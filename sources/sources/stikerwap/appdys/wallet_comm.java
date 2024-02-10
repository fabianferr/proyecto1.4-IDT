package stikerwap.appdys;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import stikerwap.appdys.TweetNaclFast;

public class wallet_comm extends Activity {
    TweetNaclFast.Box box;
    config globales;
    byte[] nonce;
    String redirect_link_pago;
    String session;

    /* JADX WARNING: Removed duplicated region for block: B:70:0x0217 A[SYNTHETIC, Splitter:B:70:0x0217] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x021e A[SYNTHETIC, Splitter:B:76:0x021e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r17) {
        /*
            r16 = this;
            r8 = r16
            android.content.Context r0 = r16.getApplicationContext()
            stikerwap.appdys.config r0 = (stikerwap.appdys.config) r0
            r8.globales = r0
            java.lang.String r0 = r0.c1
            if (r0 != 0) goto L_0x0013
            stikerwap.appdys.config r0 = r8.globales
            r0.recuperar_vars()
        L_0x0013:
            super.onCreate(r17)
            java.lang.String r0 = "Torne de Phantom"
            java.lang.String r1 = "phantom"
            android.util.Log.e(r1, r0)
            java.lang.String r0 = "sh"
            r2 = 0
            android.content.SharedPreferences r2 = r8.getSharedPreferences(r0, r2)
            android.content.Intent r0 = r16.getIntent()
            java.lang.String r0 = r0.getDataString()
            android.util.Log.e(r1, r0)
            android.content.Intent r0 = r16.getIntent()
            java.lang.String r0 = r0.getDataString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r3 = "errorCode"
            java.lang.String r3 = r0.getQueryParameter(r3)
            if (r3 == 0) goto L_0x0049
            java.lang.String r0 = "error!!!"
            android.util.Log.e(r1, r0)
            return
        L_0x0049:
            java.lang.String r3 = "signature"
            java.lang.String r3 = r0.getQueryParameter(r3)
            if (r3 == 0) goto L_0x0057
            java.lang.String r0 = "paso 2"
            android.util.Log.e(r1, r0)
            return
        L_0x0057:
            java.lang.String r3 = "phantom_encryption_public_key"
            java.lang.String r3 = r0.getQueryParameter(r3)
            r9 = 0
            byte[] r4 = stikerwap.appdys.Base58.decode(r3)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0064
        L_0x0063:
            r4 = r9
        L_0x0064:
            java.lang.String r5 = "data"
            java.lang.String r5 = r0.getQueryParameter(r5)
            byte[] r6 = stikerwap.appdys.Base58.decode(r5)     // Catch:{ Exception -> 0x006f }
            goto L_0x0070
        L_0x006f:
            r6 = r9
        L_0x0070:
            java.lang.String r7 = "nonce"
            java.lang.String r7 = r0.getQueryParameter(r7)
            r8.nonce = r9
            byte[] r0 = stikerwap.appdys.Base58.decode(r7)     // Catch:{ Exception -> 0x007e }
            r8.nonce = r0     // Catch:{ Exception -> 0x007e }
        L_0x007e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r10 = "ph_pk:"
            r0.<init>(r10)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r10 = "ph_pk_b58:"
            r0.<init>(r10)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "data:"
            r0.<init>(r3)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "data_b58:"
            r0.<init>(r3)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "nonce:"
            r0.<init>(r3)
            byte[] r3 = r8.nonce
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "nonce_b58:"
            r0.<init>(r3)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            java.lang.String r0 = "dapp_sk_b58"
            java.lang.String r3 = ""
            java.lang.String r0 = r2.getString(r0, r3)
            byte[] r5 = stikerwap.appdys.Base58.decode(r0)     // Catch:{ Exception -> 0x00f3 }
            goto L_0x00f4
        L_0x00f3:
            r5 = r9
        L_0x00f4:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "dapp_sk:"
            r10.<init>(r11)
            r10.append(r5)
            java.lang.String r10 = r10.toString()
            android.util.Log.e(r1, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "dapp_sk_b58:"
            r10.<init>(r11)
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            android.util.Log.e(r1, r0)
            r8.redirect_link_pago = r3
            java.lang.String r0 = "ac3008836://wallet_comm/"
            java.lang.String r10 = "UTF-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r10)     // Catch:{ UnsupportedEncodingException -> 0x0123 }
            r8.redirect_link_pago = r0     // Catch:{ UnsupportedEncodingException -> 0x0123 }
            goto L_0x0127
        L_0x0123:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0127:
            stikerwap.appdys.TweetNaclFast$Box r0 = new stikerwap.appdys.TweetNaclFast$Box
            r0.<init>(r4, r5)
            r8.box = r0
            java.lang.String r4 = new java.lang.String
            byte[] r5 = r8.nonce
            byte[] r0 = r0.open((byte[]) r6, (byte[]) r5)
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8
            r4.<init>(r0, r5)
            java.lang.String r0 = "data desxifrat:"
            java.lang.String r0 = r0.concat(r4)
            android.util.Log.e(r1, r0)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x014b }
            r0.<init>(r4)     // Catch:{ JSONException -> 0x014b }
            r4 = r0
            goto L_0x0150
        L_0x014b:
            r0 = move-exception
            r0.printStackTrace()
            r4 = r9
        L_0x0150:
            java.lang.String r0 = "public_key"
            java.lang.String r0 = r4.getString(r0)     // Catch:{ JSONException -> 0x0158 }
            r5 = r0
            goto L_0x015d
        L_0x0158:
            r0 = move-exception
            r0.printStackTrace()
            r5 = r3
        L_0x015d:
            if (r5 == r3) goto L_0x0161
            r6 = r5
            goto L_0x0162
        L_0x0161:
            r6 = r3
        L_0x0162:
            java.lang.String r0 = "session"
            java.lang.String r0 = r4.getString(r0)     // Catch:{ Exception -> 0x016b }
            r8.session = r0     // Catch:{ Exception -> 0x016b }
            goto L_0x016f
        L_0x016b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x016f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "wallet:"
            r0.<init>(r4)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "session:"
            r0.<init>(r4)
            java.lang.String r4 = r8.session
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            java.lang.String r0 = "dapp_pk_b58"
            java.lang.String r0 = r2.getString(r0, r3)
            android.os.Handler r5 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r5.<init>(r1)
            android.webkit.WebView r10 = new android.webkit.WebView
            r10.<init>(r8)
            stikerwap.appdys.wallet_comm$1 r11 = new stikerwap.appdys.wallet_comm$1
            r1 = r11
            r2 = r16
            r3 = r10
            r4 = r6
            r6 = r7
            r7 = r0
            r1.<init>(r3, r4, r5, r6, r7)
            r10.setWebViewClient(r11)
            android.webkit.WebSettings r0 = r10.getSettings()
            r1 = 1
            r0.setJavaScriptEnabled(r1)
            android.webkit.WebSettings r0 = r10.getSettings()
            android.webkit.WebSettings$PluginState r2 = android.webkit.WebSettings.PluginState.ON
            r0.setPluginState(r2)
            android.webkit.WebSettings r0 = r10.getSettings()
            r0.setAllowFileAccess(r1)
            stikerwap.appdys.wallet_comm$2 r0 = new stikerwap.appdys.wallet_comm$2
            r0.<init>()
            r10.setWebChromeClient(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x021b, all -> 0x0214 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x021b, all -> 0x0214 }
            android.content.res.AssetManager r3 = r16.getAssets()     // Catch:{ IOException -> 0x021b, all -> 0x0214 }
            java.lang.String r4 = "altres/crear_transaction.html"
            java.io.InputStream r3 = r3.open(r4)     // Catch:{ IOException -> 0x021b, all -> 0x0214 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x021b, all -> 0x0214 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x021b, all -> 0x0214 }
        L_0x01ef:
            java.lang.String r2 = r1.readLine()     // Catch:{ IOException -> 0x0211, all -> 0x020e }
            if (r2 == 0) goto L_0x020a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0211, all -> 0x020e }
            r3.<init>()     // Catch:{ IOException -> 0x0211, all -> 0x020e }
            r3.append(r2)     // Catch:{ IOException -> 0x0211, all -> 0x020e }
            java.lang.String r2 = "\n"
            r3.append(r2)     // Catch:{ IOException -> 0x0211, all -> 0x020e }
            java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x0211, all -> 0x020e }
            r0.append(r2)     // Catch:{ IOException -> 0x0211, all -> 0x020e }
            goto L_0x01ef
        L_0x020a:
            r1.close()     // Catch:{ IOException -> 0x0221 }
            goto L_0x0221
        L_0x020e:
            r0 = move-exception
            r9 = r1
            goto L_0x0215
        L_0x0211:
            r9 = r1
            goto L_0x021c
        L_0x0214:
            r0 = move-exception
        L_0x0215:
            if (r9 == 0) goto L_0x021a
            r9.close()     // Catch:{ IOException -> 0x021a }
        L_0x021a:
            throw r0
        L_0x021b:
        L_0x021c:
            if (r9 == 0) goto L_0x0221
            r9.close()     // Catch:{ IOException -> 0x0221 }
        L_0x0221:
            java.lang.String r11 = "https://www.meloinvento.com"
            java.lang.String r12 = r0.toString()
            java.lang.String r13 = "text/html"
            java.lang.String r14 = "utf-8"
            r15 = 0
            r10.loadDataWithBaseURL(r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.wallet_comm.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: package-private */
    public void pagar(String str, String str2, String str3) {
        byte[] bArr;
        Log.e("phantom", "session:" + this.session);
        Log.e("phantom", "transaction_b58:" + str3);
        String str4 = "{\"transaction\": " + str3 + ",\"session\": \"" + this.session + "\",}";
        Log.e("phantom", "payload_pre_b58:" + str4);
        try {
            bArr = str4.getBytes("UTF-8");
        } catch (Exception e) {
            Log.e("phantom", "PETADA AL GETBYTES");
            e.printStackTrace();
            bArr = null;
        }
        String encode = Base58.encode(this.box.box(bArr, this.nonce));
        Log.e("phantom", "payload_b58:" + encode);
        Log.e("phantom", "https://phantom.app/ul/v1/signAndSendTransaction?dapp_encryption_public_key=" + str2 + "&nonce=" + str + "&redirect_link=" + this.redirect_link_pago + "&payload=" + encode);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://phantom.app/ul/v1/signAndSendTransaction?dapp_encryption_public_key=" + str2 + "&nonce=" + str + "&redirect_link=" + this.redirect_link_pago + "&payload=" + encode)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Log.e("phantom", "finish");
        finish();
    }
}
