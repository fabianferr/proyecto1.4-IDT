package com.mbridge.msdk.dycreator.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;

public class MBSplashViewVModel implements BaseViewModel {
    private d a;
    private c b;
    private f c;
    private h d;
    private DynamicViewBackListener e;
    private DyOption f;

    public MBSplashViewVModel(DyOption dyOption) {
        this.f = dyOption;
        String campaignUnitId = (dyOption == null || dyOption.getCampaignEx() == null) ? "" : dyOption.getCampaignEx().getCampaignUnitId();
        if (!TextUtils.isEmpty(campaignUnitId)) {
            EventBus.getDefault().register(campaignUnitId, (Object) this);
        } else {
            EventBus.getDefault().register(this);
        }
    }

    public void setModelDataAndBind() {
        MBSplashData mBSplashData = new MBSplashData(this.f);
        Context g = b.d().g();
        if (g != null) {
            DyOption dyOption = this.f;
            if (dyOption != null) {
                CampaignEx campaignEx = dyOption.getCampaignEx();
                if (campaignEx != null) {
                    mBSplashData.setAdClickText(campaignEx.getAdCall());
                }
                mBSplashData.setCountDownText(g.getResources().getString(t.a(g, this.f.isCanSkip() ? "mbridge_splash_count_time_can_skip" : "mbridge_splash_count_time_can_skip_not", TypedValues.Custom.S_STRING)));
            }
            mBSplashData.setNoticeImage(t.a(g, "mbridge_splash_notice", "drawable"));
            String g2 = w.g(g);
            mBSplashData.setLogoText((TextUtils.isEmpty(g2) || !g2.contains("zh")) ? "AD" : "广告");
        }
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(mBSplashData);
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(mBSplashData);
        }
        f fVar = this.c;
        if (fVar != null) {
            fVar.a(mBSplashData);
        }
    }

    public void setDynamicViewBackListener(DynamicViewBackListener dynamicViewBackListener) {
        if (dynamicViewBackListener != null) {
            this.e = dynamicViewBackListener;
        }
    }

    public void setClickSubject(c cVar) {
        if (cVar != null) {
            this.b = cVar;
        }
    }

    public void setConcreteSubject(d dVar) {
        if (dVar != null) {
            this.a = dVar;
        }
    }

    public void setEffectSubject(f fVar) {
        if (fVar != null) {
            this.c = fVar;
        }
    }

    public void setReportSubject(h hVar) {
        if (hVar != null) {
            this.d = hVar;
        }
    }

    /* renamed from: com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mbridge.msdk.dycreator.listener.action.EAction[] r0 = com.mbridge.msdk.dycreator.listener.action.EAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.mbridge.msdk.dycreator.listener.action.EAction r1 = com.mbridge.msdk.dycreator.listener.action.EAction.DOWNLOAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.listener.action.EAction r1 = com.mbridge.msdk.dycreator.listener.action.EAction.CLOSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel.AnonymousClass1.<clinit>():void");
        }
    }

    public void onEventMainThread(SplashResData splashResData) {
        if (this.e != null && splashResData != null) {
            int i = AnonymousClass1.a[splashResData.geteAction().ordinal()];
            if (i == 1 || i == 2) {
                String str = "";
                try {
                    if (!(splashResData.getBaseViewData() == null || splashResData.getBaseViewData().getBindData() == null)) {
                        str = splashResData.getBaseViewData().getBindData().getCampaignUnitId();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        EventBus.getDefault().unregister(str);
                        com.mbridge.msdk.dycreator.binding.b.a().b();
                    } else {
                        EventBus.getDefault().unregister((Object) this);
                        com.mbridge.msdk.dycreator.binding.b.a().b();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    EventBus.getDefault().unregister((Object) this);
                    EventBus.getDefault().release();
                    com.mbridge.msdk.dycreator.binding.b.a().b();
                }
            }
            this.e.viewClicked(splashResData);
        }
    }
}
