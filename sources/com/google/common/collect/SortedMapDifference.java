package com.google.common.collect;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.common.collect.MapDifference;
import java.util.SortedMap;

@ElementTypesAreNonnullByDefault
public interface SortedMapDifference<K, V> extends MapDifference<K, V> {

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.common.collect.SortedMapDifference$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<K, V> {
    }

    SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering();

    SortedMap<K, V> entriesInCommon();

    SortedMap<K, V> entriesOnlyOnLeft();

    SortedMap<K, V> entriesOnlyOnRight();
}
