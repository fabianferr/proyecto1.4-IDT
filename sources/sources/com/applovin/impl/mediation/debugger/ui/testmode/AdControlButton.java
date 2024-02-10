package com.applovin.impl.mediation.debugger.ui.testmode;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.applovin.impl.sdk.utils.f;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.R;

public class AdControlButton extends RelativeLayout implements View.OnClickListener {
    private final Button a;
    private final com.applovin.impl.adview.a b;
    private b c;
    private MaxAdFormat d;
    private a e;

    public interface a {
        void onClick(AdControlButton adControlButton);
    }

    public enum b {
        LOAD,
        LOADING,
        SHOW
    }

    public AdControlButton(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Button button = new Button(getContext());
        this.a = button;
        com.applovin.impl.adview.a aVar = new com.applovin.impl.adview.a(getContext(), 20, 16842873);
        this.b = aVar;
        this.c = b.LOAD;
        setBackgroundColor(0);
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1, 17));
        button.setTextColor(-1);
        button.setOnClickListener(this);
        frameLayout.addView(button, new FrameLayout.LayoutParams(-1, -1, 17));
        aVar.setColor(-1);
        addView(aVar, new FrameLayout.LayoutParams(-1, -1, 17));
        a(b.LOAD);
    }

    private void a(b bVar) {
        if (b.LOADING == bVar) {
            setEnabled(false);
            this.b.a();
        } else {
            setEnabled(true);
            this.b.b();
        }
        this.a.setText(b(bVar));
        this.a.setBackgroundColor(c(bVar));
    }

    private String b(b bVar) {
        return b.LOAD == bVar ? "Load" : b.LOADING == bVar ? "" : "Show";
    }

    private int c(b bVar) {
        return f.a((b.LOAD == bVar || b.LOADING == bVar) ? R.color.applovin_sdk_brand_color : R.color.applovin_sdk_adControlbutton_brightBlueColor, getContext());
    }

    public b getControlState() {
        return this.c;
    }

    public MaxAdFormat getFormat() {
        return this.d;
    }

    public void onClick(View view) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.onClick(this);
        }
    }

    public void setControlState(b bVar) {
        if (this.c != bVar) {
            a(bVar);
        }
        this.c = bVar;
    }

    public void setFormat(MaxAdFormat maxAdFormat) {
        this.d = maxAdFormat;
    }

    public void setOnClickListener(a aVar) {
        this.e = aVar;
    }
}
