package stikerwap.appdys;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.MimeTypeMap;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.net.MailTo;
import androidx.fragment.app.Fragment;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.vungle.ads.internal.model.AdPayload;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

public class t_detalle_fr extends Fragment implements View.OnClickListener {
    cargardetalle cd;
    cargarfotogrande cfg;
    /* access modifiers changed from: private */
    public String[] cols = {"_id", "ref", "titulo", "descr", "idcat", "precio", "precio_descr", "url_compra", "img1_p", "img1_id", "img1_url", "det_cargado", "anyo", "mes", "dia"};
    cargarthumbs ct;
    String fotoscargadas = "0";
    config globales;
    /* access modifiers changed from: private */
    public long idprod_global;
    long idusu;
    boolean limpiar_hist = true;
    boolean linksexternos = false;
    /* access modifiers changed from: private */
    public FrameLayout ll = null;
    private boolean pb_inverse;
    boolean primera = true;
    /* access modifiers changed from: private */
    public ProgressBar progess_2;
    String ref;
    private RelativeLayout rl_web;
    float scale;
    SharedPreferences settings;
    String titulo;
    String url_compra;
    boolean url_compra_espp = false;
    String url_global;
    private View v = null;
    private WebView viewer = null;
    int w_global;

    public t_detalle_fr() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        config config = (config) getActivity().getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        this.pb_inverse = false;
        if (!this.globales.c_prods_det.equals("")) {
            if (config.esClaro("#" + this.globales.c_prods_det)) {
                this.pb_inverse = true;
            }
        }
        this.linksexternos = this.globales.prods_linksexternos;
        float f = getResources().getDisplayMetrics().density;
        this.scale = f;
        this.w_global = (int) ((f * 100.0f) + 0.5f);
        View inflate = layoutInflater.inflate(R.layout.detalle, viewGroup, false);
        this.v = inflate;
        this.rl_web = (RelativeLayout) inflate.findViewById(R.id.rl_web);
        WebView webView = (WebView) this.v.findViewById(R.id.ll_det_web);
        this.viewer = webView;
        webView.setWebChromeClient(new WebChromeClient() {
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                jsResult.confirm();
                return true;
            }

            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                callback.invoke(str, true, false);
            }
        });
        wv_set();
        this.viewer.getSettings().setBuiltInZoomControls(true);
        this.viewer.getSettings().setSupportZoom(true);
        this.viewer.getSettings().setDomStorageEnabled(true);
        this.viewer.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        this.viewer.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                t_detalle_fr.this.startActivity(intent);
            }
        });
        if (this.globales.prods_adaptar_ancho) {
            this.viewer.getSettings().setUseWideViewPort(true);
            this.viewer.getSettings().setLoadWithOverviewMode(true);
        }
        final ProgressBar progressBar = (ProgressBar) this.v.findViewById(R.id.pb_url);
        if (this.pb_inverse) {
            this.progess_2 = (ProgressBar) this.v.findViewById(R.id.pb_det_inverse);
        } else {
            this.progess_2 = (ProgressBar) this.v.findViewById(R.id.pb_det);
        }
        if (Build.VERSION.SDK_INT > 20) {
            config.progress_color(progressBar, this.globales.c_icos);
            config.progress_color(this.progess_2, this.globales.c_icos);
        }
        this.viewer.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                progressBar.setVisibility(0);
            }

            public void onPageFinished(WebView webView, String str) {
                progressBar.setVisibility(8);
                if (t_detalle_fr.this.limpiar_hist) {
                    webView.clearHistory();
                    t_detalle_fr.this.limpiar_hist = false;
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return t_detalle_fr.this.tratar_url(str, true);
            }
        });
        this.viewer.getSettings().setJavaScriptEnabled(true);
        this.viewer.getSettings().setPluginState(WebSettings.PluginState.ON);
        WebSettings settings2 = this.viewer.getSettings();
        settings2.setUserAgentString(this.viewer.getSettings().getUserAgentString() + " Vinebre");
        this.ll = (FrameLayout) this.v.findViewById(R.id.ll_det_cont);
        return this.v;
    }

    /* access modifiers changed from: private */
    public boolean tratar_url(String str, boolean z) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11 = str;
        String lowerCase = str.toLowerCase();
        String[] strArr = {"doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "pages", "ai", "psd", "tiff", "dxf", "svg", "eps", "ps", "ttf", "otf", "xps", "zip", "rar"};
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(lowerCase);
        boolean z2 = true;
        if (lowerCase.startsWith("tel:") || lowerCase.startsWith("http://tel:")) {
            if (lowerCase.startsWith("tel:")) {
                str2 = str11.substring(4);
            } else {
                str2 = str11.substring(11);
            }
            if (str2.endsWith("/")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str2)));
        } else if (lowerCase.startsWith(MailTo.MAILTO_SCHEME) || lowerCase.startsWith("http://mailto:")) {
            if (lowerCase.startsWith(MailTo.MAILTO_SCHEME)) {
                str3 = str11.substring(7).trim();
            } else {
                str3 = str11.substring(14).trim();
            }
            if (!str3.equals("")) {
                int indexOf = str3.indexOf("?");
                if (indexOf > 0) {
                    int indexOf2 = str3.indexOf("?subject=");
                    if (indexOf2 != -1) {
                        str5 = str3.substring(indexOf2 + 9).trim();
                        int indexOf3 = str5.indexOf("&body=");
                        if (indexOf3 != -1) {
                            str4 = str5.substring(indexOf3 + 6).trim();
                            str5 = str5.substring(0, indexOf3).trim();
                        } else {
                            str4 = "";
                        }
                    } else {
                        str5 = "";
                        str4 = str5;
                    }
                    str3 = str3.substring(0, indexOf).trim();
                } else {
                    str5 = "";
                    str4 = str5;
                }
                if (str3.endsWith("/")) {
                    str3 = str3.substring(0, str3.length() - 1);
                }
                Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", str3, (String) null));
                if (!str5.equals("")) {
                    try {
                        str5 = URLDecoder.decode(str5, "UTF-8");
                    } catch (Exception unused) {
                    }
                    intent.putExtra("android.intent.extra.SUBJECT", str5);
                }
                if (!str4.equals("")) {
                    try {
                        str4 = URLDecoder.decode(str4, "UTF-8");
                    } catch (Exception unused2) {
                    }
                    intent.putExtra("android.intent.extra.TEXT", str4);
                }
                startActivity(Intent.createChooser(intent, getResources().getString(R.string.enviar_email)));
            }
        } else if (lowerCase.startsWith("smsto:") || lowerCase.startsWith("http://smsto:")) {
            if (lowerCase.startsWith("smsto:")) {
                str6 = str11.substring(6).trim();
            } else {
                str6 = str11.substring(13).trim();
            }
            if (!str6.equals("")) {
                int indexOf4 = str6.indexOf("?");
                if (indexOf4 > 0) {
                    int indexOf5 = str6.indexOf("?body=");
                    if (indexOf5 != -1) {
                        str7 = str6.substring(indexOf5 + 6).trim();
                    } else {
                        str7 = "";
                    }
                    str6 = str6.substring(0, indexOf4).trim();
                } else {
                    str7 = "";
                }
                if (str6.endsWith("/")) {
                    str6 = str6.substring(0, str6.length() - 1);
                }
                Intent intent2 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str6));
                if (!str7.equals("")) {
                    try {
                        str7 = URLDecoder.decode(str7, "UTF-8");
                    } catch (Exception unused3) {
                    }
                    intent2.putExtra("sms_body", str7);
                }
                try {
                    startActivity(intent2);
                } catch (Exception unused4) {
                }
            }
        } else if (lowerCase.startsWith("go:") || lowerCase.startsWith("http://go:")) {
            if (lowerCase.startsWith("go:")) {
                str8 = str11.substring(3);
            } else {
                str8 = str11.substring(10);
            }
            if (str8.endsWith("/")) {
                str8 = str8.substring(0, str8.length() - 1);
            }
            try {
                str8 = URLDecoder.decode(str8, "UTF-8");
            } catch (Exception unused5) {
            }
            boolean z3 = false;
            for (int i = 0; i < this.globales.secciones_a.length; i++) {
                if (this.globales.secciones_a[i].idgo.equalsIgnoreCase(str8)) {
                    startActivityForResult(this.globales.crear_rgi(Integer.valueOf(i), this.viewer.getContext()).i, 0);
                    z3 = true;
                }
            }
            if (!z3) {
                this.primera = false;
            }
            z2 = z3;
        } else if (lowerCase.startsWith("vnd.youtube:")) {
            int indexOf6 = str11.indexOf("?");
            if (indexOf6 > 0) {
                str10 = str11.substring(12, indexOf6);
            } else {
                str10 = str11.substring(12);
            }
            String str12 = "https://www.youtube.com/watch?v=" + str10;
            if (this.linksexternos) {
                this.globales.abrir_ext(this.viewer.getContext(), str12);
            } else {
                this.primera = false;
                Intent intent3 = new Intent(this.viewer.getContext(), t_url.class);
                intent3.putExtra("url", str12);
                startActivityForResult(intent3, 0);
            }
        } else if (lowerCase.endsWith(".mp3")) {
            Intent intent4 = new Intent("android.intent.action.VIEW");
            intent4.setDataAndType(Uri.parse(str), "audio/*");
            startActivity(intent4);
        } else if (lowerCase.endsWith(".mp4") || lowerCase.endsWith(".3gp")) {
            Intent intent5 = new Intent("android.intent.action.VIEW");
            intent5.setDataAndType(Uri.parse(str), "video/*");
            startActivity(intent5);
        } else if (lowerCase.startsWith("upi://")) {
            startActivity(Intent.createChooser(new Intent("android.intent.action.VIEW", Uri.parse(str)), getResources().getString(R.string.selecciona)));
        } else if (this.linksexternos || lowerCase.startsWith("rtsp://") || lowerCase.startsWith("rtmp://") || lowerCase.startsWith("market://") || lowerCase.endsWith(".apk") || lowerCase.startsWith("whatsapp://") || lowerCase.endsWith(".m3u") || lowerCase.endsWith(".m3u8")) {
            return this.globales.abrir_ext(this.viewer.getContext(), str11);
        } else {
            if (fileExtensionFromUrl == null || fileExtensionFromUrl.equals("") || !Arrays.asList(strArr).contains(fileExtensionFromUrl) || lowerCase.contains("docs.google.com")) {
                this.primera = false;
                z2 = false;
            } else if (!z || !this.viewer.getUrl().contains("docs.google.com")) {
                try {
                    str9 = URLEncoder.encode(str11, "utf-8");
                } catch (Exception unused6) {
                    str9 = str11;
                }
                String str13 = "https://docs.google.com/viewer?embedded=true&url=" + str9;
                if (z) {
                    this.viewer.loadUrl(str13);
                } else {
                    Intent intent6 = new Intent(this.viewer.getContext(), t_url.class);
                    intent6.putExtra("url", str13);
                    startActivityForResult(intent6, 0);
                }
                this.primera = false;
            } else {
                this.globales.abrir_ext(this.viewer.getContext(), str11);
            }
        }
        if (!z && !z2) {
            Intent intent7 = new Intent(this.viewer.getContext(), t_url.class);
            intent7.putExtra("url", str11);
            startActivityForResult(intent7, 0);
        }
        return z2;
    }

    public void actContenido(String str, long j) {
        String str2 = str;
        long j2 = j;
        this.idprod_global = j2;
        if (this.v != null) {
            this.primera = true;
            this.limpiar_hist = true;
            if (!str2.equals("")) {
                this.ll.setVisibility(8);
                this.viewer.loadUrl(str2);
                this.rl_web.setVisibility(0);
                return;
            }
            this.rl_web.setVisibility(8);
            SQLiteDatabase readableDatabase = new bd(getActivity()).getReadableDatabase();
            if (readableDatabase != null) {
                String[] strArr = this.cols;
                Cursor query = readableDatabase.query("productos", strArr, "_id=" + j2, (String[]) null, (String) null, (String) null, "_id", "1");
                if (!query.moveToFirst()) {
                    query.close();
                } else if (query.getInt(query.getColumnIndex("det_cargado")) == 1) {
                    mostrar_prod(query);
                    query.close();
                } else {
                    query.close();
                    cargardetalle cargardetalle2 = this.cd;
                    if (!(cargardetalle2 == null || cargardetalle2.getStatus() == AsyncTask.Status.FINISHED)) {
                        this.cd.cancel(true);
                    }
                    cargardetalle cargardetalle3 = new cargardetalle();
                    this.cd = cargardetalle3;
                    cargardetalle3.execute(new String[0]);
                }
            }
            readableDatabase.close();
            this.ll.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x04a5  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x04df  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0541  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x05b2  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x05e7 A[LOOP:1: B:133:0x05e7->B:135:0x05ed, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0364  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0406  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x042c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mostrar_prod(android.database.Cursor r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "/"
            java.lang.String r3 = "utf-8"
            java.lang.String r4 = "ref"
            int r4 = r1.getColumnIndex(r4)
            java.lang.String r4 = r1.getString(r4)
            r0.ref = r4
            android.widget.FrameLayout r4 = r0.ll
            r5 = 2131363408(0x7f0a0650, float:1.8346624E38)
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r5 = 8
            r4.setVisibility(r5)
            java.lang.String r6 = r0.ref
            java.lang.String r7 = ""
            boolean r6 = r6.equals(r7)
            java.lang.String r8 = "#"
            r9 = 0
            if (r6 != 0) goto L_0x005a
            java.lang.String r6 = r0.ref
            r4.setText(r6)
            stikerwap.appdys.config r6 = r0.globales
            java.lang.String r6 = r6.c_txt_prods
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0057
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            stikerwap.appdys.config r10 = r0.globales
            java.lang.String r10 = r10.c_txt_prods
            r6.append(r10)
            java.lang.String r6 = r6.toString()
            int r6 = android.graphics.Color.parseColor(r6)
            r4.setTextColor(r6)
        L_0x0057:
            r4.setVisibility(r9)
        L_0x005a:
            java.lang.String r4 = "titulo"
            int r4 = r1.getColumnIndex(r4)
            java.lang.String r4 = r1.getString(r4)
            r0.titulo = r4
            android.widget.FrameLayout r4 = r0.ll
            r6 = 2131363409(0x7f0a0651, float:1.8346626E38)
            android.view.View r4 = r4.findViewById(r6)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r6 = r0.titulo
            r4.setText(r6)
            stikerwap.appdys.config r6 = r0.globales
            java.lang.String r6 = r6.c_tit_prods_l
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0097
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            stikerwap.appdys.config r10 = r0.globales
            java.lang.String r10 = r10.c_tit_prods_l
            r6.append(r10)
            java.lang.String r6 = r6.toString()
            int r6 = android.graphics.Color.parseColor(r6)
            r4.setTextColor(r6)
        L_0x0097:
            android.widget.FrameLayout r4 = r0.ll
            r6 = 2131363404(0x7f0a064c, float:1.8346616E38)
            android.view.View r4 = r4.findViewById(r6)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r5)
            java.lang.String r6 = "anyo"
            int r6 = r1.getColumnIndex(r6)
            int r6 = r1.getInt(r6)
            java.lang.String r10 = "0"
            if (r6 == 0) goto L_0x01b4
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r6)
            r13.append(r7)
            java.lang.String r13 = r13.toString()
            java.lang.String r14 = "mes"
            int r14 = r1.getColumnIndex(r14)
            int r14 = r1.getInt(r14)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r14)
            r15.append(r7)
            java.lang.String r15 = r15.toString()
            boolean r16 = r15.equals(r10)
            java.lang.String r17 = "1"
            if (r16 == 0) goto L_0x00e5
            r15 = r17
        L_0x00e5:
            java.lang.String r11 = "dia"
            int r11 = r1.getColumnIndex(r11)
            int r11 = r1.getInt(r11)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r11)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            boolean r18 = r5.equals(r10)
            if (r18 == 0) goto L_0x0106
            r5 = r17
        L_0x0106:
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ Exception -> 0x012b }
            r12 = 3
            java.text.DateFormat r9 = java.text.DateFormat.getDateInstance(r12, r9)     // Catch:{ Exception -> 0x012b }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012b }
            r12.<init>()     // Catch:{ Exception -> 0x012b }
            r12.append(r15)     // Catch:{ Exception -> 0x012b }
            r12.append(r2)     // Catch:{ Exception -> 0x012b }
            r12.append(r5)     // Catch:{ Exception -> 0x012b }
            r12.append(r2)     // Catch:{ Exception -> 0x012b }
            r12.append(r13)     // Catch:{ Exception -> 0x012b }
            java.lang.String r2 = r12.toString()     // Catch:{ Exception -> 0x012b }
            java.util.Date r2 = r9.parse(r2)     // Catch:{ Exception -> 0x012b }
            r5 = 1
            goto L_0x012e
        L_0x012b:
            r2 = 0
            r5 = 0
        L_0x012e:
            if (r5 == 0) goto L_0x01b4
            if (r14 != 0) goto L_0x0142
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            goto L_0x018c
        L_0x0142:
            if (r11 != 0) goto L_0x0184
            java.util.Locale r5 = java.util.Locale.getDefault()
            r9 = 1
            java.lang.Object[] r11 = new java.lang.Object[r9]
            r12 = 0
            r11[r12] = r2
            java.lang.String r2 = "%tB"
            java.lang.String r2 = java.lang.String.format(r5, r2, r11)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r11 = r2.substring(r12, r9)
            java.lang.String r11 = r11.toUpperCase()
            r5.append(r11)
            java.lang.String r2 = r2.substring(r9)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            java.lang.String r2 = ", "
            r5.append(r2)
            r5.append(r6)
            java.lang.String r2 = r5.toString()
            goto L_0x018c
        L_0x0184:
            java.text.DateFormat r5 = java.text.DateFormat.getDateInstance()
            java.lang.String r2 = r5.format(r2)
        L_0x018c:
            r4.setText(r2)
            stikerwap.appdys.config r2 = r0.globales
            java.lang.String r2 = r2.c_antiguedad_prods_l
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x01b0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_antiguedad_prods_l
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            int r2 = android.graphics.Color.parseColor(r2)
            r4.setTextColor(r2)
        L_0x01b0:
            r2 = 0
            r4.setVisibility(r2)
        L_0x01b4:
            android.widget.FrameLayout r2 = r0.ll
            r4 = 2131363406(0x7f0a064e, float:1.834662E38)
            android.view.View r2 = r2.findViewById(r4)
            android.widget.TextView r2 = (android.widget.TextView) r2
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_txt_prods
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x01e0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r8)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_txt_prods
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            int r4 = android.graphics.Color.parseColor(r4)
            r2.setTextColor(r4)
        L_0x01e0:
            android.content.res.Resources r4 = r19.getResources()
            r5 = 2131034118(0x7f050006, float:1.7678745E38)
            boolean r4 = r4.getBoolean(r5)
            if (r4 == 0) goto L_0x01f1
            r4 = 4
            r2.setTextDirection(r4)
        L_0x01f1:
            java.lang.String r4 = "descr"
            int r4 = r1.getColumnIndex(r4)
            java.lang.String r4 = r1.getString(r4)
            r5 = 1
            r0.tratar_tv(r2, r4, r5)
            android.widget.FrameLayout r2 = r0.ll
            r4 = 2131363407(0x7f0a064f, float:1.8346622E38)
            android.view.View r2 = r2.findViewById(r4)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r4 = 8
            r2.setVisibility(r4)
            java.lang.String r4 = "precio"
            int r5 = r1.getColumnIndex(r4)
            boolean r5 = r1.isNull(r5)
            if (r5 != 0) goto L_0x034d
            r5 = 0
            int r4 = r1.getColumnIndex(r4)     // Catch:{ Exception -> 0x0227 }
            double r11 = r1.getDouble(r4)     // Catch:{ Exception -> 0x0227 }
            r4 = 1
            goto L_0x022a
        L_0x0227:
            r11 = r5
            r4 = 0
        L_0x022a:
            if (r4 == 0) goto L_0x034d
            r4 = 2
            int r9 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r9 <= 0) goto L_0x0252
            java.text.DecimalFormatSymbols r5 = new java.text.DecimalFormatSymbols
            r5.<init>()
            r6 = 46
            r5.setDecimalSeparator(r6)
            java.text.DecimalFormat r6 = new java.text.DecimalFormat
            r6.<init>()
            r9 = 0
            r6.setGroupingUsed(r9)
            r6.setMinimumFractionDigits(r4)
            r6.setMaximumFractionDigits(r4)
            r6.setDecimalFormatSymbols(r5)
            java.lang.String r5 = r6.format(r11)
            goto L_0x0253
        L_0x0252:
            r5 = r7
        L_0x0253:
            java.text.DecimalFormat r6 = new java.text.DecimalFormat
            r6.<init>()
            java.util.Locale r9 = java.util.Locale.getDefault()
            java.util.Currency r9 = java.util.Currency.getInstance(r9)
            r6.setCurrency(r9)
            java.lang.String r6 = r6.format(r11)
            int r9 = r6.length()
            java.lang.String r11 = "."
            r12 = 1
            if (r9 <= r12) goto L_0x029b
            int r9 = r6.length()
            int r9 = r9 - r4
            int r4 = r6.length()
            int r4 = r4 - r12
            java.lang.String r4 = r6.substring(r9, r4)
            java.lang.String r9 = ","
            boolean r9 = r4.equals(r9)
            if (r9 != 0) goto L_0x028c
            boolean r4 = r4.equals(r11)
            if (r4 == 0) goto L_0x029b
        L_0x028c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            r4.append(r10)
            java.lang.String r6 = r4.toString()
        L_0x029b:
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.divisa
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x02b5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            r4.append(r11)
            java.lang.String r4 = r4.toString()
            goto L_0x02da
        L_0x02b5:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r9 = "&nbsp;"
            r6.<init>(r9)
            stikerwap.appdys.config r9 = r0.globales
            java.lang.String r9 = r9.divisa
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            android.text.Spanned r6 = android.text.Html.fromHtml(r6)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
        L_0x02da:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            java.lang.String r4 = " "
            r6.append(r4)
            java.lang.String r4 = "precio_descr"
            int r4 = r1.getColumnIndex(r4)
            java.lang.String r4 = r1.getString(r4)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.String r4 = r4.trim()
            android.text.Spanned r4 = android.text.Html.fromHtml(r4)
            r2.setText(r4)
            stikerwap.appdys.config r4 = r0.globales
            java.lang.String r4 = r4.c_precio_prods_l
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0348
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r8)
            stikerwap.appdys.config r6 = r0.globales
            java.lang.String r6 = r6.c_precio_prods_l
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            int r4 = android.graphics.Color.parseColor(r4)
            r2.setTextColor(r4)
            android.content.res.Resources r4 = r19.getResources()
            r6 = 2131231629(0x7f08038d, float:1.8079344E38)
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            stikerwap.appdys.config r9 = r0.globales
            java.lang.String r9 = r9.c_precio_prods_l
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            int r6 = android.graphics.Color.parseColor(r6)
            android.graphics.PorterDuff$Mode r9 = android.graphics.PorterDuff.Mode.MULTIPLY
            r4.setColorFilter(r6, r9)
        L_0x0348:
            r4 = 0
            r2.setVisibility(r4)
            goto L_0x034e
        L_0x034d:
            r5 = r7
        L_0x034e:
            r0.url_compra = r7
            stikerwap.appdys.config r2 = r0.globales
            java.lang.String r2 = r2.pp_email
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x0406
            stikerwap.appdys.config r2 = r0.globales
            java.lang.String r2 = r2.pp_divisa
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x0406
            boolean r2 = r5.equals(r7)
            if (r2 != 0) goto L_0x0412
            r2 = 1
            r0.url_compra_espp = r2
            stikerwap.appdys.config r2 = r0.globales
            java.lang.String r2 = r2.pp_email
            stikerwap.appdys.config r4 = r0.globales     // Catch:{ Exception -> 0x0379 }
            java.lang.String r4 = r4.pp_email     // Catch:{ Exception -> 0x0379 }
            java.lang.String r2 = java.net.URLEncoder.encode(r4, r3)     // Catch:{ Exception -> 0x0379 }
        L_0x0379:
            java.lang.String r4 = r0.titulo
            java.lang.String r4 = java.net.URLEncoder.encode(r4, r3)     // Catch:{ Exception -> 0x037f }
        L_0x037f:
            java.lang.String r6 = r0.ref
            java.lang.String r6 = java.net.URLEncoder.encode(r6, r3)     // Catch:{ Exception -> 0x0386 }
            goto L_0x0387
        L_0x0386:
        L_0x0387:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "https://www.paypal.com/cgi-bin/webscr/?rm=2&cmd=_xclick&business="
            r9.<init>(r10)
            r9.append(r2)
            java.lang.String r2 = "&item_name="
            r9.append(r2)
            int r2 = r4.length()
            r10 = 127(0x7f, float:1.78E-43)
            int r2 = java.lang.Math.min(r2, r10)
            r11 = 0
            java.lang.String r2 = r4.substring(r11, r2)
            r9.append(r2)
            java.lang.String r2 = "&item_number="
            r9.append(r2)
            int r2 = r6.length()
            int r2 = java.lang.Math.min(r2, r10)
            java.lang.String r2 = r6.substring(r11, r2)
            r9.append(r2)
            java.lang.String r2 = "&amount="
            r9.append(r2)
            r9.append(r5)
            java.lang.String r2 = "&no_shipping=0&no_note=1&currency_code="
            r9.append(r2)
            stikerwap.appdys.config r2 = r0.globales
            java.lang.String r2 = r2.pp_divisa
            r9.append(r2)
            java.lang.String r2 = "&bn=PP-BuyNowBF"
            r9.append(r2)
            java.lang.String r2 = r9.toString()
            r0.url_compra = r2
            boolean r2 = r0.linksexternos
            if (r2 != 0) goto L_0x0412
            java.lang.String r2 = "https://closethis"
            java.lang.String r2 = java.net.URLEncoder.encode(r2, r3)     // Catch:{ Exception -> 0x03e5 }
        L_0x03e5:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r0.url_compra
            r3.append(r4)
            java.lang.String r4 = "&return="
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = "&cancel_return="
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.url_compra = r2
            goto L_0x0412
        L_0x0406:
            java.lang.String r2 = "url_compra"
            int r2 = r1.getColumnIndex(r2)
            java.lang.String r2 = r1.getString(r2)
            r0.url_compra = r2
        L_0x0412:
            android.widget.FrameLayout r2 = r0.ll
            r3 = 2131361976(0x7f0a00b8, float:1.834372E38)
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 8
            r2.setVisibility(r3)
            java.lang.String r3 = r0.url_compra
            boolean r3 = r3.equals(r7)
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            if (r3 != 0) goto L_0x047e
            stikerwap.appdys.config r3 = r0.globales
            java.lang.String r3 = r3.c_icos_2_prods
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0466
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r8)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_icos_2_prods
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            int r3 = android.graphics.Color.parseColor(r3)
            r2.setBackgroundColor(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r8)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_icos_2_prods
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            boolean r3 = stikerwap.appdys.config.esClaro(r3)
            if (r3 == 0) goto L_0x0466
            r2.setTextColor(r4)
        L_0x0466:
            stikerwap.appdys.config r3 = r0.globales
            java.lang.String r3 = r3.prods_comprar
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0477
            stikerwap.appdys.config r3 = r0.globales
            java.lang.String r3 = r3.prods_comprar
            r2.setText(r3)
        L_0x0477:
            r2.setOnClickListener(r0)
            r3 = 0
            r2.setVisibility(r3)
        L_0x047e:
            android.widget.FrameLayout r2 = r0.ll
            r3 = 2131361977(0x7f0a00b9, float:1.8343722E38)
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 8
            r2.setVisibility(r3)
            stikerwap.appdys.config r3 = r0.globales
            stikerwap.appdys.Oficina[] r3 = r3.oficinas_a
            int r3 = r3.length
            if (r3 <= 0) goto L_0x04ed
            stikerwap.appdys.config r3 = r0.globales
            boolean r3 = r3.prods_masinfo_mostrar
            if (r3 == 0) goto L_0x04ed
            stikerwap.appdys.config r3 = r0.globales
            java.lang.String r3 = r3.c_icos_2_prods
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x04d5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r8)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_icos_2_prods
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            int r3 = android.graphics.Color.parseColor(r3)
            r2.setBackgroundColor(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r8)
            stikerwap.appdys.config r5 = r0.globales
            java.lang.String r5 = r5.c_icos_2_prods
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            boolean r3 = stikerwap.appdys.config.esClaro(r3)
            if (r3 == 0) goto L_0x04d5
            r2.setTextColor(r4)
        L_0x04d5:
            stikerwap.appdys.config r3 = r0.globales
            java.lang.String r3 = r3.prods_masinfo
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x04e6
            stikerwap.appdys.config r3 = r0.globales
            java.lang.String r3 = r3.prods_masinfo
            r2.setText(r3)
        L_0x04e6:
            r2.setOnClickListener(r0)
            r3 = 0
            r2.setVisibility(r3)
        L_0x04ed:
            android.widget.FrameLayout r2 = r0.ll
            r3 = 2131362588(0x7f0a031c, float:1.834496E38)
            android.view.View r2 = r2.findViewById(r3)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r2.removeAllViews()
            stikerwap.appdys.bd r2 = new stikerwap.appdys.bd
            androidx.fragment.app.FragmentActivity r4 = r19.getActivity()
            r2.<init>(r4)
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "SELECT img1_id AS id FROM productos WHERE (_id="
            r4.<init>(r5)
            long r5 = r0.idprod_global
            r4.append(r5)
            java.lang.String r5 = ") AND img1_id>0 UNION SELECT _id AS id FROM fotos WHERE (idprod="
            r4.append(r5)
            long r5 = r0.idprod_global
            r4.append(r5)
            java.lang.String r5 = ")"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r5 = 0
            android.database.Cursor r4 = r2.rawQuery(r4, r5)
            android.widget.RelativeLayout$LayoutParams r5 = new android.widget.RelativeLayout$LayoutParams
            r6 = -2
            r5.<init>(r6, r6)
            android.widget.FrameLayout r6 = r0.ll
            android.view.View r3 = r6.findViewById(r3)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r12 = 0
        L_0x053b:
            int r6 = r4.getCount()
            if (r12 >= r6) goto L_0x05a6
            android.widget.ImageSwitcher r6 = new android.widget.ImageSwitcher
            androidx.fragment.app.FragmentActivity r8 = r19.getActivity()
            r6.<init>(r8)
            r6.setLayoutParams(r5)
            android.view.ViewGroup$LayoutParams r8 = r6.getLayoutParams()
            int r9 = r0.w_global
            r8.width = r9
            android.view.ViewGroup$LayoutParams r8 = r6.getLayoutParams()
            int r9 = r0.w_global
            r8.height = r9
            boolean r8 = r0.pb_inverse
            if (r8 == 0) goto L_0x056f
            android.widget.ProgressBar r8 = new android.widget.ProgressBar
            androidx.fragment.app.FragmentActivity r9 = r19.getActivity()
            r10 = 16843399(0x1010287, float:2.369537E-38)
            r11 = 0
            r8.<init>(r9, r11, r10)
            goto L_0x057c
        L_0x056f:
            r11 = 0
            android.widget.ProgressBar r8 = new android.widget.ProgressBar
            androidx.fragment.app.FragmentActivity r9 = r19.getActivity()
            r10 = 16842871(0x1010077, float:2.3693892E-38)
            r8.<init>(r9, r11, r10)
        L_0x057c:
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 20
            if (r9 <= r10) goto L_0x0589
            stikerwap.appdys.config r9 = r0.globales
            java.lang.String r9 = r9.c_icos
            stikerwap.appdys.config.progress_color(r8, r9)
        L_0x0589:
            r8.setLayoutParams(r5)
            r9 = 1101004800(0x41a00000, float:20.0)
            float r10 = r0.scale
            float r10 = r10 * r9
            r9 = 1056964608(0x3f000000, float:0.5)
            float r10 = r10 + r9
            int r9 = (int) r10
            r8.setPadding(r9, r9, r9, r9)
            r6.addView(r8)
            r3.addView(r6)
            r6 = 0
            r3.setVisibility(r6)
            int r12 = r12 + 1
            goto L_0x053b
        L_0x05a6:
            java.lang.String r3 = "img1_p"
            int r4 = r1.getColumnIndex(r3)
            boolean r4 = r1.isNull(r4)
            if (r4 != 0) goto L_0x05c7
            int r3 = r1.getColumnIndex(r3)
            byte[] r3 = r1.getBlob(r3)
            java.lang.String r4 = "img1_id"
            int r4 = r1.getColumnIndex(r4)
            int r1 = r1.getInt(r4)
            r0.mostrar_foto(r3, r1, r7)
        L_0x05c7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "SELECT _id,img_p FROM fotos WHERE (idprod="
            r1.<init>(r3)
            long r3 = r0.idprod_global
            r1.append(r3)
            java.lang.String r3 = ") AND (img_p IS NOT NULL) ORDER BY orden"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r3 = 0
            android.database.Cursor r1 = r2.rawQuery(r1, r3)
            boolean r3 = r1.moveToFirst()
            if (r3 == 0) goto L_0x0608
        L_0x05e7:
            boolean r3 = r1.isAfterLast()
            if (r3 != 0) goto L_0x0608
            java.lang.String r3 = "img_p"
            int r3 = r1.getColumnIndex(r3)
            byte[] r3 = r1.getBlob(r3)
            java.lang.String r4 = "_id"
            int r4 = r1.getColumnIndex(r4)
            int r4 = r1.getInt(r4)
            r0.mostrar_foto(r3, r4, r7)
            r1.moveToNext()
            goto L_0x05e7
        L_0x0608:
            r1.close()
            r2.close()
            stikerwap.appdys.t_detalle_fr$cargarthumbs r1 = r0.ct
            if (r1 == 0) goto L_0x0620
            android.os.AsyncTask$Status r1 = r1.getStatus()
            android.os.AsyncTask$Status r2 = android.os.AsyncTask.Status.FINISHED
            if (r1 == r2) goto L_0x0620
            stikerwap.appdys.t_detalle_fr$cargarthumbs r1 = r0.ct
            r2 = 1
            r1.cancel(r2)
        L_0x0620:
            stikerwap.appdys.t_detalle_fr$cargarthumbs r1 = new stikerwap.appdys.t_detalle_fr$cargarthumbs
            r2 = 0
            r1.<init>(r2)
            r0.ct = r1
            java.lang.String[] r2 = new java.lang.String[r2]
            r1.execute(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_detalle_fr.mostrar_prod(android.database.Cursor):void");
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!this.globales.c_prods_det.equals("")) {
            View view = getView();
            view.setBackgroundColor(Color.parseColor("#" + this.globales.c_prods_det));
        }
        if (bundle != null) {
            this.viewer.restoreState(bundle);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_det_comprar) {
            if (this.linksexternos) {
                this.globales.abrir_ext(getActivity(), this.url_compra);
                return;
            }
            Intent intent = new Intent(getActivity(), t_url.class);
            intent.putExtra("url", this.url_compra);
            if (this.url_compra_espp) {
                intent.putExtra("loader", false);
                intent.putExtra("linksexternos", false);
                intent.putExtra("adaptar_ancho", false);
            } else {
                intent.putExtra("loader", true);
                intent.putExtra("linksexternos", this.globales.prods_linksexternos);
                intent.putExtra("adaptar_ancho", this.globales.prods_adaptar_ancho);
            }
            startActivityForResult(intent, 0);
        } else if (view.getId() == R.id.btn_det_masinfo) {
            Intent intent2 = this.globales.intent_ofics(getActivity()).i;
            String str = this.titulo;
            if (!this.ref.equals("")) {
                str = str + "(Ref." + this.ref + ")";
            }
            intent2.putExtra("msg_predefinido", str);
            startActivityForResult(intent2, 0);
        } else if (view.getTag(R.id.TAG_IDFOTO) != null) {
            cargarfotogrande cargarfotogrande2 = this.cfg;
            if (!(cargarfotogrande2 == null || cargarfotogrande2.getStatus() == AsyncTask.Status.FINISHED)) {
                try {
                    this.cfg.pb_foto.setVisibility(8);
                } catch (Exception unused) {
                }
                this.cfg.cancel(true);
            }
            cargarfotogrande cargarfotogrande3 = new cargarfotogrande((ImageView) view);
            this.cfg = cargarfotogrande3;
            cargarfotogrande3.execute(new String[0]);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1 && intent != null && intent.hasExtra("finalizar") && intent.getExtras().getBoolean("finalizar")) {
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.rl_web.getVisibility() != 0 || this.primera || i != 4 || !this.viewer.canGoBack()) {
            return false;
        }
        this.viewer.goBack();
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        WebView webView = this.viewer;
        if (webView != null) {
            webView.saveState(bundle);
        }
    }

    private class cargardetalle extends AsyncTask<String, Void, Byte> {
        long idprod;
        String result_http;

        private cargardetalle() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00a2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                java.lang.String r6 = "/srv/prod_detalle.php?v=1&idapp=3008836&idusu="
                r0 = 0
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0095 }
                r1.<init>()     // Catch:{ Exception -> 0x0095 }
                java.lang.String r2 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x0095 }
                r1.append(r2)     // Catch:{ Exception -> 0x0095 }
                r1.append(r6)     // Catch:{ Exception -> 0x0095 }
                stikerwap.appdys.t_detalle_fr r6 = stikerwap.appdys.t_detalle_fr.this     // Catch:{ Exception -> 0x0095 }
                long r2 = r6.idusu     // Catch:{ Exception -> 0x0095 }
                r1.append(r2)     // Catch:{ Exception -> 0x0095 }
                java.lang.String r6 = "&idprod="
                r1.append(r6)     // Catch:{ Exception -> 0x0095 }
                long r2 = r5.idprod     // Catch:{ Exception -> 0x0095 }
                r1.append(r2)     // Catch:{ Exception -> 0x0095 }
                java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x0095 }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0095 }
                r1.<init>(r6)     // Catch:{ Exception -> 0x0095 }
                java.net.URLConnection r6 = r1.openConnection()     // Catch:{ Exception -> 0x0095 }
                java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x0095 }
                r0 = 1
                r6.setDoInput(r0)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                r0 = 10000(0x2710, float:1.4013E-41)
                r6.setConnectTimeout(r0)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                r6.setReadTimeout(r0)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                java.lang.String r0 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r6.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                java.io.InputStream r0 = r6.getInputStream()     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                r2.<init>(r0)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                r1.<init>(r2)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                r0.<init>()     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            L_0x0056:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                if (r2 == 0) goto L_0x0071
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                r3.<init>()     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                r3.append(r2)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                r0.append(r2)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                goto L_0x0056
            L_0x0071:
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                r5.result_http = r0     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                java.lang.String r1 = "@EURO@"
                java.lang.String r2 = "€"
                java.lang.String r0 = r0.replace(r1, r2)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                r5.result_http = r0     // Catch:{ Exception -> 0x008e, all -> 0x008c }
                if (r6 == 0) goto L_0x0086
                r6.disconnect()
            L_0x0086:
                r6 = 0
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)
                return r6
            L_0x008c:
                r0 = move-exception
                goto L_0x00a0
            L_0x008e:
                r0 = r6
                goto L_0x0095
            L_0x0090:
                r6 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x00a0
            L_0x0095:
                r6 = -1
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch:{ all -> 0x0090 }
                if (r0 == 0) goto L_0x009f
                r0.disconnect()
            L_0x009f:
                return r6
            L_0x00a0:
                if (r6 == 0) goto L_0x00a5
                r6.disconnect()
            L_0x00a5:
                goto L_0x00a7
            L_0x00a6:
                throw r0
            L_0x00a7:
                goto L_0x00a6
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_detalle_fr.cargardetalle.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            t_detalle_fr.this.ll.findViewById(R.id.sv_det).setVisibility(8);
            t_detalle_fr.this.progess_2.setVisibility(0);
            this.idprod = t_detalle_fr.this.idprod_global;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            if (t_detalle_fr.this.getActivity() != null) {
                if (b.byteValue() == 0 && !this.result_http.contains("-KO-")) {
                    String[] split = this.result_http.split(",");
                    ContentValues contentValues = new ContentValues();
                    if (!split[0].trim().equals("0")) {
                        contentValues.put("ref", split[0].trim().replace("@x@", ","));
                    }
                    if (!split[1].trim().equals("0")) {
                        contentValues.put("descr", split[1].trim().replace("@x@", ","));
                    }
                    contentValues.put("idcat", split[2].trim());
                    if (!split[3].trim().equals("0")) {
                        contentValues.put("precio_descr", split[3].trim().replace("@x@", ","));
                    }
                    if (!split[4].trim().equals("0")) {
                        contentValues.put("url_compra", split[4].trim().replace("@x@", ","));
                    }
                    contentValues.put("det_cargado", 1);
                    ContentResolver contentResolver = t_detalle_fr.this.getActivity().getContentResolver();
                    Uri uri = bd_provider.PRODUCTOS_URI;
                    contentResolver.update(uri, contentValues, "_id=" + this.idprod, (String[]) null);
                    if (!split[5].equals("0")) {
                        String[] split2 = split[5].split("@z@");
                        for (int i = 0; i < split2.length; i++) {
                            String[] split3 = split2[i].split(";");
                            contentValues.clear();
                            contentValues.put("_id", split3[0]);
                            contentValues.put("idprod", Long.valueOf(this.idprod));
                            String replace = split3[1].replace("@y@", ";").replace("@x@", ",");
                            if (replace.equals("0")) {
                                replace = "";
                            }
                            contentValues.put("url", replace);
                            contentValues.put("orden", Integer.valueOf(i));
                            t_detalle_fr.this.getActivity().getContentResolver().insert(bd_provider.FOTOS_URI, contentValues);
                        }
                    }
                    if (this.idprod == t_detalle_fr.this.idprod_global) {
                        SQLiteDatabase readableDatabase = new bd(t_detalle_fr.this.getActivity()).getReadableDatabase();
                        if (readableDatabase != null) {
                            String[] r14 = t_detalle_fr.this.cols;
                            Cursor query = readableDatabase.query("productos", r14, "_id=" + this.idprod, (String[]) null, (String) null, (String) null, "_id", "1");
                            if (query.moveToFirst()) {
                                t_detalle_fr.this.mostrar_prod(query);
                            }
                            query.close();
                        }
                        readableDatabase.close();
                    }
                }
                t_detalle_fr.this.progess_2.setVisibility(8);
                t_detalle_fr.this.ll.findViewById(R.id.sv_det).setVisibility(0);
            }
        }
    }

    private class cargarthumbs extends AsyncTask<String, Void, Byte> {
        byte[] bitmapdata;
        String id_fotoacargar;
        long idprod;
        int nintento;
        int tipo;
        String url_foto;

        public cargarthumbs(int i) {
            this.nintento = i;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.idprod = t_detalle_fr.this.idprod_global;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r9) {
            /*
                r8 = this;
                stikerwap.appdys.t_detalle_fr r9 = stikerwap.appdys.t_detalle_fr.this
                androidx.fragment.app.FragmentActivity r9 = r9.getActivity()
                r0 = -1
                java.lang.Byte r0 = java.lang.Byte.valueOf(r0)
                if (r9 != 0) goto L_0x000e
                return r0
            L_0x000e:
                java.lang.String r9 = "0"
                r8.id_fotoacargar = r9
                stikerwap.appdys.bd r1 = new stikerwap.appdys.bd
                stikerwap.appdys.t_detalle_fr r2 = stikerwap.appdys.t_detalle_fr.this
                androidx.fragment.app.FragmentActivity r2 = r2.getActivity()
                r1.<init>(r2)
                android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()
                java.lang.String r2 = ""
                r3 = 0
                if (r1 == 0) goto L_0x0097
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r5 = "SELECT 1 AS tipo,img1_id AS id,0 AS orden,img1_url AS url FROM productos WHERE (_id="
                r4.<init>(r5)
                stikerwap.appdys.t_detalle_fr r5 = stikerwap.appdys.t_detalle_fr.this
                long r5 = r5.idprod_global
                r4.append(r5)
                java.lang.String r5 = ") AND (img1_id NOT IN ("
                r4.append(r5)
                stikerwap.appdys.t_detalle_fr r5 = stikerwap.appdys.t_detalle_fr.this
                java.lang.String r5 = r5.fotoscargadas
                r4.append(r5)
                java.lang.String r5 = ")) AND (img1_p IS NULL) UNION SELECT 2 AS tipo,_id AS id,orden,url FROM fotos WHERE (idprod="
                r4.append(r5)
                stikerwap.appdys.t_detalle_fr r5 = stikerwap.appdys.t_detalle_fr.this
                long r5 = r5.idprod_global
                r4.append(r5)
                java.lang.String r5 = ") AND (_id NOT IN ("
                r4.append(r5)
                stikerwap.appdys.t_detalle_fr r5 = stikerwap.appdys.t_detalle_fr.this
                java.lang.String r5 = r5.fotoscargadas
                r4.append(r5)
                java.lang.String r5 = ")) AND (img_p IS NULL) ORDER BY orden"
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                android.database.Cursor r4 = r1.rawQuery(r4, r3)
                boolean r5 = r4.moveToFirst()
                if (r5 == 0) goto L_0x0092
                java.lang.String r5 = "id"
                int r5 = r4.getColumnIndex(r5)
                java.lang.String r5 = r4.getString(r5)
                r8.id_fotoacargar = r5
                java.lang.String r5 = "tipo"
                int r5 = r4.getColumnIndex(r5)
                int r5 = r4.getInt(r5)
                r8.tipo = r5
                java.lang.String r5 = "url"
                int r5 = r4.getColumnIndex(r5)
                java.lang.String r5 = r4.getString(r5)
                goto L_0x0093
            L_0x0092:
                r5 = r2
            L_0x0093:
                r4.close()
                goto L_0x0098
            L_0x0097:
                r5 = r2
            L_0x0098:
                r1.close()
                java.lang.String r1 = r8.id_fotoacargar
                boolean r9 = r1.equals(r9)
                r1 = 1
                if (r9 == 0) goto L_0x00a9
                java.lang.Byte r9 = java.lang.Byte.valueOf(r1)
                return r9
            L_0x00a9:
                r8.url_foto = r5
                boolean r9 = r5.equals(r2)
                if (r9 == 0) goto L_0x0105
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r2 = stikerwap.appdys.config.DOM_SRV
                r9.append(r2)
                java.lang.String r2 = "/srv/imgs/prods/"
                r9.append(r2)
                java.lang.String r4 = r8.id_fotoacargar
                r9.append(r4)
                java.lang.String r4 = "_"
                r9.append(r4)
                stikerwap.appdys.t_detalle_fr r5 = stikerwap.appdys.t_detalle_fr.this
                long r5 = r5.idprod_global
                r9.append(r5)
                java.lang.String r5 = "_p.png"
                r9.append(r5)
                java.lang.String r5 = r9.toString()
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r6 = stikerwap.appdys.config.DOM_SRV
                r9.append(r6)
                r9.append(r2)
                java.lang.String r2 = r8.id_fotoacargar
                r9.append(r2)
                r9.append(r4)
                stikerwap.appdys.t_detalle_fr r2 = stikerwap.appdys.t_detalle_fr.this
                long r6 = r2.idprod_global
                r9.append(r6)
                java.lang.String r2 = ".png"
                r9.append(r2)
                java.lang.String r9 = r9.toString()
                r8.url_foto = r9
            L_0x0105:
                java.net.URL r9 = new java.net.URL     // Catch:{ MalformedURLException -> 0x017d }
                r9.<init>(r5)     // Catch:{ MalformedURLException -> 0x017d }
                java.net.URLConnection r2 = r9.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{  }
                r2.setDoInput(r1)     // Catch:{  }
                r4 = 5000(0x1388, float:7.006E-42)
                r2.setConnectTimeout(r4)     // Catch:{  }
                r5 = 7000(0x1b58, float:9.809E-42)
                r2.setReadTimeout(r5)     // Catch:{  }
                r2.connect()     // Catch:{  }
                java.io.InputStream r6 = r2.getInputStream()     // Catch:{  }
                android.graphics.BitmapFactory$Options r7 = new android.graphics.BitmapFactory$Options     // Catch:{  }
                r7.<init>()     // Catch:{  }
                r7.inJustDecodeBounds = r1     // Catch:{  }
                android.graphics.BitmapFactory.decodeStream(r6, r3, r7)     // Catch:{  }
                r6.close()     // Catch:{  }
                r2.disconnect()     // Catch:{  }
                stikerwap.appdys.t_detalle_fr r2 = stikerwap.appdys.t_detalle_fr.this     // Catch:{  }
                stikerwap.appdys.config r2 = r2.globales     // Catch:{  }
                r2 = 300(0x12c, float:4.2E-43)
                int r2 = stikerwap.appdys.config.calculateInSampleSize(r7, r2, r2)     // Catch:{  }
                r7.inSampleSize = r2     // Catch:{  }
                java.net.URLConnection r9 = r9.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{  }
                r9.setDoInput(r1)     // Catch:{  }
                r9.setConnectTimeout(r4)     // Catch:{  }
                r9.setReadTimeout(r5)     // Catch:{  }
                r9.connect()     // Catch:{  }
                java.io.InputStream r9 = r9.getInputStream()     // Catch:{  }
                r1 = 0
                r7.inJustDecodeBounds = r1     // Catch:{  }
                android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r9, r3, r7)     // Catch:{  }
                r9.close()     // Catch:{  }
                if (r2 != 0) goto L_0x0163
                return r0
            L_0x0163:
                java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream
                r9.<init>()
                android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG
                r3 = 100
                r2.compress(r0, r3, r9)
                byte[] r0 = r9.toByteArray()
                r8.bitmapdata = r0
                r9.close()     // Catch:{ IOException -> 0x0178 }
            L_0x0178:
                java.lang.Byte r9 = java.lang.Byte.valueOf(r1)
                return r9
            L_0x017d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_detalle_fr.cargarthumbs.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            if (t_detalle_fr.this.getActivity() != null) {
                if (b.byteValue() == 0) {
                    ContentValues contentValues = new ContentValues();
                    int i = this.tipo;
                    if (i == 1) {
                        contentValues.put("img1_p", this.bitmapdata);
                        t_detalle_fr.this.getActivity().getContentResolver().update(bd_provider.PRODUCTOS_URI, contentValues, "img1_id='" + this.id_fotoacargar + "'", (String[]) null);
                    } else if (i == 2) {
                        contentValues.put("img_p", this.bitmapdata);
                        t_detalle_fr.this.getActivity().getContentResolver().update(bd_provider.FOTOS_URI, contentValues, "_id='" + this.id_fotoacargar + "'", (String[]) null);
                    }
                    if (this.idprod == t_detalle_fr.this.idprod_global) {
                        StringBuilder sb = new StringBuilder();
                        t_detalle_fr t_detalle_fr = t_detalle_fr.this;
                        sb.append(t_detalle_fr.fotoscargadas);
                        sb.append(",");
                        sb.append(this.id_fotoacargar);
                        t_detalle_fr.fotoscargadas = sb.toString();
                        t_detalle_fr.this.mostrar_foto(this.bitmapdata, Integer.parseInt(this.id_fotoacargar), this.url_foto);
                    }
                }
                if (b.byteValue() != 1 && this.idprod == t_detalle_fr.this.idprod_global) {
                    if (b.byteValue() == -1) {
                        this.nintento++;
                    } else {
                        this.nintento = 0;
                    }
                    int i2 = this.nintento;
                    if (i2 < 3) {
                        t_detalle_fr t_detalle_fr2 = t_detalle_fr.this;
                        t_detalle_fr2.ct = new cargarthumbs(i2);
                        t_detalle_fr.this.ct.execute(new String[0]);
                    }
                }
            }
        }
    }

    private class cargarfotogrande extends AsyncTask<String, Void, Byte> {
        byte[] bitmapdata;
        boolean guardar_foto = false;
        String id_fotoacargar;
        public ProgressBar pb_foto;
        int tipo;

        public cargarfotogrande(ImageView imageView) {
            this.id_fotoacargar = ((Integer) imageView.getTag(R.id.TAG_IDFOTO)) + "";
            this.pb_foto = (ProgressBar) ((RelativeLayout) imageView.getParent()).getChildAt(1);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            boolean z;
            this.bitmapdata = null;
            SQLiteDatabase readableDatabase = new bd(t_detalle_fr.this.getActivity()).getReadableDatabase();
            if (readableDatabase != null) {
                Cursor rawQuery = readableDatabase.rawQuery("SELECT 1 AS tipo,img1_url AS url,img1 AS img,img1_p AS img_p FROM productos WHERE img1_id=" + this.id_fotoacargar + " UNION SELECT 2 AS tipo,url,img,img_p FROM fotos WHERE _id=" + this.id_fotoacargar, (String[]) null);
                if (rawQuery.moveToFirst()) {
                    if (!rawQuery.isNull(rawQuery.getColumnIndex("img"))) {
                        this.bitmapdata = rawQuery.getBlob(rawQuery.getColumnIndex("img"));
                    } else if (!rawQuery.getString(rawQuery.getColumnIndex("url")).equals("")) {
                        this.bitmapdata = rawQuery.getBlob(rawQuery.getColumnIndex("img_p"));
                    } else {
                        this.tipo = rawQuery.getInt(rawQuery.getColumnIndex("tipo"));
                    }
                }
                rawQuery.close();
            }
            readableDatabase.close();
            if (this.bitmapdata != null) {
                File file = new File(t_detalle_fr.this.getActivity().getFilesDir(), "temp");
                try {
                    FileOutputStream openFileOutput = t_detalle_fr.this.getActivity().openFileOutput("temp", 0);
                    openFileOutput.write(this.bitmapdata);
                    openFileOutput.close();
                    z = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    z = false;
                }
                if (z && file.exists()) {
                    Intent intent = new Intent(t_detalle_fr.this.getActivity(), t_url.class);
                    intent.putExtra("url", AdPayload.FILE_SCHEME + file);
                    intent.putExtra("bg1", t_detalle_fr.this.globales.c_prods_det);
                    intent.putExtra("bg2", t_detalle_fr.this.globales.c_prods_det);
                    t_detalle_fr.this.startActivityForResult(intent, 0);
                }
                cancel(true);
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.pb_foto.setLayoutParams(layoutParams);
            this.pb_foto.setVisibility(0);
        }

        /* access modifiers changed from: protected */
        public Byte doInBackground(String... strArr) {
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(config.DOM_SRV + "/srv/imgs/prods/" + this.id_fotoacargar + "_" + t_detalle_fr.this.idprod_global + ".png").openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(7000);
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                    if (decodeStream == null) {
                        return (byte) -1;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    decodeStream.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    this.bitmapdata = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused) {
                    }
                    this.guardar_foto = true;
                    return (byte) 0;
                } catch (IOException unused2) {
                    return (byte) -1;
                }
            } catch (MalformedURLException unused3) {
                return (byte) -1;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            if (t_detalle_fr.this.getActivity() != null && b.byteValue() == 0) {
                boolean z = true;
                if (this.guardar_foto) {
                    ContentValues contentValues = new ContentValues();
                    int i = this.tipo;
                    if (i == 1) {
                        contentValues.put("img1", this.bitmapdata);
                        ContentResolver contentResolver = t_detalle_fr.this.getActivity().getContentResolver();
                        Uri uri = bd_provider.PRODUCTOS_URI;
                        contentResolver.update(uri, contentValues, "img1_id='" + this.id_fotoacargar + "'", (String[]) null);
                    } else if (i == 2) {
                        contentValues.put("img", this.bitmapdata);
                        ContentResolver contentResolver2 = t_detalle_fr.this.getActivity().getContentResolver();
                        Uri uri2 = bd_provider.FOTOS_URI;
                        contentResolver2.update(uri2, contentValues, "_id='" + this.id_fotoacargar + "'", (String[]) null);
                    }
                }
                this.pb_foto.setVisibility(8);
                File file = new File(t_detalle_fr.this.getActivity().getFilesDir(), "temp");
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file.getPath());
                    fileOutputStream.write(this.bitmapdata);
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    z = false;
                }
                if (z && file.exists()) {
                    Intent intent = new Intent(t_detalle_fr.this.getActivity(), t_url.class);
                    intent.putExtra("url", AdPayload.FILE_SCHEME + file);
                    intent.putExtra("bg1", t_detalle_fr.this.globales.c_prods_det);
                    intent.putExtra("bg2", t_detalle_fr.this.globales.c_prods_det);
                    t_detalle_fr.this.startActivityForResult(intent, 0);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void mostrar_foto(byte[] bArr, int i, String str) {
        ProgressBar progressBar;
        RelativeLayout relativeLayout = new RelativeLayout(getActivity());
        ImageView imageView = new ImageView(getActivity());
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        imageView.setImageDrawable(new BitmapDrawable(getResources(), decodeByteArray));
        imageView.setTag(R.id.TAG_IDFOTO, Integer.valueOf(i));
        imageView.setOnClickListener(this);
        imageView.setAdjustViewBounds(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        imageView.setLayoutParams(layoutParams);
        imageView.getLayoutParams().width = this.w_global;
        int height = (decodeByteArray.getHeight() * this.w_global) / decodeByteArray.getWidth();
        imageView.getLayoutParams().height = height;
        float f = this.scale;
        imageView.setPadding(0, (int) ((f * 4.0f) + 0.5f), 0, (int) ((f * 4.0f) + 0.5f));
        relativeLayout.addView(imageView);
        if (this.pb_inverse) {
            progressBar = new ProgressBar(getActivity(), (AttributeSet) null, 16843399);
        } else {
            progressBar = new ProgressBar(getActivity(), (AttributeSet) null, 16842871);
        }
        if (Build.VERSION.SDK_INT > 20) {
            config.progress_color(progressBar, this.globales.c_icos);
        }
        progressBar.setVisibility(8);
        progressBar.setLayoutParams(layoutParams);
        relativeLayout.addView(progressBar);
        LinearLayout linearLayout = (LinearLayout) this.ll.findViewById(R.id.ll_det_imgs);
        for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
            ImageSwitcher imageSwitcher = (ImageSwitcher) linearLayout.getChildAt(i2);
            if (imageSwitcher.getChildCount() == 1) {
                imageSwitcher.getLayoutParams().height = height;
                imageSwitcher.addView(relativeLayout);
                imageSwitcher.showNext();
                return;
            }
        }
    }

    private void tratar_tv(TextView textView, String str, boolean z) {
        int i;
        int i2;
        if (z) {
            if (str.toUpperCase().indexOf("<BR") == -1) {
                str = str.replace("\n", "<br>");
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Html.fromHtml(str.replace("<a href", "@AHREF_INI@").replace("<A HREF", "@AHREF_INI@").replace("</a>", "@AHREF_FIN@").replace("</A>", "@AHREF_FIN@").replace("</ a>", "@AHREF_FIN@").replace("</ A>", "@AHREF_FIN@")));
            String spannableStringBuilder2 = spannableStringBuilder.toString();
            int indexOf = spannableStringBuilder2.indexOf("@AHREF_INI@");
            while (indexOf != -1) {
                spannableStringBuilder.replace(indexOf, indexOf + 11, "<a href");
                spannableStringBuilder2 = spannableStringBuilder.toString();
                indexOf = spannableStringBuilder2.indexOf("@AHREF_INI@");
            }
            for (int indexOf2 = spannableStringBuilder2.indexOf("@AHREF_FIN@"); indexOf2 != -1; indexOf2 = spannableStringBuilder.toString().indexOf("@AHREF_FIN@")) {
                spannableStringBuilder.replace(indexOf2, indexOf2 + 11, "</a>");
            }
            String spannableStringBuilder3 = spannableStringBuilder.toString();
            String upperCase = spannableStringBuilder3.toUpperCase();
            for (int indexOf3 = upperCase.indexOf("<A HREF="); indexOf3 != -1; indexOf3 = upperCase.indexOf("<A HREF=", i)) {
                i = indexOf3 + 8;
                int i3 = i + 1;
                String substring = spannableStringBuilder3.substring(i, i3);
                if (substring.equals("\"") || substring.equals("'")) {
                    i = i3;
                }
                if (substring.equals("\"")) {
                    i2 = spannableStringBuilder3.indexOf("\"", i);
                } else if (substring.equals("'")) {
                    i2 = spannableStringBuilder3.indexOf("'", i);
                } else {
                    i2 = spannableStringBuilder3.indexOf(">", i);
                }
                if (i2 != -1) {
                    this.url_global = spannableStringBuilder3.substring(i, i2).trim();
                    i2 = spannableStringBuilder3.indexOf(">", i2);
                    if (i2 != -1) {
                        int indexOf4 = upperCase.indexOf("</A>", i2);
                        int i4 = Integer.MAX_VALUE;
                        if (indexOf4 == -1) {
                            indexOf4 = Integer.MAX_VALUE;
                        }
                        int indexOf5 = upperCase.indexOf("</ A>", i2);
                        if (indexOf5 != -1) {
                            i4 = indexOf5;
                        }
                        if (indexOf4 == -1 && i4 == -1) {
                            i = i2;
                        } else {
                            int min = Math.min(indexOf4, i4);
                            int indexOf6 = spannableStringBuilder3.indexOf(">", min);
                            spannableStringBuilder.setSpan(new ClickableSpan() {
                                String url;

                                {
                                    this.url = t_detalle_fr.this.url_global;
                                }

                                public void onClick(View view) {
                                    boolean unused = t_detalle_fr.this.tratar_url(this.url, false);
                                }
                            }, i2, min, 33);
                            int i5 = indexOf6 + 1;
                            spannableStringBuilder.delete(min, i5);
                            int i6 = min - (i5 - min);
                            int i7 = i2 + 1;
                            spannableStringBuilder.delete(indexOf3, i7);
                            int i8 = i6 - (i7 - indexOf3);
                            String spannableStringBuilder4 = spannableStringBuilder.toString();
                            i = i2;
                            i2 = i8;
                            spannableStringBuilder3 = spannableStringBuilder4;
                            upperCase = spannableStringBuilder4.toUpperCase();
                        }
                    }
                }
                if (i2 != -1) {
                    i = i2;
                }
            }
            textView.setText(spannableStringBuilder);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private void wv_set() {
        if (Build.VERSION.SDK_INT > 20) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.viewer, true);
        }
    }
}
