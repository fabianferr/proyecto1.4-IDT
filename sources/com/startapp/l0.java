package com.startapp;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: Sta */
public class l0 {
    public Context a;
    public String b;

    public l0(Context context, AttributeSet attributeSet) {
        this.a = context;
        this.b = a(attributeSet, "adTag");
    }

    public final String a(AttributeSet attributeSet, String str) {
        String str2;
        try {
            int attributeResourceValue = attributeSet.getAttributeResourceValue((String) null, str, -1);
            if (attributeResourceValue != -1) {
                str2 = this.a.getResources().getString(attributeResourceValue);
            } else {
                str2 = attributeSet.getAttributeValue((String) null, str);
            }
            return str2;
        } catch (Exception unused) {
            return null;
        }
    }
}
