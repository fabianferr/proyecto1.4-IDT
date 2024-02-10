package com.mbridge.msdk.foundation.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.c.a.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* compiled from: FeedbackManager */
public final class b {
    public static int a = -2;
    public static int b = -2;
    public static volatile boolean c = false;
    private final ConcurrentHashMap<String, com.mbridge.msdk.foundation.c.a.a> d;
    private final RelativeLayout.LayoutParams e;
    private e f;

    /* compiled from: FeedbackManager */
    static class a {
        /* access modifiers changed from: private */
        public static final b a = new b();
    }

    private b() {
        this.d = new ConcurrentHashMap<>();
        this.e = new RelativeLayout.LayoutParams(a, b);
    }

    public static b a() {
        return a.a;
    }

    public final Activity a(Context context) {
        Activity activity;
        Context c2 = com.mbridge.msdk.foundation.controller.b.d().c();
        Activity activity2 = null;
        try {
            Activity activity3 = c2 instanceof Activity ? (Activity) c2 : null;
            try {
                if ((context instanceof Activity) && !((Activity) context).isDestroyed()) {
                    activity3 = (Activity) context;
                }
                WeakReference<Activity> a2 = com.mbridge.msdk.foundation.controller.b.d().a();
                if (a2 != null && (activity = (Activity) a2.get()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    activity3 = activity;
                }
                if (activity3 == null || activity3.isFinishing() || activity3.isDestroyed()) {
                    return null;
                }
                return activity3;
            } catch (Exception e2) {
                e = e2;
                activity2 = activity3;
                e.printStackTrace();
                return activity2;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return activity2;
        }
    }

    private boolean a(Context context, MBFeedBackDialog mBFeedBackDialog) {
        Activity a2 = a(context);
        if (a2 == null || mBFeedBackDialog == null || a2.isDestroyed()) {
            return false;
        }
        try {
            if (mBFeedBackDialog.isShowing() || a2.isFinishing()) {
                return false;
            }
            mBFeedBackDialog.show();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean a(String str, Context context, MBFeedBackDialog mBFeedBackDialog) {
        if (mBFeedBackDialog != null) {
            return a(context, mBFeedBackDialog);
        }
        aa.b("", "mbAlertDialog  is null");
        return false;
    }

    public final void a(String str, int i, ViewGroup viewGroup) {
        com.mbridge.msdk.foundation.c.a.a a2 = a(str);
        if (a2.c() != null) {
            a2.a(i);
            if (i == 0) {
                a(str, com.mbridge.msdk.foundation.controller.b.d().g(), viewGroup, (ViewGroup.LayoutParams) null, (a) null);
            }
        }
    }

    public final void a(String str, int i, int i2, int i3, float f2, float f3, float f4, String str2, String str3, float f5, JSONArray jSONArray) {
        com.mbridge.msdk.foundation.c.a.a a2 = a(str);
        Context g = com.mbridge.msdk.foundation.controller.b.d().g();
        a2.a(af.b(g, f2), af.b(g, f3), af.b(g, (float) i), af.b(g, (float) i2), af.b(g, (float) i3), f4, str2, str3, f5, jSONArray);
    }

    public final boolean b() {
        e b2 = f.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        this.f = b2;
        if (b2 != null) {
            return false;
        }
        this.f = f.a().b();
        return false;
    }

    public final void a(String str, a aVar) {
        com.mbridge.msdk.foundation.c.a.a a2 = a(str);
        if (aVar != null) {
            a2.a(new a.C0136a(str, aVar));
        }
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r3, android.content.Context r4, android.view.ViewGroup r5, android.view.ViewGroup.LayoutParams r6, com.mbridge.msdk.foundation.c.a r7) {
        /*
            r2 = this;
            boolean r0 = r2.b()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            com.mbridge.msdk.foundation.c.a.a r0 = r2.a((java.lang.String) r3)
            if (r7 == 0) goto L_0x0015
            com.mbridge.msdk.foundation.c.a.a$a r1 = new com.mbridge.msdk.foundation.c.a.a$a
            r1.<init>(r3, r7)
            r0.a((com.mbridge.msdk.foundation.c.a.a.C0136a) r1)
        L_0x0015:
            com.mbridge.msdk.widget.FeedBackButton r3 = r0.c()
            if (r3 == 0) goto L_0x0057
            if (r6 != 0) goto L_0x0032
            com.mbridge.msdk.foundation.controller.b r6 = com.mbridge.msdk.foundation.controller.b.d()
            android.content.Context r6 = r6.g()
            r7 = 1092616192(0x41200000, float:10.0)
            int r6 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r6, (float) r7)
            android.widget.RelativeLayout$LayoutParams r7 = r2.e
            r7.setMargins(r6, r6, r6, r6)
            android.widget.RelativeLayout$LayoutParams r6 = r2.e
        L_0x0032:
            android.view.ViewParent r7 = r3.getParent()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            if (r7 == 0) goto L_0x003d
            r7.removeView(r3)
        L_0x003d:
            android.app.Activity r4 = r2.a((android.content.Context) r4)
            if (r4 == 0) goto L_0x004f
            if (r5 != 0) goto L_0x004f
            r5 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r4 = r4.findViewById(r5)
            r5 = r4
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
        L_0x004f:
            if (r5 == 0) goto L_0x0057
            r5.removeView(r3)
            r5.addView(r3, r6)
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.c.b.a(java.lang.String, android.content.Context, android.view.ViewGroup, android.view.ViewGroup$LayoutParams, com.mbridge.msdk.foundation.c.a):void");
    }

    public final void a(String str, int i, a aVar) {
        com.mbridge.msdk.foundation.c.a.a a2 = a(str);
        a2.a(new a.C0136a(str, aVar));
        if (i == 1) {
            a2.b();
        } else {
            a2.a();
        }
    }

    public final void a(String str, CampaignEx campaignEx) {
        a(str).a(campaignEx);
    }

    public final void a(String str, int i) {
        a(str).b(i);
    }

    public final void b(String str, int i) {
        a(str).c(i);
    }

    public final void a(String str, String str2) {
        a(str).a(str2);
    }

    public final com.mbridge.msdk.foundation.c.a.a a(String str) {
        com.mbridge.msdk.foundation.c.a.a aVar;
        if (TextUtils.isEmpty(str)) {
            str = com.mbridge.msdk.foundation.controller.b.d().h();
        }
        if (!this.d.containsKey(str)) {
            aVar = new com.mbridge.msdk.foundation.c.a.a(str);
            this.d.put(str, aVar);
        } else {
            aVar = this.d.get(str);
        }
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.foundation.c.a.a aVar2 = new com.mbridge.msdk.foundation.c.a.a(str);
        this.d.put(str, aVar2);
        return aVar2;
    }

    private com.mbridge.msdk.foundation.c.a.a d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = com.mbridge.msdk.foundation.controller.b.d().h();
        }
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        return null;
    }

    public final void a(String str, FeedBackButton feedBackButton) {
        a(str).a(feedBackButton);
    }

    public final FeedBackButton b(String str) {
        return a(str).c();
    }

    public final void a(String str, int i, int i2, String str2, String str3) {
        String str4;
        String str5;
        String str6 = str;
        com.mbridge.msdk.foundation.c.a.a d2 = d(str + "_1");
        if (d2 == null) {
            d2 = d(str + "_2");
            if (d2 == null) {
                d2 = d(str + "_3");
                if (d2 == null) {
                    d2 = d(str + "_4");
                    if (d2 == null) {
                        d2 = a(str);
                    }
                }
            }
            d2.b(0);
        }
        if (d2 != null) {
            CampaignEx e2 = d2.e();
            if (e2 != null) {
                str4 = e2.getCampaignUnitId();
            } else {
                str4 = "";
            }
            int f2 = d2.f();
            int g = d2.g();
            if (!TextUtils.isEmpty(str2)) {
                str5 = str2;
            } else {
                str5 = "";
            }
            q.a(e2, str4, f2, g, str5, i, e2 != null ? e2.getAdType() : 0, i2, str3);
        }
    }

    public final void c(String str) {
        try {
            com.mbridge.msdk.foundation.c.a.a d2 = d(str);
            if (d2 != null) {
                d2.d();
            }
            this.d.remove(str);
            c = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
