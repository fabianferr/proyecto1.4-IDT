package androidx.media3.common;

import android.view.SurfaceView;
import com.android.tools.r8.annotations.SynthesizedClassV2;

public interface DebugViewProvider {
    public static final DebugViewProvider NONE = new DebugViewProvider$$ExternalSyntheticLambda0();

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: androidx.media3.common.DebugViewProvider$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            DebugViewProvider debugViewProvider = DebugViewProvider.NONE;
        }

        public static /* synthetic */ SurfaceView lambda$static$0(int i, int i2) {
            return null;
        }
    }

    SurfaceView getDebugPreviewSurfaceView(int i, int i2);
}
