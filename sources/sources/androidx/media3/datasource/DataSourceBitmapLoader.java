package androidx.media3.datasource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.IOException;

public final class DataSourceBitmapLoader implements BitmapLoader {
    public static final Supplier<ListeningExecutorService> DEFAULT_EXECUTOR_SERVICE = Suppliers.memoize(new DataSourceBitmapLoader$$ExternalSyntheticLambda1());
    private final DataSource.Factory dataSourceFactory;
    private final ListeningExecutorService listeningExecutorService;

    public /* synthetic */ ListenableFuture loadBitmapFromMetadata(MediaMetadata mediaMetadata) {
        return BitmapLoader.CC.$default$loadBitmapFromMetadata(this, mediaMetadata);
    }

    public DataSourceBitmapLoader(Context context) {
        this((ListeningExecutorService) Assertions.checkStateNotNull(DEFAULT_EXECUTOR_SERVICE.get()), new DefaultDataSource.Factory(context));
    }

    public DataSourceBitmapLoader(ListeningExecutorService listeningExecutorService2, DataSource.Factory factory) {
        this.listeningExecutorService = listeningExecutorService2;
        this.dataSourceFactory = factory;
    }

    public ListenableFuture<Bitmap> decodeBitmap(byte[] bArr) {
        return this.listeningExecutorService.submit(new DataSourceBitmapLoader$$ExternalSyntheticLambda0(bArr));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$loadBitmap$2$androidx-media3-datasource-DataSourceBitmapLoader  reason: not valid java name */
    public /* synthetic */ Bitmap m72lambda$loadBitmap$2$androidxmedia3datasourceDataSourceBitmapLoader(Uri uri) throws Exception {
        return load(this.dataSourceFactory.createDataSource(), uri);
    }

    public ListenableFuture<Bitmap> loadBitmap(Uri uri) {
        return this.listeningExecutorService.submit(new DataSourceBitmapLoader$$ExternalSyntheticLambda2(this, uri));
    }

    /* access modifiers changed from: private */
    public static Bitmap decode(byte[] bArr) {
        boolean z = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        if (decodeByteArray != null) {
            z = true;
        }
        Assertions.checkArgument(z, "Could not decode image data");
        return decodeByteArray;
    }

    private static Bitmap load(DataSource dataSource, Uri uri) throws IOException {
        dataSource.open(new DataSpec(uri));
        return decode(DataSourceUtil.readToEnd(dataSource));
    }
}
