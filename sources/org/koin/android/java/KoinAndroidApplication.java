package org.koin.android.java;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.koin.android.ext.koin.KoinExtKt;
import org.koin.core.KoinApplication;
import org.koin.core.logger.Level;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lorg/koin/android/java/KoinAndroidApplication;", "", "()V", "create", "Lorg/koin/core/KoinApplication;", "context", "Landroid/content/Context;", "androidLoggerLevel", "Lorg/koin/core/logger/Level;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: KoinAndroidApplication.kt */
public final class KoinAndroidApplication {
    public static final KoinAndroidApplication INSTANCE = new KoinAndroidApplication();

    @JvmStatic
    public static final KoinApplication create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return create$default(context, (Level) null, 2, (Object) null);
    }

    private KoinAndroidApplication() {
    }

    public static /* synthetic */ KoinApplication create$default(Context context, Level level, int i, Object obj) {
        if ((i & 2) != 0) {
            level = Level.INFO;
        }
        return create(context, level);
    }

    @JvmStatic
    public static final KoinApplication create(Context context, Level level) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(level, "androidLoggerLevel");
        return KoinExtKt.androidLogger(KoinExtKt.androidContext(KoinApplication.Companion.init(), context), level);
    }
}
