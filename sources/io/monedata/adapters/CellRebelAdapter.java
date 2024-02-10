package io.monedata.adapters;

import android.content.Context;
import com.cellrebel.sdk.workers.TrackingManager;
import io.monedata.adapters.cellrebel.BuildConfig;
import io.monedata.models.Extras;
import io.monedata.partners.ConsentPartnerAdapter;
import io.monedata.partners.extensions.PartnerAdapterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lio/monedata/adapters/CellRebelAdapter;", "Lio/monedata/partners/ConsentPartnerAdapter;", "()V", "consentConfig", "Lio/monedata/adapters/CellRebelConsent;", "getConsentConfig", "()Lio/monedata/adapters/CellRebelConsent;", "onInitialize", "", "context", "Landroid/content/Context;", "extras", "Lio/monedata/models/Extras;", "(Landroid/content/Context;Lio/monedata/models/Extras;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStart", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStop", "Companion", "adapter-cellrebel_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CellRebelAdapter.kt */
public final class CellRebelAdapter extends ConsentPartnerAdapter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_CLIENT = "clientKey";
    private final CellRebelConsent consentConfig = CellRebelConsent.INSTANCE;

    public CellRebelAdapter() {
        super("cellrebel", "CellRebel", BuildConfig.ADAPTER_VERSION);
    }

    /* access modifiers changed from: protected */
    public CellRebelConsent getConsentConfig() {
        return this.consentConfig;
    }

    /* access modifiers changed from: protected */
    public Object onInitialize(Context context, Extras extras, Continuation<? super Unit> continuation) {
        TrackingManager.init(context, (String) PartnerAdapterKt.testNotNullOrEmpty(this, Extras.getString$default(extras, KEY_CLIENT, (String) null, 2, (Object) null)));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public Object onStart(Context context, Continuation<? super Unit> continuation) {
        TrackingManager.startTracking(context);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public Object onStop(Context context, Continuation<? super Unit> continuation) {
        TrackingManager.stopTracking(context);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lio/monedata/adapters/CellRebelAdapter$Companion;", "", "()V", "KEY_CLIENT", "", "adapter-cellrebel_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CellRebelAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
