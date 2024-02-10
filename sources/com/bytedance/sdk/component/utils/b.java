package com.bytedance.sdk.component.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;

/* compiled from: ActivityUtil */
public class b {

    /* compiled from: ActivityUtil */
    public interface a {
        void a();

        void a(Throwable th);
    }

    public static boolean a(Context context, Intent intent, a aVar) {
        if (!(context == null || intent == null)) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            } catch (Throwable th) {
                if (aVar != null) {
                    aVar.a(th);
                }
            }
        }
        return false;
    }

    public static Activity a(View view) {
        View findViewById;
        Context context;
        if (view == null) {
            return null;
        }
        Context context2 = view.getContext();
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        View rootView = view.getRootView();
        if (rootView == null || (findViewById = rootView.findViewById(16908290)) == null || (context = findViewById.getContext()) == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }
}
