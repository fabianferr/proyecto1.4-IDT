package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.facebook.internal.NativeProtocol;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.AabEntity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.out.Campaign;
import com.umlaut.crowd.CCS;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: CampaignDao */
public class f extends a<Campaign> {
    private static final String a = "com.mbridge.msdk.foundation.db.f";
    private static f b;
    private final String c = "rid";
    private final String d = CmcdConfiguration.KEY_CONTENT_ID;
    private final String e = CampaignEx.JSON_KEY_PLCT;
    private final String f = CampaignEx.JSON_KEY_PLCTB;
    private final String g = CampaignEx.JSON_KEY_TIMESTAMP;
    private final String h = "ridCount";
    private final String i = " WHERE ";
    private final String j = " AND ";
    private final String k = "SELECT ";
    private final String l = "*";
    private final String m = " FROM ";
    private final String n = " AND readyState = '0'";
    private final String o = " AND is_bid_campaign = 1";
    private final String p = " order by ts ASC";
    private final String q = " group by request_id";
    private final String r = " group by bid_token";

    private f(g gVar) {
        super(gVar);
    }

    public static synchronized f a(g gVar) {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                b = new f(gVar);
            }
            fVar = b;
        }
        return fVar;
    }

    public final synchronized void a(String str, int i2, int i3) {
        try {
            String str2 = "unitid = " + str + " AND level = " + i2 + " AND adSource = " + i3;
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete(FirebaseAnalytics.Param.CAMPAIGN, str2, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
        }
    }

    public final synchronized void a(String str, int i2, int i3, boolean z) {
        try {
            String str2 = "unitid = " + str + " AND level = " + i2 + " AND adSource = " + i3;
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(" AND is_bid_campaign = ");
            sb.append(z ? 1 : 0);
            String sb2 = sb.toString();
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete(FirebaseAnalytics.Param.CAMPAIGN, sb2, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void a(String str, List<CampaignEx> list) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx next : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("readyState", 2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("id = '" + next.getId() + "' AND " + "unitid" + " = " + str + " AND " + "request_id" + " = '" + next.getRequestId() + "'");
                    sb.append(" AND is_bid_campaign = ");
                    sb.append(next.isBidCampaign() ? 1 : 0);
                    String sb2 = sb.toString();
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update(FirebaseAnalytics.Param.CAMPAIGN, contentValues, sb2, (String[]) null);
                        }
                    } catch (SQLException e2) {
                        aa.d("CampaignDao", e2.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, List<CampaignEx> list, boolean z) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx next : list) {
                    try {
                        if (next.getLoadTimeoutState() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("unitid");
                            sb.append(" = '");
                            sb.append(str);
                            sb.append("' AND ");
                            sb.append("id");
                            sb.append(" = '");
                            sb.append(next.getId());
                            sb.append("' AND ");
                            sb.append("request_id");
                            sb.append(" = '");
                            sb.append(next.getRequestId());
                            sb.append("'");
                            if (ac.a().a("c_n_c_s", true)) {
                                sb.append(" AND readyState");
                                sb.append(" != 0");
                            }
                            if (z) {
                                sb.append(" AND is_bid_campaign = 1");
                            } else {
                                sb.append(" AND is_bid_campaign = 0");
                            }
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("readyState", 2);
                            SQLiteDatabase writableDatabase = getWritableDatabase();
                            if (writableDatabase != null) {
                                writableDatabase.update(FirebaseAnalytics.Param.CAMPAIGN, contentValues, sb.toString(), (String[]) null);
                            }
                        }
                    } catch (SQLException e2) {
                        aa.d("CampaignDao", e2.getLocalizedMessage());
                    }
                }
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r6, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r7, java.lang.String r8, int r9) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x0087
            if (r7 == 0) goto L_0x0087
            int r0 = r7.size()     // Catch:{ all -> 0x0089 }
            if (r0 <= 0) goto L_0x0087
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x0087
            android.database.sqlite.SQLiteDatabase r0 = r5.getWritableDatabase()     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x001d
            monitor-exit(r5)
            return
        L_0x001d:
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
        L_0x0021:
            boolean r1 = r7.hasNext()     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            if (r1 == 0) goto L_0x0087
            java.lang.Object r1 = r7.next()     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            if (r1 == 0) goto L_0x0021
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            r2.<init>()     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            java.lang.String r3 = "unitid = '"
            r2.append(r3)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            r2.append(r6)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            java.lang.String r3 = "' AND "
            r2.append(r3)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            java.lang.String r3 = "id"
            r2.append(r3)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            java.lang.String r3 = " = '"
            r2.append(r3)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            java.lang.String r3 = r1.getId()     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            r2.append(r3)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            java.lang.String r3 = "' AND "
            r2.append(r3)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            java.lang.String r3 = "request_id"
            r2.append(r3)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            java.lang.String r3 = " = '"
            r2.append(r3)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            java.lang.String r1 = r1.getRequestId()     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            r2.append(r1)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            java.lang.String r1 = "'"
            r2.append(r1)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            r2.<init>()     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            r2.put(r8, r3)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            java.lang.String r3 = "campaign"
            r4 = 0
            r0.update(r3, r2, r1, r4)     // Catch:{ Exception -> 0x0087, all -> 0x0085 }
            goto L_0x0021
        L_0x0085:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0089 }
        L_0x0087:
            monitor-exit(r5)
            return
        L_0x0089:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x008d
        L_0x008c:
            throw r6
        L_0x008d:
            goto L_0x008c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.a(java.lang.String, java.util.List, java.lang.String, int):void");
    }

    public final synchronized void a(String str, List<CampaignEx> list, List<CampaignEx> list2, boolean z) {
        String str2;
        if (getWritableDatabase() != null) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        for (CampaignEx next : list) {
                            try {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("readyState", 0);
                                String str3 = "unitid = '" + str + "' AND " + "id" + " = '" + next.getId() + "' AND " + "request_id" + " = '" + next.getRequestId() + "'";
                                if (z) {
                                    str2 = str3 + " AND " + "is_bid_campaign" + " = 1";
                                } else {
                                    str2 = str3 + " AND " + "is_bid_campaign" + " = 0";
                                }
                                getWritableDatabase().update(FirebaseAnalytics.Param.CAMPAIGN, contentValues, str2, (String[]) null);
                            } catch (Exception e2) {
                                aa.d("CampaignDao", e2.getLocalizedMessage());
                            }
                        }
                    }
                } catch (Exception e3) {
                    try {
                        aa.d("CampaignDao", e3.getLocalizedMessage());
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (list2 != null && list2.size() > 0) {
                for (CampaignEx next2 : list2) {
                    try {
                        if (next2.getLoadTimeoutState() == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("unitid");
                            sb.append(" = '");
                            sb.append(str);
                            sb.append("' AND ");
                            sb.append("id");
                            sb.append(" = '");
                            sb.append(next2.getId());
                            sb.append("' AND ");
                            sb.append("request_id");
                            sb.append(" = '");
                            sb.append(next2.getRequestId());
                            sb.append("'");
                            if (z) {
                                sb.append(" AND is_bid_campaign = 1");
                            } else {
                                sb.append(" AND is_bid_campaign = 0");
                            }
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("readyState", 2);
                            getWritableDatabase().update(FirebaseAnalytics.Param.CAMPAIGN, contentValues2, sb.toString(), (String[]) null);
                        }
                    } catch (SQLException e4) {
                        aa.d("CampaignDao", e4.getLocalizedMessage());
                    }
                }
            }
        } else {
            return;
        }
    }

    public final synchronized void b(String str, List<CampaignEx> list) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx next : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", 0);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update(FirebaseAnalytics.Param.CAMPAIGN, contentValues, "unitid = '" + str + "' AND " + "id" + " = '" + next.getId() + "' AND " + "request_id" + " = '" + next.getRequestId() + "'", (String[]) null);
                        }
                    } catch (Exception e2) {
                        aa.d("CampaignDao", e2.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, List<CampaignEx> list, String str2) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx next : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("local_request_id", str2);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update(FirebaseAnalytics.Param.CAMPAIGN, contentValues, "unitid = '" + str + "' AND " + "id" + " = '" + next.getId() + "' AND " + "request_id" + " = '" + next.getRequestId() + "'", (String[]) null);
                        }
                    } catch (Exception e2) {
                        aa.d("CampaignDao", e2.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, String str2) {
        try {
            String str3 = "id = '" + str + "' AND unitid = " + str2;
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete(FirebaseAnalytics.Param.CAMPAIGN, str3, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.delete(FirebaseAnalytics.Param.CAMPAIGN, "unitid = '" + str + "' AND readyState = 2", (String[]) null);
                }
            } catch (Exception e2) {
                aa.d("CampaignDao", e2.getLocalizedMessage());
            }
        } else {
            return;
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> b(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "' AND readyState = 2"
            java.lang.String r1 = "SELECT * FROM campaign WHERE unitid = '"
            monitor-enter(r4)
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            r3.append(r5)     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            r3.append(r0)     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            android.database.sqlite.SQLiteDatabase r5 = r4.getReadableDatabase()     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            android.database.Cursor r5 = r5.rawQuery(r0, r2)     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            if (r5 == 0) goto L_0x003f
            int r0 = r5.getCount()     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            if (r0 <= 0) goto L_0x003f
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            r0.<init>()     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
        L_0x002a:
            boolean r1 = r5.moveToNext()     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            if (r1 == 0) goto L_0x0038
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r4.a((android.database.Cursor) r5)     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            r0.add(r1)     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
            goto L_0x002a
        L_0x0038:
            if (r5 == 0) goto L_0x003d
            r5.close()     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
        L_0x003d:
            monitor-exit(r4)
            return r0
        L_0x003f:
            if (r5 == 0) goto L_0x0044
            r5.close()     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
        L_0x0044:
            monitor-exit(r4)
            return r2
        L_0x0046:
            monitor-exit(r4)
            return r2
        L_0x0048:
            monitor-exit(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.b(java.lang.String):java.util.List");
    }

    public final synchronized void a(List<CampaignEx> list, String str) {
        if (list != null) {
            if (list.size() > 0) {
                for (CampaignEx next : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("readyState", 2);
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.update(FirebaseAnalytics.Param.CAMPAIGN, contentValues, "unitid" + " = '" + str + "' AND " + "id" + " = '" + next.getId() + "' AND " + "request_id" + " = '" + next.getRequestId() + "'", (String[]) null);
                        }
                    } catch (SQLException e2) {
                        aa.d("CampaignDao", e2.getLocalizedMessage());
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, String str2, boolean z, String str3) {
        try {
            StringBuilder sb = new StringBuilder("id = '");
            sb.append(str);
            sb.append("' AND unitid = ");
            sb.append(str2);
            sb.append(" AND is_bid_campaign = ");
            sb.append(z ? "1" : "0");
            sb.append(" AND request_id = '");
            sb.append(str3);
            sb.append("'");
            String sb2 = sb.toString();
            if (getWritableDatabase() != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("readyState", 2);
                getWritableDatabase().update(FirebaseAnalytics.Param.CAMPAIGN, contentValues, sb2, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void b(String str, String str2) {
        try {
            if (getWritableDatabase() != null) {
                String str3 = "id = '" + str + "' AND request_id = '" + str2 + "'";
                ContentValues contentValues = new ContentValues();
                contentValues.put("readyState", 2);
                getWritableDatabase().update(FirebaseAnalytics.Param.CAMPAIGN, contentValues, str3, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void a(String str, String str2, int i2, int i3, boolean z) {
        String str3;
        try {
            String str4 = "id = '" + str + "' AND unitid = " + str2 + " AND level = " + i2 + " AND adSource = " + i3;
            if (z) {
                str3 = str4 + " AND is_bid_campaign = 1";
            } else {
                str3 = str4 + " AND is_bid_campaign = 0";
            }
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete(FirebaseAnalytics.Param.CAMPAIGN, str3, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void c(String str) {
        try {
            String str2 = "unitid = " + str;
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete(FirebaseAnalytics.Param.CAMPAIGN, str2, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
        }
    }

    public final synchronized void a(String str, int i2, boolean z) {
        String str2;
        if (z) {
            try {
                str2 = "placement_id = " + str + " AND ad_type = " + i2;
            } catch (Exception e2) {
                aa.d("CampaignDao", e2.getLocalizedMessage());
            }
        } else {
            str2 = "ad_type = " + i2;
        }
        if (getWritableDatabase() != null) {
            getWritableDatabase().delete(FirebaseAnalytics.Param.CAMPAIGN, str2, (String[]) null);
        } else {
            return;
        }
        return;
    }

    public final synchronized void a() {
        try {
            String str = "ts<" + (System.currentTimeMillis() - CCS.a) + " AND ts>0";
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete(FirebaseAnalytics.Param.CAMPAIGN, str, (String[]) null);
            }
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void a(long j2, String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = "(plctb>0 and (plctb* 1000+ts)<" + currentTimeMillis + ") or (plctb<=0 and ts<" + (currentTimeMillis - j2) + ") and unitid=?";
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete(FirebaseAnalytics.Param.CAMPAIGN, str2, strArr);
            }
        } catch (Exception e2) {
            aa.d(a, e2.getMessage());
        }
        return;
    }

    public final synchronized void b(long j2, String str) {
        try {
            String str2 = "ts<" + (System.currentTimeMillis() - j2) + " and unitid=?";
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete(FirebaseAnalytics.Param.CAMPAIGN, str2, strArr);
            }
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2, java.lang.String r3, java.lang.String r4, int r5) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x002b
            int r0 = r2.size()     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x000a
            goto L_0x002b
        L_0x000a:
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0012
            monitor-exit(r1)
            return
        L_0x0012:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0028 }
        L_0x0016:
            boolean r0 = r2.hasNext()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0026
            java.lang.Object r0 = r2.next()     // Catch:{ all -> 0x0028 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x0028 }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.lang.String) r3, (java.lang.String) r4, (int) r5)     // Catch:{ all -> 0x0028 }
            goto L_0x0016
        L_0x0026:
            monitor-exit(r1)
            return
        L_0x0028:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x002b:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.a(java.util.List, java.lang.String, java.lang.String, int):void");
    }

    private synchronized long a(CampaignEx campaignEx, String str, String str2, int i2) {
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String put : campaignEx.getPv_urls()) {
                    jSONArray.put(put);
                }
                contentValues.put("pv_urls", jSONArray.toString());
            }
            contentValues.put("id", campaignEx.getId());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            contentValues.put(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, str);
            contentValues.put("unitid", str2);
            contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
            contentValues.put(CampaignEx.JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
            contentValues.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
            contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
            contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
            contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
            contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
            contentValues.put("advImp", campaignEx.getAdvImp());
            contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
            contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
            contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
            contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
            contentValues.put(CampaignUnit.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
            contentValues.put(CampaignUnit.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
            contentValues.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, Integer.valueOf(campaignEx.getRewardAmount()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
            contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
            contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
            contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
            contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
            contentValues.put(CampaignEx.ENDCARD_URL, campaignEx.getendcard_url());
            contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
            contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
            contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
            if (campaignEx.getRewardTemplateMode() != null) {
                contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().a());
            }
            contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
            contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
            contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
            contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
            contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
            contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
            contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
            contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
            contentValues.put("ia_url", campaignEx.getKeyIaUrl());
            contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
            contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
            contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
            contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
            contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
            contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
            contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
            contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
            contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
            contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
            CampaignEx.a adchoice = campaignEx.getAdchoice();
            if (adchoice != null) {
                contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.c());
                contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.b()));
                contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.a()));
            }
            contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
            contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
            contentValues.put("ad_zip", campaignEx.getAdZip());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
            contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID, Long.valueOf(campaignEx.getVidCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_CREATIVE_ID, Long.valueOf(campaignEx.getEcCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_TEMP_ID, Long.valueOf(campaignEx.getEcTemplateId()));
            contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
            contentValues.put("bid_token", campaignEx.getBidToken());
            contentValues.put(CampaignEx.JSON_KEY_MRAID, campaignEx.getMraid());
            contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
            contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
            contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
            contentValues.put(CampaignEx.JSON_KEY_EXT_DATA, campaignEx.getExt_data());
            contentValues.put(CampaignUnit.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            contentValues.put(CampaignUnit.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
            contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
            contentValues.put("request_id", campaignEx.getRequestId());
            contentValues.put("n_request_id", campaignEx.getNRid());
            contentValues.put("local_request_id", campaignEx.getLocalRequestId());
            contentValues.put("n_local_request_id", campaignEx.getNLRid());
            contentValues.put("err_type_default_ad", Integer.valueOf(campaignEx.getErrTypeByDefaultAd()));
            contentValues.put("err_reason_default_ad", campaignEx.getErrReasonByDefaultAd());
            contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVE, Integer.valueOf(campaignEx.getMaitve()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
            contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
            contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
            contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
            contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
            contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
            contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
            contentValues.put(CampaignEx.JSON_KEY_TP_OFFER, Integer.valueOf(campaignEx.getTpOffer()));
            contentValues.put(CampaignEx.JSON_KEY_FAC, Integer.valueOf(campaignEx.getFac()));
            if (campaignEx.getAabEntity() != null) {
                contentValues.put(CampaignEx.JSON_KEY_AAB, campaignEx.getAabEntity().toJson().toString());
            }
            contentValues.put(CampaignEx.JSON_KEY_PRIVACY_URL, campaignEx.getPrivacyUrl());
            contentValues.put("privacy_button_video", Integer.valueOf(campaignEx.getPrivacyButtonTemplateVisibility()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_REPORT_TYPE, Integer.valueOf(campaignEx.getImpReportType()));
            return getWritableDatabase().insert(FirebaseAnalytics.Param.CAMPAIGN, (String) null, contentValues);
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
            return -1;
        }
    }

    public final synchronized long a(CampaignEx campaignEx, String str, int i2) {
        String str2;
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", campaignEx.getId());
            if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String put : campaignEx.getPv_urls()) {
                    jSONArray.put(put);
                }
                contentValues.put("pv_urls", jSONArray.toString());
            }
            contentValues.put("unitid", str);
            contentValues.put("request_id", campaignEx.getRequestId());
            contentValues.put("n_request_id", campaignEx.getNRid());
            contentValues.put("local_request_id", campaignEx.getLocalRequestId());
            contentValues.put("n_local_request_id", campaignEx.getNLRid());
            contentValues.put("err_type_default_ad", Integer.valueOf(campaignEx.getErrTypeByDefaultAd()));
            contentValues.put("err_reason_default_ad", campaignEx.getErrReasonByDefaultAd());
            contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
            contentValues.put(CampaignEx.JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
            contentValues.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
            contentValues.put("deeplink_url", campaignEx.getDeepLinkURL());
            contentValues.put(CampaignEx.JSON_KEY_USER_ACTIVATION, Boolean.toString(campaignEx.getUserActivation()));
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put("fc_b", Integer.valueOf(campaignEx.getFcb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
            contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
            contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
            contentValues.put("advImp", campaignEx.getAdvImp());
            contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
            contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
            contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
            contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
            contentValues.put(CampaignUnit.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
            contentValues.put(CampaignUnit.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
            contentValues.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, Integer.valueOf(campaignEx.getRewardAmount()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
            contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
            contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
            contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
            contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
            contentValues.put(CampaignEx.ENDCARD_URL, campaignEx.getendcard_url());
            contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
            contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
            contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
            contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
            if (campaignEx.getRewardTemplateMode() != null) {
                contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().a());
            }
            contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
            contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
            contentValues.put(CampaignEx.JSON_KEY_JM_PD, Integer.valueOf(campaignEx.getJmPd()));
            contentValues.put("is_deleted", Integer.valueOf(campaignEx.getIsDeleted()));
            contentValues.put("is_click", Integer.valueOf(campaignEx.getIsClick()));
            contentValues.put("is_add_sucesful", Integer.valueOf(campaignEx.getIsAddSuccesful()));
            contentValues.put("short_ctime", String.valueOf(System.currentTimeMillis()));
            contentValues.put("ia_icon", campaignEx.getKeyIaIcon());
            contentValues.put("ia_url", campaignEx.getKeyIaUrl());
            contentValues.put("ia_rst", Integer.valueOf(campaignEx.getKeyIaRst()));
            contentValues.put("ia_ori", Integer.valueOf(campaignEx.getKeyIaOri()));
            contentValues.put("ad_type", Integer.valueOf(campaignEx.getAdType()));
            contentValues.put(CampaignEx.KEY_IA_EXT1, campaignEx.getIa_ext1());
            contentValues.put(CampaignEx.KEY_IA_EXT2, campaignEx.getIa_ext2());
            contentValues.put(CampaignEx.KEY_IS_DOWNLOAD, Integer.valueOf(campaignEx.getIsDownLoadZip()));
            contentValues.put(CampaignEx.KEY_IA_CACHE, campaignEx.getInteractiveCache());
            contentValues.put(CampaignEx.KEY_OC_TIME, Integer.valueOf(campaignEx.getOc_time()));
            contentValues.put(CampaignEx.KEY_OC_TYPE, Integer.valueOf(campaignEx.getOc_type()));
            contentValues.put(CampaignEx.KEY_T_LIST, campaignEx.getT_list());
            CampaignEx.a adchoice = campaignEx.getAdchoice();
            if (adchoice != null) {
                contentValues.put(CampaignEx.KEY_ADCHOICE, adchoice.c());
                contentValues.put("adchoice_size_height", Integer.valueOf(adchoice.b()));
                contentValues.put("adchoice_size_width", Integer.valueOf(adchoice.a()));
            }
            contentValues.put(CampaignEx.JSON_KEY_PLCT, Long.valueOf(campaignEx.getPlct()));
            contentValues.put(CampaignEx.JSON_KEY_PLCTB, Long.valueOf(campaignEx.getPlctb()));
            contentValues.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getAdHtml());
            contentValues.put("ad_zip", campaignEx.getAdZip());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_URL, campaignEx.getBannerUrl());
            contentValues.put(CampaignEx.JSON_KEY_BANNER_HTML, campaignEx.getBannerHtml());
            contentValues.put(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(campaignEx.getCreativeId()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID, Long.valueOf(campaignEx.getVidCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_CREATIVE_ID, Long.valueOf(campaignEx.getEcCrtvId()));
            contentValues.put(CampaignEx.JSON_KEY_EC_TEMP_ID, Long.valueOf(campaignEx.getEcTemplateId()));
            contentValues.put("is_bid_campaign", Boolean.valueOf(campaignEx.isBidCampaign()));
            contentValues.put("bid_token", campaignEx.getBidToken());
            contentValues.put(CampaignEx.JSON_KEY_MRAID, campaignEx.getMraid());
            contentValues.put("is_mraid_campaign", Boolean.valueOf(campaignEx.isMraid()));
            contentValues.put(CampaignEx.KEY_OMID, campaignEx.getOmid());
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TPLID, Integer.valueOf(campaignEx.getMof_tplid()));
            contentValues.put(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(campaignEx.getReady_rate()));
            contentValues.put(CampaignEx.JSON_KEY_EXT_DATA, campaignEx.getExt_data());
            contentValues.put(CampaignUnit.JSON_KEY_NSCPT, Integer.valueOf(campaignEx.getNscpt()));
            contentValues.put(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            contentValues.put(CampaignUnit.JSON_KEY_REQ_EXT_DATA, campaignEx.getReq_ext_data());
            contentValues.put("readyState", Integer.valueOf(campaignEx.getReadyState()));
            contentValues.put("load_timeout", Integer.valueOf(campaignEx.getLoadTimeoutState()));
            contentValues.put(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, campaignEx.getPlacementId());
            contentValues.put(CampaignEx.JSON_KEY_MAITVE, Integer.valueOf(campaignEx.getMaitve()));
            contentValues.put(CampaignEx.JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
            contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
            contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
            contentValues.put("vcn", Integer.valueOf(campaignEx.getVcn()));
            contentValues.put("token_r", Integer.valueOf(campaignEx.getTokenRule()));
            contentValues.put("encrypt_p", campaignEx.getEncryptPrice());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE, Integer.valueOf(campaignEx.getVideoCheckType()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE, Integer.valueOf(campaignEx.getVideoCtnType()));
            contentValues.put(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRuleString());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
            contentValues.put(CampaignEx.JSON_KEY_TP_OFFER, Integer.valueOf(campaignEx.getTpOffer()));
            contentValues.put(CampaignEx.JSON_KEY_FAC, Integer.valueOf(campaignEx.getFac()));
            contentValues.put(CampaignEx.JSON_KEY_PRIVACY_URL, campaignEx.getPrivacyUrl());
            contentValues.put("privacy_button_video", Integer.valueOf(campaignEx.getPrivacyButtonTemplateVisibility()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_REPORT_TYPE, Integer.valueOf(campaignEx.getImpReportType()));
            if (campaignEx.getAabEntity() != null) {
                contentValues.put(CampaignEx.JSON_KEY_AAB, campaignEx.getAabEntity().toJson().toString());
            }
            if (a(campaignEx.getId(), campaignEx.getTab(), str, i2, campaignEx.getType(), campaignEx.isBidCampaign())) {
                if (campaignEx.isBidCampaign()) {
                    str2 = "unitid = " + str + " AND " + "is_bid_campaign" + " = 1";
                } else {
                    str2 = "id = " + campaignEx.getId() + " AND " + "unitid" + " = " + str + " AND " + "is_bid_campaign" + " = 0";
                }
                return (long) getWritableDatabase().update(FirebaseAnalytics.Param.CAMPAIGN, contentValues, str2, (String[]) null);
            }
            return getWritableDatabase().insert(FirebaseAnalytics.Param.CAMPAIGN, (String) null, contentValues);
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(final java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r3, final java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x001c
            int r0 = r3.size()     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x000a
            goto L_0x001c
        L_0x000a:
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ all -> 0x0019 }
            com.mbridge.msdk.foundation.db.f$1 r1 = new com.mbridge.msdk.foundation.db.f$1     // Catch:{ all -> 0x0019 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0019 }
            r0.<init>(r1)     // Catch:{ all -> 0x0019 }
            r0.start()     // Catch:{ all -> 0x0019 }
            monitor-exit(r2)
            return
        L_0x0019:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x001c:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.b(java.util.List, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
        return 0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int a(java.lang.String r10, long r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            com.mbridge.msdk.c.f r1 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            com.mbridge.msdk.c.e r1 = r1.b(r2)     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            if (r1 != 0) goto L_0x001c
            com.mbridge.msdk.c.f r1 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            com.mbridge.msdk.c.e r1 = r1.b()     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
        L_0x001c:
            long r1 = r1.Q()     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            r9.a((long) r1, (java.lang.String) r10)     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            r5 = 0
            r6 = 0
            r7 = 1
            r8 = 0
            r3 = r9
            r4 = r10
            java.util.List r10 = r3.a((java.lang.String) r4, (int) r5, (int) r6, (int) r7, (boolean) r8)     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            if (r10 == 0) goto L_0x0055
            boolean r3 = r10.isEmpty()     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            if (r3 == 0) goto L_0x003a
            goto L_0x0055
        L_0x003a:
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
        L_0x003e:
            boolean r3 = r10.hasNext()     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            if (r3 == 0) goto L_0x0052
            java.lang.Object r3 = r10.next()     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            boolean r3 = r3.isSpareOffer(r11, r1)     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            if (r3 != 0) goto L_0x003e
            monitor-exit(r9)
            return r0
        L_0x0052:
            monitor-exit(r9)
            r10 = 1
            return r10
        L_0x0055:
            monitor-exit(r9)
            r10 = -1
            return r10
        L_0x0058:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        L_0x005b:
            monitor-exit(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.a(java.lang.String, long):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(java.lang.String r9, int r10, java.lang.String r11, int r12, int r13, boolean r14) {
        /*
            r8 = this;
            java.lang.String r0 = " AND is_bid_campaign = 0"
            java.lang.String r1 = " AND adSource = "
            java.lang.String r2 = "' AND level = "
            java.lang.String r3 = " AND unitid = '"
            java.lang.String r4 = " AND is_bid_campaign = 1"
            java.lang.String r5 = "' AND tab="
            java.lang.String r6 = "SELECT id FROM campaign WHERE unitid = "
            java.lang.String r7 = "SELECT id FROM campaign WHERE id='"
            monitor-enter(r8)
            if (r14 == 0) goto L_0x0023
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r9.<init>(r6)     // Catch:{ all -> 0x0069 }
            r9.append(r11)     // Catch:{ all -> 0x0069 }
            r9.append(r4)     // Catch:{ all -> 0x0069 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0069 }
            goto L_0x004a
        L_0x0023:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r14.<init>(r7)     // Catch:{ all -> 0x0069 }
            r14.append(r9)     // Catch:{ all -> 0x0069 }
            r14.append(r5)     // Catch:{ all -> 0x0069 }
            r14.append(r10)     // Catch:{ all -> 0x0069 }
            r14.append(r3)     // Catch:{ all -> 0x0069 }
            r14.append(r11)     // Catch:{ all -> 0x0069 }
            r14.append(r2)     // Catch:{ all -> 0x0069 }
            r14.append(r12)     // Catch:{ all -> 0x0069 }
            r14.append(r1)     // Catch:{ all -> 0x0069 }
            r14.append(r13)     // Catch:{ all -> 0x0069 }
            r14.append(r0)     // Catch:{ all -> 0x0069 }
            java.lang.String r9 = r14.toString()     // Catch:{ all -> 0x0069 }
        L_0x004a:
            android.database.sqlite.SQLiteDatabase r10 = r8.getReadableDatabase()     // Catch:{ all -> 0x0069 }
            r11 = 0
            android.database.Cursor r9 = r10.rawQuery(r9, r11)     // Catch:{ all -> 0x0069 }
            if (r9 == 0) goto L_0x0061
            int r10 = r9.getCount()     // Catch:{ all -> 0x0069 }
            if (r10 <= 0) goto L_0x0061
            r9.close()     // Catch:{ all -> 0x0069 }
            monitor-exit(r8)
            r9 = 1
            return r9
        L_0x0061:
            if (r9 == 0) goto L_0x0066
            r9.close()     // Catch:{ all -> 0x0069 }
        L_0x0066:
            monitor-exit(r8)
            r9 = 0
            return r9
        L_0x0069:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.a(java.lang.String, int, java.lang.String, int, int, boolean):boolean");
    }

    public final List<CampaignEx> a(String str, int i2, int i3, int i4) {
        String str2;
        String str3 = " WHERE unitid = '" + str + "' AND level = " + i3 + " AND adSource = " + i4;
        if (i2 > 0) {
            str2 = " LIMIT " + i2;
        } else {
            str2 = "";
        }
        return g("SELECT * FROM campaign" + str3 + str2);
    }

    public final synchronized List<CampaignEx> a(String str, int i2, int i3, int i4, boolean z) {
        String str2;
        String str3;
        String str4 = " WHERE unitid = '" + str + "' AND level = " + i3 + " AND adSource = " + i4;
        if (z) {
            str2 = str4 + " AND is_bid_campaign = 1";
        } else {
            str2 = str4 + " AND is_bid_campaign = 0";
        }
        str3 = "";
        if (i2 > 0) {
            str3 = " LIMIT " + i2;
        }
        return g("SELECT * FROM campaign" + str2 + str3);
    }

    public final synchronized List<CampaignEx> a(String str, int i2, int i3, int i4, String str2) {
        String str3;
        String str4;
        str3 = ((" WHERE unitid = '" + str + "' AND level = " + i3 + " AND adSource = " + i4) + " AND is_bid_campaign = 1") + " AND readyState = '0'";
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + " AND request_id = '" + str2 + "'";
        }
        str4 = "";
        if (i2 > 0) {
            str4 = " LIMIT " + i2;
        }
        return g("SELECT * FROM campaign" + (str3 + " order by ts ASC") + str4);
    }

    public final synchronized List<CampaignEx> b(String str, int i2, int i3, int i4) {
        String str2;
        String str3;
        str2 = " WHERE unitid = '" + str + "' AND level = " + i3 + " AND adSource = " + i4;
        str3 = "";
        if (i2 > 0) {
            str3 = " LIMIT " + i2;
        }
        return g("SELECT * FROM campaign" + str2 + str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x06a1, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x06a4, code lost:
        if (r10 != null) goto L_0x06a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x06ba, code lost:
        if (r10 != null) goto L_0x06a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x06be, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x06c2 A[SYNTHETIC, Splitter:B:50:0x06c2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> g(java.lang.String r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.getReadableDatabase()     // Catch:{ Exception -> 0x06af, all -> 0x06aa }
            android.database.Cursor r10 = r1.rawQuery(r10, r0)     // Catch:{ Exception -> 0x06af, all -> 0x06aa }
            if (r10 == 0) goto L_0x06a4
            int r1 = r10.getCount()     // Catch:{ Exception -> 0x06a2 }
            if (r1 <= 0) goto L_0x06a4
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x06a2 }
            r1.<init>()     // Catch:{ Exception -> 0x06a2 }
        L_0x0017:
            boolean r2 = r10.moveToNext()     // Catch:{ Exception -> 0x06a2 }
            if (r2 == 0) goto L_0x069b
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = new com.mbridge.msdk.foundation.entity.CampaignEx     // Catch:{ Exception -> 0x06a2 }
            r2.<init>()     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "pv_urls"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x06a2 }
            r5 = 0
            if (r4 != 0) goto L_0x0051
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x06a2 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x06a2 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x06a2 }
            r3.<init>()     // Catch:{ Exception -> 0x06a2 }
            r6 = 0
        L_0x003e:
            int r7 = r4.length()     // Catch:{ Exception -> 0x06a2 }
            if (r6 >= r7) goto L_0x004e
            java.lang.String r7 = r4.getString(r6)     // Catch:{ Exception -> 0x06a2 }
            r3.add(r7)     // Catch:{ Exception -> 0x06a2 }
            int r6 = r6 + 1
            goto L_0x003e
        L_0x004e:
            r2.setPv_urls(r3)     // Catch:{ Exception -> 0x06a2 }
        L_0x0051:
            java.lang.String r3 = "id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setId(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "tab"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setTab(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "package_name"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setPackageName(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "app_name"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setAppName(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "app_desc"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setAppDesc(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "app_size"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setSize(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "image_size"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setImageSize(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "icon_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setIconUrl(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "image_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setImageUrl(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "impression_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setImpressionURL(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "notice_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setNoticeUrl(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "download_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setClickURL(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "wtick"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setWtick(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "deeplink_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setDeepLinkUrl(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "user_activation"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setUserActivation(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "only_impression"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setOnlyImpressionURL(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "template"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setTemplate(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "landing_type"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setLandingType(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "link_type"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setLinkType(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "click_mode"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setClick_mode(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "star"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            double r3 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setRating(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "number_rating"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setNumberRating(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "cti"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setClickInterval(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "ts"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            long r3 = r10.getLong(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setTimestamp(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "level"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setCacheLevel(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "adSource"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setType(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "ad_call"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setAdCall(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "fc_a"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setFca(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "fc_b"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setFcb(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "ad_url_list"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setAd_url_list(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "video_length"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setVideoLength(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "video_size"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setVideoSize(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "video_resolution"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setVideoResolution(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "endcard_click_result"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setEndcard_click_result(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "video_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setVideoUrlEncode(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "watch_mile"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setWatchMile(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "t_imp"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setTImp(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "bty"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setBty(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "advImp"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setAdvImp(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "local_request_id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setLocalRequestId(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "n_request_id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setNRid(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "n_local_request_id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setNLRid(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "err_type_default_ad"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setErrTypeByDefaultAd(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "err_reason_default_ad"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setErrReasonByDefaultAd(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "offer_type"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setOfferType(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "guidelines"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setGuidelines(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "html_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setHtmlUrl(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "end_screen_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setEndScreenUrl(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "reward_name"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setRewardName(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "reward_amount"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setRewardAmount(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "reward_play_status"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setRewardPlayStatus(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "retarget"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setRetarget_offer(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "unitid"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setCampaignUnitId(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "native_ad_tracking"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            com.mbridge.msdk.foundation.entity.j r3 = com.mbridge.msdk.foundation.entity.CampaignEx.TrackingStr2Object(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setNativeVideoTracking(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "native_ad_tracking"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setNativeVideoTrackingString(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "video_end_type"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setVideo_end_type(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "endcard_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setendcard_url(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "playable_ads_without_video"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setPlayable_ads_without_video(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "mof_template_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setMof_template_url(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "mof_tplid"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setMof_tplid(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "reward_teamplate"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r3 = com.mbridge.msdk.foundation.entity.CampaignEx.c.a((java.lang.String) r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setRewardTemplateMode(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "md5_file"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setVideoMD5Value(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "gif_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setGifUrl(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "nv_t2"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setNvT2(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "c_coi"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setClickTimeOutInterval(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "c_ua"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setcUA(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "imp_ua"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setImpUA(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "oc_time"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setOc_time(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "oc_type"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setOc_type(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "t_list"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setT_list(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "gh_id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setGhId(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "gh_path"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setGhPath(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "bind_id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setBindId(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "adchoice"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x06a2 }
            if (r4 != 0) goto L_0x043c
            com.mbridge.msdk.foundation.entity.CampaignEx$a r3 = com.mbridge.msdk.foundation.entity.CampaignEx.a.b(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setAdchoice(r3)     // Catch:{ Exception -> 0x06a2 }
        L_0x043c:
            java.lang.String r3 = "adchoice_size_height"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setAdchoiceSizeHeight(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "adchoice_size_width"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setAdchoiceSizeWidth(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "plct"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            long r3 = r10.getLong(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setPlct(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "plctb"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            long r3 = r10.getLong(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setPlctb(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "ad_zip"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setAdZip(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "ad_html"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setAdHtml(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "banner_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setBannerUrl(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "banner_html"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setBannerHtml(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "creative_id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            long r3 = r10.getLong(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setCreativeId(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "vid_crtv_id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            long r3 = r10.getLong(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setVidCrtvId(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "ec_crtv_id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            long r3 = r10.getLong(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setEcCrtvId(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "ec_temp_id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            long r3 = r10.getLong(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setEcTemplateId(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "is_bid_campaign"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r4 = 1
            if (r3 != r4) goto L_0x04e8
            r3 = 1
            goto L_0x04e9
        L_0x04e8:
            r3 = 0
        L_0x04e9:
            r2.setIsBidCampaign(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "bid_token"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setBidToken(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "ad_type"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setAdType(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "fac"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setFac(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "tp_offer"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setTpOffer(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "mraid"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setMraid(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "is_mraid_campaign"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            if (r3 != r4) goto L_0x053b
            r5 = 1
        L_0x053b:
            r2.setIsMraid(r5)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "omid"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setOmid(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "ready_rate"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setReady_rate(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "ext_data"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setExt_data(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "nscpt"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setNscpt(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "req_ext_data"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setReq_ext_data(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "readyState"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setReadyState(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "load_timeout"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setLoadTimeoutState(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "placement_id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setPlacementId(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "maitve"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setMaitve(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "maitve_src"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setMaitve_src(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "flb"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setFlb(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "flb_skiptime"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setFlbSkipTime(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "cbd"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setCbd(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "vst"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setVst(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "adspace_t"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setAdSpaceT(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "vcn"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setVcn(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "token_r"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setTokenRule(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "encrypt_p"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setEncryptPrice(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "vck_t"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setVideoCheckType(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "vctn_t"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setVideoCtnType(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "rs_ignc_r"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setRsIgnoreCheckRuleByString(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "view_com_time"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setVideoCompleteTime(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "aab"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            com.mbridge.msdk.foundation.entity.AabEntity r3 = com.mbridge.msdk.foundation.entity.AabEntity.parser(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setAabEntity(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "privacy_url"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setPrivacyUrl(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "privacy_button_video"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            int r3 = r10.getInt(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setPrivacyButtonTemplateVisibility(r3)     // Catch:{ Exception -> 0x06a2 }
            java.lang.String r3 = "imp_report_type"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x06a2 }
            r2.setImpReportType(r3)     // Catch:{ Exception -> 0x06a2 }
            r1.add(r2)     // Catch:{ Exception -> 0x06a2 }
            goto L_0x0017
        L_0x069b:
            if (r10 == 0) goto L_0x06a0
            r10.close()     // Catch:{ all -> 0x06c6 }
        L_0x06a0:
            monitor-exit(r9)
            return r1
        L_0x06a2:
            r1 = move-exception
            goto L_0x06b1
        L_0x06a4:
            if (r10 == 0) goto L_0x06bd
        L_0x06a6:
            r10.close()     // Catch:{ all -> 0x06c6 }
            goto L_0x06bd
        L_0x06aa:
            r10 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
            goto L_0x06c0
        L_0x06af:
            r1 = move-exception
            r10 = r0
        L_0x06b1:
            java.lang.String r2 = "CampaignDao"
            java.lang.String r1 = r1.getLocalizedMessage()     // Catch:{ all -> 0x06bf }
            com.mbridge.msdk.foundation.tools.aa.d(r2, r1)     // Catch:{ all -> 0x06bf }
            if (r10 == 0) goto L_0x06bd
            goto L_0x06a6
        L_0x06bd:
            monitor-exit(r9)
            return r0
        L_0x06bf:
            r0 = move-exception
        L_0x06c0:
            if (r10 == 0) goto L_0x06c5
            r10.close()     // Catch:{ all -> 0x06c6 }
        L_0x06c5:
            throw r0     // Catch:{ all -> 0x06c6 }
        L_0x06c6:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x06ca
        L_0x06c9:
            throw r10
        L_0x06ca:
            goto L_0x06c9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.g(java.lang.String):java.util.List");
    }

    /* JADX WARNING: type inference failed for: r1v7, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r1v8, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v9, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v10, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0103, code lost:
        if (r1 != 0) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x011a, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.foundation.entity.b> d(java.lang.String r11) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r11)
            if (r1 == 0) goto L_0x000c
            return r0
        L_0x000c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = " WHERE unitid = '"
            r1.<init>(r2)
            r1.append(r11)
            java.lang.String r11 = "' AND level = 0 AND adSource = 1"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r11)
            java.lang.String r11 = " AND is_bid_campaign = 1"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r11)
            java.lang.String r11 = " AND readyState = '0'"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r11)
            java.lang.String r11 = " group by request_id"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r11)
            java.lang.String r11 = " order by ts ASC"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "SELECT request_id as rid ,count(*) as ridCount ,vcn,token_r,bid_token,local_request_id,ts as timestamp FROM campaign"
            r1.<init>(r2)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r1 = 0
            java.lang.Object r2 = new java.lang.Object     // Catch:{ Exception -> 0x010b }
            r2.<init>()     // Catch:{ Exception -> 0x010b }
            monitor-enter(r2)     // Catch:{ Exception -> 0x010b }
            android.database.sqlite.SQLiteDatabase r3 = r10.getReadableDatabase()     // Catch:{ all -> 0x0106 }
            android.database.Cursor r1 = r3.rawQuery(r11, r1)     // Catch:{ all -> 0x0106 }
            monitor-exit(r2)     // Catch:{ all -> 0x0106 }
            if (r1 == 0) goto L_0x0103
            int r11 = r1.getCount()     // Catch:{ Exception -> 0x010b }
            if (r11 <= 0) goto L_0x0103
        L_0x0089:
            boolean r11 = r1.moveToNext()     // Catch:{ Exception -> 0x010b }
            if (r11 == 0) goto L_0x0103
            com.mbridge.msdk.foundation.entity.b r11 = new com.mbridge.msdk.foundation.entity.b     // Catch:{ Exception -> 0x010b }
            r11.<init>()     // Catch:{ Exception -> 0x010b }
            java.lang.String r2 = "rid"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x010b }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x010b }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x010b }
            if (r3 == 0) goto L_0x00a5
            goto L_0x0089
        L_0x00a5:
            java.lang.String r3 = "local_request_id"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x010b }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x010b }
            java.lang.String r4 = "bid_token"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ Exception -> 0x010b }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ Exception -> 0x010b }
            java.lang.String r5 = "ridCount"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x010b }
            int r5 = r1.getInt(r5)     // Catch:{ Exception -> 0x010b }
            java.lang.String r6 = "token_r"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ Exception -> 0x010b }
            int r6 = r1.getInt(r6)     // Catch:{ Exception -> 0x010b }
            java.lang.String r7 = "timestamp"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x010b }
            long r7 = r1.getLong(r7)     // Catch:{ Exception -> 0x010b }
            java.lang.String r9 = "vcn"
            int r9 = r1.getColumnIndex(r9)     // Catch:{ Exception -> 0x010b }
            int r9 = r1.getInt(r9)     // Catch:{ Exception -> 0x010b }
            r11.b((java.lang.String) r2)     // Catch:{ Exception -> 0x010b }
            r11.c((int) r5)     // Catch:{ Exception -> 0x010b }
            r11.c((long) r7)     // Catch:{ Exception -> 0x010b }
            r11.a((int) r6)     // Catch:{ Exception -> 0x010b }
            r11.b((int) r9)     // Catch:{ Exception -> 0x010b }
            r11.c((java.lang.String) r3)     // Catch:{ Exception -> 0x010b }
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x010b }
            if (r2 != 0) goto L_0x00ff
            r11.a((java.lang.String) r4)     // Catch:{ Exception -> 0x010b }
        L_0x00ff:
            r0.add(r11)     // Catch:{ Exception -> 0x010b }
            goto L_0x0089
        L_0x0103:
            if (r1 == 0) goto L_0x011a
            goto L_0x0117
        L_0x0106:
            r11 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0106 }
            throw r11     // Catch:{ Exception -> 0x010b }
        L_0x0109:
            r11 = move-exception
            goto L_0x011b
        L_0x010b:
            r11 = move-exception
            java.lang.String r2 = "CampaignDao"
            java.lang.String r11 = r11.getLocalizedMessage()     // Catch:{ all -> 0x0109 }
            com.mbridge.msdk.foundation.tools.aa.d(r2, r11)     // Catch:{ all -> 0x0109 }
            if (r1 == 0) goto L_0x011a
        L_0x0117:
            r1.close()
        L_0x011a:
            return r0
        L_0x011b:
            if (r1 == 0) goto L_0x0120
            r1.close()
        L_0x0120:
            goto L_0x0122
        L_0x0121:
            throw r11
        L_0x0122:
            goto L_0x0121
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.d(java.lang.String):java.util.List");
    }

    /* JADX WARNING: type inference failed for: r1v5, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r1v6, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v7, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v8, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0082, code lost:
        if (r1 != 0) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0099, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> e(java.lang.String r5) {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto L_0x000c
            return r0
        L_0x000c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = " WHERE unitid = '"
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r5 = "'"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            java.lang.String r5 = " AND is_bid_campaign = 1"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            java.lang.String r5 = " group by request_id"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "SELECT request_id as rid FROM campaign"
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r1 = 0
            java.lang.Object r2 = new java.lang.Object     // Catch:{ Exception -> 0x008a }
            r2.<init>()     // Catch:{ Exception -> 0x008a }
            monitor-enter(r2)     // Catch:{ Exception -> 0x008a }
            android.database.sqlite.SQLiteDatabase r3 = r4.getReadableDatabase()     // Catch:{ all -> 0x0085 }
            android.database.Cursor r1 = r3.rawQuery(r5, r1)     // Catch:{ all -> 0x0085 }
            monitor-exit(r2)     // Catch:{ all -> 0x0085 }
            if (r1 == 0) goto L_0x0082
            int r5 = r1.getCount()     // Catch:{ Exception -> 0x008a }
            if (r5 <= 0) goto L_0x0082
        L_0x0067:
            boolean r5 = r1.moveToNext()     // Catch:{ Exception -> 0x008a }
            if (r5 == 0) goto L_0x0082
            java.lang.String r5 = "rid"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x008a }
            java.lang.String r5 = r1.getString(r5)     // Catch:{ Exception -> 0x008a }
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x008a }
            if (r2 == 0) goto L_0x007e
            goto L_0x0067
        L_0x007e:
            r0.add(r5)     // Catch:{ Exception -> 0x008a }
            goto L_0x0067
        L_0x0082:
            if (r1 == 0) goto L_0x0099
            goto L_0x0096
        L_0x0085:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0085 }
            throw r5     // Catch:{ Exception -> 0x008a }
        L_0x0088:
            r5 = move-exception
            goto L_0x009a
        L_0x008a:
            r5 = move-exception
            java.lang.String r2 = "CampaignDao"
            java.lang.String r5 = r5.getLocalizedMessage()     // Catch:{ all -> 0x0088 }
            com.mbridge.msdk.foundation.tools.aa.d(r2, r5)     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0099
        L_0x0096:
            r1.close()
        L_0x0099:
            return r0
        L_0x009a:
            if (r1 == 0) goto L_0x009f
            r1.close()
        L_0x009f:
            goto L_0x00a1
        L_0x00a0:
            throw r5
        L_0x00a1:
            goto L_0x00a0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.e(java.lang.String):java.util.List");
    }

    public final int c(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            str3 = "unitid = '" + str2 + "' AND request_id = '" + str + "' AND is_bid_campaign = 1";
        } else {
            str3 = "unitid = '" + str2 + "' AND is_bid_campaign = 1";
        }
        String str4 = str3 + " AND readyState = '0'";
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("readyState", 2);
            return getWritableDatabase().update(FirebaseAnalytics.Param.CAMPAIGN, contentValues, str4, (String[]) null);
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
            return 0;
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00e1, code lost:
        if (r1 != 0) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f8, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.entity.b> f(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = " WHERE unitid = '"
            r0.<init>(r1)
            r0.append(r11)
            java.lang.String r11 = "' AND level = 0 AND adSource = 1"
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = " AND is_bid_campaign = 1"
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = " AND readyState = '0'"
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "SELECT request_id as rid, id as cid, plct as plct, plctb as plctb, ts as timestamp FROM campaign"
            r0.<init>(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1 = 0
            java.lang.Object r2 = new java.lang.Object     // Catch:{ Exception -> 0x00e9 }
            r2.<init>()     // Catch:{ Exception -> 0x00e9 }
            monitor-enter(r2)     // Catch:{ Exception -> 0x00e9 }
            android.database.sqlite.SQLiteDatabase r3 = r10.getReadableDatabase()     // Catch:{ all -> 0x00e4 }
            android.database.Cursor r1 = r3.rawQuery(r11, r1)     // Catch:{ all -> 0x00e4 }
            monitor-exit(r2)     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x00e1
            int r11 = r1.getCount()     // Catch:{ Exception -> 0x00e9 }
            if (r11 <= 0) goto L_0x00e1
        L_0x0060:
            boolean r11 = r1.moveToNext()     // Catch:{ Exception -> 0x00e9 }
            if (r11 == 0) goto L_0x00e1
            java.lang.String r11 = "rid"
            int r11 = r1.getColumnIndex(r11)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r11 = r1.getString(r11)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r2 = "cid"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r3 = "plct"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x00e9 }
            long r3 = r1.getLong(r3)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r5 = "plctb"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x00e9 }
            long r5 = r1.getLong(r5)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r7 = "timestamp"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x00e9 }
            long r7 = r1.getLong(r7)     // Catch:{ Exception -> 0x00e9 }
            boolean r9 = r0.containsKey(r11)     // Catch:{ Exception -> 0x00e9 }
            if (r9 == 0) goto L_0x00c1
            java.lang.Object r9 = r0.get(r11)     // Catch:{ Exception -> 0x00e9 }
            com.mbridge.msdk.foundation.entity.b r9 = (com.mbridge.msdk.foundation.entity.b) r9     // Catch:{ Exception -> 0x00e9 }
            if (r9 == 0) goto L_0x0060
            r9.b((java.lang.String) r11)     // Catch:{ Exception -> 0x00e9 }
            r9.a((long) r3)     // Catch:{ Exception -> 0x00e9 }
            r9.b((long) r5)     // Catch:{ Exception -> 0x00e9 }
            r9.c((long) r7)     // Catch:{ Exception -> 0x00e9 }
            java.util.List r11 = r9.c()     // Catch:{ Exception -> 0x00e9 }
            if (r11 == 0) goto L_0x0060
            java.util.List r11 = r9.c()     // Catch:{ Exception -> 0x00e9 }
            r11.add(r2)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x0060
        L_0x00c1:
            com.mbridge.msdk.foundation.entity.b r9 = new com.mbridge.msdk.foundation.entity.b     // Catch:{ Exception -> 0x00e9 }
            r9.<init>()     // Catch:{ Exception -> 0x00e9 }
            r9.b((java.lang.String) r11)     // Catch:{ Exception -> 0x00e9 }
            r9.a((long) r3)     // Catch:{ Exception -> 0x00e9 }
            r9.b((long) r5)     // Catch:{ Exception -> 0x00e9 }
            r9.c((long) r7)     // Catch:{ Exception -> 0x00e9 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x00e9 }
            r3.<init>()     // Catch:{ Exception -> 0x00e9 }
            r3.add(r2)     // Catch:{ Exception -> 0x00e9 }
            r9.a((java.util.List<java.lang.String>) r3)     // Catch:{ Exception -> 0x00e9 }
            r0.put(r11, r9)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x0060
        L_0x00e1:
            if (r1 == 0) goto L_0x00f8
            goto L_0x00f5
        L_0x00e4:
            r11 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00e4 }
            throw r11     // Catch:{ Exception -> 0x00e9 }
        L_0x00e7:
            r11 = move-exception
            goto L_0x00f9
        L_0x00e9:
            r11 = move-exception
            java.lang.String r2 = "CampaignDao"
            java.lang.String r11 = r11.getLocalizedMessage()     // Catch:{ all -> 0x00e7 }
            com.mbridge.msdk.foundation.tools.aa.d(r2, r11)     // Catch:{ all -> 0x00e7 }
            if (r1 == 0) goto L_0x00f8
        L_0x00f5:
            r1.close()
        L_0x00f8:
            return r0
        L_0x00f9:
            if (r1 == 0) goto L_0x00fe
            r1.close()
        L_0x00fe:
            goto L_0x0100
        L_0x00ff:
            throw r11
        L_0x0100:
            goto L_0x00ff
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.f(java.lang.String):java.util.concurrent.ConcurrentHashMap");
    }

    private CampaignEx a(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        CampaignEx campaignEx = new CampaignEx();
        boolean z = false;
        try {
            String string = cursor.getString(cursor.getColumnIndex("pv_urls"));
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(jSONArray.getString(i2));
                }
                campaignEx.setPv_urls(arrayList);
            }
        } catch (JSONException unused) {
        }
        campaignEx.setId(cursor.getString(cursor.getColumnIndex("id")));
        campaignEx.setTab(cursor.getInt(cursor.getColumnIndex("tab")));
        campaignEx.setPackageName(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_PACKAGE_NAME)));
        campaignEx.setAppName(cursor.getString(cursor.getColumnIndex(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING)));
        campaignEx.setAppDesc(cursor.getString(cursor.getColumnIndex("app_desc")));
        campaignEx.setSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_APP_SIZE)));
        campaignEx.setImageSize(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_SIZE)));
        campaignEx.setIconUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_ICON_URL)));
        campaignEx.setImageUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_URL)));
        campaignEx.setImpressionURL(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMPRESSION_URL)));
        campaignEx.setNoticeUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_NOTICE_URL)));
        campaignEx.setClickURL(cursor.getString(cursor.getColumnIndex(DownloadModel.DOWNLOAD_URL)));
        campaignEx.setWtick(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK)));
        campaignEx.setDeepLinkUrl(cursor.getString(cursor.getColumnIndex("deeplink_url")));
        campaignEx.setUserActivation(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_USER_ACTIVATION))));
        campaignEx.setOnlyImpressionURL(cursor.getString(cursor.getColumnIndex("only_impression")));
        campaignEx.setTemplate(cursor.getInt(cursor.getColumnIndex("template")));
        campaignEx.setLandingType(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_LANDING_TYPE)));
        campaignEx.setLinkType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_LINK_TYPE)));
        campaignEx.setClick_mode(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_CLICK_MODE)));
        campaignEx.setRating(Double.parseDouble(cursor.getString(cursor.getColumnIndex("star"))));
        campaignEx.setNumberRating(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NUMBER_RATING)));
        campaignEx.setClickInterval(cursor.getInt(cursor.getColumnIndex("cti")));
        campaignEx.setTimestamp(cursor.getLong(cursor.getColumnIndex("ts")));
        campaignEx.setCacheLevel(cursor.getInt(cursor.getColumnIndex("level")));
        campaignEx.setAdCall(cursor.getString(cursor.getColumnIndex("ad_call")));
        campaignEx.setFcb(cursor.getInt(cursor.getColumnIndex("fc_b")));
        campaignEx.setAd_url_list(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_URL_LIST)));
        campaignEx.setVideoLength(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_LENGTHL)));
        campaignEx.setVideoSize(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_SIZE)));
        campaignEx.setVideoResolution(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_RESOLUTION)));
        campaignEx.setEndcard_click_result(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_ENDCARD_CLICK)));
        campaignEx.setVideoUrlEncode(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_URL)));
        campaignEx.setWatchMile(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_WATCH_MILE)));
        campaignEx.setTImp(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_T_IMP)));
        campaignEx.setBty(cursor.getInt(cursor.getColumnIndex("bty")));
        campaignEx.setAdvImp(cursor.getString(cursor.getColumnIndex("advImp")));
        campaignEx.setLocalRequestId(cursor.getString(cursor.getColumnIndex("local_request_id")));
        campaignEx.setNRid(cursor.getString(cursor.getColumnIndex("n_request_id")));
        campaignEx.setNLRid(cursor.getString(cursor.getColumnIndex("n_local_request_id")));
        campaignEx.setErrTypeByDefaultAd(cursor.getInt(cursor.getColumnIndex("err_type_default_ad")));
        campaignEx.setErrReasonByDefaultAd(cursor.getString(cursor.getColumnIndex("err_reason_default_ad")));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setOfferType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_OFFER_TYPE)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_HTML_URL)));
        campaignEx.setGuidelines(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
        campaignEx.setHtmlUrl(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_HTML_URL)));
        campaignEx.setEndScreenUrl(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_END_SCREEN_URL)));
        campaignEx.setRewardName(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_NAME)));
        campaignEx.setRewardAmount(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_AMOUNT)));
        campaignEx.setRewardPlayStatus(cursor.getInt(cursor.getColumnIndex("reward_play_status")));
        campaignEx.setRetarget_offer(cursor.getInt(cursor.getColumnIndex("retarget")));
        campaignEx.setCampaignUnitId(cursor.getString(cursor.getColumnIndex("unitid")));
        campaignEx.setNativeVideoTracking(CampaignEx.TrackingStr2Object(cursor.getString(cursor.getColumnIndex("native_ad_tracking"))));
        campaignEx.setNativeVideoTrackingString(cursor.getString(cursor.getColumnIndex("native_ad_tracking")));
        campaignEx.setVideo_end_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.VIDEO_END_TYPE)));
        campaignEx.setendcard_url(cursor.getString(cursor.getColumnIndex(CampaignEx.ENDCARD_URL)));
        campaignEx.setPlayable_ads_without_video(cursor.getInt(cursor.getColumnIndex(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO)));
        campaignEx.setMof_template_url(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL)));
        campaignEx.setMof_tplid(cursor.getInt(cursor.getColumnIndex(CampaignUnit.JSON_KEY_MOF_TPLID)));
        campaignEx.setRewardTemplateMode(CampaignEx.c.a(cursor.getString(cursor.getColumnIndex("reward_teamplate"))));
        campaignEx.setVideoMD5Value(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5)));
        campaignEx.setGifUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_GIF_URL)));
        campaignEx.setNvT2(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NV_T2)));
        campaignEx.setClickTimeOutInterval(cursor.getInt(cursor.getColumnIndex("c_coi")));
        campaignEx.setcUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_C_UA)));
        campaignEx.setImpUA(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_UA)));
        campaignEx.setJmPd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_JM_PD)));
        campaignEx.setIsDeleted(cursor.getInt(cursor.getColumnIndex("is_deleted")));
        campaignEx.setIsClick(cursor.getInt(cursor.getColumnIndex("is_click")));
        campaignEx.setIsAddSuccesful(cursor.getInt(cursor.getColumnIndex("is_add_sucesful")));
        campaignEx.setIsDownLoadZip(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_IS_DOWNLOAD)));
        campaignEx.setInteractiveCache(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_CACHE)));
        campaignEx.setKeyIaOri(cursor.getInt(cursor.getColumnIndex("ia_ori")));
        campaignEx.setAdType(cursor.getInt(cursor.getColumnIndex("ad_type")));
        campaignEx.setFac(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FAC)));
        campaignEx.setTpOffer(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_TP_OFFER)));
        campaignEx.setIa_ext1(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT1)));
        campaignEx.setIa_ext2(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_IA_EXT2)));
        campaignEx.setKeyIaRst(cursor.getInt(cursor.getColumnIndex("ia_rst")));
        campaignEx.setKeyIaUrl(cursor.getString(cursor.getColumnIndex("ia_url")));
        campaignEx.setKeyIaIcon(cursor.getString(cursor.getColumnIndex("ia_icon")));
        campaignEx.setOc_time(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TIME)));
        campaignEx.setOc_type(cursor.getInt(cursor.getColumnIndex(CampaignEx.KEY_OC_TYPE)));
        campaignEx.setT_list(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_T_LIST)));
        campaignEx.setGhId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_ID)));
        campaignEx.setGhPath(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_GH_PATH)));
        campaignEx.setBindId(cursor.getString(cursor.getColumnIndex(DomainCampaignEx.KEY_BIND_ID)));
        String string2 = cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_ADCHOICE));
        if (!TextUtils.isEmpty(string2)) {
            campaignEx.setAdchoice(CampaignEx.a.b(string2));
        }
        campaignEx.setAdchoiceSizeHeight(cursor.getInt(cursor.getColumnIndex("adchoice_size_height")));
        campaignEx.setAdchoiceSizeWidth(cursor.getInt(cursor.getColumnIndex("adchoice_size_width")));
        campaignEx.setPlct(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCT)));
        campaignEx.setPlctb(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_PLCTB)));
        campaignEx.setAdZip(cursor.getString(cursor.getColumnIndex("ad_zip")));
        campaignEx.setAdHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AD_HTML)));
        campaignEx.setBannerUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_URL)));
        campaignEx.setBannerHtml(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_BANNER_HTML)));
        campaignEx.setCreativeId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_CREATIVE_ID)));
        campaignEx.setVidCrtvId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CREATIVE_ID)));
        campaignEx.setEcCrtvId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_EC_CREATIVE_ID)));
        campaignEx.setEcTemplateId(cursor.getLong(cursor.getColumnIndex(CampaignEx.JSON_KEY_EC_TEMP_ID)));
        campaignEx.setIsBidCampaign(cursor.getInt(cursor.getColumnIndex("is_bid_campaign")) == 1);
        campaignEx.setBidToken(cursor.getString(cursor.getColumnIndex("bid_token")));
        campaignEx.setMraid(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_MRAID)));
        if (cursor.getInt(cursor.getColumnIndex("is_mraid_campaign")) == 1) {
            z = true;
        }
        campaignEx.setIsMraid(z);
        campaignEx.setOmid(cursor.getString(cursor.getColumnIndex(CampaignEx.KEY_OMID)));
        campaignEx.setReady_rate(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_READY_RATE)));
        campaignEx.setExt_data(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_EXT_DATA)));
        campaignEx.setNscpt(cursor.getInt(cursor.getColumnIndex(CampaignUnit.JSON_KEY_NSCPT)));
        campaignEx.setReq_ext_data(cursor.getString(cursor.getColumnIndex(CampaignUnit.JSON_KEY_REQ_EXT_DATA)));
        campaignEx.setReadyState(cursor.getInt(cursor.getColumnIndex("readyState")));
        campaignEx.setLoadTimeoutState(cursor.getInt(cursor.getColumnIndex("load_timeout")));
        campaignEx.setPlacementId(cursor.getString(cursor.getColumnIndex(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER)));
        campaignEx.setMaitve(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVE)));
        campaignEx.setMaitve_src(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_MAITVESRC)));
        campaignEx.setFlb(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB)));
        campaignEx.setFlbSkipTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_FLB_SKIP_TIME)));
        campaignEx.setCbd(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD)));
        campaignEx.setVst(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST)));
        campaignEx.setAdSpaceT(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T)));
        campaignEx.setVcn(cursor.getInt(cursor.getColumnIndex("vcn")));
        campaignEx.setTokenRule(cursor.getInt(cursor.getColumnIndex("token_r")));
        campaignEx.setEncryptPrice(cursor.getString(cursor.getColumnIndex("encrypt_p")));
        campaignEx.setVideoCheckType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CHECK_TYPE)));
        campaignEx.setVideoCtnType(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_CTN_TYPE)));
        campaignEx.setRsIgnoreCheckRuleByString(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_RS_IGNORE_CHECK_RULE)));
        campaignEx.setVideoCompleteTime(cursor.getInt(cursor.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME)));
        campaignEx.setAabEntity(AabEntity.parser(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_AAB))));
        campaignEx.setPrivacyUrl(cursor.getString(cursor.getColumnIndex(CampaignEx.JSON_KEY_PRIVACY_URL)));
        campaignEx.setPrivacyButtonTemplateVisibility(cursor.getInt(cursor.getColumnIndex("privacy_button_video")));
        campaignEx.setImpReportType(cursor.getColumnIndex(CampaignEx.JSON_KEY_IMP_REPORT_TYPE));
        return campaignEx;
    }

    public final synchronized void d(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String str3 = "unitid = '" + str + "'";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + " AND bid_token != '" + str2 + "'";
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("readyState", 2);
                getWritableDatabase().update(FirebaseAnalytics.Param.CAMPAIGN, contentValues, (str3 + " AND is_bid_campaign = 1") + " AND bid_token IS NOT NULL", (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    public final synchronized void e(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                String str3 = "";
                if (!TextUtils.isEmpty(str)) {
                    str3 = "unitid = '" + str + "' AND ";
                }
                String str4 = str3 + "n_local_request_id = '" + str2 + "' AND bid_token IS NOT NULL AND n_local_request_id IS NOT NULL";
                ContentValues contentValues = new ContentValues();
                contentValues.put("readyState", 2);
                getWritableDatabase().update(FirebaseAnalytics.Param.CAMPAIGN, contentValues, str4, (String[]) null);
            } else {
                return;
            }
        } catch (Exception e2) {
            aa.d("CampaignDao", e2.getLocalizedMessage());
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void f(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "' AND bid_token IS NOT NULL"
            java.lang.String r1 = "' AND bid_token = '"
            java.lang.String r2 = "unitid = '"
            monitor-enter(r4)
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0048 }
            if (r3 != 0) goto L_0x0044
            boolean r3 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0048 }
            if (r3 == 0) goto L_0x0015
            goto L_0x0044
        L_0x0015:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0048 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0048 }
            r3.append(r5)     // Catch:{ Exception -> 0x0048 }
            r3.append(r1)     // Catch:{ Exception -> 0x0048 }
            r3.append(r6)     // Catch:{ Exception -> 0x0048 }
            r3.append(r0)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r5 = r3.toString()     // Catch:{ Exception -> 0x0048 }
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ Exception -> 0x0048 }
            r6.<init>()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r0 = "readyState"
            r1 = 2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0048 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0048 }
            android.database.sqlite.SQLiteDatabase r0 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r1 = "campaign"
            r2 = 0
            r0.update(r1, r6, r5, r2)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0052
        L_0x0044:
            monitor-exit(r4)
            return
        L_0x0046:
            r5 = move-exception
            goto L_0x0054
        L_0x0048:
            r5 = move-exception
            java.lang.String r6 = "CampaignDao"
            java.lang.String r5 = r5.getLocalizedMessage()     // Catch:{ all -> 0x0046 }
            com.mbridge.msdk.foundation.tools.aa.d(r6, r5)     // Catch:{ all -> 0x0046 }
        L_0x0052:
            monitor-exit(r4)
            return
        L_0x0054:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.f(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005b, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
        r4 = r7;
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        r4 = r7;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007c, code lost:
        r4.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f A[ExcHandler: all (r8v6 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:7:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> b(java.lang.String r7, int r8, boolean r9) {
        /*
            r6 = this;
            java.lang.String r0 = "SELECT * FROM campaign WHERE "
            java.lang.String r1 = " AND ad_type = "
            java.lang.String r2 = "placement_id = "
            java.lang.String r3 = "ad_type = "
            r4 = 0
            if (r9 == 0) goto L_0x001e
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
            r9.<init>(r2)     // Catch:{ Exception -> 0x006f }
            r9.append(r7)     // Catch:{ Exception -> 0x006f }
            r9.append(r1)     // Catch:{ Exception -> 0x006f }
            r9.append(r8)     // Catch:{ Exception -> 0x006f }
            java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x006f }
            goto L_0x002a
        L_0x001e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
            r7.<init>(r3)     // Catch:{ Exception -> 0x006f }
            r7.append(r8)     // Catch:{ Exception -> 0x006f }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x006f }
        L_0x002a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
            r8.<init>(r0)     // Catch:{ Exception -> 0x006f }
            r8.append(r7)     // Catch:{ Exception -> 0x006f }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x006f }
            android.database.sqlite.SQLiteDatabase r8 = r6.getReadableDatabase()     // Catch:{ Exception -> 0x006f }
            android.database.Cursor r7 = r8.rawQuery(r7, r4)     // Catch:{ Exception -> 0x006f }
            if (r7 == 0) goto L_0x0069
            int r8 = r7.getCount()     // Catch:{ Exception -> 0x0063, all -> 0x005f }
            if (r8 <= 0) goto L_0x0069
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x0063, all -> 0x005f }
            r8.<init>()     // Catch:{ Exception -> 0x0063, all -> 0x005f }
        L_0x004b:
            boolean r9 = r7.moveToNext()     // Catch:{ Exception -> 0x005b, all -> 0x005f }
            if (r9 == 0) goto L_0x0059
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r6.a((android.database.Cursor) r7)     // Catch:{ Exception -> 0x005b, all -> 0x005f }
            r8.add(r9)     // Catch:{ Exception -> 0x005b, all -> 0x005f }
            goto L_0x004b
        L_0x0059:
            r4 = r8
            goto L_0x0069
        L_0x005b:
            r9 = move-exception
            r4 = r7
            r7 = r9
            goto L_0x0071
        L_0x005f:
            r8 = move-exception
            r4 = r7
            r7 = r8
            goto L_0x0082
        L_0x0063:
            r8 = move-exception
            r5 = r4
            r4 = r7
            r7 = r8
            r8 = r5
            goto L_0x0071
        L_0x0069:
            if (r7 == 0) goto L_0x0080
            r7.close()
            goto L_0x0080
        L_0x006f:
            r7 = move-exception
            r8 = r4
        L_0x0071:
            java.lang.String r9 = "CampaignDao"
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ all -> 0x0081 }
            com.mbridge.msdk.foundation.tools.aa.d(r9, r7)     // Catch:{ all -> 0x0081 }
            if (r4 == 0) goto L_0x007f
            r4.close()
        L_0x007f:
            r4 = r8
        L_0x0080:
            return r4
        L_0x0081:
            r7 = move-exception
        L_0x0082:
            if (r4 == 0) goto L_0x0087
            r4.close()
        L_0x0087:
            goto L_0x0089
        L_0x0088:
            throw r7
        L_0x0089:
            goto L_0x0088
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.b(java.lang.String, int, boolean):java.util.List");
    }
}
