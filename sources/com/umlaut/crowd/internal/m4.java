package com.umlaut.crowd.internal;

import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import java.io.IOException;
import java.io.OutputStream;

public class m4 extends o4 {
    public m4(j4 j4Var, OutputStream outputStream) throws g4 {
        super(outputStream);
        p();
        b(CmcdHeadersFactory.STREAMING_FORMAT_HLS);
        j4Var.a((o4) this);
        b("d");
        this.b = 1;
        this.c = (char) i4.JSON_MODE_INIT.a();
    }

    public void close() throws IOException {
        if (!this.h) {
            if (this.b == 1) {
                this.a[0] = (char) i4.JSON_MODE_DONE.a();
                char[] cArr = this.a;
                i4 i4Var = i4.JSON_MODE_OBJECT;
                cArr[1] = (char) i4Var.a();
                this.c = (char) i4Var.a();
                this.b = 2;
                try {
                    k();
                    super.close();
                } catch (g4 e) {
                    throw new IOException("Error on finilizing JSONSteam: " + e.getMessage(), e);
                }
            } else {
                throw new IOException("Datacontent is not terminated properly");
            }
        }
    }
}
