package com.lyp.settingbar;

import android.graphics.Color;

/**
 * Created by lyp on 2017/2/9.
 */

public class SettingBarModel {

    private String topTitle;
    private String leftText;
    private String rightText;
    private String rightTextColorString;
    private int rightTextColorRes;
    private int leftIconRes;
    private int rightIconRes;
    private int rightImageRes;

    public SettingBarModel() {
    }

    public SettingBarModel(String leftText, String rightText) {
        this.leftText = leftText;
        this.rightText = rightText;
    }

    public SettingBarModel(String leftText, int leftIconRes, String rightText) {
        this(leftText, rightText);
        this.leftIconRes = leftIconRes;
    }

    public SettingBarModel(String leftText, int leftIconRes, String rightText, int rightTextColorRes) {
        this(leftText, leftIconRes, rightText);
        this.rightTextColorRes = rightTextColorRes;
    }

    public SettingBarModel(String leftText, int leftIconRes, String rightText, String rightTextColorString) {
        this(leftText, leftIconRes, rightText);
        this.rightTextColorString = rightTextColorString;
    }

    public SettingBarModel(String topTitle, String leftText, int leftIconRes, String rightText, int rightTextColorRes) {
        this(leftText, leftIconRes, rightText, rightTextColorRes);
        this.topTitle = topTitle;
    }

    public SettingBarModel(String topTitle, String leftText, int leftIconRes, String rightText, String rightTextColorString) {
        this(leftText, leftIconRes, rightText, rightTextColorString);
        this.topTitle = topTitle;
    }

    public SettingBarModel(String topTitle, String leftText, String rightText) {
        this.topTitle = topTitle;
        this.leftText = leftText;
        this.rightText = rightText;
    }

    public SettingBarModel(String topTitle, String leftText, String rightText, int rightTextColorRes) {
        this(topTitle, leftText, rightText);
        this.rightTextColorRes = rightTextColorRes;
    }

    public SettingBarModel(String topTitle, String leftText, String rightText, String rightTextColorString) {
        this(topTitle, leftText, rightText);
        this.rightTextColorString = rightTextColorString;
    }

    public SettingBarModel(String topTitle, String leftText, int leftIconRes, String rightText) {
        this(topTitle, leftText, rightText);
        this.leftIconRes = leftIconRes;
    }

    public String getTopTitle() {
        return topTitle;
    }

    public void setTopTitle(String topTitle) {
        this.topTitle = topTitle;
    }

    public String getLeftText() {
        return leftText;
    }

    public void setLeftText(String leftText) {
        this.leftText = leftText;
    }

    public String getRightText() {
        return rightText;
    }

    public void setRightText(String rightText) {
        this.rightText = rightText;
    }

    public void setRightTextColor(int rightTextColorRes) {
        this.rightTextColorRes = rightTextColorRes;
    }

    public void setRightTextColor(String rightTextColorString) {
        this.rightTextColorString = rightTextColorString;
    }

    public int getRightTextColorRes() {
        return rightTextColorRes;
    }

    public String getRightTextColorString() {
        return rightTextColorString;
    }

    public int getLeftIconRes() {
        return leftIconRes;
    }

    public void setLeftIconRes(int leftIconRes) {
        this.leftIconRes = leftIconRes;
    }

    public int getRightIconRes() {
        return rightIconRes;
    }

    public void setRightIconRes(int rightIconRes) {
        this.rightIconRes = rightIconRes;
    }

    public int getRightImageRes() {
        return rightImageRes;
    }

    public void setRightImageRes(int rightImageRes) {
        this.rightImageRes = rightImageRes;
    }
}
