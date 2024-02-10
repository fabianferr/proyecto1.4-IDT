package com.bytedance.sdk.component.e.a.b.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.a.a.f;
import com.bytedance.sdk.component.e.a.c.c;
import com.bytedance.sdk.component.e.a.d.a;
import com.bytedance.sdk.component.e.a.g;
import com.bytedance.sdk.component.e.a.i;
import java.util.List;

/* compiled from: OverSeasEventProviderImpl */
public class b {
    public static g a;

    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public int a(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public Uri a(Uri uri, ContentValues contentValues) {
        return null;
    }

    public String c() {
        return "ad_log_event";
    }

    public void d() {
    }

    public static g a(Context context) {
        try {
            c.a("getResolver");
            if (a == null) {
                a = i.e().m().l();
            }
        } catch (Exception unused) {
        }
        return a;
    }

    public static void a() {
        c.a("EventProviderImpl#start");
        if (i.e().d() != null) {
            try {
                g a2 = a(i.e().d());
                if (a2 != null) {
                    Uri parse = Uri.parse(e() + "adLogStart");
                    c.a("EventProviderImpl#gettype");
                    a2.a(parse);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void b() {
        if (i.e().d() != null) {
            try {
                g a2 = a(i.e().d());
                if (a2 != null) {
                    a2.a(Uri.parse(e() + "adLogStop"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(a aVar) {
        if (aVar != null) {
            try {
                c.a("dispatch event getResolver before");
                g a2 = a(i.e().d());
                c.a("dispatch event getResolver end");
                if (a2 != null) {
                    String a3 = f.a(aVar.f());
                    Uri parse = Uri.parse(e() + "adLogDispatch?event=" + a3);
                    c.a("dispatch event getType:");
                    a2.a(parse);
                    c.a("dispatch event getType end ");
                }
            } catch (Throwable th) {
                c.d("dispatch event Throwable:" + th.toString());
            }
        }
    }

    public static void a(String str, List<String> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (String a2 : list) {
                    sb.append(f.a(a2));
                    sb.append(",");
                }
                String a3 = f.a(sb.toString());
                String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(a3) + "&replace=" + String.valueOf(z);
                g a4 = a(i.e().d());
                if (a4 != null) {
                    a4.a(Uri.parse(e() + "trackAdUrl" + str2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        if (i.e().m().g() != 0 || !TextUtils.isEmpty(str)) {
            try {
                g a2 = a(i.e().d());
                if (a2 != null) {
                    a2.a(Uri.parse(e() + "trackAdFailed?did=" + String.valueOf(str)));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String e() {
        return com.bytedance.sdk.component.e.a.a.a.g.b + "/ad_log_event/";
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
        if (r0.equals("adLogStop") == false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(android.net.Uri r8) {
        /*
            r7 = this;
            java.lang.String r0 = "OverSeasEventProviderImpl#gettype()"
            com.bytedance.sdk.component.e.a.c.c.a(r0)
            java.lang.String r0 = r8.getPath()
            java.lang.String r1 = "/"
            java.lang.String[] r0 = r0.split(r1)
            r1 = 2
            r0 = r0[r1]
            r0.hashCode()
            int r2 = r0.hashCode()
            r3 = 0
            r4 = -1
            switch(r2) {
                case -482705237: goto L_0x004a;
                case -171493183: goto L_0x003f;
                case 964299715: goto L_0x0036;
                case 1025736635: goto L_0x002b;
                case 1131732929: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            r1 = -1
            goto L_0x0054
        L_0x0020:
            java.lang.String r1 = "trackAdUrl"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0029
            goto L_0x001e
        L_0x0029:
            r1 = 4
            goto L_0x0054
        L_0x002b:
            java.lang.String r1 = "adLogDispatch"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0034
            goto L_0x001e
        L_0x0034:
            r1 = 3
            goto L_0x0054
        L_0x0036:
            java.lang.String r2 = "adLogStop"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0054
            goto L_0x001e
        L_0x003f:
            java.lang.String r1 = "adLogStart"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0048
            goto L_0x001e
        L_0x0048:
            r1 = 1
            goto L_0x0054
        L_0x004a:
            java.lang.String r1 = "trackAdFailed"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0053
            goto L_0x001e
        L_0x0053:
            r1 = 0
        L_0x0054:
            java.lang.String r0 = "did"
            java.lang.String r2 = "EventProviderImpl"
            switch(r1) {
                case 0: goto L_0x00e4;
                case 1: goto L_0x00d7;
                case 2: goto L_0x00ca;
                case 3: goto L_0x00a9;
                case 4: goto L_0x005d;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x00ef
        L_0x005d:
            java.lang.String r1 = "dispatch FUN_TRACK_URL"
            com.bytedance.sdk.component.e.a.c.c.a(r2, r1)
            java.lang.String r0 = r8.getQueryParameter(r0)     // Catch:{ all -> 0x00ef }
            java.lang.String r1 = "replace"
            java.lang.String r1 = r8.getQueryParameter(r1)     // Catch:{ all -> 0x00ef }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x00ef }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00ef }
            java.lang.String r2 = "track"
            java.lang.String r8 = r8.getQueryParameter(r2)     // Catch:{ all -> 0x00ef }
            java.lang.String r8 = com.bytedance.sdk.component.e.a.a.a.f.b(r8)     // Catch:{ all -> 0x00ef }
            java.lang.String r2 = ","
            java.lang.String[] r8 = r8.split(r2)     // Catch:{ all -> 0x00ef }
            int r2 = r8.length     // Catch:{ all -> 0x00ef }
            if (r2 <= 0) goto L_0x00ef
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00ef }
            r2.<init>()     // Catch:{ all -> 0x00ef }
            int r4 = r8.length     // Catch:{ all -> 0x00ef }
        L_0x008d:
            if (r3 >= r4) goto L_0x00a1
            r5 = r8[r3]     // Catch:{ all -> 0x00ef }
            java.lang.String r5 = com.bytedance.sdk.component.e.a.a.a.f.b(r5)     // Catch:{ all -> 0x00ef }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00ef }
            if (r6 != 0) goto L_0x009e
            r2.add(r5)     // Catch:{ all -> 0x00ef }
        L_0x009e:
            int r3 = r3 + 1
            goto L_0x008d
        L_0x00a1:
            com.bytedance.sdk.component.e.a.f.b r8 = com.bytedance.sdk.component.e.a.f.a.a()     // Catch:{ all -> 0x00ef }
            r8.a(r0, r2, r1)     // Catch:{ all -> 0x00ef }
            goto L_0x00ef
        L_0x00a9:
            java.lang.String r0 = "dispatch FUN_AD_EVENT_DISPATCH"
            com.bytedance.sdk.component.e.a.c.c.a(r2, r0)
            java.lang.String r0 = "event"
            java.lang.String r8 = r8.getQueryParameter(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L_0x00ef
            java.lang.String r8 = com.bytedance.sdk.component.e.a.a.a.f.b(r8)
            com.bytedance.sdk.component.e.a.d.a r8 = com.bytedance.sdk.component.e.a.d.a.a.c((java.lang.String) r8)
            if (r8 == 0) goto L_0x00ef
            com.bytedance.sdk.component.e.a.d r0 = com.bytedance.sdk.component.e.a.d.a
            r0.a((com.bytedance.sdk.component.e.a.d.a) r8)
            goto L_0x00ef
        L_0x00ca:
            java.lang.String r8 = "====ad event function will be stop===="
            com.bytedance.sdk.component.e.a.c.c.a(r2, r8)
            com.bytedance.sdk.component.e.a.i r8 = com.bytedance.sdk.component.e.a.i.e()
            r8.h()
            goto L_0x00ef
        L_0x00d7:
            java.lang.String r8 = "EventProviderImpl====ad event function will be start===="
            com.bytedance.sdk.component.e.a.c.c.a(r8)
            com.bytedance.sdk.component.e.a.i r8 = com.bytedance.sdk.component.e.a.i.e()
            r8.g()
            goto L_0x00ef
        L_0x00e4:
            java.lang.String r8 = r8.getQueryParameter(r0)
            com.bytedance.sdk.component.e.a.f.b r0 = com.bytedance.sdk.component.e.a.f.a.a()
            r0.a(r8)
        L_0x00ef:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.b.b.b.a(android.net.Uri):java.lang.String");
    }
}
