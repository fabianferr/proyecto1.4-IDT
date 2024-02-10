package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzxi<T> {
    public final zzxi<T> nullSafe() {
        return new zzxh(this);
    }

    public abstract T read(zzacv zzacv) throws IOException;

    public abstract void write(zzacx zzacx, T t) throws IOException;
}
