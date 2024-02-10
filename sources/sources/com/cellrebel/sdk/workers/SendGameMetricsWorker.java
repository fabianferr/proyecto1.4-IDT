package com.cellrebel.sdk.workers;

import android.os.Handler;
import com.cellrebel.sdk.database.dao.GameMetricDAO;
import com.cellrebel.sdk.networking.beans.request.GameInfoMetric;
import com.cellrebel.sdk.utils.ThreadPoolProvider;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendGameMetricsWorker extends BaseMetricsWorker {
    /* access modifiers changed from: private */
    public volatile CountDownLatch j = new CountDownLatch(1);
    private Call<Void> k;

    class a implements Callback<Void> {
        final /* synthetic */ Handler a;
        final /* synthetic */ List b;
        final /* synthetic */ GameMetricDAO c;

        a(Handler handler, List list, GameMetricDAO gameMetricDAO) {
            this.a = handler;
            this.b = list;
            this.c = gameMetricDAO;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ String a(List list, GameMetricDAO gameMetricDAO) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((GameInfoMetric) it.next()).isSending(false);
            }
            gameMetricDAO.a((List<GameInfoMetric>) list);
            return null;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ String a(Response response, List list, GameMetricDAO gameMetricDAO) {
            if (response.isSuccessful()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    GameInfoMetric gameInfoMetric = (GameInfoMetric) it.next();
                    if (gameInfoMetric.isOffline) {
                        gameMetricDAO.a(gameInfoMetric);
                    } else {
                        gameInfoMetric.isSent(true);
                        gameInfoMetric.pingsCount = Float.valueOf(0.0f);
                        gameInfoMetric.failedMeasurementsCount = Float.valueOf(0.0f);
                        gameMetricDAO.b(gameInfoMetric);
                    }
                }
                return null;
            }
            response.toString();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((GameInfoMetric) it2.next()).isSending(false);
            }
            gameMetricDAO.a((List<GameInfoMetric>) list);
            return null;
        }

        public void onFailure(Call<Void> call, Throwable th) {
            try {
                this.a.removeCallbacksAndMessages((Object) null);
                th.getMessage();
                ThreadPoolProvider.a().a(new SendGameMetricsWorker$a$$ExternalSyntheticLambda0(this.b, this.c));
                SendGameMetricsWorker.this.j.countDown();
            } catch (Exception | OutOfMemoryError unused) {
            }
        }

        public void onResponse(Call<Void> call, Response<Void> response) {
            try {
                Objects.toString(response);
                this.a.removeCallbacksAndMessages((Object) null);
                ThreadPoolProvider.a().a(new SendGameMetricsWorker$a$$ExternalSyntheticLambda1(response, this.b, this.c));
                SendGameMetricsWorker.this.j.countDown();
            } catch (Exception | OutOfMemoryError unused) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:12:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r7) {
        /*
            r6 = this;
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{  }
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{  }
            com.cellrebel.sdk.database.dao.GameMetricDAO r0 = r0.j()     // Catch:{  }
            java.util.List r1 = r0.b()     // Catch:{  }
            com.cellrebel.sdk.networking.beans.request.BaseMetric r2 = new com.cellrebel.sdk.networking.beans.request.BaseMetric     // Catch:{  }
            r2.<init>()     // Catch:{  }
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r7, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r2)     // Catch:{  }
            int r7 = r1.size()     // Catch:{  }
            if (r7 != 0) goto L_0x0022
            return
        L_0x0022:
            java.util.Iterator r7 = r1.iterator()     // Catch:{  }
        L_0x0026:
            boolean r3 = r7.hasNext()     // Catch:{  }
            if (r3 == 0) goto L_0x0037
            java.lang.Object r3 = r7.next()     // Catch:{  }
            com.cellrebel.sdk.networking.beans.request.GameInfoMetric r3 = (com.cellrebel.sdk.networking.beans.request.GameInfoMetric) r3     // Catch:{  }
            r4 = 1
            r3.isSending(r4)     // Catch:{  }
            goto L_0x0026
        L_0x0037:
            r0.a((java.util.List<com.cellrebel.sdk.networking.beans.request.GameInfoMetric>) r1)     // Catch:{  }
            android.os.Handler r7 = new android.os.Handler     // Catch:{  }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{  }
            r7.<init>(r3)     // Catch:{  }
            com.cellrebel.sdk.workers.SendGameMetricsWorker$$ExternalSyntheticLambda0 r3 = new com.cellrebel.sdk.workers.SendGameMetricsWorker$$ExternalSyntheticLambda0     // Catch:{  }
            r3.<init>(r6)     // Catch:{  }
            r4 = 15000(0x3a98, double:7.411E-320)
            r7.postDelayed(r3, r4)     // Catch:{  }
            java.util.Objects.toString(r1)     // Catch:{  }
            com.cellrebel.sdk.utils.SettingsManager r3 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{  }
            com.cellrebel.sdk.networking.beans.response.Settings r3 = r3.c()     // Catch:{  }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{  }
            r4.<init>()     // Catch:{  }
            com.cellrebel.sdk.networking.beans.request.GameMetric r5 = new com.cellrebel.sdk.networking.beans.request.GameMetric     // Catch:{  }
            r5.<init>()     // Catch:{  }
            r5.copyFrom(r2)     // Catch:{  }
            r5.games = r1     // Catch:{  }
            java.lang.Boolean r2 = r3.anonymize     // Catch:{  }
            r5.anonymize = r2     // Catch:{  }
            r4.add(r5)     // Catch:{  }
            r2 = 0
            java.lang.Object r5 = r4.get(r2)     // Catch:{  }
            com.cellrebel.sdk.networking.beans.request.GameMetric r5 = (com.cellrebel.sdk.networking.beans.request.GameMetric) r5     // Catch:{  }
            java.util.List r5 = r5.games()     // Catch:{  }
            r5.size()     // Catch:{  }
            java.lang.Object r5 = r4.get(r2)     // Catch:{  }
            com.cellrebel.sdk.networking.beans.request.GameMetric r5 = (com.cellrebel.sdk.networking.beans.request.GameMetric) r5     // Catch:{  }
            java.util.List r5 = r5.games()     // Catch:{  }
            java.lang.Object r2 = r5.get(r2)     // Catch:{  }
            com.cellrebel.sdk.networking.beans.request.GameInfoMetric r2 = (com.cellrebel.sdk.networking.beans.request.GameInfoMetric) r2     // Catch:{  }
            java.lang.String r2 = r2.dateTimeOfMeasurement     // Catch:{  }
            r4.toString()     // Catch:{  }
            com.cellrebel.sdk.networking.ApiService r2 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{  }
            java.lang.String r3 = com.cellrebel.sdk.networking.UrlProvider.a(r3)     // Catch:{  }
            retrofit2.Call r2 = r2.e(r4, r3)     // Catch:{  }
            r6.k = r2     // Catch:{  }
            com.cellrebel.sdk.workers.SendGameMetricsWorker$a r3 = new com.cellrebel.sdk.workers.SendGameMetricsWorker$a     // Catch:{  }
            r3.<init>(r7, r1, r0)     // Catch:{  }
            r2.enqueue(r3)     // Catch:{  }
            java.util.concurrent.CountDownLatch r7 = r6.j     // Catch:{ Exception | OutOfMemoryError -> 0x00ac, Exception | OutOfMemoryError -> 0x00ac }
            r7.await()     // Catch:{ Exception | OutOfMemoryError -> 0x00ac, Exception | OutOfMemoryError -> 0x00ac }
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.SendGameMetricsWorker.a(android.content.Context):void");
    }
}
