package org.apache.http.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileEntity extends AbstractHttpEntity implements Cloneable {
    protected final File file;

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public FileEntity(File file2, String str) {
        if (file2 != null) {
            this.file = file2;
            setContentType(str);
            return;
        }
        throw new IllegalArgumentException("File may not be null");
    }

    public long getContentLength() {
        return this.file.length();
    }

    public InputStream getContent() throws IOException {
        return new FileInputStream(this.file);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            FileInputStream fileInputStream = new FileInputStream(this.file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        return;
                    }
                }
            } finally {
                fileInputStream.close();
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
