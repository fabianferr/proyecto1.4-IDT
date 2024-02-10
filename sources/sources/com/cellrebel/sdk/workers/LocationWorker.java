package com.cellrebel.sdk.workers;

import android.os.Handler;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class LocationWorker extends BaseMetricsWorker {
    /* access modifiers changed from: private */
    public CountDownLatch j = new CountDownLatch(1);
    private final ScheduledExecutorService k = Executors.newSingleThreadScheduledExecutor();

    class a implements Runnable {
        a() {
        }

        public void run() {
            LocationWorker.this.j.countDown();
        }
    }

    class b extends LocationCallback {
        final /* synthetic */ Handler a;

        b(Handler handler) {
            this.a = handler;
        }

        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            this.a.removeCallbacksAndMessages((Object) null);
            try {
                LocationWorker.this.j.countDown();
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:4:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:2:0x001f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r5) {
        /*
            r4 = this;
            android.os.Handler r0 = new android.os.Handler     // Catch:{  }
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{  }
            r0.<init>(r1)     // Catch:{  }
            com.cellrebel.sdk.workers.LocationWorker$a r1 = new com.cellrebel.sdk.workers.LocationWorker$a     // Catch:{  }
            r1.<init>()     // Catch:{  }
            r2 = 15000(0x3a98, double:7.411E-320)
            r0.postDelayed(r1, r2)     // Catch:{  }
            com.cellrebel.sdk.utils.TrackingHelper r1 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{  }
            com.cellrebel.sdk.workers.LocationWorker$b r2 = new com.cellrebel.sdk.workers.LocationWorker$b     // Catch:{  }
            r2.<init>(r0)     // Catch:{  }
            r1.a((android.content.Context) r5, (com.google.android.gms.location.LocationCallback) r2)     // Catch:{  }
            java.util.concurrent.CountDownLatch r5 = r4.j     // Catch:{ Exception | OutOfMemoryError -> 0x0024, Exception | OutOfMemoryError -> 0x0024 }
            r5.await()     // Catch:{ Exception | OutOfMemoryError -> 0x0024, Exception | OutOfMemoryError -> 0x0024 }
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.LocationWorker.a(android.content.Context):void");
    }
}
