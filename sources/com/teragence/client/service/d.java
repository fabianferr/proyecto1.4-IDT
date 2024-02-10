package com.teragence.client.service;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;

public class d {
    private final String a;

    public d(String str) {
        this.a = str;
    }

    public Intent a(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        intent.setData(Uri.parse(this.a));
        return intent;
    }

    public PersistableBundle a(String str) {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(str, this.a);
        return persistableBundle;
    }
}
