package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class DrmUtil {
    public static final int ERROR_SOURCE_EXO_MEDIA_DRM = 1;
    public static final int ERROR_SOURCE_LICENSE_ACQUISITION = 2;
    public static final int ERROR_SOURCE_PROVISIONING = 3;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorSource {
    }

    public static int getErrorCodeForMediaDrmException(Exception exc, int i) {
        if (Util.SDK_INT >= 21 && PlatformOperationsWrapperV21.isMediaDrmStateException(exc)) {
            return PlatformOperationsWrapperV21.mediaDrmStateExceptionToErrorCode(exc);
        }
        if (Util.SDK_INT >= 23 && PlatformOperationsWrapperV23.isMediaDrmResetException(exc)) {
            return 6006;
        }
        if (Util.SDK_INT >= 18 && PlatformOperationsWrapperV18.isNotProvisionedException(exc)) {
            return 6002;
        }
        if (Util.SDK_INT >= 18 && PlatformOperationsWrapperV18.isDeniedByServerException(exc)) {
            return 6007;
        }
        if (exc instanceof UnsupportedDrmException) {
            return 6001;
        }
        if (exc instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
            return 6003;
        }
        if (exc instanceof KeysExpiredException) {
            return 6008;
        }
        if (i == 1) {
            return 6006;
        }
        if (i == 2) {
            return 6004;
        }
        if (i == 3) {
            return 6002;
        }
        throw new IllegalArgumentException();
    }

    private static final class PlatformOperationsWrapperV18 {
        private PlatformOperationsWrapperV18() {
        }

        public static boolean isNotProvisionedException(Throwable th) {
            return th instanceof NotProvisionedException;
        }

        public static boolean isDeniedByServerException(Throwable th) {
            return th instanceof DeniedByServerException;
        }
    }

    private static final class PlatformOperationsWrapperV21 {
        private PlatformOperationsWrapperV21() {
        }

        public static boolean isMediaDrmStateException(Throwable th) {
            return th instanceof MediaDrm.MediaDrmStateException;
        }

        public static int mediaDrmStateExceptionToErrorCode(Throwable th) {
            return C.getErrorCodeForMediaDrmErrorCode(Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
        }
    }

    private static final class PlatformOperationsWrapperV23 {
        private PlatformOperationsWrapperV23() {
        }

        public static boolean isMediaDrmResetException(Throwable th) {
            return th instanceof MediaDrmResetException;
        }
    }

    private DrmUtil() {
    }
}
