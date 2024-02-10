package com.bykv.vk.openvk.preload.geckox.d.a.b;

import android.util.Pair;
import com.bykv.vk.openvk.preload.b.b;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.utils.g;
import java.io.File;
import java.io.InputStream;

/* compiled from: CheckMergedSingleFileMD5Interceptor */
public class a extends d<Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage>, Pair<File, UpdatePackage>> {
    public final /* bridge */ /* synthetic */ Object a(b bVar, Object obj) throws Throwable {
        return a((b<Pair<File, UpdatePackage>>) bVar, (Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage>) (Pair) obj);
    }

    private static Object a(b<Pair<File, UpdatePackage>> bVar, Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage> pair) throws Throwable {
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start check merged single file, channel:", ((UpdatePackage) pair.second).getChannel());
        com.bykv.vk.openvk.preload.geckox.buffer.a aVar = (com.bykv.vk.openvk.preload.geckox.buffer.a) pair.first;
        aVar.b(0);
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        try {
            g.a((InputStream) new com.bykv.vk.openvk.preload.geckox.buffer.stream.a(aVar), updatePackage.getFullPackage().getMd5());
            return bVar.a(new Pair(aVar.f(), updatePackage));
        } catch (Throwable th) {
            throw new RuntimeException("check merged single file failed, channel：" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + ", caused by:" + th.getMessage(), th);
        }
    }
}
