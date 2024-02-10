package com.startapp;

import android.text.TextUtils;

/* compiled from: Sta */
public class gc {
    public static void a(fb fbVar) {
        if (!fbVar.f) {
            throw new IllegalStateException("AdSession is not started");
        } else if (fbVar.g) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void b(fb fbVar) {
        if (fbVar.g) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void c(fb fbVar) {
        if (!fbVar.d()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }
}
