package com.lyp.lypcustomview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lyp.settingbar.SettingBar;
import com.lyp.settingbar.SettingBarModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout container;
    private List<SettingBar> views;
    private List<SettingBarModel> models;

    private int[] leftIcons = {R.drawable.ic_qq, R.drawable.ic_wechat, R.drawable.ic_weibo};
    private String[] leftTexts = {"QQ", "微信", "微博"};
    private String[] rightTextColors = {"#995EAADE", "#992DC100", "#99E6162D"};
    private String[] titles = {"方法一：set方法", "方法二：model实体类", "方法三：xml属性"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (LinearLayout) findViewById(R.id.container);

        views = new ArrayList<>();
        for (int i = 0; i < container.getChildCount(); i++) {
            views.add((SettingBar) container.getChildAt(i));
        }


        models = new ArrayList<>();
        for (int i = 0; i < leftTexts.length; i++) {
            models.add(new SettingBarModel(leftTexts[i], leftIcons[i], "未绑定", rightTextColors[i]));
        }


        for (int i = 0; i < views.size(); i++) {

            final SettingBar view = views.get(i);

            if (i%3 == 0) {
                view.setTopTitle(titles[i/3]);
            }
            if (i%3 == 2) {
                view.setBottomDividerHeight(0);
                // 或view.setBottomDividerVisibility(false);
            }

            if (i == 0) {
                view.setLeftIconVisibility(false);
                view.setLeftText("头像");
                view.setRightImage(R.drawable.ic_icon_twitter);
            }

            if (i == 1) {
                view.setLeftText("用户名");
                view.setRightText("LYP");
                view.setRightIconVisibility(false);
            }

            if (i == 2) {
                view.setLeftText("用户等级");
                view.setLeftTextColorString("#F8B250");
                view.setRightIcon(R.drawable.ic_level);
                view.setRightText("VIP10");
            }

            if (i/3 == 1) {
                view.setupModel(models.get(i%3));
            }

            if (view.getTag() != null && view.getTag().equals("LAST")) {
                view.setRightText("LAST");
            }

            final int index = i;
            view.setOnBarClickListener(new SettingBar.OnBarClickListener() {
                @Override
                public void onBarClick() {
                    Toast.makeText(MainActivity.this, "点击了 "+ view.getLeftText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
