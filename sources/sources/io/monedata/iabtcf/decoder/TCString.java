package io.monedata.iabtcf.decoder;

import io.monedata.iabtcf.utils.IntIterable;
import io.monedata.iabtcf.v2.PublisherRestriction;
import java.util.Date;
import java.util.List;

public interface TCString {
    IntIterable getAllowedVendors();

    int getCmpId();

    int getCmpVersion();

    String getConsentLanguage();

    int getConsentScreen();

    Date getCreated();

    IntIterable getCustomPurposesConsent();

    IntIterable getCustomPurposesLITransparency();

    boolean getDefaultVendorConsent();

    IntIterable getDisclosedVendors();

    Date getLastUpdated();

    IntIterable getPubPurposesConsent();

    IntIterable getPubPurposesLITransparency();

    String getPublisherCC();

    List<PublisherRestriction> getPublisherRestrictions();

    boolean getPurposeOneTreatment();

    IntIterable getPurposesConsent();

    IntIterable getPurposesLITransparency();

    IntIterable getSpecialFeatureOptIns();

    int getTcfPolicyVersion();

    boolean getUseNonStandardStacks();

    IntIterable getVendorConsent();

    IntIterable getVendorLegitimateInterest();

    int getVendorListVersion();

    int getVersion();

    boolean isServiceSpecific();
}
