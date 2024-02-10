package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.apiImpl.c.b;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.multipro.aidl.a;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.w;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PAGAppOpenAdImpl */
public class d extends PAGAppOpenAd {
    private final Context a;
    private final q b;
    private final AdSlot c;
    /* access modifiers changed from: private */
    public b d;
    private final AtomicBoolean e = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final String f;
    private final boolean g;
    private boolean h;
    private boolean i;

    public d(Context context, q qVar, boolean z, AdSlot adSlot) {
        this.a = context;
        this.b = qVar;
        this.g = z;
        this.f = r.a();
        this.c = adSlot;
    }

    public void setAdInteractionListener(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.d = new e(pAGAppOpenAdInteractionListener);
        a();
    }

    public void setAdInteractionCallback(PAGAppOpenAdInteractionCallback pAGAppOpenAdInteractionCallback) {
        this.d = new e(pAGAppOpenAdInteractionCallback);
        a();
    }

    private void a() {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            aa.c(new h("AppOpenAd_registerMultiProcessListener") {
                public void run() {
                    a a2 = a.a();
                    if (d.this.d != null) {
                        l.b("MultiProcess", "start registerAppOpenListener ! ");
                        IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(a2.a(7));
                        if (asInterface != null) {
                            try {
                                asInterface.registerAppOpenAdListener(d.this.f, new com.bytedance.sdk.openadsdk.multipro.aidl.b.a(d.this.d));
                                b unused = d.this.d = null;
                                l.b("MultiProcess", "end registerAppOpenAdListener ! ");
                            } catch (RemoteException e) {
                                l.e("TTAppOpenAdImpl", e.getMessage());
                            }
                        }
                    }
                }
            }, 5);
        }
    }

    public void show(Activity activity) {
        Context context;
        int i2;
        if (activity != null && activity.isFinishing()) {
            activity = null;
        }
        if (!this.e.getAndSet(true)) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (activity != null) {
                    context = activity;
                } else {
                    context = this.a;
                }
                if (context == null) {
                    context = o.a();
                }
                try {
                    i2 = activity.getWindowManager().getDefaultDisplay().getRotation();
                } catch (Exception unused) {
                    i2 = 0;
                }
                Intent intent = new Intent(context, TTAppOpenAdActivity.class);
                intent.putExtra("orientation_angle", i2);
                intent.putExtra("ad_source", this.g ? 1 : 2);
                if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.b.ao().toString());
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_META_MD5, this.f);
                } else {
                    s.a().f();
                    s.a().a(this.b);
                    s.a().a(this.d);
                    this.d = null;
                }
                intent.putExtra("start_show_time", SystemClock.elapsedRealtime());
                com.bytedance.sdk.component.utils.b.a(context, intent, new b.a() {
                    public void a() {
                        l.b("TTAppOpenAdImpl", "app open ad startActivitySuccess");
                    }

                    public void a(Throwable th) {
                        l.b("TTAppOpenAdImpl", "app open ad startActivityFail");
                    }
                });
                if (this.c != null) {
                    try {
                        if (com.bytedance.sdk.openadsdk.core.settings.o.ai().x(this.c.getCodeId()) == 1) {
                            f a2 = f.a(this.a);
                            a2.g(Integer.parseInt(this.c.getCodeId()));
                            a2.a(this.c);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            } else {
                l.e("TTAppOpenAdImpl", "showTTAppOpenAd error: not main looper");
                throw new IllegalStateException("Cannot be called in a child thread ---- TTAppOpenAdImpl.showAppOpenAd");
            }
        }
    }

    public void win(Double d2) {
        if (!this.h) {
            w.a(this.b, d2);
            this.h = true;
        }
    }

    public void loss(Double d2, String str, String str2) {
        if (!this.i) {
            w.a(this.b, d2, str, str2);
            this.i = true;
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        q qVar = this.b;
        if (qVar != null) {
            return qVar.ai();
        }
        return null;
    }
}
