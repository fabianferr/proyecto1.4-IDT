package com.cellrebel.sdk.workers;

import android.content.Context;
import com.cellrebel.sdk.database.dao.GameMetricDAO;
import com.cellrebel.sdk.networking.beans.request.GameInfoMetric;
import com.cellrebel.sdk.utils.FileLoggingTree;
import com.cellrebel.sdk.utils.Storage;
import com.cellrebel.sdk.utils.TelephonyHelper;
import com.cellrebel.sdk.utils.TrackingHelper;
import com.cellrebel.sdk.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte$$ExternalSyntheticBackport0;

public class MetaHelp {
    public static FileLoggingTree l;
    public String a;
    public boolean b = false;
    public boolean c = false;
    public long d;
    public CollectPageLoadMetricsWorker e;
    public CollectGameWorker f;
    public CollectLoadedLatencyWorker g;
    public CollectFileTransferMetricsWorker h;
    public CollectVideoMetricsWorker i;
    public CollectTrafficProfileWorker j;
    private Context k;

    public MetaHelp(Context context) {
        this.k = context;
    }

    private List<GameInfoMetric> a(GameMetricDAO gameMetricDAO) {
        ArrayList arrayList = new ArrayList();
        List<GameInfoMetric> all = gameMetricDAO.getAll();
        all.size();
        for (GameInfoMetric next : all) {
            String str = next.loadedLatencyTestFileTransferUrl;
            if (str != null && !UByte$$ExternalSyntheticBackport0.m(str) && !next.isUnderAdditionalLoad) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private void a() {
        TrackingHelper.a().e();
        TelephonyHelper.b().d();
    }

    private boolean a(Integer num) {
        return num.intValue() == 0 || Math.abs(Storage.J().g() - this.d) >= ((long) (num.intValue() * 60)) * 1000;
    }

    private boolean a(Integer num, int i2) {
        Utils.b("trafficProfile_worker");
        long Q = Storage.J().Q();
        Math.abs(Q - this.d);
        num.intValue();
        if (Math.abs(Q - this.d) < (((long) (num.intValue() * 60)) * 1000) - ((long) i2)) {
            return false;
        }
        Storage.J().N(this.d);
        Storage.J().P();
        return true;
    }

    private boolean b(int i2) {
        return i2 == 0 || Math.abs(Storage.J().j() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    private boolean b(Integer num) {
        return num.intValue() == 0 || Math.abs(Storage.J().o() - this.d) >= ((long) (num.intValue() * 60)) * 1000;
    }

    private boolean b(Integer num, int i2) {
        Utils.b("tti_worker");
        long R = Storage.J().R();
        Math.abs(R - this.d);
        num.intValue();
        if (Math.abs(R - this.d) < (((long) (num.intValue() * 60)) * 1000) - ((long) i2)) {
            return false;
        }
        Storage.J().O(this.d);
        Storage.J().P();
        return true;
    }

    private boolean c(Integer num) {
        return num.intValue() == 0 || Math.abs(Storage.J().C() - this.d) >= ((long) (num.intValue() * 60)) * 1000;
    }

    private boolean d(int i2) {
        return i2 == 0 || Math.abs(Storage.J().l() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    private boolean d(Integer num) {
        return num.intValue() == 0 || Math.abs(Storage.J().D() - this.d) >= ((long) (num.intValue() * 60)) * 1000;
    }

    private boolean e(Integer num) {
        return num.intValue() == 0 || Math.abs(Storage.J().E() - this.d) >= ((long) (num.intValue() * 60)) * 1000;
    }

    private boolean f(int i2) {
        return i2 == 0 || Math.abs(Storage.J().q() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    private boolean f(Integer num) {
        return num.intValue() == 0 || Math.abs(Storage.J().F() - this.d) >= ((long) (num.intValue() * 60)) * 1000;
    }

    private boolean h(int i2) {
        return i2 == 0 || Math.abs(Storage.J().s() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    private boolean l(int i2) {
        return i2 == 0 || Math.abs(Storage.J().y() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    private boolean n(int i2) {
        return i2 == 0 || Math.abs(Storage.J().A() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    private boolean p(int i2) {
        return i2 == 0 || Math.abs(Storage.J().H() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    private boolean r(int i2) {
        return i2 == 0 || Math.abs(Storage.J().H() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1154:0x1a2d, code lost:
        android.util.Log.d("CellRebelSDK", "Measurements finished - OutOfMemoryError");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x068f, code lost:
        if (r6.cdnFileMeasurements().booleanValue() != false) goto L_0x0691;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x077d, code lost:
        if (r6.randomCdnFileMeasurements().booleanValue() != false) goto L_0x077f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:503:0x097b, code lost:
        if (r6.randomCdnFileMeasurements().booleanValue() != false) goto L_0x097d;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1041:0x1714 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0180 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:967:0x14b0 */
    /* JADX WARNING: Removed duplicated region for block: B:1022:0x16b0 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:1023:0x16b4 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x16bb A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x171a A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:1087:0x18a5 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:1090:0x18c1 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:1092:0x18d1 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:1093:0x18d4 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:1095:0x18d8 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02a1 A[Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:1121:0x1982 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:1155:? A[ExcHandler: OutOfMemoryError (unused java.lang.OutOfMemoryError), SYNTHETIC, Splitter:B:56:0x0180] */
    /* JADX WARNING: Removed duplicated region for block: B:1170:0x0af9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1198:0x13a0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0383 A[Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x04b6 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x04d1 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x04ec A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x04ee A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x04f9 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0511 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x052e A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0530 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x053b A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x054d A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x055a A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0568 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0575 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0583 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0596 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x05a8 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x05b5 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x05cc A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x06a2 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x06b3 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x06d0 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x06e1 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x06fe A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x070f A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x072c A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x073d A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0754 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x0781 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x0790 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x079d A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x07ba A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x07c7 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x08a0 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x08b1 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:459:0x08ce A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:462:0x08df A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:471:0x08fc A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:474:0x090d A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x092a A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:486:0x093b A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:494:0x0952 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:505:0x097f A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:510:0x098e A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:513:0x099b A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:522:0x09b8 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:525:0x09c5 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:546:0x0a28 A[ADDED_TO_REGION, Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:560:0x0a4a A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:584:0x0af7 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:590:0x0b2b  */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0b3c A[SYNTHETIC, Splitter:B:593:0x0b3c] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x018a A[Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x019c A[Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:679:0x0d56 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:681:0x0d64 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:692:0x0dcc A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:694:0x0dd7 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:699:0x0de8 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:701:0x0df6 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:812:0x10c1 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x119c A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:865:0x126d A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:918:0x13ab A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x13d7 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:952:0x1455 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* JADX WARNING: Removed duplicated region for block: B:970:0x14b6 A[Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.work.ListenableWorker.Result a(boolean r52, boolean r53, boolean r54, boolean r55, boolean r56, boolean r57) {
        /*
            r51 = this;
            r0 = r51
            r1 = r53
            r2 = r54
            r3 = r55
            r4 = r56
            r5 = r57
            java.lang.String r6 = "https://metricreceiver.cellrebel.com/"
            java.lang.String r7 = "Measurements finished"
            com.cellrebel.sdk.database.SDKRoomDatabase r8 = com.cellrebel.sdk.database.DatabaseClient.a()
            if (r8 != 0) goto L_0x001b
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.success()
            return r1
        L_0x001b:
            r8 = 1
            r0.c = r8
            android.content.Context r9 = r0.k
            boolean r9 = com.cellrebel.sdk.utils.Utils.f(r9)
            java.lang.String r10 = "Measurements cancelled low memory"
            java.lang.String r11 = "CellRebelSDK"
            r12 = 0
            if (r9 == 0) goto L_0x0038
            android.util.Log.d(r11, r10)
            r0.c = r12
            r51.a()
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()
            return r1
        L_0x0038:
            long r13 = java.lang.System.currentTimeMillis()
            r0.d = r13
            com.cellrebel.sdk.utils.Storage r9 = com.cellrebel.sdk.utils.Storage.J()
            long r13 = r9.t()
            r15 = r7
            long r7 = r9.u()
            long r7 = java.lang.Math.max(r13, r7)
            long r13 = r9.K()
            java.lang.String r12 = "Measurements skipped, launch time check"
            r17 = 900000(0xdbba0, double:4.44659E-318)
            r4 = 0
            if (r52 != 0) goto L_0x0078
            if (r1 != 0) goto L_0x0078
            int r19 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x0078
            long r4 = r0.d
            long r13 = r13 - r4
            long r4 = java.lang.Math.abs(r13)
            int r13 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r13 > 0) goto L_0x0078
            android.util.Log.d(r11, r12)
            r1 = 0
            r0.c = r1
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.success()
            return r1
        L_0x0078:
            if (r52 != 0) goto L_0x0098
            if (r1 != 0) goto L_0x0098
            r4 = 0
            int r13 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0098
            long r4 = r0.d
            long r7 = r7 - r4
            long r4 = java.lang.Math.abs(r7)
            int r7 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r7 > 0) goto L_0x0098
            android.util.Log.d(r11, r12)
            r1 = 0
            r0.c = r1
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.success()
            return r1
        L_0x0098:
            long r4 = r0.d
            r9.I(r4)
            com.cellrebel.sdk.utils.FileLoggingTree r4 = l
            if (r4 != 0) goto L_0x00aa
            com.cellrebel.sdk.utils.FileLoggingTree r4 = new com.cellrebel.sdk.utils.FileLoggingTree
            android.content.Context r5 = r0.k
            r4.<init>(r5)
            l = r4
        L_0x00aa:
            boolean r4 = r0.b
            java.lang.String r5 = "Measurements cancelled"
            if (r4 == 0) goto L_0x00be
            android.util.Log.d(r11, r5)
            r1 = 0
            r0.c = r1
            r51.a()
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()
            return r1
        L_0x00be:
            if (r52 != 0) goto L_0x00c7
            if (r1 != 0) goto L_0x00c7
            long r7 = r0.d
            r9.a(r7)
        L_0x00c7:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.util.UUID r7 = java.util.UUID.randomUUID()
            r4.append(r7)
            com.cellrebel.sdk.utils.PreferencesManager r7 = com.cellrebel.sdk.utils.PreferencesManager.m()
            android.content.Context r8 = r0.k
            java.lang.String r7 = r7.a((android.content.Context) r8)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = com.cellrebel.sdk.utils.Utils.b((java.lang.String) r4)
            r0.a = r4
            com.cellrebel.sdk.utils.TrackingHelper r4 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r4.d()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.utils.TelephonyHelper r4 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r4.a()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.utils.SettingsManager r4 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.networking.beans.response.Settings r4 = r4.c()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            long r7 = r9.N()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r12 = 0
            int r14 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x0118
            long r12 = r0.d     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            long r7 = r7 - r12
            long r7 = java.lang.Math.abs(r7)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r12 = 86400000(0x5265c00, double:4.2687272E-316)
            int r14 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x0180
        L_0x0118:
            com.cellrebel.sdk.networking.ApiService r7 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{ IOException -> 0x0180 }
            java.lang.String r8 = com.cellrebel.sdk.networking.UrlProvider.b(r4)     // Catch:{ IOException -> 0x0180 }
            retrofit2.Call r7 = r7.d(r8)     // Catch:{ IOException -> 0x0180 }
            retrofit2.Response r7 = r7.execute()     // Catch:{ IOException -> 0x0180 }
            boolean r8 = r7.isSuccessful()     // Catch:{ IOException -> 0x0180 }
            if (r8 == 0) goto L_0x0146
            java.lang.Object r8 = r7.body()     // Catch:{ IOException -> 0x0180 }
            if (r8 == 0) goto L_0x0146
            com.cellrebel.sdk.utils.SettingsManager r6 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ IOException -> 0x0180 }
            java.lang.Object r7 = r7.body()     // Catch:{ IOException -> 0x0180 }
            com.cellrebel.sdk.networking.beans.response.Settings r7 = (com.cellrebel.sdk.networking.beans.response.Settings) r7     // Catch:{ IOException -> 0x0180 }
            r6.a(r7)     // Catch:{ IOException -> 0x0180 }
            long r6 = r0.d     // Catch:{ IOException -> 0x0180 }
            r7 = r6
            r6 = r9
            goto L_0x017d
        L_0x0146:
            java.lang.String r7 = com.cellrebel.sdk.networking.UrlProvider.b(r4)     // Catch:{ IOException -> 0x0180 }
            boolean r7 = r7.equals(r6)     // Catch:{ IOException -> 0x0180 }
            if (r7 != 0) goto L_0x0180
            com.cellrebel.sdk.networking.ApiService r7 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{ IOException -> 0x0180 }
            retrofit2.Call r6 = r7.d(r6)     // Catch:{ IOException -> 0x0180 }
            retrofit2.Response r6 = r6.execute()     // Catch:{ IOException -> 0x0180 }
            boolean r7 = r6.isSuccessful()     // Catch:{ IOException -> 0x0180 }
            if (r7 == 0) goto L_0x0180
            java.lang.Object r7 = r6.body()     // Catch:{ IOException -> 0x0180 }
            if (r7 == 0) goto L_0x0180
            com.cellrebel.sdk.utils.SettingsManager r7 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ IOException -> 0x0180 }
            java.lang.Object r6 = r6.body()     // Catch:{ IOException -> 0x0180 }
            com.cellrebel.sdk.networking.beans.response.Settings r6 = (com.cellrebel.sdk.networking.beans.response.Settings) r6     // Catch:{ IOException -> 0x0180 }
            r7.a(r6)     // Catch:{ IOException -> 0x0180 }
            com.cellrebel.sdk.utils.Storage r6 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ IOException -> 0x0180 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0180 }
        L_0x017d:
            r6.L(r7)     // Catch:{ IOException -> 0x0180 }
        L_0x0180:
            com.cellrebel.sdk.utils.SettingsManager r6 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.networking.beans.response.Settings r6 = r6.c()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r6 != 0) goto L_0x019c
            java.lang.String r1 = "Measurements skipped, settings unavailable"
            android.util.Log.d(r11, r1)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r9.I(r1)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.success()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x019c:
            if (r4 == 0) goto L_0x0262
            java.lang.Integer r7 = r4.pageLoadPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r8 = 15
            if (r7 <= r8) goto L_0x01b3
            java.lang.Integer r7 = r4.pageLoadPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            goto L_0x01b5
        L_0x01b3:
            r7 = 15
        L_0x01b5:
            java.lang.Integer r12 = r4.fileTransferPeriodicityTimer()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r12 <= r8) goto L_0x01c8
            java.lang.Integer r12 = r4.fileTransferPeriodicityTimer()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            goto L_0x01ca
        L_0x01c8:
            r12 = 15
        L_0x01ca:
            java.lang.Integer r13 = r4.videoBackgroundPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r13 = r13.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r13 <= r8) goto L_0x01dd
            java.lang.Integer r13 = r4.videoBackgroundPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r13 = r13.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            goto L_0x01df
        L_0x01dd:
            r13 = 15
        L_0x01df:
            java.lang.Integer r14 = r4.coveragePeriodicity()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r14 = r14.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r14 <= r8) goto L_0x01f2
            java.lang.Integer r4 = r4.coveragePeriodicity()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            goto L_0x01f4
        L_0x01f2:
            r4 = 15
        L_0x01f4:
            int r7 = java.lang.Math.min(r7, r12)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r7 = java.lang.Math.min(r7, r13)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r4 = java.lang.Math.min(r7, r4)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r7 = r6.pageLoadPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r7 <= r8) goto L_0x0213
            java.lang.Integer r7 = r6.pageLoadPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            goto L_0x0215
        L_0x0213:
            r7 = 15
        L_0x0215:
            java.lang.Integer r12 = r6.fileTransferPeriodicityTimer()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r12 <= r8) goto L_0x0228
            java.lang.Integer r12 = r6.fileTransferPeriodicityTimer()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            goto L_0x022a
        L_0x0228:
            r12 = 15
        L_0x022a:
            java.lang.Integer r13 = r6.videoBackgroundPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r13 = r13.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r13 <= r8) goto L_0x023d
            java.lang.Integer r13 = r6.videoBackgroundPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r13 = r13.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            goto L_0x023f
        L_0x023d:
            r13 = 15
        L_0x023f:
            java.lang.Integer r14 = r6.coveragePeriodicity()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r14 = r14.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r14 <= r8) goto L_0x0251
            java.lang.Integer r8 = r6.coveragePeriodicity()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
        L_0x0251:
            int r7 = java.lang.Math.min(r7, r12)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r7 = java.lang.Math.min(r7, r13)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r7 = java.lang.Math.min(r7, r8)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r4 == r7) goto L_0x0260
            goto L_0x0262
        L_0x0260:
            r4 = 0
            goto L_0x0263
        L_0x0262:
            r4 = 1
        L_0x0263:
            if (r4 == 0) goto L_0x0383
            java.lang.Boolean r4 = r6.pageLoadBackgroundMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x02a1
            java.lang.Boolean r4 = r6.fileTransferBackgroundMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x02a1
            java.lang.Boolean r4 = r6.cdnBackgroundMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x02a1
            java.lang.Boolean r4 = r6.videoBackgroundMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x02a1
            java.lang.Boolean r4 = r6.backgroundCoverageMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x02a1
            java.lang.Boolean r4 = r6.backgroundGameMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0383
        L_0x02a1:
            java.lang.Boolean r1 = r6.pageLoadBackgroundMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == 0) goto L_0x02b7
            java.lang.Integer r1 = r6.pageLoadPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            goto L_0x02ba
        L_0x02b7:
            r1 = 2147483647(0x7fffffff, float:NaN)
        L_0x02ba:
            java.lang.Boolean r3 = r6.fileTransferBackgroundMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x02cd
            java.lang.Integer r3 = r6.fileTransferPeriodicityTimer()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            goto L_0x02d0
        L_0x02cd:
            r3 = 2147483647(0x7fffffff, float:NaN)
        L_0x02d0:
            java.lang.Boolean r4 = r6.cdnBackgroundMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x02e3
            java.lang.Integer r4 = r6.cdnFileDownloadPeriodicity()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            goto L_0x02e6
        L_0x02e3:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L_0x02e6:
            java.lang.Boolean r5 = r6.videoBackgroundMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r5 == 0) goto L_0x02f9
            java.lang.Integer r5 = r6.videoBackgroundPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            goto L_0x02fc
        L_0x02f9:
            r5 = 2147483647(0x7fffffff, float:NaN)
        L_0x02fc:
            java.lang.Boolean r7 = r6.backgroundCoverageMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            boolean r7 = r7.booleanValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r7 == 0) goto L_0x030f
            java.lang.Integer r7 = r6.coveragePeriodicity()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            goto L_0x0312
        L_0x030f:
            r7 = 2147483647(0x7fffffff, float:NaN)
        L_0x0312:
            java.lang.Boolean r8 = r6.backgroundGameMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            boolean r8 = r8.booleanValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r8 == 0) goto L_0x0324
            java.lang.Integer r2 = r6.backgroundGamePeriodicity()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
        L_0x0324:
            int r1 = java.lang.Math.min(r1, r3)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r1 = java.lang.Math.min(r1, r4)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r1 = java.lang.Math.min(r1, r5)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r1 = java.lang.Math.min(r1, r7)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r1 = java.lang.Math.min(r1, r2)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r1 != 0) goto L_0x033c
            r1 = 1440(0x5a0, float:2.018E-42)
        L_0x033c:
            androidx.work.PeriodicWorkRequest$Builder r2 = new androidx.work.PeriodicWorkRequest$Builder     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.lang.Class<com.cellrebel.sdk.workers.MetaWorker> r21 = com.cellrebel.sdk.workers.MetaWorker.class
            long r3 = (long) r1     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.util.concurrent.TimeUnit r27 = java.util.concurrent.TimeUnit.MINUTES     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r25 = 5
            r20 = r2
            r22 = r3
            r24 = r27
            r20.<init>(r21, r22, r24, r25, r27)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.lang.String r1 = "CR_MEASUREMENT_WORKER"
            androidx.work.WorkRequest$Builder r1 = r2.addTag(r1)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            androidx.work.PeriodicWorkRequest$Builder r1 = (androidx.work.PeriodicWorkRequest.Builder) r1     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            androidx.work.Constraints r2 = androidx.work.Constraints.NONE     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            androidx.work.WorkRequest$Builder r1 = r1.setConstraints(r2)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            androidx.work.PeriodicWorkRequest$Builder r1 = (androidx.work.PeriodicWorkRequest.Builder) r1     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            androidx.work.WorkRequest r1 = r1.build()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            androidx.work.PeriodicWorkRequest r1 = (androidx.work.PeriodicWorkRequest) r1     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            android.content.Context r2 = r0.k     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            androidx.work.WorkManager r2 = androidx.work.WorkManager.getInstance(r2)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.lang.String r3 = "CR_PERIODIC_WORKER"
            androidx.work.ExistingPeriodicWorkPolicy r4 = androidx.work.ExistingPeriodicWorkPolicy.REPLACE     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r2.enqueueUniquePeriodicWork(r3, r4, r1)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r7 = 0
            r9.I(r7)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.lang.String r1 = "Measurements skipped, reschedule"
            android.util.Log.d(r11, r1)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.success()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x0383:
            r7 = 0
            if (r52 != 0) goto L_0x0391
            java.lang.Boolean r4 = r6.backgroundLocationEnabled()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x039b
        L_0x0391:
            com.cellrebel.sdk.workers.LocationWorker r4 = new com.cellrebel.sdk.workers.LocationWorker     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r4.<init>()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            android.content.Context r9 = r0.k     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r4.a((android.content.Context) r9)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
        L_0x039b:
            java.lang.Integer r4 = r6.timeInBetweenMeasurements()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r9 = r6.pageLoadPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            int r9 = r9.intValue()     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            double r12 = (double) r9
            r17 = 4633641066610819072(0x404e000000000000, double:60.0)
            java.lang.Double.isNaN(r12)
            double r12 = r12 * r17
            r17 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r12 = r12 * r17
            r17 = 4616189618054758400(0x4010000000000000, double:4.0)
            double r12 = r12 / r17
            int r9 = (int) r12
            r12 = 0
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.lang.String r12 = r6.tracerouteUrl     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.lang.String r14 = ","
            if (r12 == 0) goto L_0x03cc
            java.lang.String[] r13 = r12.split(r14)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
        L_0x03cc:
            java.lang.String r12 = r6.pageLoadUrl     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.lang.String[] r12 = r12.split(r14)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.util.LinkedList r7 = new java.util.LinkedList     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.lang.String r8 = r6.cdnFileUrls     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.lang.String[] r8 = r8.split(r14)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.util.List r8 = java.util.Arrays.asList(r8)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r7.<init>(r8)     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            java.util.LinkedList r8 = new java.util.LinkedList     // Catch:{ Exception -> 0x1a43, OutOfMemoryError -> 0x1a2d }
            r17 = r15
            java.lang.String r15 = r6.randomCdnFileUrls()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String[] r15 = r15.split(r14)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.List r15 = java.util.Arrays.asList(r15)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r8.<init>(r15)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.utils.TrackingHelper r15 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r18 = r13
            android.content.Context r13 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.database.ConnectionType r13 = r15.a((android.content.Context) r13)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.database.ConnectionType r15 = com.cellrebel.sdk.database.ConnectionType.WIFI     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r13 != r15) goto L_0x0406
            r13 = 1
            goto L_0x0407
        L_0x0406:
            r13 = 0
        L_0x0407:
            com.cellrebel.sdk.utils.TrackingHelper r15 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.location.Location r15 = r15.b()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 != 0) goto L_0x0413
            r15 = 1
            goto L_0x0414
        L_0x0413:
            r15 = 0
        L_0x0414:
            if (r13 == 0) goto L_0x042d
            java.lang.Boolean r20 = r6.wifiMeasurementsEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r20 = r20.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r20 != 0) goto L_0x042d
            r4 = 0
            r0.c = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r1 = "Measurements skipped, wifi periodicity"
            android.util.Log.d(r11, r1)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.success()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x042d:
            r20 = r4
            if (r15 == 0) goto L_0x0448
            java.lang.Boolean r4 = r6.noLocationMeasurementEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x0448
            r4 = 0
            r0.c = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r1 = "Measurements skipped, location unavailable"
            android.util.Log.d(r11, r1)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.success()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x0448:
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = com.cellrebel.sdk.utils.Utils.f(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x045e
            android.util.Log.d(r11, r10)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x045e:
            if (r52 != 0) goto L_0x05e0
            if (r1 == 0) goto L_0x0464
            goto L_0x05e0
        L_0x0464:
            int r4 = r12.length     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0484
            java.lang.Boolean r4 = r6.pageLoadBackgroundMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0484
            r4 = 0
            r15 = r12[r4]     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r4 = r6.pageLoadPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.c(r15, r4, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0484
            r4 = 1
            goto L_0x0485
        L_0x0484:
            r4 = 0
        L_0x0485:
            java.lang.Boolean r15 = r6.fileTransferBackgroundMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r15 = r15.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x04a3
            java.lang.String r15 = r6.fileName     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r21 = r6.fileTransferPeriodicityTimer()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r22 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.b(r15, r4, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x04a5
            r4 = 1
            goto L_0x04a6
        L_0x04a3:
            r22 = r4
        L_0x04a5:
            r4 = 0
        L_0x04a6:
            int r15 = r7.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x04d1
            java.lang.Boolean r15 = r6.cdnBackgroundMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r15 = r15.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x04d1
            r15 = 0
            java.lang.Object r21 = r7.get(r15)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r15 = r21
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r21 = r6.cdnFileDownloadPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r23 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.a(r15, r4, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x04d3
            r4 = 1
            goto L_0x04d4
        L_0x04d1:
            r23 = r4
        L_0x04d3:
            r4 = 0
        L_0x04d4:
            java.lang.Boolean r15 = r6.tracerouteBackgroundMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r15 = r15.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x04ee
            java.lang.Integer r15 = r6.tracerouteForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r15 = r15.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r15 = r0.d(r15, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x04ee
            r15 = 1
            goto L_0x04ef
        L_0x04ee:
            r15 = 0
        L_0x04ef:
            java.lang.Boolean r21 = r6.videoBackgroundMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x0511
            r21 = r4
            java.lang.String r4 = r6.videoUrl()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r24 = r6.videoBackgroundPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r25 = r15
            int r15 = r24.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.d(r4, r15, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0515
            r4 = 1
            goto L_0x0516
        L_0x0511:
            r21 = r4
            r25 = r15
        L_0x0515:
            r4 = 0
        L_0x0516:
            java.lang.Boolean r15 = r6.backgroundCoverageMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r15 = r15.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x0530
            java.lang.Integer r15 = r6.coveragePeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r15 = r15.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r15 = r0.a((int) r15, (int) r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x0530
            r15 = 1
            goto L_0x0531
        L_0x0530:
            r15 = 0
        L_0x0531:
            java.lang.Boolean r24 = r6.backgroundGameMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r24 = r24.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r24 == 0) goto L_0x054d
            java.lang.Integer r24 = r6.backgroundGamePeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r26 = r4
            int r4 = r24.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.b((int) r4, (int) r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x054f
            r4 = 1
            goto L_0x0550
        L_0x054d:
            r26 = r4
        L_0x054f:
            r4 = 0
        L_0x0550:
            java.lang.Boolean r24 = r6.deviceInfoBackgroundMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r24 = r24.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r24 == 0) goto L_0x0568
            r24 = r4
            java.lang.Integer r4 = r6.deviceInfoBackgroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.a((java.lang.Integer) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x056a
            r4 = 1
            goto L_0x056b
        L_0x0568:
            r24 = r4
        L_0x056a:
            r4 = 0
        L_0x056b:
            java.lang.Boolean r27 = r6.timeToInteractionBackgroundMeasurementsEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r27 = r27.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r27 == 0) goto L_0x0583
            r27 = r4
            java.lang.Integer r4 = r6.timeToInteractionForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.b((java.lang.Integer) r4, (int) r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0585
            r4 = 1
            goto L_0x0586
        L_0x0583:
            r27 = r4
        L_0x0585:
            r4 = 0
        L_0x0586:
            int r28 = r8.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r28 == 0) goto L_0x05a8
            java.lang.Boolean r28 = r6.randomCdnBackgroundMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r28 = r28.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r28 == 0) goto L_0x05a8
            java.lang.Integer r28 = r6.randomCdnFileDownloadPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r29 = r4
            int r4 = r28.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.c(r4, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x05aa
            r4 = 1
            goto L_0x05ab
        L_0x05a8:
            r29 = r4
        L_0x05aa:
            r4 = 0
        L_0x05ab:
            java.lang.Boolean r28 = r6.trafficProfileBackgroundMeasurementsEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r28 = r28.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r28 == 0) goto L_0x05cc
            r28 = r4
            java.lang.Integer r4 = r6.trafficProfileBackgroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.a((java.lang.Integer) r4, (int) r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x05ce
            r4 = r22
            r9 = r23
            r22 = 0
            r23 = r21
            r21 = 1
            goto L_0x05d8
        L_0x05cc:
            r28 = r4
        L_0x05ce:
            r4 = r22
            r9 = r23
            r22 = 0
            r23 = r21
            r21 = 0
        L_0x05d8:
            r50 = r26
            r26 = r24
            r24 = r50
            goto L_0x0a26
        L_0x05e0:
            if (r13 == 0) goto L_0x07e2
            int r4 = r12.length     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x060d
            if (r52 == 0) goto L_0x05ff
            java.lang.Boolean r4 = r6.isPageLoadMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x05ff
            java.lang.Integer r4 = r6.wifiPageLoadForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.l(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x060b
        L_0x05ff:
            if (r1 == 0) goto L_0x060d
            java.lang.Boolean r4 = r6.isPageLoadMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x060d
        L_0x060b:
            r4 = 1
            goto L_0x060e
        L_0x060d:
            r4 = 0
        L_0x060e:
            if (r52 == 0) goto L_0x0628
            java.lang.Boolean r9 = r6.fileMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r9 = r9.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x0628
            java.lang.Integer r9 = r6.wifiFileTransferForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r9 = r9.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r9 = r0.f((int) r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 != 0) goto L_0x0634
        L_0x0628:
            if (r1 == 0) goto L_0x0636
            java.lang.Boolean r9 = r6.fileMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r9 = r9.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x0636
        L_0x0634:
            r9 = 1
            goto L_0x0637
        L_0x0636:
            r9 = 0
        L_0x0637:
            if (r52 == 0) goto L_0x0651
            java.lang.Boolean r15 = r6.tracerouteActiveMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r15 = r15.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x0651
            java.lang.Integer r15 = r6.wifiTracerouteForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r15 = r15.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r15 = r0.p(r15)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 != 0) goto L_0x065d
        L_0x0651:
            if (r1 == 0) goto L_0x065f
            java.lang.Boolean r15 = r6.tracerouteActiveMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r15 = r15.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x065f
        L_0x065d:
            r15 = 1
            goto L_0x0660
        L_0x065f:
            r15 = 0
        L_0x0660:
            int r21 = r7.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x0693
            if (r52 == 0) goto L_0x0683
            java.lang.Boolean r21 = r6.cdnFileMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x0683
            java.lang.Integer r21 = r6.wifiCdnFileDownloadForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r22 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.b((int) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x0691
            goto L_0x0685
        L_0x0683:
            r22 = r4
        L_0x0685:
            if (r1 == 0) goto L_0x0695
            java.lang.Boolean r4 = r6.cdnFileMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0695
        L_0x0691:
            r4 = 1
            goto L_0x0696
        L_0x0693:
            r22 = r4
        L_0x0695:
            r4 = 0
        L_0x0696:
            if (r52 == 0) goto L_0x06b3
            java.lang.Boolean r21 = r6.videoActiveMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x06b3
            java.lang.Integer r21 = r6.wifiVideoForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r23 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.r(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x06c1
            goto L_0x06b5
        L_0x06b3:
            r23 = r4
        L_0x06b5:
            if (r1 == 0) goto L_0x06c3
            java.lang.Boolean r4 = r6.videoActiveMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x06c3
        L_0x06c1:
            r4 = 1
            goto L_0x06c4
        L_0x06c3:
            r4 = 0
        L_0x06c4:
            if (r52 == 0) goto L_0x06e1
            java.lang.Boolean r21 = r6.coverageMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x06e1
            java.lang.Integer r21 = r6.wifiCoverageForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r24 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.d((int) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x06ef
            goto L_0x06e3
        L_0x06e1:
            r24 = r4
        L_0x06e3:
            if (r1 == 0) goto L_0x06f1
            java.lang.Boolean r4 = r6.coverageMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x06f1
        L_0x06ef:
            r4 = 1
            goto L_0x06f2
        L_0x06f1:
            r4 = 0
        L_0x06f2:
            if (r52 == 0) goto L_0x070f
            java.lang.Boolean r21 = r6.foregroundGameMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x070f
            java.lang.Integer r21 = r6.wifiGameForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r25 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.h(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x071d
            goto L_0x0711
        L_0x070f:
            r25 = r4
        L_0x0711:
            if (r1 == 0) goto L_0x071f
            java.lang.Boolean r4 = r6.foregroundGameMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x071f
        L_0x071d:
            r4 = 1
            goto L_0x0720
        L_0x071f:
            r4 = 0
        L_0x0720:
            if (r52 == 0) goto L_0x073d
            java.lang.Boolean r21 = r6.loadedLatencyEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x073d
            java.lang.Integer r21 = r6.foregroundLoadedLatencyPeriodicityWifi()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r26 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.j(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x074b
            goto L_0x073f
        L_0x073d:
            r26 = r4
        L_0x073f:
            if (r1 == 0) goto L_0x074d
            java.lang.Boolean r4 = r6.loadedLatencyEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x074d
        L_0x074b:
            r4 = 1
            goto L_0x074e
        L_0x074d:
            r4 = 0
        L_0x074e:
            int r21 = r8.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x0781
            if (r52 == 0) goto L_0x0771
            java.lang.Boolean r21 = r6.randomCdnFileMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x0771
            java.lang.Integer r21 = r6.wifiRandomCdnFileDownloadForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r27 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.n(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x077f
            goto L_0x0773
        L_0x0771:
            r27 = r4
        L_0x0773:
            if (r1 == 0) goto L_0x0783
            java.lang.Boolean r4 = r6.randomCdnFileMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0783
        L_0x077f:
            r4 = 1
            goto L_0x0784
        L_0x0781:
            r27 = r4
        L_0x0783:
            r4 = 0
        L_0x0784:
            if (r52 == 0) goto L_0x079d
            java.lang.Boolean r21 = r6.timeToInteractionMeasurementsEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x079d
            r21 = r4
            java.lang.Integer r4 = r6.timeToInteractionWiFiPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.f((java.lang.Integer) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x07ab
            goto L_0x079f
        L_0x079d:
            r21 = r4
        L_0x079f:
            if (r1 == 0) goto L_0x07ad
            java.lang.Boolean r4 = r6.timeToInteractionMeasurementsEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x07ad
        L_0x07ab:
            r4 = 1
            goto L_0x07ae
        L_0x07ad:
            r4 = 0
        L_0x07ae:
            if (r52 == 0) goto L_0x07c7
            java.lang.Boolean r28 = r6.trafficProfileMeasurementsEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r28 = r28.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r28 == 0) goto L_0x07c7
            r28 = r4
            java.lang.Integer r4 = r6.trafficProfileWiFiPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.d((java.lang.Integer) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x07d5
            goto L_0x07c9
        L_0x07c7:
            r28 = r4
        L_0x07c9:
            if (r1 == 0) goto L_0x07d7
            java.lang.Boolean r4 = r6.trafficProfileMeasurementsEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x07d7
        L_0x07d5:
            r4 = 1
            goto L_0x07d8
        L_0x07d7:
            r4 = 0
        L_0x07d8:
            r50 = r25
            r25 = r4
            r4 = r22
            r22 = r15
            goto L_0x09e0
        L_0x07e2:
            int r4 = r12.length     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x080d
            if (r52 == 0) goto L_0x07ff
            java.lang.Boolean r4 = r6.isPageLoadMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x07ff
            java.lang.Integer r4 = r6.pageLoadForegroundPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.k(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x080b
        L_0x07ff:
            if (r1 == 0) goto L_0x080d
            java.lang.Boolean r4 = r6.isPageLoadMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x080d
        L_0x080b:
            r4 = 1
            goto L_0x080e
        L_0x080d:
            r4 = 0
        L_0x080e:
            if (r52 == 0) goto L_0x0828
            java.lang.Boolean r9 = r6.fileMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r9 = r9.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x0828
            java.lang.Integer r9 = r6.fileTransferForegroundPeriodicityTimer()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r9 = r9.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r9 = r0.e((int) r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 != 0) goto L_0x0834
        L_0x0828:
            if (r1 == 0) goto L_0x0836
            java.lang.Boolean r9 = r6.fileMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r9 = r9.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x0836
        L_0x0834:
            r9 = 1
            goto L_0x0837
        L_0x0836:
            r9 = 0
        L_0x0837:
            int r15 = r7.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x0865
            if (r52 == 0) goto L_0x0857
            java.lang.Boolean r15 = r6.cdnFileMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r15 = r15.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x0857
            java.lang.Integer r15 = r6.cdnFileDownloadForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r15 = r15.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r15 = r0.a((int) r15)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 != 0) goto L_0x0863
        L_0x0857:
            if (r1 == 0) goto L_0x0865
            java.lang.Boolean r15 = r6.cdnFileMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r15 = r15.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x0865
        L_0x0863:
            r15 = 1
            goto L_0x0866
        L_0x0865:
            r15 = 0
        L_0x0866:
            if (r52 == 0) goto L_0x0883
            java.lang.Boolean r21 = r6.tracerouteActiveMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x0883
            java.lang.Integer r21 = r6.tracerouteForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r22 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.o(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x0891
            goto L_0x0885
        L_0x0883:
            r22 = r4
        L_0x0885:
            if (r1 == 0) goto L_0x0893
            java.lang.Boolean r4 = r6.tracerouteActiveMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0893
        L_0x0891:
            r4 = 1
            goto L_0x0894
        L_0x0893:
            r4 = 0
        L_0x0894:
            if (r52 == 0) goto L_0x08b1
            java.lang.Boolean r21 = r6.videoActiveMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x08b1
            java.lang.Integer r21 = r6.videoForegroundPeriodicityMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r23 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.q(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x08bf
            goto L_0x08b3
        L_0x08b1:
            r23 = r4
        L_0x08b3:
            if (r1 == 0) goto L_0x08c1
            java.lang.Boolean r4 = r6.videoActiveMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x08c1
        L_0x08bf:
            r4 = 1
            goto L_0x08c2
        L_0x08c1:
            r4 = 0
        L_0x08c2:
            if (r52 == 0) goto L_0x08df
            java.lang.Boolean r21 = r6.coverageMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x08df
            java.lang.Integer r21 = r6.coverageForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r24 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.c((int) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x08ed
            goto L_0x08e1
        L_0x08df:
            r24 = r4
        L_0x08e1:
            if (r1 == 0) goto L_0x08ef
            java.lang.Boolean r4 = r6.coverageMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x08ef
        L_0x08ed:
            r4 = 1
            goto L_0x08f0
        L_0x08ef:
            r4 = 0
        L_0x08f0:
            if (r52 == 0) goto L_0x090d
            java.lang.Boolean r21 = r6.foregroundGameMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x090d
            java.lang.Integer r21 = r6.foregroundGamePeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r25 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.g(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x091b
            goto L_0x090f
        L_0x090d:
            r25 = r4
        L_0x090f:
            if (r1 == 0) goto L_0x091d
            java.lang.Boolean r4 = r6.foregroundGameMeasurement()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x091d
        L_0x091b:
            r4 = 1
            goto L_0x091e
        L_0x091d:
            r4 = 0
        L_0x091e:
            if (r52 == 0) goto L_0x093b
            java.lang.Boolean r21 = r6.loadedLatencyEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x093b
            java.lang.Integer r21 = r6.foregroundLoadedLatencyPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r26 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.i(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x0949
            goto L_0x093d
        L_0x093b:
            r26 = r4
        L_0x093d:
            if (r1 == 0) goto L_0x094b
            java.lang.Boolean r4 = r6.loadedLatencyEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x094b
        L_0x0949:
            r4 = 1
            goto L_0x094c
        L_0x094b:
            r4 = 0
        L_0x094c:
            int r21 = r8.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x097f
            if (r52 == 0) goto L_0x096f
            java.lang.Boolean r21 = r6.randomCdnFileMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x096f
            java.lang.Integer r21 = r6.randomCdnFileDownloadForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r27 = r4
            int r4 = r21.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.m(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x097d
            goto L_0x0971
        L_0x096f:
            r27 = r4
        L_0x0971:
            if (r1 == 0) goto L_0x0981
            java.lang.Boolean r4 = r6.randomCdnFileMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0981
        L_0x097d:
            r4 = 1
            goto L_0x0982
        L_0x097f:
            r27 = r4
        L_0x0981:
            r4 = 0
        L_0x0982:
            if (r52 == 0) goto L_0x099b
            java.lang.Boolean r21 = r6.timeToInteractionMeasurementsEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r21 = r21.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r21 == 0) goto L_0x099b
            r21 = r4
            java.lang.Integer r4 = r6.timeToInteractionForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.e((java.lang.Integer) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x09a9
            goto L_0x099d
        L_0x099b:
            r21 = r4
        L_0x099d:
            if (r1 == 0) goto L_0x09ab
            java.lang.Boolean r4 = r6.timeToInteractionMeasurementsEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x09ab
        L_0x09a9:
            r4 = 1
            goto L_0x09ac
        L_0x09ab:
            r4 = 0
        L_0x09ac:
            if (r52 == 0) goto L_0x09c5
            java.lang.Boolean r28 = r6.trafficProfileMeasurementsEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r28 = r28.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r28 == 0) goto L_0x09c5
            r28 = r4
            java.lang.Integer r4 = r6.trafficProfileForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.c((java.lang.Integer) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x09d3
            goto L_0x09c7
        L_0x09c5:
            r28 = r4
        L_0x09c7:
            if (r1 == 0) goto L_0x09d5
            java.lang.Boolean r4 = r6.trafficProfileMeasurementsEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x09d5
        L_0x09d3:
            r4 = 1
            goto L_0x09d6
        L_0x09d5:
            r4 = 0
        L_0x09d6:
            r50 = r25
            r25 = r4
            r4 = r22
            r22 = r23
            r23 = r15
        L_0x09e0:
            r15 = r50
            if (r52 == 0) goto L_0x09fb
            java.lang.Boolean r29 = r6.deviceInfoActiveMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r29 = r29.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r29 == 0) goto L_0x09fb
            r29 = r4
            java.lang.Integer r4 = r6.deviceInfoForegroundPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.b((java.lang.Integer) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 != 0) goto L_0x0a09
            goto L_0x09fd
        L_0x09fb:
            r29 = r4
        L_0x09fd:
            if (r1 == 0) goto L_0x0a18
            java.lang.Boolean r4 = r6.deviceInfoActiveMeasurements()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0a18
        L_0x0a09:
            r4 = r29
            r29 = r28
            r28 = r21
            r21 = r25
            r25 = r22
            r22 = r27
            r27 = 1
            goto L_0x0a26
        L_0x0a18:
            r4 = r29
            r29 = r28
            r28 = r21
            r21 = r25
            r25 = r22
            r22 = r27
            r27 = 0
        L_0x0a26:
            if (r4 != 0) goto L_0x0a3f
            if (r9 != 0) goto L_0x0a3f
            if (r23 != 0) goto L_0x0a3f
            if (r24 != 0) goto L_0x0a3f
            if (r26 != 0) goto L_0x0a3f
            if (r15 != 0) goto L_0x0a3f
            if (r27 != 0) goto L_0x0a3f
            if (r22 != 0) goto L_0x0a3f
            if (r28 != 0) goto L_0x0a3f
            if (r29 != 0) goto L_0x0a3f
            if (r21 != 0) goto L_0x0a3f
            java.lang.String r30 = "All measurements skipped"
            goto L_0x0a41
        L_0x0a3f:
            java.lang.String r30 = "Measurements started"
        L_0x0a41:
            r31 = r15
            r15 = r30
            android.util.Log.d(r11, r15)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0b2b
            int r4 = r12.length     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r15 = 0
            r30 = 0
        L_0x0a4e:
            if (r15 >= r4) goto L_0x0b06
            r32 = r4
            r4 = r12[r15]     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r33 = r12
            boolean r12 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r12 == 0) goto L_0x0a68
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x0a68:
            android.content.Context r12 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r12 = com.cellrebel.sdk.utils.Utils.f(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r12 == 0) goto L_0x0a7e
            android.util.Log.d(r11, r10)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x0a7e:
            if (r52 == 0) goto L_0x0aa5
            boolean r12 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r12 == 0) goto L_0x0aa5
            if (r13 == 0) goto L_0x0a96
            com.cellrebel.sdk.utils.Storage r12 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r34 = r7
            r35 = r8
            long r7 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r12.w(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x0aa9
        L_0x0a96:
            r34 = r7
            r35 = r8
            com.cellrebel.sdk.utils.Storage r7 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r8 = r13
            long r12 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7.v(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x0aaa
        L_0x0aa5:
            r34 = r7
            r35 = r8
        L_0x0aa9:
            r8 = r13
        L_0x0aaa:
            if (r52 != 0) goto L_0x0ab6
            java.lang.Boolean r7 = r6.backgroundLocationEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r7 = r7.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r7 == 0) goto L_0x0ac0
        L_0x0ab6:
            com.cellrebel.sdk.workers.LocationWorker r7 = new com.cellrebel.sdk.workers.LocationWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r12 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7.a((android.content.Context) r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x0ac0:
            com.cellrebel.sdk.workers.CollectPageLoadMetricsWorker r7 = new com.cellrebel.sdk.workers.CollectPageLoadMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r0.e = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r12 = r0.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7.n = r12     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7.o = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r4 = r6.pageLoadTimeoutTimer()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r12 = (long) r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7.p = r12     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.CollectPageLoadMetricsWorker r4 = r0.e     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.BaseMetricsWorker.h = r52     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.d = r2     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.e = r3     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7 = r56
            r12 = 0
            r4.f = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r12 = r57
            r4.g = r12     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r13 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.a((android.content.Context) r13)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.CollectPageLoadMetricsWorker r4 = r0.e     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0af9
            r30 = 1
        L_0x0af9:
            int r15 = r15 + 1
            r13 = r8
            r4 = r32
            r12 = r33
            r7 = r34
            r8 = r35
            goto L_0x0a4e
        L_0x0b06:
            r12 = r57
            r34 = r7
            r35 = r8
            r8 = r13
            r7 = r56
            com.cellrebel.sdk.workers.SendPageLoadMetricsWorker r4 = new com.cellrebel.sdk.workers.SendPageLoadMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r13 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.a((android.content.Context) r13)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0b36
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x0b2b:
            r12 = r57
            r34 = r7
            r35 = r8
            r8 = r13
            r7 = r56
            r30 = 0
        L_0x0b36:
            java.lang.String r15 = ";"
            java.lang.String r4 = "filePeriodicity"
            if (r9 == 0) goto L_0x0dcc
            boolean r9 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x0b4e
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x0b4e:
            android.content.Context r9 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r9 = com.cellrebel.sdk.utils.Utils.f(r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x0b64
            android.util.Log.d(r11, r10)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x0b64:
            if (r52 == 0) goto L_0x0b86
            boolean r9 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x0b86
            if (r8 == 0) goto L_0x0b7a
            com.cellrebel.sdk.utils.Storage r9 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r33 = r14
            long r13 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.p(r13)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x0b88
        L_0x0b7a:
            r33 = r14
            com.cellrebel.sdk.utils.Storage r9 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r13 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.o(r13)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x0b88
        L_0x0b86:
            r33 = r14
        L_0x0b88:
            if (r52 != 0) goto L_0x0b94
            java.lang.Boolean r9 = r6.backgroundLocationEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r9 = r9.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x0b9e
        L_0x0b94:
            com.cellrebel.sdk.workers.LocationWorker r9 = new com.cellrebel.sdk.workers.LocationWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r13 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.a((android.content.Context) r13)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x0b9e:
            java.lang.String r9 = r6.fileName     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r13.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r14 = r6.accessTechnologyFileNames     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r14 == 0) goto L_0x0d42
            boolean r14 = r14.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r14 != 0) goto L_0x0d42
            java.lang.String r14 = r6.accessTechnologyFileNames     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String[] r14 = r14.split(r15)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r37 = r9
            com.cellrebel.sdk.utils.TrackingHelper r9 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r38 = r8
            android.content.Context r8 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.database.ConnectionType r8 = r9.a((android.content.Context) r8)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r9 = r14.length     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r40 = r5
            r39 = r15
            r15 = 0
        L_0x0bc9:
            java.lang.String r5 = "fileName"
            if (r15 >= r9) goto L_0x0c3a
            r41 = r9
            r9 = r14[r15]     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r42 = r9.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r42 == 0) goto L_0x0bdc
            r42 = r14
        L_0x0bd9:
            r32 = 2
            goto L_0x0c2f
        L_0x0bdc:
            r42 = r14
            r14 = r33
            java.lang.String[] r9 = r9.split(r14)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r33 = r14
            int r14 = r9.length     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r12 = 3
            if (r14 == r12) goto L_0x0beb
            goto L_0x0bd9
        L_0x0beb:
            r12 = 0
            r14 = r9[r12]     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r12 = 1
            r43 = r9[r12]     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r12 = java.lang.Integer.parseInt(r43)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r32 = 2
            r9 = r9[r32]     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r14 == 0) goto L_0x0c2f
            boolean r43 = r14.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r43 != 0) goto L_0x0c2f
            if (r9 == 0) goto L_0x0c2f
            boolean r43 = r9.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r43 != 0) goto L_0x0c2f
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7.putInt(r4, r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7.putString(r5, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r5 = r14.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Object r5 = r13.get(r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r5 != 0) goto L_0x0c25
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x0c25:
            r5.add(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r14.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r13.put(r7, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x0c2f:
            int r15 = r15 + 1
            r7 = r56
            r12 = r57
            r9 = r41
            r14 = r42
            goto L_0x0bc9
        L_0x0c3a:
            r32 = 2
            java.lang.String r7 = r8.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r7.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Object r7 = r13.get(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r7 == 0) goto L_0x0d4c
            boolean r9 = r7.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 != 0) goto L_0x0d4c
            com.cellrebel.sdk.utils.PreferencesManager r9 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.Map r9 = r9.j()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x0d14
            boolean r12 = r9.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r12 != 0) goto L_0x0d14
            java.lang.String r12 = r8.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r12 = r12.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Object r12 = r9.get(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r12 == 0) goto L_0x0d14
            java.lang.String r12 = r8.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r12 = r12.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Object r12 = r9.get(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r12 == 0) goto L_0x0cf8
            java.util.Iterator r13 = r7.iterator()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r14 = 0
        L_0x0c85:
            boolean r15 = r13.hasNext()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x0ccb
            java.lang.Object r15 = r13.next()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.os.Bundle r15 = (android.os.Bundle) r15     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r41 = r15.getInt(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r14 = r14 + r41
            int r41 = r12.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r42 = r13
            r16 = 1
            int r13 = r41 + 1
            if (r13 > r14) goto L_0x0cc8
            java.lang.String r13 = r15.getString(r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r15 = r8.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r15 = r15.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r37 = r12.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r16 = 1
            int r37 = r37 + 1
            r41 = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r37)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.put(r15, r13)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.utils.PreferencesManager r13 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r13.b((java.util.Map<java.lang.String, java.lang.Integer>) r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x0ccd
        L_0x0cc8:
            r13 = r42
            goto L_0x0c85
        L_0x0ccb:
            r41 = r37
        L_0x0ccd:
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r13 = 1
            int r12 = r12 + r13
            if (r14 >= r12) goto L_0x0cf5
            r12 = 0
            java.lang.Object r7 = r7.get(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r5 = r7.getString(r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r8.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r7.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r8 = 1
            java.lang.Integer r12 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.put(r7, r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x0cf0:
            com.cellrebel.sdk.utils.PreferencesManager r7 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x0d3d
        L_0x0cf5:
            r9 = r41
            goto L_0x0d4e
        L_0x0cf8:
            r12 = 0
            java.lang.Object r7 = r7.get(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r5 = r7.getString(r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r8.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r7.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r8 = 1
            java.lang.Integer r12 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.put(r7, r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x0cf0
        L_0x0d14:
            r12 = 0
            java.lang.Object r7 = r7.get(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r5 = r7.getString(r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x0d27
            boolean r7 = r9.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r7 == 0) goto L_0x0d2c
        L_0x0d27:
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x0d2c:
            java.lang.String r7 = r8.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r7.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r8 = 1
            java.lang.Integer r12 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.put(r7, r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x0cf0
        L_0x0d3d:
            r7.b((java.util.Map<java.lang.String, java.lang.Integer>) r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9 = r5
            goto L_0x0d4e
        L_0x0d42:
            r40 = r5
            r38 = r8
            r37 = r9
            r39 = r15
            r32 = 2
        L_0x0d4c:
            r9 = r37
        L_0x0d4e:
            android.content.Context r5 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r5 = com.cellrebel.sdk.utils.Utils.f(r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r5 == 0) goto L_0x0d64
            android.util.Log.d(r11, r10)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x0d64:
            com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker r5 = new com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r0.h = r5     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r0.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5.k = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5.m = r9     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r6.serverIdFileLoad     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5.n = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r6.fileServerUrls     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5.o = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7 = r20
            r5.p = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.BaseMetricsWorker.h = r52     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5.d = r2     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5.e = r3     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7 = r56
            r5.f = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r8 = r57
            r5.g = r8     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r9 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5.a((android.content.Context) r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r5 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r5 == 0) goto L_0x0da6
            r5 = r40
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x0da6:
            r5 = r40
            com.cellrebel.sdk.workers.CollectFileTransferMetricsWorker r9 = r0.h     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r9 = r9.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x0db0
            r30 = 1
        L_0x0db0:
            com.cellrebel.sdk.workers.SendFileTransferMetricsWorker r9 = new com.cellrebel.sdk.workers.SendFileTransferMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r12 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.a((android.content.Context) r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r9 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x0dd5
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x0dcc:
            r38 = r8
            r8 = r12
            r33 = r14
            r39 = r15
            r32 = 2
        L_0x0dd5:
            if (r23 != 0) goto L_0x0de0
            if (r28 == 0) goto L_0x0dda
            goto L_0x0de0
        L_0x0dda:
            r9 = r8
            r8 = r7
            r7 = r3
            r3 = r2
            goto L_0x10bf
        L_0x0de0:
            android.content.Context r9 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r9 = com.cellrebel.sdk.utils.Utils.f(r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x0df6
            android.util.Log.d(r11, r10)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x0df6:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r23 == 0) goto L_0x0fa5
            r12 = r34
            r9.addAll(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r12 = r6.accessTechnologyCdnFileUrls     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r13.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r12 == 0) goto L_0x0fa5
            boolean r14 = r12.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r14 != 0) goto L_0x0fa5
            r14 = r39
            java.lang.String[] r12 = r12.split(r14)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.utils.TrackingHelper r14 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r15 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.database.ConnectionType r14 = r14.a((android.content.Context) r15)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r15 = r12.length     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r8 = 0
        L_0x0e23:
            java.lang.String r7 = "fileUrl"
            if (r8 >= r15) goto L_0x0e9e
            r20 = r15
            r15 = r12[r8]     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r34 = r15.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r34 == 0) goto L_0x0e34
            r34 = r12
            goto L_0x0e93
        L_0x0e34:
            r34 = r12
            r12 = r33
            java.lang.String[] r15 = r15.split(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r33 = r12
            int r12 = r15.length     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3 = 3
            if (r12 >= r3) goto L_0x0e43
            goto L_0x0e93
        L_0x0e43:
            r12 = 0
            r36 = r15[r12]     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r12 = 1
            r37 = r15[r12]     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r12 = java.lang.Integer.parseInt(r37)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3 = 2
        L_0x0e4e:
            int r2 = r15.length     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 >= r2) goto L_0x0e93
            r2 = r15[r3]     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r36 == 0) goto L_0x0e8c
            boolean r39 = r36.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r39 != 0) goto L_0x0e8c
            if (r2 == 0) goto L_0x0e8c
            boolean r39 = r2.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r39 != 0) goto L_0x0e8c
            r39 = r15
            android.os.Bundle r15 = new android.os.Bundle     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r15.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r15.putInt(r4, r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r15.putString(r7, r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r2 = r36.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Object r2 = r13.get(r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 != 0) goto L_0x0e81
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x0e81:
            r2.add(r15)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r15 = r36.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r13.put(r15, r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x0e8e
        L_0x0e8c:
            r39 = r15
        L_0x0e8e:
            int r3 = r3 + 1
            r15 = r39
            goto L_0x0e4e
        L_0x0e93:
            int r8 = r8 + 1
            r2 = r54
            r3 = r55
            r15 = r20
            r12 = r34
            goto L_0x0e23
        L_0x0e9e:
            java.lang.String r2 = r14.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Object r2 = r13.get(r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x0fa5
            boolean r3 = r2.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 != 0) goto L_0x0fa5
            com.cellrebel.sdk.utils.PreferencesManager r3 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.Map r3 = r3.c()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x0f76
            boolean r8 = r3.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r8 != 0) goto L_0x0f76
            java.lang.String r8 = r14.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r8 = r8.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Object r8 = r3.get(r8)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r8 == 0) goto L_0x0f76
            java.lang.String r8 = r14.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r8 = r8.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Object r8 = r3.get(r8)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r8 == 0) goto L_0x0f57
            java.util.Iterator r12 = r2.iterator()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r13 = 0
        L_0x0ee7:
            boolean r15 = r12.hasNext()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x0f2c
            java.lang.Object r15 = r12.next()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.os.Bundle r15 = (android.os.Bundle) r15     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r20 = r15.getInt(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r13 = r13 + r20
            int r20 = r8.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r32 = r4
            r16 = 1
            int r4 = r20 + 1
            if (r4 > r13) goto L_0x0f29
            java.lang.String r4 = r15.getString(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.add(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r4 = r14.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r12 = r8.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r15 = 1
            int r12 = r12 + r15
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.put(r4, r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.utils.PreferencesManager r4 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.a((java.util.Map<java.lang.String, java.lang.Integer>) r3)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x0f2c
        L_0x0f29:
            r4 = r32
            goto L_0x0ee7
        L_0x0f2c:
            int r4 = r8.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r8 = 1
            int r4 = r4 + r8
            if (r13 >= r4) goto L_0x0fa5
            r4 = 0
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r2 = r2.getString(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.add(r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r2 = r14.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4 = 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.put(r2, r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x0f52:
            com.cellrebel.sdk.utils.PreferencesManager r2 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x0fa2
        L_0x0f57:
            r4 = 0
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r2 = r2.getString(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.add(r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r2 = r14.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4 = 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.put(r2, r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x0f52
        L_0x0f76:
            r4 = 0
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r2 = r2.getString(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.add(r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x0f8c
            boolean r2 = r3.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x0f91
        L_0x0f8c:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x0f91:
            java.lang.String r2 = r14.name()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4 = 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.put(r2, r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x0f52
        L_0x0fa2:
            r2.a((java.util.Map<java.lang.String, java.lang.Integer>) r3)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x0fa5:
            if (r28 == 0) goto L_0x0fd8
            java.lang.Integer r2 = r6.randomCdnServerCount()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 <= 0) goto L_0x0fd8
            java.lang.Integer r2 = r6.randomCdnServerCount()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.Random r3 = new java.util.Random     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x0fbe:
            if (r2 <= 0) goto L_0x0fd8
            int r4 = r35.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r4 = r3.nextInt(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7 = r35
            java.lang.Object r4 = r7.remove(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.add(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r2 = r2 + -1
            r35 = r7
            goto L_0x0fbe
        L_0x0fd8:
            java.util.Iterator r2 = r9.iterator()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x0fdc:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x109b
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0ffa
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x0ffa:
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = com.cellrebel.sdk.utils.Utils.f(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x1010
            android.util.Log.d(r11, r10)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1010:
            if (r52 == 0) goto L_0x1047
            boolean r4 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x1047
            if (r38 == 0) goto L_0x1031
            if (r23 == 0) goto L_0x1025
            com.cellrebel.sdk.utils.Storage r4 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r7 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.i(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1025:
            if (r28 == 0) goto L_0x1047
            com.cellrebel.sdk.utils.Storage r4 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r7 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.y(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x1047
        L_0x1031:
            if (r23 == 0) goto L_0x103c
            com.cellrebel.sdk.utils.Storage r4 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r7 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.h(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x103c:
            if (r28 == 0) goto L_0x1047
            com.cellrebel.sdk.utils.Storage r4 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r7 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.x(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1047:
            if (r52 != 0) goto L_0x1053
            java.lang.Boolean r4 = r6.backgroundLocationEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x105d
        L_0x1053:
            com.cellrebel.sdk.workers.LocationWorker r4 = new com.cellrebel.sdk.workers.LocationWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r7 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.a((android.content.Context) r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x105d:
            com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker r4 = new com.cellrebel.sdk.workers.CollectCdnDownloadMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r0.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.k = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.m = r3     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.BaseMetricsWorker.h = r52     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3 = r54
            r4.d = r3     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7 = r55
            r4.e = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r8 = r56
            r4.f = r8     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9 = r57
            r4.g = r9     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r12 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.a((android.content.Context) r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r12 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r12 == 0) goto L_0x1093
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1093:
            boolean r4 = r4.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x0fdc
            r30 = 1
            goto L_0x0fdc
        L_0x109b:
            r3 = r54
            r7 = r55
            r8 = r56
            r9 = r57
            com.cellrebel.sdk.workers.SendFileTransferMetricsWorker r2 = new com.cellrebel.sdk.workers.SendFileTransferMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x10bf
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x10bf:
            if (r24 == 0) goto L_0x119a
            android.content.Context r2 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = com.cellrebel.sdk.utils.Utils.f(r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x10d7
            android.util.Log.d(r11, r10)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x10d7:
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x10e9
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x10e9:
            if (r52 == 0) goto L_0x1106
            boolean r2 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x1106
            if (r38 == 0) goto L_0x10fd
            com.cellrebel.sdk.utils.Storage r2 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r12 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.G(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x1106
        L_0x10fd:
            com.cellrebel.sdk.utils.Storage r2 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r12 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.F(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1106:
            if (r52 != 0) goto L_0x1112
            java.lang.Boolean r2 = r6.backgroundLocationEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x111c
        L_0x1112:
            com.cellrebel.sdk.workers.LocationWorker r2 = new com.cellrebel.sdk.workers.LocationWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x111c:
            com.cellrebel.sdk.workers.CollectVideoMetricsWorker r2 = new com.cellrebel.sdk.workers.CollectVideoMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r0.i = r2     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r4 = r0.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.l = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.CollectVideoMetricsWorker r2 = r0.i     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r4 = r6.videoUrl()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.n = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.CollectVideoMetricsWorker r2 = r0.i     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r4 = r6.videoProvider()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.o = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.CollectVideoMetricsWorker r2 = r0.i     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r4 = r6.videoTimeoutFactor()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.q = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.CollectVideoMetricsWorker r2 = r0.i     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r4 = r6.videoTimeoutTimer()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.p = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.BaseMetricsWorker.h = r52     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.CollectVideoMetricsWorker r2 = r0.i     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.d = r3     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.e = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.f = r8     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.g = r9     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.CollectVideoMetricsWorker r2 = r0.i     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x1176
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1176:
            com.cellrebel.sdk.workers.CollectVideoMetricsWorker r2 = r0.i     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r2.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x117e
            r30 = 1
        L_0x117e:
            com.cellrebel.sdk.workers.SendVideoMetricsWorker r2 = new com.cellrebel.sdk.workers.SendVideoMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x119a
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x119a:
            if (r29 == 0) goto L_0x126b
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x11ae
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x11ae:
            android.content.Context r2 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = com.cellrebel.sdk.utils.Utils.f(r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x11c4
            android.util.Log.d(r11, r10)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x11c4:
            if (r52 == 0) goto L_0x11e1
            boolean r2 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x11e1
            if (r38 == 0) goto L_0x11d8
            com.cellrebel.sdk.utils.Storage r2 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r12 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.E(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x11e1
        L_0x11d8:
            com.cellrebel.sdk.utils.Storage r2 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r12 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.D(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x11e1:
            if (r52 != 0) goto L_0x11ed
            java.lang.Boolean r2 = r6.backgroundLocationEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x11f7
        L_0x11ed:
            com.cellrebel.sdk.workers.LocationWorker r2 = new com.cellrebel.sdk.workers.LocationWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x11f7:
            com.cellrebel.sdk.workers.CollectTtiMetricsWorker r2 = new com.cellrebel.sdk.workers.CollectTtiMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r4 = r6.timeToInteractionTimeout()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r40 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r4 = r6.timeToInteractionDownloadFileSize()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r41 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r4 = r6.timeToInteractionUploadFileSize()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r42 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r4 = r6.timeToInteractionServerListLimit()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r43 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r4 = r6.timeToInteractionServerSelectionTimeout()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r44 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r4 = r6.timeToInteractionPingTimeout()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r45 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r4 = r6.timeToInteractionPingsPerServer()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r46 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r4 = r6.timeToInteractionUploadStatsInterval()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r47 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r4 = r6.timeToInteractionUploadStatsTimeout()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r48 = r4.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r39 = r2
            r39.<init>(r40, r41, r42, r43, r44, r45, r46, r47, r48)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r4 = r0.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.j = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.SendTtiMetricsWorker r2 = new com.cellrebel.sdk.workers.SendTtiMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x126b
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x126b:
            if (r21 == 0) goto L_0x131e
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x127f
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x127f:
            android.content.Context r2 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = com.cellrebel.sdk.utils.Utils.f(r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x1295
            android.util.Log.d(r11, r10)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1295:
            if (r52 == 0) goto L_0x12b2
            boolean r2 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x12b2
            if (r38 == 0) goto L_0x12a9
            com.cellrebel.sdk.utils.Storage r2 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r12 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.C(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x12b2
        L_0x12a9:
            com.cellrebel.sdk.utils.Storage r2 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r12 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.B(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x12b2:
            if (r52 != 0) goto L_0x12be
            java.lang.Boolean r2 = r6.backgroundLocationEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x12c8
        L_0x12be:
            com.cellrebel.sdk.workers.LocationWorker r2 = new com.cellrebel.sdk.workers.LocationWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x12c8:
            com.cellrebel.sdk.workers.CollectTrafficProfileWorker r2 = new com.cellrebel.sdk.workers.CollectTrafficProfileWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r0.j = r2     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r4 = r0.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.j = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.BaseMetricsWorker.h = r52     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.CollectTrafficProfileWorker r2 = r0.j     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.d = r3     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.e = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.f = r8     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.g = r9     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.CollectTrafficProfileWorker r2 = r0.j     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x12fa
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x12fa:
            com.cellrebel.sdk.workers.CollectTrafficProfileWorker r2 = r0.j     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r2.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x1302
            r30 = 1
        L_0x1302:
            com.cellrebel.sdk.workers.SendTrafficProfileWorker r2 = new com.cellrebel.sdk.workers.SendTrafficProfileWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x131e
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x131e:
            if (r25 == 0) goto L_0x13d4
            if (r18 == 0) goto L_0x13d4
            r13 = r18
            int r2 = r13.length     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4 = 0
        L_0x1326:
            if (r4 >= r2) goto L_0x13ba
            r12 = r13[r4]     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r14 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r14 == 0) goto L_0x1339
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1339:
            if (r52 == 0) goto L_0x135b
            boolean r14 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r14 == 0) goto L_0x135b
            if (r38 == 0) goto L_0x134e
            com.cellrebel.sdk.utils.Storage r14 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r15 = r10
            long r9 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r14.A(r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x135c
        L_0x134e:
            r15 = r10
            com.cellrebel.sdk.utils.Storage r9 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r18 = r13
            long r13 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.z(r13)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x135e
        L_0x135b:
            r15 = r10
        L_0x135c:
            r18 = r13
        L_0x135e:
            if (r52 != 0) goto L_0x136a
            java.lang.Boolean r9 = r6.backgroundLocationEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r9 = r9.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x1374
        L_0x136a:
            com.cellrebel.sdk.workers.LocationWorker r9 = new com.cellrebel.sdk.workers.LocationWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r10 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.a((android.content.Context) r10)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1374:
            com.cellrebel.sdk.workers.CollectTraceRouteWorker r9 = new com.cellrebel.sdk.workers.CollectTraceRouteWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r10 = r6.tracerouteNumberOfHops()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r10 = r10.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r13 = r6.traceroutePacketSize()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r13 = r13.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.<init>(r12, r10, r13)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r10 = r0.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.t = r10     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.BaseMetricsWorker.h = r52     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.d = r3     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.e = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.f = r8     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r10 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r9.a((android.content.Context) r10)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r10 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r10 == 0) goto L_0x13ab
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x13ab:
            boolean r9 = r9.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x13b1
            r30 = 1
        L_0x13b1:
            int r4 = r4 + 1
            r9 = r57
            r10 = r15
            r13 = r18
            goto L_0x1326
        L_0x13ba:
            r15 = r10
            com.cellrebel.sdk.workers.SentTraceRouteWorker r2 = new com.cellrebel.sdk.workers.SentTraceRouteWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x13d5
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x13d4:
            r15 = r10
        L_0x13d5:
            if (r27 == 0) goto L_0x1453
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x13e6
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x13e6:
            if (r52 == 0) goto L_0x13f7
            boolean r2 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x13f7
            com.cellrebel.sdk.utils.Storage r2 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r9 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.n(r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x13f7:
            if (r52 != 0) goto L_0x1403
            java.lang.Boolean r2 = r6.backgroundLocationEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x140d
        L_0x1403:
            com.cellrebel.sdk.workers.LocationWorker r2 = new com.cellrebel.sdk.workers.LocationWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x140d:
            com.cellrebel.sdk.workers.CollectDeviceInfoWorker r2 = new com.cellrebel.sdk.workers.CollectDeviceInfoWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.BaseMetricsWorker.h = r52     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r4 = r0.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.k = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.d = r3     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.e = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.f = r8     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x1434
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1434:
            boolean r2 = r2.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x143a
            r30 = 1
        L_0x143a:
            com.cellrebel.sdk.workers.SentDeviceInfoWorker r2 = new com.cellrebel.sdk.workers.SentDeviceInfoWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x1453
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1453:
            if (r26 == 0) goto L_0x16b4
            android.content.Context r9 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r9 = com.cellrebel.sdk.utils.Utils.f(r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r9 == 0) goto L_0x146c
            r9 = r15
            android.util.Log.d(r11, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x146c:
            r9 = r15
            com.cellrebel.sdk.database.SDKRoomDatabase r10 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.database.dao.GameListDAO r10 = r10.l()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.List r12 = r10.getAll()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r13 = r12.isEmpty()     // Catch:{ IOException -> 0x14b0 }
            if (r13 != 0) goto L_0x1481
            if (r52 == 0) goto L_0x14b0
        L_0x1481:
            com.cellrebel.sdk.networking.ApiService r13 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{ IOException -> 0x14b0 }
            java.lang.String r14 = com.cellrebel.sdk.networking.UrlProvider.b(r6)     // Catch:{ IOException -> 0x14b0 }
            retrofit2.Call r13 = r13.c(r14)     // Catch:{ IOException -> 0x14b0 }
            retrofit2.Response r13 = r13.execute()     // Catch:{ IOException -> 0x14b0 }
            boolean r14 = r13.isSuccessful()     // Catch:{ IOException -> 0x14b0 }
            if (r14 == 0) goto L_0x14b0
            java.lang.Object r14 = r13.body()     // Catch:{ IOException -> 0x14b0 }
            if (r14 == 0) goto L_0x14b0
            r10.a()     // Catch:{ IOException -> 0x14b0 }
            java.lang.Object r14 = r13.body()     // Catch:{ IOException -> 0x14b0 }
            java.util.List r14 = (java.util.List) r14     // Catch:{ IOException -> 0x14b0 }
            r10.a(r14)     // Catch:{ IOException -> 0x14b0 }
            java.lang.Object r10 = r13.body()     // Catch:{ IOException -> 0x14b0 }
            java.util.List r10 = (java.util.List) r10     // Catch:{ IOException -> 0x14b0 }
            r12 = r10
        L_0x14b0:
            int r10 = r12.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r10 <= 0) goto L_0x16b0
            java.lang.Integer r10 = r6.gameCacheRefresh()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r10 = r10.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.utils.PreferencesManager r13 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r13 = r13.h()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r14 = (int) r13     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r13 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r13 == 0) goto L_0x14d9
            android.util.Log.d(r11, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x14d9:
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r13.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.database.SDKRoomDatabase r15 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.database.dao.GameMetricDAO r15 = r15.j()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r15.b()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.Iterator r18 = r12.iterator()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x14ed:
            boolean r20 = r18.hasNext()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r20 == 0) goto L_0x154d
            java.lang.Object r20 = r18.next()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2 = r20
            com.cellrebel.sdk.networking.beans.response.Game r2 = (com.cellrebel.sdk.networking.beans.response.Game) r2     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.List r20 = r2.getServers()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.Iterator r20 = r20.iterator()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1503:
            boolean r23 = r20.hasNext()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r23 == 0) goto L_0x1548
            java.lang.Object r23 = r20.next()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4 = r23
            com.cellrebel.sdk.networking.beans.response.Server r4 = (com.cellrebel.sdk.networking.beans.response.Server) r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r23 = r5
            com.cellrebel.sdk.networking.beans.request.GameInfoMetric r5 = new com.cellrebel.sdk.networking.beans.request.GameInfoMetric     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r8 = r2.name     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r25 = r2
            java.lang.String r2 = r4.url     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r4.name     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r24 = 0
            java.lang.Float r43 = java.lang.Float.valueOf(r24)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Float r44 = java.lang.Float.valueOf(r24)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Float r45 = java.lang.Float.valueOf(r24)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r4 = r4.loadedLatencyTestFileTransferUrl     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r47 = 0
            r39 = r5
            r40 = r8
            r41 = r2
            r42 = r7
            r46 = r4
            r39.<init>(r40, r41, r42, r43, r44, r45, r46, r47)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r13.add(r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7 = r55
            r8 = r56
            r5 = r23
            r2 = r25
            goto L_0x1503
        L_0x1548:
            r7 = r55
            r8 = r56
            goto L_0x14ed
        L_0x154d:
            r23 = r5
            if (r10 <= r14) goto L_0x1604
            r2 = 1
            int r4 = r14 + 1
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.Iterator r5 = r12.iterator()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x155d:
            boolean r7 = r5.hasNext()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r7 == 0) goto L_0x15f9
            java.lang.Object r7 = r5.next()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.networking.beans.response.Game r7 = (com.cellrebel.sdk.networking.beans.response.Game) r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r8 = r7.name     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Integer r10 = r6.gameServersCache()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r12 = 0
            java.util.List r8 = r15.a((java.lang.String) r8, (java.lang.Integer) r10, (boolean) r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r10 = r7.name     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r18 = r4
            r14 = 999(0x3e7, float:1.4E-42)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.List r4 = r15.a((java.lang.String) r10, (java.lang.Integer) r4, (boolean) r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r4 = r4.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.List r10 = r7.getServers()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r10 = r10.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 >= r10) goto L_0x15ec
            java.util.List r4 = r7.getServers()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1598:
            boolean r10 = r4.hasNext()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r10 == 0) goto L_0x15ec
            java.lang.Object r10 = r4.next()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.networking.beans.response.Server r10 = (com.cellrebel.sdk.networking.beans.response.Server) r10     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.networking.beans.request.GameInfoMetric r12 = new com.cellrebel.sdk.networking.beans.request.GameInfoMetric     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r14 = r7.name     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r20 = r4
            java.lang.String r4 = r10.url     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r25 = r5
            java.lang.String r5 = r10.name     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r24 = 0
            java.lang.Float r43 = java.lang.Float.valueOf(r24)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Float r44 = java.lang.Float.valueOf(r24)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Float r45 = java.lang.Float.valueOf(r24)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r3 = r10.loadedLatencyTestFileTransferUrl     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r47 = 0
            r39 = r12
            r40 = r14
            r41 = r4
            r42 = r5
            r46 = r3
            r39.<init>(r40, r41, r42, r43, r44, r45, r46, r47)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r3 = r7.name     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r4 = r10.url     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5 = 0
            java.util.List r3 = r15.b(r3, r4, r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x15e5
            r2.add(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r3 = r12.serverUrl     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r3 = r12.gameName     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x15e5:
            r3 = r54
            r4 = r20
            r5 = r25
            goto L_0x1598
        L_0x15ec:
            r25 = r5
            r2.addAll(r8)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3 = r54
            r4 = r18
            r5 = r25
            goto L_0x155d
        L_0x15f9:
            r18 = r4
            r13.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3 = r18
            goto L_0x1609
        L_0x1604:
            java.util.List r2 = r0.a((com.cellrebel.sdk.database.dao.GameMetricDAO) r15)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3 = 1
        L_0x1609:
            if (r52 == 0) goto L_0x162f
            boolean r4 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x162f
            if (r38 == 0) goto L_0x161d
            com.cellrebel.sdk.utils.Storage r4 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r7 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.r(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x1626
        L_0x161d:
            com.cellrebel.sdk.utils.Storage r4 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r7 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.q(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1626:
            com.cellrebel.sdk.utils.Storage r4 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r7 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.u(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x162f:
            if (r52 != 0) goto L_0x163b
            java.lang.Boolean r4 = r6.backgroundLocationEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x1645
        L_0x163b:
            com.cellrebel.sdk.workers.LocationWorker r4 = new com.cellrebel.sdk.workers.LocationWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r5 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.a((android.content.Context) r5)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1645:
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r4 = com.cellrebel.sdk.utils.Utils.f(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r4 == 0) goto L_0x165b
            android.util.Log.d(r11, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x165b:
            com.cellrebel.sdk.workers.CollectGameWorker r4 = new com.cellrebel.sdk.workers.CollectGameWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r0.f = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r5 = r0.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.m = r5     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.BaseMetricsWorker.h = r52     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5 = r54
            r4.d = r5     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7 = r55
            r4.e = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r8 = r56
            r4.f = r8     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r10 = r57
            r4.g = r10     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r12 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.a((android.content.Context) r12, (java.util.List<com.cellrebel.sdk.networking.beans.request.GameInfoMetric>) r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.CollectGameWorker r2 = r0.f     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r2.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x1687
            r30 = 1
        L_0x1687:
            com.cellrebel.sdk.workers.SendGameMetricsWorker r2 = new com.cellrebel.sdk.workers.SendGameMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x16a5
            r2 = r23
            android.util.Log.d(r11, r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x16a5:
            r2 = r23
            com.cellrebel.sdk.utils.PreferencesManager r4 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r12 = (long) r3     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4.b((long) r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x16b9
        L_0x16b0:
            r10 = r57
            r2 = r5
            goto L_0x16b8
        L_0x16b4:
            r10 = r57
            r2 = r5
            r9 = r15
        L_0x16b8:
            r5 = r3
        L_0x16b9:
            if (r22 == 0) goto L_0x18d4
            android.content.Context r3 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r3 = com.cellrebel.sdk.utils.Utils.f(r3)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x16d1
            android.util.Log.d(r11, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x16d1:
            com.cellrebel.sdk.database.SDKRoomDatabase r3 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.database.dao.GameListDAO r3 = r3.l()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.List r4 = r3.getAll()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r12 = r4.isEmpty()     // Catch:{ IOException -> 0x1714 }
            if (r12 != 0) goto L_0x16e5
            if (r52 == 0) goto L_0x1714
        L_0x16e5:
            com.cellrebel.sdk.networking.ApiService r12 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{ IOException -> 0x1714 }
            java.lang.String r13 = com.cellrebel.sdk.networking.UrlProvider.b(r6)     // Catch:{ IOException -> 0x1714 }
            retrofit2.Call r12 = r12.c(r13)     // Catch:{ IOException -> 0x1714 }
            retrofit2.Response r12 = r12.execute()     // Catch:{ IOException -> 0x1714 }
            boolean r13 = r12.isSuccessful()     // Catch:{ IOException -> 0x1714 }
            if (r13 == 0) goto L_0x1714
            java.lang.Object r13 = r12.body()     // Catch:{ IOException -> 0x1714 }
            if (r13 == 0) goto L_0x1714
            r3.a()     // Catch:{ IOException -> 0x1714 }
            java.lang.Object r13 = r12.body()     // Catch:{ IOException -> 0x1714 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ IOException -> 0x1714 }
            r3.a(r13)     // Catch:{ IOException -> 0x1714 }
            java.lang.Object r3 = r12.body()     // Catch:{ IOException -> 0x1714 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ IOException -> 0x1714 }
            r4 = r3
        L_0x1714:
            int r3 = r4.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 <= 0) goto L_0x18a5
            java.lang.Integer r3 = r6.loadedLatencyCacheRefresh()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.utils.PreferencesManager r12 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r12 = r12.u()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r13 = (int) r12     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r12 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r12 == 0) goto L_0x173d
            android.util.Log.d(r11, r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x173d:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r12.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.database.SDKRoomDatabase r14 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.database.dao.GameMetricDAO r14 = r14.j()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 <= r13) goto L_0x181f
            r3 = 1
            int r13 = r13 + r3
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1757:
            boolean r15 = r4.hasNext()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r15 == 0) goto L_0x1811
            java.lang.Object r15 = r4.next()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.networking.beans.response.Game r15 = (com.cellrebel.sdk.networking.beans.response.Game) r15     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r18 = r4
            java.lang.String r4 = r15.name     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r20 = r13
            java.lang.Integer r13 = r6.loadedLatencyServersCache()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r40 = r2
            r2 = 1
            java.util.List r4 = r14.a((java.lang.String) r4, (java.lang.Integer) r13, (boolean) r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r13 = r15.name     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r21 = 999(0x3e7, float:1.4E-42)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r21)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.List r10 = r14.a((java.lang.String) r13, (java.lang.Integer) r10, (boolean) r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r2 = r10.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.List r10 = r15.getServers()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r10 = r10.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 >= r10) goto L_0x17fb
            java.util.List r2 = r15.getServers()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1796:
            boolean r10 = r2.hasNext()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r10 == 0) goto L_0x17fb
            java.lang.Object r10 = r2.next()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.networking.beans.response.Server r10 = (com.cellrebel.sdk.networking.beans.response.Server) r10     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r13 = r10.loadedLatencyTestFileTransferUrl     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r13 == 0) goto L_0x17f4
            boolean r13 = kotlin.UByte$$ExternalSyntheticBackport0.m((java.lang.String) r13)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r13 != 0) goto L_0x17f4
            com.cellrebel.sdk.networking.beans.request.GameInfoMetric r13 = new com.cellrebel.sdk.networking.beans.request.GameInfoMetric     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r22 = r2
            java.lang.String r2 = r15.name     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r8 = r10.url     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r10.name     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r23 = 0
            java.lang.Float r45 = java.lang.Float.valueOf(r23)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Float r46 = java.lang.Float.valueOf(r23)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.Float r47 = java.lang.Float.valueOf(r23)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r5 = r10.loadedLatencyTestFileTransferUrl     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r49 = 0
            r41 = r13
            r42 = r2
            r43 = r8
            r44 = r7
            r48 = r5
            r41.<init>(r42, r43, r44, r45, r46, r47, r48, r49)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r2 = r15.name     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r5 = r10.url     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r7 = 1
            java.util.List r2 = r14.b(r2, r5, r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x17eb
            r3.add(r13)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r2 = r13.serverUrl     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r2 = r13.gameName     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x17eb:
            r5 = r54
            r7 = r55
            r8 = r56
            r2 = r22
            goto L_0x1796
        L_0x17f4:
            r5 = r54
            r7 = r55
            r8 = r56
            goto L_0x1796
        L_0x17fb:
            r7 = 1
            r23 = 0
            r3.addAll(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5 = r54
            r7 = r55
            r8 = r56
            r10 = r57
            r4 = r18
            r13 = r20
            r2 = r40
            goto L_0x1757
        L_0x1811:
            r40 = r2
            r20 = r13
            r7 = 1
            r12.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.size()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r12 = r20
            goto L_0x1827
        L_0x181f:
            r40 = r2
            r7 = 1
            java.util.List r3 = r0.a((com.cellrebel.sdk.database.dao.GameMetricDAO) r14)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r12 = 1
        L_0x1827:
            if (r52 == 0) goto L_0x1844
            boolean r2 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x1844
            if (r38 == 0) goto L_0x183b
            com.cellrebel.sdk.utils.Storage r2 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r4 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.r(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x1844
        L_0x183b:
            com.cellrebel.sdk.utils.Storage r2 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r4 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.q(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1844:
            if (r52 != 0) goto L_0x1850
            java.lang.Boolean r2 = r6.backgroundLocationEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x185a
        L_0x1850:
            com.cellrebel.sdk.workers.LocationWorker r2 = new com.cellrebel.sdk.workers.LocationWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r4 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x185a:
            android.content.Context r2 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = com.cellrebel.sdk.utils.Utils.f(r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x1870
            android.util.Log.d(r11, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1870:
            com.cellrebel.sdk.utils.PreferencesManager r2 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r4 = (long) r12     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.d(r4)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.CollectLoadedLatencyWorker r2 = new com.cellrebel.sdk.workers.CollectLoadedLatencyWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r0.g = r2     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r4 = r0.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.r = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.BaseMetricsWorker.h = r52     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r4 = r54
            r2.d = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r5 = r55
            r2.e = r5     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r8 = r56
            r2.f = r8     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r10 = r57
            r2.g = r10     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r12 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a(r12, r3)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.CollectLoadedLatencyWorker r2 = r0.g     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r2.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x18a9
            r30 = 1
            goto L_0x18a9
        L_0x18a5:
            r40 = r2
            r4 = r5
            r5 = r7
        L_0x18a9:
            com.cellrebel.sdk.workers.SendGameMetricsWorker r2 = new com.cellrebel.sdk.workers.SendGameMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r3 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r3)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.SendFileTransferMetricsWorker r2 = new com.cellrebel.sdk.workers.SendFileTransferMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r3 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r2.a((android.content.Context) r3)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r2 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r2 == 0) goto L_0x18d1
            r2 = r40
            android.util.Log.d(r11, r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x18d1:
            r2 = r40
            goto L_0x18d6
        L_0x18d4:
            r4 = r5
            r5 = r7
        L_0x18d6:
            if (r30 == 0) goto L_0x1980
            boolean r3 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x18ea
            android.util.Log.d(r11, r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x18ea:
            android.content.Context r3 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r3 = com.cellrebel.sdk.utils.Utils.f(r3)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x1900
            android.util.Log.d(r11, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1900:
            com.cellrebel.sdk.workers.CollectCellInfoMetricsWorker r3 = new com.cellrebel.sdk.workers.CollectCellInfoMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r0.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.j = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r7 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.a(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r3 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x1920
            android.util.Log.d(r11, r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1920:
            android.content.Context r3 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r3 = com.cellrebel.sdk.utils.Utils.f(r3)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x1936
            android.util.Log.d(r11, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1936:
            com.cellrebel.sdk.workers.CollectWifiMetricsWorker r3 = new com.cellrebel.sdk.workers.CollectWifiMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r7 = r0.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.j = r7     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r7 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.a(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r3 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x1956
            android.util.Log.d(r11, r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1956:
            android.content.Context r3 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r3 = com.cellrebel.sdk.utils.Utils.f(r3)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x196c
            android.util.Log.d(r11, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x196c:
            com.cellrebel.sdk.workers.SendCellInfoMetricsWorker r3 = new com.cellrebel.sdk.workers.SendCellInfoMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r7 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.a(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.SendWifiInfoMetricsWorker r3 = new com.cellrebel.sdk.workers.SendWifiInfoMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r7 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.a(r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1980:
            if (r31 == 0) goto L_0x1a21
            boolean r3 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x1994
            android.util.Log.d(r11, r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1994:
            android.content.Context r3 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r3 = com.cellrebel.sdk.utils.Utils.f(r3)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x19aa
            android.util.Log.d(r11, r9)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x19aa:
            if (r52 == 0) goto L_0x19c7
            boolean r3 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x19c7
            if (r38 == 0) goto L_0x19be
            com.cellrebel.sdk.utils.Storage r3 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r12 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.k(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            goto L_0x19c7
        L_0x19be:
            com.cellrebel.sdk.utils.Storage r3 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            long r12 = r0.d     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.j(r12)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x19c7:
            if (r52 != 0) goto L_0x19d3
            java.lang.Boolean r3 = r6.backgroundLocationEnabled()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r3 == 0) goto L_0x19dd
        L_0x19d3:
            com.cellrebel.sdk.workers.LocationWorker r3 = new com.cellrebel.sdk.workers.LocationWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r7 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.a((android.content.Context) r7)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x19dd:
            com.cellrebel.sdk.workers.CollectCoverageMetricsWorker r3 = new com.cellrebel.sdk.workers.CollectCoverageMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            com.cellrebel.sdk.workers.BaseMetricsWorker.h = r52     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.d = r4     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.e = r5     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.f = r8     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.g = r10     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            java.lang.String r1 = r0.a     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.j = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r1 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r3.a(r1)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            boolean r1 = r0.b     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r1 == 0) goto L_0x1a09
            android.util.Log.d(r11, r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = 0
            r0.c = r1     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            return r1
        L_0x1a09:
            com.cellrebel.sdk.workers.SendCoverageMetricsWorker r1 = new com.cellrebel.sdk.workers.SendCoverageMetricsWorker     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1.<init>()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            if (r30 == 0) goto L_0x1a12
            r2 = 0
            goto L_0x1a1a
        L_0x1a12:
            java.lang.Integer r2 = r6.reportingPeriodicity()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1a1a:
            r1.j = r2     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            android.content.Context r2 = r0.k     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1.a(r2)     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
        L_0x1a21:
            r51.a()     // Catch:{ Exception -> 0x1a2a, OutOfMemoryError -> 0x1a2d }
            r1 = r17
            android.util.Log.d(r11, r1)     // Catch:{ Exception -> 0x1a44, OutOfMemoryError -> 0x1a2d }
            goto L_0x1a32
        L_0x1a2a:
            r1 = r17
            goto L_0x1a44
        L_0x1a2d:
            java.lang.String r1 = "Measurements finished - OutOfMemoryError"
            android.util.Log.d(r11, r1)
        L_0x1a32:
            com.cellrebel.sdk.utils.Storage r1 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception | OutOfMemoryError -> 0x1a3b }
            r2 = 0
            r1.I(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x1a3b }
        L_0x1a3b:
            r1 = 0
            r0.c = r1
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.success()
            return r1
        L_0x1a43:
            r1 = r15
        L_0x1a44:
            android.util.Log.d(r11, r1)
            androidx.work.ListenableWorker$Result r1 = androidx.work.ListenableWorker.Result.success()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.MetaHelp.a(boolean, boolean, boolean, boolean, boolean, boolean):androidx.work.ListenableWorker$Result");
    }

    public boolean a(int i2) {
        return i2 == 0 || Math.abs(Storage.J().i() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    public boolean a(int i2, int i3) {
        Utils.b("coverage_worker");
        long f2 = Storage.J().f();
        Math.abs(f2 - this.d);
        if (Math.abs(f2 - this.d) < (((long) (i2 * 60)) * 1000) - ((long) i3)) {
            return false;
        }
        Storage.J().e(this.d);
        Storage.J().f();
        return true;
    }

    public boolean a(String str, int i2, int i3) {
        Utils.b(str);
        long c2 = Storage.J().c();
        Math.abs(c2 - this.d);
        if (Math.abs(c2 - this.d) < (((long) (i2 * 60)) * 1000) - ((long) i3)) {
            return false;
        }
        Storage.J().b(this.d);
        Storage.J().c();
        return true;
    }

    public boolean b(int i2, int i3) {
        Utils.b("game_worker");
        long I = Storage.J().I();
        Math.abs(I - this.d);
        if (Math.abs(I - this.d) < (((long) (i2 * 60)) * 1000) - ((long) i3)) {
            return false;
        }
        Storage.J().H(this.d);
        Storage.J().I();
        return true;
    }

    public boolean b(String str, int i2, int i3) {
        Utils.b(str);
        long h2 = Storage.J().h();
        Math.abs(h2 - this.d);
        if (Math.abs(h2 - this.d) < (((long) (i2 * 60)) * 1000) - ((long) i3)) {
            return false;
        }
        Storage.J().g(this.d);
        Storage.J().h();
        return true;
    }

    public boolean c(int i2) {
        return i2 == 0 || Math.abs(Storage.J().k() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    public boolean c(int i2, int i3) {
        if (Math.abs(Storage.J().M() - this.d) < (((long) (i2 * 60)) * 1000) - ((long) i3)) {
            return false;
        }
        Storage.J().K(this.d);
        return true;
    }

    public boolean c(String str, int i2, int i3) {
        Utils.b(str);
        long L = Storage.J().L();
        Math.abs(L - this.d);
        if (Math.abs(L - this.d) < (((long) (i2 * 60)) * 1000) - ((long) i3)) {
            return false;
        }
        Storage.J().J(this.d);
        Storage.J().L();
        return true;
    }

    public boolean d(int i2, int i3) {
        Utils.b("trace_worker");
        long P = Storage.J().P();
        Math.abs(P - this.d);
        if (Math.abs(P - this.d) < (((long) (i2 * 60)) * 1000) - ((long) i3)) {
            return false;
        }
        Storage.J().M(this.d);
        Storage.J().P();
        return true;
    }

    public boolean d(String str, int i2, int i3) {
        Utils.b(str);
        long S = Storage.J().S();
        Math.abs(S - this.d);
        if (Math.abs(S - this.d) < (((long) (i2 * 60)) * 1000) - ((long) i3)) {
            return false;
        }
        Storage.J().P(this.d);
        Storage.J().S();
        return true;
    }

    public boolean e(int i2) {
        return i2 == 0 || Math.abs(Storage.J().p() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    public boolean g(int i2) {
        return i2 == 0 || Math.abs(Storage.J().r() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    public boolean i(int i2) {
        return i2 == 0 || Math.abs(Storage.J().v() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    public boolean j(int i2) {
        return i2 == 0 || Math.abs(Storage.J().w() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    public boolean k(int i2) {
        return i2 == 0 || Math.abs(Storage.J().x() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    public boolean m(int i2) {
        return i2 == 0 || Math.abs(Storage.J().z() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    public boolean o(int i2) {
        return i2 == 0 || Math.abs(Storage.J().B() - this.d) >= ((long) (i2 * 60)) * 1000;
    }

    public boolean q(int i2) {
        return i2 == 0 || Math.abs(Storage.J().G() - this.d) >= ((long) (i2 * 60)) * 1000;
    }
}
