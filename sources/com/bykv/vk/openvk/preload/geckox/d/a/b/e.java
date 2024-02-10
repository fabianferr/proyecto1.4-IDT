package com.bykv.vk.openvk.preload.geckox.d.a.b;

import android.util.Pair;
import com.bykv.vk.openvk.preload.b.b;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.utils.c;
import java.io.File;

/* compiled from: RenameMergedSingleFileDirInterceptor */
public class e extends d<Pair<File, UpdatePackage>, Pair<String, Long>> {
    public final /* synthetic */ Object a(b bVar, Object obj) throws Throwable {
        Pair pair = (Pair) obj;
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start active merged single file,channel:", ((UpdatePackage) pair.second).getChannel());
        File parentFile = ((File) pair.first).getParentFile().getParentFile();
        long version = ((UpdatePackage) pair.second).getVersion();
        File file = new File(parentFile.getParentFile(), String.valueOf(version));
        c.a(file);
        if (parentFile.renameTo(file)) {
            return bVar.a(new Pair(((UpdatePackage) pair.second).getChannel(), Long.valueOf(version)));
        }
        throw new RuntimeException("active merged single file failed:" + parentFile.getAbsolutePath());
    }
}
