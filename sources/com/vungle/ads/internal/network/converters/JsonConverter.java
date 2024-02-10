package com.vungle.ads.internal.network.converters;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\nB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00018\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vungle/ads/internal/network/converters/JsonConverter;", "E", "Lcom/vungle/ads/internal/network/converters/Converter;", "Lokhttp3/ResponseBody;", "kType", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)V", "convert", "responseBody", "(Lokhttp3/ResponseBody;)Ljava/lang/Object;", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JsonConverter.kt */
public final class JsonConverter<E> implements Converter<ResponseBody, E> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Json json = JsonKt.Json$default((Json) null, JsonConverter$Companion$json$1.INSTANCE, 1, (Object) null);
    private final KType kType;

    public JsonConverter(KType kType2) {
        Intrinsics.checkNotNullParameter(kType2, "kType");
        this.kType = kType2;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/network/converters/JsonConverter$Companion;", "", "()V", "json", "Lkotlinx/serialization/json/Json;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: JsonConverter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E convert(okhttp3.ResponseBody r6) throws java.io.IOException {
        /*
            r5 = this;
            java.io.Closeable r6 = (java.io.Closeable) r6
            r0 = r6
            okhttp3.ResponseBody r0 = (okhttp3.ResponseBody) r0     // Catch:{ all -> 0x002b }
            r1 = 0
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r0.string()     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x000f
            goto L_0x0027
        L_0x000f:
            kotlinx.serialization.json.Json r2 = json     // Catch:{ all -> 0x002b }
            kotlinx.serialization.json.Json$Default r3 = kotlinx.serialization.json.Json.Default     // Catch:{ all -> 0x002b }
            kotlinx.serialization.modules.SerializersModule r3 = r3.getSerializersModule()     // Catch:{ all -> 0x002b }
            kotlin.reflect.KType r4 = r5.kType     // Catch:{ all -> 0x002b }
            kotlinx.serialization.KSerializer r3 = kotlinx.serialization.SerializersKt.serializer((kotlinx.serialization.modules.SerializersModule) r3, (kotlin.reflect.KType) r4)     // Catch:{ all -> 0x002b }
            kotlinx.serialization.DeserializationStrategy r3 = (kotlinx.serialization.DeserializationStrategy) r3     // Catch:{ all -> 0x002b }
            java.lang.Object r0 = r2.decodeFromString(r3, r0)     // Catch:{ all -> 0x002b }
            kotlin.io.CloseableKt.closeFinally(r6, r1)
            return r0
        L_0x0027:
            kotlin.io.CloseableKt.closeFinally(r6, r1)
            return r1
        L_0x002b:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x002d }
        L_0x002d:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.converters.JsonConverter.convert(okhttp3.ResponseBody):java.lang.Object");
    }
}
