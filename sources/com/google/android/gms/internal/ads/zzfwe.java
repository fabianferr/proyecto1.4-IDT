package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzfwe extends zzfxh {
    zzfwe() {
    }

    public final void clear() {
        zza().clear();
    }

    public boolean contains(@CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object zza = zzfwi.zza(zza(), key);
        if (!zzfss.zza(zza, entry.getValue())) {
            return false;
        }
        if (zza != null || zza().containsKey(key)) {
            return true;
        }
        return false;
    }

    public final boolean isEmpty() {
        return zza().isEmpty();
    }

    public boolean remove(@CheckForNull Object obj) {
        if (!contains(obj) || !(obj instanceof Map.Entry)) {
            return false;
        }
        return zza().keySet().remove(((Map.Entry) obj).getKey());
    }

    public final int size() {
        return zza().size();
    }

    /* access modifiers changed from: package-private */
    public abstract Map zza();

    public final boolean removeAll(Collection collection) {
        collection.getClass();
        try {
            return zzfxi.zzd(this, collection);
        } catch (UnsupportedOperationException unused) {
            return zzfxi.zze(this, collection.iterator());
        }
    }

    public final boolean retainAll(Collection collection) {
        int i;
        collection.getClass();
        try {
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size < 3) {
                zzfum.zza(size, "expectedSize");
                i = size + 1;
            } else if (size < 1073741824) {
                double d = (double) size;
                Double.isNaN(d);
                i = (int) Math.ceil(d / 0.75d);
            } else {
                i = Integer.MAX_VALUE;
            }
            HashSet hashSet = new HashSet(i);
            for (Object next : collection) {
                if (contains(next) && (next instanceof Map.Entry)) {
                    hashSet.add(((Map.Entry) next).getKey());
                }
            }
            return zza().keySet().retainAll(hashSet);
        }
    }
}
