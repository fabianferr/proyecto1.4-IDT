package com.mbridge.msdk.foundation.c.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.FeedbackRadioGroup;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: FeedBackBtnBean */
public final class a {
    /* access modifiers changed from: private */
    public static String B = null;
    private static int u = -1;
    private com.mbridge.msdk.widget.dialog.a A = new com.mbridge.msdk.widget.dialog.a() {
        public final void a() {
            a.a(a.this);
        }

        public final void b() {
            a.b(a.this);
        }

        public final void c() {
            a.c(a.this);
        }
    };
    private String a;
    private CampaignEx b;
    private FeedBackButton c;
    private int d;
    private int e;
    private String f = "";
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private float k = -1.0f;
    private JSONArray l;
    private int m = -1;
    private int n = -1;
    private int o = -1;
    private int p = -1;
    private String q;
    private String r;
    private float s = 1.0f;
    private int t = af.b(b.d().g(), 20.0f);
    private int v = u;
    /* access modifiers changed from: private */
    public MBFeedBackDialog w;
    private List<C0136a> x = new ArrayList();
    private String y = "";
    /* access modifiers changed from: private */
    public Dialog z;

    public a(String str) {
        this.a = str;
        if (this.x == null) {
            this.x = new ArrayList();
        }
        i();
        l();
        j();
    }

    private void i() {
        if (this.A == null) {
            this.A = new com.mbridge.msdk.widget.dialog.a() {
                public final void b() {
                    a.b(a.this);
                }

                public final void c() {
                    a.c(a.this);
                }

                public final void a() {
                    a.a(a.this);
                }
            };
        }
    }

    public final void a() {
        try {
            com.mbridge.msdk.foundation.c.b.a().a(this.a, 0, 1, B, this.f);
            Activity a2 = com.mbridge.msdk.foundation.c.b.a().a(b.d().g());
            MBFeedBackDialog mBFeedBackDialog = this.w;
            if (mBFeedBackDialog == null || mBFeedBackDialog.getContext() != a2) {
                j();
            }
            Context g2 = b.d().g();
            FeedBackButton feedBackButton = this.c;
            if (feedBackButton != null) {
                g2 = feedBackButton.getContext();
            }
            boolean a3 = com.mbridge.msdk.foundation.c.b.a().a(this.a, g2, this.w);
            int i2 = a3 ? 2 : 3;
            if (i2 == 2) {
                com.mbridge.msdk.foundation.c.b.a().a(this.a, 0, 2, B, this.f);
            } else {
                com.mbridge.msdk.foundation.c.b.a().a(this.a, 0, 3, B, this.f);
            }
            List<C0136a> list = this.x;
            if (list != null) {
                for (C0136a next : list) {
                    if (next != null) {
                        next.a(i2);
                    }
                }
            }
            if (!a3) {
                a(g2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b() {
        MBFeedBackDialog mBFeedBackDialog = this.w;
        if (mBFeedBackDialog != null && mBFeedBackDialog.isShowing()) {
            this.w.cancel();
        }
    }

    private void j() {
        try {
            if (com.mbridge.msdk.foundation.c.b.a().a(b.d().g()) != null) {
                e b2 = f.a().b(b.d().h());
                if (b2 == null) {
                    b2 = f.a().b();
                }
                e.b au = b2.au();
                if (au == null) {
                    aa.b("", "feedback fbk is null");
                    return;
                }
                i();
                this.w = new MBFeedBackDialog(com.mbridge.msdk.foundation.c.b.a().a(b.d().g()), this.A);
                FeedbackRadioGroup a2 = a(au);
                this.w.setCancelText(au.c());
                this.w.setConfirmText(au.b());
                this.w.setPrivacyText(au.e());
                this.y = au.d();
                this.w.setTitle(au.a());
                this.w.setContent(a2);
                this.w.setCancelButtonClickable(!TextUtils.isEmpty(B));
                a(a2, au);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(int i2) {
        this.v = i2;
        FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(i2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.mbridge.msdk.widget.FeedbackRadioGroup r11, com.mbridge.msdk.c.e.b r12) {
        /*
            r10 = this;
            org.json.JSONArray r12 = r12.f()
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()
            android.content.Context r0 = r0.g()
            if (r12 == 0) goto L_0x0084
            int r1 = r12.length()
            if (r1 <= 0) goto L_0x0084
            if (r0 == 0) goto L_0x0084
            java.lang.String r1 = "mbridge_cm_feedback_choice_btn_bg"
            java.lang.String r2 = "drawable"
            com.mbridge.msdk.foundation.tools.t.a(r0, r1, r2)
            android.content.res.Resources r1 = com.mbridge.msdk.foundation.tools.t.a(r0)
            java.lang.String r2 = "mbridge_cm_feedback_rb_text_color_color_list"
            java.lang.String r3 = "color"
            int r2 = com.mbridge.msdk.foundation.tools.t.a(r0, r2, r3)
            if (r1 == 0) goto L_0x0034
            android.content.res.ColorStateList r1 = r1.getColorStateList(r2)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0035
        L_0x0030:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0034:
            r1 = 0
        L_0x0035:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r0, (float) r2)
            int r4 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r0, (float) r2)
            int r2 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r0, (float) r2)
            r5 = 0
        L_0x0044:
            int r6 = r12.length()
            if (r5 >= r6) goto L_0x0084
            java.lang.String r6 = r12.optString(r5)
            android.widget.RadioButton r7 = new android.widget.RadioButton
            r7.<init>(r0)
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 21
            if (r8 < r9) goto L_0x005c
            r7.setButtonTintList(r1)
        L_0x005c:
            r7.setText(r6)
            if (r1 == 0) goto L_0x0064
            r7.setTextColor(r1)
        L_0x0064:
            r7.setCompoundDrawablePadding(r3)
            r7.setPadding(r3, r4, r3, r4)
            android.text.TextUtils$TruncateAt r6 = android.text.TextUtils.TruncateAt.END
            r7.setEllipsize(r6)
            android.widget.RadioGroup$LayoutParams r6 = new android.widget.RadioGroup$LayoutParams
            r8 = -1
            r9 = -2
            r6.<init>(r8, r9)
            int r8 = r2 / 4
            r6.setMargins(r2, r8, r2, r8)
            r10.a((android.widget.RadioButton) r7)
            r11.addView(r7, r6)
            int r5 = r5 + 1
            goto L_0x0044
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.c.a.a.a(com.mbridge.msdk.widget.FeedbackRadioGroup, com.mbridge.msdk.c.e$b):void");
    }

    private FeedbackRadioGroup a(e.b bVar) {
        JSONArray f2 = bVar.f();
        Context g2 = b.d().g();
        if (f2 == null || f2.length() <= 0 || g2 == null) {
            return null;
        }
        FeedbackRadioGroup feedbackRadioGroup = new FeedbackRadioGroup(g2);
        feedbackRadioGroup.setOrientation(0);
        return feedbackRadioGroup;
    }

    private void a(RadioButton radioButton) {
        if (radioButton != null) {
            radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        String unused = a.B = (String) compoundButton.getText();
                    }
                    if (a.this.w != null) {
                        a.this.w.setCancelButtonClickable(!TextUtils.isEmpty(a.B));
                    }
                }
            });
        }
    }

    public final void a(C0136a aVar) {
        if (this.x == null) {
            this.x = new ArrayList();
        }
        this.x.add(aVar);
    }

    private void a(Context context) {
        if (context != null) {
            try {
                com.mbridge.msdk.click.b.b(context, af.c(this.b));
            } catch (Exception unused) {
                com.mbridge.msdk.click.b.a(context, af.c(this.b));
            }
        }
    }

    private void k() {
        FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            int i2 = this.g;
            if (i2 > -1) {
                feedBackButton.setX((float) i2);
            }
            int i3 = this.h;
            if (i3 > -1) {
                this.c.setY((float) i3);
            }
            float f2 = this.s;
            if (f2 >= 0.0f) {
                this.c.setAlpha(f2);
                this.c.setEnabled(this.s != 0.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            int i4 = this.i;
            if (i4 > 0) {
                this.c.setWidth(i4);
                if (layoutParams != null) {
                    layoutParams.width = this.i;
                }
            }
            int i5 = this.j;
            if (i5 > 0) {
                this.c.setHeight(i5);
                if (layoutParams != null) {
                    layoutParams.height = this.j;
                }
            }
            if (layoutParams != null) {
                this.c.setLayoutParams(layoutParams);
            }
            try {
                if (!TextUtils.isEmpty(this.q)) {
                    this.c.setTextColor(Color.parseColor(this.q));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            float f3 = this.k;
            if (f3 > 0.0f) {
                this.c.setTextSize(f3);
            }
            JSONArray jSONArray = this.l;
            if (jSONArray != null && jSONArray.length() == 4) {
                Context g2 = b.d().g();
                this.c.setPadding(af.b(g2, (float) this.l.optDouble(0)), af.b(g2, (float) this.l.optDouble(1)), af.b(g2, (float) this.l.optDouble(2)), af.b(g2, (float) this.l.optDouble(3)));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i6 = this.t;
            if (i6 > 0) {
                gradientDrawable.setCornerRadius((float) i6);
            }
            if (!TextUtils.isEmpty(this.r)) {
                gradientDrawable.setColor(Color.parseColor(this.r));
            } else {
                gradientDrawable.setColor(Color.parseColor(FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
            }
            this.c.setBackground(gradientDrawable);
        }
    }

    public final void a(int i2, int i3, int i4, int i5, int i6, float f2, String str, String str2, float f3, JSONArray jSONArray) {
        if (i2 > -1) {
            this.g = i2;
        }
        if (i3 > -1) {
            this.h = i3;
        }
        if (i4 > -1) {
            this.i = i4;
        }
        if (i5 > -1) {
            this.j = i5;
        }
        if (f3 > -1.0f) {
            this.k = f3;
        }
        if (jSONArray != null) {
            this.l = jSONArray;
        }
        this.q = str;
        this.r = str2;
        this.s = f2;
        this.t = i6;
        k();
    }

    private void l() {
        Context g2 = b.d().g();
        if (g2 != null) {
            try {
                FeedBackButton feedBackButton = new FeedBackButton(g2);
                this.c = feedBackButton;
                int i2 = 8;
                if (this.v != 8) {
                    i2 = 0;
                }
                feedBackButton.setVisibility(i2);
                this.c.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        a.this.a();
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final FeedBackButton c() {
        if (this.c == null) {
            l();
        }
        return this.c;
    }

    public final void d() {
        FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            feedBackButton.setOnClickListener((View.OnClickListener) null);
            this.c.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.c.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.c);
            }
        }
        MBFeedBackDialog mBFeedBackDialog = this.w;
        if (mBFeedBackDialog != null) {
            mBFeedBackDialog.cancel();
            this.w.setListener((com.mbridge.msdk.widget.dialog.a) null);
        }
        this.w = null;
        this.x = null;
        this.c = null;
        this.A = null;
    }

    public final CampaignEx e() {
        return this.b;
    }

    public final void a(CampaignEx campaignEx) {
        this.b = campaignEx;
    }

    public final int f() {
        return this.d;
    }

    public final void b(int i2) {
        this.d = i2;
    }

    public final int g() {
        return this.e;
    }

    public final void c(int i2) {
        this.e = i2;
    }

    public final void a(String str) {
        this.f = str;
    }

    /* renamed from: com.mbridge.msdk.foundation.c.a.a$a  reason: collision with other inner class name */
    /* compiled from: FeedBackBtnBean */
    public static class C0136a implements com.mbridge.msdk.widget.dialog.a {
        private com.mbridge.msdk.foundation.c.a a;
        private String b;

        public C0136a(String str, com.mbridge.msdk.foundation.c.a aVar) {
            this.a = aVar;
            this.b = str;
        }

        public final void a() {
            com.mbridge.msdk.foundation.c.a aVar = this.a;
            if (aVar != null) {
                aVar.b();
            }
        }

        public final void b() {
            com.mbridge.msdk.foundation.c.b.c = false;
            com.mbridge.msdk.foundation.c.a aVar = this.a;
            if (aVar != null) {
                aVar.a(a.B);
            }
        }

        public final void c() {
            com.mbridge.msdk.foundation.c.b.c = false;
            com.mbridge.msdk.foundation.c.a aVar = this.a;
            if (aVar != null) {
                aVar.b();
            }
        }

        public final void a(int i) {
            com.mbridge.msdk.foundation.c.b.c = true;
            com.mbridge.msdk.foundation.c.a aVar = this.a;
            if (aVar != null && i == 2) {
                aVar.a();
            }
        }
    }

    public final void a(FeedBackButton feedBackButton) {
        FeedBackButton feedBackButton2 = this.c;
        int i2 = 8;
        if (feedBackButton2 != null) {
            feedBackButton2.setVisibility(8);
        }
        if (feedBackButton != null) {
            feedBackButton.setAlpha(this.s);
            feedBackButton.setEnabled(this.s != 0.0f);
            if (this.v != 8) {
                i2 = 0;
            }
            feedBackButton.setVisibility(i2);
            this.c = feedBackButton;
            CampaignEx campaignEx = this.b;
            if (campaignEx != null && !campaignEx.isDynamicView()) {
                k();
            }
            feedBackButton.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.a();
                }
            });
        }
    }

    static /* synthetic */ void a(a aVar) {
        com.mbridge.msdk.foundation.c.b.a().a(aVar.a, 0, 4, B, aVar.f);
        Context c2 = b.d().c();
        if (c2 == null) {
            c2 = b.d().g();
        }
        List<C0136a> list = aVar.x;
        if (list != null) {
            for (C0136a next : list) {
                if (next != null) {
                    next.c();
                }
            }
        }
        aVar.a(c2);
        B = "";
    }

    static /* synthetic */ void b(a aVar) {
        com.mbridge.msdk.foundation.c.b.a().a(aVar.a, 1, 4, B, aVar.f);
        List<C0136a> list = aVar.x;
        if (list != null) {
            for (C0136a next : list) {
                if (next != null) {
                    next.b();
                }
            }
        }
        if (!TextUtils.isEmpty(aVar.y)) {
            try {
                Activity a2 = com.mbridge.msdk.foundation.c.b.a().a(b.d().g());
                if (a2 != null) {
                    View inflate = LayoutInflater.from(a2).inflate(t.a(a2, "mbridge_cm_feedback_notice_layout", "layout"), (ViewGroup) null);
                    Dialog dialog = new Dialog(a2, 3);
                    aVar.z = dialog;
                    dialog.requestWindowFeature(1);
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                    Window window = aVar.z.getWindow();
                    layoutParams.copyFrom(window.getAttributes());
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    aVar.z.setContentView(inflate);
                    aVar.z.show();
                    window.setAttributes(layoutParams);
                    inflate.postDelayed(new Runnable() {
                        public final void run() {
                            try {
                                if (a.this.z != null && a.this.z.isShowing()) {
                                    a.this.z.dismiss();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 2000);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        B = "";
    }

    static /* synthetic */ void c(a aVar) {
        com.mbridge.msdk.foundation.c.b.a().a(aVar.a, 0, 4, B, aVar.f);
        List<C0136a> list = aVar.x;
        if (list != null) {
            for (C0136a next : list) {
                if (next != null) {
                    next.c();
                }
            }
        }
        B = "";
    }
}
