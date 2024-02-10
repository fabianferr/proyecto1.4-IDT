package com.bytedance.sdk.openadsdk.b;

/* compiled from: AdEventRepertoryImpl */
public class d {
    public static String a() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public static String b() {
        return "ALTER TABLE adevent ADD COLUMN encrypt INTEGER default 0";
    }
}
