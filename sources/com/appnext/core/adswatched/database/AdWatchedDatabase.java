package com.appnext.core.adswatched.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class AdWatchedDatabase extends RoomDatabase {
    private static final String DB_NAME = "AdWatchDatabase_Impl.db";
    private static volatile AdWatchedDatabase instance;

    public abstract a adWatchedDao();

    public static synchronized AdWatchedDatabase getInstance(Context context) {
        AdWatchedDatabase adWatchedDatabase;
        synchronized (AdWatchedDatabase.class) {
            if (instance == null) {
                instance = create(context);
            }
            adWatchedDatabase = instance;
        }
        return adWatchedDatabase;
    }

    protected AdWatchedDatabase() {
    }

    private static AdWatchedDatabase create(Context context) {
        return Room.databaseBuilder(context, AdWatchedDatabase.class, DB_NAME).build();
    }
}
