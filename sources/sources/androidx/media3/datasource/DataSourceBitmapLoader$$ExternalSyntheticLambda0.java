package androidx.media3.datasource;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DataSourceBitmapLoader$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ byte[] f$0;

    public /* synthetic */ DataSourceBitmapLoader$$ExternalSyntheticLambda0(byte[] bArr) {
        this.f$0 = bArr;
    }

    public final Object call() {
        return DataSourceBitmapLoader.decode(this.f$0);
    }
}
