package com.umlaut.crowd.internal;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import java.util.Date;

public class o0 extends ContentObserver {
    private static final String d = "bookmark";
    private static final Uri e = Uri.parse("content://browser/bookmarks");
    private static final String f = "date";
    private static final String g = "title";
    private static final String h = "url";
    private static final String i = "visits";
    private static final String[] j = {"_id", "url", i, f, d, "title", "favicon", "thumbnail", "touch_icon", "user_entered"};
    private final Context a;
    private final c b;
    private b c;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.umlaut.crowd.internal.o0$c[] r0 = com.umlaut.crowd.internal.o0.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.o0$c r1 = com.umlaut.crowd.internal.o0.c.GoogleChrome     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.o0$c r1 = com.umlaut.crowd.internal.o0.c.AndroidStock     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.o0.a.<clinit>():void");
        }
    }

    public interface b {
        void a(boolean z, Date date, String str, String str2, int i);
    }

    public enum c {
        GoogleChrome,
        AndroidStock
    }

    public o0(Context context, c cVar) {
        super(new Handler());
        this.a = context;
        this.b = cVar;
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public void onChange(boolean z) {
        onChange(z, (Uri) null);
    }

    public Uri a() {
        int i2 = a.a[this.b.ordinal()];
        if (i2 == 1) {
            return Uri.parse("content://com.android.chrome.browser/history");
        }
        if (i2 != 2) {
            return e;
        }
        return Uri.parse("content://com.sec.android.app.sbrowser.browser/history");
    }

    public void onChange(boolean z, Uri uri) {
        try {
            Cursor query = this.a.getContentResolver().query(a(), j, (String) null, (String[]) null, "date ASC");
            if (query != null) {
                if (query.moveToLast()) {
                    boolean z2 = query.getInt(query.getColumnIndexOrThrow(d)) == 1;
                    Date date = new Date(query.getLong(query.getColumnIndexOrThrow(f)));
                    String a2 = aa.a(query.getString(query.getColumnIndexOrThrow("title")));
                    String a3 = aa.a(query.getString(query.getColumnIndexOrThrow("url")));
                    int i2 = query.getInt(query.getColumnIndexOrThrow(i));
                    b bVar = this.c;
                    if (bVar != null) {
                        bVar.a(z2, date, a2, a3, i2);
                    }
                }
                query.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
