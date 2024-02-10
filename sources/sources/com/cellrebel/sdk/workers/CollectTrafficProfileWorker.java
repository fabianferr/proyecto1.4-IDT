package com.cellrebel.sdk.workers;

import android.content.Context;
import android.os.PowerManager;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.networking.beans.request.BaseMetric;
import com.cellrebel.sdk.networking.beans.request.TrafficProfileMetric;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.networking.beans.response.TrafficProfiles;
import com.cellrebel.sdk.ping.IPTools;
import com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurer;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfile;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfileMeasurementSettings;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfileResult;
import com.cellrebel.sdk.utils.PreferencesManager;
import com.cellrebel.sdk.utils.SettingsManager;
import com.cellrebel.sdk.utils.TrackingHelper;
import com.cellrebel.sdk.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CollectTrafficProfileWorker extends BaseMetricsWorker {
    static int k = 4445;
    String j;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(CountDownLatch countDownLatch) {
        try {
            countDownLatch.countDown();
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void a(Context context) {
        super.a(context);
        try {
            if (DatabaseClient.a() != null) {
                boolean e = Utils.e();
                BaseMetric baseMetric = new BaseMetric();
                baseMetric.measurementSequenceId = this.j;
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (!TrackingHelper.a().c()) {
                    baseMetric.stateDuringMeasurement = 500;
                } else if (!e) {
                    baseMetric.stateDuringMeasurement = 501;
                } else {
                    Utils.a(baseMetric, BaseMetricsWorker.h, this.c, powerManager, this.b, this.d, this.e, this.f, this.g);
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                BaseMetricsWorker.a(context, baseMetric, (Runnable) new CollectTrafficProfileWorker$$ExternalSyntheticLambda0(countDownLatch));
                countDownLatch.await();
                Settings c = SettingsManager.b().c();
                List<TrafficProfiles> trafficProfiles = c.trafficProfiles();
                ArrayList arrayList = new ArrayList();
                for (TrafficProfiles next : trafficProfiles) {
                    arrayList.add(new TrafficProfile(next.getId(), next.getName(), next.getDownlinkProfile().map(), next.getUplinkProfile().map(), next.getWeight()));
                }
                TrafficProfileMeasurementSettings trafficProfileMeasurementSettings = new TrafficProfileMeasurementSettings();
                trafficProfileMeasurementSettings.a = Arrays.asList(c.trafficProfileServerUrls().split(","));
                trafficProfileMeasurementSettings.b = k;
                trafficProfileMeasurementSettings.h = c.trafficProfileTimeout().intValue();
                trafficProfileMeasurementSettings.c = 5;
                trafficProfileMeasurementSettings.d = 1000;
                trafficProfileMeasurementSettings.e = arrayList;
                trafficProfileMeasurementSettings.f = c.trafficProfileMeasurementLimit().intValue();
                trafficProfileMeasurementSettings.g = PreferencesManager.m().w();
                List<TrafficProfileResult> e2 = new TrafficProfileMeasurer(context, trafficProfileMeasurementSettings).e();
                ArrayList arrayList2 = new ArrayList();
                for (TrafficProfileResult fill : e2) {
                    TrafficProfileMetric trafficProfileMetric = new TrafficProfileMetric();
                    trafficProfileMetric.copyFrom(baseMetric);
                    trafficProfileMetric.fill(fill);
                    String str = trafficProfileMetric.serverUrl;
                    if (str != null) {
                        trafficProfileMetric.serverIp = IPTools.b(str);
                    }
                    arrayList2.add(trafficProfileMetric);
                }
                DatabaseClient.a().s().a((List<TrafficProfileMetric>) arrayList2);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }
}
