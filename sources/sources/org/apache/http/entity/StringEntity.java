package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;

public class StringEntity extends AbstractHttpEntity implements Cloneable {
    protected final byte[] content;

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public StringEntity(String str, String str2, String str3) throws UnsupportedEncodingException {
        if (str != null) {
            str2 = str2 == null ? "text/plain" : str2;
            str3 = str3 == null ? "ISO-8859-1" : str3;
            this.content = str.getBytes(str3);
            setContentType(new StringBuffer().append(str2).append(HTTP.CHARSET_PARAM).append(str3).toString());
            return;
        }
        throw new IllegalArgumentException("Source string may not be null");
    }

    public StringEntity(String str, String str2) throws UnsupportedEncodingException {
        this(str, (String) null, str2);
    }

    public StringEntity(String str) throws UnsupportedEncodingException {
        this(str, (String) null);
    }

    public long getContentLength() {
        return (long) this.content.length;
    }

    public InputStream getContent() throws IOException {
        return new ByteArrayInputStream(this.content);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.write(this.content);
            outputStream.flush();
            return;
        }
        throw new IllegalArgumentException("Output stream may not be null");
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
