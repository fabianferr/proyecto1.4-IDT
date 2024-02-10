package com.mbridge.msdk.video.signal.a;

import android.util.Base64;
import android.webkit.WebView;
import com.appnext.core.Ad;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import org.json.JSONObject;

/* compiled from: JSNotifyProxy */
public final class l extends e {
    private WebView a;

    public l(WebView webView) {
        this.a = webView;
    }

    public final void a(int i) {
        super.a(i);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", i);
            g.a().a(this.a, "onVideoStatusNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(int i, String str) {
        super.a(i, str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i);
            jSONObject.put("pt", str);
            g.a().a(this.a, "onJSClick", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(MBridgeVideoView.a aVar) {
        super.a(aVar);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("progress", a(aVar.a, aVar.b));
            jSONObject.put("time", String.valueOf(aVar.a));
            jSONObject.put("duration", String.valueOf(aVar.b));
            g.a().a(this.a, "onVideoProgressNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String a(int i, int i2) {
        if (i2 != 0) {
            double d = (double) (((float) i) / ((float) i2));
            try {
                return af.a(Double.valueOf(d)) + "";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i2 + "";
    }

    public final void a(Object obj) {
        super.a(obj);
        g.a().a(this.a, "webviewshow", (obj == null || !(obj instanceof String)) ? "" : Base64.encodeToString(obj.toString().getBytes(), 2));
    }

    public final void a(int i, int i2, int i3, int i4) {
        super.a(i, i2, i3, i4);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            String str = Ad.ORIENTATION_LANDSCAPE;
            if (i != 2 ? i2 != 2 : i2 == 1) {
                str = Ad.ORIENTATION_PORTRAIT;
            }
            jSONObject2.put(AdUnitActivity.EXTRA_ORIENTATION, str);
            jSONObject2.put("screen_width", i3);
            jSONObject2.put("screen_height", i4);
            jSONObject.put("data", jSONObject2);
            g.a().a(this.a, "showDataInfo", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
