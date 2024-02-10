package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import java.util.HashMap;
import java.util.Map;

public class WindVaneWebView extends BaseWebView {
    protected k b;
    protected c c;
    protected f d;
    private Object e;
    private Object f;
    private String g;
    private d h;
    private String i;
    private String j;
    private int k;
    /* access modifiers changed from: private */
    public boolean l = false;
    private float m = 0.0f;
    private float n = 0.0f;

    public WindVaneWebView(Context context) {
        super(context);
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setSignalCommunication(c cVar) {
        this.c = cVar;
        cVar.a(this);
    }

    public c getSignalCommunication() {
        return this.c;
    }

    public void setRid(String str) {
        this.i = str;
    }

    public String getRid() {
        return this.i;
    }

    public String getLocalRequestId() {
        return this.j;
    }

    public void setLocalRequestId(String str) {
        this.j = str;
    }

    public void setTempTypeForMetrics(int i2) {
        this.k = i2;
    }

    public Object getJsObject(String str) {
        f fVar = this.d;
        if (fVar == null) {
            return null;
        }
        return fVar.a(str);
    }

    public void registerWindVanePlugin(Class cls) {
        f fVar = this.d;
        if (fVar != null) {
            fVar.a(cls.getSimpleName(), cls);
        }
    }

    /* access modifiers changed from: protected */
    public final void a() {
        super.a();
        getSettings().setSavePassword(false);
        WebSettings settings = getSettings();
        settings.setUserAgentString(getSettings().getUserAgentString() + " WindVane/3.0.2");
        if (this.b == null) {
            this.b = new k(this);
        }
        setWebViewChromeClient(this.b);
        this.mWebViewClient = new l();
        setWebViewClient(this.mWebViewClient);
        if (this.c == null) {
            i iVar = new i(this.a);
            this.c = iVar;
            setSignalCommunication(iVar);
        }
        this.d = new f(this.a, this);
    }

    public void setApiManagerContext(Context context) {
        f fVar = this.d;
        if (fVar != null) {
            fVar.a(context);
        }
    }

    public void setApiManagerJSFactory(Object obj) {
        f fVar = this.d;
        if (fVar != null) {
            fVar.a(obj);
        }
    }

    public void setWebViewChromeClient(k kVar) {
        this.b = kVar;
        setWebChromeClient(kVar);
    }

    public void setObject(Object obj) {
        this.e = obj;
    }

    public Object getObject() {
        return this.e;
    }

    public void setMraidObject(Object obj) {
        this.f = obj;
    }

    public Object getMraidObject() {
        return this.f;
    }

    public void setWebViewListener(d dVar) {
        this.h = dVar;
        k kVar = this.b;
        if (kVar != null) {
            kVar.a(dVar);
        }
        if (this.mWebViewClient != null) {
            this.mWebViewClient.a(dVar);
        }
    }

    public d getWebViewListener() {
        return this.h;
    }

    public boolean isDestoryed() {
        return this.l;
    }

    public void release() {
        try {
            if (!this.l) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", this.k + "");
                if (this.k == 1) {
                    m.a().b("2000135", this.j, hashMap);
                } else {
                    m.a().a("2000135", this.j, (Map<String, String>) hashMap);
                }
            }
        } catch (Exception unused) {
        }
        try {
            setVisibility(8);
            removeAllViews();
            setDownloadListener((DownloadListener) null);
            this.e = null;
            int m2 = af.m(getContext());
            if (m2 == 0) {
                this.l = true;
                destroy();
                return;
            }
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    boolean unused = WindVaneWebView.this.l = true;
                    WindVaneWebView.this.destroy();
                }
            }, (long) (m2 * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearWebView() {
        if (!this.l) {
            loadUrl("about:blank");
        }
    }

    public void setWebViewTransparent() {
        super.setTransparent();
    }

    public String getCampaignId() {
        return this.g;
    }

    public void setCampaignId(String str) {
        this.g = str;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mWebViewClient != null && (this.mWebViewClient.b() instanceof IntentFilter)) {
            String url = getUrl();
            if (!TextUtils.isEmpty(url) && url.contains("https://play.google.com")) {
                if (motionEvent.getAction() == 0) {
                    this.m = motionEvent.getRawX();
                    this.n = motionEvent.getRawY();
                } else {
                    float rawX = motionEvent.getRawX() - this.m;
                    float y = motionEvent.getY() - this.n;
                    if ((rawX >= 0.0f || rawX * -1.0f <= ((float) 48)) && ((rawX <= 0.0f || rawX <= ((float) 48)) && ((y >= 0.0f || -1.0f * y <= ((float) 48)) && (y <= 0.0f || y <= ((float) 48))))) {
                        setClickable(false);
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
