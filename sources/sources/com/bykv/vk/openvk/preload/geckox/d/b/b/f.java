package com.bykv.vk.openvk.preload.geckox.d.b.b;

import android.util.Pair;
import com.bykv.vk.openvk.preload.b.b;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.buffer.a;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.utils.c;
import com.bykv.vk.openvk.preload.geckox.utils.k;
import java.io.File;

/* compiled from: UnZipMergedZipInterceptor */
public class f extends d<Pair<a, UpdatePackage>, Pair<File, UpdatePackage>> {
    public final /* bridge */ /* synthetic */ Object a(b bVar, Object obj) throws Throwable {
        return a((b<Pair<File, UpdatePackage>>) bVar, (Pair<a, UpdatePackage>) (Pair) obj);
    }

    private static Object a(b<Pair<File, UpdatePackage>> bVar, Pair<a, UpdatePackage> pair) throws Throwable {
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start unzip merged zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        a aVar = (a) pair.first;
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        aVar.b(0);
        File parentFile = aVar.f().getParentFile();
        try {
            k.a(new com.bykv.vk.openvk.preload.geckox.buffer.stream.a(aVar), parentFile.getAbsolutePath(), updatePackage.getChannel());
            aVar.a();
            File file = new File(parentFile, "res");
            c.a(file);
            if (new File(parentFile, updatePackage.getChannel()).renameTo(file)) {
                return bVar.a(new Pair(aVar.f(), updatePackage));
            }
            throw new RuntimeException("rename unzip merged zip file failed:" + parentFile.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException("unzip merged zip file failed, channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + e.getMessage(), e);
        }
    }
}
