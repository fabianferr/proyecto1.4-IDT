package stikerwap.appdys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: s_widget_vistafb */
class vistafbRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {
    boolean c1_esclaro;
    int c_fondo;
    int c_txt;
    private int dp40;
    config globales;
    boolean hay_fotos;
    private String idi;
    long idusu;
    private int mAppWidgetId;
    private Context mContext;
    private List<widget_vistafb_item> mWidgetItems = new ArrayList();
    File path;
    SharedPreferences settings;

    public long getItemId(int i) {
        return (long) i;
    }

    public RemoteViews getLoadingView() {
        return null;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        return true;
    }

    public void onCreate() {
    }

    public vistafbRemoteViewsFactory(Context context, Intent intent) {
        this.mContext = context;
        this.mAppWidgetId = intent.getIntExtra("appWidgetId", 0);
        this.dp40 = config.dp_to_px(context, 40);
        this.idi = Locale.getDefault().getLanguage();
    }

    public void onDestroy() {
        this.mWidgetItems.clear();
    }

    public int getCount() {
        return this.mWidgetItems.size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x0590  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x05c0  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x06e1  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0711  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x03a5  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x03d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.RemoteViews getViewAt(int r18) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            java.lang.String r0 = "fperfilgal_"
            java.util.List<stikerwap.appdys.widget_vistafb_item> r3 = r1.mWidgetItems
            java.lang.Object r3 = r3.get(r2)
            stikerwap.appdys.widget_vistafb_item r3 = (stikerwap.appdys.widget_vistafb_item) r3
            android.widget.RemoteViews r4 = new android.widget.RemoteViews
            android.content.Context r5 = r1.mContext
            java.lang.String r5 = r5.getPackageName()
            r6 = 2131558771(0x7f0d0173, float:1.8742867E38)
            r4.<init>(r5, r6)
            java.lang.String r5 = "setTextColor"
            int r6 = r1.c_txt
            r7 = 2131363555(0x7f0a06e3, float:1.8346922E38)
            r4.setInt(r7, r5, r6)
            java.lang.String r5 = "setTextColor"
            int r6 = r1.c_txt
            r7 = 2131363557(0x7f0a06e5, float:1.8346926E38)
            r4.setInt(r7, r5, r6)
            java.lang.String r5 = "setTextColor"
            int r6 = r1.c_txt
            r7 = 2131363556(0x7f0a06e4, float:1.8346924E38)
            r4.setInt(r7, r5, r6)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "<i>"
            r5.<init>(r6)
            java.lang.String r6 = r3.fcrea
            r5.append(r6)
            java.lang.String r6 = "</i>"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)
            r6 = 2131363557(0x7f0a06e5, float:1.8346926E38)
            r4.setTextViewText(r6, r5)
            boolean r5 = r1.hay_fotos
            java.lang.String r6 = ""
            java.lang.String r8 = "fperfil_"
            r9 = 8
            r10 = 2131363548(0x7f0a06dc, float:1.8346908E38)
            java.lang.String r11 = ".jpg"
            r12 = 1
            r13 = 0
            if (r5 != 0) goto L_0x0075
            r4.setViewVisibility(r10, r9)
            r5 = 2131363558(0x7f0a06e6, float:1.8346928E38)
            r4.setViewVisibility(r5, r9)
            goto L_0x0102
        L_0x0075:
            r4.setViewVisibility(r10, r13)
            r5 = 2131363558(0x7f0a06e6, float:1.8346928E38)
            r4.setViewVisibility(r5, r13)
            java.lang.String r5 = r3.vfoto
            java.lang.String r14 = "0"
            boolean r5 = r5.equals(r14)
            if (r5 == 0) goto L_0x009a
            boolean r5 = r1.c1_esclaro
            if (r5 == 0) goto L_0x0093
            r5 = 2131231689(0x7f0803c9, float:1.8079466E38)
            r4.setImageViewResource(r10, r5)
            goto L_0x0102
        L_0x0093:
            r5 = 2131231691(0x7f0803cb, float:1.807947E38)
            r4.setImageViewResource(r10, r5)
            goto L_0x0102
        L_0x009a:
            android.content.SharedPreferences r5 = r1.settings
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r8)
            java.lang.String r15 = r3.idusu
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            java.lang.String r5 = r5.getString(r14, r6)
            java.lang.String r14 = r3.vfoto
            boolean r5 = r5.equals(r14)
            if (r5 != 0) goto L_0x00bd
            java.lang.String r5 = "_p"
            boolean r5 = r1.obtener_foto_perfil(r3, r6, r5)
            goto L_0x00be
        L_0x00bd:
            r5 = 1
        L_0x00be:
            if (r5 == 0) goto L_0x00ef
            stikerwap.appdys.config r14 = r1.globales
            android.content.Context r15 = r1.mContext
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r8)
            java.lang.String r7 = r3.idusu
            r13.append(r7)
            r13.append(r11)
            java.lang.String r7 = r13.toString()
            java.io.File r7 = r14.getTempFile_libre(r15, r7)
            stikerwap.appdys.config r13 = r1.globales     // Catch:{ Exception | OutOfMemoryError -> 0x00ed }
            android.net.Uri r7 = android.net.Uri.fromFile(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x00ed }
            int r14 = r1.dp40     // Catch:{ Exception | OutOfMemoryError -> 0x00ed }
            android.graphics.Bitmap r7 = r13.decodeSampledBitmapFromResource(r7, r14, r14)     // Catch:{ Exception | OutOfMemoryError -> 0x00ed }
            android.graphics.Bitmap r7 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r7, r12)     // Catch:{ Exception | OutOfMemoryError -> 0x00ed }
            r4.setImageViewBitmap(r10, r7)     // Catch:{ Exception | OutOfMemoryError -> 0x00ed }
            goto L_0x00ef
        L_0x00ed:
            r5 = 0
        L_0x00ef:
            if (r5 != 0) goto L_0x0102
            boolean r5 = r1.c1_esclaro
            if (r5 == 0) goto L_0x00fc
            r5 = 2131231689(0x7f0803c9, float:1.8079466E38)
            r4.setImageViewResource(r10, r5)
            goto L_0x0102
        L_0x00fc:
            r5 = 2131231691(0x7f0803cb, float:1.807947E38)
            r4.setImageViewResource(r10, r5)
        L_0x0102:
            r5 = 2131363544(0x7f0a06d8, float:1.83469E38)
            r4.setViewVisibility(r5, r9)
            r7 = 2131363549(0x7f0a06dd, float:1.834691E38)
            r4.setViewVisibility(r7, r9)
            r7 = 2131363556(0x7f0a06e4, float:1.8346924E38)
            r4.setViewVisibility(r7, r9)
            r7 = 2131363547(0x7f0a06db, float:1.8346906E38)
            r4.setViewVisibility(r7, r9)
            r7 = 2131363546(0x7f0a06da, float:1.8346904E38)
            r4.setViewVisibility(r7, r9)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "<b>"
            r7.<init>(r9)
            java.lang.String r9 = r3.nick
            r7.append(r9)
            java.lang.String r9 = "</b>"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            java.lang.String r9 = r3.tipo
            java.lang.String r10 = "1"
            boolean r9 = r9.equals(r10)
            java.lang.String r10 = "_g.jpg"
            r13 = 2131363545(0x7f0a06d9, float:1.8346902E38)
            r14 = 300(0x12c, float:4.2E-43)
            java.lang.String r15 = " "
            if (r9 == 0) goto L_0x01d0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r15)
            android.content.Context r7 = r1.mContext
            android.content.res.Resources r7 = r7.getResources()
            r9 = 2131886464(0x7f120180, float:1.9407508E38)
            java.lang.String r7 = r7.getString(r9)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = r3.vfoto
            java.lang.String r9 = "0"
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x01c7
            android.content.SharedPreferences r0 = r1.settings
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r8)
            java.lang.String r11 = r3.idusu
            r9.append(r11)
            java.lang.String r11 = "_g"
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = r0.getString(r9, r6)
            java.lang.String r9 = r3.vfoto
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x0198
            java.lang.String r0 = "_g"
            boolean r12 = r1.obtener_foto_perfil(r3, r0, r6)
        L_0x0198:
            if (r12 == 0) goto L_0x01c8
            stikerwap.appdys.config r0 = r1.globales
            android.content.Context r6 = r1.mContext
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r8)
            java.lang.String r8 = r3.idusu
            r9.append(r8)
            r9.append(r10)
            java.lang.String r8 = r9.toString()
            java.io.File r0 = r0.getTempFile_libre(r6, r8)
            stikerwap.appdys.config r6 = r1.globales     // Catch:{ Exception | OutOfMemoryError -> 0x01c6 }
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x01c6 }
            android.graphics.Bitmap r0 = r6.decodeSampledBitmapFromResource(r0, r14, r14)     // Catch:{ Exception | OutOfMemoryError -> 0x01c6 }
            r6 = 2
            android.graphics.Bitmap r0 = stikerwap.appdys.config.crop(r0, r6)     // Catch:{ Exception | OutOfMemoryError -> 0x01c6 }
            r4.setImageViewBitmap(r13, r0)     // Catch:{ Exception | OutOfMemoryError -> 0x01c6 }
            goto L_0x01c8
        L_0x01c6:
        L_0x01c7:
            r12 = 0
        L_0x01c8:
            if (r12 == 0) goto L_0x07c9
            r6 = 0
            r4.setViewVisibility(r5, r6)
            goto L_0x07c9
        L_0x01d0:
            java.lang.String r6 = r3.tipo
            java.lang.String r8 = "2"
            boolean r6 = r6.equals(r8)
            r8 = 100
            r9 = 60000(0xea60, float:8.4078E-41)
            r5 = 10000(0x2710, float:1.4013E-41)
            r16 = 0
            if (r6 == 0) goto L_0x02d9
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            r6.append(r15)
            android.content.Context r7 = r1.mContext
            android.content.res.Resources r7 = r7.getResources()
            r15 = 2131886456(0x7f120178, float:1.9407491E38)
            java.lang.String r7 = r7.getString(r15)
            r6.append(r7)
            java.lang.String r7 = r6.toString()
            stikerwap.appdys.config r6 = r1.globales
            android.content.Context r15 = r1.mContext
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "fperfilgal_"
            r13.<init>(r14)
            java.lang.String r14 = r3.idelem
            r13.append(r14)
            r13.append(r10)
            java.lang.String r13 = r13.toString()
            java.io.File r6 = r6.getTempFile_libre(r15, r13)
            boolean r6 = r6.exists()
            if (r6 != 0) goto L_0x029c
            java.lang.String r6 = r3.idelem
            java.net.URL r13 = new java.net.URL     // Catch:{ Exception -> 0x029a }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x029a }
            r14.<init>()     // Catch:{ Exception -> 0x029a }
            java.lang.String r15 = stikerwap.appdys.config.DOM_CDN     // Catch:{ Exception -> 0x029a }
            r14.append(r15)     // Catch:{ Exception -> 0x029a }
            java.lang.String r15 = "/srv/imgs/ususgal/"
            r14.append(r15)     // Catch:{ Exception -> 0x029a }
            java.lang.String r15 = r3.idusu     // Catch:{ Exception -> 0x029a }
            r14.append(r15)     // Catch:{ Exception -> 0x029a }
            java.lang.String r15 = "_"
            r14.append(r15)     // Catch:{ Exception -> 0x029a }
            r14.append(r6)     // Catch:{ Exception -> 0x029a }
            r14.append(r11)     // Catch:{ Exception -> 0x029a }
            java.lang.String r11 = r14.toString()     // Catch:{ Exception -> 0x029a }
            r13.<init>(r11)     // Catch:{ Exception -> 0x029a }
            java.net.URLConnection r11 = r13.openConnection()     // Catch:{ Exception -> 0x029a }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ Exception -> 0x029a }
            r11.setDoInput(r12)     // Catch:{ Exception -> 0x029a }
            r11.setConnectTimeout(r5)     // Catch:{ Exception -> 0x029a }
            r11.setReadTimeout(r9)     // Catch:{ Exception -> 0x029a }
            r11.connect()     // Catch:{ Exception -> 0x029a }
            java.io.InputStream r5 = r11.getInputStream()     // Catch:{ Exception -> 0x029a }
            android.graphics.Bitmap r16 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch:{ OutOfMemoryError -> 0x026b }
            r13 = r16
            r9 = 1
            goto L_0x026e
        L_0x026b:
            r13 = r16
            r9 = 0
        L_0x026e:
            r5.close()     // Catch:{ Exception -> 0x029a }
            r11.disconnect()     // Catch:{ Exception -> 0x029a }
            if (r9 == 0) goto L_0x0298
            stikerwap.appdys.config r5 = r1.globales     // Catch:{ Exception -> 0x029a }
            android.content.Context r9 = r1.mContext     // Catch:{ Exception -> 0x029a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x029a }
            r11.<init>(r0)     // Catch:{ Exception -> 0x029a }
            r11.append(r6)     // Catch:{ Exception -> 0x029a }
            r11.append(r10)     // Catch:{ Exception -> 0x029a }
            java.lang.String r0 = r11.toString()     // Catch:{ Exception -> 0x029a }
            java.io.File r0 = r5.getTempFile_libre(r9, r0)     // Catch:{ Exception -> 0x029a }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x029a }
            r5.<init>(r0)     // Catch:{ Exception -> 0x029a }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x029a }
            r13.compress(r0, r8, r5)     // Catch:{ Exception -> 0x029a }
            goto L_0x029c
        L_0x0298:
            r12 = r9
            goto L_0x029c
        L_0x029a:
            r12 = 0
        L_0x029c:
            if (r12 == 0) goto L_0x02ce
            stikerwap.appdys.config r0 = r1.globales
            android.content.Context r5 = r1.mContext
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "fperfilgal_"
            r6.<init>(r8)
            java.lang.String r8 = r3.idelem
            r6.append(r8)
            r6.append(r10)
            java.lang.String r6 = r6.toString()
            java.io.File r0 = r0.getTempFile_libre(r5, r6)
            stikerwap.appdys.config r5 = r1.globales     // Catch:{ Exception | OutOfMemoryError -> 0x02cc }
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x02cc }
            r6 = 300(0x12c, float:4.2E-43)
            android.graphics.Bitmap r0 = r5.decodeSampledBitmapFromResource(r0, r6, r6)     // Catch:{ Exception | OutOfMemoryError -> 0x02cc }
            r5 = 2131363545(0x7f0a06d9, float:1.8346902E38)
            r4.setImageViewBitmap(r5, r0)     // Catch:{ Exception | OutOfMemoryError -> 0x02cc }
            goto L_0x02ce
        L_0x02cc:
            r12 = 0
        L_0x02ce:
            if (r12 == 0) goto L_0x07c9
            r5 = 2131363544(0x7f0a06d8, float:1.83469E38)
            r6 = 0
            r4.setViewVisibility(r5, r6)
            goto L_0x07c9
        L_0x02d9:
            java.lang.String r0 = r3.tipo
            java.lang.String r6 = "3"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x03e4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r15)
            android.content.Context r6 = r1.mContext
            android.content.res.Resources r6 = r6.getResources()
            r7 = 2131886457(0x7f120179, float:1.9407493E38)
            java.lang.String r6 = r6.getString(r7)
            r0.append(r6)
            java.lang.String r7 = r0.toString()
            stikerwap.appdys.config r0 = r1.globales
            android.content.Context r6 = r1.mContext
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r13 = "fperfilgalv_"
            r10.<init>(r13)
            java.lang.String r14 = r3.idelem
            r10.append(r14)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.io.File r0 = r0.getTempFile_libre(r6, r10)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x03a3
            java.lang.String r0 = r3.idelem
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x039e }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039e }
            r10.<init>()     // Catch:{ Exception -> 0x039e }
            java.lang.String r14 = stikerwap.appdys.config.DOM_CDN     // Catch:{ Exception -> 0x039e }
            r10.append(r14)     // Catch:{ Exception -> 0x039e }
            java.lang.String r14 = "/srv/imgs/videos_pro/v"
            r10.append(r14)     // Catch:{ Exception -> 0x039e }
            r10.append(r0)     // Catch:{ Exception -> 0x039e }
            java.lang.String r14 = "_"
            r10.append(r14)     // Catch:{ Exception -> 0x039e }
            java.lang.String r14 = r3.idusu     // Catch:{ Exception -> 0x039e }
            r10.append(r14)     // Catch:{ Exception -> 0x039e }
            java.lang.String r14 = "_th.jpg"
            r10.append(r14)     // Catch:{ Exception -> 0x039e }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x039e }
            r6.<init>(r10)     // Catch:{ Exception -> 0x039e }
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ Exception -> 0x039e }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x039e }
            r6.setDoInput(r12)     // Catch:{ Exception -> 0x039e }
            r6.setConnectTimeout(r5)     // Catch:{ Exception -> 0x039e }
            r6.setReadTimeout(r9)     // Catch:{ Exception -> 0x039e }
            r6.connect()     // Catch:{ Exception -> 0x039e }
            java.io.InputStream r5 = r6.getInputStream()     // Catch:{ Exception -> 0x039e }
            android.graphics.Bitmap r16 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch:{ OutOfMemoryError -> 0x036d }
            r10 = r16
            r9 = 1
            goto L_0x0370
        L_0x036d:
            r10 = r16
            r9 = 0
        L_0x0370:
            r5.close()     // Catch:{ Exception -> 0x039e }
            r6.disconnect()     // Catch:{ Exception -> 0x039e }
            if (r9 == 0) goto L_0x039c
            stikerwap.appdys.config r5 = r1.globales     // Catch:{ Exception -> 0x039e }
            android.content.Context r6 = r1.mContext     // Catch:{ Exception -> 0x039e }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039e }
            r9.<init>(r13)     // Catch:{ Exception -> 0x039e }
            r9.append(r0)     // Catch:{ Exception -> 0x039e }
            r9.append(r11)     // Catch:{ Exception -> 0x039e }
            java.lang.String r0 = r9.toString()     // Catch:{ Exception -> 0x039e }
            java.io.File r0 = r5.getTempFile_libre(r6, r0)     // Catch:{ Exception -> 0x039e }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x039a }
            r5.<init>(r0)     // Catch:{ Exception -> 0x039a }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x039a }
            r10.compress(r0, r8, r5)     // Catch:{ Exception -> 0x039a }
            goto L_0x03a3
        L_0x039a:
            goto L_0x03a2
        L_0x039c:
            r12 = r9
            goto L_0x03a3
        L_0x039e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x03a2:
            r12 = 0
        L_0x03a3:
            if (r12 == 0) goto L_0x03d3
            stikerwap.appdys.config r0 = r1.globales
            android.content.Context r5 = r1.mContext
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r13)
            java.lang.String r8 = r3.idelem
            r6.append(r8)
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.io.File r0 = r0.getTempFile_libre(r5, r6)
            stikerwap.appdys.config r5 = r1.globales     // Catch:{ Exception | OutOfMemoryError -> 0x03d1 }
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x03d1 }
            r6 = 300(0x12c, float:4.2E-43)
            android.graphics.Bitmap r0 = r5.decodeSampledBitmapFromResource(r0, r6, r6)     // Catch:{ Exception | OutOfMemoryError -> 0x03d1 }
            r5 = 2131363545(0x7f0a06d9, float:1.8346902E38)
            r4.setImageViewBitmap(r5, r0)     // Catch:{ Exception | OutOfMemoryError -> 0x03d1 }
            goto L_0x03d3
        L_0x03d1:
            r12 = 0
        L_0x03d3:
            if (r12 == 0) goto L_0x07c9
            r0 = 2131363549(0x7f0a06dd, float:1.834691E38)
            r5 = 0
            r4.setViewVisibility(r0, r5)
            r6 = 2131363544(0x7f0a06d8, float:1.83469E38)
            r4.setViewVisibility(r6, r5)
            goto L_0x07c9
        L_0x03e4:
            java.lang.String r0 = r3.tipo
            java.lang.String r6 = "4"
            boolean r0 = r0.equals(r6)
            java.lang.String r6 = "&rdquo;</b>"
            java.lang.String r10 = "<b>&ldquo;"
            if (r0 == 0) goto L_0x0432
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r15)
            android.content.Context r5 = r1.mContext
            android.content.res.Resources r5 = r5.getResources()
            r7 = 2131886461(0x7f12017d, float:1.9407501E38)
            java.lang.String r5 = r5.getString(r7)
            r0.append(r5)
            java.lang.String r7 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            java.lang.String r5 = r3.idelem_2
            r0.append(r5)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            r5 = 2131363556(0x7f0a06e4, float:1.8346924E38)
            r4.setTextViewText(r5, r0)
            r6 = 0
            r4.setViewVisibility(r5, r6)
            goto L_0x07c9
        L_0x0432:
            java.lang.String r0 = r3.tipo
            java.lang.String r13 = "5"
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x047c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r15)
            android.content.Context r5 = r1.mContext
            android.content.res.Resources r5 = r5.getResources()
            r7 = 2131886462(0x7f12017e, float:1.9407504E38)
            java.lang.String r5 = r5.getString(r7)
            r0.append(r5)
            java.lang.String r7 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            java.lang.String r5 = r3.idelem_2
            r0.append(r5)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            r5 = 2131363556(0x7f0a06e4, float:1.8346924E38)
            r4.setTextViewText(r5, r0)
            r6 = 0
            r4.setViewVisibility(r5, r6)
            goto L_0x07c9
        L_0x047c:
            java.lang.String r0 = r3.tipo
            java.lang.String r13 = "6"
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x04c6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r15)
            android.content.Context r5 = r1.mContext
            android.content.res.Resources r5 = r5.getResources()
            r7 = 2131886459(0x7f12017b, float:1.9407497E38)
            java.lang.String r5 = r5.getString(r7)
            r0.append(r5)
            java.lang.String r7 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            java.lang.String r5 = r3.idelem_2
            r0.append(r5)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            r5 = 2131363556(0x7f0a06e4, float:1.8346924E38)
            r4.setTextViewText(r5, r0)
            r6 = 0
            r4.setViewVisibility(r5, r6)
            goto L_0x07c9
        L_0x04c6:
            java.lang.String r0 = r3.tipo
            java.lang.String r13 = "7"
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x05c9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r15)
            android.content.Context r6 = r1.mContext
            android.content.res.Resources r6 = r6.getResources()
            r7 = 2131886466(0x7f120182, float:1.9407512E38)
            java.lang.String r6 = r6.getString(r7)
            r0.append(r6)
            r0.append(r15)
            java.lang.String r6 = r3.idelem_2
            r0.append(r6)
            java.lang.String r7 = r0.toString()
            stikerwap.appdys.config r0 = r1.globales
            android.content.Context r6 = r1.mContext
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r13 = "game_banner"
            r10.<init>(r13)
            java.lang.String r14 = r3.idelem
            r10.append(r14)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.io.File r0 = r0.getTempFile_libre(r6, r10)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x058e
            java.lang.String r0 = r3.idelem
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x0589 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0589 }
            r10.<init>()     // Catch:{ Exception -> 0x0589 }
            java.lang.String r14 = stikerwap.appdys.config.DOM_CDN     // Catch:{ Exception -> 0x0589 }
            r10.append(r14)     // Catch:{ Exception -> 0x0589 }
            java.lang.String r14 = "/android-app-creator/game/promo"
            r10.append(r14)     // Catch:{ Exception -> 0x0589 }
            r10.append(r0)     // Catch:{ Exception -> 0x0589 }
            java.lang.String r14 = "/media/graphics/promo/banners/180x120.jpg"
            r10.append(r14)     // Catch:{ Exception -> 0x0589 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0589 }
            r6.<init>(r10)     // Catch:{ Exception -> 0x0589 }
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ Exception -> 0x0589 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x0589 }
            r6.setDoInput(r12)     // Catch:{ Exception -> 0x0589 }
            r6.setConnectTimeout(r5)     // Catch:{ Exception -> 0x0589 }
            r6.setReadTimeout(r9)     // Catch:{ Exception -> 0x0589 }
            r6.connect()     // Catch:{ Exception -> 0x0589 }
            java.io.InputStream r5 = r6.getInputStream()     // Catch:{ Exception -> 0x0589 }
            android.graphics.Bitmap r16 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch:{ OutOfMemoryError -> 0x0558 }
            r10 = r16
            r9 = 1
            goto L_0x055b
        L_0x0558:
            r10 = r16
            r9 = 0
        L_0x055b:
            r5.close()     // Catch:{ Exception -> 0x0589 }
            r6.disconnect()     // Catch:{ Exception -> 0x0589 }
            if (r9 == 0) goto L_0x0587
            stikerwap.appdys.config r5 = r1.globales     // Catch:{ Exception -> 0x0589 }
            android.content.Context r6 = r1.mContext     // Catch:{ Exception -> 0x0589 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0589 }
            r9.<init>(r13)     // Catch:{ Exception -> 0x0589 }
            r9.append(r0)     // Catch:{ Exception -> 0x0589 }
            r9.append(r11)     // Catch:{ Exception -> 0x0589 }
            java.lang.String r0 = r9.toString()     // Catch:{ Exception -> 0x0589 }
            java.io.File r0 = r5.getTempFile_libre(r6, r0)     // Catch:{ Exception -> 0x0589 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0585 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0585 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0585 }
            r10.compress(r0, r8, r5)     // Catch:{ Exception -> 0x0585 }
            goto L_0x058e
        L_0x0585:
            goto L_0x058d
        L_0x0587:
            r12 = r9
            goto L_0x058e
        L_0x0589:
            r0 = move-exception
            r0.printStackTrace()
        L_0x058d:
            r12 = 0
        L_0x058e:
            if (r12 == 0) goto L_0x05be
            stikerwap.appdys.config r0 = r1.globales
            android.content.Context r5 = r1.mContext
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r13)
            java.lang.String r8 = r3.idelem
            r6.append(r8)
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.io.File r0 = r0.getTempFile_libre(r5, r6)
            stikerwap.appdys.config r5 = r1.globales     // Catch:{ Exception | OutOfMemoryError -> 0x05bc }
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x05bc }
            r6 = 300(0x12c, float:4.2E-43)
            android.graphics.Bitmap r0 = r5.decodeSampledBitmapFromResource(r0, r6, r6)     // Catch:{ Exception | OutOfMemoryError -> 0x05bc }
            r5 = 2131363545(0x7f0a06d9, float:1.8346902E38)
            r4.setImageViewBitmap(r5, r0)     // Catch:{ Exception | OutOfMemoryError -> 0x05bc }
            goto L_0x05be
        L_0x05bc:
            r12 = 0
        L_0x05be:
            if (r12 == 0) goto L_0x07c9
            r5 = 2131363544(0x7f0a06d8, float:1.83469E38)
            r6 = 0
            r4.setViewVisibility(r5, r6)
            goto L_0x07c9
        L_0x05c9:
            java.lang.String r0 = r3.tipo
            java.lang.String r13 = "8"
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x0613
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r15)
            android.content.Context r5 = r1.mContext
            android.content.res.Resources r5 = r5.getResources()
            r7 = 2131886458(0x7f12017a, float:1.9407495E38)
            java.lang.String r5 = r5.getString(r7)
            r0.append(r5)
            java.lang.String r7 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            java.lang.String r5 = r3.idelem_2
            r0.append(r5)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            r5 = 2131363556(0x7f0a06e4, float:1.8346924E38)
            r4.setTextViewText(r5, r0)
            r6 = 0
            r4.setViewVisibility(r5, r6)
            goto L_0x07c9
        L_0x0613:
            java.lang.String r0 = r3.tipo
            java.lang.String r13 = "9"
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x0720
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r15)
            android.content.Context r6 = r1.mContext
            android.content.res.Resources r6 = r6.getResources()
            r7 = 2131886457(0x7f120179, float:1.9407493E38)
            java.lang.String r6 = r6.getString(r7)
            r0.append(r6)
            java.lang.String r7 = r0.toString()
            stikerwap.appdys.config r0 = r1.globales
            android.content.Context r6 = r1.mContext
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r13 = "fbuscvideo_"
            r10.<init>(r13)
            java.lang.String r14 = r3.idelem
            r10.append(r14)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.io.File r0 = r0.getTempFile_libre(r6, r10)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x06df
            java.lang.String r0 = r3.idelem
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x06da }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x06da }
            r10.<init>()     // Catch:{ Exception -> 0x06da }
            java.lang.String r14 = stikerwap.appdys.config.DOM_CDN     // Catch:{ Exception -> 0x06da }
            r10.append(r14)     // Catch:{ Exception -> 0x06da }
            java.lang.String r14 = "/srv/imgs/videos_busc/v"
            r10.append(r14)     // Catch:{ Exception -> 0x06da }
            r10.append(r0)     // Catch:{ Exception -> 0x06da }
            java.lang.String r0 = "_"
            r10.append(r0)     // Catch:{ Exception -> 0x06da }
            java.lang.String r0 = r3.idusu     // Catch:{ Exception -> 0x06da }
            r10.append(r0)     // Catch:{ Exception -> 0x06da }
            java.lang.String r0 = "_th.jpg"
            r10.append(r0)     // Catch:{ Exception -> 0x06da }
            java.lang.String r0 = r10.toString()     // Catch:{ Exception -> 0x06da }
            r6.<init>(r0)     // Catch:{ Exception -> 0x06da }
            java.net.URLConnection r0 = r6.openConnection()     // Catch:{ Exception -> 0x06da }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x06da }
            r0.setDoInput(r12)     // Catch:{ Exception -> 0x06da }
            r0.setConnectTimeout(r5)     // Catch:{ Exception -> 0x06da }
            r0.setReadTimeout(r9)     // Catch:{ Exception -> 0x06da }
            r0.connect()     // Catch:{ Exception -> 0x06da }
            java.io.InputStream r5 = r0.getInputStream()     // Catch:{ Exception -> 0x06da }
            android.graphics.Bitmap r16 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch:{ OutOfMemoryError -> 0x06a7 }
            r9 = r16
            r6 = 1
            goto L_0x06aa
        L_0x06a7:
            r9 = r16
            r6 = 0
        L_0x06aa:
            r5.close()     // Catch:{ Exception -> 0x06da }
            r0.disconnect()     // Catch:{ Exception -> 0x06da }
            if (r6 == 0) goto L_0x06d8
            stikerwap.appdys.config r0 = r1.globales     // Catch:{ Exception -> 0x06da }
            android.content.Context r5 = r1.mContext     // Catch:{ Exception -> 0x06da }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x06da }
            r6.<init>(r13)     // Catch:{ Exception -> 0x06da }
            java.lang.String r10 = r3.idelem     // Catch:{ Exception -> 0x06da }
            r6.append(r10)     // Catch:{ Exception -> 0x06da }
            r6.append(r11)     // Catch:{ Exception -> 0x06da }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x06da }
            java.io.File r0 = r0.getTempFile_libre(r5, r6)     // Catch:{ Exception -> 0x06da }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x06d6 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x06d6 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x06d6 }
            r9.compress(r0, r8, r5)     // Catch:{ Exception -> 0x06d6 }
            goto L_0x06df
        L_0x06d6:
            goto L_0x06de
        L_0x06d8:
            r12 = r6
            goto L_0x06df
        L_0x06da:
            r0 = move-exception
            r0.printStackTrace()
        L_0x06de:
            r12 = 0
        L_0x06df:
            if (r12 == 0) goto L_0x070f
            stikerwap.appdys.config r0 = r1.globales
            android.content.Context r5 = r1.mContext
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r13)
            java.lang.String r8 = r3.idelem
            r6.append(r8)
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            java.io.File r0 = r0.getTempFile_libre(r5, r6)
            stikerwap.appdys.config r5 = r1.globales     // Catch:{ Exception | OutOfMemoryError -> 0x070d }
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x070d }
            r6 = 300(0x12c, float:4.2E-43)
            android.graphics.Bitmap r0 = r5.decodeSampledBitmapFromResource(r0, r6, r6)     // Catch:{ Exception | OutOfMemoryError -> 0x070d }
            r5 = 2131363545(0x7f0a06d9, float:1.8346902E38)
            r4.setImageViewBitmap(r5, r0)     // Catch:{ Exception | OutOfMemoryError -> 0x070d }
            goto L_0x070f
        L_0x070d:
            r12 = 0
        L_0x070f:
            if (r12 == 0) goto L_0x07c9
            r0 = 2131363549(0x7f0a06dd, float:1.834691E38)
            r5 = 0
            r4.setViewVisibility(r0, r5)
            r6 = 2131363544(0x7f0a06d8, float:1.83469E38)
            r4.setViewVisibility(r6, r5)
            goto L_0x07c9
        L_0x0720:
            java.lang.String r0 = r3.tipo
            java.lang.String r5 = "10"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0769
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r15)
            android.content.Context r5 = r1.mContext
            android.content.res.Resources r5 = r5.getResources()
            r7 = 2131886459(0x7f12017b, float:1.9407497E38)
            java.lang.String r5 = r5.getString(r7)
            r0.append(r5)
            java.lang.String r7 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            java.lang.String r5 = r3.idelem_2
            r0.append(r5)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            r5 = 2131363556(0x7f0a06e4, float:1.8346924E38)
            r4.setTextViewText(r5, r0)
            r6 = 0
            r4.setViewVisibility(r5, r6)
            goto L_0x07c9
        L_0x0769:
            java.lang.String r0 = r3.tipo
            java.lang.String r5 = "11"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x07c9
            java.lang.String r0 = r1.idi
            if (r0 == 0) goto L_0x0797
            java.lang.String r5 = "es"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0789
            java.lang.String r0 = r1.idi
            java.lang.String r5 = "ca"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0797
        L_0x0789:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "A "
            r0.<init>(r5)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L_0x0797:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r15)
            android.content.Context r5 = r1.mContext
            android.content.res.Resources r5 = r5.getResources()
            r6 = 2131886477(0x7f12018d, float:1.9407534E38)
            java.lang.String r5 = r5.getString(r6)
            r0.append(r5)
            java.lang.String r7 = r0.toString()
            boolean r0 = r1.c1_esclaro
            if (r0 == 0) goto L_0x07c2
            r0 = 2131363547(0x7f0a06db, float:1.8346906E38)
            r5 = 0
            r4.setViewVisibility(r0, r5)
            goto L_0x07c9
        L_0x07c2:
            r5 = 0
            r0 = 2131363546(0x7f0a06da, float:1.8346904E38)
            r4.setViewVisibility(r0, r5)
        L_0x07c9:
            r0 = 2131363555(0x7f0a06e3, float:1.8346922E38)
            android.text.Spanned r5 = android.text.Html.fromHtml(r7)
            r4.setTextViewText(r0, r5)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r5 = "EXTRA_ITEM"
            r0.putInt(r5, r2)
            java.lang.String r2 = "EXTRA_TIPO"
            java.lang.String r5 = r3.tipo
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_IDUSU"
            java.lang.String r5 = r3.idusu
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_IDELEM"
            java.lang.String r5 = r3.idelem
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_IDELEM_2"
            java.lang.String r5 = r3.idelem_2
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_IDELEM_3"
            java.lang.String r5 = r3.idelem_3
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_PRIVADOS"
            java.lang.String r5 = r3.privados
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_NOMBRE"
            java.lang.String r5 = r3.nick
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_COMENTS"
            java.lang.String r5 = r3.coments
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_FNAC_D"
            java.lang.String r5 = r3.fnac_d
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_FNAC_M"
            java.lang.String r5 = r3.fnac_m
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_FNAC_A"
            java.lang.String r5 = r3.fnac_a
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_SEXO"
            java.lang.String r5 = r3.sexo
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_VFOTO"
            java.lang.String r5 = r3.vfoto
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_FNAC_CHAT"
            java.lang.String r5 = r3.fnac_chat
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_SEXO_CHAT"
            java.lang.String r5 = r3.sexo_chat
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_DESCR_CHAT"
            java.lang.String r5 = r3.descr_chat
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_DIST_CHAT"
            java.lang.String r5 = r3.dist_chat
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_COMENTS_CHAT"
            java.lang.String r5 = r3.coments_chat
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_GALERIA_CHAT"
            java.lang.String r5 = r3.galeria_chat
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_PRIVADOS_CHAT"
            java.lang.String r5 = r3.privados_chat
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_FOTOS_PERFIL"
            java.lang.String r5 = r3.fotos_perfil
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_FOTOS_CHAT"
            java.lang.String r5 = r3.fotos_chat
            r0.putString(r2, r5)
            java.lang.String r2 = "EXTRA_FCREA"
            java.lang.String r3 = r3.fcrea
            r0.putString(r2, r3)
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            r2.putExtras(r0)
            r0 = 2131363554(0x7f0a06e2, float:1.834692E38)
            r4.setOnClickFillInIntent(r0, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.vistafbRemoteViewsFactory.getViewAt(int):android.widget.RemoteViews");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:28|29|30|31|(3:33|34|(4:36|38|39|50))|37|38|39|50) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x02b0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDataSetChanged() {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r0 = "#FF"
            java.lang.String r2 = ";"
            android.content.Context r3 = r1.mContext
            android.content.Context r3 = r3.getApplicationContext()
            stikerwap.appdys.config r3 = (stikerwap.appdys.config) r3
            r1.globales = r3
            if (r3 != 0) goto L_0x0013
            return
        L_0x0013:
            android.content.Context r3 = r1.mContext
            java.lang.String r4 = "sh"
            r5 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r5)
            r1.settings = r3
            java.lang.String r4 = "idusu"
            r6 = 0
            long r3 = r3.getLong(r4, r6)
            r1.idusu = r3
            android.content.Context r3 = r1.mContext
            java.io.File r3 = r3.getFilesDir()
            r1.path = r3
            r3 = 1
            r1.hay_fotos = r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = stikerwap.appdys.config.PROTOC_GEN
            r4.append(r6)
            java.lang.String r6 = "widget."
            r4.append(r6)
            java.lang.String r6 = stikerwap.appdys.config.DOM_EDROID
            r4.append(r6)
            java.lang.String r6 = "/srv/widget_fb.php?widget=1&idusu="
            r4.append(r6)
            long r6 = r1.idusu
            r4.append(r6)
            java.lang.String r6 = "&c="
            r4.append(r6)
            android.content.SharedPreferences r6 = r1.settings
            java.lang.String r7 = "cod"
            java.lang.String r8 = ""
            java.lang.String r6 = r6.getString(r7, r8)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            android.content.Context r6 = r1.mContext
            android.appwidget.AppWidgetManager r6 = android.appwidget.AppWidgetManager.getInstance(r6)
            android.widget.RemoteViews r7 = new android.widget.RemoteViews
            android.content.Context r8 = r1.mContext
            java.lang.String r8 = r8.getPackageName()
            r9 = 2131558770(0x7f0d0172, float:1.8742865E38)
            r7.<init>(r8, r9)
            r8 = 2131363543(0x7f0a06d7, float:1.8346898E38)
            r9 = 8
            r7.setViewVisibility(r8, r9)
            r10 = 2131363552(0x7f0a06e0, float:1.8346916E38)
            r7.setViewVisibility(r10, r9)
            r11 = 2131363551(0x7f0a06df, float:1.8346914E38)
            r7.setViewVisibility(r11, r5)
            int r12 = r1.mAppWidgetId
            r6.updateAppWidget(r12, r7)
            org.apache.http.params.BasicHttpParams r12 = new org.apache.http.params.BasicHttpParams     // Catch:{ Exception -> 0x02c9 }
            r12.<init>()     // Catch:{ Exception -> 0x02c9 }
            r13 = 10000(0x2710, float:1.4013E-41)
            org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r12, r13)     // Catch:{ Exception -> 0x02c9 }
            r13 = 60000(0xea60, float:8.4078E-41)
            org.apache.http.params.HttpConnectionParams.setSoTimeout(r12, r13)     // Catch:{ Exception -> 0x02c9 }
            org.apache.http.impl.client.DefaultHttpClient r13 = new org.apache.http.impl.client.DefaultHttpClient     // Catch:{ Exception -> 0x02c9 }
            r13.<init>((org.apache.http.params.HttpParams) r12)     // Catch:{ Exception -> 0x02c9 }
            org.apache.http.client.methods.HttpPost r12 = new org.apache.http.client.methods.HttpPost     // Catch:{ Exception -> 0x02c9 }
            r12.<init>((java.lang.String) r4)     // Catch:{ Exception -> 0x02c9 }
            org.apache.http.entity.mime.MultipartEntity r4 = new org.apache.http.entity.mime.MultipartEntity     // Catch:{ Exception -> 0x02c9 }
            org.apache.http.entity.mime.HttpMultipartMode r14 = org.apache.http.entity.mime.HttpMultipartMode.BROWSER_COMPATIBLE     // Catch:{ Exception -> 0x02c9 }
            r4.<init>(r14)     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r4 = "User-Agent"
            java.lang.String r14 = "Android Vinebre Software"
            r12.setHeader(r4, r14)     // Catch:{ Exception -> 0x02c9 }
            org.apache.http.HttpResponse r4 = r13.execute(r12)     // Catch:{ Exception -> 0x02c9 }
            java.io.BufferedReader r12 = new java.io.BufferedReader     // Catch:{ Exception -> 0x02c9 }
            java.io.InputStreamReader r13 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x02c9 }
            org.apache.http.HttpEntity r4 = r4.getEntity()     // Catch:{ Exception -> 0x02c9 }
            java.io.InputStream r4 = r4.getContent()     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r14 = "UTF-8"
            r13.<init>(r4, r14)     // Catch:{ Exception -> 0x02c9 }
            r12.<init>(r13)     // Catch:{ Exception -> 0x02c9 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c9 }
            r4.<init>()     // Catch:{ Exception -> 0x02c9 }
        L_0x00d9:
            java.lang.String r13 = r12.readLine()     // Catch:{ Exception -> 0x02c9 }
            if (r13 == 0) goto L_0x00e3
            r4.append(r13)     // Catch:{ Exception -> 0x02c9 }
            goto L_0x00d9
        L_0x00e3:
            java.lang.String r12 = "ANDROID:OK CAD:"
            int r12 = r4.indexOf(r12)     // Catch:{ Exception -> 0x02c9 }
            r13 = -1
            if (r12 == r13) goto L_0x02cd
            r14 = 15
            int r12 = r12 + r14
            java.lang.String r4 = r4.substring(r12)     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r12 = "@"
            java.lang.String[] r4 = r4.split(r12)     // Catch:{ Exception -> 0x02c9 }
            int r12 = r4.length     // Catch:{ Exception -> 0x02c9 }
            if (r12 <= 0) goto L_0x02cd
            r12 = r4[r5]     // Catch:{ Exception -> 0x02c9 }
            int r12 = r12.indexOf(r2)     // Catch:{ Exception -> 0x02c9 }
            if (r12 == r13) goto L_0x02cd
            r12 = r4[r5]     // Catch:{ Exception -> 0x02c9 }
            java.lang.String[] r12 = r12.split(r2)     // Catch:{ Exception -> 0x02c9 }
            r13 = r12[r5]     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r15 = "1"
            boolean r13 = r13.equals(r15)     // Catch:{ Exception -> 0x02c9 }
            r1.hay_fotos = r13     // Catch:{ Exception -> 0x02c9 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c9 }
            r13.<init>()     // Catch:{ Exception -> 0x02c9 }
            r13.append(r0)     // Catch:{ Exception -> 0x02c9 }
            r15 = r12[r3]     // Catch:{ Exception -> 0x02c9 }
            r13.append(r15)     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x02c9 }
            int r13 = android.graphics.Color.parseColor(r13)     // Catch:{ Exception -> 0x02c9 }
            r1.c_fondo = r13     // Catch:{ Exception -> 0x02c9 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c9 }
            r13.<init>()     // Catch:{ Exception -> 0x02c9 }
            r13.append(r0)     // Catch:{ Exception -> 0x02c9 }
            r15 = r12[r3]     // Catch:{ Exception -> 0x02c9 }
            r13.append(r15)     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x02c9 }
            boolean r13 = stikerwap.appdys.config.esClaro(r13)     // Catch:{ Exception -> 0x02c9 }
            r1.c1_esclaro = r13     // Catch:{ Exception -> 0x02c9 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c9 }
            r13.<init>()     // Catch:{ Exception -> 0x02c9 }
            r13.append(r0)     // Catch:{ Exception -> 0x02c9 }
            r0 = 2
            r12 = r12[r0]     // Catch:{ Exception -> 0x02c9 }
            r13.append(r12)     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r12 = r13.toString()     // Catch:{ Exception -> 0x02c9 }
            int r12 = android.graphics.Color.parseColor(r12)     // Catch:{ Exception -> 0x02c9 }
            r1.c_txt = r12     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r12 = "setBackgroundColor"
            int r13 = r1.c_fondo     // Catch:{ Exception -> 0x02c9 }
            r15 = 2131363553(0x7f0a06e1, float:1.8346918E38)
            r7.setInt(r15, r12, r13)     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r12 = "setTextColor"
            int r13 = r1.c_txt     // Catch:{ Exception -> 0x02c9 }
            r7.setInt(r8, r12, r13)     // Catch:{ Exception -> 0x02c9 }
            int r12 = r4.length     // Catch:{ Exception -> 0x02c9 }
            if (r12 <= r3) goto L_0x0197
            r12 = r4[r3]     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r13 = "SIGNUP;"
            boolean r12 = r12.equals(r13)     // Catch:{ Exception -> 0x02c9 }
            if (r12 == 0) goto L_0x0197
            r7.setViewVisibility(r11, r9)     // Catch:{ Exception -> 0x02c9 }
            r7.setViewVisibility(r10, r5)     // Catch:{ Exception -> 0x02c9 }
            android.content.Context r0 = r1.mContext     // Catch:{ Exception -> 0x02c9 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x02c9 }
            r2 = 2131886654(0x7f12023e, float:1.9407893E38)
            java.lang.String r0 = r0.getString(r2)     // Catch:{ Exception -> 0x02c9 }
            r7.setTextViewText(r8, r0)     // Catch:{ Exception -> 0x02c9 }
            r7.setViewVisibility(r8, r5)     // Catch:{ Exception -> 0x02c9 }
            int r0 = r1.mAppWidgetId     // Catch:{ Exception -> 0x02c9 }
            r6.updateAppWidget(r0, r7)     // Catch:{ Exception -> 0x02c9 }
            return
        L_0x0197:
            java.util.List<stikerwap.appdys.widget_vistafb_item> r12 = r1.mWidgetItems     // Catch:{ Exception -> 0x02c9 }
            r12.clear()     // Catch:{ Exception -> 0x02c9 }
            r12 = 1
        L_0x019d:
            int r13 = r4.length     // Catch:{ Exception -> 0x02c9 }
            if (r12 >= r13) goto L_0x02cd
            r13 = r4[r12]     // Catch:{ Exception -> 0x02c9 }
            boolean r13 = r13.contains(r2)     // Catch:{ Exception -> 0x02c9 }
            if (r13 == 0) goto L_0x02b5
            r13 = r4[r12]     // Catch:{ Exception -> 0x02c9 }
            java.lang.String[] r13 = r13.split(r2)     // Catch:{ Exception -> 0x02c9 }
            int r15 = r13.length     // Catch:{ Exception -> 0x02c9 }
            if (r15 <= r0) goto L_0x02b5
            r15 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r8 = r13[r3]     // Catch:{ Exception -> 0x02c9 }
            r5 = r13[r0]     // Catch:{ Exception -> 0x02c9 }
            r16 = 3
            r0 = r13[r16]     // Catch:{ Exception -> 0x02c9 }
            r16 = 4
            r16 = r13[r16]     // Catch:{ Exception -> 0x02c9 }
            r17 = 5
            r10 = r13[r17]     // Catch:{ Exception -> 0x02c9 }
            stikerwap.appdys.widget_vistafb_item r11 = new stikerwap.appdys.widget_vistafb_item     // Catch:{ Exception -> 0x02c9 }
            r11.<init>()     // Catch:{ Exception -> 0x02c9 }
            r11.tipo = r15     // Catch:{ Exception -> 0x02c9 }
            r11.idusu = r8     // Catch:{ Exception -> 0x02c9 }
            r11.nick = r5     // Catch:{ Exception -> 0x02c9 }
            r11.vfoto = r0     // Catch:{ Exception -> 0x02c9 }
            r11.idelem = r10     // Catch:{ Exception -> 0x02c9 }
            r0 = 6
            r5 = r13[r0]     // Catch:{ Exception -> 0x02c9 }
            r11.idelem_2 = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 7
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.privados = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = r13[r9]     // Catch:{ Exception -> 0x02c9 }
            r11.fnac_d = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 9
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.fnac_m = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 10
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.fnac_a = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 11
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.sexo = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 12
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.coments = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 13
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.fotos_perfil = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 14
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.privados_chat = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = r13[r14]     // Catch:{ Exception -> 0x02c9 }
            r11.fotos_chat = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 16
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.coments_chat = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 17
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.fnac_chat = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 18
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.sexo_chat = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 19
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.descr_chat = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 20
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.galeria_chat = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 21
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.dist_chat = r5     // Catch:{ Exception -> 0x02c9 }
            r5 = 22
            r5 = r13[r5]     // Catch:{ Exception -> 0x02c9 }
            r11.idelem_3 = r5     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r5 = stikerwap.appdys.config.convertir_fecha(r16)     // Catch:{ Exception -> 0x02c9 }
            java.text.SimpleDateFormat r8 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x02c9 }
            java.lang.String r10 = "ddMMyyHHmm"
            r8.<init>(r10)     // Catch:{ Exception -> 0x02c9 }
            android.content.Context r10 = r1.mContext     // Catch:{ Exception -> 0x02b0 }
            java.text.DateFormat r10 = android.text.format.DateFormat.getDateFormat(r10)     // Catch:{ Exception -> 0x02b0 }
            android.content.Context r13 = r1.mContext     // Catch:{ Exception -> 0x02b0 }
            java.text.DateFormat r13 = android.text.format.DateFormat.getTimeFormat(r13)     // Catch:{ Exception -> 0x02b0 }
            java.util.Date r5 = r8.parse(r5)     // Catch:{ Exception -> 0x02b0 }
            java.util.Calendar r8 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x02b0 }
            java.util.Calendar r15 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x02b0 }
            r15.setTime(r5)     // Catch:{ Exception -> 0x02b0 }
            int r14 = r15.get(r3)     // Catch:{ Exception -> 0x02b0 }
            int r9 = r8.get(r3)     // Catch:{ Exception -> 0x02b0 }
            java.lang.String r3 = " "
            if (r14 != r9) goto L_0x0294
            int r9 = r15.get(r0)     // Catch:{ Exception -> 0x02b0 }
            int r0 = r8.get(r0)     // Catch:{ Exception -> 0x02b0 }
            if (r9 != r0) goto L_0x0294
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b0 }
            r0.<init>()     // Catch:{ Exception -> 0x02b0 }
            android.content.Context r8 = r1.mContext     // Catch:{ Exception -> 0x02b0 }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ Exception -> 0x02b0 }
            r9 = 2131886471(0x7f120187, float:1.9407522E38)
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x02b0 }
            r0.append(r8)     // Catch:{ Exception -> 0x02b0 }
            r0.append(r3)     // Catch:{ Exception -> 0x02b0 }
            java.lang.String r3 = r13.format(r5)     // Catch:{ Exception -> 0x02b0 }
            r0.append(r3)     // Catch:{ Exception -> 0x02b0 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02b0 }
            r11.fcrea = r0     // Catch:{ Exception -> 0x02b0 }
            goto L_0x02b0
        L_0x0294:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b0 }
            r0.<init>()     // Catch:{ Exception -> 0x02b0 }
            java.lang.String r8 = r10.format(r5)     // Catch:{ Exception -> 0x02b0 }
            r0.append(r8)     // Catch:{ Exception -> 0x02b0 }
            r0.append(r3)     // Catch:{ Exception -> 0x02b0 }
            java.lang.String r3 = r13.format(r5)     // Catch:{ Exception -> 0x02b0 }
            r0.append(r3)     // Catch:{ Exception -> 0x02b0 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02b0 }
            r11.fcrea = r0     // Catch:{ Exception -> 0x02b0 }
        L_0x02b0:
            java.util.List<stikerwap.appdys.widget_vistafb_item> r0 = r1.mWidgetItems     // Catch:{ Exception -> 0x02c9 }
            r0.add(r11)     // Catch:{ Exception -> 0x02c9 }
        L_0x02b5:
            int r12 = r12 + 1
            r0 = 2
            r3 = 1
            r5 = 0
            r8 = 2131363543(0x7f0a06d7, float:1.8346898E38)
            r9 = 8
            r10 = 2131363552(0x7f0a06e0, float:1.8346916E38)
            r11 = 2131363551(0x7f0a06df, float:1.8346914E38)
            r14 = 15
            goto L_0x019d
        L_0x02c9:
            r0 = move-exception
            r0.printStackTrace()
        L_0x02cd:
            r2 = 2131363551(0x7f0a06df, float:1.8346914E38)
            r3 = 8
            r7.setViewVisibility(r2, r3)
            r2 = 2131363552(0x7f0a06e0, float:1.8346916E38)
            r3 = 0
            r7.setViewVisibility(r2, r3)
            java.util.List<stikerwap.appdys.widget_vistafb_item> r0 = r1.mWidgetItems
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x02fa
            android.content.Context r0 = r1.mContext
            android.content.res.Resources r0 = r0.getResources()
            r2 = 2131886677(0x7f120255, float:1.940794E38)
            java.lang.String r0 = r0.getString(r2)
            r2 = 2131363543(0x7f0a06d7, float:1.8346898E38)
            r7.setTextViewText(r2, r0)
            r7.setViewVisibility(r2, r3)
        L_0x02fa:
            int r0 = r1.mAppWidgetId
            r6.updateAppWidget(r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.vistafbRemoteViewsFactory.onDataSetChanged():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean obtener_foto_perfil(stikerwap.appdys.widget_vistafb_item r9, java.lang.String r10, java.lang.String r11) {
        /*
            r8 = this;
            java.lang.String r0 = "fperfil_"
            java.lang.String r1 = r9.idusu
            java.lang.String r9 = r9.vfoto
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{  }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{  }
            r4.<init>()     // Catch:{  }
            java.lang.String r5 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
            r4.append(r5)     // Catch:{  }
            java.lang.String r5 = "/srv/imgs/usus/"
            r4.append(r5)     // Catch:{  }
            r4.append(r1)     // Catch:{  }
            java.lang.String r5 = "_1"
            r4.append(r5)     // Catch:{  }
            r4.append(r11)     // Catch:{  }
            java.lang.String r11 = ".jpg?v="
            r4.append(r11)     // Catch:{  }
            r4.append(r9)     // Catch:{  }
            java.lang.String r11 = r4.toString()     // Catch:{  }
            r3.<init>(r11)     // Catch:{  }
            java.net.URLConnection r11 = r3.openConnection()     // Catch:{  }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{  }
            r3 = 1
            r11.setDoInput(r3)     // Catch:{  }
            r4 = 10000(0x2710, float:1.4013E-41)
            r11.setConnectTimeout(r4)     // Catch:{  }
            r4 = 20000(0x4e20, float:2.8026E-41)
            r11.setReadTimeout(r4)     // Catch:{  }
            r11.connect()     // Catch:{  }
            java.io.InputStream r4 = r11.getInputStream()     // Catch:{  }
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch:{ MalformedURLException -> 0x009a }
            r4.close()     // Catch:{  }
            r11.disconnect()     // Catch:{  }
            java.io.File r11 = new java.io.File     // Catch:{  }
            java.io.File r4 = r8.path     // Catch:{  }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{  }
            r6.<init>(r0)     // Catch:{  }
            r6.append(r1)     // Catch:{  }
            r6.append(r10)     // Catch:{  }
            java.lang.String r7 = ".jpg"
            r6.append(r7)     // Catch:{  }
            java.lang.String r6 = r6.toString()     // Catch:{  }
            r11.<init>(r4, r6)     // Catch:{  }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{  }
            r4.<init>(r11)     // Catch:{  }
            android.graphics.Bitmap$CompressFormat r11 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{  }
            r6 = 100
            r5.compress(r11, r6, r4)     // Catch:{  }
            android.content.SharedPreferences r11 = r8.settings     // Catch:{  }
            android.content.SharedPreferences$Editor r11 = r11.edit()     // Catch:{  }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{  }
            r4.<init>(r0)     // Catch:{  }
            r4.append(r1)     // Catch:{  }
            r4.append(r10)     // Catch:{  }
            java.lang.String r10 = r4.toString()     // Catch:{  }
            r11.putString(r10, r9)     // Catch:{  }
            r11.commit()     // Catch:{  }
            return r3
        L_0x009a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.vistafbRemoteViewsFactory.obtener_foto_perfil(stikerwap.appdys.widget_vistafb_item, java.lang.String, java.lang.String):boolean");
    }
}
