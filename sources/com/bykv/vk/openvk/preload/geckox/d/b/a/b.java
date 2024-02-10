package com.bykv.vk.openvk.preload.geckox.d.b.a;

import android.net.Uri;
import android.util.Pair;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.buffer.a;
import com.bykv.vk.openvk.preload.geckox.buffer.stream.BufferOutputStream;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import java.io.File;

/* compiled from: DownloadFullZipInterceptor */
public class b extends d<Pair<Uri, UpdatePackage>, Pair<a, UpdatePackage>> {
    private com.bykv.vk.openvk.preload.geckox.b g;
    private File h;

    public final void a(Object... objArr) {
        super.a(objArr);
        this.g = objArr[0];
        this.h = objArr[1];
    }

    /* access modifiers changed from: private */
    public Object a(com.bykv.vk.openvk.preload.b.b<Pair<a, UpdatePackage>> bVar, Pair<Uri, UpdatePackage> pair) throws Throwable {
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start download full zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        String uri = ((Uri) pair.first).toString();
        long length = updatePackage.getFullPackage().getLength();
        File file = this.h;
        File file2 = new File(file, updatePackage.getAccessKey() + File.separator + updatePackage.getChannel() + File.separator + updatePackage.getVersion() + "--updating");
        file2.mkdirs();
        a a = com.bykv.vk.openvk.preload.geckox.buffer.a.a.a(new File(file2, "res.zip"), length);
        try {
            this.g.f.downloadFile(uri, length, new BufferOutputStream(a));
            try {
                return bVar.a(new Pair(a, updatePackage));
            } finally {
                a.e();
            }
        } catch (Throwable th) {
            a.e();
            throw new com.bykv.vk.openvk.preload.geckox.b.a("download full zip file failed, url:" + uri + ", channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getFullPackage().getId() + ", caused by:" + th.getMessage(), th);
        }
    }
}
