package io.monedata.utils;

import android.content.Context;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import io.monedata.a1;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\u000e"}, d2 = {"Lio/monedata/utils/Framework;", "", "()V", "classExists", "", "name", "", "isFlutter", "context", "Landroid/content/Context;", "isMetadata", "value", "isReactNative", "isUnity", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Framework {
    public static final Framework INSTANCE = new Framework();

    private Framework() {
    }

    private final boolean classExists(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Class.forName(str);
            obj = Result.m2344constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m2351isSuccessimpl(obj);
    }

    private final boolean isMetadata(Context context, String str) {
        return Intrinsics.areEqual((Object) a1.e.a(context).c(), (Object) str);
    }

    public final boolean isFlutter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isMetadata(context, "flutter")) {
            return true;
        }
        return classExists("io.flutter.app.FlutterApplication");
    }

    public final boolean isReactNative(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isMetadata(context, "react-native")) {
            return true;
        }
        return classExists("com.facebook.react.ReactActivity");
    }

    public final boolean isUnity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isMetadata(context, "unity")) {
            return true;
        }
        return classExists(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
    }
}
