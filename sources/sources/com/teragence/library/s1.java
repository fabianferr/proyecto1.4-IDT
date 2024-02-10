package com.teragence.library;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;

public class s1 {
    private final int a;

    public s1(int i, Context context) {
        this.a = i;
    }

    public String toString() {
        try {
            switch (this.a) {
                case 0:
                    return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 4:
                    return "CDMA";
                case 5:
                    return "EVDO-0";
                case 6:
                    return "EVDO-A";
                case 7:
                    return "1xRTT";
                case 8:
                    return "HSDPA";
                case 9:
                    return "HSUPA";
                case 10:
                    return "HSPA";
                case 11:
                    return "iDen";
                case 12:
                    return "EVDO-B";
                case 13:
                    return "LTE";
                case 14:
                    return "eHRPD";
                case 15:
                    return "HSPA+";
                case 16:
                    return "GSM";
                case 17:
                    return "TD-SCDMA";
                case 18:
                    return "IWLAN";
                case 20:
                    return "NR";
                default:
                    return "Unknown: " + Integer.toString(this.a);
            }
        } catch (Exception unused) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
