package org.apache.http.impl.client.cache;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.client.cache.InputLimit;
import org.apache.http.client.cache.Resource;
import org.apache.http.client.cache.ResourceFactory;

public class HeapResourceFactory implements ResourceFactory {
    public Resource generate(String str, InputStream inputStream, InputLimit inputLimit) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
            j += (long) read;
            if (inputLimit != null && j > inputLimit.getValue()) {
                inputLimit.reached();
                break;
            }
        }
        return new HeapResource(byteArrayOutputStream.toByteArray());
    }

    public Resource copy(String str, Resource resource) throws IOException {
        byte[] bArr;
        if (resource instanceof HeapResource) {
            bArr = ((HeapResource) resource).getByteArray();
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IOUtils.copyAndClose(resource.getInputStream(), byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
        }
        return new HeapResource(bArr);
    }
}
