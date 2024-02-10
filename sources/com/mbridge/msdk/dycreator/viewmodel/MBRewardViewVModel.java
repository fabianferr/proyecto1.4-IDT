package com.mbridge.msdk.dycreator.viewmodel;

import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.f.a;
import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;

public class MBRewardViewVModel implements BaseViewModel {
    private d a;
    private c b;
    private f c;
    private h d;
    private DynamicViewBackListener e;
    private DyOption f;

    public MBRewardViewVModel(DyOption dyOption) {
        this.f = dyOption;
        EventBus.getDefault().register(this);
    }

    public void setModelDataAndBind() {
        a aVar = new a(this.f);
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(aVar);
        }
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(aVar);
        }
        f fVar = this.c;
        if (fVar != null) {
            fVar.a(aVar);
        }
        h hVar = this.d;
        if (hVar != null) {
            hVar.a(aVar);
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

    public void onEventMainThread(SplashResData splashResData) {
        DynamicViewBackListener dynamicViewBackListener = this.e;
        if (dynamicViewBackListener != null) {
            dynamicViewBackListener.viewClicked(splashResData);
        }
    }
}
