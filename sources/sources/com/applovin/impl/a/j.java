package com.applovin.impl.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.r;
import com.facebook.internal.security.CertificateUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class j {
    private String a;
    private String b;
    private String c;
    private long d = -1;
    private int e = -1;

    private j() {
    }

    private static int a(String str, e eVar) {
        if ("start".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(str)) {
            return 25;
        }
        if (CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT.equalsIgnoreCase(str)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(str)) {
            return 75;
        }
        if (!CampaignEx.JSON_NATIVE_VIDEO_COMPLETE.equalsIgnoreCase(str)) {
            return -1;
        }
        if (eVar != null) {
            return eVar.h();
        }
        return 95;
    }

    public static j a(r rVar, e eVar, m mVar) {
        List<String> explode;
        int size;
        TimeUnit timeUnit;
        long seconds;
        if (rVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            try {
                String c2 = rVar.c();
                if (StringUtils.isValidString(c2)) {
                    j jVar = new j();
                    jVar.c = c2;
                    jVar.a = rVar.b().get("id");
                    jVar.b = rVar.b().get("event");
                    jVar.e = a(jVar.a(), eVar);
                    String str = rVar.b().get(TypedValues.CycleType.S_WAVE_OFFSET);
                    if (StringUtils.isValidString(str)) {
                        String trim = str.trim();
                        if (trim.contains("%")) {
                            jVar.e = StringUtils.parseInt(trim.substring(0, trim.length() - 1));
                        } else if (trim.contains(CertificateUtil.DELIMITER) && (size = explode.size()) > 0) {
                            int i = size - 1;
                            long j = 0;
                            for (int i2 = i; i2 >= 0; i2--) {
                                String str2 = (explode = CollectionUtils.explode(trim, CertificateUtil.DELIMITER)).get(i2);
                                if (StringUtils.isNumeric(str2)) {
                                    int parseInt = Integer.parseInt(str2);
                                    if (i2 == i) {
                                        seconds = (long) parseInt;
                                    } else {
                                        if (i2 == size - 2) {
                                            timeUnit = TimeUnit.MINUTES;
                                        } else if (i2 == size - 3) {
                                            timeUnit = TimeUnit.HOURS;
                                        }
                                        seconds = timeUnit.toSeconds((long) parseInt);
                                    }
                                    j += seconds;
                                }
                            }
                            jVar.d = j;
                            jVar.e = -1;
                        }
                    }
                    return jVar;
                } else if (!u.a()) {
                    return null;
                } else {
                    mVar.A().e("VastTracker", "Unable to create tracker. Could not find URL.");
                    return null;
                }
            } catch (Throwable th) {
                if (!u.a()) {
                    return null;
                }
                mVar.A().b("VastTracker", "Error occurred while initializing", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public String a() {
        return this.b;
    }

    public boolean a(long j, int i) {
        long j2 = this.d;
        boolean z = j2 >= 0;
        boolean z2 = j >= j2;
        int i2 = this.e;
        boolean z3 = i2 >= 0;
        boolean z4 = i >= i2;
        if (!z || !z2) {
            return z3 && z4;
        }
        return true;
    }

    public String b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.d != jVar.d || this.e != jVar.e) {
            return false;
        }
        String str = this.a;
        if (str == null ? jVar.a != null : !str.equals(jVar.a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? jVar.b == null : str2.equals(jVar.b)) {
            return this.c.equals(jVar.c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        long j = this.d;
        return ((((((hashCode + i) * 31) + this.c.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.e;
    }

    public String toString() {
        return "VastTracker{identifier='" + this.a + "', event='" + this.b + "', uriString='" + this.c + "', offsetSeconds=" + this.d + ", offsetPercent=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
