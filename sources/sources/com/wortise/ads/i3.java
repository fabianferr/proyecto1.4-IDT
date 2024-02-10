package com.wortise.ads;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "", "listener", "", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: Gestures.kt */
public final class i3 {

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/wortise/ads/i3$a", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapConfirmed", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Gestures.kt */
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ Function1<View, Boolean> a;
        final /* synthetic */ View b;

        a(Function1<? super View, Boolean> function1, View view) {
            this.a = function1;
            this.b = view;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return this.a.invoke(this.b).booleanValue();
        }
    }

    public static final void a(View view, Function1<? super View, Boolean> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        view.setOnTouchListener(new i3$$ExternalSyntheticLambda0(new GestureDetector(view.getContext(), new a(function1, view))));
    }

    /* access modifiers changed from: private */
    public static final boolean a(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(gestureDetector, "$detector");
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }
}
