package com.ironsource.sdk.controller;

import com.facebook.internal.NativeProtocol;
import com.ironsource.mediationsdk.C0214d;
import com.ironsource.mediationsdk.C0215e;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/ironsource/mediationsdk/auction/AuctionListener;", "Lcom/ironsource/mediationsdk/AuctionCompletionListener;", "onAuctionSuccess", "", "auctionData", "Lcom/ironsource/mediationsdk/AuctionDataUtils$AuctionData;", "auctionTrial", "", "elapsedTime", "", "troubleshootingRecoveryErrorCode", "troubleshootingRecoveryErrorMessage", "", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface h extends C0214d {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/ironsource/sdk/controller/ControllerMessage$CallbackToNative;", "", "msgId", "", "params", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getMsgId", "()Ljava/lang/String;", "getParams", "()Lorg/json/JSONObject;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private static C0118a b = new C0118a((byte) 0);
        public final JSONObject a;
        private final String c;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/ironsource/sdk/controller/ControllerMessage$CallbackToNative$Companion;", "", "()V", "createFromJsonString", "Lcom/ironsource/sdk/controller/ControllerMessage$CallbackToNative;", "jsonStr", "", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.ironsource.sdk.controller.h$a$a  reason: collision with other inner class name */
        public static final class C0118a {
            private C0118a() {
            }

            public /* synthetic */ C0118a(byte b) {
                this();
            }
        }

        public a(String str, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(str, "msgId");
            this.c = str;
            this.a = jSONObject;
        }

        @JvmStatic
        public static final a a(String str) {
            Intrinsics.checkNotNullParameter(str, "jsonStr");
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("msgId");
            JSONObject optJSONObject = jSONObject.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
            Intrinsics.checkNotNullExpressionValue(string, "id");
            return new a(string, optJSONObject);
        }

        public final String a() {
            return this.c;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual((Object) this.c, (Object) aVar.c) && Intrinsics.areEqual((Object) this.a, (Object) aVar.a);
        }

        public final int hashCode() {
            int hashCode = this.c.hashCode() * 31;
            JSONObject jSONObject = this.a;
            return hashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
        }

        public final String toString() {
            return "CallbackToNative(msgId=" + this.c + ", params=" + this.a + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/ironsource/sdk/controller/ControllerMessage$MessageToController;", "", "adId", "", "command", "params", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getAdId", "()Ljava/lang/String;", "getCommand", "msgId", "getMsgId", "setMsgId", "(Ljava/lang/String;)V", "getParams", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "payloadString", "toString", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        private final String a;
        private final String b;
        private final JSONObject c;
        private String d;

        public b(String str, String str2, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(str, "adId");
            Intrinsics.checkNotNullParameter(str2, "command");
            Intrinsics.checkNotNullParameter(jSONObject, NativeProtocol.WEB_DIALOG_PARAMS);
            this.a = str;
            this.b = str2;
            this.c = jSONObject;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            this.d = uuid;
        }

        public final String a() {
            return this.b;
        }

        public final String b() {
            return this.d;
        }

        public final String c() {
            String jSONObject = new JSONObject().put("msgId", this.d).put("adId", this.a).put(NativeProtocol.WEB_DIALOG_PARAMS, this.c).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject()\n\t\t\t\t.put(Co…, params)\n\t\t\t\t.toString()");
            return jSONObject;
        }

        public final boolean equals(Object obj) {
            b bVar = obj instanceof b ? (b) obj : null;
            if (bVar == null) {
                return false;
            }
            if (this == bVar) {
                return true;
            }
            return Intrinsics.areEqual((Object) this.d, (Object) bVar.d) && Intrinsics.areEqual((Object) this.a, (Object) bVar.a) && Intrinsics.areEqual((Object) this.b, (Object) bVar.b) && Intrinsics.areEqual((Object) this.c.toString(), (Object) bVar.c.toString());
        }

        public final int hashCode() {
            return super.hashCode();
        }

        public final String toString() {
            return "MessageToController(adId=" + this.a + ", command=" + this.b + ", params=" + this.c + ')';
        }
    }

    void a(C0215e.a aVar, long j, int i, String str);
}
