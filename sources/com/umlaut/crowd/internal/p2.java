package com.umlaut.crowd.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class p2 extends Reader {
    private static final String b = System.getProperty("line.separator");
    private static final Charset c = Charset.forName("UTF-8");
    private Reader a;

    public p2(InputStream inputStream) throws IOException {
        this.a = new InputStreamReader(inputStream, c);
    }

    public void close() throws IOException {
        synchronized (this) {
            this.a.close();
        }
    }

    public String g() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int i = -1;
        while (true) {
            int read = this.a.read();
            if (read == -1) {
                if (stringBuffer.length() == 0) {
                    return null;
                }
                return stringBuffer.toString();
            } else if (read == 10) {
                return stringBuffer.toString();
            } else {
                if (i == 13 && read == 0) {
                    stringBuffer.append(b);
                } else if (!(read == 0 || read == 13)) {
                    stringBuffer.append((char) read);
                }
                i = read;
            }
        }
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        throw new IOException("Currently not supported");
    }
}
