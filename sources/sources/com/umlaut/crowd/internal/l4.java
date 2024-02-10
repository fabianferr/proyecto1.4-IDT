package com.umlaut.crowd.internal;

import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import java.io.IOException;
import java.io.InputStream;

public class l4 extends k4 {
    private j4 p = new j4();

    public l4(InputStream inputStream) throws g4 {
        super(inputStream);
        H();
        if (q().equals(CmcdHeadersFactory.STREAMING_FORMAT_HLS)) {
            this.p.c(this);
            try {
                if (q().equals("d")) {
                    this.b = 1;
                    this.c = (char) i4.JSON_MODE_INIT.a();
                    return;
                }
                throw new g4("Expected data is missing...");
            } catch (Exception e) {
                throw new g4("Expected data is missing.", e);
            }
        } else {
            throw new g4("Expected header is missing...");
        }
    }

    public j4 J() {
        return this.p;
    }

    public void close() throws IOException {
        if (!this.e) {
            if (this.b == 1) {
                this.a[0] = (char) i4.JSON_MODE_DONE.a();
                char[] cArr = this.a;
                i4 i4Var = i4.JSON_MODE_OBJECT;
                cArr[1] = (char) i4Var.a();
                this.c = (char) i4Var.a();
                this.b = 2;
                try {
                    l();
                } catch (g4 e) {
                    throw new IOException("Error on finilizing JSONSteam: " + e.getMessage(), e);
                }
            }
            super.close();
        }
    }
}
