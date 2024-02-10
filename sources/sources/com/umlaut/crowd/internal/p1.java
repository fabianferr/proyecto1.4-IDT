package com.umlaut.crowd.internal;

import android.util.Log;
import com.umlaut.crowd.utils.DateUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class p1 {
    private static final String f = "p1";
    private static final int g = 1;
    private static final int h = 2;
    private static final boolean i = false;
    private String a;
    private File b;
    private PublicKey c;
    private Calendar d = Calendar.getInstance();
    private String e;

    public p1(String str, File file, PublicKey publicKey, String str2) {
        this.a = str;
        this.b = file;
        this.c = publicKey;
        this.e = str2;
    }

    public String a(w2 w2Var, byte[] bArr, Date date, boolean z) {
        try {
            SecretKey b2 = c.b();
            IvParameterSpec a2 = c.a();
            byte[] a3 = c.a(bArr, b2, a2);
            byte[] iv = a2.getIV();
            byte[] encoded = b2.getEncoded();
            byte[] a4 = h9.a(a3);
            byte[] seed = SecureRandom.getSeed(200);
            seed[0] = 80;
            seed[1] = 51;
            seed[2] = 105;
            if (z) {
                seed[3] = 2;
            } else {
                seed[3] = 1;
            }
            System.arraycopy(iv, 0, seed, 4, iv.length);
            System.arraycopy(encoded, 0, seed, 20, encoded.length);
            System.arraycopy(a4, 0, seed, 52, a4.length);
            byte[] a5 = a8.a(seed, this.c);
            String path = this.b.getPath();
            if (!path.endsWith("/")) {
                path = path + "/";
            }
            this.d.setTime(date);
            String str = path + this.e + "-" + w2Var + "-" + this.a + "-" + DateUtils.formatETLDateTime(this.d.get(1), this.d.get(2) + 1, this.d.get(5), this.d.get(11), this.d.get(12), this.d.get(13), this.d.get(14)) + ".p3ic";
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(a5);
            fileOutputStream.write(a3);
            fileOutputStream.flush();
            fileOutputStream.close();
            return str;
        } catch (Exception e2) {
            Log.e(f, "writeFile: " + e2.getMessage());
            e2.printStackTrace();
            return null;
        }
    }
}
