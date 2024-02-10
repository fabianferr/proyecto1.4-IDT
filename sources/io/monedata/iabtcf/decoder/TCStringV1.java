package io.monedata.iabtcf.decoder;

import io.monedata.iabtcf.utils.BitReader;
import io.monedata.iabtcf.utils.BitSetIntIterable;
import io.monedata.iabtcf.utils.FieldDefs;
import io.monedata.iabtcf.utils.IntIterable;
import io.monedata.iabtcf.utils.Objects;
import io.monedata.iabtcf.v2.PublisherRestriction;
import java.util.BitSet;
import java.util.Date;
import java.util.List;

class TCStringV1 implements TCString {
    private final BitReader bbv;

    private TCStringV1(BitReader bitReader) {
        this.bbv = bitReader;
    }

    public static TCStringV1 fromBitVector(BitReader bitReader) {
        return new TCStringV1(bitReader);
    }

    public int getVersion() {
        return this.bbv.readBits6(FieldDefs.V1_VERSION);
    }

    public Date getCreated() {
        return new Date(this.bbv.readBits36(FieldDefs.V1_CREATED) * 100);
    }

    public Date getLastUpdated() {
        return new Date(this.bbv.readBits36(FieldDefs.V1_LAST_UPDATED) * 100);
    }

    public int getCmpId() {
        return this.bbv.readBits12(FieldDefs.V1_CMP_ID);
    }

    public int getCmpVersion() {
        return this.bbv.readBits12(FieldDefs.V1_CMP_VERSION);
    }

    public int getConsentScreen() {
        return this.bbv.readBits6(FieldDefs.V1_CONSENT_SCREEN);
    }

    public String getConsentLanguage() {
        return this.bbv.readStr2(FieldDefs.V1_CONSENT_LANGUAGE);
    }

    public int getVendorListVersion() {
        return this.bbv.readBits12(FieldDefs.V1_VENDOR_LIST_VERSION);
    }

    public IntIterable getVendorConsent() {
        return fillVendorsV1(this.bbv, FieldDefs.V1_VENDOR_MAX_VENDOR_ID, FieldDefs.V1_VENDOR_BITRANGE_FIELD);
    }

    public boolean getDefaultVendorConsent() {
        return this.bbv.readBits1(FieldDefs.V1_VENDOR_IS_RANGE_ENCODING) && this.bbv.readBits1(FieldDefs.V1_VENDOR_DEFAULT_CONSENT);
    }

    public IntIterable getPurposesConsent() {
        return TCStringV2.fillBitSet(this.bbv, FieldDefs.V1_PURPOSES_ALLOW);
    }

    public int getTcfPolicyVersion() {
        throw new UnsupportedOperationException();
    }

    public boolean isServiceSpecific() {
        throw new UnsupportedOperationException();
    }

    public boolean getUseNonStandardStacks() {
        throw new UnsupportedOperationException();
    }

    public IntIterable getSpecialFeatureOptIns() {
        throw new UnsupportedOperationException();
    }

    public IntIterable getPurposesLITransparency() {
        throw new UnsupportedOperationException();
    }

    public boolean getPurposeOneTreatment() {
        throw new UnsupportedOperationException();
    }

    public String getPublisherCC() {
        throw new UnsupportedOperationException();
    }

    public IntIterable getVendorLegitimateInterest() {
        throw new UnsupportedOperationException();
    }

    public List<PublisherRestriction> getPublisherRestrictions() {
        throw new UnsupportedOperationException();
    }

    public IntIterable getAllowedVendors() {
        throw new UnsupportedOperationException();
    }

    public IntIterable getDisclosedVendors() {
        throw new UnsupportedOperationException();
    }

    public IntIterable getPubPurposesConsent() {
        throw new UnsupportedOperationException();
    }

    public IntIterable getPubPurposesLITransparency() {
        throw new UnsupportedOperationException();
    }

    public IntIterable getCustomPurposesConsent() {
        throw new UnsupportedOperationException();
    }

    public IntIterable getCustomPurposesLITransparency() {
        throw new UnsupportedOperationException();
    }

    private IntIterable fillVendorsV1(BitReader bitReader, FieldDefs fieldDefs, FieldDefs fieldDefs2) {
        BitSet bitSet = new BitSet();
        int readBits16 = bitReader.readBits16(fieldDefs);
        if (bitReader.readBits1(fieldDefs.getEnd(bitReader))) {
            boolean readBits1 = bitReader.readBits1(FieldDefs.V1_VENDOR_DEFAULT_CONSENT);
            TCStringV2.vendorIdsFromRange(bitReader, bitSet, FieldDefs.V1_VENDOR_NUM_ENTRIES.getOffset(bitReader), fieldDefs);
            if (readBits1) {
                bitSet.flip(1, readBits16 + 1);
            }
        } else {
            for (int i = 0; i < readBits16; i++) {
                if (bitReader.readBits1(fieldDefs2.getOffset(bitReader) + i)) {
                    bitSet.set(i + 1);
                }
            }
        }
        return BitSetIntIterable.from(bitSet);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(getVersion()), getCreated(), getLastUpdated(), Integer.valueOf(getCmpId()), Integer.valueOf(getCmpVersion()), Integer.valueOf(getConsentScreen()), getConsentLanguage(), Integer.valueOf(getVendorListVersion()), getVendorConsent(), Boolean.valueOf(getDefaultVendorConsent()), getPurposesConsent());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TCStringV1 tCStringV1 = (TCStringV1) obj;
        if (getVersion() == tCStringV1.getVersion() && Objects.equals(getCreated(), tCStringV1.getCreated()) && Objects.equals(getLastUpdated(), tCStringV1.getLastUpdated()) && getCmpId() == tCStringV1.getCmpId() && getCmpVersion() == tCStringV1.getCmpVersion() && getConsentScreen() == tCStringV1.getConsentScreen() && Objects.equals(getConsentLanguage(), tCStringV1.getConsentLanguage()) && getVendorListVersion() == tCStringV1.getVendorListVersion() && Objects.equals(getVendorConsent(), tCStringV1.getVendorConsent()) && getDefaultVendorConsent() == tCStringV1.getDefaultVendorConsent() && Objects.equals(getPurposesConsent(), tCStringV1.getPurposesConsent())) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "TCStringV1 [getVersion()=" + getVersion() + ", getCreated()=" + getCreated() + ", getLastUpdated()=" + getLastUpdated() + ", getCmpId()=" + getCmpId() + ", getCmpVersion()=" + getCmpVersion() + ", getConsentScreen()=" + getConsentScreen() + ", getConsentLanguage()=" + getConsentLanguage() + ", getVendorListVersion()=" + getVendorListVersion() + ", getVendorConsent()=" + getVendorConsent() + ", getDefaultVendorConsent()=" + getDefaultVendorConsent() + ", getPurposesConsent()=" + getPurposesConsent() + "]";
    }
}
