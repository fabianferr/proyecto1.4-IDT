package com.cellrebel.sdk.workers;

import android.os.Handler;
import android.os.HandlerThread;
import com.cellrebel.sdk.database.dao.PageLoadedMetricDAO;
import com.cellrebel.sdk.networking.beans.request.PageLoadMetric;
import com.cellrebel.sdk.utils.ThreadPoolProvider;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendPageLoadMetricsWorker extends BaseMetricsWorker {
    /* access modifiers changed from: private */
    public volatile CountDownLatch j = new CountDownLatch(1);
    /* access modifiers changed from: private */
    public Call<Void> k;
    PageLoadedMetricDAO l;

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (SendPageLoadMetricsWorker.this.k != null && !SendPageLoadMetricsWorker.this.k.isCanceled()) {
                SendPageLoadMetricsWorker.this.k.cancel();
            }
        }
    }

    class b implements Callback<Void> {
        final /* synthetic */ HandlerThread a;
        final /* synthetic */ Handler b;
        final /* synthetic */ List c;

        b(HandlerThread handlerThread, Handler handler, List list) {
            this.a = handlerThread;
            this.b = handler;
            this.c = list;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String a(Handler handler, Throwable th, List list) {
            handler.removeCallbacksAndMessages((Object) null);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((PageLoadMetric) it.next()).isSending(false);
            }
            SendPageLoadMetricsWorker.this.l.a((List<PageLoadMetric>) list);
            SendPageLoadMetricsWorker.this.j.countDown();
            return null;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String a(Handler handler, Response response, List list) {
            handler.removeCallbacksAndMessages((Object) null);
            if (response.isSuccessful()) {
                SendPageLoadMetricsWorker.this.l.a();
            } else {
                response.toString();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((PageLoadMetric) it.next()).isSending(false);
                }
                SendPageLoadMetricsWorker.this.l.a((List<PageLoadMetric>) list);
            }
            SendPageLoadMetricsWorker.this.j.countDown();
            return null;
        }

        public void onFailure(Call<Void> call, Throwable th) {
            try {
                this.a.quit();
                ThreadPoolProvider.a().a(new SendPageLoadMetricsWorker$b$$ExternalSyntheticLambda1(this, this.b, th, this.c));
            } catch (Exception | OutOfMemoryError unused) {
            }
        }

        public void onResponse(Call<Void> call, Response<Void> response) {
            try {
                this.a.quit();
                ThreadPoolProvider.a().a(new SendPageLoadMetricsWorker$b$$ExternalSyntheticLambda0(this, this.b, response, this.c));
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:12:0x0073] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r6) {
        /*
            r5 = this;
            com.cellrebel.sdk.database.SDKRoomDatabase r6 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{  }
            if (r6 != 0) goto L_0x0007
            return
        L_0x0007:
            com.cellrebel.sdk.database.SDKRoomDatabase r6 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{  }
            com.cellrebel.sdk.database.dao.PageLoadedMetricDAO r6 = r6.m()     // Catch:{  }
            r5.l = r6     // Catch:{  }
            java.util.List r6 = r6.b()     // Catch:{  }
            int r0 = r6.size()     // Catch:{  }
            if (r0 != 0) goto L_0x001c
            return
        L_0x001c:
            r0 = 0
        L_0x001d:
            int r1 = r6.size()     // Catch:{  }
            if (r0 >= r1) goto L_0x0030
            java.lang.Object r1 = r6.get(r0)     // Catch:{  }
            com.cellrebel.sdk.networking.beans.request.PageLoadMetric r1 = (com.cellrebel.sdk.networking.beans.request.PageLoadMetric) r1     // Catch:{  }
            r2 = 1
            r1.isSending(r2)     // Catch:{  }
            int r0 = r0 + 1
            goto L_0x001d
        L_0x0030:
            com.cellrebel.sdk.database.dao.PageLoadedMetricDAO r0 = r5.l     // Catch:{  }
            r0.a((java.util.List<com.cellrebel.sdk.networking.beans.request.PageLoadMetric>) r6)     // Catch:{  }
            android.os.HandlerThread r0 = new android.os.HandlerThread     // Catch:{  }
            java.lang.String r1 = "CustomTimeoutThread"
            r0.<init>(r1)     // Catch:{  }
            r0.start()     // Catch:{  }
            android.os.Handler r1 = new android.os.Handler     // Catch:{  }
            android.os.Looper r2 = r0.getLooper()     // Catch:{  }
            r1.<init>(r2)     // Catch:{  }
            com.cellrebel.sdk.workers.SendPageLoadMetricsWorker$a r2 = new com.cellrebel.sdk.workers.SendPageLoadMetricsWorker$a     // Catch:{  }
            r2.<init>()     // Catch:{  }
            r3 = 15000(0x3a98, double:7.411E-320)
            r1.postDelayed(r2, r3)     // Catch:{  }
            r6.toString()     // Catch:{  }
            com.cellrebel.sdk.utils.SettingsManager r2 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{  }
            com.cellrebel.sdk.networking.beans.response.Settings r2 = r2.c()     // Catch:{  }
            com.cellrebel.sdk.networking.ApiService r3 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{  }
            java.lang.String r2 = com.cellrebel.sdk.networking.UrlProvider.a(r2)     // Catch:{  }
            retrofit2.Call r2 = r3.a((java.util.List<com.cellrebel.sdk.networking.beans.request.PageLoadMetric>) r6, (java.lang.String) r2)     // Catch:{  }
            r5.k = r2     // Catch:{  }
            com.cellrebel.sdk.workers.SendPageLoadMetricsWorker$b r3 = new com.cellrebel.sdk.workers.SendPageLoadMetricsWorker$b     // Catch:{  }
            r3.<init>(r0, r1, r6)     // Catch:{  }
            r2.enqueue(r3)     // Catch:{  }
            java.util.concurrent.CountDownLatch r6 = r5.j     // Catch:{ Exception | OutOfMemoryError -> 0x0078, Exception | OutOfMemoryError -> 0x0078 }
            r6.await()     // Catch:{ Exception | OutOfMemoryError -> 0x0078, Exception | OutOfMemoryError -> 0x0078 }
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.SendPageLoadMetricsWorker.a(android.content.Context):void");
    }
}
