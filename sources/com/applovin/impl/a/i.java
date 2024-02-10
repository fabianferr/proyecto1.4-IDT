package com.applovin.impl.a;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.r;

public class i {
    private String a;
    private String b;

    private i() {
    }

    public static i a(r rVar, i iVar, m mVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            if (iVar == null) {
                try {
                    iVar = new i();
                } catch (Throwable th) {
                    if (!u.a()) {
                        return null;
                    }
                    mVar.A().b("VastSystemInfo", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (!StringUtils.isValidString(iVar.a)) {
                String c = rVar.c();
                if (StringUtils.isValidString(c)) {
                    iVar.a = c;
                }
            }
            if (!StringUtils.isValidString(iVar.b)) {
                String str = rVar.b().get("version");
                if (StringUtils.isValidString(str)) {
                    iVar.b = str;
                }
            }
            return iVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        String str = this.a;
        if (str == null ? iVar.a != null : !str.equals(iVar.a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = iVar.b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "VastSystemInfo{name='" + this.a + "', version='" + this.b + "'}";
    }
}
