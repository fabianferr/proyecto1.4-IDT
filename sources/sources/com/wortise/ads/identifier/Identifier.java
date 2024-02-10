package com.wortise.ads.identifier;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/wortise/ads/identifier/Identifier;", "", "id", "", "limitAdTracking", "", "type", "Lcom/wortise/ads/identifier/IdentifierType;", "(Ljava/lang/String;ZLcom/wortise/ads/identifier/IdentifierType;)V", "getId", "()Ljava/lang/String;", "getLimitAdTracking", "()Z", "getType", "()Lcom/wortise/ads/identifier/IdentifierType;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Identifier.kt */
public final class Identifier {
    @SerializedName("id")
    private final String id;
    @SerializedName("limitAdTracking")
    private final boolean limitAdTracking;
    @SerializedName("type")
    private final IdentifierType type;

    public Identifier(String str, boolean z, IdentifierType identifierType) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.limitAdTracking = z;
        this.type = identifierType;
    }

    public static /* synthetic */ Identifier copy$default(Identifier identifier, String str, boolean z, IdentifierType identifierType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = identifier.id;
        }
        if ((i & 2) != 0) {
            z = identifier.limitAdTracking;
        }
        if ((i & 4) != 0) {
            identifierType = identifier.type;
        }
        return identifier.copy(str, z, identifierType);
    }

    public final String component1() {
        return this.id;
    }

    public final boolean component2() {
        return this.limitAdTracking;
    }

    public final IdentifierType component3() {
        return this.type;
    }

    public final Identifier copy(String str, boolean z, IdentifierType identifierType) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new Identifier(str, z, identifierType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Identifier)) {
            return false;
        }
        Identifier identifier = (Identifier) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) identifier.id) && this.limitAdTracking == identifier.limitAdTracking && this.type == identifier.type;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getLimitAdTracking() {
        return this.limitAdTracking;
    }

    public final IdentifierType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        boolean z = this.limitAdTracking;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        IdentifierType identifierType = this.type;
        return i + (identifierType == null ? 0 : identifierType.hashCode());
    }

    public String toString() {
        return "Identifier(id=" + this.id + ", limitAdTracking=" + this.limitAdTracking + ", type=" + this.type + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Identifier(String str, boolean z, IdentifierType identifierType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? null : identifierType);
    }
}
