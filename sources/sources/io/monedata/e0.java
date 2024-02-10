package io.monedata;

import android.os.Build;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000¨\u0006\u0002"}, d2 = {"Landroidx/work/Constraints$Builder;", "a", "core_productionRelease"}, k = 2, mv = {1, 7, 1})
public final class e0 {
    public static final Constraints.Builder a(Constraints.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.setRequiredNetworkType(Build.VERSION.SDK_INT <= 22 ? NetworkType.NOT_REQUIRED : NetworkType.CONNECTED);
    }
}
