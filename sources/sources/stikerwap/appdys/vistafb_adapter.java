package stikerwap.appdys;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

public class vistafb_adapter extends ArrayAdapter<widget_vistafb_item> {
    protected boolean c1_esclaro;
    /* access modifiers changed from: private */
    public ArrayList<widget_vistafb_item> datas;
    private final int dp40;
    /* access modifiers changed from: private */
    public vistafb_adapter este = this;
    config globales;
    protected boolean hay_fotos;
    private String idi;
    private String idusus = "";
    protected int ind_secc;
    private Activity myContext;
    /* access modifiers changed from: private */
    public File path;
    /* access modifiers changed from: private */
    public SharedPreferences settings = this.myContext.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);

    public vistafb_adapter(Context context, int i, ArrayList<widget_vistafb_item> arrayList) {
        super(context, i, arrayList);
        Activity activity = (Activity) context;
        this.myContext = activity;
        this.globales = (config) activity.getApplicationContext();
        this.datas = arrayList;
        this.dp40 = config.dp_to_px(context, 40);
        this.path = this.myContext.getFilesDir();
        this.idi = Locale.getDefault().getLanguage();
    }

    static class ViewHolder {
        FrameLayout fl_content;
        ImageView iv_content;
        ImageView iv_favorito_b;
        ImageView iv_favorito_n;
        ImageView iv_perfil;
        ImageView iv_play;
        TextView tv_aux;
        TextView tv_content;
        TextView tv_descr;
        TextView tv_fcrea;

        ViewHolder() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: stikerwap.appdys.vistafb_adapter$ViewHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r17, android.view.View r18, android.view.ViewGroup r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = 0
            if (r18 != 0) goto L_0x00d7
            android.app.Activity r2 = r0.myContext
            android.view.LayoutInflater r2 = r2.getLayoutInflater()
            r3 = 2131558771(0x7f0d0173, float:1.8742867E38)
            android.view.View r2 = r2.inflate(r3, r1)
            stikerwap.appdys.vistafb_adapter$ViewHolder r3 = new stikerwap.appdys.vistafb_adapter$ViewHolder
            r3.<init>()
            r4 = 2131363548(0x7f0a06dc, float:1.8346908E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r3.iv_perfil = r4
            r4 = 2131363544(0x7f0a06d8, float:1.83469E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r3.fl_content = r4
            r4 = 2131363545(0x7f0a06d9, float:1.8346902E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r3.iv_content = r4
            r4 = 2131363549(0x7f0a06dd, float:1.834691E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r3.iv_play = r4
            r4 = 2131363547(0x7f0a06db, float:1.8346906E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r3.iv_favorito_n = r4
            r4 = 2131363546(0x7f0a06da, float:1.8346904E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r3.iv_favorito_b = r4
            r4 = 2131363555(0x7f0a06e3, float:1.8346922E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.tv_descr = r4
            r4 = 2131363558(0x7f0a06e6, float:1.8346928E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.tv_aux = r4
            r4 = 2131363557(0x7f0a06e5, float:1.8346926E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.tv_fcrea = r4
            r4 = 2131363556(0x7f0a06e4, float:1.8346924E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.tv_content = r4
            boolean r4 = r0.c1_esclaro
            if (r4 == 0) goto L_0x009f
            android.widget.TextView r4 = r3.tv_descr
            int r5 = stikerwap.appdys.config.NEGRO
            r4.setTextColor(r5)
            android.widget.TextView r4 = r3.tv_fcrea
            int r5 = stikerwap.appdys.config.NEGRO
            r4.setTextColor(r5)
            android.widget.TextView r4 = r3.tv_content
            int r5 = stikerwap.appdys.config.NEGRO
            r4.setTextColor(r5)
            goto L_0x00b4
        L_0x009f:
            android.widget.TextView r4 = r3.tv_descr
            int r5 = stikerwap.appdys.config.BLANCO_2
            r4.setTextColor(r5)
            android.widget.TextView r4 = r3.tv_fcrea
            int r5 = stikerwap.appdys.config.BLANCO_2
            r4.setTextColor(r5)
            android.widget.TextView r4 = r3.tv_content
            int r5 = stikerwap.appdys.config.BLANCO_2
            r4.setTextColor(r5)
        L_0x00b4:
            android.app.Activity r4 = r0.myContext
            android.content.res.Resources r4 = r4.getResources()
            r5 = 2131034118(0x7f050006, float:1.7678745E38)
            boolean r4 = r4.getBoolean(r5)
            if (r4 == 0) goto L_0x00d3
            android.widget.TextView r4 = r3.tv_descr
            r5 = 4
            r4.setTextDirection(r5)
            android.widget.TextView r4 = r3.tv_fcrea
            r4.setTextDirection(r5)
            android.widget.TextView r4 = r3.tv_content
            r4.setTextDirection(r5)
        L_0x00d3:
            r2.setTag(r3)
            goto L_0x00e0
        L_0x00d7:
            java.lang.Object r2 = r18.getTag()
            r3 = r2
            stikerwap.appdys.vistafb_adapter$ViewHolder r3 = (stikerwap.appdys.vistafb_adapter.ViewHolder) r3
            r2 = r18
        L_0x00e0:
            java.util.ArrayList<stikerwap.appdys.widget_vistafb_item> r4 = r0.datas
            r5 = r17
            java.lang.Object r4 = r4.get(r5)
            stikerwap.appdys.widget_vistafb_item r4 = (stikerwap.appdys.widget_vistafb_item) r4
            android.widget.TextView r6 = r3.tv_fcrea
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "<i>"
            r7.<init>(r8)
            java.lang.String r8 = r4.fcrea
            r7.append(r8)
            java.lang.String r8 = "</i>"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            android.text.Spanned r7 = android.text.Html.fromHtml(r7)
            r6.setText(r7)
            boolean r6 = r0.hay_fotos
            java.lang.String r7 = ""
            java.lang.String r8 = "0"
            java.lang.String r9 = ".jpg"
            java.lang.String r10 = "fperfil_"
            r11 = 8
            r12 = 1
            r13 = 0
            if (r6 != 0) goto L_0x0124
            android.widget.ImageView r6 = r3.iv_perfil
            r6.setVisibility(r11)
            android.widget.TextView r6 = r3.tv_aux
            r6.setVisibility(r11)
            goto L_0x0211
        L_0x0124:
            android.widget.ImageView r6 = r3.iv_perfil
            r6.setVisibility(r13)
            android.widget.TextView r6 = r3.tv_aux
            r6.setVisibility(r13)
            java.lang.String r6 = r4.vfoto
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x0139
        L_0x0136:
            r6 = 1
            goto L_0x01e6
        L_0x0139:
            android.content.SharedPreferences r6 = r0.settings
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r10)
            java.lang.String r15 = r4.idusu
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            java.lang.String r6 = r6.getString(r14, r7)
            java.lang.String r14 = r4.vfoto
            boolean r6 = r6.equals(r14)
            if (r6 != 0) goto L_0x01b1
            java.lang.String r6 = r0.idusus
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = ","
            r14.<init>(r15)
            java.lang.String r11 = r4.idusu
            r14.append(r11)
            r14.append(r15)
            java.lang.String r11 = r14.toString()
            int r6 = r6.indexOf(r11)
            r11 = -1
            r14 = 2131230954(0x7f0800ea, float:1.8077975E38)
            if (r6 != r11) goto L_0x01a7
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r11 = r0.idusus
            r6.append(r11)
            r6.append(r15)
            java.lang.String r11 = r4.idusu
            r6.append(r11)
            r6.append(r15)
            java.lang.String r6 = r6.toString()
            r0.idusus = r6
            android.widget.ImageView r6 = r3.iv_perfil
            r6.setImageResource(r14)
            r4.cargando_perfil = r12
            stikerwap.appdys.vistafb_adapter$DownloadAsyncTask_perfil r6 = new stikerwap.appdys.vistafb_adapter$DownloadAsyncTask_perfil
            r6.<init>()
            java.lang.Integer[] r11 = new java.lang.Integer[r12]
            java.lang.Integer r14 = java.lang.Integer.valueOf(r17)
            r11[r13] = r14
            r6.execute(r11)
            goto L_0x01e1
        L_0x01a7:
            boolean r6 = r4.cargando_perfil
            if (r6 == 0) goto L_0x0136
            android.widget.ImageView r6 = r3.iv_perfil
            r6.setImageResource(r14)
            goto L_0x01e1
        L_0x01b1:
            stikerwap.appdys.config r6 = r0.globales
            android.app.Activity r11 = r0.myContext
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r10)
            java.lang.String r15 = r4.idusu
            r14.append(r15)
            r14.append(r9)
            java.lang.String r14 = r14.toString()
            java.io.File r6 = r6.getTempFile_libre(r11, r14)
            stikerwap.appdys.config r11 = r0.globales     // Catch:{ Exception -> 0x01e3, OutOfMemoryError -> 0x01e0 }
            android.net.Uri r6 = android.net.Uri.fromFile(r6)     // Catch:{ Exception -> 0x01e3, OutOfMemoryError -> 0x01e0 }
            int r14 = r0.dp40     // Catch:{ Exception -> 0x01e3, OutOfMemoryError -> 0x01e0 }
            android.graphics.Bitmap r6 = r11.decodeSampledBitmapFromResource(r6, r14, r14)     // Catch:{ Exception -> 0x01e3, OutOfMemoryError -> 0x01e0 }
            android.graphics.Bitmap r6 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r6, r12)     // Catch:{ Exception -> 0x01e3, OutOfMemoryError -> 0x01e0 }
            android.widget.ImageView r11 = r3.iv_perfil     // Catch:{ Exception -> 0x01e3, OutOfMemoryError -> 0x01e0 }
            r11.setImageBitmap(r6)     // Catch:{ Exception -> 0x01e3, OutOfMemoryError -> 0x01e0 }
            goto L_0x01e1
        L_0x01e0:
        L_0x01e1:
            r6 = 0
            goto L_0x01e6
        L_0x01e3:
            goto L_0x0136
        L_0x01e6:
            if (r6 == 0) goto L_0x0211
            boolean r6 = r0.c1_esclaro
            if (r6 == 0) goto L_0x01ff
            android.widget.ImageView r6 = r3.iv_perfil
            android.app.Activity r11 = r0.myContext
            android.content.res.Resources r11 = r11.getResources()
            r14 = 2131231689(0x7f0803c9, float:1.8079466E38)
            android.graphics.drawable.Drawable r11 = r11.getDrawable(r14)
            r6.setImageDrawable(r11)
            goto L_0x0211
        L_0x01ff:
            android.widget.ImageView r6 = r3.iv_perfil
            android.app.Activity r11 = r0.myContext
            android.content.res.Resources r11 = r11.getResources()
            r14 = 2131231691(0x7f0803cb, float:1.807947E38)
            android.graphics.drawable.Drawable r11 = r11.getDrawable(r14)
            r6.setImageDrawable(r11)
        L_0x0211:
            android.widget.FrameLayout r6 = r3.fl_content
            r11 = 8
            r6.setVisibility(r11)
            android.widget.ImageView r6 = r3.iv_play
            r6.setVisibility(r11)
            android.widget.TextView r6 = r3.tv_content
            r6.setVisibility(r11)
            android.widget.ImageView r6 = r3.iv_favorito_n
            r6.setVisibility(r11)
            android.widget.ImageView r6 = r3.iv_favorito_b
            r6.setVisibility(r11)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r11 = "<b>"
            r6.<init>(r11)
            java.lang.String r11 = r4.nick
            r6.append(r11)
            java.lang.String r11 = "</b>"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            boolean r11 = r4.error_content
            if (r11 == 0) goto L_0x0247
            goto L_0x06e3
        L_0x0247:
            java.lang.String r11 = r4.tipo
            java.lang.String r14 = "1"
            boolean r11 = r11.equals(r14)
            java.lang.String r14 = "_g.jpg"
            r15 = 2131230955(0x7f0800eb, float:1.8077977E38)
            java.lang.String r12 = " "
            if (r11 == 0) goto L_0x02f7
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            r9.append(r12)
            android.app.Activity r6 = r0.myContext
            android.content.res.Resources r6 = r6.getResources()
            r11 = 2131886464(0x7f120180, float:1.9407508E38)
            java.lang.String r6 = r6.getString(r11)
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            java.lang.String r9 = r4.vfoto
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x06e3
            android.content.SharedPreferences r8 = r0.settings
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r10)
            java.lang.String r11 = r4.idusu
            r9.append(r11)
            java.lang.String r11 = "_g"
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            java.lang.String r7 = r8.getString(r9, r7)
            java.lang.String r8 = r4.vfoto
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x02c1
            android.widget.ImageView r7 = r3.iv_content
            r7.setImageResource(r15)
            android.widget.FrameLayout r7 = r3.fl_content
            r7.setVisibility(r13)
            boolean r4 = r4.carga_iniciada
            if (r4 != 0) goto L_0x06e3
            stikerwap.appdys.vistafb_adapter$DownloadAsyncTask_content r4 = new stikerwap.appdys.vistafb_adapter$DownloadAsyncTask_content
            r4.<init>()
            r1 = 1
            java.lang.Integer[] r1 = new java.lang.Integer[r1]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)
            r1[r13] = r5
            r4.execute(r1)
            goto L_0x06e3
        L_0x02c1:
            stikerwap.appdys.config r1 = r0.globales
            android.app.Activity r5 = r0.myContext
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r10)
            java.lang.String r4 = r4.idusu
            r7.append(r4)
            r7.append(r14)
            java.lang.String r4 = r7.toString()
            java.io.File r1 = r1.getTempFile_libre(r5, r4)
            stikerwap.appdys.config r4 = r0.globales     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.net.Uri r1 = android.net.Uri.fromFile(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r5 = 300(0x12c, float:4.2E-43)
            android.graphics.Bitmap r1 = r4.decodeSampledBitmapFromResource(r1, r5, r5)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r4 = 2
            android.graphics.Bitmap r1 = stikerwap.appdys.config.crop(r1, r4)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.widget.ImageView r4 = r3.iv_content     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r4.setImageBitmap(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.widget.FrameLayout r1 = r3.fl_content     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r1.setVisibility(r13)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            goto L_0x06e3
        L_0x02f7:
            java.lang.String r7 = r4.tipo
            java.lang.String r8 = "2"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x037a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r12)
            android.app.Activity r6 = r0.myContext
            android.content.res.Resources r6 = r6.getResources()
            r8 = 2131886456(0x7f120178, float:1.9407491E38)
            java.lang.String r6 = r6.getString(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            stikerwap.appdys.config r7 = r0.globales
            android.app.Activity r8 = r0.myContext
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "fperfilgal_"
            r9.<init>(r10)
            java.lang.String r10 = r4.idelem
            r9.append(r10)
            r9.append(r14)
            java.lang.String r9 = r9.toString()
            java.io.File r7 = r7.getTempFile_libre(r8, r9)
            boolean r8 = r7.exists()
            if (r8 != 0) goto L_0x0362
            android.widget.ImageView r7 = r3.iv_content
            r7.setImageResource(r15)
            android.widget.FrameLayout r7 = r3.fl_content
            r7.setVisibility(r13)
            boolean r4 = r4.carga_iniciada
            if (r4 != 0) goto L_0x06e3
            stikerwap.appdys.vistafb_adapter$DownloadAsyncTask_content r4 = new stikerwap.appdys.vistafb_adapter$DownloadAsyncTask_content
            r4.<init>()
            r1 = 1
            java.lang.Integer[] r1 = new java.lang.Integer[r1]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)
            r1[r13] = r5
            r4.execute(r1)
            goto L_0x06e3
        L_0x0362:
            stikerwap.appdys.config r1 = r0.globales     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.net.Uri r4 = android.net.Uri.fromFile(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r5 = 300(0x12c, float:4.2E-43)
            android.graphics.Bitmap r1 = r1.decodeSampledBitmapFromResource(r4, r5, r5)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.widget.ImageView r4 = r3.iv_content     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r4.setImageBitmap(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.widget.FrameLayout r1 = r3.fl_content     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r1.setVisibility(r13)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            goto L_0x06e3
        L_0x037a:
            java.lang.String r7 = r4.tipo
            java.lang.String r8 = "3"
            boolean r7 = r7.equals(r8)
            r8 = 2131886457(0x7f120179, float:1.9407493E38)
            if (r7 == 0) goto L_0x0402
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r12)
            android.app.Activity r6 = r0.myContext
            android.content.res.Resources r6 = r6.getResources()
            java.lang.String r6 = r6.getString(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            stikerwap.appdys.config r7 = r0.globales
            android.app.Activity r8 = r0.myContext
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "fperfilgalv_"
            r10.<init>(r11)
            java.lang.String r11 = r4.idelem
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.io.File r7 = r7.getTempFile_libre(r8, r9)
            boolean r8 = r7.exists()
            if (r8 != 0) goto L_0x03e5
            android.widget.ImageView r7 = r3.iv_content
            r7.setImageResource(r15)
            android.widget.FrameLayout r7 = r3.fl_content
            r7.setVisibility(r13)
            boolean r4 = r4.carga_iniciada
            if (r4 != 0) goto L_0x06e3
            stikerwap.appdys.vistafb_adapter$DownloadAsyncTask_content r4 = new stikerwap.appdys.vistafb_adapter$DownloadAsyncTask_content
            r4.<init>()
            r1 = 1
            java.lang.Integer[] r1 = new java.lang.Integer[r1]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)
            r1[r13] = r5
            r4.execute(r1)
            goto L_0x06e3
        L_0x03e5:
            stikerwap.appdys.config r1 = r0.globales     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.net.Uri r4 = android.net.Uri.fromFile(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r5 = 300(0x12c, float:4.2E-43)
            android.graphics.Bitmap r1 = r1.decodeSampledBitmapFromResource(r4, r5, r5)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.widget.ImageView r4 = r3.iv_content     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r4.setImageBitmap(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.widget.ImageView r1 = r3.iv_play     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r1.setVisibility(r13)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.widget.FrameLayout r1 = r3.fl_content     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r1.setVisibility(r13)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            goto L_0x06e3
        L_0x0402:
            java.lang.String r7 = r4.tipo
            java.lang.String r10 = "4"
            boolean r7 = r7.equals(r10)
            java.lang.String r10 = "&rdquo;</b>"
            java.lang.String r11 = "<b>&ldquo;"
            if (r7 == 0) goto L_0x0450
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r12)
            android.app.Activity r5 = r0.myContext
            android.content.res.Resources r5 = r5.getResources()
            r6 = 2131886461(0x7f12017d, float:1.9407501E38)
            java.lang.String r5 = r5.getString(r6)
            r1.append(r5)
            java.lang.String r6 = r1.toString()
            android.widget.TextView r1 = r3.tv_content
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r11)
            java.lang.String r4 = r4.idelem_2
            r5.append(r4)
            r5.append(r10)
            java.lang.String r4 = r5.toString()
            android.text.Spanned r4 = android.text.Html.fromHtml(r4)
            r1.setText(r4)
            android.widget.TextView r1 = r3.tv_content
            r1.setVisibility(r13)
            goto L_0x06e3
        L_0x0450:
            java.lang.String r7 = r4.tipo
            java.lang.String r14 = "5"
            boolean r7 = r7.equals(r14)
            if (r7 == 0) goto L_0x049a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r12)
            android.app.Activity r5 = r0.myContext
            android.content.res.Resources r5 = r5.getResources()
            r6 = 2131886462(0x7f12017e, float:1.9407504E38)
            java.lang.String r5 = r5.getString(r6)
            r1.append(r5)
            java.lang.String r6 = r1.toString()
            android.widget.TextView r1 = r3.tv_content
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r11)
            java.lang.String r4 = r4.idelem_2
            r5.append(r4)
            r5.append(r10)
            java.lang.String r4 = r5.toString()
            android.text.Spanned r4 = android.text.Html.fromHtml(r4)
            r1.setText(r4)
            android.widget.TextView r1 = r3.tv_content
            r1.setVisibility(r13)
            goto L_0x06e3
        L_0x049a:
            java.lang.String r7 = r4.tipo
            java.lang.String r14 = "6"
            boolean r7 = r7.equals(r14)
            r14 = 2131886459(0x7f12017b, float:1.9407497E38)
            if (r7 == 0) goto L_0x04e4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r12)
            android.app.Activity r5 = r0.myContext
            android.content.res.Resources r5 = r5.getResources()
            java.lang.String r5 = r5.getString(r14)
            r1.append(r5)
            java.lang.String r6 = r1.toString()
            android.widget.TextView r1 = r3.tv_content
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r11)
            java.lang.String r4 = r4.idelem_2
            r5.append(r4)
            r5.append(r10)
            java.lang.String r4 = r5.toString()
            android.text.Spanned r4 = android.text.Html.fromHtml(r4)
            r1.setText(r4)
            android.widget.TextView r1 = r3.tv_content
            r1.setVisibility(r13)
            goto L_0x06e3
        L_0x04e4:
            java.lang.String r7 = r4.tipo
            java.lang.String r14 = "7"
            boolean r7 = r7.equals(r14)
            if (r7 == 0) goto L_0x056f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r12)
            android.app.Activity r6 = r0.myContext
            android.content.res.Resources r6 = r6.getResources()
            r8 = 2131886466(0x7f120182, float:1.9407512E38)
            java.lang.String r6 = r6.getString(r8)
            r7.append(r6)
            r7.append(r12)
            java.lang.String r6 = r4.idelem_2
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            stikerwap.appdys.config r7 = r0.globales
            android.app.Activity r8 = r0.myContext
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "game_banner"
            r10.<init>(r11)
            java.lang.String r11 = r4.idelem
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.io.File r7 = r7.getTempFile_libre(r8, r9)
            boolean r8 = r7.exists()
            if (r8 != 0) goto L_0x0557
            android.widget.ImageView r7 = r3.iv_content
            r7.setImageResource(r15)
            android.widget.FrameLayout r7 = r3.fl_content
            r7.setVisibility(r13)
            boolean r4 = r4.carga_iniciada
            if (r4 != 0) goto L_0x06e3
            stikerwap.appdys.vistafb_adapter$DownloadAsyncTask_content r4 = new stikerwap.appdys.vistafb_adapter$DownloadAsyncTask_content
            r4.<init>()
            r1 = 1
            java.lang.Integer[] r1 = new java.lang.Integer[r1]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)
            r1[r13] = r5
            r4.execute(r1)
            goto L_0x06e3
        L_0x0557:
            stikerwap.appdys.config r1 = r0.globales     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.net.Uri r4 = android.net.Uri.fromFile(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r5 = 300(0x12c, float:4.2E-43)
            android.graphics.Bitmap r1 = r1.decodeSampledBitmapFromResource(r4, r5, r5)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.widget.ImageView r4 = r3.iv_content     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r4.setImageBitmap(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.widget.FrameLayout r1 = r3.fl_content     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r1.setVisibility(r13)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            goto L_0x06e3
        L_0x056f:
            java.lang.String r7 = r4.tipo
            java.lang.String r14 = "8"
            boolean r7 = r7.equals(r14)
            if (r7 == 0) goto L_0x05b9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r12)
            android.app.Activity r5 = r0.myContext
            android.content.res.Resources r5 = r5.getResources()
            r6 = 2131886458(0x7f12017a, float:1.9407495E38)
            java.lang.String r5 = r5.getString(r6)
            r1.append(r5)
            java.lang.String r6 = r1.toString()
            android.widget.TextView r1 = r3.tv_content
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r11)
            java.lang.String r4 = r4.idelem_2
            r5.append(r4)
            r5.append(r10)
            java.lang.String r4 = r5.toString()
            android.text.Spanned r4 = android.text.Html.fromHtml(r4)
            r1.setText(r4)
            android.widget.TextView r1 = r3.tv_content
            r1.setVisibility(r13)
            goto L_0x06e3
        L_0x05b9:
            java.lang.String r7 = r4.tipo
            java.lang.String r14 = "9"
            boolean r7 = r7.equals(r14)
            if (r7 == 0) goto L_0x063e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r12)
            android.app.Activity r6 = r0.myContext
            android.content.res.Resources r6 = r6.getResources()
            java.lang.String r6 = r6.getString(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            stikerwap.appdys.config r7 = r0.globales
            android.app.Activity r8 = r0.myContext
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "fbuscvideo_"
            r10.<init>(r11)
            java.lang.String r11 = r4.idelem
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.io.File r7 = r7.getTempFile_libre(r8, r9)
            boolean r8 = r7.exists()
            if (r8 != 0) goto L_0x0621
            android.widget.ImageView r7 = r3.iv_content
            r7.setImageResource(r15)
            android.widget.FrameLayout r7 = r3.fl_content
            r7.setVisibility(r13)
            boolean r4 = r4.carga_iniciada
            if (r4 != 0) goto L_0x06e3
            stikerwap.appdys.vistafb_adapter$DownloadAsyncTask_content r4 = new stikerwap.appdys.vistafb_adapter$DownloadAsyncTask_content
            r4.<init>()
            r1 = 1
            java.lang.Integer[] r1 = new java.lang.Integer[r1]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)
            r1[r13] = r5
            r4.execute(r1)
            goto L_0x06e3
        L_0x0621:
            stikerwap.appdys.config r1 = r0.globales     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.net.Uri r4 = android.net.Uri.fromFile(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r5 = 300(0x12c, float:4.2E-43)
            android.graphics.Bitmap r1 = r1.decodeSampledBitmapFromResource(r4, r5, r5)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.widget.ImageView r4 = r3.iv_content     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r4.setImageBitmap(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.widget.ImageView r1 = r3.iv_play     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r1.setVisibility(r13)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            android.widget.FrameLayout r1 = r3.fl_content     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            r1.setVisibility(r13)     // Catch:{ Exception | OutOfMemoryError -> 0x06e3 }
            goto L_0x06e3
        L_0x063e:
            java.lang.String r1 = r4.tipo
            java.lang.String r5 = "10"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0687
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r12)
            android.app.Activity r5 = r0.myContext
            android.content.res.Resources r5 = r5.getResources()
            r6 = 2131886459(0x7f12017b, float:1.9407497E38)
            java.lang.String r5 = r5.getString(r6)
            r1.append(r5)
            java.lang.String r6 = r1.toString()
            android.widget.TextView r1 = r3.tv_content
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r11)
            java.lang.String r4 = r4.idelem_2
            r5.append(r4)
            r5.append(r10)
            java.lang.String r4 = r5.toString()
            android.text.Spanned r4 = android.text.Html.fromHtml(r4)
            r1.setText(r4)
            android.widget.TextView r1 = r3.tv_content
            r1.setVisibility(r13)
            goto L_0x06e3
        L_0x0687:
            java.lang.String r1 = r4.tipo
            java.lang.String r4 = "11"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x06e3
            java.lang.String r1 = r0.idi
            if (r1 == 0) goto L_0x06b5
            java.lang.String r4 = "es"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x06a7
            java.lang.String r1 = r0.idi
            java.lang.String r4 = "ca"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x06b5
        L_0x06a7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "A "
            r1.<init>(r4)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
        L_0x06b5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r12)
            android.app.Activity r4 = r0.myContext
            android.content.res.Resources r4 = r4.getResources()
            r5 = 2131886477(0x7f12018d, float:1.9407534E38)
            java.lang.String r4 = r4.getString(r5)
            r1.append(r4)
            java.lang.String r6 = r1.toString()
            boolean r1 = r0.c1_esclaro
            if (r1 == 0) goto L_0x06de
            android.widget.ImageView r1 = r3.iv_favorito_n
            r1.setVisibility(r13)
            goto L_0x06e3
        L_0x06de:
            android.widget.ImageView r1 = r3.iv_favorito_b
            r1.setVisibility(r13)
        L_0x06e3:
            android.widget.TextView r1 = r3.tv_descr
            android.text.Spanned r3 = android.text.Html.fromHtml(r6)
            r1.setText(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.vistafb_adapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private class DownloadAsyncTask_perfil extends AsyncTask<Integer, Void, Integer> {
        Integer ind;

        private DownloadAsyncTask_perfil() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(10:6|7|8|9|10|11|12|13|14|15) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x00b2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Integer... r13) {
            /*
                r12 = this;
                java.lang.String r0 = "fperfil_"
                r1 = 0
                r13 = r13[r1]
                r12.ind = r13
                stikerwap.appdys.vistafb_adapter r13 = stikerwap.appdys.vistafb_adapter.this
                java.util.ArrayList r13 = r13.datas
                java.lang.Integer r2 = r12.ind
                int r2 = r2.intValue()
                java.lang.Object r13 = r13.get(r2)
                stikerwap.appdys.widget_vistafb_item r13 = (stikerwap.appdys.widget_vistafb_item) r13
                java.lang.String r2 = r13.idusu
                java.lang.String r13 = r13.vfoto
                r3 = -1
                java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x0103 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0103 }
                r5.<init>()     // Catch:{ IOException -> 0x0103 }
                java.lang.String r6 = stikerwap.appdys.config.DOM_CDN     // Catch:{ IOException -> 0x0103 }
                r5.append(r6)     // Catch:{ IOException -> 0x0103 }
                java.lang.String r6 = "/srv/imgs/usus/"
                r5.append(r6)     // Catch:{ IOException -> 0x0103 }
                r5.append(r2)     // Catch:{ IOException -> 0x0103 }
                java.lang.String r6 = "_1_p.jpg?v="
                r5.append(r6)     // Catch:{ IOException -> 0x0103 }
                r5.append(r13)     // Catch:{ IOException -> 0x0103 }
                java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0103 }
                r4.<init>(r5)     // Catch:{ IOException -> 0x0103 }
                java.net.URLConnection r5 = r4.openConnection()     // Catch:{ IOException -> 0x0103 }
                java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ IOException -> 0x0103 }
                r6 = 1
                r5.setDoInput(r6)     // Catch:{ IOException -> 0x0103 }
                r7 = 5000(0x1388, float:7.006E-42)
                r5.setConnectTimeout(r7)     // Catch:{ IOException -> 0x0103 }
                r8 = 7000(0x1b58, float:9.809E-42)
                r5.setReadTimeout(r8)     // Catch:{ IOException -> 0x0103 }
                r5.connect()     // Catch:{ IOException -> 0x0103 }
                java.io.InputStream r9 = r5.getInputStream()     // Catch:{ IOException -> 0x0103 }
                android.graphics.BitmapFactory$Options r10 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x0103 }
                r10.<init>()     // Catch:{ IOException -> 0x0103 }
                r10.inJustDecodeBounds = r6     // Catch:{ IOException -> 0x0103 }
                r11 = 0
                android.graphics.BitmapFactory.decodeStream(r9, r11, r10)     // Catch:{ IOException -> 0x0103 }
                r9.close()     // Catch:{ IOException -> 0x0103 }
                r5.disconnect()     // Catch:{ IOException -> 0x0103 }
                stikerwap.appdys.vistafb_adapter r5 = stikerwap.appdys.vistafb_adapter.this     // Catch:{ IOException -> 0x0103 }
                stikerwap.appdys.config r5 = r5.globales     // Catch:{ IOException -> 0x0103 }
                r5 = 300(0x12c, float:4.2E-43)
                int r5 = stikerwap.appdys.config.calculateInSampleSize(r10, r5, r5)     // Catch:{ IOException -> 0x0103 }
                r10.inSampleSize = r5     // Catch:{ IOException -> 0x0103 }
                java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x0103 }
                java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x0103 }
                r4.setDoInput(r6)     // Catch:{ IOException -> 0x0103 }
                r4.setConnectTimeout(r7)     // Catch:{ IOException -> 0x0103 }
                r4.setReadTimeout(r8)     // Catch:{ IOException -> 0x0103 }
                r4.connect()     // Catch:{ IOException -> 0x0103 }
                java.io.InputStream r4 = r4.getInputStream()     // Catch:{ IOException -> 0x0103 }
                r10.inJustDecodeBounds = r1     // Catch:{ IOException -> 0x0103 }
                android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r4, r11, r10)     // Catch:{ IOException -> 0x0103 }
                r4.close()     // Catch:{ IOException -> 0x0103 }
                if (r5 != 0) goto L_0x009f
                java.lang.Integer r13 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x0103 }
                return r13
            L_0x009f:
                java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0103 }
                r4.<init>()     // Catch:{ IOException -> 0x0103 }
                android.graphics.Bitmap$CompressFormat r6 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x0103 }
                r7 = 100
                r5.compress(r6, r7, r4)     // Catch:{ IOException -> 0x0103 }
                byte[] r5 = r4.toByteArray()     // Catch:{ IOException -> 0x0103 }
                r4.close()     // Catch:{ IOException -> 0x00b2 }
            L_0x00b2:
                int r4 = r5.length     // Catch:{ IOException -> 0x0103 }
                android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeByteArray(r5, r1, r4)     // Catch:{ IOException -> 0x0103 }
                java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x0103 }
                stikerwap.appdys.vistafb_adapter r6 = stikerwap.appdys.vistafb_adapter.this     // Catch:{ IOException -> 0x0103 }
                java.io.File r6 = r6.path     // Catch:{ IOException -> 0x0103 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0103 }
                r8.<init>(r0)     // Catch:{ IOException -> 0x0103 }
                r8.append(r2)     // Catch:{ IOException -> 0x0103 }
                java.lang.String r9 = ".jpg"
                r8.append(r9)     // Catch:{ IOException -> 0x0103 }
                java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x0103 }
                r5.<init>(r6, r8)     // Catch:{ IOException -> 0x0103 }
                java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00fe }
                r6.<init>(r5)     // Catch:{ Exception -> 0x00fe }
                android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00fe }
                r4.compress(r5, r7, r6)     // Catch:{ Exception -> 0x00fe }
                stikerwap.appdys.vistafb_adapter r4 = stikerwap.appdys.vistafb_adapter.this     // Catch:{ Exception -> 0x00fe }
                android.content.SharedPreferences r4 = r4.settings     // Catch:{ Exception -> 0x00fe }
                android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ Exception -> 0x00fe }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fe }
                r5.<init>(r0)     // Catch:{ Exception -> 0x00fe }
                r5.append(r2)     // Catch:{ Exception -> 0x00fe }
                java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x00fe }
                r4.putString(r0, r13)     // Catch:{ Exception -> 0x00fe }
                r4.commit()     // Catch:{ Exception -> 0x00fe }
                java.lang.Integer r13 = java.lang.Integer.valueOf(r1)     // Catch:{ IOException -> 0x0103 }
                return r13
            L_0x00fe:
                java.lang.Integer r13 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x0103 }
                return r13
            L_0x0103:
                java.lang.Integer r13 = java.lang.Integer.valueOf(r3)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.vistafb_adapter.DownloadAsyncTask_perfil.doInBackground(java.lang.Integer[]):java.lang.Integer");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            ((widget_vistafb_item) vistafb_adapter.this.datas.get(this.ind.intValue())).cargando_perfil = false;
            vistafb_adapter.this.este.notifyDataSetChanged();
        }
    }

    private class DownloadAsyncTask_content extends AsyncTask<Integer, Void, Integer> {
        Integer ind;

        private DownloadAsyncTask_content() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x01e9 */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x020b A[Catch:{ Exception -> 0x0235 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Integer... r14) {
            /*
                r13 = this;
                r0 = 0
                r14 = r14[r0]
                r13.ind = r14
                stikerwap.appdys.vistafb_adapter r14 = stikerwap.appdys.vistafb_adapter.this
                java.util.ArrayList r14 = r14.datas
                java.lang.Integer r1 = r13.ind
                int r1 = r1.intValue()
                java.lang.Object r14 = r14.get(r1)
                stikerwap.appdys.widget_vistafb_item r14 = (stikerwap.appdys.widget_vistafb_item) r14
                boolean r1 = r14.carga_iniciada
                if (r1 == 0) goto L_0x0022
                r14 = 99
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                return r14
            L_0x0022:
                r1 = 1
                r14.carga_iniciada = r1
                r14.cargando_content = r1
                java.lang.String r2 = r14.tipo
                java.lang.String r3 = "1"
                boolean r2 = r2.equals(r3)
                java.lang.String r4 = "_g.jpg"
                java.lang.String r5 = "fperfil_"
                if (r2 == 0) goto L_0x006a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r6 = stikerwap.appdys.config.DOM_CDN
                r2.append(r6)
                java.lang.String r6 = "/srv/imgs/usus/"
                r2.append(r6)
                java.lang.String r6 = r14.idusu
                r2.append(r6)
                java.lang.String r6 = "_1.jpg?v="
                r2.append(r6)
                java.lang.String r6 = r14.vfoto
                r2.append(r6)
                java.lang.String r2 = r2.toString()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>(r5)
                java.lang.String r7 = r14.idusu
                r6.append(r7)
                r6.append(r4)
                java.lang.String r4 = r6.toString()
                goto L_0x0173
            L_0x006a:
                java.lang.String r2 = r14.tipo
                java.lang.String r6 = "2"
                boolean r2 = r2.equals(r6)
                java.lang.String r6 = "_"
                java.lang.String r7 = ".jpg"
                if (r2 == 0) goto L_0x00b0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = stikerwap.appdys.config.DOM_CDN
                r2.append(r8)
                java.lang.String r8 = "/srv/imgs/ususgal/"
                r2.append(r8)
                java.lang.String r8 = r14.idusu
                r2.append(r8)
                r2.append(r6)
                java.lang.String r6 = r14.idelem
                r2.append(r6)
                r2.append(r7)
                java.lang.String r2 = r2.toString()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "fperfilgal_"
                r6.<init>(r7)
                java.lang.String r7 = r14.idelem
                r6.append(r7)
                r6.append(r4)
                java.lang.String r4 = r6.toString()
                goto L_0x0173
            L_0x00b0:
                java.lang.String r2 = r14.tipo
                java.lang.String r4 = "3"
                boolean r2 = r2.equals(r4)
                java.lang.String r4 = "_th.jpg"
                if (r2 == 0) goto L_0x00f4
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = stikerwap.appdys.config.DOM_CDN
                r2.append(r8)
                java.lang.String r8 = "/srv/imgs/videos_pro/v"
                r2.append(r8)
                java.lang.String r8 = r14.idelem
                r2.append(r8)
                r2.append(r6)
                java.lang.String r6 = r14.idusu
                r2.append(r6)
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r6 = "fperfilgalv_"
                r4.<init>(r6)
                java.lang.String r6 = r14.idelem
                r4.append(r6)
                r4.append(r7)
                java.lang.String r4 = r4.toString()
                goto L_0x0173
            L_0x00f4:
                java.lang.String r2 = r14.tipo
                java.lang.String r8 = "7"
                boolean r2 = r2.equals(r8)
                if (r2 == 0) goto L_0x012f
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = stikerwap.appdys.config.DOM_CDN
                r2.append(r4)
                java.lang.String r4 = "/android-app-creator/game/promo"
                r2.append(r4)
                java.lang.String r4 = r14.idelem
                r2.append(r4)
                java.lang.String r4 = "/media/graphics/promo/banners/180x120.jpg"
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r6 = "game_banner"
                r4.<init>(r6)
                java.lang.String r6 = r14.idelem
                r4.append(r6)
                r4.append(r7)
                java.lang.String r4 = r4.toString()
                goto L_0x0173
            L_0x012f:
                java.lang.String r2 = r14.tipo
                java.lang.String r8 = "9"
                boolean r2 = r2.equals(r8)
                if (r2 == 0) goto L_0x0170
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = stikerwap.appdys.config.DOM_CDN
                r2.append(r8)
                java.lang.String r8 = "/srv/imgs/videos_busc/v"
                r2.append(r8)
                java.lang.String r8 = r14.idelem
                r2.append(r8)
                r2.append(r6)
                java.lang.String r6 = r14.idusu
                r2.append(r6)
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r6 = "fbuscvideo_"
                r4.<init>(r6)
                java.lang.String r6 = r14.idelem
                r4.append(r6)
                r4.append(r7)
                java.lang.String r4 = r4.toString()
                goto L_0x0173
            L_0x0170:
                java.lang.String r2 = ""
                r4 = r2
            L_0x0173:
                r6 = -1
                java.net.URL r7 = new java.net.URL     // Catch:{ IOException -> 0x023a }
                r7.<init>(r2)     // Catch:{ IOException -> 0x023a }
                java.net.URLConnection r2 = r7.openConnection()     // Catch:{ IOException -> 0x023a }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x023a }
                r2.setDoInput(r1)     // Catch:{ IOException -> 0x023a }
                r8 = 5000(0x1388, float:7.006E-42)
                r2.setConnectTimeout(r8)     // Catch:{ IOException -> 0x023a }
                r9 = 7000(0x1b58, float:9.809E-42)
                r2.setReadTimeout(r9)     // Catch:{ IOException -> 0x023a }
                r2.connect()     // Catch:{ IOException -> 0x023a }
                java.io.InputStream r10 = r2.getInputStream()     // Catch:{ IOException -> 0x023a }
                android.graphics.BitmapFactory$Options r11 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x023a }
                r11.<init>()     // Catch:{ IOException -> 0x023a }
                r11.inJustDecodeBounds = r1     // Catch:{ IOException -> 0x023a }
                r12 = 0
                android.graphics.BitmapFactory.decodeStream(r10, r12, r11)     // Catch:{ IOException -> 0x023a }
                r10.close()     // Catch:{ IOException -> 0x023a }
                r2.disconnect()     // Catch:{ IOException -> 0x023a }
                stikerwap.appdys.vistafb_adapter r2 = stikerwap.appdys.vistafb_adapter.this     // Catch:{ IOException -> 0x023a }
                stikerwap.appdys.config r2 = r2.globales     // Catch:{ IOException -> 0x023a }
                r2 = 300(0x12c, float:4.2E-43)
                int r2 = stikerwap.appdys.config.calculateInSampleSize(r11, r2, r2)     // Catch:{ IOException -> 0x023a }
                r11.inSampleSize = r2     // Catch:{ IOException -> 0x023a }
                java.net.URLConnection r2 = r7.openConnection()     // Catch:{ IOException -> 0x023a }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x023a }
                r2.setDoInput(r1)     // Catch:{ IOException -> 0x023a }
                r2.setConnectTimeout(r8)     // Catch:{ IOException -> 0x023a }
                r2.setReadTimeout(r9)     // Catch:{ IOException -> 0x023a }
                r2.connect()     // Catch:{ IOException -> 0x023a }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x023a }
                r11.inJustDecodeBounds = r0     // Catch:{ IOException -> 0x023a }
                android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1, r12, r11)     // Catch:{ IOException -> 0x023a }
                r1.close()     // Catch:{ IOException -> 0x023a }
                if (r2 != 0) goto L_0x01d6
                java.lang.Integer r14 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x023a }
                return r14
            L_0x01d6:
                java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x023a }
                r1.<init>()     // Catch:{ IOException -> 0x023a }
                android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x023a }
                r8 = 100
                r2.compress(r7, r8, r1)     // Catch:{ IOException -> 0x023a }
                byte[] r2 = r1.toByteArray()     // Catch:{ IOException -> 0x023a }
                r1.close()     // Catch:{ IOException -> 0x01e9 }
            L_0x01e9:
                int r1 = r2.length     // Catch:{ IOException -> 0x023a }
                android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r2, r0, r1)     // Catch:{ IOException -> 0x023a }
                java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x023a }
                stikerwap.appdys.vistafb_adapter r7 = stikerwap.appdys.vistafb_adapter.this     // Catch:{ IOException -> 0x023a }
                java.io.File r7 = r7.path     // Catch:{ IOException -> 0x023a }
                r2.<init>(r7, r4)     // Catch:{ IOException -> 0x023a }
                java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0235 }
                r4.<init>(r2)     // Catch:{ Exception -> 0x0235 }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0235 }
                r1.compress(r2, r8, r4)     // Catch:{ Exception -> 0x0235 }
                java.lang.String r1 = r14.tipo     // Catch:{ Exception -> 0x0235 }
                boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0235 }
                if (r1 == 0) goto L_0x0230
                stikerwap.appdys.vistafb_adapter r1 = stikerwap.appdys.vistafb_adapter.this     // Catch:{ Exception -> 0x0235 }
                android.content.SharedPreferences r1 = r1.settings     // Catch:{ Exception -> 0x0235 }
                android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ Exception -> 0x0235 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235 }
                r2.<init>(r5)     // Catch:{ Exception -> 0x0235 }
                java.lang.String r3 = r14.idusu     // Catch:{ Exception -> 0x0235 }
                r2.append(r3)     // Catch:{ Exception -> 0x0235 }
                java.lang.String r3 = "_g"
                r2.append(r3)     // Catch:{ Exception -> 0x0235 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0235 }
                java.lang.String r14 = r14.vfoto     // Catch:{ Exception -> 0x0235 }
                r1.putString(r2, r14)     // Catch:{ Exception -> 0x0235 }
                r1.commit()     // Catch:{ Exception -> 0x0235 }
            L_0x0230:
                java.lang.Integer r14 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x023a }
                return r14
            L_0x0235:
                java.lang.Integer r14 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x023a }
                return r14
            L_0x023a:
                java.lang.Integer r14 = java.lang.Integer.valueOf(r6)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.vistafb_adapter.DownloadAsyncTask_content.doInBackground(java.lang.Integer[]):java.lang.Integer");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            if (num.intValue() != 99) {
                ((widget_vistafb_item) vistafb_adapter.this.datas.get(this.ind.intValue())).cargando_content = false;
                if (num.intValue() == -1) {
                    ((widget_vistafb_item) vistafb_adapter.this.datas.get(this.ind.intValue())).error_content = true;
                }
                vistafb_adapter.this.este.notifyDataSetChanged();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x04db  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x058e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clicat(int r58) {
        /*
            r57 = this;
            r0 = r57
            java.util.ArrayList<stikerwap.appdys.widget_vistafb_item> r1 = r0.datas
            r2 = r58
            java.lang.Object r1 = r1.get(r2)
            stikerwap.appdys.widget_vistafb_item r1 = (stikerwap.appdys.widget_vistafb_item) r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.SharedPreferences r3 = r0.settings
            java.lang.String r4 = "idusu"
            r5 = 0
            long r3 = r3.getLong(r4, r5)
            r2.append(r3)
            java.lang.String r3 = ""
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.content.SharedPreferences r3 = r0.settings
            java.lang.String r4 = "nick"
            java.lang.String r5 = ""
            java.lang.String r3 = r3.getString(r4, r5)
            java.lang.String r4 = r1.tipo
            java.lang.String r5 = r1.idusu
            java.lang.String r6 = r1.idelem
            java.lang.String r7 = r1.idelem_2
            java.lang.String r7 = r1.idelem_3
            java.lang.String r8 = r1.privados
            java.lang.String r9 = r1.nick
            java.lang.String r10 = r1.coments
            java.lang.String r11 = r1.fnac_d
            java.lang.String r12 = r1.fnac_m
            java.lang.String r13 = r1.fnac_a
            java.lang.String r14 = r1.sexo
            java.lang.String r15 = r1.vfoto
            r58 = r7
            java.lang.String r7 = r1.fnac_chat
            r16 = r6
            java.lang.String r6 = r1.sexo_chat
            r17 = r6
            java.lang.String r6 = r1.descr_chat
            r18 = r6
            java.lang.String r6 = r1.dist_chat
            r19 = r6
            java.lang.String r6 = r1.coments_chat
            r20 = r6
            java.lang.String r6 = r1.galeria_chat
            r21 = r6
            java.lang.String r6 = r1.privados_chat
            r22 = r6
            java.lang.String r6 = r1.fotos_perfil
            r23 = r6
            java.lang.String r6 = r1.fotos_chat
            java.lang.String r1 = r1.fcrea
            r24 = r1
            android.content.Intent r1 = new android.content.Intent
            r25 = r6
            android.app.Activity r6 = r0.myContext
            java.lang.Class<stikerwap.appdys.preinicio> r0 = stikerwap.appdys.preinicio.class
            r1.<init>(r6, r0)
            java.lang.String r0 = "4"
            boolean r0 = r4.equals(r0)
            java.lang.String r6 = "abrir_perfilv"
            r26 = r6
            java.lang.String r6 = "1"
            r27 = r6
            java.lang.String r6 = "nombre"
            r28 = r7
            java.lang.String r7 = "abrir_buscvideo_vfoto"
            r29 = r7
            java.lang.String r7 = "abrir_buscvideo_nombre"
            r30 = r7
            java.lang.String r7 = "abrir_buscvideo_idusu"
            r31 = r7
            java.lang.String r7 = "abrir_buscvideo"
            r32 = r7
            java.lang.String r7 = "abrir_idresp"
            r33 = r7
            java.lang.String r7 = "abrir_idcat"
            r34 = r7
            java.lang.String r7 = "fotos_chat"
            r35 = r7
            java.lang.String r7 = "fotos_perfil"
            r36 = r7
            java.lang.String r7 = "privados_chat"
            r37 = r7
            java.lang.String r7 = "galeria"
            r38 = r7
            java.lang.String r7 = "coments_chat"
            r39 = r7
            java.lang.String r7 = "p_dist"
            r40 = r7
            java.lang.String r7 = "p_descr"
            r41 = r7
            java.lang.String r7 = "p_sexo"
            r42 = r7
            java.lang.String r7 = "p_fnac"
            r43 = r7
            java.lang.String r7 = "coments"
            r44 = r15
            java.lang.String r15 = "abrir_perfil"
            r45 = r14
            java.lang.String r14 = "abrir_idtema"
            r46 = r14
            java.lang.String r14 = "abrir_idsecc"
            if (r0 != 0) goto L_0x02de
            java.lang.String r0 = "5"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x00e6
            goto L_0x02de
        L_0x00e6:
            java.lang.String r0 = "9"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x0229
            java.lang.String r0 = "10"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x011c
            r17 = r6
            r18 = r8
            r0 = r16
            r47 = r27
            r48 = r36
            r49 = r37
            r50 = r38
            r51 = r39
            r52 = r40
            r53 = r41
            r54 = r42
            r55 = r43
            r6 = r45
            r16 = r15
            r15 = r44
            r56 = r7
            r7 = r58
            r58 = r56
            goto L_0x024d
        L_0x011c:
            java.lang.String r0 = "6"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x0134
            java.lang.String r0 = "8"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x012d
            goto L_0x0134
        L_0x012d:
            r1.putExtra(r15, r5)
            r1.putExtra(r6, r9)
            goto L_0x013a
        L_0x0134:
            r1.putExtra(r15, r2)
            r1.putExtra(r6, r3)
        L_0x013a:
            java.lang.String r0 = "privados"
            r1.putExtra(r0, r8)
            r1.putExtra(r7, r10)
            java.lang.String r0 = "fnac_d"
            r1.putExtra(r0, r11)
            java.lang.String r0 = "fnac_m"
            r1.putExtra(r0, r12)
            java.lang.String r0 = "fnac_a"
            r1.putExtra(r0, r13)
            java.lang.String r0 = "sexo"
            r2 = r45
            r1.putExtra(r0, r2)
            java.lang.String r0 = "vfoto"
            r2 = r44
            r1.putExtra(r0, r2)
            int r0 = java.lang.Integer.parseInt(r28)
            r2 = r43
            r1.putExtra(r2, r0)
            int r0 = java.lang.Integer.parseInt(r17)
            r3 = r42
            r1.putExtra(r3, r0)
            int r0 = java.lang.Integer.parseInt(r18)
            r5 = r41
            r1.putExtra(r5, r0)
            int r0 = java.lang.Integer.parseInt(r19)
            r8 = r40
            r1.putExtra(r8, r0)
            r0 = r20
            r9 = r27
            boolean r0 = r0.equals(r9)
            r10 = r39
            r1.putExtra(r10, r0)
            r0 = r21
            boolean r0 = r0.equals(r9)
            r11 = r38
            r1.putExtra(r11, r0)
            r0 = r22
            boolean r0 = r0.equals(r9)
            r12 = r37
            r1.putExtra(r12, r0)
            int r0 = java.lang.Integer.parseInt(r23)
            r13 = r36
            r1.putExtra(r13, r0)
            int r0 = java.lang.Integer.parseInt(r25)
            r17 = r6
            r6 = r35
            r1.putExtra(r6, r0)
            java.lang.String r0 = "6"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x01f0
            r35 = r6
            r0 = r16
            r6 = r26
            r1.putExtra(r6, r0)
            java.lang.String r0 = "abrir_perfilv_formato"
            r4 = r58
            r1.putExtra(r0, r4)
            r55 = r2
            r54 = r3
            r53 = r5
            r58 = r7
            r52 = r8
            r47 = r9
            r51 = r10
            r50 = r11
            r49 = r12
            r48 = r13
            r16 = r15
            r8 = r29
            r5 = r30
            r0 = r31
            goto L_0x02d6
        L_0x01f0:
            r43 = r2
            r35 = r6
            r0 = r16
            r6 = r26
            java.lang.String r2 = "7"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0205
            java.lang.String r2 = "abrir_game"
            r1.putExtra(r2, r0)
        L_0x0205:
            r54 = r3
            r53 = r5
            r26 = r6
            r58 = r7
            r52 = r8
            r47 = r9
            r51 = r10
            r50 = r11
            r49 = r12
            r48 = r13
            r16 = r15
            r8 = r29
            r5 = r30
            r0 = r31
            r7 = r33
            r4 = r34
            r55 = r43
            goto L_0x02da
        L_0x0229:
            r17 = r6
            r0 = r16
            r47 = r27
            r48 = r36
            r49 = r37
            r50 = r38
            r51 = r39
            r52 = r40
            r53 = r41
            r54 = r42
            r55 = r43
            r6 = r45
            r16 = r15
            r15 = r44
            r56 = r7
            r7 = r58
            r58 = r56
            r18 = r8
        L_0x024d:
            java.lang.String r8 = "-"
            java.lang.String[] r7 = r7.split(r8)
            r8 = 1
            r8 = r7[r8]
            r1.putExtra(r14, r8)
            r8 = r32
            r1.putExtra(r8, r0)
            r0 = 0
            r0 = r7[r0]
            java.lang.String r8 = "abrir_buscvideo_formato"
            r1.putExtra(r8, r0)
            java.lang.String r0 = "9"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x027e
            r0 = r31
            r1.putExtra(r0, r5)
            r5 = r30
            r1.putExtra(r5, r9)
            r8 = r29
            r1.putExtra(r8, r15)
            goto L_0x028f
        L_0x027e:
            r8 = r29
            r5 = r30
            r0 = r31
            r1.putExtra(r0, r2)
            r1.putExtra(r5, r3)
            java.lang.String r2 = "99999999"
            r1.putExtra(r8, r2)
        L_0x028f:
            r2 = 2
            r2 = r7[r2]
            java.lang.String r3 = "abrir_buscvideo_nlikes"
            r1.putExtra(r3, r2)
            r2 = 4
            r2 = r7[r2]
            java.lang.String r3 = "abrir_buscvideo_liked"
            r1.putExtra(r3, r2)
            r2 = 3
            r2 = r7[r2]
            java.lang.String r3 = "abrir_buscvideo_descr"
            r1.putExtra(r3, r2)
            r2 = 5
            r2 = r7[r2]
            java.lang.String r3 = "abrir_buscvideo_nvideos"
            r1.putExtra(r3, r2)
            java.lang.String r2 = "abrir_buscvideo_fcrea"
            r3 = r24
            r1.putExtra(r2, r3)
            java.lang.String r2 = "abrir_buscvideo_coments"
            r1.putExtra(r2, r10)
            java.lang.String r2 = "abrir_buscvideo_fnac_d"
            r1.putExtra(r2, r11)
            java.lang.String r2 = "abrir_buscvideo_fnac_m"
            r1.putExtra(r2, r12)
            java.lang.String r2 = "abrir_buscvideo_fnac_a"
            r1.putExtra(r2, r13)
            java.lang.String r2 = "abrir_buscvideo_sexo"
            r1.putExtra(r2, r6)
            java.lang.String r2 = "abrir_buscvideo_privados"
            r3 = r18
            r1.putExtra(r2, r3)
        L_0x02d6:
            r7 = r33
            r4 = r34
        L_0x02da:
            r6 = r46
            goto L_0x034f
        L_0x02de:
            r17 = r6
            r16 = r15
            r47 = r27
            r8 = r29
            r5 = r30
            r0 = r31
            r48 = r36
            r49 = r37
            r50 = r38
            r51 = r39
            r52 = r40
            r53 = r41
            r54 = r42
            r55 = r43
            r56 = r7
            r7 = r58
            r58 = r56
            java.lang.String r2 = "-"
            java.lang.String[] r2 = r7.split(r2)
            r3 = 0
            r3 = r2[r3]
            r1.putExtra(r14, r3)
            java.lang.String r3 = "4"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x032f
            r3 = 1
            r3 = r2[r3]
            r4 = r34
            r1.putExtra(r4, r3)
            r3 = 2
            r3 = r2[r3]
            r6 = r46
            r1.putExtra(r6, r3)
            r3 = 3
            r2 = r2[r3]
            java.lang.String r3 = "idresp_ir"
            r1.putExtra(r3, r2)
            r7 = r33
            goto L_0x034f
        L_0x032f:
            r4 = r34
            r6 = r46
            r3 = 1
            r3 = r2[r3]
            r1.putExtra(r4, r3)
            r3 = 2
            r3 = r2[r3]
            r1.putExtra(r6, r3)
            r3 = 3
            r3 = r2[r3]
            r7 = r33
            r1.putExtra(r7, r3)
            r3 = 4
            r2 = r2[r3]
            java.lang.String r3 = "idcoment_ir"
            r1.putExtra(r3, r2)
        L_0x034f:
            android.os.Bundle r1 = r1.getExtras()
            if (r1 == 0) goto L_0x03b2
            java.lang.String r2 = r1.getString(r6)
            if (r2 == 0) goto L_0x03b2
            java.util.ArrayList<java.lang.Integer> r0 = stikerwap.appdys.config.secciones_alist
            java.lang.String r2 = r1.getString(r14)
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r0 = r0.indexOf(r2)
            r2 = r57
            stikerwap.appdys.config r3 = r2.globales
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            android.app.Activity r5 = r2.myContext
            stikerwap.appdys.ResultGetIntent r0 = r3.crear_rgi(r0, r5)
            android.content.Intent r0 = r0.i
            java.lang.String r3 = r1.getString(r4)
            r0.putExtra(r4, r3)
            java.lang.String r3 = r1.getString(r6)
            r0.putExtra(r6, r3)
            java.lang.String r3 = r1.getString(r7)
            if (r3 == 0) goto L_0x03a5
            java.lang.String r3 = r1.getString(r7)
            r0.putExtra(r7, r3)
            java.lang.String r3 = "idcoment_ir"
            java.lang.String r1 = r1.getString(r3)
            java.lang.String r3 = "idcoment_ir"
            r0.putExtra(r3, r1)
            goto L_0x065b
        L_0x03a5:
            java.lang.String r3 = "idresp_ir"
            java.lang.String r1 = r1.getString(r3)
            java.lang.String r3 = "idresp_ir"
            r0.putExtra(r3, r1)
            goto L_0x065b
        L_0x03b2:
            r2 = r57
            if (r1 == 0) goto L_0x0488
            r3 = r32
            java.lang.String r4 = r1.getString(r3)
            if (r4 == 0) goto L_0x0488
            java.util.ArrayList<java.lang.Integer> r4 = stikerwap.appdys.config.secciones_alist
            java.lang.String r6 = r1.getString(r14)
            int r6 = java.lang.Integer.parseInt(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            int r4 = r4.indexOf(r6)
            stikerwap.appdys.config r6 = r2.globales
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            android.app.Activity r7 = r2.myContext
            stikerwap.appdys.ResultGetIntent r4 = r6.crear_rgi(r4, r7)
            android.content.Intent r4 = r4.i
            java.lang.String r6 = r1.getString(r14)
            r4.putExtra(r14, r6)
            java.lang.String r6 = r1.getString(r3)
            r4.putExtra(r3, r6)
            java.lang.String r3 = "abrir_buscvideo_formato"
            java.lang.String r3 = r1.getString(r3)
            java.lang.String r6 = "abrir_buscvideo_formato"
            r4.putExtra(r6, r3)
            java.lang.String r3 = r1.getString(r0)
            r4.putExtra(r0, r3)
            java.lang.String r0 = r1.getString(r5)
            r4.putExtra(r5, r0)
            java.lang.String r0 = "abrir_buscvideo_nlikes"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "abrir_buscvideo_nlikes"
            r4.putExtra(r3, r0)
            java.lang.String r0 = "abrir_buscvideo_liked"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "abrir_buscvideo_liked"
            r4.putExtra(r3, r0)
            java.lang.String r0 = "abrir_buscvideo_descr"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "abrir_buscvideo_descr"
            r4.putExtra(r3, r0)
            java.lang.String r0 = "abrir_buscvideo_nvideos"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "abrir_buscvideo_nvideos"
            r4.putExtra(r3, r0)
            java.lang.String r0 = "abrir_buscvideo_fcrea"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "abrir_buscvideo_fcrea"
            r4.putExtra(r3, r0)
            java.lang.String r0 = "abrir_buscvideo_coments"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "abrir_buscvideo_coments"
            r4.putExtra(r3, r0)
            java.lang.String r0 = "abrir_buscvideo_fnac_d"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "abrir_buscvideo_fnac_d"
            r4.putExtra(r3, r0)
            java.lang.String r0 = "abrir_buscvideo_fnac_m"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "abrir_buscvideo_fnac_m"
            r4.putExtra(r3, r0)
            java.lang.String r0 = "abrir_buscvideo_fnac_a"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "abrir_buscvideo_fnac_a"
            r4.putExtra(r3, r0)
            java.lang.String r0 = "abrir_buscvideo_sexo"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "abrir_buscvideo_sexo"
            r4.putExtra(r3, r0)
            java.lang.String r0 = "abrir_buscvideo_privados"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "abrir_buscvideo_privados"
            r4.putExtra(r3, r0)
            java.lang.String r0 = r1.getString(r8)
            r4.putExtra(r8, r0)
            r0 = r4
            goto L_0x065b
        L_0x0488:
            if (r1 == 0) goto L_0x065a
            r0 = r16
            java.lang.String r3 = r1.getString(r0)
            if (r3 == 0) goto L_0x065a
            r3 = r26
            boolean r4 = r1.containsKey(r3)
            if (r4 == 0) goto L_0x04cd
            java.lang.String r4 = "abrir_perfilv_formato"
            java.lang.String r4 = r1.getString(r4)
            r5 = r47
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x04ab
            java.lang.String r4 = "mp4"
            goto L_0x04cf
        L_0x04ab:
            java.lang.String r4 = "abrir_perfilv_formato"
            java.lang.String r4 = r1.getString(r4)
            java.lang.String r5 = "2"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x04bc
            java.lang.String r4 = "3gp"
            goto L_0x04cf
        L_0x04bc:
            java.lang.String r4 = "abrir_perfilv_formato"
            java.lang.String r4 = r1.getString(r4)
            java.lang.String r5 = "3"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x04cd
            java.lang.String r4 = "webm"
            goto L_0x04cf
        L_0x04cd:
            java.lang.String r4 = ""
        L_0x04cf:
            boolean r5 = r1.containsKey(r3)
            if (r5 == 0) goto L_0x058e
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x058e
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = r1.getString(r3)
            android.content.Intent r5 = new android.content.Intent
            android.app.Activity r6 = r2.myContext
            java.lang.Class<stikerwap.appdys.t_video_pro> r7 = stikerwap.appdys.t_video_pro.class
            r5.<init>(r6, r7)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "https://video."
            r6.<init>(r7)
            java.lang.String r7 = stikerwap.appdys.config.DOM_EDROID
            r6.append(r7)
            java.lang.String r7 = "/files_pro/v"
            r6.append(r7)
            r6.append(r3)
            java.lang.String r7 = "_"
            r6.append(r7)
            r6.append(r0)
            java.lang.String r7 = "."
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.String r6 = "url"
            r5.putExtra(r6, r4)
            stikerwap.appdys.config r4 = r2.globales
            int r4 = r4.ind_secc_sel_2
            java.lang.String r6 = "ind"
            r5.putExtra(r6, r4)
            java.lang.String r4 = "idv"
            r5.putExtra(r4, r3)
            java.lang.String r3 = "indv"
            r4 = -1
            r5.putExtra(r3, r4)
            java.lang.String r3 = "idusu_profile"
            r5.putExtra(r3, r0)
            r3 = r58
            java.lang.String r0 = r1.getString(r3)
            r5.putExtra(r3, r0)
            r4 = r55
            int r0 = r1.getInt(r4)
            r5.putExtra(r4, r0)
            r6 = r54
            int r0 = r1.getInt(r6)
            r5.putExtra(r6, r0)
            r7 = r53
            int r0 = r1.getInt(r7)
            r5.putExtra(r7, r0)
            r8 = r52
            int r0 = r1.getInt(r8)
            r5.putExtra(r8, r0)
            r9 = r51
            boolean r0 = r1.getBoolean(r9)
            r5.putExtra(r9, r0)
            r10 = r50
            boolean r0 = r1.getBoolean(r10)
            r5.putExtra(r10, r0)
            r11 = r49
            boolean r0 = r1.getBoolean(r11)
            r5.putExtra(r11, r0)
            r12 = r48
            int r0 = r1.getInt(r12)
            r5.putExtra(r12, r0)
            r13 = r35
            int r0 = r1.getInt(r13)
            r5.putExtra(r13, r0)
            goto L_0x0658
        L_0x058e:
            r3 = r58
            r13 = r35
            r12 = r48
            r11 = r49
            r10 = r50
            r9 = r51
            r8 = r52
            r7 = r53
            r6 = r54
            r4 = r55
            android.content.Intent r5 = new android.content.Intent
            android.app.Activity r14 = r2.myContext
            java.lang.Class<stikerwap.appdys.profile> r15 = stikerwap.appdys.profile.class
            r5.<init>(r14, r15)
            java.lang.String r14 = "id"
            java.lang.String r0 = r1.getString(r0)
            r5.putExtra(r14, r0)
            java.lang.String r0 = "privados"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r14 = "privados"
            r5.putExtra(r14, r0)
            r0 = r17
            java.lang.String r14 = r1.getString(r0)
            r5.putExtra(r0, r14)
            java.lang.String r0 = r1.getString(r3)
            r5.putExtra(r3, r0)
            java.lang.String r0 = "fnac_d"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "fnac_d"
            r5.putExtra(r3, r0)
            java.lang.String r0 = "fnac_m"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "fnac_m"
            r5.putExtra(r3, r0)
            java.lang.String r0 = "fnac_a"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "fnac_a"
            r5.putExtra(r3, r0)
            java.lang.String r0 = "sexo"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "sexo"
            r5.putExtra(r3, r0)
            java.lang.String r0 = "vfoto"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r3 = "vfoto"
            r5.putExtra(r3, r0)
            int r0 = r1.getInt(r4)
            r5.putExtra(r4, r0)
            int r0 = r1.getInt(r6)
            r5.putExtra(r6, r0)
            int r0 = r1.getInt(r7)
            r5.putExtra(r7, r0)
            int r0 = r1.getInt(r8)
            r5.putExtra(r8, r0)
            boolean r0 = r1.getBoolean(r9)
            r5.putExtra(r9, r0)
            boolean r0 = r1.getBoolean(r10)
            r5.putExtra(r10, r0)
            boolean r0 = r1.getBoolean(r11)
            r5.putExtra(r11, r0)
            int r0 = r1.getInt(r12)
            r5.putExtra(r12, r0)
            int r0 = r1.getInt(r13)
            r5.putExtra(r13, r0)
            java.lang.String r0 = "abrir_game"
            boolean r0 = r1.containsKey(r0)
            if (r0 == 0) goto L_0x0658
            java.lang.String r0 = "abrir_game"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r1 = "abrir_game"
            r5.putExtra(r1, r0)
        L_0x0658:
            r0 = r5
            goto L_0x065b
        L_0x065a:
            r0 = 0
        L_0x065b:
            if (r0 == 0) goto L_0x0663
            android.app.Activity r1 = r2.myContext
            r3 = 0
            r1.startActivityForResult(r0, r3)
        L_0x0663:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.vistafb_adapter.clicat(int):void");
    }
}
