package com.appnext.core;

import android.content.Context;
import com.appnext.core.ra.services.a;
import java.util.ArrayList;

public class AppnextSDK {
    public static void sendRA(Context context, ArrayList<String> arrayList) {
        a.p(context.getApplicationContext()).d(arrayList);
    }
}
