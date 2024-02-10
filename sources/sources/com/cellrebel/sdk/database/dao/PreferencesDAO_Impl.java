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
import com.cellrebel.sdk.database.Preferences;
import com.ironsource.adapters.ironsource.IronSourceAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PreferencesDAO_Impl implements PreferencesDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<Preferences> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<Preferences> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, Preferences preferences) {
            supportSQLiteStatement.bindLong(1, preferences.a);
            String str = preferences.b;
            if (str == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str);
            }
            String str2 = preferences.c;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            String str3 = preferences.d;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            String str4 = preferences.e;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str4);
            }
            String str5 = preferences.f;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, str5);
            }
            String str6 = preferences.g;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str6);
            }
            supportSQLiteStatement.bindLong(8, preferences.h);
            supportSQLiteStatement.bindLong(9, preferences.i);
            supportSQLiteStatement.bindLong(10, preferences.j);
            String str7 = preferences.k;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str7);
            }
            String str8 = preferences.l;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str8);
            }
            supportSQLiteStatement.bindLong(13, preferences.m);
            supportSQLiteStatement.bindLong(14, preferences.n);
            supportSQLiteStatement.bindLong(15, preferences.o);
            supportSQLiteStatement.bindLong(16, preferences.p);
            supportSQLiteStatement.bindLong(17, preferences.q);
            supportSQLiteStatement.bindLong(18, preferences.r);
            supportSQLiteStatement.bindLong(19, preferences.s);
            supportSQLiteStatement.bindDouble(20, preferences.t);
            supportSQLiteStatement.bindDouble(21, preferences.u);
            supportSQLiteStatement.bindDouble(22, preferences.v);
            String str9 = preferences.w;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str9);
            }
            String str10 = preferences.x;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str10);
            }
            supportSQLiteStatement.bindLong(25, preferences.y ? 1 : 0);
            supportSQLiteStatement.bindLong(26, preferences.z ? 1 : 0);
            supportSQLiteStatement.bindLong(27, preferences.A ? 1 : 0);
            supportSQLiteStatement.bindLong(28, preferences.B ? 1 : 0);
            supportSQLiteStatement.bindLong(29, preferences.C ? 1 : 0);
            String str11 = preferences.D;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, str11);
            }
            String str12 = preferences.E;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(31);
            } else {
                supportSQLiteStatement.bindString(31, str12);
            }
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `Preferences` (`id`,`token`,`manufacturer`,`marketName`,`codename`,`mobileClientId`,`clientKey`,`fileTransferTimeout`,`currentRefreshCache`,`onLoadRefreshCache`,`ranksJson`,`countriesJson`,`ranksTimestamp`,`wiFiSentUsage`,`wiFiReceivedUsage`,`cellularSentUsage`,`cellularReceivedUsage`,`callStartTime`,`dataUsageMeasurementTimestamp`,`pageLoadTimestamp`,`fileLoadTimestamp`,`videoLoadTimestamp`,`locationDebug`,`cellInfoDebug`,`isMeasurementsStopped`,`isBackgroundMeasurementEnabled`,`isCallEnded`,`isOnCall`,`isRinging`,`fileTransferAccessTechs`,`cdnDownloadAccessTechs`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM preferences";
        }
    }

    public PreferencesDAO_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    public static List<Class<?>> c() {
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

    public void a(Preferences preferences) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(preferences);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<Preferences> b() {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from preferences", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, IronSourceAdapter.IRONSOURCE_BIDDING_TOKEN_KEY);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "manufacturer");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "marketName");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "codename");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "mobileClientId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "clientKey");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "fileTransferTimeout");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "currentRefreshCache");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "onLoadRefreshCache");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "ranksJson");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "countriesJson");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "ranksTimestamp");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "wiFiSentUsage");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "wiFiReceivedUsage");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "cellularSentUsage");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "cellularReceivedUsage");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "callStartTime");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "dataUsageMeasurementTimestamp");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "pageLoadTimestamp");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "fileLoadTimestamp");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "videoLoadTimestamp");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "locationDebug");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "cellInfoDebug");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "isMeasurementsStopped");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "isBackgroundMeasurementEnabled");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "isCallEnded");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "isOnCall");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "isRinging");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "fileTransferAccessTechs");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "cdnDownloadAccessTechs");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    Preferences preferences = new Preferences();
                    ArrayList arrayList2 = arrayList;
                    int i5 = columnIndexOrThrow13;
                    preferences.a = query.getLong(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        preferences.b = null;
                    } else {
                        preferences.b = query.getString(columnIndexOrThrow2);
                    }
                    if (query.isNull(columnIndexOrThrow3)) {
                        preferences.c = null;
                    } else {
                        preferences.c = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        preferences.d = null;
                    } else {
                        preferences.d = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        preferences.e = null;
                    } else {
                        preferences.e = query.getString(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        preferences.f = null;
                    } else {
                        preferences.f = query.getString(columnIndexOrThrow6);
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        preferences.g = null;
                    } else {
                        preferences.g = query.getString(columnIndexOrThrow7);
                    }
                    preferences.h = query.getLong(columnIndexOrThrow8);
                    preferences.i = query.getLong(columnIndexOrThrow9);
                    preferences.j = query.getLong(columnIndexOrThrow10);
                    if (query.isNull(columnIndexOrThrow11)) {
                        preferences.k = null;
                    } else {
                        preferences.k = query.getString(columnIndexOrThrow11);
                    }
                    if (query.isNull(columnIndexOrThrow12)) {
                        preferences.l = null;
                    } else {
                        preferences.l = query.getString(columnIndexOrThrow12);
                    }
                    int i6 = columnIndexOrThrow2;
                    int i7 = i5;
                    int i8 = columnIndexOrThrow3;
                    preferences.m = query.getLong(i7);
                    int i9 = columnIndexOrThrow12;
                    int i10 = i4;
                    int i11 = i7;
                    preferences.n = query.getLong(i10);
                    int i12 = columnIndexOrThrow15;
                    int i13 = i6;
                    preferences.o = query.getLong(i12);
                    int i14 = i10;
                    int i15 = columnIndexOrThrow16;
                    int i16 = i9;
                    preferences.p = query.getLong(i15);
                    int i17 = i12;
                    int i18 = columnIndexOrThrow17;
                    int i19 = i15;
                    preferences.q = query.getLong(i18);
                    int i20 = columnIndexOrThrow18;
                    int i21 = i14;
                    preferences.r = query.getLong(i20);
                    int i22 = i18;
                    int i23 = columnIndexOrThrow19;
                    int i24 = i17;
                    preferences.s = query.getLong(i23);
                    int i25 = i20;
                    int i26 = columnIndexOrThrow20;
                    int i27 = i23;
                    preferences.t = query.getDouble(i26);
                    int i28 = columnIndexOrThrow21;
                    int i29 = i22;
                    preferences.u = query.getDouble(i28);
                    int i30 = i26;
                    int i31 = columnIndexOrThrow22;
                    int i32 = i25;
                    preferences.v = query.getDouble(i31);
                    int i33 = columnIndexOrThrow23;
                    if (query.isNull(i33)) {
                        preferences.w = null;
                    } else {
                        preferences.w = query.getString(i33);
                    }
                    int i34 = columnIndexOrThrow24;
                    if (query.isNull(i34)) {
                        i = columnIndexOrThrow;
                        preferences.x = null;
                    } else {
                        i = columnIndexOrThrow;
                        preferences.x = query.getString(i34);
                    }
                    int i35 = columnIndexOrThrow25;
                    if (query.getInt(i35) != 0) {
                        i2 = i35;
                        z = true;
                    } else {
                        i2 = i35;
                        z = false;
                    }
                    preferences.y = z;
                    int i36 = columnIndexOrThrow26;
                    if (query.getInt(i36) != 0) {
                        columnIndexOrThrow26 = i36;
                        z2 = true;
                    } else {
                        columnIndexOrThrow26 = i36;
                        z2 = false;
                    }
                    preferences.z = z2;
                    int i37 = columnIndexOrThrow27;
                    if (query.getInt(i37) != 0) {
                        columnIndexOrThrow27 = i37;
                        z3 = true;
                    } else {
                        columnIndexOrThrow27 = i37;
                        z3 = false;
                    }
                    preferences.A = z3;
                    int i38 = columnIndexOrThrow28;
                    if (query.getInt(i38) != 0) {
                        columnIndexOrThrow28 = i38;
                        z4 = true;
                    } else {
                        columnIndexOrThrow28 = i38;
                        z4 = false;
                    }
                    preferences.B = z4;
                    int i39 = columnIndexOrThrow29;
                    if (query.getInt(i39) != 0) {
                        columnIndexOrThrow29 = i39;
                        z5 = true;
                    } else {
                        columnIndexOrThrow29 = i39;
                        z5 = false;
                    }
                    preferences.C = z5;
                    int i40 = columnIndexOrThrow30;
                    if (query.isNull(i40)) {
                        i3 = i28;
                        preferences.D = null;
                    } else {
                        i3 = i28;
                        preferences.D = query.getString(i40);
                    }
                    int i41 = columnIndexOrThrow31;
                    if (query.isNull(i41)) {
                        columnIndexOrThrow30 = i40;
                        preferences.E = null;
                    } else {
                        columnIndexOrThrow30 = i40;
                        preferences.E = query.getString(i41);
                    }
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(preferences);
                    columnIndexOrThrow31 = i41;
                    columnIndexOrThrow12 = i16;
                    columnIndexOrThrow16 = i19;
                    columnIndexOrThrow17 = i29;
                    columnIndexOrThrow21 = i3;
                    columnIndexOrThrow25 = i2;
                    columnIndexOrThrow24 = i34;
                    columnIndexOrThrow3 = i8;
                    int i42 = i31;
                    arrayList = arrayList3;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow23 = i33;
                    columnIndexOrThrow2 = i13;
                    columnIndexOrThrow15 = i24;
                    columnIndexOrThrow19 = i27;
                    columnIndexOrThrow20 = i30;
                    columnIndexOrThrow13 = i11;
                    i4 = i21;
                    columnIndexOrThrow18 = i32;
                    columnIndexOrThrow22 = i42;
                }
                ArrayList arrayList4 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList4;
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
