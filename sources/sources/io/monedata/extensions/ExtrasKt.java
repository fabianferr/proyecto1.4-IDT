package io.monedata.extensions;

import io.monedata.models.Extras;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"extrasOf", "Lio/monedata/models/Extras;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Lio/monedata/models/Extras;", "core_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ExtrasKt {
    public static final Extras extrasOf(Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        return new Extras(MapsKt.mapOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
    }
}
