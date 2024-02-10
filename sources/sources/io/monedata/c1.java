package io.monedata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.monedata.core.R;

public final class c1 implements ViewBinding {
    private final LinearLayout a;
    public final Button b;
    public final Button c;
    public final TextView d;

    private c1(LinearLayout linearLayout, Button button, Button button2, TextView textView) {
        this.a = linearLayout;
        this.b = button;
        this.c = button2;
        this.d = textView;
    }

    public static c1 a(LayoutInflater layoutInflater) {
        return a(layoutInflater, (ViewGroup) null, false);
    }

    public static c1 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.monedata_dialog_consent, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static c1 a(View view) {
        int i = R.id.buttonAllow;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.buttonDeny;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.textMessage;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new c1((LinearLayout) view, button, button2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.a;
    }
}
