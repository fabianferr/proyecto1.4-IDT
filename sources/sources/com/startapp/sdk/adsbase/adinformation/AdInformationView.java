package com.startapp.sdk.adsbase.adinformation;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.startapp.f9;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adinformation.AdInformationPositions;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: Sta */
public class AdInformationView extends RelativeLayout {
    public ImageView a;
    public RelativeLayout b;
    public View.OnClickListener c = null;
    public AdInformationConfig d;
    public ImageResourceConfig e;
    public final AdInformationPositions.Position f;

    /* compiled from: Sta */
    public class a implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener a;

        public a(AdInformationView adInformationView, View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        public void onClick(View view) {
            this.a.onClick(view);
        }
    }

    public AdInformationView(Context context, AdInformationObject.Size size, AdPreferences.Placement placement, AdInformationOverrides adInformationOverrides, View.OnClickListener onClickListener) {
        super(context);
        this.c = new a(this, onClickListener);
        AdInformationConfig a2 = AdInformationMetaData.c().a();
        this.d = a2;
        if (a2 == null) {
            this.d = AdInformationConfig.a();
        }
        this.e = this.d.a(size.a());
        if (adInformationOverrides == null || !adInformationOverrides.e()) {
            this.f = this.d.a(placement);
        } else {
            this.f = adInformationOverrides.b();
        }
        ImageView imageView = new ImageView(getContext());
        this.a = imageView;
        imageView.setContentDescription("info");
        this.a.setId(1475346433);
        this.a.setImageBitmap(this.e.a(getContext()));
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.b = relativeLayout;
        relativeLayout.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(d(), c());
        layoutParams.setMargins(0, 0, 0, 0);
        this.a.setPadding(0, 0, 0, 0);
        this.f.addRules(layoutParams);
        this.b.addView(this.a, layoutParams);
        this.b.setOnClickListener(this.c);
        addView(this.b, new RelativeLayout.LayoutParams(b(), a()));
    }

    public int a() {
        return (int) (this.d.e() * ((float) c()));
    }

    public int b() {
        return (int) (this.d.e() * ((float) d()));
    }

    public int c() {
        return f9.a(getContext(), this.e.a());
    }

    public int d() {
        return f9.a(getContext(), this.e.d());
    }
}
