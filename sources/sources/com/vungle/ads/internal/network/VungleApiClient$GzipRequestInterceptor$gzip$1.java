package com.vungle.ads.internal.network;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/vungle/ads/internal/network/VungleApiClient$GzipRequestInterceptor$gzip$1", "Lokhttp3/RequestBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleApiClient.kt */
public final class VungleApiClient$GzipRequestInterceptor$gzip$1 extends RequestBody {
    final /* synthetic */ Buffer $output;
    final /* synthetic */ RequestBody $requestBody;

    VungleApiClient$GzipRequestInterceptor$gzip$1(RequestBody requestBody, Buffer buffer) {
        this.$requestBody = requestBody;
        this.$output = buffer;
    }

    public MediaType contentType() {
        return this.$requestBody.contentType();
    }

    public long contentLength() {
        return this.$output.size();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        bufferedSink.write(this.$output.snapshot());
    }
}
