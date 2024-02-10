package com.bykv.vk.openvk.component.video.a.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.a.a.a.b;
import com.bykv.vk.openvk.component.video.a.a.a.c;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SdkMediaDataSource */
public class a extends MediaDataSource {
    public static final ConcurrentHashMap<String, a> a = new ConcurrentHashMap<>();
    private final c b;
    private long c = -2147483648L;
    private final Context d;
    private final com.bykv.vk.openvk.component.video.api.c.c e;

    public a(Context context, com.bykv.vk.openvk.component.video.api.c.c cVar) {
        this.d = context;
        this.e = cVar;
        this.b = new b(context, cVar);
    }

    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        int a2 = this.b.a(j, bArr, i, i2);
        com.bykv.vk.openvk.component.video.api.f.c.b("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i + " size =" + a2 + "  current = " + Thread.currentThread());
        return a2;
    }

    public long getSize() throws IOException {
        if (this.c == -2147483648L) {
            if (this.d == null || TextUtils.isEmpty(this.e.m())) {
                return -1;
            }
            this.c = this.b.c();
            com.bykv.vk.openvk.component.video.api.f.c.b("SdkMediaDataSource", "getSize: " + this.c);
        }
        return this.c;
    }

    public void close() throws IOException {
        com.bykv.vk.openvk.component.video.api.f.c.b("SdkMediaDataSource", "close: ", this.e.m());
        c cVar = this.b;
        if (cVar != null) {
            cVar.b();
        }
        a.remove(this.e.n());
    }

    public com.bykv.vk.openvk.component.video.api.c.c a() {
        return this.e;
    }

    public static a a(Context context, com.bykv.vk.openvk.component.video.api.c.c cVar) {
        a aVar = new a(context, cVar);
        a.put(cVar.n(), aVar);
        return aVar;
    }
}
