package com.google.android.exoplayer2.transformer;

import android.os.ParcelFileDescriptor;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.nio.ByteBuffer;

interface Muxer {

    public interface Factory {
        Muxer create(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException;

        Muxer create(String str, String str2) throws IOException;

        boolean supportsOutputMimeType(String str);
    }

    int addTrack(Format format);

    void release(boolean z);

    boolean supportsSampleMimeType(String str);

    void writeSampleData(int i, ByteBuffer byteBuffer, boolean z, long j);
}
