package com.umlaut.crowd.utils;

import android.content.Context;
import com.facebook.internal.security.CertificateUtil;
import com.umlaut.crowd.internal.ub;
import com.umlaut.crowd.internal.v1;
import com.umlaut.crowd.timeserver.TimeServer;
import java.util.TimeZone;
import org.slf4j.Marker;

public class DateUtils {
    private static String a(long j, boolean z) {
        v1 millisToDate = millisToDate(j);
        return simpleFormatDateTime(millisToDate.a, millisToDate.b, millisToDate.c, millisToDate.d, millisToDate.e, millisToDate.f, millisToDate.g, z, millisToDate.h);
    }

    public static ub addMillisToTimeInfo(ub ubVar, long j) {
        ub ubVar2 = new ub();
        ubVar2.DeviceDriftMillis = ubVar.DeviceDriftMillis;
        ubVar2.IsSynced = ubVar.IsSynced;
        ubVar2.MillisSinceLastSync = ubVar.MillisSinceLastSync;
        ubVar2.TimeSource = ubVar.TimeSource;
        ubVar2.TimestampDateTime = formatDateTime(ubVar.TimestampMillis + j);
        ubVar2.TimestampMillis = ubVar.TimestampMillis + j;
        ubVar2.TimestampOffset = ubVar.TimestampOffset;
        ubVar2.TimestampTableau = formatTableau(ubVar.TimestampMillis + j);
        return ubVar2;
    }

    public static String formatDateTime(long j) {
        return a(j, false);
    }

    public static String formatETLDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        String formatLumenDateTime = formatLumenDateTime(i, i2, i3, i4, i5, i6);
        String str = "" + i7;
        if (i7 < 10) {
            str = "00" + i7;
        } else if (i7 < 100) {
            str = "0" + i7;
        }
        return formatLumenDateTime + "-" + str;
    }

    public static String formatLumenDate(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("-");
        if (i2 < 10) {
            sb.append("0");
        }
        sb.append(i2);
        sb.append("-");
        if (i3 < 10) {
            sb.append("0");
        }
        sb.append(i3);
        return sb.toString();
    }

    public static String formatLumenDateTime(int i, int i2, int i3, int i4, int i5, int i6) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("-");
        if (i2 < 10) {
            sb.append("0");
        }
        sb.append(i2);
        sb.append("-");
        if (i3 < 10) {
            sb.append("0");
        }
        sb.append(i3);
        sb.append("-");
        if (i4 < 10) {
            sb.append("0");
        }
        sb.append(i4);
        sb.append("-");
        if (i5 < 10) {
            sb.append("0");
        }
        sb.append(i5);
        sb.append("-");
        if (i6 < 10) {
            sb.append("0");
        }
        sb.append(i6);
        return sb.toString();
    }

    public static String formatLumenTime(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        if (i < 10) {
            sb.append("0");
        }
        sb.append(i);
        sb.append("-");
        if (i2 < 10) {
            sb.append("0");
        }
        sb.append(i2);
        sb.append("-");
        if (i3 < 10) {
            sb.append("0");
        }
        sb.append(i3);
        return sb.toString();
    }

    public static String formatTableau(long j) {
        return a(j, true);
    }

    public static String getTimestamp(Context context) {
        return formatTableau(TimeServer.getTimeInMillis());
    }

    public static v1 millisToDate(long j) {
        return millisToDate(j, TimeZone.getDefault().getOffset(j));
    }

    public static String simpleFormatDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, int i8) {
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        int i15 = i8;
        String str = "" + i10;
        String str2 = "" + i9;
        String str3 = "" + i11;
        String str4 = "" + i12;
        String str5 = "" + i13;
        String str6 = "" + i14;
        if (i10 < 10) {
            str = "0" + i10;
        }
        if (i9 < 10) {
            str2 = "0" + i9;
        }
        if (i11 < 10) {
            str3 = "0" + i11;
        }
        if (i12 < 10) {
            str4 = "0" + i12;
        }
        if (i13 < 10) {
            str5 = "0" + i13;
        }
        if (i14 < 10) {
            str6 = "00" + i14;
        } else if (i14 < 100) {
            str6 = "0" + i14;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        String str7 = "-";
        sb.append(str7);
        sb.append(str2);
        sb.append(str7);
        sb.append(str);
        sb.append(" ");
        sb.append(str3);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(str4);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(str5);
        sb.append(".");
        sb.append(str6);
        String sb2 = sb.toString();
        if (!z) {
            return sb2;
        }
        int i16 = (i15 / 1000) / 60;
        if (i15 < 0) {
            i16 *= -1;
        } else {
            str7 = Marker.ANY_NON_NULL_MARKER;
        }
        int i17 = i16 / 60;
        int i18 = i16 % 60;
        String str8 = "" + i17;
        String str9 = "" + i18;
        if (i17 < 10) {
            str8 = "0" + i17;
        }
        if (i18 < 10) {
            str9 = "0" + i18;
        }
        return sb2 + " " + str7 + str8 + str9;
    }

    public static v1 millisToDate(long j, int i) {
        int i2;
        int i3;
        long j2 = ((long) i) + j;
        long j3 = j2 / 1000;
        int i4 = (int) (j2 % 1000);
        long j4 = j3 / 60;
        int i5 = (int) (j3 % 60);
        long j5 = j4 / 60;
        int i6 = (int) (j4 % 60);
        int i7 = (int) (j5 / 24);
        int i8 = (int) (j5 % 24);
        int i9 = 1970;
        int i10 = 365;
        int i11 = 0;
        boolean z = false;
        while (true) {
            i2 = 1;
            i3 = i7 + 1;
            if (i10 >= i3) {
                break;
            }
            i9++;
            int i12 = i10 + 365;
            if ((i9 % 4 != 0 || i9 % 100 == 0) && i9 % 400 != 0) {
                z = false;
            } else {
                i12++;
                z = true;
            }
            int i13 = i12;
            i11 = i10;
            i10 = i13;
        }
        int i14 = i3 - i11;
        int i15 = 31;
        int i16 = 0;
        while (i15 < i14) {
            i2++;
            i16 = i15;
            i15 = (!z || i2 != 2) ? i2 == 2 ? i15 + 28 : (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? i15 + 30 : i15 + 31 : i15 + 29;
        }
        return new v1(i9, i2, i14 - i16, i8, i6, i5, i4, i);
    }
}
