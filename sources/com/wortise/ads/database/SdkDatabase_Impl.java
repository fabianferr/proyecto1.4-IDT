package com.wortise.ads.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.wortise.ads.m;
import com.wortise.ads.n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class SdkDatabase_Impl extends SdkDatabase {
    private volatile m a;

    class a extends RoomOpenHelper.Delegate {
        a(int i) {
            super(i);
        }

        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ad_result_cache` (`adUnitId` TEXT NOT NULL, `adResult` TEXT NOT NULL, `date` INTEGER NOT NULL, PRIMARY KEY(`adUnitId`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '904a47d01e83e8495a3df853cdb7356d')");
        }

        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ad_result_cache`");
            if (SdkDatabase_Impl.this.mCallbacks != null) {
                int size = SdkDatabase_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) SdkDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (SdkDatabase_Impl.this.mCallbacks != null) {
                int size = SdkDatabase_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) SdkDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            SupportSQLiteDatabase unused = SdkDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
            SdkDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (SdkDatabase_Impl.this.mCallbacks != null) {
                int size = SdkDatabase_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) SdkDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        /* access modifiers changed from: protected */
        public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(3);
            hashMap.put("adUnitId", new TableInfo.Column("adUnitId", AdPreferences.TYPE_TEXT, true, 1, (String) null, 1));
            hashMap.put("adResult", new TableInfo.Column("adResult", AdPreferences.TYPE_TEXT, true, 0, (String) null, 1));
            hashMap.put("date", new TableInfo.Column("date", "INTEGER", true, 0, (String) null, 1));
            TableInfo tableInfo = new TableInfo("ad_result_cache", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "ad_result_cache");
            if (tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(true, (String) null);
            }
            return new RoomOpenHelper.ValidationResult(false, "ad_result_cache(com.wortise.ads.database.models.AdResultCache).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
        }
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `ad_result_cache`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "ad_result_cache");
    }

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(4), "904a47d01e83e8495a3df853cdb7356d", "c58a34609af1d14dc2c9e6191005fd0c")).build());
    }

    /* access modifiers changed from: protected */
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(m.class, n.a());
        return hashMap;
    }

    public m a() {
        m mVar;
        if (this.a != null) {
            return this.a;
        }
        synchronized (this) {
            if (this.a == null) {
                this.a = new n(this);
            }
            mVar = this.a;
        }
        return mVar;
    }
}
