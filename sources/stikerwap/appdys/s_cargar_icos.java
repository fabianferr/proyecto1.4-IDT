package stikerwap.appdys;

import android.app.IntentService;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class s_cargar_icos extends IntentService {
    Bitmap bm;
    config globales;

    public s_cargar_icos() {
        super("s_cargar_icos");
    }

    private void pasar_ico(int i, SharedPreferences.Editor editor) {
        config config = this.globales;
        if (config != null && config.c1 != null && this.globales.secciones_a[i] != null) {
            this.globales.secciones_a[i].ico_cargando = false;
            if (this.globales.tipomenu == 1) {
                this.globales.opcions.get(this.globales.secciones_a[i].ind_menu).img = BitmapFactory.decodeResource(getResources(), R.drawable.pixel500por1);
                this.globales.opcions.get(this.globales.secciones_a[i].ind_menu).img_cargando = false;
                editor.putLong("ico_cargado", System.currentTimeMillis());
                editor.commit();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x0239 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntent(android.content.Intent r15) {
        /*
            r14 = this;
            java.lang.String r0 = "_ico"
            java.lang.String r1 = "img_s"
            android.content.Context r2 = r14.getApplicationContext()
            stikerwap.appdys.config r2 = (stikerwap.appdys.config) r2
            r14.globales = r2
            java.lang.String r2 = "sh"
            r3 = 0
            android.content.SharedPreferences r2 = r14.getSharedPreferences(r2, r3)
            android.content.SharedPreferences$Editor r4 = r2.edit()
            java.lang.String r5 = "ind_submenu"
            r6 = -1
            int r15 = r15.getIntExtra(r5, r6)
            java.lang.String r5 = ","
            java.lang.String r7 = ""
            if (r15 <= r6) goto L_0x004f
            stikerwap.appdys.config r8 = r14.globales
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            r8 = r8[r15]
            int r8 = r8.tipo
            r9 = 22
            if (r8 != r9) goto L_0x0038
            java.lang.String r8 = "seccs_ultimas"
            java.lang.String r2 = r2.getString(r8, r7)
            goto L_0x0040
        L_0x0038:
            stikerwap.appdys.config r2 = r14.globales
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            r2 = r2[r15]
            java.lang.String r2 = r2.seccs
        L_0x0040:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r5)
            r7.append(r2)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
        L_0x004f:
            stikerwap.appdys.config r2 = r14.globales
            if (r2 == 0) goto L_0x024d
            stikerwap.appdys.Seccion[] r2 = r2.secciones_a
            if (r2 != 0) goto L_0x0059
            goto L_0x024d
        L_0x0059:
            r2 = 0
        L_0x005a:
            stikerwap.appdys.config r8 = r14.globales
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            int r8 = r8.length
            if (r2 >= r8) goto L_0x00a4
            stikerwap.appdys.config r8 = r14.globales
            if (r8 == 0) goto L_0x00a1
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            r8 = r8[r2]
            if (r8 == 0) goto L_0x00a1
            stikerwap.appdys.config r8 = r14.globales
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            r8 = r8[r2]
            boolean r8 = r8.ico_cargando
            if (r8 == 0) goto L_0x00a1
            if (r15 != r6) goto L_0x0081
            stikerwap.appdys.config r8 = r14.globales
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            r8 = r8[r2]
            boolean r8 = r8.oculta
            if (r8 == 0) goto L_0x00a4
        L_0x0081:
            if (r15 <= r6) goto L_0x00a1
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r5)
            stikerwap.appdys.config r9 = r14.globales
            stikerwap.appdys.Seccion[] r9 = r9.secciones_a
            r9 = r9[r2]
            int r9 = r9.id
            r8.append(r9)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            boolean r8 = r7.contains(r8)
            if (r8 == 0) goto L_0x00a1
            goto L_0x00a4
        L_0x00a1:
            int r2 = r2 + 1
            goto L_0x005a
        L_0x00a4:
            stikerwap.appdys.config r8 = r14.globales
            if (r8 == 0) goto L_0x024d
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            if (r8 != 0) goto L_0x00ae
            goto L_0x024d
        L_0x00ae:
            stikerwap.appdys.config r8 = r14.globales
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            int r8 = r8.length
            if (r2 < r8) goto L_0x00bd
            if (r15 != r6) goto L_0x024d
            stikerwap.appdys.config r15 = r14.globales
            r15.icos_pendientes = r3
            goto L_0x024d
        L_0x00bd:
            stikerwap.appdys.config r8 = r14.globales
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            r8 = r8[r2]
            if (r8 != 0) goto L_0x00c7
            goto L_0x024d
        L_0x00c7:
            stikerwap.appdys.config r8 = r14.globales
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            r8 = r8[r2]
            int r8 = r8.ico_id
            if (r8 != 0) goto L_0x0100
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = stikerwap.appdys.config.DOM_CDN
            r8.append(r9)
            java.lang.String r9 = "/srv/imgs/seccs/"
            r8.append(r9)
            stikerwap.appdys.config r9 = r14.globales
            stikerwap.appdys.Seccion[] r9 = r9.secciones_a
            r9 = r9[r2]
            int r9 = r9.id
            r8.append(r9)
            java.lang.String r9 = "_ico.png?v="
            r8.append(r9)
            stikerwap.appdys.config r9 = r14.globales
            stikerwap.appdys.Seccion[] r9 = r9.secciones_a
            r9 = r9[r2]
            int r9 = r9.v_ico
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            goto L_0x0123
        L_0x0100:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = stikerwap.appdys.config.DOM_CDN
            r8.append(r9)
            java.lang.String r9 = "/android-app-creator/icos_secc/"
            r8.append(r9)
            stikerwap.appdys.config r9 = r14.globales
            stikerwap.appdys.Seccion[] r9 = r9.secciones_a
            r9 = r9[r2]
            int r9 = r9.ico_id
            r8.append(r9)
            java.lang.String r9 = ".png"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
        L_0x0123:
            java.net.URL r9 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0248 }
            r9.<init>(r8)     // Catch:{ MalformedURLException -> 0x0248 }
            java.net.URLConnection r8 = r9.openConnection()     // Catch:{ IOException -> 0x0243 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ IOException -> 0x0243 }
            r9 = 1
            r8.setDoInput(r9)     // Catch:{ IOException -> 0x0243 }
            r10 = 5000(0x1388, float:7.006E-42)
            r8.setConnectTimeout(r10)     // Catch:{ IOException -> 0x0243 }
            r10 = 7000(0x1b58, float:9.809E-42)
            r8.setReadTimeout(r10)     // Catch:{ IOException -> 0x0243 }
            r8.connect()     // Catch:{ IOException -> 0x0243 }
            java.io.InputStream r8 = r8.getInputStream()     // Catch:{ IOException -> 0x0243 }
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r8)     // Catch:{ IOException -> 0x0243 }
            r14.bm = r8     // Catch:{ IOException -> 0x0243 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            r8.<init>()     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            r8.append(r1)     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            stikerwap.appdys.config r10 = r14.globales     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            stikerwap.appdys.Seccion[] r10 = r10.secciones_a     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            r10 = r10[r2]     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            int r10 = r10.id     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            r8.append(r10)     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            r8.append(r0)     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            java.io.FileOutputStream r8 = r14.openFileOutput(r8, r3)     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            android.graphics.Bitmap r10 = r14.bm     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            android.graphics.Bitmap$CompressFormat r11 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            r12 = 100
            r10.compress(r11, r12, r8)     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            r8.close()     // Catch:{ Exception -> 0x023e, OutOfMemoryError -> 0x0239 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            r8.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            r8.append(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            stikerwap.appdys.config r10 = r14.globales     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            stikerwap.appdys.Seccion[] r10 = r10.secciones_a     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            r10 = r10[r2]     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            int r10 = r10.id     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            r8.append(r10)     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            java.lang.String r10 = "_ico_g"
            r8.append(r10)     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            java.io.FileOutputStream r8 = r14.openFileOutput(r8, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            android.graphics.Bitmap r10 = r14.bm     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            int r11 = r10.getWidth()     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            int r11 = stikerwap.appdys.config.dp_to_px(r14, r11)     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            android.graphics.Bitmap r13 = r14.bm     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            int r13 = r13.getHeight()     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            int r13 = stikerwap.appdys.config.dp_to_px(r14, r13)     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createScaledBitmap(r10, r11, r13, r9)     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            android.graphics.Bitmap$CompressFormat r11 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            r10.compress(r11, r12, r8)     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
            r8.close()     // Catch:{ Exception | OutOfMemoryError -> 0x01b3 }
        L_0x01b3:
            stikerwap.appdys.config r8 = r14.globales
            if (r8 == 0) goto L_0x024d
            java.lang.String r8 = r8.c1
            if (r8 == 0) goto L_0x024d
            stikerwap.appdys.config r8 = r14.globales
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            r8 = r8[r2]
            if (r8 == 0) goto L_0x024d
            stikerwap.appdys.config r8 = r14.globales
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            r8 = r8[r2]
            android.graphics.Bitmap r10 = r14.bm
            r8.ico = r10
            stikerwap.appdys.config r8 = r14.globales
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            r8 = r8[r2]
            r8.ico_cargando = r3
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "s"
            r8.<init>(r10)
            stikerwap.appdys.config r10 = r14.globales
            stikerwap.appdys.Seccion[] r10 = r10.secciones_a
            r10 = r10[r2]
            int r10 = r10.id
            r8.append(r10)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r4.putInt(r8, r3)
            java.lang.String r8 = "ico_cargado"
            long r10 = java.lang.System.currentTimeMillis()
            r4.putLong(r8, r10)
            stikerwap.appdys.config r8 = r14.globales
            int r8 = r8.tipomenu
            if (r8 != r9) goto L_0x0234
            stikerwap.appdys.config r8 = r14.globales
            stikerwap.appdys.Seccion[] r8 = r8.secciones_a
            r8 = r8[r2]
            boolean r8 = r8.oculta
            if (r8 != 0) goto L_0x0234
            stikerwap.appdys.config r8 = r14.globales
            java.util.ArrayList<stikerwap.appdys.config$MenuOpcion> r8 = r8.opcions
            stikerwap.appdys.config r9 = r14.globales
            stikerwap.appdys.Seccion[] r9 = r9.secciones_a
            r9 = r9[r2]
            int r9 = r9.ind_menu
            java.lang.Object r8 = r8.get(r9)
            stikerwap.appdys.config$MenuOpcion r8 = (stikerwap.appdys.config.MenuOpcion) r8
            android.graphics.Bitmap r9 = r14.bm
            r8.img = r9
            stikerwap.appdys.config r8 = r14.globales
            java.util.ArrayList<stikerwap.appdys.config$MenuOpcion> r8 = r8.opcions
            stikerwap.appdys.config r9 = r14.globales
            stikerwap.appdys.Seccion[] r9 = r9.secciones_a
            r2 = r9[r2]
            int r2 = r2.ind_menu
            java.lang.Object r2 = r8.get(r2)
            stikerwap.appdys.config$MenuOpcion r2 = (stikerwap.appdys.config.MenuOpcion) r2
            r2.img_cargando = r3
        L_0x0234:
            r4.commit()
            goto L_0x004f
        L_0x0239:
            r14.pasar_ico(r2, r4)     // Catch:{ IOException -> 0x0243 }
            goto L_0x004f
        L_0x023e:
            r14.pasar_ico(r2, r4)     // Catch:{ IOException -> 0x0243 }
            goto L_0x004f
        L_0x0243:
            r14.pasar_ico(r2, r4)
            goto L_0x004f
        L_0x0248:
            r14.pasar_ico(r2, r4)
            goto L_0x004f
        L_0x024d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.s_cargar_icos.onHandleIntent(android.content.Intent):void");
    }
}
