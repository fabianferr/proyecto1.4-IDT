package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class DeflateDecompressingEntity extends DecompressingEntity {
    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        return -1;
    }

    public DeflateDecompressingEntity(HttpEntity httpEntity) {
        super(httpEntity);
    }

    public InputStream getContent() throws IOException {
        int inflate;
        byte[] bArr = new byte[6];
        PushbackInputStream pushbackInputStream = new PushbackInputStream(this.wrappedEntity.getContent(), 6);
        int read = pushbackInputStream.read(bArr);
        if (read != -1) {
            byte[] bArr2 = new byte[1];
            Inflater inflater = new Inflater();
            while (true) {
                try {
                    inflate = inflater.inflate(bArr2);
                    if (inflate != 0) {
                        break;
                    } else if (inflater.finished()) {
                        throw new IOException("Unable to read the response");
                    } else if (inflater.needsDictionary()) {
                        break;
                    } else if (inflater.needsInput()) {
                        inflater.setInput(bArr);
                    }
                } catch (DataFormatException unused) {
                    pushbackInputStream.unread(bArr, 0, read);
                    return new InflaterInputStream(pushbackInputStream, new Inflater(true));
                }
            }
            if (inflate != -1) {
                pushbackInputStream.unread(bArr, 0, read);
                return new InflaterInputStream(pushbackInputStream);
            }
            throw new IOException("Unable to read the response");
        }
        throw new IOException("Unable to read the response");
    }
}
