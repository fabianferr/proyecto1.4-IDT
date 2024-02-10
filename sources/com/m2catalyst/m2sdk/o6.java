package com.m2catalyst.m2sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TelemetryConfig */
public final class o6 {
    public final String a = "disabled";
    public final String b = null;
    public final String c = null;
    public final String d = null;

    public o6() {
    }

    public final void a() {
        if (!this.a.equals("disabled") && !this.a.equals("basic") && !this.a.equals("full")) {
            throw new IllegalArgumentException("Telemetry level must be disabled, basic or full");
        }
    }

    public final Object clone() {
        return new o6(this.a, this.b, this.c, this.d);
    }

    public o6(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        a();
    }

    public o6(JSONObject jSONObject) {
        try {
            if (jSONObject.has("telemetryLevel")) {
                this.a = jSONObject.getString("telemetryLevel");
            }
            if (jSONObject.has("server")) {
                this.b = jSONObject.getString("server");
            }
            if (jSONObject.has("path")) {
                this.c = jSONObject.getString("path");
            }
            if (jSONObject.has("shareURL")) {
                this.d = jSONObject.getString("shareURL");
            }
            a();
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON (" + e.toString() + ")");
        }
    }
}
