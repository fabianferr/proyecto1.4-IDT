package com.applovin.impl.sdk.b;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.facebook.internal.AnalyticsEvents;
import com.iab.omid.library.applovin.Omid;
import com.iab.omid.library.applovin.ScriptInjector;
import com.iab.omid.library.applovin.adsession.Partner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class f {
    /* access modifiers changed from: private */
    public final m a;
    /* access modifiers changed from: private */
    public final Context b;
    /* access modifiers changed from: private */
    public String c;

    public f(m mVar) {
        this.a = mVar;
        this.b = mVar.L();
    }

    public String a(String str) {
        try {
            return ScriptInjector.injectScriptContentIntoHtml(this.c, str);
        } catch (Throwable th) {
            if (u.a()) {
                this.a.A().b("OpenMeasurementService", "Failed to inject JavaScript SDK into HTML", th);
            }
            return str;
        }
    }

    public void a() {
        if (((Boolean) this.a.a(b.as)).booleanValue()) {
            if (u.a()) {
                u A = this.a.A();
                A.b("OpenMeasurementService", "Initializing Open Measurement SDK v" + c() + "...");
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    Omid.activate(f.this.b);
                    if (u.a()) {
                        u A = f.this.a.A();
                        StringBuilder sb = new StringBuilder("Init ");
                        sb.append(f.this.b() ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
                        sb.append(" and took ");
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        sb.append("ms");
                        A.b("OpenMeasurementService", sb.toString());
                    }
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(f.this.b.getResources().openRawResource(R.raw.omsdk_v_1_0)));
                        try {
                            StringBuilder sb2 = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    sb2.append(readLine);
                                } else {
                                    String unused = f.this.c = sb2.toString();
                                    try {
                                        bufferedReader.close();
                                        return;
                                    } catch (IOException e) {
                                        Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e);
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e2);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (u.a()) {
                            f.this.a.A().b("OpenMeasurementService", "Failed to retrieve resource omskd_v_1_0.js", th2);
                        }
                    }
                }
            });
        }
    }

    public boolean b() {
        return Omid.isActive();
    }

    public String c() {
        return Omid.getVersion();
    }

    public Partner d() {
        return Partner.createPartner((String) this.a.a(b.at), AppLovinSdk.VERSION);
    }

    public String e() {
        return this.c;
    }
}
