package com.appnext.core;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class SettingsManager {
    protected HashMap<String, Object> ds = null;
    private ArrayList<ConfigCallback> dt;
    /* access modifiers changed from: private */
    public int m = 0;
    protected HashMap<String, String> w = null;

    public interface ConfigCallback {
        void error(String str);

        void loaded(HashMap<String, Object> hashMap);
    }

    /* access modifiers changed from: protected */
    public abstract String j();

    /* access modifiers changed from: protected */
    public abstract HashMap<String, String> k();

    /* access modifiers changed from: protected */
    public abstract HashMap<String, String> l();

    /* access modifiers changed from: protected */
    public abstract String m();

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0090, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r6.m = 0;
        v("Internal Error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0091 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r7, java.lang.String r8, com.appnext.core.SettingsManager.ConfigCallback r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            boolean r1 = com.appnext.core.g.g(r7)     // Catch:{ all -> 0x0091 }
            if (r1 != 0) goto L_0x0013
            r6.m = r0     // Catch:{ all -> 0x0091 }
            if (r9 == 0) goto L_0x0011
            java.lang.String r7 = "Connection Error"
            r9.error(r7)     // Catch:{ all -> 0x0091 }
        L_0x0011:
            monitor-exit(r6)
            return
        L_0x0013:
            java.util.ArrayList<com.appnext.core.SettingsManager$ConfigCallback> r1 = r6.dt     // Catch:{ all -> 0x0091 }
            if (r1 != 0) goto L_0x001e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0091 }
            r1.<init>()     // Catch:{ all -> 0x0091 }
            r6.dt = r1     // Catch:{ all -> 0x0091 }
        L_0x001e:
            int r1 = r6.m     // Catch:{ all -> 0x0091 }
            r2 = 2
            if (r1 != r2) goto L_0x002b
            if (r9 == 0) goto L_0x008f
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r6.ds     // Catch:{ all -> 0x0091 }
            r9.loaded(r7)     // Catch:{ all -> 0x0091 }
            goto L_0x0098
        L_0x002b:
            if (r1 != 0) goto L_0x0088
            r1 = 1
            r6.m = r1     // Catch:{ all -> 0x0091 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            r3.<init>()     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = r6.j()     // Catch:{ all -> 0x0091 }
            r3.append(r4)     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = "?packageId="
            r3.append(r4)     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = r7.getPackageName()     // Catch:{ all -> 0x0091 }
            r3.append(r4)     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = "&id="
            r3.append(r4)     // Catch:{ all -> 0x0091 }
            r3.append(r8)     // Catch:{ all -> 0x0091 }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x0091 }
            if (r7 == 0) goto L_0x005f
            java.lang.String r3 = "pck"
            java.lang.String r4 = r7.getPackageName()     // Catch:{ all -> 0x0091 }
            r6.g(r3, r4)     // Catch:{ all -> 0x0091 }
        L_0x005f:
            java.lang.String r3 = "vid"
            java.lang.String r4 = com.appnext.core.g.W()     // Catch:{ all -> 0x0091 }
            r6.g(r3, r4)     // Catch:{ all -> 0x0091 }
            com.appnext.core.SettingsManager$a r3 = new com.appnext.core.SettingsManager$a     // Catch:{ all -> 0x0091 }
            r4 = 0
            r3.<init>()     // Catch:{ all -> 0x0091 }
            java.util.concurrent.Executor r4 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch:{ all -> 0x0091 }
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0091 }
            r5[r0] = r7     // Catch:{ all -> 0x0091 }
            r5[r1] = r8     // Catch:{ all -> 0x0091 }
            java.util.HashMap r7 = r6.k()     // Catch:{ all -> 0x0091 }
            r5[r2] = r7     // Catch:{ all -> 0x0091 }
            java.lang.String r7 = r6.m()     // Catch:{ all -> 0x0091 }
            r8 = 3
            r5[r8] = r7     // Catch:{ all -> 0x0091 }
            r3.executeOnExecutor(r4, r5)     // Catch:{ all -> 0x0091 }
        L_0x0088:
            if (r9 == 0) goto L_0x008f
            java.util.ArrayList<com.appnext.core.SettingsManager$ConfigCallback> r7 = r6.dt     // Catch:{ all -> 0x0091 }
            r7.add(r9)     // Catch:{ all -> 0x0091 }
        L_0x008f:
            monitor-exit(r6)
            return
        L_0x0091:
            r6.m = r0     // Catch:{ all -> 0x009a }
            java.lang.String r7 = "Internal Error"
            r6.v(r7)     // Catch:{ all -> 0x009a }
        L_0x0098:
            monitor-exit(r6)
            return
        L_0x009a:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.SettingsManager.a(android.content.Context, java.lang.String, com.appnext.core.SettingsManager$ConfigCallback):void");
    }

    public final void g(String str, String str2) {
        if (this.w == null) {
            this.w = new HashMap<>();
        }
        this.w.put(str, str2);
    }

    public final void h(String str, String str2) {
        if (this.w == null) {
            this.w = new HashMap<>();
        }
        if (!this.w.containsKey(str)) {
            this.w.put(str, str2);
        }
    }

    public final void i(String str, String str2) {
        if (this.ds == null) {
            this.ds = new HashMap<>();
        }
        this.ds.put(str, str2);
    }

    private class a extends AsyncTask<Object, Void, String> {
        private a() {
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a(objArr);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            super.onPostExecute(str);
            if (str == null) {
                SettingsManager.this.m = 0;
                SettingsManager.this.v("unknown error");
            } else if (str.startsWith("error:")) {
                SettingsManager.this.m = 0;
                SettingsManager.this.v(str.substring(7));
            } else {
                try {
                    HashMap<String, Object> u = SettingsManager.u(str);
                    if (SettingsManager.this.ds == null) {
                        SettingsManager.this.ds = u;
                    } else {
                        SettingsManager.this.ds.putAll(u);
                    }
                    SettingsManager.this.m = 2;
                    SettingsManager settingsManager = SettingsManager.this;
                    settingsManager.a(settingsManager.ds);
                } catch (Throwable th) {
                    com.appnext.base.a.a("SettingsManager$onPostExecute", th);
                    SettingsManager.this.m = 0;
                    SettingsManager.this.v("parsing error");
                }
            }
        }

        protected static String a(Object... objArr) {
            if (objArr == null) {
                return "error: Internal error";
            }
            try {
                int length = objArr.length;
                String str = null;
                Context context = length >= 0 ? objArr[0] : null;
                if (context == null) {
                    return "error: Internal error";
                }
                String str2 = length > 0 ? objArr[1] : null;
                if (TextUtils.isEmpty(str2)) {
                    return "error: Internal error";
                }
                HashMap hashMap = length >= 2 ? objArr[2] : null;
                if (length >= 3) {
                    str = objArr[3];
                }
                m.Z();
                return m.a(context, str2, hashMap, str);
            } catch (Throwable unused) {
                return "error: Internal error";
            }
        }
    }

    protected static HashMap<String, Object> u(String str) throws JSONException {
        HashMap<String, Object> hashMap = new HashMap<>();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String string = jSONObject.getString(next);
            try {
                JSONObject jSONObject2 = new JSONObject(string);
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    String string2 = jSONObject2.getString(next2);
                    hashMap.put(next + "_" + next2, string2);
                }
            } catch (Throwable unused) {
                hashMap.put(next, string);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void v(String str) {
        synchronized ("https://cdn.appnext.com/tools/sdk/confign") {
            Iterator it = new ArrayList(this.dt).iterator();
            while (it.hasNext()) {
                ConfigCallback configCallback = (ConfigCallback) it.next();
                if (configCallback != null) {
                    configCallback.error(str);
                }
            }
            this.dt.clear();
        }
    }

    /* access modifiers changed from: private */
    public void a(HashMap<String, Object> hashMap) {
        synchronized ("https://cdn.appnext.com/tools/sdk/confign") {
            Iterator it = new ArrayList(this.dt).iterator();
            while (it.hasNext()) {
                ((ConfigCallback) it.next()).loaded(hashMap);
            }
            this.dt.clear();
        }
    }

    public final String t(String str) {
        HashMap<String, Object> hashMap = this.ds;
        String str2 = (hashMap == null || !hashMap.containsKey(str)) ? null : (String) this.ds.get(str);
        if (str2 != null) {
            return str2;
        }
        if (l().containsKey(str)) {
            return l().get(str);
        }
        return null;
    }
}
