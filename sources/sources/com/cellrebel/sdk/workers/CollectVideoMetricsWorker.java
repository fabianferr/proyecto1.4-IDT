package com.cellrebel.sdk.workers;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.telephony.CellInfo;
import com.cellrebel.sdk.database.ConnectionType;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.database.VideoLoadScore;
import com.cellrebel.sdk.networking.beans.request.BaseMetric;
import com.cellrebel.sdk.networking.beans.request.VideoMetric;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.utils.TelephonyHelper;
import com.cellrebel.sdk.utils.ThreadPoolProvider;
import com.cellrebel.sdk.utils.TrackingHelper;
import com.cellrebel.sdk.youtube.player.PlayerConstants;
import com.cellrebel.sdk.youtube.player.YouTubePlayer;
import com.cellrebel.sdk.youtube.player.YouTubePlayerView;
import com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerListener;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CollectVideoMetricsWorker extends BaseMetricsWorker {
    /* access modifiers changed from: private */
    public List<CellInfo> A;
    private final ScheduledExecutorService B = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */
    public ScheduledFuture<?> C;
    private final ScheduledExecutorService D = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */
    public ScheduledFuture<?> E;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService F = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */
    public ScheduledFuture<?> G;
    private final ScheduledExecutorService H = Executors.newSingleThreadScheduledExecutor();
    public VideoLoadScore j = new VideoLoadScore();
    /* access modifiers changed from: private */
    public CountDownLatch k = new CountDownLatch(2);
    String l;
    String m;
    String n;
    String o;
    int p;
    int q;
    /* access modifiers changed from: private */
    public YouTubePlayerView r;
    private YouTubePlayer s;
    /* access modifiers changed from: private */
    public YouTubePlayerListener t;
    /* access modifiers changed from: private */
    public ConnectionType u;
    /* access modifiers changed from: private */
    public int v;
    /* access modifiers changed from: private */
    public long w;
    /* access modifiers changed from: private */
    public long x;
    Settings y;
    /* access modifiers changed from: private */
    public VideoMetric z = new VideoMetric();

    class a implements YouTubePlayerListener {
        private long a = 0;
        private long b = 0;
        private long c = 0;
        private long d = 0;
        private long e = 0;
        private long f = 0;
        private long g = 0;
        private long h = 0;
        private long i = 0;
        private long j = 0;
        private long k = 0;
        PlayerConstants.PlaybackQuality l;
        PlayerConstants.PlayerState m;
        long n;
        long o;
        long p;
        long q;
        int r;
        boolean s;
        long t = 0;
        final /* synthetic */ int u;
        final /* synthetic */ int v;
        final /* synthetic */ YouTubePlayer w;
        final /* synthetic */ Context x;

        a(int i2, int i3, YouTubePlayer youTubePlayer, Context context) {
            this.u = i2;
            this.v = i3;
            this.w = youTubePlayer;
            this.x = context;
        }

        private void a(VideoMetric videoMetric) {
            try {
                videoMetric.videoRebufferingCount(this.r);
                videoMetric.videoRebufferingTime(this.n);
            } catch (Exception | OutOfMemoryError unused) {
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(YouTubePlayer youTubePlayer) {
            youTubePlayer.a(CollectVideoMetricsWorker.this.m, 0.0f);
            CollectVideoMetricsWorker.this.r.c();
            CollectVideoMetricsWorker.this.r.setSoundEffectsEnabled(false);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String b() {
            try {
                DatabaseClient.a().v().a(CollectVideoMetricsWorker.this.j);
                return null;
            } catch (Exception | OutOfMemoryError unused) {
                return null;
            }
        }

        private void b(VideoMetric videoMetric) {
            try {
                if (CollectVideoMetricsWorker.this.E != null) {
                    CollectVideoMetricsWorker.this.E.cancel(true);
                    ScheduledFuture unused = CollectVideoMetricsWorker.this.E = null;
                }
                if (CollectVideoMetricsWorker.this.G != null) {
                    CollectVideoMetricsWorker.this.G.cancel(true);
                    ScheduledFuture unused2 = CollectVideoMetricsWorker.this.G = null;
                }
                ConnectionType unused3 = CollectVideoMetricsWorker.this.u = TrackingHelper.a().a(this.x);
                videoMetric.accessTechEnd(CollectVideoMetricsWorker.this.u.toString());
                videoMetric.accessTechNumChanges(CollectVideoMetricsWorker.this.v);
                videoMetric.bytesSent(TrafficStats.getTotalTxBytes() - CollectVideoMetricsWorker.this.w);
                videoMetric.bytesReceived(TrafficStats.getTotalRxBytes() - CollectVideoMetricsWorker.this.x);
                if (CollectVideoMetricsWorker.this.A == null || CollectVideoMetricsWorker.this.A.isEmpty()) {
                    BaseMetricsWorker.a(this.x, (BaseMetric) videoMetric, (Runnable) new CollectVideoMetricsWorker$a$$ExternalSyntheticLambda2(this, videoMetric));
                } else {
                    BaseMetricsWorker.a(this.x, (BaseMetric) videoMetric, (List<CellInfo>) CollectVideoMetricsWorker.this.A, (Runnable) new CollectVideoMetricsWorker$a$$ExternalSyntheticLambda1(this, videoMetric));
                }
                CollectVideoMetricsWorker.this.k.countDown();
            } catch (Exception | OutOfMemoryError unused4) {
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(YouTubePlayer youTubePlayer) {
            try {
                if (CollectVideoMetricsWorker.this.t != null) {
                    youTubePlayer.a(CollectVideoMetricsWorker.this.t);
                }
                if (youTubePlayer != null) {
                    youTubePlayer.a(0);
                    youTubePlayer.e();
                    new Handler(Looper.getMainLooper()).post(new CollectVideoMetricsWorker$a$$ExternalSyntheticLambda5(this));
                }
            } catch (Exception | OutOfMemoryError unused) {
            }
            try {
                this.p = -1;
                if (CollectVideoMetricsWorker.this.z != null) {
                    CollectVideoMetricsWorker.this.z.videoTimeToStart(0);
                    CollectVideoMetricsWorker.this.z.isVideoFailsToStart(true);
                    b(CollectVideoMetricsWorker.this.z);
                    VideoMetric unused2 = CollectVideoMetricsWorker.this.z = null;
                }
            } catch (Exception | OutOfMemoryError unused3) {
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00b0 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ void c(com.cellrebel.sdk.networking.beans.request.VideoMetric r10) {
            /*
                r9 = this;
                long r0 = r10.videoTimeToStart()
                r2 = 0
                r4 = 1
                r5 = 0
                int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r7 <= 0) goto L_0x0062
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r0 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                com.cellrebel.sdk.networking.beans.response.Settings r0 = r0.y
                if (r0 == 0) goto L_0x0062
                java.lang.Integer r1 = r0.videoBufferingThreshold
                r2 = 4652007308841189376(0x408f400000000000, double:1000.0)
                java.lang.Integer r0 = r0.connectionTestVideoScore()
                int r0 = r0.intValue()
                if (r1 == 0) goto L_0x0049
                double r0 = (double) r0
                long r7 = r10.videoTimeToStart
                double r7 = (double) r7
                java.lang.Double.isNaN(r7)
                double r7 = r7 / r2
                java.lang.Double.isNaN(r0)
                double r0 = r0 - r7
                long r2 = r10.videoRebufferingTime
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r10 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                com.cellrebel.sdk.networking.beans.response.Settings r10 = r10.y
                java.lang.Integer r10 = r10.videoBufferingThreshold
                int r10 = r10.intValue()
                long r7 = (long) r10
                int r10 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
                if (r10 <= 0) goto L_0x0043
                r10 = 2
                goto L_0x0044
            L_0x0043:
                r10 = 1
            L_0x0044:
                double r2 = (double) r10
                java.lang.Double.isNaN(r2)
                goto L_0x0060
            L_0x0049:
                double r0 = (double) r0
                long r7 = r10.videoTimeToStart
                double r7 = (double) r7
                java.lang.Double.isNaN(r7)
                double r7 = r7 / r2
                java.lang.Double.isNaN(r0)
                double r0 = r0 - r7
                int r10 = r10.videoRebufferingCount()
                double r2 = (double) r10
                r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                java.lang.Double.isNaN(r2)
                double r2 = r2 + r7
            L_0x0060:
                double r0 = r0 / r2
                goto L_0x0063
            L_0x0062:
                r0 = r5
            L_0x0063:
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r10 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                com.cellrebel.sdk.database.VideoLoadScore r10 = r10.j
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 <= 0) goto L_0x006c
                r5 = r0
            L_0x006c:
                r10.c(r5)
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r10 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                com.cellrebel.sdk.database.VideoLoadScore r10 = r10.j
                long r0 = java.lang.System.currentTimeMillis()
                r10.a((long) r0)
                com.cellrebel.sdk.utils.TrackingHelper r10 = com.cellrebel.sdk.utils.TrackingHelper.a()
                android.location.Location r10 = r10.b()
                if (r10 == 0) goto L_0x009a
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r0 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                com.cellrebel.sdk.database.VideoLoadScore r0 = r0.j
                double r1 = r10.getLatitude()
                r0.a((double) r1)
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r0 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                com.cellrebel.sdk.database.VideoLoadScore r0 = r0.j
                double r1 = r10.getLongitude()
                r0.b(r1)
            L_0x009a:
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r10 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                r10.a = r4
                com.cellrebel.sdk.database.SDKRoomDatabase r10 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00b0 }
                if (r10 == 0) goto L_0x00b0
                com.cellrebel.sdk.utils.ThreadPoolProvider r10 = com.cellrebel.sdk.utils.ThreadPoolProvider.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00b0 }
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker$a$$ExternalSyntheticLambda4 r0 = new com.cellrebel.sdk.workers.CollectVideoMetricsWorker$a$$ExternalSyntheticLambda4     // Catch:{ Exception | OutOfMemoryError -> 0x00b0 }
                r0.<init>(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x00b0 }
                r10.a(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x00b0 }
            L_0x00b0:
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r10 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x00b9 }
                java.util.concurrent.CountDownLatch r10 = r10.k     // Catch:{ Exception | OutOfMemoryError -> 0x00b9 }
                r10.countDown()     // Catch:{ Exception | OutOfMemoryError -> 0x00b9 }
            L_0x00b9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectVideoMetricsWorker.a.c(com.cellrebel.sdk.networking.beans.request.VideoMetric):void");
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String d() {
            try {
                if (DatabaseClient.a() == null) {
                    return null;
                }
                DatabaseClient.a().v().a(CollectVideoMetricsWorker.this.j);
                return null;
            } catch (Exception | OutOfMemoryError unused) {
                return null;
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(1:13)(3:4|(3:6|(1:8)(1:9)|10)(1:11)|12)|14|(1:16)|17|(1:19)|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00aa */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ void d(com.cellrebel.sdk.networking.beans.request.VideoMetric r10) {
            /*
                r9 = this;
                long r0 = r10.videoTimeToStart()
                r2 = 0
                r4 = 1
                r5 = 0
                int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r7 <= 0) goto L_0x0062
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r0 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                com.cellrebel.sdk.networking.beans.response.Settings r0 = r0.y
                if (r0 == 0) goto L_0x0062
                java.lang.Integer r1 = r0.videoBufferingThreshold
                r2 = 4652007308841189376(0x408f400000000000, double:1000.0)
                java.lang.Integer r0 = r0.connectionTestVideoScore()
                int r0 = r0.intValue()
                if (r1 == 0) goto L_0x0049
                double r0 = (double) r0
                long r7 = r10.videoTimeToStart
                double r7 = (double) r7
                java.lang.Double.isNaN(r7)
                double r7 = r7 / r2
                java.lang.Double.isNaN(r0)
                double r0 = r0 - r7
                long r2 = r10.videoRebufferingTime
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r10 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                com.cellrebel.sdk.networking.beans.response.Settings r10 = r10.y
                java.lang.Integer r10 = r10.videoBufferingThreshold
                int r10 = r10.intValue()
                long r7 = (long) r10
                int r10 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
                if (r10 <= 0) goto L_0x0043
                r10 = 2
                goto L_0x0044
            L_0x0043:
                r10 = 1
            L_0x0044:
                double r2 = (double) r10
                java.lang.Double.isNaN(r2)
                goto L_0x0060
            L_0x0049:
                double r0 = (double) r0
                long r7 = r10.videoTimeToStart
                double r7 = (double) r7
                java.lang.Double.isNaN(r7)
                double r7 = r7 / r2
                java.lang.Double.isNaN(r0)
                double r0 = r0 - r7
                int r10 = r10.videoRebufferingCount()
                double r2 = (double) r10
                r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                java.lang.Double.isNaN(r2)
                double r2 = r2 + r7
            L_0x0060:
                double r0 = r0 / r2
                goto L_0x0063
            L_0x0062:
                r0 = r5
            L_0x0063:
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r10 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                com.cellrebel.sdk.database.VideoLoadScore r10 = r10.j
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 <= 0) goto L_0x006c
                r5 = r0
            L_0x006c:
                r10.c(r5)
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r10 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                com.cellrebel.sdk.database.VideoLoadScore r10 = r10.j
                long r0 = java.lang.System.currentTimeMillis()
                r10.a((long) r0)
                com.cellrebel.sdk.utils.TrackingHelper r10 = com.cellrebel.sdk.utils.TrackingHelper.a()
                android.location.Location r10 = r10.b()
                if (r10 == 0) goto L_0x009a
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r0 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                com.cellrebel.sdk.database.VideoLoadScore r0 = r0.j
                double r1 = r10.getLatitude()
                r0.a((double) r1)
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r0 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                com.cellrebel.sdk.database.VideoLoadScore r0 = r0.j
                double r1 = r10.getLongitude()
                r0.b(r1)
            L_0x009a:
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r10 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this
                r10.a = r4
                com.cellrebel.sdk.utils.ThreadPoolProvider r10 = com.cellrebel.sdk.utils.ThreadPoolProvider.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00aa }
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker$a$$ExternalSyntheticLambda9 r0 = new com.cellrebel.sdk.workers.CollectVideoMetricsWorker$a$$ExternalSyntheticLambda9     // Catch:{ Exception | OutOfMemoryError -> 0x00aa }
                r0.<init>(r9)     // Catch:{ Exception | OutOfMemoryError -> 0x00aa }
                r10.a(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x00aa }
            L_0x00aa:
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r10 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x00b3 }
                java.util.concurrent.CountDownLatch r10 = r10.k     // Catch:{ Exception | OutOfMemoryError -> 0x00b3 }
                r10.countDown()     // Catch:{ Exception | OutOfMemoryError -> 0x00b3 }
            L_0x00b3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectVideoMetricsWorker.a.d(com.cellrebel.sdk.networking.beans.request.VideoMetric):void");
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(YouTubePlayer youTubePlayer) {
            try {
                i();
                if (CollectVideoMetricsWorker.this.t != null) {
                    youTubePlayer.a(CollectVideoMetricsWorker.this.t);
                }
                if (youTubePlayer != null) {
                    youTubePlayer.a(0);
                    youTubePlayer.e();
                    new Handler(Looper.getMainLooper()).post(new CollectVideoMetricsWorker$a$$ExternalSyntheticLambda11(this));
                }
                if (CollectVideoMetricsWorker.this.z != null) {
                    CollectVideoMetricsWorker.this.z.inStreamFailure(true);
                    a(CollectVideoMetricsWorker.this.z);
                    b(CollectVideoMetricsWorker.this.z);
                    VideoMetric unused = CollectVideoMetricsWorker.this.z = null;
                }
            } catch (Exception | OutOfMemoryError unused2) {
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e() {
            CollectVideoMetricsWorker.this.r.release();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f() {
            try {
                CollectVideoMetricsWorker.this.r.setSoundEffectsEnabled(false);
                CollectVideoMetricsWorker.this.r.c();
            } catch (Exception | OutOfMemoryError unused) {
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g() {
            CollectVideoMetricsWorker.this.r.release();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h() {
            CollectVideoMetricsWorker.this.r.release();
        }

        private void i() {
            try {
                if (this.l != null && this.s) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j2 = currentTimeMillis - this.o;
                    PlayerConstants.PlaybackQuality playbackQuality = this.l;
                    if (playbackQuality == PlayerConstants.PlaybackQuality.UNKNOWN) {
                        this.a += j2;
                        CollectVideoMetricsWorker.this.z.videoQualityTimeUnknown += j2;
                    } else if (playbackQuality == PlayerConstants.PlaybackQuality.DEFAULT) {
                        this.b += j2;
                        CollectVideoMetricsWorker.this.z.videoQualityTimeDefault += j2;
                    } else if (playbackQuality == PlayerConstants.PlaybackQuality.TINY) {
                        this.c += j2;
                        CollectVideoMetricsWorker.this.z.videoQualityTime144p += j2;
                    } else if (playbackQuality == PlayerConstants.PlaybackQuality.SMALL) {
                        this.d += j2;
                        CollectVideoMetricsWorker.this.z.videoQualityTime240p += j2;
                    } else if (playbackQuality == PlayerConstants.PlaybackQuality.MEDIUM) {
                        this.e += j2;
                        CollectVideoMetricsWorker.this.z.videoQualityTime360p += j2;
                    } else if (playbackQuality == PlayerConstants.PlaybackQuality.LARGE) {
                        this.f += j2;
                        CollectVideoMetricsWorker.this.z.videoQualityTime480p += j2;
                    } else if (playbackQuality == PlayerConstants.PlaybackQuality.HD720) {
                        this.g += j2;
                        CollectVideoMetricsWorker.this.z.videoQualityTime720p += j2;
                    } else if (playbackQuality == PlayerConstants.PlaybackQuality.HD1080) {
                        this.h += j2;
                        CollectVideoMetricsWorker.this.z.videoQualityTime1080p += j2;
                    } else if (playbackQuality == PlayerConstants.PlaybackQuality.HD1440) {
                        this.i += j2;
                        CollectVideoMetricsWorker.this.z.videoQualityTime1440p += j2;
                    } else if (playbackQuality == PlayerConstants.PlaybackQuality.HD2160) {
                        this.j += j2;
                        CollectVideoMetricsWorker.this.z.videoQualityTime2160p += j2;
                    } else if (playbackQuality == PlayerConstants.PlaybackQuality.HIGH_RES) {
                        this.k += j2;
                        CollectVideoMetricsWorker.this.z.videoQualityTimeHighRes += j2;
                    }
                    this.o = currentTimeMillis;
                }
            } catch (Exception | OutOfMemoryError unused) {
            }
        }

        public void a() {
            try {
                if (CollectVideoMetricsWorker.this.C != null) {
                    CollectVideoMetricsWorker.this.C.cancel(true);
                    ScheduledFuture unused = CollectVideoMetricsWorker.this.C = null;
                }
                new Handler(Looper.getMainLooper()).post(new CollectVideoMetricsWorker$a$$ExternalSyntheticLambda6(this));
                this.w.a(this.u, this.v);
                this.w.a(0);
                new Handler(Looper.getMainLooper()).post(new CollectVideoMetricsWorker$a$$ExternalSyntheticLambda7(this, this.w));
                this.w.a(0);
                this.t = System.currentTimeMillis();
                CollectVideoMetricsWorker collectVideoMetricsWorker = CollectVideoMetricsWorker.this;
                ScheduledFuture unused2 = collectVideoMetricsWorker.E = collectVideoMetricsWorker.F.schedule(new CollectVideoMetricsWorker$a$$ExternalSyntheticLambda8(this, this.w), (long) CollectVideoMetricsWorker.this.p, TimeUnit.SECONDS);
            } catch (Exception | OutOfMemoryError unused3) {
            }
        }

        public void a(float f2) {
            if (((double) f2) != 0.0d) {
                try {
                    if (CollectVideoMetricsWorker.this.z != null) {
                        CollectVideoMetricsWorker.this.z.videoLength((int) (1000.0f * f2));
                        if (CollectVideoMetricsWorker.this.G == null) {
                            CollectVideoMetricsWorker collectVideoMetricsWorker = CollectVideoMetricsWorker.this;
                            ScheduledFuture unused = collectVideoMetricsWorker.G = collectVideoMetricsWorker.F.schedule(new CollectVideoMetricsWorker$a$$ExternalSyntheticLambda10(this, this.w), (long) (collectVideoMetricsWorker.b ? collectVideoMetricsWorker.p : ((int) f2) * collectVideoMetricsWorker.q), TimeUnit.SECONDS);
                        }
                    }
                } catch (Exception | OutOfMemoryError unused2) {
                }
            }
        }

        public void a(PlayerConstants.PlaybackQuality playbackQuality) {
            try {
                playbackQuality.name();
                this.w.a(0);
                this.l = playbackQuality;
                i();
            } catch (Exception | OutOfMemoryError unused) {
            }
        }

        public void a(PlayerConstants.PlaybackRate playbackRate) {
            try {
                this.w.a(0);
            } catch (Exception | OutOfMemoryError unused) {
            }
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0061 */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0069 A[Catch:{ Exception | OutOfMemoryError -> 0x0099 }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x006a A[Catch:{ Exception | OutOfMemoryError -> 0x0099 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.cellrebel.sdk.youtube.player.PlayerConstants.PlayerError r4) {
            /*
                r3 = this;
                r4.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r4 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                java.util.concurrent.ScheduledFuture r4 = r4.G     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                r0 = 0
                r1 = 0
                if (r4 == 0) goto L_0x001b
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r4 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                java.util.concurrent.ScheduledFuture r4 = r4.G     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                r4.cancel(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r4 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                java.util.concurrent.ScheduledFuture unused = r4.G = r0     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
            L_0x001b:
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r4 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                java.util.concurrent.ScheduledFuture r4 = r4.E     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                if (r4 == 0) goto L_0x0031
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r4 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                java.util.concurrent.ScheduledFuture r4 = r4.E     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                r4.cancel(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r4 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                java.util.concurrent.ScheduledFuture unused = r4.E = r0     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
            L_0x0031:
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r4 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerListener r4 = r4.t     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                if (r4 == 0) goto L_0x0044
                com.cellrebel.sdk.youtube.player.YouTubePlayer r4 = r3.w     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r2 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerListener r2 = r2.t     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                r4.a((com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerListener) r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
            L_0x0044:
                com.cellrebel.sdk.youtube.player.YouTubePlayer r4 = r3.w     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                if (r4 == 0) goto L_0x0061
                r4.a((int) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                com.cellrebel.sdk.youtube.player.YouTubePlayer r4 = r3.w     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                r4.e()     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                android.os.Handler r4 = new android.os.Handler     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                r4.<init>(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker$a$$ExternalSyntheticLambda3 r1 = new com.cellrebel.sdk.workers.CollectVideoMetricsWorker$a$$ExternalSyntheticLambda3     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                r1.<init>(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
                r4.post(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0061 }
            L_0x0061:
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r4 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                com.cellrebel.sdk.networking.beans.request.VideoMetric r4 = r4.z     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                if (r4 != 0) goto L_0x006a
                return
            L_0x006a:
                boolean r4 = r3.s     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                r1 = 1
                if (r4 == 0) goto L_0x0079
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r4 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                com.cellrebel.sdk.networking.beans.request.VideoMetric r4 = r4.z     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                r4.inStreamFailure(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                goto L_0x0082
            L_0x0079:
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r4 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                com.cellrebel.sdk.networking.beans.request.VideoMetric r4 = r4.z     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                r4.isVideoFailsToStart(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
            L_0x0082:
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r4 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                com.cellrebel.sdk.networking.beans.request.VideoMetric r4 = r4.z     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                r3.a((com.cellrebel.sdk.networking.beans.request.VideoMetric) r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r4 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                com.cellrebel.sdk.networking.beans.request.VideoMetric r4 = r4.z     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                r3.b((com.cellrebel.sdk.networking.beans.request.VideoMetric) r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                com.cellrebel.sdk.workers.CollectVideoMetricsWorker r4 = com.cellrebel.sdk.workers.CollectVideoMetricsWorker.this     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
                com.cellrebel.sdk.networking.beans.request.VideoMetric unused = r4.z = r0     // Catch:{ Exception | OutOfMemoryError -> 0x0099 }
            L_0x0099:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectVideoMetricsWorker.a.a(com.cellrebel.sdk.youtube.player.PlayerConstants$PlayerError):void");
        }

        public void a(PlayerConstants.PlayerState playerState) {
            double d2;
            double d3;
            double d4;
            try {
                if (CollectVideoMetricsWorker.this.z != null) {
                    this.w.a(0);
                    playerState.name();
                    int i2 = b.a[playerState.ordinal()];
                    int i3 = 1;
                    if (i2 == 1) {
                        if (CollectVideoMetricsWorker.this.G != null) {
                            CollectVideoMetricsWorker.this.G.cancel(true);
                            ScheduledFuture unused = CollectVideoMetricsWorker.this.G = null;
                        }
                        if (!CollectVideoMetricsWorker.this.z.inStreamFailure && !CollectVideoMetricsWorker.this.z.isVideoFailsToStart) {
                            i();
                            if (CollectVideoMetricsWorker.this.z != null) {
                                a(CollectVideoMetricsWorker.this.z);
                                b(CollectVideoMetricsWorker.this.z);
                                VideoMetric unused2 = CollectVideoMetricsWorker.this.z = null;
                            } else {
                                return;
                            }
                        }
                    } else if (i2 == 2) {
                        if (this.s) {
                            this.p = System.currentTimeMillis();
                            i();
                        } else {
                            this.q = System.currentTimeMillis();
                        }
                        this.s = false;
                    } else if (i2 == 3) {
                        if (CollectVideoMetricsWorker.this.E != null) {
                            CollectVideoMetricsWorker.this.E.cancel(true);
                            ScheduledFuture unused3 = CollectVideoMetricsWorker.this.E = null;
                        }
                        if (this.q != 0 && CollectVideoMetricsWorker.this.z.videoInitialBufferingTime == 0) {
                            CollectVideoMetricsWorker.this.z.videoInitialBufferingTime = System.currentTimeMillis() - this.q;
                        }
                        this.s = true;
                        this.o = System.currentTimeMillis();
                        if (this.m.equals(PlayerConstants.PlayerState.BUFFERING) && this.p != 0) {
                            long currentTimeMillis = System.currentTimeMillis() - this.p;
                            this.r++;
                            this.n += currentTimeMillis;
                        }
                        if (this.p == 0) {
                            CollectVideoMetricsWorker.this.z.videoTimeToStart(System.currentTimeMillis() - this.t);
                            List unused4 = CollectVideoMetricsWorker.this.A = TelephonyHelper.b().a(this.x);
                        }
                        double d5 = 0.0d;
                        if (CollectVideoMetricsWorker.this.z.videoTimeToStart() > 0) {
                            Settings settings = CollectVideoMetricsWorker.this.y;
                            if (settings.videoBufferingThreshold != null) {
                                double intValue = (double) settings.connectionTestVideoScore().intValue();
                                double d6 = (double) CollectVideoMetricsWorker.this.z.videoTimeToStart;
                                Double.isNaN(d6);
                                Double.isNaN(intValue);
                                d4 = intValue - (d6 / 1000.0d);
                                if (CollectVideoMetricsWorker.this.z.videoRebufferingTime > ((long) CollectVideoMetricsWorker.this.y.videoBufferingThreshold.intValue())) {
                                    i3 = 2;
                                }
                                d3 = (double) i3;
                                Double.isNaN(d3);
                            } else {
                                double intValue2 = (double) settings.connectionTestVideoScore().intValue();
                                double d7 = (double) CollectVideoMetricsWorker.this.z.videoTimeToStart;
                                Double.isNaN(d7);
                                Double.isNaN(intValue2);
                                d4 = intValue2 - (d7 / 1000.0d);
                                double videoRebufferingCount = (double) CollectVideoMetricsWorker.this.z.videoRebufferingCount();
                                Double.isNaN(videoRebufferingCount);
                                d3 = videoRebufferingCount + 1.0d;
                            }
                            d2 = d4 / d3;
                        } else {
                            d2 = 0.0d;
                        }
                        VideoLoadScore videoLoadScore = CollectVideoMetricsWorker.this.j;
                        if (d2 > 0.0d) {
                            d5 = d2;
                        }
                        videoLoadScore.c(d5);
                    } else if (i2 == 4) {
                        i();
                        this.s = false;
                        new Handler(Looper.getMainLooper()).postDelayed(new CollectVideoMetricsWorker$a$$ExternalSyntheticLambda0(this.w), 1000);
                    }
                    this.m = playerState;
                }
            } catch (Exception | OutOfMemoryError unused5) {
            }
        }

        public void a(String str) {
        }

        public void b(float f2) {
        }

        public void c() {
        }

        public void c(float f2) {
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.cellrebel.sdk.youtube.player.PlayerConstants$PlayerState[] r0 = com.cellrebel.sdk.youtube.player.PlayerConstants.PlayerState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.cellrebel.sdk.youtube.player.PlayerConstants$PlayerState r1 = com.cellrebel.sdk.youtube.player.PlayerConstants.PlayerState.ENDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.cellrebel.sdk.youtube.player.PlayerConstants$PlayerState r1 = com.cellrebel.sdk.youtube.player.PlayerConstants.PlayerState.BUFFERING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.cellrebel.sdk.youtube.player.PlayerConstants$PlayerState r1 = com.cellrebel.sdk.youtube.player.PlayerConstants.PlayerState.PLAYING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.cellrebel.sdk.youtube.player.PlayerConstants$PlayerState r1 = com.cellrebel.sdk.youtube.player.PlayerConstants.PlayerState.PAUSED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectVideoMetricsWorker.b.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.r.release();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i, int i2, Context context, YouTubePlayer youTubePlayer) {
        this.s = youTubePlayer;
        a aVar = new a(i, i2, youTubePlayer, context);
        this.t = aVar;
        youTubePlayer.b(aVar);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|(1:3)|4|5|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ java.lang.String b() {
        /*
            r3 = this;
            com.cellrebel.sdk.database.VideoLoadScore r0 = r3.j     // Catch:{ Exception | OutOfMemoryError -> 0x0023 }
            r1 = 0
            r0.c(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0023 }
            com.cellrebel.sdk.database.VideoLoadScore r0 = r3.j     // Catch:{ Exception | OutOfMemoryError -> 0x0023 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x0023 }
            r0.a((long) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0023 }
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x0023 }
            if (r0 == 0) goto L_0x0023
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x0023 }
            com.cellrebel.sdk.database.dao.VideoLoadScoreDAO r0 = r0.v()     // Catch:{ Exception | OutOfMemoryError -> 0x0023 }
            com.cellrebel.sdk.database.VideoLoadScore r1 = r3.j     // Catch:{ Exception | OutOfMemoryError -> 0x0023 }
            r0.a(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0023 }
        L_0x0023:
            java.util.concurrent.CountDownLatch r0 = r3.k     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
            r0.countDown()     // Catch:{ Exception | OutOfMemoryError -> 0x0028 }
        L_0x0028:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectVideoMetricsWorker.b():java.lang.String");
    }

    private void b(Context context) {
        ConnectionType a2 = TrackingHelper.a().a(context);
        this.u = a2;
        this.z.accessTechStart(a2.toString());
        this.C = this.D.schedule(new CollectVideoMetricsWorker$$ExternalSyntheticLambda4(this, context), (long) this.p, TimeUnit.SECONDS);
        new Handler(Looper.getMainLooper()).post(new CollectVideoMetricsWorker$$ExternalSyntheticLambda5(this, context));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        try {
            ThreadPoolProvider.a().a(new CollectVideoMetricsWorker$$ExternalSyntheticLambda1(this));
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Context context) {
        try {
            YouTubePlayerListener youTubePlayerListener = this.t;
            if (youTubePlayerListener != null) {
                this.s.a(youTubePlayerListener);
            }
            YouTubePlayer youTubePlayer = this.s;
            if (youTubePlayer != null) {
                youTubePlayer.a(0);
                this.s.e();
                new Handler(Looper.getMainLooper()).post(new CollectVideoMetricsWorker$$ExternalSyntheticLambda7(this));
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
        VideoMetric videoMetric = this.z;
        if (videoMetric != null) {
            videoMetric.isVideoFailsToStart(true);
            this.z.videoQualityTime144p(0);
            this.z.videoQualityTime240p(0);
            this.z.videoQualityTime360p(0);
            this.z.videoQualityTime480p(0);
            this.z.videoQualityTime720p(0);
            this.z.videoQualityTime1080p(0);
            this.z.videoQualityTime1440p(0);
            this.z.videoQualityTime2160p(0);
            this.z.videoQualityTimeHighRes(0);
            this.z.videoQualityTimeDefault(0);
            this.z.videoQualityTimeUnknown(0);
            this.z.videoRebufferingCount(0);
            this.z.videoRebufferingTime(0);
            this.z.videoInitialBufferingTime(0);
            this.z.videoTimeToStart(0);
            ConnectionType a2 = TrackingHelper.a().a(context);
            this.u = a2;
            this.z.accessTechEnd(a2.toString());
            this.z.accessTechNumChanges(this.v);
            this.z.bytesSent(TrafficStats.getTotalTxBytes() - this.w);
            this.z.bytesReceived(TrafficStats.getTotalRxBytes() - this.x);
            BaseMetricsWorker.a(context, (BaseMetric) this.z, (Runnable) new CollectVideoMetricsWorker$$ExternalSyntheticLambda8(this));
            this.z = null;
            try {
                this.k.countDown();
            } catch (Exception | OutOfMemoryError unused2) {
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        try {
            this.k.countDown();
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0063 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0068 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void d(android.content.Context r8) {
        /*
            r7 = this;
            android.widget.LinearLayout r0 = new android.widget.LinearLayout
            r0.<init>(r8)
            java.lang.String r1 = "window"
            java.lang.Object r1 = r8.getSystemService(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            android.view.WindowManager r1 = (android.view.WindowManager) r1     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            android.util.DisplayMetrics r2 = new android.util.DisplayMetrics     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r2.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            android.view.Display r1 = r1.getDefaultDisplay()     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r1.getMetrics(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            int r1 = r2.heightPixels     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            int r2 = r2.widthPixels     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r3.<init>(r2, r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r0.setLayoutParams(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r3 = 0
            r0.setOrientation(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            com.cellrebel.sdk.youtube.player.YouTubePlayerView r3 = new com.cellrebel.sdk.youtube.player.YouTubePlayerView     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r3.<init>(r8)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r7.r = r3     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            android.view.ViewGroup$LayoutParams r4 = new android.view.ViewGroup$LayoutParams     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r4.<init>(r2, r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r3.setLayoutParams(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            com.cellrebel.sdk.youtube.player.YouTubePlayerView r3 = r7.r     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r0.addView(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            com.cellrebel.sdk.youtube.player.YouTubePlayerView r3 = r7.r     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r4 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r3.measure(r5, r6)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r0.measure(r3, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            com.cellrebel.sdk.youtube.player.YouTubePlayerView r0 = r7.r     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            com.cellrebel.sdk.workers.CollectVideoMetricsWorker$$ExternalSyntheticLambda6 r3 = new com.cellrebel.sdk.workers.CollectVideoMetricsWorker$$ExternalSyntheticLambda6     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r3.<init>(r7, r1, r2, r8)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            r8 = 1
            r0.a((com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerInitListener) r3, (boolean) r8)     // Catch:{ Exception | OutOfMemoryError -> 0x0063 }
            goto L_0x006d
        L_0x0063:
            java.util.concurrent.CountDownLatch r8 = r7.k     // Catch:{ Exception | OutOfMemoryError -> 0x0068 }
            r8.countDown()     // Catch:{ Exception | OutOfMemoryError -> 0x0068 }
        L_0x0068:
            java.util.concurrent.CountDownLatch r8 = r7.k     // Catch:{ Exception | OutOfMemoryError -> 0x006d }
            r8.countDown()     // Catch:{ Exception | OutOfMemoryError -> 0x006d }
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectVideoMetricsWorker.d(android.content.Context):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.r.release();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(Context context) {
        ConnectionType a2 = TrackingHelper.a().a(context);
        if (a2 != this.u) {
            this.v++;
        }
        this.u = a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00e6 */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:1:0x0003] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r12) {
        /*
            r11 = this;
            super.a((android.content.Context) r12)
            com.cellrebel.sdk.utils.SettingsManager r0 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            com.cellrebel.sdk.networking.beans.response.Settings r0 = r0.c()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r11.y = r0     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            java.lang.String r0 = "(?<=watch\\?v=|/videos/|embed/|youtu.be/|/v/|/e/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%‌​2F|youtu.be%2F|%2Fv%2F)[^#&?\\n]*"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            java.lang.String r1 = r11.n     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            java.util.regex.Matcher r0 = r0.matcher(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            boolean r1 = r0.find()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            if (r1 == 0) goto L_0x0028
            java.lang.String r0 = r0.group()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r11.m = r0     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
        L_0x0028:
            java.lang.String r0 = r11.m     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            if (r0 != 0) goto L_0x002d
            return
        L_0x002d:
            com.cellrebel.sdk.utils.SettingsManager r0 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            com.cellrebel.sdk.networking.beans.response.Settings r0 = r0.c()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            java.lang.String r1 = "audio"
            java.lang.Object r1 = r12.getSystemService(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            android.media.AudioManager r1 = (android.media.AudioManager) r1     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            boolean r1 = r1.isMusicActive()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            if (r0 == 0) goto L_0x0054
            java.lang.Boolean r0 = r0.audioManagerEnabled()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            if (r0 == 0) goto L_0x0054
            boolean r0 = r11.b     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            if (r0 != 0) goto L_0x0054
            if (r1 == 0) goto L_0x0054
            return
        L_0x0054:
            java.lang.String r0 = "power"
            java.lang.Object r0 = r12.getSystemService(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r4 = r0
            android.os.PowerManager r4 = (android.os.PowerManager) r4     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            com.cellrebel.sdk.networking.beans.request.VideoMetric r0 = r11.z     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            java.lang.String r1 = r11.l     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r0.measurementSequenceId = r1     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            java.lang.String r1 = r11.n     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r0.fileUrl(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            com.cellrebel.sdk.networking.beans.request.VideoMetric r0 = r11.z     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            java.lang.String r1 = r11.n     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            java.lang.String r1 = com.cellrebel.sdk.ping.IPTools.a((java.lang.String) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r0.serverIp = r1     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            com.cellrebel.sdk.networking.beans.request.VideoMetric r0 = r11.z     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            java.lang.String r1 = r11.o     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r0.videoSource(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            boolean r0 = r0.c()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r10 = 1
            if (r0 != 0) goto L_0x00a4
            com.cellrebel.sdk.networking.beans.request.VideoMetric r0 = r11.z     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r1 = 500(0x1f4, float:7.0E-43)
            r0.stateDuringMeasurement(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r0.<init>(r10)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r11.k = r0     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r11.a = r10     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            com.cellrebel.sdk.networking.beans.request.VideoMetric r0 = r11.z     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            com.cellrebel.sdk.workers.CollectVideoMetricsWorker$$ExternalSyntheticLambda2 r1 = new com.cellrebel.sdk.workers.CollectVideoMetricsWorker$$ExternalSyntheticLambda2     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r1.<init>(r11)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r12, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r0, (java.lang.Runnable) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            java.util.concurrent.CountDownLatch r12 = r11.k     // Catch:{ Exception | OutOfMemoryError -> 0x00a3 }
            r12.await()     // Catch:{ Exception | OutOfMemoryError -> 0x00a3 }
        L_0x00a3:
            return
        L_0x00a4:
            com.cellrebel.sdk.networking.beans.request.VideoMetric r1 = r11.z     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            boolean r2 = com.cellrebel.sdk.workers.BaseMetricsWorker.h     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            boolean r3 = r11.c     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            boolean r5 = r11.b     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            boolean r6 = r11.d     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            boolean r7 = r11.e     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            boolean r8 = r11.f     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            boolean r9 = r11.g     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            com.cellrebel.sdk.utils.Utils.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            com.cellrebel.sdk.database.ConnectionType r0 = r0.a((android.content.Context) r12)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r11.u = r0     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            long r0 = android.net.TrafficStats.getTotalTxBytes()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r11.w = r0     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            long r0 = android.net.TrafficStats.getTotalRxBytes()     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r11.x = r0     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r11.b((android.content.Context) r12)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            com.cellrebel.sdk.workers.CollectVideoMetricsWorker$$ExternalSyntheticLambda3 r3 = new com.cellrebel.sdk.workers.CollectVideoMetricsWorker$$ExternalSyntheticLambda3     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r3.<init>(r11, r12)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            java.util.concurrent.ScheduledExecutorService r2 = r11.B     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            r4 = 0
            r6 = 500(0x1f4, double:2.47E-321)
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            java.util.concurrent.ScheduledFuture r12 = r2.scheduleAtFixedRate(r3, r4, r6, r8)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
            java.util.concurrent.CountDownLatch r0 = r11.k     // Catch:{ InterruptedException -> 0x00e6, Exception | OutOfMemoryError -> 0x00e9 }
            r0.await()     // Catch:{ InterruptedException -> 0x00e6, Exception | OutOfMemoryError -> 0x00e9 }
        L_0x00e6:
            r12.cancel(r10)     // Catch:{ Exception | OutOfMemoryError -> 0x00e9 }
        L_0x00e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectVideoMetricsWorker.a(android.content.Context):void");
    }

    public void a(boolean z2) {
        try {
            ScheduledFuture<?> scheduledFuture = this.C;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                this.C = null;
            }
            ScheduledFuture<?> scheduledFuture2 = this.E;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(true);
                this.E = null;
            }
            ScheduledFuture<?> scheduledFuture3 = this.G;
            if (scheduledFuture3 != null) {
                scheduledFuture3.cancel(true);
                this.G = null;
            }
            YouTubePlayerListener youTubePlayerListener = this.t;
            if (youTubePlayerListener != null) {
                this.s.a(youTubePlayerListener);
            }
            YouTubePlayer youTubePlayer = this.s;
            if (youTubePlayer != null) {
                youTubePlayer.a(0);
                this.s.e();
                new Handler(Looper.getMainLooper()).post(new CollectVideoMetricsWorker$$ExternalSyntheticLambda0(this));
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }
}
