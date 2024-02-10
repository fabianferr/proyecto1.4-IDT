package org.koin.android.scope;

import android.app.Service;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.koin.core.logger.Logger;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lorg/koin/android/scope/ScopeService;", "Landroid/app/Service;", "Lorg/koin/android/scope/AndroidScopeComponent;", "initialiseScope", "", "(Z)V", "scope", "Lorg/koin/core/scope/Scope;", "getScope", "()Lorg/koin/core/scope/Scope;", "scope$delegate", "Lkotlin/Lazy;", "onCreate", "", "onDestroy", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ScopeService.kt */
public abstract class ScopeService extends Service implements AndroidScopeComponent {
    private final boolean initialiseScope;
    private final Lazy scope$delegate;

    public ScopeService() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScopeService(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public ScopeService(boolean z) {
        this.initialiseScope = z;
        this.scope$delegate = ServiceExtKt.serviceScope(this);
    }

    public Scope getScope() {
        return (Scope) this.scope$delegate.getValue();
    }

    public void onCreate() {
        super.onCreate();
        if (this.initialiseScope) {
            Logger logger = getScope().getLogger();
            logger.debug("Open Service Scope: " + getScope());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Logger logger = getScope().getLogger();
        logger.debug("Close service scope: " + getScope());
        if (!getScope().getClosed()) {
            getScope().close();
        }
    }
}
