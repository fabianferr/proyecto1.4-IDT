package com.ironsource.environment;

import android.content.Context;
import com.ironsource.environment.e.b;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.C0213c;
import com.ironsource.mediationsdk.C0215e;
import com.ironsource.mediationsdk.V;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/ironsource/environment/Time;", "", "now", "", "Base", "environment_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface l {

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0004"}, d2 = {"string", "", "Lorg/json/JSONObject;", "key", "sdk5_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
    public static final class a implements l {
        public static /* synthetic */ String a(JSONObject jSONObject, String str) {
            CharSequence optString = jSONObject.optString(str);
            if (optString.length() == 0) {
                optString = null;
            }
            return (String) optString;
        }

        public static /* synthetic */ JSONObject a(n nVar, Context context) {
            AbstractAdapter a;
            if (nVar.d) {
                b bVar = new b();
                Intrinsics.checkNotNullParameter(context, "context");
                JSONObject a2 = bVar.b.a(context, bVar.a);
                Intrinsics.checkNotNullExpressionValue(a2, "mGlobalDataReader.getDat…s(context, mTokenKeyList)");
                return b.a(a2);
            }
            NetworkSettings networkSettings = nVar.b;
            if (networkSettings == null || (a = C0213c.a().a(networkSettings, networkSettings.getApplicationSettings(), true, false)) == null) {
                return null;
            }
            C0215e a3 = C0215e.a();
            JSONObject playerBiddingData = a.getPlayerBiddingData();
            JSONObject jSONObject = nVar.c;
            List list = nVar.a;
            V a4 = V.a();
            a4.a(V.c());
            a4.a(a4.b());
            JSONObject a5 = C0215e.a(a4.a, (List<String>) list.isEmpty() ? m.a : list);
            a3.a(a5, a3.b(playerBiddingData, list));
            if (!list.isEmpty()) {
                jSONObject = C0215e.a(jSONObject, (List<String>) list);
            }
            a3.a(a5, jSONObject);
            return a5;
        }

        public final long a() {
            return System.currentTimeMillis();
        }
    }

    long a();
}
