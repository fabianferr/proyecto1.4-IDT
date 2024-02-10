package com.cellrebel.sdk.workers;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import androidx.core.app.ActivityCompat;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.networking.beans.request.BaseMetric;
import com.cellrebel.sdk.networking.beans.request.CellInfoMetric;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.utils.SettingsManager;
import com.cellrebel.sdk.utils.TelephonyHelper;
import com.cellrebel.sdk.utils.TrackingHelper;
import java.util.ArrayList;
import java.util.List;

public class CollectCellInfoMetricsWorker extends BaseMetricsWorker {
    public String j;

    class a implements TelephonyHelper.CellInfoCallback {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        public void a(List<CellInfo> list) {
            CollectCellInfoMetricsWorker.this.a(this.a, list);
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, List<CellInfo> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    BaseMetric baseMetric = new BaseMetric();
                    BaseMetricsWorker.a(context, baseMetric);
                    ArrayList arrayList = new ArrayList();
                    for (CellInfo fill : list) {
                        CellInfoMetric cellInfoMetric = new CellInfoMetric();
                        cellInfoMetric.fill(baseMetric);
                        cellInfoMetric.fill(fill);
                        cellInfoMetric.measurementSequenceId = this.j;
                        if (this.d || this.e || this.f) {
                            cellInfoMetric.stateDuringMeasurement = this.f ? 41 : this.e ? 42 : 43;
                        }
                        arrayList.add(cellInfoMetric);
                    }
                    if (DatabaseClient.a() != null) {
                        DatabaseClient.a().a().a((List<CellInfoMetric>) arrayList);
                    }
                }
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
    }

    public void a(Context context) {
        super.a(context);
        try {
            if (TrackingHelper.a().h(context) != null && ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                Settings c = SettingsManager.b().c();
                if (Build.VERSION.SDK_INT <= 29 || c == null || !c.cellInfoUpdateEnabled().booleanValue()) {
                    List<CellInfo> a2 = TelephonyHelper.b().a(context);
                    if (a2 == null || a2.size() == 0) {
                        if (TrackingHelper.a().i(context) != null) {
                            a2 = TelephonyHelper.b().a(context);
                        } else {
                            return;
                        }
                    }
                    a(context, a2);
                    return;
                }
                TelephonyHelper.b().a(context, (TelephonyHelper.CellInfoCallback) new a(context));
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }
}
