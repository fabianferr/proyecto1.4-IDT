package com.vungle.ads.internal.util;

import android.os.CountDownTimer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010+\u001a\u00020\bJ\u0010\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020\fH\u0002J\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020\bR\u0014\u0010\u000b\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\f8@X\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000eR$\u0010\u001a\u001a\u00020\u00038\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\f8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010#R&\u0010$\u001a\u0004\u0018\u00010%8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00062"}, d2 = {"Lcom/vungle/ads/internal/util/SuspendableTimer;", "", "durationSecs", "", "repeats", "", "onTick", "Lkotlin/Function0;", "", "onFinish", "(DZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "durationMillis", "", "getDurationMillis", "()J", "elapsedMillis", "getElapsedMillis$vungle_ads_release$annotations", "()V", "getElapsedMillis$vungle_ads_release", "elapsedSecs", "getElapsedSecs", "()D", "isCanceled", "isPaused", "nextDurationMillis", "getNextDurationMillis", "nextDurationSecs", "getNextDurationSecs$vungle_ads_release$annotations", "getNextDurationSecs$vungle_ads_release", "setNextDurationSecs$vungle_ads_release", "(D)V", "startTimeMillis", "getStartTimeMillis$vungle_ads_release$annotations", "getStartTimeMillis$vungle_ads_release", "setStartTimeMillis$vungle_ads_release", "(J)V", "timer", "Landroid/os/CountDownTimer;", "getTimer$vungle_ads_release$annotations", "getTimer$vungle_ads_release", "()Landroid/os/CountDownTimer;", "setTimer$vungle_ads_release", "(Landroid/os/CountDownTimer;)V", "cancel", "createCountdown", "duration", "pause", "reset", "resume", "start", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SuspendableTimer.kt */
public final class SuspendableTimer {
    /* access modifiers changed from: private */
    public final double durationSecs;
    /* access modifiers changed from: private */
    public boolean isCanceled;
    private boolean isPaused;
    private double nextDurationSecs;
    /* access modifiers changed from: private */
    public final Function0<Unit> onFinish;
    /* access modifiers changed from: private */
    public final Function0<Unit> onTick;
    /* access modifiers changed from: private */
    public final boolean repeats;
    private long startTimeMillis;
    private CountDownTimer timer;

    public static /* synthetic */ void getElapsedMillis$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getNextDurationSecs$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getStartTimeMillis$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getTimer$vungle_ads_release$annotations() {
    }

    public SuspendableTimer(double d, boolean z, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "onTick");
        Intrinsics.checkNotNullParameter(function02, "onFinish");
        this.durationSecs = d;
        this.repeats = z;
        this.onTick = function0;
        this.onFinish = function02;
        this.nextDurationSecs = d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuspendableTimer(double d, boolean z, Function0 function0, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, z, (i & 4) != 0 ? AnonymousClass1.INSTANCE : function0, function02);
    }

    public final double getNextDurationSecs$vungle_ads_release() {
        return this.nextDurationSecs;
    }

    public final void setNextDurationSecs$vungle_ads_release(double d) {
        this.nextDurationSecs = d;
    }

    public final long getStartTimeMillis$vungle_ads_release() {
        return this.startTimeMillis;
    }

    public final void setStartTimeMillis$vungle_ads_release(long j) {
        this.startTimeMillis = j;
    }

    public final CountDownTimer getTimer$vungle_ads_release() {
        return this.timer;
    }

    public final void setTimer$vungle_ads_release(CountDownTimer countDownTimer) {
        this.timer = countDownTimer;
    }

    private final long getDurationMillis() {
        double d = this.durationSecs;
        double d2 = (double) 1000;
        Double.isNaN(d2);
        return (long) (d * d2);
    }

    public final long getElapsedMillis$vungle_ads_release() {
        long currentTimeMillis;
        long j;
        if (this.isPaused) {
            currentTimeMillis = getDurationMillis();
            j = getNextDurationMillis();
        } else {
            currentTimeMillis = System.currentTimeMillis();
            j = this.startTimeMillis;
        }
        return currentTimeMillis - j;
    }

    private final double getElapsedSecs() {
        return (double) (getElapsedMillis$vungle_ads_release() / ((long) 1000));
    }

    private final long getNextDurationMillis() {
        double d = this.nextDurationSecs;
        double d2 = (double) 1000;
        Double.isNaN(d2);
        return (long) (d * d2);
    }

    public final void start() {
        this.startTimeMillis = System.currentTimeMillis();
        CountDownTimer createCountdown = createCountdown(getNextDurationMillis());
        this.timer = createCountdown;
        if (createCountdown != null) {
            createCountdown.start();
        }
    }

    public final void reset() {
        cancel();
        start();
    }

    public final void pause() {
        if (this.timer != null) {
            this.nextDurationSecs -= getElapsedSecs();
            this.isPaused = true;
            CountDownTimer countDownTimer = this.timer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.timer = null;
        }
    }

    public final void resume() {
        if (this.isPaused) {
            this.isPaused = false;
            start();
        }
    }

    public final void cancel() {
        this.isPaused = false;
        this.isCanceled = true;
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
    }

    private final CountDownTimer createCountdown(long j) {
        return new SuspendableTimer$createCountdown$1(j, this);
    }
}
