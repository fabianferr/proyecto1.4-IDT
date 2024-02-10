package com.startapp;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import java.util.LinkedHashSet;
import java.util.Locale;

/* compiled from: Sta */
public class y4 extends w1<x4> {
    public y4(Context context) {
        super(context);
    }

    public Object a() {
        Locale locale;
        Locale locale2;
        Configuration configuration;
        LocaleList locales;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Resources resources = this.a.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            locale = null;
        } else {
            locale = configuration.locale;
            if (Build.VERSION.SDK_INT >= 24 && (locales = configuration.getLocales()) != null && locales.size() > 0) {
                int size = locales.size();
                boolean z = true;
                for (int i = 0; i < size; i++) {
                    Locale locale3 = locales.get(i);
                    if (locale3 != null) {
                        if (linkedHashSet.size() < 11) {
                            linkedHashSet.add(locale3);
                        }
                        if (z) {
                            locale = locale3;
                            z = false;
                        }
                    }
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 24 && (locale2 = Locale.getDefault(Locale.Category.DISPLAY)) != null) {
            if (locale == null) {
                locale = locale2;
            }
            if (linkedHashSet.size() < 11) {
                linkedHashSet.add(locale2);
            }
        }
        Locale locale4 = Locale.getDefault();
        if (locale4 != null) {
            if (locale == null) {
                locale = locale4;
            }
            if (linkedHashSet.size() < 11) {
                linkedHashSet.add(locale4);
            }
        }
        if (locale == null) {
            locale = new Locale("en");
        }
        linkedHashSet.remove(locale);
        return new x4(locale, linkedHashSet);
    }

    public /* bridge */ /* synthetic */ Object c() {
        return x4.d;
    }
}
