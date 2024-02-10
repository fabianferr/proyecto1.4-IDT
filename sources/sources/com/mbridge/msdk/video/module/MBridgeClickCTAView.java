package com.mbridge.msdk.video.module;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.video.dynview.e.g;
import com.mbridge.msdk.video.dynview.j.c;
import com.mbridge.msdk.video.module.a.a.e;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.widget.a;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeClickCTAView extends MBridgeBaseView {
    private ViewGroup n;
    private ImageView o;
    private TextView p;
    private TextView q;
    /* access modifiers changed from: private */
    public TextView r;
    private String s;
    private float t;
    private float u;
    private int v;
    private ObjectAnimator w;

    public void init(Context context) {
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.w = objectAnimator;
    }

    public void setUnitId(String str) {
        this.s = str;
    }

    public MBridgeClickCTAView(Context context) {
        super(context);
    }

    public MBridgeClickCTAView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f) {
            if (this.b != null && this.b.isDynamicView()) {
                setOnClickListener(new a() {
                    /* access modifiers changed from: protected */
                    public final void a(View view) {
                        MBridgeClickCTAView.b(MBridgeClickCTAView.this);
                    }
                });
            }
            this.q.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeClickCTAView.b(MBridgeClickCTAView.this);
                }
            });
            ImageView imageView = this.o;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                    }
                });
            }
        }
    }

    public void preLoadData(b bVar) {
        if (this.b != null) {
            if (this.b.isDynamicView()) {
                com.mbridge.msdk.video.dynview.b.a().a(new c().b((View) this, this.b), new g() {
                    public final void a(com.mbridge.msdk.video.dynview.a aVar) {
                        if (aVar != null) {
                            this.addView(aVar.a());
                            MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                            mBridgeClickCTAView.f = mBridgeClickCTAView.b();
                            MBridgeClickCTAView mBridgeClickCTAView2 = MBridgeClickCTAView.this;
                            TextView unused = mBridgeClickCTAView2.r = (TextView) mBridgeClickCTAView2.findViewById(mBridgeClickCTAView2.findID("mbridge_tv_desc"));
                            MBridgeClickCTAView.this.c();
                        }
                    }

                    public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                        aa.d(MBridgeBaseView.TAG, "errorMsg:" + aVar.b());
                    }
                });
            } else {
                int findLayout = findLayout("mbridge_reward_clickable_cta");
                if (findLayout >= 0) {
                    this.c.inflate(findLayout, this);
                    this.f = b();
                    c();
                    setWrapContent();
                }
            }
            if (this.f) {
                this.q.setText(this.b.getAdCall());
                if (!TextUtils.isEmpty(this.b.getIconUrl())) {
                    com.mbridge.msdk.foundation.same.c.b.a(this.a.getApplicationContext()).a(this.b.getIconUrl(), (com.mbridge.msdk.foundation.same.c.c) new e(this.o, this.b, this.s) {
                        public final void onFailedLoad(String str, String str2) {
                            super.onFailedLoad(str, str2);
                            MBridgeClickCTAView.this.a();
                        }
                    });
                } else {
                    a();
                }
                if (this.p != null && !TextUtils.isEmpty(this.b.getAppName())) {
                    this.p.setText(this.b.getAppName());
                }
                if (this.r != null && !TextUtils.isEmpty(this.b.getAppDesc())) {
                    this.r.setText(this.b.getAppDesc());
                }
            }
        }
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.v = configuration.orientation;
    }

    /* access modifiers changed from: private */
    public void a() {
        ImageView imageView = this.o;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public boolean b() {
        this.n = (ViewGroup) findViewById(findID("mbridge_viewgroup_ctaroot"));
        this.o = (ImageView) findViewById(findID("mbridge_iv_appicon"));
        this.p = (TextView) findViewById(findID("mbridge_tv_title"));
        TextView textView = (TextView) findViewById(findID("mbridge_tv_install"));
        this.q = textView;
        return isNotNULL(this.n, this.o, this.p, textView);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.t = motionEvent.getRawX();
        this.u = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.w;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.w;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static /* synthetic */ void b(MBridgeClickCTAView mBridgeClickCTAView) {
        JSONObject jSONObject;
        JSONException e;
        if (mBridgeClickCTAView.b != null && mBridgeClickCTAView.b.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = mBridgeClickCTAView.b.getRewardTemplateMode();
                String str = "";
                if (rewardTemplateMode != null) {
                    str = rewardTemplateMode.b() + str;
                }
                q.a(com.mbridge.msdk.foundation.controller.b.d().g(), "cta_click", mBridgeClickCTAView.b.getCampaignUnitId(), mBridgeClickCTAView.b.isBidCampaign(), mBridgeClickCTAView.b.getRequestId(), mBridgeClickCTAView.b.getRequestIdNotice(), mBridgeClickCTAView.b.getId(), str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.h, mBridgeClickCTAView.a(0));
            } catch (JSONException e3) {
                e = e3;
            }
        } catch (JSONException e4) {
            JSONException jSONException = e4;
            jSONObject = null;
            e = jSONException;
            e.printStackTrace();
            mBridgeClickCTAView.e.a(105, jSONObject);
        }
        mBridgeClickCTAView.e.a(105, jSONObject);
    }
}
