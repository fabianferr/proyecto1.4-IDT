package com.google.android.exoplayer2.audio;

import com.android.tools.r8.annotations.SynthesizedClassV2;

@Deprecated
public interface AudioListener {

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.android.exoplayer2.audio.AudioListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onAudioAttributesChanged(AudioListener _this, AudioAttributes audioAttributes) {
        }

        public static void $default$onAudioSessionIdChanged(AudioListener _this, int i) {
        }

        public static void $default$onSkipSilenceEnabledChanged(AudioListener _this, boolean z) {
        }

        public static void $default$onVolumeChanged(AudioListener _this, float f) {
        }
    }

    void onAudioAttributesChanged(AudioAttributes audioAttributes);

    void onAudioSessionIdChanged(int i);

    void onSkipSilenceEnabledChanged(boolean z);

    void onVolumeChanged(float f);
}
