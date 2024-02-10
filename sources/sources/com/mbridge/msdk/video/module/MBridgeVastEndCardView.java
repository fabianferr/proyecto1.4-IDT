package com.mbridge.msdk.video.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.widget.a;

public class MBridgeVastEndCardView extends MBridgeBaseView {
    private ViewGroup n;
    private View o;
    private View p;

    public void preLoadData(b bVar) {
    }

    public MBridgeVastEndCardView(Context context) {
        super(context);
    }

    public MBridgeVastEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_endcard_vast");
        if (findLayout >= 0) {
            this.c.inflate(findLayout, this);
            this.n = (ViewGroup) findViewById(findID("mbridge_rl_content"));
            this.o = findViewById(findID("mbridge_iv_vastclose"));
            View findViewById = findViewById(findID("mbridge_iv_vastok"));
            this.p = findViewById;
            this.f = isNotNULL(this.n, this.o, findViewById);
            c();
            if (this.f) {
                setMatchParent();
                setBackgroundResource(findColor("mbridge_reward_endcard_vast_bg"));
                setClickable(true);
                ((RelativeLayout.LayoutParams) this.n.getLayoutParams()).addRule(13, -1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f) {
            this.o.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBridgeVastEndCardView.this.e.a(104, "");
                }
            });
            this.p.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeVastEndCardView.this.e.a(108, MBridgeVastEndCardView.this.d());
                }
            });
        }
    }

    public void notifyShowListener() {
        this.e.a(111, "");
    }
}
