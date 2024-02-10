package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.iid.zzav;
import com.google.firebase.iid.zzb;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class FirebaseMessagingService extends zzb {
    private static final Queue<String> zzdr = new ArrayDeque(10);

    public void onDeletedMessages() {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }

    /* access modifiers changed from: protected */
    public final Intent zzb(Intent intent) {
        return zzav.zzai().zzaj();
    }

    public final boolean zzc(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (!MessagingAnalytics.shouldUploadMetrics(intent)) {
            return true;
        }
        MessagingAnalytics.logNotificationOpen(intent);
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ea, code lost:
        if (r1.equals("send_error") == false) goto L_0x00d7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.content.Intent r12) {
        /*
            r11 = this;
            java.lang.String r0 = r12.getAction()
            java.lang.String r1 = "com.google.android.c2dm.intent.RECEIVE"
            boolean r1 = r1.equals(r0)
            java.lang.String r2 = "FirebaseMessaging"
            if (r1 != 0) goto L_0x0059
            java.lang.String r1 = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0017
            goto L_0x0059
        L_0x0017:
            java.lang.String r1 = "com.google.firebase.messaging.NOTIFICATION_DISMISS"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0029
            boolean r0 = com.google.firebase.messaging.MessagingAnalytics.shouldUploadMetrics(r12)
            if (r0 == 0) goto L_0x0058
            com.google.firebase.messaging.MessagingAnalytics.logNotificationDismiss(r12)
            return
        L_0x0029:
            java.lang.String r1 = "com.google.firebase.messaging.NEW_TOKEN"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = "token"
            java.lang.String r12 = r12.getStringExtra(r0)
            r11.onNewToken(r12)
            return
        L_0x003b:
            java.lang.String r12 = r12.getAction()
            java.lang.String r12 = java.lang.String.valueOf(r12)
            int r0 = r12.length()
            java.lang.String r1 = "Unknown intent action: "
            if (r0 == 0) goto L_0x0050
            java.lang.String r12 = r1.concat(r12)
            goto L_0x0055
        L_0x0050:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r1)
        L_0x0055:
            android.util.Log.d(r2, r12)
        L_0x0058:
            return
        L_0x0059:
            java.lang.String r0 = "google.message_id"
            java.lang.String r1 = r12.getStringExtra(r0)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            r4 = 2
            if (r3 == 0) goto L_0x006c
            r3 = 0
            com.google.android.gms.tasks.Task r3 = com.google.android.gms.tasks.Tasks.forResult(r3)
            goto L_0x007c
        L_0x006c:
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            r3.putString(r0, r1)
            com.google.firebase.iid.zzab r5 = com.google.firebase.iid.zzab.zzc(r11)
            com.google.android.gms.tasks.Task r3 = r5.zza(r4, r3)
        L_0x007c:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            r6 = 1
            r7 = 3
            r8 = 0
            if (r5 == 0) goto L_0x0087
        L_0x0085:
            r1 = 0
            goto L_0x00bf
        L_0x0087:
            java.util.Queue<java.lang.String> r5 = zzdr
            boolean r9 = r5.contains(r1)
            if (r9 == 0) goto L_0x00b0
            boolean r5 = android.util.Log.isLoggable(r2, r7)
            if (r5 == 0) goto L_0x00ae
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r5 = r1.length()
            java.lang.String r9 = "Received duplicate message: "
            if (r5 == 0) goto L_0x00a6
            java.lang.String r1 = r9.concat(r1)
            goto L_0x00ab
        L_0x00a6:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r9)
        L_0x00ab:
            android.util.Log.d(r2, r1)
        L_0x00ae:
            r1 = 1
            goto L_0x00bf
        L_0x00b0:
            int r9 = r5.size()
            r10 = 10
            if (r9 < r10) goto L_0x00bb
            r5.remove()
        L_0x00bb:
            r5.add(r1)
            goto L_0x0085
        L_0x00bf:
            if (r1 != 0) goto L_0x017f
            java.lang.String r1 = "message_type"
            java.lang.String r1 = r12.getStringExtra(r1)
            java.lang.String r5 = "gcm"
            if (r1 != 0) goto L_0x00cc
            r1 = r5
        L_0x00cc:
            r1.hashCode()
            int r9 = r1.hashCode()
            r10 = -1
            switch(r9) {
                case -2062414158: goto L_0x00f6;
                case 102161: goto L_0x00ed;
                case 814694033: goto L_0x00e4;
                case 814800675: goto L_0x00d9;
                default: goto L_0x00d7;
            }
        L_0x00d7:
            r4 = -1
            goto L_0x0100
        L_0x00d9:
            java.lang.String r4 = "send_event"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00e2
            goto L_0x00d7
        L_0x00e2:
            r4 = 3
            goto L_0x0100
        L_0x00e4:
            java.lang.String r5 = "send_error"
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x0100
            goto L_0x00d7
        L_0x00ed:
            boolean r4 = r1.equals(r5)
            if (r4 != 0) goto L_0x00f4
            goto L_0x00d7
        L_0x00f4:
            r4 = 1
            goto L_0x0100
        L_0x00f6:
            java.lang.String r4 = "deleted_messages"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00ff
            goto L_0x00d7
        L_0x00ff:
            r4 = 0
        L_0x0100:
            switch(r4) {
                case 0: goto L_0x017c;
                case 1: goto L_0x0140;
                case 2: goto L_0x0125;
                case 3: goto L_0x011d;
                default: goto L_0x0103;
            }
        L_0x0103:
            java.lang.String r12 = java.lang.String.valueOf(r1)
            int r0 = r12.length()
            java.lang.String r1 = "Received message with unknown type: "
            if (r0 == 0) goto L_0x0114
            java.lang.String r12 = r1.concat(r12)
            goto L_0x0119
        L_0x0114:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r1)
        L_0x0119:
            android.util.Log.w(r2, r12)
            goto L_0x017f
        L_0x011d:
            java.lang.String r12 = r12.getStringExtra(r0)
            r11.onMessageSent(r12)
            goto L_0x017f
        L_0x0125:
            java.lang.String r0 = r12.getStringExtra(r0)
            if (r0 != 0) goto L_0x0131
            java.lang.String r0 = "message_id"
            java.lang.String r0 = r12.getStringExtra(r0)
        L_0x0131:
            com.google.firebase.messaging.SendException r1 = new com.google.firebase.messaging.SendException
            java.lang.String r4 = "error"
            java.lang.String r12 = r12.getStringExtra(r4)
            r1.<init>(r12)
            r11.onSendError(r0, r1)
            goto L_0x017f
        L_0x0140:
            boolean r0 = com.google.firebase.messaging.MessagingAnalytics.shouldUploadMetrics(r12)
            if (r0 == 0) goto L_0x0149
            com.google.firebase.messaging.MessagingAnalytics.logNotificationReceived(r12)
        L_0x0149:
            android.os.Bundle r0 = r12.getExtras()
            if (r0 != 0) goto L_0x0154
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
        L_0x0154:
            java.lang.String r1 = "androidx.contentpager.content.wakelockid"
            r0.remove(r1)
            boolean r1 = com.google.firebase.messaging.zza.zzf(r0)
            if (r1 == 0) goto L_0x0173
            com.google.firebase.messaging.zza r1 = new com.google.firebase.messaging.zza
            r1.<init>(r11)
            boolean r1 = r1.zzh(r0)
            if (r1 != 0) goto L_0x017f
            boolean r1 = com.google.firebase.messaging.MessagingAnalytics.shouldUploadMetrics(r12)
            if (r1 == 0) goto L_0x0173
            com.google.firebase.messaging.MessagingAnalytics.logNotificationForeground(r12)
        L_0x0173:
            com.google.firebase.messaging.RemoteMessage r12 = new com.google.firebase.messaging.RemoteMessage
            r12.<init>(r0)
            r11.onMessageReceived(r12)
            goto L_0x017f
        L_0x017c:
            r11.onDeletedMessages()
        L_0x017f:
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x018b, InterruptedException -> 0x0189, TimeoutException -> 0x0187 }
            r0 = 1
            com.google.android.gms.tasks.Tasks.await(r3, r0, r12)     // Catch:{ ExecutionException -> 0x018b, InterruptedException -> 0x0189, TimeoutException -> 0x0187 }
            return
        L_0x0187:
            r12 = move-exception
            goto L_0x018c
        L_0x0189:
            r12 = move-exception
            goto L_0x018c
        L_0x018b:
            r12 = move-exception
        L_0x018c:
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r0 = java.lang.String.valueOf(r12)
            int r0 = r0.length()
            int r0 = r0 + 20
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Message ack failed: "
            r1.append(r0)
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            android.util.Log.w(r2, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.zzd(android.content.Intent):void");
    }

    static void zzj(Bundle bundle) {
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith("google.c.")) {
                it.remove();
            }
        }
    }
}
