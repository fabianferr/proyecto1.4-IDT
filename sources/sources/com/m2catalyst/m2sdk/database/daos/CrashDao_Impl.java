package com.m2catalyst.m2sdk.database.daos;

import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.m2catalyst.m2sdk.database.entities.CrashEntity;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class CrashDao_Impl implements CrashDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<CrashEntity> __insertionAdapterOfCrashEntity;

    public CrashDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfCrashEntity = new EntityInsertionAdapter<CrashEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `crash_tbl` (`id`,`time_stamp`,`stack_trace`) VALUES (nullif(?, 0),?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, CrashEntity crashEntity) {
                supportSQLiteStatement.bindLong(1, (long) crashEntity.getId());
                if (crashEntity.getTime_stamp() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindLong(2, crashEntity.getTime_stamp().longValue());
                }
                if (crashEntity.getStack_trace() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, crashEntity.getStack_trace());
                }
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Object insertCrash(final CrashEntity crashEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                CrashDao_Impl.this.__db.beginTransaction();
                try {
                    CrashDao_Impl.this.__insertionAdapterOfCrashEntity.insert(crashEntity);
                    CrashDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    CrashDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }
}
