package com.applovin.impl.adview.activity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.adview.activity.b.a;
import com.applovin.impl.adview.o;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.f.p;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements ServiceConnection {
    /* access modifiers changed from: private */
    public final m a;
    /* access modifiers changed from: private */
    public final u b;
    /* access modifiers changed from: private */
    public final WeakReference<AppLovinFullscreenActivity> c;
    private final AtomicBoolean d = new AtomicBoolean();
    /* access modifiers changed from: private */
    public Messenger e;

    /* renamed from: com.applovin.impl.adview.activity.a$a  reason: collision with other inner class name */
    private class C0007a implements AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdVideoPlaybackListener {
        private C0007a() {
        }

        private void a(Bundle bundle, FullscreenAdService.b bVar) {
            Message obtain = Message.obtain((Handler) null, bVar.a());
            if (bundle != null) {
                obtain.setData(bundle);
            }
            try {
                a.this.e.send(obtain);
            } catch (RemoteException e) {
                if (u.a()) {
                    u b = a.this.b;
                    b.b("AppLovinFullscreenActivity", "Failed to forward callback (" + bVar.a() + ")", e);
                }
            }
        }

        private void a(FullscreenAdService.b bVar) {
            a((Bundle) null, bVar);
        }

        public void adClicked(AppLovinAd appLovinAd) {
            a(FullscreenAdService.b.AD_CLICKED);
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            a(FullscreenAdService.b.AD_DISPLAYED);
        }

        public void adHidden(AppLovinAd appLovinAd) {
            a(FullscreenAdService.b.AD_HIDDEN);
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            a(FullscreenAdService.b.AD_VIDEO_STARTED);
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            Bundle bundle = new Bundle();
            bundle.putDouble("percent_viewed", d);
            bundle.putBoolean("fully_watched", z);
            a(bundle, FullscreenAdService.b.AD_VIDEO_ENDED);
        }
    }

    private static class b extends Handler {
        private final WeakReference<a> a;

        private b(a aVar) {
            this.a = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            a aVar;
            if (message.what != FullscreenAdService.b.AD.a() || (aVar = (a) this.a.get()) == null) {
                super.handleMessage(message);
                return;
            }
            aVar.a(com.applovin.impl.sdk.ad.b.a(message.getData().getInt("ad_source")), message.getData().getString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE));
        }
    }

    public a(AppLovinFullscreenActivity appLovinFullscreenActivity, m mVar) {
        this.a = mVar;
        this.b = mVar.A();
        this.c = new WeakReference<>(appLovinFullscreenActivity);
    }

    /* access modifiers changed from: private */
    public void a() {
        AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) this.c.get();
        if (appLovinFullscreenActivity != null) {
            if (u.a()) {
                this.b.b("AppLovinFullscreenActivity", "Dismissing...");
            }
            appLovinFullscreenActivity.dismiss();
        } else if (u.a()) {
            this.b.e("AppLovinFullscreenActivity", "Unable to dismiss parent Activity");
        }
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.b bVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.applovin.impl.sdk.ad.b bVar2 = bVar;
            this.a.S().a((com.applovin.impl.sdk.f.a) new p(jSONObject, d.a(JsonUtils.getString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, "")), bVar2, new AppLovinAdLoadListener() {
                public void adReceived(final AppLovinAd appLovinAd) {
                    final AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) a.this.c.get();
                    boolean a2 = u.a();
                    if (appLovinFullscreenActivity != null) {
                        if (a2) {
                            a.this.b.b("AppLovinFullscreenActivity", "Presenting ad...");
                        }
                        final C0007a aVar = new C0007a();
                        com.applovin.impl.adview.activity.b.a.a((e) appLovinAd, aVar, aVar, aVar, a.this.a, appLovinFullscreenActivity, new a.C0008a() {
                            public void a(com.applovin.impl.adview.activity.b.a aVar) {
                                appLovinFullscreenActivity.setPresenter(aVar);
                                aVar.d();
                            }

                            public void a(String str, Throwable th) {
                                o.a((e) appLovinAd, aVar, str, th, appLovinFullscreenActivity);
                            }
                        });
                    } else if (a2) {
                        u b = a.this.b;
                        b.e("AppLovinFullscreenActivity", "Unable to present ad, parent activity has been GC'd - " + appLovinAd);
                    }
                }

                public void failedToReceiveAd(int i) {
                    a.this.a();
                }
            }, this.a));
        } catch (JSONException e2) {
            if (u.a()) {
                u uVar = this.b;
                uVar.b("AppLovinFullscreenActivity", "Unable to process ad: " + str, e2);
            }
            a();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.d.compareAndSet(false, true)) {
            if (u.a()) {
                u uVar = this.b;
                uVar.b("AppLovinFullscreenActivity", "Fullscreen ad service connected to " + componentName);
            }
            this.e = new Messenger(iBinder);
            Message obtain = Message.obtain((Handler) null, FullscreenAdService.b.AD.a());
            obtain.replyTo = new Messenger(new b());
            try {
                if (u.a()) {
                    this.b.b("AppLovinFullscreenActivity", "Requesting ad from FullscreenAdService...");
                }
                this.e.send(obtain);
            } catch (RemoteException e2) {
                if (u.a()) {
                    this.b.b("AppLovinFullscreenActivity", "Failed to send ad request message to FullscreenAdService", e2);
                }
                a();
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.d.compareAndSet(true, false) && u.a()) {
            u uVar = this.b;
            uVar.b("AppLovinFullscreenActivity", "FullscreenAdService disconnected from " + componentName);
        }
    }
}
