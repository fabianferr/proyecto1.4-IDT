package com.bykv.vk.openvk.preload.geckox.d.b.a;

import android.util.Pair;
import com.bykv.vk.openvk.preload.b.b;
import com.bykv.vk.openvk.preload.geckox.buffer.a;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.utils.c;
import com.bykv.vk.openvk.preload.geckox.utils.k;
import java.io.File;

/* compiled from: UnzipFullZipInterceptor */
public class d extends com.bykv.vk.openvk.preload.b.d<Pair<a, UpdatePackage>, Pair<File, UpdatePackage>> {
    public final /* bridge */ /* synthetic */ Object a(b bVar, Object obj) throws Throwable {
        return a((b<Pair<File, UpdatePackage>>) bVar, (Pair<a, UpdatePackage>) (Pair) obj);
    }

    private static Object a(b<Pair<File, UpdatePackage>> bVar, Pair<a, UpdatePackage> pair) throws Throwable {
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start unzip full zip file, channel:", ((UpdatePackage) pair.second).getChannel());
        a aVar = (a) pair.first;
        aVar.b(0);
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        File parentFile = aVar.f().getParentFile();
        try {
            k.a(new com.bykv.vk.openvk.preload.geckox.buffer.stream.a(aVar), parentFile.getAbsolutePath(), updatePackage.getChannel());
            aVar.a();
            File file = new File(parentFile, "res");
            c.a(file);
            if (new File(parentFile, updatePackage.getChannel()).renameTo(file)) {
                return bVar.a(new Pair(aVar.f(), updatePackage));
            }
            throw new RuntimeException("rename unziped full zip file failed:" + parentFile.getAbsolutePath() + ", dest:" + file.getAbsolutePath() + ", exist?" + file.exists());
        } catch (Exception e) {
            throw new RuntimeException("unzip full zip file failed, channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getFullPackage().getId() + ", dir:" + parentFile.getAbsolutePath() + ", caused by:" + e.getMessage(), e);
        }
    }
}
