package com.ironsource.mediationsdk.services;

import com.ironsource.mediationsdk.services.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ironsource/mediationsdk/services/MediationServices;", "Lcom/ironsource/mediationsdk/services/IMediationServiceProvider;", "Lcom/ironsource/mediationsdk/services/IMediationServiceEditor;", "()V", "sessionDepthManager", "Lcom/ironsource/mediationsdk/services/SessionDepthManager;", "getSessionDepthService", "Lcom/ironsource/mediationsdk/services/ISessionDepthService;", "getSessionDepthServiceEditor", "Lcom/ironsource/mediationsdk/services/ISessionDepthService$Editor;", "Companion", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MediationServices implements IMediationServiceEditor, IMediationServiceProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<MediationServices> b = LazyKt.lazy(a.a);
    private final b a;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/ironsource/mediationsdk/services/MediationServices$Companion;", "", "()V", "editor", "Lcom/ironsource/mediationsdk/services/IMediationServiceEditor;", "getEditor$annotations", "getEditor", "()Lcom/ironsource/mediationsdk/services/IMediationServiceEditor;", "instance", "Lcom/ironsource/mediationsdk/services/MediationServices;", "getInstance", "()Lcom/ironsource/mediationsdk/services/MediationServices;", "instance$delegate", "Lkotlin/Lazy;", "provider", "Lcom/ironsource/mediationsdk/services/IMediationServiceProvider;", "getProvider$annotations", "getProvider", "()Lcom/ironsource/mediationsdk/services/IMediationServiceProvider;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static MediationServices a() {
            return (MediationServices) MediationServices.b.getValue();
        }

        @JvmStatic
        public static /* synthetic */ void getEditor$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getProvider$annotations() {
        }

        public final IMediationServiceEditor getEditor() {
            return a();
        }

        public final IMediationServiceProvider getProvider() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ironsource/mediationsdk/services/MediationServices;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends Lambda implements Function0<MediationServices> {
        public static final a a = new a();

        a() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            return new MediationServices((DefaultConstructorMarker) null);
        }
    }

    private MediationServices() {
        this.a = new b();
    }

    public /* synthetic */ MediationServices(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final IMediationServiceEditor getEditor() {
        return Companion.getEditor();
    }

    public static final IMediationServiceProvider getProvider() {
        return Companion.getProvider();
    }

    public final a getSessionDepthService() {
        return this.a;
    }

    public final a.C0114a getSessionDepthServiceEditor() {
        return this.a;
    }
}
