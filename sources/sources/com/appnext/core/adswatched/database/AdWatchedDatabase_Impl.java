package com.appnext.core.adswatched.database;

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
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AdWatchedDatabase_Impl extends AdWatchedDatabase {
    private volatile a dQ;

    /* access modifiers changed from: protected */
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) {
            public final void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public final void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `AdWatched` (`bannerId` TEXT NOT NULL, `auid` TEXT NOT NULL, PRIMARY KEY(`bannerId`, `auid`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '78dfff40d553309e5115594472f14b49')");
            }

            public final void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `AdWatched`");
                if (AdWatchedDatabase_Impl.this.mCallbacks != null) {
                    int size = AdWatchedDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AdWatchedDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public final void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (AdWatchedDatabase_Impl.this.mCallbacks != null) {
                    int size = AdWatchedDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AdWatchedDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public final void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = AdWatchedDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                AdWatchedDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (AdWatchedDatabase_Impl.this.mCallbacks != null) {
                    int size = AdWatchedDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AdWatchedDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public final void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("bannerId", new TableInfo.Column("bannerId", AdPreferences.TYPE_TEXT, true, 1, (String) null, 1));
                hashMap.put(JsonStorageKeyNames.AUID_ID_KEY, new TableInfo.Column(JsonStorageKeyNames.AUID_ID_KEY, AdPreferences.TYPE_TEXT, true, 2, (String) null, 1));
                TableInfo tableInfo = new TableInfo("AdWatched", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "AdWatched");
                if (tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "AdWatched(com.appnext.core.adswatched.database.AdWatched).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
        }, "78dfff40d553309e5115594472f14b49", "e2de3c54f36f9aabd3896d5f33522662")).build());
    }

    /* access modifiers changed from: protected */
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "AdWatched");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `AdWatched`");
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
        hashMap.put(a.class, b.ae());
        return hashMap;
    }

    public final Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public final List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    public final a adWatchedDao() {
        a aVar;
        if (this.dQ != null) {
            return this.dQ;
        }
        synchronized (this) {
            if (this.dQ == null) {
                this.dQ = new b(this);
            }
            aVar = this.dQ;
        }
        return aVar;
    }
}
