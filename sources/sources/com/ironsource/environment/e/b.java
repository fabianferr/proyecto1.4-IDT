package com.ironsource.environment.e;

import com.ironsource.environment.c.c;
import com.ironsource.environment.c.d;
import com.ironsource.environment.e.a;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0007J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/ironsource/environment/token/TokenProvider;", "", "()V", "mGlobalDataReader", "Lcom/ironsource/environment/globaldata/GlobalDataReader;", "mTokenKeyList", "", "", "[Ljava/lang/String;", "formatDataMetaData", "Lorg/json/JSONObject;", "tokenData", "getToken", "context", "Landroid/content/Context;", "environment_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {
    public final String[] a = a.b;
    public final c b = new c();

    public b() {
        a.C0106a aVar = a.a;
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject a2 = d.a(jSONObject.optJSONObject("md"));
        if (a2 != null) {
            jSONObject.put("md", a2);
        }
        return jSONObject;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the new method getToken(context: Context)")
    public final JSONObject a() {
        JSONObject a2 = this.b.a(this.a);
        Intrinsics.checkNotNullExpressionValue(a2, "mGlobalDataReader.getDataByKeys(mTokenKeyList)");
        return a(a2);
    }
}
