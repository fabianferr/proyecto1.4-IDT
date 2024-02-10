package com.appnext.core.adswatched.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b implements a {
    private final RoomDatabase dM;
    private final EntityInsertionAdapter<AdWatched> dN;
    private final SharedSQLiteStatement dO;

    public b(RoomDatabase roomDatabase) {
        this.dM = roomDatabase;
        this.dN = new EntityInsertionAdapter<AdWatched>(roomDatabase) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `AdWatched` (`bannerId`,`auid`) VALUES (?,?)";
            }

            public final /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
                AdWatched adWatched = (AdWatched) obj;
                if (adWatched.bannerId == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, adWatched.bannerId);
                }
                if (adWatched.auid == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, adWatched.auid);
                }
            }
        };
        this.dO = new SharedSQLiteStatement(roomDatabase) {
            public final String createQuery() {
                return "DELETE FROM adwatched WHERE adwatched.auid Like ?";
            }
        };
    }

    public final long a(AdWatched adWatched) {
        this.dM.assertNotSuspendingTransaction();
        this.dM.beginTransaction();
        try {
            long insertAndReturnId = this.dN.insertAndReturnId(adWatched);
            this.dM.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.dM.endTransaction();
        }
    }

    public final int y(String str) {
        this.dM.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.dO.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.dM.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.dM.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.dM.endTransaction();
            this.dO.release(acquire);
        }
    }

    public final List<String> x(String str) {
        String str2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT adwatched.bannerId FROM adwatched WHERE  adwatched.auid Like ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.dM.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.dM, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str2 = null;
                } else {
                    str2 = query.getString(0);
                }
                arrayList.add(str2);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public static List<Class<?>> ae() {
        return Collections.emptyList();
    }
}
