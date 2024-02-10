package org.koin.androidx.viewmodel;

import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lorg/koin/androidx/viewmodel/ViewModelOwner;", "", "storeOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "stateRegistry", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getStateRegistry", "()Landroidx/savedstate/SavedStateRegistryOwner;", "getStoreOwner", "()Landroidx/lifecycle/ViewModelStoreOwner;", "Companion", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "Replaced by ViewModelStoreOwner")
/* compiled from: ViewModelOwner.kt */
public final class ViewModelOwner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final SavedStateRegistryOwner stateRegistry;
    private final ViewModelStoreOwner storeOwner;

    public ViewModelOwner(ViewModelStoreOwner viewModelStoreOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "storeOwner");
        this.storeOwner = viewModelStoreOwner;
        this.stateRegistry = savedStateRegistryOwner;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelOwner(ViewModelStoreOwner viewModelStoreOwner, SavedStateRegistryOwner savedStateRegistryOwner, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewModelStoreOwner, (i & 2) != 0 ? null : savedStateRegistryOwner);
    }

    public final ViewModelStoreOwner getStoreOwner() {
        return this.storeOwner;
    }

    public final SavedStateRegistryOwner getStateRegistry() {
        return this.stateRegistry;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001H\u0007¨\u0006\u000b"}, d2 = {"Lorg/koin/androidx/viewmodel/ViewModelOwner$Companion;", "", "()V", "from", "Lorg/koin/androidx/viewmodel/ViewModelOwner;", "storeOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "stateRegistry", "Landroidx/savedstate/SavedStateRegistryOwner;", "fromAny", "owner", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ViewModelOwner.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ViewModelOwner from$default(Companion companion, ViewModelStoreOwner viewModelStoreOwner, SavedStateRegistryOwner savedStateRegistryOwner, int i, Object obj) {
            if ((i & 2) != 0) {
                savedStateRegistryOwner = null;
            }
            return companion.from(viewModelStoreOwner, savedStateRegistryOwner);
        }

        @Deprecated(message = "Replaced by ViewModelStoreOwner")
        public final ViewModelOwner from(ViewModelStoreOwner viewModelStoreOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "storeOwner");
            return new ViewModelOwner(viewModelStoreOwner, savedStateRegistryOwner);
        }

        @Deprecated(message = "Replaced by ViewModelStoreOwner")
        public final ViewModelOwner from(ViewModelStoreOwner viewModelStoreOwner) {
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "storeOwner");
            return new ViewModelOwner(viewModelStoreOwner, (SavedStateRegistryOwner) null, 2, (DefaultConstructorMarker) null);
        }

        @Deprecated(message = "Replaced by ViewModelStoreOwner")
        public final ViewModelOwner fromAny(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "owner");
            return new ViewModelOwner((ViewModelStoreOwner) obj, obj instanceof SavedStateRegistryOwner ? (SavedStateRegistryOwner) obj : null);
        }
    }
}
