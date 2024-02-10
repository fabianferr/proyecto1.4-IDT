package com.bykv.vk.openvk.preload.geckox.d;

import android.net.Uri;
import android.util.Pair;
import com.bykv.vk.openvk.preload.b.k;
import com.bykv.vk.openvk.preload.geckox.b.a;
import com.bykv.vk.openvk.preload.geckox.h.b;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import java.util.List;

/* compiled from: RetryPatchDownloadInterceptor */
public class h extends k<UpdatePackage, Pair<Uri, UpdatePackage>> {
    private int h = 0;

    public final boolean a(Throwable th) {
        b.a("gecko-debug-tag", "patch update failed", th);
        if (this.h >= ((UpdatePackage) this.g).getPatch().getUrlList().size()) {
            return false;
        }
        if ((th instanceof a) || (th instanceof com.bykv.vk.openvk.preload.geckox.b.b)) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object a() {
        UpdatePackage updatePackage = (UpdatePackage) this.g;
        List<String> urlList = updatePackage.getPatch().getUrlList();
        int i = this.h;
        this.h = i + 1;
        return new Pair(Uri.parse(urlList.get(i)), updatePackage);
    }
}
