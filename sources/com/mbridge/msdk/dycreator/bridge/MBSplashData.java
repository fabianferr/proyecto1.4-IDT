package com.mbridge.msdk.dycreator.bridge;

import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public class MBSplashData implements a {
    private DyOption a;
    private String b;
    private String c;
    private String d;
    private String e;
    private CampaignEx f;
    private int g;
    private int h;
    private float i;
    private float j;
    private int k = 0;

    public MBSplashData(DyOption dyOption) {
        this.a = dyOption;
        this.f = dyOption.getCampaignEx();
    }

    public DyOption getDyOption() {
        return this.a;
    }

    public int getNoticeImage() {
        return this.g;
    }

    public void setNoticeImage(int i2) {
        this.g = i2;
    }

    public int getLogoImage() {
        return this.h;
    }

    public void setLogoImage(int i2) {
        this.h = i2;
    }

    public String getAppInfo() {
        return this.b;
    }

    public void setAppInfo(String str) {
        this.b = str;
    }

    public String getAdClickText() {
        return this.c;
    }

    public void setAdClickText(String str) {
        this.c = str;
    }

    public String getCountDownText() {
        return this.d;
    }

    public void setCountDownText(String str) {
        this.d = str;
    }

    public CampaignEx getBindData() {
        return this.f;
    }

    public DyOption getEffectData() {
        return this.a;
    }

    public float getxInScreen() {
        return this.i;
    }

    public void setxInScreen(float f2) {
        this.i = f2;
    }

    public float getyInScreen() {
        return this.j;
    }

    public void setyInScreen(float f2) {
        this.j = f2;
    }

    public int getClickType() {
        return this.k;
    }

    public void setClickType(int i2) {
        this.k = i2;
    }

    public String getLogoText() {
        return this.e;
    }

    public void setLogoText(String str) {
        this.e = str;
    }
}
