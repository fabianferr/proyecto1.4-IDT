package com.vungle.ads.internal.util;

import android.content.Context;
import android.os.Build;
import android.os.StatFs;
import android.util.Log;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/vungle/ads/internal/util/PathProvider;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cleverCacheDir", "Ljava/io/File;", "getContext", "()Landroid/content/Context;", "downloadsDir", "jsDir", "vungleDir", "getAvailableBytes", "", "path", "", "getCleverCacheDir", "getDownloadDir", "getDownloadsDirForAd", "adId", "getJsAssetDir", "jsVersion", "getJsDir", "getSharedPrefsDir", "getVungleDir", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PathProvider.kt */
public final class PathProvider {
    private static final String CLEVER_CACHE_FOLDER = "clever_cache";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DOWNLOADS_FOLDER = "downloads";
    private static final String JS_FOLDER = "js";
    private static final long UNKNOWN_SIZE = -1;
    private static final String VUNGLE_FOLDER = "vungle_cache";
    private final File cleverCacheDir;
    private final Context context;
    private final File downloadsDir;
    private final File jsDir;
    private final File vungleDir;

    public PathProvider(Context context2) {
        File file;
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        if (Build.VERSION.SDK_INT >= 21) {
            file = context2.getNoBackupFilesDir();
        } else {
            file = context2.getFilesDir();
        }
        File file2 = new File(file, VUNGLE_FOLDER);
        this.vungleDir = file2;
        File file3 = new File(file2, DOWNLOADS_FOLDER);
        this.downloadsDir = file3;
        File file4 = new File(file2, JS_FOLDER);
        this.jsDir = file4;
        File file5 = new File(file2, CLEVER_CACHE_FOLDER);
        this.cleverCacheDir = file5;
        for (File file6 : CollectionsKt.listOf(file2, file3, file4, file5)) {
            if (!file6.exists()) {
                file6.mkdirs();
            }
        }
    }

    public final Context getContext() {
        return this.context;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/vungle/ads/internal/util/PathProvider$Companion;", "", "()V", "CLEVER_CACHE_FOLDER", "", "DOWNLOADS_FOLDER", "JS_FOLDER", "UNKNOWN_SIZE", "", "VUNGLE_FOLDER", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PathProvider.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final File getVungleDir() {
        if (!this.vungleDir.exists()) {
            this.vungleDir.mkdirs();
        }
        return this.vungleDir;
    }

    public final File getCleverCacheDir() {
        if (!this.cleverCacheDir.exists()) {
            this.cleverCacheDir.mkdirs();
        }
        return this.cleverCacheDir;
    }

    public final File getJsDir() {
        if (!this.jsDir.exists()) {
            this.jsDir.mkdirs();
        }
        return this.jsDir;
    }

    public final File getDownloadDir() {
        if (!this.downloadsDir.exists()) {
            this.downloadsDir.mkdirs();
        }
        return this.downloadsDir;
    }

    public final File getJsAssetDir(String str) {
        Intrinsics.checkNotNullParameter(str, "jsVersion");
        File file = new File(getJsDir(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File getDownloadsDirForAd(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        File downloadDir = getDownloadDir();
        File file = new File(downloadDir.getPath() + File.separator + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File getSharedPrefsDir() {
        if (Build.VERSION.SDK_INT >= 21) {
            File noBackupFilesDir = this.context.getNoBackupFilesDir();
            Intrinsics.checkNotNullExpressionValue(noBackupFilesDir, "{\n        context.noBackupFilesDir\n    }");
            return noBackupFilesDir;
        }
        File filesDir = this.context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "{\n        context.filesDir\n    }");
        return filesDir;
    }

    public final long getAvailableBytes(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        try {
            return new StatFs(str).getAvailableBytes();
        } catch (IllegalArgumentException e) {
            Log.w("PathProvider", "Failed to get available bytes " + e.getMessage());
            return -1;
        }
    }
}
