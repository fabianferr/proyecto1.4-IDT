package com.appnext.core;

import com.appnext.base.a;

public final class b {
    private String bZ = "";
    private String ca = "";
    private String cat = "";
    private int cc;
    private int cd;
    private int cnt;
    private String pbk = "";

    public b(Ad ad) {
        try {
            this.bZ = ad.getPlacementID();
            this.cat = ad.getCategories();
            this.ca = ad.getSpecificCategories();
            this.pbk = ad.getPostback();
            this.cc = ad.getMinVideoLength();
            this.cd = ad.getMaxVideoLength();
            this.cnt = ad.getCount();
        } catch (Throwable th) {
            a.a("AdKey$AdKey", th);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        try {
            if (!getClass().isInstance(obj) && !obj.getClass().isInstance(this)) {
                return false;
            }
            if (obj instanceof b) {
                return ((b) obj).bZ.equals(this.bZ) && ((b) obj).cat.equals(this.cat) && ((b) obj).ca.equals(this.ca) && ((b) obj).pbk.equals(this.pbk) && ((b) obj).cc == this.cc && ((b) obj).cd == this.cd && ((b) obj).cnt == this.cnt;
            }
            return super.equals(obj);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final int hashCode() {
        return (((((((((((this.bZ.hashCode() * 31) + this.cat.hashCode()) * 31) + this.ca.hashCode()) * 31) + this.pbk.hashCode()) * 31) + this.cc) * 31) + this.cd) * 31) + this.cnt;
    }
}
