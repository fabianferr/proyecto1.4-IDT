package androidx.media3.exoplayer.smoothstreaming;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.smoothstreaming.SsChunkSource;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.chunk.BaseMediaChunkIterator;
import androidx.media3.exoplayer.source.chunk.BundledChunkExtractor;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.exoplayer.source.chunk.ChunkHolder;
import androidx.media3.exoplayer.source.chunk.ContainerMediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectionUtil;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Track;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.List;

public class DefaultSsChunkSource implements SsChunkSource {
    private final ChunkExtractor[] chunkExtractors;
    private final CmcdConfiguration cmcdConfiguration;
    private int currentManifestChunkOffset;
    private final DataSource dataSource;
    private IOException fatalError;
    private SsManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int streamElementIndex;
    private ExoTrackSelection trackSelection;

    public void onChunkLoadCompleted(Chunk chunk) {
    }

    public static final class Factory implements SsChunkSource.Factory {
        private final DataSource.Factory dataSourceFactory;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = factory;
        }

        public SsChunkSource createChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, ExoTrackSelection exoTrackSelection, TransferListener transferListener, CmcdConfiguration cmcdConfiguration) {
            DataSource createDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener != null) {
                createDataSource.addTransferListener(transferListener);
            }
            return new DefaultSsChunkSource(loaderErrorThrower, ssManifest, i, exoTrackSelection, createDataSource, cmcdConfiguration);
        }
    }

    public DefaultSsChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, ExoTrackSelection exoTrackSelection, DataSource dataSource2, CmcdConfiguration cmcdConfiguration2) {
        SsManifest ssManifest2 = ssManifest;
        int i2 = i;
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = ssManifest2;
        this.streamElementIndex = i2;
        this.trackSelection = exoTrackSelection2;
        this.dataSource = dataSource2;
        this.cmcdConfiguration = cmcdConfiguration2;
        SsManifest.StreamElement streamElement = ssManifest2.streamElements[i2];
        this.chunkExtractors = new ChunkExtractor[exoTrackSelection.length()];
        int i3 = 0;
        while (i3 < this.chunkExtractors.length) {
            int indexInTrackGroup = exoTrackSelection2.getIndexInTrackGroup(i3);
            Format format = streamElement.formats[indexInTrackGroup];
            int i4 = i3;
            Track track = r7;
            Track track2 = new Track(indexInTrackGroup, streamElement.type, streamElement.timescale, -9223372036854775807L, ssManifest2.durationUs, format, 0, format.drmInitData != null ? ((SsManifest.ProtectionElement) Assertions.checkNotNull(ssManifest2.protectionElement)).trackEncryptionBoxes : null, streamElement.type == 2 ? 4 : 0, (long[]) null, (long[]) null);
            this.chunkExtractors[i4] = new BundledChunkExtractor(new FragmentedMp4Extractor(3, (TimestampAdjuster) null, track), streamElement.type, format);
            i3 = i4 + 1;
        }
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int chunkIndex = streamElement.getChunkIndex(j);
        long startTimeUs = streamElement.getStartTimeUs(chunkIndex);
        return seekParameters.resolveSeekPositionUs(j, startTimeUs, (startTimeUs >= j || chunkIndex >= streamElement.chunkCount + -1) ? startTimeUs : streamElement.getStartTimeUs(chunkIndex + 1));
    }

    public void updateManifest(SsManifest ssManifest) {
        SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int i = streamElement.chunkCount;
        SsManifest.StreamElement streamElement2 = ssManifest.streamElements[this.streamElementIndex];
        if (i == 0 || streamElement2.chunkCount == 0) {
            this.currentManifestChunkOffset += i;
        } else {
            int i2 = i - 1;
            long startTimeUs = streamElement2.getStartTimeUs(0);
            if (streamElement.getStartTimeUs(i2) + streamElement.getChunkDurationUs(i2) <= startTimeUs) {
                this.currentManifestChunkOffset += i;
            } else {
                this.currentManifestChunkOffset += streamElement.getChunkIndex(startTimeUs);
            }
        }
        this.manifest = ssManifest;
    }

    public void updateTrackSelection(ExoTrackSelection exoTrackSelection) {
        this.trackSelection = exoTrackSelection;
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            this.manifestLoaderErrorThrower.maybeThrowError();
            return;
        }
        throw iOException;
    }

    public int getPreferredQueueSize(long j, List<? extends MediaChunk> list) {
        if (this.fatalError != null || this.trackSelection.length() < 2) {
            return list.size();
        }
        return this.trackSelection.evaluateQueueSize(j, list);
    }

    public boolean shouldCancelLoad(long j, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.fatalError != null) {
            return false;
        }
        return this.trackSelection.shouldCancelChunkLoad(j, chunk, list);
    }

    public final void getNextChunk(long j, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        int i;
        CmcdHeadersFactory cmcdHeadersFactory;
        long j3 = j2;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.fatalError == null) {
            SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
            if (streamElement.chunkCount == 0) {
                chunkHolder2.endOfStream = !this.manifest.isLive;
                return;
            }
            if (list.isEmpty()) {
                i = streamElement.getChunkIndex(j3);
                List<? extends MediaChunk> list2 = list;
            } else {
                i = (int) (((MediaChunk) list.get(list.size() - 1)).getNextChunkIndex() - ((long) this.currentManifestChunkOffset));
                if (i < 0) {
                    this.fatalError = new BehindLiveWindowException();
                    return;
                }
            }
            if (i >= streamElement.chunkCount) {
                chunkHolder2.endOfStream = !this.manifest.isLive;
                return;
            }
            long j4 = j3 - j;
            long resolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j);
            int length = this.trackSelection.length();
            MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
            for (int i2 = 0; i2 < length; i2++) {
                mediaChunkIteratorArr[i2] = new StreamElementIterator(streamElement, this.trackSelection.getIndexInTrackGroup(i2), i);
            }
            this.trackSelection.updateSelectedTrack(j, j4, resolveTimeToLiveEdgeUs, list, mediaChunkIteratorArr);
            long startTimeUs = streamElement.getStartTimeUs(i);
            long chunkDurationUs = startTimeUs + streamElement.getChunkDurationUs(i);
            if (!list.isEmpty()) {
                j3 = -9223372036854775807L;
            }
            long j5 = j3;
            int i3 = i + this.currentManifestChunkOffset;
            int selectedIndex = this.trackSelection.getSelectedIndex();
            ChunkExtractor chunkExtractor = this.chunkExtractors[selectedIndex];
            Uri buildRequestUri = streamElement.buildRequestUri(this.trackSelection.getIndexInTrackGroup(selectedIndex), i);
            if (this.cmcdConfiguration == null) {
                cmcdHeadersFactory = null;
            } else {
                cmcdHeadersFactory = new CmcdHeadersFactory(this.cmcdConfiguration, this.trackSelection, j4, CmcdHeadersFactory.STREAMING_FORMAT_SS, this.manifest.isLive).setChunkDurationUs(chunkDurationUs - startTimeUs).setObjectType(CmcdHeadersFactory.getObjectType(this.trackSelection));
            }
            CmcdHeadersFactory cmcdHeadersFactory2 = cmcdHeadersFactory;
            chunkHolder2.chunk = newMediaChunk(this.trackSelection.getSelectedFormat(), this.dataSource, buildRequestUri, i3, startTimeUs, chunkDurationUs, j5, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), chunkExtractor, cmcdHeadersFactory2);
        }
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionFor = loadErrorHandlingPolicy.getFallbackSelectionFor(TrackSelectionUtil.createFallbackOptions(this.trackSelection), loadErrorInfo);
        if (z && fallbackSelectionFor != null && fallbackSelectionFor.type == 2) {
            ExoTrackSelection exoTrackSelection = this.trackSelection;
            if (exoTrackSelection.excludeTrack(exoTrackSelection.indexOf(chunk.trackFormat), fallbackSelectionFor.exclusionDurationMs)) {
                return true;
            }
        }
        return false;
    }

    public void release() {
        for (ChunkExtractor release : this.chunkExtractors) {
            release.release();
        }
    }

    private static MediaChunk newMediaChunk(Format format, DataSource dataSource2, Uri uri, int i, long j, long j2, long j3, int i2, Object obj, ChunkExtractor chunkExtractor, CmcdHeadersFactory cmcdHeadersFactory) {
        ImmutableMap<String, String> immutableMap;
        if (cmcdHeadersFactory == null) {
            immutableMap = ImmutableMap.of();
        } else {
            immutableMap = cmcdHeadersFactory.createHttpRequestHeaders();
        }
        return new ContainerMediaChunk(dataSource2, new DataSpec.Builder().setUri(uri).setHttpRequestHeaders(immutableMap).build(), format, i2, obj, j, j2, j3, -9223372036854775807L, (long) i, 1, j, chunkExtractor);
    }

    private long resolveTimeToLiveEdgeUs(long j) {
        if (!this.manifest.isLive) {
            return -9223372036854775807L;
        }
        SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int i = streamElement.chunkCount - 1;
        return (streamElement.getStartTimeUs(i) + streamElement.getChunkDurationUs(i)) - j;
    }

    private static final class StreamElementIterator extends BaseMediaChunkIterator {
        private final SsManifest.StreamElement streamElement;
        private final int trackIndex;

        public StreamElementIterator(SsManifest.StreamElement streamElement2, int i, int i2) {
            super((long) i2, (long) (streamElement2.chunkCount - 1));
            this.streamElement = streamElement2;
            this.trackIndex = i;
        }

        public DataSpec getDataSpec() {
            checkInBounds();
            return new DataSpec(this.streamElement.buildRequestUri(this.trackIndex, (int) getCurrentIndex()));
        }

        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.streamElement.getStartTimeUs((int) getCurrentIndex());
        }

        public long getChunkEndTimeUs() {
            return getChunkStartTimeUs() + this.streamElement.getChunkDurationUs((int) getCurrentIndex());
        }
    }
}
