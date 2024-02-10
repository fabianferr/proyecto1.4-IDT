package com.appnext.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import java.lang.ref.WeakReference;

public class j {
    private static volatile j dk;

    public interface a {
        void X();
    }

    public static j Y() {
        if (dk == null) {
            synchronized (j.class) {
                if (dk == null) {
                    dk = new j();
                }
            }
        }
        return dk;
    }

    private j() {
    }

    public final void a(Context context, ImageView imageView, String str, a aVar) {
        a(context, imageView, str, 0, false, aVar);
    }

    public final void a(Context context, ImageView imageView, String str, int i, a aVar) {
        a(context, imageView, str, 16, false, aVar);
    }

    public final void b(Context context, ImageView imageView, String str, int i, a aVar) {
        a(context, imageView, str, 16, true, aVar);
    }

    private void a(Context context, ImageView imageView, String str, int i, boolean z, a aVar) {
        final WeakReference weakReference;
        if (aVar != null) {
            try {
                weakReference = new WeakReference(aVar);
            } catch (Throwable th) {
                com.appnext.base.a.a("ImageLoader$displayImage", th);
                return;
            }
        } else {
            weakReference = null;
        }
        if (context != null && imageView != null && !TextUtils.isEmpty(str)) {
            RequestBuilder<Drawable> addListener = Glide.with(context.getApplicationContext()).load(str).addListener(new RequestListener<Drawable>() {
                public final boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                    a aVar;
                    try {
                        WeakReference weakReference = weakReference;
                        if (weakReference == null || (aVar = (a) weakReference.get()) == null) {
                            return false;
                        }
                        aVar.X();
                        return false;
                    } catch (Throwable unused) {
                        return false;
                    }
                }

                /* renamed from: a */
                public final boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                    try {
                        WeakReference weakReference = weakReference;
                        if (weakReference == null) {
                            return false;
                        }
                        weakReference.get();
                        return false;
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
            RequestOptions requestOptions = new RequestOptions();
            if (i > 0) {
                requestOptions.transform((Transformation<Bitmap>) new RoundedCorners(i));
            }
            if (z) {
                requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
            }
            addListener.apply((BaseRequestOptions<?>) requestOptions).into(imageView);
        }
    }
}
