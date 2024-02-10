package com.appnext.core.ra;

import android.content.Context;
import android.text.TextUtils;
import com.appnext.base.b.b;
import com.appnext.core.g;
import java.util.HashMap;
import kotlinx.coroutines.DebugKt;
import org.json.JSONObject;

public class a {
    private static final String eb = ("https://cdn.appnext.com/tools/sdk/confign/sdk_core/" + g.W() + "/sdk_config.json");
    private static volatile a ec;
    private Context aM;
    private JSONObject ed;

    public static a o(Context context) {
        if (ec == null) {
            synchronized (a.class) {
                if (ec == null) {
                    ec = new a(context);
                }
            }
        }
        return ec;
    }

    private a(Context context) {
        try {
            this.aM = context;
            String c = b.N().c("config_store", (String) null);
            if (!TextUtils.isEmpty(c)) {
                this.ed = new JSONObject(c);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("RAConfigManager$RAConfigManager", th);
        }
    }

    public final boolean ah() {
        if (this.ed == null) {
            al();
        }
        String m = m("rc_send", DebugKt.DEBUG_PROPERTY_VALUE_ON);
        return m != null && m.equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON);
    }

    public final void ai() {
        try {
            al();
            com.appnext.core.ra.services.a.p(this.aM).a(ak());
            if (ah()) {
                com.appnext.core.ra.services.a.p(this.aM).b(aj());
            } else {
                com.appnext.core.ra.services.a.p(this.aM).ax();
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("RRAConfigManager$downloadConfigFileFromServer", th);
        }
    }

    private synchronized long aj() {
        return c("send_rc_int", 240);
    }

    private synchronized long ak() {
        return c("config_int", 14400);
    }

    private long c(String str, int i) {
        try {
            if (this.ed != null) {
                return d(str, i);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("RAConfigManager$getLongValue", th);
        }
        return (long) i;
    }

    private long d(String str, int i) {
        try {
            JSONObject jSONObject = this.ed;
            if (jSONObject != null && jSONObject.has(str)) {
                return this.ed.getLong(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return (long) i;
    }

    private String m(String str, String str2) {
        try {
            JSONObject jSONObject = this.ed;
            if (!(jSONObject == null || jSONObject == null)) {
                return n(str, str2);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("RAConfigManager$getStringValue", th);
        }
        return str2;
    }

    private String n(String str, String str2) {
        try {
            JSONObject jSONObject = this.ed;
            if (jSONObject != null && jSONObject.has(str)) {
                return this.ed.getString(str);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("RAConfigManager$getStringValueFromLocalJson", th);
        }
        return str2;
    }

    private JSONObject al() {
        try {
            String am = am();
            if (TextUtils.isEmpty(am)) {
                return null;
            }
            if (!TextUtils.isEmpty(am)) {
                b.N().d("config_store", am);
            }
            JSONObject jSONObject = new JSONObject(am);
            this.ed = jSONObject;
            return jSONObject;
        } catch (Throwable th) {
            com.appnext.base.a.a("RAConfigManager$downloadConfigFileAndStore", th);
            return null;
        }
    }

    private String am() {
        try {
            return g.a(this.aM, eb, (HashMap<String, String>) null);
        } catch (Throwable th) {
            com.appnext.base.a.a("RAConfigManager$downloadConfigFile", th);
            return null;
        }
    }
}
