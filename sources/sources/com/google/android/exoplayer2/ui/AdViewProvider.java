package com.google.android.exoplayer2.ui;

import android.view.ViewGroup;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.common.collect.ImmutableList;
import java.util.List;

public interface AdViewProvider {
    List<AdOverlayInfo> getAdOverlayInfos();

    ViewGroup getAdViewGroup();

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.android.exoplayer2.ui.AdViewProvider$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static List $default$getAdOverlayInfos(AdViewProvider _this) {
            return ImmutableList.of();
        }
    }
}
