package com.vungle.ads.internal.util;

import android.os.CountDownTimer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/vungle/ads/internal/util/SuspendableTimer$createCountdown$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SuspendableTimer.kt */
public final class SuspendableTimer$createCountdown$1 extends CountDownTimer {
    final /* synthetic */ SuspendableTimer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuspendableTimer$createCountdown$1(long j, SuspendableTimer suspendableTimer) {
        super(j, j);
        this.this$0 = suspendableTimer;
    }

    public void onTick(long j) {
        this.this$0.onTick.invoke();
    }

    public void onFinish() {
        SuspendableTimer suspendableTimer = this.this$0;
        suspendableTimer.onFinish.invoke();
        if (!suspendableTimer.repeats || suspendableTimer.isCanceled) {
            suspendableTimer.cancel();
            return;
        }
        suspendableTimer.setNextDurationSecs$vungle_ads_release(suspendableTimer.durationSecs);
        suspendableTimer.start();
    }
}
