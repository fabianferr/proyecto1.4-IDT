package io.monedata.iabtcf.decoder;

import android.util.Base64;
import io.monedata.iabtcf.exceptions.ByteParseException;
import io.monedata.iabtcf.exceptions.UnsupportedVersionException;
import io.monedata.iabtcf.utils.BitReader;
import io.monedata.iabtcf.utils.FieldDefs;
import io.monedata.iabtcf.utils.IntIterable;
import io.monedata.iabtcf.utils.Objects;
import java.util.Date;

public class PPCString {
    private final BitReader bbv;

    private PPCString(BitReader bitReader) {
        this.bbv = bitReader;
    }

    public static PPCString decode(String str) throws IllegalArgumentException, ByteParseException, UnsupportedVersionException {
        return new PPCString(new BitReader(Base64.decode(str, 8)));
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

    public int getPublisherPurposesVersion() {
        return this.bbv.readBits12(FieldDefs.V1_PPC_PUBLISHER_PURPOSES_VERSION);
    }

    public IntIterable getStandardPurposesAllowed() {
        return TCStringV2.fillBitSet(this.bbv, FieldDefs.V1_PPC_STANDARD_PURPOSES_ALLOWED);
    }

    public IntIterable getCustomPurposesBitField() {
        return TCStringV2.fillBitSet(this.bbv, FieldDefs.V1_PPC_CUSTOM_PURPOSES_BITFIELD);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(getVersion()), getCreated(), getLastUpdated(), Integer.valueOf(getCmpId()), Integer.valueOf(getCmpVersion()), Integer.valueOf(getConsentScreen()), getConsentLanguage(), Integer.valueOf(getVendorListVersion()), Integer.valueOf(getPublisherPurposesVersion()), getStandardPurposesAllowed(), getCustomPurposesBitField());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PPCString pPCString = (PPCString) obj;
        if (getVersion() != pPCString.getVersion() || !Objects.equals(getCreated(), pPCString.getCreated()) || !Objects.equals(getLastUpdated(), pPCString.getLastUpdated()) || getCmpId() != pPCString.getCmpId() || getCmpVersion() != pPCString.getCmpVersion() || getConsentScreen() != pPCString.getConsentScreen() || !Objects.equals(getConsentLanguage(), pPCString.getConsentLanguage()) || getVendorListVersion() != pPCString.getVendorListVersion() || !Objects.equals(Integer.valueOf(getPublisherPurposesVersion()), Integer.valueOf(pPCString.getPublisherPurposesVersion())) || !Objects.equals(getStandardPurposesAllowed(), pPCString.getStandardPurposesAllowed()) || !Objects.equals(getCustomPurposesBitField(), pPCString.getCustomPurposesBitField())) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "PPCString [getVersion()=" + getVersion() + ", getCreated()=" + getCreated() + ", getLastUpdated()=" + getLastUpdated() + ", getCmpId()=" + getCmpId() + ", getCmpVersion()=" + getCmpVersion() + ", getConsentScreen()=" + getConsentScreen() + ", getConsentLanguage()=" + getConsentLanguage() + ", getVendorListVersion()=" + getVendorListVersion() + ", getPublisherPurposesVersion()=" + getPublisherPurposesVersion() + ", getStandardPurposesAllowed()=" + getStandardPurposesAllowed() + ", getCustomPurposesBitField()=" + getCustomPurposesBitField() + "]";
    }
}
