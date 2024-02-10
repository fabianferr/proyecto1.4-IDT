package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.StringWriter;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public class zzwr {
    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            zzacx zzacx = new zzacx(stringWriter);
            zzacx.zzo(true);
            zzaby.zzV.write(zzacx, this);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
