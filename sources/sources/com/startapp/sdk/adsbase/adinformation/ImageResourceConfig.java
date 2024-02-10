package com.startapp.sdk.adsbase.adinformation;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.startapp.a1;
import com.startapp.k9;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Sta */
public class ImageResourceConfig implements Serializable {
    private static final long serialVersionUID = -8927634568015374287L;
    public transient Bitmap a;
    public transient Bitmap b;
    public transient Bitmap c = null;
    private int height = 1;
    private String imageFallbackUrl = "";
    private String imageUrlSecured = "";
    private String name;
    private int width = 1;

    private ImageResourceConfig() {
    }

    public Bitmap a(Context context) {
        if (this.c == null) {
            Bitmap bitmap = this.a;
            this.c = bitmap;
            if (bitmap == null) {
                if (this.b == null) {
                    this.b = a1.a(context, this.imageFallbackUrl);
                }
                this.c = this.b;
            }
        }
        return this.c;
    }

    public void b(int i) {
        this.width = i;
    }

    public String c() {
        return this.name;
    }

    public int d() {
        return this.width;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImageResourceConfig imageResourceConfig = (ImageResourceConfig) obj;
        if (this.width != imageResourceConfig.width || this.height != imageResourceConfig.height || !k9.a(this.imageUrlSecured, imageResourceConfig.imageUrlSecured) || !k9.a(this.imageFallbackUrl, imageResourceConfig.imageFallbackUrl) || !k9.a(this.name, imageResourceConfig.name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.imageUrlSecured, this.imageFallbackUrl, Integer.valueOf(this.width), Integer.valueOf(this.height), this.name};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }

    public String b() {
        String str = this.imageUrlSecured;
        return str != null ? str : "";
    }

    public void b(String str) {
        this.imageFallbackUrl = str;
    }

    public int a() {
        return this.height;
    }

    public void a(int i) {
        this.height = i;
    }

    public static ImageResourceConfig a(String str) {
        ImageResourceConfig imageResourceConfig = new ImageResourceConfig();
        imageResourceConfig.name = str;
        return imageResourceConfig;
    }
}
