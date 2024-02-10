package androidx.media3.exoplayer.dash;

import android.os.SystemClock;
import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.dash.DashChunkSource;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.BaseUrl;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.RangedUri;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.chunk.BaseMediaChunkIterator;
import androidx.media3.exoplayer.source.chunk.BundledChunkExtractor;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.exoplayer.source.chunk.ContainerMediaChunk;
import androidx.media3.exoplayer.source.chunk.InitializationChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.SingleSampleMediaChunk;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.extractor.ChunkIndex;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultDashChunkSource implements DashChunkSource {
    private final int[] adaptationSetIndices;
    private final BaseUrlExclusionList baseUrlExclusionList;
    private final CmcdConfiguration cmcdConfiguration;
    private final DataSource dataSource;
    private final long elapsedRealtimeOffsetMs;
    private IOException fatalError;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int maxSegmentsPerLoad;
    private boolean missingLastSegment;
    private int periodIndex;
    private final PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler;
    protected final RepresentationHolder[] representationHolders;
    private ExoTrackSelection trackSelection;
    private final int trackType;

    public static final class Factory implements DashChunkSource.Factory {
        private final ChunkExtractor.Factory chunkExtractorFactory;
        private final DataSource.Factory dataSourceFactory;
        private final int maxSegmentsPerLoad;

        public Factory(DataSource.Factory factory) {
            this(factory, 1);
        }

        public Factory(DataSource.Factory factory, int i) {
            this(BundledChunkExtractor.FACTORY, factory, i);
        }

        public Factory(ChunkExtractor.Factory factory, DataSource.Factory factory2, int i) {
            this.chunkExtractorFactory = factory;
            this.dataSourceFactory = factory2;
            this.maxSegmentsPerLoad = i;
        }

        public DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i, int[] iArr, ExoTrackSelection exoTrackSelection, int i2, long j, boolean z, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, TransferListener transferListener, PlayerId playerId, CmcdConfiguration cmcdConfiguration) {
            TransferListener transferListener2 = transferListener;
            DataSource createDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener2 != null) {
                createDataSource.addTransferListener(transferListener2);
            }
            return new DefaultDashChunkSource(this.chunkExtractorFactory, loaderErrorThrower, dashManifest, baseUrlExclusionList, i, iArr, exoTrackSelection, i2, createDataSource, j, this.maxSegmentsPerLoad, z, list, playerTrackEmsgHandler, playerId, cmcdConfiguration);
        }
    }

    public DefaultDashChunkSource(ChunkExtractor.Factory factory, LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList2, int i, int[] iArr, ExoTrackSelection exoTrackSelection, int i2, DataSource dataSource2, long j, int i3, boolean z, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2, PlayerId playerId, CmcdConfiguration cmcdConfiguration2) {
        DashManifest dashManifest2 = dashManifest;
        BaseUrlExclusionList baseUrlExclusionList3 = baseUrlExclusionList2;
        int i4 = i;
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = dashManifest2;
        this.baseUrlExclusionList = baseUrlExclusionList3;
        this.adaptationSetIndices = iArr;
        this.trackSelection = exoTrackSelection2;
        this.trackType = i2;
        this.dataSource = dataSource2;
        this.periodIndex = i4;
        this.elapsedRealtimeOffsetMs = j;
        this.maxSegmentsPerLoad = i3;
        this.playerTrackEmsgHandler = playerTrackEmsgHandler2;
        this.cmcdConfiguration = cmcdConfiguration2;
        long periodDurationUs = dashManifest2.getPeriodDurationUs(i4);
        ArrayList<Representation> representations = getRepresentations();
        this.representationHolders = new RepresentationHolder[exoTrackSelection.length()];
        int i5 = 0;
        while (i5 < this.representationHolders.length) {
            Representation representation = representations.get(exoTrackSelection2.getIndexInTrackGroup(i5));
            BaseUrl selectBaseUrl = baseUrlExclusionList3.selectBaseUrl(representation.baseUrls);
            RepresentationHolder[] representationHolderArr = this.representationHolders;
            if (selectBaseUrl == null) {
                selectBaseUrl = (BaseUrl) representation.baseUrls.get(0);
            }
            int i6 = i5;
            long j2 = periodDurationUs;
            Representation representation2 = representation;
            representationHolderArr[i6] = new RepresentationHolder(j2, representation2, selectBaseUrl, factory.createProgressiveMediaExtractor(i2, representation.format, z, list, playerTrackEmsgHandler2, playerId), 0, representation.getIndex());
            i5 = i6 + 1;
        }
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        long j2 = j;
        for (RepresentationHolder representationHolder : this.representationHolders) {
            if (representationHolder.segmentIndex != null) {
                long segmentCount = representationHolder.getSegmentCount();
                if (segmentCount != 0) {
                    long segmentNum = representationHolder.getSegmentNum(j2);
                    long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(segmentNum);
                    return seekParameters.resolveSeekPositionUs(j, segmentStartTimeUs, (segmentStartTimeUs >= j2 || (segmentCount != -1 && segmentNum >= (representationHolder.getFirstSegmentNum() + segmentCount) - 1)) ? segmentStartTimeUs : representationHolder.getSegmentStartTimeUs(segmentNum + 1));
                }
            }
        }
        return j2;
    }

    public void updateManifest(DashManifest dashManifest, int i) {
        try {
            this.manifest = dashManifest;
            this.periodIndex = i;
            long periodDurationUs = dashManifest.getPeriodDurationUs(i);
            ArrayList<Representation> representations = getRepresentations();
            for (int i2 = 0; i2 < this.representationHolders.length; i2++) {
                RepresentationHolder[] representationHolderArr = this.representationHolders;
                representationHolderArr[i2] = representationHolderArr[i2].copyWithNewRepresentation(periodDurationUs, representations.get(this.trackSelection.getIndexInTrackGroup(i2)));
            }
        } catch (BehindLiveWindowException e) {
            this.fatalError = e;
        }
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

    /* JADX WARNING: type inference failed for: r10v0, types: [boolean] */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getNextChunk(long r33, long r35, java.util.List<? extends androidx.media3.exoplayer.source.chunk.MediaChunk> r37, androidx.media3.exoplayer.source.chunk.ChunkHolder r38) {
        /*
            r32 = this;
            r15 = r32
            r9 = r33
            r14 = r38
            java.io.IOException r0 = r15.fatalError
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            long r11 = r35 - r9
            androidx.media3.exoplayer.dash.manifest.DashManifest r0 = r15.manifest
            long r0 = r0.availabilityStartTimeMs
            long r0 = androidx.media3.common.util.Util.msToUs(r0)
            androidx.media3.exoplayer.dash.manifest.DashManifest r2 = r15.manifest
            int r3 = r15.periodIndex
            androidx.media3.exoplayer.dash.manifest.Period r2 = r2.getPeriod(r3)
            long r2 = r2.startMs
            long r2 = androidx.media3.common.util.Util.msToUs(r2)
            long r0 = r0 + r2
            long r0 = r0 + r35
            androidx.media3.exoplayer.dash.PlayerEmsgHandler$PlayerTrackEmsgHandler r2 = r15.playerTrackEmsgHandler
            if (r2 == 0) goto L_0x0031
            boolean r0 = r2.maybeRefreshManifestBeforeLoadingNextChunk(r0)
            if (r0 == 0) goto L_0x0031
            return
        L_0x0031:
            long r0 = r15.elapsedRealtimeOffsetMs
            long r0 = androidx.media3.common.util.Util.getNowUnixTimeMs(r0)
            long r7 = androidx.media3.common.util.Util.msToUs(r0)
            long r24 = r15.getNowPeriodTimeUs(r7)
            boolean r0 = r37.isEmpty()
            r5 = 1
            if (r0 == 0) goto L_0x004b
            r6 = r37
            r26 = 0
            goto L_0x005a
        L_0x004b:
            int r0 = r37.size()
            int r0 = r0 - r5
            r6 = r37
            java.lang.Object r0 = r6.get(r0)
            androidx.media3.exoplayer.source.chunk.MediaChunk r0 = (androidx.media3.exoplayer.source.chunk.MediaChunk) r0
            r26 = r0
        L_0x005a:
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.trackSelection
            int r3 = r0.length()
            androidx.media3.exoplayer.source.chunk.MediaChunkIterator[] r4 = new androidx.media3.exoplayer.source.chunk.MediaChunkIterator[r3]
            r27 = 0
            r2 = 0
        L_0x0065:
            if (r2 >= r3) goto L_0x00bf
            androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationHolder[] r0 = r15.representationHolders
            r1 = r0[r2]
            androidx.media3.exoplayer.dash.DashSegmentIndex r0 = r1.segmentIndex
            if (r0 != 0) goto L_0x007c
            androidx.media3.exoplayer.source.chunk.MediaChunkIterator r0 = androidx.media3.exoplayer.source.chunk.MediaChunkIterator.EMPTY
            r4[r2] = r0
            r13 = r2
            r28 = r3
            r29 = r4
            r30 = r11
            r11 = r7
            goto L_0x00b2
        L_0x007c:
            long r16 = r1.getFirstAvailableSegmentNum(r7)
            long r20 = r1.getLastAvailableSegmentNum(r7)
            r0 = r32
            r13 = r2
            r2 = r26
            r28 = r3
            r29 = r4
            r3 = r35
            r5 = r16
            r30 = r11
            r11 = r7
            r7 = r20
            long r18 = r0.getSegmentNum(r1, r2, r3, r5, r7)
            int r0 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a3
            androidx.media3.exoplayer.source.chunk.MediaChunkIterator r0 = androidx.media3.exoplayer.source.chunk.MediaChunkIterator.EMPTY
            r29[r13] = r0
            goto L_0x00b2
        L_0x00a3:
            androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationHolder r17 = r15.updateSelectedBaseUrl(r13)
            androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationSegmentIterator r0 = new androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationSegmentIterator
            r16 = r0
            r22 = r24
            r16.<init>(r17, r18, r20, r22)
            r29[r13] = r0
        L_0x00b2:
            int r2 = r13 + 1
            r6 = r37
            r7 = r11
            r3 = r28
            r4 = r29
            r11 = r30
            r5 = 1
            goto L_0x0065
        L_0x00bf:
            r29 = r4
            r30 = r11
            r11 = r7
            long r5 = r15.getAvailableLiveDurationUs(r11, r9)
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.trackSelection
            r1 = r33
            r3 = r30
            r7 = r37
            r8 = r29
            r0.updateSelectedTrack(r1, r3, r5, r7, r8)
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.trackSelection
            int r0 = r0.getSelectedIndex()
            androidx.media3.exoplayer.upstream.CmcdConfiguration r1 = r15.cmcdConfiguration
            if (r1 != 0) goto L_0x00e2
            r16 = 0
            goto L_0x00f6
        L_0x00e2:
            androidx.media3.exoplayer.upstream.CmcdHeadersFactory r8 = new androidx.media3.exoplayer.upstream.CmcdHeadersFactory
            androidx.media3.exoplayer.upstream.CmcdConfiguration r2 = r15.cmcdConfiguration
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r3 = r15.trackSelection
            java.lang.String r6 = "d"
            androidx.media3.exoplayer.dash.manifest.DashManifest r1 = r15.manifest
            boolean r7 = r1.dynamic
            r1 = r8
            r4 = r30
            r1.<init>(r2, r3, r4, r6, r7)
            r16 = r8
        L_0x00f6:
            androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationHolder r9 = r15.updateSelectedBaseUrl(r0)
            androidx.media3.exoplayer.source.chunk.ChunkExtractor r0 = r9.chunkExtractor
            if (r0 == 0) goto L_0x013e
            androidx.media3.exoplayer.dash.manifest.Representation r0 = r9.representation
            androidx.media3.exoplayer.source.chunk.ChunkExtractor r1 = r9.chunkExtractor
            androidx.media3.common.Format[] r1 = r1.getSampleFormats()
            if (r1 != 0) goto L_0x010e
            androidx.media3.exoplayer.dash.manifest.RangedUri r1 = r0.getInitializationUri()
            r6 = r1
            goto L_0x010f
        L_0x010e:
            r6 = 0
        L_0x010f:
            androidx.media3.exoplayer.dash.DashSegmentIndex r1 = r9.segmentIndex
            if (r1 != 0) goto L_0x0119
            androidx.media3.exoplayer.dash.manifest.RangedUri r0 = r0.getIndexUri()
            r7 = r0
            goto L_0x011a
        L_0x0119:
            r7 = 0
        L_0x011a:
            if (r6 != 0) goto L_0x011e
            if (r7 == 0) goto L_0x013e
        L_0x011e:
            androidx.media3.datasource.DataSource r2 = r15.dataSource
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.trackSelection
            androidx.media3.common.Format r3 = r0.getSelectedFormat()
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.trackSelection
            int r4 = r0.getSelectionReason()
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.trackSelection
            java.lang.Object r5 = r0.getSelectionData()
            r0 = r32
            r1 = r9
            r8 = r16
            androidx.media3.exoplayer.source.chunk.Chunk r0 = r0.newInitializationChunk(r1, r2, r3, r4, r5, r6, r7, r8)
            r14.chunk = r0
            return
        L_0x013e:
            long r17 = r9.periodDurationUs
            androidx.media3.exoplayer.dash.manifest.DashManifest r0 = r15.manifest
            boolean r0 = r0.dynamic
            if (r0 == 0) goto L_0x0156
            int r0 = r15.periodIndex
            androidx.media3.exoplayer.dash.manifest.DashManifest r1 = r15.manifest
            int r1 = r1.getPeriodCount()
            r10 = 1
            int r1 = r1 - r10
            if (r0 != r1) goto L_0x0157
            r5 = 1
            goto L_0x0158
        L_0x0156:
            r10 = 1
        L_0x0157:
            r5 = 0
        L_0x0158:
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 == 0) goto L_0x0166
            int r0 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0164
            goto L_0x0166
        L_0x0164:
            r0 = 0
            goto L_0x0167
        L_0x0166:
            r0 = 1
        L_0x0167:
            long r1 = r9.getSegmentCount()
            r3 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x0174
            r14.endOfStream = r0
            return
        L_0x0174:
            long r21 = r9.getFirstAvailableSegmentNum(r11)
            long r11 = r9.getLastAvailableSegmentNum(r11)
            if (r5 == 0) goto L_0x0191
            long r1 = r9.getSegmentEndTimeUs(r11)
            long r3 = r9.getSegmentStartTimeUs(r11)
            long r3 = r1 - r3
            long r1 = r1 + r3
            int r3 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r3 < 0) goto L_0x018f
            r5 = 1
            goto L_0x0190
        L_0x018f:
            r5 = 0
        L_0x0190:
            r0 = r0 & r5
        L_0x0191:
            r13 = r0
            r0 = r32
            r1 = r9
            r2 = r26
            r3 = r35
            r5 = r21
            r7 = r11
            long r7 = r0.getSegmentNum(r1, r2, r3, r5, r7)
            int r0 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r0 >= 0) goto L_0x01ac
            androidx.media3.exoplayer.source.BehindLiveWindowException r0 = new androidx.media3.exoplayer.source.BehindLiveWindowException
            r0.<init>()
            r15.fatalError = r0
            return
        L_0x01ac:
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 > 0) goto L_0x0217
            boolean r0 = r15.missingLastSegment
            if (r0 == 0) goto L_0x01b9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x01b9
            goto L_0x0217
        L_0x01b9:
            if (r13 == 0) goto L_0x01c6
            long r0 = r9.getSegmentStartTimeUs(r7)
            int r2 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r2 < 0) goto L_0x01c6
            r14.endOfStream = r10
            return
        L_0x01c6:
            int r0 = r15.maxSegmentsPerLoad
            long r0 = (long) r0
            long r11 = r11 - r7
            r2 = 1
            long r11 = r11 + r2
            long r0 = java.lang.Math.min(r0, r11)
            int r1 = (int) r0
            int r0 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x01e6
        L_0x01d6:
            if (r1 <= r10) goto L_0x01e6
            long r4 = (long) r1
            long r4 = r4 + r7
            long r4 = r4 - r2
            long r4 = r9.getSegmentStartTimeUs(r4)
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 < 0) goto L_0x01e6
            int r1 = r1 + -1
            goto L_0x01d6
        L_0x01e6:
            r10 = r1
            boolean r0 = r37.isEmpty()
            if (r0 == 0) goto L_0x01ef
            r19 = r35
        L_0x01ef:
            androidx.media3.datasource.DataSource r2 = r15.dataSource
            int r3 = r15.trackType
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.trackSelection
            androidx.media3.common.Format r4 = r0.getSelectedFormat()
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.trackSelection
            int r5 = r0.getSelectionReason()
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.trackSelection
            java.lang.Object r6 = r0.getSelectionData()
            r0 = r32
            r1 = r9
            r9 = r10
            r10 = r19
            r12 = r24
            r15 = r14
            r14 = r16
            androidx.media3.exoplayer.source.chunk.Chunk r0 = r0.newMediaChunk(r1, r2, r3, r4, r5, r6, r7, r9, r10, r12, r14)
            r15.chunk = r0
            return
        L_0x0217:
            r15 = r14
            r15.endOfStream = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.DefaultDashChunkSource.getNextChunk(long, long, java.util.List, androidx.media3.exoplayer.source.chunk.ChunkHolder):void");
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        ChunkIndex chunkIndex;
        if (chunk instanceof InitializationChunk) {
            int indexOf = this.trackSelection.indexOf(((InitializationChunk) chunk).trackFormat);
            RepresentationHolder representationHolder = this.representationHolders[indexOf];
            if (representationHolder.segmentIndex == null && (chunkIndex = representationHolder.chunkExtractor.getChunkIndex()) != null) {
                this.representationHolders[indexOf] = representationHolder.copyWithNewSegmentIndex(new DashWrappingSegmentIndex(chunkIndex, representationHolder.representation.presentationTimeOffsetUs));
            }
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler2 != null) {
            playerTrackEmsgHandler2.onChunkLoadCompleted(chunk);
        }
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionFor;
        if (!z) {
            return false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler2 != null && playerTrackEmsgHandler2.onChunkLoadError(chunk)) {
            return true;
        }
        if (!this.manifest.dynamic && (chunk instanceof MediaChunk) && (loadErrorInfo.exception instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) loadErrorInfo.exception).responseCode == 404) {
            RepresentationHolder representationHolder = this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)];
            long segmentCount = representationHolder.getSegmentCount();
            if (!(segmentCount == -1 || segmentCount == 0)) {
                if (((MediaChunk) chunk).getNextChunkIndex() > (representationHolder.getFirstSegmentNum() + segmentCount) - 1) {
                    this.missingLastSegment = true;
                    return true;
                }
            }
        }
        RepresentationHolder representationHolder2 = this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)];
        BaseUrl selectBaseUrl = this.baseUrlExclusionList.selectBaseUrl(representationHolder2.representation.baseUrls);
        if (selectBaseUrl != null && !representationHolder2.selectedBaseUrl.equals(selectBaseUrl)) {
            return true;
        }
        LoadErrorHandlingPolicy.FallbackOptions createFallbackOptions = createFallbackOptions(this.trackSelection, representationHolder2.representation.baseUrls);
        if ((!createFallbackOptions.isFallbackAvailable(2) && !createFallbackOptions.isFallbackAvailable(1)) || (fallbackSelectionFor = loadErrorHandlingPolicy.getFallbackSelectionFor(createFallbackOptions, loadErrorInfo)) == null || !createFallbackOptions.isFallbackAvailable(fallbackSelectionFor.type)) {
            return false;
        }
        if (fallbackSelectionFor.type == 2) {
            ExoTrackSelection exoTrackSelection = this.trackSelection;
            return exoTrackSelection.excludeTrack(exoTrackSelection.indexOf(chunk.trackFormat), fallbackSelectionFor.exclusionDurationMs);
        } else if (fallbackSelectionFor.type != 1) {
            return false;
        } else {
            this.baseUrlExclusionList.exclude(representationHolder2.selectedBaseUrl, fallbackSelectionFor.exclusionDurationMs);
            return true;
        }
    }

    public void release() {
        for (RepresentationHolder representationHolder : this.representationHolders) {
            ChunkExtractor chunkExtractor = representationHolder.chunkExtractor;
            if (chunkExtractor != null) {
                chunkExtractor.release();
            }
        }
    }

    private LoadErrorHandlingPolicy.FallbackOptions createFallbackOptions(ExoTrackSelection exoTrackSelection, List<BaseUrl> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (exoTrackSelection.isTrackExcluded(i2, elapsedRealtime)) {
                i++;
            }
        }
        int priorityCount = BaseUrlExclusionList.getPriorityCount(list);
        return new LoadErrorHandlingPolicy.FallbackOptions(priorityCount, priorityCount - this.baseUrlExclusionList.getPriorityCountAfterExclusion(list), length, i);
    }

    private long getSegmentNum(RepresentationHolder representationHolder, MediaChunk mediaChunk, long j, long j2, long j3) {
        if (mediaChunk != null) {
            return mediaChunk.getNextChunkIndex();
        }
        return Util.constrainValue(representationHolder.getSegmentNum(j), j2, j3);
    }

    private ArrayList<Representation> getRepresentations() {
        List<AdaptationSet> list = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i : this.adaptationSetIndices) {
            arrayList.addAll(list.get(i).representations);
        }
        return arrayList;
    }

    private long getAvailableLiveDurationUs(long j, long j2) {
        if (!this.manifest.dynamic || this.representationHolders[0].getSegmentCount() == 0) {
            return -9223372036854775807L;
        }
        return Math.max(0, Math.min(getNowPeriodTimeUs(j), this.representationHolders[0].getSegmentEndTimeUs(this.representationHolders[0].getLastAvailableSegmentNum(j))) - j2);
    }

    private long getNowPeriodTimeUs(long j) {
        if (this.manifest.availabilityStartTimeMs == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j - Util.msToUs(this.manifest.availabilityStartTimeMs + this.manifest.getPeriod(this.periodIndex).startMs);
    }

    /* access modifiers changed from: protected */
    public Chunk newInitializationChunk(RepresentationHolder representationHolder, DataSource dataSource2, Format format, int i, Object obj, RangedUri rangedUri, RangedUri rangedUri2, CmcdHeadersFactory cmcdHeadersFactory) {
        ImmutableMap<String, String> immutableMap;
        RepresentationHolder representationHolder2 = representationHolder;
        RangedUri rangedUri3 = rangedUri;
        CmcdHeadersFactory cmcdHeadersFactory2 = cmcdHeadersFactory;
        Representation representation = representationHolder2.representation;
        if (rangedUri3 != null) {
            RangedUri attemptMerge = rangedUri3.attemptMerge(rangedUri2, representationHolder2.selectedBaseUrl.url);
            if (attemptMerge != null) {
                rangedUri3 = attemptMerge;
            }
        } else {
            rangedUri3 = rangedUri2;
        }
        if (cmcdHeadersFactory2 == null) {
            immutableMap = ImmutableMap.of();
        } else {
            immutableMap = cmcdHeadersFactory2.setObjectType(CmcdHeadersFactory.OBJECT_TYPE_INIT_SEGMENT).createHttpRequestHeaders();
        }
        return new InitializationChunk(dataSource2, DashUtil.buildDataSpec(representation, representationHolder2.selectedBaseUrl.url, rangedUri3, 0, immutableMap), format, i, obj, representationHolder2.chunkExtractor);
    }

    /* access modifiers changed from: protected */
    public Chunk newMediaChunk(RepresentationHolder representationHolder, DataSource dataSource2, int i, Format format, int i2, Object obj, long j, int i3, long j2, long j3, CmcdHeadersFactory cmcdHeadersFactory) {
        ImmutableMap<String, String> immutableMap;
        ImmutableMap<String, String> immutableMap2;
        RepresentationHolder representationHolder2 = representationHolder;
        long j4 = j;
        long j5 = j3;
        CmcdHeadersFactory cmcdHeadersFactory2 = cmcdHeadersFactory;
        Representation representation = representationHolder2.representation;
        long segmentStartTimeUs = representationHolder2.getSegmentStartTimeUs(j4);
        RangedUri segmentUrl = representationHolder2.getSegmentUrl(j4);
        if (representationHolder2.chunkExtractor == null) {
            long segmentEndTimeUs = representationHolder2.getSegmentEndTimeUs(j4);
            int i4 = representationHolder2.isSegmentAvailableAtFullNetworkSpeed(j4, j5) ? 0 : 8;
            if (cmcdHeadersFactory2 == null) {
                immutableMap2 = ImmutableMap.of();
            } else {
                immutableMap2 = cmcdHeadersFactory2.setChunkDurationUs(segmentEndTimeUs - segmentStartTimeUs).setObjectType(CmcdHeadersFactory.getObjectType(this.trackSelection)).createHttpRequestHeaders();
            }
            return new SingleSampleMediaChunk(dataSource2, DashUtil.buildDataSpec(representation, representationHolder2.selectedBaseUrl.url, segmentUrl, i4, immutableMap2), format, i2, obj, segmentStartTimeUs, segmentEndTimeUs, j, i, format);
        }
        int i5 = 1;
        int i6 = i3;
        int i7 = 1;
        while (i5 < i6) {
            RangedUri attemptMerge = segmentUrl.attemptMerge(representationHolder2.getSegmentUrl(((long) i5) + j4), representationHolder2.selectedBaseUrl.url);
            if (attemptMerge == null) {
                break;
            }
            i7++;
            i5++;
            segmentUrl = attemptMerge;
        }
        long j6 = (((long) i7) + j4) - 1;
        long segmentEndTimeUs2 = representationHolder2.getSegmentEndTimeUs(j6);
        long access$000 = representationHolder.periodDurationUs;
        long j7 = (access$000 == -9223372036854775807L || access$000 > segmentEndTimeUs2) ? -9223372036854775807L : access$000;
        int i8 = representationHolder2.isSegmentAvailableAtFullNetworkSpeed(j6, j5) ? 0 : 8;
        if (cmcdHeadersFactory2 == null) {
            immutableMap = ImmutableMap.of();
        } else {
            immutableMap = cmcdHeadersFactory2.setChunkDurationUs(segmentEndTimeUs2 - segmentStartTimeUs).setObjectType(CmcdHeadersFactory.getObjectType(this.trackSelection)).createHttpRequestHeaders();
        }
        return new ContainerMediaChunk(dataSource2, DashUtil.buildDataSpec(representation, representationHolder2.selectedBaseUrl.url, segmentUrl, i8, immutableMap), format, i2, obj, segmentStartTimeUs, segmentEndTimeUs2, j2, j7, j, i7, -representation.presentationTimeOffsetUs, representationHolder2.chunkExtractor);
    }

    private RepresentationHolder updateSelectedBaseUrl(int i) {
        RepresentationHolder representationHolder = this.representationHolders[i];
        BaseUrl selectBaseUrl = this.baseUrlExclusionList.selectBaseUrl(representationHolder.representation.baseUrls);
        if (selectBaseUrl == null || selectBaseUrl.equals(representationHolder.selectedBaseUrl)) {
            return representationHolder;
        }
        RepresentationHolder copyWithNewSelectedBaseUrl = representationHolder.copyWithNewSelectedBaseUrl(selectBaseUrl);
        this.representationHolders[i] = copyWithNewSelectedBaseUrl;
        return copyWithNewSelectedBaseUrl;
    }

    protected static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {
        private final long nowPeriodTimeUs;
        private final RepresentationHolder representationHolder;

        public RepresentationSegmentIterator(RepresentationHolder representationHolder2, long j, long j2, long j3) {
            super(j, j2);
            this.representationHolder = representationHolder2;
            this.nowPeriodTimeUs = j3;
        }

        public DataSpec getDataSpec() {
            checkInBounds();
            long currentIndex = getCurrentIndex();
            return DashUtil.buildDataSpec(this.representationHolder.representation, this.representationHolder.selectedBaseUrl.url, this.representationHolder.getSegmentUrl(currentIndex), this.representationHolder.isSegmentAvailableAtFullNetworkSpeed(currentIndex, this.nowPeriodTimeUs) ? 0 : 8, ImmutableMap.of());
        }

        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentStartTimeUs(getCurrentIndex());
        }

        public long getChunkEndTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentEndTimeUs(getCurrentIndex());
        }
    }

    protected static final class RepresentationHolder {
        final ChunkExtractor chunkExtractor;
        /* access modifiers changed from: private */
        public final long periodDurationUs;
        public final Representation representation;
        public final DashSegmentIndex segmentIndex;
        private final long segmentNumShift;
        public final BaseUrl selectedBaseUrl;

        RepresentationHolder(long j, Representation representation2, BaseUrl baseUrl, ChunkExtractor chunkExtractor2, long j2, DashSegmentIndex dashSegmentIndex) {
            this.periodDurationUs = j;
            this.representation = representation2;
            this.selectedBaseUrl = baseUrl;
            this.segmentNumShift = j2;
            this.chunkExtractor = chunkExtractor2;
            this.segmentIndex = dashSegmentIndex;
        }

        /* access modifiers changed from: package-private */
        public RepresentationHolder copyWithNewRepresentation(long j, Representation representation2) throws BehindLiveWindowException {
            long segmentNum;
            long segmentNum2;
            long j2 = j;
            DashSegmentIndex index = this.representation.getIndex();
            DashSegmentIndex index2 = representation2.getIndex();
            if (index == null) {
                return new RepresentationHolder(j, representation2, this.selectedBaseUrl, this.chunkExtractor, this.segmentNumShift, index);
            } else if (!index.isExplicit()) {
                return new RepresentationHolder(j, representation2, this.selectedBaseUrl, this.chunkExtractor, this.segmentNumShift, index2);
            } else {
                long segmentCount = index.getSegmentCount(j2);
                if (segmentCount == 0) {
                    return new RepresentationHolder(j, representation2, this.selectedBaseUrl, this.chunkExtractor, this.segmentNumShift, index2);
                }
                long firstSegmentNum = index.getFirstSegmentNum();
                long timeUs = index.getTimeUs(firstSegmentNum);
                long j3 = (segmentCount + firstSegmentNum) - 1;
                long timeUs2 = index.getTimeUs(j3) + index.getDurationUs(j3, j2);
                long firstSegmentNum2 = index2.getFirstSegmentNum();
                DashSegmentIndex dashSegmentIndex = index;
                long timeUs3 = index2.getTimeUs(firstSegmentNum2);
                long j4 = firstSegmentNum;
                long j5 = this.segmentNumShift;
                if (timeUs2 == timeUs3) {
                    segmentNum = j3 + 1;
                } else if (timeUs2 < timeUs3) {
                    throw new BehindLiveWindowException();
                } else if (timeUs3 < timeUs) {
                    segmentNum2 = j5 - (index2.getSegmentNum(timeUs, j2) - j4);
                    return new RepresentationHolder(j, representation2, this.selectedBaseUrl, this.chunkExtractor, segmentNum2, index2);
                } else {
                    segmentNum = dashSegmentIndex.getSegmentNum(timeUs3, j2);
                }
                segmentNum2 = j5 + (segmentNum - firstSegmentNum2);
                return new RepresentationHolder(j, representation2, this.selectedBaseUrl, this.chunkExtractor, segmentNum2, index2);
            }
        }

        /* access modifiers changed from: package-private */
        public RepresentationHolder copyWithNewSegmentIndex(DashSegmentIndex dashSegmentIndex) {
            return new RepresentationHolder(this.periodDurationUs, this.representation, this.selectedBaseUrl, this.chunkExtractor, this.segmentNumShift, dashSegmentIndex);
        }

        /* access modifiers changed from: package-private */
        public RepresentationHolder copyWithNewSelectedBaseUrl(BaseUrl baseUrl) {
            return new RepresentationHolder(this.periodDurationUs, this.representation, baseUrl, this.chunkExtractor, this.segmentNumShift, this.segmentIndex);
        }

        public long getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.segmentNumShift;
        }

        public long getFirstAvailableSegmentNum(long j) {
            return this.segmentIndex.getFirstAvailableSegmentNum(this.periodDurationUs, j) + this.segmentNumShift;
        }

        public long getSegmentCount() {
            return this.segmentIndex.getSegmentCount(this.periodDurationUs);
        }

        public long getSegmentStartTimeUs(long j) {
            return this.segmentIndex.getTimeUs(j - this.segmentNumShift);
        }

        public long getSegmentEndTimeUs(long j) {
            return getSegmentStartTimeUs(j) + this.segmentIndex.getDurationUs(j - this.segmentNumShift, this.periodDurationUs);
        }

        public long getSegmentNum(long j) {
            return this.segmentIndex.getSegmentNum(j, this.periodDurationUs) + this.segmentNumShift;
        }

        public RangedUri getSegmentUrl(long j) {
            return this.segmentIndex.getSegmentUrl(j - this.segmentNumShift);
        }

        public long getLastAvailableSegmentNum(long j) {
            return (getFirstAvailableSegmentNum(j) + this.segmentIndex.getAvailableSegmentCount(this.periodDurationUs, j)) - 1;
        }

        public boolean isSegmentAvailableAtFullNetworkSpeed(long j, long j2) {
            if (!this.segmentIndex.isExplicit() && j2 != -9223372036854775807L && getSegmentEndTimeUs(j) > j2) {
                return false;
            }
            return true;
        }
    }
}
