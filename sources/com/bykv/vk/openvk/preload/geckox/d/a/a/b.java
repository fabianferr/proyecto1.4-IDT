package com.bykv.vk.openvk.preload.geckox.d.a.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.buffer.a;
import com.bykv.vk.openvk.preload.geckox.buffer.stream.BufferOutputStream;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import java.io.File;

/* compiled from: DownloadFullSingleFileInterceptor */
public class b extends d<Pair<Uri, UpdatePackage>, Pair<a, UpdatePackage>> {
    private com.bykv.vk.openvk.preload.geckox.b g;
    private File h;

    public static String a(UpdatePackage updatePackage, String str) {
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf != -1) {
                String substring = str.substring(lastIndexOf + 1);
                if (!TextUtils.isEmpty(substring)) {
                    return substring;
                }
                throw new RuntimeException("url path illegal, url:".concat(String.valueOf(str)));
            }
            throw new RuntimeException("url path illegal, url:".concat(String.valueOf(str)));
        }
        throw new RuntimeException("url empty, channel:" + updatePackage.getChannel());
    }

    public final void a(Object... objArr) {
        super.a(objArr);
        this.g = objArr[0];
        this.h = objArr[1];
    }

    /* access modifiers changed from: private */
    public Object a(com.bykv.vk.openvk.preload.b.b<Pair<a, UpdatePackage>> bVar, Pair<Uri, UpdatePackage> pair) throws Throwable {
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start download full single file channel:", ((UpdatePackage) pair.second).getChannel());
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        String uri = ((Uri) pair.first).toString();
        long length = updatePackage.getFullPackage().getLength();
        File file = this.h;
        File file2 = new File(file, updatePackage.getAccessKey() + File.separator + updatePackage.getChannel() + File.separator + updatePackage.getVersion() + "--updating");
        file2.mkdirs();
        StringBuilder sb = new StringBuilder("res");
        sb.append(File.separator);
        sb.append(a(updatePackage, uri));
        a a = com.bykv.vk.openvk.preload.geckox.buffer.a.a.a(new File(file2, sb.toString()), length);
        try {
            this.g.f.downloadFile(uri, length, new BufferOutputStream(a));
            try {
                Object a2 = bVar.a(new Pair(a, updatePackage));
                try {
                    a.e();
                } catch (Exception e) {
                    com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "DownloadFullSingleFile-release:", e);
                }
                return a2;
            } catch (Exception e2) {
                throw e2;
            } catch (Throwable th) {
                try {
                    a.e();
                } catch (Exception e3) {
                    com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "DownloadFullSingleFile-release:", e3);
                }
                throw th;
            }
        } catch (Throwable th2) {
            a.e();
            throw new com.bykv.vk.openvk.preload.geckox.b.a("download full single file failed! url:" + uri + ", channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getFullPackage().getId() + ", caused by:" + th2.getMessage(), th2);
        }
    }
}
