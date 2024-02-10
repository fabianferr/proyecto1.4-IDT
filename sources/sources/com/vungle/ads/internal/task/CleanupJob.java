package com.vungle.ads.internal.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.vungle.ads.BuildConfig;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.PathProvider;
import java.io.File;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u0002"}, d2 = {"Lcom/vungle/ads/internal/task/CleanupJob;", "Lcom/vungle/ads/internal/task/Job;", "context", "Landroid/content/Context;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "(Landroid/content/Context;Lcom/vungle/ads/internal/util/PathProvider;)V", "getContext", "()Landroid/content/Context;", "getPathProvider", "()Lcom/vungle/ads/internal/util/PathProvider;", "checkIfSdkUpgraded", "", "dropV6Data", "dropV700Data", "onRunJob", "", "bundle", "Landroid/os/Bundle;", "jobRunner", "Lcom/vungle/ads/internal/task/JobRunner;", "Companion", "vungle-ads_release", "filePreferences", "Lcom/vungle/ads/internal/persistence/FilePreferences;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CleanupJob.kt */
public final class CleanupJob implements Job {
    private static final String AD_ID_KEY = "AD_ID_KEY";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CleanupJob";
    private final Context context;
    private final PathProvider pathProvider;

    public CleanupJob(Context context2, PathProvider pathProvider2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(pathProvider2, "pathProvider");
        this.context = context2;
        this.pathProvider = pathProvider2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        File file;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(jobRunner, "jobRunner");
        File downloadDir = this.pathProvider.getDownloadDir();
        String string = bundle.getString(AD_ID_KEY);
        if (string == null || (file = this.pathProvider.getDownloadsDirForAd(string)) == null) {
            file = downloadDir;
        }
        try {
            if (Intrinsics.areEqual((Object) file, (Object) downloadDir)) {
                checkIfSdkUpgraded();
                FileUtility.deleteContents(file);
                return 0;
            }
            FileUtility.delete(file);
            return 0;
        } catch (IOException unused) {
            return 1;
        }
    }

    private final void dropV6Data() {
        File file;
        Log.d(TAG, "CleanupJob: drop old files data");
        File file2 = Build.VERSION.SDK_INT >= 21 ? new File(this.context.getNoBackupFilesDir(), "vungle_db") : null;
        if (file2 == null || !file2.exists()) {
            this.context.deleteDatabase("vungle_db");
        } else {
            FileUtility.delete(file2);
            FileUtility.delete(new File(file2.getPath() + "-journal"));
        }
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("com.vungle.sdk", 0);
        String string = sharedPreferences.getString("cache_path", (String) null);
        if (Build.VERSION.SDK_INT >= 24) {
            this.context.deleteSharedPreferences("com.vungle.sdk");
        } else {
            sharedPreferences.edit().clear().apply();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            file = this.context.getNoBackupFilesDir();
            Intrinsics.checkNotNullExpressionValue(file, "{\n            context.noBackupFilesDir\n        }");
        } else {
            file = this.context.getFilesDir();
            Intrinsics.checkNotNullExpressionValue(file, "{\n            context.filesDir\n        }");
        }
        FileUtility.delete(new File(file, "vungle_settings"));
        if (string != null) {
            FileUtility.delete(new File(string));
        }
    }

    private final void dropV700Data() {
        FileUtility.delete(new File(this.context.getApplicationInfo().dataDir, "vungle"));
    }

    private final void checkIfSdkUpgraded() {
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new CleanupJob$checkIfSdkUpgraded$$inlined$inject$1(this.context));
        int i = m2325checkIfSdkUpgraded$lambda3(lazy).getInt("VERSION_CODE", -1);
        if (i < 70100) {
            if (i < 70000) {
                dropV6Data();
            }
            if (i < 70100) {
                dropV700Data();
            }
            m2325checkIfSdkUpgraded$lambda3(lazy).put("VERSION_CODE", (int) BuildConfig.VERSION_CODE).apply();
        }
    }

    /* renamed from: checkIfSdkUpgraded$lambda-3  reason: not valid java name */
    private static final FilePreferences m2325checkIfSdkUpgraded$lambda3(Lazy<FilePreferences> lazy) {
        return lazy.getValue();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/vungle/ads/internal/task/CleanupJob$Companion;", "", "()V", "AD_ID_KEY", "", "TAG", "makeJobInfo", "Lcom/vungle/ads/internal/task/JobInfo;", "adId", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CleanupJob.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ JobInfo makeJobInfo$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.makeJobInfo(str);
        }

        public final JobInfo makeJobInfo(String str) {
            boolean z = false;
            JobInfo priority = new JobInfo(CleanupJob.TAG).setPriority(0);
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString(CleanupJob.AD_ID_KEY, str);
            }
            JobInfo extras = priority.setExtras(bundle);
            if (str == null) {
                z = true;
            }
            return extras.setUpdateCurrent(z);
        }
    }
}
