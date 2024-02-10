package com.mbridge.msdk.dycreator.binding.response;

import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;
import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.listener.action.EAction;

public class SplashResData extends BaseRespData {
    private a a;
    private EAction b;

    public a getBaseViewData() {
        return this.a;
    }

    public void setBaseViewData(a aVar) {
        this.a = aVar;
    }

    public EAction geteAction() {
        return this.b;
    }

    public void seteAction(EAction eAction) {
        this.b = eAction;
    }
}
