package com.bytedance.sdk.openadsdk.core.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ad;

/* compiled from: VideoOnTouchLayout */
public class d {
    /* access modifiers changed from: private */
    public final a a;
    private final boolean b = false;
    /* access modifiers changed from: private */
    public boolean c = false;
    /* access modifiers changed from: private */
    public float d;
    /* access modifiers changed from: private */
    public float e;
    /* access modifiers changed from: private */
    public int f;
    /* access modifiers changed from: private */
    public int g;
    /* access modifiers changed from: private */
    public boolean h = true;
    /* access modifiers changed from: private */
    public boolean i = false;
    private final View.OnTouchListener j = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.a.w()) {
                return !d.this.c;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                d dVar = d.this;
                boolean unused = dVar.k = dVar.a(motionEvent);
                float unused2 = d.this.d = x;
                float unused3 = d.this.e = y;
                int unused4 = d.this.f = (int) x;
                int unused5 = d.this.g = (int) y;
                boolean unused6 = d.this.h = true;
                if (d.this.a != null && d.this.c) {
                    d.this.a.a(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - ((float) d.this.f)) > 20.0f || Math.abs(y - ((float) d.this.g)) > 20.0f) {
                    boolean unused7 = d.this.h = false;
                }
                boolean unused8 = d.this.h = true;
                boolean unused9 = d.this.i = false;
                float unused10 = d.this.d = 0.0f;
                float unused11 = d.this.e = 0.0f;
                int unused12 = d.this.f = 0;
                if (d.this.a != null) {
                    d.this.a.a(view, d.this.h);
                }
                boolean unused13 = d.this.k = false;
            } else if (action == 3) {
                boolean unused14 = d.this.k = false;
            }
            return !d.this.c;
        }
    };
    /* access modifiers changed from: private */
    public boolean k;

    /* compiled from: VideoOnTouchLayout */
    public interface a {
        void a(View view, boolean z);

        boolean w();
    }

    public d(a aVar) {
        this.a = aVar;
    }

    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(this.j);
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    /* access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int c2 = ad.c(o.a().getApplicationContext());
        int d2 = ad.d(o.a().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f2 = (float) c2;
        if (rawX > f2 * 0.01f && rawX < f2 * 0.99f) {
            float f3 = (float) d2;
            if (rawY <= 0.01f * f3 || rawY >= f3 * 0.99f) {
                return true;
            }
            return false;
        }
        return true;
    }
}
