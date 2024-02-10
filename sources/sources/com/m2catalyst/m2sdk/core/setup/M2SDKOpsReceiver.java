package com.m2catalyst.m2sdk.core.setup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.m2catalyst.m2sdk.a6;
import com.m2catalyst.m2sdk.business.repositories.DeviceRepository;
import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.external.LoggingLevel;
import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.p2;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.y1;
import com.m2catalyst.m2sdk.z5;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u001b\u0010\u0012\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/m2catalyst/m2sdk/core/setup/M2SDKOpsReceiver;", "Landroid/content/BroadcastReceiver;", "Lorg/koin/core/component/KoinComponent;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "exportDB", "Ljava/io/File;", "directory", "deleteOlderZipFiles", "onReceive", "Lcom/m2catalyst/m2sdk/business/repositories/DeviceRepository;", "deviceRepository$delegate", "Lkotlin/Lazy;", "getDeviceRepository", "()Lcom/m2catalyst/m2sdk/business/repositories/DeviceRepository;", "deviceRepository", "Lcom/m2catalyst/m2sdk/r2;", "m2InternalConfiguration", "Lcom/m2catalyst/m2sdk/r2;", "Lcom/m2catalyst/m2sdk/z5;", "sdkPreferences$delegate", "getSdkPreferences", "()Lcom/m2catalyst/m2sdk/z5;", "sdkPreferences", "<init>", "()V", "Companion", "a", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: M2SDKOpsReceiver.kt */
public final class M2SDKOpsReceiver extends BroadcastReceiver implements KoinComponent {
    public static final a Companion = new a();
    public static final String EXPORT_DB = "com.m2catalyst.m2sdk.action.EXPORT_DB";
    public static final String SUPER_LOG_ASSERT = "com.m2catalyst.m2sdk.action.SUPER_LOG_ASSERT";
    public static final String SUPER_LOG_DEBUG = "com.m2catalyst.m2sdk.action.SUPER_LOG_DEBUG";
    public static final String SUPER_LOG_ERROR = "com.m2catalyst.m2sdk.action.SUPER_LOG_ERROR";
    public static final String SUPER_LOG_INFO = "com.m2catalyst.m2sdk.action.SUPER_LOG_INFO";
    public static final String SUPER_LOG_NULL = "com.m2catalyst.m2sdk.action.SUPER_LOG_NULL";
    public static final String SUPER_LOG_VERBOSE = "com.m2catalyst.m2sdk.action.SUPER_LOG_VERBOSE";
    public static final String SUPER_LOG_WARN = "com.m2catalyst.m2sdk.action.SUPER_LOG_WARN";
    private final Lazy deviceRepository$delegate = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new b(this));
    private final r2 m2InternalConfiguration = r2.a.a();
    private final Lazy sdkPreferences$delegate = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new c(this));

    /* compiled from: M2SDKOpsReceiver.kt */
    public static final class a {
    }

    /* compiled from: KoinComponent.kt */
    public static final class b extends Lambda implements Function0<DeviceRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.business.repositories.DeviceRepository, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.business.repositories.DeviceRepository, java.lang.Object] */
        public final DeviceRepository invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(DeviceRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(DeviceRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class c extends Lambda implements Function0<z5> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.z5] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.z5] */
        public final z5 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(z5.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(z5.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    private final void deleteOlderZipFiles(File file) {
        File[] listFiles;
        String str = this.m2InternalConfiguration.a(false).getAppName() + "_" + Build.MANUFACTURER + "_" + Build.MODEL;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles(new M2SDKOpsReceiver$$ExternalSyntheticLambda0())) != null) {
            if (!(listFiles.length == 0)) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "zipFile.name");
                    if (StringsKt.contains$default((CharSequence) name, (CharSequence) str, false, 2, (Object) null)) {
                        file2.delete();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final boolean deleteOlderZipFiles$lambda$7(File file, String str) {
        Intrinsics.checkNotNullExpressionValue(str, "name");
        return StringsKt.endsWith$default(str, ".zip", false, 2, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0070 A[Catch:{ Exception -> 0x0212 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void exportDB(android.content.Context r18, android.content.Intent r19) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r0 = ".zip"
            java.lang.String r2 = "//data//"
            com.m2catalyst.m2sdk.business.repositories.DeviceRepository r3 = r17.getDeviceRepository()
            com.m2catalyst.m2sdk.business.models.DeviceInfo r3 = r3.getDeviceInfo()
            r4 = 0
            if (r3 == 0) goto L_0x0016
            java.lang.Integer r5 = r3.getDeviceId()
            goto L_0x0017
        L_0x0016:
            r5 = r4
        L_0x0017:
            if (r3 == 0) goto L_0x001e
            java.lang.String r3 = r3.getM2uuid()
            goto L_0x001f
        L_0x001e:
            r3 = r4
        L_0x001f:
            com.m2catalyst.m2sdk.r2 r6 = r1.m2InternalConfiguration
            com.m2catalyst.m2sdk.configuration.M2Configuration r6 = r6.a(false)
            java.lang.String r6 = r6.getAppName()
            java.lang.String r7 = android.os.Build.MANUFACTURER
            java.lang.String r8 = android.os.Build.MODEL
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            java.lang.String r6 = "_"
            r9.append(r6)
            r9.append(r7)
            r9.append(r6)
            r9.append(r8)
            r9.append(r6)
            r9.append(r5)
            r9.append(r6)
            r9.append(r3)
            java.lang.String r3 = "_10.0.0.49"
            r9.append(r3)
            java.lang.String r3 = r9.toString()
            r5 = r18
            java.io.File r6 = r5.getExternalFilesDir(r4)     // Catch:{ Exception -> 0x0212 }
            java.io.File r7 = android.os.Environment.getDataDirectory()     // Catch:{ Exception -> 0x0212 }
            r8 = 0
            if (r6 == 0) goto L_0x006d
            boolean r9 = r6.canWrite()     // Catch:{ Exception -> 0x0212 }
            r10 = 1
            if (r9 != r10) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r10 = 0
        L_0x006e:
            if (r10 == 0) goto L_0x0212
            r1.deleteOlderZipFiles(r6)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r9 = r18.getPackageName()     // Catch:{ Exception -> 0x0212 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0212 }
            r10.<init>(r2)     // Catch:{ Exception -> 0x0212 }
            r10.append(r9)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r9 = "//databases//sdk-db"
            r10.append(r9)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x0212 }
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x0212 }
            r10.<init>(r7, r9)     // Catch:{ Exception -> 0x0212 }
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0212 }
            java.lang.String r11 = "toPull"
            r9.<init>(r6, r11)     // Catch:{ Exception -> 0x0212 }
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0212 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0212 }
            r11.<init>()     // Catch:{ Exception -> 0x0212 }
            r11.append(r3)     // Catch:{ Exception -> 0x0212 }
            r11.append(r0)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0212 }
            r9.<init>(r6, r11)     // Catch:{ Exception -> 0x0212 }
            java.util.zip.ZipOutputStream r6 = new java.util.zip.ZipOutputStream     // Catch:{ Exception -> 0x0212 }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0212 }
            r11.<init>(r9)     // Catch:{ Exception -> 0x0212 }
            r6.<init>(r11)     // Catch:{ Exception -> 0x0212 }
            java.util.zip.ZipEntry r11 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x0212 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0212 }
            r12.<init>()     // Catch:{ Exception -> 0x0212 }
            r12.append(r3)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r3 = ".db"
            r12.append(r3)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r3 = r12.toString()     // Catch:{ Exception -> 0x0212 }
            r11.<init>(r3)     // Catch:{ Exception -> 0x0212 }
            r6.putNextEntry(r11)     // Catch:{ Exception -> 0x0212 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0212 }
            r3.<init>(r10)     // Catch:{ Exception -> 0x0212 }
            r10 = 4096(0x1000, float:5.74E-42)
            byte[] r11 = new byte[r10]     // Catch:{ all -> 0x0209 }
        L_0x00d5:
            int r12 = r3.read(r11)     // Catch:{ all -> 0x0209 }
            if (r12 <= 0) goto L_0x00df
            r6.write(r11, r8, r12)     // Catch:{ all -> 0x0209 }
            goto L_0x00d5
        L_0x00df:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0209 }
            kotlin.io.CloseableKt.closeFinally(r3, r4)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r3 = r18.getPackageName()     // Catch:{ Exception -> 0x0212 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0212 }
            r11.<init>()     // Catch:{ Exception -> 0x0212 }
            r11.append(r2)     // Catch:{ Exception -> 0x0212 }
            r11.append(r3)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r3 = "//files//logs"
            r11.append(r3)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r3 = r11.toString()     // Catch:{ Exception -> 0x0212 }
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x0212 }
            r11.<init>(r7, r3)     // Catch:{ Exception -> 0x0212 }
            boolean r3 = r11.exists()     // Catch:{ Exception -> 0x0212 }
            java.lang.String r12 = ".txt"
            r13 = 2
            java.lang.String r14 = "logFile.name"
            if (r3 == 0) goto L_0x0179
            boolean r3 = r11.isDirectory()     // Catch:{ Exception -> 0x0212 }
            if (r3 == 0) goto L_0x0179
            java.io.File[] r3 = r11.listFiles()     // Catch:{ Exception -> 0x0212 }
            java.lang.String r11 = "logsDir.listFiles()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r11)     // Catch:{ Exception -> 0x0212 }
            int r11 = r3.length     // Catch:{ Exception -> 0x0212 }
            r15 = 0
        L_0x011d:
            if (r15 >= r11) goto L_0x0179
            r10 = r3[r15]     // Catch:{ Exception -> 0x0212 }
            boolean r16 = r10.isFile()     // Catch:{ Exception -> 0x0212 }
            if (r16 == 0) goto L_0x0171
            java.lang.String r4 = r10.getName()     // Catch:{ Exception -> 0x0212 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r14)     // Catch:{ Exception -> 0x0212 }
            r1 = 0
            boolean r4 = kotlin.text.StringsKt.endsWith$default(r4, r12, r8, r13, r1)     // Catch:{ Exception -> 0x0212 }
            if (r4 != 0) goto L_0x0142
            java.lang.String r4 = r10.getName()     // Catch:{ Exception -> 0x0212 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r14)     // Catch:{ Exception -> 0x0212 }
            boolean r4 = kotlin.text.StringsKt.endsWith$default(r4, r0, r8, r13, r1)     // Catch:{ Exception -> 0x0212 }
            if (r4 == 0) goto L_0x0171
        L_0x0142:
            java.util.zip.ZipEntry r1 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x0212 }
            java.lang.String r4 = r10.getName()     // Catch:{ Exception -> 0x0212 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0212 }
            r6.putNextEntry(r1)     // Catch:{ Exception -> 0x0212 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0212 }
            r1.<init>(r10)     // Catch:{ Exception -> 0x0212 }
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r10 = new byte[r4]     // Catch:{ all -> 0x0168 }
        L_0x0157:
            int r4 = r1.read(r10)     // Catch:{ all -> 0x0168 }
            if (r4 <= 0) goto L_0x0161
            r6.write(r10, r8, r4)     // Catch:{ all -> 0x0168 }
            goto L_0x0157
        L_0x0161:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0168 }
            r4 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r4)     // Catch:{ Exception -> 0x0212 }
            goto L_0x0171
        L_0x0168:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ all -> 0x016b }
        L_0x016b:
            r0 = move-exception
            r3 = r0
            kotlin.io.CloseableKt.closeFinally(r1, r2)     // Catch:{ Exception -> 0x0212 }
            throw r3     // Catch:{ Exception -> 0x0212 }
        L_0x0171:
            int r15 = r15 + 1
            r1 = r17
            r4 = 0
            r10 = 4096(0x1000, float:5.74E-42)
            goto L_0x011d
        L_0x0179:
            java.lang.String r0 = r18.getPackageName()     // Catch:{ Exception -> 0x0212 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0212 }
            r1.<init>()     // Catch:{ Exception -> 0x0212 }
            r1.append(r2)     // Catch:{ Exception -> 0x0212 }
            r1.append(r0)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r0 = "//files//logs//m2_sdk"
            r1.append(r0)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0212 }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0212 }
            r1.<init>(r7, r0)     // Catch:{ Exception -> 0x0212 }
            boolean r0 = r1.exists()     // Catch:{ Exception -> 0x0212 }
            if (r0 == 0) goto L_0x01fa
            boolean r0 = r1.isDirectory()     // Catch:{ Exception -> 0x0212 }
            if (r0 == 0) goto L_0x01fa
            java.io.File[] r0 = r1.listFiles()     // Catch:{ Exception -> 0x0212 }
            java.lang.String r1 = "logsDir2.listFiles()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x0212 }
            int r1 = r0.length     // Catch:{ Exception -> 0x0212 }
            r2 = 0
        L_0x01ad:
            if (r2 >= r1) goto L_0x01fa
            r3 = r0[r2]     // Catch:{ Exception -> 0x0212 }
            boolean r4 = r3.isFile()     // Catch:{ Exception -> 0x0212 }
            if (r4 == 0) goto L_0x01f4
            java.lang.String r4 = r3.getName()     // Catch:{ Exception -> 0x0212 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r14)     // Catch:{ Exception -> 0x0212 }
            r5 = 0
            boolean r4 = kotlin.text.StringsKt.endsWith$default(r4, r12, r8, r13, r5)     // Catch:{ Exception -> 0x0212 }
            if (r4 == 0) goto L_0x01f4
            java.util.zip.ZipEntry r4 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x0212 }
            java.lang.String r5 = r3.getName()     // Catch:{ Exception -> 0x0212 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0212 }
            r6.putNextEntry(r4)     // Catch:{ Exception -> 0x0212 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0212 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0212 }
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r3]     // Catch:{ all -> 0x01eb }
        L_0x01da:
            int r7 = r4.read(r5)     // Catch:{ all -> 0x01eb }
            if (r7 <= 0) goto L_0x01e4
            r6.write(r5, r8, r7)     // Catch:{ all -> 0x01eb }
            goto L_0x01da
        L_0x01e4:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01eb }
            r5 = 0
            kotlin.io.CloseableKt.closeFinally(r4, r5)     // Catch:{ Exception -> 0x0212 }
            goto L_0x01f7
        L_0x01eb:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x01ee }
        L_0x01ee:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r4, r1)     // Catch:{ Exception -> 0x0212 }
            throw r2     // Catch:{ Exception -> 0x0212 }
        L_0x01f4:
            r3 = 4096(0x1000, float:5.74E-42)
            r5 = 0
        L_0x01f7:
            int r2 = r2 + 1
            goto L_0x01ad
        L_0x01fa:
            r6.close()     // Catch:{ Exception -> 0x0212 }
            java.lang.String r0 = "android.intent.extra.TITLE"
            java.lang.String r1 = r9.getName()     // Catch:{ Exception -> 0x0212 }
            r2 = r19
            r2.putExtra(r0, r1)     // Catch:{ Exception -> 0x0212 }
            goto L_0x0212
        L_0x0209:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x020c }
        L_0x020c:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r3, r1)     // Catch:{ Exception -> 0x0212 }
            throw r2     // Catch:{ Exception -> 0x0212 }
        L_0x0212:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.core.setup.M2SDKOpsReceiver.exportDB(android.content.Context, android.content.Intent):void");
    }

    private final DeviceRepository getDeviceRepository() {
        return (DeviceRepository) this.deviceRepository$delegate.getValue();
    }

    private final z5 getSdkPreferences() {
        return (z5) this.sdkPreferences$delegate.getValue();
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public void onReceive(Context context, Intent intent) {
        p2 generalConfig;
        p2 generalConfig2;
        p2 generalConfig3;
        p2 generalConfig4;
        p2 generalConfig5;
        p2 generalConfig6;
        p2 generalConfig7;
        p2 generalConfig8;
        if (context != null) {
            M2SDK.INSTANCE.wakeUpSDK$m2sdk_release(context);
            if (intent != null) {
                String action = intent.getAction();
                if (action == null) {
                    action = "";
                }
                boolean z = false;
                switch (action.hashCode()) {
                    case -1577546073:
                        if (action.equals(SUPER_LOG_VERBOSE)) {
                            if (r2.j == null) {
                                r2.j = new r2();
                            }
                            r2 r2Var = r2.j;
                            Intrinsics.checkNotNull(r2Var);
                            M2Configuration m2Configuration = r2Var.g;
                            if (!(m2Configuration == null || (generalConfig = m2Configuration.getGeneralConfig()) == null)) {
                                z = Intrinsics.areEqual((Object) generalConfig.d, (Object) Boolean.TRUE);
                            }
                            if (z) {
                                if (r2.j == null) {
                                    r2.j = new r2();
                                }
                                r2 r2Var2 = r2.j;
                                Intrinsics.checkNotNull(r2Var2);
                                M2Configuration m2Configuration2 = r2Var2.g;
                                if (m2Configuration2 != null) {
                                    m2Configuration2.setSuperloggingLevel$m2sdk_release(LoggingLevel.VERBOSE);
                                }
                                getSdkPreferences().a(a6.SDK_SUPER_LOGGING_LEVEL, Integer.valueOf(LoggingLevel.VERBOSE.getId()));
                                return;
                            }
                            return;
                        }
                        return;
                    case -1470422687:
                        if (action.equals(SUPER_LOG_ASSERT)) {
                            if (r2.j == null) {
                                r2.j = new r2();
                            }
                            r2 r2Var3 = r2.j;
                            Intrinsics.checkNotNull(r2Var3);
                            M2Configuration m2Configuration3 = r2Var3.g;
                            if (!(m2Configuration3 == null || (generalConfig2 = m2Configuration3.getGeneralConfig()) == null)) {
                                z = Intrinsics.areEqual((Object) generalConfig2.d, (Object) Boolean.TRUE);
                            }
                            if (z) {
                                if (r2.j == null) {
                                    r2.j = new r2();
                                }
                                r2 r2Var4 = r2.j;
                                Intrinsics.checkNotNull(r2Var4);
                                M2Configuration m2Configuration4 = r2Var4.g;
                                if (m2Configuration4 != null) {
                                    m2Configuration4.setSuperloggingLevel$m2sdk_release(LoggingLevel.ASSERT);
                                }
                                getSdkPreferences().a(a6.SDK_SUPER_LOGGING_LEVEL, Integer.valueOf(LoggingLevel.ASSERT.getId()));
                                return;
                            }
                            return;
                        }
                        return;
                    case -460737352:
                        if (action.equals(SUPER_LOG_DEBUG)) {
                            if (r2.j == null) {
                                r2.j = new r2();
                            }
                            r2 r2Var5 = r2.j;
                            Intrinsics.checkNotNull(r2Var5);
                            M2Configuration m2Configuration5 = r2Var5.g;
                            if (!(m2Configuration5 == null || (generalConfig3 = m2Configuration5.getGeneralConfig()) == null)) {
                                z = Intrinsics.areEqual((Object) generalConfig3.d, (Object) Boolean.TRUE);
                            }
                            if (z) {
                                if (r2.j == null) {
                                    r2.j = new r2();
                                }
                                r2 r2Var6 = r2.j;
                                Intrinsics.checkNotNull(r2Var6);
                                M2Configuration m2Configuration6 = r2Var6.g;
                                if (m2Configuration6 != null) {
                                    m2Configuration6.setSuperloggingLevel$m2sdk_release(LoggingLevel.DEBUG);
                                }
                                getSdkPreferences().a(a6.SDK_SUPER_LOGGING_LEVEL, Integer.valueOf(LoggingLevel.DEBUG.getId()));
                                return;
                            }
                            return;
                        }
                        return;
                    case -459411347:
                        if (action.equals(SUPER_LOG_ERROR)) {
                            if (r2.j == null) {
                                r2.j = new r2();
                            }
                            r2 r2Var7 = r2.j;
                            Intrinsics.checkNotNull(r2Var7);
                            M2Configuration m2Configuration7 = r2Var7.g;
                            if (!(m2Configuration7 == null || (generalConfig4 = m2Configuration7.getGeneralConfig()) == null)) {
                                z = Intrinsics.areEqual((Object) generalConfig4.d, (Object) Boolean.TRUE);
                            }
                            if (z) {
                                if (r2.j == null) {
                                    r2.j = new r2();
                                }
                                r2 r2Var8 = r2.j;
                                Intrinsics.checkNotNull(r2Var8);
                                M2Configuration m2Configuration8 = r2Var8.g;
                                if (m2Configuration8 != null) {
                                    m2Configuration8.setSuperloggingLevel$m2sdk_release(LoggingLevel.ERROR);
                                }
                                getSdkPreferences().a(a6.SDK_SUPER_LOGGING_LEVEL, Integer.valueOf(LoggingLevel.ERROR.getId()));
                                return;
                            }
                            return;
                        }
                        return;
                    case 539484553:
                        if (action.equals(SUPER_LOG_INFO)) {
                            if (r2.j == null) {
                                r2.j = new r2();
                            }
                            r2 r2Var9 = r2.j;
                            Intrinsics.checkNotNull(r2Var9);
                            M2Configuration m2Configuration9 = r2Var9.g;
                            if (!(m2Configuration9 == null || (generalConfig5 = m2Configuration9.getGeneralConfig()) == null)) {
                                z = Intrinsics.areEqual((Object) generalConfig5.d, (Object) Boolean.TRUE);
                            }
                            if (z) {
                                if (r2.j == null) {
                                    r2.j = new r2();
                                }
                                r2 r2Var10 = r2.j;
                                Intrinsics.checkNotNull(r2Var10);
                                M2Configuration m2Configuration10 = r2Var10.g;
                                if (m2Configuration10 != null) {
                                    m2Configuration10.setSuperloggingLevel$m2sdk_release(LoggingLevel.INFO);
                                }
                                getSdkPreferences().a(a6.SDK_SUPER_LOGGING_LEVEL, Integer.valueOf(LoggingLevel.INFO.getId()));
                                return;
                            }
                            return;
                        }
                        return;
                    case 539640418:
                        if (action.equals(SUPER_LOG_NULL)) {
                            if (r2.j == null) {
                                r2.j = new r2();
                            }
                            r2 r2Var11 = r2.j;
                            Intrinsics.checkNotNull(r2Var11);
                            M2Configuration m2Configuration11 = r2Var11.g;
                            if (!(m2Configuration11 == null || (generalConfig6 = m2Configuration11.getGeneralConfig()) == null)) {
                                z = Intrinsics.areEqual((Object) generalConfig6.d, (Object) Boolean.TRUE);
                            }
                            if (z) {
                                if (r2.j == null) {
                                    r2.j = new r2();
                                }
                                r2 r2Var12 = r2.j;
                                Intrinsics.checkNotNull(r2Var12);
                                M2Configuration m2Configuration12 = r2Var12.g;
                                if (m2Configuration12 != null) {
                                    m2Configuration12.setSuperloggingLevel$m2sdk_release((LoggingLevel) null);
                                }
                                getSdkPreferences().a(a6.SDK_SUPER_LOGGING_LEVEL, -1);
                                return;
                            }
                            return;
                        }
                        return;
                    case 539889505:
                        if (action.equals(SUPER_LOG_WARN)) {
                            if (r2.j == null) {
                                r2.j = new r2();
                            }
                            r2 r2Var13 = r2.j;
                            Intrinsics.checkNotNull(r2Var13);
                            M2Configuration m2Configuration13 = r2Var13.g;
                            if (!(m2Configuration13 == null || (generalConfig7 = m2Configuration13.getGeneralConfig()) == null)) {
                                z = Intrinsics.areEqual((Object) generalConfig7.d, (Object) Boolean.TRUE);
                            }
                            if (z) {
                                if (r2.j == null) {
                                    r2.j = new r2();
                                }
                                r2 r2Var14 = r2.j;
                                Intrinsics.checkNotNull(r2Var14);
                                M2Configuration m2Configuration14 = r2Var14.g;
                                if (m2Configuration14 != null) {
                                    m2Configuration14.setSuperloggingLevel$m2sdk_release(LoggingLevel.WARN);
                                }
                                getSdkPreferences().a(a6.SDK_SUPER_LOGGING_LEVEL, Integer.valueOf(LoggingLevel.WARN.getId()));
                                return;
                            }
                            return;
                        }
                        return;
                    case 1532876589:
                        if (action.equals(EXPORT_DB)) {
                            if (r2.j == null) {
                                r2.j = new r2();
                            }
                            r2 r2Var15 = r2.j;
                            Intrinsics.checkNotNull(r2Var15);
                            M2Configuration m2Configuration15 = r2Var15.g;
                            if (!(m2Configuration15 == null || (generalConfig8 = m2Configuration15.getGeneralConfig()) == null)) {
                                z = Intrinsics.areEqual((Object) generalConfig8.d, (Object) Boolean.TRUE);
                            }
                            if (z) {
                                exportDB(context, intent);
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
