package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.mediation.a.a;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;

public class k {
    private final StringBuilder a = new StringBuilder();

    public k a() {
        this.a.append("\n========================================");
        return this;
    }

    public k a(Bundle bundle) {
        if (bundle == null) {
            return this;
        }
        for (String str : bundle.keySet()) {
            a(str, bundle.get(str));
        }
        return this;
    }

    public k a(AppLovinAdView appLovinAdView) {
        return a("Size", appLovinAdView.getSize().getWidth() + "x" + appLovinAdView.getSize().getHeight()).a("Alpha", Float.valueOf(appLovinAdView.getAlpha())).a("Visibility", q.b(appLovinAdView.getVisibility()));
    }

    public k a(a aVar) {
        String str = "None";
        k a2 = a("Network", aVar.O()).a("Format", aVar.getFormat().getLabel()).a("Ad Unit ID", aVar.getAdUnitId()).a("Placement", aVar.getPlacement()).a("Network Placement", aVar.l()).a("Serve ID", aVar.f()).a("Creative ID", StringUtils.isValidString(aVar.getCreativeId()) ? aVar.getCreativeId() : str).a("DSP Name", StringUtils.isValidString(aVar.getDspName()) ? aVar.getDspName() : str);
        if (StringUtils.isValidString(aVar.getDspId())) {
            str = aVar.getDspId();
        }
        return a2.a("DSP ID", str).a("Server Parameters", aVar.W());
    }

    public k a(e eVar) {
        boolean z = eVar instanceof com.applovin.impl.a.a;
        a("Format", eVar.getAdZone().b() != null ? eVar.getAdZone().b().getLabel() : null).a("Ad ID", Long.valueOf(eVar.getAdIdNumber())).a("Zone ID", eVar.getAdZone().a()).a("Source", eVar.getSource()).a("Ad Class", z ? "VastAd" : "AdServerAd");
        String dspName = eVar.getDspName();
        if (StringUtils.isValidString(dspName)) {
            a("DSP Name", dspName);
        }
        if (z) {
            a("VAST DSP", ((com.applovin.impl.a.a) eVar).n());
        }
        return this;
    }

    public k a(m mVar) {
        return a("Muted", Boolean.valueOf(mVar.p().isMuted())).a("ExoPlayer eligible", Boolean.valueOf(Utils.checkExoPlayerEligibility(mVar)));
    }

    public k a(String str) {
        StringBuilder sb = this.a;
        sb.append("\n");
        sb.append(str);
        return this;
    }

    public k a(String str, Object obj) {
        return a(str, obj, "");
    }

    public k a(String str, Object obj, String str2) {
        StringBuilder sb = this.a;
        sb.append("\n");
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append(str2);
        return this;
    }

    public k b(e eVar) {
        a("Target", eVar.p()).a("close_style", eVar.v()).a("close_delay_graphic", Long.valueOf(eVar.t()), CmcdHeadersFactory.STREAMING_FORMAT_SS);
        if (eVar instanceof com.applovin.impl.sdk.ad.a) {
            com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) eVar;
            a("HTML", aVar.b().substring(0, Math.min(aVar.b().length(), 64)));
        }
        if (eVar.hasVideoUrl()) {
            a("close_delay", Long.valueOf(eVar.r()), CmcdHeadersFactory.STREAMING_FORMAT_SS).a("skip_style", eVar.x()).a("Streaming", Boolean.valueOf(eVar.f())).a("Video Location", eVar.d()).a("video_button_properties", eVar.D());
        }
        return this;
    }

    public k b(String str) {
        this.a.append(str);
        return this;
    }

    public String toString() {
        return this.a.toString();
    }
}
