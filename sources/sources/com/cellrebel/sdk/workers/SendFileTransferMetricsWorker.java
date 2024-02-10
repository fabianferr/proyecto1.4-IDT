package com.cellrebel.sdk.workers;

import android.os.Handler;
import android.os.HandlerThread;
import com.cellrebel.sdk.database.dao.FileTransferMetricDAO;
import com.cellrebel.sdk.networking.beans.request.FileTransferMetric;
import com.cellrebel.sdk.utils.ThreadPoolProvider;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendFileTransferMetricsWorker extends BaseMetricsWorker {
    /* access modifiers changed from: private */
    public volatile CountDownLatch j = new CountDownLatch(1);
    /* access modifiers changed from: private */
    public Call<Void> k;

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (SendFileTransferMetricsWorker.this.k != null && !SendFileTransferMetricsWorker.this.k.isCanceled()) {
                SendFileTransferMetricsWorker.this.k.cancel();
            }
        }
    }

    class b implements Callback<Void> {
        final /* synthetic */ HandlerThread a;
        final /* synthetic */ Handler b;
        final /* synthetic */ FileTransferMetricDAO c;
        final /* synthetic */ List d;

        b(HandlerThread handlerThread, Handler handler, FileTransferMetricDAO fileTransferMetricDAO, List list) {
            this.a = handlerThread;
            this.b = handler;
            this.c = fileTransferMetricDAO;
            this.d = list;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String a(Handler handler, Throwable th, List list, FileTransferMetricDAO fileTransferMetricDAO) {
            handler.removeCallbacksAndMessages((Object) null);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((FileTransferMetric) it.next()).isSending(false);
            }
            fileTransferMetricDAO.a((List<FileTransferMetric>) list);
            SendFileTransferMetricsWorker.this.j.countDown();
            return null;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String a(Handler handler, Response response, FileTransferMetricDAO fileTransferMetricDAO, List list) {
            handler.removeCallbacksAndMessages((Object) null);
            if (response.isSuccessful()) {
                fileTransferMetricDAO.a();
            } else {
                response.toString();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((FileTransferMetric) it.next()).isSending(false);
                }
                fileTransferMetricDAO.a((List<FileTransferMetric>) list);
            }
            SendFileTransferMetricsWorker.this.j.countDown();
            return null;
        }

        public void onFailure(Call<Void> call, Throwable th) {
            try {
                this.a.quit();
                ThreadPoolProvider.a().a(new SendFileTransferMetricsWorker$b$$ExternalSyntheticLambda0(this, this.b, th, this.d, this.c));
            } catch (Exception | OutOfMemoryError unused) {
            }
        }

        public void onResponse(Call<Void> call, Response<Void> response) {
            try {
                this.a.quit();
                ThreadPoolProvider.a().a(new SendFileTransferMetricsWorker$b$$ExternalSyntheticLambda1(this, this.b, response, this.c, this.d));
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:12:0x0072] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r8) {
        /*
            r7 = this;
            com.cellrebel.sdk.database.SDKRoomDatabase r8 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{  }
            if (r8 != 0) goto L_0x0007
            return
        L_0x0007:
            com.cellrebel.sdk.database.SDKRoomDatabase r8 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{  }
            com.cellrebel.sdk.database.dao.FileTransferMetricDAO r4 = r8.i()     // Catch:{  }
            java.util.List r5 = r4.b()     // Catch:{  }
            int r8 = r5.size()     // Catch:{  }
            if (r8 != 0) goto L_0x001a
            return
        L_0x001a:
            java.util.Iterator r8 = r5.iterator()     // Catch:{  }
        L_0x001e:
            boolean r0 = r8.hasNext()     // Catch:{  }
            if (r0 == 0) goto L_0x002f
            java.lang.Object r0 = r8.next()     // Catch:{  }
            com.cellrebel.sdk.networking.beans.request.FileTransferMetric r0 = (com.cellrebel.sdk.networking.beans.request.FileTransferMetric) r0     // Catch:{  }
            r1 = 1
            r0.isSending(r1)     // Catch:{  }
            goto L_0x001e
        L_0x002f:
            r4.a((java.util.List<com.cellrebel.sdk.networking.beans.request.FileTransferMetric>) r5)     // Catch:{  }
            android.os.HandlerThread r2 = new android.os.HandlerThread     // Catch:{  }
            java.lang.String r8 = "CustomTimeoutThread"
            r2.<init>(r8)     // Catch:{  }
            r2.start()     // Catch:{  }
            android.os.Handler r3 = new android.os.Handler     // Catch:{  }
            android.os.Looper r8 = r2.getLooper()     // Catch:{  }
            r3.<init>(r8)     // Catch:{  }
            com.cellrebel.sdk.workers.SendFileTransferMetricsWorker$a r8 = new com.cellrebel.sdk.workers.SendFileTransferMetricsWorker$a     // Catch:{  }
            r8.<init>()     // Catch:{  }
            r0 = 15000(0x3a98, double:7.411E-320)
            r3.postDelayed(r8, r0)     // Catch:{  }
            r5.toString()     // Catch:{  }
            com.cellrebel.sdk.utils.SettingsManager r8 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{  }
            com.cellrebel.sdk.networking.beans.response.Settings r8 = r8.c()     // Catch:{  }
            com.cellrebel.sdk.networking.ApiService r0 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{  }
            java.lang.String r8 = com.cellrebel.sdk.networking.UrlProvider.a(r8)     // Catch:{  }
            retrofit2.Call r8 = r0.n(r5, r8)     // Catch:{  }
            r7.k = r8     // Catch:{  }
            com.cellrebel.sdk.workers.SendFileTransferMetricsWorker$b r6 = new com.cellrebel.sdk.workers.SendFileTransferMetricsWorker$b     // Catch:{  }
            r0 = r6
            r1 = r7
            r0.<init>(r2, r3, r4, r5)     // Catch:{  }
            r8.enqueue(r6)     // Catch:{  }
            java.util.concurrent.CountDownLatch r8 = r7.j     // Catch:{ Exception | OutOfMemoryError -> 0x0077, Exception | OutOfMemoryError -> 0x0077 }
            r8.await()     // Catch:{ Exception | OutOfMemoryError -> 0x0077, Exception | OutOfMemoryError -> 0x0077 }
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.SendFileTransferMetricsWorker.a(android.content.Context):void");
    }
}
