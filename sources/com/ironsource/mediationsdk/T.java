package com.ironsource.mediationsdk;

import com.ironsource.lifecycle.g;
import com.ironsource.mediationsdk.events.h;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ironsource/mediationsdk/SessionCalculationManager;", "", "()V", "calculator", "Lcom/ironsource/lifecycle/ForegroundTimeCalculator;", "init", "", "SessionCalcEventTask", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class T {
    private com.ironsource.lifecycle.a a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/ironsource/mediationsdk/SessionCalculationManager$SessionCalcEventTask;", "Lcom/ironsource/lifecycle/SessionCalcTask;", "(Lcom/ironsource/mediationsdk/SessionCalculationManager;)V", "run", "", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    final class a extends g {
        public a() {
        }

        public final void run() {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
            try {
                mediationAdditionalData.put("duration", this.a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            h.x.a(new com.ironsource.environment.c.a(44, mediationAdditionalData));
        }
    }

    public final void a() {
        this.a = new com.ironsource.lifecycle.a(new a());
    }
}
