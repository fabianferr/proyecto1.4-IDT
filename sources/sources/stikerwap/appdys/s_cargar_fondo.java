package stikerwap.appdys;

import android.app.IntentService;
import android.graphics.Bitmap;

public class s_cargar_fondo extends IntentService {
    Bitmap bm;
    config globales;

    public s_cargar_fondo() {
        super("s_cargar_fondo");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntent(android.content.Intent r6) {
        /*
            r5 = this;
            android.content.Context r6 = r5.getApplicationContext()
            stikerwap.appdys.config r6 = (stikerwap.appdys.config) r6
            r5.globales = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = stikerwap.appdys.config.DOM_CDN
            r6.append(r0)
            java.lang.String r0 = "/srv/imgs/gen/3008836_fondo.png?v="
            r6.append(r0)
            stikerwap.appdys.config r0 = r5.globales
            int r0 = r0.fondo_v
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r0 = 0
            r1 = 1
            java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x002b }
            r2.<init>(r6)     // Catch:{ MalformedURLException -> 0x002b }
            r6 = 1
            goto L_0x002d
        L_0x002b:
            r2 = 0
            r6 = 0
        L_0x002d:
            if (r6 == 0) goto L_0x0084
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{  }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{  }
            r2.setDoInput(r1)     // Catch:{  }
            r1 = 5000(0x1388, float:7.006E-42)
            r2.setConnectTimeout(r1)     // Catch:{  }
            r1 = 7000(0x1b58, float:9.809E-42)
            r2.setReadTimeout(r1)     // Catch:{  }
            r2.connect()     // Catch:{  }
            java.io.InputStream r1 = r2.getInputStream()     // Catch:{  }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{  }
            r5.bm = r1     // Catch:{  }
            java.lang.String r1 = "fondo"
            java.io.FileOutputStream r1 = r5.openFileOutput(r1, r0)     // Catch:{ IOException -> 0x0062 }
            android.graphics.Bitmap r2 = r5.bm     // Catch:{ IOException -> 0x0062 }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ IOException -> 0x0062 }
            r4 = 100
            r2.compress(r3, r4, r1)     // Catch:{ IOException -> 0x0062 }
            r1.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0064
        L_0x0062:
            r6 = 0
        L_0x0064:
            stikerwap.appdys.config r1 = r5.globales
            if (r1 == 0) goto L_0x0084
            java.lang.String r1 = r1.c1
            if (r1 == 0) goto L_0x0084
            if (r6 == 0) goto L_0x0084
            java.lang.String r6 = "sh"
            android.content.SharedPreferences r6 = r5.getSharedPreferences(r6, r0)
            android.content.SharedPreferences$Editor r6 = r6.edit()
            stikerwap.appdys.config r0 = r5.globales
            int r0 = r0.fondo_v
            java.lang.String r1 = "fondo_v_act"
            r6.putInt(r1, r0)
            r6.commit()
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.s_cargar_fondo.onHandleIntent(android.content.Intent):void");
    }
}
