package com.wortise.ads;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\u000b\u001a\u00020\t8CX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/wortise/ads/t2;", "", "Landroid/view/View;", "decor", "", "b", "a", "Landroid/view/Window;", "window", "", "()I", "insetTypes", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Fullscreen.kt */
public final class t2 {
    public static final t2 a = new t2();

    private t2() {
    }

    private final int a() {
        return WindowInsets.Type.navigationBars() | WindowInsets.Type.statusBars();
    }

    private final void b(View view) {
        view.setSystemUiVisibility(4871);
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "decor");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                windowInsetsController.hide(a());
                return;
            }
            return;
        }
        b(view);
    }

    public final void a(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        a(decorView);
    }
}
