package com.bykv.vk.openvk.preload.geckox.d.a.b;

import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.b;
import com.bykv.vk.openvk.preload.geckox.buffer.a;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.utils.BsPatch;
import com.bykv.vk.openvk.preload.geckox.utils.c;
import java.io.File;

/* compiled from: MergePatchSingleFileInterceptor */
public class d extends com.bykv.vk.openvk.preload.b.d<Pair<a, UpdatePackage>, Pair<a, UpdatePackage>> {
    private b g;

    public final /* bridge */ /* synthetic */ Object a(com.bykv.vk.openvk.preload.b.b bVar, Object obj) throws Throwable {
        return a((com.bykv.vk.openvk.preload.b.b<Pair<a, UpdatePackage>>) bVar, (Pair<a, UpdatePackage>) (Pair) obj);
    }

    public final void a(Object... objArr) {
        super.a(objArr);
        this.g = objArr[0];
    }

    private static Object a(com.bykv.vk.openvk.preload.b.b<Pair<a, UpdatePackage>> bVar, Pair<a, UpdatePackage> pair) throws Throwable {
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start merge patch single file, channel:", ((UpdatePackage) pair.second).getChannel());
        a aVar = (a) pair.first;
        File f = aVar.f();
        aVar.a();
        aVar.e();
        File parentFile = f.getParentFile().getParentFile();
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        File file = new File(parentFile, updatePackage.getLocalVersion() + File.separator + "res");
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            throw new RuntimeException("can not found old full single file,:" + file.getAbsolutePath());
        }
        File file2 = listFiles[0];
        File parentFile2 = f.getParentFile();
        File file3 = new File(parentFile2, "res" + File.separator + com.bykv.vk.openvk.preload.geckox.d.a.a.b.a(updatePackage, updatePackage.getFullPackage().getUrlList().get(0)));
        c.a(file3);
        try {
            BsPatch.a(file2, f, file3.getParentFile(), file3.getName());
            c.a(f);
            a a = com.bykv.vk.openvk.preload.geckox.buffer.a.a.a(file3, file3.length());
            try {
                return bVar.a(new Pair(a, updatePackage));
            } finally {
                a.e();
            }
        } catch (Exception e) {
            throw new RuntimeException("merge patch single file failed, channel：" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + ", caused by:" + e.getMessage(), e);
        } catch (Throwable th) {
            c.a(f);
            throw th;
        }
    }
}
