package androidx.media3.common.util;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.media3.common.MediaMetadata;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.common.util.concurrent.ListenableFuture;

public interface BitmapLoader {
    ListenableFuture<Bitmap> decodeBitmap(byte[] bArr);

    ListenableFuture<Bitmap> loadBitmap(Uri uri);

    ListenableFuture<Bitmap> loadBitmapFromMetadata(MediaMetadata mediaMetadata);

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: androidx.media3.common.util.BitmapLoader$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ListenableFuture $default$loadBitmapFromMetadata(BitmapLoader _this, MediaMetadata mediaMetadata) {
            if (mediaMetadata.artworkData != null) {
                return _this.decodeBitmap(mediaMetadata.artworkData);
            }
            if (mediaMetadata.artworkUri != null) {
                return _this.loadBitmap(mediaMetadata.artworkUri);
            }
            return null;
        }
    }
}
