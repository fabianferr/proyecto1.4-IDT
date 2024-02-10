package com.bykv.vk.openvk.preload.geckox.d.b.b;

import android.util.Pair;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.buffer.a;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.utils.g;
import java.io.InputStream;

/* compiled from: CheckPatchZipMD5Interceptor */
public class b extends d<Pair<a, UpdatePackage>, Pair<a, UpdatePackage>> {
    public final /* bridge */ /* synthetic */ Object a(com.bykv.vk.openvk.preload.b.b bVar, Object obj) throws Throwable {
        return a((com.bykv.vk.openvk.preload.b.b<Pair<a, UpdatePackage>>) bVar, (Pair<a, UpdatePackage>) (Pair) obj);
    }

    private static Object a(com.bykv.vk.openvk.preload.b.b<Pair<a, UpdatePackage>> bVar, Pair<a, UpdatePackage> pair) throws Throwable {
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start check patch zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        a aVar = (a) pair.first;
        aVar.b(0);
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        try {
            g.a((InputStream) new com.bykv.vk.openvk.preload.geckox.buffer.stream.a(aVar), updatePackage.getPatch().getMd5());
            return bVar.a(pair);
        } catch (Throwable th) {
            throw new com.bykv.vk.openvk.preload.geckox.b.b("check patch zip file failed, channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + ", caused by:" + th.getMessage(), th);
        }
    }
}
