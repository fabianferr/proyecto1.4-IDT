package com.google.ads.interactivemedia.v3.internal;

import java.math.BigInteger;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzww extends zzwr {
    private final Object zza;

    public zzww(Boolean bool) {
        this.zza = bool;
    }

    public zzww(Number number) {
        this.zza = number;
    }

    public zzww(String str) {
        str.getClass();
        this.zza = str;
    }

    private static boolean zzg(zzww zzww) {
        Object obj = zzww.zza;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzww zzww = (zzww) obj;
        if (this.zza == null) {
            return zzww.zza == null;
        }
        if (!zzg(this) || !zzg(zzww)) {
            Object obj2 = this.zza;
            if (!(obj2 instanceof Number) || !(zzww.zza instanceof Number)) {
                return obj2.equals(zzww.zza);
            }
            double doubleValue = zza().doubleValue();
            double doubleValue2 = zzww.zza().doubleValue();
            if (doubleValue != doubleValue2) {
                return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
            }
            return true;
        } else if ((this.zza instanceof BigInteger) || (zzww.zza instanceof BigInteger)) {
            return zzc().equals(zzww.zzc());
        } else {
            return zza().longValue() == zzww.zza().longValue();
        }
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (this.zza == null) {
            return 31;
        }
        if (zzg(this)) {
            doubleToLongBits = zza().longValue();
        } else {
            Object obj = this.zza;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(zza().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public final Number zza() {
        Object obj = this.zza;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new zzyq((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public final String zzb() {
        Object obj = this.zza;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Number) {
            return zza().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        throw new AssertionError("Unexpected value type: ".concat(String.valueOf(String.valueOf(obj.getClass()))));
    }

    public final BigInteger zzc() {
        Object obj = this.zza;
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if (zzg(this)) {
            return BigInteger.valueOf(zza().longValue());
        }
        return new BigInteger(zzb());
    }

    public final boolean zzd() {
        Object obj = this.zza;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return Boolean.parseBoolean(zzb());
    }

    public final boolean zze() {
        return this.zza instanceof Boolean;
    }

    public final boolean zzf() {
        return this.zza instanceof Number;
    }
}
