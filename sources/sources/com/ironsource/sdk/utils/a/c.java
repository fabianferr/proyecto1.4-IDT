package com.ironsource.sdk.utils.a;

import android.graphics.drawable.Drawable;
import android.webkit.URLUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\r\u0010\u000bJ&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/ironsource/sdk/utils/loaders/ImageLoader;", "Lcom/ironsource/sdk/utils/loaders/ImageLoaderInterface;", "connectionFactory", "Lcom/ironsource/sdk/utils/loaders/ConnectionFactoryInterface;", "(Lcom/ironsource/sdk/utils/loaders/ConnectionFactoryInterface;)V", "createDrawable", "Lkotlin/Result;", "Landroid/graphics/drawable/Drawable;", "url", "", "createDrawable-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "createDrawableFromLocalFile", "createDrawableFromLocalFile-IoAF18A", "createDrawableFromRemoteUrl", "createDrawableFromRemoteUrl-IoAF18A", "isRemoteUrl", "", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c implements d {
    private final a a;

    public c() {
        this((a) null, 1);
    }

    private c(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "connectionFactory");
        this.a = aVar;
    }

    public /* synthetic */ c(a aVar, int i) {
        this(b.a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object b(java.lang.String r4) {
        /*
            r3 = this;
            com.ironsource.sdk.utils.a.a r0 = r3.a
            java.io.InputStream r0 = r0.a(r4)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ all -> 0x0035 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0035 }
            r2.<init>(r4)     // Catch:{ all -> 0x0035 }
            java.lang.String r4 = r2.getName()     // Catch:{ all -> 0x0035 }
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromStream(r1, r4)     // Catch:{ all -> 0x0035 }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            if (r4 != 0) goto L_0x0032
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Exception r4 = new java.lang.Exception
            java.lang.String r0 = "failed to create a drawable"
            r4.<init>(r0)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
        L_0x002d:
            java.lang.Object r4 = kotlin.Result.m2344constructorimpl(r4)
            return r4
        L_0x0032:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            goto L_0x002d
        L_0x0035:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0037 }
        L_0x0037:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r4)
            goto L_0x003d
        L_0x003c:
            throw r1
        L_0x003d:
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.utils.a.c.b(java.lang.String):java.lang.Object");
    }

    public final Object a(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        try {
            if (URLUtil.isHttpsUrl(str)) {
                return b(str);
            }
            File file = new File(str);
            if (!file.exists()) {
                Result.Companion companion = Result.Companion;
                return Result.m2344constructorimpl(ResultKt.createFailure(new Exception("file does not exists")));
            }
            Drawable createFromPath = Drawable.createFromPath(file.getPath());
            if (createFromPath == null) {
                Result.Companion companion2 = Result.Companion;
                return Result.m2344constructorimpl(ResultKt.createFailure(new Exception("failed to create a drawable")));
            }
            Result.Companion companion3 = Result.Companion;
            return Result.m2344constructorimpl(createFromPath);
        } catch (Exception e) {
            Result.Companion companion4 = Result.Companion;
            return Result.m2344constructorimpl(ResultKt.createFailure(e));
        }
    }
}
