package com.google.common.collect;

import com.android.tools.r8.annotations.SynthesizedClassV2;

@ElementTypesAreNonnullByDefault
interface FilteredSetMultimap<K, V> extends FilteredMultimap<K, V>, SetMultimap<K, V> {

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.common.collect.FilteredSetMultimap$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<K, V> {
    }

    SetMultimap<K, V> unfiltered();
}
