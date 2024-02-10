package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.module.a.a.j;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeVideoEndCoverView extends MBridgeBaseView {
    private final String n = "MBridgeVideoEndCoverView";
    private View o;
    private ImageView p;
    private ImageView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private b u;

    public MBridgeVideoEndCoverView(Context context) {
        super(context);
    }

    public MBridgeVideoEndCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_videoend_cover");
        if (findLayout >= 0) {
            View inflate = this.c.inflate(findLayout, (ViewGroup) null);
            this.o = inflate;
            if (inflate != null) {
                this.f = a(inflate);
                addView(this.o, -1, -1);
                c();
            }
        }
    }

    public void preLoadData(b bVar) {
        ImageView imageView;
        this.u = bVar;
        try {
            if (this.b != null && this.f && this.b != null) {
                if (!TextUtils.isEmpty(this.b.getIconUrl()) && (imageView = this.p) != null) {
                    com.mbridge.msdk.foundation.same.c.b.a(this.a.getApplicationContext()).a(this.b.getIconUrl(), (c) new j(imageView, af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 8.0f)));
                }
                TextView textView = this.r;
                if (textView != null) {
                    textView.setText(this.b.getAppName());
                }
                TextView textView2 = this.t;
                if (textView2 != null) {
                    textView2.setText(this.b.getAdCall());
                }
                TextView textView3 = this.s;
                if (textView3 != null) {
                    textView3.setText(this.b.getAppDesc());
                }
            }
        } catch (Throwable th) {
            aa.a("MBridgeVideoEndCoverView", th.getMessage());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.g = motionEvent.getRawX();
        this.h = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.d = configuration.orientation;
        removeView(this.o);
        View view = this.o;
        if (view == null) {
            init(this.a);
            preLoadData(this.u);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.o.getParent()).removeView(this.o);
        }
        addView(this.o);
        a(this.o);
        c();
    }

    private boolean a(View view) {
        if (view == null) {
            return true;
        }
        try {
            this.p = (ImageView) view.findViewById(findID("mbridge_vec_iv_icon"));
            this.q = (ImageView) view.findViewById(findID("mbridge_vec_iv_close"));
            this.r = (TextView) view.findViewById(findID("mbridge_vec_tv_title"));
            this.s = (TextView) view.findViewById(findID("mbridge_vec_tv_desc"));
            this.t = (TextView) view.findViewById(findID("mbridge_vec_btn"));
            return true;
        } catch (Throwable th) {
            aa.d("MBridgeVideoEndCoverView", th.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        this.q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.e.a(104, "");
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.a();
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.a();
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void a() {
        JSONObject jSONObject;
        JSONException e;
        JSONObject jSONObject2;
        JSONException e2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(a.f, af.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.g));
                    jSONObject2.put(a.g, af.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.h));
                    jSONObject2.put(a.i, 0);
                    try {
                        this.d = getContext().getResources().getConfiguration().orientation;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    jSONObject2.put(a.j, this.d);
                    jSONObject2.put(a.k, (double) af.e(getContext()));
                } catch (JSONException e4) {
                    e2 = e4;
                    aa.d("MBridgeVideoEndCoverView", e2.getMessage());
                    jSONObject = new JSONObject();
                    jSONObject.put(a.h, jSONObject2);
                    this.e.a(105, jSONObject);
                }
            } catch (JSONException e5) {
                JSONException jSONException = e5;
                jSONObject2 = jSONObject3;
                e2 = jSONException;
                aa.d("MBridgeVideoEndCoverView", e2.getMessage());
                jSONObject = new JSONObject();
                jSONObject.put(a.h, jSONObject2);
                this.e.a(105, jSONObject);
            }
            jSONObject = new JSONObject();
            try {
                jSONObject.put(a.h, jSONObject2);
            } catch (JSONException e6) {
                e = e6;
            }
        } catch (JSONException e7) {
            JSONException jSONException2 = e7;
            jSONObject = null;
            e = jSONException2;
            e.printStackTrace();
            this.e.a(105, jSONObject);
        }
        this.e.a(105, jSONObject);
    }
}
