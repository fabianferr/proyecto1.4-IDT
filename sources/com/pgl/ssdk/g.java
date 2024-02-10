package com.pgl.ssdk;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class g {
    private static g c;
    private Context a = null;
    private List b = new ArrayList();

    private g(Context context) {
        this.a = context;
    }

    public static g a(Context context) {
        if (c == null) {
            synchronized (g.class) {
                if (c == null) {
                    c = new g(context);
                }
            }
        }
        return c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        r1 = -10001;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r6 = this;
            r0 = -1
            monitor-enter(r6)     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            android.content.Context r1 = r6.a     // Catch:{ all -> 0x004d }
            android.content.IntentFilter r2 = new android.content.IntentFilter     // Catch:{ all -> 0x004d }
            java.lang.String r3 = "android.intent.action.BATTERY_CHANGED"
            r2.<init>(r3)     // Catch:{ all -> 0x004d }
            r3 = 0
            android.content.Intent r1 = r1.registerReceiver(r3, r2)     // Catch:{ all -> 0x004d }
            if (r1 != 0) goto L_0x0014
            r1 = -1
            goto L_0x001a
        L_0x0014:
            java.lang.String r2 = "plugged"
            int r1 = r1.getIntExtra(r2, r0)     // Catch:{ all -> 0x004d }
        L_0x001a:
            android.content.Context r2 = r6.a     // Catch:{ all -> 0x004d }
            android.content.IntentFilter r4 = new android.content.IntentFilter     // Catch:{ all -> 0x004d }
            java.lang.String r5 = "android.intent.action.BATTERY_CHANGED"
            r4.<init>(r5)     // Catch:{ all -> 0x004d }
            android.content.Intent r2 = r2.registerReceiver(r3, r4)     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x002b
            r2 = -1
            goto L_0x0048
        L_0x002b:
            java.lang.String r3 = "level"
            int r3 = r2.getIntExtra(r3, r0)     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "scale"
            int r2 = r2.getIntExtra(r4, r0)     // Catch:{ all -> 0x004d }
            float r3 = (float) r3     // Catch:{ all -> 0x004d }
            float r2 = (float) r2     // Catch:{ all -> 0x004d }
            float r3 = r3 / r2
            r2 = 1120403456(0x42c80000, float:100.0)
            float r3 = r3 * r2
            r2 = 1092616192(0x41200000, float:10.0)
            float r3 = r3 * r2
            int r2 = java.lang.Math.round(r3)     // Catch:{ all -> 0x004d }
            int r2 = r2 / 10
        L_0x0048:
            monitor-exit(r6)     // Catch:{ all -> 0x004d }
            int r1 = r1 * 10000
            int r1 = r1 + r2
            goto L_0x0054
        L_0x004d:
            r1 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x004d }
            throw r1     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
        L_0x0050:
            r0 = move-exception
            throw r0
        L_0x0052:
            r1 = -10001(0xffffffffffffd8ef, float:NaN)
        L_0x0054:
            if (r1 != r0) goto L_0x0057
            return
        L_0x0057:
            java.util.List r0 = r6.b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            java.util.List r0 = r6.b     // Catch:{ all -> 0x007e }
            int r0 = r0.size()     // Catch:{ all -> 0x007e }
            r1 = 20
            if (r0 <= r1) goto L_0x007e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x007e }
            java.util.List r2 = r6.b     // Catch:{ all -> 0x007e }
            int r3 = r0 + -10
            java.util.List r0 = r2.subList(r3, r0)     // Catch:{ all -> 0x007e }
            r1.<init>(r0)     // Catch:{ all -> 0x007e }
            java.util.List r0 = r6.b     // Catch:{ all -> 0x007e }
            r0.clear()     // Catch:{ all -> 0x007e }
            r6.b = r1     // Catch:{ all -> 0x007e }
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.g.a():void");
    }

    public synchronized String b() {
        if (this.b.size() <= 0) {
            return "-1";
        }
        List list = this.b;
        return String.valueOf(((Integer) list.get(list.size() - 1)).intValue() % 100);
    }

    public synchronized String c() {
        return new JSONArray(this.b).toString();
    }
}
