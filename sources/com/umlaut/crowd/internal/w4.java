package com.umlaut.crowd.internal;

import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.timeserver.TimeServer;
import java.util.Map;

public class w4 {
    public static void a(v4 v4Var, u4 u4Var, Map<String, String> map) {
        InsightCore.OnLoggingEventListener onLoggingEventListener;
        if (InsightCore.isInitialized()) {
            if (v4Var == v4.ConnectivityTest && !InsightCore.getInsightConfig().Y()) {
                return;
            }
            if (v4Var == v4.LatencyTest && !InsightCore.getInsightConfig().K0()) {
                return;
            }
            if ((v4Var != v4.UploadResults || InsightCore.getInsightConfig().F1()) && (onLoggingEventListener = InsightCore.getOnLoggingEventListener()) != null) {
                onLoggingEventListener.onLoggingEvent(u4Var, TimeServer.getTimeInMillis(), map);
            }
        }
    }
}
