package com.startapp;

import android.graphics.Bitmap;
import com.startapp.b1;
import com.startapp.sdk.adsbase.adinformation.ImageResourceConfig;

/* compiled from: Sta */
public class f3 implements b1.b {
    public final /* synthetic */ ImageResourceConfig a;

    public f3(ImageResourceConfig imageResourceConfig) {
        this.a = imageResourceConfig;
    }

    public void a(Bitmap bitmap, int i) {
        ImageResourceConfig imageResourceConfig = this.a;
        imageResourceConfig.a = bitmap;
        if (bitmap != null) {
            imageResourceConfig.c = bitmap;
        }
    }
}
