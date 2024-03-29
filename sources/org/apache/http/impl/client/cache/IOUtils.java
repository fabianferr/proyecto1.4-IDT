package org.apache.http.impl.client.cache;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

class IOUtils {
    IOUtils() {
    }

    static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    static void closeSilently(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    static void copyAndClose(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            copy(inputStream, outputStream);
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            closeSilently(inputStream);
            closeSilently(outputStream);
            throw e;
        }
    }

    static void copyFile(File file, File file2) throws IOException {
        FileChannel channel;
        FileChannel channel2;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, CampaignEx.JSON_KEY_AD_R);
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "w");
        try {
            channel = randomAccessFile.getChannel();
            channel2 = randomAccessFile2.getChannel();
            channel.transferTo(0, randomAccessFile.length(), channel2);
            channel.close();
            channel2.close();
            randomAccessFile.close();
            randomAccessFile2.close();
        } catch (IOException e) {
            closeSilently(channel);
            closeSilently(channel2);
            throw e;
        } catch (IOException e2) {
            closeSilently(randomAccessFile);
            closeSilently(randomAccessFile2);
            throw e2;
        }
    }
}
