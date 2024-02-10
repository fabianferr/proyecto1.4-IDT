package com.cellrebel.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.workers.CollectCellInfoMetricsWorker;
import com.cellrebel.sdk.workers.CollectVoiceCallWorker;
import com.cellrebel.sdk.workers.SendVoiceCallWorker;

public class PhoneStateReceiver extends BroadcastReceiver {
    /* access modifiers changed from: private */
    public static /* synthetic */ String a(double d, boolean z, boolean z2, Context context) {
        CollectVoiceCallWorker collectVoiceCallWorker = new CollectVoiceCallWorker();
        collectVoiceCallWorker.k = (int) System.currentTimeMillis();
        collectVoiceCallWorker.j = (int) d;
        collectVoiceCallWorker.d = true;
        collectVoiceCallWorker.e = z;
        collectVoiceCallWorker.f = z2;
        collectVoiceCallWorker.a(context);
        new SendVoiceCallWorker().a(context);
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String a(Settings settings, boolean z, boolean z2, boolean z3, Context context) {
        if (settings == null || !settings.coverageMeasurement().booleanValue()) {
            return null;
        }
        CollectCellInfoMetricsWorker collectCellInfoMetricsWorker = new CollectCellInfoMetricsWorker();
        collectCellInfoMetricsWorker.d = z;
        collectCellInfoMetricsWorker.e = z2;
        collectCellInfoMetricsWorker.f = z3;
        collectCellInfoMetricsWorker.a(context);
        return null;
    }

    public void onReceive(Context context, Intent intent) {
        double b = (double) PreferencesManager.m().b();
        Settings c = SettingsManager.b().c();
        try {
            if (DatabaseClient.a() != null) {
                String stringExtra = intent.getStringExtra("state");
                boolean equals = stringExtra.equals(TelephonyManager.EXTRA_STATE_IDLE);
                boolean equals2 = stringExtra.equals(TelephonyManager.EXTRA_STATE_OFFHOOK);
                boolean equals3 = stringExtra.equals(TelephonyManager.EXTRA_STATE_RINGING);
                PreferencesManager.m().a(equals3, equals2, equals);
                ThreadPoolProvider.a().b(new PhoneStateReceiver$$ExternalSyntheticLambda0(c, equals, equals2, equals3, context));
                if (equals2) {
                    PreferencesManager.m().a(System.currentTimeMillis());
                }
                if (equals && b != 0.0d && c.voiceCallMeasurements().booleanValue()) {
                    ThreadPoolProvider.a().b(new PhoneStateReceiver$$ExternalSyntheticLambda1(b, equals2, equals3, context));
                    PreferencesManager.m().a(0);
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }
}
