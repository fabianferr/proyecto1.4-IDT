package stikerwap.appdys;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class t_rss_fr extends Fragment {
    /* access modifiers changed from: private */
    public String c1;
    Bundle extras;
    config globales;
    int ind;
    /* access modifiers changed from: private */
    public rss_adapter itemAdapter;
    /* access modifiers changed from: private */
    public ArrayList<rss_item> listData;
    /* access modifiers changed from: private */
    public SharedPreferences preferences;
    private View v = null;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        config config = (config) getActivity().getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        this.preferences = getActivity().getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        Bundle extras2 = getActivity().getIntent().getExtras();
        this.extras = extras2;
        this.ind = extras2.getInt("ind");
        View inflate = layoutInflater.inflate(R.layout.t_rss, viewGroup, false);
        this.v = inflate;
        ListView listView = (ListView) inflate.findViewById(R.id.postListView);
        listView.setCacheColorHint(0);
        this.c1 = this.globales.secciones_a[this.ind].c1;
        String str = this.globales.secciones_a[this.ind].c2;
        String str2 = this.globales.secciones_a[this.ind].c_tit;
        String str3 = this.globales.secciones_a[this.ind].c_fecha;
        if (!this.c1.equals("") && !this.c1.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            listView.setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.c1), Color.parseColor("#" + str)}));
        }
        this.listData = new ArrayList<>();
        this.itemAdapter = new rss_adapter(this.v.getContext(), R.layout.rss_item, this.listData);
        if (!str2.equals("")) {
            rss_adapter rss_adapter = this.itemAdapter;
            rss_adapter.c_tit = Integer.valueOf(Color.parseColor("#" + str2));
        }
        if (!str3.equals("")) {
            rss_adapter rss_adapter2 = this.itemAdapter;
            rss_adapter2.c_fecha = Integer.valueOf(Color.parseColor("#" + str3));
        }
        this.itemAdapter.d_item_sel = getResources().getDrawable(R.drawable.item_sel);
        this.itemAdapter.d_item_sel.setColorFilter(Color.parseColor("#FFFFFFFF"), PorterDuff.Mode.MULTIPLY);
        listView.setAdapter(this.itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                t_rss_fr.this.itemAdapter.pos_sel = i;
                t_rss_fr.this.itemAdapter.notifyDataSetChanged();
                ((t_rss) t_rss_fr.this.getActivity()).onTutSelected(((rss_item) t_rss_fr.this.listData.get(i)).postLink);
            }
        });
        return this.v;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        new RssDataController().execute(new String[]{this.globales.secciones_a[this.ind].url});
        this.itemAdapter.modo_h = false;
        Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = point.x;
        if (!((t_rss) getActivity()).abrir_fuera && i > ((int) ((getResources().getDisplayMetrics().density * 500.0f) + 0.5f))) {
            this.itemAdapter.modo_h = true;
        }
    }

    private class RssDataController extends AsyncTask<String, Integer, ArrayList<rss_item>> {
        ProgressBar pb;

        private RssDataController() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (config.esClaro("#" + t_rss_fr.this.c1)) {
                this.pb = (ProgressBar) t_rss_fr.this.getActivity().findViewById(R.id.pb_rss_inv);
            } else {
                this.pb = (ProgressBar) t_rss_fr.this.getActivity().findViewById(R.id.pb_rss);
            }
            if (Build.VERSION.SDK_INT > 20) {
                config.progress_color(this.pb, t_rss_fr.this.globales.c_icos);
            }
            this.pb.setVisibility(0);
        }

        /* access modifiers changed from: protected */
        public ArrayList<rss_item> doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                return config.tratar_rss(httpURLConnection.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(ArrayList<rss_item> arrayList) {
            if (arrayList != null) {
                boolean z = false;
                for (int i = 0; i < arrayList.size(); i++) {
                    t_rss_fr.this.listData.add(arrayList.get(i));
                    if (arrayList.get(i).postThumbUrl != null) {
                        z = true;
                    }
                }
                if (!z || !t_rss_fr.this.globales.secciones_a[t_rss_fr.this.ind].mostrar_img) {
                    t_rss_fr.this.itemAdapter.mostrar_imgs = false;
                }
                if (!t_rss_fr.this.globales.secciones_a[t_rss_fr.this.ind].mostrar_fecha) {
                    t_rss_fr.this.itemAdapter.mostrar_fechas = false;
                }
                t_rss_fr.this.itemAdapter.notifyDataSetChanged();
                if (arrayList.size() > 0 && arrayList.get(0).postLink != null && !arrayList.get(0).postLink.equals("")) {
                    SharedPreferences.Editor edit = t_rss_fr.this.preferences.edit();
                    edit.putString("rss_" + t_rss_fr.this.globales.secciones_a[t_rss_fr.this.ind].id + "_ultpost", arrayList.get(0).postLink);
                    edit.commit();
                }
            }
            try {
                this.pb.setVisibility(8);
            } catch (Exception unused) {
            }
        }
    }
}
