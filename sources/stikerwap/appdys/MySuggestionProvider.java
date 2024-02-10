package stikerwap.appdys;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class MySuggestionProvider extends ContentProvider {
    private static final String STORES = "stores/search_suggest_query/*";
    private static String[] matrixCursorColumns;
    private static final UriMatcher uriMatcher;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    static {
        UriMatcher uriMatcher2 = new UriMatcher(-1);
        uriMatcher = uriMatcher2;
        uriMatcher2.addURI("stikerwap.appdys.MySuggestionProvider", STORES, 1);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (uriMatcher.match(uri) != 1) {
            return null;
        }
        return getSearchResultsCursor(uri.getLastPathSegment().toLowerCase());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01c7, code lost:
        if (r4 != null) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01cf, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01d1, code lost:
        r17 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01d3, code lost:
        r18 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01d7, code lost:
        r17 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01d9, code lost:
        r18 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01eb, code lost:
        if (r4 == null) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01cf A[ExcHandler: all (th java.lang.Throwable), Splitter:B:98:0x0199] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01e1 A[SYNTHETIC, Splitter:B:129:0x01e1] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01f6 A[SYNTHETIC, Splitter:B:141:0x01f6] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0205 A[SYNTHETIC, Splitter:B:148:0x0205] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.database.MatrixCursor getSearchResultsCursor(java.lang.String r20) {
        /*
            r19 = this;
            java.lang.String r0 = "_ico_g"
            java.lang.String r1 = "img_s"
            android.content.Context r2 = r19.getContext()
            stikerwap.appdys.config r2 = (stikerwap.appdys.config) r2
            java.lang.String r3 = r2.c1
            r4 = 0
            if (r3 != 0) goto L_0x0010
            return r4
        L_0x0010:
            boolean r3 = r2.search_show_ico
            r5 = 0
            if (r3 == 0) goto L_0x002e
            stikerwap.appdys.Seccion[] r3 = r2.secciones_a
            int r7 = r3.length
            r8 = 0
        L_0x0019:
            if (r8 >= r7) goto L_0x002e
            r9 = r3[r8]
            boolean r10 = r9.search_incluir
            if (r10 == 0) goto L_0x002b
            boolean r10 = r9.ico_cargando
            if (r10 != 0) goto L_0x0029
            android.graphics.Bitmap r9 = r9.ico
            if (r9 == 0) goto L_0x002b
        L_0x0029:
            r3 = 1
            goto L_0x002f
        L_0x002b:
            int r8 = r8 + 1
            goto L_0x0019
        L_0x002e:
            r3 = 0
        L_0x002f:
            java.lang.String r7 = "suggest_intent_data"
            java.lang.String r8 = "suggest_text_2"
            java.lang.String r9 = "suggest_text_1"
            java.lang.String r10 = "_id"
            if (r3 == 0) goto L_0x0042
            java.lang.String r11 = "suggest_icon_1"
            java.lang.String[] r7 = new java.lang.String[]{r10, r9, r8, r11, r7}
            matrixCursorColumns = r7
            goto L_0x0048
        L_0x0042:
            java.lang.String[] r7 = new java.lang.String[]{r10, r9, r8, r7}
            matrixCursorColumns = r7
        L_0x0048:
            android.database.MatrixCursor r7 = new android.database.MatrixCursor
            java.lang.String[] r8 = matrixCursorColumns
            r7.<init>(r8)
            r8 = 4
            if (r3 == 0) goto L_0x0056
            r9 = 5
            java.lang.Object[] r9 = new java.lang.Object[r9]
            goto L_0x0058
        L_0x0056:
            java.lang.Object[] r9 = new java.lang.Object[r8]
        L_0x0058:
            if (r20 == 0) goto L_0x026a
            java.lang.String r10 = r20.trim()
            java.lang.String r11 = ""
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x026a
            java.lang.String r10 = r20.toLowerCase()
            java.lang.String r10 = stikerwap.appdys.config.removeAccents(r10)
            java.lang.String r10 = r10.trim()
            stikerwap.appdys.Seccion[] r12 = r2.secciones_a
            int r13 = r12.length
            r14 = 0
            r15 = 0
        L_0x0077:
            if (r14 >= r13) goto L_0x026a
            r8 = r12[r14]
            boolean r4 = r8.search_incluir
            if (r4 == 0) goto L_0x0257
            boolean r4 = r2.search_tit
            if (r4 == 0) goto L_0x0093
            java.lang.String r4 = r8.titulo_norm
            if (r4 != 0) goto L_0x0093
            java.lang.String r4 = r8.titulo
            java.lang.String r4 = stikerwap.appdys.config.removeAccents(r4)
            java.lang.String r4 = r4.toLowerCase()
            r8.titulo_norm = r4
        L_0x0093:
            boolean r4 = r2.search_descr
            if (r4 == 0) goto L_0x00a7
            java.lang.String r4 = r8.descr_norm
            if (r4 != 0) goto L_0x00a7
            java.lang.String r4 = r8.descr
            java.lang.String r4 = stikerwap.appdys.config.removeAccents(r4)
            java.lang.String r4 = r4.toLowerCase()
            r8.descr_norm = r4
        L_0x00a7:
            boolean r4 = r2.search_tit
            if (r4 == 0) goto L_0x00c3
            java.lang.String r4 = r8.titulo_norm
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x00c3
            java.lang.String r4 = r8.titulo_norm
            boolean r4 = r4.contains(r10)
            if (r4 != 0) goto L_0x00eb
            java.lang.String r4 = r8.titulo_norm
            boolean r4 = r10.contains(r4)
            if (r4 != 0) goto L_0x00eb
        L_0x00c3:
            boolean r4 = r2.search_descr
            if (r4 == 0) goto L_0x00df
            java.lang.String r4 = r8.descr_norm
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x00df
            java.lang.String r4 = r8.descr_norm
            boolean r4 = r4.contains(r10)
            if (r4 != 0) goto L_0x00eb
            java.lang.String r4 = r8.descr_norm
            boolean r4 = r10.contains(r4)
            if (r4 != 0) goto L_0x00eb
        L_0x00df:
            java.util.ArrayList<java.lang.String> r4 = r8.kw
            if (r4 == 0) goto L_0x00ed
            java.util.ArrayList<java.lang.String> r4 = r8.kw
            boolean r4 = r4.contains(r10)
            if (r4 == 0) goto L_0x00ed
        L_0x00eb:
            r6 = 1
            goto L_0x0113
        L_0x00ed:
            java.util.ArrayList<java.lang.String> r4 = r8.kw
            if (r4 == 0) goto L_0x0112
            java.util.ArrayList<java.lang.String> r4 = r8.kw
            java.util.Iterator r4 = r4.iterator()
        L_0x00f7:
            boolean r16 = r4.hasNext()
            if (r16 == 0) goto L_0x0112
            java.lang.Object r16 = r4.next()
            r6 = r16
            java.lang.String r6 = (java.lang.String) r6
            boolean r16 = r6.contains(r10)
            if (r16 != 0) goto L_0x00eb
            boolean r6 = r10.contains(r6)
            if (r6 == 0) goto L_0x00f7
            goto L_0x00eb
        L_0x0112:
            r6 = 0
        L_0x0113:
            if (r6 == 0) goto L_0x0257
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            r4.append(r15)
            java.lang.String r4 = r4.toString()
            r9[r5] = r4
            boolean r4 = r2.search_show_tit
            r6 = 2
            if (r4 == 0) goto L_0x013c
            java.lang.String r4 = r8.titulo
            r16 = 1
            r9[r16] = r4
            boolean r4 = r2.search_show_descr
            if (r4 == 0) goto L_0x0138
            java.lang.String r4 = r8.descr
            r9[r6] = r4
            r4 = 0
            goto L_0x0145
        L_0x0138:
            r4 = 0
            r9[r6] = r4
            goto L_0x0145
        L_0x013c:
            r4 = 0
            r16 = 1
            java.lang.String r5 = r8.descr
            r9[r16] = r5
            r9[r6] = r4
        L_0x0145:
            r5 = 3
            if (r3 == 0) goto L_0x023e
            r9[r5] = r4
            boolean r6 = r8.ico_cargando
            if (r6 != 0) goto L_0x0229
            android.graphics.Bitmap r6 = r8.ico
            if (r6 == 0) goto L_0x0229
            android.content.Context r6 = r19.getContext()     // Catch:{ FileNotFoundException -> 0x0170 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0170 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0170 }
            r4.append(r1)     // Catch:{ FileNotFoundException -> 0x0170 }
            int r5 = r8.id     // Catch:{ FileNotFoundException -> 0x0170 }
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x0170 }
            r4.append(r0)     // Catch:{ FileNotFoundException -> 0x0170 }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0170 }
            java.io.FileInputStream r4 = r6.openFileInput(r4)     // Catch:{ FileNotFoundException -> 0x0170 }
            r5 = 0
            goto L_0x0173
        L_0x0170:
            r4 = 0
            r5 = 1
        L_0x0173:
            if (r4 == 0) goto L_0x017a
            r4.close()     // Catch:{ Exception -> 0x0179 }
            goto L_0x017a
        L_0x0179:
        L_0x017a:
            if (r5 == 0) goto L_0x01fd
            android.content.Context r4 = r19.getContext()     // Catch:{ Exception -> 0x01ee, OutOfMemoryError -> 0x01e5, all -> 0x01dd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ee, OutOfMemoryError -> 0x01e5, all -> 0x01dd }
            r5.<init>()     // Catch:{ Exception -> 0x01ee, OutOfMemoryError -> 0x01e5, all -> 0x01dd }
            r5.append(r1)     // Catch:{ Exception -> 0x01ee, OutOfMemoryError -> 0x01e5, all -> 0x01dd }
            int r6 = r8.id     // Catch:{ Exception -> 0x01ee, OutOfMemoryError -> 0x01e5, all -> 0x01dd }
            r5.append(r6)     // Catch:{ Exception -> 0x01ee, OutOfMemoryError -> 0x01e5, all -> 0x01dd }
            r5.append(r0)     // Catch:{ Exception -> 0x01ee, OutOfMemoryError -> 0x01e5, all -> 0x01dd }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x01ee, OutOfMemoryError -> 0x01e5, all -> 0x01dd }
            r6 = 0
            java.io.FileOutputStream r4 = r4.openFileOutput(r5, r6)     // Catch:{ Exception -> 0x01ee, OutOfMemoryError -> 0x01e5, all -> 0x01dd }
            android.graphics.Bitmap r5 = r8.ico     // Catch:{ Exception -> 0x01d7, OutOfMemoryError -> 0x01d1, all -> 0x01cf }
            android.content.Context r6 = r19.getContext()     // Catch:{ Exception -> 0x01d7, OutOfMemoryError -> 0x01d1, all -> 0x01cf }
            r17 = r2
            android.graphics.Bitmap r2 = r8.ico     // Catch:{ Exception -> 0x01d9, OutOfMemoryError -> 0x01d3, all -> 0x01cf }
            int r2 = r2.getWidth()     // Catch:{ Exception -> 0x01d9, OutOfMemoryError -> 0x01d3, all -> 0x01cf }
            int r2 = stikerwap.appdys.config.dp_to_px(r6, r2)     // Catch:{ Exception -> 0x01d9, OutOfMemoryError -> 0x01d3, all -> 0x01cf }
            android.content.Context r6 = r19.getContext()     // Catch:{ Exception -> 0x01d9, OutOfMemoryError -> 0x01d3, all -> 0x01cf }
            r18 = r3
            android.graphics.Bitmap r3 = r8.ico     // Catch:{ Exception -> 0x01db, OutOfMemoryError -> 0x01d5, all -> 0x01cf }
            int r3 = r3.getHeight()     // Catch:{ Exception -> 0x01db, OutOfMemoryError -> 0x01d5, all -> 0x01cf }
            int r3 = stikerwap.appdys.config.dp_to_px(r6, r3)     // Catch:{ Exception -> 0x01db, OutOfMemoryError -> 0x01d5, all -> 0x01cf }
            r6 = 1
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r5, r2, r3, r6)     // Catch:{ Exception -> 0x01f4, OutOfMemoryError -> 0x01eb, all -> 0x01cf }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x01f4, OutOfMemoryError -> 0x01eb, all -> 0x01cf }
            r5 = 100
            r2.compress(r3, r5, r4)     // Catch:{ Exception -> 0x01f4, OutOfMemoryError -> 0x01eb, all -> 0x01cf }
            if (r4 == 0) goto L_0x0202
        L_0x01c9:
            r4.close()     // Catch:{ IOException -> 0x01cd }
            goto L_0x0202
        L_0x01cd:
            goto L_0x0202
        L_0x01cf:
            r0 = move-exception
            goto L_0x01df
        L_0x01d1:
            r17 = r2
        L_0x01d3:
            r18 = r3
        L_0x01d5:
            r6 = 1
            goto L_0x01eb
        L_0x01d7:
            r17 = r2
        L_0x01d9:
            r18 = r3
        L_0x01db:
            r6 = 1
            goto L_0x01f4
        L_0x01dd:
            r0 = move-exception
            r4 = 0
        L_0x01df:
            if (r4 == 0) goto L_0x01e4
            r4.close()     // Catch:{ IOException -> 0x01e4 }
        L_0x01e4:
            throw r0
        L_0x01e5:
            r17 = r2
            r18 = r3
            r6 = 1
            r4 = 0
        L_0x01eb:
            if (r4 == 0) goto L_0x0202
            goto L_0x01c9
        L_0x01ee:
            r17 = r2
            r18 = r3
            r6 = 1
            r4 = 0
        L_0x01f4:
            if (r4 == 0) goto L_0x01fb
            r4.close()     // Catch:{ IOException -> 0x01fa }
            goto L_0x01fb
        L_0x01fa:
        L_0x01fb:
            r2 = 0
            goto L_0x0203
        L_0x01fd:
            r17 = r2
            r18 = r3
            r6 = 1
        L_0x0202:
            r2 = 1
        L_0x0203:
            if (r2 == 0) goto L_0x022e
            android.content.Context r2 = r19.getContext()     // Catch:{ Exception | OutOfMemoryError -> 0x022e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception | OutOfMemoryError -> 0x022e }
            r3.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x022e }
            r3.append(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x022e }
            int r4 = r8.id     // Catch:{ Exception | OutOfMemoryError -> 0x022e }
            r3.append(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x022e }
            r3.append(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x022e }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x022e }
            java.io.File r2 = r2.getFileStreamPath(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x022e }
            java.net.URI r2 = r2.toURI()     // Catch:{ Exception | OutOfMemoryError -> 0x022e }
            r3 = 3
            r9[r3] = r2     // Catch:{ Exception | OutOfMemoryError -> 0x022e }
            goto L_0x022e
        L_0x0229:
            r17 = r2
            r18 = r3
            r6 = 1
        L_0x022e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r3 = 4
            r9[r3] = r2
            goto L_0x0253
        L_0x023e:
            r17 = r2
            r18 = r3
            r3 = 4
            r6 = 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r4 = 3
            r9[r4] = r2
        L_0x0253:
            r7.addRow(r9)
            goto L_0x025d
        L_0x0257:
            r17 = r2
            r18 = r3
            r3 = 4
            r6 = 1
        L_0x025d:
            int r15 = r15 + 1
            int r14 = r14 + 1
            r2 = r17
            r3 = r18
            r4 = 0
            r5 = 0
            r8 = 4
            goto L_0x0077
        L_0x026a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.MySuggestionProvider.getSearchResultsCursor(java.lang.String):android.database.MatrixCursor");
    }
}
