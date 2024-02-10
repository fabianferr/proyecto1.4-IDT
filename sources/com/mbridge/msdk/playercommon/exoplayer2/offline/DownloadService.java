package com.mbridge.msdk.playercommon.exoplayer2.offline;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager;
import com.mbridge.msdk.playercommon.exoplayer2.scheduler.Requirements;
import com.mbridge.msdk.playercommon.exoplayer2.scheduler.RequirementsWatcher;
import com.mbridge.msdk.playercommon.exoplayer2.scheduler.Scheduler;
import com.mbridge.msdk.playercommon.exoplayer2.util.NotificationUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.HashMap;

public abstract class DownloadService extends Service {
    public static final String ACTION_ADD = "com.google.android.exoplayer.downloadService.action.ADD";
    public static final String ACTION_INIT = "com.google.android.exoplayer.downloadService.action.INIT";
    private static final String ACTION_RESTART = "com.google.android.exoplayer.downloadService.action.RESTART";
    private static final String ACTION_START_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.START_DOWNLOADS";
    private static final String ACTION_STOP_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.STOP_DOWNLOADS";
    private static final boolean DEBUG = false;
    public static final long DEFAULT_FOREGROUND_NOTIFICATION_UPDATE_INTERVAL = 1000;
    public static final String KEY_DOWNLOAD_ACTION = "download_action";
    public static final String KEY_FOREGROUND = "foreground";
    private static final String TAG = "DownloadService";
    private static final HashMap<Class<? extends DownloadService>, RequirementsHelper> requirementsHelpers = new HashMap<>();
    private final String channelId;
    private final int channelName;
    /* access modifiers changed from: private */
    public DownloadManager downloadManager;
    private DownloadManagerListener downloadManagerListener;
    /* access modifiers changed from: private */
    public final ForegroundNotificationUpdater foregroundNotificationUpdater;
    private int lastStartId;
    private boolean startedInForeground;
    private boolean taskRemoved;

    private void logd(String str) {
    }

    /* access modifiers changed from: protected */
    public abstract DownloadManager getDownloadManager();

    /* access modifiers changed from: protected */
    public abstract Notification getForegroundNotification(DownloadManager.TaskState[] taskStateArr);

    /* access modifiers changed from: protected */
    public abstract Scheduler getScheduler();

    public IBinder onBind(Intent intent) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onTaskStateChanged(DownloadManager.TaskState taskState) {
    }

    protected DownloadService(int i) {
        this(i, 1000);
    }

    protected DownloadService(int i, long j) {
        this(i, j, (String) null, 0);
    }

    protected DownloadService(int i, long j, String str, int i2) {
        this.foregroundNotificationUpdater = new ForegroundNotificationUpdater(i, j);
        this.channelId = str;
        this.channelName = i2;
    }

    public static Intent buildAddActionIntent(Context context, Class<? extends DownloadService> cls, DownloadAction downloadAction, boolean z) {
        return new Intent(context, cls).setAction(ACTION_ADD).putExtra(KEY_DOWNLOAD_ACTION, downloadAction.toByteArray()).putExtra("foreground", z);
    }

    public static void startWithAction(Context context, Class<? extends DownloadService> cls, DownloadAction downloadAction, boolean z) {
        Intent buildAddActionIntent = buildAddActionIntent(context, cls, downloadAction, z);
        if (z) {
            Util.startForegroundService(context, buildAddActionIntent);
        } else {
            context.startService(buildAddActionIntent);
        }
    }

    public static void start(Context context, Class<? extends DownloadService> cls) {
        context.startService(new Intent(context, cls).setAction("com.google.android.exoplayer.downloadService.action.INIT"));
    }

    public static void startForeground(Context context, Class<? extends DownloadService> cls) {
        Util.startForegroundService(context, new Intent(context, cls).setAction("com.google.android.exoplayer.downloadService.action.INIT").putExtra("foreground", true));
    }

    public void onCreate() {
        logd("onCreate");
        String str = this.channelId;
        if (str != null) {
            NotificationUtil.createNotificationChannel(this, str, this.channelName, 2);
        }
        this.downloadManager = getDownloadManager();
        DownloadManagerListener downloadManagerListener2 = new DownloadManagerListener();
        this.downloadManagerListener = downloadManagerListener2;
        this.downloadManager.addListener(downloadManagerListener2);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
        if (r2.equals(ACTION_RESTART) == false) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(android.content.Intent r7, int r8, int r9) {
        /*
            r6 = this;
            r6.lastStartId = r9
            r8 = 0
            r6.taskRemoved = r8
            java.lang.String r0 = "com.google.android.exoplayer.downloadService.action.RESTART"
            r1 = 1
            if (r7 == 0) goto L_0x0026
            java.lang.String r2 = r7.getAction()
            boolean r3 = r6.startedInForeground
            java.lang.String r4 = "foreground"
            boolean r4 = r7.getBooleanExtra(r4, r8)
            if (r4 != 0) goto L_0x0021
            boolean r4 = r0.equals(r2)
            if (r4 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r4 = 0
            goto L_0x0022
        L_0x0021:
            r4 = 1
        L_0x0022:
            r3 = r3 | r4
            r6.startedInForeground = r3
            goto L_0x0027
        L_0x0026:
            r2 = 0
        L_0x0027:
            java.lang.String r3 = "com.google.android.exoplayer.downloadService.action.INIT"
            if (r2 != 0) goto L_0x002c
            r2 = r3
        L_0x002c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "onStartCommand action: "
            r4.<init>(r5)
            r4.append(r2)
            java.lang.String r5 = " startId: "
            r4.append(r5)
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            r6.logd(r9)
            r2.hashCode()
            int r9 = r2.hashCode()
            r4 = -1
            switch(r9) {
                case -871181424: goto L_0x007c;
                case -382886238: goto L_0x0071;
                case -337334865: goto L_0x0066;
                case 1015676687: goto L_0x005d;
                case 1286088717: goto L_0x0052;
                default: goto L_0x0050;
            }
        L_0x0050:
            r8 = -1
            goto L_0x0083
        L_0x0052:
            java.lang.String r8 = "com.google.android.exoplayer.downloadService.action.STOP_DOWNLOADS"
            boolean r8 = r2.equals(r8)
            if (r8 != 0) goto L_0x005b
            goto L_0x0050
        L_0x005b:
            r8 = 4
            goto L_0x0083
        L_0x005d:
            boolean r8 = r2.equals(r3)
            if (r8 != 0) goto L_0x0064
            goto L_0x0050
        L_0x0064:
            r8 = 3
            goto L_0x0083
        L_0x0066:
            java.lang.String r8 = "com.google.android.exoplayer.downloadService.action.START_DOWNLOADS"
            boolean r8 = r2.equals(r8)
            if (r8 != 0) goto L_0x006f
            goto L_0x0050
        L_0x006f:
            r8 = 2
            goto L_0x0083
        L_0x0071:
            java.lang.String r8 = "com.google.android.exoplayer.downloadService.action.ADD"
            boolean r8 = r2.equals(r8)
            if (r8 != 0) goto L_0x007a
            goto L_0x0050
        L_0x007a:
            r8 = 1
            goto L_0x0083
        L_0x007c:
            boolean r9 = r2.equals(r0)
            if (r9 != 0) goto L_0x0083
            goto L_0x0050
        L_0x0083:
            java.lang.String r9 = "DownloadService"
            switch(r8) {
                case 0: goto L_0x00c0;
                case 1: goto L_0x00a6;
                case 2: goto L_0x00a0;
                case 3: goto L_0x00c0;
                case 4: goto L_0x009a;
                default: goto L_0x0088;
            }
        L_0x0088:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Ignoring unrecognized action: "
            r7.<init>(r8)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            android.util.Log.e(r9, r7)
            goto L_0x00c0
        L_0x009a:
            com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager r7 = r6.downloadManager
            r7.stopDownloads()
            goto L_0x00c0
        L_0x00a0:
            com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager r7 = r6.downloadManager
            r7.startDownloads()
            goto L_0x00c0
        L_0x00a6:
            java.lang.String r8 = "download_action"
            byte[] r7 = r7.getByteArrayExtra(r8)
            if (r7 != 0) goto L_0x00b4
            java.lang.String r7 = "Ignoring ADD action with no action data"
            android.util.Log.e(r9, r7)
            goto L_0x00c0
        L_0x00b4:
            com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager r8 = r6.downloadManager     // Catch:{ IOException -> 0x00ba }
            r8.handleAction((byte[]) r7)     // Catch:{ IOException -> 0x00ba }
            goto L_0x00c0
        L_0x00ba:
            r7 = move-exception
            java.lang.String r8 = "Failed to handle ADD action"
            android.util.Log.e(r9, r8, r7)
        L_0x00c0:
            r6.maybeStartWatchingRequirements()
            com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager r7 = r6.downloadManager
            boolean r7 = r7.isIdle()
            if (r7 == 0) goto L_0x00ce
            r6.stop()
        L_0x00ce:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadService.onStartCommand(android.content.Intent, int, int):int");
    }

    public void onTaskRemoved(Intent intent) {
        logd("onTaskRemoved rootIntent: " + intent);
        this.taskRemoved = true;
    }

    public void onDestroy() {
        logd("onDestroy");
        this.foregroundNotificationUpdater.stopPeriodicUpdates();
        this.downloadManager.removeListener(this.downloadManagerListener);
        maybeStopWatchingRequirements();
    }

    /* access modifiers changed from: protected */
    public Requirements getRequirements() {
        return new Requirements(1, false, false);
    }

    /* access modifiers changed from: private */
    public void maybeStartWatchingRequirements() {
        if (this.downloadManager.getDownloadCount() != 0) {
            Class<?> cls = getClass();
            HashMap<Class<? extends DownloadService>, RequirementsHelper> hashMap = requirementsHelpers;
            if (hashMap.get(cls) == null) {
                RequirementsHelper requirementsHelper = new RequirementsHelper(this, getRequirements(), getScheduler(), cls);
                hashMap.put(cls, requirementsHelper);
                requirementsHelper.start();
                logd("started watching requirements");
            }
        }
    }

    private void maybeStopWatchingRequirements() {
        RequirementsHelper remove;
        if (this.downloadManager.getDownloadCount() <= 0 && (remove = requirementsHelpers.remove(getClass())) != null) {
            remove.stop();
            logd("stopped watching requirements");
        }
    }

    /* access modifiers changed from: private */
    public void stop() {
        this.foregroundNotificationUpdater.stopPeriodicUpdates();
        if (this.startedInForeground && Util.SDK_INT >= 26) {
            this.foregroundNotificationUpdater.showNotificationIfNotAlready();
        }
        if (Util.SDK_INT >= 28 || !this.taskRemoved) {
            boolean stopSelfResult = stopSelfResult(this.lastStartId);
            logd("stopSelf(" + this.lastStartId + ") result: " + stopSelfResult);
            return;
        }
        stopSelf();
        logd("stopSelf()");
    }

    private final class DownloadManagerListener implements DownloadManager.Listener {
        private DownloadManagerListener() {
        }

        public final void onInitialized(DownloadManager downloadManager) {
            DownloadService.this.maybeStartWatchingRequirements();
        }

        public final void onTaskStateChanged(DownloadManager downloadManager, DownloadManager.TaskState taskState) {
            DownloadService.this.onTaskStateChanged(taskState);
            if (taskState.state == 1) {
                DownloadService.this.foregroundNotificationUpdater.startPeriodicUpdates();
            } else {
                DownloadService.this.foregroundNotificationUpdater.update();
            }
        }

        public final void onIdle(DownloadManager downloadManager) {
            DownloadService.this.stop();
        }
    }

    private final class ForegroundNotificationUpdater implements Runnable {
        private final Handler handler = new Handler(Looper.getMainLooper());
        private boolean notificationDisplayed;
        private final int notificationId;
        private boolean periodicUpdatesStarted;
        private final long updateInterval;

        public ForegroundNotificationUpdater(int i, long j) {
            this.notificationId = i;
            this.updateInterval = j;
        }

        public final void startPeriodicUpdates() {
            this.periodicUpdatesStarted = true;
            update();
        }

        public final void stopPeriodicUpdates() {
            this.periodicUpdatesStarted = false;
            this.handler.removeCallbacks(this);
        }

        public final void update() {
            DownloadManager.TaskState[] allTaskStates = DownloadService.this.downloadManager.getAllTaskStates();
            DownloadService downloadService = DownloadService.this;
            downloadService.startForeground(this.notificationId, downloadService.getForegroundNotification(allTaskStates));
            this.notificationDisplayed = true;
            if (this.periodicUpdatesStarted) {
                this.handler.removeCallbacks(this);
                this.handler.postDelayed(this, this.updateInterval);
            }
        }

        public final void showNotificationIfNotAlready() {
            if (!this.notificationDisplayed) {
                update();
            }
        }

        public final void run() {
            update();
        }
    }

    private static final class RequirementsHelper implements RequirementsWatcher.Listener {
        private final Context context;
        private final Requirements requirements;
        private final RequirementsWatcher requirementsWatcher;
        private final Scheduler scheduler;
        private final Class<? extends DownloadService> serviceClass;

        private RequirementsHelper(Context context2, Requirements requirements2, Scheduler scheduler2, Class<? extends DownloadService> cls) {
            this.context = context2;
            this.requirements = requirements2;
            this.scheduler = scheduler2;
            this.serviceClass = cls;
            this.requirementsWatcher = new RequirementsWatcher(context2, this, requirements2);
        }

        public final void start() {
            this.requirementsWatcher.start();
        }

        public final void stop() {
            this.requirementsWatcher.stop();
            Scheduler scheduler2 = this.scheduler;
            if (scheduler2 != null) {
                scheduler2.cancel();
            }
        }

        public final void requirementsMet(RequirementsWatcher requirementsWatcher2) {
            startServiceWithAction(DownloadService.ACTION_START_DOWNLOADS);
            Scheduler scheduler2 = this.scheduler;
            if (scheduler2 != null) {
                scheduler2.cancel();
            }
        }

        public final void requirementsNotMet(RequirementsWatcher requirementsWatcher2) {
            startServiceWithAction(DownloadService.ACTION_STOP_DOWNLOADS);
            if (this.scheduler != null) {
                if (!this.scheduler.schedule(this.requirements, this.context.getPackageName(), DownloadService.ACTION_RESTART)) {
                    Log.e(DownloadService.TAG, "Scheduling downloads failed.");
                }
            }
        }

        private void startServiceWithAction(String str) {
            Util.startForegroundService(this.context, new Intent(this.context, this.serviceClass).setAction(str).putExtra("foreground", true));
        }
    }
}
