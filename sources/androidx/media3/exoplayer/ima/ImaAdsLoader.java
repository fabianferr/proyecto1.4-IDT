package androidx.media3.exoplayer.ima;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.ima.ImaUtil;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public final class ImaAdsLoader implements AdsLoader {
    private final HashMap<Object, AdTagLoader> adTagLoaderByAdsId;
    private final HashMap<AdsMediaSource, AdTagLoader> adTagLoaderByAdsMediaSource;
    private final ImaUtil.Configuration configuration;
    private final Context context;
    private AdTagLoader currentAdTagLoader;
    private final ImaUtil.ImaFactory imaFactory;
    private Player nextPlayer;
    private final Timeline.Period period;
    private Player player;
    private final PlayerListenerImpl playerListener;
    private List<String> supportedMimeTypes;
    private boolean wasSetPlayerCalled;
    private final Timeline.Window window;

    static {
        MediaLibraryInfo.registerModule("media3.exoplayer.ima");
    }

    public static final class Builder {
        public static final long DEFAULT_AD_PRELOAD_TIMEOUT_MS = 10000;
        private AdErrorEvent.AdErrorListener adErrorListener;
        private AdEvent.AdEventListener adEventListener;
        private List<String> adMediaMimeTypes;
        private long adPreloadTimeoutMs = 10000;
        private Set<UiElement> adUiElements;
        private Collection<CompanionAdSlot> companionAdSlots;
        private final Context context;
        private boolean debugModeEnabled;
        private Boolean enableContinuousPlayback;
        private boolean focusSkipButtonWhenAvailable = true;
        private ImaUtil.ImaFactory imaFactory = new DefaultImaFactory();
        private ImaSdkSettings imaSdkSettings;
        private int mediaBitrate = -1;
        private int mediaLoadTimeoutMs = -1;
        private boolean playAdBeforeStartPosition = true;
        private int vastLoadTimeoutMs = -1;
        private VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback;

        public Builder(Context context2) {
            this.context = ((Context) Assertions.checkNotNull(context2)).getApplicationContext();
        }

        public Builder setImaSdkSettings(ImaSdkSettings imaSdkSettings2) {
            this.imaSdkSettings = (ImaSdkSettings) Assertions.checkNotNull(imaSdkSettings2);
            return this;
        }

        public Builder setAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener2) {
            this.adErrorListener = (AdErrorEvent.AdErrorListener) Assertions.checkNotNull(adErrorListener2);
            return this;
        }

        public Builder setAdEventListener(AdEvent.AdEventListener adEventListener2) {
            this.adEventListener = (AdEvent.AdEventListener) Assertions.checkNotNull(adEventListener2);
            return this;
        }

        public Builder setVideoAdPlayerCallback(VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback2) {
            this.videoAdPlayerCallback = (VideoAdPlayer.VideoAdPlayerCallback) Assertions.checkNotNull(videoAdPlayerCallback2);
            return this;
        }

        public Builder setAdUiElements(Set<UiElement> set) {
            this.adUiElements = ImmutableSet.copyOf((Collection) Assertions.checkNotNull(set));
            return this;
        }

        public Builder setCompanionAdSlots(Collection<CompanionAdSlot> collection) {
            this.companionAdSlots = ImmutableList.copyOf((Collection) Assertions.checkNotNull(collection));
            return this;
        }

        public Builder setAdMediaMimeTypes(List<String> list) {
            this.adMediaMimeTypes = ImmutableList.copyOf((Collection) Assertions.checkNotNull(list));
            return this;
        }

        public Builder setEnableContinuousPlayback(boolean z) {
            this.enableContinuousPlayback = Boolean.valueOf(z);
            return this;
        }

        public Builder setAdPreloadTimeoutMs(long j) {
            Assertions.checkArgument(j == -9223372036854775807L || j > 0);
            this.adPreloadTimeoutMs = j;
            return this;
        }

        public Builder setVastLoadTimeoutMs(int i) {
            Assertions.checkArgument(i > 0);
            this.vastLoadTimeoutMs = i;
            return this;
        }

        public Builder setMediaLoadTimeoutMs(int i) {
            Assertions.checkArgument(i > 0);
            this.mediaLoadTimeoutMs = i;
            return this;
        }

        public Builder setMaxMediaBitrate(int i) {
            Assertions.checkArgument(i > 0);
            this.mediaBitrate = i;
            return this;
        }

        public Builder setFocusSkipButtonWhenAvailable(boolean z) {
            this.focusSkipButtonWhenAvailable = z;
            return this;
        }

        public Builder setPlayAdBeforeStartPosition(boolean z) {
            this.playAdBeforeStartPosition = z;
            return this;
        }

        public Builder setDebugModeEnabled(boolean z) {
            this.debugModeEnabled = z;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setImaFactory(ImaUtil.ImaFactory imaFactory2) {
            this.imaFactory = (ImaUtil.ImaFactory) Assertions.checkNotNull(imaFactory2);
            return this;
        }

        public ImaAdsLoader build() {
            Context context2 = this.context;
            ImaUtil.Configuration configuration = r3;
            ImaUtil.Configuration configuration2 = new ImaUtil.Configuration(this.adPreloadTimeoutMs, this.vastLoadTimeoutMs, this.mediaLoadTimeoutMs, this.focusSkipButtonWhenAvailable, this.playAdBeforeStartPosition, this.mediaBitrate, this.enableContinuousPlayback, this.adMediaMimeTypes, this.adUiElements, this.companionAdSlots, this.adErrorListener, this.adEventListener, this.videoAdPlayerCallback, this.imaSdkSettings, this.debugModeEnabled);
            return new ImaAdsLoader(context2, configuration, this.imaFactory);
        }
    }

    private ImaAdsLoader(Context context2, ImaUtil.Configuration configuration2, ImaUtil.ImaFactory imaFactory2) {
        this.context = context2.getApplicationContext();
        this.configuration = configuration2;
        this.imaFactory = imaFactory2;
        this.playerListener = new PlayerListenerImpl();
        this.supportedMimeTypes = ImmutableList.of();
        this.adTagLoaderByAdsId = new HashMap<>();
        this.adTagLoaderByAdsMediaSource = new HashMap<>();
        this.period = new Timeline.Period();
        this.window = new Timeline.Window();
    }

    public com.google.ads.interactivemedia.v3.api.AdsLoader getAdsLoader() {
        AdTagLoader adTagLoader = this.currentAdTagLoader;
        if (adTagLoader != null) {
            return adTagLoader.getAdsLoader();
        }
        return null;
    }

    public AdDisplayContainer getAdDisplayContainer() {
        AdTagLoader adTagLoader = this.currentAdTagLoader;
        if (adTagLoader != null) {
            return adTagLoader.getAdDisplayContainer();
        }
        return null;
    }

    public void requestAds(DataSpec dataSpec, Object obj, ViewGroup viewGroup) {
        if (!this.adTagLoaderByAdsId.containsKey(obj)) {
            this.adTagLoaderByAdsId.put(obj, new AdTagLoader(this.context, this.configuration, this.imaFactory, this.supportedMimeTypes, dataSpec, obj, viewGroup));
        }
    }

    public void skipAd() {
        AdTagLoader adTagLoader = this.currentAdTagLoader;
        if (adTagLoader != null) {
            adTagLoader.skipAd();
        }
    }

    public void focusSkipButton() {
        AdTagLoader adTagLoader = this.currentAdTagLoader;
        if (adTagLoader != null) {
            adTagLoader.focusSkipButton();
        }
    }

    public void setPlayer(Player player2) {
        boolean z = false;
        Assertions.checkState(Looper.myLooper() == ImaUtil.getImaLooper());
        if (player2 == null || player2.getApplicationLooper() == ImaUtil.getImaLooper()) {
            z = true;
        }
        Assertions.checkState(z);
        this.nextPlayer = player2;
        this.wasSetPlayerCalled = true;
    }

    public void setSupportedContentTypes(int... iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i == 0) {
                arrayList.add("application/dash+xml");
            } else if (i == 2) {
                arrayList.add("application/x-mpegURL");
            } else if (i == 4) {
                arrayList.addAll(Arrays.asList(new String[]{"video/mp4", "video/webm", "video/3gpp", "audio/mp4", "audio/mpeg"}));
            }
        }
        this.supportedMimeTypes = Collections.unmodifiableList(arrayList);
    }

    public void start(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, AdsLoader.EventListener eventListener) {
        Assertions.checkState(this.wasSetPlayerCalled, "Set player using adsLoader.setPlayer before preparing the player.");
        if (this.adTagLoaderByAdsMediaSource.isEmpty()) {
            Player player2 = this.nextPlayer;
            this.player = player2;
            if (player2 != null) {
                player2.addListener(this.playerListener);
            } else {
                return;
            }
        }
        AdTagLoader adTagLoader = this.adTagLoaderByAdsId.get(obj);
        if (adTagLoader == null) {
            requestAds(dataSpec, obj, adViewProvider.getAdViewGroup());
            adTagLoader = this.adTagLoaderByAdsId.get(obj);
        }
        this.adTagLoaderByAdsMediaSource.put(adsMediaSource, (AdTagLoader) Assertions.checkNotNull(adTagLoader));
        adTagLoader.addListenerWithAdView(eventListener, adViewProvider);
        maybeUpdateCurrentAdTagLoader();
    }

    public void stop(AdsMediaSource adsMediaSource, AdsLoader.EventListener eventListener) {
        AdTagLoader remove = this.adTagLoaderByAdsMediaSource.remove(adsMediaSource);
        maybeUpdateCurrentAdTagLoader();
        if (remove != null) {
            remove.removeListener(eventListener);
        }
        if (this.player != null && this.adTagLoaderByAdsMediaSource.isEmpty()) {
            this.player.removeListener(this.playerListener);
            this.player = null;
        }
    }

    public void release() {
        Player player2 = this.player;
        if (player2 != null) {
            player2.removeListener(this.playerListener);
            this.player = null;
            maybeUpdateCurrentAdTagLoader();
        }
        this.nextPlayer = null;
        for (AdTagLoader release : this.adTagLoaderByAdsMediaSource.values()) {
            release.release();
        }
        this.adTagLoaderByAdsMediaSource.clear();
        for (AdTagLoader release2 : this.adTagLoaderByAdsId.values()) {
            release2.release();
        }
        this.adTagLoaderByAdsId.clear();
    }

    public void handlePrepareComplete(AdsMediaSource adsMediaSource, int i, int i2) {
        if (this.player != null) {
            ((AdTagLoader) Assertions.checkNotNull(this.adTagLoaderByAdsMediaSource.get(adsMediaSource))).handlePrepareComplete(i, i2);
        }
    }

    public void handlePrepareError(AdsMediaSource adsMediaSource, int i, int i2, IOException iOException) {
        if (this.player != null) {
            ((AdTagLoader) Assertions.checkNotNull(this.adTagLoaderByAdsMediaSource.get(adsMediaSource))).handlePrepareError(i, i2, iOException);
        }
    }

    /* access modifiers changed from: private */
    public void maybeUpdateCurrentAdTagLoader() {
        AdTagLoader adTagLoader = this.currentAdTagLoader;
        AdTagLoader currentAdTagLoader2 = getCurrentAdTagLoader();
        if (!Util.areEqual(adTagLoader, currentAdTagLoader2)) {
            if (adTagLoader != null) {
                adTagLoader.deactivate();
            }
            this.currentAdTagLoader = currentAdTagLoader2;
            if (currentAdTagLoader2 != null) {
                currentAdTagLoader2.activate((Player) Assertions.checkNotNull(this.player));
            }
        }
    }

    private AdTagLoader getCurrentAdTagLoader() {
        Object adsId;
        AdTagLoader adTagLoader;
        Player player2 = this.player;
        if (player2 == null) {
            return null;
        }
        Timeline currentTimeline = player2.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && (adsId = currentTimeline.getPeriod(player2.getCurrentPeriodIndex(), this.period).getAdsId()) != null && (adTagLoader = this.adTagLoaderByAdsId.get(adsId)) != null && this.adTagLoaderByAdsMediaSource.containsValue(adTagLoader)) {
            return adTagLoader;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void maybePreloadNextPeriodAds() {
        int nextPeriodIndex;
        AdTagLoader adTagLoader;
        Player player2 = this.player;
        if (player2 != null) {
            Timeline currentTimeline = player2.getCurrentTimeline();
            if (!currentTimeline.isEmpty() && (nextPeriodIndex = currentTimeline.getNextPeriodIndex(player2.getCurrentPeriodIndex(), this.period, this.window, player2.getRepeatMode(), player2.getShuffleModeEnabled())) != -1) {
                currentTimeline.getPeriod(nextPeriodIndex, this.period);
                Object adsId = this.period.getAdsId();
                if (adsId != null && (adTagLoader = this.adTagLoaderByAdsId.get(adsId)) != null && adTagLoader != this.currentAdTagLoader) {
                    Timeline.Window window2 = this.window;
                    Timeline.Period period2 = this.period;
                    adTagLoader.maybePreloadAds(Util.usToMs(((Long) currentTimeline.getPeriodPositionUs(window2, period2, period2.windowIndex, -9223372036854775807L).second).longValue()), Util.usToMs(this.period.durationUs));
                }
            }
        }
    }

    private final class PlayerListenerImpl implements Player.Listener {
        public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
            Player.Listener.CC.$default$onAudioAttributesChanged(this, audioAttributes);
        }

        public /* synthetic */ void onAudioSessionIdChanged(int i) {
            Player.Listener.CC.$default$onAudioSessionIdChanged(this, i);
        }

        public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
            Player.Listener.CC.$default$onAvailableCommandsChanged(this, commands);
        }

        public /* synthetic */ void onCues(CueGroup cueGroup) {
            Player.Listener.CC.$default$onCues((Player.Listener) this, cueGroup);
        }

        public /* synthetic */ void onCues(List list) {
            Player.Listener.CC.$default$onCues((Player.Listener) this, list);
        }

        public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            Player.Listener.CC.$default$onDeviceInfoChanged(this, deviceInfo);
        }

        public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
            Player.Listener.CC.$default$onDeviceVolumeChanged(this, i, z);
        }

        public /* synthetic */ void onEvents(Player player, Player.Events events) {
            Player.Listener.CC.$default$onEvents(this, player, events);
        }

        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            Player.Listener.CC.$default$onIsLoadingChanged(this, z);
        }

        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            Player.Listener.CC.$default$onIsPlayingChanged(this, z);
        }

        public /* synthetic */ void onLoadingChanged(boolean z) {
            Player.Listener.CC.$default$onLoadingChanged(this, z);
        }

        public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
            Player.Listener.CC.$default$onMaxSeekToPreviousPositionChanged(this, j);
        }

        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
            Player.Listener.CC.$default$onMediaItemTransition(this, mediaItem, i);
        }

        public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            Player.Listener.CC.$default$onMediaMetadataChanged(this, mediaMetadata);
        }

        public /* synthetic */ void onMetadata(Metadata metadata) {
            Player.Listener.CC.$default$onMetadata(this, metadata);
        }

        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            Player.Listener.CC.$default$onPlayWhenReadyChanged(this, z, i);
        }

        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Player.Listener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        public /* synthetic */ void onPlaybackStateChanged(int i) {
            Player.Listener.CC.$default$onPlaybackStateChanged(this, i);
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            Player.Listener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            Player.Listener.CC.$default$onPlayerError(this, playbackException);
        }

        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            Player.Listener.CC.$default$onPlayerErrorChanged(this, playbackException);
        }

        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            Player.Listener.CC.$default$onPlayerStateChanged(this, z, i);
        }

        public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            Player.Listener.CC.$default$onPlaylistMetadataChanged(this, mediaMetadata);
        }

        public /* synthetic */ void onPositionDiscontinuity(int i) {
            Player.Listener.CC.$default$onPositionDiscontinuity(this, i);
        }

        public /* synthetic */ void onRenderedFirstFrame() {
            Player.Listener.CC.$default$onRenderedFirstFrame(this);
        }

        public /* synthetic */ void onSeekBackIncrementChanged(long j) {
            Player.Listener.CC.$default$onSeekBackIncrementChanged(this, j);
        }

        public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
            Player.Listener.CC.$default$onSeekForwardIncrementChanged(this, j);
        }

        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
            Player.Listener.CC.$default$onSkipSilenceEnabledChanged(this, z);
        }

        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            Player.Listener.CC.$default$onSurfaceSizeChanged(this, i, i2);
        }

        public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            Player.Listener.CC.$default$onTrackSelectionParametersChanged(this, trackSelectionParameters);
        }

        public /* synthetic */ void onTracksChanged(Tracks tracks) {
            Player.Listener.CC.$default$onTracksChanged(this, tracks);
        }

        public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
            Player.Listener.CC.$default$onVideoSizeChanged(this, videoSize);
        }

        public /* synthetic */ void onVolumeChanged(float f) {
            Player.Listener.CC.$default$onVolumeChanged(this, f);
        }

        private PlayerListenerImpl() {
        }

        public void onTimelineChanged(Timeline timeline, int i) {
            if (!timeline.isEmpty()) {
                ImaAdsLoader.this.maybeUpdateCurrentAdTagLoader();
                ImaAdsLoader.this.maybePreloadNextPeriodAds();
            }
        }

        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
            ImaAdsLoader.this.maybeUpdateCurrentAdTagLoader();
            ImaAdsLoader.this.maybePreloadNextPeriodAds();
        }

        public void onShuffleModeEnabledChanged(boolean z) {
            ImaAdsLoader.this.maybePreloadNextPeriodAds();
        }

        public void onRepeatModeChanged(int i) {
            ImaAdsLoader.this.maybePreloadNextPeriodAds();
        }
    }

    private static final class DefaultImaFactory implements ImaUtil.ImaFactory {
        private DefaultImaFactory() {
        }

        public ImaSdkSettings createImaSdkSettings() {
            ImaSdkSettings createImaSdkSettings = ImaSdkFactory.getInstance().createImaSdkSettings();
            createImaSdkSettings.setLanguage(Util.getSystemLanguageCodes()[0]);
            return createImaSdkSettings;
        }

        public AdsRenderingSettings createAdsRenderingSettings() {
            return ImaSdkFactory.getInstance().createAdsRenderingSettings();
        }

        public AdDisplayContainer createAdDisplayContainer(ViewGroup viewGroup, VideoAdPlayer videoAdPlayer) {
            return ImaSdkFactory.createAdDisplayContainer(viewGroup, videoAdPlayer);
        }

        public AdDisplayContainer createAudioAdDisplayContainer(Context context, VideoAdPlayer videoAdPlayer) {
            return ImaSdkFactory.createAudioAdDisplayContainer(context, videoAdPlayer);
        }

        public FriendlyObstruction createFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
            return ImaSdkFactory.getInstance().createFriendlyObstruction(view, friendlyObstructionPurpose, str);
        }

        public AdsRequest createAdsRequest() {
            return ImaSdkFactory.getInstance().createAdsRequest();
        }

        public com.google.ads.interactivemedia.v3.api.AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, AdDisplayContainer adDisplayContainer) {
            return ImaSdkFactory.getInstance().createAdsLoader(context, imaSdkSettings, adDisplayContainer);
        }
    }
}
