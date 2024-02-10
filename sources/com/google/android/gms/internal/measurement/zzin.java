package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzim;
import com.google.android.gms.internal.measurement.zzin;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
public abstract class zzin<MessageType extends zzin<MessageType, BuilderType>, BuilderType extends zzim<MessageType, BuilderType>> implements zzll {
    protected int zzb = 0;

    protected static void zzbt(Iterable iterable, List list) {
        zzkm.zze(iterable);
        if (iterable instanceof zzkt) {
            List zzh = ((zzkt) iterable).zzh();
            zzkt zzkt = (zzkt) list;
            int size = list.size();
            for (Object next : zzh) {
                if (next == null) {
                    int size2 = zzkt.size();
                    String str = "Element at index " + (size2 - size) + " is null.";
                    int size3 = zzkt.size();
                    while (true) {
                        size3--;
                        if (size3 >= size) {
                            zzkt.remove(size3);
                        } else {
                            throw new NullPointerException(str);
                        }
                    }
                } else if (next instanceof zzjd) {
                    zzkt.zzi((zzjd) next);
                } else {
                    zzkt.add((String) next);
                }
            }
        } else if (!(iterable instanceof zzls)) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size4 = list.size();
            for (Object next2 : iterable) {
                if (next2 == null) {
                    int size5 = list.size();
                    String str2 = "Element at index " + (size5 - size4) + " is null.";
                    int size6 = list.size();
                    while (true) {
                        size6--;
                        if (size6 >= size4) {
                            list.remove(size6);
                        } else {
                            throw new NullPointerException(str2);
                        }
                    }
                } else {
                    list.add(next2);
                }
            }
        } else {
            list.addAll((Collection) iterable);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzbr() {
        throw null;
    }

    public final zzjd zzbs() {
        try {
            int zzbw = zzbw();
            zzjd zzjd = zzjd.zzb;
            byte[] bArr = new byte[zzbw];
            zzjl zzC = zzjl.zzC(bArr);
            zzbK(zzC);
            zzC.zzD();
            return new zzja(bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzbu(int i) {
        throw null;
    }

    public final byte[] zzbv() {
        try {
            byte[] bArr = new byte[zzbw()];
            zzjl zzC = zzjl.zzC(bArr);
            zzbK(zzC);
            zzC.zzD();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
