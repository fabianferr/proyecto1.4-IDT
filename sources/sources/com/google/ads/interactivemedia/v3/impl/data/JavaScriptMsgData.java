package com.google.ads.interactivemedia.v3.impl.data;

import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.google.ads.interactivemedia.v3.internal.zzaie;
import com.google.ads.interactivemedia.v3.internal.zzaig;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public class JavaScriptMsgData {
    public double adBreakDuration;
    public String adBreakTime;
    public List<Float> adCuePoints;
    public AdImpl adData;
    public double adPeriodDuration;
    public AdPodInfoImpl adPodInfo;
    public int adPosition;
    public long adTimeUpdateMs;
    public long appSetIdTimeoutMs;
    public double bufferedTime;
    public Map<String, CompanionData> companions;
    public List<CuePointData> cuepoints;
    public double currentTime;
    public boolean disableAppSetId;
    public double duration;
    public boolean enableGks;
    public boolean enableInstrumentation;
    public boolean enableTrustlessGksBc;
    public boolean enableTrustlessGksDai;
    public int errorCode;
    public String errorMessage;
    public Integer espAdapterTimeoutMs;
    public List<String> espAdapters;
    public String eventId;
    public List<String> gksFirstPartyAdServers;
    public int gksTimeoutMs;
    public List<zzbb> iconClickFallbackImages;
    public String innerError;
    public SortedSet<Float> internalCuePoints;
    public String ln;
    public LogData logData;
    public String m;
    public boolean monitorAppLifecycle;
    public String n;
    public NetworkRequestData networkRequest;
    public Integer platformSignalCollectorTimeoutMs;
    public String queryId;
    public ResizeAndPositionVideoMsgData resizeAndPositionVideo;
    public double seekTime;
    public String streamId;
    public String streamUrl;
    public List<HashMap<String, String>> subtitles;
    public int totalAds;
    public String url;
    public boolean useAndroidAdshieldV2;
    public String vastEvent;
    public String videoUrl;

    /* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
    public static class LogData {
        public int errorCode;
        public String errorMessage;
        public String innerError;
        public String type;

        public Map<String, String> constructMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("type", this.type);
            hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, String.valueOf(this.errorCode));
            hashMap.put("errorMessage", this.errorMessage);
            String str = this.innerError;
            if (str != null) {
                hashMap.put("innerError", str);
            }
            return hashMap;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            return zzaie.zzf(this, obj, false, (Class) null, false, new String[0]);
        }

        public int hashCode() {
            return zzaig.zza(this, new String[0]);
        }

        public String toString() {
            return String.format("Log[type=%s, errorCode=%s, errorMessage=%s, innerError=%s]", new Object[]{this.type, Integer.valueOf(this.errorCode), this.errorMessage, this.innerError});
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return zzaie.zzf(this, obj, false, (Class) null, false, new String[0]);
    }

    public int hashCode() {
        return zzaig.zza(this, new String[0]);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("JavaScriptMsgData[");
        for (Field field : JavaScriptMsgData.class.getFields()) {
            try {
                Object obj = field.get(this);
                sb.append(field.getName());
                sb.append(CertificateUtil.DELIMITER);
                sb.append(obj);
                sb.append(",");
            } catch (IllegalArgumentException e) {
                Log.e("IMASDK", "IllegalArgumentException occurred", e);
            } catch (IllegalAccessException e2) {
                Log.e("IMASDK", "IllegalAccessException occurred", e2);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
