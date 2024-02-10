package io.monedata.extensions;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 7, 1}, xi = 176)
public final class SafeMapKt$mapTry$$inlined$mapNotNull$1 implements Flow<R> {
    final /* synthetic */ Function2 $block$inlined;
    final /* synthetic */ Flow $this_unsafeTransform$inlined;

    public SafeMapKt$mapTry$$inlined$mapNotNull$1(Flow flow, Function2 function2) {
        this.$this_unsafeTransform$inlined = flow;
        this.$block$inlined = function2;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final Function2 function2 = this.$block$inlined;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x006f  */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x0072  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof io.monedata.extensions.SafeMapKt$mapTry$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    io.monedata.extensions.SafeMapKt$mapTry$$inlined$mapNotNull$1$2$1 r0 = (io.monedata.extensions.SafeMapKt$mapTry$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    io.monedata.extensions.SafeMapKt$mapTry$$inlined$mapNotNull$1$2$1 r0 = new io.monedata.extensions.SafeMapKt$mapTry$$inlined$mapNotNull$1$2$1
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003e
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L_0x007d
                L_0x002c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0034:
                    java.lang.Object r7 = r0.L$0
                    kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                    kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x003c }
                    goto L_0x0055
                L_0x003c:
                    r8 = move-exception
                    goto L_0x005e
                L_0x003e:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r4
                    kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x005a }
                    kotlin.jvm.functions.Function2 r2 = r2     // Catch:{ all -> 0x005a }
                    r0.L$0 = r8     // Catch:{ all -> 0x005a }
                    r0.label = r4     // Catch:{ all -> 0x005a }
                    java.lang.Object r7 = r2.invoke(r7, r0)     // Catch:{ all -> 0x005a }
                    if (r7 != r1) goto L_0x0052
                    return r1
                L_0x0052:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L_0x0055:
                    java.lang.Object r8 = kotlin.Result.m2344constructorimpl(r8)     // Catch:{ all -> 0x003c }
                    goto L_0x0068
                L_0x005a:
                    r7 = move-exception
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L_0x005e:
                    kotlin.Result$Companion r2 = kotlin.Result.Companion
                    java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
                    java.lang.Object r8 = kotlin.Result.m2344constructorimpl(r8)
                L_0x0068:
                    boolean r2 = kotlin.Result.m2350isFailureimpl(r8)
                    r4 = 0
                    if (r2 == 0) goto L_0x0070
                    r8 = r4
                L_0x0070:
                    if (r8 == 0) goto L_0x007d
                    r0.L$0 = r4
                    r0.label = r3
                    java.lang.Object r7 = r7.emit(r8, r0)
                    if (r7 != r1) goto L_0x007d
                    return r1
                L_0x007d:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: io.monedata.extensions.SafeMapKt$mapTry$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }

            public final Object emit$$forInline(Object obj, Continuation continuation) {
                Object obj2;
                InlineMarker.mark(4);
                new ContinuationImpl(this, continuation) {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;
                    final /* synthetic */ AnonymousClass2 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.emit((Object) null, this);
                    }
                };
                InlineMarker.mark(5);
                FlowCollector flowCollector = r4;
                try {
                    Result.Companion companion = Result.Companion;
                    obj2 = Result.m2344constructorimpl(r2.invoke(obj, continuation));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.m2344constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m2350isFailureimpl(obj2)) {
                    obj2 = null;
                }
                if (obj2 != null) {
                    InlineMarker.mark(0);
                    flowCollector.emit(obj2, continuation);
                    InlineMarker.mark(1);
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public Object collect$$forInline(final FlowCollector flowCollector, Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ SafeMapKt$mapTry$$inlined$mapNotNull$1 this$0;

            {
                this.this$0 = r1;
            }

            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.collect((FlowCollector) null, this);
            }
        };
        InlineMarker.mark(5);
        Flow flow = this.$this_unsafeTransform$inlined;
        final Function2 function2 = this.$block$inlined;
        InlineMarker.mark(0);
        flow.collect(new FlowCollector() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof io.monedata.extensions.SafeMapKt$mapTry$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    io.monedata.extensions.SafeMapKt$mapTry$$inlined$mapNotNull$1$2$1 r0 = (io.monedata.extensions.SafeMapKt$mapTry$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    io.monedata.extensions.SafeMapKt$mapTry$$inlined$mapNotNull$1$2$1 r0 = new io.monedata.extensions.SafeMapKt$mapTry$$inlined$mapNotNull$1$2$1
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003e
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L_0x007d
                L_0x002c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0034:
                    java.lang.Object r7 = r0.L$0
                    kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                    kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x003c }
                    goto L_0x0055
                L_0x003c:
                    r8 = move-exception
                    goto L_0x005e
                L_0x003e:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r4
                    kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x005a }
                    kotlin.jvm.functions.Function2 r2 = r2     // Catch:{ all -> 0x005a }
                    r0.L$0 = r8     // Catch:{ all -> 0x005a }
                    r0.label = r4     // Catch:{ all -> 0x005a }
                    java.lang.Object r7 = r2.invoke(r7, r0)     // Catch:{ all -> 0x005a }
                    if (r7 != r1) goto L_0x0052
                    return r1
                L_0x0052:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L_0x0055:
                    java.lang.Object r8 = kotlin.Result.m2344constructorimpl(r8)     // Catch:{ all -> 0x003c }
                    goto L_0x0068
                L_0x005a:
                    r7 = move-exception
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L_0x005e:
                    kotlin.Result$Companion r2 = kotlin.Result.Companion
                    java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
                    java.lang.Object r8 = kotlin.Result.m2344constructorimpl(r8)
                L_0x0068:
                    boolean r2 = kotlin.Result.m2350isFailureimpl(r8)
                    r4 = 0
                    if (r2 == 0) goto L_0x0070
                    r8 = r4
                L_0x0070:
                    if (r8 == 0) goto L_0x007d
                    r0.L$0 = r4
                    r0.label = r3
                    java.lang.Object r7 = r7.emit(r8, r0)
                    if (r7 != r1) goto L_0x007d
                    return r1
                L_0x007d:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: io.monedata.extensions.SafeMapKt$mapTry$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }

            public final Object emit$$forInline(Object obj, Continuation continuation) {
                Object obj2;
                InlineMarker.mark(4);
                new ContinuationImpl(this, continuation) {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;
                    final /* synthetic */ AnonymousClass2 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.emit((Object) null, this);
                    }
                };
                InlineMarker.mark(5);
                FlowCollector flowCollector = flowCollector;
                try {
                    Result.Companion companion = Result.Companion;
                    obj2 = Result.m2344constructorimpl(function2.invoke(obj, continuation));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.m2344constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m2350isFailureimpl(obj2)) {
                    obj2 = null;
                }
                if (obj2 != null) {
                    InlineMarker.mark(0);
                    flowCollector.emit(obj2, continuation);
                    InlineMarker.mark(1);
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
