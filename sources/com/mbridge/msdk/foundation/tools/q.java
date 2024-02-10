package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: MIMManager */
public final class q {
    private static volatile String d;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<CampaignEx> a;
    /* access modifiers changed from: private */
    public volatile b b;
    /* access modifiers changed from: private */
    public final AtomicBoolean c;
    /* access modifiers changed from: private */
    public volatile Boolean e;
    private CampaignEx f;
    private int g;
    private Context h;

    /* compiled from: MIMManager */
    private static final class a {
        /* access modifiers changed from: private */
        public static final q a = new q();
    }

    private q() {
        this.g = 0;
        this.a = new CopyOnWriteArrayList<>();
        this.c = new AtomicBoolean(false);
    }

    public static q a() {
        return a.a;
    }

    public final void a(CampaignEx campaignEx) {
        try {
            if (this.e != null && campaignEx != null && this.e.booleanValue()) {
                this.f = campaignEx;
                this.a.add(campaignEx);
            }
        } catch (Exception e2) {
            aa.d("MIMManager", e2.getMessage());
        }
    }

    public final void b(CampaignEx campaignEx) {
        try {
            if (this.e != null && campaignEx != null && this.e.booleanValue()) {
                this.f = null;
                try {
                    this.a.remove(campaignEx);
                } catch (Exception e2) {
                    aa.a("MIMManager", e2.getMessage());
                }
            }
        } catch (Exception e3) {
            aa.d("MIMManager", e3.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final CampaignEx b() {
        return this.f;
    }

    public final void c() {
        this.g++;
    }

    public final void d() {
        int i = this.g - 1;
        this.g = i;
        if (i <= 0) {
            Context context = this.h;
            if (this.b != null && context != null) {
                try {
                    context.unregisterReceiver(this.b);
                } catch (Exception e2) {
                    aa.a("MIMManager", e2.getMessage());
                } catch (Throwable th) {
                    this.f = null;
                    this.a.clear();
                    this.a = null;
                    this.b = null;
                    this.h = null;
                    throw th;
                }
                this.f = null;
                this.a.clear();
                this.a = null;
                this.b = null;
                this.h = null;
            }
        }
    }

    public final void a(final Context context) {
        this.h = context;
        com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() {
            public final void run() {
                if (q.this.c.compareAndSet(false, true)) {
                    try {
                        q qVar = q.this;
                        Boolean unused = qVar.e = qVar.g();
                    } catch (Exception e) {
                        aa.a("MIMManager", e.getMessage());
                    }
                    if (q.this.e != null && q.this.e.booleanValue() && context != null) {
                        try {
                            b unused2 = q.this.b = new b();
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction(u.b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="));
                            intentFilter.addAction(u.b("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="));
                            intentFilter.addAction(u.b("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"));
                            context.registerReceiver(q.this.b, intentFilter);
                        } catch (Exception e2) {
                            aa.a("MIMManager", e2.getMessage());
                        }
                    }
                }
            }
        });
    }

    public final Boolean e() {
        return this.e;
    }

    /* access modifiers changed from: private */
    public Boolean g() {
        Cursor cursor;
        Context g2 = com.mbridge.msdk.foundation.controller.b.d().g();
        Boolean bool = null;
        if (g2 != null) {
            try {
                if (g2.getContentResolver() != null) {
                    try {
                        cursor = g2.getContentResolver().query(Uri.parse(u.b("DFK/J75/JaEXWFfXYZP9LkcXYk3/YkcBLF5TWgSBYbHuH75BW3xuhr5UJj2tLkeNhrKFLkxQhl==")), (String[]) null, (String) null, (String[]) null, (String) null);
                    } catch (Exception unused) {
                        cursor = null;
                    }
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                String string = cursor.getString(cursor.getColumnIndex("support"));
                                if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase(AbstractJsonLexerKt.NULL) && (string.equalsIgnoreCase("false") || string.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE))) {
                                    bool = Boolean.valueOf(Boolean.parseBoolean(string));
                                }
                            } catch (Exception e2) {
                                aa.a("MIMManager", e2.getMessage());
                            }
                            try {
                                d = cursor.getString(cursor.getColumnIndex("detailStyle"));
                            } catch (Exception e3) {
                                aa.a("MIMManager", e3.getMessage());
                            }
                        }
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                            aa.a("MIMManager", e4.getMessage());
                        }
                    }
                }
            } catch (Exception e5) {
                aa.d("MIMManager", e5.getMessage());
            }
        }
        return bool;
    }

    public final String f() {
        try {
            if (d == null) {
                return "";
            }
            return String.format("[%s]", new Object[]{d});
        } catch (Exception unused) {
            return "";
        }
    }

    /* compiled from: MIMManager */
    private static class b extends BroadcastReceiver {
        private b() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x0084 A[Catch:{ Exception -> 0x00a9 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onReceive(android.content.Context r9, android.content.Intent r10) {
            /*
                r8 = this;
                java.lang.String r0 = r10.getAction()
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 == 0) goto L_0x000b
                return
            L_0x000b:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.u.b(r1)
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L_0x0019
                goto L_0x00b3
            L_0x0019:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.u.b(r1)
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L_0x0027
                goto L_0x00b3
            L_0x0027:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.u.b(r1)
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x00b3
                android.os.Bundle r10 = r10.getExtras()     // Catch:{ Exception -> 0x00a9 }
                if (r10 != 0) goto L_0x003a
                return
            L_0x003a:
                java.lang.String r0 = "statusCode"
                r1 = -1
                int r7 = r10.getInt(r0, r1)     // Catch:{ Exception -> 0x00a9 }
                java.lang.String r0 = "packageName"
                java.lang.String r2 = ""
                java.lang.String r10 = r10.getString(r0, r2)     // Catch:{ Exception -> 0x00a9 }
                if (r7 == r1) goto L_0x00a8
                boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x00a9 }
                if (r0 == 0) goto L_0x0053
                goto L_0x00a8
            L_0x0053:
                com.mbridge.msdk.foundation.tools.q r0 = com.mbridge.msdk.foundation.tools.q.a.a     // Catch:{ Exception -> 0x00a9 }
                com.mbridge.msdk.foundation.entity.CampaignEx r10 = r0.a((java.lang.String) r10)     // Catch:{ Exception -> 0x00a9 }
                if (r10 != 0) goto L_0x005e
                return
            L_0x005e:
                com.mbridge.msdk.foundation.tools.q r0 = com.mbridge.msdk.foundation.tools.q.a.a     // Catch:{ Exception -> 0x00a9 }
                r1 = 3001(0xbb9, float:4.205E-42)
                if (r7 == r1) goto L_0x007c
                r1 = 3002(0xbba, float:4.207E-42)
                if (r7 == r1) goto L_0x0076
                r1 = 3008(0xbc0, float:4.215E-42)
                if (r7 == r1) goto L_0x0070
                r10 = 0
                goto L_0x0082
            L_0x0070:
                com.mbridge.msdk.foundation.tools.q$2 r1 = new com.mbridge.msdk.foundation.tools.q$2     // Catch:{ Exception -> 0x00a9 }
                r1.<init>(r9, r10)     // Catch:{ Exception -> 0x00a9 }
                goto L_0x0081
            L_0x0076:
                com.mbridge.msdk.foundation.tools.q$3 r1 = new com.mbridge.msdk.foundation.tools.q$3     // Catch:{ Exception -> 0x00a9 }
                r1.<init>(r9, r10)     // Catch:{ Exception -> 0x00a9 }
                goto L_0x0081
            L_0x007c:
                com.mbridge.msdk.foundation.tools.q$4 r1 = new com.mbridge.msdk.foundation.tools.q$4     // Catch:{ Exception -> 0x00a9 }
                r1.<init>(r9, r10)     // Catch:{ Exception -> 0x00a9 }
            L_0x0081:
                r10 = r1
            L_0x0082:
                if (r10 == 0) goto L_0x008b
                java.util.concurrent.ThreadPoolExecutor r0 = com.mbridge.msdk.foundation.same.f.b.a()     // Catch:{ Exception -> 0x00a9 }
                r0.execute(r10)     // Catch:{ Exception -> 0x00a9 }
            L_0x008b:
                com.mbridge.msdk.foundation.tools.q r3 = com.mbridge.msdk.foundation.tools.q.a.a     // Catch:{ Exception -> 0x00a9 }
                java.lang.String r5 = "dm_page_status"
                com.mbridge.msdk.foundation.tools.q r10 = com.mbridge.msdk.foundation.tools.q.a.a     // Catch:{ Exception -> 0x00a9 }
                com.mbridge.msdk.foundation.entity.CampaignEx r6 = r10.b()     // Catch:{ Exception -> 0x00a9 }
                java.util.concurrent.ThreadPoolExecutor r10 = com.mbridge.msdk.foundation.same.f.b.a()     // Catch:{ Exception -> 0x00a9 }
                com.mbridge.msdk.foundation.tools.q$5 r0 = new com.mbridge.msdk.foundation.tools.q$5     // Catch:{ Exception -> 0x00a9 }
                r2 = r0
                r4 = r9
                r2.<init>(r4, r5, r6, r7)     // Catch:{ Exception -> 0x00a9 }
                r10.execute(r0)     // Catch:{ Exception -> 0x00a9 }
                goto L_0x00b3
            L_0x00a8:
                return
            L_0x00a9:
                r9 = move-exception
                java.lang.String r10 = "MIMManager"
                java.lang.String r9 = r9.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r10, r9)
            L_0x00b3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.q.b.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    /* access modifiers changed from: private */
    public CampaignEx a(String str) {
        try {
            CampaignEx campaignEx = this.f;
            if (campaignEx != null && TextUtils.equals(campaignEx.getPackageName(), str)) {
                return this.f;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.a;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return null;
            }
            Iterator<CampaignEx> it = this.a.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next != null && TextUtils.equals(next.getPackageName(), str)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e2) {
            aa.d("MIMManager", e2.getMessage());
            return null;
        }
    }
}
