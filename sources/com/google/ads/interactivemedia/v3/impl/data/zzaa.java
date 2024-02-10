package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaa extends zzbi {
    private final String message;
    private final String name;

    zzaa(String str, String str2) {
        this.name = str;
        this.message = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbi) {
            zzbi zzbi = (zzbi) obj;
            String str = this.name;
            if (str != null ? str.equals(zzbi.name()) : zzbi.name() == null) {
                String str2 = this.message;
                if (str2 != null ? str2.equals(zzbi.message()) : zzbi.message() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public String message() {
        return this.message;
    }

    public String name() {
        return this.name;
    }

    public String toString() {
        String str = this.name;
        String str2 = this.message;
        return "LoggableException{name=" + str + ", message=" + str2 + "}";
    }

    public int hashCode() {
        int i;
        String str = this.name;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        String str2 = this.message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((i ^ 1000003) * 1000003) ^ i2;
    }
}
