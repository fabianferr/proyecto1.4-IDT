package androidx.media3.exoplayer.drm;

import android.os.Looper;
import androidx.media3.common.Format;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import com.android.tools.r8.annotations.SynthesizedClassV2;

public interface DrmSessionManager {
    public static final DrmSessionManager DRM_UNSUPPORTED;
    @Deprecated
    public static final DrmSessionManager DUMMY;

    public interface DrmSessionReference {
        public static final DrmSessionReference EMPTY = new DrmSessionManager$DrmSessionReference$$ExternalSyntheticLambda0();

        @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
        /* renamed from: androidx.media3.exoplayer.drm.DrmSessionManager$DrmSessionReference$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            static {
                DrmSessionReference drmSessionReference = DrmSessionReference.EMPTY;
            }

            public static /* synthetic */ void lambda$static$0() {
            }
        }

        void release();
    }

    DrmSession acquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    int getCryptoType(Format format);

    DrmSessionReference preacquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    void prepare();

    void release();

    void setPlayer(Looper looper, PlayerId playerId);

    static {
        AnonymousClass1 r0 = new DrmSessionManager() {
            public /* synthetic */ DrmSessionReference preacquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
                return CC.$default$preacquireSession(this, eventDispatcher, format);
            }

            public /* synthetic */ void prepare() {
                CC.$default$prepare(this);
            }

            public /* synthetic */ void release() {
                CC.$default$release(this);
            }

            public void setPlayer(Looper looper, PlayerId playerId) {
            }

            public DrmSession acquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
                if (format.drmInitData == null) {
                    return null;
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
            }

            public int getCryptoType(Format format) {
                return format.drmInitData != null ? 1 : 0;
            }
        };
        DRM_UNSUPPORTED = r0;
        DUMMY = r0;
    }

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: androidx.media3.exoplayer.drm.DrmSessionManager$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$prepare(DrmSessionManager _this) {
        }

        public static void $default$release(DrmSessionManager _this) {
        }

        static {
            DrmSessionManager drmSessionManager = DrmSessionManager.DRM_UNSUPPORTED;
        }

        @Deprecated
        public static DrmSessionManager getDummyDrmSessionManager() {
            return DrmSessionManager.DRM_UNSUPPORTED;
        }

        public static DrmSessionReference $default$preacquireSession(DrmSessionManager _this, DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
            return DrmSessionReference.EMPTY;
        }
    }
}
