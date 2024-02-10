package com.umlaut.crowd;

import com.facebook.internal.security.OidcSecurityUtil;
import com.umlaut.crowd.internal.a8;
import com.umlaut.crowd.utils.JsonUtils;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.security.PublicKey;
import java.security.Signature;

class ICB {
    public PublicKey a;
    public IC b;

    private ICB() {
    }

    static ICB a(byte[] bArr) throws Exception {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ICB icb = new ICB();
        byte[] bArr2 = new byte[((int) dataInputStream.readLong())];
        dataInputStream.read(bArr2);
        icb.a = a8.b(bArr2);
        byte[] bArr3 = new byte[((int) dataInputStream.readLong())];
        dataInputStream.read(bArr3);
        String str = new String(bArr3);
        byte[] bArr4 = new byte[dataInputStream.readInt()];
        dataInputStream.read(bArr4);
        Signature instance = Signature.getInstance(OidcSecurityUtil.SIGNATURE_ALGORITHM_SHA256);
        instance.initVerify(icb.a);
        instance.update(bArr3);
        if (instance.verify(bArr4)) {
            icb.b = (IC) JsonUtils.fromJson(str, IC.class);
            return icb;
        }
        throw new IllegalArgumentException();
    }
}
