package com.vungle.ads;

import com.mbridge.msdk.MBridgeConstans;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0003\u0017\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u0004J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\fR$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/vungle/ads/AdConfig;", "", "()V", "adOrientation", "", "getAdOrientation$annotations", "getAdOrientation", "()I", "setAdOrientation", "(I)V", "extras", "", "", "settings", "getSettings", "getWatermark", "getWatermark$vungle_ads_release", "setBackButtonImmediatelyEnabled", "", "isBackButtonImmediatelyEnabled", "", "setWatermark", "watermark", "Companion", "Orientation", "Settings", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdConfig.kt */
public class AdConfig {
    public static final int AUTO_ROTATE = 2;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int IMMEDIATE_BACK = 2;
    public static final int LANDSCAPE = 1;
    public static final int PORTRAIT = 0;
    private static final String WATERMARK = "WATERMARK";
    private int adOrientation = 2;
    private Map<String, String> extras = new LinkedHashMap();
    private int settings;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/vungle/ads/AdConfig$Orientation;", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: AdConfig.kt */
    public @interface Orientation {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/vungle/ads/AdConfig$Settings;", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: AdConfig.kt */
    public @interface Settings {
    }

    @Orientation
    public static /* synthetic */ void getAdOrientation$annotations() {
    }

    public final int getAdOrientation() {
        return this.adOrientation;
    }

    public final void setAdOrientation(int i) {
        this.adOrientation = i;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/vungle/ads/AdConfig$Companion;", "", "()V", "AUTO_ROTATE", "", "IMMEDIATE_BACK", "LANDSCAPE", "PORTRAIT", "WATERMARK", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AdConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setBackButtonImmediatelyEnabled(boolean z) {
        int i;
        if (z) {
            i = this.settings | 2;
        } else {
            i = this.settings & -3;
        }
        this.settings = i;
    }

    public final int getSettings() {
        return this.settings;
    }

    public final void setWatermark(String str) {
        Intrinsics.checkNotNullParameter(str, MBridgeConstans.EXTRA_KEY_WM);
        this.extras.put(WATERMARK, str);
    }

    public final String getWatermark$vungle_ads_release() {
        return this.extras.get(WATERMARK);
    }
}
