package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;

public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    private static final String TAG = "DefaultMediaSourceFactory";
    private AdViewProvider adViewProvider;
    private AdsLoaderProvider adsLoaderProvider;
    private final DataSource.Factory dataSourceFactory;
    private long liveMaxOffsetMs;
    private float liveMaxSpeed;
    private long liveMinOffsetMs;
    private float liveMinSpeed;
    private long liveTargetOffsetMs;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final SparseArray<MediaSourceFactory> mediaSourceFactories;
    private final int[] supportedTypes;

    public interface AdsLoaderProvider {
        AdsLoader getAdsLoader(MediaItem.AdsConfiguration adsConfiguration);
    }

    public /* synthetic */ MediaSource createMediaSource(Uri uri) {
        return MediaSourceFactory.CC.$default$createMediaSource(this, uri);
    }

    public DefaultMediaSourceFactory(Context context) {
        this((DataSource.Factory) new DefaultDataSourceFactory(context));
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this((DataSource.Factory) new DefaultDataSourceFactory(context), extractorsFactory);
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, (ExtractorsFactory) new DefaultExtractorsFactory());
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.dataSourceFactory = factory;
        SparseArray<MediaSourceFactory> loadDelegates = loadDelegates(factory, extractorsFactory);
        this.mediaSourceFactories = loadDelegates;
        this.supportedTypes = new int[loadDelegates.size()];
        for (int i = 0; i < this.mediaSourceFactories.size(); i++) {
            this.supportedTypes[i] = this.mediaSourceFactories.keyAt(i);
        }
        this.liveTargetOffsetMs = -9223372036854775807L;
        this.liveMinOffsetMs = -9223372036854775807L;
        this.liveMaxOffsetMs = -9223372036854775807L;
        this.liveMinSpeed = -3.4028235E38f;
        this.liveMaxSpeed = -3.4028235E38f;
    }

    public DefaultMediaSourceFactory setAdsLoaderProvider(AdsLoaderProvider adsLoaderProvider2) {
        this.adsLoaderProvider = adsLoaderProvider2;
        return this;
    }

    public DefaultMediaSourceFactory setAdViewProvider(AdViewProvider adViewProvider2) {
        this.adViewProvider = adViewProvider2;
        return this;
    }

    public DefaultMediaSourceFactory setLiveTargetOffsetMs(long j) {
        this.liveTargetOffsetMs = j;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMinOffsetMs(long j) {
        this.liveMinOffsetMs = j;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMaxOffsetMs(long j) {
        this.liveMaxOffsetMs = j;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMinSpeed(float f) {
        this.liveMinSpeed = f;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMaxSpeed(float f) {
        this.liveMaxSpeed = f;
        return this;
    }

    public DefaultMediaSourceFactory setDrmHttpDataSourceFactory(HttpDataSource.Factory factory) {
        for (int i = 0; i < this.mediaSourceFactories.size(); i++) {
            this.mediaSourceFactories.valueAt(i).setDrmHttpDataSourceFactory(factory);
        }
        return this;
    }

    public DefaultMediaSourceFactory setDrmUserAgent(String str) {
        for (int i = 0; i < this.mediaSourceFactories.size(); i++) {
            this.mediaSourceFactories.valueAt(i).setDrmUserAgent(str);
        }
        return this;
    }

    public DefaultMediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager) {
        for (int i = 0; i < this.mediaSourceFactories.size(); i++) {
            this.mediaSourceFactories.valueAt(i).setDrmSessionManager(drmSessionManager);
        }
        return this;
    }

    public DefaultMediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
        for (int i = 0; i < this.mediaSourceFactories.size(); i++) {
            this.mediaSourceFactories.valueAt(i).setDrmSessionManagerProvider(drmSessionManagerProvider);
        }
        return this;
    }

    public DefaultMediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        for (int i = 0; i < this.mediaSourceFactories.size(); i++) {
            this.mediaSourceFactories.valueAt(i).setLoadErrorHandlingPolicy(loadErrorHandlingPolicy2);
        }
        return this;
    }

    @Deprecated
    public DefaultMediaSourceFactory setStreamKeys(List<StreamKey> list) {
        for (int i = 0; i < this.mediaSourceFactories.size(); i++) {
            this.mediaSourceFactories.valueAt(i).setStreamKeys(list);
        }
        return this;
    }

    public int[] getSupportedTypes() {
        int[] iArr = this.supportedTypes;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public MediaSource createMediaSource(MediaItem mediaItem) {
        long j;
        float f;
        float f2;
        long j2;
        long j3;
        Assertions.checkNotNull(mediaItem.playbackProperties);
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(mediaItem.playbackProperties.uri, mediaItem.playbackProperties.mimeType);
        MediaSourceFactory mediaSourceFactory = this.mediaSourceFactories.get(inferContentTypeForUriAndMimeType);
        StringBuilder sb = new StringBuilder(68);
        sb.append("No suitable media source factory found for content type: ");
        sb.append(inferContentTypeForUriAndMimeType);
        Assertions.checkNotNull(mediaSourceFactory, sb.toString());
        if ((mediaItem.liveConfiguration.targetOffsetMs == -9223372036854775807L && this.liveTargetOffsetMs != -9223372036854775807L) || ((mediaItem.liveConfiguration.minPlaybackSpeed == -3.4028235E38f && this.liveMinSpeed != -3.4028235E38f) || ((mediaItem.liveConfiguration.maxPlaybackSpeed == -3.4028235E38f && this.liveMaxSpeed != -3.4028235E38f) || ((mediaItem.liveConfiguration.minOffsetMs == -9223372036854775807L && this.liveMinOffsetMs != -9223372036854775807L) || (mediaItem.liveConfiguration.maxOffsetMs == -9223372036854775807L && this.liveMaxOffsetMs != -9223372036854775807L))))) {
            MediaItem.Builder buildUpon = mediaItem.buildUpon();
            if (mediaItem.liveConfiguration.targetOffsetMs == -9223372036854775807L) {
                j = this.liveTargetOffsetMs;
            } else {
                j = mediaItem.liveConfiguration.targetOffsetMs;
            }
            MediaItem.Builder liveTargetOffsetMs2 = buildUpon.setLiveTargetOffsetMs(j);
            if (mediaItem.liveConfiguration.minPlaybackSpeed == -3.4028235E38f) {
                f = this.liveMinSpeed;
            } else {
                f = mediaItem.liveConfiguration.minPlaybackSpeed;
            }
            MediaItem.Builder liveMinPlaybackSpeed = liveTargetOffsetMs2.setLiveMinPlaybackSpeed(f);
            if (mediaItem.liveConfiguration.maxPlaybackSpeed == -3.4028235E38f) {
                f2 = this.liveMaxSpeed;
            } else {
                f2 = mediaItem.liveConfiguration.maxPlaybackSpeed;
            }
            MediaItem.Builder liveMaxPlaybackSpeed = liveMinPlaybackSpeed.setLiveMaxPlaybackSpeed(f2);
            if (mediaItem.liveConfiguration.minOffsetMs == -9223372036854775807L) {
                j2 = this.liveMinOffsetMs;
            } else {
                j2 = mediaItem.liveConfiguration.minOffsetMs;
            }
            MediaItem.Builder liveMinOffsetMs2 = liveMaxPlaybackSpeed.setLiveMinOffsetMs(j2);
            if (mediaItem.liveConfiguration.maxOffsetMs == -9223372036854775807L) {
                j3 = this.liveMaxOffsetMs;
            } else {
                j3 = mediaItem.liveConfiguration.maxOffsetMs;
            }
            mediaItem = liveMinOffsetMs2.setLiveMaxOffsetMs(j3).build();
        }
        MediaSource createMediaSource = mediaSourceFactory.createMediaSource(mediaItem);
        List<MediaItem.Subtitle> list = ((MediaItem.PlaybackProperties) Util.castNonNull(mediaItem.playbackProperties)).subtitles;
        if (!list.isEmpty()) {
            MediaSource[] mediaSourceArr = new MediaSource[(list.size() + 1)];
            int i = 0;
            mediaSourceArr[0] = createMediaSource;
            SingleSampleMediaSource.Factory loadErrorHandlingPolicy2 = new SingleSampleMediaSource.Factory(this.dataSourceFactory).setLoadErrorHandlingPolicy(this.loadErrorHandlingPolicy);
            while (i < list.size()) {
                int i2 = i + 1;
                mediaSourceArr[i2] = loadErrorHandlingPolicy2.createMediaSource(list.get(i), -9223372036854775807L);
                i = i2;
            }
            createMediaSource = new MergingMediaSource(mediaSourceArr);
        }
        return maybeWrapWithAdsMediaSource(mediaItem, maybeClipMediaSource(mediaItem, createMediaSource));
    }

    private static MediaSource maybeClipMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        if (mediaItem.clippingProperties.startPositionMs == 0 && mediaItem.clippingProperties.endPositionMs == Long.MIN_VALUE && !mediaItem.clippingProperties.relativeToDefaultPosition) {
            return mediaSource;
        }
        return new ClippingMediaSource(mediaSource, C.msToUs(mediaItem.clippingProperties.startPositionMs), C.msToUs(mediaItem.clippingProperties.endPositionMs), !mediaItem.clippingProperties.startsAtKeyFrame, mediaItem.clippingProperties.relativeToLiveWindow, mediaItem.clippingProperties.relativeToDefaultPosition);
    }

    private MediaSource maybeWrapWithAdsMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        Object obj;
        Assertions.checkNotNull(mediaItem.playbackProperties);
        MediaItem.AdsConfiguration adsConfiguration = mediaItem.playbackProperties.adsConfiguration;
        if (adsConfiguration == null) {
            return mediaSource;
        }
        AdsLoaderProvider adsLoaderProvider2 = this.adsLoaderProvider;
        AdViewProvider adViewProvider2 = this.adViewProvider;
        if (adsLoaderProvider2 == null || adViewProvider2 == null) {
            Log.w(TAG, "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return mediaSource;
        }
        AdsLoader adsLoader = adsLoaderProvider2.getAdsLoader(adsConfiguration);
        if (adsLoader == null) {
            Log.w(TAG, "Playing media without ads, as no AdsLoader was provided.");
            return mediaSource;
        }
        DataSpec dataSpec = new DataSpec(adsConfiguration.adTagUri);
        if (adsConfiguration.adsId != null) {
            obj = adsConfiguration.adsId;
        } else {
            obj = ImmutableList.of(mediaItem.mediaId, mediaItem.playbackProperties.uri, adsConfiguration.adTagUri);
        }
        return new AdsMediaSource(mediaSource, dataSpec, obj, this, adsLoader, adViewProvider2);
    }

    private static SparseArray<MediaSourceFactory> loadDelegates(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        SparseArray<MediaSourceFactory> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, (MediaSourceFactory) Class.forName("com.google.android.exoplayer2.source.dash.DashMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(new Class[]{DataSource.Factory.class}).newInstance(new Object[]{factory}));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (MediaSourceFactory) Class.forName("com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(new Class[]{DataSource.Factory.class}).newInstance(new Object[]{factory}));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (MediaSourceFactory) Class.forName("com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(new Class[]{DataSource.Factory.class}).newInstance(new Object[]{factory}));
        } catch (Exception unused3) {
        }
        try {
            sparseArray.put(3, (MediaSourceFactory) Class.forName("com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Exception unused4) {
        }
        sparseArray.put(4, new ProgressiveMediaSource.Factory(factory, extractorsFactory));
        return sparseArray;
    }
}
