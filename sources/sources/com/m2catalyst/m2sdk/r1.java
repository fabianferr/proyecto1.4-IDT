package com.m2catalyst.m2sdk;

import android.content.Context;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileUtils.kt */
public final class r1 {
    public static final void a() {
        Intrinsics.checkNotNullParameter("SIGNAL STRENGH CREATION", "<this>");
    }

    public static final void a(String str, Context context, String str2, boolean z) {
        int hashCode;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        File file = new File(context.getFilesDir().getAbsolutePath() + "/logs/", "m2_sdk");
        file.mkdirs();
        String str3 = o1.a() + ":  " + str + " \n";
        Intrinsics.checkNotNullParameter(str3, "<this>");
        if (!z) {
            if (str2 != null) {
                if ((hashCode = str2.hashCode()) == -2086236426 ? str2.equals("sdk_network_collection.txt") : hashCode == -1548231707 ? str2.equals("sdk_location_collection.txt") : hashCode == 1727124997 && str2.equals("sdk_wifi_collection.txt")) {
                    FilesKt.appendText$default(new File(file, "sdk_general_collection.txt"), str3, (Charset) null, 2, (Object) null);
                }
                FilesKt.appendText$default(new File(file, str2), str3, (Charset) null, 2, (Object) null);
            }
            FilesKt.appendText$default(new File(file, "sdk_binnacle.txt"), str3, (Charset) null, 2, (Object) null);
        }
    }
}
