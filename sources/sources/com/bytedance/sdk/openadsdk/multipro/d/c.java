package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.a;
import java.util.Map;

/* compiled from: SPMultiProviderImpl */
public class c implements a {
    private Context a;

    public String a() {
        return "t_sp";
    }

    public void b() {
    }

    private Context c() {
        Context context = this.a;
        return context == null ? o.a() : context;
    }

    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> c;
        if (!uri.getPath().split("/")[2].equals("get_all") || (c = b.c(c(), uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String next : c.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = next;
            Object obj = c.get(next);
            objArr[2] = obj;
            if (obj instanceof Boolean) {
                objArr[1] = TypedValues.Custom.S_BOOLEAN;
            } else if (obj instanceof String) {
                objArr[1] = TypedValues.Custom.S_STRING;
            } else if (obj instanceof Integer) {
                objArr[1] = "int";
            } else if (obj instanceof Long) {
                objArr[1] = "long";
            } else if (obj instanceof Float) {
                objArr[1] = TypedValues.Custom.S_FLOAT;
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    public String a(Uri uri) {
        String[] split = uri.getPath().split("/");
        String str = split[2];
        String str2 = split[3];
        if (str.equals("contain")) {
            return String.valueOf(b.a(o.a(), uri.getQueryParameter("sp_file_name"), str2));
        }
        return b.a(c(), uri.getQueryParameter("sp_file_name"), str2, str);
    }

    public Uri a(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String[] split = uri.getPath().split("/");
        String str = split[2];
        String str2 = split[3];
        Object obj = contentValues.get("value");
        if (obj != null) {
            b.a(c(), uri.getQueryParameter("sp_file_name"), str2, obj);
        }
        return null;
    }

    public int a(Uri uri, String str, String[] strArr) {
        String[] split = uri.getPath().split("/");
        if (split[2].equals("clean")) {
            b.b(c(), uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = split[3];
        if (b.a(c(), uri.getQueryParameter("sp_file_name"), str2)) {
            b.b(c(), uri.getQueryParameter("sp_file_name"), str2);
        }
        return 0;
    }

    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        a(uri, contentValues);
        return 0;
    }
}
