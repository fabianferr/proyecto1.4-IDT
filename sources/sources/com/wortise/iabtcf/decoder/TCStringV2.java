package com.wortise.iabtcf.decoder;

import com.wortise.iabtcf.exceptions.InvalidRangeFieldException;
import com.wortise.iabtcf.utils.BitReader;
import com.wortise.iabtcf.utils.BitSetIntIterable;
import com.wortise.iabtcf.utils.FieldDefs;
import com.wortise.iabtcf.utils.IntIterable;
import com.wortise.iabtcf.utils.Objects;
import com.wortise.iabtcf.v2.PublisherRestriction;
import com.wortise.iabtcf.v2.RestrictionType;
import com.wortise.iabtcf.v2.SegmentType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

class TCStringV2 implements TCString {
    private IntIterable allowedVendors;
    private final BitReader bbv;
    private final EnumSet<FieldDefs> cache;
    private String consentLanguage;
    private int consentManagerProviderId;
    private int consentManagerProviderVersion;
    private Date consentRecordCreated;
    private Date consentRecordLastUpdated;
    private int consentScreen;
    private IntIterable customPurposesConsent;
    private IntIterable customPurposesLITransparency;
    private IntIterable disclosedVendors;
    private boolean isPurposeOneTreatment;
    private boolean isServiceSpecific;
    private int policyVersion;
    private String publisherCountryCode;
    private IntIterable publisherPurposesConsent;
    private IntIterable publisherPurposesLITransparency;
    private List<PublisherRestriction> publisherRestrictions;
    private IntIterable purposesConsent;
    private IntIterable purposesLITransparency;
    private final Collection<BitReader> remainingVectors;
    private IntIterable specialFeaturesOptInts;
    private boolean useNonStandardStacks;
    private IntIterable vendorConsents;
    private IntIterable vendorLegitimateInterests;
    private int vendorListVersion;
    private int version;

    public boolean getDefaultVendorConsent() {
        return false;
    }

    private TCStringV2(BitReader bitReader) {
        this(bitReader, new BitReader[0]);
    }

    private TCStringV2(BitReader bitReader, BitReader... bitReaderArr) {
        this.cache = EnumSet.noneOf(FieldDefs.class);
        this.bbv = bitReader;
        this.remainingVectors = Arrays.asList(bitReaderArr);
    }

    public static TCStringV2 fromBitVector(BitReader bitReader, BitReader... bitReaderArr) {
        return new TCStringV2(bitReader, bitReaderArr);
    }

    private BitReader getSegment(SegmentType segmentType) {
        if (segmentType == SegmentType.DEFAULT) {
            return this.bbv;
        }
        for (BitReader next : this.remainingVectors) {
            if (segmentType == SegmentType.from(next.readBits3(FieldDefs.OOB_SEGMENT_TYPE))) {
                return next;
            }
        }
        return null;
    }

    public IntIterable getPubPurposesConsent() {
        if (this.cache.add(FieldDefs.PPTC_PUB_PURPOSES_CONSENT)) {
            this.publisherPurposesConsent = BitSetIntIterable.EMPTY;
            BitReader segment = getSegment(SegmentType.PUBLISHER_TC);
            if (segment != null) {
                this.publisherPurposesConsent = fillBitSet(segment, FieldDefs.PPTC_PUB_PURPOSES_CONSENT);
            }
        }
        return this.publisherPurposesConsent;
    }

    static BitSetIntIterable fillVendors(BitReader bitReader, FieldDefs fieldDefs, FieldDefs fieldDefs2) {
        BitSet bitSet = new BitSet();
        int readBits16 = bitReader.readBits16(fieldDefs);
        if (bitReader.readBits1(fieldDefs.getEnd(bitReader))) {
            vendorIdsFromRange(bitReader, bitSet, fieldDefs2, fieldDefs);
        } else {
            for (int i = 0; i < readBits16; i++) {
                if (bitReader.readBits1(fieldDefs2.getOffset(bitReader) + i)) {
                    bitSet.set(i + 1);
                }
            }
        }
        return BitSetIntIterable.from(bitSet);
    }

    static int vendorIdsFromRange(BitReader bitReader, BitSet bitSet, int i, FieldDefs fieldDefs) {
        int readBits12 = bitReader.readBits12(i);
        int length = i + FieldDefs.NUM_ENTRIES.getLength(bitReader);
        int readBits16 = fieldDefs != null ? bitReader.readBits16(fieldDefs) : Integer.MAX_VALUE;
        for (int i2 = 0; i2 < readBits12; i2++) {
            int i3 = length + 1;
            boolean readBits1 = bitReader.readBits1(length);
            int readBits162 = bitReader.readBits16(i3);
            int length2 = i3 + FieldDefs.START_OR_ONLY_VENDOR_ID.getLength(bitReader);
            if (readBits1) {
                int readBits163 = bitReader.readBits16(length2);
                length2 += FieldDefs.START_OR_ONLY_VENDOR_ID.getLength(bitReader);
                if (readBits162 > readBits163) {
                    throw new InvalidRangeFieldException(String.format("start vendor id (%d) is greater than endVendorId (%d)", new Object[]{Integer.valueOf(readBits162), Integer.valueOf(readBits163)}));
                } else if (readBits163 <= readBits16) {
                    bitSet.set(readBits162, readBits163 + 1);
                } else {
                    throw new InvalidRangeFieldException(String.format("end vendor id (%d) is greater than max (%d)", new Object[]{Integer.valueOf(readBits163), Integer.valueOf(readBits16)}));
                }
            } else {
                bitSet.set(readBits162);
            }
            length = length2;
        }
        return length;
    }

    static void vendorIdsFromRange(BitReader bitReader, BitSet bitSet, FieldDefs fieldDefs, FieldDefs fieldDefs2) {
        vendorIdsFromRange(bitReader, bitSet, fieldDefs.getOffset(bitReader), fieldDefs2);
    }

    private int fillPublisherRestrictions(List<PublisherRestriction> list, int i, BitReader bitReader) {
        int readBits12 = bitReader.readBits12(i);
        int length = i + FieldDefs.NUM_ENTRIES.getLength(bitReader);
        for (int i2 = 0; i2 < readBits12; i2++) {
            byte readBits6 = bitReader.readBits6(length);
            int length2 = length + FieldDefs.PURPOSE_ID.getLength(bitReader);
            RestrictionType from = RestrictionType.from(bitReader.readBits2(length2));
            BitSet bitSet = new BitSet();
            length = vendorIdsFromRange(this.bbv, bitSet, length2 + 2, (FieldDefs) null);
            list.add(new PublisherRestriction(readBits6, from, BitSetIntIterable.from(bitSet)));
        }
        return length;
    }

    static BitSetIntIterable fillBitSet(BitReader bitReader, FieldDefs fieldDefs) {
        int offset = fieldDefs.getOffset(bitReader);
        int length = fieldDefs.getLength(bitReader);
        BitSetIntIterable.Builder newBuilder = BitSetIntIterable.newBuilder();
        for (int i = 0; i < length; i++) {
            if (bitReader.readBits1(offset + i)) {
                newBuilder.add(i + 1);
            }
        }
        return newBuilder.build();
    }

    public int getVersion() {
        if (this.cache.add(FieldDefs.CORE_VERSION)) {
            this.version = this.bbv.readBits6(FieldDefs.CORE_VERSION);
        }
        return this.version;
    }

    public Date getCreated() {
        if (this.cache.add(FieldDefs.CORE_CREATED)) {
            this.consentRecordCreated = new Date(this.bbv.readBits36(FieldDefs.CORE_CREATED) * 100);
        }
        return this.consentRecordCreated;
    }

    public Date getLastUpdated() {
        if (this.cache.add(FieldDefs.CORE_LAST_UPDATED)) {
            this.consentRecordLastUpdated = new Date(this.bbv.readBits36(FieldDefs.CORE_LAST_UPDATED) * 100);
        }
        return this.consentRecordLastUpdated;
    }

    public int getCmpId() {
        if (this.cache.add(FieldDefs.CORE_CMP_ID)) {
            this.consentManagerProviderId = (short) this.bbv.readBits12(FieldDefs.CORE_CMP_ID);
        }
        return this.consentManagerProviderId;
    }

    public int getCmpVersion() {
        if (this.cache.add(FieldDefs.CORE_CMP_VERSION)) {
            this.consentManagerProviderVersion = (short) this.bbv.readBits12(FieldDefs.CORE_CMP_VERSION);
        }
        return this.consentManagerProviderVersion;
    }

    public int getConsentScreen() {
        if (this.cache.add(FieldDefs.CORE_CONSENT_SCREEN)) {
            this.consentScreen = this.bbv.readBits6(FieldDefs.CORE_CONSENT_SCREEN);
        }
        return this.consentScreen;
    }

    public String getConsentLanguage() {
        if (this.cache.add(FieldDefs.CORE_CONSENT_LANGUAGE)) {
            this.consentLanguage = this.bbv.readStr2(FieldDefs.CORE_CONSENT_LANGUAGE);
        }
        return this.consentLanguage;
    }

    public int getVendorListVersion() {
        if (this.cache.add(FieldDefs.CORE_VENDOR_LIST_VERSION)) {
            this.vendorListVersion = (short) this.bbv.readBits12(FieldDefs.CORE_VENDOR_LIST_VERSION);
        }
        return this.vendorListVersion;
    }

    public IntIterable getPurposesConsent() {
        if (this.cache.add(FieldDefs.CORE_PURPOSES_CONSENT)) {
            this.purposesConsent = fillBitSet(this.bbv, FieldDefs.CORE_PURPOSES_CONSENT);
        }
        return this.purposesConsent;
    }

    public IntIterable getVendorConsent() {
        if (this.cache.add(FieldDefs.CORE_VENDOR_BITRANGE_FIELD)) {
            this.vendorConsents = fillVendors(this.bbv, FieldDefs.CORE_VENDOR_MAX_VENDOR_ID, FieldDefs.CORE_VENDOR_BITRANGE_FIELD);
        }
        return this.vendorConsents;
    }

    public int getTcfPolicyVersion() {
        if (this.cache.add(FieldDefs.CORE_TCF_POLICY_VERSION)) {
            this.policyVersion = this.bbv.readBits6(FieldDefs.CORE_TCF_POLICY_VERSION);
        }
        return this.policyVersion;
    }

    public boolean isServiceSpecific() {
        if (this.cache.add(FieldDefs.CORE_IS_SERVICE_SPECIFIC)) {
            this.isServiceSpecific = this.bbv.readBits1(FieldDefs.CORE_IS_SERVICE_SPECIFIC);
        }
        return this.isServiceSpecific;
    }

    public boolean getUseNonStandardStacks() {
        if (this.cache.add(FieldDefs.CORE_USE_NON_STANDARD_STOCKS)) {
            this.useNonStandardStacks = this.bbv.readBits1(FieldDefs.CORE_USE_NON_STANDARD_STOCKS);
        }
        return this.useNonStandardStacks;
    }

    public IntIterable getSpecialFeatureOptIns() {
        if (this.cache.add(FieldDefs.CORE_SPECIAL_FEATURE_OPT_INS)) {
            this.specialFeaturesOptInts = fillBitSet(this.bbv, FieldDefs.CORE_SPECIAL_FEATURE_OPT_INS);
        }
        return this.specialFeaturesOptInts;
    }

    public IntIterable getPurposesLITransparency() {
        if (this.cache.add(FieldDefs.CORE_PURPOSES_LI_TRANSPARENCY)) {
            this.purposesLITransparency = fillBitSet(this.bbv, FieldDefs.CORE_PURPOSES_LI_TRANSPARENCY);
        }
        return this.purposesLITransparency;
    }

    public boolean getPurposeOneTreatment() {
        if (this.cache.add(FieldDefs.CORE_PURPOSE_ONE_TREATMENT)) {
            this.isPurposeOneTreatment = this.bbv.readBits1(FieldDefs.CORE_PURPOSE_ONE_TREATMENT);
        }
        return this.isPurposeOneTreatment;
    }

    public String getPublisherCC() {
        if (this.cache.add(FieldDefs.CORE_PUBLISHER_CC)) {
            this.publisherCountryCode = this.bbv.readStr2(FieldDefs.CORE_PUBLISHER_CC);
        }
        return this.publisherCountryCode;
    }

    public IntIterable getVendorLegitimateInterest() {
        if (this.cache.add(FieldDefs.CORE_VENDOR_LI_BITRANGE_FIELD)) {
            this.vendorLegitimateInterests = fillVendors(this.bbv, FieldDefs.CORE_VENDOR_LI_MAX_VENDOR_ID, FieldDefs.CORE_VENDOR_LI_BITRANGE_FIELD);
        }
        return this.vendorLegitimateInterests;
    }

    public List<PublisherRestriction> getPublisherRestrictions() {
        if (this.cache.add(FieldDefs.CORE_PUB_RESTRICTION_ENTRY)) {
            ArrayList arrayList = new ArrayList();
            this.publisherRestrictions = arrayList;
            fillPublisherRestrictions(arrayList, FieldDefs.CORE_NUM_PUB_RESTRICTION.getOffset(this.bbv), this.bbv);
        }
        return this.publisherRestrictions;
    }

    public IntIterable getAllowedVendors() {
        if (this.cache.add(FieldDefs.AV_VENDOR_BITRANGE_FIELD)) {
            this.allowedVendors = BitSetIntIterable.EMPTY;
            BitReader segment = getSegment(SegmentType.ALLOWED_VENDOR);
            if (segment != null) {
                this.allowedVendors = fillVendors(segment, FieldDefs.AV_MAX_VENDOR_ID, FieldDefs.AV_VENDOR_BITRANGE_FIELD);
            }
        }
        return this.allowedVendors;
    }

    public IntIterable getDisclosedVendors() {
        if (this.cache.add(FieldDefs.DV_VENDOR_BITRANGE_FIELD)) {
            this.disclosedVendors = BitSetIntIterable.EMPTY;
            BitReader segment = getSegment(SegmentType.DISCLOSED_VENDOR);
            if (segment != null) {
                this.disclosedVendors = fillVendors(segment, FieldDefs.DV_MAX_VENDOR_ID, FieldDefs.DV_VENDOR_BITRANGE_FIELD);
            }
        }
        return this.disclosedVendors;
    }

    public IntIterable getPubPurposesLITransparency() {
        if (this.cache.add(FieldDefs.PPTC_PUB_PURPOSES_LI_TRANSPARENCY)) {
            this.publisherPurposesLITransparency = BitSetIntIterable.EMPTY;
            BitReader segment = getSegment(SegmentType.PUBLISHER_TC);
            if (segment != null) {
                this.publisherPurposesLITransparency = fillBitSet(segment, FieldDefs.PPTC_PUB_PURPOSES_LI_TRANSPARENCY);
            }
        }
        return this.publisherPurposesLITransparency;
    }

    public IntIterable getCustomPurposesConsent() {
        if (this.cache.add(FieldDefs.PPTC_CUSTOM_PURPOSES_CONSENT)) {
            this.customPurposesConsent = BitSetIntIterable.EMPTY;
            BitReader segment = getSegment(SegmentType.PUBLISHER_TC);
            if (segment != null) {
                this.customPurposesConsent = fillBitSet(segment, FieldDefs.PPTC_CUSTOM_PURPOSES_CONSENT);
            }
        }
        return this.customPurposesConsent;
    }

    public IntIterable getCustomPurposesLITransparency() {
        if (this.cache.add(FieldDefs.PPTC_CUSTOM_PURPOSES_LI_TRANSPARENCY)) {
            this.customPurposesLITransparency = BitSetIntIterable.EMPTY;
            BitReader segment = getSegment(SegmentType.PUBLISHER_TC);
            if (segment != null) {
                this.customPurposesLITransparency = fillBitSet(segment, FieldDefs.PPTC_CUSTOM_PURPOSES_LI_TRANSPARENCY);
            }
        }
        return this.customPurposesLITransparency;
    }

    public int hashCode() {
        return Objects.hash(getAllowedVendors(), getConsentLanguage(), Integer.valueOf(getCmpId()), Integer.valueOf(getCmpVersion()), getCreated(), getLastUpdated(), Integer.valueOf(getConsentScreen()), getCustomPurposesConsent(), getCustomPurposesLITransparency(), getDisclosedVendors(), Boolean.valueOf(getPurposeOneTreatment()), Boolean.valueOf(isServiceSpecific()), Integer.valueOf(getTcfPolicyVersion()), getPublisherCC(), getPubPurposesConsent(), getPubPurposesLITransparency(), getPublisherRestrictions(), getPurposesConsent(), getPurposesLITransparency(), getSpecialFeatureOptIns(), Boolean.valueOf(getUseNonStandardStacks()), getVendorConsent(), getVendorLegitimateInterest(), Integer.valueOf(getVendorListVersion()), Integer.valueOf(getVersion()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TCStringV2 tCStringV2 = (TCStringV2) obj;
        if (!Objects.equals(getAllowedVendors(), tCStringV2.getAllowedVendors()) || !Objects.equals(getConsentLanguage(), tCStringV2.getConsentLanguage()) || getCmpId() != tCStringV2.getCmpId() || getCmpVersion() != tCStringV2.getCmpVersion() || !Objects.equals(getCreated(), tCStringV2.getCreated()) || !Objects.equals(getLastUpdated(), tCStringV2.getLastUpdated()) || getConsentScreen() != tCStringV2.getConsentScreen() || !Objects.equals(getCustomPurposesConsent(), tCStringV2.getCustomPurposesConsent()) || !Objects.equals(getCustomPurposesLITransparency(), tCStringV2.getCustomPurposesLITransparency()) || !Objects.equals(getDisclosedVendors(), tCStringV2.getDisclosedVendors()) || getPurposeOneTreatment() != tCStringV2.getPurposeOneTreatment() || isServiceSpecific() != tCStringV2.isServiceSpecific() || getTcfPolicyVersion() != tCStringV2.getTcfPolicyVersion() || !Objects.equals(getPublisherCC(), tCStringV2.getPublisherCC()) || !Objects.equals(getPubPurposesConsent(), tCStringV2.getPubPurposesConsent()) || !Objects.equals(getPubPurposesLITransparency(), tCStringV2.getPubPurposesLITransparency()) || !Objects.equals(getPublisherRestrictions(), tCStringV2.getPublisherRestrictions()) || !Objects.equals(getPurposesConsent(), tCStringV2.getPurposesConsent()) || !Objects.equals(getPurposesLITransparency(), tCStringV2.getPurposesLITransparency()) || !Objects.equals(getSpecialFeatureOptIns(), tCStringV2.getSpecialFeatureOptIns()) || getUseNonStandardStacks() != tCStringV2.getUseNonStandardStacks() || !Objects.equals(getVendorConsent(), tCStringV2.getVendorConsent()) || !Objects.equals(getVendorLegitimateInterest(), tCStringV2.getVendorLegitimateInterest()) || getVendorListVersion() != tCStringV2.getVendorListVersion() || getVersion() != tCStringV2.getVersion()) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "TCStringV2 [getVersion()=" + getVersion() + ", getCreated()=" + getCreated() + ", getLastUpdated()=" + getLastUpdated() + ", getCmpId()=" + getCmpId() + ", getCmpVersion()=" + getCmpVersion() + ", getConsentScreen()=" + getConsentScreen() + ", getConsentLanguage()=" + getConsentLanguage() + ", getVendorListVersion()=" + getVendorListVersion() + ", getTcfPolicyVersion()=" + getTcfPolicyVersion() + ", isServiceSpecific()=" + isServiceSpecific() + ", getUseNonStandardStacks()=" + getUseNonStandardStacks() + ", getSpecialFeatureOptIns()=" + getSpecialFeatureOptIns() + ", getPurposesConsent()=" + getPurposesConsent() + ", getPurposesLITransparency()=" + getPurposesLITransparency() + ", getPurposeOneTreatment()=" + getPurposeOneTreatment() + ", getPublisherCC()=" + getPublisherCC() + ", getVendorConsent()=" + getVendorConsent() + ", getVendorLegitimateInterest()=" + getVendorLegitimateInterest() + ", getPublisherRestrictions()=" + getPublisherRestrictions() + ", getDisclosedVendors()=" + getDisclosedVendors() + ", getAllowedVendors()=" + getAllowedVendors() + ", getPubPurposesConsent()=" + getPubPurposesConsent() + ", getPubPurposesLITransparency()=" + getPubPurposesLITransparency() + ", getCustomPurposesConsent()=" + getCustomPurposesConsent() + ", getCustomPurposesLITransparency()=" + getCustomPurposesLITransparency() + "]";
    }
}
