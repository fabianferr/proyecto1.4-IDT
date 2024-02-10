package com.cellrebel.sdk.workers;

import android.os.Build;
import com.cellrebel.sdk.utils.PreferencesManager;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TrackingManager$$ExternalSyntheticLambda4 implements Callable {
    public final Object call() {
        return PreferencesManager.m().a(Build.MODEL, Build.MANUFACTURER, Build.BRAND);
    }
}
