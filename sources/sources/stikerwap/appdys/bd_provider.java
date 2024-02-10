package stikerwap.appdys;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

public class bd_provider extends ContentProvider {
    private static final String AUTHORITY = "stikerwap.appdys.bd_provider";
    public static final int CATS = 103;
    public static final int CATS_ID = 113;
    public static final String CATS_ITEM_TYPE = "vnd.android.cursor.item/mt-cat";
    public static final String CATS_TYPE = "vnd.android.cursor.dir/mt-cat";
    public static final int FOTOS = 102;
    private static final String FOTOS_BASE_PATH = "fotos";
    public static final int FOTOS_ID = 112;
    public static final String FOTOS_ITEM_TYPE = "vnd.android.cursor.item/mt-foto";
    public static final String FOTOS_TYPE = "vnd.android.cursor.dir/mt-foto";
    public static final Uri FOTOS_URI = Uri.parse("content://stikerwap.appdys.bd_provider/fotos");
    public static final int PRODUCTOS = 101;
    private static final String PRODUCTOS_BASE_PATH = "productos";
    public static final int PRODUCTOS_ID = 111;
    public static final String PRODUCTOS_ITEM_TYPE = "vnd.android.cursor.item/mt-producto";
    public static final String PRODUCTOS_TYPE = "vnd.android.cursor.dir/mt-producto";
    public static final Uri PRODUCTOS_URI = Uri.parse("content://stikerwap.appdys.bd_provider/productos");
    private static final UriMatcher sURIMatcher;
    private bd mDB;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        sURIMatcher = uriMatcher;
        uriMatcher.addURI(AUTHORITY, PRODUCTOS_BASE_PATH, 101);
        uriMatcher.addURI(AUTHORITY, "productos/#", 111);
        uriMatcher.addURI(AUTHORITY, FOTOS_BASE_PATH, 102);
        uriMatcher.addURI(AUTHORITY, "fotos/#", 112);
    }

    public boolean onCreate() {
        this.mDB = new bd(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        int match = sURIMatcher.match(uri);
        sQLiteQueryBuilder.setTables((match == 111 || match == 101) ? PRODUCTOS_BASE_PATH : (match == 112 || match == 102) ? FOTOS_BASE_PATH : (match == 113 || match == 103) ? "cats" : "");
        switch (match) {
            case 101:
            case 102:
            case 103:
                break;
            default:
                switch (match) {
                    case 111:
                    case 112:
                    case 113:
                        sQLiteQueryBuilder.appendWhere("_id=" + uri.getLastPathSegment());
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown URI");
                }
        }
        Cursor query = sQLiteQueryBuilder.query(this.mDB.getReadableDatabase(), strArr, str, strArr2, (String) null, (String) null, str2);
        query.setNotificationUri(getContext().getContentResolver(), uri);
        return query;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int i;
        int match = sURIMatcher.match(uri);
        try {
            SQLiteDatabase writableDatabase = this.mDB.getWritableDatabase();
            switch (match) {
                case 101:
                    i = writableDatabase.delete(PRODUCTOS_BASE_PATH, str, strArr);
                    break;
                case 102:
                    i = writableDatabase.delete(FOTOS_BASE_PATH, str, strArr);
                    break;
                case 103:
                    i = writableDatabase.delete("cats", str, strArr);
                    break;
                default:
                    switch (match) {
                        case 111:
                            String lastPathSegment = uri.getLastPathSegment();
                            if (!TextUtils.isEmpty(str)) {
                                i = writableDatabase.delete(PRODUCTOS_BASE_PATH, str + " and id=" + lastPathSegment, strArr);
                                break;
                            } else {
                                i = writableDatabase.delete(PRODUCTOS_BASE_PATH, "_id=" + lastPathSegment, (String[]) null);
                                break;
                            }
                        case 112:
                            String lastPathSegment2 = uri.getLastPathSegment();
                            if (!TextUtils.isEmpty(str)) {
                                i = writableDatabase.delete(FOTOS_BASE_PATH, str + " and id=" + lastPathSegment2, strArr);
                                break;
                            } else {
                                i = writableDatabase.delete(FOTOS_BASE_PATH, "_id=" + lastPathSegment2, (String[]) null);
                                break;
                            }
                        case 113:
                            String lastPathSegment3 = uri.getLastPathSegment();
                            if (!TextUtils.isEmpty(str)) {
                                i = writableDatabase.delete("cats", str + " and id=" + lastPathSegment3, strArr);
                                break;
                            } else {
                                i = writableDatabase.delete("cats", "_id=" + lastPathSegment3, (String[]) null);
                                break;
                            }
                        default:
                            throw new IllegalArgumentException("Unknown or Invalid URI " + uri);
                    }
            }
            getContext().getContentResolver().notifyChange(uri, (ContentObserver) null);
            return i;
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getType(Uri uri) {
        int match = sURIMatcher.match(uri);
        switch (match) {
            case 101:
                return PRODUCTOS_TYPE;
            case 102:
                return FOTOS_TYPE;
            case 103:
                return CATS_TYPE;
            default:
                switch (match) {
                    case 111:
                        return PRODUCTOS_ITEM_TYPE;
                    case 112:
                        return FOTOS_ITEM_TYPE;
                    case 113:
                        return CATS_ITEM_TYPE;
                    default:
                        return null;
                }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.net.Uri insert(android.net.Uri r8, android.content.ContentValues r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Failed to insert row into "
            android.content.UriMatcher r1 = sURIMatcher
            int r1 = r1.match(r8)
            r2 = 101(0x65, float:1.42E-43)
            if (r1 != r2) goto L_0x000f
            java.lang.String r1 = "productos"
            goto L_0x001c
        L_0x000f:
            r2 = 102(0x66, float:1.43E-43)
            if (r1 != r2) goto L_0x0016
            java.lang.String r1 = "fotos"
            goto L_0x001c
        L_0x0016:
            r2 = 103(0x67, float:1.44E-43)
            if (r1 != r2) goto L_0x0050
            java.lang.String r1 = "cats"
        L_0x001c:
            r2 = 0
            stikerwap.appdys.bd r3 = r7.mDB     // Catch:{ Exception -> 0x004f }
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x004f }
            long r3 = r3.insertOrThrow(r1, r2, r9)     // Catch:{  }
            r5 = 0
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 <= 0) goto L_0x003d
            android.net.Uri r9 = android.content.ContentUris.withAppendedId(r8, r3)     // Catch:{  }
            android.content.Context r0 = r7.getContext()     // Catch:{  }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{  }
            r0.notifyChange(r8, r2)     // Catch:{  }
            return r9
        L_0x003d:
            android.database.SQLException r9 = new android.database.SQLException     // Catch:{  }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{  }
            r1.<init>(r0)     // Catch:{  }
            r1.append(r8)     // Catch:{  }
            java.lang.String r8 = r1.toString()     // Catch:{  }
            r9.<init>(r8)     // Catch:{  }
            throw r9     // Catch:{  }
        L_0x004f:
            return r2
        L_0x0050:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Invalid URI for insert"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.bd_provider.insert(android.net.Uri, android.content.ContentValues):android.net.Uri");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int i;
        int match = sURIMatcher.match(uri);
        try {
            SQLiteDatabase writableDatabase = this.mDB.getWritableDatabase();
            String str2 = (match == 111 || match == 101) ? PRODUCTOS_BASE_PATH : (match == 112 || match == 102) ? FOTOS_BASE_PATH : (match == 113 || match == 103) ? "cats" : "";
            switch (match) {
                case 101:
                case 102:
                case 103:
                    i = writableDatabase.update(str2, contentValues, str, strArr);
                    break;
                default:
                    switch (match) {
                        case 111:
                        case 112:
                        case 113:
                            String lastPathSegment = uri.getLastPathSegment();
                            StringBuilder sb = new StringBuilder("_id=" + lastPathSegment);
                            if (!TextUtils.isEmpty(str)) {
                                sb.append(" AND " + str);
                            }
                            i = writableDatabase.update(str2, contentValues, sb.toString(), (String[]) null);
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown URI");
                    }
            }
            getContext().getContentResolver().notifyChange(uri, (ContentObserver) null);
            return i;
        } catch (Exception unused) {
            return 0;
        }
    }
}
