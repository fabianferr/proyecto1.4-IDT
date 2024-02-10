package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.RendererCapabilities;
import com.mbridge.msdk.playercommon.exoplayer2.RendererConfiguration;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.Arrays;

public abstract class MappingTrackSelector extends TrackSelector {
    private MappedTrackInfo currentMappedTrackInfo;

    /* access modifiers changed from: protected */
    public abstract Pair<RendererConfiguration[], TrackSelection[]> selectTracks(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws ExoPlaybackException;

    public static final class MappedTrackInfo {
        public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
        public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
        public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
        public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;
        public final int length;
        private final int rendererCount;
        private final int[][][] rendererFormatSupports;
        private final int[] rendererMixedMimeTypeAdaptiveSupports;
        private final TrackGroupArray[] rendererTrackGroups;
        private final int[] rendererTrackTypes;
        private final TrackGroupArray unmappedTrackGroups;

        @interface RendererSupport {
        }

        MappedTrackInfo(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.rendererTrackTypes = iArr;
            this.rendererTrackGroups = trackGroupArrayArr;
            this.rendererFormatSupports = iArr3;
            this.rendererMixedMimeTypeAdaptiveSupports = iArr2;
            this.unmappedTrackGroups = trackGroupArray;
            int length2 = iArr.length;
            this.rendererCount = length2;
            this.length = length2;
        }

        public final int getRendererCount() {
            return this.rendererCount;
        }

        public final int getRendererType(int i) {
            return this.rendererTrackTypes[i];
        }

        public final TrackGroupArray getTrackGroups(int i) {
            return this.rendererTrackGroups[i];
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            r1 = r1 + 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int getRendererSupport(int r8) {
            /*
                r7 = this;
                int[][][] r0 = r7.rendererFormatSupports
                r8 = r0[r8]
                r0 = 0
                r1 = 0
                r2 = 0
            L_0x0007:
                int r3 = r8.length
                if (r1 >= r3) goto L_0x0028
                r3 = 0
            L_0x000b:
                r4 = r8[r1]
                int r5 = r4.length
                if (r3 >= r5) goto L_0x0025
                r4 = r4[r3]
                r4 = r4 & 7
                r5 = 3
                if (r4 == r5) goto L_0x001d
                r6 = 4
                if (r4 == r6) goto L_0x001c
                r4 = 1
                goto L_0x001e
            L_0x001c:
                return r5
            L_0x001d:
                r4 = 2
            L_0x001e:
                int r2 = java.lang.Math.max(r2, r4)
                int r3 = r3 + 1
                goto L_0x000b
            L_0x0025:
                int r1 = r1 + 1
                goto L_0x0007
            L_0x0028:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo.getRendererSupport(int):int");
        }

        public final int getTrackTypeRendererSupport(int i) {
            return getTypeSupport(i);
        }

        public final int getTypeSupport(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.rendererCount; i3++) {
                if (this.rendererTrackTypes[i3] == i) {
                    i2 = Math.max(i2, getRendererSupport(i3));
                }
            }
            return i2;
        }

        public final int getTrackFormatSupport(int i, int i2, int i3) {
            return getTrackSupport(i, i2, i3);
        }

        public final int getTrackSupport(int i, int i2, int i3) {
            return this.rendererFormatSupports[i][i2][i3] & 7;
        }

        public final int getAdaptiveSupport(int i, int i2, boolean z) {
            int i3 = this.rendererTrackGroups[i].get(i2).length;
            int[] iArr = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int trackSupport = getTrackSupport(i, i2, i5);
                if (trackSupport == 4 || (z && trackSupport == 3)) {
                    iArr[i4] = i5;
                    i4++;
                }
            }
            return getAdaptiveSupport(i, i2, Arrays.copyOf(iArr, i4));
        }

        public final int getAdaptiveSupport(int i, int i2, int[] iArr) {
            int i3 = 0;
            String str = null;
            boolean z = false;
            int i4 = 0;
            int i5 = 16;
            while (i3 < iArr.length) {
                String str2 = this.rendererTrackGroups[i].get(i2).getFormat(iArr[i3]).sampleMimeType;
                int i6 = i4 + 1;
                if (i4 == 0) {
                    str = str2;
                } else {
                    z |= !Util.areEqual(str, str2);
                }
                i5 = Math.min(i5, this.rendererFormatSupports[i][i2][i3] & 24);
                i3++;
                i4 = i6;
            }
            return z ? Math.min(i5, this.rendererMixedMimeTypeAdaptiveSupports[i]) : i5;
        }

        public final TrackGroupArray getUnassociatedTrackGroups() {
            return getUnmappedTrackGroups();
        }

        public final TrackGroupArray getUnmappedTrackGroups() {
            return this.unmappedTrackGroups;
        }
    }

    public final MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.currentMappedTrackInfo;
    }

    public final void onSelectionActivated(Object obj) {
        this.currentMappedTrackInfo = (MappedTrackInfo) obj;
    }

    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray) throws ExoPlaybackException {
        int[] iArr;
        int[] iArr2 = new int[(rendererCapabilitiesArr.length + 1)];
        int length = rendererCapabilitiesArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr3 = new int[(rendererCapabilitiesArr.length + 1)][][];
        for (int i = 0; i < length; i++) {
            trackGroupArr[i] = new TrackGroup[trackGroupArray.length];
            iArr3[i] = new int[trackGroupArray.length][];
        }
        int[] mixedMimeTypeAdaptationSupports = getMixedMimeTypeAdaptationSupports(rendererCapabilitiesArr);
        for (int i2 = 0; i2 < trackGroupArray.length; i2++) {
            TrackGroup trackGroup = trackGroupArray.get(i2);
            int findRenderer = findRenderer(rendererCapabilitiesArr, trackGroup);
            if (findRenderer == rendererCapabilitiesArr.length) {
                iArr = new int[trackGroup.length];
            } else {
                iArr = getFormatSupport(rendererCapabilitiesArr[findRenderer], trackGroup);
            }
            int i3 = iArr2[findRenderer];
            trackGroupArr[findRenderer][i3] = trackGroup;
            iArr3[findRenderer][i3] = iArr;
            iArr2[findRenderer] = i3 + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
        int[] iArr4 = new int[rendererCapabilitiesArr.length];
        for (int i4 = 0; i4 < rendererCapabilitiesArr.length; i4++) {
            int i5 = iArr2[i4];
            trackGroupArrayArr[i4] = new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[i4], i5));
            iArr3[i4] = (int[][]) Util.nullSafeArrayCopy(iArr3[i4], i5);
            iArr4[i4] = rendererCapabilitiesArr[i4].getTrackType();
        }
        int[] iArr5 = mixedMimeTypeAdaptationSupports;
        int[][][] iArr6 = iArr3;
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(iArr4, trackGroupArrayArr, iArr5, iArr6, new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[rendererCapabilitiesArr.length], iArr2[rendererCapabilitiesArr.length])));
        Pair<RendererConfiguration[], TrackSelection[]> selectTracks = selectTracks(mappedTrackInfo, iArr3, mixedMimeTypeAdaptationSupports);
        return new TrackSelectorResult((RendererConfiguration[]) selectTracks.first, (TrackSelection[]) selectTracks.second, mappedTrackInfo);
    }

    private static int findRenderer(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int i = 0;
        for (int i2 = 0; i2 < rendererCapabilitiesArr.length; i2++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i2];
            for (int i3 = 0; i3 < trackGroup.length; i3++) {
                int supportsFormat = rendererCapabilities.supportsFormat(trackGroup.getFormat(i3)) & 7;
                if (supportsFormat > i) {
                    if (supportsFormat == 4) {
                        return i2;
                    }
                    length = i2;
                    i = supportsFormat;
                }
            }
        }
        return length;
    }

    private static int[] getFormatSupport(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.length];
        for (int i = 0; i < trackGroup.length; i++) {
            iArr[i] = rendererCapabilities.supportsFormat(trackGroup.getFormat(i));
        }
        return iArr;
    }

    private static int[] getMixedMimeTypeAdaptationSupports(RendererCapabilities[] rendererCapabilitiesArr) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = rendererCapabilitiesArr[i].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }
}
