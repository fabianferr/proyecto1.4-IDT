package com.cellrebel.sdk.trafficprofile;

import android.content.Context;
import androidx.media3.common.C;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfile;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfileConfig;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfileErrorType;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfileMeasurementSettings;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfileResult;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegment;
import com.cellrebel.sdk.trafficprofile.udp.UdpClient;
import com.cellrebel.sdk.trafficprofile.udp.UdpMessageType;
import com.cellrebel.sdk.trafficprofile.udp.messages.UdpMessage;
import com.cellrebel.sdk.trafficprofile.udp.messages.UdpPackageMessage;
import com.cellrebel.sdk.trafficprofile.udp.messages.UdpProfileMessage;
import com.cellrebel.sdk.trafficprofile.utils.DownloadManager;
import com.cellrebel.sdk.trafficprofile.utils.FileManager;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TrafficProfileMeasurer {
    private final TrafficProfileMeasurementSettings a;
    private final Context b;
    private final List<Long> c = new ArrayList();
    private UdpClient d;
    /* access modifiers changed from: private */
    public List<TrafficProfile> e;
    private List<Thread> f = new ArrayList();
    private long g;
    /* access modifiers changed from: private */
    public boolean h = false;
    /* access modifiers changed from: private */
    public boolean i = false;
    private Timer j;
    /* access modifiers changed from: private */
    public TrafficProfileResultProcessor k;
    private String l;
    /* access modifiers changed from: private */
    public e m;
    private TrafficProfile n;
    /* access modifiers changed from: private */
    public CountDownLatch o;
    private String p;
    private List<TrafficProfileErrorType> q = new ArrayList();

    class a implements e {
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        public void a() {
            TrafficProfileMeasurer.this.g();
        }

        public void a(TrafficProfileErrorType trafficProfileErrorType) {
            if (TrafficProfileMeasurer.this.e.isEmpty()) {
                TrafficProfileMeasurer.this.o.countDown();
            } else {
                TrafficProfileMeasurer.this.g();
            }
        }

        public void b() {
            boolean unused = TrafficProfileMeasurer.this.i = true;
            if (TrafficProfileMeasurer.this.h) {
                this.a.addAll(TrafficProfileMeasurer.this.k.a());
                TrafficProfileMeasurer.this.g();
            }
        }

        public void c() {
            boolean unused = TrafficProfileMeasurer.this.h = true;
            if (TrafficProfileMeasurer.this.i) {
                this.a.addAll(TrafficProfileMeasurer.this.k.a());
                TrafficProfileMeasurer.this.g();
            }
        }

        public void d() {
            TrafficProfileMeasurer.this.o.countDown();
        }
    }

    class b implements UdpClient.UdpClientListener {
        b() {
        }

        public void a() {
            TrafficProfileMeasurer.this.m.a(TrafficProfileErrorType.UDP_CONNECTION_FAILURE);
        }

        public void a(UdpMessage udpMessage, long j) {
            int i = d.a[udpMessage.a.ordinal()];
            if (i == 1) {
                TrafficProfileMeasurer.this.a(udpMessage);
            } else if (i == 2) {
                TrafficProfileMeasurer.this.b(udpMessage);
            } else if (i == 3) {
                TrafficProfileMeasurer.this.a((UdpPackageMessage) udpMessage, j);
            } else if (i == 4) {
                TrafficProfileMeasurer.this.h();
            }
        }
    }

    class c extends TimerTask {
        c() {
        }

        public void run() {
            TrafficProfileMeasurer.this.m.c();
        }
    }

    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.cellrebel.sdk.trafficprofile.udp.UdpMessageType[] r0 = com.cellrebel.sdk.trafficprofile.udp.UdpMessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.cellrebel.sdk.trafficprofile.udp.UdpMessageType r1 = com.cellrebel.sdk.trafficprofile.udp.UdpMessageType.HANDSHAKE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.cellrebel.sdk.trafficprofile.udp.UdpMessageType r1 = com.cellrebel.sdk.trafficprofile.udp.UdpMessageType.PING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.cellrebel.sdk.trafficprofile.udp.UdpMessageType r1 = com.cellrebel.sdk.trafficprofile.udp.UdpMessageType.DOWNLINK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.cellrebel.sdk.trafficprofile.udp.UdpMessageType r1 = com.cellrebel.sdk.trafficprofile.udp.UdpMessageType.DOWNLINK_READY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.trafficprofile.TrafficProfileMeasurer.d.<clinit>():void");
        }
    }

    private interface e {
        void a();

        void a(TrafficProfileErrorType trafficProfileErrorType);

        void b();

        void c();

        void d();
    }

    public TrafficProfileMeasurer(Context context, TrafficProfileMeasurementSettings trafficProfileMeasurementSettings) {
        this.b = context;
        this.a = trafficProfileMeasurementSettings;
    }

    private String a() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(32);
        for (int i2 = 0; i2 < 32; i2++) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(52)));
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void a(TrafficProfileConfig trafficProfileConfig) {
        for (TrafficProfileSegment next : trafficProfileConfig.b) {
            for (int i2 = 0; i2 < next.d; i2++) {
                try {
                    UdpPackageMessage udpPackageMessage = new UdpPackageMessage();
                    udpPackageMessage.a = UdpMessageType.UPLINK;
                    udpPackageMessage.i = next.b;
                    udpPackageMessage.c = i2;
                    udpPackageMessage.e = this.n.a;
                    udpPackageMessage.f = trafficProfileConfig.a;
                    udpPackageMessage.g = next.a;
                    udpPackageMessage.b = TrafficProfileMeasurementUtils.a().b();
                    udpPackageMessage.h = this.p;
                    String str = udpPackageMessage.h;
                    int i3 = udpPackageMessage.g;
                    int i4 = udpPackageMessage.c;
                    int i5 = udpPackageMessage.i;
                    this.d.a((UdpMessage) udpPackageMessage);
                    Thread.sleep((long) next.c);
                } catch (InterruptedException unused) {
                }
            }
        }
        return null;
    }

    private List<TrafficProfileResult> a(List<TrafficProfileResult> list) {
        String str = this.l;
        for (TrafficProfileResult trafficProfileResult : list) {
            trafficProfileResult.w = str;
        }
        return list;
    }

    /* access modifiers changed from: private */
    public void a(UdpMessage udpMessage) {
        long j2 = udpMessage.b;
        i();
    }

    /* access modifiers changed from: private */
    public void a(UdpPackageMessage udpPackageMessage, long j2) {
        Timer timer = this.j;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.j = timer2;
        timer2.schedule(new c(), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        udpPackageMessage.b = j2;
        int i2 = udpPackageMessage.e;
        int i3 = udpPackageMessage.g;
        int i4 = udpPackageMessage.c;
        long j3 = udpPackageMessage.d;
        int i5 = udpPackageMessage.i;
        this.k.a(udpPackageMessage);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(this.n.d.size());
        ArrayList arrayList = new ArrayList();
        for (TrafficProfileConfig trafficProfileMeasurer$$ExternalSyntheticLambda1 : this.n.d) {
            arrayList.add(new TrafficProfileMeasurer$$ExternalSyntheticLambda1(this, trafficProfileMeasurer$$ExternalSyntheticLambda1));
        }
        try {
            newFixedThreadPool.invokeAll(arrayList);
        } catch (InterruptedException unused) {
        }
        newFixedThreadPool.shutdown();
        List<UdpPackageMessage> a2 = new TrafficProfileUplinkDataProvider(this.l, this.a.g, new DownloadManager(), new FileManager(this.b)).a(this.p);
        this.k.a(a2);
        Objects.toString(a2);
        this.m.b();
    }

    /* access modifiers changed from: private */
    public void b(UdpMessage udpMessage) {
        long b2 = TrafficProfileMeasurementUtils.a().b();
        long j2 = this.g;
        this.c.add(Long.valueOf((udpMessage.b - ((b2 - j2) / 2)) - j2));
        int i2 = udpMessage.c;
        long j3 = udpMessage.b;
        i();
    }

    private void c() {
        this.d.a((UdpClient.UdpClientListener) new b());
    }

    private void d() {
        this.d.a(new UdpMessage(UdpMessageType.HANDSHAKE));
    }

    private void f() {
        UdpProfileMessage udpProfileMessage = new UdpProfileMessage();
        udpProfileMessage.d = this.n;
        this.d.a((UdpMessage) udpProfileMessage);
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.e.size() > 0) {
            this.h = false;
            this.i = false;
            this.p = a();
            this.n = this.e.remove(0);
            TrafficProfileResultProcessor trafficProfileResultProcessor = new TrafficProfileResultProcessor();
            this.k = trafficProfileResultProcessor;
            trafficProfileResultProcessor.a(this.n);
            f();
            return;
        }
        this.m.d();
    }

    /* access modifiers changed from: private */
    public void h() {
        new Thread(new TrafficProfileMeasurer$$ExternalSyntheticLambda0(this)).start();
    }

    private void i() {
        if (this.c.size() < 10) {
            UdpMessage udpMessage = new UdpMessage(UdpMessageType.PING);
            udpMessage.c = this.c.size();
            long b2 = TrafficProfileMeasurementUtils.a().b();
            this.g = b2;
            udpMessage.b = b2;
            this.d.a(udpMessage);
            return;
        }
        long longValue = ((Long) Collections.max(this.c)).longValue();
        long longValue2 = ((Long) Collections.min(this.c)).longValue();
        if (Math.abs(longValue2) > Math.abs(longValue)) {
            TrafficProfileMeasurementUtils.a().a(longValue);
        } else {
            TrafficProfileMeasurementUtils.a().a(longValue2);
        }
        this.m.a();
    }

    public List<TrafficProfileResult> e() {
        List<TrafficProfileErrorType> list;
        TrafficProfileErrorType trafficProfileErrorType;
        this.o = new CountDownLatch(1);
        ArrayList arrayList = new ArrayList();
        TrafficProfileMeasurementSettings trafficProfileMeasurementSettings = this.a;
        this.e = TrafficProfileRandomizer.a(trafficProfileMeasurementSettings.e, trafficProfileMeasurementSettings.f);
        TrafficProfileServerSelector trafficProfileServerSelector = new TrafficProfileServerSelector();
        TrafficProfileMeasurementSettings trafficProfileMeasurementSettings2 = this.a;
        String a2 = trafficProfileServerSelector.a(trafficProfileMeasurementSettings2.a, trafficProfileMeasurementSettings2.b, trafficProfileMeasurementSettings2.c, trafficProfileMeasurementSettings2.d);
        this.l = a2;
        if (a2 == null) {
            list = this.q;
            trafficProfileErrorType = TrafficProfileErrorType.SERVER_SELECTION_FAILURE;
        } else {
            try {
                this.d = new UdpClient(a2, this.a.b);
                for (TrafficProfile next : this.e) {
                    int i2 = next.a;
                    for (TrafficProfileConfig trafficProfileConfig : next.c) {
                        for (TrafficProfileSegment trafficProfileSegment : trafficProfileConfig.b) {
                            trafficProfileSegment.toString();
                        }
                    }
                    for (TrafficProfileConfig trafficProfileConfig2 : next.d) {
                        for (TrafficProfileSegment trafficProfileSegment2 : trafficProfileConfig2.b) {
                            trafficProfileSegment2.toString();
                        }
                    }
                }
                this.n = this.e.get(0);
                this.m = new a(arrayList);
                c();
                d();
                try {
                    if (!this.o.await((long) this.a.h, TimeUnit.SECONDS)) {
                        this.q.add(TrafficProfileErrorType.TRAFFIC_PROFILE_TIMEOUT);
                        return a((List<TrafficProfileResult>) arrayList);
                    }
                } catch (InterruptedException unused) {
                    this.q.add(TrafficProfileErrorType.TRAFFIC_PROFILE_INTERRUPTED);
                }
                return a((List<TrafficProfileResult>) arrayList);
            } catch (SocketException unused2) {
                list = this.q;
                trafficProfileErrorType = TrafficProfileErrorType.UDP_CONNECTION_FAILURE;
            }
        }
        list.add(trafficProfileErrorType);
        return a((List<TrafficProfileResult>) arrayList);
    }
}
