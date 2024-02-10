package com.wortise.ads;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* compiled from: WortiseActivityFullscreenBinding */
public final class f7 implements ViewBinding {
    private final RelativeLayout a;
    public final RelativeLayout b;
    public final Button c;

    private f7(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, Button button) {
        this.a = relativeLayout;
        this.b = relativeLayout2;
        this.c = button;
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.a;
    }

    public static f7 a(LayoutInflater layoutInflater) {
        return a(layoutInflater, (ViewGroup) null, false);
    }

    public static f7 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.wortise_activity_fullscreen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static f7 a(View view) {
        int i = R.id.adFrame;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.buttonClose;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                return new f7((RelativeLayout) view, relativeLayout, button);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
