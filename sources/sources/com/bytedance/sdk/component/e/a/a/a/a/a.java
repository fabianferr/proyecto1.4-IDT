package com.bytedance.sdk.component.e.a.a.a.a;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.a.e;
import com.bytedance.sdk.component.e.a.b.d;
import com.bytedance.sdk.component.e.a.c.b;
import com.bytedance.sdk.component.e.a.c.c;
import com.bytedance.sdk.component.e.a.f;
import com.bytedance.sdk.component.e.a.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AdEventRepoImpl */
public class a extends c {
    protected List<String> a = new ArrayList();
    private final Context c;
    private com.bytedance.sdk.component.e.a.d.b.a d;

    public byte c() {
        return 2;
    }

    public byte d() {
        return 0;
    }

    public a(Context context, com.bytedance.sdk.component.e.a.d.b.a aVar) {
        super(context);
        this.c = context;
        this.d = aVar;
        if (aVar == null) {
            this.d = com.bytedance.sdk.component.e.a.d.b.a.c();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r0 == null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        if (r0 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r0.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a() {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            android.content.Context r2 = r10.f()     // Catch:{ Exception -> 0x002f, all -> 0x0028 }
            java.lang.String r3 = r10.b()     // Catch:{ Exception -> 0x002f, all -> 0x0028 }
            java.lang.String r4 = "count(1)"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x002f, all -> 0x0028 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r0 = com.bytedance.sdk.component.e.a.a.a.c.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x002f, all -> 0x0028 }
            if (r0 == 0) goto L_0x0022
            r0.moveToFirst()     // Catch:{ Exception -> 0x002f, all -> 0x0028 }
            int r1 = r0.getInt(r1)     // Catch:{ Exception -> 0x002f, all -> 0x0028 }
        L_0x0022:
            if (r0 == 0) goto L_0x0032
        L_0x0024:
            r0.close()     // Catch:{ Exception -> 0x0032 }
            goto L_0x0032
        L_0x0028:
            r1 = move-exception
            if (r0 == 0) goto L_0x002e
            r0.close()     // Catch:{ Exception -> 0x002e }
        L_0x002e:
            throw r1
        L_0x002f:
            if (r0 == 0) goto L_0x0032
            goto L_0x0024
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.a.a.a.a():int");
    }

    public String b() {
        e b = i.e().b();
        if (b != null) {
            return b.b();
        }
        return null;
    }

    public List<com.bytedance.sdk.component.e.a.d.a> a(int i, String str) {
        String str2;
        long a2 = com.bytedance.sdk.component.e.a.b.a.a(i, f());
        c.c("" + b() + " query db max :" + a2 + " limit:" + i);
        if (a2 <= 0 || TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = str + " DESC limit " + a2;
        }
        String str3 = str2;
        LinkedList linkedList = new LinkedList();
        this.a.clear();
        Cursor a3 = com.bytedance.sdk.component.e.a.a.a.c.a(f(), b(), new String[]{"id", "value", "encrypt"}, (String) null, (String[]) null, (String) null, (String) null, str3);
        if (a3 != null) {
            try {
                f m = i.e().m();
                while (a3.moveToNext()) {
                    String string = a3.getString(a3.getColumnIndex("id"));
                    String string2 = a3.getString(a3.getColumnIndex("value"));
                    if (a3.getInt(a3.getColumnIndex("encrypt")) == 1) {
                        string2 = m.a(string2);
                    }
                    if (TextUtils.isEmpty(string2)) {
                        c.a("log_show_query : value is null");
                        this.a.add(string);
                    } else {
                        JSONObject jSONObject = new JSONObject(string2);
                        com.bytedance.sdk.component.e.a.d.a.a aVar = new com.bytedance.sdk.component.e.a.d.a.a(string, jSONObject);
                        aVar.a(d());
                        aVar.b(c());
                        com.bytedance.sdk.component.e.a.c.a.a(jSONObject, aVar);
                        linkedList.add(aVar);
                    }
                }
                if (a3 != null) {
                    try {
                        a3.close();
                        if (!this.a.isEmpty()) {
                            a(this.a);
                            this.a.clear();
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                if (a3 != null) {
                    try {
                        a3.close();
                        if (!this.a.isEmpty()) {
                            a(this.a);
                            this.a.clear();
                        }
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        }
        c.c("" + b() + " query db actually size :" + linkedList.size());
        return linkedList;
    }

    public List<com.bytedance.sdk.component.e.a.d.a> a(String str) {
        com.bytedance.sdk.component.e.a.d.b.a aVar = this.d;
        if (aVar == null) {
            return new ArrayList();
        }
        return a(aVar.b(), str);
    }

    /* access modifiers changed from: protected */
    public void a(List<String> list) {
        c.a("PADLT", b() + " adevent repo delete: " + list.size());
        com.bytedance.sdk.component.e.a.a.a.c.a(f(), "DELETE FROM " + b() + " WHERE " + a("id", list, 1000, true));
        b.a(d.d.Y(), list.size());
        c(list);
    }

    public void b(List<com.bytedance.sdk.component.e.a.d.a> list) {
        if (list != null && list.size() != 0) {
            LinkedList linkedList = new LinkedList();
            for (com.bytedance.sdk.component.e.a.d.a next : list) {
                linkedList.add(next.c());
                com.bytedance.sdk.component.e.a.c.a.j(next);
            }
            c.a("PADLT", b() + " adevent repo delete: " + linkedList.size());
            com.bytedance.sdk.component.e.a.a.a.c.a(f(), "DELETE FROM " + b() + " WHERE " + a("id", linkedList, 1000, true));
            c(linkedList);
        }
    }

    public boolean a(int i) {
        if (this.d == null) {
            return false;
        }
        int a2 = a();
        int a3 = this.d.a();
        c.c("" + b() + " check dbCount:" + a2 + " MaxCacheCount:" + a3 + " message:" + i);
        if (!com.bytedance.sdk.component.e.a.c.a.b() || !(i == 1 || i == 2)) {
            if (a2 >= a3) {
                return true;
            }
            return false;
        } else if (a2 >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static String e() {
        return "CREATE TABLE IF NOT EXISTS " + i.e().b().b() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
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
