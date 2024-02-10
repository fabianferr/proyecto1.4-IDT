package com.ironsource.mediationsdk.ads.nativead.interfaces;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0010R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdDataInterface;", "", "advertiser", "", "getAdvertiser", "()Ljava/lang/String;", "body", "getBody", "callToAction", "getCallToAction", "icon", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdDataInterface$Image;", "getIcon", "()Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdDataInterface$Image;", "title", "getTitle", "Image", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface NativeAdDataInterface {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdDataInterface$Image;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "uri", "Landroid/net/Uri;", "(Landroid/graphics/drawable/Drawable;Landroid/net/Uri;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getUri", "()Landroid/net/Uri;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Image {
        private final Drawable a;
        private final Uri b;

        public Image(Drawable drawable, Uri uri) {
            this.a = drawable;
            this.b = uri;
        }

        public final Drawable getDrawable() {
            return this.a;
        }

        public final Uri getUri() {
            return this.b;
        }
    }

    String getAdvertiser();

    String getBody();

    String getCallToAction();

    Image getIcon();

    String getTitle();
}
