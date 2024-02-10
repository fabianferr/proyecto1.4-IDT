package com.vungle.ads.internal.omsdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.iab.omid.library.vungle.Omid;
import com.vungle.ads.internal.util.FileUtility;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/vungle/ads/internal/omsdk/OMInjector;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contextRef", "Ljava/util/concurrent/atomic/AtomicReference;", "uiHandler", "Landroid/os/Handler;", "init", "", "injectJsFiles", "", "Ljava/io/File;", "dir", "writeToFile", "lines", "", "outputFile", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OMInjector.kt */
public final class OMInjector {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String OM_SDK_JS = "omsdk.js";
    private static final String OM_SESSION_JS = "omsdk-session.js";
    private final AtomicReference<Context> contextRef;
    private final Handler uiHandler = new Handler(Looper.getMainLooper());

    public OMInjector(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.contextRef = new AtomicReference<>(context.getApplicationContext());
    }

    public final void init() {
        this.uiHandler.post(new OMInjector$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-0  reason: not valid java name */
    public static final void m2308init$lambda0(OMInjector oMInjector) {
        Intrinsics.checkNotNullParameter(oMInjector, "this$0");
        try {
            if (!Omid.isActive()) {
                Omid.activate(oMInjector.contextRef.get());
            }
        } catch (NoClassDefFoundError e) {
            Log.e("OMSDK", "error: " + e.getLocalizedMessage());
        }
    }

    public final List<File> injectJsFiles(File file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "dir");
        ArrayList arrayList = new ArrayList();
        arrayList.add(writeToFile(Res.INSTANCE.getOM_JS$vungle_ads_release(), new File(file, OM_SDK_JS)));
        arrayList.add(writeToFile(Res.INSTANCE.getOM_SESSION_JS$vungle_ads_release(), new File(file, OM_SESSION_JS)));
        return arrayList;
    }

    private final File writeToFile(String str, File file) throws IOException {
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str);
                fileWriter2.flush();
                FileUtility.INSTANCE.closeQuietly(fileWriter2);
                return file;
            } catch (Throwable th) {
                th = th;
                fileWriter = fileWriter2;
                FileUtility.INSTANCE.closeQuietly(fileWriter);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            FileUtility.INSTANCE.closeQuietly(fileWriter);
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/omsdk/OMInjector$Companion;", "", "()V", "OM_SDK_JS", "", "OM_SESSION_JS", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OMInjector.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
