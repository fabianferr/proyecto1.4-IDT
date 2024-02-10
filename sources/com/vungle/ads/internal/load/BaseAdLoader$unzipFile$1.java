package com.vungle.ads.internal.load;

import com.vungle.ads.internal.util.UnzipUtility;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/vungle/ads/internal/load/BaseAdLoader$unzipFile$1", "Lcom/vungle/ads/internal/util/UnzipUtility$Filter;", "matches", "", "extractPath", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BaseAdLoader.kt */
public final class BaseAdLoader$unzipFile$1 implements UnzipUtility.Filter {
    final /* synthetic */ List<String> $existingPaths;

    BaseAdLoader$unzipFile$1(List<String> list) {
        this.$existingPaths = list;
    }

    public boolean matches(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        File file = new File(str);
        for (String file2 : this.$existingPaths) {
            File file3 = new File(file2);
            if (Intrinsics.areEqual((Object) file3, (Object) file)) {
                return false;
            }
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "toExtract.path");
            if (StringsKt.startsWith$default(path, file3.getPath() + File.separator, false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }
}
