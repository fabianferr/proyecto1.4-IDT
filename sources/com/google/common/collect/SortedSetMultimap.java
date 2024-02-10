package com.google.common.collect;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public interface SortedSetMultimap<K, V> extends SetMultimap<K, V> {

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.common.collect.SortedSetMultimap$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<K, V> {
    }

    Map<K, Collection<V>> asMap();

    SortedSet<V> get(@ParametricNullness K k);

    SortedSet<V> removeAll(@CheckForNull Object obj);

    SortedSet<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable);

    @CheckForNull
    Comparator<? super V> valueComparator();
}
