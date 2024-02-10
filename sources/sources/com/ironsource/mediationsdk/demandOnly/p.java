package com.ironsource.mediationsdk.demandOnly;

import android.app.Activity;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.demandOnly.s;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/LoadParameters;", "Lcom/ironsource/mediationsdk/demandOnly/Validator;", "Abstract", "DemandOnlyBanner", "DemandOnlyInterstitial", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface p extends s {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/LoadParameters$Abstract;", "Lcom/ironsource/mediationsdk/demandOnly/LoadParameters;", "instanceId", "", "(Ljava/lang/String;)V", "adm", "getAdm", "()Ljava/lang/String;", "setAdm", "getInstanceId", "isBidding", "", "()Z", "setBidding", "(Z)V", "validate", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class a implements p {
        final String a;
        String b;
        boolean c;

        public a(String str) {
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public final void a(String str) {
            this.b = str;
        }

        public final void a(boolean z) {
            this.c = true;
        }

        public final String b() {
            return this.b;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/LoadParameters$DemandOnlyBanner;", "Lcom/ironsource/mediationsdk/demandOnly/LoadParameters$Abstract;", "instanceId", "", "(Ljava/lang/String;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "banner", "Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyBannerLayout;", "getBanner", "()Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyBannerLayout;", "setBanner", "(Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyBannerLayout;)V", "validate", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends a {
        Activity d;
        ISDemandOnlyBannerLayout e;

        public b(String str) {
            super(str);
        }

        public final void a(Activity activity) {
            this.d = activity;
        }

        public final void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout) {
            this.e = iSDemandOnlyBannerLayout;
        }

        public final ISDemandOnlyBannerLayout c() {
            return this.e;
        }

        public final IronSourceError d() {
            IronSourceError ironSourceError;
            new s.a();
            p pVar = this;
            Intrinsics.checkNotNullParameter(pVar, "loadParams");
            b bVar = (b) pVar;
            if (bVar.d == null) {
                ironSourceError = new IronSourceError(IronSourceError.ERROR_DO_BN_LOAD_MISSING_ACTIVITY, "Banner was initialized and loaded without Activity");
            } else {
                ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout = bVar.e;
                if (iSDemandOnlyBannerLayout == null) {
                    ironSourceError = new IronSourceError(510, "Missing banner layout");
                } else {
                    Intrinsics.checkNotNull(iSDemandOnlyBannerLayout);
                    if (iSDemandOnlyBannerLayout.isDestroyed()) {
                        ironSourceError = new IronSourceError(510, "Banner layout is destroyed");
                    } else {
                        ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout2 = bVar.e;
                        Intrinsics.checkNotNull(iSDemandOnlyBannerLayout2);
                        ISBannerSize size = iSDemandOnlyBannerLayout2.getSize();
                        if (size == null) {
                            ironSourceError = new IronSourceError(510, "Missing banner size");
                        } else if ("CUSTOM" == size.getDescription() && (size.getHeight() <= 0 || size.getWidth() <= 0)) {
                            ironSourceError = new IronSourceError(510, "Unsupported banner size. Height and width must be bigger than 0");
                        } else if (bVar.a == null) {
                            ironSourceError = new IronSourceError(510, "Missing instance Id");
                        } else {
                            CharSequence charSequence = bVar.b;
                            ironSourceError = (!(charSequence == null || charSequence.length() == 0) || !bVar.c) ? null : new IronSourceError(510, "Missing adm");
                        }
                    }
                }
            }
            if (ironSourceError != null) {
                return ironSourceError;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/LoadParameters$DemandOnlyInterstitial;", "Lcom/ironsource/mediationsdk/demandOnly/LoadParameters$Abstract;", "instanceId", "", "(Ljava/lang/String;)V", "validate", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends a {
        public c(String str) {
            super(str);
        }

        public final IronSourceError c() {
            IronSourceError ironSourceError;
            new s.b();
            p pVar = this;
            Intrinsics.checkNotNullParameter(pVar, "loadParams");
            c cVar = (c) pVar;
            if (cVar.a == null) {
                ironSourceError = new IronSourceError(510, "Missing instance Id");
            } else {
                CharSequence charSequence = cVar.b;
                ironSourceError = (!(charSequence == null || charSequence.length() == 0) || !cVar.c) ? null : new IronSourceError(510, "Missing adm");
            }
            if (ironSourceError != null) {
                return ironSourceError;
            }
            return null;
        }
    }
}
