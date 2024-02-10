package io.monedata.partners.models;

import io.monedata.partners.PartnerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/monedata/partners/models/AdapterException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "adapter", "Lio/monedata/partners/PartnerAdapter;", "message", "", "cause", "", "(Lio/monedata/partners/PartnerAdapter;Ljava/lang/String;Ljava/lang/Throwable;)V", "getAdapter", "()Lio/monedata/partners/PartnerAdapter;", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AdapterException extends Exception {
    private final PartnerAdapter adapter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdapterException(PartnerAdapter partnerAdapter, String str, Throwable th) {
        super(str, th);
        Intrinsics.checkNotNullParameter(partnerAdapter, "adapter");
        this.adapter = partnerAdapter;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdapterException(PartnerAdapter partnerAdapter, String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(partnerAdapter, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : th);
    }

    public final PartnerAdapter getAdapter() {
        return this.adapter;
    }
}
