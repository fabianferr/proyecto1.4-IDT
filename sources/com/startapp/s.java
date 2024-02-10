package com.startapp;

import android.content.DialogInterface;
import android.webkit.WebView;

/* compiled from: Sta */
public class s implements DialogInterface.OnCancelListener {
    public final /* synthetic */ WebView a;

    public s(WebView webView) {
        this.a = webView;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.stopLoading();
    }
}
