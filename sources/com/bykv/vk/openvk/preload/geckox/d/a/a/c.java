package com.bykv.vk.openvk.preload.geckox.d.a.a;

import android.util.Pair;
import com.bykv.vk.openvk.preload.b.b;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import java.io.File;

/* compiled from: RenameFullSingleFileChannelInterceptor */
public class c extends d<Pair<File, UpdatePackage>, Pair<String, Long>> {
    public final /* synthetic */ Object a(b bVar, Object obj) throws Throwable {
        Pair pair = (Pair) obj;
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start active full single file, channel:", ((UpdatePackage) pair.second).getChannel());
        File parentFile = ((File) pair.first).getParentFile().getParentFile();
        long version = ((UpdatePackage) pair.second).getVersion();
        File file = new File(parentFile.getParentFile(), String.valueOf(version));
        com.bykv.vk.openvk.preload.geckox.utils.c.a(file);
        if (parentFile.renameTo(file)) {
            return bVar.a(new Pair(((UpdatePackage) pair.second).getChannel(), Long.valueOf(version)));
        }
        throw new RuntimeException("active full single file failed: " + parentFile.getAbsolutePath());
    }
}
