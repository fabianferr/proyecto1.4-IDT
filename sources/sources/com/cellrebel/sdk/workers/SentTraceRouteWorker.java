package com.cellrebel.sdk.workers;

import android.os.Handler;
import android.os.HandlerThread;
import com.cellrebel.sdk.database.dao.TraceRouteDAO;
import com.cellrebel.sdk.networking.beans.request.TraceRouteMetric;
import com.cellrebel.sdk.utils.ThreadPoolProvider;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SentTraceRouteWorker extends BaseMetricsWorker {
    /* access modifiers changed from: private */
    public volatile CountDownLatch j = new CountDownLatch(1);
    private Call<Void> k;
    TraceRouteDAO l;

    class a implements Callback<Void> {
        final /* synthetic */ HandlerThread a;
        final /* synthetic */ Handler b;
        final /* synthetic */ List c;

        a(HandlerThread handlerThread, Handler handler, List list) {
            this.a = handlerThread;
            this.b = handler;
            this.c = list;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String a(Handler handler, Throwable th, List list) {
            handler.removeCallbacksAndMessages((Object) null);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((TraceRouteMetric) it.next()).isSending(false);
            }
            SentTraceRouteWorker.this.l.a((List<TraceRouteMetric>) list);
            SentTraceRouteWorker.this.j.countDown();
            return null;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String a(Handler handler, Response response, List list) {
            handler.removeCallbacksAndMessages((Object) null);
            if (response.isSuccessful()) {
                SentTraceRouteWorker.this.l.a();
            } else {
                response.toString();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TraceRouteMetric) it.next()).isSending(false);
                }
                SentTraceRouteWorker.this.l.a((List<TraceRouteMetric>) list);
            }
            SentTraceRouteWorker.this.j.countDown();
            return null;
        }

        public void onFailure(Call<Void> call, Throwable th) {
            try {
                this.a.quit();
                ThreadPoolProvider.a().a(new SentTraceRouteWorker$a$$ExternalSyntheticLambda1(this, this.b, th, this.c));
            } catch (Exception unused) {
            }
        }

        public void onResponse(Call<Void> call, Response<Void> response) {
            try {
                this.a.quit();
                ThreadPoolProvider.a().a(new SentTraceRouteWorker$a$$ExternalSyntheticLambda0(this, this.b, response, this.c));
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        Call<Void> call = this.k;
        if (call != null && !call.isCanceled()) {
            this.k.cancel();
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r6) {
        /*
            r5 = this;
            com.cellrebel.sdk.database.SDKRoomDatabase r6 = com.cellrebel.sdk.database.DatabaseClient.a()
            if (r6 != 0) goto L_0x0007
            return
        L_0x0007:
            com.cellrebel.sdk.database.SDKRoomDatabase r6 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{  }
            com.cellrebel.sdk.database.dao.TraceRouteDAO r6 = r6.r()     // Catch:{  }
            r5.l = r6     // Catch:{  }
            java.util.List r6 = r6.b()     // Catch:{  }
            int r0 = r6.size()     // Catch:{  }
            if (r0 != 0) goto L_0x001c
            return
        L_0x001c:
            java.util.Iterator r0 = r6.iterator()     // Catch:{  }
        L_0x0020:
            boolean r1 = r0.hasNext()     // Catch:{  }
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r0.next()     // Catch:{  }
            com.cellrebel.sdk.networking.beans.request.TraceRouteMetric r1 = (com.cellrebel.sdk.networking.beans.request.TraceRouteMetric) r1     // Catch:{  }
            r2 = 1
            r1.isSending(r2)     // Catch:{  }
            com.cellrebel.sdk.database.dao.TraceRouteDAO r1 = r5.l     // Catch:{  }
            r1.a((java.util.List<com.cellrebel.sdk.networking.beans.request.TraceRouteMetric>) r6)     // Catch:{  }
            goto L_0x0020
        L_0x0036:
            android.os.HandlerThread r0 = new android.os.HandlerThread     // Catch:{  }
            java.lang.String r1 = "CustomTimeoutThread"
            r0.<init>(r1)     // Catch:{  }
            r0.start()     // Catch:{  }
            android.os.Handler r1 = new android.os.Handler     // Catch:{  }
            android.os.Looper r2 = r0.getLooper()     // Catch:{  }
            r1.<init>(r2)     // Catch:{  }
            com.cellrebel.sdk.workers.SentTraceRouteWorker$$ExternalSyntheticLambda0 r2 = new com.cellrebel.sdk.workers.SentTraceRouteWorker$$ExternalSyntheticLambda0     // Catch:{  }
            r2.<init>(r5)     // Catch:{  }
            r3 = 15000(0x3a98, double:7.411E-320)
            r1.postDelayed(r2, r3)     // Catch:{  }
            r6.toString()     // Catch:{  }
            com.cellrebel.sdk.utils.SettingsManager r2 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{  }
            com.cellrebel.sdk.networking.beans.response.Settings r2 = r2.c()     // Catch:{  }
            com.cellrebel.sdk.networking.ApiService r3 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{  }
            java.lang.String r2 = com.cellrebel.sdk.networking.UrlProvider.a(r2)     // Catch:{  }
            retrofit2.Call r2 = r3.h(r6, r2)     // Catch:{  }
            r5.k = r2     // Catch:{  }
            com.cellrebel.sdk.workers.SentTraceRouteWorker$a r3 = new com.cellrebel.sdk.workers.SentTraceRouteWorker$a     // Catch:{  }
            r3.<init>(r0, r1, r6)     // Catch:{  }
            r2.enqueue(r3)     // Catch:{  }
            java.util.concurrent.CountDownLatch r6 = r5.j     // Catch:{ Exception -> 0x0079 }
            r6.await()     // Catch:{ Exception -> 0x0079 }
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.SentTraceRouteWorker.a(android.content.Context):void");
    }
}