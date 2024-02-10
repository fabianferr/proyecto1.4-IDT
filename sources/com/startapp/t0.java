package com.startapp;

import android.app.Activity;
import java.net.URLDecoder;
import java.util.Map;

/* compiled from: Sta */
public abstract class t0 implements e5 {
    private static final String LOG_TAG = "t0";
    public a openListener;

    /* compiled from: Sta */
    public interface a {
        boolean onClickEvent(String str);
    }

    public t0(a aVar) {
        this.openListener = aVar;
    }

    public void applyOrientationProperties(Activity activity, l5 l5Var) {
        try {
            int i = 0;
            int i2 = activity.getResources().getConfiguration().orientation == 1 ? 1 : 0;
            int i3 = l5Var.b;
            if (i3 == 0) {
                i = 1;
            } else if (i3 != 1) {
                i = l5Var.a ? -1 : i2;
            }
            int i4 = a0.a;
            try {
                activity.setRequestedOrientation(i);
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            i3.a(th);
        }
    }

    public abstract void close();

    public void createCalendarEvent(String str) {
        isFeatureSupported("calendar");
    }

    public void expand(String str) {
    }

    public abstract boolean isFeatureSupported(String str);

    public boolean open(String str) {
        try {
            String trim = URLDecoder.decode(str, "UTF-8").trim();
            if (trim.startsWith("sms")) {
                return openSMS(trim);
            }
            if (trim.startsWith("tel")) {
                return openTel(trim);
            }
            return this.openListener.onClickEvent(trim);
        } catch (Exception unused) {
            return this.openListener.onClickEvent(str);
        }
    }

    public boolean openSMS(String str) {
        isFeatureSupported("sms");
        return true;
    }

    public boolean openTel(String str) {
        isFeatureSupported("tel");
        return true;
    }

    public void playVideo(String str) {
        isFeatureSupported("inlineVideo");
    }

    public void resize() {
    }

    public void setExpandProperties(Map<String, String> map) {
    }

    public abstract void setOrientationProperties(Map<String, String> map);

    public void setResizeProperties(Map<String, String> map) {
    }

    public void storePicture(String str) {
        isFeatureSupported("storePicture");
    }

    public abstract void useCustomClose(String str);
}
