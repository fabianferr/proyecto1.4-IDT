package org.koin.core.time;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.koin.mp.KoinPlatformTimeTools;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u001a*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u0002H\b\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\u001a(\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004H\u0002*\n\u0010\n\"\u00020\u00012\u00020\u0001¨\u0006\u000b"}, d2 = {"measureDuration", "", "Lorg/koin/core/time/TimeInMillis;", "code", "Lkotlin/Function0;", "", "measureDurationForResult", "Lkotlin/Pair;", "T", "measureTimedValue", "TimeInMillis", "koin-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Measure.kt */
public final class MeasureKt {
    public static final double measureDuration(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "code");
        return measureTimedValue(function0).getSecond().doubleValue();
    }

    public static final <T> Pair<T, Double> measureDurationForResult(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "code");
        Pair<T, Double> measureTimedValue = measureTimedValue(function0);
        return new Pair<>(measureTimedValue.component1(), Double.valueOf(measureTimedValue.component2().doubleValue()));
    }

    private static final <T> Pair<T, Double> measureTimedValue(Function0<? extends T> function0) {
        long timeInNanoSeconds = KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds();
        Object invoke = function0.invoke();
        double timeInNanoSeconds2 = (double) (KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds() - timeInNanoSeconds);
        Double.isNaN(timeInNanoSeconds2);
        return new Pair<>(invoke, Double.valueOf(timeInNanoSeconds2 / 1000000.0d));
    }
}
