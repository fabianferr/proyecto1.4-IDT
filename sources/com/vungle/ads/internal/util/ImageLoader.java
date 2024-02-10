package com.vungle.ads.internal.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.LruCache;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\rJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/vungle/ads/internal/util/ImageLoader;", "", "()V", "ioExecutor", "Ljava/util/concurrent/Executor;", "lruCache", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "displayImage", "", "uri", "onImageLoaded", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bitmap", "init", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageLoader.kt */
public final class ImageLoader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FILE_SCHEME = "file://";
    private static final String TAG = "ImageLoader";
    /* access modifiers changed from: private */
    public static final ImageLoader instance = new ImageLoader();
    private Executor ioExecutor;
    private final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(((int) (Runtime.getRuntime().maxMemory() / ((long) 1024))) / 8) {
        /* access modifiers changed from: protected */
        public int sizeOf(String str, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "value");
            return bitmap.getByteCount() / 1024;
        }
    };

    private ImageLoader() {
    }

    public final void init(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "ioExecutor");
        this.ioExecutor = executor;
    }

    public final void displayImage(String str, Function1<? super Bitmap, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onImageLoaded");
        if (this.ioExecutor == null) {
            Log.w(TAG, "ImageLoader not initialized.");
            return;
        }
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            Log.w(TAG, "the uri is required.");
            return;
        }
        Executor executor = this.ioExecutor;
        if (executor != null) {
            executor.execute(new ImageLoader$$ExternalSyntheticLambda0(str, this, function1));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: displayImage$lambda-0  reason: not valid java name */
    public static final void m2334displayImage$lambda0(String str, ImageLoader imageLoader, Function1 function1) {
        Intrinsics.checkNotNullParameter(imageLoader, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$onImageLoaded");
        if (StringsKt.startsWith$default(str, "file://", false, 2, (Object) null)) {
            Bitmap bitmap = imageLoader.lruCache.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                String substring = str.substring(7);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                Bitmap decodeFile = BitmapFactory.decodeFile(substring);
                if (decodeFile != null) {
                    imageLoader.lruCache.put(str, decodeFile);
                    function1.invoke(decodeFile);
                    return;
                }
                Log.w(TAG, "decode bitmap failed.");
                return;
            }
            function1.invoke(bitmap);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/vungle/ads/internal/util/ImageLoader$Companion;", "", "()V", "FILE_SCHEME", "", "TAG", "kotlin.jvm.PlatformType", "instance", "Lcom/vungle/ads/internal/util/ImageLoader;", "getInstance", "()Lcom/vungle/ads/internal/util/ImageLoader;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImageLoader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageLoader getInstance() {
            return ImageLoader.instance;
        }
    }
}
