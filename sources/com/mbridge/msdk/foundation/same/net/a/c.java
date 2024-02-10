package com.mbridge.msdk.foundation.same.net.a;

import com.mbridge.msdk.foundation.same.net.f.b;
import java.io.ByteArrayOutputStream;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.net.UrlRequest;

/* compiled from: DefaultCronetCallback */
public final class c extends UrlRequest.Callback {
    ByteArrayOutputStream a = null;
    WritableByteChannel b = null;
    b c = null;
    AtomicBoolean d = new AtomicBoolean(false);
    BlockingQueue<b> e;

    public c(BlockingQueue<b> blockingQueue) {
        this.e = blockingQueue;
    }
}
