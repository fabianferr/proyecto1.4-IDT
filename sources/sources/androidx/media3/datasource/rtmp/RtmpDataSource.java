package androidx.media3.datasource.rtmp;

import android.net.Uri;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.BaseDataSource;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import io.antmedia.rtmp_client.RtmpClient;
import java.io.IOException;

public final class RtmpDataSource extends BaseDataSource {
    private RtmpClient rtmpClient;
    private Uri uri;

    static {
        MediaLibraryInfo.registerModule("media3.datasource.rtmp");
    }

    public static final class Factory implements DataSource.Factory {
        private TransferListener transferListener;

        public Factory setTransferListener(TransferListener transferListener2) {
            this.transferListener = transferListener2;
            return this;
        }

        public RtmpDataSource createDataSource() {
            RtmpDataSource rtmpDataSource = new RtmpDataSource();
            TransferListener transferListener2 = this.transferListener;
            if (transferListener2 != null) {
                rtmpDataSource.addTransferListener(transferListener2);
            }
            return rtmpDataSource;
        }
    }

    public RtmpDataSource() {
        super(true);
    }

    public long open(DataSpec dataSpec) throws RtmpClient.RtmpIOException {
        transferInitializing(dataSpec);
        RtmpClient rtmpClient2 = new RtmpClient();
        this.rtmpClient = rtmpClient2;
        rtmpClient2.open(dataSpec.uri.toString(), false);
        this.uri = dataSpec.uri;
        transferStarted(dataSpec);
        return -1;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = ((RtmpClient) Util.castNonNull(this.rtmpClient)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        bytesTransferred(read);
        return read;
    }

    public void close() {
        if (this.uri != null) {
            this.uri = null;
            transferEnded();
        }
        RtmpClient rtmpClient2 = this.rtmpClient;
        if (rtmpClient2 != null) {
            rtmpClient2.close();
            this.rtmpClient = null;
        }
    }

    public Uri getUri() {
        return this.uri;
    }
}
