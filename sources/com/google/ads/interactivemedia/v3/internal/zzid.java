package com.google.ads.interactivemedia.v3.internal;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzid implements Runnable {
    private zzid() {
    }

    /* synthetic */ zzid(zzic zzic) {
    }

    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzie.zzd = MessageDigest.getInstance(SameMD5.TAG);
            countDownLatch = zzie.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzie.zzb;
        } catch (Throwable th) {
            zzie.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
