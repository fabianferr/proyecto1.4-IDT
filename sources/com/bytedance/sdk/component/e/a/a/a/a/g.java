package com.bytedance.sdk.component.e.a.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.b.d;
import com.bytedance.sdk.component.e.a.c.b;
import com.bytedance.sdk.component.e.a.c.c;
import com.bytedance.sdk.component.e.a.d.b.a;
import com.bytedance.sdk.component.e.a.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: StatsLogEventRepoImpl */
public class g extends c {
    protected List<String> a = new ArrayList();
    private a c;

    public byte a() {
        return 1;
    }

    public byte c() {
        return 2;
    }

    public g(Context context, a aVar) {
        super(context);
        this.c = aVar;
        if (aVar == null) {
            this.c = a.c();
        }
    }

    public String b() {
        return i.e().b().d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        if (r0 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        if (0 == 0) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int e() {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            android.content.Context r2 = r10.f()     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = r10.b()     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = "count(1)"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ all -> 0x0028 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r0 = com.bytedance.sdk.component.e.a.a.a.c.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0022
            r0.moveToFirst()     // Catch:{ all -> 0x0028 }
            int r1 = r0.getInt(r1)     // Catch:{ all -> 0x0028 }
        L_0x0022:
            if (r0 == 0) goto L_0x002b
        L_0x0024:
            r0.close()     // Catch:{ Exception -> 0x002b }
            goto L_0x002b
        L_0x0028:
            if (r0 == 0) goto L_0x002b
            goto L_0x0024
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.a.a.g.e():int");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0051 */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0051 A[LOOP:0: B:8:0x0051->B:34:0x0051, LOOP_START, SYNTHETIC, Splitter:B:8:0x0051] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.bytedance.sdk.component.e.a.d.a> a(int r11, java.lang.String r12) {
        /*
            r10 = this;
            android.content.Context r0 = r10.f()
            long r0 = com.bytedance.sdk.component.e.a.b.a.a(r11, r0)
            r2 = 0
            int r11 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r11 <= 0) goto L_0x0029
            boolean r11 = android.text.TextUtils.isEmpty(r12)
            if (r11 != 0) goto L_0x0029
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r12)
            java.lang.String r12 = " DESC limit "
            r11.append(r12)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            goto L_0x002a
        L_0x0029:
            r11 = 0
        L_0x002a:
            r7 = r11
            java.util.LinkedList r11 = new java.util.LinkedList
            r11.<init>()
            java.util.List<java.lang.String> r12 = r10.a
            r12.clear()
            android.content.Context r0 = r10.f()
            java.lang.String r1 = r10.b()
            java.lang.String r12 = "id"
            java.lang.String r8 = "value"
            java.lang.String r9 = "encrypt"
            java.lang.String[] r2 = new java.lang.String[]{r12, r8, r9}
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r0 = com.bytedance.sdk.component.e.a.a.a.c.a(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r0 == 0) goto L_0x00d7
        L_0x0051:
            boolean r1 = r0.moveToNext()     // Catch:{ all -> 0x00be }
            if (r1 == 0) goto L_0x00a6
            int r1 = r0.getColumnIndex(r12)     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x0051 }
            int r2 = r0.getColumnIndex(r8)     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0051 }
            int r3 = r0.getColumnIndex(r9)     // Catch:{ all -> 0x0051 }
            int r3 = r0.getInt(r3)     // Catch:{ all -> 0x0051 }
            r4 = 1
            if (r3 != r4) goto L_0x007e
            com.bytedance.sdk.component.e.a.i r3 = com.bytedance.sdk.component.e.a.i.e()     // Catch:{ all -> 0x0051 }
            com.bytedance.sdk.component.e.a.f r3 = r3.m()     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = r3.a((java.lang.String) r2)     // Catch:{ all -> 0x0051 }
        L_0x007e:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0051 }
            if (r3 == 0) goto L_0x008a
            java.util.List<java.lang.String> r2 = r10.a     // Catch:{ all -> 0x0051 }
            r2.add(r1)     // Catch:{ all -> 0x0051 }
            goto L_0x0051
        L_0x008a:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0051 }
            r3.<init>(r2)     // Catch:{ all -> 0x0051 }
            com.bytedance.sdk.component.e.a.d.a.a r2 = new com.bytedance.sdk.component.e.a.d.a.a     // Catch:{ all -> 0x0051 }
            r2.<init>((java.lang.String) r1, (org.json.JSONObject) r3)     // Catch:{ all -> 0x0051 }
            byte r1 = r10.c()     // Catch:{ all -> 0x0051 }
            r2.b((byte) r1)     // Catch:{ all -> 0x0051 }
            byte r1 = r10.a()     // Catch:{ all -> 0x0051 }
            r2.a((byte) r1)     // Catch:{ all -> 0x0051 }
            r11.add(r2)     // Catch:{ all -> 0x0051 }
            goto L_0x0051
        L_0x00a6:
            if (r0 == 0) goto L_0x00d7
            r0.close()     // Catch:{ Exception -> 0x00d7 }
            java.util.List<java.lang.String> r12 = r10.a     // Catch:{ Exception -> 0x00d7 }
            boolean r12 = r12.isEmpty()     // Catch:{ Exception -> 0x00d7 }
            if (r12 != 0) goto L_0x00d7
            java.util.List<java.lang.String> r12 = r10.a     // Catch:{ Exception -> 0x00d7 }
            r10.a((java.util.List<java.lang.String>) r12)     // Catch:{ Exception -> 0x00d7 }
            java.util.List<java.lang.String> r12 = r10.a     // Catch:{ Exception -> 0x00d7 }
            r12.clear()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00d7
        L_0x00be:
            r11 = move-exception
            if (r0 == 0) goto L_0x00d6
            r0.close()     // Catch:{ Exception -> 0x00d6 }
            java.util.List<java.lang.String> r12 = r10.a     // Catch:{ Exception -> 0x00d6 }
            boolean r12 = r12.isEmpty()     // Catch:{ Exception -> 0x00d6 }
            if (r12 != 0) goto L_0x00d6
            java.util.List<java.lang.String> r12 = r10.a     // Catch:{ Exception -> 0x00d6 }
            r10.a((java.util.List<java.lang.String>) r12)     // Catch:{ Exception -> 0x00d6 }
            java.util.List<java.lang.String> r12 = r10.a     // Catch:{ Exception -> 0x00d6 }
            r12.clear()     // Catch:{ Exception -> 0x00d6 }
        L_0x00d6:
            throw r11
        L_0x00d7:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.a.a.g.a(int, java.lang.String):java.util.List");
    }

    /* access modifiers changed from: protected */
    public void a(List<String> list) {
        c.a("PADLT", b() + " stats repo delete: " + list.size());
        com.bytedance.sdk.component.e.a.a.a.c.a(f(), "DELETE FROM " + b() + " WHERE " + a("id", list, 1000, true));
        b.a(d.d.Y(), list.size());
        c(list);
    }

    public List<com.bytedance.sdk.component.e.a.d.a> a(String str) {
        a aVar = this.c;
        if (aVar == null) {
            return new ArrayList();
        }
        return a(aVar.b(), str);
    }

    public void b(List<com.bytedance.sdk.component.e.a.d.a> list) {
        if (list != null && list.size() != 0) {
            LinkedList linkedList = new LinkedList();
            for (com.bytedance.sdk.component.e.a.d.a next : list) {
                linkedList.add(next.c());
                com.bytedance.sdk.component.e.a.c.a.j(next);
            }
            c.a("PADLT", b() + " stats repo delete: " + linkedList.size());
            com.bytedance.sdk.component.e.a.a.a.c.a(f(), "DELETE FROM " + b() + " WHERE " + a("id", linkedList, 1000, true));
            c(linkedList);
        }
    }

    public boolean a(int i) {
        if (this.c != null && e() >= this.c.a()) {
            return true;
        }
        return false;
    }

    public static String g() {
        return "CREATE TABLE IF NOT EXISTS " + i.e().b().d() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    private static String a(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i, 1000);
        int size = list.size();
        if (size % min == 0) {
            i2 = size / min;
        } else {
            i2 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * min;
            String a2 = a(TextUtils.join("','", list.subList(i4, Math.min(i4 + min, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(a2);
            sb.append("')");
        }
        String sb2 = sb.toString();
        return a(sb2, str + str2 + "('')");
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
