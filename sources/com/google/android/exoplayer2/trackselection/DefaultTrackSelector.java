package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultTrackSelector extends MappingTrackSelector {
    /* access modifiers changed from: private */
    public static final Ordering<Integer> FORMAT_VALUE_ORDERING = Ordering.from(new DefaultTrackSelector$$ExternalSyntheticLambda0());
    private static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    /* access modifiers changed from: private */
    public static final Ordering<Integer> NO_ORDER = Ordering.from(new DefaultTrackSelector$$ExternalSyntheticLambda1());
    private static final int[] NO_TRACKS = new int[0];
    private final AtomicReference<Parameters> parametersReference;
    private final ExoTrackSelection.Factory trackSelectionFactory;

    static /* synthetic */ int lambda$static$1(Integer num, Integer num2) {
        return 0;
    }

    public static final class ParametersBuilder extends TrackSelectionParameters.Builder {
        /* access modifiers changed from: private */
        public boolean allowAudioMixedChannelCountAdaptiveness;
        /* access modifiers changed from: private */
        public boolean allowAudioMixedMimeTypeAdaptiveness;
        /* access modifiers changed from: private */
        public boolean allowAudioMixedSampleRateAdaptiveness;
        /* access modifiers changed from: private */
        public boolean allowMultipleAdaptiveSelections;
        /* access modifiers changed from: private */
        public boolean allowVideoMixedMimeTypeAdaptiveness;
        /* access modifiers changed from: private */
        public boolean allowVideoNonSeamlessAdaptiveness;
        /* access modifiers changed from: private */
        public int disabledTextTrackSelectionFlags;
        /* access modifiers changed from: private */
        public boolean exceedAudioConstraintsIfNecessary;
        /* access modifiers changed from: private */
        public boolean exceedRendererCapabilitiesIfNecessary;
        /* access modifiers changed from: private */
        public boolean exceedVideoConstraintsIfNecessary;
        /* access modifiers changed from: private */
        public final SparseBooleanArray rendererDisabledFlags;
        /* access modifiers changed from: private */
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        /* access modifiers changed from: private */
        public boolean tunnelingEnabled;

        @Deprecated
        public ParametersBuilder() {
            this.selectionOverrides = new SparseArray<>();
            this.rendererDisabledFlags = new SparseBooleanArray();
            init();
        }

        public ParametersBuilder(Context context) {
            super(context);
            this.selectionOverrides = new SparseArray<>();
            this.rendererDisabledFlags = new SparseBooleanArray();
            init();
        }

        private ParametersBuilder(Parameters parameters) {
            super((TrackSelectionParameters) parameters);
            this.disabledTextTrackSelectionFlags = parameters.disabledTextTrackSelectionFlags;
            this.exceedVideoConstraintsIfNecessary = parameters.exceedVideoConstraintsIfNecessary;
            this.allowVideoMixedMimeTypeAdaptiveness = parameters.allowVideoMixedMimeTypeAdaptiveness;
            this.allowVideoNonSeamlessAdaptiveness = parameters.allowVideoNonSeamlessAdaptiveness;
            this.exceedAudioConstraintsIfNecessary = parameters.exceedAudioConstraintsIfNecessary;
            this.allowAudioMixedMimeTypeAdaptiveness = parameters.allowAudioMixedMimeTypeAdaptiveness;
            this.allowAudioMixedSampleRateAdaptiveness = parameters.allowAudioMixedSampleRateAdaptiveness;
            this.allowAudioMixedChannelCountAdaptiveness = parameters.allowAudioMixedChannelCountAdaptiveness;
            this.exceedRendererCapabilitiesIfNecessary = parameters.exceedRendererCapabilitiesIfNecessary;
            this.tunnelingEnabled = parameters.tunnelingEnabled;
            this.allowMultipleAdaptiveSelections = parameters.allowMultipleAdaptiveSelections;
            this.selectionOverrides = cloneSelectionOverrides(parameters.selectionOverrides);
            this.rendererDisabledFlags = parameters.rendererDisabledFlags.clone();
        }

        public ParametersBuilder setMaxVideoSizeSd() {
            super.setMaxVideoSizeSd();
            return this;
        }

        public ParametersBuilder clearVideoSizeConstraints() {
            super.clearVideoSizeConstraints();
            return this;
        }

        public ParametersBuilder setMaxVideoSize(int i, int i2) {
            super.setMaxVideoSize(i, i2);
            return this;
        }

        public ParametersBuilder setMaxVideoFrameRate(int i) {
            super.setMaxVideoFrameRate(i);
            return this;
        }

        public ParametersBuilder setMaxVideoBitrate(int i) {
            super.setMaxVideoBitrate(i);
            return this;
        }

        public ParametersBuilder setMinVideoSize(int i, int i2) {
            super.setMinVideoSize(i, i2);
            return this;
        }

        public ParametersBuilder setMinVideoFrameRate(int i) {
            super.setMinVideoFrameRate(i);
            return this;
        }

        public ParametersBuilder setMinVideoBitrate(int i) {
            super.setMinVideoBitrate(i);
            return this;
        }

        public ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean z) {
            this.exceedVideoConstraintsIfNecessary = z;
            return this;
        }

        public ParametersBuilder setAllowVideoMixedMimeTypeAdaptiveness(boolean z) {
            this.allowVideoMixedMimeTypeAdaptiveness = z;
            return this;
        }

        public ParametersBuilder setAllowVideoNonSeamlessAdaptiveness(boolean z) {
            this.allowVideoNonSeamlessAdaptiveness = z;
            return this;
        }

        public ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context, boolean z) {
            super.setViewportSizeToPhysicalDisplaySize(context, z);
            return this;
        }

        public ParametersBuilder clearViewportSizeConstraints() {
            super.clearViewportSizeConstraints();
            return this;
        }

        public ParametersBuilder setViewportSize(int i, int i2, boolean z) {
            super.setViewportSize(i, i2, z);
            return this;
        }

        public ParametersBuilder setPreferredVideoMimeType(String str) {
            super.setPreferredVideoMimeType(str);
            return this;
        }

        public ParametersBuilder setPreferredVideoMimeTypes(String... strArr) {
            super.setPreferredVideoMimeTypes(strArr);
            return this;
        }

        public ParametersBuilder setPreferredAudioLanguage(String str) {
            super.setPreferredAudioLanguage(str);
            return this;
        }

        public ParametersBuilder setPreferredAudioLanguages(String... strArr) {
            super.setPreferredAudioLanguages(strArr);
            return this;
        }

        public ParametersBuilder setPreferredAudioRoleFlags(int i) {
            super.setPreferredAudioRoleFlags(i);
            return this;
        }

        public ParametersBuilder setMaxAudioChannelCount(int i) {
            super.setMaxAudioChannelCount(i);
            return this;
        }

        public ParametersBuilder setMaxAudioBitrate(int i) {
            super.setMaxAudioBitrate(i);
            return this;
        }

        public ParametersBuilder setExceedAudioConstraintsIfNecessary(boolean z) {
            this.exceedAudioConstraintsIfNecessary = z;
            return this;
        }

        public ParametersBuilder setAllowAudioMixedMimeTypeAdaptiveness(boolean z) {
            this.allowAudioMixedMimeTypeAdaptiveness = z;
            return this;
        }

        public ParametersBuilder setAllowAudioMixedSampleRateAdaptiveness(boolean z) {
            this.allowAudioMixedSampleRateAdaptiveness = z;
            return this;
        }

        public ParametersBuilder setAllowAudioMixedChannelCountAdaptiveness(boolean z) {
            this.allowAudioMixedChannelCountAdaptiveness = z;
            return this;
        }

        public ParametersBuilder setPreferredAudioMimeType(String str) {
            super.setPreferredAudioMimeType(str);
            return this;
        }

        public ParametersBuilder setPreferredAudioMimeTypes(String... strArr) {
            super.setPreferredAudioMimeTypes(strArr);
            return this;
        }

        public ParametersBuilder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            super.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            return this;
        }

        public ParametersBuilder setPreferredTextLanguage(String str) {
            super.setPreferredTextLanguage(str);
            return this;
        }

        public ParametersBuilder setPreferredTextLanguages(String... strArr) {
            super.setPreferredTextLanguages(strArr);
            return this;
        }

        public ParametersBuilder setPreferredTextRoleFlags(int i) {
            super.setPreferredTextRoleFlags(i);
            return this;
        }

        public ParametersBuilder setSelectUndeterminedTextLanguage(boolean z) {
            super.setSelectUndeterminedTextLanguage(z);
            return this;
        }

        public ParametersBuilder setDisabledTextTrackSelectionFlags(int i) {
            this.disabledTextTrackSelectionFlags = i;
            return this;
        }

        public ParametersBuilder setForceLowestBitrate(boolean z) {
            super.setForceLowestBitrate(z);
            return this;
        }

        public ParametersBuilder setForceHighestSupportedBitrate(boolean z) {
            super.setForceHighestSupportedBitrate(z);
            return this;
        }

        public ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean z) {
            this.exceedRendererCapabilitiesIfNecessary = z;
            return this;
        }

        public ParametersBuilder setTunnelingEnabled(boolean z) {
            this.tunnelingEnabled = z;
            return this;
        }

        public ParametersBuilder setAllowMultipleAdaptiveSelections(boolean z) {
            this.allowMultipleAdaptiveSelections = z;
            return this;
        }

        public final ParametersBuilder setRendererDisabled(int i, boolean z) {
            if (this.rendererDisabledFlags.get(i) == z) {
                return this;
            }
            if (z) {
                this.rendererDisabledFlags.put(i, true);
            } else {
                this.rendererDisabledFlags.delete(i);
            }
            return this;
        }

        public final ParametersBuilder setSelectionOverride(int i, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
            Map map = this.selectionOverrides.get(i);
            if (map == null) {
                map = new HashMap();
                this.selectionOverrides.put(i, map);
            }
            if (map.containsKey(trackGroupArray) && Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
                return this;
            }
            map.put(trackGroupArray, selectionOverride);
            return this;
        }

        public final ParametersBuilder clearSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i);
            if (map != null && map.containsKey(trackGroupArray)) {
                map.remove(trackGroupArray);
                if (map.isEmpty()) {
                    this.selectionOverrides.remove(i);
                }
            }
            return this;
        }

        public final ParametersBuilder clearSelectionOverrides(int i) {
            Map map = this.selectionOverrides.get(i);
            if (map != null && !map.isEmpty()) {
                this.selectionOverrides.remove(i);
            }
            return this;
        }

        public final ParametersBuilder clearSelectionOverrides() {
            if (this.selectionOverrides.size() == 0) {
                return this;
            }
            this.selectionOverrides.clear();
            return this;
        }

        public Parameters build() {
            return new Parameters(this);
        }

        private void init() {
            this.exceedVideoConstraintsIfNecessary = true;
            this.allowVideoMixedMimeTypeAdaptiveness = false;
            this.allowVideoNonSeamlessAdaptiveness = true;
            this.exceedAudioConstraintsIfNecessary = true;
            this.allowAudioMixedMimeTypeAdaptiveness = false;
            this.allowAudioMixedSampleRateAdaptiveness = false;
            this.allowAudioMixedChannelCountAdaptiveness = false;
            this.disabledTextTrackSelectionFlags = 0;
            this.exceedRendererCapabilitiesIfNecessary = true;
            this.tunnelingEnabled = false;
            this.allowMultipleAdaptiveSelections = true;
        }

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> cloneSelectionOverrides(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
            for (int i = 0; i < sparseArray.size(); i++) {
                sparseArray2.put(sparseArray.keyAt(i), new HashMap(sparseArray.valueAt(i)));
            }
            return sparseArray2;
        }
    }

    public static final class Parameters extends TrackSelectionParameters implements Parcelable {
        public static final Parcelable.Creator<Parameters> CREATOR = new Parcelable.Creator<Parameters>() {
            public Parameters createFromParcel(Parcel parcel) {
                return new Parameters(parcel);
            }

            public Parameters[] newArray(int i) {
                return new Parameters[i];
            }
        };
        @Deprecated
        public static final Parameters DEFAULT;
        public static final Parameters DEFAULT_WITHOUT_CONTEXT;
        public final boolean allowAudioMixedChannelCountAdaptiveness;
        public final boolean allowAudioMixedMimeTypeAdaptiveness;
        public final boolean allowAudioMixedSampleRateAdaptiveness;
        public final boolean allowMultipleAdaptiveSelections;
        public final boolean allowVideoMixedMimeTypeAdaptiveness;
        public final boolean allowVideoNonSeamlessAdaptiveness;
        public final int disabledTextTrackSelectionFlags;
        public final boolean exceedAudioConstraintsIfNecessary;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        /* access modifiers changed from: private */
        public final SparseBooleanArray rendererDisabledFlags;
        /* access modifiers changed from: private */
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        public final boolean tunnelingEnabled;

        public int describeContents() {
            return 0;
        }

        static {
            Parameters build = new ParametersBuilder().build();
            DEFAULT_WITHOUT_CONTEXT = build;
            DEFAULT = build;
        }

        public static Parameters getDefaults(Context context) {
            return new ParametersBuilder(context).build();
        }

        private Parameters(ParametersBuilder parametersBuilder) {
            super((TrackSelectionParameters.Builder) parametersBuilder);
            this.exceedVideoConstraintsIfNecessary = parametersBuilder.exceedVideoConstraintsIfNecessary;
            this.allowVideoMixedMimeTypeAdaptiveness = parametersBuilder.allowVideoMixedMimeTypeAdaptiveness;
            this.allowVideoNonSeamlessAdaptiveness = parametersBuilder.allowVideoNonSeamlessAdaptiveness;
            this.exceedAudioConstraintsIfNecessary = parametersBuilder.exceedAudioConstraintsIfNecessary;
            this.allowAudioMixedMimeTypeAdaptiveness = parametersBuilder.allowAudioMixedMimeTypeAdaptiveness;
            this.allowAudioMixedSampleRateAdaptiveness = parametersBuilder.allowAudioMixedSampleRateAdaptiveness;
            this.allowAudioMixedChannelCountAdaptiveness = parametersBuilder.allowAudioMixedChannelCountAdaptiveness;
            this.disabledTextTrackSelectionFlags = parametersBuilder.disabledTextTrackSelectionFlags;
            this.exceedRendererCapabilitiesIfNecessary = parametersBuilder.exceedRendererCapabilitiesIfNecessary;
            this.tunnelingEnabled = parametersBuilder.tunnelingEnabled;
            this.allowMultipleAdaptiveSelections = parametersBuilder.allowMultipleAdaptiveSelections;
            this.selectionOverrides = parametersBuilder.selectionOverrides;
            this.rendererDisabledFlags = parametersBuilder.rendererDisabledFlags;
        }

        Parameters(Parcel parcel) {
            super(parcel);
            this.exceedVideoConstraintsIfNecessary = Util.readBoolean(parcel);
            this.allowVideoMixedMimeTypeAdaptiveness = Util.readBoolean(parcel);
            this.allowVideoNonSeamlessAdaptiveness = Util.readBoolean(parcel);
            this.exceedAudioConstraintsIfNecessary = Util.readBoolean(parcel);
            this.allowAudioMixedMimeTypeAdaptiveness = Util.readBoolean(parcel);
            this.allowAudioMixedSampleRateAdaptiveness = Util.readBoolean(parcel);
            this.allowAudioMixedChannelCountAdaptiveness = Util.readBoolean(parcel);
            this.disabledTextTrackSelectionFlags = parcel.readInt();
            this.exceedRendererCapabilitiesIfNecessary = Util.readBoolean(parcel);
            this.tunnelingEnabled = Util.readBoolean(parcel);
            this.allowMultipleAdaptiveSelections = Util.readBoolean(parcel);
            this.selectionOverrides = readSelectionOverrides(parcel);
            this.rendererDisabledFlags = (SparseBooleanArray) Util.castNonNull(parcel.readSparseBooleanArray());
        }

        public final boolean getRendererDisabled(int i) {
            return this.rendererDisabledFlags.get(i);
        }

        public final boolean hasSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i);
            return map != null && map.containsKey(trackGroupArray);
        }

        public final SelectionOverride getSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i);
            if (map != null) {
                return (SelectionOverride) map.get(trackGroupArray);
            }
            return null;
        }

        public ParametersBuilder buildUpon() {
            return new ParametersBuilder(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            if (super.equals(parameters) && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.allowVideoMixedMimeTypeAdaptiveness == parameters.allowVideoMixedMimeTypeAdaptiveness && this.allowVideoNonSeamlessAdaptiveness == parameters.allowVideoNonSeamlessAdaptiveness && this.exceedAudioConstraintsIfNecessary == parameters.exceedAudioConstraintsIfNecessary && this.allowAudioMixedMimeTypeAdaptiveness == parameters.allowAudioMixedMimeTypeAdaptiveness && this.allowAudioMixedSampleRateAdaptiveness == parameters.allowAudioMixedSampleRateAdaptiveness && this.allowAudioMixedChannelCountAdaptiveness == parameters.allowAudioMixedChannelCountAdaptiveness && this.disabledTextTrackSelectionFlags == parameters.disabledTextTrackSelectionFlags && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.tunnelingEnabled == parameters.tunnelingEnabled && this.allowMultipleAdaptiveSelections == parameters.allowMultipleAdaptiveSelections && areRendererDisabledFlagsEqual(this.rendererDisabledFlags, parameters.rendererDisabledFlags) && areSelectionOverridesEqual(this.selectionOverrides, parameters.selectionOverrides)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) * 31) + (this.exceedAudioConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) * 31) + this.disabledTextTrackSelectionFlags) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.tunnelingEnabled ? 1 : 0)) * 31) + (this.allowMultipleAdaptiveSelections ? 1 : 0);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            Util.writeBoolean(parcel, this.exceedVideoConstraintsIfNecessary);
            Util.writeBoolean(parcel, this.allowVideoMixedMimeTypeAdaptiveness);
            Util.writeBoolean(parcel, this.allowVideoNonSeamlessAdaptiveness);
            Util.writeBoolean(parcel, this.exceedAudioConstraintsIfNecessary);
            Util.writeBoolean(parcel, this.allowAudioMixedMimeTypeAdaptiveness);
            Util.writeBoolean(parcel, this.allowAudioMixedSampleRateAdaptiveness);
            Util.writeBoolean(parcel, this.allowAudioMixedChannelCountAdaptiveness);
            parcel.writeInt(this.disabledTextTrackSelectionFlags);
            Util.writeBoolean(parcel, this.exceedRendererCapabilitiesIfNecessary);
            Util.writeBoolean(parcel, this.tunnelingEnabled);
            Util.writeBoolean(parcel, this.allowMultipleAdaptiveSelections);
            writeSelectionOverridesToParcel(parcel, this.selectionOverrides);
            parcel.writeSparseBooleanArray(this.rendererDisabledFlags);
        }

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> readSelectionOverrides(Parcel parcel) {
            int readInt = parcel.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                for (int i2 = 0; i2 < readInt3; i2++) {
                    hashMap.put((TrackGroupArray) Assertions.checkNotNull((TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader())), (SelectionOverride) parcel.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            return sparseArray;
        }

        private static void writeSelectionOverridesToParcel(Parcel parcel, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                int keyAt = sparseArray.keyAt(i);
                Map valueAt = sparseArray.valueAt(i);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry entry : valueAt.entrySet()) {
                    parcel.writeParcelable((Parcelable) entry.getKey(), 0);
                    parcel.writeParcelable((Parcelable) entry.getValue(), 0);
                }
            }
        }

        private static boolean areRendererDisabledFlagsEqual(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (indexOfKey < 0 || !areSelectionOverridesEqual(sparseArray.valueAt(i), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean areSelectionOverridesEqual(java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r4, java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r5) {
            /*
                int r0 = r4.size()
                int r1 = r5.size()
                r2 = 0
                if (r1 == r0) goto L_0x000c
                return r2
            L_0x000c:
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x0014:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = r4.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getKey()
                com.google.android.exoplayer2.source.TrackGroupArray r1 = (com.google.android.exoplayer2.source.TrackGroupArray) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L_0x003a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = com.google.android.exoplayer2.util.Util.areEqual(r0, r1)
                if (r0 != 0) goto L_0x0014
            L_0x003a:
                return r2
            L_0x003b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.areSelectionOverridesEqual(java.util.Map, java.util.Map):boolean");
        }
    }

    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new Parcelable.Creator<SelectionOverride>() {
            public SelectionOverride createFromParcel(Parcel parcel) {
                return new SelectionOverride(parcel);
            }

            public SelectionOverride[] newArray(int i) {
                return new SelectionOverride[i];
            }
        };
        public final int groupIndex;
        public final int length;
        public final int[] tracks;
        public final int type;

        public int describeContents() {
            return 0;
        }

        public SelectionOverride(int i, int... iArr) {
            this(i, iArr, 0);
        }

        public SelectionOverride(int i, int[] iArr, int i2) {
            this.groupIndex = i;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.tracks = copyOf;
            this.length = iArr.length;
            this.type = i2;
            Arrays.sort(copyOf);
        }

        SelectionOverride(Parcel parcel) {
            this.groupIndex = parcel.readInt();
            int readByte = parcel.readByte();
            this.length = readByte;
            int[] iArr = new int[readByte];
            this.tracks = iArr;
            parcel.readIntArray(iArr);
            this.type = parcel.readInt();
        }

        public boolean containsTrack(int i) {
            for (int i2 : this.tracks) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.groupIndex * 31) + Arrays.hashCode(this.tracks)) * 31) + this.type;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            if (this.groupIndex == selectionOverride.groupIndex && Arrays.equals(this.tracks, selectionOverride.tracks) && this.type == selectionOverride.type) {
                return true;
            }
            return false;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.groupIndex);
            parcel.writeInt(this.tracks.length);
            parcel.writeIntArray(this.tracks);
            parcel.writeInt(this.type);
        }
    }

    static /* synthetic */ int lambda$static$0(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            if (num2.intValue() == -1) {
                return 0;
            }
            return -1;
        } else if (num2.intValue() == -1) {
            return 1;
        } else {
            return num.intValue() - num2.intValue();
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this(Parameters.DEFAULT_WITHOUT_CONTEXT, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    @Deprecated
    public DefaultTrackSelector(ExoTrackSelection.Factory factory) {
        this(Parameters.DEFAULT_WITHOUT_CONTEXT, factory);
    }

    public DefaultTrackSelector(Context context) {
        this(context, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(Context context, ExoTrackSelection.Factory factory) {
        this(Parameters.getDefaults(context), factory);
    }

    public DefaultTrackSelector(Parameters parameters, ExoTrackSelection.Factory factory) {
        this.trackSelectionFactory = factory;
        this.parametersReference = new AtomicReference<>(parameters);
    }

    public void setParameters(Parameters parameters) {
        Assertions.checkNotNull(parameters);
        if (!this.parametersReference.getAndSet(parameters).equals(parameters)) {
            invalidate();
        }
    }

    public void setParameters(ParametersBuilder parametersBuilder) {
        setParameters(parametersBuilder.build());
    }

    public Parameters getParameters() {
        return this.parametersReference.get();
    }

    public ParametersBuilder buildUponParameters() {
        return getParameters().buildUpon();
    }

    /* access modifiers changed from: protected */
    public final Pair<RendererConfiguration[], ExoTrackSelection[]> selectTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        Parameters parameters = this.parametersReference.get();
        int rendererCount = mappedTrackInfo.getRendererCount();
        ExoTrackSelection.Definition[] selectAllTracks = selectAllTracks(mappedTrackInfo, iArr, iArr2, parameters);
        int i = 0;
        while (true) {
            ExoTrackSelection.Definition definition = null;
            if (i >= rendererCount) {
                break;
            }
            if (parameters.getRendererDisabled(i)) {
                selectAllTracks[i] = null;
            } else {
                TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i);
                if (parameters.hasSelectionOverride(i, trackGroups)) {
                    SelectionOverride selectionOverride = parameters.getSelectionOverride(i, trackGroups);
                    if (selectionOverride != null) {
                        definition = new ExoTrackSelection.Definition(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks, selectionOverride.type);
                    }
                    selectAllTracks[i] = definition;
                }
            }
            i++;
        }
        ExoTrackSelection[] createTrackSelections = this.trackSelectionFactory.createTrackSelections(selectAllTracks, getBandwidthMeter(), mediaPeriodId, timeline);
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCount];
        for (int i2 = 0; i2 < rendererCount; i2++) {
            rendererConfigurationArr[i2] = !parameters.getRendererDisabled(i2) && (mappedTrackInfo.getRendererType(i2) == 7 || createTrackSelections[i2] != null) ? RendererConfiguration.DEFAULT : null;
        }
        if (parameters.tunnelingEnabled) {
            maybeConfigureRenderersForTunneling(mappedTrackInfo, iArr, rendererConfigurationArr, createTrackSelections);
        }
        return Pair.create(rendererConfigurationArr, createTrackSelections);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.google.android.exoplayer2.trackselection.DefaultTrackSelector$AudioTrackScore} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.trackselection.ExoTrackSelection.Definition[] selectAllTracks(com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo r22, int[][][] r23, int[] r24, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r25) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r21 = this;
            r6 = r21
            r7 = r22
            r8 = r25
            int r9 = r22.getRendererCount()
            com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition[] r10 = new com.google.android.exoplayer2.trackselection.ExoTrackSelection.Definition[r9]
            r11 = 0
            r0 = 0
            r12 = 0
            r13 = 0
        L_0x0010:
            r14 = 2
            r15 = 1
            if (r12 >= r9) goto L_0x0042
            int r1 = r7.getRendererType(r12)
            if (r14 != r1) goto L_0x003f
            if (r0 != 0) goto L_0x0034
            com.google.android.exoplayer2.source.TrackGroupArray r1 = r7.getTrackGroups(r12)
            r2 = r23[r12]
            r3 = r24[r12]
            r5 = 1
            r0 = r21
            r4 = r25
            com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition r0 = r0.selectVideoTrack(r1, r2, r3, r4, r5)
            r10[r12] = r0
            if (r0 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            com.google.android.exoplayer2.source.TrackGroupArray r1 = r7.getTrackGroups(r12)
            int r1 = r1.length
            if (r1 <= 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r15 = 0
        L_0x003e:
            r13 = r13 | r15
        L_0x003f:
            int r12 = r12 + 1
            goto L_0x0010
        L_0x0042:
            r12 = -1
            r16 = 0
            r3 = r16
            r4 = r3
            r2 = -1
            r5 = 0
        L_0x004a:
            if (r5 >= r9) goto L_0x00b5
            int r0 = r7.getRendererType(r5)
            if (r15 != r0) goto L_0x00a6
            boolean r0 = r8.allowMultipleAdaptiveSelections
            if (r0 != 0) goto L_0x005c
            if (r13 != 0) goto L_0x0059
            goto L_0x005c
        L_0x0059:
            r17 = 0
            goto L_0x005e
        L_0x005c:
            r17 = 1
        L_0x005e:
            com.google.android.exoplayer2.source.TrackGroupArray r1 = r7.getTrackGroups(r5)
            r18 = r23[r5]
            r19 = r24[r5]
            r0 = r21
            r14 = r2
            r2 = r18
            r15 = r3
            r3 = r19
            r20 = r4
            r4 = r25
            r19 = r5
            r5 = r17
            android.util.Pair r0 = r0.selectAudioTrack(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00ac
            if (r15 == 0) goto L_0x0088
            java.lang.Object r1 = r0.second
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$AudioTrackScore r1 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore) r1
            int r1 = r1.compareTo((com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore) r15)
            if (r1 <= 0) goto L_0x00ac
        L_0x0088:
            if (r14 == r12) goto L_0x008c
            r10[r14] = r16
        L_0x008c:
            java.lang.Object r1 = r0.first
            com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition r1 = (com.google.android.exoplayer2.trackselection.ExoTrackSelection.Definition) r1
            r10[r19] = r1
            com.google.android.exoplayer2.source.TrackGroup r2 = r1.group
            int[] r1 = r1.tracks
            r1 = r1[r11]
            com.google.android.exoplayer2.Format r1 = r2.getFormat(r1)
            java.lang.String r4 = r1.language
            java.lang.Object r0 = r0.second
            r3 = r0
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$AudioTrackScore r3 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore) r3
            r2 = r19
            goto L_0x00b0
        L_0x00a6:
            r14 = r2
            r15 = r3
            r20 = r4
            r19 = r5
        L_0x00ac:
            r2 = r14
            r3 = r15
            r4 = r20
        L_0x00b0:
            int r5 = r19 + 1
            r14 = 2
            r15 = 1
            goto L_0x004a
        L_0x00b5:
            r20 = r4
            r0 = r16
            r1 = -1
        L_0x00ba:
            if (r11 >= r9) goto L_0x010b
            int r2 = r7.getRendererType(r11)
            r3 = 1
            if (r2 == r3) goto L_0x0103
            r4 = 2
            if (r2 == r4) goto L_0x0100
            r5 = 3
            if (r2 == r5) goto L_0x00d6
            com.google.android.exoplayer2.source.TrackGroupArray r5 = r7.getTrackGroups(r11)
            r13 = r23[r11]
            com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition r2 = r6.selectOtherTrack(r2, r5, r13, r8)
            r10[r11] = r2
            goto L_0x0100
        L_0x00d6:
            com.google.android.exoplayer2.source.TrackGroupArray r2 = r7.getTrackGroups(r11)
            r5 = r23[r11]
            r13 = r20
            android.util.Pair r2 = r6.selectTextTrack(r2, r5, r8, r13)
            if (r2 == 0) goto L_0x0106
            if (r0 == 0) goto L_0x00f0
            java.lang.Object r5 = r2.second
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$TextTrackScore r5 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore) r5
            int r5 = r5.compareTo((com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore) r0)
            if (r5 <= 0) goto L_0x0106
        L_0x00f0:
            if (r1 == r12) goto L_0x00f4
            r10[r1] = r16
        L_0x00f4:
            java.lang.Object r0 = r2.first
            com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition r0 = (com.google.android.exoplayer2.trackselection.ExoTrackSelection.Definition) r0
            r10[r11] = r0
            java.lang.Object r0 = r2.second
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$TextTrackScore r0 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore) r0
            r1 = r11
            goto L_0x0106
        L_0x0100:
            r13 = r20
            goto L_0x0106
        L_0x0103:
            r13 = r20
            r4 = 2
        L_0x0106:
            int r11 = r11 + 1
            r20 = r13
            goto L_0x00ba
        L_0x010b:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.selectAllTracks(com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo, int[][][], int[], com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition[]");
    }

    /* access modifiers changed from: protected */
    public ExoTrackSelection.Definition selectVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i, Parameters parameters, boolean z) throws ExoPlaybackException {
        ExoTrackSelection.Definition selectAdaptiveVideoTrack = (parameters.forceHighestSupportedBitrate || parameters.forceLowestBitrate || !z) ? null : selectAdaptiveVideoTrack(trackGroupArray, iArr, i, parameters);
        return selectAdaptiveVideoTrack == null ? selectFixedVideoTrack(trackGroupArray, iArr, parameters) : selectAdaptiveVideoTrack;
    }

    private static ExoTrackSelection.Definition selectAdaptiveVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i, Parameters parameters) {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i2 = parameters2.allowVideoNonSeamlessAdaptiveness ? 24 : 16;
        boolean z = parameters2.allowVideoMixedMimeTypeAdaptiveness && (i & i2) != 0;
        int i3 = 0;
        while (i3 < trackGroupArray2.length) {
            TrackGroup trackGroup = trackGroupArray2.get(i3);
            int[] iArr2 = iArr[i3];
            int i4 = parameters2.maxVideoWidth;
            int i5 = parameters2.maxVideoHeight;
            int i6 = parameters2.maxVideoFrameRate;
            int i7 = parameters2.maxVideoBitrate;
            int i8 = parameters2.minVideoWidth;
            int i9 = parameters2.minVideoHeight;
            int i10 = parameters2.minVideoFrameRate;
            int i11 = parameters2.minVideoBitrate;
            int i12 = parameters2.viewportWidth;
            int i13 = parameters2.viewportHeight;
            boolean z2 = parameters2.viewportOrientationMayChange;
            TrackGroup trackGroup2 = trackGroup;
            int i14 = i3;
            int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(trackGroup, iArr2, z, i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, z2);
            if (adaptiveVideoTracksForGroup.length > 0) {
                return new ExoTrackSelection.Definition(trackGroup2, adaptiveVideoTracksForGroup);
            }
            i3 = i14 + 1;
            trackGroupArray2 = trackGroupArray;
            parameters2 = parameters;
        }
        return null;
    }

    private static int[] getAdaptiveVideoTracksForGroup(TrackGroup trackGroup, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z2) {
        String str;
        HashSet hashSet;
        int i12;
        int i13;
        TrackGroup trackGroup2 = trackGroup;
        if (trackGroup2.length < 2) {
            return NO_TRACKS;
        }
        List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup2, i10, i11, z2);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        if (!z) {
            HashSet hashSet2 = new HashSet();
            String str2 = null;
            int i14 = 0;
            int i15 = 0;
            while (i15 < viewportFilteredTrackIndices.size()) {
                String str3 = trackGroup2.getFormat(viewportFilteredTrackIndices.get(i15).intValue()).sampleMimeType;
                if (hashSet2.add(str3)) {
                    String str4 = str3;
                    i13 = i14;
                    i12 = i15;
                    hashSet = hashSet2;
                    int adaptiveVideoTrackCountForMimeType = getAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i, str3, i2, i3, i4, i5, i6, i7, i8, i9, viewportFilteredTrackIndices);
                    if (adaptiveVideoTrackCountForMimeType > i13) {
                        i14 = adaptiveVideoTrackCountForMimeType;
                        str2 = str4;
                        i15 = i12 + 1;
                        hashSet2 = hashSet;
                    }
                } else {
                    i13 = i14;
                    i12 = i15;
                    hashSet = hashSet2;
                }
                i14 = i13;
                i15 = i12 + 1;
                hashSet2 = hashSet;
            }
            str = str2;
        } else {
            str = null;
        }
        filterAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i, str, i2, i3, i4, i5, i6, i7, i8, i9, viewportFilteredTrackIndices);
        return viewportFilteredTrackIndices.size() < 2 ? NO_TRACKS : Ints.toArray(viewportFilteredTrackIndices);
    }

    private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, List<Integer> list) {
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            int intValue = list.get(i11).intValue();
            if (isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i, i2, i3, i4, i5, i6, i7, i8, i9)) {
                i10++;
            }
        }
        return i10;
    }

    private static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, List<Integer> list) {
        List<Integer> list2 = list;
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list2.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i, i2, i3, i4, i5, i6, i7, i8, i9)) {
                list2.remove(size);
            }
        }
    }

    private static boolean isSupportedAdaptiveVideoTrack(Format format, String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if ((format.roleFlags & 16384) != 0 || !isSupported(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !Util.areEqual(format.sampleMimeType, str)) {
            return false;
        }
        if (format.width != -1 && (i7 > format.width || format.width > i3)) {
            return false;
        }
        if (format.height != -1 && (i8 > format.height || format.height > i4)) {
            return false;
        }
        if ((format.frameRate == -1.0f || (((float) i9) <= format.frameRate && format.frameRate <= ((float) i5))) && format.bitrate != -1 && i10 <= format.bitrate && format.bitrate <= i6) {
            return true;
        }
        return false;
    }

    private static ExoTrackSelection.Definition selectFixedVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i = -1;
        TrackGroup trackGroup = null;
        VideoTrackScore videoTrackScore = null;
        for (int i2 = 0; i2 < trackGroupArray2.length; i2++) {
            TrackGroup trackGroup2 = trackGroupArray2.get(i2);
            List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup2, parameters2.viewportWidth, parameters2.viewportHeight, parameters2.viewportOrientationMayChange);
            int[] iArr2 = iArr[i2];
            for (int i3 = 0; i3 < trackGroup2.length; i3++) {
                Format format = trackGroup2.getFormat(i3);
                if ((format.roleFlags & 16384) == 0 && isSupported(iArr2[i3], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    VideoTrackScore videoTrackScore2 = new VideoTrackScore(format, parameters2, iArr2[i3], viewportFilteredTrackIndices.contains(Integer.valueOf(i3)));
                    if ((videoTrackScore2.isWithinMaxConstraints || parameters2.exceedVideoConstraintsIfNecessary) && (videoTrackScore == null || videoTrackScore2.compareTo(videoTrackScore) > 0)) {
                        trackGroup = trackGroup2;
                        i = i3;
                        videoTrackScore = videoTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new ExoTrackSelection.Definition(trackGroup, i);
    }

    /* access modifiers changed from: protected */
    public Pair<ExoTrackSelection.Definition, AudioTrackScore> selectAudioTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i, Parameters parameters, boolean z) throws ExoPlaybackException {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        ExoTrackSelection.Definition definition = null;
        AudioTrackScore audioTrackScore = null;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < trackGroupArray2.length; i4++) {
            TrackGroup trackGroup = trackGroupArray2.get(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < trackGroup.length; i5++) {
                if (isSupported(iArr2[i5], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    AudioTrackScore audioTrackScore2 = new AudioTrackScore(trackGroup.getFormat(i5), parameters2, iArr2[i5]);
                    if ((audioTrackScore2.isWithinConstraints || parameters2.exceedAudioConstraintsIfNecessary) && (audioTrackScore == null || audioTrackScore2.compareTo(audioTrackScore) > 0)) {
                        i2 = i4;
                        i3 = i5;
                        audioTrackScore = audioTrackScore2;
                    }
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        TrackGroup trackGroup2 = trackGroupArray2.get(i2);
        if (!parameters2.forceHighestSupportedBitrate && !parameters2.forceLowestBitrate && z) {
            int[] adaptiveAudioTracks = getAdaptiveAudioTracks(trackGroup2, iArr[i2], i3, parameters2.maxAudioBitrate, parameters2.allowAudioMixedMimeTypeAdaptiveness, parameters2.allowAudioMixedSampleRateAdaptiveness, parameters2.allowAudioMixedChannelCountAdaptiveness);
            if (adaptiveAudioTracks.length > 1) {
                definition = new ExoTrackSelection.Definition(trackGroup2, adaptiveAudioTracks);
            }
        }
        if (definition == null) {
            definition = new ExoTrackSelection.Definition(trackGroup2, i3);
        }
        return Pair.create(definition, (AudioTrackScore) Assertions.checkNotNull(audioTrackScore));
    }

    private static int[] getAdaptiveAudioTracks(TrackGroup trackGroup, int[] iArr, int i, int i2, boolean z, boolean z2, boolean z3) {
        TrackGroup trackGroup2 = trackGroup;
        int i3 = i;
        Format format = trackGroup.getFormat(i);
        int[] iArr2 = new int[trackGroup2.length];
        int i4 = 0;
        for (int i5 = 0; i5 < trackGroup2.length; i5++) {
            if (i5 == i3 || isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i5), iArr[i5], format, i2, z, z2, z3)) {
                iArr2[i4] = i5;
                i4++;
            }
        }
        return Arrays.copyOf(iArr2, i4);
    }

    private static boolean isSupportedAdaptiveAudioTrack(Format format, int i, Format format2, int i2, boolean z, boolean z2, boolean z3) {
        if (!isSupported(i, false) || format.bitrate == -1 || format.bitrate > i2) {
            return false;
        }
        if (!z3 && (format.channelCount == -1 || format.channelCount != format2.channelCount)) {
            return false;
        }
        if (!z && (format.sampleMimeType == null || !TextUtils.equals(format.sampleMimeType, format2.sampleMimeType))) {
            return false;
        }
        if (z2 || (format.sampleRate != -1 && format.sampleRate == format2.sampleRate)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Pair<ExoTrackSelection.Definition, TextTrackScore> selectTextTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, String str) throws ExoPlaybackException {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i = -1;
        TrackGroup trackGroup = null;
        TextTrackScore textTrackScore = null;
        for (int i2 = 0; i2 < trackGroupArray2.length; i2++) {
            TrackGroup trackGroup2 = trackGroupArray2.get(i2);
            int[] iArr2 = iArr[i2];
            for (int i3 = 0; i3 < trackGroup2.length; i3++) {
                if (isSupported(iArr2[i3], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    TextTrackScore textTrackScore2 = new TextTrackScore(trackGroup2.getFormat(i3), parameters2, iArr2[i3], str);
                    if (textTrackScore2.isWithinConstraints && (textTrackScore == null || textTrackScore2.compareTo(textTrackScore) > 0)) {
                        trackGroup = trackGroup2;
                        i = i3;
                        textTrackScore = textTrackScore2;
                    }
                } else {
                    String str2 = str;
                }
            }
            String str3 = str;
        }
        if (trackGroup == null) {
            return null;
        }
        return Pair.create(new ExoTrackSelection.Definition(trackGroup, i), (TextTrackScore) Assertions.checkNotNull(textTrackScore));
    }

    /* access modifiers changed from: protected */
    public ExoTrackSelection.Definition selectOtherTrack(int i, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        OtherTrackScore otherTrackScore = null;
        int i2 = 0;
        for (int i3 = 0; i3 < trackGroupArray.length; i3++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < trackGroup2.length; i4++) {
                if (isSupported(iArr2[i4], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    OtherTrackScore otherTrackScore2 = new OtherTrackScore(trackGroup2.getFormat(i4), iArr2[i4]);
                    if (otherTrackScore == null || otherTrackScore2.compareTo(otherTrackScore) > 0) {
                        trackGroup = trackGroup2;
                        i2 = i4;
                        otherTrackScore = otherTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new ExoTrackSelection.Definition(trackGroup, i2);
    }

    private static void maybeConfigureRenderersForTunneling(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr) {
        boolean z;
        boolean z2 = false;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            if (i >= mappedTrackInfo.getRendererCount()) {
                z = true;
                break;
            }
            int rendererType = mappedTrackInfo.getRendererType(i);
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
            if ((rendererType == 1 || rendererType == 2) && exoTrackSelection != null && rendererSupportsTunneling(iArr[i], mappedTrackInfo.getTrackGroups(i), exoTrackSelection)) {
                if (rendererType == 1) {
                    if (i3 != -1) {
                        break;
                    }
                    i3 = i;
                } else if (i2 != -1) {
                    break;
                } else {
                    i2 = i;
                }
            }
            i++;
        }
        z = false;
        if (!(i3 == -1 || i2 == -1)) {
            z2 = true;
        }
        if (z && z2) {
            RendererConfiguration rendererConfiguration = new RendererConfiguration(true);
            rendererConfigurationArr[i3] = rendererConfiguration;
            rendererConfigurationArr[i2] = rendererConfiguration;
        }
    }

    private static boolean rendererSupportsTunneling(int[][] iArr, TrackGroupArray trackGroupArray, ExoTrackSelection exoTrackSelection) {
        if (exoTrackSelection == null) {
            return false;
        }
        int indexOf = trackGroupArray.indexOf(exoTrackSelection.getTrackGroup());
        for (int i = 0; i < exoTrackSelection.length(); i++) {
            if (RendererCapabilities.CC.getTunnelingSupport(iArr[indexOf][exoTrackSelection.getIndexInTrackGroup(i)]) != 32) {
                return false;
            }
        }
        return true;
    }

    protected static boolean isSupported(int i, boolean z) {
        int formatSupport = RendererCapabilities.CC.getFormatSupport(i);
        return formatSupport == 4 || (z && formatSupport == 3);
    }

    protected static String normalizeUndeterminedLanguageToNull(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    protected static int getFormatLanguageScore(Format format, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(format.language)) {
            return 4;
        }
        String normalizeUndeterminedLanguageToNull = normalizeUndeterminedLanguageToNull(str);
        String normalizeUndeterminedLanguageToNull2 = normalizeUndeterminedLanguageToNull(format.language);
        if (normalizeUndeterminedLanguageToNull2 == null || normalizeUndeterminedLanguageToNull == null) {
            if (!z || normalizeUndeterminedLanguageToNull2 != null) {
                return 0;
            }
            return 1;
        } else if (normalizeUndeterminedLanguageToNull2.startsWith(normalizeUndeterminedLanguageToNull) || normalizeUndeterminedLanguageToNull.startsWith(normalizeUndeterminedLanguageToNull2)) {
            return 3;
        } else {
            if (Util.splitAtFirst(normalizeUndeterminedLanguageToNull2, "-")[0].equals(Util.splitAtFirst(normalizeUndeterminedLanguageToNull, "-")[0])) {
                return 2;
            }
            return 0;
        }
    }

    private static List<Integer> getViewportFilteredTrackIndices(TrackGroup trackGroup, int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList(trackGroup.length);
        for (int i3 = 0; i3 < trackGroup.length; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (!(i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE)) {
            int i4 = Integer.MAX_VALUE;
            for (int i5 = 0; i5 < trackGroup.length; i5++) {
                Format format = trackGroup.getFormat(i5);
                if (format.width > 0 && format.height > 0) {
                    Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z, i, i2, format.width, format.height);
                    int i6 = format.width * format.height;
                    if (format.width >= ((int) (((float) maxVideoSizeInViewport.x) * FRACTION_TO_CONSIDER_FULLSCREEN)) && format.height >= ((int) (((float) maxVideoSizeInViewport.y) * FRACTION_TO_CONSIDER_FULLSCREEN)) && i6 < i4) {
                        i4 = i6;
                    }
                }
            }
            if (i4 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int pixelCount = trackGroup.getFormat(((Integer) arrayList.get(size)).intValue()).getPixelCount();
                    if (pixelCount == -1 || pixelCount > i4) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 != r3) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point getMaxVideoSizeInViewport(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x0010
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L_0x0008
            r1 = 1
            goto L_0x0009
        L_0x0008:
            r1 = 0
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r3 = 0
        L_0x000d:
            if (r1 == r3) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0013:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0023
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r0, (int) r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0023:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r3, (int) r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.getMaxVideoSizeInViewport(boolean, int, int, int, int):android.graphics.Point");
    }

    protected static final class VideoTrackScore implements Comparable<VideoTrackScore> {
        private final int bitrate;
        public final boolean isWithinMaxConstraints;
        private final boolean isWithinMinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final Parameters parameters;
        private final int pixelCount;
        private final int preferredMimeTypeMatchIndex;

        public VideoTrackScore(Format format, Parameters parameters2, int i, boolean z) {
            this.parameters = parameters2;
            boolean z2 = true;
            int i2 = 0;
            this.isWithinMaxConstraints = z && (format.width == -1 || format.width <= parameters2.maxVideoWidth) && ((format.height == -1 || format.height <= parameters2.maxVideoHeight) && ((format.frameRate == -1.0f || format.frameRate <= ((float) parameters2.maxVideoFrameRate)) && (format.bitrate == -1 || format.bitrate <= parameters2.maxVideoBitrate)));
            if (!z || ((format.width != -1 && format.width < parameters2.minVideoWidth) || ((format.height != -1 && format.height < parameters2.minVideoHeight) || ((format.frameRate != -1.0f && format.frameRate < ((float) parameters2.minVideoFrameRate)) || (format.bitrate != -1 && format.bitrate < parameters2.minVideoBitrate))))) {
                z2 = false;
            }
            this.isWithinMinConstraints = z2;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i, false);
            this.bitrate = format.bitrate;
            this.pixelCount = format.getPixelCount();
            while (true) {
                if (i2 < parameters2.preferredVideoMimeTypes.size()) {
                    if (format.sampleMimeType != null && format.sampleMimeType.equals(parameters2.preferredVideoMimeTypes.get(i2))) {
                        break;
                    }
                    i2++;
                } else {
                    i2 = Integer.MAX_VALUE;
                    break;
                }
            }
            this.preferredMimeTypeMatchIndex = i2;
        }

        public int compareTo(VideoTrackScore videoTrackScore) {
            Ordering ordering;
            if (!this.isWithinMaxConstraints || !this.isWithinRendererCapabilities) {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse();
            } else {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
            }
            return ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, videoTrackScore.isWithinRendererCapabilities).compareFalseFirst(this.isWithinMaxConstraints, videoTrackScore.isWithinMaxConstraints).compareFalseFirst(this.isWithinMinConstraints, videoTrackScore.isWithinMinConstraints).compare(Integer.valueOf(this.preferredMimeTypeMatchIndex), Integer.valueOf(videoTrackScore.preferredMimeTypeMatchIndex), Ordering.natural().reverse()).compare(Integer.valueOf(this.bitrate), Integer.valueOf(videoTrackScore.bitrate), this.parameters.forceLowestBitrate ? DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse() : DefaultTrackSelector.NO_ORDER).compare(Integer.valueOf(this.pixelCount), Integer.valueOf(videoTrackScore.pixelCount), ordering).compare(Integer.valueOf(this.bitrate), Integer.valueOf(videoTrackScore.bitrate), ordering).result();
        }
    }

    protected static final class AudioTrackScore implements Comparable<AudioTrackScore> {
        private final int bitrate;
        private final int channelCount;
        private final boolean isDefaultSelectionFlag;
        public final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final String language;
        private final int localeLanguageMatchIndex;
        private final int localeLanguageScore;
        private final Parameters parameters;
        private final int preferredLanguageIndex;
        private final int preferredLanguageScore;
        private final int preferredMimeTypeMatchIndex;
        private final int preferredRoleFlagsScore;
        private final int sampleRate;

        public AudioTrackScore(Format format, Parameters parameters2, int i) {
            int i2;
            int i3;
            int i4;
            this.parameters = parameters2;
            this.language = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(format.language);
            int i5 = 0;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i, false);
            int i6 = 0;
            while (true) {
                i2 = Integer.MAX_VALUE;
                if (i6 >= parameters2.preferredAudioLanguages.size()) {
                    i6 = Integer.MAX_VALUE;
                    i3 = 0;
                    break;
                }
                i3 = DefaultTrackSelector.getFormatLanguageScore(format, (String) parameters2.preferredAudioLanguages.get(i6), false);
                if (i3 > 0) {
                    break;
                }
                i6++;
            }
            this.preferredLanguageIndex = i6;
            this.preferredLanguageScore = i3;
            this.preferredRoleFlagsScore = Integer.bitCount(format.roleFlags & parameters2.preferredAudioRoleFlags);
            boolean z = true;
            this.isDefaultSelectionFlag = (format.selectionFlags & 1) != 0;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.bitrate = format.bitrate;
            if ((format.bitrate != -1 && format.bitrate > parameters2.maxAudioBitrate) || (format.channelCount != -1 && format.channelCount > parameters2.maxAudioChannelCount)) {
                z = false;
            }
            this.isWithinConstraints = z;
            String[] systemLanguageCodes = Util.getSystemLanguageCodes();
            int i7 = 0;
            while (true) {
                if (i7 >= systemLanguageCodes.length) {
                    i7 = Integer.MAX_VALUE;
                    i4 = 0;
                    break;
                }
                i4 = DefaultTrackSelector.getFormatLanguageScore(format, systemLanguageCodes[i7], false);
                if (i4 > 0) {
                    break;
                }
                i7++;
            }
            this.localeLanguageMatchIndex = i7;
            this.localeLanguageScore = i4;
            while (true) {
                if (i5 < parameters2.preferredAudioMimeTypes.size()) {
                    if (format.sampleMimeType != null && format.sampleMimeType.equals(parameters2.preferredAudioMimeTypes.get(i5))) {
                        i2 = i5;
                        break;
                    }
                    i5++;
                } else {
                    break;
                }
            }
            this.preferredMimeTypeMatchIndex = i2;
        }

        public int compareTo(AudioTrackScore audioTrackScore) {
            Ordering ordering;
            if (!this.isWithinConstraints || !this.isWithinRendererCapabilities) {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse();
            } else {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
            }
            ComparisonChain compare = ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, audioTrackScore.isWithinRendererCapabilities).compare(Integer.valueOf(this.preferredLanguageIndex), Integer.valueOf(audioTrackScore.preferredLanguageIndex), Ordering.natural().reverse()).compare(this.preferredLanguageScore, audioTrackScore.preferredLanguageScore).compare(this.preferredRoleFlagsScore, audioTrackScore.preferredRoleFlagsScore).compareFalseFirst(this.isWithinConstraints, audioTrackScore.isWithinConstraints).compare(Integer.valueOf(this.preferredMimeTypeMatchIndex), Integer.valueOf(audioTrackScore.preferredMimeTypeMatchIndex), Ordering.natural().reverse()).compare(Integer.valueOf(this.bitrate), Integer.valueOf(audioTrackScore.bitrate), this.parameters.forceLowestBitrate ? DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse() : DefaultTrackSelector.NO_ORDER).compareFalseFirst(this.isDefaultSelectionFlag, audioTrackScore.isDefaultSelectionFlag).compare(Integer.valueOf(this.localeLanguageMatchIndex), Integer.valueOf(audioTrackScore.localeLanguageMatchIndex), Ordering.natural().reverse()).compare(this.localeLanguageScore, audioTrackScore.localeLanguageScore).compare(Integer.valueOf(this.channelCount), Integer.valueOf(audioTrackScore.channelCount), ordering).compare(Integer.valueOf(this.sampleRate), Integer.valueOf(audioTrackScore.sampleRate), ordering);
            Integer valueOf = Integer.valueOf(this.bitrate);
            Integer valueOf2 = Integer.valueOf(audioTrackScore.bitrate);
            if (!Util.areEqual(this.language, audioTrackScore.language)) {
                ordering = DefaultTrackSelector.NO_ORDER;
            }
            return compare.compare(valueOf, valueOf2, ordering).result();
        }
    }

    protected static final class TextTrackScore implements Comparable<TextTrackScore> {
        private final boolean hasCaptionRoleFlags;
        private final boolean isDefault;
        private final boolean isForced;
        public final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final int preferredLanguageIndex;
        private final int preferredLanguageScore;
        private final int preferredRoleFlagsScore;
        private final int selectedAudioLanguageScore;

        public TextTrackScore(Format format, Parameters parameters, int i, String str) {
            ImmutableList immutableList;
            int i2;
            boolean z = false;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i, false);
            int i3 = format.selectionFlags & (parameters.disabledTextTrackSelectionFlags ^ -1);
            this.isDefault = (i3 & 1) != 0;
            this.isForced = (i3 & 2) != 0;
            if (parameters.preferredTextLanguages.isEmpty()) {
                immutableList = ImmutableList.of("");
            } else {
                immutableList = parameters.preferredTextLanguages;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= immutableList.size()) {
                    i4 = Integer.MAX_VALUE;
                    i2 = 0;
                    break;
                }
                i2 = DefaultTrackSelector.getFormatLanguageScore(format, (String) immutableList.get(i4), parameters.selectUndeterminedTextLanguage);
                if (i2 > 0) {
                    break;
                }
                i4++;
            }
            this.preferredLanguageIndex = i4;
            this.preferredLanguageScore = i2;
            int bitCount = Integer.bitCount(format.roleFlags & parameters.preferredTextRoleFlags);
            this.preferredRoleFlagsScore = bitCount;
            this.hasCaptionRoleFlags = (format.roleFlags & 1088) != 0;
            int formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, str, DefaultTrackSelector.normalizeUndeterminedLanguageToNull(str) == null);
            this.selectedAudioLanguageScore = formatLanguageScore;
            if (i2 > 0 || ((parameters.preferredTextLanguages.isEmpty() && bitCount > 0) || this.isDefault || (this.isForced && formatLanguageScore > 0))) {
                z = true;
            }
            this.isWithinConstraints = z;
        }

        public int compareTo(TextTrackScore textTrackScore) {
            ComparisonChain compare = ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, textTrackScore.isWithinRendererCapabilities).compare(Integer.valueOf(this.preferredLanguageIndex), Integer.valueOf(textTrackScore.preferredLanguageIndex), Ordering.natural().reverse()).compare(this.preferredLanguageScore, textTrackScore.preferredLanguageScore).compare(this.preferredRoleFlagsScore, textTrackScore.preferredRoleFlagsScore).compareFalseFirst(this.isDefault, textTrackScore.isDefault).compare(Boolean.valueOf(this.isForced), Boolean.valueOf(textTrackScore.isForced), this.preferredLanguageScore == 0 ? Ordering.natural() : Ordering.natural().reverse()).compare(this.selectedAudioLanguageScore, textTrackScore.selectedAudioLanguageScore);
            if (this.preferredRoleFlagsScore == 0) {
                compare = compare.compareTrueFirst(this.hasCaptionRoleFlags, textTrackScore.hasCaptionRoleFlags);
            }
            return compare.result();
        }
    }

    protected static final class OtherTrackScore implements Comparable<OtherTrackScore> {
        private final boolean isDefault;
        private final boolean isWithinRendererCapabilities;

        public OtherTrackScore(Format format, int i) {
            this.isDefault = (format.selectionFlags & 1) == 0 ? false : true;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i, false);
        }

        public int compareTo(OtherTrackScore otherTrackScore) {
            return ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, otherTrackScore.isWithinRendererCapabilities).compareFalseFirst(this.isDefault, otherTrackScore.isDefault).result();
        }
    }
}
