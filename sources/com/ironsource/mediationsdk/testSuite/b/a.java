package com.ironsource.mediationsdk.testSuite.b;

import com.ironsource.mediationsdk.testSuite.d;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/ironsource/mediationsdk/testSuite/events/TestSuiteEventsManager;", "", "()V", "getTestSuiteMetaDataValues", "Lorg/json/JSONArray;", "logEvent", "", "eventId", "", "errorCode", "errorReason", "", "(ILjava/lang/Integer;Ljava/lang/String;)V", "onTestSuiteLaunch", "onTestSuiteLaunchFailed", "onTestSuiteLaunchedSuccessfully", "onTestSuiteWebControllerFailedToLoad", "onTestSuiteWebControllerOpened", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {
    public static final a a = new a();

    private a() {
    }

    private static JSONArray c() {
        d dVar = d.a;
        ConcurrentHashMap<String, List<String>> b = d.b();
        if (b.containsKey("is_test_suite")) {
            return new JSONArray(b.get("is_test_suite"));
        }
        return null;
    }

    public final void a() {
        a(70, (Integer) null, (String) null);
    }

    public final void a(int i) {
        a(72, Integer.valueOf(i), (String) null);
    }

    public final void a(int i, Integer num, String str) {
        d dVar = d.a;
        JSONObject a2 = d.a(false);
        if (num != null) {
            a2.put(IronSourceConstants.EVENTS_ERROR_CODE, num.intValue());
            JSONArray c = c();
            if (c != null) {
                a2.put("is_test_suite", c);
            }
        }
        if (str != null) {
            a2.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        }
        d dVar2 = d.a;
        d.a(i, a2);
    }

    public final void b() {
        a(71, (Integer) null, (String) null);
    }
}
