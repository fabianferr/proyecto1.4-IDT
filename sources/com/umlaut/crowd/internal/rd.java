package com.umlaut.crowd.internal;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.telephony.PreciseDisconnectCause;
import android.util.Log;
import androidx.core.app.FrameMetricsAggregator;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.cast.MediaError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.umlaut.crowd.enums.NetworkTypes;
import com.umlaut.crowd.enums.ThreeState;
import com.umlaut.crowd.utils.DateUtils;
import java.util.List;

class rd {
    private static final boolean a = false;
    private static final String b = "rd";
    static final int c = 2048;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.umlaut.crowd.enums.NetworkGenerations[] r0 = com.umlaut.crowd.enums.NetworkGenerations.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen2     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen3     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen4     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen5SA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.rd.a.<clinit>():void");
        }
    }

    rd() {
    }

    static int a(int i) {
        switch (i) {
            case 200:
                return 16;
            case 400:
            case 405:
                return 6;
            case 406:
                return 17;
            case 408:
            case 1114:
            case IronSourceConstants.RV_CAP_SESSION:
                return 8;
            case 438:
                return 22;
            case 480:
                return 41;
            case 484:
                return 1;
            case 500:
                return 42;
            case 580:
            case IronSourceConstants.RV_INSTANCE_SHOW:
                return 43;
            case 1103:
                return 18;
            case 1108:
                return 21;
            case IronSourceConstants.RV_INSTANCE_SHOW_FAILED:
                return 34;
            case IronSourceConstants.RV_INSTANCE_STARTED:
                return 47;
            case 1701:
                return 38;
            case 1702:
                return 44;
            case 1803:
                return -1;
            default:
                return 3;
        }
    }

    static String a(String str) {
        byte[] a2;
        if (str == null || str.isEmpty() || (a2 = h9.a(str.getBytes())) == null) {
            return "";
        }
        return new String(a2);
    }

    static int b(int i) {
        if (i == 49 || i == 50 || i == 57 || i == 58 || i == 87 || i == 88) {
            return 2;
        }
        switch (i) {
            case -1:
                return 11;
            case 3:
            case 55:
            case 63:
            case 65:
            case 79:
            case 81:
            case 91:
            case 111:
            case 127:
                return 2;
            case 6:
            case 8:
            case 34:
            case 38:
            case 47:
                return 1;
            default:
                switch (i) {
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                        return 2;
                    default:
                        switch (i) {
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                                return 1;
                            default:
                                switch (i) {
                                    case 68:
                                    case 69:
                                    case 70:
                                        return 2;
                                    default:
                                        switch (i) {
                                            case 95:
                                            case 96:
                                            case 97:
                                            case 98:
                                            case 99:
                                            case 100:
                                            case 101:
                                            case 102:
                                                return 2;
                                            default:
                                                return 0;
                                        }
                                }
                        }
                }
        }
    }

    static long b(RVR rvr, List<j5> list) {
        NetworkTypes networkTypes;
        if (list.size() == 0) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            j5 j5Var = list.get(i8);
            if (j5Var.CallPhase == t0.Active) {
                i++;
                NetworkTypes networkTypes2 = j5Var.RadioInfo.NetworkType;
                NetworkTypes networkTypes3 = NetworkTypes.WiFi;
                if (networkTypes2 == networkTypes3 || j5Var.IsVoWiFiAvailable == ThreeState.Enabled || (networkTypes = j5Var.VoiceNetworkType) == networkTypes3) {
                    i2++;
                } else {
                    int i9 = a.a[l7.a(networkTypes, o6.Unknown, NetworkTypes.Unknown).ordinal()];
                    if (i9 == 1) {
                        i6++;
                    } else if (i9 == 2) {
                        i5++;
                    } else if (i9 == 3) {
                        i4++;
                    } else if (i9 != 4) {
                        i7++;
                    } else {
                        i3++;
                    }
                }
            }
        }
        if (i > 0) {
            double d = (double) i7;
            double d2 = (double) i;
            Double.isNaN(d);
            Double.isNaN(d2);
            rvr.VoiceRatShareUnknown = d / d2;
            double d3 = (double) i6;
            Double.isNaN(d3);
            Double.isNaN(d2);
            rvr.VoiceRatShare2G = d3 / d2;
            double d4 = (double) i5;
            Double.isNaN(d4);
            Double.isNaN(d2);
            rvr.VoiceRatShare3G = d4 / d2;
            double d5 = (double) i4;
            Double.isNaN(d5);
            Double.isNaN(d2);
            rvr.VoiceRatShare4G = d5 / d2;
            double d6 = (double) i3;
            Double.isNaN(d6);
            Double.isNaN(d2);
            rvr.VoiceRatShare5G = d6 / d2;
            double d7 = (double) i2;
            Double.isNaN(d7);
            Double.isNaN(d2);
            rvr.VoiceRatShareVoWiFi = d7 / d2;
        }
        return (long) i;
    }

    static String c(int i) {
        if (i == 111) {
            return "LOCAL_POWER_OFF";
        }
        if (i == 112) {
            return "LOCAL_LOW_BATTERY";
        }
        if (i == 131) {
            return "LOCAL_SERVICE_UNAVAILABLE";
        }
        if (i == 132) {
            return "LOCAL_NOT_REGISTERED";
        }
        if (i == 240) {
            return "CALL_BARRED";
        }
        if (i == 241) {
            return "FDN_BLOCKED";
        }
        if (i == 0) {
            return "UNSPECIFIED";
        }
        if (i == 901) {
            return "ECBM_NOT_SUPPORTED";
        }
        if (i == 902) {
            return "MULTIENDPOINT_NOT_SUPPORTED";
        }
        switch (i) {
            case 0:
                return "UNSPECIFIED";
            case MediaError.DetailedErrorCode.DASH_NETWORK:
                return "SIP_REDIRECTED";
            case 361:
                return "SIP_USER_REJECTED";
            case 362:
                return "SIP_GLOBAL_ERROR";
            case 363:
                return "EMERGENCY_TEMP_FAILURE";
            case 364:
                return "EMERGENCY_PERM_FAILURE";
            case 365:
                return "SIP_USER_MARKED_UNWANTED";
            case 366:
                return "SIP_METHOD_NOT_ALLOWED";
            case 367:
                return "SIP_PROXY_AUTHENTICATION_REQUIRED";
            case 368:
                return "SIP_REQUEST_ENTITY_TOO_LARGE";
            case 369:
                return "SIP_REQUEST_URI_TOO_LARGE";
            case 370:
                return "SIP_EXTENSION_REQUIRED";
            case 371:
                return "SIP_INTERVAL_TOO_BRIEF";
            case 372:
                return "SIP_CALL_OR_TRANS_DOES_NOT_EXIST";
            case 373:
                return "SIP_LOOP_DETECTED";
            case 374:
                return "SIP_TOO_MANY_HOPS";
            case 1000:
                return "REGISTRATION_ERROR";
            case 1014:
                return "ANSWERED_ELSEWHERE";
            case 1015:
                return "CALL_PULL_OUT_OF_SYNC";
            case 1016:
                return "CALL_END_CAUSE_CALL_PULL";
            case 1017:
                return "REJECTED_ELSEWHERE";
            case IronSourceConstants.RV_API_SHOW_CALLED:
                return "CALL_DROP_IWLAN_TO_LTE_UNAVAILABLE";
            case IronSourceConstants.RV_INSTANCE_SHOW:
                return "SUPP_SVC_FAILED";
            case IronSourceConstants.RV_INSTANCE_SHOW_FAILED:
                return "SUPP_SVC_CANCELLED";
            case IronSourceConstants.RV_INSTANCE_CLOSED:
                return "SUPP_SVC_REINVITE_COLLISION";
            case IronSourceConstants.RV_AUCTION_REQUEST:
                return "IWLAN_DPD_FAILURE";
            case IronSourceConstants.RV_CAP_PLACEMENT:
                return "EPDG_TUNNEL_ESTABLISH_FAILURE";
            case IronSourceConstants.RV_CAP_SESSION:
                return "EPDG_TUNNEL_REKEY_FAILURE";
            case 1402:
                return "EPDG_TUNNEL_LOST_CONNECTION";
            case 1403:
                return "MAXIMUM_NUMBER_OF_CALLS_REACHED";
            case 1404:
                return "REMOTE_CALL_DECLINE";
            case 1405:
                return "DATA_LIMIT_REACHED";
            case 1406:
                return "DATA_DISABLED";
            case 1407:
                return "WIFI_LOST";
            case 1408:
                return "IKEV2_AUTH_FAILURE";
            case 1500:
                return "RADIO_OFF";
            case 1501:
                return "NO_VALID_SIM";
            case 1502:
                return "RADIO_INTERNAL_ERROR";
            case 1503:
                return "NETWORK_RESP_TIMEOUT";
            case 1504:
                return "NETWORK_REJECT";
            case 1505:
                return "RADIO_ACCESS_FAILURE";
            case 1506:
                return "RADIO_LINK_FAILURE";
            case 1507:
                return "RADIO_LINK_LOST";
            case 1508:
                return "RADIO_UPLINK_FAILURE";
            case 1509:
                return "RADIO_SETUP_FAILURE";
            case 1510:
                return "RADIO_RELEASE_NORMAL";
            case 1511:
                return "RADIO_RELEASE_ABNORMAL";
            case 1512:
                return "ACCESS_CLASS_BLOCKED";
            case 1513:
                return "NETWORK_DETACH";
            case 1514:
                return "SIP_ALTERNATE_EMERGENCY_CALL";
            case 1515:
                return "UNOBTAINABLE_NUMBER";
            case 1516:
                return "NO_CSFB_IN_CS_ROAM";
            case 1517:
                return "SESSION_MODIFICATION_FAILED";
            case 1600:
                return "REJECT_UNKNOWN";
            case 1601:
                return "REJECT_ONGOING_CALL_WAITING_DISABLED";
            case 1602:
                return "REJECT_CALL_ON_OTHER_SUB";
            case 1603:
                return "REJECT_1X_COLLISION";
            case 1604:
                return "REJECT_SERVICE_NOT_REGISTERED";
            case 1605:
                return "REJECT_CALL_TYPE_NOT_ALLOWED";
            case 1606:
                return "REJECT_ONGOING_E911_CALL";
            case 1607:
                return "REJECT_ONGOING_CALL_SETUP";
            case 1608:
                return "REJECT_MAX_CALL_LIMIT_REACHED";
            case 1609:
                return "REJECT_UNSUPPORTED_SIP_HEADERS";
            case 1610:
                return "REJECT_UNSUPPORTED_SDP_HEADERS";
            case 1611:
                return "REJECT_ONGOING_CALL_TRANSFER";
            case 1612:
                return "REJECT_INTERNAL_ERROR";
            case 1613:
                return "REJECT_QOS_FAILURE";
            case 1614:
                return "REJECT_ONGOING_HANDOVER";
            case 1615:
                return "REJECT_VT_TTY_NOT_ALLOWED";
            case 1616:
                return "REJECT_ONGOING_CALL_UPGRADE";
            case 1617:
                return "REJECT_CONFERENCE_TTY_NOT_ALLOWED";
            case 1618:
                return "REJECT_ONGOING_CONFERENCE_CALL";
            case 1619:
                return "REJECT_VT_AVPF_NOT_ALLOWED";
            case 1620:
                return "REJECT_ONGOING_ENCRYPTED_CALL";
            case 1621:
                return "REJECT_ONGOING_CS_CALL";
            case 3001:
                return "RETRY_ON_IMS_WITHOUT_RTT";
            case PreciseDisconnectCause.OEM_CAUSE_1:
                return "OEM_CAUSE_1";
            case PreciseDisconnectCause.OEM_CAUSE_2:
                return "OEM_CAUSE_2";
            case PreciseDisconnectCause.OEM_CAUSE_3:
                return "OEM_CAUSE_3";
            case PreciseDisconnectCause.OEM_CAUSE_4:
                return "OEM_CAUSE_4";
            case PreciseDisconnectCause.OEM_CAUSE_5:
                return "OEM_CAUSE_5";
            case PreciseDisconnectCause.OEM_CAUSE_6:
                return "OEM_CAUSE_6";
            case PreciseDisconnectCause.OEM_CAUSE_7:
                return "OEM_CAUSE_7";
            case PreciseDisconnectCause.OEM_CAUSE_8:
                return "OEM_CAUSE_8";
            case PreciseDisconnectCause.OEM_CAUSE_9:
                return "OEM_CAUSE_9";
            case PreciseDisconnectCause.OEM_CAUSE_10:
                return "OEM_CAUSE_10";
            case PreciseDisconnectCause.OEM_CAUSE_11:
                return "OEM_CAUSE_11";
            case PreciseDisconnectCause.OEM_CAUSE_12:
                return "OEM_CAUSE_12";
            case PreciseDisconnectCause.OEM_CAUSE_13:
                return "OEM_CAUSE_13";
            case PreciseDisconnectCause.OEM_CAUSE_14:
                return "OEM_CAUSE_14";
            case PreciseDisconnectCause.OEM_CAUSE_15:
                return "OEM_CAUSE_15";
            default:
                switch (i) {
                    case MediaError.DetailedErrorCode.SMOOTH_NETWORK:
                        return "SIP_BAD_REQUEST";
                    case MediaError.DetailedErrorCode.SMOOTH_NO_MEDIA_DATA:
                        return "SIP_FORBIDDEN";
                    case 333:
                        return "SIP_NOT_FOUND";
                    case 334:
                        return "SIP_NOT_SUPPORTED";
                    case 335:
                        return "SIP_REQUEST_TIMEOUT";
                    case 336:
                        return "SIP_TEMPRARILY_UNAVAILABLE";
                    case 337:
                        return "SIP_BAD_ADDRESS";
                    case 338:
                        return "SIP_BUSY";
                    case 339:
                        return "SIP_REQUEST_CANCELLED";
                    case 340:
                        return "SIP_NOT_ACCEPTABLE";
                    case FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS:
                        return "SIP_NOT_REACHABLE";
                    case 342:
                        return "SIP_CLIENT_ERROR";
                    case 343:
                        return "SIP_TRANSACTION_DOES_NOT_EXIST";
                    default:
                        switch (i) {
                            case 351:
                                return "SIP_SERVER_INTERNAL_ERROR";
                            case 352:
                                return "SIP_SERVICE_UNAVAILABLE";
                            case 353:
                                return "SIP_SERVER_TIMEOUT";
                            case 354:
                                return "SIP_SERVER_ERROR";
                            default:
                                switch (i) {
                                    case 376:
                                        return "SIP_AMBIGUOUS";
                                    case 377:
                                        return "SIP_REQUEST_PENDING";
                                    case 378:
                                        return "SIP_UNDECIPHERABLE";
                                    default:
                                        switch (i) {
                                            case 401:
                                                return "MEDIA_INIT_FAILED";
                                            case 402:
                                                return "MEDIA_NO_DATA";
                                            case 403:
                                                return "MEDIA_NOT_ACCEPTABLE";
                                            case 404:
                                                return "MEDIA_UNSPECIFIED";
                                            default:
                                                switch (i) {
                                                    case 501:
                                                        return "USER_TERMINATED";
                                                    case 502:
                                                        return "USER_NOANSWER";
                                                    case 503:
                                                        return "USER_IGNORE";
                                                    case 504:
                                                        return "USER_DECLINE";
                                                    case 505:
                                                        return "LOW_BATTERY";
                                                    case 506:
                                                        return "BLACKLISTED_CALL_ID";
                                                    default:
                                                        switch (i) {
                                                            case 510:
                                                                return "USER_TERMINATED_BY_REMOTE";
                                                            case FrameMetricsAggregator.EVERY_DURATION:
                                                                return "USER_REJECTED_SESSION_MODIFICATION";
                                                            case 512:
                                                                return "USER_CANCELLED_SESSION_MODIFICATION";
                                                            default:
                                                                switch (i) {
                                                                    case 801:
                                                                        return "UT_NOT_SUPPORTED";
                                                                    case 802:
                                                                        return "UT_SERVICE_UNAVAILABLE";
                                                                    case 803:
                                                                        return "UT_OPERATION_NOT_ALLOWED";
                                                                    case 804:
                                                                        return "UT_NETWORK_ERROR";
                                                                    default:
                                                                        switch (i) {
                                                                            case 821:
                                                                                return "UT_CB_PASSWORD_MISMATCH";
                                                                            case 822:
                                                                                return "UT_SS_MODIFIED_TO_DIAL";
                                                                            case 823:
                                                                                return "UT_SS_MODIFIED_TO_USSD";
                                                                            case 824:
                                                                                return "UT_SS_MODIFIED_TO_SS";
                                                                            case 825:
                                                                                return "UT_SS_MODIFIED_TO_DIAL_VIDEO";
                                                                            default:
                                                                                switch (i) {
                                                                                    case 101:
                                                                                        return "LOCAL_ILLEGAL_ARGUMENT";
                                                                                    case 102:
                                                                                        return "LOCAL_ILLEGAL_STATE";
                                                                                    case 103:
                                                                                        return "LOCAL_INTERNAL_ERROR";
                                                                                    default:
                                                                                        switch (i) {
                                                                                            case 106:
                                                                                                return "LOCAL_IMS_SERVICE_DOWN";
                                                                                            case 107:
                                                                                                return "LOCAL_NO_PENDING_CALL";
                                                                                            case 108:
                                                                                                return "LOCAL_ENDED_BY_CONFERENCE_MERGE";
                                                                                            default:
                                                                                                switch (i) {
                                                                                                    case 121:
                                                                                                        return "LOCAL_NETWORK_NO_SERVICE";
                                                                                                    case 122:
                                                                                                        return "LOCAL_NETWORK_NO_LTE_COVERAGE";
                                                                                                    case 123:
                                                                                                        return "LOCAL_NETWORK_ROAMING";
                                                                                                    case 124:
                                                                                                        return "LOCAL_NETWORK_IP_CHANGED";
                                                                                                    default:
                                                                                                        switch (i) {
                                                                                                            case 141:
                                                                                                                return "LOCAL_CALL_EXCEEDED";
                                                                                                            case 142:
                                                                                                                return "LOCAL_CALL_BUSY";
                                                                                                            case 143:
                                                                                                                return "LOCAL_CALL_DECLINE";
                                                                                                            case 144:
                                                                                                                return "LOCAL_CALL_VCC_ON_PROGRESSING";
                                                                                                            case 145:
                                                                                                                return "LOCAL_CALL_RESOURCE_RESERVATION_FAILED";
                                                                                                            case 146:
                                                                                                                return "LOCAL_CALL_CS_RETRY_REQUIRED";
                                                                                                            case 147:
                                                                                                                return "LOCAL_CALL_VOLTE_RETRY_REQUIRED";
                                                                                                            case 148:
                                                                                                                return "LOCAL_CALL_TERMINATED";
                                                                                                            case 149:
                                                                                                                return "LOCAL_HO_NOT_FEASIBLE";
                                                                                                            default:
                                                                                                                switch (i) {
                                                                                                                    case 201:
                                                                                                                        return "TIMEOUT_1XX_WAITING";
                                                                                                                    case 202:
                                                                                                                        return "TIMEOUT_NO_ANSWER";
                                                                                                                    case 203:
                                                                                                                        return "TIMEOUT_NO_ANSWER_CALL_UPDATE";
                                                                                                                    default:
                                                                                                                        switch (i) {
                                                                                                                            case PreciseDisconnectCause.IMEI_NOT_ACCEPTED:
                                                                                                                                return "IMEI_NOT_ACCEPTED";
                                                                                                                            case 244:
                                                                                                                                return "DIAL_MODIFIED_TO_USSD";
                                                                                                                            case 245:
                                                                                                                                return "DIAL_MODIFIED_TO_SS";
                                                                                                                            case 246:
                                                                                                                                return "DIAL_MODIFIED_TO_DIAL";
                                                                                                                            case PreciseDisconnectCause.RADIO_OFF:
                                                                                                                                return "DIAL_MODIFIED_TO_DIAL_VIDEO";
                                                                                                                            case PreciseDisconnectCause.OUT_OF_SRV:
                                                                                                                                return "DIAL_VIDEO_MODIFIED_TO_DIAL";
                                                                                                                            case PreciseDisconnectCause.NO_VALID_SIM:
                                                                                                                                return "DIAL_VIDEO_MODIFIED_TO_DIAL_VIDEO";
                                                                                                                            case 250:
                                                                                                                                return "DIAL_VIDEO_MODIFIED_TO_SS";
                                                                                                                            case PreciseDisconnectCause.NETWORK_RESP_TIMEOUT:
                                                                                                                                return "DIAL_VIDEO_MODIFIED_TO_USSD";
                                                                                                                            default:
                                                                                                                                return "UNKNOWN";
                                                                                                                        }
                                                                                                                }
                                                                                                        }
                                                                                                }
                                                                                        }
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    static String d(int i) {
        switch (i) {
            case 0:
                return "PRECISE_CALL_STATE_IDLE";
            case 1:
                return "PRECISE_CALL_STATE_ACTIVE";
            case 2:
                return "PRECISE_CALL_STATE_HOLDING";
            case 3:
                return "PRECISE_CALL_STATE_DIALING";
            case 4:
                return "PRECISE_CALL_STATE_ALERTING";
            case 5:
                return "PRECISE_CALL_STATE_INCOMING";
            case 6:
                return "PRECISE_CALL_STATE_WAITING";
            case 7:
                return "PRECISE_CALL_STATE_DISCONNECTED";
            case 8:
                return "PRECISE_CALL_STATE_DISCONNECTING";
            default:
                return "UNKNOWN";
        }
    }

    static String e(int i) {
        if (i == -1) {
            return "NOT_VALID";
        }
        if (i == 0) {
            return "NO_DISCONNECT_CAUSE_AVAILABLE";
        }
        if (i == 1) {
            return "UNOBTAINABLE_NUMBER";
        }
        if (i == 3) {
            return "NO_ROUTE_TO_DESTINATION";
        }
        if (i == 6) {
            return "CHANNEL_UNACCEPTABLE";
        }
        if (i == 21) {
            return "CALL_REJECTED";
        }
        if (i == 22) {
            return "NUMBER_CHANGED";
        }
        if (i == 49) {
            return "QOS_NOT_AVAIL";
        }
        if (i == 50) {
            return "REQUESTED_FACILITY_NOT_SUBSCRIBED";
        }
        if (i == 57) {
            return "BEARER_CAPABILITY_NOT_AUTHORIZED";
        }
        if (i == 58) {
            return "BEARER_NOT_AVAIL";
        }
        if (i == 87) {
            return "USER_NOT_MEMBER_OF_CUG";
        }
        if (i == 88) {
            return "INCOMPATIBLE_DESTINATION";
        }
        switch (i) {
            case 6:
                return "CHANNEL_UNACCEPTABLE";
            case 8:
                return "OPERATOR_DETERMINED_BARRING";
            case 25:
                return "PREEMPTION";
            case 34:
                return "NO_CIRCUIT_AVAIL";
            case 38:
                return "NETWORK_OUT_OF_ORDER";
            case 47:
                return "RESOURCES_UNAVAILABLE_OR_UNSPECIFIED";
            case 55:
                return "INCOMING_CALLS_BARRED_WITHIN_CUG";
            case 63:
                return "SERVICE_OPTION_NOT_AVAILABLE";
            case 65:
                return "BEARER_SERVICE_NOT_IMPLEMENTED";
            case 79:
                return "SERVICE_OR_OPTION_NOT_IMPLEMENTED";
            case 81:
                return "INVALID_TRANSACTION_IDENTIFIER";
            case 95:
                return "SEMANTICALLY_INCORRECT_MESSAGE";
            case 96:
                return "INVALID_MANDATORY_INFORMATION";
            case 97:
                return "MESSAGE_TYPE_NON_IMPLEMENTED";
            case 98:
                return "MESSAGE_TYPE_NOT_COMPATIBLE_WITH_PROTOCOL_STATE";
            case 99:
                return "INFORMATION_ELEMENT_NON_EXISTENT";
            case 100:
                return "CONDITIONAL_IE_ERROR";
            case 101:
                return "MESSAGE_NOT_COMPATIBLE_WITH_PROTOCOL_STATE";
            case 102:
                return "RECOVERY_ON_TIMER_EXPIRED";
            case 111:
                return "PROTOCOL_ERROR_UNSPECIFIED";
            case 127:
                return "INTERWORKING_UNSPECIFIED";
            case 240:
                return "CALL_BARRED";
            case PreciseDisconnectCause.FDN_BLOCKED:
                return "FDN_BLOCKED";
            case PreciseDisconnectCause.IMSI_UNKNOWN_IN_VLR:
                return "IMSI_UNKNOWN_IN_VLR";
            case PreciseDisconnectCause.IMEI_NOT_ACCEPTED:
                return "IMEI_NOT_ACCEPTED";
            case PreciseDisconnectCause.RADIO_OFF:
                return "RADIO_OFF";
            case PreciseDisconnectCause.OUT_OF_SRV:
                return "OUT_OF_SRV";
            case PreciseDisconnectCause.NO_VALID_SIM:
                return "NO_VALID_SIM";
            case 250:
                return "RADIO_INTERNAL_ERROR";
            case PreciseDisconnectCause.NETWORK_RESP_TIMEOUT:
                return "NETWORK_RESP_TIMEOUT";
            case PreciseDisconnectCause.NETWORK_REJECT:
                return "NETWORK_REJECT";
            case PreciseDisconnectCause.RADIO_ACCESS_FAILURE:
                return "RADIO_ACCESS_FAILURE";
            case PreciseDisconnectCause.RADIO_LINK_FAILURE:
                return "RADIO_LINK_FAILURE";
            case 255:
                return "RADIO_LINK_LOST";
            case 256:
                return "RADIO_UPLINK_FAILURE";
            case 257:
                return "RADIO_SETUP_FAILURE";
            case 258:
                return "RADIO_RELEASE_NORMAL";
            case 259:
                return "RADIO_RELEASE_ABNORMAL";
            case 260:
                return "ACCESS_CLASS_BLOCKED";
            case 261:
                return "NETWORK_DETACH";
            case 1000:
                return "CDMA_LOCKED_UNTIL_POWER_CYCLE";
            case 1001:
                return "CDMA_DROP";
            case 1002:
                return "CDMA_INTERCEPT";
            case 1003:
                return "CDMA_REORDER";
            case 1004:
                return "CDMA_SO_REJECT";
            case 1005:
                return "CDMA_RETRY_ORDER";
            case 1006:
                return "CDMA_ACCESS_FAILURE";
            case 1007:
                return "CDMA_PREEMPTED";
            case 1008:
                return "CDMA_NOT_EMERGENCY";
            case 1009:
                return "CDMA_ACCESS_BLOCKED";
            case PreciseDisconnectCause.OEM_CAUSE_1:
                return "OEM_CAUSE_1";
            case PreciseDisconnectCause.OEM_CAUSE_2:
                return "OEM_CAUSE_2";
            case PreciseDisconnectCause.OEM_CAUSE_3:
                return "OEM_CAUSE_3";
            case PreciseDisconnectCause.OEM_CAUSE_4:
                return "OEM_CAUSE_4";
            case PreciseDisconnectCause.OEM_CAUSE_5:
                return "OEM_CAUSE_5";
            case PreciseDisconnectCause.OEM_CAUSE_6:
                return "OEM_CAUSE_6";
            case PreciseDisconnectCause.OEM_CAUSE_7:
                return "OEM_CAUSE_7";
            case PreciseDisconnectCause.OEM_CAUSE_8:
                return "OEM_CAUSE_8";
            case PreciseDisconnectCause.OEM_CAUSE_9:
                return "OEM_CAUSE_9";
            case PreciseDisconnectCause.OEM_CAUSE_10:
                return "OEM_CAUSE_10";
            case PreciseDisconnectCause.OEM_CAUSE_11:
                return "OEM_CAUSE_11";
            case PreciseDisconnectCause.OEM_CAUSE_12:
                return "OEM_CAUSE_12";
            case PreciseDisconnectCause.OEM_CAUSE_13:
                return "OEM_CAUSE_13";
            case PreciseDisconnectCause.OEM_CAUSE_14:
                return "OEM_CAUSE_14";
            case PreciseDisconnectCause.OEM_CAUSE_15:
                return "OEM_CAUSE_15";
            case 65535:
                return "ERROR_UNSPECIFIED";
            default:
                switch (i) {
                    case 16:
                        return "NORMAL";
                    case 17:
                        return "BUSY";
                    case 18:
                        return "NO_USER_RESPONDING";
                    case 19:
                        return "NO_ANSWER_FROM_USER";
                    default:
                        switch (i) {
                            case 27:
                                return "DESTINATION_OUT_OF_ORDER";
                            case 28:
                                return "INVALID_NUMBER_FORMAT";
                            case 29:
                                return "FACILITY_REJECTED";
                            case 30:
                                return "STATUS_ENQUIRY";
                            case 31:
                                return "NORMAL_UNSPECIFIED";
                            default:
                                switch (i) {
                                    case 41:
                                        return "TEMPORARY_FAILURE";
                                    case 42:
                                        return "SWITCHING_CONGESTION";
                                    case 43:
                                        return "ACCESS_INFORMATION_DISCARDED";
                                    case 44:
                                        return "CHANNEL_NOT_AVAIL";
                                    default:
                                        switch (i) {
                                            case 68:
                                                return "ACM_LIMIT_EXCEEDED";
                                            case 69:
                                                return "REQUESTED_FACILITY_NOT_IMPLEMENTED";
                                            case 70:
                                                return "ONLY_DIGITAL_INFORMATION_BEARER_AVAILABLE";
                                            default:
                                                return "UNKNOWN";
                                        }
                                }
                        }
                }
        }
    }

    static boolean a(Context context, RVR rvr, String str) {
        RVR rvr2 = rvr;
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, (String[]) null, (String) null, (String[]) null, "date DESC");
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
            try {
                int columnIndex = cursor.getColumnIndex("type");
                int columnIndex2 = cursor.getColumnIndex("duration");
                int columnIndex3 = cursor.getColumnIndex("number");
                int columnIndex4 = cursor.getColumnIndex("date");
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return false;
                }
                int i = 0;
                while (true) {
                    long j = cursor.getLong(columnIndex4);
                    ub ubVar = rvr2.TimeInfoOnStart;
                    long j2 = ubVar.TimestampMillis + ubVar.DeviceDriftMillis;
                    if (j2 <= 5000 + j) {
                        if (a(aa.a(cursor.getString(columnIndex3))).equals(str) || str.length() == 0) {
                            if (j2 >= j - 2000) {
                                if (j2 <= j + 2000) {
                                    String string = cursor.getString(columnIndex);
                                    if (Integer.parseInt(string) == 3) {
                                        rvr2.CallEndType = s0.Missed;
                                    } else if (Integer.parseInt(string) == 5) {
                                        rvr2.CallEndType = s0.Rejected;
                                    } else if (Integer.parseInt(string) == 6) {
                                        rvr2.CallEndType = s0.Blocked;
                                    } else if (Integer.parseInt(string) == 4) {
                                        rvr2.CallEndType = s0.VoiceMail;
                                    } else if (Integer.parseInt(string) == 7) {
                                        rvr2.CallEndType = s0.AnsweredExternally;
                                    }
                                    long parseLong = Long.parseLong(cursor.getString(columnIndex2));
                                    if (parseLong > 0) {
                                        if (rvr2.CallDuration == 0) {
                                            rvr2.CallDuration = parseLong * 1000;
                                        }
                                        if (rvr2.TimeToConnect == 0) {
                                            ub addMillisToTimeInfo = DateUtils.addMillisToTimeInfo(rvr2.TimeInfoOnEnd, -rvr2.CallDuration);
                                            rvr2.TimeInfoOnEstablished = addMillisToTimeInfo;
                                            rvr2.TimestampOnEstablished = addMillisToTimeInfo.TimestampTableau;
                                        }
                                    } else {
                                        rvr2.CallSuccessful = false;
                                    }
                                    if (rvr2.CallStateRecognition == u0.Default) {
                                        rvr2.CallStateRecognition = u0.CallLog;
                                    }
                                    cursor.close();
                                    return true;
                                }
                            }
                        }
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        int i2 = i + 1;
                        if (i >= rvr2.MultiCalls) {
                            break;
                        }
                        i = i2;
                    } else {
                        cursor.close();
                        return false;
                    }
                }
                cursor.close();
                return false;
            } catch (Exception e) {
                String str2 = b;
                Log.d(str2, "gatherCallLogInformation: " + e.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            String str3 = b;
            Log.d(str3, "gatherCallLogInformation: " + e2.getMessage());
            return false;
        }
    }

    static void a(RVR rvr, List<j5> list) {
        long j = 0;
        if (rvr.CallDuration != 0 && list.size() != 0) {
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    i = -1;
                    break;
                }
                j5 j5Var = list.get(i);
                if (j5Var.CallPhase == t0.Active && j5Var.RadioInfo.ServiceState == g9.InService) {
                    break;
                }
                i++;
            }
            if (i != -1 && i != list.size() - 1) {
                boolean z = true;
                for (int i2 = i + 1; i2 < list.size(); i2++) {
                    j5 j5Var2 = list.get(i2);
                    boolean z2 = j5Var2.RadioInfo.ServiceState == g9.InService;
                    if ((!z2) && z) {
                        j = j5Var2.Delta;
                        z = false;
                    } else if (z2 && (!z)) {
                        if (j5Var2.Delta - j <= 10000) {
                            rvr.CallReestablishments++;
                        }
                        z = true;
                    }
                }
            }
        }
    }

    static void c(RVR rvr, List<j5> list) {
        for (j5 next : list) {
            if (next.CallPhase != t0.PostCall) {
                if (rvr.CallDirection == r0.MOC) {
                    next.CallPhase = next.Delta < rvr.TimeToConnect ? t0.Connecting : t0.Active;
                } else {
                    next.CallPhase = next.Delta < rvr.TimeToConnect ? t0.Ringing : t0.Active;
                }
            }
        }
    }
}
