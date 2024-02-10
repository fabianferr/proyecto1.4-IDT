package com.wortise.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/wortise/ads/AdError;", "", "Landroid/os/Parcelable;", "", "toString", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "message", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "INVALID_PARAMS", "LOAD_FAILED", "NO_FILL", "NO_NETWORK", "NOTIFICATIONS_DISABLED", "RENDER_ERROR", "RENDER_PROCESS_GONE", "SERVER_ERROR", "TIMEOUT", "UNSPECIFIED", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdError.kt */
public enum AdError implements Parcelable {
    INVALID_PARAMS("Invalid and/or missing values."),
    LOAD_FAILED("Ad load has failed."),
    NO_FILL("Request could not be filled."),
    NO_NETWORK("No network connection available."),
    NOTIFICATIONS_DISABLED("Notifications are disabled."),
    RENDER_ERROR("Ad render has failed."),
    RENDER_PROCESS_GONE("WebView render process is gone."),
    SERVER_ERROR("Server error."),
    TIMEOUT("Load timed-out."),
    UNSPECIFIED("Unspecified error.");
    
    public static final Parcelable.Creator<AdError> CREATOR = null;
    public static final a Companion = null;
    private final String message;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/AdError$a;", "", "", "value", "Lcom/wortise/ads/AdError;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AdError.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AdError a(String str) {
            AdError adError = AdError.UNSPECIFIED;
            if (str != null) {
                try {
                    String upperCase = str.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    return AdError.valueOf(upperCase);
                } catch (Throwable unused) {
                    return adError;
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AdError.kt */
    public static final class b implements Parcelable.Creator<AdError> {
        /* renamed from: a */
        public final AdError createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return AdError.valueOf(parcel.readString());
        }

        /* renamed from: a */
        public final AdError[] newArray(int i) {
            return new AdError[i];
        }
    }

    static {
        Companion = new a((DefaultConstructorMarker) null);
        CREATOR = new b();
    }

    private AdError(String str) {
        this.message = str;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.message;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(name());
    }
}
