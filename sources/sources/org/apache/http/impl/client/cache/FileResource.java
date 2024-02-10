package org.apache.http.impl.client.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.client.cache.Resource;

public class FileResource implements Resource {
    private static final long serialVersionUID = 4132244415919043397L;
    private volatile boolean disposed = false;
    private final File file;

    public FileResource(File file2) {
        this.file = file2;
    }

    private void ensureValid() {
        if (this.disposed) {
            throw new IllegalStateException("Resource has been deallocated");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized File getFile() {
        ensureValid();
        return this.file;
    }

    public synchronized InputStream getInputStream() throws IOException {
        ensureValid();
        return new FileInputStream(this.file);
    }

    public synchronized long length() {
        ensureValid();
        return this.file.length();
    }

    public synchronized void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.file.delete();
        }
    }
}
