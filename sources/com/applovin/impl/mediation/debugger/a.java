package com.applovin.impl.mediation.debugger;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxDebuggerActivity;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.share.internal.ShareConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class a implements b.c<JSONObject> {
    /* access modifiers changed from: private */
    public static WeakReference<MaxDebuggerActivity> a;
    /* access modifiers changed from: private */
    public static final AtomicBoolean b = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final m c;
    private final u d;
    private final Context e;
    /* access modifiers changed from: private */
    public final com.applovin.impl.mediation.debugger.ui.b.b f;
    private final Map<String, com.applovin.impl.mediation.debugger.b.b.b> g = CollectionUtils.map();
    private final AtomicBoolean h = new AtomicBoolean();
    private boolean i;
    private int j = 2;
    private boolean k;
    private Map<String, List<?>> l;

    public a(m mVar) {
        this.c = mVar;
        this.d = mVar.A();
        Context L = mVar.L();
        this.e = L;
        this.f = new com.applovin.impl.mediation.debugger.ui.b.b(L);
    }

    private List<com.applovin.impl.mediation.debugger.b.a.a> a(List<com.applovin.impl.mediation.debugger.b.a.a> list, m mVar) {
        List<String> initializationAdUnitIds = mVar.p().getInitializationAdUnitIds();
        if (initializationAdUnitIds == null || initializationAdUnitIds.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(initializationAdUnitIds.size());
        for (com.applovin.impl.mediation.debugger.b.a.a next : list) {
            if (initializationAdUnitIds.contains(next.a())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.b.b.b> a(JSONObject jSONObject, m mVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "networks", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) null);
            if (jSONObject2 != null) {
                com.applovin.impl.mediation.debugger.b.b.b bVar = new com.applovin.impl.mediation.debugger.b.b.b(jSONObject2, mVar);
                arrayList.add(bVar);
                this.g.put(bVar.m(), bVar);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private List<com.applovin.impl.mediation.debugger.b.a.a> a(JSONObject jSONObject, List<com.applovin.impl.mediation.debugger.b.b.b> list, m mVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ad_units", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new com.applovin.impl.mediation.debugger.b.a.a(jSONObject2, this.g, mVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private void a(List<com.applovin.impl.mediation.debugger.b.b.b> list) {
        boolean z;
        Iterator<com.applovin.impl.mediation.debugger.b.b.b> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.applovin.impl.mediation.debugger.b.b.b next = it.next();
            if (next.e() && next.a() == b.a.INVALID_INTEGRATION) {
                z = true;
                break;
            }
        }
        if (z) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    Activity ao = a.this.c.ao();
                    if (ao == null) {
                        u.i("AppLovinSdk", "MAX Mediation Debugger has flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this log will only be shown in your development builds. Live apps will not be affected.");
                    } else {
                        new AlertDialog.Builder(ao).setTitle("Review Integration Errors").setMessage("Looks like MAX Mediation Debugger flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this prompt will only be shown in your development builds. Live apps will not be affected.").setPositiveButton("Show Mediation Debugger", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                a.this.c();
                            }
                        }).setNegativeButton("DISMISS", (DialogInterface.OnClickListener) null).create().show();
                    }
                }
            }, TimeUnit.SECONDS.toMillis(2));
        }
    }

    private void f() {
        this.c.af().a(new com.applovin.impl.sdk.utils.a() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof MaxDebuggerActivity) {
                    u.f("AppLovinSdk", "Started mediation debugger");
                    if (!a.this.g() || a.a.get() != activity) {
                        MaxDebuggerActivity maxDebuggerActivity = (MaxDebuggerActivity) activity;
                        WeakReference unused = a.a = new WeakReference(maxDebuggerActivity);
                        maxDebuggerActivity.setListAdapter(a.this.f, a.this.c.af());
                    }
                    a.b.set(false);
                }
            }

            public void onActivityDestroyed(Activity activity) {
                if (activity instanceof MaxDebuggerActivity) {
                    u.f("AppLovinSdk", "Mediation debugger destroyed");
                    WeakReference unused = a.a = null;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean g() {
        WeakReference<MaxDebuggerActivity> weakReference = a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public List<?> a(String str) {
        Map<String, List<?>> map = this.l;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return this.l.get(str);
    }

    public void a() {
        if (this.h.compareAndSet(false, true)) {
            this.c.S().a((com.applovin.impl.sdk.f.a) new com.applovin.impl.mediation.debugger.c.a(this, this.c), o.a.MEDIATION_MAIN);
        }
    }

    public void a(int i2, String str, JSONObject jSONObject) {
        u uVar = this.d;
        uVar.e("MediationDebuggerService", "Unable to fetch mediation debugger info: server returned " + i2);
        u.i("AppLovinSdk", "Unable to show mediation debugger.");
        this.f.a((List<com.applovin.impl.mediation.debugger.b.b.b>) null, (List<com.applovin.impl.mediation.debugger.b.a.a>) null, (List<com.applovin.impl.mediation.debugger.b.a.a>) null, (String) null, (String) null, (String) null, this.c);
        this.h.set(false);
    }

    public void a(Map<String, List<?>> map) {
        this.l = map;
        a();
        if (g() || !b.compareAndSet(false, true)) {
            u.i("AppLovinSdk", "Mediation debugger is already showing");
            return;
        }
        if (!this.k) {
            f();
            this.k = true;
        }
        Intent intent = new Intent(this.e, MaxDebuggerActivity.class);
        intent.setFlags(268435456);
        u.f("AppLovinSdk", "Starting mediation debugger...");
        this.e.startActivity(intent);
    }

    public void a(JSONObject jSONObject, int i2) {
        List<com.applovin.impl.mediation.debugger.b.b.b> a2 = a(jSONObject, this.c);
        List<com.applovin.impl.mediation.debugger.b.a.a> a3 = a(jSONObject, a2, this.c);
        List<com.applovin.impl.mediation.debugger.b.a.a> a4 = a(a3, this.c);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "alert", (JSONObject) null);
        List<com.applovin.impl.mediation.debugger.b.b.b> list = a2;
        this.f.a(list, a3, a4, JsonUtils.getString(jSONObject2, "title", (String) null), JsonUtils.getString(jSONObject2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE, (String) null), JsonUtils.getString(jSONObject, "account_id", (String) null), this.c);
        if (b()) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    a.this.c();
                }
            }, TimeUnit.SECONDS.toMillis((long) this.j));
        } else {
            a(a2);
        }
    }

    public void a(boolean z, int i2) {
        this.i = z;
        this.j = i2;
    }

    public boolean b() {
        return this.i;
    }

    public void c() {
        a((Map<String, List<?>>) null);
    }

    public String toString() {
        return "MediationDebuggerService{, listAdapter=" + this.f + "}";
    }
}
