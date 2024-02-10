package com.mbridge.msdk.video.dynview.moffer;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.video.dynview.e.f;
import com.mbridge.msdk.video.module.MBridgeNativeEndCardView;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: MOfferEnergize */
public class a {
    private static volatile a a;
    private Map<String, SoftReference<MOfferModel>> b = new ConcurrentHashMap();
    private int c = 500;

    private a() {
    }

    public static a a() {
        a aVar;
        if (a != null) {
            return a;
        }
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public final void a(final ViewGroup viewGroup, String str, com.mbridge.msdk.video.module.a.a aVar) {
        if (viewGroup != null && aVar != null && this.b != null && !TextUtils.isEmpty(str) && this.b.containsKey(str)) {
            SoftReference softReference = this.b.get(str);
            final MOfferModel mOfferModel = (softReference == null || softReference.get() == null) ? null : (MOfferModel) softReference.get();
            if (mOfferModel != null && mOfferModel != null) {
                mOfferModel.setMoreOfferListener(new f() {
                    public final void a(ViewGroup viewGroup, CampaignUnit campaignUnit) {
                        ViewGroup viewGroup2;
                        if (viewGroup != null && (viewGroup2 = viewGroup) != null) {
                            try {
                                a.a(a.this, mOfferModel, viewGroup2, viewGroup, campaignUnit);
                            } catch (Exception e) {
                                aa.d("MOfferEnergize", e.getMessage());
                            }
                        }
                    }

                    public final void a(int i, String str) {
                        aa.d("MOfferEnergize", str);
                    }
                }, aVar);
                mOfferModel.showView();
            }
        }
    }

    public final void a(CampaignEx campaignEx, int i) {
        if (campaignEx != null) {
            String str = campaignEx.getRequestId() + "_" + campaignEx.getId();
            if (this.b == null) {
                this.b = new ConcurrentHashMap();
            }
            if (!this.b.containsKey(str)) {
                try {
                    MOfferModel mOfferModel = new MOfferModel();
                    mOfferModel.setFromType(i);
                    SoftReference softReference = new SoftReference(mOfferModel);
                    if (softReference.get() != null) {
                        this.b.put(str, softReference);
                        ((MOfferModel) softReference.get()).buildMofferAd(campaignEx);
                    }
                } catch (Exception e) {
                    aa.d("MOfferEnergize", e.getMessage());
                }
            }
        }
    }

    public final void a(CampaignEx campaignEx, final ViewGroup viewGroup, com.mbridge.msdk.video.module.a.a aVar, int i) {
        final MOfferModel mOfferModel = new MOfferModel();
        mOfferModel.setFromType(i);
        mOfferModel.setMoreOfferListener(new f() {
            public final void a(int i, String str) {
            }

            public final void a(ViewGroup viewGroup, CampaignUnit campaignUnit) {
                if (viewGroup != null && campaignUnit != null) {
                    try {
                        a.a(a.this, mOfferModel, viewGroup, viewGroup, campaignUnit);
                    } catch (Exception e) {
                        aa.d("MOfferEnergize", e.getMessage());
                    }
                }
            }
        }, aVar);
        mOfferModel.buildMofferAd(campaignEx);
    }

    public final boolean a(String str) {
        if (this.b == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.b.containsKey(str);
    }

    public final void b() {
        MOfferModel mOfferModel;
        try {
            Map<String, SoftReference<MOfferModel>> map = this.b;
            if (map != null) {
                for (SoftReference next : map.values()) {
                    if (!(next == null || (mOfferModel = (MOfferModel) next.get()) == null)) {
                        mOfferModel.mofDestroy();
                    }
                }
                this.b.clear();
            }
        } catch (Exception e) {
            aa.d("MOfferEnergize", e.getMessage());
        }
    }

    private int b(String str) {
        return t.a(b.d().g(), str, "id");
    }

    static /* synthetic */ void a(a aVar, final MOfferModel mOfferModel, ViewGroup viewGroup, ViewGroup viewGroup2, CampaignUnit campaignUnit) {
        RelativeLayout relativeLayout;
        if (mOfferModel != null && viewGroup != null && viewGroup2 != null && campaignUnit != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams.addRule(12, -1);
            int b2 = af.b(b.d().g(), 5.0f);
            layoutParams.setMargins(b2, b2, b2, b2);
            if (viewGroup2 != null && viewGroup2.getBackground() == null) {
                try {
                    Drawable drawable = b.d().g().getResources().getDrawable(t.a(b.d().g(), "mbridge_reward_more_offer_default_bg", "drawable"));
                    if (drawable != null) {
                        View findViewById = viewGroup2.findViewById(aVar.b("mbridge_moreoffer_hls"));
                        if (findViewById != null) {
                            findViewById.setBackground(drawable);
                        }
                    }
                } catch (Exception e) {
                    aa.d("MOfferEnergize", e.getMessage());
                }
            }
            viewGroup2.setLayoutParams(layoutParams);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 != null) {
                viewGroup3.removeAllViews();
            }
            try {
                if (viewGroup instanceof MBridgeNativeEndCardView) {
                    if (((MBridgeNativeEndCardView) viewGroup).isDyXmlSuccess()) {
                        relativeLayout = (RelativeLayout) viewGroup.findViewById(-1642631508);
                    } else {
                        relativeLayout = (RelativeLayout) viewGroup.findViewById(aVar.b("mbridge_native_ec_layout"));
                    }
                    new com.mbridge.msdk.video.dynview.h.b().a(relativeLayout, 0, af.b(b.d().g(), 100.0f), (long) aVar.c);
                }
                RelativeLayout relativeLayout2 = (RelativeLayout) viewGroup.findViewById(aVar.b("mbridge_reward_moreoffer_layout"));
                if (relativeLayout2 == null) {
                    relativeLayout2 = (RelativeLayout) viewGroup.findViewById(-82036151);
                }
                if (relativeLayout2 == null) {
                    viewGroup.addView(viewGroup2);
                } else if (viewGroup.isShown()) {
                    relativeLayout2.setVisibility(0);
                    relativeLayout2.addView(viewGroup2);
                }
                new com.mbridge.msdk.video.dynview.h.b().a(viewGroup2, 0, af.i(b.d().g()), 0, af.b(b.d().g(), 100.0f), 0);
                if (viewGroup instanceof MBridgeNativeEndCardView) {
                    ((MBridgeNativeEndCardView) viewGroup).setMoreOfferCampaignUnit(campaignUnit);
                }
                viewGroup.postDelayed(new Runnable() {
                    public final void run() {
                        MOfferModel mOfferModel = mOfferModel;
                        if (mOfferModel != null) {
                            mOfferModel.checkViewVisiableState();
                        }
                    }
                }, (long) (aVar.c + 500));
            } catch (Exception e2) {
                aa.d("MOfferEnergize", e2.getMessage());
            }
        }
    }
}
