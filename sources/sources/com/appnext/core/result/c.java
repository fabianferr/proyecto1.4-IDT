package com.appnext.core.result;

import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.SettingsManager;
import org.json.JSONException;
import org.json.JSONObject;

public interface c {
    a A();

    JSONObject getConfigParams() throws JSONException;

    String getPlacementId();

    AppnextAd getSelectedAd();

    String v();

    String w();

    String x();

    SettingsManager y();

    Ad z();
}
