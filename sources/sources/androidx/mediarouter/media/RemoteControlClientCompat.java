package androidx.mediarouter.media;

import android.content.Context;
import androidx.mediarouter.media.MediaRouterJellybean;
import java.lang.ref.WeakReference;

abstract class RemoteControlClientCompat {
    protected final Context mContext;
    protected final Object mRcc;
    protected VolumeCallback mVolumeCallback;

    public static final class PlaybackInfo {
        public int playbackStream = 3;
        public int playbackType = 1;
        public int volume;
        public String volumeControlId;
        public int volumeHandling = 0;
        public int volumeMax;
    }

    public interface VolumeCallback {
        void onVolumeSetRequest(int i);

        void onVolumeUpdateRequest(int i);
    }

    public void setPlaybackInfo(PlaybackInfo playbackInfo) {
    }

    protected RemoteControlClientCompat(Context context, Object obj) {
        this.mContext = context;
        this.mRcc = obj;
    }

    public static RemoteControlClientCompat obtain(Context context, Object obj) {
        return new JellybeanImpl(context, obj);
    }

    public Object getRemoteControlClient() {
        return this.mRcc;
    }

    public void setVolumeCallback(VolumeCallback volumeCallback) {
        this.mVolumeCallback = volumeCallback;
    }

    static class LegacyImpl extends RemoteControlClientCompat {
        public LegacyImpl(Context context, Object obj) {
            super(context, obj);
        }
    }

    static class JellybeanImpl extends RemoteControlClientCompat {
        private boolean mRegistered;
        private final Object mRouterObj;
        private final Object mUserRouteCategoryObj;
        private final Object mUserRouteObj;

        public JellybeanImpl(Context context, Object obj) {
            super(context, obj);
            Object mediaRouter = MediaRouterJellybean.getMediaRouter(context);
            this.mRouterObj = mediaRouter;
            Object createRouteCategory = MediaRouterJellybean.createRouteCategory(mediaRouter, "", false);
            this.mUserRouteCategoryObj = createRouteCategory;
            this.mUserRouteObj = MediaRouterJellybean.createUserRoute(mediaRouter, createRouteCategory);
        }

        public void setPlaybackInfo(PlaybackInfo playbackInfo) {
            MediaRouterJellybean.UserRouteInfo.setVolume(this.mUserRouteObj, playbackInfo.volume);
            MediaRouterJellybean.UserRouteInfo.setVolumeMax(this.mUserRouteObj, playbackInfo.volumeMax);
            MediaRouterJellybean.UserRouteInfo.setVolumeHandling(this.mUserRouteObj, playbackInfo.volumeHandling);
            MediaRouterJellybean.UserRouteInfo.setPlaybackStream(this.mUserRouteObj, playbackInfo.playbackStream);
            MediaRouterJellybean.UserRouteInfo.setPlaybackType(this.mUserRouteObj, playbackInfo.playbackType);
            if (!this.mRegistered) {
                this.mRegistered = true;
                MediaRouterJellybean.UserRouteInfo.setVolumeCallback(this.mUserRouteObj, MediaRouterJellybean.createVolumeCallback(new VolumeCallbackWrapper(this)));
                MediaRouterJellybean.UserRouteInfo.setRemoteControlClient(this.mUserRouteObj, this.mRcc);
            }
        }

        private static final class VolumeCallbackWrapper implements MediaRouterJellybean.VolumeCallback {
            private final WeakReference<JellybeanImpl> mImplWeak;

            public VolumeCallbackWrapper(JellybeanImpl jellybeanImpl) {
                this.mImplWeak = new WeakReference<>(jellybeanImpl);
            }

            public void onVolumeUpdateRequest(Object obj, int i) {
                JellybeanImpl jellybeanImpl = (JellybeanImpl) this.mImplWeak.get();
                if (jellybeanImpl != null && jellybeanImpl.mVolumeCallback != null) {
                    jellybeanImpl.mVolumeCallback.onVolumeUpdateRequest(i);
                }
            }

            public void onVolumeSetRequest(Object obj, int i) {
                JellybeanImpl jellybeanImpl = (JellybeanImpl) this.mImplWeak.get();
                if (jellybeanImpl != null && jellybeanImpl.mVolumeCallback != null) {
                    jellybeanImpl.mVolumeCallback.onVolumeSetRequest(i);
                }
            }
        }
    }
}
