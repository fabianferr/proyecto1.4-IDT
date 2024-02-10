package com.startapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataStyle;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: Sta */
public class o4 extends ArrayAdapter<s4> {
    public String a;
    public String b;

    public o4(Context context, List list, String str, String str2) {
        super(context, 0, list);
        this.a = str;
        this.b = str2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        t4 t4Var;
        long j;
        if (view == null) {
            t4Var = new t4(getContext());
            view2 = t4Var.a;
        } else {
            view2 = view;
            t4Var = (t4) view.getTag();
        }
        s4 s4Var = (s4) getItem(i);
        MetaDataStyle a2 = AdsCommonMetaData.h.a(s4Var.q);
        boolean z = true;
        if (t4Var.g != a2) {
            t4Var.g = a2;
            t4Var.a.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{a2.e().intValue(), a2.d().intValue()}));
            t4Var.c.setTextSize((float) a2.h().intValue());
            t4Var.c.setTextColor(a2.f().intValue());
            f9.a(t4Var.c, a2.g());
            t4Var.d.setTextSize((float) a2.c().intValue());
            t4Var.d.setTextColor(a2.a().intValue());
            f9.a(t4Var.d, a2.b());
        }
        t4Var.c.setText(s4Var.g);
        t4Var.d.setText(s4Var.h);
        u4 a3 = v4.b.a(this.b);
        Bitmap a4 = a3.a.a(i, s4Var.a, s4Var.i);
        if (a4 == null) {
            t4Var.b.setImageResource(17301651);
            t4Var.b.setTag("tag_error");
        } else {
            t4Var.b.setImageBitmap(a4);
            t4Var.b.setTag("tag_ok");
        }
        t4Var.f.setRating(s4Var.j);
        if (s4Var.n == null) {
            z = false;
        }
        t4Var.a(z);
        u4 a5 = v4.b.a(this.b);
        Context context = getContext();
        String[] strArr = s4Var.c;
        TrackingParams trackingParams = new TrackingParams(this.a);
        Long l = s4Var.o;
        if (l != null) {
            j = TimeUnit.SECONDS.toMillis(l.longValue());
        } else {
            j = TimeUnit.SECONDS.toMillis(MetaData.k.s());
        }
        long j2 = j;
        g3 g3Var = a5.a;
        AdPreferences.Placement placement = AdPreferences.Placement.INAPP_OFFER_WALL;
        String a6 = g3Var.a(strArr, a5.c);
        if (!g3Var.a.containsKey(a6)) {
            k7 k7Var = new k7(context, placement, strArr, trackingParams, j2);
            g3Var.a.put(a6, k7Var);
            k7Var.c();
        }
        return view2;
    }
}
