package com.wortise.ads;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* compiled from: WortiseDialogConsentBinding */
public final class g7 implements ViewBinding {
    private final LinearLayout a;
    public final AppCompatButton b;
    public final AppCompatButton c;
    public final TextView d;

    private g7(LinearLayout linearLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, TextView textView) {
        this.a = linearLayout;
        this.b = appCompatButton;
        this.c = appCompatButton2;
        this.d = textView;
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static g7 a(LayoutInflater layoutInflater) {
        return a(layoutInflater, (ViewGroup) null, false);
    }

    public static g7 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.wortise_dialog_consent, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static g7 a(View view) {
        int i = R.id.buttonDeny;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R.id.buttonGrant;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton2 != null) {
                i = R.id.textMessage;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new g7((LinearLayout) view, appCompatButton, appCompatButton2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
