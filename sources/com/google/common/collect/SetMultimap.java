package com.google.common.collect;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public interface SetMultimap<K, V> extends Multimap<K, V> {

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.common.collect.SetMultimap$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<K, V> {
    }

    Map<K, Collection<V>> asMap();

    Set<Map.Entry<K, V>> entries();

    boolean equals(@CheckForNull Object obj);

    Set<V> get(@ParametricNullness K k);

    Set<V> removeAll(@CheckForNull Object obj);

    Set<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable);
}
