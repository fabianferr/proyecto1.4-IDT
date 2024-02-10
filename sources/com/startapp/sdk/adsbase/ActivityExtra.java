package com.startapp.sdk.adsbase;

import android.app.Activity;
import java.io.Serializable;

/* compiled from: Sta */
public class ActivityExtra implements Serializable {
    private static final long serialVersionUID = 4821646469251112585L;
    private boolean isActivityFullScreen;

    public ActivityExtra(Activity activity) {
        a(a.a(activity));
    }

    public boolean a() {
        return this.isActivityFullScreen;
    }

    public final void a(boolean z) {
        this.isActivityFullScreen = z;
    }
}
