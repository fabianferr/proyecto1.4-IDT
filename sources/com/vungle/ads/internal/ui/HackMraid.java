package com.vungle.ads.internal.ui;

import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.util.PathProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/vungle/ads/internal/ui/HackMraid;", "", "()V", "apply", "", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "out", "Ljava/io/PrintWriter;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HackMraid.kt */
public final class HackMraid {
    public static final HackMraid INSTANCE = new HackMraid();

    private HackMraid() {
    }

    public final void apply(PathProvider pathProvider, PrintWriter printWriter) {
        Intrinsics.checkNotNullParameter(pathProvider, "pathProvider");
        Intrinsics.checkNotNullParameter(printWriter, "out");
        File file = new File(pathProvider.getJsAssetDir(ConfigManager.INSTANCE.getMraidJsVersion()), Constants.MRAID_JS_FILE_NAME);
        if (file.exists()) {
            Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
            printWriter.println(TextStreamsKt.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192)));
        }
    }
}
