package androidx.media3.datasource.rtmp;

import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;

@Deprecated
public final class RtmpDataSourceFactory implements DataSource.Factory {
    private final TransferListener listener;

    public RtmpDataSourceFactory() {
        this((TransferListener) null);
    }

    public RtmpDataSourceFactory(TransferListener transferListener) {
        this.listener = transferListener;
    }

    public RtmpDataSource createDataSource() {
        RtmpDataSource rtmpDataSource = new RtmpDataSource();
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            rtmpDataSource.addTransferListener(transferListener);
        }
        return rtmpDataSource;
    }
}
