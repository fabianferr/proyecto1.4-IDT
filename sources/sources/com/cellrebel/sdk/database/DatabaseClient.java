package com.cellrebel.sdk.database;

import android.content.Context;

public class DatabaseClient {
    private static DatabaseClient b;
    private static SDKRoomDatabase c;
    private Context a;

    private DatabaseClient(Context context) {
        this.a = context;
        try {
            c = SDKRoomDatabase.a(context);
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public static synchronized DatabaseClient a(Context context) {
        DatabaseClient databaseClient;
        synchronized (DatabaseClient.class) {
            if (b == null) {
                b = new DatabaseClient(context);
            }
            databaseClient = b;
        }
        return databaseClient;
    }

    public static SDKRoomDatabase a() {
        return c;
    }

    public static void b() {
        SDKRoomDatabase sDKRoomDatabase = c;
        if (sDKRoomDatabase != null) {
            sDKRoomDatabase.clearAllTables();
        }
    }
}
