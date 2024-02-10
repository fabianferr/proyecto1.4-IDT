package com.bytedance.sdk.openadsdk.component.reward.view;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.component.reward.a.a;
import com.bytedance.sdk.openadsdk.core.b.e;
import com.bytedance.sdk.openadsdk.core.b.g;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.f.b;
import com.bytedance.sdk.openadsdk.f.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.security.CertificateUtil;
import java.util.Locale;
import org.json.JSONObject;

public class RFDownloadBarLayout extends PAGRelativeLayout {
    private TTRatingBar2 a;
    private TextView b;
    /* access modifiers changed from: private */
    public TextView c;
    /* access modifiers changed from: private */
    public TTRoundRectImageView d;
    private TextView e;
    private boolean f;
    /* access modifiers changed from: private */
    public a g;
    private TextView h;

    private void d() {
    }

    public RFDownloadBarLayout(Context context) {
        super(context);
        setVisibility(8);
    }

    private static TTRoundRectImageView a(Context context) {
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        tTRoundRectImageView.setBackgroundColor(0);
        tTRoundRectImageView.setId(i.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ad.b(context, 69.0f), ad.b(context, 69.0f));
        layoutParams.addRule(20);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        tTRoundRectImageView.setLayoutParams(layoutParams);
        return tTRoundRectImageView;
    }

    private static TextView b(Context context) {
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setGravity(16);
        pAGTextView.setSingleLine(true);
        pAGTextView.setTextColor(-1);
        pAGTextView.setTextSize(2, 17.0f);
        pAGTextView.setId(i.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ad.b(context, 27.0f));
        layoutParams.leftMargin = ad.b(context, 14.0f);
        pAGTextView.setLayoutParams(layoutParams);
        return pAGTextView;
    }

    private static TTRatingBar2 a(Context context, int i) {
        TTRatingBar2 tTRatingBar2 = new TTRatingBar2(context);
        tTRatingBar2.setId(i.e);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ad.b(context, 14.0f));
        layoutParams.gravity = i;
        tTRatingBar2.setLayoutParams(layoutParams);
        return tTRatingBar2;
    }

    private static TextView c(Context context) {
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setSingleLine(true);
        pAGTextView.setTextColor(-1);
        pAGTextView.setTextSize(2, 13.0f);
        pAGTextView.setId(i.d);
        pAGTextView.setMaxWidth(ad.b(context, 72.0f));
        pAGTextView.setText(s.b(context, "tt_comment_num"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ad.b(context, 10.0f);
        pAGTextView.setLayoutParams(layoutParams);
        return pAGTextView;
    }

    private static TextView d(Context context) {
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setGravity(17);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setLines(1);
        pAGTextView.setTextColor(-1);
        pAGTextView.setTextSize(2, 14.0f);
        pAGTextView.setBackgroundResource(s.d(context, "tt_reward_video_download_btn_bg"));
        pAGTextView.setId(520093705);
        pAGTextView.setPadding(ad.b(context, 10.0f), 0, ad.b(context, 10.0f), 0);
        pAGTextView.setText(s.b(context, "tt_video_mobile_go_detail"));
        return pAGTextView;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0 && !this.f) {
            c();
        }
    }

    private void c() {
        TextView textView;
        this.f = true;
        Context context = getContext();
        int B = this.g.a.B();
        if (B == 1) {
            e();
        } else if (B == 3) {
            g();
        } else if (B != 5) {
            h();
        } else {
            f();
        }
        d();
        if (this.c == null) {
            this.c = (TextView) this.g.V.findViewById(520093705);
        }
        final q qVar = this.g.a;
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    int width = ((ViewGroup) RFDownloadBarLayout.this.c.getParent()).getWidth();
                    if (width > 0) {
                        RFDownloadBarLayout.this.c.setMaxWidth((int) (((float) width) * 0.45f));
                    }
                }
            });
            if (!qVar.at()) {
                this.c.setText(qVar.B() == 3 ? getButtonTextForNewStyleBar() : qVar.X());
            } else if (qVar.au() != null && TextUtils.isEmpty(qVar.au().f())) {
                ad.a((View) this.c, 8);
            }
        }
        if (!(this.d == null || qVar.N() == null || TextUtils.isEmpty(qVar.N().a()))) {
            final String a2 = qVar.N().a();
            if (qVar.at()) {
                d.a(qVar.N()).a(u.BITMAP).a((o) new b(qVar, qVar.N().a(), new o<Bitmap>() {
                    public void a(k<Bitmap> kVar) {
                        if (kVar != null && kVar.b() != null) {
                            if (RFDownloadBarLayout.this.d != null) {
                                RFDownloadBarLayout.this.d.setImageBitmap(kVar.b());
                            }
                            c.b(qVar, RFDownloadBarLayout.this.g.g, "load_vast_icon_success", (JSONObject) null);
                        }
                    }

                    public void a(int i, String str, Throwable th) {
                        RFDownloadBarLayout.this.a(i, str, a2);
                    }
                }));
                if (!(qVar.au() == null || qVar.au().b() == null)) {
                    qVar.au().b().b(0);
                }
            } else {
                com.bytedance.sdk.openadsdk.k.c.a().a(qVar.N(), (ImageView) this.d, qVar);
            }
        }
        if (this.e != null) {
            if (this.g.j != 1 || qVar.aa() == null || TextUtils.isEmpty(qVar.aa().b())) {
                this.e.setText(qVar.V());
            } else {
                this.e.setText(qVar.aa().b());
            }
        }
        TextView textView3 = this.b;
        if (textView3 != null) {
            ad.a(textView3, qVar, this.g.W, "tt_comment_num");
        }
        if (this.g.j == 1) {
            TextView textView4 = this.e;
            if (textView4 != null) {
                textView4.setMaxWidth(ad.b(context, 153.0f));
            }
        } else {
            TextView textView5 = this.e;
            if (textView5 != null) {
                textView5.setMaxWidth(ad.b(context, 404.0f));
            }
        }
        TTRatingBar2 tTRatingBar2 = this.a;
        if (tTRatingBar2 != null) {
            ad.a((TextView) null, tTRatingBar2, qVar);
        }
        if (qVar.at() && (textView = this.h) != null) {
            textView.setText(qVar.W());
        }
        if (this.g.j == 2 && qVar.B() == 1) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.height = ad.b(this.g.W, 55.0f);
            layoutParams.topMargin = ad.b(this.g.W, 20.0f);
            this.c.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams2.bottomMargin = ad.b(this.g.W, 12.0f);
            setLayoutParams(layoutParams2);
        }
        b();
    }

    public void a() {
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe ofFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("scaleX", new Keyframe[]{ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6}), PropertyValuesHolder.ofKeyframe("scaleY", new Keyframe[]{ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6})});
        ofPropertyValuesHolder.setDuration(1000);
        ofPropertyValuesHolder.start();
    }

    public void a(a aVar) {
        this.g = aVar;
        if (aVar.a.B() == 1) {
            c();
        }
    }

    /* access modifiers changed from: protected */
    public String getButtonTextForNewStyleBar() {
        boolean z;
        String str;
        String g2 = ac.g(this.g.W);
        if (g2 == null) {
            g2 = "";
        }
        try {
            z = g2.equals(Locale.ENGLISH.getLanguage());
        } catch (Throwable unused) {
            z = false;
        }
        if (TextUtils.isEmpty(this.g.a.X())) {
            str = this.g.a.M() != 4 ? "View" : "Install";
        } else {
            str = this.g.a.X();
            if (str == null || !ac.f(str) || str.length() <= 2) {
                if (str != null && !ac.f(str) && str.length() > 7 && z) {
                    str = getCnOrEnBtnText();
                }
            } else if (z) {
                str = getCnOrEnBtnText();
            }
        }
        if (z && !ac.f(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.bottomMargin = ad.b(this.g.W, 4.0f);
            this.c.setLayoutParams(layoutParams);
        }
        return str;
    }

    private String getCnOrEnBtnText() {
        return this.g.a.M() != 4 ? "View" : "Install";
    }

    /* access modifiers changed from: private */
    public void a(int i, String str, String str2) {
        final int i2 = i;
        final String str3 = str;
        final String str4 = str2;
        c.a((h) new h("load_vast_icon_fail") {
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i2);
                    jSONObject.put("description", i2 + CertificateUtil.DELIMITER + str3);
                    jSONObject.put("url", str4);
                } catch (Throwable unused) {
                }
                c.b(RFDownloadBarLayout.this.g.a, RFDownloadBarLayout.this.g.g, "load_vast_icon_fail", jSONObject);
            }
        });
    }

    public void b() {
        e e2 = this.g.L.e();
        final View.OnClickListener d2 = this.g.L.d();
        final q qVar = this.g.a;
        if (qVar.C() != null) {
            if (!(qVar.B() == 5 || this.c == null)) {
                if (qVar.C().e) {
                    this.c.setOnClickListener(e2);
                    this.c.setOnTouchListener(e2);
                } else {
                    this.c.setOnClickListener(d2);
                }
            }
            if (qVar.B() == 1) {
                if (qVar.C().a) {
                    ad.a((View) this, (View.OnClickListener) e2, "TTBaseVideoActivity#mRlDownloadBar");
                    ad.a((View) this, (View.OnTouchListener) e2, "TTBaseVideoActivity#mRlDownloadBar");
                    this.e.setOnClickListener(e2);
                    this.e.setOnTouchListener(e2);
                    this.b.setOnClickListener(e2);
                    this.b.setOnTouchListener(e2);
                    this.a.setOnClickListener(e2);
                    this.a.setOnTouchListener(e2);
                    this.d.setOnClickListener(e2);
                    this.d.setOnTouchListener(e2);
                    return;
                }
                ad.a((View) this, d2, "TTBaseVideoActivity#mRlDownloadBar");
                this.e.setOnClickListener(d2);
                this.b.setOnClickListener(d2);
                this.a.setOnClickListener(d2);
                this.d.setOnClickListener(d2);
            } else if (qVar.B() == 5) {
                if (qVar.C().e) {
                    AnonymousClass4 r1 = new g("VAST_ACTION_BUTTON", qVar.au(), e2) {
                        public void a() {
                        }
                    };
                    AnonymousClass5 r3 = new g("VAST_ICON", qVar.au(), e2) {
                        public void a() {
                        }
                    };
                    TextView textView = this.c;
                    if (textView != null) {
                        textView.setOnClickListener(r1);
                        this.c.setOnTouchListener(r1);
                    }
                    TTRoundRectImageView tTRoundRectImageView = this.d;
                    if (tTRoundRectImageView != null) {
                        tTRoundRectImageView.setOnClickListener(r3);
                        this.d.setOnTouchListener(r3);
                    }
                    TextView textView2 = this.e;
                    if (textView2 != null && !TextUtils.isEmpty(textView2.getText())) {
                        this.e.setOnClickListener(r1);
                        this.e.setOnTouchListener(r1);
                    }
                    TextView textView3 = this.h;
                    if (textView3 != null && !TextUtils.isEmpty(textView3.getText())) {
                        this.h.setOnClickListener(r1);
                        this.h.setOnTouchListener(r1);
                        return;
                    }
                    return;
                }
                AnonymousClass6 r0 = new View.OnClickListener() {
                    public void onClick(View view) {
                        View.OnClickListener onClickListener = d2;
                        if (onClickListener != null) {
                            onClickListener.onClick(view);
                        }
                        if (view == null || !"VAST_ICON".equals(view.getTag(570425345))) {
                            if (qVar.au() != null) {
                                qVar.au().a().g(RFDownloadBarLayout.this.g.G.g());
                            }
                        } else if (qVar.au() != null && qVar.au().b() != null) {
                            qVar.au().b().a(RFDownloadBarLayout.this.g.G.g());
                        }
                    }
                };
                TextView textView4 = this.c;
                if (textView4 != null) {
                    textView4.setOnClickListener(r0);
                }
                TextView textView5 = this.e;
                if (textView5 != null && !TextUtils.isEmpty(textView5.getText())) {
                    this.e.setOnClickListener(r0);
                }
                TextView textView6 = this.h;
                if (textView6 != null && !TextUtils.isEmpty(textView6.getText())) {
                    this.h.setOnClickListener(r0);
                }
                TTRoundRectImageView tTRoundRectImageView2 = this.d;
                if (tTRoundRectImageView2 != null) {
                    tTRoundRectImageView2.setTag(570425345, "VAST_ICON");
                    this.d.setOnClickListener(d2);
                }
            } else if (qVar.C().c) {
                ad.a((View) this, (View.OnClickListener) e2, "TTBaseVideoActivity#mRlDownloadBar");
                ad.a((View) this, (View.OnTouchListener) e2, "TTBaseVideoActivity#mRlDownloadBar");
            } else {
                ad.a((View) this, d2, "TTBaseVideoActivity#mRlDownloadBar");
            }
        }
    }

    private void e() {
        Context context = getContext();
        TTRoundRectImageView a2 = a(context);
        this.d = a2;
        addView(a2);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(1, i.b);
        layoutParams.addRule(17, i.b);
        addView(pAGLinearLayout, layoutParams);
        TextView b2 = b(context);
        this.e = b2;
        b2.setMaxWidth(ad.b(context, 176.0f));
        pAGLinearLayout.addView(this.e);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        pAGLinearLayout2.setGravity(16);
        pAGLinearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = ad.b(context, 14.0f);
        layoutParams2.topMargin = ad.b(context, 10.0f);
        pAGLinearLayout.addView(pAGLinearLayout2, layoutParams2);
        TTRatingBar2 a3 = a(context, 17);
        this.a = a3;
        pAGLinearLayout2.addView(a3);
        TextView c2 = c(context);
        this.b = c2;
        pAGLinearLayout2.addView(c2);
    }

    private void f() {
        Context context = getContext();
        TTRoundRectImageView a2 = a(context);
        this.d = a2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a2.getLayoutParams();
        int b2 = ad.b(context, 52.0f);
        layoutParams.height = b2;
        layoutParams.width = b2;
        addView(this.d);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setGravity(17);
        pAGLinearLayout.setId(i.f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ad.b(context, 100.0f), ad.b(context, 45.0f));
        layoutParams2.addRule(11);
        layoutParams2.addRule(21);
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = ad.b(context, 15.0f);
        addView(pAGLinearLayout, layoutParams2);
        this.c = d(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, ad.b(context, 41.0f));
        layoutParams3.bottomMargin = ad.b(context, 3.0f);
        pAGLinearLayout.addView(this.c, layoutParams3);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        pAGLinearLayout2.setGravity(16);
        pAGLinearLayout2.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(0, i.f);
        layoutParams4.addRule(1, i.b);
        addView(pAGLinearLayout2, layoutParams4);
        TextView b3 = b(context);
        this.e = b3;
        b3.setTextColor(Color.parseColor("#222222"));
        this.e.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams5.width = -1;
        layoutParams5.height = ad.b(context, 22.0f);
        layoutParams5.leftMargin = ad.b(context, 10.0f);
        pAGLinearLayout2.addView(this.e);
        PAGTextView pAGTextView = new PAGTextView(context);
        this.h = pAGTextView;
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setSingleLine(true);
        this.h.setTextColor(Color.parseColor("#4A4A4A"));
        this.h.setTextSize(2, 14.0f);
        this.h.setId(i.g);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, ad.b(context, 16.0f));
        layoutParams6.leftMargin = ad.b(context, 10.0f);
        layoutParams6.topMargin = ad.b(context, 5.0f);
        pAGLinearLayout2.addView(this.h, layoutParams6);
    }

    private void g() {
        Context context = getContext();
        TTRoundRectImageView a2 = a(context);
        this.d = a2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a2.getLayoutParams();
        int b2 = ad.b(context, 52.0f);
        layoutParams.height = b2;
        layoutParams.width = b2;
        addView(this.d);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setId(i.f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ad.b(context, 76.0f), ad.b(context, 45.0f));
        layoutParams2.addRule(11);
        layoutParams2.addRule(21);
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = ad.b(context, 15.0f);
        int[] iArr = {Color.parseColor("#0070FF")};
        com.bytedance.sdk.openadsdk.core.widget.c.a(pAGLinearLayout, new c.a().a(iArr[0]).b(Color.parseColor("#80000000")).a(iArr).c(ad.b(context, 17.0f)).d(0).e(ad.b(context, 3.0f)));
        addView(pAGLinearLayout, layoutParams2);
        this.c = d(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams3.bottomMargin = ad.b(context, 3.0f);
        pAGLinearLayout.addView(this.c, layoutParams3);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        pAGLinearLayout2.setGravity(16);
        pAGLinearLayout2.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(16, i.f);
        layoutParams4.addRule(0, i.f);
        layoutParams4.addRule(1, i.b);
        layoutParams4.addRule(17, i.b);
        addView(pAGLinearLayout2, layoutParams4);
        TextView b3 = b(context);
        this.e = b3;
        b3.setTextColor(Color.parseColor("#222222"));
        this.e.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams5.width = -1;
        layoutParams5.height = ad.b(context, 22.0f);
        layoutParams5.leftMargin = ad.b(context, 10.0f);
        pAGLinearLayout2.addView(this.e);
        PAGLinearLayout pAGLinearLayout3 = new PAGLinearLayout(context);
        pAGLinearLayout3.setGravity(16);
        pAGLinearLayout3.setOrientation(0);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = ad.b(context, 14.0f);
        layoutParams6.topMargin = ad.b(context, 5.0f);
        pAGLinearLayout2.addView(pAGLinearLayout3, layoutParams6);
        TTRatingBar2 a3 = a(context, -1);
        this.a = a3;
        ((LinearLayout.LayoutParams) a3.getLayoutParams()).height = ad.b(context, 12.0f);
        pAGLinearLayout3.addView(this.a);
        TextView c2 = c(context);
        this.b = c2;
        c2.setTextColor(Color.parseColor("#4A4A4A"));
        this.b.setTextSize(2, 14.0f);
        this.b.setMaxWidth(ad.b(context, 83.0f));
        ((LinearLayout.LayoutParams) this.b.getLayoutParams()).height = ad.b(context, 20.0f);
        pAGLinearLayout3.addView(this.b);
    }

    private void h() {
        Context context = getContext();
        TTRoundRectImageView a2 = a(context);
        this.d = a2;
        addView(a2);
        TextView d2 = d(context);
        this.c = d2;
        d2.setBackgroundResource(s.d(context, "tt_download_corner_bg"));
        this.c.setMaxWidth(ad.b(context, 105.0f));
        this.c.setText(s.b(context, "tt_video_download_apk"));
        this.c.setTextSize(2, 17.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, ad.b(context, 36.0f));
        layoutParams.addRule(21);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.rightMargin = ad.b(context, 15.0f);
        addView(this.c, layoutParams);
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(context);
        pAGLinearLayout.setGravity(16);
        pAGLinearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(0, this.c.getId());
        layoutParams2.addRule(16, this.c.getId());
        layoutParams2.addRule(1, this.d.getId());
        layoutParams2.addRule(17, this.d.getId());
        addView(pAGLinearLayout, layoutParams2);
        TextView b2 = b(context);
        this.e = b2;
        b2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        pAGLinearLayout.addView(this.e);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = ad.b(context, 14.0f);
        layoutParams3.topMargin = ad.b(context, 5.0f);
        pAGLinearLayout.addView(pAGLinearLayout2, layoutParams3);
        pAGLinearLayout2.setGravity(16);
        pAGLinearLayout2.setOrientation(0);
        TTRatingBar2 a3 = a(context, 17);
        this.a = a3;
        pAGLinearLayout2.addView(a3);
        TextView c2 = c(context);
        this.b = c2;
        c2.setTextColor(Color.parseColor("#4A4A4A"));
        this.b.setTextSize(2, 11.0f);
        pAGLinearLayout2.addView(this.b);
    }
}
