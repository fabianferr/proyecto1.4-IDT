package com.bykv.vk.openvk.preload.geckox.d.b.a;

import android.util.Pair;
import com.bykv.vk.openvk.preload.b.b;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.utils.g;
import java.io.InputStream;

/* compiled from: CheckFullZipMD5Interceptor */
public class a extends d<Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage>, Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage>> {
    public final /* bridge */ /* synthetic */ Object a(b bVar, Object obj) throws Throwable {
        return a((b<Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage>>) bVar, (Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage>) (Pair) obj);
    }

    private static Object a(b<Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage>> bVar, Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage> pair) throws Throwable {
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start check full zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        com.bykv.vk.openvk.preload.geckox.buffer.a aVar = (com.bykv.vk.openvk.preload.geckox.buffer.a) pair.first;
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        aVar.b(0);
        try {
            g.a((InputStream) new com.bykv.vk.openvk.preload.geckox.buffer.stream.a(aVar), updatePackage.getFullPackage().getMd5());
            return bVar.a(pair);
        } catch (Throwable th) {
            throw new com.bykv.vk.openvk.preload.geckox.b.b("check full zip file failed, channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getFullPackage().getId() + ", caused by:" + th.getMessage(), th);
        }
    }
}