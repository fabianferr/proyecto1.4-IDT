package org.koin.android.ext.koin;

import android.app.Application;
import android.content.Context;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.android.logger.AndroidLogger;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.logger.Level;
import org.koin.dsl.ModuleDSLKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"androidContext", "Lorg/koin/core/KoinApplication;", "Landroid/content/Context;", "androidFileProperties", "koinPropertyFile", "", "androidLogger", "level", "Lorg/koin/core/logger/Level;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: KoinExt.kt */
public final class KoinExtKt {
    public static /* synthetic */ KoinApplication androidLogger$default(KoinApplication koinApplication, Level level, int i, Object obj) {
        if ((i & 1) != 0) {
            level = Level.INFO;
        }
        return androidLogger(koinApplication, level);
    }

    public static final KoinApplication androidLogger(KoinApplication koinApplication, Level level) {
        Intrinsics.checkNotNullParameter(koinApplication, "<this>");
        Intrinsics.checkNotNullParameter(level, "level");
        koinApplication.getKoin().setupLogger(new AndroidLogger(level));
        return koinApplication;
    }

    public static final KoinApplication androidContext(KoinApplication koinApplication, Context context) {
        Intrinsics.checkNotNullParameter(koinApplication, "<this>");
        Intrinsics.checkNotNullParameter(context, "androidContext");
        if (koinApplication.getKoin().getLogger().isAt(Level.INFO)) {
            koinApplication.getKoin().getLogger().info("[init] declare Android Context");
        }
        if (context instanceof Application) {
            Koin.loadModules$default(koinApplication.getKoin(), CollectionsKt.listOf(ModuleDSLKt.module$default(false, new KoinExtKt$androidContext$1(context), 1, (Object) null)), false, 2, (Object) null);
        } else {
            Koin.loadModules$default(koinApplication.getKoin(), CollectionsKt.listOf(ModuleDSLKt.module$default(false, new KoinExtKt$androidContext$2(context), 1, (Object) null)), false, 2, (Object) null);
        }
        return koinApplication;
    }

    public static /* synthetic */ KoinApplication androidFileProperties$default(KoinApplication koinApplication, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "koin.properties";
        }
        return androidFileProperties(koinApplication, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0098, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009c, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0034, code lost:
        r5 = r5.list("");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.koin.core.KoinApplication androidFileProperties(org.koin.core.KoinApplication r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "[Android-Properties] loaded "
            java.lang.String r1 = "[Android-Properties] no assets/"
            java.lang.String r2 = "[Android-Properties] error for binding properties : "
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r3)
            java.lang.String r3 = "koinPropertyFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r3)
            java.util.Properties r3 = new java.util.Properties
            r3.<init>()
            org.koin.core.Koin r4 = r8.getKoin()
            org.koin.core.registry.ScopeRegistry r4 = r4.getScopeRegistry()
            org.koin.core.scope.Scope r4 = r4.getRootScope()
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            r6 = 0
            java.lang.Object r4 = r4.get(r5, r6, r6)
            android.content.Context r4 = (android.content.Context) r4
            android.content.res.AssetManager r5 = r4.getAssets()     // Catch:{ Exception -> 0x00e3 }
            if (r5 == 0) goto L_0x0041
            java.lang.String r7 = ""
            java.lang.String[] r5 = r5.list(r7)     // Catch:{ Exception -> 0x00e3 }
            if (r5 == 0) goto L_0x0041
            boolean r5 = kotlin.collections.ArraysKt.contains((T[]) r5, r9)     // Catch:{ Exception -> 0x00e3 }
            goto L_0x0042
        L_0x0041:
            r5 = 0
        L_0x0042:
            if (r5 == 0) goto L_0x00b6
            android.content.res.AssetManager r1 = r4.getAssets()     // Catch:{ Exception -> 0x009d }
            java.io.InputStream r1 = r1.open(r9)     // Catch:{ Exception -> 0x009d }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ Exception -> 0x009d }
            r4 = r1
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ all -> 0x0096 }
            r3.load(r4)     // Catch:{ all -> 0x0096 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0096 }
            kotlin.io.CloseableKt.closeFinally(r1, r6)     // Catch:{ Exception -> 0x009d }
            org.koin.core.Koin r1 = r8.getKoin()     // Catch:{ Exception -> 0x009d }
            org.koin.core.registry.PropertyRegistry r1 = r1.getPropertyRegistry()     // Catch:{ Exception -> 0x009d }
            org.koin.core.registry.PropertyRegistryExtKt.saveProperties(r1, r3)     // Catch:{ Exception -> 0x009d }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x009d }
            org.koin.core.Koin r3 = r8.getKoin()     // Catch:{ Exception -> 0x009d }
            org.koin.core.logger.Logger r3 = r3.getLogger()     // Catch:{ Exception -> 0x009d }
            org.koin.core.logger.Level r4 = org.koin.core.logger.Level.INFO     // Catch:{ Exception -> 0x009d }
            boolean r3 = r3.isAt(r4)     // Catch:{ Exception -> 0x009d }
            if (r3 == 0) goto L_0x0105
            org.koin.core.Koin r3 = r8.getKoin()     // Catch:{ Exception -> 0x009d }
            org.koin.core.logger.Logger r3 = r3.getLogger()     // Catch:{ Exception -> 0x009d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d }
            r4.<init>(r0)     // Catch:{ Exception -> 0x009d }
            r4.append(r1)     // Catch:{ Exception -> 0x009d }
            java.lang.String r0 = " properties from assets/"
            r4.append(r0)     // Catch:{ Exception -> 0x009d }
            r4.append(r9)     // Catch:{ Exception -> 0x009d }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x009d }
            r3.info(r0)     // Catch:{ Exception -> 0x009d }
            goto L_0x0105
        L_0x0096:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0098 }
        L_0x0098:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ Exception -> 0x009d }
            throw r3     // Catch:{ Exception -> 0x009d }
        L_0x009d:
            r0 = move-exception
            org.koin.core.Koin r1 = r8.getKoin()     // Catch:{ Exception -> 0x00e3 }
            org.koin.core.logger.Logger r1 = r1.getLogger()     // Catch:{ Exception -> 0x00e3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00e3 }
            r3.append(r0)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x00e3 }
            r1.error(r0)     // Catch:{ Exception -> 0x00e3 }
            goto L_0x0105
        L_0x00b6:
            org.koin.core.Koin r0 = r8.getKoin()     // Catch:{ Exception -> 0x00e3 }
            org.koin.core.logger.Logger r0 = r0.getLogger()     // Catch:{ Exception -> 0x00e3 }
            org.koin.core.logger.Level r2 = org.koin.core.logger.Level.INFO     // Catch:{ Exception -> 0x00e3 }
            boolean r0 = r0.isAt(r2)     // Catch:{ Exception -> 0x00e3 }
            if (r0 == 0) goto L_0x0105
            org.koin.core.Koin r0 = r8.getKoin()     // Catch:{ Exception -> 0x00e3 }
            org.koin.core.logger.Logger r0 = r0.getLogger()     // Catch:{ Exception -> 0x00e3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00e3 }
            r2.append(r9)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r1 = " file to load"
            r2.append(r1)     // Catch:{ Exception -> 0x00e3 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x00e3 }
            r0.info(r1)     // Catch:{ Exception -> 0x00e3 }
            goto L_0x0105
        L_0x00e3:
            r0 = move-exception
            org.koin.core.Koin r1 = r8.getKoin()
            org.koin.core.logger.Logger r1 = r1.getLogger()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "[Android-Properties] error while loading properties from assets/"
            r2.<init>(r3)
            r2.append(r9)
            java.lang.String r9 = " : "
            r2.append(r9)
            r2.append(r0)
            java.lang.String r9 = r2.toString()
            r1.error(r9)
        L_0x0105:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.android.ext.koin.KoinExtKt.androidFileProperties(org.koin.core.KoinApplication, java.lang.String):org.koin.core.KoinApplication");
    }
}
