package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.layout.TTVideoTrafficTipsLayout;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

/* compiled from: VideoTrafficTipLayout */
public class e {
    private View a;
    private TextView b;
    private Context c;
    /* access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.a d;
    private b e;
    private boolean f = false;
    private com.bykv.vk.openvk.component.video.api.c.b g;
    private ViewGroup h;

    /* compiled from: VideoTrafficTipLayout */
    public enum a {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    /* compiled from: VideoTrafficTipLayout */
    public interface b {
        boolean j();

        void k();
    }

    public void a(Context context, ViewGroup viewGroup) {
        if (context != null && (viewGroup instanceof ViewGroup)) {
            this.h = viewGroup;
            this.c = o.a().getApplicationContext();
        }
    }

    private void a(Context context, View view, boolean z) {
        ViewGroup.LayoutParams a2;
        if (context != null && view != null && this.a == null && (a2 = a(this.h)) != null) {
            TTVideoTrafficTipsLayout tTVideoTrafficTipsLayout = new TTVideoTrafficTipsLayout(context);
            this.a = tTVideoTrafficTipsLayout;
            tTVideoTrafficTipsLayout.setLayoutParams(a2);
            this.h.addView(this.a);
            this.b = (TextView) this.a.findViewById(i.bb);
            View findViewById = this.a.findViewById(i.bc);
            if (z) {
                findViewById.setClickable(true);
                findViewById.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        e.this.c();
                        if (e.this.d != null) {
                            e.this.d.a(a.START_VIDEO, (String) null);
                        }
                    }
                });
                return;
            }
            findViewById.setOnClickListener((View.OnClickListener) null);
            findViewById.setClickable(false);
        }
    }

    private ViewGroup.LayoutParams a(ViewGroup viewGroup) {
        if (viewGroup instanceof RelativeLayout) {
            return new RelativeLayout.LayoutParams(-1, -1);
        }
        if (viewGroup instanceof LinearLayout) {
            return new LinearLayout.LayoutParams(-1, -1);
        }
        if (viewGroup instanceof FrameLayout) {
            return new FrameLayout.LayoutParams(-1, -1);
        }
        return null;
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.a aVar, b bVar) {
        this.e = bVar;
        this.d = aVar;
    }

    private void b() {
        this.g = null;
    }

    public boolean a(int i, com.bykv.vk.openvk.component.video.api.c.b bVar, boolean z) {
        Context context = this.c;
        if (context == null || bVar == null) {
            return true;
        }
        a(context, (View) this.h, z);
        this.g = bVar;
        if (i == 1 || i == 2) {
            return a(i);
        }
        return true;
    }

    private boolean a(int i) {
        b bVar;
        if (a() || this.f) {
            return true;
        }
        if (!(this.d == null || (bVar = this.e) == null)) {
            if (bVar.j()) {
                this.d.e((com.bykv.vk.openvk.component.video.api.d.b) null, (View) null);
            }
            this.d.a(a.PAUSE_VIDEO, (String) null);
        }
        a(this.g, true);
        return false;
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.c != null) {
            d();
        }
    }

    public void a(boolean z) {
        if (z) {
            b();
        }
        d();
    }

    public boolean a() {
        View view = this.a;
        return view != null && view.getVisibility() == 0;
    }

    private void d() {
        View view = this.a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void a(com.bykv.vk.openvk.component.video.api.c.b bVar, boolean z) {
        View view;
        String str;
        View view2;
        if (bVar != null && (view = this.a) != null && this.c != null && view.getVisibility() != 0) {
            b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.k();
            }
            double e2 = (double) bVar.e();
            Double.isNaN(e2);
            double ceil = Math.ceil((e2 * 1.0d) / 1048576.0d);
            if (z) {
                str = String.format(s.a(this.c, "tt_video_without_wifi_tips"), new Object[]{Float.valueOf(Double.valueOf(ceil).floatValue())});
            } else {
                str = s.a(this.c, "tt_video_without_wifi_tips") + s.a(this.c, "tt_video_bytesize");
            }
            ad.a(this.a, 0);
            ad.a(this.b, (CharSequence) str);
            Log.i("VideoTrafficTipLayout", "showTrafficTipCover: ");
            if (ad.d(this.a) && (view2 = this.a) != null) {
                view2.bringToFront();
                Log.i("VideoTrafficTipLayout", "showTrafficTipCover: bringToFront");
            }
        }
    }
}
