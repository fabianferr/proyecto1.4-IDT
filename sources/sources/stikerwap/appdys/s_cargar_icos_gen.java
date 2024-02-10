package stikerwap.appdys;

import android.app.IntentService;
import android.graphics.Bitmap;

public class s_cargar_icos_gen extends IntentService {
    Bitmap bm;
    config globales;

    public s_cargar_icos_gen() {
        super("s_cargar_icos_gen");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntent(android.content.Intent r10) {
        /*
            r9 = this;
            android.content.Context r0 = r9.getApplicationContext()
            stikerwap.appdys.config r0 = (stikerwap.appdys.config) r0
            r9.globales = r0
            r0 = 0
            r1 = 0
        L_0x000a:
            r2 = 6
            if (r1 >= r2) goto L_0x0181
            if (r1 != 0) goto L_0x0019
            java.lang.String r2 = "act_ico_perfil"
            boolean r2 = r10.getBooleanExtra(r2, r0)
            if (r2 != 0) goto L_0x0019
            goto L_0x017d
        L_0x0019:
            r2 = 1
            if (r1 != r2) goto L_0x0026
            java.lang.String r3 = "act_ico_privados"
            boolean r3 = r10.getBooleanExtra(r3, r0)
            if (r3 != 0) goto L_0x0026
            goto L_0x017d
        L_0x0026:
            r3 = 2
            if (r1 != r3) goto L_0x0033
            java.lang.String r4 = "act_ico_foto"
            boolean r4 = r10.getBooleanExtra(r4, r0)
            if (r4 != 0) goto L_0x0033
            goto L_0x017d
        L_0x0033:
            r4 = 3
            if (r1 != r4) goto L_0x0040
            java.lang.String r5 = "act_ico_video"
            boolean r5 = r10.getBooleanExtra(r5, r0)
            if (r5 != 0) goto L_0x0040
            goto L_0x017d
        L_0x0040:
            r5 = 4
            if (r1 != r5) goto L_0x004d
            java.lang.String r6 = "act_ico_emotic"
            boolean r6 = r10.getBooleanExtra(r6, r0)
            if (r6 != 0) goto L_0x004d
            goto L_0x017d
        L_0x004d:
            r6 = 5
            if (r1 != r6) goto L_0x005a
            java.lang.String r7 = "act_ico_enviar"
            boolean r7 = r10.getBooleanExtra(r7, r0)
            if (r7 != 0) goto L_0x005a
            goto L_0x017d
        L_0x005a:
            if (r1 != 0) goto L_0x0078
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "3008836_ico_perfil.png?v="
            r3.<init>(r4)
            stikerwap.appdys.config r4 = r9.globales
            int r4 = r4.v_ico_perfil
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            stikerwap.appdys.config r4 = r9.globales
            int r4 = r4.v_ico_perfil
            java.lang.String r5 = "ico_perfil"
            java.lang.String r6 = "v_ico_perfil_act"
            goto L_0x010f
        L_0x0078:
            if (r1 != r2) goto L_0x0096
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "3008836_ico_privados.png?v="
            r3.<init>(r4)
            stikerwap.appdys.config r4 = r9.globales
            int r4 = r4.v_ico_privados
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            stikerwap.appdys.config r4 = r9.globales
            int r4 = r4.v_ico_privados
            java.lang.String r5 = "ico_privados"
            java.lang.String r6 = "v_ico_privados_act"
            goto L_0x010f
        L_0x0096:
            if (r1 != r3) goto L_0x00b3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "3008836_ico_foto.png?v="
            r3.<init>(r4)
            stikerwap.appdys.config r4 = r9.globales
            int r4 = r4.v_ico_foto
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            stikerwap.appdys.config r4 = r9.globales
            int r4 = r4.v_ico_foto
            java.lang.String r5 = "ico_foto"
            java.lang.String r6 = "v_ico_foto_act"
            goto L_0x010f
        L_0x00b3:
            if (r1 != r4) goto L_0x00d0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "3008836_ico_video.png?v="
            r3.<init>(r4)
            stikerwap.appdys.config r4 = r9.globales
            int r4 = r4.v_ico_video
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            stikerwap.appdys.config r4 = r9.globales
            int r4 = r4.v_ico_video
            java.lang.String r5 = "ico_video"
            java.lang.String r6 = "v_ico_video_act"
            goto L_0x010f
        L_0x00d0:
            if (r1 != r5) goto L_0x00ed
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "3008836_ico_emotic.png?v="
            r3.<init>(r4)
            stikerwap.appdys.config r4 = r9.globales
            int r4 = r4.v_ico_emotic
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            stikerwap.appdys.config r4 = r9.globales
            int r4 = r4.v_ico_emotic
            java.lang.String r5 = "ico_emotic"
            java.lang.String r6 = "v_ico_emotic_act"
            goto L_0x010f
        L_0x00ed:
            if (r1 != r6) goto L_0x010a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "3008836_ico_enviar.png?v="
            r3.<init>(r4)
            stikerwap.appdys.config r4 = r9.globales
            int r4 = r4.v_ico_enviar
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            stikerwap.appdys.config r4 = r9.globales
            int r4 = r4.v_ico_enviar
            java.lang.String r5 = "ico_enviar"
            java.lang.String r6 = "v_ico_enviar_act"
            goto L_0x010f
        L_0x010a:
            java.lang.String r3 = ""
            r5 = r3
            r6 = r5
            r4 = 0
        L_0x010f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = stikerwap.appdys.config.DOM_CDN
            r7.append(r8)
            java.lang.String r8 = "/srv/imgs/gen/"
            r7.append(r8)
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            java.net.URL r7 = new java.net.URL     // Catch:{ MalformedURLException -> 0x012c }
            r7.<init>(r3)     // Catch:{ MalformedURLException -> 0x012c }
            r3 = 1
            goto L_0x012e
        L_0x012c:
            r7 = 0
            r3 = 0
        L_0x012e:
            if (r3 == 0) goto L_0x017d
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{  }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{  }
            r7.setDoInput(r2)     // Catch:{  }
            r2 = 5000(0x1388, float:7.006E-42)
            r7.setConnectTimeout(r2)     // Catch:{  }
            r2 = 7000(0x1b58, float:9.809E-42)
            r7.setReadTimeout(r2)     // Catch:{  }
            r7.connect()     // Catch:{  }
            java.io.InputStream r2 = r7.getInputStream()     // Catch:{  }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{  }
            r9.bm = r2     // Catch:{  }
            java.io.FileOutputStream r2 = r9.openFileOutput(r5, r0)     // Catch:{ IOException -> 0x0161 }
            android.graphics.Bitmap r5 = r9.bm     // Catch:{ IOException -> 0x0161 }
            android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ IOException -> 0x0161 }
            r8 = 100
            r5.compress(r7, r8, r2)     // Catch:{ IOException -> 0x0161 }
            r2.close()     // Catch:{ IOException -> 0x0161 }
            goto L_0x0163
        L_0x0161:
            r3 = 0
        L_0x0163:
            stikerwap.appdys.config r2 = r9.globales
            if (r2 == 0) goto L_0x017d
            java.lang.String r2 = r2.c1
            if (r2 == 0) goto L_0x017d
            if (r3 == 0) goto L_0x017d
            java.lang.String r2 = "sh"
            android.content.SharedPreferences r2 = r9.getSharedPreferences(r2, r0)
            android.content.SharedPreferences$Editor r2 = r2.edit()
            r2.putInt(r6, r4)
            r2.commit()
        L_0x017d:
            int r1 = r1 + 1
            goto L_0x000a
        L_0x0181:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.s_cargar_icos_gen.onHandleIntent(android.content.Intent):void");
    }
}
