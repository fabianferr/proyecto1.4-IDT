package com.appnext.core.ra.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class RecentAppsDatabase extends RoomDatabase {
    private static final String DB_NAME = "RecentAppsDatabase_Impl.db";
    private static volatile RecentAppsDatabase instance;

    public abstract b recentAppDao();

    public static synchronized RecentAppsDatabase getInstance(Context context) {
        RecentAppsDatabase recentAppsDatabase;
        synchronized (RecentAppsDatabase.class) {
            if (instance == null) {
                instance = create(context);
            }
            recentAppsDatabase = instance;
        }
        return recentAppsDatabase;
    }

    protected RecentAppsDatabase() {
    }

    private static RecentAppsDatabase create(Context context) {
        return Room.databaseBuilder(context, RecentAppsDatabase.class, DB_NAME).build();
    }
}
