package com.cellrebel.sdk.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.cellrebel.sdk.database.dao.CellInfoDAO;
import com.cellrebel.sdk.database.dao.ConnectionMetricDAO;
import com.cellrebel.sdk.database.dao.ConnectionTimeActiveDAO;
import com.cellrebel.sdk.database.dao.ConnectionTimePassiveDAO;
import com.cellrebel.sdk.database.dao.CoverageMetricDAO;
import com.cellrebel.sdk.database.dao.DataUsageMetricDAO;
import com.cellrebel.sdk.database.dao.DeviceInfoDAO;
import com.cellrebel.sdk.database.dao.FileTransferDAO;
import com.cellrebel.sdk.database.dao.FileTransferMetricDAO;
import com.cellrebel.sdk.database.dao.GameLatencyDAO;
import com.cellrebel.sdk.database.dao.GameListDAO;
import com.cellrebel.sdk.database.dao.GameMetricDAO;
import com.cellrebel.sdk.database.dao.PageLoadScoreDAO;
import com.cellrebel.sdk.database.dao.PageLoadedMetricDAO;
import com.cellrebel.sdk.database.dao.PreferencesDAO;
import com.cellrebel.sdk.database.dao.SettingsDAO;
import com.cellrebel.sdk.database.dao.TimestampsDAO;
import com.cellrebel.sdk.database.dao.TraceRouteDAO;
import com.cellrebel.sdk.database.dao.TrafficProfileDAO;
import com.cellrebel.sdk.database.dao.TtiDAO;
import com.cellrebel.sdk.database.dao.VideoLoadScoreDAO;
import com.cellrebel.sdk.database.dao.VideoMetricDAO;
import com.cellrebel.sdk.database.dao.VoiceCallDAO;
import com.cellrebel.sdk.database.dao.WifiInfoMetricDAO;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class SDKRoomDatabase extends RoomDatabase {
    private static volatile SDKRoomDatabase a;
    static final ExecutorService b = Executors.newFixedThreadPool(4);
    private static Boolean c = Boolean.TRUE;
    public static Boolean d = Boolean.FALSE;

    public static SDKRoomDatabase a(Context context) {
        if (d.booleanValue()) {
            context.getApplicationContext().deleteDatabase("sdk_database");
        }
        if (a == null) {
            synchronized (SDKRoomDatabase.class) {
                if (a == null) {
                    a = Room.databaseBuilder(context.getApplicationContext(), SDKRoomDatabase.class, "sdk_database").allowMainThreadQueries().enableMultiInstanceInvalidation().fallbackToDestructiveMigration().build();
                }
            }
        }
        return a;
    }

    public abstract CellInfoDAO a();

    public abstract ConnectionMetricDAO b();

    public abstract ConnectionTimeActiveDAO c();

    public abstract ConnectionTimePassiveDAO d();

    public abstract CoverageMetricDAO e();

    public abstract DataUsageMetricDAO f();

    public abstract DeviceInfoDAO g();

    public abstract FileTransferDAO h();

    public abstract FileTransferMetricDAO i();

    public abstract GameMetricDAO j();

    public abstract GameLatencyDAO k();

    public abstract GameListDAO l();

    public abstract PageLoadedMetricDAO m();

    public abstract PageLoadScoreDAO n();

    public abstract PreferencesDAO o();

    public abstract SettingsDAO p();

    public abstract TimestampsDAO q();

    public abstract TraceRouteDAO r();

    public abstract TrafficProfileDAO s();

    public abstract TtiDAO t();

    public abstract VideoMetricDAO u();

    public abstract VideoLoadScoreDAO v();

    public abstract VoiceCallDAO w();

    public abstract WifiInfoMetricDAO x();
}
