package com.cellrebel.sdk.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class SendConnectionMetricsWorker extends Worker {
    public SendConnectionMetricsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:9:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.work.ListenableWorker.Result doWork() {
        /*
            r4 = this;
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{  }
            if (r0 != 0) goto L_0x000b
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.success()     // Catch:{  }
            return r0
        L_0x000b:
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{  }
            com.cellrebel.sdk.database.dao.ConnectionMetricDAO r0 = r0.b()     // Catch:{  }
            java.util.List r1 = r0.getAll()     // Catch:{  }
            int r2 = r1.size()     // Catch:{  }
            if (r2 != 0) goto L_0x0022
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.success()     // Catch:{  }
            return r0
        L_0x0022:
            com.cellrebel.sdk.utils.SettingsManager r2 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ Exception | OutOfMemoryError -> 0x0043, Exception | OutOfMemoryError -> 0x0043 }
            com.cellrebel.sdk.networking.beans.response.Settings r2 = r2.c()     // Catch:{ Exception | OutOfMemoryError -> 0x0043, Exception | OutOfMemoryError -> 0x0043 }
            com.cellrebel.sdk.networking.ApiService r3 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x0043, Exception | OutOfMemoryError -> 0x0043 }
            java.lang.String r2 = com.cellrebel.sdk.networking.UrlProvider.a(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0043, Exception | OutOfMemoryError -> 0x0043 }
            retrofit2.Call r1 = r3.k(r1, r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0043, Exception | OutOfMemoryError -> 0x0043 }
            retrofit2.Response r1 = r1.execute()     // Catch:{ Exception | OutOfMemoryError -> 0x0043, Exception | OutOfMemoryError -> 0x0043 }
            boolean r1 = r1.isSuccessful()     // Catch:{ Exception | OutOfMemoryError -> 0x0043, Exception | OutOfMemoryError -> 0x0043 }
            if (r1 == 0) goto L_0x0043
            r0.a()     // Catch:{ Exception | OutOfMemoryError -> 0x0043, Exception | OutOfMemoryError -> 0x0043 }
        L_0x0043:
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.success()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.SendConnectionMetricsWorker.doWork():androidx.work.ListenableWorker$Result");
    }
}
