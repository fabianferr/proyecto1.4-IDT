package androidx.media3.cast;

import android.util.SparseArray;
import androidx.media3.cast.CastTimeline;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

final class CastTimelineTracker {
    private final SparseArray<CastTimeline.ItemData> itemIdToData = new SparseArray<>();
    private final MediaItemConverter mediaItemConverter;
    final HashMap<String, MediaItem> mediaItemsByContentId = new HashMap<>();

    public CastTimelineTracker(MediaItemConverter mediaItemConverter2) {
        this.mediaItemConverter = mediaItemConverter2;
    }

    public void onMediaItemsSet(List<MediaItem> list, MediaQueueItem[] mediaQueueItemArr) {
        this.mediaItemsByContentId.clear();
        onMediaItemsAdded(list, mediaQueueItemArr);
    }

    public void onMediaItemsAdded(List<MediaItem> list, MediaQueueItem[] mediaQueueItemArr) {
        for (int i = 0; i < list.size(); i++) {
            this.mediaItemsByContentId.put(((MediaInfo) Assertions.checkNotNull(mediaQueueItemArr[i].getMedia())).getContentId(), list.get(i));
        }
    }

    public CastTimeline getCastTimeline(RemoteMediaClient remoteMediaClient) {
        MediaItem mediaItem;
        int[] itemIds = remoteMediaClient.getMediaQueue().getItemIds();
        if (itemIds.length > 0) {
            removeUnusedItemDataEntries(itemIds);
        }
        MediaStatus mediaStatus = remoteMediaClient.getMediaStatus();
        if (mediaStatus == null) {
            return CastTimeline.EMPTY_CAST_TIMELINE;
        }
        int currentItemId = mediaStatus.getCurrentItemId();
        String contentId = ((MediaInfo) Assertions.checkStateNotNull(mediaStatus.getMediaInfo())).getContentId();
        MediaItem mediaItem2 = this.mediaItemsByContentId.get(contentId);
        if (mediaItem2 == null) {
            mediaItem2 = MediaItem.EMPTY;
        }
        updateItemData(currentItemId, mediaItem2, mediaStatus.getMediaInfo(), contentId, -9223372036854775807L);
        for (MediaQueueItem next : mediaStatus.getQueueItems()) {
            long startTime = (long) (next.getStartTime() * 1000000.0d);
            MediaInfo media = next.getMedia();
            String contentId2 = media != null ? media.getContentId() : "UNKNOWN_CONTENT_ID";
            MediaItem mediaItem3 = this.mediaItemsByContentId.get(contentId2);
            int itemId = next.getItemId();
            if (mediaItem3 != null) {
                mediaItem = mediaItem3;
            } else {
                mediaItem = this.mediaItemConverter.toMediaItem(next);
            }
            updateItemData(itemId, mediaItem, media, contentId2, startTime);
        }
        return new CastTimeline(itemIds, this.itemIdToData);
    }

    private void updateItemData(int i, MediaItem mediaItem, MediaInfo mediaInfo, String str, long j) {
        boolean z;
        CastTimeline.ItemData itemData = this.itemIdToData.get(i, CastTimeline.ItemData.EMPTY);
        long streamDurationUs = CastUtils.getStreamDurationUs(mediaInfo);
        if (streamDurationUs == -9223372036854775807L) {
            streamDurationUs = itemData.durationUs;
        }
        if (mediaInfo == null) {
            z = itemData.isLive;
        } else {
            z = mediaInfo.getStreamType() == 2;
        }
        if (j == -9223372036854775807L) {
            j = itemData.defaultPositionUs;
        }
        this.itemIdToData.put(i, itemData.copyWithNewValues(streamDurationUs, j, z, mediaItem, str));
    }

    private void removeUnusedItemDataEntries(int[] iArr) {
        HashSet hashSet = new HashSet(iArr.length * 2);
        int i = 0;
        for (int valueOf : iArr) {
            hashSet.add(Integer.valueOf(valueOf));
        }
        while (i < this.itemIdToData.size()) {
            if (!hashSet.contains(Integer.valueOf(this.itemIdToData.keyAt(i)))) {
                this.mediaItemsByContentId.remove(this.itemIdToData.valueAt(i).contentId);
                this.itemIdToData.removeAt(i);
            } else {
                i++;
            }
        }
    }
}
