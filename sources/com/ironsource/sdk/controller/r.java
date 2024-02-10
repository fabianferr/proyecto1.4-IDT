package com.ironsource.sdk.controller;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/ironsource/sdk/controller/MessageToNative;", "", "adId", "", "command", "params", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getAdId", "()Ljava/lang/String;", "getCommand", "getParams", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class r {
    private static a c = new a((byte) 0);
    public final String a;
    public final JSONObject b;
    private final String d;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/ironsource/sdk/controller/MessageToNative$Companion;", "", "()V", "createFromJsonString", "Lcom/ironsource/sdk/controller/MessageToNative;", "jsonStr", "", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public r(String str, String str2, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "adId");
        Intrinsics.checkNotNullParameter(str2, "command");
        this.d = str;
        this.a = str2;
        this.b = jSONObject;
    }

    @JvmStatic
    public static final r a(String str) {
        Intrinsics.checkNotNullParameter(str, "jsonStr");
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("adId");
        String string2 = jSONObject.getString("command");
        JSONObject optJSONObject = jSONObject.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkNotNullExpressionValue(string, "adId");
        Intrinsics.checkNotNullExpressionValue(string2, "command");
        return new r(string, string2, optJSONObject);
    }

    public final String a() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return Intrinsics.areEqual((Object) this.d, (Object) rVar.d) && Intrinsics.areEqual((Object) this.a, (Object) rVar.a) && Intrinsics.areEqual((Object) this.b, (Object) rVar.b);
    }

    public final int hashCode() {
        int hashCode = ((this.d.hashCode() * 31) + this.a.hashCode()) * 31;
        JSONObject jSONObject = this.b;
        return hashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
    }

    public final String toString() {
        return "MessageToNative(adId=" + this.d + ", command=" + this.a + ", params=" + this.b + ')';
    }
}
