package com.m2catalyst.m2sdk.database;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
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
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.m2catalyst.m2sdk.database.daos.BadSignalsDao;
import com.m2catalyst.m2sdk.database.daos.BadSignalsDao_Impl;
import com.m2catalyst.m2sdk.database.daos.CounterDao;
import com.m2catalyst.m2sdk.database.daos.CounterDao_Impl;
import com.m2catalyst.m2sdk.database.daos.CrashDao;
import com.m2catalyst.m2sdk.database.daos.CrashDao_Impl;
import com.m2catalyst.m2sdk.database.daos.LocationDao;
import com.m2catalyst.m2sdk.database.daos.LocationDao_Impl;
import com.m2catalyst.m2sdk.database.daos.MNSIDao;
import com.m2catalyst.m2sdk.database.daos.MNSIDao_Impl;
import com.m2catalyst.m2sdk.database.daos.NDTDao;
import com.m2catalyst.m2sdk.database.daos.NDTDao_Impl;
import com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao;
import com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao_Impl;
import com.m2catalyst.m2sdk.database.daos.WifiDao;
import com.m2catalyst.m2sdk.database.daos.WifiDao_Impl;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SDKDatabase_Impl extends SDKDatabase {
    private volatile BadSignalsDao _badSignalsDao;
    private volatile CounterDao _counterDao;
    private volatile CrashDao _crashDao;
    private volatile LocationDao _locationDao;
    private volatile MNSIDao _mNSIDao;
    private volatile NDTDao _nDTDao;
    private volatile NoSignalMNSIDao _noSignalMNSIDao;
    private volatile WifiDao _wifiDao;

    public BadSignalsDao badSignalsDao() {
        BadSignalsDao badSignalsDao;
        if (this._badSignalsDao != null) {
            return this._badSignalsDao;
        }
        synchronized (this) {
            if (this._badSignalsDao == null) {
                this._badSignalsDao = new BadSignalsDao_Impl(this);
            }
            badSignalsDao = this._badSignalsDao;
        }
        return badSignalsDao;
    }

    public void clearAllTables() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        try {
            beginTransaction();
            writableDatabase.execSQL("DELETE FROM `CounterInt`");
            writableDatabase.execSQL("DELETE FROM `CounterLong`");
            writableDatabase.execSQL("DELETE FROM `location_tbl`");
            writableDatabase.execSQL("DELETE FROM `wifi_tbl`");
            writableDatabase.execSQL("DELETE FROM `diagnostics_tbl`");
            writableDatabase.execSQL("DELETE FROM `mnsi_tbl`");
            writableDatabase.execSQL("DELETE FROM `no_network_signal_tbl`");
            writableDatabase.execSQL("DELETE FROM `bad_signals_tbl`");
            writableDatabase.execSQL("DELETE FROM `crash_tbl`");
            setTransactionSuccessful();
        } finally {
            endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    public CounterDao counterDao() {
        CounterDao counterDao;
        if (this._counterDao != null) {
            return this._counterDao;
        }
        synchronized (this) {
            if (this._counterDao == null) {
                this._counterDao = new CounterDao_Impl(this);
            }
            counterDao = this._counterDao;
        }
        return counterDao;
    }

    public CrashDao crashDao() {
        CrashDao crashDao;
        if (this._crashDao != null) {
            return this._crashDao;
        }
        synchronized (this) {
            if (this._crashDao == null) {
                this._crashDao = new CrashDao_Impl(this);
            }
            crashDao = this._crashDao;
        }
        return crashDao;
    }

    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "CounterInt", "CounterLong", SDKDatabaseKt.LOCATION_TBL, SDKDatabaseKt.WIFI_TBL, SDKDatabaseKt.NETWORK_DIAGNOSTICS_TBL, SDKDatabaseKt.MNSI_TBL, SDKDatabaseKt.NO_SIGNALS_TBL, SDKDatabaseKt.BAD_SIGNALS_TBL, SDKDatabaseKt.CRASH_TBL);
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(69) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `CounterInt` (`counterId` TEXT NOT NULL, `counterValue` INTEGER NOT NULL, `date` TEXT NOT NULL, `transmitted` INTEGER NOT NULL, PRIMARY KEY(`counterId`, `date`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `CounterLong` (`counterId` TEXT NOT NULL, `counterValue` INTEGER NOT NULL, `date` TEXT NOT NULL, `transmitted` INTEGER NOT NULL, PRIMARY KEY(`counterId`, `date`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `location_tbl` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `altitude` REAL, `longitude` REAL, `latitude` REAL, `indoorOutdoorWeight` REAL, `accuracy` REAL, `bearing` REAL, `speed` REAL, `timeZoneOffset` INTEGER, `timeZoneId` TEXT, `timeStamp` INTEGER, `transmitted` INTEGER NOT NULL, `provider` TEXT, `barometric` REAL, `permissions` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_location_tbl_timeStamp` ON `location_tbl` (`timeStamp`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `wifi_tbl` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `time_stamp` INTEGER, `ssid` TEXT, `ip_address` TEXT, `connection_speed` INTEGER, `connected_wifi_band_frequency` INTEGER, `signal_strenth_dbm` INTEGER, `locationTimeStamp` INTEGER, `locationProvider` TEXT, `accuracy` REAL, `dataRx` INTEGER, `dataTx` INTEGER, `transmitted` INTEGER NOT NULL, `timeZoneOffset` INTEGER, `latitude` REAL, `longitude` REAL, `permissions` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_wifi_tbl_time_stamp` ON `wifi_tbl` (`time_stamp`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `diagnostics_tbl` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `startTest` INTEGER NOT NULL, `endTest` INTEGER NOT NULL, `serverIP` TEXT, `timeOffset` INTEGER, `connectionType` INTEGER, `uploadDataUsed` INTEGER, `downloadDataUsed` INTEGER, `transmitted` INTEGER NOT NULL, `cellID` TEXT, `cellIDChanged` INTEGER, `mnsiID` INTEGER, `testTrigger` INTEGER, `testType` INTEGER, `wifiNetworkInfoID` INTEGER, `uploadAlgorithm` INTEGER, `downloadAlgorithm` INTEGER, `latencyAlgorithm` INTEGER, `latencyMin` REAL, `latencyMax` REAL, `latencyAvg` REAL, `latencyDev` REAL, `jitter` REAL, `uploadMin` REAL, `uploadMax` REAL, `uploadAvg` REAL, `downloadMin` REAL, `downloadMax` REAL, `downloadAvg` REAL, `locationDiff` REAL, `permissions` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `mnsi_tbl` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `transmitted` INTEGER NOT NULL, `timeStamp` INTEGER, `timeZone` TEXT, `phoneType` TEXT, `networkTypeString` TEXT, `dbm` INTEGER, `asu` INTEGER, `ecio` INTEGER, `rsrp` INTEGER, `rsrq` INTEGER, `bitErrorRate` INTEGER, `wcdmaBitErrorRate` INTEGER, `locationTimeStamp` INTEGER, `locationProvider` TEXT, `accuracy` REAL, `networkOperatorName` TEXT, `networkCountryIso` TEXT, `networkMnc` INTEGER, `networkMcc` INTEGER, `simOperatorName` TEXT, `simCountryIso` TEXT, `simMnc` INTEGER, `simMcc` INTEGER, `simSlot` INTEGER, `isDataDefaultSim` INTEGER, `isPrimaryConnection` INTEGER, `resourcesMnc` INTEGER, `resourcesMcc` INTEGER, `registered` INTEGER, `lteSignalStrength` INTEGER, `lteRsrp` INTEGER, `lteRsrq` INTEGER, `lteRssnr` INTEGER, `lteRssi` INTEGER, `lteBand` TEXT, `lteCqi` INTEGER, `lteDbm` INTEGER, `lteAsu` INTEGER, `cdmaDbm` INTEGER, `cdmaAsu` INTEGER, `cdmaEcio` INTEGER, `evdoDbm` INTEGER, `evdoAsu` INTEGER, `evdoEcio` INTEGER, `evdoSnr` INTEGER, `barometric` REAL, `gsmDbm` INTEGER, `gsmAsu` INTEGER, `gsmBitError` INTEGER, `tdscdmaDbm` INTEGER, `tdscdmaAsu` INTEGER, `gpsAvailable` INTEGER, `lteCi` INTEGER, `ltePci` INTEGER, `lteTac` INTEGER, `wcdmaDbm` INTEGER, `wcdmaAsu` INTEGER, `wcdmaCid` INTEGER, `wcdmaLac` INTEGER, `wcdmaPsc` INTEGER, `roaming` INTEGER, `networkType` INTEGER NOT NULL, `dataNetworkType` INTEGER NOT NULL, `voiceNetworkType` INTEGER NOT NULL, `lteTimingAdvance` INTEGER, `dataRX` INTEGER, `dataTX` INTEGER, `nrAsuLevel` INTEGER, `nrCsiRsrp` INTEGER, `nrCsiRsrq` INTEGER, `nrCsiSinr` INTEGER, `nrDbm` INTEGER, `nrLevel` INTEGER, `nrSsRsrp` INTEGER, `nrSsRsrq` INTEGER, `nrSsSinr` INTEGER, `completeness` INTEGER, `nrBand` TEXT, `permissions` TEXT, `celltowerInfoTimestamp` INTEGER, `baseStationId` INTEGER, `baseStationLatitude` REAL, `baseStationLongitude` REAL, `networkId` INTEGER, `systemId` INTEGER, `cid` INTEGER, `lac` INTEGER, `gsmArfcn` INTEGER, `gsmBsic` INTEGER, `lteEarfcn` INTEGER, `lteBandwidth` INTEGER, `psc` INTEGER, `wcdmaUarfcn` INTEGER, `nrNci` INTEGER, `nrArfcn` INTEGER, `nrPci` INTEGER, `nrTac` INTEGER, `timeZoneOffset` INTEGER, `secondaryNrNci` INTEGER, `isUsingCarrierAggregation` INTEGER, `is5GConnected` INTEGER, `latitude` REAL, `longitude` REAL, `indoorOutdoorWeight` REAL, `overrideNetworkType` INTEGER)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_mnsi_tbl_timeStamp` ON `mnsi_tbl` (`timeStamp`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `no_network_signal_tbl` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `transmitted` INTEGER NOT NULL, `phoneType` TEXT, `timeZone` TEXT, `simOperatorName` TEXT, `locationTimeStamp` INTEGER, `locationProvider` TEXT, `accuracy` REAL, `simMnc` INTEGER, `simMcc` INTEGER, `simSlot` INTEGER, `timeStamp` INTEGER, `timeZoneId` TEXT, `timeZoneOffset` INTEGER, `latitude` REAL, `longitude` REAL, `permissions` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_no_network_signal_tbl_timeStamp` ON `no_network_signal_tbl` (`timeStamp`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `bad_signals_tbl` (`date` TEXT NOT NULL, `twoCount` INTEGER NOT NULL, `threeCount` INTEGER NOT NULL, `fourCount` INTEGER NOT NULL, `fiveCount` INTEGER NOT NULL, `noNetworkCount` INTEGER NOT NULL, PRIMARY KEY(`date`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `crash_tbl` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `time_stamp` INTEGER, `stack_trace` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_crash_tbl_time_stamp` ON `crash_tbl` (`time_stamp`)");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'dfdc5a5c98bcb52df44c9e7e6fa26dcc')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `CounterInt`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `CounterLong`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `location_tbl`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `wifi_tbl`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `diagnostics_tbl`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `mnsi_tbl`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `no_network_signal_tbl`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `bad_signals_tbl`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `crash_tbl`");
                if (SDKDatabase_Impl.this.mCallbacks != null) {
                    int size = SDKDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) SDKDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (SDKDatabase_Impl.this.mCallbacks != null) {
                    int size = SDKDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) SDKDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = SDKDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                SDKDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (SDKDatabase_Impl.this.mCallbacks != null) {
                    int size = SDKDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) SDKDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(4);
                hashMap.put("counterId", new TableInfo.Column("counterId", AdPreferences.TYPE_TEXT, true, 1, (String) null, 1));
                hashMap.put("counterValue", new TableInfo.Column("counterValue", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("date", new TableInfo.Column("date", AdPreferences.TYPE_TEXT, true, 2, (String) null, 1));
                hashMap.put("transmitted", new TableInfo.Column("transmitted", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("CounterInt", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "CounterInt");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "CounterInt(com.m2catalyst.m2sdk.database.entities.CounterInt).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(4);
                hashMap2.put("counterId", new TableInfo.Column("counterId", AdPreferences.TYPE_TEXT, true, 1, (String) null, 1));
                hashMap2.put("counterValue", new TableInfo.Column("counterValue", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("date", new TableInfo.Column("date", AdPreferences.TYPE_TEXT, true, 2, (String) null, 1));
                hashMap2.put("transmitted", new TableInfo.Column("transmitted", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("CounterLong", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "CounterLong");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "CounterLong(com.m2catalyst.m2sdk.database.entities.CounterLong).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(15);
                hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap3.put("altitude", new TableInfo.Column("altitude", "REAL", false, 0, (String) null, 1));
                hashMap3.put("longitude", new TableInfo.Column("longitude", "REAL", false, 0, (String) null, 1));
                hashMap3.put("latitude", new TableInfo.Column("latitude", "REAL", false, 0, (String) null, 1));
                hashMap3.put("indoorOutdoorWeight", new TableInfo.Column("indoorOutdoorWeight", "REAL", false, 0, (String) null, 1));
                hashMap3.put("accuracy", new TableInfo.Column("accuracy", "REAL", false, 0, (String) null, 1));
                hashMap3.put("bearing", new TableInfo.Column("bearing", "REAL", false, 0, (String) null, 1));
                hashMap3.put("speed", new TableInfo.Column("speed", "REAL", false, 0, (String) null, 1));
                hashMap3.put("timeZoneOffset", new TableInfo.Column("timeZoneOffset", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("timeZoneId", new TableInfo.Column("timeZoneId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap3.put("timeStamp", new TableInfo.Column("timeStamp", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("transmitted", new TableInfo.Column("transmitted", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put(IronSourceConstants.EVENTS_PROVIDER, new TableInfo.Column(IronSourceConstants.EVENTS_PROVIDER, AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap3.put("barometric", new TableInfo.Column("barometric", "REAL", false, 0, (String) null, 1));
                hashMap3.put("permissions", new TableInfo.Column("permissions", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                Object obj = "date";
                Object obj2 = "indoorOutdoorWeight";
                String str = "timeStamp";
                Object obj3 = "permissions";
                hashSet2.add(new TableInfo.Index("index_location_tbl_timeStamp", true, Arrays.asList(new String[]{"timeStamp"}), Arrays.asList(new String[]{"ASC"})));
                TableInfo tableInfo3 = new TableInfo(SDKDatabaseKt.LOCATION_TBL, hashMap3, hashSet, hashSet2);
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, SDKDatabaseKt.LOCATION_TBL);
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "location_tbl(com.m2catalyst.m2sdk.database.entities.LocationEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(17);
                hashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap4.put("time_stamp", new TableInfo.Column("time_stamp", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("ssid", new TableInfo.Column("ssid", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap4.put("ip_address", new TableInfo.Column("ip_address", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap4.put("connection_speed", new TableInfo.Column("connection_speed", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("connected_wifi_band_frequency", new TableInfo.Column("connected_wifi_band_frequency", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("signal_strenth_dbm", new TableInfo.Column("signal_strenth_dbm", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("locationTimeStamp", new TableInfo.Column("locationTimeStamp", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("locationProvider", new TableInfo.Column("locationProvider", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap4.put("accuracy", new TableInfo.Column("accuracy", "REAL", false, 0, (String) null, 1));
                hashMap4.put("dataRx", new TableInfo.Column("dataRx", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("dataTx", new TableInfo.Column("dataTx", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("transmitted", new TableInfo.Column("transmitted", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("timeZoneOffset", new TableInfo.Column("timeZoneOffset", "INTEGER", false, 0, (String) null, 1));
                hashMap4.put("latitude", new TableInfo.Column("latitude", "REAL", false, 0, (String) null, 1));
                hashMap4.put("longitude", new TableInfo.Column("longitude", "REAL", false, 0, (String) null, 1));
                Object obj4 = obj3;
                hashMap4.put(obj4, new TableInfo.Column("permissions", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(1);
                String str2 = "time_stamp";
                Object obj5 = "longitude";
                Object obj6 = "latitude";
                Object obj7 = "timeZoneOffset";
                hashSet4.add(new TableInfo.Index("index_wifi_tbl_time_stamp", true, Arrays.asList(new String[]{"time_stamp"}), Arrays.asList(new String[]{"ASC"})));
                TableInfo tableInfo4 = new TableInfo(SDKDatabaseKt.WIFI_TBL, hashMap4, hashSet3, hashSet4);
                TableInfo read4 = TableInfo.read(supportSQLiteDatabase2, SDKDatabaseKt.WIFI_TBL);
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "wifi_tbl(com.m2catalyst.m2sdk.database.entities.WifiEntity).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                HashMap hashMap5 = new HashMap(31);
                hashMap5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap5.put("startTest", new TableInfo.Column("startTest", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("endTest", new TableInfo.Column("endTest", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("serverIP", new TableInfo.Column("serverIP", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap5.put("timeOffset", new TableInfo.Column("timeOffset", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("connectionType", new TableInfo.Column("connectionType", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("uploadDataUsed", new TableInfo.Column("uploadDataUsed", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("downloadDataUsed", new TableInfo.Column("downloadDataUsed", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("transmitted", new TableInfo.Column("transmitted", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("cellID", new TableInfo.Column("cellID", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap5.put("cellIDChanged", new TableInfo.Column("cellIDChanged", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("mnsiID", new TableInfo.Column("mnsiID", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("testTrigger", new TableInfo.Column("testTrigger", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("testType", new TableInfo.Column("testType", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("wifiNetworkInfoID", new TableInfo.Column("wifiNetworkInfoID", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("uploadAlgorithm", new TableInfo.Column("uploadAlgorithm", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("downloadAlgorithm", new TableInfo.Column("downloadAlgorithm", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("latencyAlgorithm", new TableInfo.Column("latencyAlgorithm", "INTEGER", false, 0, (String) null, 1));
                hashMap5.put("latencyMin", new TableInfo.Column("latencyMin", "REAL", false, 0, (String) null, 1));
                hashMap5.put("latencyMax", new TableInfo.Column("latencyMax", "REAL", false, 0, (String) null, 1));
                hashMap5.put("latencyAvg", new TableInfo.Column("latencyAvg", "REAL", false, 0, (String) null, 1));
                hashMap5.put("latencyDev", new TableInfo.Column("latencyDev", "REAL", false, 0, (String) null, 1));
                hashMap5.put("jitter", new TableInfo.Column("jitter", "REAL", false, 0, (String) null, 1));
                hashMap5.put("uploadMin", new TableInfo.Column("uploadMin", "REAL", false, 0, (String) null, 1));
                hashMap5.put("uploadMax", new TableInfo.Column("uploadMax", "REAL", false, 0, (String) null, 1));
                hashMap5.put("uploadAvg", new TableInfo.Column("uploadAvg", "REAL", false, 0, (String) null, 1));
                hashMap5.put("downloadMin", new TableInfo.Column("downloadMin", "REAL", false, 0, (String) null, 1));
                hashMap5.put("downloadMax", new TableInfo.Column("downloadMax", "REAL", false, 0, (String) null, 1));
                hashMap5.put("downloadAvg", new TableInfo.Column("downloadAvg", "REAL", false, 0, (String) null, 1));
                hashMap5.put("locationDiff", new TableInfo.Column("locationDiff", "REAL", false, 0, (String) null, 1));
                hashMap5.put(obj4, new TableInfo.Column("permissions", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                TableInfo tableInfo5 = new TableInfo(SDKDatabaseKt.NETWORK_DIAGNOSTICS_TBL, hashMap5, new HashSet(0), new HashSet(0));
                TableInfo read5 = TableInfo.read(supportSQLiteDatabase2, SDKDatabaseKt.NETWORK_DIAGNOSTICS_TBL);
                if (!tableInfo5.equals(read5)) {
                    return new RoomOpenHelper.ValidationResult(false, "diagnostics_tbl(com.m2catalyst.m2sdk.database.entities.NetworkDiagnosticsEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                }
                HashMap hashMap6 = new HashMap(106);
                hashMap6.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap6.put("transmitted", new TableInfo.Column("transmitted", "INTEGER", true, 0, (String) null, 1));
                String str3 = str;
                hashMap6.put(str3, new TableInfo.Column("timeStamp", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("timeZone", new TableInfo.Column("timeZone", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap6.put("phoneType", new TableInfo.Column("phoneType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap6.put("networkTypeString", new TableInfo.Column("networkTypeString", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap6.put("dbm", new TableInfo.Column("dbm", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("asu", new TableInfo.Column("asu", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("ecio", new TableInfo.Column("ecio", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("rsrp", new TableInfo.Column("rsrp", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("rsrq", new TableInfo.Column("rsrq", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("bitErrorRate", new TableInfo.Column("bitErrorRate", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("wcdmaBitErrorRate", new TableInfo.Column("wcdmaBitErrorRate", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("locationTimeStamp", new TableInfo.Column("locationTimeStamp", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("locationProvider", new TableInfo.Column("locationProvider", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap6.put("accuracy", new TableInfo.Column("accuracy", "REAL", false, 0, (String) null, 1));
                hashMap6.put("networkOperatorName", new TableInfo.Column("networkOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap6.put("networkCountryIso", new TableInfo.Column("networkCountryIso", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap6.put("networkMnc", new TableInfo.Column("networkMnc", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("networkMcc", new TableInfo.Column("networkMcc", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("simOperatorName", new TableInfo.Column("simOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap6.put("simCountryIso", new TableInfo.Column("simCountryIso", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap6.put("simMnc", new TableInfo.Column("simMnc", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("simMcc", new TableInfo.Column("simMcc", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("simSlot", new TableInfo.Column("simSlot", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("isDataDefaultSim", new TableInfo.Column("isDataDefaultSim", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("isPrimaryConnection", new TableInfo.Column("isPrimaryConnection", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("resourcesMnc", new TableInfo.Column("resourcesMnc", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("resourcesMcc", new TableInfo.Column("resourcesMcc", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("registered", new TableInfo.Column("registered", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("lteSignalStrength", new TableInfo.Column("lteSignalStrength", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("lteRsrp", new TableInfo.Column("lteRsrp", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("lteRsrq", new TableInfo.Column("lteRsrq", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("lteRssnr", new TableInfo.Column("lteRssnr", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("lteRssi", new TableInfo.Column("lteRssi", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("lteBand", new TableInfo.Column("lteBand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap6.put("lteCqi", new TableInfo.Column("lteCqi", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("lteDbm", new TableInfo.Column("lteDbm", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("lteAsu", new TableInfo.Column("lteAsu", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("cdmaDbm", new TableInfo.Column("cdmaDbm", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("cdmaAsu", new TableInfo.Column("cdmaAsu", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("cdmaEcio", new TableInfo.Column("cdmaEcio", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("evdoDbm", new TableInfo.Column("evdoDbm", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("evdoAsu", new TableInfo.Column("evdoAsu", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("evdoEcio", new TableInfo.Column("evdoEcio", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("evdoSnr", new TableInfo.Column("evdoSnr", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("barometric", new TableInfo.Column("barometric", "REAL", false, 0, (String) null, 1));
                hashMap6.put("gsmDbm", new TableInfo.Column("gsmDbm", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("gsmAsu", new TableInfo.Column("gsmAsu", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("gsmBitError", new TableInfo.Column("gsmBitError", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("tdscdmaDbm", new TableInfo.Column("tdscdmaDbm", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("tdscdmaAsu", new TableInfo.Column("tdscdmaAsu", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("gpsAvailable", new TableInfo.Column("gpsAvailable", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("lteCi", new TableInfo.Column("lteCi", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("ltePci", new TableInfo.Column("ltePci", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("lteTac", new TableInfo.Column("lteTac", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("wcdmaDbm", new TableInfo.Column("wcdmaDbm", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("wcdmaAsu", new TableInfo.Column("wcdmaAsu", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("wcdmaCid", new TableInfo.Column("wcdmaCid", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("wcdmaLac", new TableInfo.Column("wcdmaLac", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("wcdmaPsc", new TableInfo.Column("wcdmaPsc", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("roaming", new TableInfo.Column("roaming", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("networkType", new TableInfo.Column("networkType", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("dataNetworkType", new TableInfo.Column("dataNetworkType", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("voiceNetworkType", new TableInfo.Column("voiceNetworkType", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("lteTimingAdvance", new TableInfo.Column("lteTimingAdvance", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("dataRX", new TableInfo.Column("dataRX", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("dataTX", new TableInfo.Column("dataTX", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrAsuLevel", new TableInfo.Column("nrAsuLevel", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrCsiRsrp", new TableInfo.Column("nrCsiRsrp", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrCsiRsrq", new TableInfo.Column("nrCsiRsrq", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrCsiSinr", new TableInfo.Column("nrCsiSinr", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrDbm", new TableInfo.Column("nrDbm", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrLevel", new TableInfo.Column("nrLevel", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrSsRsrp", new TableInfo.Column("nrSsRsrp", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrSsRsrq", new TableInfo.Column("nrSsRsrq", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrSsSinr", new TableInfo.Column("nrSsSinr", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("completeness", new TableInfo.Column("completeness", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrBand", new TableInfo.Column("nrBand", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap6.put(obj4, new TableInfo.Column("permissions", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap6.put("celltowerInfoTimestamp", new TableInfo.Column("celltowerInfoTimestamp", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("baseStationId", new TableInfo.Column("baseStationId", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("baseStationLatitude", new TableInfo.Column("baseStationLatitude", "REAL", false, 0, (String) null, 1));
                hashMap6.put("baseStationLongitude", new TableInfo.Column("baseStationLongitude", "REAL", false, 0, (String) null, 1));
                hashMap6.put("networkId", new TableInfo.Column("networkId", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("systemId", new TableInfo.Column("systemId", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put(CmcdConfiguration.KEY_CONTENT_ID, new TableInfo.Column(CmcdConfiguration.KEY_CONTENT_ID, "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("lac", new TableInfo.Column("lac", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("gsmArfcn", new TableInfo.Column("gsmArfcn", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("gsmBsic", new TableInfo.Column("gsmBsic", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("lteEarfcn", new TableInfo.Column("lteEarfcn", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("lteBandwidth", new TableInfo.Column("lteBandwidth", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("psc", new TableInfo.Column("psc", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("wcdmaUarfcn", new TableInfo.Column("wcdmaUarfcn", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrNci", new TableInfo.Column("nrNci", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrArfcn", new TableInfo.Column("nrArfcn", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrPci", new TableInfo.Column("nrPci", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("nrTac", new TableInfo.Column("nrTac", "INTEGER", false, 0, (String) null, 1));
                Object obj8 = obj7;
                hashMap6.put(obj8, new TableInfo.Column("timeZoneOffset", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("secondaryNrNci", new TableInfo.Column("secondaryNrNci", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("isUsingCarrierAggregation", new TableInfo.Column("isUsingCarrierAggregation", "INTEGER", false, 0, (String) null, 1));
                hashMap6.put("is5GConnected", new TableInfo.Column("is5GConnected", "INTEGER", false, 0, (String) null, 1));
                Object obj9 = obj6;
                hashMap6.put(obj9, new TableInfo.Column("latitude", "REAL", false, 0, (String) null, 1));
                Object obj10 = obj5;
                hashMap6.put(obj10, new TableInfo.Column("longitude", "REAL", false, 0, (String) null, 1));
                hashMap6.put(obj2, new TableInfo.Column("indoorOutdoorWeight", "REAL", false, 0, (String) null, 1));
                hashMap6.put("overrideNetworkType", new TableInfo.Column("overrideNetworkType", "INTEGER", false, 0, (String) null, 1));
                HashSet hashSet5 = new HashSet(0);
                HashSet hashSet6 = new HashSet(1);
                Object obj11 = obj4;
                Object obj12 = obj10;
                Object obj13 = obj9;
                Object obj14 = obj8;
                hashSet6.add(new TableInfo.Index("index_mnsi_tbl_timeStamp", true, Arrays.asList(new String[]{str3}), Arrays.asList(new String[]{"ASC"})));
                TableInfo tableInfo6 = new TableInfo(SDKDatabaseKt.MNSI_TBL, hashMap6, hashSet5, hashSet6);
                TableInfo read6 = TableInfo.read(supportSQLiteDatabase2, SDKDatabaseKt.MNSI_TBL);
                if (!tableInfo6.equals(read6)) {
                    return new RoomOpenHelper.ValidationResult(false, "mnsi_tbl(com.m2catalyst.m2sdk.database.entities.MNSIEntity).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
                }
                HashMap hashMap7 = new HashMap(17);
                hashMap7.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap7.put("transmitted", new TableInfo.Column("transmitted", "INTEGER", true, 0, (String) null, 1));
                hashMap7.put("phoneType", new TableInfo.Column("phoneType", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap7.put("timeZone", new TableInfo.Column("timeZone", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap7.put("simOperatorName", new TableInfo.Column("simOperatorName", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap7.put("locationTimeStamp", new TableInfo.Column("locationTimeStamp", "INTEGER", false, 0, (String) null, 1));
                hashMap7.put("locationProvider", new TableInfo.Column("locationProvider", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap7.put("accuracy", new TableInfo.Column("accuracy", "REAL", false, 0, (String) null, 1));
                hashMap7.put("simMnc", new TableInfo.Column("simMnc", "INTEGER", false, 0, (String) null, 1));
                hashMap7.put("simMcc", new TableInfo.Column("simMcc", "INTEGER", false, 0, (String) null, 1));
                hashMap7.put("simSlot", new TableInfo.Column("simSlot", "INTEGER", false, 0, (String) null, 1));
                hashMap7.put(str3, new TableInfo.Column("timeStamp", "INTEGER", false, 0, (String) null, 1));
                hashMap7.put("timeZoneId", new TableInfo.Column("timeZoneId", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap7.put(obj14, new TableInfo.Column("timeZoneOffset", "INTEGER", false, 0, (String) null, 1));
                hashMap7.put(obj13, new TableInfo.Column("latitude", "REAL", false, 0, (String) null, 1));
                hashMap7.put(obj12, new TableInfo.Column("longitude", "REAL", false, 0, (String) null, 1));
                hashMap7.put(obj11, new TableInfo.Column("permissions", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                HashSet hashSet7 = new HashSet(0);
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new TableInfo.Index("index_no_network_signal_tbl_timeStamp", true, Arrays.asList(new String[]{str3}), Arrays.asList(new String[]{"ASC"})));
                TableInfo tableInfo7 = new TableInfo(SDKDatabaseKt.NO_SIGNALS_TBL, hashMap7, hashSet7, hashSet8);
                TableInfo read7 = TableInfo.read(supportSQLiteDatabase2, SDKDatabaseKt.NO_SIGNALS_TBL);
                if (!tableInfo7.equals(read7)) {
                    return new RoomOpenHelper.ValidationResult(false, "no_network_signal_tbl(com.m2catalyst.m2sdk.database.entities.NoSignalMNSIEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
                }
                HashMap hashMap8 = new HashMap(6);
                hashMap8.put(obj, new TableInfo.Column("date", AdPreferences.TYPE_TEXT, true, 1, (String) null, 1));
                hashMap8.put("twoCount", new TableInfo.Column("twoCount", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("threeCount", new TableInfo.Column("threeCount", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("fourCount", new TableInfo.Column("fourCount", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("fiveCount", new TableInfo.Column("fiveCount", "INTEGER", true, 0, (String) null, 1));
                hashMap8.put("noNetworkCount", new TableInfo.Column("noNetworkCount", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo8 = new TableInfo(SDKDatabaseKt.BAD_SIGNALS_TBL, hashMap8, new HashSet(0), new HashSet(0));
                TableInfo read8 = TableInfo.read(supportSQLiteDatabase2, SDKDatabaseKt.BAD_SIGNALS_TBL);
                if (!tableInfo8.equals(read8)) {
                    return new RoomOpenHelper.ValidationResult(false, "bad_signals_tbl(com.m2catalyst.m2sdk.database.entities.BadSignal).\n Expected:\n" + tableInfo8 + "\n Found:\n" + read8);
                }
                HashMap hashMap9 = new HashMap(3);
                hashMap9.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                String str4 = str2;
                hashMap9.put(str4, new TableInfo.Column("time_stamp", "INTEGER", false, 0, (String) null, 1));
                hashMap9.put("stack_trace", new TableInfo.Column("stack_trace", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                HashSet hashSet9 = new HashSet(0);
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new TableInfo.Index("index_crash_tbl_time_stamp", true, Arrays.asList(new String[]{str4}), Arrays.asList(new String[]{"ASC"})));
                TableInfo tableInfo9 = new TableInfo(SDKDatabaseKt.CRASH_TBL, hashMap9, hashSet9, hashSet10);
                TableInfo read9 = TableInfo.read(supportSQLiteDatabase2, SDKDatabaseKt.CRASH_TBL);
                if (tableInfo9.equals(read9)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "crash_tbl(com.m2catalyst.m2sdk.database.entities.CrashEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + read9);
            }
        }, "dfdc5a5c98bcb52df44c9e7e6fa26dcc", "57dda372d00d7e4adf96bf1ae4474ad0")).build());
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(CounterDao.class, CounterDao_Impl.getRequiredConverters());
        hashMap.put(LocationDao.class, LocationDao_Impl.getRequiredConverters());
        hashMap.put(NDTDao.class, NDTDao_Impl.getRequiredConverters());
        hashMap.put(WifiDao.class, WifiDao_Impl.getRequiredConverters());
        hashMap.put(MNSIDao.class, MNSIDao_Impl.getRequiredConverters());
        hashMap.put(NoSignalMNSIDao.class, NoSignalMNSIDao_Impl.getRequiredConverters());
        hashMap.put(BadSignalsDao.class, BadSignalsDao_Impl.getRequiredConverters());
        hashMap.put(CrashDao.class, CrashDao_Impl.getRequiredConverters());
        return hashMap;
    }

    public LocationDao locationLogDao() {
        LocationDao locationDao;
        if (this._locationDao != null) {
            return this._locationDao;
        }
        synchronized (this) {
            if (this._locationDao == null) {
                this._locationDao = new LocationDao_Impl(this);
            }
            locationDao = this._locationDao;
        }
        return locationDao;
    }

    public MNSIDao mobileSignalNetworkDao() {
        MNSIDao mNSIDao;
        if (this._mNSIDao != null) {
            return this._mNSIDao;
        }
        synchronized (this) {
            if (this._mNSIDao == null) {
                this._mNSIDao = new MNSIDao_Impl(this);
            }
            mNSIDao = this._mNSIDao;
        }
        return mNSIDao;
    }

    public NDTDao networkDiagnosticsDao() {
        NDTDao nDTDao;
        if (this._nDTDao != null) {
            return this._nDTDao;
        }
        synchronized (this) {
            if (this._nDTDao == null) {
                this._nDTDao = new NDTDao_Impl(this);
            }
            nDTDao = this._nDTDao;
        }
        return nDTDao;
    }

    public NoSignalMNSIDao noNetworkSignalDao() {
        NoSignalMNSIDao noSignalMNSIDao;
        if (this._noSignalMNSIDao != null) {
            return this._noSignalMNSIDao;
        }
        synchronized (this) {
            if (this._noSignalMNSIDao == null) {
                this._noSignalMNSIDao = new NoSignalMNSIDao_Impl(this);
            }
            noSignalMNSIDao = this._noSignalMNSIDao;
        }
        return noSignalMNSIDao;
    }

    public WifiDao wifiConnectivityDao() {
        WifiDao wifiDao;
        if (this._wifiDao != null) {
            return this._wifiDao;
        }
        synchronized (this) {
            if (this._wifiDao == null) {
                this._wifiDao = new WifiDao_Impl(this);
            }
            wifiDao = this._wifiDao;
        }
        return wifiDao;
    }
}
