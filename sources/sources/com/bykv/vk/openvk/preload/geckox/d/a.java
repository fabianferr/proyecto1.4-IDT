package com.bykv.vk.openvk.preload.geckox.d;

import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;

/* compiled from: FileTypeBranchInterceptor */
public class a extends com.bykv.vk.openvk.preload.b.a<UpdatePackage, UpdatePackage> {
    public final /* synthetic */ String a(Object obj) {
        int packageType = ((UpdatePackage) obj).getPackageType();
        if (packageType == 0) {
            return "branch_zip";
        }
        if (packageType == 1) {
            return "branch_single_file";
        }
        throw new RuntimeException("unknow file type: ".concat(String.valueOf(packageType)));
    }
}
