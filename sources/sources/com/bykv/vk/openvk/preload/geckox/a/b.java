package com.bykv.vk.openvk.preload.geckox.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.statistic.model.StatisticModel;
import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import com.bykv.vk.openvk.preload.geckox.utils.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AbandonChannelSQLiteHelper */
public class b extends SQLiteOpenHelper {
    private static volatile b a;

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private b(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static b a(Context context) {
        String str;
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    Context applicationContext = context.getApplicationContext();
                    StringBuilder sb = new StringBuilder("geckox_clean_statistic");
                    if (!TextUtils.isEmpty(a.a)) {
                        str = a.a;
                    } else {
                        String a2 = a.a();
                        a.a = a2;
                        if (!TextUtils.isEmpty(a2)) {
                            str = a.a;
                        } else {
                            String b = a.b();
                            a.a = b;
                            if (!TextUtils.isEmpty(b)) {
                                str = a.a;
                            } else {
                                str = a.c(context);
                                a.a = str;
                            }
                        }
                    }
                    sb.append(str);
                    sb.append(".db");
                    a = new b(applicationContext, sb.toString());
                }
            }
        }
        return a;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists geckox_clean_statistic (id integer primary key autoincrement,access_key text,channel text,clean_type integer,status integer,pkg_id integer,err_code integer,clean_strategy integer,clean_duration integer,err_msg text)");
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2, int i, int i2, long j, int i3, String str3, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("access_key", str);
        contentValues.put("channel", str2);
        contentValues.put("clean_type", Integer.valueOf(i));
        contentValues.put("status", Integer.valueOf(i2));
        contentValues.put("pkg_id", Long.valueOf(j));
        contentValues.put("err_code", Integer.valueOf(i3));
        contentValues.put("err_msg", str3);
        contentValues.put("clean_duration", Long.valueOf(j2));
        contentValues.put("clean_strategy", 1);
        try {
            getWritableDatabase().insert("geckox_clean_statistic", (String) null, contentValues);
        } catch (Exception e) {
            com.bykv.vk.openvk.preload.geckox.h.b.a("clean-channel", "insert failed", e);
        }
    }

    public final List<StatisticModel.PackageStatisticModel> a() {
        Cursor cursor;
        String str;
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            cursor = getWritableDatabase().query("geckox_clean_statistic", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (cursor == null) {
                return arrayList;
            }
            while (cursor.moveToNext()) {
                try {
                    String string = cursor.getString(cursor.getColumnIndex("access_key"));
                    String string2 = cursor.getString(cursor.getColumnIndex("channel"));
                    int i = cursor.getInt(cursor.getColumnIndex("clean_type"));
                    int i2 = cursor.getInt(cursor.getColumnIndex("status"));
                    int i3 = cursor.getInt(cursor.getColumnIndex("err_code"));
                    String string3 = cursor.getString(cursor.getColumnIndex("err_msg"));
                    int i4 = cursor.getInt(cursor.getColumnIndex("clean_strategy"));
                    long j = cursor.getLong(cursor.getColumnIndex("clean_duration"));
                    StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
                    packageStatisticModel.accessKey = string;
                    packageStatisticModel.channel = string2;
                    packageStatisticModel.statsType = Integer.valueOf(i2);
                    packageStatisticModel.id = Long.valueOf((long) cursor.getInt(cursor.getColumnIndex("pkg_id")));
                    if (i3 == 0) {
                        str = null;
                    } else {
                        str = String.valueOf(i3);
                    }
                    packageStatisticModel.errCode = str;
                    packageStatisticModel.errMsg = string3;
                    packageStatisticModel.cleanType = Integer.valueOf(i);
                    packageStatisticModel.cleanDuration = Long.valueOf(j);
                    packageStatisticModel.cleanStrategy = Integer.valueOf(i4);
                    arrayList.add(packageStatisticModel);
                } catch (Exception e) {
                    e = e;
                    cursor2 = cursor;
                    com.bykv.vk.openvk.preload.geckox.h.b.a("clean-channel", "get all statistic failed!", e);
                    cursor = cursor2;
                    CloseableUtils.close(cursor);
                    return arrayList;
                }
            }
            getWritableDatabase().delete("geckox_clean_statistic", (String) null, (String[]) null);
            CloseableUtils.close(cursor);
            return arrayList;
        } catch (Exception e2) {
            e = e2;
            com.bykv.vk.openvk.preload.geckox.h.b.a("clean-channel", "get all statistic failed!", e);
            cursor = cursor2;
            CloseableUtils.close(cursor);
            return arrayList;
        }
    }
}
