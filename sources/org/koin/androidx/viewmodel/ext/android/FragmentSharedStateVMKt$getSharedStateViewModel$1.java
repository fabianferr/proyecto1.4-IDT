package org.koin.androidx.viewmodel.ext.android;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/fragment/app/FragmentActivity;", "T", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 5, 1}, xi = 176)
/* compiled from: FragmentSharedStateVM.kt */
public final class FragmentSharedStateVMKt$getSharedStateViewModel$1 extends Lambda implements Function0<FragmentActivity> {
    final /* synthetic */ Fragment $this_getSharedStateViewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentSharedStateVMKt$getSharedStateViewModel$1(Fragment fragment) {
        super(0);
        this.$this_getSharedStateViewModel = fragment;
    }

    public final FragmentActivity invoke() {
        FragmentActivity requireActivity = this.$this_getSharedStateViewModel.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return requireActivity;
    }
}
