package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/Animator;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Animator.kt */
final class AnimatorKt$addPauseListener$2 extends Lambda implements Function1<Animator, Unit> {
    public static final AnimatorKt$addPauseListener$2 INSTANCE = new AnimatorKt$addPauseListener$2();

    AnimatorKt$addPauseListener$2() {
        super(1);
    }

    public final void invoke(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Animator) obj);
        return Unit.INSTANCE;
    }
}