package androidx.mediarouter.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.core.util.ObjectsCompat;
import androidx.mediarouter.media.MediaRouter;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class RemotePlaybackClient {
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    static final String TAG = "RemotePlaybackClient";
    private final ActionReceiver mActionReceiver;
    private final Context mContext;
    private final PendingIntent mItemStatusPendingIntent;
    private final PendingIntent mMessagePendingIntent;
    OnMessageReceivedListener mOnMessageReceivedListener;
    private final MediaRouter.RouteInfo mRoute;
    private boolean mRouteSupportsMessaging;
    private boolean mRouteSupportsQueuing;
    private boolean mRouteSupportsRemotePlayback;
    private boolean mRouteSupportsSessionManagement;
    String mSessionId;
    private final PendingIntent mSessionStatusPendingIntent;
    StatusCallback mStatusCallback;

    public static abstract class ActionCallback {
        public void onError(String str, int i, Bundle bundle) {
        }
    }

    public static abstract class ItemActionCallback extends ActionCallback {
        public void onResult(Bundle bundle, String str, MediaSessionStatus mediaSessionStatus, String str2, MediaItemStatus mediaItemStatus) {
        }
    }

    public interface OnMessageReceivedListener {
        void onMessageReceived(String str, Bundle bundle);
    }

    public static abstract class SessionActionCallback extends ActionCallback {
        public void onResult(Bundle bundle, String str, MediaSessionStatus mediaSessionStatus) {
        }
    }

    public static abstract class StatusCallback {
        public void onItemStatusChanged(Bundle bundle, String str, MediaSessionStatus mediaSessionStatus, String str2, MediaItemStatus mediaItemStatus) {
        }

        public void onSessionChanged(String str) {
        }

        public void onSessionStatusChanged(Bundle bundle, String str, MediaSessionStatus mediaSessionStatus) {
        }
    }

    public RemotePlaybackClient(Context context, MediaRouter.RouteInfo routeInfo) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        } else if (routeInfo != null) {
            this.mContext = context;
            this.mRoute = routeInfo;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ActionReceiver.ACTION_ITEM_STATUS_CHANGED);
            intentFilter.addAction(ActionReceiver.ACTION_SESSION_STATUS_CHANGED);
            intentFilter.addAction(ActionReceiver.ACTION_MESSAGE_RECEIVED);
            ActionReceiver actionReceiver = new ActionReceiver();
            this.mActionReceiver = actionReceiver;
            context.registerReceiver(actionReceiver, intentFilter);
            Intent intent = new Intent(ActionReceiver.ACTION_ITEM_STATUS_CHANGED);
            intent.setPackage(context.getPackageName());
            this.mItemStatusPendingIntent = PendingIntent.getBroadcast(context, 0, intent, 67108864);
            Intent intent2 = new Intent(ActionReceiver.ACTION_SESSION_STATUS_CHANGED);
            intent2.setPackage(context.getPackageName());
            this.mSessionStatusPendingIntent = PendingIntent.getBroadcast(context, 0, intent2, 67108864);
            Intent intent3 = new Intent(ActionReceiver.ACTION_MESSAGE_RECEIVED);
            intent3.setPackage(context.getPackageName());
            this.mMessagePendingIntent = PendingIntent.getBroadcast(context, 0, intent3, 67108864);
            detectFeatures();
        } else {
            throw new IllegalArgumentException("route must not be null");
        }
    }

    public void release() {
        this.mContext.unregisterReceiver(this.mActionReceiver);
    }

    public boolean isRemotePlaybackSupported() {
        return this.mRouteSupportsRemotePlayback;
    }

    public boolean isQueuingSupported() {
        return this.mRouteSupportsQueuing;
    }

    public boolean isSessionManagementSupported() {
        return this.mRouteSupportsSessionManagement;
    }

    public boolean isMessagingSupported() {
        return this.mRouteSupportsMessaging;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public void setSessionId(String str) {
        if (!ObjectsCompat.equals(this.mSessionId, str)) {
            if (DEBUG) {
                Log.d(TAG, "Session id is now: " + str);
            }
            this.mSessionId = str;
            StatusCallback statusCallback = this.mStatusCallback;
            if (statusCallback != null) {
                statusCallback.onSessionChanged(str);
            }
        }
    }

    public boolean hasSession() {
        return this.mSessionId != null;
    }

    public void setStatusCallback(StatusCallback statusCallback) {
        this.mStatusCallback = statusCallback;
    }

    public void setOnMessageReceivedListener(OnMessageReceivedListener onMessageReceivedListener) {
        this.mOnMessageReceivedListener = onMessageReceivedListener;
    }

    public void play(Uri uri, String str, Bundle bundle, long j, Bundle bundle2, ItemActionCallback itemActionCallback) {
        playOrEnqueue(uri, str, bundle, j, bundle2, itemActionCallback, MediaControlIntent.ACTION_PLAY);
    }

    public void enqueue(Uri uri, String str, Bundle bundle, long j, Bundle bundle2, ItemActionCallback itemActionCallback) {
        playOrEnqueue(uri, str, bundle, j, bundle2, itemActionCallback, MediaControlIntent.ACTION_ENQUEUE);
    }

    private void playOrEnqueue(Uri uri, String str, Bundle bundle, long j, Bundle bundle2, ItemActionCallback itemActionCallback, String str2) {
        if (uri != null) {
            throwIfRemotePlaybackNotSupported();
            if (str2.equals(MediaControlIntent.ACTION_ENQUEUE)) {
                throwIfQueuingNotSupported();
            }
            Intent intent = new Intent(str2);
            intent.setDataAndType(uri, str);
            intent.putExtra(MediaControlIntent.EXTRA_ITEM_STATUS_UPDATE_RECEIVER, this.mItemStatusPendingIntent);
            if (bundle != null) {
                intent.putExtra(MediaControlIntent.EXTRA_ITEM_METADATA, bundle);
            }
            if (j != 0) {
                intent.putExtra(MediaControlIntent.EXTRA_ITEM_CONTENT_POSITION, j);
            }
            performItemAction(intent, this.mSessionId, (String) null, bundle2, itemActionCallback);
            return;
        }
        throw new IllegalArgumentException("contentUri must not be null");
    }

    public void seek(String str, long j, Bundle bundle, ItemActionCallback itemActionCallback) {
        if (str != null) {
            throwIfNoCurrentSession();
            Intent intent = new Intent(MediaControlIntent.ACTION_SEEK);
            intent.putExtra(MediaControlIntent.EXTRA_ITEM_CONTENT_POSITION, j);
            performItemAction(intent, this.mSessionId, str, bundle, itemActionCallback);
            return;
        }
        throw new IllegalArgumentException("itemId must not be null");
    }

    public void getStatus(String str, Bundle bundle, ItemActionCallback itemActionCallback) {
        if (str != null) {
            throwIfNoCurrentSession();
            performItemAction(new Intent(MediaControlIntent.ACTION_GET_STATUS), this.mSessionId, str, bundle, itemActionCallback);
            return;
        }
        throw new IllegalArgumentException("itemId must not be null");
    }

    public void remove(String str, Bundle bundle, ItemActionCallback itemActionCallback) {
        if (str != null) {
            throwIfQueuingNotSupported();
            throwIfNoCurrentSession();
            performItemAction(new Intent(MediaControlIntent.ACTION_REMOVE), this.mSessionId, str, bundle, itemActionCallback);
            return;
        }
        throw new IllegalArgumentException("itemId must not be null");
    }

    public void pause(Bundle bundle, SessionActionCallback sessionActionCallback) {
        throwIfNoCurrentSession();
        performSessionAction(new Intent(MediaControlIntent.ACTION_PAUSE), this.mSessionId, bundle, sessionActionCallback);
    }

    public void resume(Bundle bundle, SessionActionCallback sessionActionCallback) {
        throwIfNoCurrentSession();
        performSessionAction(new Intent(MediaControlIntent.ACTION_RESUME), this.mSessionId, bundle, sessionActionCallback);
    }

    public void stop(Bundle bundle, SessionActionCallback sessionActionCallback) {
        throwIfNoCurrentSession();
        performSessionAction(new Intent(MediaControlIntent.ACTION_STOP), this.mSessionId, bundle, sessionActionCallback);
    }

    public void startSession(Bundle bundle, SessionActionCallback sessionActionCallback) {
        throwIfSessionManagementNotSupported();
        Intent intent = new Intent(MediaControlIntent.ACTION_START_SESSION);
        intent.putExtra(MediaControlIntent.EXTRA_SESSION_STATUS_UPDATE_RECEIVER, this.mSessionStatusPendingIntent);
        if (this.mRouteSupportsMessaging) {
            intent.putExtra(MediaControlIntent.EXTRA_MESSAGE_RECEIVER, this.mMessagePendingIntent);
        }
        performSessionAction(intent, (String) null, bundle, sessionActionCallback);
    }

    public void sendMessage(Bundle bundle, SessionActionCallback sessionActionCallback) {
        throwIfNoCurrentSession();
        throwIfMessageNotSupported();
        performSessionAction(new Intent(MediaControlIntent.ACTION_SEND_MESSAGE), this.mSessionId, bundle, sessionActionCallback);
    }

    public void getSessionStatus(Bundle bundle, SessionActionCallback sessionActionCallback) {
        throwIfSessionManagementNotSupported();
        throwIfNoCurrentSession();
        performSessionAction(new Intent(MediaControlIntent.ACTION_GET_SESSION_STATUS), this.mSessionId, bundle, sessionActionCallback);
    }

    public void endSession(Bundle bundle, SessionActionCallback sessionActionCallback) {
        throwIfSessionManagementNotSupported();
        throwIfNoCurrentSession();
        performSessionAction(new Intent(MediaControlIntent.ACTION_END_SESSION), this.mSessionId, bundle, sessionActionCallback);
    }

    private void performItemAction(Intent intent, String str, String str2, Bundle bundle, ItemActionCallback itemActionCallback) {
        intent.addCategory(MediaControlIntent.CATEGORY_REMOTE_PLAYBACK);
        if (str != null) {
            intent.putExtra(MediaControlIntent.EXTRA_SESSION_ID, str);
        }
        if (str2 != null) {
            intent.putExtra(MediaControlIntent.EXTRA_ITEM_ID, str2);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        logRequest(intent);
        final String str3 = str;
        final String str4 = str2;
        final Intent intent2 = intent;
        final ItemActionCallback itemActionCallback2 = itemActionCallback;
        this.mRoute.sendControlRequest(intent, new MediaRouter.ControlRequestCallback() {
            public void onResult(Bundle bundle) {
                if (bundle != null) {
                    String inferMissingResult = RemotePlaybackClient.inferMissingResult(str3, bundle.getString(MediaControlIntent.EXTRA_SESSION_ID));
                    MediaSessionStatus fromBundle = MediaSessionStatus.fromBundle(bundle.getBundle(MediaControlIntent.EXTRA_SESSION_STATUS));
                    String inferMissingResult2 = RemotePlaybackClient.inferMissingResult(str4, bundle.getString(MediaControlIntent.EXTRA_ITEM_ID));
                    MediaItemStatus fromBundle2 = MediaItemStatus.fromBundle(bundle.getBundle(MediaControlIntent.EXTRA_ITEM_STATUS));
                    RemotePlaybackClient.this.adoptSession(inferMissingResult);
                    if (!(inferMissingResult == null || inferMissingResult2 == null || fromBundle2 == null)) {
                        if (RemotePlaybackClient.DEBUG) {
                            Log.d(RemotePlaybackClient.TAG, "Received result from " + intent2.getAction() + ": data=" + RemotePlaybackClient.bundleToString(bundle) + ", sessionId=" + inferMissingResult + ", sessionStatus=" + fromBundle + ", itemId=" + inferMissingResult2 + ", itemStatus=" + fromBundle2);
                        }
                        itemActionCallback2.onResult(bundle, inferMissingResult, fromBundle, inferMissingResult2, fromBundle2);
                        return;
                    }
                }
                RemotePlaybackClient.this.handleInvalidResult(intent2, itemActionCallback2, bundle);
            }

            public void onError(String str, Bundle bundle) {
                RemotePlaybackClient.this.handleError(intent2, itemActionCallback2, str, bundle);
            }
        });
    }

    private void performSessionAction(final Intent intent, final String str, Bundle bundle, final SessionActionCallback sessionActionCallback) {
        intent.addCategory(MediaControlIntent.CATEGORY_REMOTE_PLAYBACK);
        if (str != null) {
            intent.putExtra(MediaControlIntent.EXTRA_SESSION_ID, str);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        logRequest(intent);
        this.mRoute.sendControlRequest(intent, new MediaRouter.ControlRequestCallback() {
            public void onResult(Bundle bundle) {
                boolean equals;
                boolean equals2;
                if (bundle != null) {
                    String inferMissingResult = RemotePlaybackClient.inferMissingResult(str, bundle.getString(MediaControlIntent.EXTRA_SESSION_ID));
                    MediaSessionStatus fromBundle = MediaSessionStatus.fromBundle(bundle.getBundle(MediaControlIntent.EXTRA_SESSION_STATUS));
                    RemotePlaybackClient.this.adoptSession(inferMissingResult);
                    if (inferMissingResult != null) {
                        if (RemotePlaybackClient.DEBUG) {
                            Log.d(RemotePlaybackClient.TAG, "Received result from " + intent.getAction() + ": data=" + RemotePlaybackClient.bundleToString(bundle) + ", sessionId=" + inferMissingResult + ", sessionStatus=" + fromBundle);
                        }
                        try {
                            sessionActionCallback.onResult(bundle, inferMissingResult, fromBundle);
                            if (equals && equals2) {
                                return;
                            }
                            return;
                        } finally {
                            if (intent.getAction().equals(MediaControlIntent.ACTION_END_SESSION) && inferMissingResult.equals(RemotePlaybackClient.this.mSessionId)) {
                                RemotePlaybackClient.this.setSessionId((String) null);
                            }
                        }
                    }
                }
                RemotePlaybackClient.this.handleInvalidResult(intent, sessionActionCallback, bundle);
            }

            public void onError(String str, Bundle bundle) {
                RemotePlaybackClient.this.handleError(intent, sessionActionCallback, str, bundle);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void adoptSession(String str) {
        if (str != null) {
            setSessionId(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void handleInvalidResult(Intent intent, ActionCallback actionCallback, Bundle bundle) {
        Log.w(TAG, "Received invalid result data from " + intent.getAction() + ": data=" + bundleToString(bundle));
        actionCallback.onError((String) null, 0, bundle);
    }

    /* access modifiers changed from: package-private */
    public void handleError(Intent intent, ActionCallback actionCallback, String str, Bundle bundle) {
        int i = 0;
        if (bundle != null) {
            i = bundle.getInt(MediaControlIntent.EXTRA_ERROR_CODE, 0);
        }
        if (DEBUG) {
            Log.w(TAG, "Received error from " + intent.getAction() + ": error=" + str + ", code=" + i + ", data=" + bundleToString(bundle));
        }
        actionCallback.onError(str, i, bundle);
    }

    private void detectFeatures() {
        boolean z = true;
        boolean z2 = routeSupportsAction(MediaControlIntent.ACTION_PLAY) && routeSupportsAction(MediaControlIntent.ACTION_SEEK) && routeSupportsAction(MediaControlIntent.ACTION_GET_STATUS) && routeSupportsAction(MediaControlIntent.ACTION_PAUSE) && routeSupportsAction(MediaControlIntent.ACTION_RESUME) && routeSupportsAction(MediaControlIntent.ACTION_STOP);
        this.mRouteSupportsRemotePlayback = z2;
        this.mRouteSupportsQueuing = z2 && routeSupportsAction(MediaControlIntent.ACTION_ENQUEUE) && routeSupportsAction(MediaControlIntent.ACTION_REMOVE);
        if (!this.mRouteSupportsRemotePlayback || !routeSupportsAction(MediaControlIntent.ACTION_START_SESSION) || !routeSupportsAction(MediaControlIntent.ACTION_GET_SESSION_STATUS) || !routeSupportsAction(MediaControlIntent.ACTION_END_SESSION)) {
            z = false;
        }
        this.mRouteSupportsSessionManagement = z;
        this.mRouteSupportsMessaging = doesRouteSupportMessaging();
    }

    private boolean routeSupportsAction(String str) {
        return this.mRoute.supportsControlAction(MediaControlIntent.CATEGORY_REMOTE_PLAYBACK, str);
    }

    private boolean doesRouteSupportMessaging() {
        for (IntentFilter hasAction : this.mRoute.getControlFilters()) {
            if (hasAction.hasAction(MediaControlIntent.ACTION_SEND_MESSAGE)) {
                return true;
            }
        }
        return false;
    }

    private void throwIfRemotePlaybackNotSupported() {
        if (!this.mRouteSupportsRemotePlayback) {
            throw new UnsupportedOperationException("The route does not support remote playback.");
        }
    }

    private void throwIfQueuingNotSupported() {
        if (!this.mRouteSupportsQueuing) {
            throw new UnsupportedOperationException("The route does not support queuing.");
        }
    }

    private void throwIfSessionManagementNotSupported() {
        if (!this.mRouteSupportsSessionManagement) {
            throw new UnsupportedOperationException("The route does not support session management.");
        }
    }

    private void throwIfMessageNotSupported() {
        if (!this.mRouteSupportsMessaging) {
            throw new UnsupportedOperationException("The route does not support message.");
        }
    }

    private void throwIfNoCurrentSession() {
        if (this.mSessionId == null) {
            throw new IllegalStateException("There is no current session.");
        }
    }

    static String inferMissingResult(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        if (str == null || str.equals(str2)) {
            return str2;
        }
        return null;
    }

    private static void logRequest(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "Sending request: " + intent);
        }
    }

    static String bundleToString(Bundle bundle) {
        if (bundle == null) {
            return AbstractJsonLexerKt.NULL;
        }
        bundle.size();
        return bundle.toString();
    }

    private final class ActionReceiver extends BroadcastReceiver {
        public static final String ACTION_ITEM_STATUS_CHANGED = "androidx.mediarouter.media.actions.ACTION_ITEM_STATUS_CHANGED";
        public static final String ACTION_MESSAGE_RECEIVED = "androidx.mediarouter.media.actions.ACTION_MESSAGE_RECEIVED";
        public static final String ACTION_SESSION_STATUS_CHANGED = "androidx.mediarouter.media.actions.ACTION_SESSION_STATUS_CHANGED";

        ActionReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(MediaControlIntent.EXTRA_SESSION_ID);
            if (stringExtra == null || !stringExtra.equals(RemotePlaybackClient.this.mSessionId)) {
                Log.w(RemotePlaybackClient.TAG, "Discarding spurious status callback with missing or invalid session id: sessionId=" + stringExtra);
                return;
            }
            MediaSessionStatus fromBundle = MediaSessionStatus.fromBundle(intent.getBundleExtra(MediaControlIntent.EXTRA_SESSION_STATUS));
            String action = intent.getAction();
            if (action.equals(ACTION_ITEM_STATUS_CHANGED)) {
                String stringExtra2 = intent.getStringExtra(MediaControlIntent.EXTRA_ITEM_ID);
                if (stringExtra2 == null) {
                    Log.w(RemotePlaybackClient.TAG, "Discarding spurious status callback with missing item id.");
                    return;
                }
                MediaItemStatus fromBundle2 = MediaItemStatus.fromBundle(intent.getBundleExtra(MediaControlIntent.EXTRA_ITEM_STATUS));
                if (fromBundle2 == null) {
                    Log.w(RemotePlaybackClient.TAG, "Discarding spurious status callback with missing item status.");
                    return;
                }
                if (RemotePlaybackClient.DEBUG) {
                    Log.d(RemotePlaybackClient.TAG, "Received item status callback: sessionId=" + stringExtra + ", sessionStatus=" + fromBundle + ", itemId=" + stringExtra2 + ", itemStatus=" + fromBundle2);
                }
                if (RemotePlaybackClient.this.mStatusCallback != null) {
                    RemotePlaybackClient.this.mStatusCallback.onItemStatusChanged(intent.getExtras(), stringExtra, fromBundle, stringExtra2, fromBundle2);
                }
            } else if (action.equals(ACTION_SESSION_STATUS_CHANGED)) {
                if (fromBundle == null) {
                    Log.w(RemotePlaybackClient.TAG, "Discarding spurious media status callback with missing session status.");
                    return;
                }
                if (RemotePlaybackClient.DEBUG) {
                    Log.d(RemotePlaybackClient.TAG, "Received session status callback: sessionId=" + stringExtra + ", sessionStatus=" + fromBundle);
                }
                if (RemotePlaybackClient.this.mStatusCallback != null) {
                    RemotePlaybackClient.this.mStatusCallback.onSessionStatusChanged(intent.getExtras(), stringExtra, fromBundle);
                }
            } else if (action.equals(ACTION_MESSAGE_RECEIVED)) {
                if (RemotePlaybackClient.DEBUG) {
                    Log.d(RemotePlaybackClient.TAG, "Received message callback: sessionId=" + stringExtra);
                }
                if (RemotePlaybackClient.this.mOnMessageReceivedListener != null) {
                    RemotePlaybackClient.this.mOnMessageReceivedListener.onMessageReceived(stringExtra, intent.getBundleExtra(MediaControlIntent.EXTRA_MESSAGE));
                }
            }
        }
    }
}
