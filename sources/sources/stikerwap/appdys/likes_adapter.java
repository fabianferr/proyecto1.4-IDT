package stikerwap.appdys;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.io.File;
import java.util.ArrayList;

public class likes_adapter extends ArrayAdapter<likes_item> {
    /* access modifiers changed from: private */
    public ArrayList<likes_item> datas;
    /* access modifiers changed from: private */
    public likes_adapter este;
    config globales;
    private String idusu;
    protected boolean mostrar_imgs = true;
    private Activity myContext;
    File path;
    SharedPreferences settings;

    public likes_adapter(Context context, int i, ArrayList<likes_item> arrayList, long j) {
        super(context, i, arrayList);
        Activity activity = (Activity) context;
        this.myContext = activity;
        this.globales = (config) activity.getApplicationContext();
        this.datas = arrayList;
        this.este = this;
        this.path = context.getFilesDir();
        this.settings = context.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.idusu = j + "";
    }

    static class ViewHolder {
        ImageView fav;
        FrameLayout fl_img;
        ImageView iv;
        LinearLayout ll_info;
        LinearLayout ll_mas;
        ProgressBar pb_img;
        TextView tv_nombre;

        ViewHolder() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0160, code lost:
        if (r5.getString("fperfil_" + r8.datas.get(r9).id, "0").equals(r8.datas.get(r9).vfoto_bd) == false) goto L_0x0162;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
            r8 = this;
            if (r10 != 0) goto L_0x0066
            android.app.Activity r10 = r8.myContext
            android.view.LayoutInflater r10 = r10.getLayoutInflater()
            r11 = 2131558531(0x7f0d0083, float:1.874238E38)
            r0 = 0
            android.view.View r10 = r10.inflate(r11, r0)
            stikerwap.appdys.likes_adapter$ViewHolder r11 = new stikerwap.appdys.likes_adapter$ViewHolder
            r11.<init>()
            r0 = 2131362309(0x7f0a0205, float:1.8344395E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r11.fl_img = r0
            r0 = 2131362534(0x7f0a02e6, float:1.8344851E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            r11.pb_img = r0
            r0 = 2131362533(0x7f0a02e5, float:1.834485E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r11.iv = r0
            r0 = 2131362535(0x7f0a02e7, float:1.8344853E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r11.tv_nombre = r0
            r0 = 2131362620(0x7f0a033c, float:1.8345026E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r11.ll_info = r0
            r0 = 2131362621(0x7f0a033d, float:1.8345028E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r11.ll_mas = r0
            r0 = 2131362532(0x7f0a02e4, float:1.8344847E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r11.fav = r0
            r10.setTag(r11)
            goto L_0x006c
        L_0x0066:
            java.lang.Object r11 = r10.getTag()
            stikerwap.appdys.likes_adapter$ViewHolder r11 = (stikerwap.appdys.likes_adapter.ViewHolder) r11
        L_0x006c:
            java.util.ArrayList<stikerwap.appdys.likes_item> r0 = r8.datas
            java.lang.Object r0 = r0.get(r9)
            stikerwap.appdys.likes_item r0 = (stikerwap.appdys.likes_item) r0
            boolean r0 = r0.es_mas
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L_0x0087
            android.widget.LinearLayout r9 = r11.ll_mas
            r9.setVisibility(r1)
            android.widget.LinearLayout r9 = r11.ll_info
            r9.setVisibility(r2)
            goto L_0x01bd
        L_0x0087:
            android.widget.ImageView r0 = r11.fav
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r11.ll_mas
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r11.ll_info
            r0.setVisibility(r1)
            java.util.ArrayList<stikerwap.appdys.likes_item> r0 = r8.datas
            java.lang.Object r0 = r0.get(r9)
            stikerwap.appdys.likes_item r0 = (stikerwap.appdys.likes_item) r0
            boolean r0 = r0.fav
            if (r0 == 0) goto L_0x00a7
            android.widget.ImageView r0 = r11.fav
            r0.setVisibility(r1)
        L_0x00a7:
            boolean r0 = r8.mostrar_imgs
            if (r0 != 0) goto L_0x00b2
            android.widget.FrameLayout r0 = r11.fl_img
            r0.setVisibility(r2)
            goto L_0x01ae
        L_0x00b2:
            android.widget.ProgressBar r0 = r11.pb_img
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r11.iv
            r0.setVisibility(r1)
            java.util.ArrayList<stikerwap.appdys.likes_item> r0 = r8.datas
            java.lang.Object r0 = r0.get(r9)
            stikerwap.appdys.likes_item r0 = (stikerwap.appdys.likes_item) r0
            boolean r0 = r0.t_img
            if (r0 != 0) goto L_0x00dc
            android.widget.ImageView r0 = r11.iv
            android.app.Activity r1 = r8.myContext
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2131231691(0x7f0803cb, float:1.807947E38)
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            r0.setImageDrawable(r1)
            goto L_0x01ae
        L_0x00dc:
            java.util.ArrayList<stikerwap.appdys.likes_item> r0 = r8.datas
            java.lang.Object r0 = r0.get(r9)
            stikerwap.appdys.likes_item r0 = (stikerwap.appdys.likes_item) r0
            java.lang.String r0 = r0.id
            java.lang.String r3 = r8.idusu
            boolean r0 = r0.equals(r3)
            r3 = 1
            java.lang.String r4 = "fperfil_"
            if (r0 == 0) goto L_0x00fa
            stikerwap.appdys.config r0 = r8.globales
            android.app.Activity r5 = r8.myContext
            java.io.File r0 = r0.getTempFile(r5, r3)
            goto L_0x011c
        L_0x00fa:
            java.io.File r0 = new java.io.File
            java.io.File r5 = r8.path
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r4)
            java.util.ArrayList<stikerwap.appdys.likes_item> r7 = r8.datas
            java.lang.Object r7 = r7.get(r9)
            stikerwap.appdys.likes_item r7 = (stikerwap.appdys.likes_item) r7
            java.lang.String r7 = r7.id
            r6.append(r7)
            java.lang.String r7 = ".jpg"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r0.<init>(r5, r6)
        L_0x011c:
            java.util.ArrayList<stikerwap.appdys.likes_item> r5 = r8.datas
            java.lang.Object r5 = r5.get(r9)
            stikerwap.appdys.likes_item r5 = (stikerwap.appdys.likes_item) r5
            java.lang.String r5 = r5.id
            java.lang.String r6 = r8.idusu
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x019c
            boolean r5 = r0.exists()
            if (r5 == 0) goto L_0x0162
            android.content.SharedPreferences r5 = r8.settings
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r4)
            java.util.ArrayList<stikerwap.appdys.likes_item> r4 = r8.datas
            java.lang.Object r4 = r4.get(r9)
            stikerwap.appdys.likes_item r4 = (stikerwap.appdys.likes_item) r4
            java.lang.String r4 = r4.id
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.String r6 = "0"
            java.lang.String r4 = r5.getString(r4, r6)
            java.util.ArrayList<stikerwap.appdys.likes_item> r5 = r8.datas
            java.lang.Object r5 = r5.get(r9)
            stikerwap.appdys.likes_item r5 = (stikerwap.appdys.likes_item) r5
            java.lang.String r5 = r5.vfoto_bd
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x019c
        L_0x0162:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 20
            if (r0 <= r4) goto L_0x0171
            android.widget.ProgressBar r0 = r11.pb_img
            stikerwap.appdys.config r4 = r8.globales
            java.lang.String r4 = r4.c_icos
            stikerwap.appdys.config.progress_color(r0, r4)
        L_0x0171:
            android.widget.ProgressBar r0 = r11.pb_img
            r0.setVisibility(r1)
            android.widget.ImageView r0 = r11.iv
            r0.setVisibility(r2)
            java.util.ArrayList<stikerwap.appdys.likes_item> r0 = r8.datas
            java.lang.Object r0 = r0.get(r9)
            stikerwap.appdys.likes_item r0 = (stikerwap.appdys.likes_item) r0
            boolean r0 = r0.cargando
            if (r0 != 0) goto L_0x01ae
            java.util.ArrayList<stikerwap.appdys.likes_item> r0 = r8.datas
            java.lang.Object r0 = r0.get(r9)
            stikerwap.appdys.likes_item r0 = (stikerwap.appdys.likes_item) r0
            r0.cargando = r3
            stikerwap.appdys.likes_adapter$DownloadAsyncTask r0 = new stikerwap.appdys.likes_adapter$DownloadAsyncTask
            r0.<init>(r9)
            java.lang.Integer[] r1 = new java.lang.Integer[r1]
            r0.execute(r1)
            goto L_0x01ae
        L_0x019c:
            android.widget.ImageView r1 = r11.iv     // Catch:{ Exception | OutOfMemoryError -> 0x01ae }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception | OutOfMemoryError -> 0x01ae }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x01ae }
            r2 = 2
            android.graphics.Bitmap r0 = stikerwap.appdys.config.crop(r0, r2)     // Catch:{ Exception | OutOfMemoryError -> 0x01ae }
            r1.setImageBitmap(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x01ae }
        L_0x01ae:
            android.widget.TextView r11 = r11.tv_nombre
            java.util.ArrayList<stikerwap.appdys.likes_item> r0 = r8.datas
            java.lang.Object r9 = r0.get(r9)
            stikerwap.appdys.likes_item r9 = (stikerwap.appdys.likes_item) r9
            java.lang.String r9 = r9.nombre
            r11.setText(r9)
        L_0x01bd:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.likes_adapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private class DownloadAsyncTask extends AsyncTask<Integer, Void, Integer> {
        int ind;

        public DownloadAsyncTask(int i) {
            this.ind = i;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x00ae */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Integer... r7) {
            /*
                r6 = this;
                java.lang.String r7 = "fperfil_"
                r0 = -1
                java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00bd }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bd }
                r2.<init>()     // Catch:{ IOException -> 0x00bd }
                java.lang.String r3 = stikerwap.appdys.config.DOM_CDN     // Catch:{ IOException -> 0x00bd }
                r2.append(r3)     // Catch:{ IOException -> 0x00bd }
                java.lang.String r3 = "/srv/imgs/usus/"
                r2.append(r3)     // Catch:{ IOException -> 0x00bd }
                stikerwap.appdys.likes_adapter r3 = stikerwap.appdys.likes_adapter.this     // Catch:{ IOException -> 0x00bd }
                java.util.ArrayList r3 = r3.datas     // Catch:{ IOException -> 0x00bd }
                int r4 = r6.ind     // Catch:{ IOException -> 0x00bd }
                java.lang.Object r3 = r3.get(r4)     // Catch:{ IOException -> 0x00bd }
                stikerwap.appdys.likes_item r3 = (stikerwap.appdys.likes_item) r3     // Catch:{ IOException -> 0x00bd }
                java.lang.String r3 = r3.id     // Catch:{ IOException -> 0x00bd }
                r2.append(r3)     // Catch:{ IOException -> 0x00bd }
                java.lang.String r3 = "_1_p.jpg?v="
                r2.append(r3)     // Catch:{ IOException -> 0x00bd }
                stikerwap.appdys.likes_adapter r3 = stikerwap.appdys.likes_adapter.this     // Catch:{ IOException -> 0x00bd }
                java.util.ArrayList r3 = r3.datas     // Catch:{ IOException -> 0x00bd }
                int r4 = r6.ind     // Catch:{ IOException -> 0x00bd }
                java.lang.Object r3 = r3.get(r4)     // Catch:{ IOException -> 0x00bd }
                stikerwap.appdys.likes_item r3 = (stikerwap.appdys.likes_item) r3     // Catch:{ IOException -> 0x00bd }
                java.lang.String r3 = r3.vfoto_bd     // Catch:{ IOException -> 0x00bd }
                r2.append(r3)     // Catch:{ IOException -> 0x00bd }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00bd }
                r1.<init>(r2)     // Catch:{ IOException -> 0x00bd }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ IOException -> 0x00bd }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00bd }
                r2 = 1
                r1.setDoInput(r2)     // Catch:{ IOException -> 0x00bd }
                r2 = 5000(0x1388, float:7.006E-42)
                r1.setConnectTimeout(r2)     // Catch:{ IOException -> 0x00bd }
                r2 = 7000(0x1b58, float:9.809E-42)
                r1.setReadTimeout(r2)     // Catch:{ IOException -> 0x00bd }
                r1.connect()     // Catch:{ IOException -> 0x00bd }
                java.io.InputStream r2 = r1.getInputStream()     // Catch:{ IOException -> 0x00bd }
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ OutOfMemoryError -> 0x00b8 }
                r2.close()     // Catch:{ IOException -> 0x00bd }
                r1.disconnect()     // Catch:{ IOException -> 0x00bd }
                if (r3 != 0) goto L_0x0072
                java.lang.Integer r7 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x00bd }
                return r7
            L_0x0072:
                java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x00bd }
                stikerwap.appdys.likes_adapter r2 = stikerwap.appdys.likes_adapter.this     // Catch:{ IOException -> 0x00bd }
                java.io.File r2 = r2.path     // Catch:{ IOException -> 0x00bd }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bd }
                r4.<init>(r7)     // Catch:{ IOException -> 0x00bd }
                stikerwap.appdys.likes_adapter r7 = stikerwap.appdys.likes_adapter.this     // Catch:{ IOException -> 0x00bd }
                java.util.ArrayList r7 = r7.datas     // Catch:{ IOException -> 0x00bd }
                int r5 = r6.ind     // Catch:{ IOException -> 0x00bd }
                java.lang.Object r7 = r7.get(r5)     // Catch:{ IOException -> 0x00bd }
                stikerwap.appdys.likes_item r7 = (stikerwap.appdys.likes_item) r7     // Catch:{ IOException -> 0x00bd }
                java.lang.String r7 = r7.id     // Catch:{ IOException -> 0x00bd }
                r4.append(r7)     // Catch:{ IOException -> 0x00bd }
                java.lang.String r7 = ".jpg"
                r4.append(r7)     // Catch:{ IOException -> 0x00bd }
                java.lang.String r7 = r4.toString()     // Catch:{ IOException -> 0x00bd }
                r1.<init>(r2, r7)     // Catch:{ IOException -> 0x00bd }
                java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00ae }
                r7.<init>(r1)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00ae }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00ae }
                r2 = 90
                r3.compress(r1, r2, r7)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00ae }
                r7 = 0
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00b3, OutOfMemoryError -> 0x00ae }
                return r7
            L_0x00ae:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x00bd }
                return r7
            L_0x00b3:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x00bd }
                return r7
            L_0x00b8:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x00bd }
                return r7
            L_0x00bd:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.likes_adapter.DownloadAsyncTask.doInBackground(java.lang.Integer[]):java.lang.Integer");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            ((likes_item) likes_adapter.this.datas.get(this.ind)).cargando = false;
            if (num.intValue() == 0) {
                SharedPreferences.Editor edit = likes_adapter.this.settings.edit();
                edit.putString("fperfil_" + ((likes_item) likes_adapter.this.datas.get(this.ind)).id, ((likes_item) likes_adapter.this.datas.get(this.ind)).vfoto_bd);
                edit.commit();
                likes_adapter.this.este.notifyDataSetChanged();
            }
        }
    }
}
