package com.umlaut.crowd.internal;

import android.os.Build;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.NetworkRegistrationInfo;
import android.telephony.ServiceState;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import org.apache.http.cookie.ClientCookie;

public class k6 {
    private static j6 a(NetworkRegistrationInfo networkRegistrationInfo) {
        if (networkRegistrationInfo == null) {
            return null;
        }
        j6 j6Var = new j6();
        j6Var.NetworkTechnology = l7.d(networkRegistrationInfo.getAccessNetworkTechnology());
        int transportType = networkRegistrationInfo.getTransportType();
        if (transportType == 1) {
            j6Var.TransportType = qc.WWAN;
        } else if (transportType != 2) {
            j6Var.TransportType = qc.Unknown;
        } else {
            j6Var.TransportType = qc.WLAN;
        }
        int domain = networkRegistrationInfo.getDomain();
        if (domain == 1) {
            j6Var.Domain = i2.CS;
        } else if (domain == 2) {
            j6Var.Domain = i2.PS;
        } else if (domain != 3) {
            j6Var.Domain = i2.Unknown;
        } else {
            j6Var.Domain = i2.CS_PS;
        }
        a(networkRegistrationInfo.getCellIdentity(), j6Var);
        return j6Var;
    }

    private static i2 b(String str) {
        str.hashCode();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 2160:
                if (str.equals("CS")) {
                    c = 0;
                    break;
                }
                break;
            case 2563:
                if (str.equals("PS")) {
                    c = 1;
                    break;
                }
                break;
            case 64442418:
                if (str.equals("CS_PS")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return i2.CS;
            case 1:
                return i2.PS;
            case 2:
                return i2.CS_PS;
            default:
                return i2.Unknown;
        }
    }

    private static String c(String str) {
        return str.replace("isDcNrRestricted = false", "isDcNrRestricted=false").replace("isDcNrRestricted = true", "isDcNrRestricted=true").replace("isNrAvailable = false", "isNrAvailable=false").replace("isNrAvailable = true", "isNrAvailable=true").replace("isEnDcAvailable = false", "isEnDcAvailable=false").replace("isEnDcAvailable = true", "isEnDcAvailable=true").replace("mIsUsingCarrierAggregation = false", "mIsUsingCarrierAggregation=false").replace("mIsUsingCarrierAggregation = true", "mIsUsingCarrierAggregation=true");
    }

    private static String[] d(String str) {
        return str.replace("NetworkRegistrationState", " ").replace("NetworkRegistrationInfo", " ").replace("}", " ").replace("{", " ").replace(CertificateUtil.DELIMITER, "").replaceAll(" +", " ").trim().split(" ");
    }

    private static int e(String str) {
        String str2 = str;
        str.hashCode();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2039427040:
                if (str2.equals("LTE_CA")) {
                    c = 0;
                    break;
                }
                break;
            case -908593671:
                if (str2.equals("TD_SCDMA")) {
                    c = 1;
                    break;
                }
                break;
            case 2500:
                if (str2.equals("NR")) {
                    c = 2;
                    break;
                }
                break;
            case 70881:
                if (str2.equals("GSM")) {
                    c = 3;
                    break;
                }
                break;
            case 75709:
                if (str2.equals("LTE")) {
                    c = 4;
                    break;
                }
                break;
            case 2063797:
                if (str2.equals("CDMA")) {
                    c = 5;
                    break;
                }
                break;
            case 2123197:
                if (str2.equals("EDGE")) {
                    c = 6;
                    break;
                }
                break;
            case 2194666:
                if (str2.equals("GPRS")) {
                    c = 7;
                    break;
                }
                break;
            case 2227260:
                if (str2.equals("HSPA")) {
                    c = 8;
                    break;
                }
                break;
            case 2608919:
                if (str2.equals("UMTS")) {
                    c = 9;
                    break;
                }
                break;
            case 3195620:
                if (str2.equals("iDEN")) {
                    c = 10;
                    break;
                }
                break;
            case 69034058:
                if (str2.equals("HSDPA")) {
                    c = 11;
                    break;
                }
                break;
            case 69045103:
                if (str2.equals("HSPA+")) {
                    c = 12;
                    break;
                }
                break;
            case 69050395:
                if (str2.equals("HSUPA")) {
                    c = 13;
                    break;
                }
                break;
            case 70083979:
                if (str2.equals("IWLAN")) {
                    c = 14;
                    break;
                }
                break;
            case 836263277:
                if (str2.equals("CDMA - 1xRTT")) {
                    c = 15;
                    break;
                }
                break;
            case 882856261:
                if (str2.equals("CDMA - eHRPD")) {
                    c = 16;
                    break;
                }
                break;
            case 893165057:
                if (str2.equals("CDMA - EvDo rev. 0")) {
                    c = 17;
                    break;
                }
                break;
            case 893165074:
                if (str2.equals("CDMA - EvDo rev. A")) {
                    c = 18;
                    break;
                }
                break;
            case 893165075:
                if (str2.equals("CDMA - EvDo rev. B")) {
                    c = 19;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 19;
            case 1:
                return 17;
            case 2:
                return 20;
            case 3:
                return 16;
            case 4:
                return 13;
            case 5:
                return 4;
            case 6:
                return 2;
            case 7:
                return 1;
            case 8:
                return 10;
            case 9:
                return 3;
            case 10:
                return 11;
            case 11:
                return 8;
            case 12:
                return 15;
            case 13:
                return 9;
            case 14:
                return 18;
            case 15:
                return 7;
            case 16:
                return 14;
            case 17:
                return 5;
            case 18:
                return 6;
            case 19:
                return 12;
            default:
                return 0;
        }
    }

    private static String f(String str) {
        String[] split = str.split("=");
        return split.length > 1 ? split[1] : "";
    }

    private static o6 g(String str) {
        str.hashCode();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2087582999:
                if (str.equals("CONNECTED")) {
                    c = 0;
                    break;
                }
                break;
            case -812190629:
                if (str.equals("RESTRICTED")) {
                    c = 1;
                    break;
                }
                break;
            case 2402104:
                if (str.equals("NONE")) {
                    c = 2;
                    break;
                }
                break;
            case 46267751:
                if (str.equals("NOT_RESTRICTED")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return o6.CONNECTED;
            case 1:
                return o6.RESTRICTED;
            case 2:
                return o6.NONE;
            case 3:
                return o6.NOT_RESTRICTED;
            default:
                return o6.Unknown;
        }
    }

    private static qc h(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt == 1) {
                return qc.WWAN;
            }
            if (parseInt != 2) {
                return qc.Unknown;
            }
            return qc.WLAN;
        } catch (Exception unused) {
            return qc.Unknown;
        }
    }

    private static qc i(String str) {
        str.hashCode();
        if (str.equals("WLAN")) {
            return qc.WLAN;
        }
        if (!str.equals("WWAN")) {
            return qc.Unknown;
        }
        return qc.WWAN;
    }

    public static j6[] a(ServiceState serviceState) {
        String serviceState2 = serviceState.toString();
        String str = "mNetworkRegistrationStates=";
        try {
            int indexOf = serviceState2.indexOf(str);
            if (indexOf == -1) {
                str = "mNetworkRegistrationInfos=";
                indexOf = serviceState2.indexOf(str);
            }
            if (indexOf == -1) {
                return new j6[0];
            }
            String replaceAll = serviceState2.substring(indexOf).substring(str.length() + 1).replaceAll("\\[\\w@", "@");
            int indexOf2 = replaceAll.indexOf("]");
            int indexOf3 = replaceAll.indexOf("[");
            while (indexOf3 != -1 && indexOf2 > indexOf3) {
                replaceAll = replaceAll.replaceFirst("\\[", "").replaceFirst("]", "");
                indexOf3 = replaceAll.indexOf("[");
                indexOf2 = replaceAll.indexOf("]");
            }
            String[] split = replaceAll.substring(0, indexOf2).split(", ");
            j6[] j6VarArr = new j6[split.length];
            for (int i = 0; i < split.length; i++) {
                String c = c(split[i]);
                split[i] = c;
                String trim = c.trim();
                split[i] = trim;
                j6VarArr[i] = a(d(trim));
            }
            return j6VarArr;
        } catch (Exception e) {
            e.printStackTrace();
            return new j6[0];
        }
    }

    private static void a(CellIdentity cellIdentity, j6 j6Var) {
        if (cellIdentity instanceof CellIdentityGsm) {
            CellIdentityGsm cellIdentityGsm = (CellIdentityGsm) cellIdentity;
            j6Var.CellTechnology = a1.Gsm;
            if (cellIdentityGsm.getCid() != Integer.MAX_VALUE) {
                j6Var.CellId = String.valueOf(cellIdentityGsm.getCid());
            }
            if (cellIdentityGsm.getLac() != Integer.MAX_VALUE) {
                j6Var.Tac = String.valueOf(cellIdentityGsm.getLac());
            }
            if (cellIdentityGsm.getArfcn() != Integer.MAX_VALUE) {
                j6Var.Arfcn = cellIdentityGsm.getArfcn();
            }
            j6Var.Mcc = cellIdentityGsm.getMccString();
            j6Var.Mnc = cellIdentityGsm.getMncString();
        } else if (cellIdentity instanceof CellIdentityWcdma) {
            CellIdentityWcdma cellIdentityWcdma = (CellIdentityWcdma) cellIdentity;
            j6Var.CellTechnology = a1.Wcdma;
            if (cellIdentityWcdma.getCid() != Integer.MAX_VALUE) {
                j6Var.CellId = String.valueOf(cellIdentityWcdma.getCid());
            }
            if (cellIdentityWcdma.getLac() != Integer.MAX_VALUE) {
                j6Var.Tac = String.valueOf(cellIdentityWcdma.getLac());
            }
            if (cellIdentityWcdma.getUarfcn() != Integer.MAX_VALUE) {
                j6Var.Arfcn = cellIdentityWcdma.getUarfcn();
            }
            j6Var.Mcc = cellIdentityWcdma.getMccString();
            j6Var.Mnc = cellIdentityWcdma.getMncString();
        } else if (cellIdentity instanceof CellIdentityCdma) {
            j6Var.CellTechnology = a1.Cdma;
        } else if (cellIdentity instanceof CellIdentityLte) {
            CellIdentityLte cellIdentityLte = (CellIdentityLte) cellIdentity;
            j6Var.CellTechnology = a1.Lte;
            if (cellIdentityLte.getCi() != Integer.MAX_VALUE) {
                j6Var.CellId = String.valueOf(cellIdentityLte.getCi());
            }
            if (cellIdentityLte.getTac() != Integer.MAX_VALUE) {
                j6Var.Tac = String.valueOf(cellIdentityLte.getTac());
            }
            if (cellIdentityLte.getPci() != Integer.MAX_VALUE) {
                j6Var.Pci = String.valueOf(cellIdentityLte.getPci());
            }
            if (cellIdentityLte.getEarfcn() != Integer.MAX_VALUE) {
                j6Var.Arfcn = cellIdentityLte.getEarfcn();
            }
            if (cellIdentityLte.getBandwidth() != Integer.MAX_VALUE) {
                j6Var.Bandwidth = cellIdentityLte.getBandwidth();
            }
            j6Var.Mcc = cellIdentityLte.getMccString();
            j6Var.Mnc = cellIdentityLte.getMncString();
        } else if (cellIdentity instanceof CellIdentityNr) {
            CellIdentityNr cellIdentityNr = (CellIdentityNr) cellIdentity;
            j6Var.CellTechnology = a1.Nr;
            if (cellIdentityNr.getNci() != Long.MAX_VALUE) {
                j6Var.CellId = String.valueOf(cellIdentityNr.getNci());
            }
            if (cellIdentityNr.getTac() != Integer.MAX_VALUE) {
                j6Var.Tac = String.valueOf(cellIdentityNr.getTac());
            }
            if (cellIdentityNr.getPci() != Integer.MAX_VALUE) {
                j6Var.Pci = String.valueOf(cellIdentityNr.getPci());
            }
            if (cellIdentityNr.getNrarfcn() != Integer.MAX_VALUE) {
                j6Var.Arfcn = cellIdentityNr.getNrarfcn();
            }
            j6Var.Mcc = cellIdentityNr.getMccString();
            j6Var.Mnc = cellIdentityNr.getMncString();
        }
        if (cellIdentity.getOperatorAlphaLong() != null) {
            j6Var.OperatorLong = String.valueOf(cellIdentity.getOperatorAlphaLong());
        }
        if (cellIdentity.getOperatorAlphaShort() != null) {
            j6Var.OperatorShort = String.valueOf(cellIdentity.getOperatorAlphaShort());
        }
    }

    private static j6 a(String[] strArr) {
        j6 j6Var = new j6();
        for (String str : strArr) {
            if (str.startsWith("transportType")) {
                String f = f(str);
                if (Build.VERSION.SDK_INT >= 29) {
                    j6Var.TransportType = i(f);
                } else {
                    j6Var.TransportType = h(f);
                }
            } else if (str.startsWith(ClientCookie.DOMAIN_ATTR)) {
                j6Var.Domain = b(f(str));
            } else if (str.startsWith("regState")) {
                j6Var.RegState = f(str);
            } else if (str.startsWith("registrationState")) {
                j6Var.RegState = f(str);
            } else if (str.startsWith("accessNetworkTechnology")) {
                j6Var.NetworkTechnology = l7.a(f(str));
            } else if (str.startsWith("reasonForDenial")) {
                j6Var.ReasonForDenial = f(str);
            } else if (str.startsWith("rejectCause")) {
                j6Var.ReasonForDenial = f(str);
            } else if (str.startsWith("emergencyEnabled")) {
                j6Var.EmergencyEnabled = f(str).equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            } else if (str.startsWith("mIsUsingCarrierAggregation") || str.startsWith("isUsingCarrierAggregation")) {
                j6Var.CarrierAggregation = f(str).equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) ? tb.Yes : tb.No;
            } else if (str.startsWith("cellIdentity")) {
                j6Var.CellTechnology = a(f(str));
            } else if (str.startsWith("mCid") || str.startsWith("mCi") || str.startsWith("mNetworkId") || str.startsWith("mNci")) {
                j6Var.CellId = f(str);
            } else if (str.startsWith("mLac") || str.startsWith("mTac") || str.startsWith("mSystemId")) {
                j6Var.Tac = f(str);
            } else if (str.startsWith("mBsic") || str.startsWith("mPsc") || str.startsWith("mPci") || str.startsWith("mBasestationId")) {
                String f2 = f(str);
                if (f2.startsWith("0x") && f2.length() > 2) {
                    try {
                        f2 = String.valueOf((int) Long.parseLong(f2.substring(2), 16));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        f2 = "";
                    }
                }
                j6Var.Pci = f2;
            } else if (str.startsWith("mArfcn") || str.startsWith("mUarfcn") || str.startsWith("mEarfcn") || str.startsWith("mNrArfcn")) {
                try {
                    j6Var.Arfcn = Integer.parseInt(f(str));
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            } else if (str.startsWith("mBandwidth")) {
                try {
                    j6Var.Bandwidth = Integer.parseInt(f(str));
                } catch (NumberFormatException e3) {
                    e3.printStackTrace();
                }
            } else if (str.startsWith("mMcc")) {
                j6Var.Mcc = f(str);
            } else if (str.startsWith("mMnc")) {
                j6Var.Mnc = f(str);
            } else if (str.startsWith("mAlphaLong")) {
                j6Var.OperatorLong = f(str);
            } else if (str.startsWith("mAlphaShort")) {
                j6Var.OperatorShort = f(str);
            } else if (str.startsWith("mMaxDataCalls")) {
                try {
                    j6Var.MaxDataCalls = Integer.parseInt(f(str));
                } catch (NumberFormatException e4) {
                    e4.printStackTrace();
                }
            } else if (str.startsWith("availableServices")) {
                j6Var.AvailableServices = f(str);
            } else if (str.startsWith("nrState") || str.startsWith("nrStatus")) {
                j6Var.NrState = g(f(str));
            } else if (str.startsWith("isDcNrRestricted")) {
                j6Var.DcNrRestricted = f(str).equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) ? tb.Yes : tb.No;
            } else if (str.startsWith("isNrAvailable")) {
                j6Var.NrAvailable = f(str).equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) ? tb.Yes : tb.No;
            } else if (str.startsWith("isEnDcAvailable")) {
                j6Var.EnDcAvailable = f(str).equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) ? tb.Yes : tb.No;
            }
        }
        return j6Var;
    }

    private static a1 a(String str) {
        str.hashCode();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1647210964:
                if (str.equals("CellIdentityWcdma")) {
                    c = 0;
                    break;
                }
                break;
            case 887655553:
                if (str.equals("CellIdentityGsm")) {
                    c = 1;
                    break;
                }
                break;
            case 887660381:
                if (str.equals("CellIdentityLte")) {
                    c = 2;
                    break;
                }
                break;
            case 1552654916:
                if (str.equals("CellIdentityNr")) {
                    c = 3;
                    break;
                }
                break;
            case 1747384885:
                if (str.equals("CellIdentityCdma")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return a1.Wcdma;
            case 1:
                return a1.Gsm;
            case 2:
                return a1.Lte;
            case 3:
                return a1.Nr;
            case 4:
                return a1.Cdma;
            default:
                return a1.Unknown;
        }
    }
}
