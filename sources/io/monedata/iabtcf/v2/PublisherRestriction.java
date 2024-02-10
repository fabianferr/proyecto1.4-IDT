package io.monedata.iabtcf.v2;

import io.monedata.iabtcf.utils.IntIterable;
import io.monedata.iabtcf.utils.IntIterator;
import java.util.Objects;
import java.util.StringJoiner;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class PublisherRestriction {
    private final int purposeId;
    private final RestrictionType restrictionType;
    private final IntIterable vendorIds;

    public PublisherRestriction(int i, RestrictionType restrictionType2, IntIterable intIterable) {
        Objects.requireNonNull(intIterable);
        Objects.requireNonNull(restrictionType2);
        this.purposeId = i;
        this.restrictionType = restrictionType2;
        this.vendorIds = intIterable;
    }

    public int getPurposeId() {
        return this.purposeId;
    }

    public RestrictionType getRestrictionType() {
        return this.restrictionType;
    }

    public IntIterable getVendorIds() {
        return this.vendorIds;
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        IntIterator intIterator = getVendorIds().intIterator();
        while (intIterator.hasNext()) {
            stringJoiner.add(((Integer) intIterator.next()).toString());
        }
        return "PublisherRestriction{purposeId=" + this.purposeId + ", restrictionType=" + this.restrictionType + ", vendorIds=" + stringJoiner.toString() + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PublisherRestriction publisherRestriction = (PublisherRestriction) obj;
        if (this.purposeId == publisherRestriction.purposeId && this.restrictionType == publisherRestriction.restrictionType && this.vendorIds.equals(publisherRestriction.vendorIds)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.purposeId), this.restrictionType, this.vendorIds});
    }
}
