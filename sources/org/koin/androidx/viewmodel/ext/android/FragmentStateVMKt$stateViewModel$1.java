package org.koin.androidx.viewmodel.ext.android;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "T", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 5, 1}, xi = 176)
/* compiled from: FragmentStateVM.kt */
public final class FragmentStateVMKt$stateViewModel$1 extends Lambda implements Function0<Fragment> {
    final /* synthetic */ Fragment $this_stateViewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentStateVMKt$stateViewModel$1(Fragment fragment) {
        super(0);
        this.$this_stateViewModel = fragment;
    }

    public final Fragment invoke() {
        return this.$this_stateViewModel;
    }
}
