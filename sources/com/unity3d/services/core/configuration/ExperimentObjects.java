package com.unity3d.services.core.configuration;

import com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class ExperimentObjects extends ExperimentsBase {
    private final Map<String, ExperimentObject> _experimentObjects = new HashMap();
    private final JSONObject _experimentObjetsData;

    public ExperimentObjects(JSONObject jSONObject) {
        if (jSONObject != null) {
            this._experimentObjetsData = jSONObject;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this._experimentObjects.put(next, new ExperimentObject(jSONObject.optJSONObject(next)));
            }
            return;
        }
        this._experimentObjetsData = new JSONObject();
    }

    public ExperimentObject getExperimentObject(String str) {
        return this._experimentObjects.get(str);
    }

    public boolean shouldNativeTokenAwaitPrivacy() {
        return getExperimentValueOrDefault("tsi_prw");
    }

    public boolean isNativeWebViewCacheEnabled() {
        return getExperimentValueOrDefault("nwc");
    }

    public boolean isWebAssetAdCaching() {
        return getExperimentValueOrDefault("wac");
    }

    public boolean isWebGestureNotRequired() {
        return getExperimentValueOrDefault("wgr");
    }

    public boolean isScarInitEnabled() {
        return getExperimentValueOrDefault("scar_init");
    }

    public String getScarBiddingManager() {
        return getExperimentValue("scar_bm", SCARBiddingManagerType.DISABLED.getName());
    }

    public boolean isJetpackLifecycle() {
        return getExperimentValueOrDefault("gjl");
    }

    public boolean isOkHttpEnabled() {
        return getExperimentValueOrDefault("okhttp");
    }

    public boolean isWebMessageEnabled() {
        return getExperimentValueOrDefault("jwm");
    }

    public boolean isWebViewAsyncDownloadEnabled() {
        return getExperimentValueOrDefault("wad");
    }

    public boolean isCronetCheckEnabled() {
        return getExperimentValueOrDefault("cce");
    }

    private String getExperimentValue(String str, String str2) {
        ExperimentObject experimentObject = getExperimentObject(str);
        return experimentObject != null ? experimentObject.getStringValue() : str2;
    }

    private boolean getExperimentValue(String str, boolean z) {
        ExperimentObject experimentObject = getExperimentObject(str);
        return experimentObject != null ? experimentObject.getBooleanValue() : z;
    }

    private boolean getExperimentValueOrDefault(String str) {
        return getExperimentValue(str, false);
    }

    public JSONObject getExperimentsAsJson() {
        return this._experimentObjetsData;
    }

    public Map<String, String> getExperimentTags() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this._experimentObjects.entrySet()) {
            hashMap.put((String) next.getKey(), ((ExperimentObject) next.getValue()).getStringValue());
        }
        return hashMap;
    }

    public JSONObject getCurrentSessionExperiments() {
        return getExperimentWithAppliedRule(ExperimentAppliedRule.IMMEDIATE);
    }

    public JSONObject getNextSessionExperiments() {
        return getExperimentWithAppliedRule(ExperimentAppliedRule.NEXT);
    }

    private JSONObject getExperimentWithAppliedRule(ExperimentAppliedRule experimentAppliedRule) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this._experimentObjects.entrySet()) {
            if (((ExperimentObject) next.getValue()).getAppliedRule() == experimentAppliedRule) {
                hashMap.put((String) next.getKey(), ((ExperimentObject) next.getValue()).getStringValue());
            }
        }
        return new JSONObject(hashMap);
    }
}
