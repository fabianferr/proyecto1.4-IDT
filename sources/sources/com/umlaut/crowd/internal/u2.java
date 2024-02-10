package com.umlaut.crowd.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

public class u2 extends Writer {
    private static final Charset b = Charset.forName("UTF-8");
    private Writer a;

    public u2(OutputStream outputStream) throws IOException {
        this.a = new OutputStreamWriter(outputStream, b);
    }

    public void a(String str) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "\r\n");
        int countTokens = stringTokenizer.countTokens();
        boolean z = false;
        for (int i = 0; i < countTokens; i++) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.length() > 0) {
                if (z) {
                    stringBuffer.append("\r\u0000");
                }
                stringBuffer.append(nextToken);
                z = true;
            }
        }
        if (stringBuffer.length() > 0) {
            this.a.write(stringBuffer.toString());
            this.a.write("\r\n");
            this.a.flush();
        }
    }

    public void close() throws IOException {
        synchronized (this) {
            this.a.close();
        }
    }

    public void flush() throws IOException {
        this.a.flush();
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        this.a.write(cArr, i, i2);
    }
}
