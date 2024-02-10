package com.cellrebel.sdk.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.cellrebel.sdk.database.Timestamps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TimestampsDAO_Impl implements TimestampsDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<Timestamps> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<Timestamps> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, Timestamps timestamps) {
            supportSQLiteStatement.bindLong(1, timestamps.a);
            supportSQLiteStatement.bindLong(2, timestamps.b);
            supportSQLiteStatement.bindLong(3, timestamps.c);
            supportSQLiteStatement.bindLong(4, timestamps.d);
            supportSQLiteStatement.bindLong(5, timestamps.e);
            supportSQLiteStatement.bindLong(6, timestamps.f);
            supportSQLiteStatement.bindLong(7, timestamps.g);
            supportSQLiteStatement.bindLong(8, timestamps.h);
            supportSQLiteStatement.bindLong(9, timestamps.i);
            supportSQLiteStatement.bindLong(10, timestamps.j);
            supportSQLiteStatement.bindLong(11, timestamps.k);
            supportSQLiteStatement.bindLong(12, timestamps.l);
            supportSQLiteStatement.bindLong(13, timestamps.m);
            supportSQLiteStatement.bindLong(14, timestamps.n);
            supportSQLiteStatement.bindLong(15, timestamps.o);
            supportSQLiteStatement.bindLong(16, timestamps.p);
            supportSQLiteStatement.bindLong(17, timestamps.q);
            supportSQLiteStatement.bindLong(18, timestamps.r);
            supportSQLiteStatement.bindLong(19, timestamps.s);
            supportSQLiteStatement.bindLong(20, timestamps.t);
            supportSQLiteStatement.bindLong(21, timestamps.u);
            supportSQLiteStatement.bindLong(22, timestamps.v);
            supportSQLiteStatement.bindLong(23, timestamps.w);
            supportSQLiteStatement.bindLong(24, timestamps.x);
            supportSQLiteStatement.bindLong(25, timestamps.y);
            supportSQLiteStatement.bindLong(26, timestamps.z);
            supportSQLiteStatement.bindLong(27, timestamps.A);
            supportSQLiteStatement.bindLong(28, timestamps.B);
            supportSQLiteStatement.bindLong(29, timestamps.C);
            supportSQLiteStatement.bindLong(30, timestamps.D);
            supportSQLiteStatement.bindLong(31, timestamps.E);
            supportSQLiteStatement.bindLong(32, timestamps.F);
            supportSQLiteStatement.bindLong(33, timestamps.G);
            supportSQLiteStatement.bindLong(34, timestamps.H);
            supportSQLiteStatement.bindLong(35, timestamps.I);
            supportSQLiteStatement.bindLong(36, timestamps.J);
            supportSQLiteStatement.bindLong(37, timestamps.K);
            supportSQLiteStatement.bindLong(38, timestamps.L);
            supportSQLiteStatement.bindLong(39, timestamps.M);
            supportSQLiteStatement.bindLong(40, timestamps.N);
            supportSQLiteStatement.bindLong(41, timestamps.O);
            supportSQLiteStatement.bindLong(42, timestamps.P);
            supportSQLiteStatement.bindLong(43, timestamps.Q);
            supportSQLiteStatement.bindLong(44, timestamps.R);
            supportSQLiteStatement.bindLong(45, timestamps.S);
            supportSQLiteStatement.bindLong(46, timestamps.T);
            supportSQLiteStatement.bindLong(47, timestamps.U);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `Timestamps` (`id`,`pageLoad`,`fileTransfer`,`cdnDownload`,`video`,`coverage`,`dataUsage`,`connection`,`coverageReporting`,`game`,`traceroute`,`tti`,`trafficProfile`,`deviceInfo`,`loadedLatency`,`randomCdnDownload`,`cellInfoReportingPeriodicity`,`foregroundLaunchTime`,`foregroundLaunchTimeWiFi`,`backgroundLaunchTime`,`metaWorkerLaunchTme`,`settingsRefreshTime`,`foregroundPageLoad`,`foregroundDeviceInfo`,`foregroundFileTransfer`,`foregroundCdnDownload`,`foregroundVideo`,`foregroundTraceroute`,`foregroundCoverage`,`foregroundGame`,`foregroundLoadedLatency`,`foregroundDataUsage`,`foregroundRandomCdnDownload`,`foregroundTti`,`foregroundTrafficProfile`,`foregroundPageLoadWiFi`,`foregroundFileTransferWiFi`,`foregroundCdnDownloadWiFi`,`foregroundVideoWiFi`,`foregroundTracerouteWiFi`,`foregroundCoverageWiFi`,`foregroundGameWiFi`,`foregroundDataUsageWiFi`,`foregroundLoadedLatencyWiFi`,`foregroundRandomCdnDownloadWiFi`,`foregroundTtiWiFi`,`foregroundTrafficProfileWiFi`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM timestamps";
        }
    }

    public TimestampsDAO_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    public static List<Class<?>> b() {
        return Collections.emptyList();
    }

    public void a() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.c.acquire();
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.c.release(acquire);
        }
    }

    public void a(Timestamps timestamps) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(timestamps);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<Timestamps> getAll() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from timestamps", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "pageLoad");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "fileTransfer");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "cdnDownload");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "video");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "coverage");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "dataUsage");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "connection");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "coverageReporting");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "game");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "traceroute");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "tti");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "trafficProfile");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "deviceInfo");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "loadedLatency");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "randomCdnDownload");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "cellInfoReportingPeriodicity");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "foregroundLaunchTime");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "foregroundLaunchTimeWiFi");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backgroundLaunchTime");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "metaWorkerLaunchTme");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "settingsRefreshTime");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "foregroundPageLoad");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "foregroundDeviceInfo");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "foregroundFileTransfer");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "foregroundCdnDownload");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "foregroundVideo");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "foregroundTraceroute");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "foregroundCoverage");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "foregroundGame");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "foregroundLoadedLatency");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "foregroundDataUsage");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "foregroundRandomCdnDownload");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "foregroundTti");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "foregroundTrafficProfile");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "foregroundPageLoadWiFi");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "foregroundFileTransferWiFi");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "foregroundCdnDownloadWiFi");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "foregroundVideoWiFi");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "foregroundTracerouteWiFi");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "foregroundCoverageWiFi");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "foregroundGameWiFi");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "foregroundDataUsageWiFi");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "foregroundLoadedLatencyWiFi");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "foregroundRandomCdnDownloadWiFi");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "foregroundTtiWiFi");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "foregroundTrafficProfileWiFi");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    Timestamps timestamps = new Timestamps();
                    int i2 = columnIndexOrThrow13;
                    timestamps.a = query.getLong(columnIndexOrThrow);
                    timestamps.b = query.getLong(columnIndexOrThrow2);
                    timestamps.c = query.getLong(columnIndexOrThrow3);
                    timestamps.d = query.getLong(columnIndexOrThrow4);
                    timestamps.e = query.getLong(columnIndexOrThrow5);
                    timestamps.f = query.getLong(columnIndexOrThrow6);
                    timestamps.g = query.getLong(columnIndexOrThrow7);
                    timestamps.h = query.getLong(columnIndexOrThrow8);
                    timestamps.i = query.getLong(columnIndexOrThrow9);
                    timestamps.j = query.getLong(columnIndexOrThrow10);
                    timestamps.k = query.getLong(columnIndexOrThrow11);
                    int i3 = columnIndexOrThrow2;
                    columnIndexOrThrow12 = columnIndexOrThrow12;
                    int i4 = columnIndexOrThrow3;
                    timestamps.l = query.getLong(columnIndexOrThrow12);
                    int i5 = i2;
                    int i6 = columnIndexOrThrow4;
                    timestamps.m = query.getLong(i5);
                    int i7 = i;
                    int i8 = columnIndexOrThrow5;
                    timestamps.n = query.getLong(i7);
                    int i9 = i5;
                    int i10 = columnIndexOrThrow15;
                    int i11 = i7;
                    timestamps.o = query.getLong(i10);
                    int i12 = columnIndexOrThrow16;
                    int i13 = i10;
                    timestamps.p = query.getLong(i12);
                    int i14 = columnIndexOrThrow17;
                    int i15 = i9;
                    timestamps.q = query.getLong(i14);
                    int i16 = i12;
                    int i17 = columnIndexOrThrow18;
                    int i18 = i14;
                    timestamps.r = query.getLong(i17);
                    int i19 = columnIndexOrThrow19;
                    int i20 = i17;
                    timestamps.s = query.getLong(i19);
                    int i21 = columnIndexOrThrow20;
                    int i22 = i16;
                    timestamps.t = query.getLong(i21);
                    int i23 = i19;
                    int i24 = columnIndexOrThrow21;
                    int i25 = i21;
                    timestamps.u = query.getLong(i24);
                    int i26 = columnIndexOrThrow22;
                    int i27 = i24;
                    timestamps.v = query.getLong(i26);
                    int i28 = columnIndexOrThrow23;
                    int i29 = i23;
                    timestamps.w = query.getLong(i28);
                    int i30 = i26;
                    int i31 = columnIndexOrThrow24;
                    int i32 = i28;
                    timestamps.x = query.getLong(i31);
                    int i33 = columnIndexOrThrow25;
                    int i34 = i31;
                    timestamps.y = query.getLong(i33);
                    int i35 = columnIndexOrThrow26;
                    int i36 = i30;
                    timestamps.z = query.getLong(i35);
                    int i37 = i33;
                    int i38 = columnIndexOrThrow27;
                    int i39 = i35;
                    timestamps.A = query.getLong(i38);
                    int i40 = columnIndexOrThrow28;
                    int i41 = i38;
                    timestamps.B = query.getLong(i40);
                    int i42 = columnIndexOrThrow29;
                    int i43 = i37;
                    timestamps.C = query.getLong(i42);
                    int i44 = i40;
                    int i45 = columnIndexOrThrow30;
                    int i46 = i42;
                    timestamps.D = query.getLong(i45);
                    int i47 = columnIndexOrThrow31;
                    int i48 = i45;
                    timestamps.E = query.getLong(i47);
                    int i49 = columnIndexOrThrow32;
                    int i50 = i44;
                    timestamps.F = query.getLong(i49);
                    int i51 = i47;
                    int i52 = columnIndexOrThrow33;
                    int i53 = i49;
                    timestamps.G = query.getLong(i52);
                    int i54 = columnIndexOrThrow34;
                    int i55 = i52;
                    timestamps.H = query.getLong(i54);
                    int i56 = columnIndexOrThrow35;
                    int i57 = i51;
                    timestamps.I = query.getLong(i56);
                    int i58 = i54;
                    int i59 = columnIndexOrThrow36;
                    int i60 = i56;
                    timestamps.J = query.getLong(i59);
                    int i61 = columnIndexOrThrow37;
                    int i62 = i59;
                    timestamps.K = query.getLong(i61);
                    int i63 = columnIndexOrThrow38;
                    int i64 = i58;
                    timestamps.L = query.getLong(i63);
                    int i65 = i61;
                    int i66 = columnIndexOrThrow39;
                    int i67 = i63;
                    timestamps.M = query.getLong(i66);
                    int i68 = columnIndexOrThrow40;
                    int i69 = i66;
                    timestamps.N = query.getLong(i68);
                    int i70 = columnIndexOrThrow41;
                    int i71 = i65;
                    timestamps.O = query.getLong(i70);
                    int i72 = i68;
                    int i73 = columnIndexOrThrow42;
                    int i74 = i70;
                    timestamps.P = query.getLong(i73);
                    int i75 = columnIndexOrThrow43;
                    int i76 = i73;
                    timestamps.Q = query.getLong(i75);
                    int i77 = columnIndexOrThrow44;
                    int i78 = i72;
                    timestamps.R = query.getLong(i77);
                    int i79 = i75;
                    int i80 = columnIndexOrThrow45;
                    int i81 = i77;
                    timestamps.S = query.getLong(i80);
                    int i82 = columnIndexOrThrow46;
                    int i83 = i80;
                    timestamps.T = query.getLong(i82);
                    int i84 = columnIndexOrThrow47;
                    int i85 = i79;
                    timestamps.U = query.getLong(i84);
                    arrayList.add(timestamps);
                    columnIndexOrThrow5 = i8;
                    columnIndexOrThrow4 = i6;
                    i = i11;
                    columnIndexOrThrow15 = i13;
                    columnIndexOrThrow16 = i22;
                    columnIndexOrThrow20 = i25;
                    columnIndexOrThrow21 = i27;
                    columnIndexOrThrow22 = i36;
                    columnIndexOrThrow26 = i39;
                    columnIndexOrThrow27 = i41;
                    columnIndexOrThrow28 = i50;
                    columnIndexOrThrow32 = i53;
                    columnIndexOrThrow33 = i55;
                    columnIndexOrThrow34 = i64;
                    columnIndexOrThrow38 = i67;
                    columnIndexOrThrow39 = i69;
                    columnIndexOrThrow40 = i78;
                    columnIndexOrThrow44 = i81;
                    columnIndexOrThrow45 = i83;
                    columnIndexOrThrow46 = i82;
                    columnIndexOrThrow2 = i3;
                    columnIndexOrThrow13 = i15;
                    columnIndexOrThrow17 = i18;
                    columnIndexOrThrow18 = i20;
                    columnIndexOrThrow19 = i29;
                    columnIndexOrThrow23 = i32;
                    columnIndexOrThrow24 = i34;
                    columnIndexOrThrow25 = i43;
                    columnIndexOrThrow29 = i46;
                    columnIndexOrThrow30 = i48;
                    columnIndexOrThrow31 = i57;
                    columnIndexOrThrow35 = i60;
                    columnIndexOrThrow36 = i62;
                    columnIndexOrThrow37 = i71;
                    columnIndexOrThrow41 = i74;
                    columnIndexOrThrow42 = i76;
                    columnIndexOrThrow43 = i85;
                    columnIndexOrThrow47 = i84;
                    columnIndexOrThrow3 = i4;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }
}
