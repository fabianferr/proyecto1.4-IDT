package com.google.ads.interactivemedia.v3.internal;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzlf extends zzmh {
    public zzlf(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2) {
        super(zzkt, "T3/sZUE/W2YS2JEZxAJ9+4WZqL0N5U3nlPH/EgJtSfFyoL5ScIK7u2ujqCA7A1X+", "/kxg835MxJPnjT7DvCL5Ez5ZnGTMXmN+leb95qeWXpw=", zzaf, i, 49);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzaa(3);
        try {
            int i = 1;
            boolean booleanValue = ((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue();
            zzaf zzaf = this.zze;
            if (true == booleanValue) {
                i = 2;
            }
            zzaf.zzaa(i);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
