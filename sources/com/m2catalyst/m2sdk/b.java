package com.m2catalyst.m2sdk;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;

/* compiled from: ActivityMainTestingBinding */
public final class b implements ViewBinding {
    public final RelativeLayout a;
    public final AppCompatButton b;

    public b(RelativeLayout relativeLayout, AppCompatButton appCompatButton) {
        this.a = relativeLayout;
        this.b = appCompatButton;
    }

    public final View getRoot() {
        return this.a;
    }
}
