package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.internal.cast.zzag;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public class CastReasonCodes {
    public static final int APPLICATION_LAUNCH_ERROR = 10;
    public static final int CASTING_ROUTE_CHANGED = 9;
    public static final int CASTING_STOPPED = 2;
    public static final int CAST_CANCELLED = 11;
    public static final int CAST_INTERNAL_ERROR = 1;
    public static final int CAST_SOCKET_ERROR = 6;
    public static final int CAST_TIMEOUT = 7;
    public static final int NETWORK_ERROR = 8;
    public static final int RECEIVER_APP_NOT_RUNNING = 3;
    public static final int SESSION_RESUME_FAILED = 5;
    public static final int SESSION_START_FAILED = 4;
    public static final int UNKNOWN_REASON = 0;
    private final Map zza;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
    public @interface CastReasonType {
    }

    public CastReasonCodes(Bundle bundle) {
        this.zza = zzag.zza(bundle, "com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES");
    }

    public final int zza(int i) {
        Integer num;
        Map map = this.zza;
        if (map != null) {
            Integer valueOf = Integer.valueOf(i);
            if (map.containsKey(valueOf) && (num = (Integer) this.zza.get(valueOf)) != null) {
                return num.intValue();
            }
        }
        return 0;
    }
}
