package com.m2catalyst.m2sdk.logger;

import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH&J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH&J\u001c\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\nH&J4\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/M2LoggingListener;", "", "onErrorLogged", "", "event", "Lcom/m2catalyst/m2sdk/logger/Event;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "name", "", "message", "onEventLogged", "tag", "params", "", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: M2SDKLoggerConfiguration.kt */
public interface M2LoggingListener {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: M2SDKLoggerConfiguration.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onErrorLogged$default(M2LoggingListener m2LoggingListener, Event event, Exception exc, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    exc = null;
                }
                m2LoggingListener.onErrorLogged(event, exc);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onErrorLogged");
        }

        public static /* synthetic */ void onEventLogged$default(M2LoggingListener m2LoggingListener, String str, String str2, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    map = null;
                }
                m2LoggingListener.onEventLogged(str, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEventLogged");
        }

        public static /* synthetic */ void onErrorLogged$default(M2LoggingListener m2LoggingListener, String str, String str2, Exception exc, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    exc = null;
                }
                m2LoggingListener.onErrorLogged(str, str2, exc);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onErrorLogged");
        }

        public static /* synthetic */ void onEventLogged$default(M2LoggingListener m2LoggingListener, Event event, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                m2LoggingListener.onEventLogged(event, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEventLogged");
        }
    }

    void onErrorLogged(Event event, Exception exc);

    void onErrorLogged(String str, String str2, Exception exc);

    void onEventLogged(Event event, String str);

    void onEventLogged(String str, String str2, Map<String, ? extends Object> map);
}
