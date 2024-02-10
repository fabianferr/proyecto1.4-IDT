package androidx.lifecycle;

import com.android.tools.r8.annotations.SynthesizedClassV2;

public interface DefaultLifecycleObserver extends FullLifecycleObserver {

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: androidx.lifecycle.DefaultLifecycleObserver$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onCreate(DefaultLifecycleObserver _this, LifecycleOwner lifecycleOwner) {
        }

        public static void $default$onDestroy(DefaultLifecycleObserver _this, LifecycleOwner lifecycleOwner) {
        }

        public static void $default$onPause(DefaultLifecycleObserver _this, LifecycleOwner lifecycleOwner) {
        }

        public static void $default$onResume(DefaultLifecycleObserver _this, LifecycleOwner lifecycleOwner) {
        }

        public static void $default$onStart(DefaultLifecycleObserver _this, LifecycleOwner lifecycleOwner) {
        }

        public static void $default$onStop(DefaultLifecycleObserver _this, LifecycleOwner lifecycleOwner) {
        }
    }

    void onCreate(LifecycleOwner lifecycleOwner);

    void onDestroy(LifecycleOwner lifecycleOwner);

    void onPause(LifecycleOwner lifecycleOwner);

    void onResume(LifecycleOwner lifecycleOwner);

    void onStart(LifecycleOwner lifecycleOwner);

    void onStop(LifecycleOwner lifecycleOwner);
}
