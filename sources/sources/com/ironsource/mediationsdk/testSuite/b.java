package com.ironsource.mediationsdk.testSuite;

import android.content.Context;
import android.content.Intent;
import com.ironsource.environment.c;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Jm\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\rH\u0002JE\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/ironsource/mediationsdk/testSuite/TestSuiteHandler;", "", "()V", "createControllerDataString", "", "appKey", "sdkVersion", "bundleId", "appName", "appVersion", "consent", "", "initResponse", "Lorg/json/JSONObject;", "isRewardedVideoManual", "generalProperties", "adaptersVersions", "metaData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lorg/json/JSONObject;ZLorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)Ljava/lang/String;", "getMetaDataJson", "startTestSuite", "", "context", "Landroid/content/Context;", "testSuiteControllerUrl", "(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Z)V", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {
    public final void a(Context context, String str, JSONObject jSONObject, String str2, String str3, Boolean bool, boolean z) {
        Context context2 = context;
        String str4 = str;
        JSONObject jSONObject2 = jSONObject;
        String str5 = str2;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str4, "appKey");
        Intrinsics.checkNotNullParameter(jSONObject2, "initResponse");
        Intrinsics.checkNotNullParameter(str5, "sdkVersion");
        Intrinsics.checkNotNullParameter(str3, "testSuiteControllerUrl");
        d dVar = d.a;
        String a = d.a(context);
        d dVar2 = d.a;
        Intrinsics.checkNotNullParameter(context2, "context");
        String d = c.d(context2, d.a(context));
        d dVar3 = d.a;
        Intrinsics.checkNotNullParameter(context2, "context");
        String c = c.c(context2, d.a(context));
        d dVar4 = d.a;
        JSONObject a2 = d.a();
        d dVar5 = d.a;
        JSONObject c2 = d.c();
        JSONObject jSONObject3 = new JSONObject();
        d dVar6 = d.a;
        for (Iterator it = d.b().entrySet().iterator(); it.hasNext(); it = it) {
            Map.Entry entry = (Map.Entry) it.next();
            jSONObject3.putOpt((String) entry.getKey(), new JSONArray((List) entry.getValue()));
            String str6 = str3;
        }
        String jSONObject4 = new JSONObject(MapsKt.mapOf(TuplesKt.to("deviceOS", "Android"), TuplesKt.to("appKey", str4), TuplesKt.to("sdkVersion", str5), TuplesKt.to("bundleId", a), TuplesKt.to("appName", d), TuplesKt.to("appVersion", c), TuplesKt.to("initResponse", jSONObject2), TuplesKt.to("isRvManual", Boolean.valueOf(z)), TuplesKt.to("generalProperties", a2), TuplesKt.to("adaptersVersion", c2), TuplesKt.to("metaData", jSONObject3), TuplesKt.to("gdprConsent", bool))).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject4, "JSONObject(mapOf(\n      …ent\n        )).toString()");
        Context context3 = context;
        Intent intent = new Intent(context3, TestSuiteActivity.class);
        intent.setFlags(805306368);
        intent.putExtra("dataString", jSONObject4);
        intent.putExtra("controllerUrl", str3);
        context3.startActivity(intent);
    }
}
