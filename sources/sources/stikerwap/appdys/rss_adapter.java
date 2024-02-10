package stikerwap.appdys;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class rss_adapter extends ArrayAdapter<rss_item> {
    Integer c_fecha;
    Integer c_tit;
    protected Drawable d_item_sel;
    /* access modifiers changed from: private */
    public ArrayList<rss_item> datas;
    /* access modifiers changed from: private */
    public rss_adapter este;
    config globales;
    protected boolean modo_h = false;
    protected boolean mostrar_fechas = true;
    protected boolean mostrar_imgs = true;
    private Activity myContext;
    protected int pos_sel = -1;

    public rss_adapter(Context context, int i, ArrayList<rss_item> arrayList) {
        super(context, i, arrayList);
        Activity activity = (Activity) context;
        this.myContext = activity;
        this.globales = (config) activity.getApplicationContext();
        this.datas = arrayList;
        this.este = this;
    }

    static class ViewHolder {
        ImageView iv_item_der;
        ImageView iv_item_sel;
        TextView postDateView;
        ImageView postThumbView;
        TextView postTitleView;

        ViewHolder() {
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.myContext.getLayoutInflater().inflate(R.layout.rss_item, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.postThumbView = (ImageView) view.findViewById(R.id.postThumb);
            viewHolder.postTitleView = (TextView) view.findViewById(R.id.postTitleLabel);
            if (this.c_tit != null) {
                viewHolder.postTitleView.setTextColor(this.c_tit.intValue());
            }
            if (this.myContext.getResources().getBoolean(R.bool.es_rtl)) {
                viewHolder.postTitleView.setTextDirection(4);
            }
            viewHolder.postDateView = (TextView) view.findViewById(R.id.postDateLabel);
            if (this.c_fecha != null) {
                viewHolder.postDateView.setTextColor(this.c_fecha.intValue());
            }
            viewHolder.iv_item_sel = (ImageView) view.findViewById(R.id.iv_item_sel);
            viewHolder.iv_item_der = (ImageView) view.findViewById(R.id.iv_item_der);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (!this.mostrar_imgs) {
            viewHolder.postThumbView.setVisibility(8);
        } else if (this.datas.get(i).postThumbUrl == null) {
            viewHolder.postThumbView.setImageResource(17170445);
        } else if (this.datas.get(i).postThumbBitmap == null) {
            viewHolder.postThumbView.setImageResource(R.drawable.loader_g);
            if (!this.datas.get(i).postThumbCargando) {
                this.datas.get(i).postThumbCargando = true;
                new DownloadAsyncTask().execute(new Integer[]{Integer.valueOf(i)});
            }
        } else {
            viewHolder.postThumbView.setImageBitmap(this.datas.get(i).postThumbBitmap);
        }
        viewHolder.postTitleView.setText(this.datas.get(i).postTitle);
        if (!this.mostrar_fechas || this.datas.get(i).postDate == null || this.datas.get(i).postDate.equals("")) {
            viewHolder.postDateView.setVisibility(8);
        } else {
            viewHolder.postDateView.setText(this.datas.get(i).postDate);
        }
        if (!this.modo_h) {
            viewHolder.iv_item_der.setVisibility(8);
        } else if (i == this.pos_sel) {
            viewHolder.iv_item_sel.setImageDrawable(this.d_item_sel);
            viewHolder.iv_item_sel.setVisibility(0);
        } else {
            viewHolder.iv_item_sel.setVisibility(8);
        }
        return view;
    }

    private class DownloadAsyncTask extends AsyncTask<Integer, Void, Integer> {
        private DownloadAsyncTask() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|14|15|16|17) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x00b3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Integer... r12) {
            /*
                r11 = this;
                r0 = 0
                java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
                r12 = r12[r0]
                r2 = -1
                java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00cb }
                stikerwap.appdys.rss_adapter r4 = stikerwap.appdys.rss_adapter.this     // Catch:{ IOException -> 0x00cb }
                java.util.ArrayList r4 = r4.datas     // Catch:{ IOException -> 0x00cb }
                int r5 = r12.intValue()     // Catch:{ IOException -> 0x00cb }
                java.lang.Object r4 = r4.get(r5)     // Catch:{ IOException -> 0x00cb }
                stikerwap.appdys.rss_item r4 = (stikerwap.appdys.rss_item) r4     // Catch:{ IOException -> 0x00cb }
                java.lang.String r4 = r4.postThumbUrl     // Catch:{ IOException -> 0x00cb }
                java.lang.String r5 = " "
                java.lang.String r6 = "%20"
                java.lang.String r4 = r4.replace(r5, r6)     // Catch:{ IOException -> 0x00cb }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00cb }
                java.net.URLConnection r4 = r3.openConnection()     // Catch:{ IOException -> 0x00cb }
                java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x00cb }
                r5 = 1
                r4.setDoInput(r5)     // Catch:{ IOException -> 0x00cb }
                r6 = 5000(0x1388, float:7.006E-42)
                r4.setConnectTimeout(r6)     // Catch:{ IOException -> 0x00cb }
                r7 = 7000(0x1b58, float:9.809E-42)
                r4.setReadTimeout(r7)     // Catch:{ IOException -> 0x00cb }
                r4.connect()     // Catch:{ IOException -> 0x00cb }
                java.io.InputStream r8 = r4.getInputStream()     // Catch:{ IOException -> 0x00cb }
                android.graphics.BitmapFactory$Options r9 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x00cb }
                r9.<init>()     // Catch:{ IOException -> 0x00cb }
                r9.inJustDecodeBounds = r5     // Catch:{ IOException -> 0x00cb }
                r10 = 0
                android.graphics.BitmapFactory.decodeStream(r8, r10, r9)     // Catch:{ IOException -> 0x00cb }
                r8.close()     // Catch:{ IOException -> 0x00cb }
                r4.disconnect()     // Catch:{ IOException -> 0x00cb }
                int r4 = r9.outWidth     // Catch:{ IOException -> 0x00cb }
                if (r4 != r5) goto L_0x006e
                int r4 = r9.outHeight     // Catch:{ IOException -> 0x00cb }
                if (r4 != r5) goto L_0x006e
                stikerwap.appdys.rss_adapter r0 = stikerwap.appdys.rss_adapter.this     // Catch:{ IOException -> 0x00cb }
                java.util.ArrayList r0 = r0.datas     // Catch:{ IOException -> 0x00cb }
                int r12 = r12.intValue()     // Catch:{ IOException -> 0x00cb }
                java.lang.Object r12 = r0.get(r12)     // Catch:{ IOException -> 0x00cb }
                stikerwap.appdys.rss_item r12 = (stikerwap.appdys.rss_item) r12     // Catch:{ IOException -> 0x00cb }
                r12.postThumbUrl = r10     // Catch:{ IOException -> 0x00cb }
                return r1
            L_0x006e:
                stikerwap.appdys.rss_adapter r4 = stikerwap.appdys.rss_adapter.this     // Catch:{ IOException -> 0x00cb }
                stikerwap.appdys.config r4 = r4.globales     // Catch:{ IOException -> 0x00cb }
                r4 = 300(0x12c, float:4.2E-43)
                int r4 = stikerwap.appdys.config.calculateInSampleSize(r9, r4, r4)     // Catch:{ IOException -> 0x00cb }
                r9.inSampleSize = r4     // Catch:{ IOException -> 0x00cb }
                java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x00cb }
                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x00cb }
                r3.setDoInput(r5)     // Catch:{ IOException -> 0x00cb }
                r3.setConnectTimeout(r6)     // Catch:{ IOException -> 0x00cb }
                r3.setReadTimeout(r7)     // Catch:{ IOException -> 0x00cb }
                r3.connect()     // Catch:{ IOException -> 0x00cb }
                java.io.InputStream r3 = r3.getInputStream()     // Catch:{ IOException -> 0x00cb }
                r9.inJustDecodeBounds = r0     // Catch:{ IOException -> 0x00cb }
                android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r3, r10, r9)     // Catch:{ IOException -> 0x00cb }
                r3.close()     // Catch:{ IOException -> 0x00cb }
                if (r4 != 0) goto L_0x00a0
                java.lang.Integer r12 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x00cb }
                return r12
            L_0x00a0:
                java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00cb }
                r3.<init>()     // Catch:{ IOException -> 0x00cb }
                android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x00cb }
                r6 = 100
                r4.compress(r5, r6, r3)     // Catch:{ IOException -> 0x00cb }
                byte[] r4 = r3.toByteArray()     // Catch:{ IOException -> 0x00cb }
                r3.close()     // Catch:{ IOException -> 0x00b3 }
            L_0x00b3:
                stikerwap.appdys.rss_adapter r3 = stikerwap.appdys.rss_adapter.this     // Catch:{ IOException -> 0x00cb }
                java.util.ArrayList r3 = r3.datas     // Catch:{ IOException -> 0x00cb }
                int r12 = r12.intValue()     // Catch:{ IOException -> 0x00cb }
                java.lang.Object r12 = r3.get(r12)     // Catch:{ IOException -> 0x00cb }
                stikerwap.appdys.rss_item r12 = (stikerwap.appdys.rss_item) r12     // Catch:{ IOException -> 0x00cb }
                int r3 = r4.length     // Catch:{ IOException -> 0x00cb }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r4, r0, r3)     // Catch:{ IOException -> 0x00cb }
                r12.postThumbBitmap = r0     // Catch:{ IOException -> 0x00cb }
                return r1
            L_0x00cb:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.rss_adapter.DownloadAsyncTask.doInBackground(java.lang.Integer[]):java.lang.Integer");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            if (num.intValue() == 0) {
                rss_adapter.this.este.notifyDataSetChanged();
            }
        }
    }
}
