package androidx.core.os;

import android.os.Build;
import android.os.Environment;
import java.io.File;

public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    public static String getStorageState(File file) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getExternalStorageState(file);
        }
        return Api19Impl.getStorageState(file);
    }

    private EnvironmentCompat() {
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static String getExternalStorageState(File file) {
            return Environment.getExternalStorageState(file);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static String getStorageState(File file) {
            return Environment.getStorageState(file);
        }
    }
}
