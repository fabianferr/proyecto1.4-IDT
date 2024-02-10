package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.security.PrivilegedAction;
import java.util.ArrayList;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzabw implements PrivilegedAction {
    final /* synthetic */ Class zza;

    zzabw(zzabx zzabx, Class cls) {
        this.zza = cls;
    }

    public final /* bridge */ /* synthetic */ Object run() {
        ArrayList arrayList = new ArrayList(r2);
        for (Field field : this.zza.getDeclaredFields()) {
            if (field.isEnumConstant()) {
                arrayList.add(field);
            }
        }
        Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
        AccessibleObject.setAccessible(fieldArr, true);
        return fieldArr;
    }
}
