package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u000f"}, d2 = {"Lcom/wortise/ads/c7;", "", "", "toString", "", "hashCode", "other", "", "equals", "bssid", "frequency", "rssi", "ssid", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Wifi.kt */
public final class c7 {
    @SerializedName("bssid")
    private final String a;
    @SerializedName("frequency")
    private final Integer b;
    @SerializedName("rssi")
    private final Integer c;
    @SerializedName("ssid")
    private final String d;

    public c7(String str, Integer num, Integer num2, String str2) {
        this.a = str;
        this.b = num;
        this.c = num2;
        this.d = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c7)) {
            return false;
        }
        c7 c7Var = (c7) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) c7Var.a) && Intrinsics.areEqual((Object) this.b, (Object) c7Var.b) && Intrinsics.areEqual((Object) this.c, (Object) c7Var.c) && Intrinsics.areEqual((Object) this.d, (Object) c7Var.d);
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.b;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.c;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "Wifi(bssid=" + this.a + ", frequency=" + this.b + ", rssi=" + this.c + ", ssid=" + this.d + ')';
    }
}
