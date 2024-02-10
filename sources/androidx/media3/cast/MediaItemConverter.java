package androidx.media3.cast;

import androidx.media3.common.MediaItem;
import com.google.android.gms.cast.MediaQueueItem;

public interface MediaItemConverter {
    MediaItem toMediaItem(MediaQueueItem mediaQueueItem);

    MediaQueueItem toMediaQueueItem(MediaItem mediaItem);
}
