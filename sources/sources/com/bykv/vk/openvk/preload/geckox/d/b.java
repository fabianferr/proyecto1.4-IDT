package com.bykv.vk.openvk.preload.geckox.d;

import com.bykv.vk.openvk.preload.b.j;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import java.util.List;

/* compiled from: FullPatchRetryInterceptor */
public class b extends j<UpdatePackage, UpdatePackage> {
    public final /* synthetic */ String a(Object obj) {
        UpdatePackage updatePackage = (UpdatePackage) obj;
        UpdatePackage.Package patch = updatePackage.getPatch();
        if (patch == null) {
            com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
            return "full";
        }
        List<String> urlList = patch.getUrlList();
        if (urlList == null || urlList.isEmpty()) {
            com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
            return "full";
        }
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
        return "patch";
    }

    public final /* synthetic */ String a(Object obj, Throwable th, String str) {
        UpdatePackage updatePackage = (UpdatePackage) obj;
        if ("patch".equals(str)) {
            com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
            return "full";
        }
        throw new RuntimeException("full update failed, caused by:" + th.getMessage(), th);
    }
}
