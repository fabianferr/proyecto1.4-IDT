package com.m2catalyst.m2sdk.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.m2catalyst.m2sdk.database.daos.MNSIDao;
import com.m2catalyst.m2sdk.database.entities.MNSIEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class MNSIDao_Impl implements MNSIDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<MNSIEntity> __insertionAdapterOfMNSIEntity;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfDeleteMNSIEntries;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfResetMNSITable;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateMNSILocationEntryFromNetworkDiagnostics;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfUpdateMobileSignalRxTx;

    public MNSIDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfMNSIEntity = new EntityInsertionAdapter<MNSIEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `mnsi_tbl` (`id`,`transmitted`,`timeStamp`,`timeZone`,`phoneType`,`networkTypeString`,`dbm`,`asu`,`ecio`,`rsrp`,`rsrq`,`bitErrorRate`,`wcdmaBitErrorRate`,`locationTimeStamp`,`locationProvider`,`accuracy`,`networkOperatorName`,`networkCountryIso`,`networkMnc`,`networkMcc`,`simOperatorName`,`simCountryIso`,`simMnc`,`simMcc`,`simSlot`,`isDataDefaultSim`,`isPrimaryConnection`,`resourcesMnc`,`resourcesMcc`,`registered`,`lteSignalStrength`,`lteRsrp`,`lteRsrq`,`lteRssnr`,`lteRssi`,`lteBand`,`lteCqi`,`lteDbm`,`lteAsu`,`cdmaDbm`,`cdmaAsu`,`cdmaEcio`,`evdoDbm`,`evdoAsu`,`evdoEcio`,`evdoSnr`,`barometric`,`gsmDbm`,`gsmAsu`,`gsmBitError`,`tdscdmaDbm`,`tdscdmaAsu`,`gpsAvailable`,`lteCi`,`ltePci`,`lteTac`,`wcdmaDbm`,`wcdmaAsu`,`wcdmaCid`,`wcdmaLac`,`wcdmaPsc`,`roaming`,`networkType`,`dataNetworkType`,`voiceNetworkType`,`lteTimingAdvance`,`dataRX`,`dataTX`,`nrAsuLevel`,`nrCsiRsrp`,`nrCsiRsrq`,`nrCsiSinr`,`nrDbm`,`nrLevel`,`nrSsRsrp`,`nrSsRsrq`,`nrSsSinr`,`completeness`,`nrBand`,`permissions`,`celltowerInfoTimestamp`,`baseStationId`,`baseStationLatitude`,`baseStationLongitude`,`networkId`,`systemId`,`cid`,`lac`,`gsmArfcn`,`gsmBsic`,`lteEarfcn`,`lteBandwidth`,`psc`,`wcdmaUarfcn`,`nrNci`,`nrArfcn`,`nrPci`,`nrTac`,`timeZoneOffset`,`secondaryNrNci`,`isUsingCarrierAggregation`,`is5GConnected`,`latitude`,`longitude`,`indoorOutdoorWeight`,`overrideNetworkType`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, MNSIEntity mNSIEntity) {
                supportSQLiteStatement.bindLong(1, (long) mNSIEntity.getId());
                supportSQLiteStatement.bindLong(2, (long) mNSIEntity.getTransmitted());
                if (mNSIEntity.getTimeStamp() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindLong(3, mNSIEntity.getTimeStamp().longValue());
                }
                if (mNSIEntity.getTimeZone() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, mNSIEntity.getTimeZone());
                }
                if (mNSIEntity.getPhoneType() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, mNSIEntity.getPhoneType());
                }
                if (mNSIEntity.getNetworkTypeString() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, mNSIEntity.getNetworkTypeString());
                }
                if (mNSIEntity.getDbm() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, (long) mNSIEntity.getDbm().intValue());
                }
                if (mNSIEntity.getAsu() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, (long) mNSIEntity.getAsu().intValue());
                }
                if (mNSIEntity.getEcio() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindLong(9, (long) mNSIEntity.getEcio().intValue());
                }
                if (mNSIEntity.getRsrp() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindLong(10, (long) mNSIEntity.getRsrp().intValue());
                }
                if (mNSIEntity.getRsrq() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, (long) mNSIEntity.getRsrq().intValue());
                }
                if (mNSIEntity.getBitErrorRate() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, (long) mNSIEntity.getBitErrorRate().intValue());
                }
                if (mNSIEntity.getWcdmaBitErrorRate() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindLong(13, (long) mNSIEntity.getWcdmaBitErrorRate().intValue());
                }
                if (mNSIEntity.getLocationTimeStamp() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindLong(14, mNSIEntity.getLocationTimeStamp().longValue());
                }
                if (mNSIEntity.getLocationProvider() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, mNSIEntity.getLocationProvider());
                }
                if (mNSIEntity.getAccuracy() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindDouble(16, (double) mNSIEntity.getAccuracy().floatValue());
                }
                if (mNSIEntity.getNetworkOperatorName() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, mNSIEntity.getNetworkOperatorName());
                }
                if (mNSIEntity.getNetworkCountryIso() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, mNSIEntity.getNetworkCountryIso());
                }
                if (mNSIEntity.getNetworkMnc() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindLong(19, (long) mNSIEntity.getNetworkMnc().intValue());
                }
                if (mNSIEntity.getNetworkMcc() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindLong(20, (long) mNSIEntity.getNetworkMcc().intValue());
                }
                if (mNSIEntity.getSimOperatorName() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, mNSIEntity.getSimOperatorName());
                }
                if (mNSIEntity.getSimCountryIso() == null) {
                    supportSQLiteStatement.bindNull(22);
                } else {
                    supportSQLiteStatement.bindString(22, mNSIEntity.getSimCountryIso());
                }
                if (mNSIEntity.getSimMnc() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindLong(23, (long) mNSIEntity.getSimMnc().intValue());
                }
                if (mNSIEntity.getSimMcc() == null) {
                    supportSQLiteStatement.bindNull(24);
                } else {
                    supportSQLiteStatement.bindLong(24, (long) mNSIEntity.getSimMcc().intValue());
                }
                if (mNSIEntity.getSimSlot() == null) {
                    supportSQLiteStatement.bindNull(25);
                } else {
                    supportSQLiteStatement.bindLong(25, (long) mNSIEntity.getSimSlot().intValue());
                }
                if (mNSIEntity.isDataDefaultSim() == null) {
                    supportSQLiteStatement.bindNull(26);
                } else {
                    supportSQLiteStatement.bindLong(26, (long) mNSIEntity.isDataDefaultSim().intValue());
                }
                Integer valueOf = mNSIEntity.isPrimaryConnection() == null ? null : Integer.valueOf(mNSIEntity.isPrimaryConnection().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    supportSQLiteStatement.bindNull(27);
                } else {
                    supportSQLiteStatement.bindLong(27, (long) valueOf.intValue());
                }
                if (mNSIEntity.getResourcesMnc() == null) {
                    supportSQLiteStatement.bindNull(28);
                } else {
                    supportSQLiteStatement.bindLong(28, (long) mNSIEntity.getResourcesMnc().intValue());
                }
                if (mNSIEntity.getResourcesMcc() == null) {
                    supportSQLiteStatement.bindNull(29);
                } else {
                    supportSQLiteStatement.bindLong(29, (long) mNSIEntity.getResourcesMcc().intValue());
                }
                if (mNSIEntity.getRegistered() == null) {
                    supportSQLiteStatement.bindNull(30);
                } else {
                    supportSQLiteStatement.bindLong(30, (long) mNSIEntity.getRegistered().intValue());
                }
                if (mNSIEntity.getLteSignalStrength() == null) {
                    supportSQLiteStatement.bindNull(31);
                } else {
                    supportSQLiteStatement.bindLong(31, (long) mNSIEntity.getLteSignalStrength().intValue());
                }
                if (mNSIEntity.getLteRsrp() == null) {
                    supportSQLiteStatement.bindNull(32);
                } else {
                    supportSQLiteStatement.bindLong(32, (long) mNSIEntity.getLteRsrp().intValue());
                }
                if (mNSIEntity.getLteRsrq() == null) {
                    supportSQLiteStatement.bindNull(33);
                } else {
                    supportSQLiteStatement.bindLong(33, (long) mNSIEntity.getLteRsrq().intValue());
                }
                if (mNSIEntity.getLteRssnr() == null) {
                    supportSQLiteStatement.bindNull(34);
                } else {
                    supportSQLiteStatement.bindLong(34, (long) mNSIEntity.getLteRssnr().intValue());
                }
                if (mNSIEntity.getLteRssi() == null) {
                    supportSQLiteStatement.bindNull(35);
                } else {
                    supportSQLiteStatement.bindLong(35, (long) mNSIEntity.getLteRssi().intValue());
                }
                if (mNSIEntity.getLteBand() == null) {
                    supportSQLiteStatement.bindNull(36);
                } else {
                    supportSQLiteStatement.bindString(36, mNSIEntity.getLteBand());
                }
                if (mNSIEntity.getLteCqi() == null) {
                    supportSQLiteStatement.bindNull(37);
                } else {
                    supportSQLiteStatement.bindLong(37, (long) mNSIEntity.getLteCqi().intValue());
                }
                if (mNSIEntity.getLteDbm() == null) {
                    supportSQLiteStatement.bindNull(38);
                } else {
                    supportSQLiteStatement.bindLong(38, (long) mNSIEntity.getLteDbm().intValue());
                }
                if (mNSIEntity.getLteAsu() == null) {
                    supportSQLiteStatement.bindNull(39);
                } else {
                    supportSQLiteStatement.bindLong(39, (long) mNSIEntity.getLteAsu().intValue());
                }
                if (mNSIEntity.getCdmaDbm() == null) {
                    supportSQLiteStatement.bindNull(40);
                } else {
                    supportSQLiteStatement.bindLong(40, (long) mNSIEntity.getCdmaDbm().intValue());
                }
                if (mNSIEntity.getCdmaAsu() == null) {
                    supportSQLiteStatement.bindNull(41);
                } else {
                    supportSQLiteStatement.bindLong(41, (long) mNSIEntity.getCdmaAsu().intValue());
                }
                if (mNSIEntity.getCdmaEcio() == null) {
                    supportSQLiteStatement.bindNull(42);
                } else {
                    supportSQLiteStatement.bindLong(42, (long) mNSIEntity.getCdmaEcio().intValue());
                }
                if (mNSIEntity.getEvdoDbm() == null) {
                    supportSQLiteStatement.bindNull(43);
                } else {
                    supportSQLiteStatement.bindLong(43, (long) mNSIEntity.getEvdoDbm().intValue());
                }
                if (mNSIEntity.getEvdoAsu() == null) {
                    supportSQLiteStatement.bindNull(44);
                } else {
                    supportSQLiteStatement.bindLong(44, (long) mNSIEntity.getEvdoAsu().intValue());
                }
                if (mNSIEntity.getEvdoEcio() == null) {
                    supportSQLiteStatement.bindNull(45);
                } else {
                    supportSQLiteStatement.bindLong(45, (long) mNSIEntity.getEvdoEcio().intValue());
                }
                if (mNSIEntity.getEvdoSnr() == null) {
                    supportSQLiteStatement.bindNull(46);
                } else {
                    supportSQLiteStatement.bindLong(46, (long) mNSIEntity.getEvdoSnr().intValue());
                }
                if (mNSIEntity.getBarometric() == null) {
                    supportSQLiteStatement.bindNull(47);
                } else {
                    supportSQLiteStatement.bindDouble(47, (double) mNSIEntity.getBarometric().floatValue());
                }
                if (mNSIEntity.getGsmDbm() == null) {
                    supportSQLiteStatement.bindNull(48);
                } else {
                    supportSQLiteStatement.bindLong(48, (long) mNSIEntity.getGsmDbm().intValue());
                }
                if (mNSIEntity.getGsmAsu() == null) {
                    supportSQLiteStatement.bindNull(49);
                } else {
                    supportSQLiteStatement.bindLong(49, (long) mNSIEntity.getGsmAsu().intValue());
                }
                if (mNSIEntity.getGsmBitError() == null) {
                    supportSQLiteStatement.bindNull(50);
                } else {
                    supportSQLiteStatement.bindLong(50, (long) mNSIEntity.getGsmBitError().intValue());
                }
                if (mNSIEntity.getTdscdmaDbm() == null) {
                    supportSQLiteStatement.bindNull(51);
                } else {
                    supportSQLiteStatement.bindLong(51, (long) mNSIEntity.getTdscdmaDbm().intValue());
                }
                if (mNSIEntity.getTdscdmaAsu() == null) {
                    supportSQLiteStatement.bindNull(52);
                } else {
                    supportSQLiteStatement.bindLong(52, (long) mNSIEntity.getTdscdmaAsu().intValue());
                }
                if (mNSIEntity.getGpsAvailable() == null) {
                    supportSQLiteStatement.bindNull(53);
                } else {
                    supportSQLiteStatement.bindLong(53, (long) mNSIEntity.getGpsAvailable().intValue());
                }
                if (mNSIEntity.getLteCi() == null) {
                    supportSQLiteStatement.bindNull(54);
                } else {
                    supportSQLiteStatement.bindLong(54, (long) mNSIEntity.getLteCi().intValue());
                }
                if (mNSIEntity.getLtePci() == null) {
                    supportSQLiteStatement.bindNull(55);
                } else {
                    supportSQLiteStatement.bindLong(55, (long) mNSIEntity.getLtePci().intValue());
                }
                if (mNSIEntity.getLteTac() == null) {
                    supportSQLiteStatement.bindNull(56);
                } else {
                    supportSQLiteStatement.bindLong(56, (long) mNSIEntity.getLteTac().intValue());
                }
                if (mNSIEntity.getWcdmaDbm() == null) {
                    supportSQLiteStatement.bindNull(57);
                } else {
                    supportSQLiteStatement.bindLong(57, (long) mNSIEntity.getWcdmaDbm().intValue());
                }
                if (mNSIEntity.getWcdmaAsu() == null) {
                    supportSQLiteStatement.bindNull(58);
                } else {
                    supportSQLiteStatement.bindLong(58, (long) mNSIEntity.getWcdmaAsu().intValue());
                }
                if (mNSIEntity.getWcdmaCid() == null) {
                    supportSQLiteStatement.bindNull(59);
                } else {
                    supportSQLiteStatement.bindLong(59, (long) mNSIEntity.getWcdmaCid().intValue());
                }
                if (mNSIEntity.getWcdmaLac() == null) {
                    supportSQLiteStatement.bindNull(60);
                } else {
                    supportSQLiteStatement.bindLong(60, (long) mNSIEntity.getWcdmaLac().intValue());
                }
                if (mNSIEntity.getWcdmaPsc() == null) {
                    supportSQLiteStatement.bindNull(61);
                } else {
                    supportSQLiteStatement.bindLong(61, (long) mNSIEntity.getWcdmaPsc().intValue());
                }
                if (mNSIEntity.getRoaming() == null) {
                    supportSQLiteStatement.bindNull(62);
                } else {
                    supportSQLiteStatement.bindLong(62, (long) mNSIEntity.getRoaming().intValue());
                }
                supportSQLiteStatement.bindLong(63, (long) mNSIEntity.getNetworkType());
                supportSQLiteStatement.bindLong(64, (long) mNSIEntity.getDataNetworkType());
                supportSQLiteStatement.bindLong(65, (long) mNSIEntity.getVoiceNetworkType());
                if (mNSIEntity.getLteTimingAdvance() == null) {
                    supportSQLiteStatement.bindNull(66);
                } else {
                    supportSQLiteStatement.bindLong(66, (long) mNSIEntity.getLteTimingAdvance().intValue());
                }
                if (mNSIEntity.getDataRX() == null) {
                    supportSQLiteStatement.bindNull(67);
                } else {
                    supportSQLiteStatement.bindLong(67, mNSIEntity.getDataRX().longValue());
                }
                if (mNSIEntity.getDataTX() == null) {
                    supportSQLiteStatement.bindNull(68);
                } else {
                    supportSQLiteStatement.bindLong(68, mNSIEntity.getDataTX().longValue());
                }
                if (mNSIEntity.getNrAsuLevel() == null) {
                    supportSQLiteStatement.bindNull(69);
                } else {
                    supportSQLiteStatement.bindLong(69, (long) mNSIEntity.getNrAsuLevel().intValue());
                }
                if (mNSIEntity.getNrCsiRsrp() == null) {
                    supportSQLiteStatement.bindNull(70);
                } else {
                    supportSQLiteStatement.bindLong(70, (long) mNSIEntity.getNrCsiRsrp().intValue());
                }
                if (mNSIEntity.getNrCsiRsrq() == null) {
                    supportSQLiteStatement.bindNull(71);
                } else {
                    supportSQLiteStatement.bindLong(71, (long) mNSIEntity.getNrCsiRsrq().intValue());
                }
                if (mNSIEntity.getNrCsiSinr() == null) {
                    supportSQLiteStatement.bindNull(72);
                } else {
                    supportSQLiteStatement.bindLong(72, (long) mNSIEntity.getNrCsiSinr().intValue());
                }
                if (mNSIEntity.getNrDbm() == null) {
                    supportSQLiteStatement.bindNull(73);
                } else {
                    supportSQLiteStatement.bindLong(73, (long) mNSIEntity.getNrDbm().intValue());
                }
                if (mNSIEntity.getNrLevel() == null) {
                    supportSQLiteStatement.bindNull(74);
                } else {
                    supportSQLiteStatement.bindLong(74, (long) mNSIEntity.getNrLevel().intValue());
                }
                if (mNSIEntity.getNrSsRsrp() == null) {
                    supportSQLiteStatement.bindNull(75);
                } else {
                    supportSQLiteStatement.bindLong(75, (long) mNSIEntity.getNrSsRsrp().intValue());
                }
                if (mNSIEntity.getNrSsRsrq() == null) {
                    supportSQLiteStatement.bindNull(76);
                } else {
                    supportSQLiteStatement.bindLong(76, (long) mNSIEntity.getNrSsRsrq().intValue());
                }
                if (mNSIEntity.getNrSsSinr() == null) {
                    supportSQLiteStatement.bindNull(77);
                } else {
                    supportSQLiteStatement.bindLong(77, (long) mNSIEntity.getNrSsSinr().intValue());
                }
                if (mNSIEntity.getCompleteness() == null) {
                    supportSQLiteStatement.bindNull(78);
                } else {
                    supportSQLiteStatement.bindLong(78, (long) mNSIEntity.getCompleteness().intValue());
                }
                if (mNSIEntity.getNrBand() == null) {
                    supportSQLiteStatement.bindNull(79);
                } else {
                    supportSQLiteStatement.bindString(79, mNSIEntity.getNrBand());
                }
                if (mNSIEntity.getPermissions() == null) {
                    supportSQLiteStatement.bindNull(80);
                } else {
                    supportSQLiteStatement.bindString(80, mNSIEntity.getPermissions());
                }
                if (mNSIEntity.getCelltowerInfoTimestamp() == null) {
                    supportSQLiteStatement.bindNull(81);
                } else {
                    supportSQLiteStatement.bindLong(81, mNSIEntity.getCelltowerInfoTimestamp().longValue());
                }
                if (mNSIEntity.getBaseStationId() == null) {
                    supportSQLiteStatement.bindNull(82);
                } else {
                    supportSQLiteStatement.bindLong(82, (long) mNSIEntity.getBaseStationId().intValue());
                }
                if (mNSIEntity.getBaseStationLatitude() == null) {
                    supportSQLiteStatement.bindNull(83);
                } else {
                    supportSQLiteStatement.bindDouble(83, mNSIEntity.getBaseStationLatitude().doubleValue());
                }
                if (mNSIEntity.getBaseStationLongitude() == null) {
                    supportSQLiteStatement.bindNull(84);
                } else {
                    supportSQLiteStatement.bindDouble(84, mNSIEntity.getBaseStationLongitude().doubleValue());
                }
                if (mNSIEntity.getNetworkId() == null) {
                    supportSQLiteStatement.bindNull(85);
                } else {
                    supportSQLiteStatement.bindLong(85, (long) mNSIEntity.getNetworkId().intValue());
                }
                if (mNSIEntity.getSystemId() == null) {
                    supportSQLiteStatement.bindNull(86);
                } else {
                    supportSQLiteStatement.bindLong(86, (long) mNSIEntity.getSystemId().intValue());
                }
                if (mNSIEntity.getCid() == null) {
                    supportSQLiteStatement.bindNull(87);
                } else {
                    supportSQLiteStatement.bindLong(87, (long) mNSIEntity.getCid().intValue());
                }
                if (mNSIEntity.getLac() == null) {
                    supportSQLiteStatement.bindNull(88);
                } else {
                    supportSQLiteStatement.bindLong(88, (long) mNSIEntity.getLac().intValue());
                }
                if (mNSIEntity.getGsmArfcn() == null) {
                    supportSQLiteStatement.bindNull(89);
                } else {
                    supportSQLiteStatement.bindLong(89, (long) mNSIEntity.getGsmArfcn().intValue());
                }
                if (mNSIEntity.getGsmBsic() == null) {
                    supportSQLiteStatement.bindNull(90);
                } else {
                    supportSQLiteStatement.bindLong(90, (long) mNSIEntity.getGsmBsic().intValue());
                }
                if (mNSIEntity.getLteEarfcn() == null) {
                    supportSQLiteStatement.bindNull(91);
                } else {
                    supportSQLiteStatement.bindLong(91, (long) mNSIEntity.getLteEarfcn().intValue());
                }
                if (mNSIEntity.getLteBandwidth() == null) {
                    supportSQLiteStatement.bindNull(92);
                } else {
                    supportSQLiteStatement.bindLong(92, (long) mNSIEntity.getLteBandwidth().intValue());
                }
                if (mNSIEntity.getPsc() == null) {
                    supportSQLiteStatement.bindNull(93);
                } else {
                    supportSQLiteStatement.bindLong(93, (long) mNSIEntity.getPsc().intValue());
                }
                if (mNSIEntity.getWcdmaUarfcn() == null) {
                    supportSQLiteStatement.bindNull(94);
                } else {
                    supportSQLiteStatement.bindLong(94, (long) mNSIEntity.getWcdmaUarfcn().intValue());
                }
                if (mNSIEntity.getNrNci() == null) {
                    supportSQLiteStatement.bindNull(95);
                } else {
                    supportSQLiteStatement.bindLong(95, mNSIEntity.getNrNci().longValue());
                }
                if (mNSIEntity.getNrArfcn() == null) {
                    supportSQLiteStatement.bindNull(96);
                } else {
                    supportSQLiteStatement.bindLong(96, (long) mNSIEntity.getNrArfcn().intValue());
                }
                if (mNSIEntity.getNrPci() == null) {
                    supportSQLiteStatement.bindNull(97);
                } else {
                    supportSQLiteStatement.bindLong(97, (long) mNSIEntity.getNrPci().intValue());
                }
                if (mNSIEntity.getNrTac() == null) {
                    supportSQLiteStatement.bindNull(98);
                } else {
                    supportSQLiteStatement.bindLong(98, (long) mNSIEntity.getNrTac().intValue());
                }
                if (mNSIEntity.getTimeZoneOffset() == null) {
                    supportSQLiteStatement.bindNull(99);
                } else {
                    supportSQLiteStatement.bindLong(99, (long) mNSIEntity.getTimeZoneOffset().intValue());
                }
                if (mNSIEntity.getSecondaryNrNci() == null) {
                    supportSQLiteStatement.bindNull(100);
                } else {
                    supportSQLiteStatement.bindLong(100, mNSIEntity.getSecondaryNrNci().longValue());
                }
                if (mNSIEntity.getCarrierAgregationUsed() == null) {
                    supportSQLiteStatement.bindNull(101);
                } else {
                    supportSQLiteStatement.bindLong(101, (long) mNSIEntity.getCarrierAgregationUsed().intValue());
                }
                if (mNSIEntity.getConnectivityTo5G() == null) {
                    supportSQLiteStatement.bindNull(102);
                } else {
                    supportSQLiteStatement.bindLong(102, (long) mNSIEntity.getConnectivityTo5G().intValue());
                }
                if (mNSIEntity.getLatitude() == null) {
                    supportSQLiteStatement.bindNull(103);
                } else {
                    supportSQLiteStatement.bindDouble(103, mNSIEntity.getLatitude().doubleValue());
                }
                if (mNSIEntity.getLongitude() == null) {
                    supportSQLiteStatement.bindNull(104);
                } else {
                    supportSQLiteStatement.bindDouble(104, mNSIEntity.getLongitude().doubleValue());
                }
                if (mNSIEntity.getIndoorOutdoorWeight() == null) {
                    supportSQLiteStatement.bindNull(105);
                } else {
                    supportSQLiteStatement.bindDouble(105, mNSIEntity.getIndoorOutdoorWeight().doubleValue());
                }
                if (mNSIEntity.getOverrideNetworkType() == null) {
                    supportSQLiteStatement.bindNull(106);
                } else {
                    supportSQLiteStatement.bindLong(106, (long) mNSIEntity.getOverrideNetworkType().intValue());
                }
            }
        };
        this.__preparedStmtOfDeleteMNSIEntries = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM mnsi_tbl";
            }
        };
        this.__preparedStmtOfUpdateMobileSignalRxTx = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE mnsi_tbl SET dataRX = ?, dataTx = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfUpdateMNSILocationEntryFromNetworkDiagnostics = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE mnsi_tbl SET locationTimeStamp = ?, locationProvider = ?, latitude = ?, longitude = ?, accuracy = ?, indoorOutdoorWeight = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfResetMNSITable = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM sqlite_sequence WHERE name='mnsi_tbl'";
            }
        };
    }

    /* access modifiers changed from: private */
    public MNSIEntity __entityCursorConverter_comM2catalystM2sdkDatabaseEntitiesMNSIEntity(Cursor cursor) {
        Double d;
        Double d2;
        Double d3;
        Integer num;
        Integer num2;
        Long l;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Long l2;
        Integer num7;
        Integer num8;
        Integer num9;
        Integer num10;
        Integer num11;
        Integer num12;
        Integer num13;
        Integer num14;
        Integer num15;
        Integer num16;
        Double d4;
        Double d5;
        Integer num17;
        Long l3;
        String str;
        String str2;
        Integer num18;
        Integer num19;
        Integer num20;
        Integer num21;
        Integer num22;
        Integer num23;
        Integer num24;
        Integer num25;
        Integer num26;
        Integer num27;
        Long l4;
        Long l5;
        Integer num28;
        Integer num29;
        Integer num30;
        Integer num31;
        Integer num32;
        Integer num33;
        Integer num34;
        Integer num35;
        Integer num36;
        Integer num37;
        Integer num38;
        Integer num39;
        Integer num40;
        Integer num41;
        Integer num42;
        Integer num43;
        Float f;
        Integer num44;
        Integer num45;
        Integer num46;
        Integer num47;
        Integer num48;
        Integer num49;
        Integer num50;
        Integer num51;
        Integer num52;
        Integer num53;
        String str3;
        Integer num54;
        Integer num55;
        Integer num56;
        Integer num57;
        Integer num58;
        Integer num59;
        Integer num60;
        Integer num61;
        Integer num62;
        Boolean bool;
        Integer num63;
        Integer num64;
        Integer num65;
        Integer num66;
        String str4;
        String str5;
        Integer num67;
        Integer num68;
        String str6;
        String str7;
        Float f2;
        String str8;
        Long l6;
        Integer num69;
        Integer num70;
        Integer num71;
        Integer num72;
        Integer num73;
        Integer num74;
        Integer num75;
        String str9;
        String str10;
        String str11;
        Long l7;
        Cursor cursor2 = cursor;
        int columnIndex = cursor2.getColumnIndex("id");
        int columnIndex2 = cursor2.getColumnIndex("transmitted");
        int columnIndex3 = cursor2.getColumnIndex("timeStamp");
        int columnIndex4 = cursor2.getColumnIndex("timeZone");
        int columnIndex5 = cursor2.getColumnIndex("phoneType");
        int columnIndex6 = cursor2.getColumnIndex("networkTypeString");
        int columnIndex7 = cursor2.getColumnIndex("dbm");
        int columnIndex8 = cursor2.getColumnIndex("asu");
        int columnIndex9 = cursor2.getColumnIndex("ecio");
        int columnIndex10 = cursor2.getColumnIndex("rsrp");
        int columnIndex11 = cursor2.getColumnIndex("rsrq");
        int columnIndex12 = cursor2.getColumnIndex("bitErrorRate");
        int columnIndex13 = cursor2.getColumnIndex("wcdmaBitErrorRate");
        int columnIndex14 = cursor2.getColumnIndex("locationTimeStamp");
        int columnIndex15 = cursor2.getColumnIndex("locationProvider");
        int columnIndex16 = cursor2.getColumnIndex("accuracy");
        int columnIndex17 = cursor2.getColumnIndex("networkOperatorName");
        int columnIndex18 = cursor2.getColumnIndex("networkCountryIso");
        int columnIndex19 = cursor2.getColumnIndex("networkMnc");
        int columnIndex20 = cursor2.getColumnIndex("networkMcc");
        int columnIndex21 = cursor2.getColumnIndex("simOperatorName");
        int columnIndex22 = cursor2.getColumnIndex("simCountryIso");
        int columnIndex23 = cursor2.getColumnIndex("simMnc");
        int columnIndex24 = cursor2.getColumnIndex("simMcc");
        int columnIndex25 = cursor2.getColumnIndex("simSlot");
        int columnIndex26 = cursor2.getColumnIndex("isDataDefaultSim");
        int columnIndex27 = cursor2.getColumnIndex("isPrimaryConnection");
        int columnIndex28 = cursor2.getColumnIndex("resourcesMnc");
        int columnIndex29 = cursor2.getColumnIndex("resourcesMcc");
        int columnIndex30 = cursor2.getColumnIndex("registered");
        int columnIndex31 = cursor2.getColumnIndex("lteSignalStrength");
        int columnIndex32 = cursor2.getColumnIndex("lteRsrp");
        int columnIndex33 = cursor2.getColumnIndex("lteRsrq");
        int columnIndex34 = cursor2.getColumnIndex("lteRssnr");
        int columnIndex35 = cursor2.getColumnIndex("lteRssi");
        int columnIndex36 = cursor2.getColumnIndex("lteBand");
        int columnIndex37 = cursor2.getColumnIndex("lteCqi");
        int columnIndex38 = cursor2.getColumnIndex("lteDbm");
        int columnIndex39 = cursor2.getColumnIndex("lteAsu");
        int columnIndex40 = cursor2.getColumnIndex("cdmaDbm");
        int columnIndex41 = cursor2.getColumnIndex("cdmaAsu");
        int columnIndex42 = cursor2.getColumnIndex("cdmaEcio");
        int columnIndex43 = cursor2.getColumnIndex("evdoDbm");
        int columnIndex44 = cursor2.getColumnIndex("evdoAsu");
        int columnIndex45 = cursor2.getColumnIndex("evdoEcio");
        int columnIndex46 = cursor2.getColumnIndex("evdoSnr");
        int columnIndex47 = cursor2.getColumnIndex("barometric");
        int columnIndex48 = cursor2.getColumnIndex("gsmDbm");
        int columnIndex49 = cursor2.getColumnIndex("gsmAsu");
        int columnIndex50 = cursor2.getColumnIndex("gsmBitError");
        int columnIndex51 = cursor2.getColumnIndex("tdscdmaDbm");
        int columnIndex52 = cursor2.getColumnIndex("tdscdmaAsu");
        int columnIndex53 = cursor2.getColumnIndex("gpsAvailable");
        int columnIndex54 = cursor2.getColumnIndex("lteCi");
        int columnIndex55 = cursor2.getColumnIndex("ltePci");
        int columnIndex56 = cursor2.getColumnIndex("lteTac");
        int columnIndex57 = cursor2.getColumnIndex("wcdmaDbm");
        int columnIndex58 = cursor2.getColumnIndex("wcdmaAsu");
        int columnIndex59 = cursor2.getColumnIndex("wcdmaCid");
        int columnIndex60 = cursor2.getColumnIndex("wcdmaLac");
        int columnIndex61 = cursor2.getColumnIndex("wcdmaPsc");
        int columnIndex62 = cursor2.getColumnIndex("roaming");
        int columnIndex63 = cursor2.getColumnIndex("networkType");
        int columnIndex64 = cursor2.getColumnIndex("dataNetworkType");
        int columnIndex65 = cursor2.getColumnIndex("voiceNetworkType");
        int columnIndex66 = cursor2.getColumnIndex("lteTimingAdvance");
        int columnIndex67 = cursor2.getColumnIndex("dataRX");
        int columnIndex68 = cursor2.getColumnIndex("dataTX");
        int columnIndex69 = cursor2.getColumnIndex("nrAsuLevel");
        int columnIndex70 = cursor2.getColumnIndex("nrCsiRsrp");
        int columnIndex71 = cursor2.getColumnIndex("nrCsiRsrq");
        int columnIndex72 = cursor2.getColumnIndex("nrCsiSinr");
        int columnIndex73 = cursor2.getColumnIndex("nrDbm");
        int columnIndex74 = cursor2.getColumnIndex("nrLevel");
        int columnIndex75 = cursor2.getColumnIndex("nrSsRsrp");
        int columnIndex76 = cursor2.getColumnIndex("nrSsRsrq");
        int columnIndex77 = cursor2.getColumnIndex("nrSsSinr");
        int columnIndex78 = cursor2.getColumnIndex("completeness");
        int columnIndex79 = cursor2.getColumnIndex("nrBand");
        int columnIndex80 = cursor2.getColumnIndex("permissions");
        int columnIndex81 = cursor2.getColumnIndex("celltowerInfoTimestamp");
        int columnIndex82 = cursor2.getColumnIndex("baseStationId");
        int columnIndex83 = cursor2.getColumnIndex("baseStationLatitude");
        int columnIndex84 = cursor2.getColumnIndex("baseStationLongitude");
        int columnIndex85 = cursor2.getColumnIndex("networkId");
        int columnIndex86 = cursor2.getColumnIndex("systemId");
        int columnIndex87 = cursor2.getColumnIndex(CmcdConfiguration.KEY_CONTENT_ID);
        int columnIndex88 = cursor2.getColumnIndex("lac");
        int columnIndex89 = cursor2.getColumnIndex("gsmArfcn");
        int columnIndex90 = cursor2.getColumnIndex("gsmBsic");
        int columnIndex91 = cursor2.getColumnIndex("lteEarfcn");
        int columnIndex92 = cursor2.getColumnIndex("lteBandwidth");
        int columnIndex93 = cursor2.getColumnIndex("psc");
        int columnIndex94 = cursor2.getColumnIndex("wcdmaUarfcn");
        int columnIndex95 = cursor2.getColumnIndex("nrNci");
        int columnIndex96 = cursor2.getColumnIndex("nrArfcn");
        int columnIndex97 = cursor2.getColumnIndex("nrPci");
        int columnIndex98 = cursor2.getColumnIndex("nrTac");
        int columnIndex99 = cursor2.getColumnIndex("timeZoneOffset");
        int columnIndex100 = cursor2.getColumnIndex("secondaryNrNci");
        int columnIndex101 = cursor2.getColumnIndex("isUsingCarrierAggregation");
        int columnIndex102 = cursor2.getColumnIndex("is5GConnected");
        int columnIndex103 = cursor2.getColumnIndex("latitude");
        int columnIndex104 = cursor2.getColumnIndex("longitude");
        int columnIndex105 = cursor2.getColumnIndex("indoorOutdoorWeight");
        int columnIndex106 = cursor2.getColumnIndex("overrideNetworkType");
        MNSIEntity mNSIEntity = new MNSIEntity();
        int i = columnIndex14;
        if (columnIndex != -1) {
            mNSIEntity.setId(cursor2.getInt(columnIndex));
        }
        if (columnIndex2 != -1) {
            mNSIEntity.setTransmitted(cursor2.getInt(columnIndex2));
        }
        Integer num76 = null;
        if (columnIndex3 != -1) {
            if (cursor2.isNull(columnIndex3)) {
                l7 = null;
            } else {
                l7 = Long.valueOf(cursor2.getLong(columnIndex3));
            }
            mNSIEntity.setTimeStamp(l7);
        }
        if (columnIndex4 != -1) {
            if (cursor2.isNull(columnIndex4)) {
                str11 = null;
            } else {
                str11 = cursor2.getString(columnIndex4);
            }
            mNSIEntity.setTimeZone(str11);
        }
        if (columnIndex5 != -1) {
            if (cursor2.isNull(columnIndex5)) {
                str10 = null;
            } else {
                str10 = cursor2.getString(columnIndex5);
            }
            mNSIEntity.setPhoneType(str10);
        }
        if (columnIndex6 != -1) {
            if (cursor2.isNull(columnIndex6)) {
                str9 = null;
            } else {
                str9 = cursor2.getString(columnIndex6);
            }
            mNSIEntity.setNetworkTypeString(str9);
        }
        if (columnIndex7 != -1) {
            if (cursor2.isNull(columnIndex7)) {
                num75 = null;
            } else {
                num75 = Integer.valueOf(cursor2.getInt(columnIndex7));
            }
            mNSIEntity.setDbm(num75);
        }
        if (columnIndex8 != -1) {
            if (cursor2.isNull(columnIndex8)) {
                num74 = null;
            } else {
                num74 = Integer.valueOf(cursor2.getInt(columnIndex8));
            }
            mNSIEntity.setAsu(num74);
        }
        if (columnIndex9 != -1) {
            if (cursor2.isNull(columnIndex9)) {
                num73 = null;
            } else {
                num73 = Integer.valueOf(cursor2.getInt(columnIndex9));
            }
            mNSIEntity.setEcio(num73);
        }
        if (columnIndex10 != -1) {
            if (cursor2.isNull(columnIndex10)) {
                num72 = null;
            } else {
                num72 = Integer.valueOf(cursor2.getInt(columnIndex10));
            }
            mNSIEntity.setRsrp(num72);
        }
        if (columnIndex11 != -1) {
            if (cursor2.isNull(columnIndex11)) {
                num71 = null;
            } else {
                num71 = Integer.valueOf(cursor2.getInt(columnIndex11));
            }
            mNSIEntity.setRsrq(num71);
        }
        if (columnIndex12 != -1) {
            if (cursor2.isNull(columnIndex12)) {
                num70 = null;
            } else {
                num70 = Integer.valueOf(cursor2.getInt(columnIndex12));
            }
            mNSIEntity.setBitErrorRate(num70);
        }
        if (columnIndex13 != -1) {
            if (cursor2.isNull(columnIndex13)) {
                num69 = null;
            } else {
                num69 = Integer.valueOf(cursor2.getInt(columnIndex13));
            }
            mNSIEntity.setWcdmaBitErrorRate(num69);
        }
        int i2 = i;
        if (i2 != -1) {
            if (cursor2.isNull(i2)) {
                l6 = null;
            } else {
                l6 = Long.valueOf(cursor2.getLong(i2));
            }
            mNSIEntity.setLocationTimeStamp(l6);
        }
        int i3 = columnIndex15;
        if (i3 != -1) {
            if (cursor2.isNull(i3)) {
                str8 = null;
            } else {
                str8 = cursor2.getString(i3);
            }
            mNSIEntity.setLocationProvider(str8);
        }
        int i4 = columnIndex16;
        if (i4 != -1) {
            if (cursor2.isNull(i4)) {
                f2 = null;
            } else {
                f2 = Float.valueOf(cursor2.getFloat(i4));
            }
            mNSIEntity.setAccuracy(f2);
        }
        int i5 = columnIndex17;
        if (i5 != -1) {
            if (cursor2.isNull(i5)) {
                str7 = null;
            } else {
                str7 = cursor2.getString(i5);
            }
            mNSIEntity.setNetworkOperatorName(str7);
        }
        int i6 = columnIndex18;
        if (i6 != -1) {
            if (cursor2.isNull(i6)) {
                str6 = null;
            } else {
                str6 = cursor2.getString(i6);
            }
            mNSIEntity.setNetworkCountryIso(str6);
        }
        int i7 = columnIndex19;
        if (i7 != -1) {
            if (cursor2.isNull(i7)) {
                num68 = null;
            } else {
                num68 = Integer.valueOf(cursor2.getInt(i7));
            }
            mNSIEntity.setNetworkMnc(num68);
        }
        int i8 = columnIndex20;
        if (i8 != -1) {
            if (cursor2.isNull(i8)) {
                num67 = null;
            } else {
                num67 = Integer.valueOf(cursor2.getInt(i8));
            }
            mNSIEntity.setNetworkMcc(num67);
        }
        int i9 = columnIndex21;
        if (i9 != -1) {
            if (cursor2.isNull(i9)) {
                str5 = null;
            } else {
                str5 = cursor2.getString(i9);
            }
            mNSIEntity.setSimOperatorName(str5);
        }
        int i10 = columnIndex22;
        if (i10 != -1) {
            if (cursor2.isNull(i10)) {
                str4 = null;
            } else {
                str4 = cursor2.getString(i10);
            }
            mNSIEntity.setSimCountryIso(str4);
        }
        int i11 = columnIndex23;
        if (i11 != -1) {
            if (cursor2.isNull(i11)) {
                num66 = null;
            } else {
                num66 = Integer.valueOf(cursor2.getInt(i11));
            }
            mNSIEntity.setSimMnc(num66);
        }
        int i12 = columnIndex24;
        if (i12 != -1) {
            if (cursor2.isNull(i12)) {
                num65 = null;
            } else {
                num65 = Integer.valueOf(cursor2.getInt(i12));
            }
            mNSIEntity.setSimMcc(num65);
        }
        int i13 = columnIndex25;
        if (i13 != -1) {
            if (cursor2.isNull(i13)) {
                num64 = null;
            } else {
                num64 = Integer.valueOf(cursor2.getInt(i13));
            }
            mNSIEntity.setSimSlot(num64);
        }
        int i14 = columnIndex26;
        if (i14 != -1) {
            if (cursor2.isNull(i14)) {
                num63 = null;
            } else {
                num63 = Integer.valueOf(cursor2.getInt(i14));
            }
            mNSIEntity.setIsDataDefaultSim(num63);
        }
        int i15 = columnIndex27;
        if (i15 != -1) {
            if (cursor2.isNull(i15)) {
                num62 = null;
            } else {
                num62 = Integer.valueOf(cursor2.getInt(i15));
            }
            if (num62 == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(num62.intValue() != 0);
            }
            mNSIEntity.setPrimaryConnection(bool);
        }
        int i16 = columnIndex28;
        if (i16 != -1) {
            if (cursor2.isNull(i16)) {
                num61 = null;
            } else {
                num61 = Integer.valueOf(cursor2.getInt(i16));
            }
            mNSIEntity.setResourcesMnc(num61);
        }
        int i17 = columnIndex29;
        if (i17 != -1) {
            if (cursor2.isNull(i17)) {
                num60 = null;
            } else {
                num60 = Integer.valueOf(cursor2.getInt(i17));
            }
            mNSIEntity.setResourcesMcc(num60);
        }
        int i18 = columnIndex30;
        if (i18 != -1) {
            if (cursor2.isNull(i18)) {
                num59 = null;
            } else {
                num59 = Integer.valueOf(cursor2.getInt(i18));
            }
            mNSIEntity.setRegistered(num59);
        }
        int i19 = columnIndex31;
        if (i19 != -1) {
            if (cursor2.isNull(i19)) {
                num58 = null;
            } else {
                num58 = Integer.valueOf(cursor2.getInt(i19));
            }
            mNSIEntity.setLteSignalStrength(num58);
        }
        int i20 = columnIndex32;
        if (i20 != -1) {
            if (cursor2.isNull(i20)) {
                num57 = null;
            } else {
                num57 = Integer.valueOf(cursor2.getInt(i20));
            }
            mNSIEntity.setLteRsrp(num57);
        }
        int i21 = columnIndex33;
        if (i21 != -1) {
            if (cursor2.isNull(i21)) {
                num56 = null;
            } else {
                num56 = Integer.valueOf(cursor2.getInt(i21));
            }
            mNSIEntity.setLteRsrq(num56);
        }
        int i22 = columnIndex34;
        if (i22 != -1) {
            if (cursor2.isNull(i22)) {
                num55 = null;
            } else {
                num55 = Integer.valueOf(cursor2.getInt(i22));
            }
            mNSIEntity.setLteRssnr(num55);
        }
        int i23 = columnIndex35;
        if (i23 != -1) {
            if (cursor2.isNull(i23)) {
                num54 = null;
            } else {
                num54 = Integer.valueOf(cursor2.getInt(i23));
            }
            mNSIEntity.setLteRssi(num54);
        }
        int i24 = columnIndex36;
        if (i24 != -1) {
            if (cursor2.isNull(i24)) {
                str3 = null;
            } else {
                str3 = cursor2.getString(i24);
            }
            mNSIEntity.setLteBand(str3);
        }
        int i25 = columnIndex37;
        if (i25 != -1) {
            if (cursor2.isNull(i25)) {
                num53 = null;
            } else {
                num53 = Integer.valueOf(cursor2.getInt(i25));
            }
            mNSIEntity.setLteCqi(num53);
        }
        int i26 = columnIndex38;
        if (i26 != -1) {
            if (cursor2.isNull(i26)) {
                num52 = null;
            } else {
                num52 = Integer.valueOf(cursor2.getInt(i26));
            }
            mNSIEntity.setLteDbm(num52);
        }
        int i27 = columnIndex39;
        if (i27 != -1) {
            if (cursor2.isNull(i27)) {
                num51 = null;
            } else {
                num51 = Integer.valueOf(cursor2.getInt(i27));
            }
            mNSIEntity.setLteAsu(num51);
        }
        int i28 = columnIndex40;
        if (i28 != -1) {
            if (cursor2.isNull(i28)) {
                num50 = null;
            } else {
                num50 = Integer.valueOf(cursor2.getInt(i28));
            }
            mNSIEntity.setCdmaDbm(num50);
        }
        int i29 = columnIndex41;
        if (i29 != -1) {
            if (cursor2.isNull(i29)) {
                num49 = null;
            } else {
                num49 = Integer.valueOf(cursor2.getInt(i29));
            }
            mNSIEntity.setCdmaAsu(num49);
        }
        int i30 = columnIndex42;
        if (i30 != -1) {
            if (cursor2.isNull(i30)) {
                num48 = null;
            } else {
                num48 = Integer.valueOf(cursor2.getInt(i30));
            }
            mNSIEntity.setCdmaEcio(num48);
        }
        int i31 = columnIndex43;
        if (i31 != -1) {
            if (cursor2.isNull(i31)) {
                num47 = null;
            } else {
                num47 = Integer.valueOf(cursor2.getInt(i31));
            }
            mNSIEntity.setEvdoDbm(num47);
        }
        int i32 = columnIndex44;
        if (i32 != -1) {
            if (cursor2.isNull(i32)) {
                num46 = null;
            } else {
                num46 = Integer.valueOf(cursor2.getInt(i32));
            }
            mNSIEntity.setEvdoAsu(num46);
        }
        int i33 = columnIndex45;
        if (i33 != -1) {
            if (cursor2.isNull(i33)) {
                num45 = null;
            } else {
                num45 = Integer.valueOf(cursor2.getInt(i33));
            }
            mNSIEntity.setEvdoEcio(num45);
        }
        int i34 = columnIndex46;
        if (i34 != -1) {
            if (cursor2.isNull(i34)) {
                num44 = null;
            } else {
                num44 = Integer.valueOf(cursor2.getInt(i34));
            }
            mNSIEntity.setEvdoSnr(num44);
        }
        int i35 = columnIndex47;
        if (i35 != -1) {
            if (cursor2.isNull(i35)) {
                f = null;
            } else {
                f = Float.valueOf(cursor2.getFloat(i35));
            }
            mNSIEntity.setBarometric(f);
        }
        int i36 = columnIndex48;
        if (i36 != -1) {
            if (cursor2.isNull(i36)) {
                num43 = null;
            } else {
                num43 = Integer.valueOf(cursor2.getInt(i36));
            }
            mNSIEntity.setGsmDbm(num43);
        }
        int i37 = columnIndex49;
        if (i37 != -1) {
            if (cursor2.isNull(i37)) {
                num42 = null;
            } else {
                num42 = Integer.valueOf(cursor2.getInt(i37));
            }
            mNSIEntity.setGsmAsu(num42);
        }
        int i38 = columnIndex50;
        if (i38 != -1) {
            if (cursor2.isNull(i38)) {
                num41 = null;
            } else {
                num41 = Integer.valueOf(cursor2.getInt(i38));
            }
            mNSIEntity.setGsmBitError(num41);
        }
        int i39 = columnIndex51;
        if (i39 != -1) {
            if (cursor2.isNull(i39)) {
                num40 = null;
            } else {
                num40 = Integer.valueOf(cursor2.getInt(i39));
            }
            mNSIEntity.setTdscdmaDbm(num40);
        }
        int i40 = columnIndex52;
        if (i40 != -1) {
            if (cursor2.isNull(i40)) {
                num39 = null;
            } else {
                num39 = Integer.valueOf(cursor2.getInt(i40));
            }
            mNSIEntity.setTdscdmaAsu(num39);
        }
        int i41 = columnIndex53;
        if (i41 != -1) {
            if (cursor2.isNull(i41)) {
                num38 = null;
            } else {
                num38 = Integer.valueOf(cursor2.getInt(i41));
            }
            mNSIEntity.setGpsAvailable(num38);
        }
        int i42 = columnIndex54;
        if (i42 != -1) {
            if (cursor2.isNull(i42)) {
                num37 = null;
            } else {
                num37 = Integer.valueOf(cursor2.getInt(i42));
            }
            mNSIEntity.setLteCi(num37);
        }
        int i43 = columnIndex55;
        if (i43 != -1) {
            if (cursor2.isNull(i43)) {
                num36 = null;
            } else {
                num36 = Integer.valueOf(cursor2.getInt(i43));
            }
            mNSIEntity.setLtePci(num36);
        }
        int i44 = columnIndex56;
        if (i44 != -1) {
            if (cursor2.isNull(i44)) {
                num35 = null;
            } else {
                num35 = Integer.valueOf(cursor2.getInt(i44));
            }
            mNSIEntity.setLteTac(num35);
        }
        int i45 = columnIndex57;
        if (i45 != -1) {
            if (cursor2.isNull(i45)) {
                num34 = null;
            } else {
                num34 = Integer.valueOf(cursor2.getInt(i45));
            }
            mNSIEntity.setWcdmaDbm(num34);
        }
        int i46 = columnIndex58;
        if (i46 != -1) {
            if (cursor2.isNull(i46)) {
                num33 = null;
            } else {
                num33 = Integer.valueOf(cursor2.getInt(i46));
            }
            mNSIEntity.setWcdmaAsu(num33);
        }
        int i47 = columnIndex59;
        if (i47 != -1) {
            if (cursor2.isNull(i47)) {
                num32 = null;
            } else {
                num32 = Integer.valueOf(cursor2.getInt(i47));
            }
            mNSIEntity.setWcdmaCid(num32);
        }
        int i48 = columnIndex60;
        if (i48 != -1) {
            if (cursor2.isNull(i48)) {
                num31 = null;
            } else {
                num31 = Integer.valueOf(cursor2.getInt(i48));
            }
            mNSIEntity.setWcdmaLac(num31);
        }
        int i49 = columnIndex61;
        if (i49 != -1) {
            if (cursor2.isNull(i49)) {
                num30 = null;
            } else {
                num30 = Integer.valueOf(cursor2.getInt(i49));
            }
            mNSIEntity.setWcdmaPsc(num30);
        }
        int i50 = columnIndex62;
        if (i50 != -1) {
            if (cursor2.isNull(i50)) {
                num29 = null;
            } else {
                num29 = Integer.valueOf(cursor2.getInt(i50));
            }
            mNSIEntity.setRoaming(num29);
        }
        int i51 = columnIndex63;
        if (i51 != -1) {
            mNSIEntity.setNetworkType(cursor2.getInt(i51));
        }
        int i52 = columnIndex64;
        if (i52 != -1) {
            mNSIEntity.setDataNetworkType(cursor2.getInt(i52));
        }
        int i53 = columnIndex65;
        if (i53 != -1) {
            mNSIEntity.setVoiceNetworkType(cursor2.getInt(i53));
        }
        int i54 = columnIndex66;
        if (i54 != -1) {
            if (cursor2.isNull(i54)) {
                num28 = null;
            } else {
                num28 = Integer.valueOf(cursor2.getInt(i54));
            }
            mNSIEntity.setLteTimingAdvance(num28);
        }
        int i55 = columnIndex67;
        if (i55 != -1) {
            if (cursor2.isNull(i55)) {
                l5 = null;
            } else {
                l5 = Long.valueOf(cursor2.getLong(i55));
            }
            mNSIEntity.setDataRX(l5);
        }
        int i56 = columnIndex68;
        if (i56 != -1) {
            if (cursor2.isNull(i56)) {
                l4 = null;
            } else {
                l4 = Long.valueOf(cursor2.getLong(i56));
            }
            mNSIEntity.setDataTX(l4);
        }
        int i57 = columnIndex69;
        if (i57 != -1) {
            if (cursor2.isNull(i57)) {
                num27 = null;
            } else {
                num27 = Integer.valueOf(cursor2.getInt(i57));
            }
            mNSIEntity.setNrAsuLevel(num27);
        }
        int i58 = columnIndex70;
        if (i58 != -1) {
            if (cursor2.isNull(i58)) {
                num26 = null;
            } else {
                num26 = Integer.valueOf(cursor2.getInt(i58));
            }
            mNSIEntity.setNrCsiRsrp(num26);
        }
        int i59 = columnIndex71;
        if (i59 != -1) {
            if (cursor2.isNull(i59)) {
                num25 = null;
            } else {
                num25 = Integer.valueOf(cursor2.getInt(i59));
            }
            mNSIEntity.setNrCsiRsrq(num25);
        }
        int i60 = columnIndex72;
        if (i60 != -1) {
            if (cursor2.isNull(i60)) {
                num24 = null;
            } else {
                num24 = Integer.valueOf(cursor2.getInt(i60));
            }
            mNSIEntity.setNrCsiSinr(num24);
        }
        int i61 = columnIndex73;
        if (i61 != -1) {
            if (cursor2.isNull(i61)) {
                num23 = null;
            } else {
                num23 = Integer.valueOf(cursor2.getInt(i61));
            }
            mNSIEntity.setNrDbm(num23);
        }
        int i62 = columnIndex74;
        if (i62 != -1) {
            if (cursor2.isNull(i62)) {
                num22 = null;
            } else {
                num22 = Integer.valueOf(cursor2.getInt(i62));
            }
            mNSIEntity.setNrLevel(num22);
        }
        int i63 = columnIndex75;
        if (i63 != -1) {
            if (cursor2.isNull(i63)) {
                num21 = null;
            } else {
                num21 = Integer.valueOf(cursor2.getInt(i63));
            }
            mNSIEntity.setNrSsRsrp(num21);
        }
        int i64 = columnIndex76;
        if (i64 != -1) {
            if (cursor2.isNull(i64)) {
                num20 = null;
            } else {
                num20 = Integer.valueOf(cursor2.getInt(i64));
            }
            mNSIEntity.setNrSsRsrq(num20);
        }
        int i65 = columnIndex77;
        if (i65 != -1) {
            if (cursor2.isNull(i65)) {
                num19 = null;
            } else {
                num19 = Integer.valueOf(cursor2.getInt(i65));
            }
            mNSIEntity.setNrSsSinr(num19);
        }
        int i66 = columnIndex78;
        if (i66 != -1) {
            if (cursor2.isNull(i66)) {
                num18 = null;
            } else {
                num18 = Integer.valueOf(cursor2.getInt(i66));
            }
            mNSIEntity.setCompleteness(num18);
        }
        int i67 = columnIndex79;
        if (i67 != -1) {
            if (cursor2.isNull(i67)) {
                str2 = null;
            } else {
                str2 = cursor2.getString(i67);
            }
            mNSIEntity.setNrBand(str2);
        }
        int i68 = columnIndex80;
        if (i68 != -1) {
            if (cursor2.isNull(i68)) {
                str = null;
            } else {
                str = cursor2.getString(i68);
            }
            mNSIEntity.setPermissions(str);
        }
        int i69 = columnIndex81;
        if (i69 != -1) {
            if (cursor2.isNull(i69)) {
                l3 = null;
            } else {
                l3 = Long.valueOf(cursor2.getLong(i69));
            }
            mNSIEntity.setCelltowerInfoTimestamp(l3);
        }
        int i70 = columnIndex82;
        if (i70 != -1) {
            if (cursor2.isNull(i70)) {
                num17 = null;
            } else {
                num17 = Integer.valueOf(cursor2.getInt(i70));
            }
            mNSIEntity.setBaseStationId(num17);
        }
        int i71 = columnIndex83;
        if (i71 != -1) {
            if (cursor2.isNull(i71)) {
                d5 = null;
            } else {
                d5 = Double.valueOf(cursor2.getDouble(i71));
            }
            mNSIEntity.setBaseStationLatitude(d5);
        }
        int i72 = columnIndex84;
        if (i72 != -1) {
            if (cursor2.isNull(i72)) {
                d4 = null;
            } else {
                d4 = Double.valueOf(cursor2.getDouble(i72));
            }
            mNSIEntity.setBaseStationLongitude(d4);
        }
        int i73 = columnIndex85;
        if (i73 != -1) {
            if (cursor2.isNull(i73)) {
                num16 = null;
            } else {
                num16 = Integer.valueOf(cursor2.getInt(i73));
            }
            mNSIEntity.setNetworkId(num16);
        }
        int i74 = columnIndex86;
        if (i74 != -1) {
            if (cursor2.isNull(i74)) {
                num15 = null;
            } else {
                num15 = Integer.valueOf(cursor2.getInt(i74));
            }
            mNSIEntity.setSystemId(num15);
        }
        int i75 = columnIndex87;
        if (i75 != -1) {
            if (cursor2.isNull(i75)) {
                num14 = null;
            } else {
                num14 = Integer.valueOf(cursor2.getInt(i75));
            }
            mNSIEntity.setCid(num14);
        }
        int i76 = columnIndex88;
        if (i76 != -1) {
            if (cursor2.isNull(i76)) {
                num13 = null;
            } else {
                num13 = Integer.valueOf(cursor2.getInt(i76));
            }
            mNSIEntity.setLac(num13);
        }
        int i77 = columnIndex89;
        if (i77 != -1) {
            if (cursor2.isNull(i77)) {
                num12 = null;
            } else {
                num12 = Integer.valueOf(cursor2.getInt(i77));
            }
            mNSIEntity.setGsmArfcn(num12);
        }
        int i78 = columnIndex90;
        if (i78 != -1) {
            if (cursor2.isNull(i78)) {
                num11 = null;
            } else {
                num11 = Integer.valueOf(cursor2.getInt(i78));
            }
            mNSIEntity.setGsmBsic(num11);
        }
        int i79 = columnIndex91;
        if (i79 != -1) {
            if (cursor2.isNull(i79)) {
                num10 = null;
            } else {
                num10 = Integer.valueOf(cursor2.getInt(i79));
            }
            mNSIEntity.setLteEarfcn(num10);
        }
        int i80 = columnIndex92;
        if (i80 != -1) {
            if (cursor2.isNull(i80)) {
                num9 = null;
            } else {
                num9 = Integer.valueOf(cursor2.getInt(i80));
            }
            mNSIEntity.setLteBandwidth(num9);
        }
        int i81 = columnIndex93;
        if (i81 != -1) {
            if (cursor2.isNull(i81)) {
                num8 = null;
            } else {
                num8 = Integer.valueOf(cursor2.getInt(i81));
            }
            mNSIEntity.setPsc(num8);
        }
        int i82 = columnIndex94;
        if (i82 != -1) {
            if (cursor2.isNull(i82)) {
                num7 = null;
            } else {
                num7 = Integer.valueOf(cursor2.getInt(i82));
            }
            mNSIEntity.setWcdmaUarfcn(num7);
        }
        int i83 = columnIndex95;
        if (i83 != -1) {
            if (cursor2.isNull(i83)) {
                l2 = null;
            } else {
                l2 = Long.valueOf(cursor2.getLong(i83));
            }
            mNSIEntity.setNrNci(l2);
        }
        int i84 = columnIndex96;
        if (i84 != -1) {
            if (cursor2.isNull(i84)) {
                num6 = null;
            } else {
                num6 = Integer.valueOf(cursor2.getInt(i84));
            }
            mNSIEntity.setNrArfcn(num6);
        }
        int i85 = columnIndex97;
        if (i85 != -1) {
            if (cursor2.isNull(i85)) {
                num5 = null;
            } else {
                num5 = Integer.valueOf(cursor2.getInt(i85));
            }
            mNSIEntity.setNrPci(num5);
        }
        int i86 = columnIndex98;
        if (i86 != -1) {
            if (cursor2.isNull(i86)) {
                num4 = null;
            } else {
                num4 = Integer.valueOf(cursor2.getInt(i86));
            }
            mNSIEntity.setNrTac(num4);
        }
        int i87 = columnIndex99;
        if (i87 != -1) {
            if (cursor2.isNull(i87)) {
                num3 = null;
            } else {
                num3 = Integer.valueOf(cursor2.getInt(i87));
            }
            mNSIEntity.setTimeZoneOffset(num3);
        }
        int i88 = columnIndex100;
        if (i88 != -1) {
            if (cursor2.isNull(i88)) {
                l = null;
            } else {
                l = Long.valueOf(cursor2.getLong(i88));
            }
            mNSIEntity.setSecondaryNrNci(l);
        }
        int i89 = columnIndex101;
        if (i89 != -1) {
            if (cursor2.isNull(i89)) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(cursor2.getInt(i89));
            }
            mNSIEntity.setCarrierAgregationUsed(num2);
        }
        int i90 = columnIndex102;
        if (i90 != -1) {
            if (cursor2.isNull(i90)) {
                num = null;
            } else {
                num = Integer.valueOf(cursor2.getInt(i90));
            }
            mNSIEntity.setConnectivityTo5G(num);
        }
        int i91 = columnIndex103;
        if (i91 != -1) {
            if (cursor2.isNull(i91)) {
                d3 = null;
            } else {
                d3 = Double.valueOf(cursor2.getDouble(i91));
            }
            mNSIEntity.setLatitude(d3);
        }
        int i92 = columnIndex104;
        if (i92 != -1) {
            if (cursor2.isNull(i92)) {
                d2 = null;
            } else {
                d2 = Double.valueOf(cursor2.getDouble(i92));
            }
            mNSIEntity.setLongitude(d2);
        }
        int i93 = columnIndex105;
        if (i93 != -1) {
            if (cursor2.isNull(i93)) {
                d = null;
            } else {
                d = Double.valueOf(cursor2.getDouble(i93));
            }
            mNSIEntity.setIndoorOutdoorWeight(d);
        }
        int i94 = columnIndex106;
        if (i94 != -1) {
            if (!cursor2.isNull(i94)) {
                num76 = Integer.valueOf(cursor2.getInt(i94));
            }
            mNSIEntity.setOverrideNetworkType(num76);
        }
        return mNSIEntity;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Object addEntries(final List<MNSIEntity> list, Continuation<Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                MNSIDao_Impl.this.__db.beginTransaction();
                try {
                    MNSIDao_Impl.this.__insertionAdapterOfMNSIEntity.insert(list);
                    MNSIDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MNSIDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object clearMNSITable(Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new MNSIDao_Impl$$ExternalSyntheticLambda0(this), continuation);
    }

    public Object deleteMNSIEntries(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = MNSIDao_Impl.this.__preparedStmtOfDeleteMNSIEntries.acquire();
                MNSIDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    MNSIDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MNSIDao_Impl.this.__db.endTransaction();
                    MNSIDao_Impl.this.__preparedStmtOfDeleteMNSIEntries.release(acquire);
                }
            }
        }, continuation);
    }

    public Object getMNSI(Continuation<? super List<? extends MNSIEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM mnsi_tbl ORDER BY timeStamp ASC", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends MNSIEntity>>() {
            public List<? extends MNSIEntity> call() {
                AnonymousClass13 r3;
                Long l;
                String str;
                String str2;
                String str3;
                Integer num;
                Integer num2;
                Integer num3;
                Integer num4;
                Integer num5;
                Integer num6;
                int i;
                Integer num7;
                int i2;
                Long l2;
                String str4;
                Float f;
                String str5;
                String str6;
                Integer num8;
                Integer num9;
                String str7;
                String str8;
                Integer num10;
                Integer num11;
                Integer num12;
                Integer num13;
                Integer num14;
                Boolean bool;
                Integer num15;
                Integer num16;
                Integer num17;
                Integer num18;
                Integer num19;
                Integer num20;
                Integer num21;
                Integer num22;
                String str9;
                Integer num23;
                Integer num24;
                Integer num25;
                Integer num26;
                Integer num27;
                Integer num28;
                Integer num29;
                Integer num30;
                Integer num31;
                Integer num32;
                Float f2;
                Integer num33;
                Integer num34;
                Integer num35;
                Integer num36;
                Integer num37;
                Integer num38;
                Integer num39;
                Integer num40;
                Integer num41;
                Integer num42;
                Integer num43;
                Integer num44;
                Integer num45;
                Integer num46;
                Integer num47;
                int i3;
                Integer num48;
                Long l3;
                Long l4;
                Integer num49;
                Integer num50;
                Integer num51;
                Integer num52;
                Integer num53;
                Integer num54;
                Integer num55;
                Integer num56;
                Integer num57;
                Integer num58;
                String str10;
                String str11;
                Long l5;
                Integer num59;
                Double d;
                Double d2;
                Integer num60;
                Integer num61;
                Integer num62;
                Integer num63;
                Integer num64;
                Integer num65;
                Integer num66;
                Integer num67;
                Integer num68;
                Integer num69;
                Long l6;
                Integer num70;
                Integer num71;
                Integer num72;
                Integer num73;
                Long l7;
                Integer num74;
                Integer num75;
                Double d3;
                Double d4;
                Double d5;
                Integer num76;
                Cursor query = DBUtil.query(MNSIDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "timeStamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "timeZone");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "phoneType");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "networkTypeString");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "asu");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "ecio");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "rsrp");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "rsrq");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "bitErrorRate");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaBitErrorRate");
                    try {
                        int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "locationTimeStamp");
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "locationProvider");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "accuracy");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "networkCountryIso");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "networkMnc");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "networkMcc");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "simOperatorName");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "simCountryIso");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "simMnc");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "simMcc");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "simSlot");
                        int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "isDataDefaultSim");
                        int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "isPrimaryConnection");
                        int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "resourcesMnc");
                        int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "resourcesMcc");
                        int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "registered");
                        int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "lteSignalStrength");
                        int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "lteRsrp");
                        int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "lteRsrq");
                        int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "lteRssnr");
                        int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "lteRssi");
                        int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "lteBand");
                        int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "lteCqi");
                        int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "lteDbm");
                        int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "lteAsu");
                        int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "cdmaDbm");
                        int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "cdmaAsu");
                        int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "cdmaEcio");
                        int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "evdoDbm");
                        int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "evdoAsu");
                        int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "evdoEcio");
                        int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "evdoSnr");
                        int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "barometric");
                        int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "gsmDbm");
                        int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "gsmAsu");
                        int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "gsmBitError");
                        int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "tdscdmaDbm");
                        int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "tdscdmaAsu");
                        int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "gpsAvailable");
                        int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "lteCi");
                        int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "ltePci");
                        int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "lteTac");
                        int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaDbm");
                        int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaAsu");
                        int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaCid");
                        int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaLac");
                        int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaPsc");
                        int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "roaming");
                        int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "networkType");
                        int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "dataNetworkType");
                        int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "voiceNetworkType");
                        int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "lteTimingAdvance");
                        int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "dataRX");
                        int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "dataTX");
                        int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "nrAsuLevel");
                        int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "nrCsiRsrp");
                        int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "nrCsiRsrq");
                        int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "nrCsiSinr");
                        int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "nrDbm");
                        int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "nrLevel");
                        int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "nrSsRsrp");
                        int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "nrSsRsrq");
                        int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "nrSsSinr");
                        int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "completeness");
                        int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "nrBand");
                        int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "celltowerInfoTimestamp");
                        int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "baseStationId");
                        int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "baseStationLatitude");
                        int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "baseStationLongitude");
                        int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "networkId");
                        int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "systemId");
                        int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, CmcdConfiguration.KEY_CONTENT_ID);
                        int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "lac");
                        int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "gsmArfcn");
                        int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "gsmBsic");
                        int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "lteEarfcn");
                        int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "lteBandwidth");
                        int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "psc");
                        int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaUarfcn");
                        int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "nrNci");
                        int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "nrArfcn");
                        int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "nrPci");
                        int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "nrTac");
                        int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneOffset");
                        int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "secondaryNrNci");
                        int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                        int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "is5GConnected");
                        int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                        int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                        int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "indoorOutdoorWeight");
                        int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                        int i4 = columnIndexOrThrow13;
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            MNSIEntity mNSIEntity = new MNSIEntity();
                            ArrayList arrayList2 = arrayList;
                            mNSIEntity.setId(query.getInt(columnIndexOrThrow));
                            mNSIEntity.setTransmitted(query.getInt(columnIndexOrThrow2));
                            if (query.isNull(columnIndexOrThrow3)) {
                                l = null;
                            } else {
                                l = Long.valueOf(query.getLong(columnIndexOrThrow3));
                            }
                            mNSIEntity.setTimeStamp(l);
                            if (query.isNull(columnIndexOrThrow4)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow4);
                            }
                            mNSIEntity.setTimeZone(str);
                            if (query.isNull(columnIndexOrThrow5)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow5);
                            }
                            mNSIEntity.setPhoneType(str2);
                            if (query.isNull(columnIndexOrThrow6)) {
                                str3 = null;
                            } else {
                                str3 = query.getString(columnIndexOrThrow6);
                            }
                            mNSIEntity.setNetworkTypeString(str3);
                            if (query.isNull(columnIndexOrThrow7)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                            }
                            mNSIEntity.setDbm(num);
                            if (query.isNull(columnIndexOrThrow8)) {
                                num2 = null;
                            } else {
                                num2 = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                            }
                            mNSIEntity.setAsu(num2);
                            if (query.isNull(columnIndexOrThrow9)) {
                                num3 = null;
                            } else {
                                num3 = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                            }
                            mNSIEntity.setEcio(num3);
                            if (query.isNull(columnIndexOrThrow10)) {
                                num4 = null;
                            } else {
                                num4 = Integer.valueOf(query.getInt(columnIndexOrThrow10));
                            }
                            mNSIEntity.setRsrp(num4);
                            if (query.isNull(columnIndexOrThrow11)) {
                                num5 = null;
                            } else {
                                num5 = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                            }
                            mNSIEntity.setRsrq(num5);
                            if (query.isNull(columnIndexOrThrow12)) {
                                num6 = null;
                            } else {
                                num6 = Integer.valueOf(query.getInt(columnIndexOrThrow12));
                            }
                            mNSIEntity.setBitErrorRate(num6);
                            int i5 = i4;
                            if (query.isNull(i5)) {
                                i = i5;
                                num7 = null;
                            } else {
                                i = i5;
                                num7 = Integer.valueOf(query.getInt(i5));
                            }
                            mNSIEntity.setWcdmaBitErrorRate(num7);
                            int i6 = columnIndexOrThrow14;
                            if (query.isNull(i6)) {
                                i2 = i6;
                                l2 = null;
                            } else {
                                i2 = i6;
                                l2 = Long.valueOf(query.getLong(i6));
                            }
                            mNSIEntity.setLocationTimeStamp(l2);
                            int i7 = columnIndexOrThrow15;
                            if (query.isNull(i7)) {
                                columnIndexOrThrow15 = i7;
                                str4 = null;
                            } else {
                                columnIndexOrThrow15 = i7;
                                str4 = query.getString(i7);
                            }
                            mNSIEntity.setLocationProvider(str4);
                            int i8 = columnIndexOrThrow16;
                            if (query.isNull(i8)) {
                                columnIndexOrThrow16 = i8;
                                f = null;
                            } else {
                                columnIndexOrThrow16 = i8;
                                f = Float.valueOf(query.getFloat(i8));
                            }
                            mNSIEntity.setAccuracy(f);
                            int i9 = columnIndexOrThrow17;
                            if (query.isNull(i9)) {
                                columnIndexOrThrow17 = i9;
                                str5 = null;
                            } else {
                                columnIndexOrThrow17 = i9;
                                str5 = query.getString(i9);
                            }
                            mNSIEntity.setNetworkOperatorName(str5);
                            int i10 = columnIndexOrThrow18;
                            if (query.isNull(i10)) {
                                columnIndexOrThrow18 = i10;
                                str6 = null;
                            } else {
                                columnIndexOrThrow18 = i10;
                                str6 = query.getString(i10);
                            }
                            mNSIEntity.setNetworkCountryIso(str6);
                            int i11 = columnIndexOrThrow19;
                            if (query.isNull(i11)) {
                                columnIndexOrThrow19 = i11;
                                num8 = null;
                            } else {
                                columnIndexOrThrow19 = i11;
                                num8 = Integer.valueOf(query.getInt(i11));
                            }
                            mNSIEntity.setNetworkMnc(num8);
                            int i12 = columnIndexOrThrow20;
                            if (query.isNull(i12)) {
                                columnIndexOrThrow20 = i12;
                                num9 = null;
                            } else {
                                columnIndexOrThrow20 = i12;
                                num9 = Integer.valueOf(query.getInt(i12));
                            }
                            mNSIEntity.setNetworkMcc(num9);
                            int i13 = columnIndexOrThrow21;
                            if (query.isNull(i13)) {
                                columnIndexOrThrow21 = i13;
                                str7 = null;
                            } else {
                                columnIndexOrThrow21 = i13;
                                str7 = query.getString(i13);
                            }
                            mNSIEntity.setSimOperatorName(str7);
                            int i14 = columnIndexOrThrow22;
                            if (query.isNull(i14)) {
                                columnIndexOrThrow22 = i14;
                                str8 = null;
                            } else {
                                columnIndexOrThrow22 = i14;
                                str8 = query.getString(i14);
                            }
                            mNSIEntity.setSimCountryIso(str8);
                            int i15 = columnIndexOrThrow23;
                            if (query.isNull(i15)) {
                                columnIndexOrThrow23 = i15;
                                num10 = null;
                            } else {
                                columnIndexOrThrow23 = i15;
                                num10 = Integer.valueOf(query.getInt(i15));
                            }
                            mNSIEntity.setSimMnc(num10);
                            int i16 = columnIndexOrThrow24;
                            if (query.isNull(i16)) {
                                columnIndexOrThrow24 = i16;
                                num11 = null;
                            } else {
                                columnIndexOrThrow24 = i16;
                                num11 = Integer.valueOf(query.getInt(i16));
                            }
                            mNSIEntity.setSimMcc(num11);
                            int i17 = columnIndexOrThrow25;
                            if (query.isNull(i17)) {
                                columnIndexOrThrow25 = i17;
                                num12 = null;
                            } else {
                                columnIndexOrThrow25 = i17;
                                num12 = Integer.valueOf(query.getInt(i17));
                            }
                            mNSIEntity.setSimSlot(num12);
                            int i18 = columnIndexOrThrow26;
                            if (query.isNull(i18)) {
                                columnIndexOrThrow26 = i18;
                                num13 = null;
                            } else {
                                columnIndexOrThrow26 = i18;
                                num13 = Integer.valueOf(query.getInt(i18));
                            }
                            mNSIEntity.setIsDataDefaultSim(num13);
                            int i19 = columnIndexOrThrow27;
                            if (query.isNull(i19)) {
                                num14 = null;
                            } else {
                                num14 = Integer.valueOf(query.getInt(i19));
                            }
                            if (num14 == null) {
                                columnIndexOrThrow27 = i19;
                                bool = null;
                            } else {
                                columnIndexOrThrow27 = i19;
                                bool = Boolean.valueOf(num14.intValue() != 0);
                            }
                            mNSIEntity.setPrimaryConnection(bool);
                            int i20 = columnIndexOrThrow28;
                            if (query.isNull(i20)) {
                                columnIndexOrThrow28 = i20;
                                num15 = null;
                            } else {
                                columnIndexOrThrow28 = i20;
                                num15 = Integer.valueOf(query.getInt(i20));
                            }
                            mNSIEntity.setResourcesMnc(num15);
                            int i21 = columnIndexOrThrow29;
                            if (query.isNull(i21)) {
                                columnIndexOrThrow29 = i21;
                                num16 = null;
                            } else {
                                columnIndexOrThrow29 = i21;
                                num16 = Integer.valueOf(query.getInt(i21));
                            }
                            mNSIEntity.setResourcesMcc(num16);
                            int i22 = columnIndexOrThrow30;
                            if (query.isNull(i22)) {
                                columnIndexOrThrow30 = i22;
                                num17 = null;
                            } else {
                                columnIndexOrThrow30 = i22;
                                num17 = Integer.valueOf(query.getInt(i22));
                            }
                            mNSIEntity.setRegistered(num17);
                            int i23 = columnIndexOrThrow31;
                            if (query.isNull(i23)) {
                                columnIndexOrThrow31 = i23;
                                num18 = null;
                            } else {
                                columnIndexOrThrow31 = i23;
                                num18 = Integer.valueOf(query.getInt(i23));
                            }
                            mNSIEntity.setLteSignalStrength(num18);
                            int i24 = columnIndexOrThrow32;
                            if (query.isNull(i24)) {
                                columnIndexOrThrow32 = i24;
                                num19 = null;
                            } else {
                                columnIndexOrThrow32 = i24;
                                num19 = Integer.valueOf(query.getInt(i24));
                            }
                            mNSIEntity.setLteRsrp(num19);
                            int i25 = columnIndexOrThrow33;
                            if (query.isNull(i25)) {
                                columnIndexOrThrow33 = i25;
                                num20 = null;
                            } else {
                                columnIndexOrThrow33 = i25;
                                num20 = Integer.valueOf(query.getInt(i25));
                            }
                            mNSIEntity.setLteRsrq(num20);
                            int i26 = columnIndexOrThrow34;
                            if (query.isNull(i26)) {
                                columnIndexOrThrow34 = i26;
                                num21 = null;
                            } else {
                                columnIndexOrThrow34 = i26;
                                num21 = Integer.valueOf(query.getInt(i26));
                            }
                            mNSIEntity.setLteRssnr(num21);
                            int i27 = columnIndexOrThrow35;
                            if (query.isNull(i27)) {
                                columnIndexOrThrow35 = i27;
                                num22 = null;
                            } else {
                                columnIndexOrThrow35 = i27;
                                num22 = Integer.valueOf(query.getInt(i27));
                            }
                            mNSIEntity.setLteRssi(num22);
                            int i28 = columnIndexOrThrow36;
                            if (query.isNull(i28)) {
                                columnIndexOrThrow36 = i28;
                                str9 = null;
                            } else {
                                columnIndexOrThrow36 = i28;
                                str9 = query.getString(i28);
                            }
                            mNSIEntity.setLteBand(str9);
                            int i29 = columnIndexOrThrow37;
                            if (query.isNull(i29)) {
                                columnIndexOrThrow37 = i29;
                                num23 = null;
                            } else {
                                columnIndexOrThrow37 = i29;
                                num23 = Integer.valueOf(query.getInt(i29));
                            }
                            mNSIEntity.setLteCqi(num23);
                            int i30 = columnIndexOrThrow38;
                            if (query.isNull(i30)) {
                                columnIndexOrThrow38 = i30;
                                num24 = null;
                            } else {
                                columnIndexOrThrow38 = i30;
                                num24 = Integer.valueOf(query.getInt(i30));
                            }
                            mNSIEntity.setLteDbm(num24);
                            int i31 = columnIndexOrThrow39;
                            if (query.isNull(i31)) {
                                columnIndexOrThrow39 = i31;
                                num25 = null;
                            } else {
                                columnIndexOrThrow39 = i31;
                                num25 = Integer.valueOf(query.getInt(i31));
                            }
                            mNSIEntity.setLteAsu(num25);
                            int i32 = columnIndexOrThrow40;
                            if (query.isNull(i32)) {
                                columnIndexOrThrow40 = i32;
                                num26 = null;
                            } else {
                                columnIndexOrThrow40 = i32;
                                num26 = Integer.valueOf(query.getInt(i32));
                            }
                            mNSIEntity.setCdmaDbm(num26);
                            int i33 = columnIndexOrThrow41;
                            if (query.isNull(i33)) {
                                columnIndexOrThrow41 = i33;
                                num27 = null;
                            } else {
                                columnIndexOrThrow41 = i33;
                                num27 = Integer.valueOf(query.getInt(i33));
                            }
                            mNSIEntity.setCdmaAsu(num27);
                            int i34 = columnIndexOrThrow42;
                            if (query.isNull(i34)) {
                                columnIndexOrThrow42 = i34;
                                num28 = null;
                            } else {
                                columnIndexOrThrow42 = i34;
                                num28 = Integer.valueOf(query.getInt(i34));
                            }
                            mNSIEntity.setCdmaEcio(num28);
                            int i35 = columnIndexOrThrow43;
                            if (query.isNull(i35)) {
                                columnIndexOrThrow43 = i35;
                                num29 = null;
                            } else {
                                columnIndexOrThrow43 = i35;
                                num29 = Integer.valueOf(query.getInt(i35));
                            }
                            mNSIEntity.setEvdoDbm(num29);
                            int i36 = columnIndexOrThrow44;
                            if (query.isNull(i36)) {
                                columnIndexOrThrow44 = i36;
                                num30 = null;
                            } else {
                                columnIndexOrThrow44 = i36;
                                num30 = Integer.valueOf(query.getInt(i36));
                            }
                            mNSIEntity.setEvdoAsu(num30);
                            int i37 = columnIndexOrThrow45;
                            if (query.isNull(i37)) {
                                columnIndexOrThrow45 = i37;
                                num31 = null;
                            } else {
                                columnIndexOrThrow45 = i37;
                                num31 = Integer.valueOf(query.getInt(i37));
                            }
                            mNSIEntity.setEvdoEcio(num31);
                            int i38 = columnIndexOrThrow46;
                            if (query.isNull(i38)) {
                                columnIndexOrThrow46 = i38;
                                num32 = null;
                            } else {
                                columnIndexOrThrow46 = i38;
                                num32 = Integer.valueOf(query.getInt(i38));
                            }
                            mNSIEntity.setEvdoSnr(num32);
                            int i39 = columnIndexOrThrow47;
                            if (query.isNull(i39)) {
                                columnIndexOrThrow47 = i39;
                                f2 = null;
                            } else {
                                columnIndexOrThrow47 = i39;
                                f2 = Float.valueOf(query.getFloat(i39));
                            }
                            mNSIEntity.setBarometric(f2);
                            int i40 = columnIndexOrThrow48;
                            if (query.isNull(i40)) {
                                columnIndexOrThrow48 = i40;
                                num33 = null;
                            } else {
                                columnIndexOrThrow48 = i40;
                                num33 = Integer.valueOf(query.getInt(i40));
                            }
                            mNSIEntity.setGsmDbm(num33);
                            int i41 = columnIndexOrThrow49;
                            if (query.isNull(i41)) {
                                columnIndexOrThrow49 = i41;
                                num34 = null;
                            } else {
                                columnIndexOrThrow49 = i41;
                                num34 = Integer.valueOf(query.getInt(i41));
                            }
                            mNSIEntity.setGsmAsu(num34);
                            int i42 = columnIndexOrThrow50;
                            if (query.isNull(i42)) {
                                columnIndexOrThrow50 = i42;
                                num35 = null;
                            } else {
                                columnIndexOrThrow50 = i42;
                                num35 = Integer.valueOf(query.getInt(i42));
                            }
                            mNSIEntity.setGsmBitError(num35);
                            int i43 = columnIndexOrThrow51;
                            if (query.isNull(i43)) {
                                columnIndexOrThrow51 = i43;
                                num36 = null;
                            } else {
                                columnIndexOrThrow51 = i43;
                                num36 = Integer.valueOf(query.getInt(i43));
                            }
                            mNSIEntity.setTdscdmaDbm(num36);
                            int i44 = columnIndexOrThrow52;
                            if (query.isNull(i44)) {
                                columnIndexOrThrow52 = i44;
                                num37 = null;
                            } else {
                                columnIndexOrThrow52 = i44;
                                num37 = Integer.valueOf(query.getInt(i44));
                            }
                            mNSIEntity.setTdscdmaAsu(num37);
                            int i45 = columnIndexOrThrow53;
                            if (query.isNull(i45)) {
                                columnIndexOrThrow53 = i45;
                                num38 = null;
                            } else {
                                columnIndexOrThrow53 = i45;
                                num38 = Integer.valueOf(query.getInt(i45));
                            }
                            mNSIEntity.setGpsAvailable(num38);
                            int i46 = columnIndexOrThrow54;
                            if (query.isNull(i46)) {
                                columnIndexOrThrow54 = i46;
                                num39 = null;
                            } else {
                                columnIndexOrThrow54 = i46;
                                num39 = Integer.valueOf(query.getInt(i46));
                            }
                            mNSIEntity.setLteCi(num39);
                            int i47 = columnIndexOrThrow55;
                            if (query.isNull(i47)) {
                                columnIndexOrThrow55 = i47;
                                num40 = null;
                            } else {
                                columnIndexOrThrow55 = i47;
                                num40 = Integer.valueOf(query.getInt(i47));
                            }
                            mNSIEntity.setLtePci(num40);
                            int i48 = columnIndexOrThrow56;
                            if (query.isNull(i48)) {
                                columnIndexOrThrow56 = i48;
                                num41 = null;
                            } else {
                                columnIndexOrThrow56 = i48;
                                num41 = Integer.valueOf(query.getInt(i48));
                            }
                            mNSIEntity.setLteTac(num41);
                            int i49 = columnIndexOrThrow57;
                            if (query.isNull(i49)) {
                                columnIndexOrThrow57 = i49;
                                num42 = null;
                            } else {
                                columnIndexOrThrow57 = i49;
                                num42 = Integer.valueOf(query.getInt(i49));
                            }
                            mNSIEntity.setWcdmaDbm(num42);
                            int i50 = columnIndexOrThrow58;
                            if (query.isNull(i50)) {
                                columnIndexOrThrow58 = i50;
                                num43 = null;
                            } else {
                                columnIndexOrThrow58 = i50;
                                num43 = Integer.valueOf(query.getInt(i50));
                            }
                            mNSIEntity.setWcdmaAsu(num43);
                            int i51 = columnIndexOrThrow59;
                            if (query.isNull(i51)) {
                                columnIndexOrThrow59 = i51;
                                num44 = null;
                            } else {
                                columnIndexOrThrow59 = i51;
                                num44 = Integer.valueOf(query.getInt(i51));
                            }
                            mNSIEntity.setWcdmaCid(num44);
                            int i52 = columnIndexOrThrow60;
                            if (query.isNull(i52)) {
                                columnIndexOrThrow60 = i52;
                                num45 = null;
                            } else {
                                columnIndexOrThrow60 = i52;
                                num45 = Integer.valueOf(query.getInt(i52));
                            }
                            mNSIEntity.setWcdmaLac(num45);
                            int i53 = columnIndexOrThrow61;
                            if (query.isNull(i53)) {
                                columnIndexOrThrow61 = i53;
                                num46 = null;
                            } else {
                                columnIndexOrThrow61 = i53;
                                num46 = Integer.valueOf(query.getInt(i53));
                            }
                            mNSIEntity.setWcdmaPsc(num46);
                            int i54 = columnIndexOrThrow62;
                            if (query.isNull(i54)) {
                                columnIndexOrThrow62 = i54;
                                num47 = null;
                            } else {
                                columnIndexOrThrow62 = i54;
                                num47 = Integer.valueOf(query.getInt(i54));
                            }
                            mNSIEntity.setRoaming(num47);
                            int i55 = columnIndexOrThrow;
                            int i56 = columnIndexOrThrow63;
                            mNSIEntity.setNetworkType(query.getInt(i56));
                            columnIndexOrThrow63 = i56;
                            int i57 = columnIndexOrThrow64;
                            mNSIEntity.setDataNetworkType(query.getInt(i57));
                            columnIndexOrThrow64 = i57;
                            int i58 = columnIndexOrThrow65;
                            mNSIEntity.setVoiceNetworkType(query.getInt(i58));
                            int i59 = columnIndexOrThrow66;
                            if (query.isNull(i59)) {
                                i3 = i58;
                                num48 = null;
                            } else {
                                i3 = i58;
                                num48 = Integer.valueOf(query.getInt(i59));
                            }
                            mNSIEntity.setLteTimingAdvance(num48);
                            int i60 = columnIndexOrThrow67;
                            if (query.isNull(i60)) {
                                columnIndexOrThrow67 = i60;
                                l3 = null;
                            } else {
                                columnIndexOrThrow67 = i60;
                                l3 = Long.valueOf(query.getLong(i60));
                            }
                            mNSIEntity.setDataRX(l3);
                            int i61 = columnIndexOrThrow68;
                            if (query.isNull(i61)) {
                                columnIndexOrThrow68 = i61;
                                l4 = null;
                            } else {
                                columnIndexOrThrow68 = i61;
                                l4 = Long.valueOf(query.getLong(i61));
                            }
                            mNSIEntity.setDataTX(l4);
                            int i62 = columnIndexOrThrow69;
                            if (query.isNull(i62)) {
                                columnIndexOrThrow69 = i62;
                                num49 = null;
                            } else {
                                columnIndexOrThrow69 = i62;
                                num49 = Integer.valueOf(query.getInt(i62));
                            }
                            mNSIEntity.setNrAsuLevel(num49);
                            int i63 = columnIndexOrThrow70;
                            if (query.isNull(i63)) {
                                columnIndexOrThrow70 = i63;
                                num50 = null;
                            } else {
                                columnIndexOrThrow70 = i63;
                                num50 = Integer.valueOf(query.getInt(i63));
                            }
                            mNSIEntity.setNrCsiRsrp(num50);
                            int i64 = columnIndexOrThrow71;
                            if (query.isNull(i64)) {
                                columnIndexOrThrow71 = i64;
                                num51 = null;
                            } else {
                                columnIndexOrThrow71 = i64;
                                num51 = Integer.valueOf(query.getInt(i64));
                            }
                            mNSIEntity.setNrCsiRsrq(num51);
                            int i65 = columnIndexOrThrow72;
                            if (query.isNull(i65)) {
                                columnIndexOrThrow72 = i65;
                                num52 = null;
                            } else {
                                columnIndexOrThrow72 = i65;
                                num52 = Integer.valueOf(query.getInt(i65));
                            }
                            mNSIEntity.setNrCsiSinr(num52);
                            int i66 = columnIndexOrThrow73;
                            if (query.isNull(i66)) {
                                columnIndexOrThrow73 = i66;
                                num53 = null;
                            } else {
                                columnIndexOrThrow73 = i66;
                                num53 = Integer.valueOf(query.getInt(i66));
                            }
                            mNSIEntity.setNrDbm(num53);
                            int i67 = columnIndexOrThrow74;
                            if (query.isNull(i67)) {
                                columnIndexOrThrow74 = i67;
                                num54 = null;
                            } else {
                                columnIndexOrThrow74 = i67;
                                num54 = Integer.valueOf(query.getInt(i67));
                            }
                            mNSIEntity.setNrLevel(num54);
                            int i68 = columnIndexOrThrow75;
                            if (query.isNull(i68)) {
                                columnIndexOrThrow75 = i68;
                                num55 = null;
                            } else {
                                columnIndexOrThrow75 = i68;
                                num55 = Integer.valueOf(query.getInt(i68));
                            }
                            mNSIEntity.setNrSsRsrp(num55);
                            int i69 = columnIndexOrThrow76;
                            if (query.isNull(i69)) {
                                columnIndexOrThrow76 = i69;
                                num56 = null;
                            } else {
                                columnIndexOrThrow76 = i69;
                                num56 = Integer.valueOf(query.getInt(i69));
                            }
                            mNSIEntity.setNrSsRsrq(num56);
                            int i70 = columnIndexOrThrow77;
                            if (query.isNull(i70)) {
                                columnIndexOrThrow77 = i70;
                                num57 = null;
                            } else {
                                columnIndexOrThrow77 = i70;
                                num57 = Integer.valueOf(query.getInt(i70));
                            }
                            mNSIEntity.setNrSsSinr(num57);
                            int i71 = columnIndexOrThrow78;
                            if (query.isNull(i71)) {
                                columnIndexOrThrow78 = i71;
                                num58 = null;
                            } else {
                                columnIndexOrThrow78 = i71;
                                num58 = Integer.valueOf(query.getInt(i71));
                            }
                            mNSIEntity.setCompleteness(num58);
                            int i72 = columnIndexOrThrow79;
                            if (query.isNull(i72)) {
                                columnIndexOrThrow79 = i72;
                                str10 = null;
                            } else {
                                columnIndexOrThrow79 = i72;
                                str10 = query.getString(i72);
                            }
                            mNSIEntity.setNrBand(str10);
                            int i73 = columnIndexOrThrow80;
                            if (query.isNull(i73)) {
                                columnIndexOrThrow80 = i73;
                                str11 = null;
                            } else {
                                columnIndexOrThrow80 = i73;
                                str11 = query.getString(i73);
                            }
                            mNSIEntity.setPermissions(str11);
                            int i74 = columnIndexOrThrow81;
                            if (query.isNull(i74)) {
                                columnIndexOrThrow81 = i74;
                                l5 = null;
                            } else {
                                columnIndexOrThrow81 = i74;
                                l5 = Long.valueOf(query.getLong(i74));
                            }
                            mNSIEntity.setCelltowerInfoTimestamp(l5);
                            int i75 = columnIndexOrThrow82;
                            if (query.isNull(i75)) {
                                columnIndexOrThrow82 = i75;
                                num59 = null;
                            } else {
                                columnIndexOrThrow82 = i75;
                                num59 = Integer.valueOf(query.getInt(i75));
                            }
                            mNSIEntity.setBaseStationId(num59);
                            int i76 = columnIndexOrThrow83;
                            if (query.isNull(i76)) {
                                columnIndexOrThrow83 = i76;
                                d = null;
                            } else {
                                columnIndexOrThrow83 = i76;
                                d = Double.valueOf(query.getDouble(i76));
                            }
                            mNSIEntity.setBaseStationLatitude(d);
                            int i77 = columnIndexOrThrow84;
                            if (query.isNull(i77)) {
                                columnIndexOrThrow84 = i77;
                                d2 = null;
                            } else {
                                columnIndexOrThrow84 = i77;
                                d2 = Double.valueOf(query.getDouble(i77));
                            }
                            mNSIEntity.setBaseStationLongitude(d2);
                            int i78 = columnIndexOrThrow85;
                            if (query.isNull(i78)) {
                                columnIndexOrThrow85 = i78;
                                num60 = null;
                            } else {
                                columnIndexOrThrow85 = i78;
                                num60 = Integer.valueOf(query.getInt(i78));
                            }
                            mNSIEntity.setNetworkId(num60);
                            int i79 = columnIndexOrThrow86;
                            if (query.isNull(i79)) {
                                columnIndexOrThrow86 = i79;
                                num61 = null;
                            } else {
                                columnIndexOrThrow86 = i79;
                                num61 = Integer.valueOf(query.getInt(i79));
                            }
                            mNSIEntity.setSystemId(num61);
                            int i80 = columnIndexOrThrow87;
                            if (query.isNull(i80)) {
                                columnIndexOrThrow87 = i80;
                                num62 = null;
                            } else {
                                columnIndexOrThrow87 = i80;
                                num62 = Integer.valueOf(query.getInt(i80));
                            }
                            mNSIEntity.setCid(num62);
                            int i81 = columnIndexOrThrow88;
                            if (query.isNull(i81)) {
                                columnIndexOrThrow88 = i81;
                                num63 = null;
                            } else {
                                columnIndexOrThrow88 = i81;
                                num63 = Integer.valueOf(query.getInt(i81));
                            }
                            mNSIEntity.setLac(num63);
                            int i82 = columnIndexOrThrow89;
                            if (query.isNull(i82)) {
                                columnIndexOrThrow89 = i82;
                                num64 = null;
                            } else {
                                columnIndexOrThrow89 = i82;
                                num64 = Integer.valueOf(query.getInt(i82));
                            }
                            mNSIEntity.setGsmArfcn(num64);
                            int i83 = columnIndexOrThrow90;
                            if (query.isNull(i83)) {
                                columnIndexOrThrow90 = i83;
                                num65 = null;
                            } else {
                                columnIndexOrThrow90 = i83;
                                num65 = Integer.valueOf(query.getInt(i83));
                            }
                            mNSIEntity.setGsmBsic(num65);
                            int i84 = columnIndexOrThrow91;
                            if (query.isNull(i84)) {
                                columnIndexOrThrow91 = i84;
                                num66 = null;
                            } else {
                                columnIndexOrThrow91 = i84;
                                num66 = Integer.valueOf(query.getInt(i84));
                            }
                            mNSIEntity.setLteEarfcn(num66);
                            int i85 = columnIndexOrThrow92;
                            if (query.isNull(i85)) {
                                columnIndexOrThrow92 = i85;
                                num67 = null;
                            } else {
                                columnIndexOrThrow92 = i85;
                                num67 = Integer.valueOf(query.getInt(i85));
                            }
                            mNSIEntity.setLteBandwidth(num67);
                            int i86 = columnIndexOrThrow93;
                            if (query.isNull(i86)) {
                                columnIndexOrThrow93 = i86;
                                num68 = null;
                            } else {
                                columnIndexOrThrow93 = i86;
                                num68 = Integer.valueOf(query.getInt(i86));
                            }
                            mNSIEntity.setPsc(num68);
                            int i87 = columnIndexOrThrow94;
                            if (query.isNull(i87)) {
                                columnIndexOrThrow94 = i87;
                                num69 = null;
                            } else {
                                columnIndexOrThrow94 = i87;
                                num69 = Integer.valueOf(query.getInt(i87));
                            }
                            mNSIEntity.setWcdmaUarfcn(num69);
                            int i88 = columnIndexOrThrow95;
                            if (query.isNull(i88)) {
                                columnIndexOrThrow95 = i88;
                                l6 = null;
                            } else {
                                columnIndexOrThrow95 = i88;
                                l6 = Long.valueOf(query.getLong(i88));
                            }
                            mNSIEntity.setNrNci(l6);
                            int i89 = columnIndexOrThrow96;
                            if (query.isNull(i89)) {
                                columnIndexOrThrow96 = i89;
                                num70 = null;
                            } else {
                                columnIndexOrThrow96 = i89;
                                num70 = Integer.valueOf(query.getInt(i89));
                            }
                            mNSIEntity.setNrArfcn(num70);
                            int i90 = columnIndexOrThrow97;
                            if (query.isNull(i90)) {
                                columnIndexOrThrow97 = i90;
                                num71 = null;
                            } else {
                                columnIndexOrThrow97 = i90;
                                num71 = Integer.valueOf(query.getInt(i90));
                            }
                            mNSIEntity.setNrPci(num71);
                            int i91 = columnIndexOrThrow98;
                            if (query.isNull(i91)) {
                                columnIndexOrThrow98 = i91;
                                num72 = null;
                            } else {
                                columnIndexOrThrow98 = i91;
                                num72 = Integer.valueOf(query.getInt(i91));
                            }
                            mNSIEntity.setNrTac(num72);
                            int i92 = columnIndexOrThrow99;
                            if (query.isNull(i92)) {
                                columnIndexOrThrow99 = i92;
                                num73 = null;
                            } else {
                                columnIndexOrThrow99 = i92;
                                num73 = Integer.valueOf(query.getInt(i92));
                            }
                            mNSIEntity.setTimeZoneOffset(num73);
                            int i93 = columnIndexOrThrow100;
                            if (query.isNull(i93)) {
                                columnIndexOrThrow100 = i93;
                                l7 = null;
                            } else {
                                columnIndexOrThrow100 = i93;
                                l7 = Long.valueOf(query.getLong(i93));
                            }
                            mNSIEntity.setSecondaryNrNci(l7);
                            int i94 = columnIndexOrThrow101;
                            if (query.isNull(i94)) {
                                columnIndexOrThrow101 = i94;
                                num74 = null;
                            } else {
                                columnIndexOrThrow101 = i94;
                                num74 = Integer.valueOf(query.getInt(i94));
                            }
                            mNSIEntity.setCarrierAgregationUsed(num74);
                            int i95 = columnIndexOrThrow102;
                            if (query.isNull(i95)) {
                                columnIndexOrThrow102 = i95;
                                num75 = null;
                            } else {
                                columnIndexOrThrow102 = i95;
                                num75 = Integer.valueOf(query.getInt(i95));
                            }
                            mNSIEntity.setConnectivityTo5G(num75);
                            int i96 = columnIndexOrThrow103;
                            if (query.isNull(i96)) {
                                columnIndexOrThrow103 = i96;
                                d3 = null;
                            } else {
                                columnIndexOrThrow103 = i96;
                                d3 = Double.valueOf(query.getDouble(i96));
                            }
                            mNSIEntity.setLatitude(d3);
                            int i97 = columnIndexOrThrow104;
                            if (query.isNull(i97)) {
                                columnIndexOrThrow104 = i97;
                                d4 = null;
                            } else {
                                columnIndexOrThrow104 = i97;
                                d4 = Double.valueOf(query.getDouble(i97));
                            }
                            mNSIEntity.setLongitude(d4);
                            int i98 = columnIndexOrThrow105;
                            if (query.isNull(i98)) {
                                columnIndexOrThrow105 = i98;
                                d5 = null;
                            } else {
                                columnIndexOrThrow105 = i98;
                                d5 = Double.valueOf(query.getDouble(i98));
                            }
                            mNSIEntity.setIndoorOutdoorWeight(d5);
                            int i99 = columnIndexOrThrow106;
                            if (query.isNull(i99)) {
                                columnIndexOrThrow106 = i99;
                                num76 = null;
                            } else {
                                columnIndexOrThrow106 = i99;
                                num76 = Integer.valueOf(query.getInt(i99));
                            }
                            mNSIEntity.setOverrideNetworkType(num76);
                            arrayList = arrayList2;
                            arrayList.add(mNSIEntity);
                            columnIndexOrThrow65 = i3;
                            columnIndexOrThrow66 = i59;
                            columnIndexOrThrow = i55;
                            columnIndexOrThrow14 = i2;
                            i4 = i;
                        }
                        query.close();
                        acquire.release();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        r3 = this;
                        Throwable th2 = th;
                        query.close();
                        acquire.release();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r3 = this;
                    Throwable th22 = th;
                    query.close();
                    acquire.release();
                    throw th22;
                }
            }
        }, continuation);
    }

    public Object getMNSIEntries(long j, long j2, Continuation<? super List<? extends MNSIEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM mnsi_tbl WHERE timeStamp >= ? AND timeStamp <= ?", 2);
        acquire.bindLong(1, j);
        acquire.bindLong(2, j2);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends MNSIEntity>>() {
            public List<? extends MNSIEntity> call() {
                AnonymousClass14 r3;
                Long l;
                String str;
                String str2;
                String str3;
                Integer num;
                Integer num2;
                Integer num3;
                Integer num4;
                Integer num5;
                Integer num6;
                int i;
                Integer num7;
                int i2;
                Long l2;
                String str4;
                Float f;
                String str5;
                String str6;
                Integer num8;
                Integer num9;
                String str7;
                String str8;
                Integer num10;
                Integer num11;
                Integer num12;
                Integer num13;
                Integer num14;
                Boolean bool;
                Integer num15;
                Integer num16;
                Integer num17;
                Integer num18;
                Integer num19;
                Integer num20;
                Integer num21;
                Integer num22;
                String str9;
                Integer num23;
                Integer num24;
                Integer num25;
                Integer num26;
                Integer num27;
                Integer num28;
                Integer num29;
                Integer num30;
                Integer num31;
                Integer num32;
                Float f2;
                Integer num33;
                Integer num34;
                Integer num35;
                Integer num36;
                Integer num37;
                Integer num38;
                Integer num39;
                Integer num40;
                Integer num41;
                Integer num42;
                Integer num43;
                Integer num44;
                Integer num45;
                Integer num46;
                Integer num47;
                int i3;
                Integer num48;
                Long l3;
                Long l4;
                Integer num49;
                Integer num50;
                Integer num51;
                Integer num52;
                Integer num53;
                Integer num54;
                Integer num55;
                Integer num56;
                Integer num57;
                Integer num58;
                String str10;
                String str11;
                Long l5;
                Integer num59;
                Double d;
                Double d2;
                Integer num60;
                Integer num61;
                Integer num62;
                Integer num63;
                Integer num64;
                Integer num65;
                Integer num66;
                Integer num67;
                Integer num68;
                Integer num69;
                Long l6;
                Integer num70;
                Integer num71;
                Integer num72;
                Integer num73;
                Long l7;
                Integer num74;
                Integer num75;
                Double d3;
                Double d4;
                Double d5;
                Integer num76;
                Cursor query = DBUtil.query(MNSIDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "timeStamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "timeZone");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "phoneType");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "networkTypeString");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "asu");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "ecio");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "rsrp");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "rsrq");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "bitErrorRate");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaBitErrorRate");
                    try {
                        int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "locationTimeStamp");
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "locationProvider");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "accuracy");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "networkCountryIso");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "networkMnc");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "networkMcc");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "simOperatorName");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "simCountryIso");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "simMnc");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "simMcc");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "simSlot");
                        int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "isDataDefaultSim");
                        int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "isPrimaryConnection");
                        int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "resourcesMnc");
                        int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "resourcesMcc");
                        int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "registered");
                        int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "lteSignalStrength");
                        int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "lteRsrp");
                        int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "lteRsrq");
                        int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "lteRssnr");
                        int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "lteRssi");
                        int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "lteBand");
                        int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "lteCqi");
                        int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "lteDbm");
                        int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "lteAsu");
                        int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "cdmaDbm");
                        int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "cdmaAsu");
                        int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "cdmaEcio");
                        int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "evdoDbm");
                        int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "evdoAsu");
                        int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "evdoEcio");
                        int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "evdoSnr");
                        int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "barometric");
                        int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "gsmDbm");
                        int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "gsmAsu");
                        int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "gsmBitError");
                        int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "tdscdmaDbm");
                        int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "tdscdmaAsu");
                        int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "gpsAvailable");
                        int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "lteCi");
                        int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "ltePci");
                        int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "lteTac");
                        int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaDbm");
                        int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaAsu");
                        int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaCid");
                        int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaLac");
                        int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaPsc");
                        int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "roaming");
                        int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "networkType");
                        int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "dataNetworkType");
                        int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "voiceNetworkType");
                        int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "lteTimingAdvance");
                        int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "dataRX");
                        int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "dataTX");
                        int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "nrAsuLevel");
                        int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "nrCsiRsrp");
                        int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "nrCsiRsrq");
                        int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "nrCsiSinr");
                        int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "nrDbm");
                        int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "nrLevel");
                        int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "nrSsRsrp");
                        int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "nrSsRsrq");
                        int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "nrSsSinr");
                        int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "completeness");
                        int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "nrBand");
                        int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "celltowerInfoTimestamp");
                        int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "baseStationId");
                        int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "baseStationLatitude");
                        int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "baseStationLongitude");
                        int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "networkId");
                        int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "systemId");
                        int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, CmcdConfiguration.KEY_CONTENT_ID);
                        int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "lac");
                        int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "gsmArfcn");
                        int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "gsmBsic");
                        int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "lteEarfcn");
                        int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "lteBandwidth");
                        int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "psc");
                        int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaUarfcn");
                        int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "nrNci");
                        int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "nrArfcn");
                        int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "nrPci");
                        int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "nrTac");
                        int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneOffset");
                        int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "secondaryNrNci");
                        int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                        int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "is5GConnected");
                        int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                        int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                        int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "indoorOutdoorWeight");
                        int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                        int i4 = columnIndexOrThrow13;
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            MNSIEntity mNSIEntity = new MNSIEntity();
                            ArrayList arrayList2 = arrayList;
                            mNSIEntity.setId(query.getInt(columnIndexOrThrow));
                            mNSIEntity.setTransmitted(query.getInt(columnIndexOrThrow2));
                            if (query.isNull(columnIndexOrThrow3)) {
                                l = null;
                            } else {
                                l = Long.valueOf(query.getLong(columnIndexOrThrow3));
                            }
                            mNSIEntity.setTimeStamp(l);
                            if (query.isNull(columnIndexOrThrow4)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow4);
                            }
                            mNSIEntity.setTimeZone(str);
                            if (query.isNull(columnIndexOrThrow5)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow5);
                            }
                            mNSIEntity.setPhoneType(str2);
                            if (query.isNull(columnIndexOrThrow6)) {
                                str3 = null;
                            } else {
                                str3 = query.getString(columnIndexOrThrow6);
                            }
                            mNSIEntity.setNetworkTypeString(str3);
                            if (query.isNull(columnIndexOrThrow7)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                            }
                            mNSIEntity.setDbm(num);
                            if (query.isNull(columnIndexOrThrow8)) {
                                num2 = null;
                            } else {
                                num2 = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                            }
                            mNSIEntity.setAsu(num2);
                            if (query.isNull(columnIndexOrThrow9)) {
                                num3 = null;
                            } else {
                                num3 = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                            }
                            mNSIEntity.setEcio(num3);
                            if (query.isNull(columnIndexOrThrow10)) {
                                num4 = null;
                            } else {
                                num4 = Integer.valueOf(query.getInt(columnIndexOrThrow10));
                            }
                            mNSIEntity.setRsrp(num4);
                            if (query.isNull(columnIndexOrThrow11)) {
                                num5 = null;
                            } else {
                                num5 = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                            }
                            mNSIEntity.setRsrq(num5);
                            if (query.isNull(columnIndexOrThrow12)) {
                                num6 = null;
                            } else {
                                num6 = Integer.valueOf(query.getInt(columnIndexOrThrow12));
                            }
                            mNSIEntity.setBitErrorRate(num6);
                            int i5 = i4;
                            if (query.isNull(i5)) {
                                i = i5;
                                num7 = null;
                            } else {
                                i = i5;
                                num7 = Integer.valueOf(query.getInt(i5));
                            }
                            mNSIEntity.setWcdmaBitErrorRate(num7);
                            int i6 = columnIndexOrThrow14;
                            if (query.isNull(i6)) {
                                i2 = i6;
                                l2 = null;
                            } else {
                                i2 = i6;
                                l2 = Long.valueOf(query.getLong(i6));
                            }
                            mNSIEntity.setLocationTimeStamp(l2);
                            int i7 = columnIndexOrThrow15;
                            if (query.isNull(i7)) {
                                columnIndexOrThrow15 = i7;
                                str4 = null;
                            } else {
                                columnIndexOrThrow15 = i7;
                                str4 = query.getString(i7);
                            }
                            mNSIEntity.setLocationProvider(str4);
                            int i8 = columnIndexOrThrow16;
                            if (query.isNull(i8)) {
                                columnIndexOrThrow16 = i8;
                                f = null;
                            } else {
                                columnIndexOrThrow16 = i8;
                                f = Float.valueOf(query.getFloat(i8));
                            }
                            mNSIEntity.setAccuracy(f);
                            int i9 = columnIndexOrThrow17;
                            if (query.isNull(i9)) {
                                columnIndexOrThrow17 = i9;
                                str5 = null;
                            } else {
                                columnIndexOrThrow17 = i9;
                                str5 = query.getString(i9);
                            }
                            mNSIEntity.setNetworkOperatorName(str5);
                            int i10 = columnIndexOrThrow18;
                            if (query.isNull(i10)) {
                                columnIndexOrThrow18 = i10;
                                str6 = null;
                            } else {
                                columnIndexOrThrow18 = i10;
                                str6 = query.getString(i10);
                            }
                            mNSIEntity.setNetworkCountryIso(str6);
                            int i11 = columnIndexOrThrow19;
                            if (query.isNull(i11)) {
                                columnIndexOrThrow19 = i11;
                                num8 = null;
                            } else {
                                columnIndexOrThrow19 = i11;
                                num8 = Integer.valueOf(query.getInt(i11));
                            }
                            mNSIEntity.setNetworkMnc(num8);
                            int i12 = columnIndexOrThrow20;
                            if (query.isNull(i12)) {
                                columnIndexOrThrow20 = i12;
                                num9 = null;
                            } else {
                                columnIndexOrThrow20 = i12;
                                num9 = Integer.valueOf(query.getInt(i12));
                            }
                            mNSIEntity.setNetworkMcc(num9);
                            int i13 = columnIndexOrThrow21;
                            if (query.isNull(i13)) {
                                columnIndexOrThrow21 = i13;
                                str7 = null;
                            } else {
                                columnIndexOrThrow21 = i13;
                                str7 = query.getString(i13);
                            }
                            mNSIEntity.setSimOperatorName(str7);
                            int i14 = columnIndexOrThrow22;
                            if (query.isNull(i14)) {
                                columnIndexOrThrow22 = i14;
                                str8 = null;
                            } else {
                                columnIndexOrThrow22 = i14;
                                str8 = query.getString(i14);
                            }
                            mNSIEntity.setSimCountryIso(str8);
                            int i15 = columnIndexOrThrow23;
                            if (query.isNull(i15)) {
                                columnIndexOrThrow23 = i15;
                                num10 = null;
                            } else {
                                columnIndexOrThrow23 = i15;
                                num10 = Integer.valueOf(query.getInt(i15));
                            }
                            mNSIEntity.setSimMnc(num10);
                            int i16 = columnIndexOrThrow24;
                            if (query.isNull(i16)) {
                                columnIndexOrThrow24 = i16;
                                num11 = null;
                            } else {
                                columnIndexOrThrow24 = i16;
                                num11 = Integer.valueOf(query.getInt(i16));
                            }
                            mNSIEntity.setSimMcc(num11);
                            int i17 = columnIndexOrThrow25;
                            if (query.isNull(i17)) {
                                columnIndexOrThrow25 = i17;
                                num12 = null;
                            } else {
                                columnIndexOrThrow25 = i17;
                                num12 = Integer.valueOf(query.getInt(i17));
                            }
                            mNSIEntity.setSimSlot(num12);
                            int i18 = columnIndexOrThrow26;
                            if (query.isNull(i18)) {
                                columnIndexOrThrow26 = i18;
                                num13 = null;
                            } else {
                                columnIndexOrThrow26 = i18;
                                num13 = Integer.valueOf(query.getInt(i18));
                            }
                            mNSIEntity.setIsDataDefaultSim(num13);
                            int i19 = columnIndexOrThrow27;
                            if (query.isNull(i19)) {
                                num14 = null;
                            } else {
                                num14 = Integer.valueOf(query.getInt(i19));
                            }
                            if (num14 == null) {
                                columnIndexOrThrow27 = i19;
                                bool = null;
                            } else {
                                columnIndexOrThrow27 = i19;
                                bool = Boolean.valueOf(num14.intValue() != 0);
                            }
                            mNSIEntity.setPrimaryConnection(bool);
                            int i20 = columnIndexOrThrow28;
                            if (query.isNull(i20)) {
                                columnIndexOrThrow28 = i20;
                                num15 = null;
                            } else {
                                columnIndexOrThrow28 = i20;
                                num15 = Integer.valueOf(query.getInt(i20));
                            }
                            mNSIEntity.setResourcesMnc(num15);
                            int i21 = columnIndexOrThrow29;
                            if (query.isNull(i21)) {
                                columnIndexOrThrow29 = i21;
                                num16 = null;
                            } else {
                                columnIndexOrThrow29 = i21;
                                num16 = Integer.valueOf(query.getInt(i21));
                            }
                            mNSIEntity.setResourcesMcc(num16);
                            int i22 = columnIndexOrThrow30;
                            if (query.isNull(i22)) {
                                columnIndexOrThrow30 = i22;
                                num17 = null;
                            } else {
                                columnIndexOrThrow30 = i22;
                                num17 = Integer.valueOf(query.getInt(i22));
                            }
                            mNSIEntity.setRegistered(num17);
                            int i23 = columnIndexOrThrow31;
                            if (query.isNull(i23)) {
                                columnIndexOrThrow31 = i23;
                                num18 = null;
                            } else {
                                columnIndexOrThrow31 = i23;
                                num18 = Integer.valueOf(query.getInt(i23));
                            }
                            mNSIEntity.setLteSignalStrength(num18);
                            int i24 = columnIndexOrThrow32;
                            if (query.isNull(i24)) {
                                columnIndexOrThrow32 = i24;
                                num19 = null;
                            } else {
                                columnIndexOrThrow32 = i24;
                                num19 = Integer.valueOf(query.getInt(i24));
                            }
                            mNSIEntity.setLteRsrp(num19);
                            int i25 = columnIndexOrThrow33;
                            if (query.isNull(i25)) {
                                columnIndexOrThrow33 = i25;
                                num20 = null;
                            } else {
                                columnIndexOrThrow33 = i25;
                                num20 = Integer.valueOf(query.getInt(i25));
                            }
                            mNSIEntity.setLteRsrq(num20);
                            int i26 = columnIndexOrThrow34;
                            if (query.isNull(i26)) {
                                columnIndexOrThrow34 = i26;
                                num21 = null;
                            } else {
                                columnIndexOrThrow34 = i26;
                                num21 = Integer.valueOf(query.getInt(i26));
                            }
                            mNSIEntity.setLteRssnr(num21);
                            int i27 = columnIndexOrThrow35;
                            if (query.isNull(i27)) {
                                columnIndexOrThrow35 = i27;
                                num22 = null;
                            } else {
                                columnIndexOrThrow35 = i27;
                                num22 = Integer.valueOf(query.getInt(i27));
                            }
                            mNSIEntity.setLteRssi(num22);
                            int i28 = columnIndexOrThrow36;
                            if (query.isNull(i28)) {
                                columnIndexOrThrow36 = i28;
                                str9 = null;
                            } else {
                                columnIndexOrThrow36 = i28;
                                str9 = query.getString(i28);
                            }
                            mNSIEntity.setLteBand(str9);
                            int i29 = columnIndexOrThrow37;
                            if (query.isNull(i29)) {
                                columnIndexOrThrow37 = i29;
                                num23 = null;
                            } else {
                                columnIndexOrThrow37 = i29;
                                num23 = Integer.valueOf(query.getInt(i29));
                            }
                            mNSIEntity.setLteCqi(num23);
                            int i30 = columnIndexOrThrow38;
                            if (query.isNull(i30)) {
                                columnIndexOrThrow38 = i30;
                                num24 = null;
                            } else {
                                columnIndexOrThrow38 = i30;
                                num24 = Integer.valueOf(query.getInt(i30));
                            }
                            mNSIEntity.setLteDbm(num24);
                            int i31 = columnIndexOrThrow39;
                            if (query.isNull(i31)) {
                                columnIndexOrThrow39 = i31;
                                num25 = null;
                            } else {
                                columnIndexOrThrow39 = i31;
                                num25 = Integer.valueOf(query.getInt(i31));
                            }
                            mNSIEntity.setLteAsu(num25);
                            int i32 = columnIndexOrThrow40;
                            if (query.isNull(i32)) {
                                columnIndexOrThrow40 = i32;
                                num26 = null;
                            } else {
                                columnIndexOrThrow40 = i32;
                                num26 = Integer.valueOf(query.getInt(i32));
                            }
                            mNSIEntity.setCdmaDbm(num26);
                            int i33 = columnIndexOrThrow41;
                            if (query.isNull(i33)) {
                                columnIndexOrThrow41 = i33;
                                num27 = null;
                            } else {
                                columnIndexOrThrow41 = i33;
                                num27 = Integer.valueOf(query.getInt(i33));
                            }
                            mNSIEntity.setCdmaAsu(num27);
                            int i34 = columnIndexOrThrow42;
                            if (query.isNull(i34)) {
                                columnIndexOrThrow42 = i34;
                                num28 = null;
                            } else {
                                columnIndexOrThrow42 = i34;
                                num28 = Integer.valueOf(query.getInt(i34));
                            }
                            mNSIEntity.setCdmaEcio(num28);
                            int i35 = columnIndexOrThrow43;
                            if (query.isNull(i35)) {
                                columnIndexOrThrow43 = i35;
                                num29 = null;
                            } else {
                                columnIndexOrThrow43 = i35;
                                num29 = Integer.valueOf(query.getInt(i35));
                            }
                            mNSIEntity.setEvdoDbm(num29);
                            int i36 = columnIndexOrThrow44;
                            if (query.isNull(i36)) {
                                columnIndexOrThrow44 = i36;
                                num30 = null;
                            } else {
                                columnIndexOrThrow44 = i36;
                                num30 = Integer.valueOf(query.getInt(i36));
                            }
                            mNSIEntity.setEvdoAsu(num30);
                            int i37 = columnIndexOrThrow45;
                            if (query.isNull(i37)) {
                                columnIndexOrThrow45 = i37;
                                num31 = null;
                            } else {
                                columnIndexOrThrow45 = i37;
                                num31 = Integer.valueOf(query.getInt(i37));
                            }
                            mNSIEntity.setEvdoEcio(num31);
                            int i38 = columnIndexOrThrow46;
                            if (query.isNull(i38)) {
                                columnIndexOrThrow46 = i38;
                                num32 = null;
                            } else {
                                columnIndexOrThrow46 = i38;
                                num32 = Integer.valueOf(query.getInt(i38));
                            }
                            mNSIEntity.setEvdoSnr(num32);
                            int i39 = columnIndexOrThrow47;
                            if (query.isNull(i39)) {
                                columnIndexOrThrow47 = i39;
                                f2 = null;
                            } else {
                                columnIndexOrThrow47 = i39;
                                f2 = Float.valueOf(query.getFloat(i39));
                            }
                            mNSIEntity.setBarometric(f2);
                            int i40 = columnIndexOrThrow48;
                            if (query.isNull(i40)) {
                                columnIndexOrThrow48 = i40;
                                num33 = null;
                            } else {
                                columnIndexOrThrow48 = i40;
                                num33 = Integer.valueOf(query.getInt(i40));
                            }
                            mNSIEntity.setGsmDbm(num33);
                            int i41 = columnIndexOrThrow49;
                            if (query.isNull(i41)) {
                                columnIndexOrThrow49 = i41;
                                num34 = null;
                            } else {
                                columnIndexOrThrow49 = i41;
                                num34 = Integer.valueOf(query.getInt(i41));
                            }
                            mNSIEntity.setGsmAsu(num34);
                            int i42 = columnIndexOrThrow50;
                            if (query.isNull(i42)) {
                                columnIndexOrThrow50 = i42;
                                num35 = null;
                            } else {
                                columnIndexOrThrow50 = i42;
                                num35 = Integer.valueOf(query.getInt(i42));
                            }
                            mNSIEntity.setGsmBitError(num35);
                            int i43 = columnIndexOrThrow51;
                            if (query.isNull(i43)) {
                                columnIndexOrThrow51 = i43;
                                num36 = null;
                            } else {
                                columnIndexOrThrow51 = i43;
                                num36 = Integer.valueOf(query.getInt(i43));
                            }
                            mNSIEntity.setTdscdmaDbm(num36);
                            int i44 = columnIndexOrThrow52;
                            if (query.isNull(i44)) {
                                columnIndexOrThrow52 = i44;
                                num37 = null;
                            } else {
                                columnIndexOrThrow52 = i44;
                                num37 = Integer.valueOf(query.getInt(i44));
                            }
                            mNSIEntity.setTdscdmaAsu(num37);
                            int i45 = columnIndexOrThrow53;
                            if (query.isNull(i45)) {
                                columnIndexOrThrow53 = i45;
                                num38 = null;
                            } else {
                                columnIndexOrThrow53 = i45;
                                num38 = Integer.valueOf(query.getInt(i45));
                            }
                            mNSIEntity.setGpsAvailable(num38);
                            int i46 = columnIndexOrThrow54;
                            if (query.isNull(i46)) {
                                columnIndexOrThrow54 = i46;
                                num39 = null;
                            } else {
                                columnIndexOrThrow54 = i46;
                                num39 = Integer.valueOf(query.getInt(i46));
                            }
                            mNSIEntity.setLteCi(num39);
                            int i47 = columnIndexOrThrow55;
                            if (query.isNull(i47)) {
                                columnIndexOrThrow55 = i47;
                                num40 = null;
                            } else {
                                columnIndexOrThrow55 = i47;
                                num40 = Integer.valueOf(query.getInt(i47));
                            }
                            mNSIEntity.setLtePci(num40);
                            int i48 = columnIndexOrThrow56;
                            if (query.isNull(i48)) {
                                columnIndexOrThrow56 = i48;
                                num41 = null;
                            } else {
                                columnIndexOrThrow56 = i48;
                                num41 = Integer.valueOf(query.getInt(i48));
                            }
                            mNSIEntity.setLteTac(num41);
                            int i49 = columnIndexOrThrow57;
                            if (query.isNull(i49)) {
                                columnIndexOrThrow57 = i49;
                                num42 = null;
                            } else {
                                columnIndexOrThrow57 = i49;
                                num42 = Integer.valueOf(query.getInt(i49));
                            }
                            mNSIEntity.setWcdmaDbm(num42);
                            int i50 = columnIndexOrThrow58;
                            if (query.isNull(i50)) {
                                columnIndexOrThrow58 = i50;
                                num43 = null;
                            } else {
                                columnIndexOrThrow58 = i50;
                                num43 = Integer.valueOf(query.getInt(i50));
                            }
                            mNSIEntity.setWcdmaAsu(num43);
                            int i51 = columnIndexOrThrow59;
                            if (query.isNull(i51)) {
                                columnIndexOrThrow59 = i51;
                                num44 = null;
                            } else {
                                columnIndexOrThrow59 = i51;
                                num44 = Integer.valueOf(query.getInt(i51));
                            }
                            mNSIEntity.setWcdmaCid(num44);
                            int i52 = columnIndexOrThrow60;
                            if (query.isNull(i52)) {
                                columnIndexOrThrow60 = i52;
                                num45 = null;
                            } else {
                                columnIndexOrThrow60 = i52;
                                num45 = Integer.valueOf(query.getInt(i52));
                            }
                            mNSIEntity.setWcdmaLac(num45);
                            int i53 = columnIndexOrThrow61;
                            if (query.isNull(i53)) {
                                columnIndexOrThrow61 = i53;
                                num46 = null;
                            } else {
                                columnIndexOrThrow61 = i53;
                                num46 = Integer.valueOf(query.getInt(i53));
                            }
                            mNSIEntity.setWcdmaPsc(num46);
                            int i54 = columnIndexOrThrow62;
                            if (query.isNull(i54)) {
                                columnIndexOrThrow62 = i54;
                                num47 = null;
                            } else {
                                columnIndexOrThrow62 = i54;
                                num47 = Integer.valueOf(query.getInt(i54));
                            }
                            mNSIEntity.setRoaming(num47);
                            int i55 = columnIndexOrThrow;
                            int i56 = columnIndexOrThrow63;
                            mNSIEntity.setNetworkType(query.getInt(i56));
                            columnIndexOrThrow63 = i56;
                            int i57 = columnIndexOrThrow64;
                            mNSIEntity.setDataNetworkType(query.getInt(i57));
                            columnIndexOrThrow64 = i57;
                            int i58 = columnIndexOrThrow65;
                            mNSIEntity.setVoiceNetworkType(query.getInt(i58));
                            int i59 = columnIndexOrThrow66;
                            if (query.isNull(i59)) {
                                i3 = i58;
                                num48 = null;
                            } else {
                                i3 = i58;
                                num48 = Integer.valueOf(query.getInt(i59));
                            }
                            mNSIEntity.setLteTimingAdvance(num48);
                            int i60 = columnIndexOrThrow67;
                            if (query.isNull(i60)) {
                                columnIndexOrThrow67 = i60;
                                l3 = null;
                            } else {
                                columnIndexOrThrow67 = i60;
                                l3 = Long.valueOf(query.getLong(i60));
                            }
                            mNSIEntity.setDataRX(l3);
                            int i61 = columnIndexOrThrow68;
                            if (query.isNull(i61)) {
                                columnIndexOrThrow68 = i61;
                                l4 = null;
                            } else {
                                columnIndexOrThrow68 = i61;
                                l4 = Long.valueOf(query.getLong(i61));
                            }
                            mNSIEntity.setDataTX(l4);
                            int i62 = columnIndexOrThrow69;
                            if (query.isNull(i62)) {
                                columnIndexOrThrow69 = i62;
                                num49 = null;
                            } else {
                                columnIndexOrThrow69 = i62;
                                num49 = Integer.valueOf(query.getInt(i62));
                            }
                            mNSIEntity.setNrAsuLevel(num49);
                            int i63 = columnIndexOrThrow70;
                            if (query.isNull(i63)) {
                                columnIndexOrThrow70 = i63;
                                num50 = null;
                            } else {
                                columnIndexOrThrow70 = i63;
                                num50 = Integer.valueOf(query.getInt(i63));
                            }
                            mNSIEntity.setNrCsiRsrp(num50);
                            int i64 = columnIndexOrThrow71;
                            if (query.isNull(i64)) {
                                columnIndexOrThrow71 = i64;
                                num51 = null;
                            } else {
                                columnIndexOrThrow71 = i64;
                                num51 = Integer.valueOf(query.getInt(i64));
                            }
                            mNSIEntity.setNrCsiRsrq(num51);
                            int i65 = columnIndexOrThrow72;
                            if (query.isNull(i65)) {
                                columnIndexOrThrow72 = i65;
                                num52 = null;
                            } else {
                                columnIndexOrThrow72 = i65;
                                num52 = Integer.valueOf(query.getInt(i65));
                            }
                            mNSIEntity.setNrCsiSinr(num52);
                            int i66 = columnIndexOrThrow73;
                            if (query.isNull(i66)) {
                                columnIndexOrThrow73 = i66;
                                num53 = null;
                            } else {
                                columnIndexOrThrow73 = i66;
                                num53 = Integer.valueOf(query.getInt(i66));
                            }
                            mNSIEntity.setNrDbm(num53);
                            int i67 = columnIndexOrThrow74;
                            if (query.isNull(i67)) {
                                columnIndexOrThrow74 = i67;
                                num54 = null;
                            } else {
                                columnIndexOrThrow74 = i67;
                                num54 = Integer.valueOf(query.getInt(i67));
                            }
                            mNSIEntity.setNrLevel(num54);
                            int i68 = columnIndexOrThrow75;
                            if (query.isNull(i68)) {
                                columnIndexOrThrow75 = i68;
                                num55 = null;
                            } else {
                                columnIndexOrThrow75 = i68;
                                num55 = Integer.valueOf(query.getInt(i68));
                            }
                            mNSIEntity.setNrSsRsrp(num55);
                            int i69 = columnIndexOrThrow76;
                            if (query.isNull(i69)) {
                                columnIndexOrThrow76 = i69;
                                num56 = null;
                            } else {
                                columnIndexOrThrow76 = i69;
                                num56 = Integer.valueOf(query.getInt(i69));
                            }
                            mNSIEntity.setNrSsRsrq(num56);
                            int i70 = columnIndexOrThrow77;
                            if (query.isNull(i70)) {
                                columnIndexOrThrow77 = i70;
                                num57 = null;
                            } else {
                                columnIndexOrThrow77 = i70;
                                num57 = Integer.valueOf(query.getInt(i70));
                            }
                            mNSIEntity.setNrSsSinr(num57);
                            int i71 = columnIndexOrThrow78;
                            if (query.isNull(i71)) {
                                columnIndexOrThrow78 = i71;
                                num58 = null;
                            } else {
                                columnIndexOrThrow78 = i71;
                                num58 = Integer.valueOf(query.getInt(i71));
                            }
                            mNSIEntity.setCompleteness(num58);
                            int i72 = columnIndexOrThrow79;
                            if (query.isNull(i72)) {
                                columnIndexOrThrow79 = i72;
                                str10 = null;
                            } else {
                                columnIndexOrThrow79 = i72;
                                str10 = query.getString(i72);
                            }
                            mNSIEntity.setNrBand(str10);
                            int i73 = columnIndexOrThrow80;
                            if (query.isNull(i73)) {
                                columnIndexOrThrow80 = i73;
                                str11 = null;
                            } else {
                                columnIndexOrThrow80 = i73;
                                str11 = query.getString(i73);
                            }
                            mNSIEntity.setPermissions(str11);
                            int i74 = columnIndexOrThrow81;
                            if (query.isNull(i74)) {
                                columnIndexOrThrow81 = i74;
                                l5 = null;
                            } else {
                                columnIndexOrThrow81 = i74;
                                l5 = Long.valueOf(query.getLong(i74));
                            }
                            mNSIEntity.setCelltowerInfoTimestamp(l5);
                            int i75 = columnIndexOrThrow82;
                            if (query.isNull(i75)) {
                                columnIndexOrThrow82 = i75;
                                num59 = null;
                            } else {
                                columnIndexOrThrow82 = i75;
                                num59 = Integer.valueOf(query.getInt(i75));
                            }
                            mNSIEntity.setBaseStationId(num59);
                            int i76 = columnIndexOrThrow83;
                            if (query.isNull(i76)) {
                                columnIndexOrThrow83 = i76;
                                d = null;
                            } else {
                                columnIndexOrThrow83 = i76;
                                d = Double.valueOf(query.getDouble(i76));
                            }
                            mNSIEntity.setBaseStationLatitude(d);
                            int i77 = columnIndexOrThrow84;
                            if (query.isNull(i77)) {
                                columnIndexOrThrow84 = i77;
                                d2 = null;
                            } else {
                                columnIndexOrThrow84 = i77;
                                d2 = Double.valueOf(query.getDouble(i77));
                            }
                            mNSIEntity.setBaseStationLongitude(d2);
                            int i78 = columnIndexOrThrow85;
                            if (query.isNull(i78)) {
                                columnIndexOrThrow85 = i78;
                                num60 = null;
                            } else {
                                columnIndexOrThrow85 = i78;
                                num60 = Integer.valueOf(query.getInt(i78));
                            }
                            mNSIEntity.setNetworkId(num60);
                            int i79 = columnIndexOrThrow86;
                            if (query.isNull(i79)) {
                                columnIndexOrThrow86 = i79;
                                num61 = null;
                            } else {
                                columnIndexOrThrow86 = i79;
                                num61 = Integer.valueOf(query.getInt(i79));
                            }
                            mNSIEntity.setSystemId(num61);
                            int i80 = columnIndexOrThrow87;
                            if (query.isNull(i80)) {
                                columnIndexOrThrow87 = i80;
                                num62 = null;
                            } else {
                                columnIndexOrThrow87 = i80;
                                num62 = Integer.valueOf(query.getInt(i80));
                            }
                            mNSIEntity.setCid(num62);
                            int i81 = columnIndexOrThrow88;
                            if (query.isNull(i81)) {
                                columnIndexOrThrow88 = i81;
                                num63 = null;
                            } else {
                                columnIndexOrThrow88 = i81;
                                num63 = Integer.valueOf(query.getInt(i81));
                            }
                            mNSIEntity.setLac(num63);
                            int i82 = columnIndexOrThrow89;
                            if (query.isNull(i82)) {
                                columnIndexOrThrow89 = i82;
                                num64 = null;
                            } else {
                                columnIndexOrThrow89 = i82;
                                num64 = Integer.valueOf(query.getInt(i82));
                            }
                            mNSIEntity.setGsmArfcn(num64);
                            int i83 = columnIndexOrThrow90;
                            if (query.isNull(i83)) {
                                columnIndexOrThrow90 = i83;
                                num65 = null;
                            } else {
                                columnIndexOrThrow90 = i83;
                                num65 = Integer.valueOf(query.getInt(i83));
                            }
                            mNSIEntity.setGsmBsic(num65);
                            int i84 = columnIndexOrThrow91;
                            if (query.isNull(i84)) {
                                columnIndexOrThrow91 = i84;
                                num66 = null;
                            } else {
                                columnIndexOrThrow91 = i84;
                                num66 = Integer.valueOf(query.getInt(i84));
                            }
                            mNSIEntity.setLteEarfcn(num66);
                            int i85 = columnIndexOrThrow92;
                            if (query.isNull(i85)) {
                                columnIndexOrThrow92 = i85;
                                num67 = null;
                            } else {
                                columnIndexOrThrow92 = i85;
                                num67 = Integer.valueOf(query.getInt(i85));
                            }
                            mNSIEntity.setLteBandwidth(num67);
                            int i86 = columnIndexOrThrow93;
                            if (query.isNull(i86)) {
                                columnIndexOrThrow93 = i86;
                                num68 = null;
                            } else {
                                columnIndexOrThrow93 = i86;
                                num68 = Integer.valueOf(query.getInt(i86));
                            }
                            mNSIEntity.setPsc(num68);
                            int i87 = columnIndexOrThrow94;
                            if (query.isNull(i87)) {
                                columnIndexOrThrow94 = i87;
                                num69 = null;
                            } else {
                                columnIndexOrThrow94 = i87;
                                num69 = Integer.valueOf(query.getInt(i87));
                            }
                            mNSIEntity.setWcdmaUarfcn(num69);
                            int i88 = columnIndexOrThrow95;
                            if (query.isNull(i88)) {
                                columnIndexOrThrow95 = i88;
                                l6 = null;
                            } else {
                                columnIndexOrThrow95 = i88;
                                l6 = Long.valueOf(query.getLong(i88));
                            }
                            mNSIEntity.setNrNci(l6);
                            int i89 = columnIndexOrThrow96;
                            if (query.isNull(i89)) {
                                columnIndexOrThrow96 = i89;
                                num70 = null;
                            } else {
                                columnIndexOrThrow96 = i89;
                                num70 = Integer.valueOf(query.getInt(i89));
                            }
                            mNSIEntity.setNrArfcn(num70);
                            int i90 = columnIndexOrThrow97;
                            if (query.isNull(i90)) {
                                columnIndexOrThrow97 = i90;
                                num71 = null;
                            } else {
                                columnIndexOrThrow97 = i90;
                                num71 = Integer.valueOf(query.getInt(i90));
                            }
                            mNSIEntity.setNrPci(num71);
                            int i91 = columnIndexOrThrow98;
                            if (query.isNull(i91)) {
                                columnIndexOrThrow98 = i91;
                                num72 = null;
                            } else {
                                columnIndexOrThrow98 = i91;
                                num72 = Integer.valueOf(query.getInt(i91));
                            }
                            mNSIEntity.setNrTac(num72);
                            int i92 = columnIndexOrThrow99;
                            if (query.isNull(i92)) {
                                columnIndexOrThrow99 = i92;
                                num73 = null;
                            } else {
                                columnIndexOrThrow99 = i92;
                                num73 = Integer.valueOf(query.getInt(i92));
                            }
                            mNSIEntity.setTimeZoneOffset(num73);
                            int i93 = columnIndexOrThrow100;
                            if (query.isNull(i93)) {
                                columnIndexOrThrow100 = i93;
                                l7 = null;
                            } else {
                                columnIndexOrThrow100 = i93;
                                l7 = Long.valueOf(query.getLong(i93));
                            }
                            mNSIEntity.setSecondaryNrNci(l7);
                            int i94 = columnIndexOrThrow101;
                            if (query.isNull(i94)) {
                                columnIndexOrThrow101 = i94;
                                num74 = null;
                            } else {
                                columnIndexOrThrow101 = i94;
                                num74 = Integer.valueOf(query.getInt(i94));
                            }
                            mNSIEntity.setCarrierAgregationUsed(num74);
                            int i95 = columnIndexOrThrow102;
                            if (query.isNull(i95)) {
                                columnIndexOrThrow102 = i95;
                                num75 = null;
                            } else {
                                columnIndexOrThrow102 = i95;
                                num75 = Integer.valueOf(query.getInt(i95));
                            }
                            mNSIEntity.setConnectivityTo5G(num75);
                            int i96 = columnIndexOrThrow103;
                            if (query.isNull(i96)) {
                                columnIndexOrThrow103 = i96;
                                d3 = null;
                            } else {
                                columnIndexOrThrow103 = i96;
                                d3 = Double.valueOf(query.getDouble(i96));
                            }
                            mNSIEntity.setLatitude(d3);
                            int i97 = columnIndexOrThrow104;
                            if (query.isNull(i97)) {
                                columnIndexOrThrow104 = i97;
                                d4 = null;
                            } else {
                                columnIndexOrThrow104 = i97;
                                d4 = Double.valueOf(query.getDouble(i97));
                            }
                            mNSIEntity.setLongitude(d4);
                            int i98 = columnIndexOrThrow105;
                            if (query.isNull(i98)) {
                                columnIndexOrThrow105 = i98;
                                d5 = null;
                            } else {
                                columnIndexOrThrow105 = i98;
                                d5 = Double.valueOf(query.getDouble(i98));
                            }
                            mNSIEntity.setIndoorOutdoorWeight(d5);
                            int i99 = columnIndexOrThrow106;
                            if (query.isNull(i99)) {
                                columnIndexOrThrow106 = i99;
                                num76 = null;
                            } else {
                                columnIndexOrThrow106 = i99;
                                num76 = Integer.valueOf(query.getInt(i99));
                            }
                            mNSIEntity.setOverrideNetworkType(num76);
                            arrayList = arrayList2;
                            arrayList.add(mNSIEntity);
                            columnIndexOrThrow65 = i3;
                            columnIndexOrThrow66 = i59;
                            columnIndexOrThrow = i55;
                            columnIndexOrThrow14 = i2;
                            i4 = i;
                        }
                        query.close();
                        acquire.release();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        r3 = this;
                        Throwable th2 = th;
                        query.close();
                        acquire.release();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r3 = this;
                    Throwable th22 = th;
                    query.close();
                    acquire.release();
                    throw th22;
                }
            }
        }, continuation);
    }

    public Object getMNSIEntry(long j, Continuation<? super MNSIEntity> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM mnsi_tbl WHERE id = ?", 1);
        acquire.bindLong(1, j);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<MNSIEntity>() {
            public MNSIEntity call() {
                MNSIEntity mNSIEntity;
                Long l;
                String str;
                String str2;
                String str3;
                Integer num;
                Integer num2;
                Integer num3;
                Integer num4;
                Integer num5;
                Integer num6;
                Integer num7;
                Long l2;
                String str4;
                Float f;
                String str5;
                String str6;
                Integer num8;
                Integer num9;
                String str7;
                String str8;
                Integer num10;
                Integer num11;
                Integer num12;
                Integer num13;
                Integer num14;
                Boolean bool;
                Integer num15;
                Integer num16;
                Integer num17;
                Integer num18;
                Integer num19;
                Integer num20;
                Integer num21;
                Integer num22;
                String str9;
                Integer num23;
                Integer num24;
                Integer num25;
                Integer num26;
                Integer num27;
                Integer num28;
                Integer num29;
                Integer num30;
                Integer num31;
                Integer num32;
                Float f2;
                Integer num33;
                Integer num34;
                Integer num35;
                Integer num36;
                Integer num37;
                Integer num38;
                Integer num39;
                Integer num40;
                Integer num41;
                Integer num42;
                Integer num43;
                Integer num44;
                Integer num45;
                Integer num46;
                Integer num47;
                Integer num48;
                Long l3;
                Long l4;
                Integer num49;
                Integer num50;
                Integer num51;
                Integer num52;
                Integer num53;
                Integer num54;
                Integer num55;
                Integer num56;
                Integer num57;
                Integer num58;
                String str10;
                String str11;
                Long l5;
                Integer num59;
                Double d;
                Double d2;
                Integer num60;
                Integer num61;
                Integer num62;
                Integer num63;
                Integer num64;
                Integer num65;
                Integer num66;
                Integer num67;
                Integer num68;
                Integer num69;
                Long l6;
                Integer num70;
                Integer num71;
                Integer num72;
                Integer num73;
                Long l7;
                Integer num74;
                Integer num75;
                Double d3;
                Double d4;
                Double d5;
                Integer num76;
                AnonymousClass12 r1 = this;
                Cursor query = DBUtil.query(MNSIDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "timeStamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "timeZone");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "phoneType");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "networkTypeString");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "asu");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "ecio");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "rsrp");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "rsrq");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "bitErrorRate");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaBitErrorRate");
                    try {
                        int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "locationTimeStamp");
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "locationProvider");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "accuracy");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "networkCountryIso");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "networkMnc");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "networkMcc");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "simOperatorName");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "simCountryIso");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "simMnc");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "simMcc");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "simSlot");
                        int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "isDataDefaultSim");
                        int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "isPrimaryConnection");
                        int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "resourcesMnc");
                        int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "resourcesMcc");
                        int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "registered");
                        int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "lteSignalStrength");
                        int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "lteRsrp");
                        int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "lteRsrq");
                        int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "lteRssnr");
                        int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "lteRssi");
                        int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "lteBand");
                        int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "lteCqi");
                        int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "lteDbm");
                        int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "lteAsu");
                        int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "cdmaDbm");
                        int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "cdmaAsu");
                        int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "cdmaEcio");
                        int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "evdoDbm");
                        int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "evdoAsu");
                        int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "evdoEcio");
                        int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "evdoSnr");
                        int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "barometric");
                        int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "gsmDbm");
                        int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "gsmAsu");
                        int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "gsmBitError");
                        int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "tdscdmaDbm");
                        int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "tdscdmaAsu");
                        int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "gpsAvailable");
                        int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "lteCi");
                        int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "ltePci");
                        int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "lteTac");
                        int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaDbm");
                        int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaAsu");
                        int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaCid");
                        int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaLac");
                        int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaPsc");
                        int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "roaming");
                        int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "networkType");
                        int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "dataNetworkType");
                        int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "voiceNetworkType");
                        int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "lteTimingAdvance");
                        int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "dataRX");
                        int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "dataTX");
                        int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "nrAsuLevel");
                        int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "nrCsiRsrp");
                        int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "nrCsiRsrq");
                        int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "nrCsiSinr");
                        int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "nrDbm");
                        int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "nrLevel");
                        int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "nrSsRsrp");
                        int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "nrSsRsrq");
                        int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "nrSsSinr");
                        int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "completeness");
                        int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "nrBand");
                        int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "celltowerInfoTimestamp");
                        int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "baseStationId");
                        int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "baseStationLatitude");
                        int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "baseStationLongitude");
                        int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "networkId");
                        int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "systemId");
                        int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, CmcdConfiguration.KEY_CONTENT_ID);
                        int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "lac");
                        int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "gsmArfcn");
                        int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "gsmBsic");
                        int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "lteEarfcn");
                        int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "lteBandwidth");
                        int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "psc");
                        int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaUarfcn");
                        int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "nrNci");
                        int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "nrArfcn");
                        int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "nrPci");
                        int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "nrTac");
                        int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneOffset");
                        int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "secondaryNrNci");
                        int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                        int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "is5GConnected");
                        int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                        int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                        int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "indoorOutdoorWeight");
                        int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                        if (query.moveToFirst()) {
                            int i = columnIndexOrThrow106;
                            MNSIEntity mNSIEntity2 = new MNSIEntity();
                            mNSIEntity2.setId(query.getInt(columnIndexOrThrow));
                            mNSIEntity2.setTransmitted(query.getInt(columnIndexOrThrow2));
                            if (query.isNull(columnIndexOrThrow3)) {
                                l = null;
                            } else {
                                l = Long.valueOf(query.getLong(columnIndexOrThrow3));
                            }
                            mNSIEntity2.setTimeStamp(l);
                            if (query.isNull(columnIndexOrThrow4)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow4);
                            }
                            mNSIEntity2.setTimeZone(str);
                            if (query.isNull(columnIndexOrThrow5)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow5);
                            }
                            mNSIEntity2.setPhoneType(str2);
                            if (query.isNull(columnIndexOrThrow6)) {
                                str3 = null;
                            } else {
                                str3 = query.getString(columnIndexOrThrow6);
                            }
                            mNSIEntity2.setNetworkTypeString(str3);
                            if (query.isNull(columnIndexOrThrow7)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                            }
                            mNSIEntity2.setDbm(num);
                            if (query.isNull(columnIndexOrThrow8)) {
                                num2 = null;
                            } else {
                                num2 = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                            }
                            mNSIEntity2.setAsu(num2);
                            if (query.isNull(columnIndexOrThrow9)) {
                                num3 = null;
                            } else {
                                num3 = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                            }
                            mNSIEntity2.setEcio(num3);
                            if (query.isNull(columnIndexOrThrow10)) {
                                num4 = null;
                            } else {
                                num4 = Integer.valueOf(query.getInt(columnIndexOrThrow10));
                            }
                            mNSIEntity2.setRsrp(num4);
                            if (query.isNull(columnIndexOrThrow11)) {
                                num5 = null;
                            } else {
                                num5 = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                            }
                            mNSIEntity2.setRsrq(num5);
                            if (query.isNull(columnIndexOrThrow12)) {
                                num6 = null;
                            } else {
                                num6 = Integer.valueOf(query.getInt(columnIndexOrThrow12));
                            }
                            mNSIEntity2.setBitErrorRate(num6);
                            if (query.isNull(columnIndexOrThrow13)) {
                                num7 = null;
                            } else {
                                num7 = Integer.valueOf(query.getInt(columnIndexOrThrow13));
                            }
                            mNSIEntity2.setWcdmaBitErrorRate(num7);
                            int i2 = columnIndexOrThrow14;
                            if (query.isNull(i2)) {
                                l2 = null;
                            } else {
                                l2 = Long.valueOf(query.getLong(i2));
                            }
                            mNSIEntity2.setLocationTimeStamp(l2);
                            int i3 = columnIndexOrThrow15;
                            if (query.isNull(i3)) {
                                str4 = null;
                            } else {
                                str4 = query.getString(i3);
                            }
                            mNSIEntity2.setLocationProvider(str4);
                            int i4 = columnIndexOrThrow16;
                            if (query.isNull(i4)) {
                                f = null;
                            } else {
                                f = Float.valueOf(query.getFloat(i4));
                            }
                            mNSIEntity2.setAccuracy(f);
                            int i5 = columnIndexOrThrow17;
                            if (query.isNull(i5)) {
                                str5 = null;
                            } else {
                                str5 = query.getString(i5);
                            }
                            mNSIEntity2.setNetworkOperatorName(str5);
                            int i6 = columnIndexOrThrow18;
                            if (query.isNull(i6)) {
                                str6 = null;
                            } else {
                                str6 = query.getString(i6);
                            }
                            mNSIEntity2.setNetworkCountryIso(str6);
                            int i7 = columnIndexOrThrow19;
                            if (query.isNull(i7)) {
                                num8 = null;
                            } else {
                                num8 = Integer.valueOf(query.getInt(i7));
                            }
                            mNSIEntity2.setNetworkMnc(num8);
                            int i8 = columnIndexOrThrow20;
                            if (query.isNull(i8)) {
                                num9 = null;
                            } else {
                                num9 = Integer.valueOf(query.getInt(i8));
                            }
                            mNSIEntity2.setNetworkMcc(num9);
                            int i9 = columnIndexOrThrow21;
                            if (query.isNull(i9)) {
                                str7 = null;
                            } else {
                                str7 = query.getString(i9);
                            }
                            mNSIEntity2.setSimOperatorName(str7);
                            int i10 = columnIndexOrThrow22;
                            if (query.isNull(i10)) {
                                str8 = null;
                            } else {
                                str8 = query.getString(i10);
                            }
                            mNSIEntity2.setSimCountryIso(str8);
                            int i11 = columnIndexOrThrow23;
                            if (query.isNull(i11)) {
                                num10 = null;
                            } else {
                                num10 = Integer.valueOf(query.getInt(i11));
                            }
                            mNSIEntity2.setSimMnc(num10);
                            int i12 = columnIndexOrThrow24;
                            if (query.isNull(i12)) {
                                num11 = null;
                            } else {
                                num11 = Integer.valueOf(query.getInt(i12));
                            }
                            mNSIEntity2.setSimMcc(num11);
                            int i13 = columnIndexOrThrow25;
                            if (query.isNull(i13)) {
                                num12 = null;
                            } else {
                                num12 = Integer.valueOf(query.getInt(i13));
                            }
                            mNSIEntity2.setSimSlot(num12);
                            int i14 = columnIndexOrThrow26;
                            if (query.isNull(i14)) {
                                num13 = null;
                            } else {
                                num13 = Integer.valueOf(query.getInt(i14));
                            }
                            mNSIEntity2.setIsDataDefaultSim(num13);
                            int i15 = columnIndexOrThrow27;
                            if (query.isNull(i15)) {
                                num14 = null;
                            } else {
                                num14 = Integer.valueOf(query.getInt(i15));
                            }
                            if (num14 == null) {
                                bool = null;
                            } else {
                                bool = Boolean.valueOf(num14.intValue() != 0);
                            }
                            mNSIEntity2.setPrimaryConnection(bool);
                            int i16 = columnIndexOrThrow28;
                            if (query.isNull(i16)) {
                                num15 = null;
                            } else {
                                num15 = Integer.valueOf(query.getInt(i16));
                            }
                            mNSIEntity2.setResourcesMnc(num15);
                            int i17 = columnIndexOrThrow29;
                            if (query.isNull(i17)) {
                                num16 = null;
                            } else {
                                num16 = Integer.valueOf(query.getInt(i17));
                            }
                            mNSIEntity2.setResourcesMcc(num16);
                            int i18 = columnIndexOrThrow30;
                            if (query.isNull(i18)) {
                                num17 = null;
                            } else {
                                num17 = Integer.valueOf(query.getInt(i18));
                            }
                            mNSIEntity2.setRegistered(num17);
                            int i19 = columnIndexOrThrow31;
                            if (query.isNull(i19)) {
                                num18 = null;
                            } else {
                                num18 = Integer.valueOf(query.getInt(i19));
                            }
                            mNSIEntity2.setLteSignalStrength(num18);
                            int i20 = columnIndexOrThrow32;
                            if (query.isNull(i20)) {
                                num19 = null;
                            } else {
                                num19 = Integer.valueOf(query.getInt(i20));
                            }
                            mNSIEntity2.setLteRsrp(num19);
                            int i21 = columnIndexOrThrow33;
                            if (query.isNull(i21)) {
                                num20 = null;
                            } else {
                                num20 = Integer.valueOf(query.getInt(i21));
                            }
                            mNSIEntity2.setLteRsrq(num20);
                            int i22 = columnIndexOrThrow34;
                            if (query.isNull(i22)) {
                                num21 = null;
                            } else {
                                num21 = Integer.valueOf(query.getInt(i22));
                            }
                            mNSIEntity2.setLteRssnr(num21);
                            int i23 = columnIndexOrThrow35;
                            if (query.isNull(i23)) {
                                num22 = null;
                            } else {
                                num22 = Integer.valueOf(query.getInt(i23));
                            }
                            mNSIEntity2.setLteRssi(num22);
                            int i24 = columnIndexOrThrow36;
                            if (query.isNull(i24)) {
                                str9 = null;
                            } else {
                                str9 = query.getString(i24);
                            }
                            mNSIEntity2.setLteBand(str9);
                            int i25 = columnIndexOrThrow37;
                            if (query.isNull(i25)) {
                                num23 = null;
                            } else {
                                num23 = Integer.valueOf(query.getInt(i25));
                            }
                            mNSIEntity2.setLteCqi(num23);
                            int i26 = columnIndexOrThrow38;
                            if (query.isNull(i26)) {
                                num24 = null;
                            } else {
                                num24 = Integer.valueOf(query.getInt(i26));
                            }
                            mNSIEntity2.setLteDbm(num24);
                            int i27 = columnIndexOrThrow39;
                            if (query.isNull(i27)) {
                                num25 = null;
                            } else {
                                num25 = Integer.valueOf(query.getInt(i27));
                            }
                            mNSIEntity2.setLteAsu(num25);
                            int i28 = columnIndexOrThrow40;
                            if (query.isNull(i28)) {
                                num26 = null;
                            } else {
                                num26 = Integer.valueOf(query.getInt(i28));
                            }
                            mNSIEntity2.setCdmaDbm(num26);
                            int i29 = columnIndexOrThrow41;
                            if (query.isNull(i29)) {
                                num27 = null;
                            } else {
                                num27 = Integer.valueOf(query.getInt(i29));
                            }
                            mNSIEntity2.setCdmaAsu(num27);
                            int i30 = columnIndexOrThrow42;
                            if (query.isNull(i30)) {
                                num28 = null;
                            } else {
                                num28 = Integer.valueOf(query.getInt(i30));
                            }
                            mNSIEntity2.setCdmaEcio(num28);
                            int i31 = columnIndexOrThrow43;
                            if (query.isNull(i31)) {
                                num29 = null;
                            } else {
                                num29 = Integer.valueOf(query.getInt(i31));
                            }
                            mNSIEntity2.setEvdoDbm(num29);
                            int i32 = columnIndexOrThrow44;
                            if (query.isNull(i32)) {
                                num30 = null;
                            } else {
                                num30 = Integer.valueOf(query.getInt(i32));
                            }
                            mNSIEntity2.setEvdoAsu(num30);
                            int i33 = columnIndexOrThrow45;
                            if (query.isNull(i33)) {
                                num31 = null;
                            } else {
                                num31 = Integer.valueOf(query.getInt(i33));
                            }
                            mNSIEntity2.setEvdoEcio(num31);
                            int i34 = columnIndexOrThrow46;
                            if (query.isNull(i34)) {
                                num32 = null;
                            } else {
                                num32 = Integer.valueOf(query.getInt(i34));
                            }
                            mNSIEntity2.setEvdoSnr(num32);
                            int i35 = columnIndexOrThrow47;
                            if (query.isNull(i35)) {
                                f2 = null;
                            } else {
                                f2 = Float.valueOf(query.getFloat(i35));
                            }
                            mNSIEntity2.setBarometric(f2);
                            int i36 = columnIndexOrThrow48;
                            if (query.isNull(i36)) {
                                num33 = null;
                            } else {
                                num33 = Integer.valueOf(query.getInt(i36));
                            }
                            mNSIEntity2.setGsmDbm(num33);
                            int i37 = columnIndexOrThrow49;
                            if (query.isNull(i37)) {
                                num34 = null;
                            } else {
                                num34 = Integer.valueOf(query.getInt(i37));
                            }
                            mNSIEntity2.setGsmAsu(num34);
                            int i38 = columnIndexOrThrow50;
                            if (query.isNull(i38)) {
                                num35 = null;
                            } else {
                                num35 = Integer.valueOf(query.getInt(i38));
                            }
                            mNSIEntity2.setGsmBitError(num35);
                            int i39 = columnIndexOrThrow51;
                            if (query.isNull(i39)) {
                                num36 = null;
                            } else {
                                num36 = Integer.valueOf(query.getInt(i39));
                            }
                            mNSIEntity2.setTdscdmaDbm(num36);
                            int i40 = columnIndexOrThrow52;
                            if (query.isNull(i40)) {
                                num37 = null;
                            } else {
                                num37 = Integer.valueOf(query.getInt(i40));
                            }
                            mNSIEntity2.setTdscdmaAsu(num37);
                            int i41 = columnIndexOrThrow53;
                            if (query.isNull(i41)) {
                                num38 = null;
                            } else {
                                num38 = Integer.valueOf(query.getInt(i41));
                            }
                            mNSIEntity2.setGpsAvailable(num38);
                            int i42 = columnIndexOrThrow54;
                            if (query.isNull(i42)) {
                                num39 = null;
                            } else {
                                num39 = Integer.valueOf(query.getInt(i42));
                            }
                            mNSIEntity2.setLteCi(num39);
                            int i43 = columnIndexOrThrow55;
                            if (query.isNull(i43)) {
                                num40 = null;
                            } else {
                                num40 = Integer.valueOf(query.getInt(i43));
                            }
                            mNSIEntity2.setLtePci(num40);
                            int i44 = columnIndexOrThrow56;
                            if (query.isNull(i44)) {
                                num41 = null;
                            } else {
                                num41 = Integer.valueOf(query.getInt(i44));
                            }
                            mNSIEntity2.setLteTac(num41);
                            int i45 = columnIndexOrThrow57;
                            if (query.isNull(i45)) {
                                num42 = null;
                            } else {
                                num42 = Integer.valueOf(query.getInt(i45));
                            }
                            mNSIEntity2.setWcdmaDbm(num42);
                            int i46 = columnIndexOrThrow58;
                            if (query.isNull(i46)) {
                                num43 = null;
                            } else {
                                num43 = Integer.valueOf(query.getInt(i46));
                            }
                            mNSIEntity2.setWcdmaAsu(num43);
                            int i47 = columnIndexOrThrow59;
                            if (query.isNull(i47)) {
                                num44 = null;
                            } else {
                                num44 = Integer.valueOf(query.getInt(i47));
                            }
                            mNSIEntity2.setWcdmaCid(num44);
                            int i48 = columnIndexOrThrow60;
                            if (query.isNull(i48)) {
                                num45 = null;
                            } else {
                                num45 = Integer.valueOf(query.getInt(i48));
                            }
                            mNSIEntity2.setWcdmaLac(num45);
                            int i49 = columnIndexOrThrow61;
                            if (query.isNull(i49)) {
                                num46 = null;
                            } else {
                                num46 = Integer.valueOf(query.getInt(i49));
                            }
                            mNSIEntity2.setWcdmaPsc(num46);
                            int i50 = columnIndexOrThrow62;
                            if (query.isNull(i50)) {
                                num47 = null;
                            } else {
                                num47 = Integer.valueOf(query.getInt(i50));
                            }
                            mNSIEntity2.setRoaming(num47);
                            mNSIEntity2.setNetworkType(query.getInt(columnIndexOrThrow63));
                            mNSIEntity2.setDataNetworkType(query.getInt(columnIndexOrThrow64));
                            mNSIEntity2.setVoiceNetworkType(query.getInt(columnIndexOrThrow65));
                            int i51 = columnIndexOrThrow66;
                            if (query.isNull(i51)) {
                                num48 = null;
                            } else {
                                num48 = Integer.valueOf(query.getInt(i51));
                            }
                            mNSIEntity2.setLteTimingAdvance(num48);
                            int i52 = columnIndexOrThrow67;
                            if (query.isNull(i52)) {
                                l3 = null;
                            } else {
                                l3 = Long.valueOf(query.getLong(i52));
                            }
                            mNSIEntity2.setDataRX(l3);
                            int i53 = columnIndexOrThrow68;
                            if (query.isNull(i53)) {
                                l4 = null;
                            } else {
                                l4 = Long.valueOf(query.getLong(i53));
                            }
                            mNSIEntity2.setDataTX(l4);
                            int i54 = columnIndexOrThrow69;
                            if (query.isNull(i54)) {
                                num49 = null;
                            } else {
                                num49 = Integer.valueOf(query.getInt(i54));
                            }
                            mNSIEntity2.setNrAsuLevel(num49);
                            int i55 = columnIndexOrThrow70;
                            if (query.isNull(i55)) {
                                num50 = null;
                            } else {
                                num50 = Integer.valueOf(query.getInt(i55));
                            }
                            mNSIEntity2.setNrCsiRsrp(num50);
                            int i56 = columnIndexOrThrow71;
                            if (query.isNull(i56)) {
                                num51 = null;
                            } else {
                                num51 = Integer.valueOf(query.getInt(i56));
                            }
                            mNSIEntity2.setNrCsiRsrq(num51);
                            int i57 = columnIndexOrThrow72;
                            if (query.isNull(i57)) {
                                num52 = null;
                            } else {
                                num52 = Integer.valueOf(query.getInt(i57));
                            }
                            mNSIEntity2.setNrCsiSinr(num52);
                            int i58 = columnIndexOrThrow73;
                            if (query.isNull(i58)) {
                                num53 = null;
                            } else {
                                num53 = Integer.valueOf(query.getInt(i58));
                            }
                            mNSIEntity2.setNrDbm(num53);
                            int i59 = columnIndexOrThrow74;
                            if (query.isNull(i59)) {
                                num54 = null;
                            } else {
                                num54 = Integer.valueOf(query.getInt(i59));
                            }
                            mNSIEntity2.setNrLevel(num54);
                            int i60 = columnIndexOrThrow75;
                            if (query.isNull(i60)) {
                                num55 = null;
                            } else {
                                num55 = Integer.valueOf(query.getInt(i60));
                            }
                            mNSIEntity2.setNrSsRsrp(num55);
                            int i61 = columnIndexOrThrow76;
                            if (query.isNull(i61)) {
                                num56 = null;
                            } else {
                                num56 = Integer.valueOf(query.getInt(i61));
                            }
                            mNSIEntity2.setNrSsRsrq(num56);
                            int i62 = columnIndexOrThrow77;
                            if (query.isNull(i62)) {
                                num57 = null;
                            } else {
                                num57 = Integer.valueOf(query.getInt(i62));
                            }
                            mNSIEntity2.setNrSsSinr(num57);
                            int i63 = columnIndexOrThrow78;
                            if (query.isNull(i63)) {
                                num58 = null;
                            } else {
                                num58 = Integer.valueOf(query.getInt(i63));
                            }
                            mNSIEntity2.setCompleteness(num58);
                            int i64 = columnIndexOrThrow79;
                            if (query.isNull(i64)) {
                                str10 = null;
                            } else {
                                str10 = query.getString(i64);
                            }
                            mNSIEntity2.setNrBand(str10);
                            int i65 = columnIndexOrThrow80;
                            if (query.isNull(i65)) {
                                str11 = null;
                            } else {
                                str11 = query.getString(i65);
                            }
                            mNSIEntity2.setPermissions(str11);
                            int i66 = columnIndexOrThrow81;
                            if (query.isNull(i66)) {
                                l5 = null;
                            } else {
                                l5 = Long.valueOf(query.getLong(i66));
                            }
                            mNSIEntity2.setCelltowerInfoTimestamp(l5);
                            int i67 = columnIndexOrThrow82;
                            if (query.isNull(i67)) {
                                num59 = null;
                            } else {
                                num59 = Integer.valueOf(query.getInt(i67));
                            }
                            mNSIEntity2.setBaseStationId(num59);
                            int i68 = columnIndexOrThrow83;
                            if (query.isNull(i68)) {
                                d = null;
                            } else {
                                d = Double.valueOf(query.getDouble(i68));
                            }
                            mNSIEntity2.setBaseStationLatitude(d);
                            int i69 = columnIndexOrThrow84;
                            if (query.isNull(i69)) {
                                d2 = null;
                            } else {
                                d2 = Double.valueOf(query.getDouble(i69));
                            }
                            mNSIEntity2.setBaseStationLongitude(d2);
                            int i70 = columnIndexOrThrow85;
                            if (query.isNull(i70)) {
                                num60 = null;
                            } else {
                                num60 = Integer.valueOf(query.getInt(i70));
                            }
                            mNSIEntity2.setNetworkId(num60);
                            int i71 = columnIndexOrThrow86;
                            if (query.isNull(i71)) {
                                num61 = null;
                            } else {
                                num61 = Integer.valueOf(query.getInt(i71));
                            }
                            mNSIEntity2.setSystemId(num61);
                            int i72 = columnIndexOrThrow87;
                            if (query.isNull(i72)) {
                                num62 = null;
                            } else {
                                num62 = Integer.valueOf(query.getInt(i72));
                            }
                            mNSIEntity2.setCid(num62);
                            int i73 = columnIndexOrThrow88;
                            if (query.isNull(i73)) {
                                num63 = null;
                            } else {
                                num63 = Integer.valueOf(query.getInt(i73));
                            }
                            mNSIEntity2.setLac(num63);
                            int i74 = columnIndexOrThrow89;
                            if (query.isNull(i74)) {
                                num64 = null;
                            } else {
                                num64 = Integer.valueOf(query.getInt(i74));
                            }
                            mNSIEntity2.setGsmArfcn(num64);
                            int i75 = columnIndexOrThrow90;
                            if (query.isNull(i75)) {
                                num65 = null;
                            } else {
                                num65 = Integer.valueOf(query.getInt(i75));
                            }
                            mNSIEntity2.setGsmBsic(num65);
                            int i76 = columnIndexOrThrow91;
                            if (query.isNull(i76)) {
                                num66 = null;
                            } else {
                                num66 = Integer.valueOf(query.getInt(i76));
                            }
                            mNSIEntity2.setLteEarfcn(num66);
                            int i77 = columnIndexOrThrow92;
                            if (query.isNull(i77)) {
                                num67 = null;
                            } else {
                                num67 = Integer.valueOf(query.getInt(i77));
                            }
                            mNSIEntity2.setLteBandwidth(num67);
                            int i78 = columnIndexOrThrow93;
                            if (query.isNull(i78)) {
                                num68 = null;
                            } else {
                                num68 = Integer.valueOf(query.getInt(i78));
                            }
                            mNSIEntity2.setPsc(num68);
                            int i79 = columnIndexOrThrow94;
                            if (query.isNull(i79)) {
                                num69 = null;
                            } else {
                                num69 = Integer.valueOf(query.getInt(i79));
                            }
                            mNSIEntity2.setWcdmaUarfcn(num69);
                            int i80 = columnIndexOrThrow95;
                            if (query.isNull(i80)) {
                                l6 = null;
                            } else {
                                l6 = Long.valueOf(query.getLong(i80));
                            }
                            mNSIEntity2.setNrNci(l6);
                            int i81 = columnIndexOrThrow96;
                            if (query.isNull(i81)) {
                                num70 = null;
                            } else {
                                num70 = Integer.valueOf(query.getInt(i81));
                            }
                            mNSIEntity2.setNrArfcn(num70);
                            int i82 = columnIndexOrThrow97;
                            if (query.isNull(i82)) {
                                num71 = null;
                            } else {
                                num71 = Integer.valueOf(query.getInt(i82));
                            }
                            mNSIEntity2.setNrPci(num71);
                            int i83 = columnIndexOrThrow98;
                            if (query.isNull(i83)) {
                                num72 = null;
                            } else {
                                num72 = Integer.valueOf(query.getInt(i83));
                            }
                            mNSIEntity2.setNrTac(num72);
                            int i84 = columnIndexOrThrow99;
                            if (query.isNull(i84)) {
                                num73 = null;
                            } else {
                                num73 = Integer.valueOf(query.getInt(i84));
                            }
                            mNSIEntity2.setTimeZoneOffset(num73);
                            int i85 = columnIndexOrThrow100;
                            if (query.isNull(i85)) {
                                l7 = null;
                            } else {
                                l7 = Long.valueOf(query.getLong(i85));
                            }
                            mNSIEntity2.setSecondaryNrNci(l7);
                            int i86 = columnIndexOrThrow101;
                            if (query.isNull(i86)) {
                                num74 = null;
                            } else {
                                num74 = Integer.valueOf(query.getInt(i86));
                            }
                            mNSIEntity2.setCarrierAgregationUsed(num74);
                            int i87 = columnIndexOrThrow102;
                            if (query.isNull(i87)) {
                                num75 = null;
                            } else {
                                num75 = Integer.valueOf(query.getInt(i87));
                            }
                            mNSIEntity2.setConnectivityTo5G(num75);
                            int i88 = columnIndexOrThrow103;
                            if (query.isNull(i88)) {
                                d3 = null;
                            } else {
                                d3 = Double.valueOf(query.getDouble(i88));
                            }
                            mNSIEntity2.setLatitude(d3);
                            int i89 = columnIndexOrThrow104;
                            if (query.isNull(i89)) {
                                d4 = null;
                            } else {
                                d4 = Double.valueOf(query.getDouble(i89));
                            }
                            mNSIEntity2.setLongitude(d4);
                            int i90 = columnIndexOrThrow105;
                            if (query.isNull(i90)) {
                                d5 = null;
                            } else {
                                d5 = Double.valueOf(query.getDouble(i90));
                            }
                            mNSIEntity2.setIndoorOutdoorWeight(d5);
                            int i91 = i;
                            if (query.isNull(i91)) {
                                num76 = null;
                            } else {
                                num76 = Integer.valueOf(query.getInt(i91));
                            }
                            mNSIEntity2.setOverrideNetworkType(num76);
                            mNSIEntity = mNSIEntity2;
                        } else {
                            mNSIEntity = null;
                        }
                        query.close();
                        acquire.release();
                        return mNSIEntity;
                    } catch (Throwable th) {
                        th = th;
                        r1 = this;
                        Throwable th2 = th;
                        query.close();
                        acquire.release();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    Throwable th22 = th;
                    query.close();
                    acquire.release();
                    throw th22;
                }
            }
        }, continuation);
    }

    public Object getMNSIWithWhereClause(final SupportSQLiteQuery supportSQLiteQuery, Continuation<? super List<? extends MNSIEntity>> continuation) {
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends MNSIEntity>>() {
            public List<? extends MNSIEntity> call() {
                Cursor query = DBUtil.query(MNSIDao_Impl.this.__db, supportSQLiteQuery, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(MNSIDao_Impl.this.__entityCursorConverter_comM2catalystM2sdkDatabaseEntitiesMNSIEntity(query));
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }
        }, continuation);
    }

    public Object insertMNSIEntry(final MNSIEntity mNSIEntity, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Long>() {
            public Long call() {
                MNSIDao_Impl.this.__db.beginTransaction();
                try {
                    long insertAndReturnId = MNSIDao_Impl.this.__insertionAdapterOfMNSIEntity.insertAndReturnId(mNSIEntity);
                    MNSIDao_Impl.this.__db.setTransactionSuccessful();
                    return Long.valueOf(insertAndReturnId);
                } finally {
                    MNSIDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$clearMNSITable$0$com-m2catalyst-m2sdk-database-daos-MNSIDao_Impl  reason: not valid java name */
    public /* synthetic */ Object m2165lambda$clearMNSITable$0$comm2catalystm2sdkdatabasedaosMNSIDao_Impl(Continuation continuation) {
        return MNSIDao.DefaultImpls.clearMNSITable(this, continuation);
    }

    public Object markMNSIAsTransmitted(final List<Integer> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                StringBuilder newStringBuilder = StringUtil.newStringBuilder();
                newStringBuilder.append("UPDATE mnsi_tbl SET transmitted = 1 WHERE id IN (");
                StringUtil.appendPlaceholders(newStringBuilder, list.size());
                newStringBuilder.append(") ");
                SupportSQLiteStatement compileStatement = MNSIDao_Impl.this.__db.compileStatement(newStringBuilder.toString());
                int i = 1;
                for (Integer num : list) {
                    if (num == null) {
                        compileStatement.bindNull(i);
                    } else {
                        compileStatement.bindLong(i, (long) num.intValue());
                    }
                    i++;
                }
                MNSIDao_Impl.this.__db.beginTransaction();
                try {
                    compileStatement.executeUpdateDelete();
                    MNSIDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MNSIDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public Object resetMNSITable(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = MNSIDao_Impl.this.__preparedStmtOfResetMNSITable.acquire();
                MNSIDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    MNSIDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MNSIDao_Impl.this.__db.endTransaction();
                    MNSIDao_Impl.this.__preparedStmtOfResetMNSITable.release(acquire);
                }
            }
        }, continuation);
    }

    public Object updateMNSILocationEntryFromNetworkDiagnostics(int i, Long l, String str, Double d, Double d2, Float f, Float f2, Continuation<? super Unit> continuation) {
        final Long l2 = l;
        final String str2 = str;
        final Double d3 = d;
        final Double d4 = d2;
        final Float f3 = f;
        final Float f4 = f2;
        final int i2 = i;
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = MNSIDao_Impl.this.__preparedStmtOfUpdateMNSILocationEntryFromNetworkDiagnostics.acquire();
                Long l = l2;
                if (l == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindLong(1, l.longValue());
                }
                String str = str2;
                if (str == null) {
                    acquire.bindNull(2);
                } else {
                    acquire.bindString(2, str);
                }
                Double d = d3;
                if (d == null) {
                    acquire.bindNull(3);
                } else {
                    acquire.bindDouble(3, d.doubleValue());
                }
                Double d2 = d4;
                if (d2 == null) {
                    acquire.bindNull(4);
                } else {
                    acquire.bindDouble(4, d2.doubleValue());
                }
                Float f = f3;
                if (f == null) {
                    acquire.bindNull(5);
                } else {
                    acquire.bindDouble(5, (double) f.floatValue());
                }
                Float f2 = f4;
                if (f2 == null) {
                    acquire.bindNull(6);
                } else {
                    acquire.bindDouble(6, (double) f2.floatValue());
                }
                acquire.bindLong(7, (long) i2);
                MNSIDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    MNSIDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MNSIDao_Impl.this.__db.endTransaction();
                    MNSIDao_Impl.this.__preparedStmtOfUpdateMNSILocationEntryFromNetworkDiagnostics.release(acquire);
                }
            }
        }, continuation);
    }

    public Object updateMobileSignalRxTx(int i, long j, long j2, Continuation<? super Unit> continuation) {
        final long j3 = j;
        final long j4 = j2;
        final int i2 = i;
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() {
                SupportSQLiteStatement acquire = MNSIDao_Impl.this.__preparedStmtOfUpdateMobileSignalRxTx.acquire();
                acquire.bindLong(1, j3);
                acquire.bindLong(2, j4);
                acquire.bindLong(3, (long) i2);
                MNSIDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    MNSIDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    MNSIDao_Impl.this.__db.endTransaction();
                    MNSIDao_Impl.this.__preparedStmtOfUpdateMobileSignalRxTx.release(acquire);
                }
            }
        }, continuation);
    }

    public Object getMNSIEntries(long j, long j2, int i, Continuation<? super List<? extends MNSIEntity>> continuation) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM mnsi_tbl WHERE timeStamp >= ? AND timeStamp <= ? AND simSlot = ?", 3);
        acquire.bindLong(1, j);
        acquire.bindLong(2, j2);
        acquire.bindLong(3, (long) i);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<? extends MNSIEntity>>() {
            public List<? extends MNSIEntity> call() {
                AnonymousClass15 r3;
                Long l;
                String str;
                String str2;
                String str3;
                Integer num;
                Integer num2;
                Integer num3;
                Integer num4;
                Integer num5;
                Integer num6;
                int i;
                Integer num7;
                int i2;
                Long l2;
                String str4;
                Float f;
                String str5;
                String str6;
                Integer num8;
                Integer num9;
                String str7;
                String str8;
                Integer num10;
                Integer num11;
                Integer num12;
                Integer num13;
                Integer num14;
                Boolean bool;
                Integer num15;
                Integer num16;
                Integer num17;
                Integer num18;
                Integer num19;
                Integer num20;
                Integer num21;
                Integer num22;
                String str9;
                Integer num23;
                Integer num24;
                Integer num25;
                Integer num26;
                Integer num27;
                Integer num28;
                Integer num29;
                Integer num30;
                Integer num31;
                Integer num32;
                Float f2;
                Integer num33;
                Integer num34;
                Integer num35;
                Integer num36;
                Integer num37;
                Integer num38;
                Integer num39;
                Integer num40;
                Integer num41;
                Integer num42;
                Integer num43;
                Integer num44;
                Integer num45;
                Integer num46;
                Integer num47;
                int i3;
                Integer num48;
                Long l3;
                Long l4;
                Integer num49;
                Integer num50;
                Integer num51;
                Integer num52;
                Integer num53;
                Integer num54;
                Integer num55;
                Integer num56;
                Integer num57;
                Integer num58;
                String str10;
                String str11;
                Long l5;
                Integer num59;
                Double d;
                Double d2;
                Integer num60;
                Integer num61;
                Integer num62;
                Integer num63;
                Integer num64;
                Integer num65;
                Integer num66;
                Integer num67;
                Integer num68;
                Integer num69;
                Long l6;
                Integer num70;
                Integer num71;
                Integer num72;
                Integer num73;
                Long l7;
                Integer num74;
                Integer num75;
                Double d3;
                Double d4;
                Double d5;
                Integer num76;
                Cursor query = DBUtil.query(MNSIDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "transmitted");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "timeStamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "timeZone");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "phoneType");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "networkTypeString");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "dbm");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "asu");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "ecio");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "rsrp");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "rsrq");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "bitErrorRate");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaBitErrorRate");
                    try {
                        int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "locationTimeStamp");
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "locationProvider");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "accuracy");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "networkOperatorName");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "networkCountryIso");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "networkMnc");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "networkMcc");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "simOperatorName");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "simCountryIso");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "simMnc");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "simMcc");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "simSlot");
                        int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "isDataDefaultSim");
                        int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "isPrimaryConnection");
                        int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "resourcesMnc");
                        int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "resourcesMcc");
                        int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "registered");
                        int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "lteSignalStrength");
                        int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "lteRsrp");
                        int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(query, "lteRsrq");
                        int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(query, "lteRssnr");
                        int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(query, "lteRssi");
                        int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(query, "lteBand");
                        int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(query, "lteCqi");
                        int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(query, "lteDbm");
                        int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(query, "lteAsu");
                        int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(query, "cdmaDbm");
                        int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(query, "cdmaAsu");
                        int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(query, "cdmaEcio");
                        int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(query, "evdoDbm");
                        int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(query, "evdoAsu");
                        int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(query, "evdoEcio");
                        int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(query, "evdoSnr");
                        int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(query, "barometric");
                        int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(query, "gsmDbm");
                        int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(query, "gsmAsu");
                        int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(query, "gsmBitError");
                        int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(query, "tdscdmaDbm");
                        int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(query, "tdscdmaAsu");
                        int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(query, "gpsAvailable");
                        int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(query, "lteCi");
                        int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(query, "ltePci");
                        int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(query, "lteTac");
                        int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaDbm");
                        int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaAsu");
                        int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaCid");
                        int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaLac");
                        int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaPsc");
                        int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(query, "roaming");
                        int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(query, "networkType");
                        int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(query, "dataNetworkType");
                        int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(query, "voiceNetworkType");
                        int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(query, "lteTimingAdvance");
                        int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(query, "dataRX");
                        int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(query, "dataTX");
                        int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(query, "nrAsuLevel");
                        int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(query, "nrCsiRsrp");
                        int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(query, "nrCsiRsrq");
                        int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(query, "nrCsiSinr");
                        int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(query, "nrDbm");
                        int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(query, "nrLevel");
                        int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(query, "nrSsRsrp");
                        int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(query, "nrSsRsrq");
                        int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(query, "nrSsSinr");
                        int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(query, "completeness");
                        int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(query, "nrBand");
                        int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(query, "permissions");
                        int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(query, "celltowerInfoTimestamp");
                        int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(query, "baseStationId");
                        int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(query, "baseStationLatitude");
                        int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(query, "baseStationLongitude");
                        int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(query, "networkId");
                        int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(query, "systemId");
                        int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(query, CmcdConfiguration.KEY_CONTENT_ID);
                        int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(query, "lac");
                        int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(query, "gsmArfcn");
                        int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(query, "gsmBsic");
                        int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(query, "lteEarfcn");
                        int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(query, "lteBandwidth");
                        int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(query, "psc");
                        int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(query, "wcdmaUarfcn");
                        int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(query, "nrNci");
                        int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(query, "nrArfcn");
                        int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(query, "nrPci");
                        int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(query, "nrTac");
                        int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(query, "timeZoneOffset");
                        int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(query, "secondaryNrNci");
                        int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(query, "isUsingCarrierAggregation");
                        int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(query, "is5GConnected");
                        int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
                        int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
                        int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(query, "indoorOutdoorWeight");
                        int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(query, "overrideNetworkType");
                        int i4 = columnIndexOrThrow13;
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            MNSIEntity mNSIEntity = new MNSIEntity();
                            ArrayList arrayList2 = arrayList;
                            mNSIEntity.setId(query.getInt(columnIndexOrThrow));
                            mNSIEntity.setTransmitted(query.getInt(columnIndexOrThrow2));
                            if (query.isNull(columnIndexOrThrow3)) {
                                l = null;
                            } else {
                                l = Long.valueOf(query.getLong(columnIndexOrThrow3));
                            }
                            mNSIEntity.setTimeStamp(l);
                            if (query.isNull(columnIndexOrThrow4)) {
                                str = null;
                            } else {
                                str = query.getString(columnIndexOrThrow4);
                            }
                            mNSIEntity.setTimeZone(str);
                            if (query.isNull(columnIndexOrThrow5)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow5);
                            }
                            mNSIEntity.setPhoneType(str2);
                            if (query.isNull(columnIndexOrThrow6)) {
                                str3 = null;
                            } else {
                                str3 = query.getString(columnIndexOrThrow6);
                            }
                            mNSIEntity.setNetworkTypeString(str3);
                            if (query.isNull(columnIndexOrThrow7)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow7));
                            }
                            mNSIEntity.setDbm(num);
                            if (query.isNull(columnIndexOrThrow8)) {
                                num2 = null;
                            } else {
                                num2 = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                            }
                            mNSIEntity.setAsu(num2);
                            if (query.isNull(columnIndexOrThrow9)) {
                                num3 = null;
                            } else {
                                num3 = Integer.valueOf(query.getInt(columnIndexOrThrow9));
                            }
                            mNSIEntity.setEcio(num3);
                            if (query.isNull(columnIndexOrThrow10)) {
                                num4 = null;
                            } else {
                                num4 = Integer.valueOf(query.getInt(columnIndexOrThrow10));
                            }
                            mNSIEntity.setRsrp(num4);
                            if (query.isNull(columnIndexOrThrow11)) {
                                num5 = null;
                            } else {
                                num5 = Integer.valueOf(query.getInt(columnIndexOrThrow11));
                            }
                            mNSIEntity.setRsrq(num5);
                            if (query.isNull(columnIndexOrThrow12)) {
                                num6 = null;
                            } else {
                                num6 = Integer.valueOf(query.getInt(columnIndexOrThrow12));
                            }
                            mNSIEntity.setBitErrorRate(num6);
                            int i5 = i4;
                            if (query.isNull(i5)) {
                                i = i5;
                                num7 = null;
                            } else {
                                i = i5;
                                num7 = Integer.valueOf(query.getInt(i5));
                            }
                            mNSIEntity.setWcdmaBitErrorRate(num7);
                            int i6 = columnIndexOrThrow14;
                            if (query.isNull(i6)) {
                                i2 = i6;
                                l2 = null;
                            } else {
                                i2 = i6;
                                l2 = Long.valueOf(query.getLong(i6));
                            }
                            mNSIEntity.setLocationTimeStamp(l2);
                            int i7 = columnIndexOrThrow15;
                            if (query.isNull(i7)) {
                                columnIndexOrThrow15 = i7;
                                str4 = null;
                            } else {
                                columnIndexOrThrow15 = i7;
                                str4 = query.getString(i7);
                            }
                            mNSIEntity.setLocationProvider(str4);
                            int i8 = columnIndexOrThrow16;
                            if (query.isNull(i8)) {
                                columnIndexOrThrow16 = i8;
                                f = null;
                            } else {
                                columnIndexOrThrow16 = i8;
                                f = Float.valueOf(query.getFloat(i8));
                            }
                            mNSIEntity.setAccuracy(f);
                            int i9 = columnIndexOrThrow17;
                            if (query.isNull(i9)) {
                                columnIndexOrThrow17 = i9;
                                str5 = null;
                            } else {
                                columnIndexOrThrow17 = i9;
                                str5 = query.getString(i9);
                            }
                            mNSIEntity.setNetworkOperatorName(str5);
                            int i10 = columnIndexOrThrow18;
                            if (query.isNull(i10)) {
                                columnIndexOrThrow18 = i10;
                                str6 = null;
                            } else {
                                columnIndexOrThrow18 = i10;
                                str6 = query.getString(i10);
                            }
                            mNSIEntity.setNetworkCountryIso(str6);
                            int i11 = columnIndexOrThrow19;
                            if (query.isNull(i11)) {
                                columnIndexOrThrow19 = i11;
                                num8 = null;
                            } else {
                                columnIndexOrThrow19 = i11;
                                num8 = Integer.valueOf(query.getInt(i11));
                            }
                            mNSIEntity.setNetworkMnc(num8);
                            int i12 = columnIndexOrThrow20;
                            if (query.isNull(i12)) {
                                columnIndexOrThrow20 = i12;
                                num9 = null;
                            } else {
                                columnIndexOrThrow20 = i12;
                                num9 = Integer.valueOf(query.getInt(i12));
                            }
                            mNSIEntity.setNetworkMcc(num9);
                            int i13 = columnIndexOrThrow21;
                            if (query.isNull(i13)) {
                                columnIndexOrThrow21 = i13;
                                str7 = null;
                            } else {
                                columnIndexOrThrow21 = i13;
                                str7 = query.getString(i13);
                            }
                            mNSIEntity.setSimOperatorName(str7);
                            int i14 = columnIndexOrThrow22;
                            if (query.isNull(i14)) {
                                columnIndexOrThrow22 = i14;
                                str8 = null;
                            } else {
                                columnIndexOrThrow22 = i14;
                                str8 = query.getString(i14);
                            }
                            mNSIEntity.setSimCountryIso(str8);
                            int i15 = columnIndexOrThrow23;
                            if (query.isNull(i15)) {
                                columnIndexOrThrow23 = i15;
                                num10 = null;
                            } else {
                                columnIndexOrThrow23 = i15;
                                num10 = Integer.valueOf(query.getInt(i15));
                            }
                            mNSIEntity.setSimMnc(num10);
                            int i16 = columnIndexOrThrow24;
                            if (query.isNull(i16)) {
                                columnIndexOrThrow24 = i16;
                                num11 = null;
                            } else {
                                columnIndexOrThrow24 = i16;
                                num11 = Integer.valueOf(query.getInt(i16));
                            }
                            mNSIEntity.setSimMcc(num11);
                            int i17 = columnIndexOrThrow25;
                            if (query.isNull(i17)) {
                                columnIndexOrThrow25 = i17;
                                num12 = null;
                            } else {
                                columnIndexOrThrow25 = i17;
                                num12 = Integer.valueOf(query.getInt(i17));
                            }
                            mNSIEntity.setSimSlot(num12);
                            int i18 = columnIndexOrThrow26;
                            if (query.isNull(i18)) {
                                columnIndexOrThrow26 = i18;
                                num13 = null;
                            } else {
                                columnIndexOrThrow26 = i18;
                                num13 = Integer.valueOf(query.getInt(i18));
                            }
                            mNSIEntity.setIsDataDefaultSim(num13);
                            int i19 = columnIndexOrThrow27;
                            if (query.isNull(i19)) {
                                num14 = null;
                            } else {
                                num14 = Integer.valueOf(query.getInt(i19));
                            }
                            if (num14 == null) {
                                columnIndexOrThrow27 = i19;
                                bool = null;
                            } else {
                                columnIndexOrThrow27 = i19;
                                bool = Boolean.valueOf(num14.intValue() != 0);
                            }
                            mNSIEntity.setPrimaryConnection(bool);
                            int i20 = columnIndexOrThrow28;
                            if (query.isNull(i20)) {
                                columnIndexOrThrow28 = i20;
                                num15 = null;
                            } else {
                                columnIndexOrThrow28 = i20;
                                num15 = Integer.valueOf(query.getInt(i20));
                            }
                            mNSIEntity.setResourcesMnc(num15);
                            int i21 = columnIndexOrThrow29;
                            if (query.isNull(i21)) {
                                columnIndexOrThrow29 = i21;
                                num16 = null;
                            } else {
                                columnIndexOrThrow29 = i21;
                                num16 = Integer.valueOf(query.getInt(i21));
                            }
                            mNSIEntity.setResourcesMcc(num16);
                            int i22 = columnIndexOrThrow30;
                            if (query.isNull(i22)) {
                                columnIndexOrThrow30 = i22;
                                num17 = null;
                            } else {
                                columnIndexOrThrow30 = i22;
                                num17 = Integer.valueOf(query.getInt(i22));
                            }
                            mNSIEntity.setRegistered(num17);
                            int i23 = columnIndexOrThrow31;
                            if (query.isNull(i23)) {
                                columnIndexOrThrow31 = i23;
                                num18 = null;
                            } else {
                                columnIndexOrThrow31 = i23;
                                num18 = Integer.valueOf(query.getInt(i23));
                            }
                            mNSIEntity.setLteSignalStrength(num18);
                            int i24 = columnIndexOrThrow32;
                            if (query.isNull(i24)) {
                                columnIndexOrThrow32 = i24;
                                num19 = null;
                            } else {
                                columnIndexOrThrow32 = i24;
                                num19 = Integer.valueOf(query.getInt(i24));
                            }
                            mNSIEntity.setLteRsrp(num19);
                            int i25 = columnIndexOrThrow33;
                            if (query.isNull(i25)) {
                                columnIndexOrThrow33 = i25;
                                num20 = null;
                            } else {
                                columnIndexOrThrow33 = i25;
                                num20 = Integer.valueOf(query.getInt(i25));
                            }
                            mNSIEntity.setLteRsrq(num20);
                            int i26 = columnIndexOrThrow34;
                            if (query.isNull(i26)) {
                                columnIndexOrThrow34 = i26;
                                num21 = null;
                            } else {
                                columnIndexOrThrow34 = i26;
                                num21 = Integer.valueOf(query.getInt(i26));
                            }
                            mNSIEntity.setLteRssnr(num21);
                            int i27 = columnIndexOrThrow35;
                            if (query.isNull(i27)) {
                                columnIndexOrThrow35 = i27;
                                num22 = null;
                            } else {
                                columnIndexOrThrow35 = i27;
                                num22 = Integer.valueOf(query.getInt(i27));
                            }
                            mNSIEntity.setLteRssi(num22);
                            int i28 = columnIndexOrThrow36;
                            if (query.isNull(i28)) {
                                columnIndexOrThrow36 = i28;
                                str9 = null;
                            } else {
                                columnIndexOrThrow36 = i28;
                                str9 = query.getString(i28);
                            }
                            mNSIEntity.setLteBand(str9);
                            int i29 = columnIndexOrThrow37;
                            if (query.isNull(i29)) {
                                columnIndexOrThrow37 = i29;
                                num23 = null;
                            } else {
                                columnIndexOrThrow37 = i29;
                                num23 = Integer.valueOf(query.getInt(i29));
                            }
                            mNSIEntity.setLteCqi(num23);
                            int i30 = columnIndexOrThrow38;
                            if (query.isNull(i30)) {
                                columnIndexOrThrow38 = i30;
                                num24 = null;
                            } else {
                                columnIndexOrThrow38 = i30;
                                num24 = Integer.valueOf(query.getInt(i30));
                            }
                            mNSIEntity.setLteDbm(num24);
                            int i31 = columnIndexOrThrow39;
                            if (query.isNull(i31)) {
                                columnIndexOrThrow39 = i31;
                                num25 = null;
                            } else {
                                columnIndexOrThrow39 = i31;
                                num25 = Integer.valueOf(query.getInt(i31));
                            }
                            mNSIEntity.setLteAsu(num25);
                            int i32 = columnIndexOrThrow40;
                            if (query.isNull(i32)) {
                                columnIndexOrThrow40 = i32;
                                num26 = null;
                            } else {
                                columnIndexOrThrow40 = i32;
                                num26 = Integer.valueOf(query.getInt(i32));
                            }
                            mNSIEntity.setCdmaDbm(num26);
                            int i33 = columnIndexOrThrow41;
                            if (query.isNull(i33)) {
                                columnIndexOrThrow41 = i33;
                                num27 = null;
                            } else {
                                columnIndexOrThrow41 = i33;
                                num27 = Integer.valueOf(query.getInt(i33));
                            }
                            mNSIEntity.setCdmaAsu(num27);
                            int i34 = columnIndexOrThrow42;
                            if (query.isNull(i34)) {
                                columnIndexOrThrow42 = i34;
                                num28 = null;
                            } else {
                                columnIndexOrThrow42 = i34;
                                num28 = Integer.valueOf(query.getInt(i34));
                            }
                            mNSIEntity.setCdmaEcio(num28);
                            int i35 = columnIndexOrThrow43;
                            if (query.isNull(i35)) {
                                columnIndexOrThrow43 = i35;
                                num29 = null;
                            } else {
                                columnIndexOrThrow43 = i35;
                                num29 = Integer.valueOf(query.getInt(i35));
                            }
                            mNSIEntity.setEvdoDbm(num29);
                            int i36 = columnIndexOrThrow44;
                            if (query.isNull(i36)) {
                                columnIndexOrThrow44 = i36;
                                num30 = null;
                            } else {
                                columnIndexOrThrow44 = i36;
                                num30 = Integer.valueOf(query.getInt(i36));
                            }
                            mNSIEntity.setEvdoAsu(num30);
                            int i37 = columnIndexOrThrow45;
                            if (query.isNull(i37)) {
                                columnIndexOrThrow45 = i37;
                                num31 = null;
                            } else {
                                columnIndexOrThrow45 = i37;
                                num31 = Integer.valueOf(query.getInt(i37));
                            }
                            mNSIEntity.setEvdoEcio(num31);
                            int i38 = columnIndexOrThrow46;
                            if (query.isNull(i38)) {
                                columnIndexOrThrow46 = i38;
                                num32 = null;
                            } else {
                                columnIndexOrThrow46 = i38;
                                num32 = Integer.valueOf(query.getInt(i38));
                            }
                            mNSIEntity.setEvdoSnr(num32);
                            int i39 = columnIndexOrThrow47;
                            if (query.isNull(i39)) {
                                columnIndexOrThrow47 = i39;
                                f2 = null;
                            } else {
                                columnIndexOrThrow47 = i39;
                                f2 = Float.valueOf(query.getFloat(i39));
                            }
                            mNSIEntity.setBarometric(f2);
                            int i40 = columnIndexOrThrow48;
                            if (query.isNull(i40)) {
                                columnIndexOrThrow48 = i40;
                                num33 = null;
                            } else {
                                columnIndexOrThrow48 = i40;
                                num33 = Integer.valueOf(query.getInt(i40));
                            }
                            mNSIEntity.setGsmDbm(num33);
                            int i41 = columnIndexOrThrow49;
                            if (query.isNull(i41)) {
                                columnIndexOrThrow49 = i41;
                                num34 = null;
                            } else {
                                columnIndexOrThrow49 = i41;
                                num34 = Integer.valueOf(query.getInt(i41));
                            }
                            mNSIEntity.setGsmAsu(num34);
                            int i42 = columnIndexOrThrow50;
                            if (query.isNull(i42)) {
                                columnIndexOrThrow50 = i42;
                                num35 = null;
                            } else {
                                columnIndexOrThrow50 = i42;
                                num35 = Integer.valueOf(query.getInt(i42));
                            }
                            mNSIEntity.setGsmBitError(num35);
                            int i43 = columnIndexOrThrow51;
                            if (query.isNull(i43)) {
                                columnIndexOrThrow51 = i43;
                                num36 = null;
                            } else {
                                columnIndexOrThrow51 = i43;
                                num36 = Integer.valueOf(query.getInt(i43));
                            }
                            mNSIEntity.setTdscdmaDbm(num36);
                            int i44 = columnIndexOrThrow52;
                            if (query.isNull(i44)) {
                                columnIndexOrThrow52 = i44;
                                num37 = null;
                            } else {
                                columnIndexOrThrow52 = i44;
                                num37 = Integer.valueOf(query.getInt(i44));
                            }
                            mNSIEntity.setTdscdmaAsu(num37);
                            int i45 = columnIndexOrThrow53;
                            if (query.isNull(i45)) {
                                columnIndexOrThrow53 = i45;
                                num38 = null;
                            } else {
                                columnIndexOrThrow53 = i45;
                                num38 = Integer.valueOf(query.getInt(i45));
                            }
                            mNSIEntity.setGpsAvailable(num38);
                            int i46 = columnIndexOrThrow54;
                            if (query.isNull(i46)) {
                                columnIndexOrThrow54 = i46;
                                num39 = null;
                            } else {
                                columnIndexOrThrow54 = i46;
                                num39 = Integer.valueOf(query.getInt(i46));
                            }
                            mNSIEntity.setLteCi(num39);
                            int i47 = columnIndexOrThrow55;
                            if (query.isNull(i47)) {
                                columnIndexOrThrow55 = i47;
                                num40 = null;
                            } else {
                                columnIndexOrThrow55 = i47;
                                num40 = Integer.valueOf(query.getInt(i47));
                            }
                            mNSIEntity.setLtePci(num40);
                            int i48 = columnIndexOrThrow56;
                            if (query.isNull(i48)) {
                                columnIndexOrThrow56 = i48;
                                num41 = null;
                            } else {
                                columnIndexOrThrow56 = i48;
                                num41 = Integer.valueOf(query.getInt(i48));
                            }
                            mNSIEntity.setLteTac(num41);
                            int i49 = columnIndexOrThrow57;
                            if (query.isNull(i49)) {
                                columnIndexOrThrow57 = i49;
                                num42 = null;
                            } else {
                                columnIndexOrThrow57 = i49;
                                num42 = Integer.valueOf(query.getInt(i49));
                            }
                            mNSIEntity.setWcdmaDbm(num42);
                            int i50 = columnIndexOrThrow58;
                            if (query.isNull(i50)) {
                                columnIndexOrThrow58 = i50;
                                num43 = null;
                            } else {
                                columnIndexOrThrow58 = i50;
                                num43 = Integer.valueOf(query.getInt(i50));
                            }
                            mNSIEntity.setWcdmaAsu(num43);
                            int i51 = columnIndexOrThrow59;
                            if (query.isNull(i51)) {
                                columnIndexOrThrow59 = i51;
                                num44 = null;
                            } else {
                                columnIndexOrThrow59 = i51;
                                num44 = Integer.valueOf(query.getInt(i51));
                            }
                            mNSIEntity.setWcdmaCid(num44);
                            int i52 = columnIndexOrThrow60;
                            if (query.isNull(i52)) {
                                columnIndexOrThrow60 = i52;
                                num45 = null;
                            } else {
                                columnIndexOrThrow60 = i52;
                                num45 = Integer.valueOf(query.getInt(i52));
                            }
                            mNSIEntity.setWcdmaLac(num45);
                            int i53 = columnIndexOrThrow61;
                            if (query.isNull(i53)) {
                                columnIndexOrThrow61 = i53;
                                num46 = null;
                            } else {
                                columnIndexOrThrow61 = i53;
                                num46 = Integer.valueOf(query.getInt(i53));
                            }
                            mNSIEntity.setWcdmaPsc(num46);
                            int i54 = columnIndexOrThrow62;
                            if (query.isNull(i54)) {
                                columnIndexOrThrow62 = i54;
                                num47 = null;
                            } else {
                                columnIndexOrThrow62 = i54;
                                num47 = Integer.valueOf(query.getInt(i54));
                            }
                            mNSIEntity.setRoaming(num47);
                            int i55 = columnIndexOrThrow;
                            int i56 = columnIndexOrThrow63;
                            mNSIEntity.setNetworkType(query.getInt(i56));
                            columnIndexOrThrow63 = i56;
                            int i57 = columnIndexOrThrow64;
                            mNSIEntity.setDataNetworkType(query.getInt(i57));
                            columnIndexOrThrow64 = i57;
                            int i58 = columnIndexOrThrow65;
                            mNSIEntity.setVoiceNetworkType(query.getInt(i58));
                            int i59 = columnIndexOrThrow66;
                            if (query.isNull(i59)) {
                                i3 = i58;
                                num48 = null;
                            } else {
                                i3 = i58;
                                num48 = Integer.valueOf(query.getInt(i59));
                            }
                            mNSIEntity.setLteTimingAdvance(num48);
                            int i60 = columnIndexOrThrow67;
                            if (query.isNull(i60)) {
                                columnIndexOrThrow67 = i60;
                                l3 = null;
                            } else {
                                columnIndexOrThrow67 = i60;
                                l3 = Long.valueOf(query.getLong(i60));
                            }
                            mNSIEntity.setDataRX(l3);
                            int i61 = columnIndexOrThrow68;
                            if (query.isNull(i61)) {
                                columnIndexOrThrow68 = i61;
                                l4 = null;
                            } else {
                                columnIndexOrThrow68 = i61;
                                l4 = Long.valueOf(query.getLong(i61));
                            }
                            mNSIEntity.setDataTX(l4);
                            int i62 = columnIndexOrThrow69;
                            if (query.isNull(i62)) {
                                columnIndexOrThrow69 = i62;
                                num49 = null;
                            } else {
                                columnIndexOrThrow69 = i62;
                                num49 = Integer.valueOf(query.getInt(i62));
                            }
                            mNSIEntity.setNrAsuLevel(num49);
                            int i63 = columnIndexOrThrow70;
                            if (query.isNull(i63)) {
                                columnIndexOrThrow70 = i63;
                                num50 = null;
                            } else {
                                columnIndexOrThrow70 = i63;
                                num50 = Integer.valueOf(query.getInt(i63));
                            }
                            mNSIEntity.setNrCsiRsrp(num50);
                            int i64 = columnIndexOrThrow71;
                            if (query.isNull(i64)) {
                                columnIndexOrThrow71 = i64;
                                num51 = null;
                            } else {
                                columnIndexOrThrow71 = i64;
                                num51 = Integer.valueOf(query.getInt(i64));
                            }
                            mNSIEntity.setNrCsiRsrq(num51);
                            int i65 = columnIndexOrThrow72;
                            if (query.isNull(i65)) {
                                columnIndexOrThrow72 = i65;
                                num52 = null;
                            } else {
                                columnIndexOrThrow72 = i65;
                                num52 = Integer.valueOf(query.getInt(i65));
                            }
                            mNSIEntity.setNrCsiSinr(num52);
                            int i66 = columnIndexOrThrow73;
                            if (query.isNull(i66)) {
                                columnIndexOrThrow73 = i66;
                                num53 = null;
                            } else {
                                columnIndexOrThrow73 = i66;
                                num53 = Integer.valueOf(query.getInt(i66));
                            }
                            mNSIEntity.setNrDbm(num53);
                            int i67 = columnIndexOrThrow74;
                            if (query.isNull(i67)) {
                                columnIndexOrThrow74 = i67;
                                num54 = null;
                            } else {
                                columnIndexOrThrow74 = i67;
                                num54 = Integer.valueOf(query.getInt(i67));
                            }
                            mNSIEntity.setNrLevel(num54);
                            int i68 = columnIndexOrThrow75;
                            if (query.isNull(i68)) {
                                columnIndexOrThrow75 = i68;
                                num55 = null;
                            } else {
                                columnIndexOrThrow75 = i68;
                                num55 = Integer.valueOf(query.getInt(i68));
                            }
                            mNSIEntity.setNrSsRsrp(num55);
                            int i69 = columnIndexOrThrow76;
                            if (query.isNull(i69)) {
                                columnIndexOrThrow76 = i69;
                                num56 = null;
                            } else {
                                columnIndexOrThrow76 = i69;
                                num56 = Integer.valueOf(query.getInt(i69));
                            }
                            mNSIEntity.setNrSsRsrq(num56);
                            int i70 = columnIndexOrThrow77;
                            if (query.isNull(i70)) {
                                columnIndexOrThrow77 = i70;
                                num57 = null;
                            } else {
                                columnIndexOrThrow77 = i70;
                                num57 = Integer.valueOf(query.getInt(i70));
                            }
                            mNSIEntity.setNrSsSinr(num57);
                            int i71 = columnIndexOrThrow78;
                            if (query.isNull(i71)) {
                                columnIndexOrThrow78 = i71;
                                num58 = null;
                            } else {
                                columnIndexOrThrow78 = i71;
                                num58 = Integer.valueOf(query.getInt(i71));
                            }
                            mNSIEntity.setCompleteness(num58);
                            int i72 = columnIndexOrThrow79;
                            if (query.isNull(i72)) {
                                columnIndexOrThrow79 = i72;
                                str10 = null;
                            } else {
                                columnIndexOrThrow79 = i72;
                                str10 = query.getString(i72);
                            }
                            mNSIEntity.setNrBand(str10);
                            int i73 = columnIndexOrThrow80;
                            if (query.isNull(i73)) {
                                columnIndexOrThrow80 = i73;
                                str11 = null;
                            } else {
                                columnIndexOrThrow80 = i73;
                                str11 = query.getString(i73);
                            }
                            mNSIEntity.setPermissions(str11);
                            int i74 = columnIndexOrThrow81;
                            if (query.isNull(i74)) {
                                columnIndexOrThrow81 = i74;
                                l5 = null;
                            } else {
                                columnIndexOrThrow81 = i74;
                                l5 = Long.valueOf(query.getLong(i74));
                            }
                            mNSIEntity.setCelltowerInfoTimestamp(l5);
                            int i75 = columnIndexOrThrow82;
                            if (query.isNull(i75)) {
                                columnIndexOrThrow82 = i75;
                                num59 = null;
                            } else {
                                columnIndexOrThrow82 = i75;
                                num59 = Integer.valueOf(query.getInt(i75));
                            }
                            mNSIEntity.setBaseStationId(num59);
                            int i76 = columnIndexOrThrow83;
                            if (query.isNull(i76)) {
                                columnIndexOrThrow83 = i76;
                                d = null;
                            } else {
                                columnIndexOrThrow83 = i76;
                                d = Double.valueOf(query.getDouble(i76));
                            }
                            mNSIEntity.setBaseStationLatitude(d);
                            int i77 = columnIndexOrThrow84;
                            if (query.isNull(i77)) {
                                columnIndexOrThrow84 = i77;
                                d2 = null;
                            } else {
                                columnIndexOrThrow84 = i77;
                                d2 = Double.valueOf(query.getDouble(i77));
                            }
                            mNSIEntity.setBaseStationLongitude(d2);
                            int i78 = columnIndexOrThrow85;
                            if (query.isNull(i78)) {
                                columnIndexOrThrow85 = i78;
                                num60 = null;
                            } else {
                                columnIndexOrThrow85 = i78;
                                num60 = Integer.valueOf(query.getInt(i78));
                            }
                            mNSIEntity.setNetworkId(num60);
                            int i79 = columnIndexOrThrow86;
                            if (query.isNull(i79)) {
                                columnIndexOrThrow86 = i79;
                                num61 = null;
                            } else {
                                columnIndexOrThrow86 = i79;
                                num61 = Integer.valueOf(query.getInt(i79));
                            }
                            mNSIEntity.setSystemId(num61);
                            int i80 = columnIndexOrThrow87;
                            if (query.isNull(i80)) {
                                columnIndexOrThrow87 = i80;
                                num62 = null;
                            } else {
                                columnIndexOrThrow87 = i80;
                                num62 = Integer.valueOf(query.getInt(i80));
                            }
                            mNSIEntity.setCid(num62);
                            int i81 = columnIndexOrThrow88;
                            if (query.isNull(i81)) {
                                columnIndexOrThrow88 = i81;
                                num63 = null;
                            } else {
                                columnIndexOrThrow88 = i81;
                                num63 = Integer.valueOf(query.getInt(i81));
                            }
                            mNSIEntity.setLac(num63);
                            int i82 = columnIndexOrThrow89;
                            if (query.isNull(i82)) {
                                columnIndexOrThrow89 = i82;
                                num64 = null;
                            } else {
                                columnIndexOrThrow89 = i82;
                                num64 = Integer.valueOf(query.getInt(i82));
                            }
                            mNSIEntity.setGsmArfcn(num64);
                            int i83 = columnIndexOrThrow90;
                            if (query.isNull(i83)) {
                                columnIndexOrThrow90 = i83;
                                num65 = null;
                            } else {
                                columnIndexOrThrow90 = i83;
                                num65 = Integer.valueOf(query.getInt(i83));
                            }
                            mNSIEntity.setGsmBsic(num65);
                            int i84 = columnIndexOrThrow91;
                            if (query.isNull(i84)) {
                                columnIndexOrThrow91 = i84;
                                num66 = null;
                            } else {
                                columnIndexOrThrow91 = i84;
                                num66 = Integer.valueOf(query.getInt(i84));
                            }
                            mNSIEntity.setLteEarfcn(num66);
                            int i85 = columnIndexOrThrow92;
                            if (query.isNull(i85)) {
                                columnIndexOrThrow92 = i85;
                                num67 = null;
                            } else {
                                columnIndexOrThrow92 = i85;
                                num67 = Integer.valueOf(query.getInt(i85));
                            }
                            mNSIEntity.setLteBandwidth(num67);
                            int i86 = columnIndexOrThrow93;
                            if (query.isNull(i86)) {
                                columnIndexOrThrow93 = i86;
                                num68 = null;
                            } else {
                                columnIndexOrThrow93 = i86;
                                num68 = Integer.valueOf(query.getInt(i86));
                            }
                            mNSIEntity.setPsc(num68);
                            int i87 = columnIndexOrThrow94;
                            if (query.isNull(i87)) {
                                columnIndexOrThrow94 = i87;
                                num69 = null;
                            } else {
                                columnIndexOrThrow94 = i87;
                                num69 = Integer.valueOf(query.getInt(i87));
                            }
                            mNSIEntity.setWcdmaUarfcn(num69);
                            int i88 = columnIndexOrThrow95;
                            if (query.isNull(i88)) {
                                columnIndexOrThrow95 = i88;
                                l6 = null;
                            } else {
                                columnIndexOrThrow95 = i88;
                                l6 = Long.valueOf(query.getLong(i88));
                            }
                            mNSIEntity.setNrNci(l6);
                            int i89 = columnIndexOrThrow96;
                            if (query.isNull(i89)) {
                                columnIndexOrThrow96 = i89;
                                num70 = null;
                            } else {
                                columnIndexOrThrow96 = i89;
                                num70 = Integer.valueOf(query.getInt(i89));
                            }
                            mNSIEntity.setNrArfcn(num70);
                            int i90 = columnIndexOrThrow97;
                            if (query.isNull(i90)) {
                                columnIndexOrThrow97 = i90;
                                num71 = null;
                            } else {
                                columnIndexOrThrow97 = i90;
                                num71 = Integer.valueOf(query.getInt(i90));
                            }
                            mNSIEntity.setNrPci(num71);
                            int i91 = columnIndexOrThrow98;
                            if (query.isNull(i91)) {
                                columnIndexOrThrow98 = i91;
                                num72 = null;
                            } else {
                                columnIndexOrThrow98 = i91;
                                num72 = Integer.valueOf(query.getInt(i91));
                            }
                            mNSIEntity.setNrTac(num72);
                            int i92 = columnIndexOrThrow99;
                            if (query.isNull(i92)) {
                                columnIndexOrThrow99 = i92;
                                num73 = null;
                            } else {
                                columnIndexOrThrow99 = i92;
                                num73 = Integer.valueOf(query.getInt(i92));
                            }
                            mNSIEntity.setTimeZoneOffset(num73);
                            int i93 = columnIndexOrThrow100;
                            if (query.isNull(i93)) {
                                columnIndexOrThrow100 = i93;
                                l7 = null;
                            } else {
                                columnIndexOrThrow100 = i93;
                                l7 = Long.valueOf(query.getLong(i93));
                            }
                            mNSIEntity.setSecondaryNrNci(l7);
                            int i94 = columnIndexOrThrow101;
                            if (query.isNull(i94)) {
                                columnIndexOrThrow101 = i94;
                                num74 = null;
                            } else {
                                columnIndexOrThrow101 = i94;
                                num74 = Integer.valueOf(query.getInt(i94));
                            }
                            mNSIEntity.setCarrierAgregationUsed(num74);
                            int i95 = columnIndexOrThrow102;
                            if (query.isNull(i95)) {
                                columnIndexOrThrow102 = i95;
                                num75 = null;
                            } else {
                                columnIndexOrThrow102 = i95;
                                num75 = Integer.valueOf(query.getInt(i95));
                            }
                            mNSIEntity.setConnectivityTo5G(num75);
                            int i96 = columnIndexOrThrow103;
                            if (query.isNull(i96)) {
                                columnIndexOrThrow103 = i96;
                                d3 = null;
                            } else {
                                columnIndexOrThrow103 = i96;
                                d3 = Double.valueOf(query.getDouble(i96));
                            }
                            mNSIEntity.setLatitude(d3);
                            int i97 = columnIndexOrThrow104;
                            if (query.isNull(i97)) {
                                columnIndexOrThrow104 = i97;
                                d4 = null;
                            } else {
                                columnIndexOrThrow104 = i97;
                                d4 = Double.valueOf(query.getDouble(i97));
                            }
                            mNSIEntity.setLongitude(d4);
                            int i98 = columnIndexOrThrow105;
                            if (query.isNull(i98)) {
                                columnIndexOrThrow105 = i98;
                                d5 = null;
                            } else {
                                columnIndexOrThrow105 = i98;
                                d5 = Double.valueOf(query.getDouble(i98));
                            }
                            mNSIEntity.setIndoorOutdoorWeight(d5);
                            int i99 = columnIndexOrThrow106;
                            if (query.isNull(i99)) {
                                columnIndexOrThrow106 = i99;
                                num76 = null;
                            } else {
                                columnIndexOrThrow106 = i99;
                                num76 = Integer.valueOf(query.getInt(i99));
                            }
                            mNSIEntity.setOverrideNetworkType(num76);
                            arrayList = arrayList2;
                            arrayList.add(mNSIEntity);
                            columnIndexOrThrow65 = i3;
                            columnIndexOrThrow66 = i59;
                            columnIndexOrThrow = i55;
                            columnIndexOrThrow14 = i2;
                            i4 = i;
                        }
                        query.close();
                        acquire.release();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        r3 = this;
                        Throwable th2 = th;
                        query.close();
                        acquire.release();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r3 = this;
                    Throwable th22 = th;
                    query.close();
                    acquire.release();
                    throw th22;
                }
            }
        }, continuation);
    }
}
