package com.lyp.settingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by lyp on 2017/2/7.
 */

public class SettingBar extends LinearLayout implements View.OnClickListener {

    private static final int DEFAULT_TOP_TITLE_BG_COLOR = 0xF5F5F5;
    private static final int DEFAULT_TOP_TITLE_COLOR = 0x707070;
    private static final int DEFAULT_TOP_TITLE_SIZE = 14; //sp

    private static final int DEFAULT_LEFT_TEXT_COLOR = 0x101010;
    private static final int DEFAULT_LEFT_TEXT_SIZE = 19; //sp

    private static final int DEFAULT_RIGHT_TEXT_COLOR = 0x999999;
    private static final int DEFAULT_RIGHT_TEXT_SIZE = 17; //sp

    private static final int DEFAULT_BOTTOM_DIVIDER_COLOR = 0xF0F0F0;
    private static final float DEFAULT_BOTTOM_DIVIDER_HEIGHT = 0.5f; //dp

    private String mTopTitle, mLeftText, mRightText;
    private int mTopTitleBgColor;
    private int mTopTitleColor;
    private int mTopTitleSize, mLeftTextSize, mRightTextSize;
    private boolean mTopTitleVisible, mBottomDividerVisible;

    private TextView topTitleView, leftTextView, rightTextView;
    private ImageView leftIconView, rightImageView, rightIconView;
    private View bottomDividerView;
    private LinearLayout bodyLayout;

    private SettingBarModel mModel;

    private Object mTag;

    private OnBarClickListener mListener;

    public SettingBar(Context context) {
        this(context, null);
    }

    public SettingBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mModel = new SettingBarModel();

        initViews(context);
        obtainStyledAttrs(attrs);
    }

    private void initViews(Context context) {

        LayoutInflater.from(context).inflate(R.layout.layout_setting_bar, this);
        this.topTitleView = (TextView) findViewById(R.id.top_title);
        this.leftTextView = (TextView) findViewById(R.id.left_text);
        this.rightTextView = (TextView) findViewById(R.id.right_text);
        this.leftIconView = (ImageView) findViewById(R.id.left_icon);
        this.rightImageView = (ImageView) findViewById(R.id.right_image);
        this.rightIconView = (ImageView) findViewById(R.id.right_icon);
        this.bottomDividerView = findViewById(R.id.bottom_divider);
        this.bodyLayout = (LinearLayout) findViewById(R.id.body_layout);
        this.bodyLayout.setOnClickListener(this);
    }

    /**
     * 获取自定义属性
     * @param attrs
     */
    private void obtainStyledAttrs(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.SettingBar);

        mTag = ta.getString(R.styleable.SettingBar_tag);
        mTopTitle = ta.getString(R.styleable.SettingBar_topTitle);
        mLeftText = ta.getString(R.styleable.SettingBar_leftText);
        mRightText = ta.getString(R.styleable.SettingBar_rightText);

        mTopTitleSize = (int) ta.getDimension(R.styleable.SettingBar_topTitleSize, DEFAULT_TOP_TITLE_SIZE);
        mLeftTextSize = (int) ta.getDimension(R.styleable.SettingBar_leftTextSize, DEFAULT_LEFT_TEXT_SIZE);
        mRightTextSize = (int) ta.getDimension(R.styleable.SettingBar_rightTextSize, DEFAULT_RIGHT_TEXT_SIZE);

        mTopTitleVisible = ta.getBoolean(R.styleable.SettingBar_topTitleVisibility, false);
        mBottomDividerVisible = ta.getBoolean(R.styleable.SettingBar_bottomDividerVisibility, true);

        setTag(mTag == null ? "" : mTag);
        setTopTitle(mTopTitle == null ? "" : mTopTitle);
        setLeftText(mLeftText == null ? "" : mLeftText);
        setRightText(mRightText == null ? "" : mRightText);

        setTopTitleSize(mTopTitleSize);
        setLeftTextSize(mLeftTextSize);
        setRightTextSize(mRightTextSize);

        setTopTitleVisibility(mTopTitleVisible);
        setBottomDividerVisibility(mBottomDividerVisible);

        ta.recycle();
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            mListener.onBarClick();
        }
    }

    public interface OnBarClickListener {
        void onBarClick();
    }

    public void setOnBarClickListener(OnBarClickListener listener) {
        this.mListener = listener;
    }

    private void setModel(SettingBarModel model) {
        this.mModel = model;
    }

    public void setupModel(SettingBarModel model) {

        setModel(model);

        if (this.mModel == null) {
            return;
        }

        if (mModel.getTopTitle() != null) {
            setTopTitle(mModel.getTopTitle());
        }
        if (mModel.getLeftText() != null) {
            setLeftText(mModel.getLeftText());
        }
        if (mModel.getRightText() != null) {
            setRightText(mModel.getRightText());
        }
        if (mModel.getRightTextColorString() != null ) {
            setRightTextColorString(mModel.getRightTextColorString());
        } else if (mModel.getRightTextColorRes() != 0 ) {
            setRightTextColorRes(mModel.getRightTextColorRes());
        }
        if (mModel.getLeftIconRes() != 0 ) {
            setLeftIcon(mModel.getLeftIconRes());
        }
        if (mModel.getRightIconRes() != 0 ) {
            setRightIcon(mModel.getRightIconRes());
        }
        if (mModel.getRightImageRes() != 0 ) {
            setRightImage(mModel.getRightImageRes());
        }
    }

    public SettingBarModel getModel() {
        return mModel;
    }

    public void setTopTitle(String title) {
        setTopTitleVisibility(true);
        this.topTitleView.setText(title);
        this.mModel.setTopTitle(title);
    }

    public String getTopTitle() {
        return topTitleView.getText().toString();
    }

    public void setTopTitleColorRes(int colorRes) {
        this.topTitleView.setTextColor(getResources().getColor(colorRes));
    }

    public void setTopTitleColorString(String colorString) {
        this.topTitleView.setTextColor(Color.parseColor(colorString));
    }

    public void setTopTitleSize(float size) {
        this.topTitleView.setTextSize(size);
    }

    public void setTopTitleBgColor(int color) {
        this.topTitleView.setBackgroundColor(color);
    }

    public void setTopTitleVisibility(boolean visible) {
        this.topTitleView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setLeftIcon(int resId) {
        setLeftIconVisibility(true);
        this.leftIconView.setImageResource(resId);
    }

    public void setLeftIcon(Bitmap bm) {
        setLeftIconVisibility(true);
        this.leftIconView.setImageBitmap(bm);
    }

    public void setLeftIconVisibility(boolean visible) {
        this.leftIconView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setLeftText(String text) {
        this.leftTextView.setText(text);
        this.mModel.setLeftText(text);
    }

    public String getLeftText() {
        return this.leftTextView.getText().toString();
    }

    public void setLeftTextColorRes(int colorRes) {
        this.leftTextView.setTextColor(getResources().getColor(colorRes));
    }

    public void setLeftTextColorString(String colorString) {
        this.leftTextView.setTextColor(Color.parseColor(colorString));
    }

    public void setLeftTextSize(float size) {
        this.leftTextView.setTextSize(size);
    }

    public void setRightText(String text) {
        this.rightTextView.setText(text);
        this.mModel.setRightText(text);
    }

    public String getRightText() {
        return this.rightTextView.getText().toString();
    }

    public void setRightTextColorRes(int colorRes) {
        this.rightTextView.setTextColor(getResources().getColor(colorRes));
        this.mModel.setRightTextColor(colorRes);
    }

    public void setRightTextColorString(String colorString) {
        this.rightTextView.setTextColor(Color.parseColor(colorString));
    }

    public void setRightTextSize(float size) {
        this.rightTextView.setTextSize(size);
    }

    public void setRightImage(int resId) {
        setRightImageVisibility(true);
        this.rightImageView.setImageResource(resId);
        this.mModel.setRightImageRes(resId);
    }

    public void setRightImage(Bitmap bm) {
        setRightImageVisibility(true);
        this.rightImageView.setImageBitmap(bm);
    }

    public void setRightImageVisibility(boolean visible) {
        this.rightImageView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setRightIcon(int resId) {
        setRightIconVisibility(true);
        this.rightIconView.setImageResource(resId);
        this.mModel.setRightIconRes(resId);
    }

    public void setRightIcon(Bitmap bm) {
        setRightIconVisibility(true);
        this.rightIconView.setImageBitmap(bm);
    }

    public void setRightIconVisibility(boolean visible) {
        this.rightIconView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setBottomDividerColor(int color) {
        setBottomDividerVisibility(true);
        this.bottomDividerView.setBackgroundColor(color);
    }

    public void setBottomDividerHeight(int height) {
        if (height <= 0) {
            setBottomDividerVisibility(false);
            return;
        }
        setBottomDividerVisibility(true);
        ViewGroup.LayoutParams lp = this.bottomDividerView.getLayoutParams();
        lp.height = height;
        this.bottomDividerView.setLayoutParams(lp);
    }

    public void setBottomDividerVisibility(boolean visible) {
        this.bottomDividerView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setTag(Object tag) {
        super.setTag(tag);
        this.mTag = tag;
    }

    @Override
    public Object getTag() {
        return super.getTag();
    }

    private int sp2px(int spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, getResources().getDisplayMetrics());
    }

    private int dp2px(int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, getResources().getDisplayMetrics());
    }
}
