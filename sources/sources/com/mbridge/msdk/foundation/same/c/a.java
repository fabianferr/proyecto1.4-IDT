package com.mbridge.msdk.foundation.same.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.mbridge.msdk.foundation.tools.y;

/* compiled from: CommonBitmapUtil */
public final class a {
    public static Bitmap a(String str) {
        Bitmap bitmap = null;
        if (!y.a(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inJustDecodeBounds = false;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inDither = true;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.gc();
            b.b();
            try {
                options.inPreferredConfig = Bitmap.Config.ARGB_4444;
                bitmap = BitmapFactory.decodeFile(str, options);
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return bitmap;
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                return bitmap;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002e A[Catch:{ all -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0033 A[SYNTHETIC, Splitter:B:21:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0044 A[SYNTHETIC, Splitter:B:30:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.InputStream a(android.graphics.Bitmap r4) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0028, all -> 0x0026 }
            r1.<init>()     // Catch:{ Exception -> 0x0028, all -> 0x0026 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0024 }
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch:{ Exception -> 0x0024 }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0024 }
            byte[] r2 = r1.toByteArray()     // Catch:{ Exception -> 0x0024 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0024 }
            r1.close()     // Catch:{ Exception -> 0x001a }
            goto L_0x0022
        L_0x001a:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x0022
            r0.printStackTrace()
        L_0x0022:
            r0 = r4
            goto L_0x003f
        L_0x0024:
            r4 = move-exception
            goto L_0x002a
        L_0x0026:
            r4 = move-exception
            goto L_0x0042
        L_0x0028:
            r4 = move-exception
            r1 = r0
        L_0x002a:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x0031
            r4.printStackTrace()     // Catch:{ all -> 0x0040 }
        L_0x0031:
            if (r1 == 0) goto L_0x003f
            r1.close()     // Catch:{ Exception -> 0x0037 }
            goto L_0x003f
        L_0x0037:
            r4 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x003f
            r4.printStackTrace()
        L_0x003f:
            return r0
        L_0x0040:
            r4 = move-exception
            r0 = r1
        L_0x0042:
            if (r0 == 0) goto L_0x0050
            r0.close()     // Catch:{ Exception -> 0x0048 }
            goto L_0x0050
        L_0x0048:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x0050
            r0.printStackTrace()
        L_0x0050:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.c.a.a(android.graphics.Bitmap):java.io.InputStream");
    }
}
