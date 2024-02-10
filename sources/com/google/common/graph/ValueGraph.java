package com.google.common.graph;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public interface ValueGraph<N, V> extends BaseGraph<N> {

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.common.graph.ValueGraph$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<N, V> {
    }

    Set<N> adjacentNodes(N n);

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N n);

    @CheckForNull
    V edgeValueOrDefault(EndpointPair<N> endpointPair, @CheckForNull V v);

    @CheckForNull
    V edgeValueOrDefault(N n, N n2, @CheckForNull V v);

    Set<EndpointPair<N>> edges();

    boolean equals(@CheckForNull Object obj);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    int inDegree(N n);

    ElementOrder<N> incidentEdgeOrder();

    Set<EndpointPair<N>> incidentEdges(N n);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n);

    Set<N> predecessors(N n);

    Set<N> successors(N n);
}
