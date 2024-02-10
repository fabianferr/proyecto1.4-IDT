package com.squareup.wire.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Internal.kt */
/* synthetic */ class Internal__InternalKt$sanitize$2 extends FunctionReference implements Function1<String, String> {
    public static final Internal__InternalKt$sanitize$2 INSTANCE = new Internal__InternalKt$sanitize$2();

    Internal__InternalKt$sanitize$2() {
        super(1);
    }

    public final String getName() {
        return "sanitize";
    }

    public final String getSignature() {
        return "sanitize(Ljava/lang/String;)Ljava/lang/String;";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(Internal__InternalKt.class, "wire-runtime");
    }

    public final String invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        return Internal.sanitize(str);
    }
}
