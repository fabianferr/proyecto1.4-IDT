package io.monedata.extensions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007H\bø\u0001\u0000\u001aD\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\b2\u0016\b\u0004\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007H\bø\u0001\u0000\u001aY\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\b\u0000\u0010\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\t2&\b\u0004\u0010\u0006\u001a \b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\nH\bø\u0001\u0001¢\u0006\u0002\u0010\f\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"mapTry", "", "R", "T", "", "", "block", "Lkotlin/Function1;", "Lkotlin/sequences/Sequence;", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "core_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SafeMapKt {
    public static final <T, R> List<R> mapTry(Collection<? extends T> collection, Function1<? super T, ? extends R> function1) {
        Object obj;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        Collection arrayList = new ArrayList();
        for (Object next : collection) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m2344constructorimpl(function1.invoke(next));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m2350isFailureimpl(obj)) {
                obj = null;
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return (List) arrayList;
    }

    public static final <T, R> Sequence<R> mapTry(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        return SequencesKt.mapNotNull(sequence, new SafeMapKt$mapTry$3(function1));
    }

    public static final <T, R> Flow<R> mapTry(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(function2, "block");
        return new SafeMapKt$mapTry$$inlined$mapNotNull$1(flow, function2);
    }
}
