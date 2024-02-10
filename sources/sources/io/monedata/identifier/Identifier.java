package io.monedata.identifier;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lio/monedata/identifier/Identifier;", "", "id", "", "isLimitAdTrackingEnabled", "", "type", "Lio/monedata/identifier/IdentifierType;", "(Ljava/lang/String;ZLio/monedata/identifier/IdentifierType;)V", "getId", "()Ljava/lang/String;", "()Z", "getType", "()Lio/monedata/identifier/IdentifierType;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Identifier {
    private final String id;
    private final boolean isLimitAdTrackingEnabled;
    private final IdentifierType type;

    public Identifier(String str, boolean z, IdentifierType identifierType) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(identifierType, "type");
        this.id = str;
        this.isLimitAdTrackingEnabled = z;
        this.type = identifierType;
    }

    public static /* synthetic */ Identifier copy$default(Identifier identifier, String str, boolean z, IdentifierType identifierType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = identifier.id;
        }
        if ((i & 2) != 0) {
            z = identifier.isLimitAdTrackingEnabled;
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
        return this.isLimitAdTrackingEnabled;
    }

    public final IdentifierType component3() {
        return this.type;
    }

    public final Identifier copy(String str, boolean z, IdentifierType identifierType) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(identifierType, "type");
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
        return Intrinsics.areEqual((Object) this.id, (Object) identifier.id) && this.isLimitAdTrackingEnabled == identifier.isLimitAdTrackingEnabled && this.type == identifier.type;
    }

    public final String getId() {
        return this.id;
    }

    public final IdentifierType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        boolean z = this.isLimitAdTrackingEnabled;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + this.type.hashCode();
    }

    public final boolean isLimitAdTrackingEnabled() {
        return this.isLimitAdTrackingEnabled;
    }

    public String toString() {
        return "Identifier(id=" + this.id + ", isLimitAdTrackingEnabled=" + this.isLimitAdTrackingEnabled + ", type=" + this.type + ')';
    }
}
