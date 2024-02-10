package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;

public final class TeeDataSource implements DataSource {
    private long bytesRemaining;
    private final DataSink dataSink;
    private boolean dataSinkNeedsClosing;
    private final DataSource upstream;

    public TeeDataSource(DataSource dataSource, DataSink dataSink2) {
        this.upstream = (DataSource) Assertions.checkNotNull(dataSource);
        this.dataSink = (DataSink) Assertions.checkNotNull(dataSink2);
    }

    public final long open(DataSpec dataSpec) throws IOException {
        DataSpec dataSpec2 = dataSpec;
        long open = this.upstream.open(dataSpec2);
        this.bytesRemaining = open;
        if (open == 0) {
            return 0;
        }
        if (dataSpec2.length == -1 && this.bytesRemaining != -1) {
            dataSpec2 = new DataSpec(dataSpec2.uri, dataSpec2.absoluteStreamPosition, dataSpec2.position, this.bytesRemaining, dataSpec2.key, dataSpec2.flags);
        }
        this.dataSinkNeedsClosing = true;
        this.dataSink.open(dataSpec2);
        return this.bytesRemaining;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.bytesRemaining == 0) {
            return -1;
        }
        int read = this.upstream.read(bArr, i, i2);
        if (read > 0) {
            this.dataSink.write(bArr, i, read);
            long j = this.bytesRemaining;
            if (j != -1) {
                this.bytesRemaining = j - ((long) read);
            }
        }
        return read;
    }

    public final Uri getUri() {
        return this.upstream.getUri();
    }

    public final void close() throws IOException {
        try {
            this.upstream.close();
        } finally {
            if (this.dataSinkNeedsClosing) {
                this.dataSinkNeedsClosing = false;
                this.dataSink.close();
            }
        }
    }
}
