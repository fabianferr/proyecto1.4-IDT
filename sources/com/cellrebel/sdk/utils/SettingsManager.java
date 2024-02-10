package com.cellrebel.sdk.utils;

import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.database.dao.SettingsDAO;
import com.cellrebel.sdk.networking.beans.response.Settings;
import java.util.List;

public class SettingsManager {
    private static volatile SettingsManager c;
    private SettingsDAO a;
    private Settings b;

    private SettingsManager() {
        if (c == null) {
            try {
                this.a = DatabaseClient.a().p();
            } catch (Exception | OutOfMemoryError unused) {
            }
        } else {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SettingsManager b() {
        if (c == null) {
            synchronized (SettingsManager.class) {
                if (c == null) {
                    c = new SettingsManager();
                }
            }
        }
        return c;
    }

    public void a() {
        this.b = null;
    }

    public void a(Settings settings) {
        settings.pageLoadPeriodicityMeasurement(Integer.valueOf((settings.pageLoadPeriodicityMeasurement().intValue() / 15) * 15));
        settings.fileTransferPeriodicityTimer(Integer.valueOf((settings.fileTransferPeriodicityTimer().intValue() / 15) * 15));
        settings.videoBackgroundPeriodicityMeasurement(Integer.valueOf((settings.videoBackgroundPeriodicityMeasurement().intValue() / 15) * 15));
        try {
            this.a.a();
            this.b = settings;
            if (settings.connectionTestSettings() != null) {
                Settings settings2 = this.b;
                settings2.connectionTestVideoUrl(settings2.connectionTestSettings().videoUrl);
                Settings settings3 = this.b;
                settings3.connectionTestVideoTimeout(settings3.connectionTestSettings().videoTimeout);
                Settings settings4 = this.b;
                settings4.connectionTestVideoScore(settings4.connectionTestSettings().videoScore);
                Settings settings5 = this.b;
                settings5.connectionTestPageLoadUrl(settings5.connectionTestSettings().pageLoadUrl);
                Settings settings6 = this.b;
                settings6.connectionTestPageLoadTimeout(settings6.connectionTestSettings().pageLoadTimeout);
                Settings settings7 = this.b;
                settings7.connectionTestPageLoadScore(settings7.connectionTestSettings().pageLoadScore);
            }
            this.a.a(this.b);
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public Settings c() {
        Settings settings = this.b;
        if (settings == null) {
            settings = null;
            try {
                if (this.a == null) {
                    SettingsDAO p = DatabaseClient.a().p();
                    if (p == null) {
                        return null;
                    }
                    this.a = p;
                }
                List<Settings> b2 = this.a.b();
                if (b2.size() == 0) {
                    return null;
                }
                Settings settings2 = b2.get(0);
                this.b = settings2;
                return settings2;
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
        return settings;
    }
}
