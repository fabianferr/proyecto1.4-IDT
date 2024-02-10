package com.applovin.impl.sdk;

import android.os.Bundle;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.f.a;
import com.applovin.impl.sdk.f.m;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinVariableService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

public class VariableServiceImpl implements AppLovinVariableService {
    private final m a;
    /* access modifiers changed from: private */
    public final AtomicBoolean b = new AtomicBoolean();
    private final AtomicBoolean c = new AtomicBoolean();
    /* access modifiers changed from: private */
    public AppLovinVariableService.OnVariablesUpdateListener d;
    private Bundle e;
    private final Object f = new Object();

    VariableServiceImpl(m mVar) {
        this.a = mVar;
        String str = (String) mVar.a(d.j);
        if (StringUtils.isValidString(str)) {
            updateVariables(JsonUtils.deserialize(str));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object a(java.lang.String r5, java.lang.Object r6, java.lang.Class<?> r7) {
        /*
            r4 = this;
            java.lang.String r0 = "Unable to retrieve variable value for "
            java.lang.String r1 = "Unable to retrieve variable value for name \""
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 == 0) goto L_0x0018
            boolean r5 = com.applovin.impl.sdk.u.a()
            if (r5 == 0) goto L_0x0017
            java.lang.String r5 = "AppLovinVariableService"
            java.lang.String r7 = "Unable to retrieve variable value for empty name"
            com.applovin.impl.sdk.u.i(r5, r7)
        L_0x0017:
            return r6
        L_0x0018:
            boolean r2 = com.applovin.impl.sdk.u.a()
            if (r2 == 0) goto L_0x002d
            com.applovin.impl.sdk.m r2 = r4.a
            boolean r2 = r2.d()
            if (r2 != 0) goto L_0x002d
            java.lang.String r2 = "AppLovinSdk"
            java.lang.String r3 = "Attempted to retrieve variable before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener)."
            com.applovin.impl.sdk.u.h(r2, r3)
        L_0x002d:
            java.lang.Object r2 = r4.f
            monitor-enter(r2)
            android.os.Bundle r3 = r4.e     // Catch:{ all -> 0x0090 }
            if (r3 != 0) goto L_0x0052
            boolean r7 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x0090 }
            if (r7 == 0) goto L_0x0050
            java.lang.String r7 = "AppLovinVariableService"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r0.<init>(r1)     // Catch:{ all -> 0x0090 }
            r0.append(r5)     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = "\". No variables returned by the server."
            r0.append(r5)     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x0090 }
            com.applovin.impl.sdk.u.i(r7, r5)     // Catch:{ all -> 0x0090 }
        L_0x0050:
            monitor-exit(r2)     // Catch:{ all -> 0x0090 }
            return r6
        L_0x0052:
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            boolean r1 = r7.equals(r1)     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x0064
            android.os.Bundle r7 = r4.e     // Catch:{ all -> 0x0090 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = r7.getString(r5, r6)     // Catch:{ all -> 0x0090 }
            monitor-exit(r2)     // Catch:{ all -> 0x0090 }
            return r5
        L_0x0064:
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            boolean r7 = r7.equals(r1)     // Catch:{ all -> 0x0090 }
            if (r7 == 0) goto L_0x007e
            android.os.Bundle r7 = r4.e     // Catch:{ all -> 0x0090 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x0090 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x0090 }
            boolean r5 = r7.getBoolean(r5, r6)     // Catch:{ all -> 0x0090 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0090 }
            monitor-exit(r2)     // Catch:{ all -> 0x0090 }
            return r5
        L_0x007e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r7.<init>(r0)     // Catch:{ all -> 0x0090 }
            r7.append(r5)     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0090 }
            r6.<init>(r5)     // Catch:{ all -> 0x0090 }
            throw r6     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0090 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.VariableServiceImpl.a(java.lang.String, java.lang.Object, java.lang.Class):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f
            monitor-enter(r0)
            com.applovin.sdk.AppLovinVariableService$OnVariablesUpdateListener r1 = r3.d     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x001d
            android.os.Bundle r1 = r3.e     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x000c
            goto L_0x001d
        L_0x000c:
            java.lang.Object r1 = r1.clone()     // Catch:{ all -> 0x001f }
            android.os.Bundle r1 = (android.os.Bundle) r1     // Catch:{ all -> 0x001f }
            com.applovin.impl.sdk.VariableServiceImpl$2 r2 = new com.applovin.impl.sdk.VariableServiceImpl$2     // Catch:{ all -> 0x001f }
            r2.<init>(r1)     // Catch:{ all -> 0x001f }
            r1 = 1
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThread(r1, r2)     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.VariableServiceImpl.a():void");
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return ((Boolean) a(str, Boolean.valueOf(z), Boolean.class)).booleanValue();
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        return (String) a(str, str2, String.class);
    }

    @Deprecated
    public void loadVariables() {
        String str;
        if (this.a.d()) {
            if (this.b.compareAndSet(false, true)) {
                this.a.S().a((a) new m(this.a, new m.a() {
                    public void a() {
                        VariableServiceImpl.this.b.set(false);
                    }
                }), o.a.BACKGROUND);
                return;
            } else if (u.a()) {
                str = "Ignored explicit variables load. Service is already in the process of retrieving the latest set of variables.";
            } else {
                return;
            }
        } else if (u.a()) {
            str = "The AppLovin SDK is waiting for the initial variables to be returned upon completing initialization.";
        } else {
            return;
        }
        u.i("AppLovinVariableService", str);
    }

    @Deprecated
    public void setOnVariablesUpdateListener(AppLovinVariableService.OnVariablesUpdateListener onVariablesUpdateListener) {
        this.d = onVariablesUpdateListener;
        synchronized (this.f) {
            if (onVariablesUpdateListener != null) {
                if (this.e != null && this.c.compareAndSet(false, true)) {
                    if (u.a()) {
                        this.a.A().b("AppLovinVariableService", "Setting initial listener");
                    }
                    a();
                }
            }
        }
    }

    public String toString() {
        return "VariableService{variables=" + this.e + ", listener=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public void updateVariables(JSONObject jSONObject) {
        if (u.a()) {
            u A = this.a.A();
            A.b("AppLovinVariableService", "Updating variables: " + jSONObject + "...");
        }
        synchronized (this.f) {
            this.e = JsonUtils.toBundle(jSONObject);
            a();
            this.a.a(d.j, jSONObject.toString());
        }
    }
}
