package stikerwap.appdys;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import androidx.fragment.app.ListFragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class t_buscador_fr extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final int TUTORIAL_LIST_LOADER = 1;
    private SimpleCursorAdapter adapter;
    cargaritems ci;
    cargarthumbs ct;
    Drawable d_item_sel;
    Drawable d_precio;
    Bundle extras;
    boolean fin;
    String fotoscargadas = "0";
    GradientDrawable gd;
    config globales;
    boolean hayfotos;
    int i_global;
    long idusu;
    boolean modo_h;
    boolean mostrar_loader;
    int ncargados;
    int pos_sel = -1;
    SharedPreferences settings;
    private OnTutSelectedListener tutSelectedListener;
    View v_footer;

    public interface OnTutSelectedListener {
        void onTutSelected(String str, long j);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        if (!this.globales.c_prods_det.equals("")) {
            this.pos_sel = i;
            this.adapter.notifyDataSetChanged();
        }
        Cursor query = getActivity().getContentResolver().query(Uri.withAppendedPath(bd_provider.PRODUCTOS_URI, String.valueOf(j)), new String[]{"url_detalle"}, (String) null, (String[]) null, (String) null);
        if (query.moveToFirst()) {
            this.tutSelectedListener.onTutSelected(query.getString(0), j);
        }
        query.close();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        config config = (config) getActivity().getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        String[] strArr = {"titulo", "img1_p", "precio", "anyo", "dia"};
        int[] iArr = {R.id.title, R.id.iv_item, R.id.precio, R.id.antiguedad, R.id.tv_aux};
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        this.extras = getActivity().getIntent().getExtras();
        this.modo_h = false;
        Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (point.x > ((int) ((getResources().getDisplayMetrics().density * 500.0f) + 0.5f))) {
            this.modo_h = true;
        }
        Drawable drawable = getResources().getDrawable(R.drawable.item_sel);
        this.d_item_sel = drawable;
        drawable.setColorFilter(Color.parseColor("#" + this.globales.c_prods_det), PorterDuff.Mode.MULTIPLY);
        if (!this.globales.c_precio_prods_l.equals("")) {
            Drawable drawable2 = getResources().getDrawable(R.drawable.precio);
            this.d_precio = drawable2;
            drawable2.setColorFilter(Color.parseColor("#" + this.globales.c_precio_prods_l), PorterDuff.Mode.MULTIPLY);
        }
        if (bundle == null) {
            this.fin = false;
            this.mostrar_loader = true;
            this.ncargados = 0;
            try {
                SQLiteDatabase writableDatabase = new bd(getActivity()).getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.execSQL("DELETE FROM productos");
                    writableDatabase.execSQL("DELETE FROM fotos");
                    writableDatabase.close();
                }
            } catch (Exception unused) {
            }
        } else {
            this.hayfotos = bundle.getBoolean("hayfotos", true);
            this.mostrar_loader = bundle.getBoolean("mostrar_loader", false);
            this.fin = bundle.getBoolean("fin", false);
            this.ncargados = bundle.getInt("ncargados", 0);
        }
        if (!this.globales.c1_prods_l.equals("") && !this.globales.c2_prods_l.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            this.gd = new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.globales.c1_prods_l), Color.parseColor("#" + this.globales.c2_prods_l)});
        }
        getLoaderManager().initLoader(1, (Bundle) null, this);
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(getActivity().getApplicationContext(), R.layout.list_item, (Cursor) null, strArr, iArr, 2);
        this.adapter = simpleCursorAdapter;
        simpleCursorAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            public boolean setViewValue(View view, Cursor cursor, int i) {
                boolean z;
                String str;
                boolean z2;
                LinearLayout linearLayout;
                Date date = null;
                if (view.getId() == R.id.iv_item) {
                    if (t_buscador_fr.this.globales.c_perprod == 1 && !t_buscador_fr.this.globales.c1_prods_l.equals("") && !t_buscador_fr.this.globales.c2_prods_l.equals("")) {
                        try {
                            linearLayout = (LinearLayout) view.getParent().getParent().getParent().getParent();
                            z2 = true;
                        } catch (Exception unused) {
                            linearLayout = null;
                            z2 = false;
                        }
                        if (z2) {
                            linearLayout.setBackgroundDrawable(t_buscador_fr.this.gd);
                        }
                    }
                    FrameLayout frameLayout = (FrameLayout) view.getParent().getParent().getParent();
                    if (t_buscador_fr.this.modo_h) {
                        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.iv_item_sel);
                        if (cursor.getPosition() == t_buscador_fr.this.pos_sel) {
                            imageView.setImageDrawable(t_buscador_fr.this.d_item_sel);
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(8);
                        }
                    } else {
                        frameLayout.findViewById(R.id.ll_item_der).setVisibility(8);
                    }
                    ImageView imageView2 = (ImageView) view;
                    if (cursor.getInt(cursor.getColumnIndex("img1_id")) == 0 && cursor.getString(cursor.getColumnIndex("img1_url")).equals("")) {
                        imageView2.setImageDrawable((Drawable) null);
                    } else if (!cursor.isNull(i)) {
                        byte[] blob = cursor.getBlob(i);
                        imageView2.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
                    } else {
                        imageView2.setImageDrawable(t_buscador_fr.this.getResources().getDrawable(R.drawable.loader_g));
                    }
                    if (!t_buscador_fr.this.hayfotos) {
                        imageView2.setVisibility(8);
                    }
                    return true;
                } else if (view.getId() == R.id.title) {
                    TextView textView = (TextView) view;
                    textView.setTypeface(Typeface.MONOSPACE);
                    if (!t_buscador_fr.this.globales.c_tit_prods_l.equals("")) {
                        textView.setTextColor(Color.parseColor("#" + t_buscador_fr.this.globales.c_tit_prods_l));
                    }
                    return false;
                } else if (view.getId() == R.id.precio) {
                    view.setVisibility(8);
                    if (cursor.isNull(cursor.getColumnIndex("precio"))) {
                        return false;
                    }
                    DecimalFormat decimalFormat = new DecimalFormat();
                    decimalFormat.setCurrency(Currency.getInstance(Locale.getDefault()));
                    String format = decimalFormat.format(cursor.getDouble(cursor.getColumnIndex("precio")));
                    if (format.length() > 1) {
                        String substring = format.substring(format.length() - 2, format.length() - 1);
                        if (substring.equals(",") || substring.equals(".")) {
                            format = format + "0";
                        }
                    }
                    TextView textView2 = (TextView) view;
                    textView2.setTypeface(Typeface.MONOSPACE);
                    if (t_buscador_fr.this.globales.divisa.equals("")) {
                        textView2.setText(format + ".");
                    } else {
                        textView2.setText(format + " " + Html.fromHtml(t_buscador_fr.this.globales.divisa));
                    }
                    if (!t_buscador_fr.this.globales.c_precio_prods_l.equals("")) {
                        textView2.setTextColor(Color.parseColor("#" + t_buscador_fr.this.globales.c_precio_prods_l));
                    }
                    textView2.setVisibility(0);
                    return true;
                } else if (view.getId() == R.id.antiguedad) {
                    view.setVisibility(8);
                    int i2 = cursor.getInt(cursor.getColumnIndex("anyo"));
                    if (i2 != 0) {
                        String str2 = i2 + "";
                        int i3 = cursor.getInt(cursor.getColumnIndex("mes"));
                        String str3 = i3 + "";
                        String str4 = "1";
                        if (str3.equals("0")) {
                            str3 = str4;
                        }
                        int i4 = cursor.getInt(cursor.getColumnIndex("dia"));
                        String str5 = i4 + "";
                        if (!str5.equals("0")) {
                            str4 = str5;
                        }
                        try {
                            date = DateFormat.getDateInstance(3, Locale.US).parse(str3 + "/" + str4 + "/" + str2);
                            z = true;
                        } catch (Exception unused2) {
                            z = false;
                        }
                        if (z) {
                            if (i3 == 0) {
                                str = i2 + "";
                            } else if (i4 == 0) {
                                String format2 = String.format(Locale.getDefault(), "%tB", new Object[]{date});
                                str = (format2.substring(0, 1).toUpperCase() + format2.substring(1)) + ", " + i2;
                            } else {
                                str = DateFormat.getDateInstance().format(date);
                            }
                            TextView textView3 = (TextView) view;
                            textView3.setTypeface(Typeface.MONOSPACE);
                            textView3.setText(str);
                            if (!t_buscador_fr.this.globales.c_antiguedad_prods_l.equals("")) {
                                textView3.setTextColor(Color.parseColor("#" + t_buscador_fr.this.globales.c_antiguedad_prods_l));
                            }
                            textView3.setVisibility(0);
                            return true;
                        }
                    }
                    return false;
                } else {
                    if (view.getId() == R.id.tv_aux && cursor.getPosition() == cursor.getCount() - 1 && !t_buscador_fr.this.fin && (t_buscador_fr.this.ci == null || t_buscador_fr.this.ci.getStatus() != AsyncTask.Status.RUNNING)) {
                        t_buscador_fr.this.i_global = cursor.getCount();
                        t_buscador_fr.this.ci = new cargaritems(cursor.getCount() + 1);
                        t_buscador_fr.this.ci.execute(new String[0]);
                    }
                    return false;
                }
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        cargaritems cargaritems2;
        super.onActivityCreated(bundle);
        View inflate = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.list_footer, (ViewGroup) null, false);
        this.v_footer = inflate;
        inflate.findViewById(R.id.tv_footer).setBackgroundColor(-1);
        if (!this.modo_h) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            ((TextView) this.v_footer.findViewById(R.id.tv_footer)).setLayoutParams(layoutParams);
        }
        getListView().addFooterView(this.v_footer);
        setListAdapter(this.adapter);
        getListView().removeFooterView(this.v_footer);
        if (this.mostrar_loader) {
            setListShown(false);
        }
        getListView().setCacheColorHint(0);
        if (this.globales.c_perprod == 0 && !this.globales.c1_prods_l.equals("") && !this.globales.c2_prods_l.equals("")) {
            getListView().setBackgroundDrawable(this.gd);
        }
        if (!this.fin && ((cargaritems2 = this.ci) == null || cargaritems2.getStatus() != AsyncTask.Status.RUNNING)) {
            cargaritems cargaritems3 = new cargaritems(this.ncargados + 1);
            this.ci = cargaritems3;
            cargaritems3.execute(new String[0]);
        }
        if (this.ncargados > 0) {
            cargarthumbs cargarthumbs2 = this.ct;
            if (cargarthumbs2 == null || cargarthumbs2.getStatus() != AsyncTask.Status.RUNNING) {
                cargarthumbs cargarthumbs3 = new cargarthumbs();
                this.ct = cargarthumbs3;
                cargarthumbs3.execute(new String[0]);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("hayfotos", this.hayfotos);
        bundle.putBoolean("mostrar_loader", this.mostrar_loader);
        bundle.putBoolean("fin", this.fin);
        bundle.putInt("ncargados", this.ncargados);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.tutSelectedListener = (OnTutSelectedListener) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement OnTutSelectedListener");
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(getActivity(), bd_provider.PRODUCTOS_URI, new String[]{"_id", "titulo", "precio", "anyo", "mes", "dia", "url_detalle", "img1_p", "img1_id", "img1_url"}, (String) null, (String[]) null, "orden");
    }

    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.adapter.swapCursor(cursor);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        this.adapter.swapCursor((Cursor) null);
    }

    private class cargaritems extends AsyncTask<String, Void, Byte> {
        int fila_global;
        String result_http;

        public cargaritems(int i) {
            this.fila_global = i;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.fila_global > 1 && t_buscador_fr.this.v_footer != null) {
                t_buscador_fr.this.getListView().addFooterView(t_buscador_fr.this.v_footer);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0062 A[SYNTHETIC, Splitter:B:11:0x0062] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00f4  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x018b A[Catch:{ Exception -> 0x01bd, all -> 0x01ba }, LOOP:0: B:26:0x0185->B:28:0x018b, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x01b2  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x01c8  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x01ce  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x01a0 A[EDGE_INSN: B:49:0x01a0->B:29:0x01a0 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r8) {
            /*
                r7 = this;
                java.lang.String r8 = "/srv/result.php?v=2&idapp=3008836&idusu="
                java.lang.String r0 = "&texto="
                stikerwap.appdys.t_buscador_fr r1 = stikerwap.appdys.t_buscador_fr.this
                android.os.Bundle r1 = r1.extras
                java.lang.String r2 = "texto"
                java.lang.String r1 = r1.getString(r2)
                java.lang.String r3 = "UTF-8"
                if (r1 == 0) goto L_0x002b
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002b }
                r1.<init>(r0)     // Catch:{ Exception -> 0x002b }
                stikerwap.appdys.t_buscador_fr r0 = stikerwap.appdys.t_buscador_fr.this     // Catch:{ Exception -> 0x002b }
                android.os.Bundle r0 = r0.extras     // Catch:{ Exception -> 0x002b }
                java.lang.String r0 = r0.getString(r2)     // Catch:{ Exception -> 0x002b }
                java.lang.String r0 = java.net.URLEncoder.encode(r0, r3)     // Catch:{ Exception -> 0x002b }
                r1.append(r0)     // Catch:{ Exception -> 0x002b }
                java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x002b }
                goto L_0x002d
            L_0x002b:
                java.lang.String r0 = ""
            L_0x002d:
                stikerwap.appdys.t_buscador_fr r1 = stikerwap.appdys.t_buscador_fr.this
                android.os.Bundle r1 = r1.extras
                java.lang.String r2 = "idcat"
                r4 = 0
                int r1 = r1.getInt(r2, r4)
                if (r1 == 0) goto L_0x0056
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                java.lang.String r0 = "&idcat="
                r1.append(r0)
                stikerwap.appdys.t_buscador_fr r0 = stikerwap.appdys.t_buscador_fr.this
                android.os.Bundle r0 = r0.extras
                int r0 = r0.getInt(r2)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
            L_0x0056:
                stikerwap.appdys.t_buscador_fr r1 = stikerwap.appdys.t_buscador_fr.this
                android.os.Bundle r1 = r1.extras
                java.lang.String r2 = "precio"
                java.lang.String r1 = r1.getString(r2)
                if (r1 == 0) goto L_0x0084
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0083 }
                r1.<init>()     // Catch:{ Exception -> 0x0083 }
                r1.append(r0)     // Catch:{ Exception -> 0x0083 }
                java.lang.String r5 = "&precio="
                r1.append(r5)     // Catch:{ Exception -> 0x0083 }
                stikerwap.appdys.t_buscador_fr r5 = stikerwap.appdys.t_buscador_fr.this     // Catch:{ Exception -> 0x0083 }
                android.os.Bundle r5 = r5.extras     // Catch:{ Exception -> 0x0083 }
                java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x0083 }
                java.lang.String r2 = java.net.URLEncoder.encode(r2, r3)     // Catch:{ Exception -> 0x0083 }
                r1.append(r2)     // Catch:{ Exception -> 0x0083 }
                java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0083 }
                goto L_0x0084
            L_0x0083:
            L_0x0084:
                stikerwap.appdys.t_buscador_fr r1 = stikerwap.appdys.t_buscador_fr.this
                android.os.Bundle r1 = r1.extras
                java.lang.String r2 = "dia"
                int r1 = r1.getInt(r2, r4)
                if (r1 == 0) goto L_0x00e8
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                java.lang.String r0 = "&dia="
                r1.append(r0)
                stikerwap.appdys.t_buscador_fr r0 = stikerwap.appdys.t_buscador_fr.this
                android.os.Bundle r0 = r0.extras
                int r0 = r0.getInt(r2)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                java.lang.String r0 = "&mes="
                r1.append(r0)
                stikerwap.appdys.t_buscador_fr r0 = stikerwap.appdys.t_buscador_fr.this
                android.os.Bundle r0 = r0.extras
                java.lang.String r2 = "mes"
                int r0 = r0.getInt(r2)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                java.lang.String r0 = "&anyo="
                r1.append(r0)
                stikerwap.appdys.t_buscador_fr r0 = stikerwap.appdys.t_buscador_fr.this
                android.os.Bundle r0 = r0.extras
                java.lang.String r2 = "anyo"
                int r0 = r0.getInt(r2)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
            L_0x00e8:
                stikerwap.appdys.t_buscador_fr r1 = stikerwap.appdys.t_buscador_fr.this
                android.os.Bundle r1 = r1.extras
                java.lang.String r2 = "orden"
                int r1 = r1.getInt(r2, r4)
                if (r1 == 0) goto L_0x012e
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                java.lang.String r0 = "&orden="
                r1.append(r0)
                stikerwap.appdys.t_buscador_fr r0 = stikerwap.appdys.t_buscador_fr.this
                android.os.Bundle r0 = r0.extras
                int r0 = r0.getInt(r2)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                java.lang.String r0 = "&orden_tipo="
                r1.append(r0)
                stikerwap.appdys.t_buscador_fr r0 = stikerwap.appdys.t_buscador_fr.this
                android.os.Bundle r0 = r0.extras
                java.lang.String r2 = "orden_tipo"
                boolean r0 = r0.getBoolean(r2)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
            L_0x012e:
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x01c1 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c1 }
                r3.<init>()     // Catch:{ Exception -> 0x01c1 }
                java.lang.String r5 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x01c1 }
                r3.append(r5)     // Catch:{ Exception -> 0x01c1 }
                r3.append(r8)     // Catch:{ Exception -> 0x01c1 }
                stikerwap.appdys.t_buscador_fr r8 = stikerwap.appdys.t_buscador_fr.this     // Catch:{ Exception -> 0x01c1 }
                long r5 = r8.idusu     // Catch:{ Exception -> 0x01c1 }
                r3.append(r5)     // Catch:{ Exception -> 0x01c1 }
                java.lang.String r8 = "&fila="
                r3.append(r8)     // Catch:{ Exception -> 0x01c1 }
                int r8 = r7.fila_global     // Catch:{ Exception -> 0x01c1 }
                r3.append(r8)     // Catch:{ Exception -> 0x01c1 }
                r3.append(r0)     // Catch:{ Exception -> 0x01c1 }
                java.lang.String r8 = r3.toString()     // Catch:{ Exception -> 0x01c1 }
                r2.<init>(r8)     // Catch:{ Exception -> 0x01c1 }
                java.net.URLConnection r8 = r2.openConnection()     // Catch:{ Exception -> 0x01c1 }
                java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ Exception -> 0x01c1 }
                r0 = 1
                r8.setDoInput(r0)     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                r0 = 10000(0x2710, float:1.4013E-41)
                r8.setConnectTimeout(r0)     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                r8.setReadTimeout(r0)     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                java.lang.String r0 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r8.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                java.io.InputStream r0 = r8.getInputStream()     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                r2.<init>(r0)     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                r1.<init>(r2)     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                r0.<init>()     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
            L_0x0185:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                if (r2 == 0) goto L_0x01a0
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                r3.<init>()     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                r3.append(r2)     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                r0.append(r2)     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                goto L_0x0185
            L_0x01a0:
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                r7.result_http = r0     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                java.lang.String r1 = "@EURO@"
                java.lang.String r2 = "€"
                java.lang.String r0 = r0.replace(r1, r2)     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                r7.result_http = r0     // Catch:{ Exception -> 0x01bd, all -> 0x01ba }
                if (r8 == 0) goto L_0x01b5
                r8.disconnect()
            L_0x01b5:
                java.lang.Byte r8 = java.lang.Byte.valueOf(r4)
                return r8
            L_0x01ba:
                r0 = move-exception
                r1 = r8
                goto L_0x01cc
            L_0x01bd:
                r1 = r8
                goto L_0x01c1
            L_0x01bf:
                r0 = move-exception
                goto L_0x01cc
            L_0x01c1:
                r8 = -1
                java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch:{ all -> 0x01bf }
                if (r1 == 0) goto L_0x01cb
                r1.disconnect()
            L_0x01cb:
                return r8
            L_0x01cc:
                if (r1 == 0) goto L_0x01d1
                r1.disconnect()
            L_0x01d1:
                goto L_0x01d3
            L_0x01d2:
                throw r0
            L_0x01d3:
                goto L_0x01d2
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscador_fr.cargaritems.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            if (t_buscador_fr.this.getActivity() != null) {
                t_buscador_fr.this.mostrar_loader = false;
                t_buscador_fr.this.setListShown(true);
                t_buscador_fr.this.getListView().removeFooterView(t_buscador_fr.this.v_footer);
                if (b.byteValue() == 0 && !this.result_http.contains("ANDROID:ERROR")) {
                    if (this.result_http.contains("ANDROID:VACIO")) {
                        t_buscador_fr t_buscador_fr = t_buscador_fr.this;
                        t_buscador_fr.setEmptyText(t_buscador_fr.getResources().getString(R.string.sin_resultados));
                        return;
                    }
                    String[] split = this.result_http.split(";");
                    for (int i = 0; i < split.length; i++) {
                        if (split[i].trim().equals("SIHAYFOTOS")) {
                            t_buscador_fr.this.hayfotos = true;
                        } else if (split[i].trim().equals("NOHAYFOTOS")) {
                            t_buscador_fr.this.hayfotos = false;
                        } else if (split[i].trim().equals("FIN")) {
                            t_buscador_fr.this.fin = true;
                        } else if (!split[i].trim().equals("")) {
                            t_buscador_fr.this.i_global++;
                            String[] split2 = split[i].split(",");
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("_id", split2[0].trim());
                            contentValues.put("ref", "");
                            contentValues.put("titulo", split2[1].trim());
                            contentValues.put("descr", "");
                            contentValues.put("idcat", "0");
                            contentValues.put("precio_descr", "");
                            contentValues.put("url_detalle", split2[4].trim());
                            contentValues.put("url_compra", "");
                            contentValues.put("img1_id", split2[2].trim());
                            String trim = split2[3].trim();
                            if (trim.equals("0")) {
                                contentValues.put("img1_url", "");
                            } else {
                                contentValues.put("img1_url", trim);
                            }
                            contentValues.put("det_cargado", 0);
                            String trim2 = split2[5].trim();
                            if (!trim2.equals("-1")) {
                                contentValues.put("precio", trim2);
                            }
                            contentValues.put("anyo", split2[6].trim());
                            contentValues.put("mes", split2[7].trim());
                            contentValues.put("dia", split2[8].trim());
                            t_buscador_fr.this.getActivity().getContentResolver().insert(bd_provider.PRODUCTOS_URI, contentValues);
                            t_buscador_fr.this.ncargados++;
                        }
                    }
                    if (t_buscador_fr.this.ct == null || t_buscador_fr.this.ct.getStatus() != AsyncTask.Status.RUNNING) {
                        t_buscador_fr.this.ct = new cargarthumbs();
                        t_buscador_fr.this.ct.execute(new String[0]);
                    }
                }
            }
        }
    }

    private class cargarthumbs extends AsyncTask<String, Void, Byte> {
        byte[] bitmapdata;
        String id_fotoacargar;

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        private cargarthumbs() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r20) {
            /*
                r19 = this;
                r0 = r19
                stikerwap.appdys.t_buscador_fr r1 = stikerwap.appdys.t_buscador_fr.this
                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                r2 = -1
                java.lang.Byte r2 = java.lang.Byte.valueOf(r2)
                if (r1 != 0) goto L_0x0010
                return r2
            L_0x0010:
                java.lang.String r1 = "0"
                r0.id_fotoacargar = r1
                stikerwap.appdys.bd r3 = new stikerwap.appdys.bd
                stikerwap.appdys.t_buscador_fr r4 = stikerwap.appdys.t_buscador_fr.this
                androidx.fragment.app.FragmentActivity r4 = r4.getActivity()
                r3.<init>(r4)
                android.database.sqlite.SQLiteDatabase r3 = r3.getReadableDatabase()     // Catch:{ Exception -> 0x0024 }
                goto L_0x0026
            L_0x0024:
                r3 = 0
            L_0x0026:
                java.lang.String r14 = ""
                if (r3 == 0) goto L_0x00ab
                java.lang.String r13 = "_id"
                java.lang.String r12 = "img1_id"
                java.lang.String r11 = "img1_url"
                java.lang.String[] r7 = new java.lang.String[]{r13, r12, r11}
                java.lang.String r6 = "productos"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                java.lang.String r8 = "(img1_id NOT IN ("
                r5.<init>(r8)
                stikerwap.appdys.t_buscador_fr r8 = stikerwap.appdys.t_buscador_fr.this
                java.lang.String r8 = r8.fotoscargadas
                r5.append(r8)
                java.lang.String r8 = ")) AND (img1_p IS NULL)"
                r5.append(r8)
                java.lang.String r8 = r5.toString()
                r9 = 0
                r10 = 0
                r16 = 0
                java.lang.String r17 = "_id"
                java.lang.String r18 = "1"
                r5 = r3
                r15 = r11
                r11 = r16
                r4 = r12
                r12 = r17
                r17 = r2
                r2 = r13
                r13 = r18
                android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10, r11, r12, r13)
                boolean r6 = r5.moveToFirst()
                if (r6 == 0) goto L_0x00a2
                int r4 = r5.getColumnIndex(r4)
                java.lang.String r4 = r5.getString(r4)
                r0.id_fotoacargar = r4
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                stikerwap.appdys.t_buscador_fr r6 = stikerwap.appdys.t_buscador_fr.this
                java.lang.String r7 = r6.fotoscargadas
                r4.append(r7)
                java.lang.String r7 = ","
                r4.append(r7)
                java.lang.String r7 = r0.id_fotoacargar
                r4.append(r7)
                java.lang.String r4 = r4.toString()
                r6.fotoscargadas = r4
                int r2 = r5.getColumnIndex(r2)
                int r2 = r5.getInt(r2)
                int r4 = r5.getColumnIndex(r15)
                java.lang.String r4 = r5.getString(r4)
                goto L_0x00a4
            L_0x00a2:
                r4 = r14
                r2 = 0
            L_0x00a4:
                r5.close()
                r3.close()
                goto L_0x00af
            L_0x00ab:
                r17 = r2
                r4 = r14
                r2 = 0
            L_0x00af:
                java.lang.String r3 = r0.id_fotoacargar
                boolean r1 = r3.equals(r1)
                r3 = 1
                if (r1 == 0) goto L_0x00bd
                java.lang.Byte r1 = java.lang.Byte.valueOf(r3)
                return r1
            L_0x00bd:
                boolean r1 = r4.equals(r14)
                if (r1 == 0) goto L_0x00e8
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = stikerwap.appdys.config.DOM_SRV
                r1.append(r4)
                java.lang.String r4 = "/srv/imgs/prods/"
                r1.append(r4)
                java.lang.String r4 = r0.id_fotoacargar
                r1.append(r4)
                java.lang.String r4 = "_"
                r1.append(r4)
                r1.append(r2)
                java.lang.String r2 = "_p.png"
                r1.append(r2)
                java.lang.String r4 = r1.toString()
            L_0x00e8:
                java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0160 }
                r1.<init>(r4)     // Catch:{ MalformedURLException -> 0x0160 }
                java.net.URLConnection r2 = r1.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{  }
                r2.setDoInput(r3)     // Catch:{  }
                r4 = 5000(0x1388, float:7.006E-42)
                r2.setConnectTimeout(r4)     // Catch:{  }
                r5 = 7000(0x1b58, float:9.809E-42)
                r2.setReadTimeout(r5)     // Catch:{  }
                r2.connect()     // Catch:{  }
                java.io.InputStream r6 = r2.getInputStream()     // Catch:{  }
                android.graphics.BitmapFactory$Options r7 = new android.graphics.BitmapFactory$Options     // Catch:{  }
                r7.<init>()     // Catch:{  }
                r7.inJustDecodeBounds = r3     // Catch:{  }
                r8 = 0
                android.graphics.BitmapFactory.decodeStream(r6, r8, r7)     // Catch:{  }
                r6.close()     // Catch:{  }
                r2.disconnect()     // Catch:{  }
                stikerwap.appdys.t_buscador_fr r2 = stikerwap.appdys.t_buscador_fr.this     // Catch:{  }
                stikerwap.appdys.config r2 = r2.globales     // Catch:{  }
                r2 = 300(0x12c, float:4.2E-43)
                int r2 = stikerwap.appdys.config.calculateInSampleSize(r7, r2, r2)     // Catch:{  }
                r7.inSampleSize = r2     // Catch:{  }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{  }
                r1.setDoInput(r3)     // Catch:{  }
                r1.setConnectTimeout(r4)     // Catch:{  }
                r1.setReadTimeout(r5)     // Catch:{  }
                r1.connect()     // Catch:{  }
                java.io.InputStream r1 = r1.getInputStream()     // Catch:{  }
                r2 = 0
                r7.inJustDecodeBounds = r2     // Catch:{  }
                r2 = 0
                android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1, r2, r7)     // Catch:{  }
                r1.close()     // Catch:{  }
                java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
                r1.<init>()
                android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{  }
                r4 = 100
                r2.compress(r3, r4, r1)     // Catch:{  }
                byte[] r2 = r1.toByteArray()
                r0.bitmapdata = r2
                r1.close()     // Catch:{ IOException -> 0x015a }
            L_0x015a:
                r1 = 0
                java.lang.Byte r1 = java.lang.Byte.valueOf(r1)
                return r1
            L_0x0160:
                return r17
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscador_fr.cargarthumbs.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            if (t_buscador_fr.this.getActivity() != null) {
                if (b.byteValue() == 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("img1_p", this.bitmapdata);
                    ContentResolver contentResolver = t_buscador_fr.this.getActivity().getContentResolver();
                    Uri uri = bd_provider.PRODUCTOS_URI;
                    contentResolver.update(uri, contentValues, "img1_id='" + this.id_fotoacargar + "'", (String[]) null);
                }
                if (b.byteValue() != 1) {
                    t_buscador_fr t_buscador_fr = t_buscador_fr.this;
                    t_buscador_fr.ct = new cargarthumbs();
                    t_buscador_fr.this.ct.execute(new String[0]);
                }
            }
        }
    }
}
