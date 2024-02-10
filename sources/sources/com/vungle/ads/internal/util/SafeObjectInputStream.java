package com.vungle.ads.internal.util;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\nH\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vungle/ads/internal/util/SafeObjectInputStream;", "Ljava/io/ObjectInputStream;", "in", "Ljava/io/InputStream;", "allowed", "", "Ljava/lang/Class;", "(Ljava/io/InputStream;Ljava/util/List;)V", "resolveClass", "desc", "Ljava/io/ObjectStreamClass;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SafeObjectInputStream.kt */
public final class SafeObjectInputStream extends ObjectInputStream {
    private final List<Class<?>> allowed;

    public SafeObjectInputStream(InputStream inputStream, List<? extends Class<?>> list) {
        super(inputStream);
        this.allowed = list;
    }

    /* access modifiers changed from: protected */
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
        Intrinsics.checkNotNullParameter(objectStreamClass, CampaignEx.JSON_KEY_DESC);
        Class<?> resolveClass = super.resolveClass(objectStreamClass);
        if (this.allowed == null || Number.class.isAssignableFrom(resolveClass) || Intrinsics.areEqual((Object) String.class, (Object) resolveClass) || Intrinsics.areEqual((Object) Boolean.class, (Object) resolveClass) || resolveClass.isArray() || this.allowed.contains(resolveClass)) {
            Intrinsics.checkNotNullExpressionValue(resolveClass, "c");
            return resolveClass;
        }
        throw new IOException("Deserialization is not allowed for " + objectStreamClass.getName());
    }
}
