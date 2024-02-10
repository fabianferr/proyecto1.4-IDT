package com.wortise.ads;

import android.content.Context;
import android.os.StatFs;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/x0;", "", "Landroid/content/Context;", "context", "Ljava/io/File;", "a", "dir", "", "minSize", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: CacheUtils.kt */
public final class x0 {
    public static final x0 a = new x0();

    private x0() {
    }

    public final File a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new File(context.getCacheDir(), "wortise-cache");
    }

    public static /* synthetic */ long a(x0 x0Var, File file, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 10485760;
        }
        return x0Var.a(file, j);
    }

    public final long a(File file, long j) {
        Intrinsics.checkNotNullParameter(file, "dir");
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / ((long) 50);
        } catch (Throwable unused) {
        }
        return Math.max(Math.min(j, 31457280), 10485760);
    }
}
