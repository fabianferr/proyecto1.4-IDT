package com.appnext.core.ra.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class RecentAppsDatabase_Impl extends RecentAppsDatabase {
    private volatile b eo;

    /* access modifiers changed from: protected */
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) {
            public final void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public final void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RecentApp` (`recentAppPackage` TEXT NOT NULL, `storeDate` TEXT NOT NULL, `sent` INTEGER NOT NULL, PRIMARY KEY(`recentAppPackage`, `storeDate`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e1eb051e9230fda8568d681a1d3cf00b')");
            }

            public final void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `RecentApp`");
                if (RecentAppsDatabase_Impl.this.mCallbacks != null) {
                    int size = RecentAppsDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) RecentAppsDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public final void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (RecentAppsDatabase_Impl.this.mCallbacks != null) {
                    int size = RecentAppsDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) RecentAppsDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public final void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = RecentAppsDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                RecentAppsDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (RecentAppsDatabase_Impl.this.mCallbacks != null) {
                    int size = RecentAppsDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) RecentAppsDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public final void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("recentAppPackage", new TableInfo.Column("recentAppPackage", AdPreferences.TYPE_TEXT, true, 1, (String) null, 1));
                hashMap.put("storeDate", new TableInfo.Column("storeDate", AdPreferences.TYPE_TEXT, true, 2, (String) null, 1));
                hashMap.put("sent", new TableInfo.Column("sent", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("RecentApp", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "RecentApp");
                if (tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "RecentApp(com.appnext.core.ra.database.RecentApp).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
        }, "e1eb051e9230fda8568d681a1d3cf00b", "52c6c70fcfd3ff556a2b04d53ac85ff8")).build());
    }

    /* access modifiers changed from: protected */
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "RecentApp");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `RecentApp`");
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
    public final Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(b.class, c.ae());
        return hashMap;
    }

    public final Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public final List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    public final b recentAppDao() {
        b bVar;
        if (this.eo != null) {
            return this.eo;
        }
        synchronized (this) {
            if (this.eo == null) {
                this.eo = new c(this);
            }
            bVar = this.eo;
        }
        return bVar;
    }
}
