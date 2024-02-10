package com.startapp;

import android.content.Context;
import android.webkit.WebView;
import com.iab.omid.library.startio.adsession.AdSessionContextType;
import com.iab.omid.library.startio.adsession.CreativeType;
import com.iab.omid.library.startio.adsession.ImpressionType;
import com.iab.omid.library.startio.adsession.Owner;
import com.startapp.sdk.omsdk.VerificationDetails;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Sta */
public class r {
    public static boolean a(Context context) {
        try {
            if (e6.a.a) {
                return true;
            }
            e6.a(context);
            return true;
        } catch (Throwable th) {
            i3.a(th);
            return false;
        }
    }

    public static o b(WebView webView) {
        try {
            return a(webView);
        } catch (Throwable th) {
            i3.a(th);
            return null;
        }
    }

    public static o b(Context context, List<VerificationDetails> list, boolean z) {
        try {
            return a(context, list, z);
        } catch (Throwable th) {
            i3.a(th);
            return null;
        }
    }

    public static o a(WebView webView) {
        if (!a(webView.getContext())) {
            return null;
        }
        gc.a("Startio", "Name is null or empty");
        gc.a("4.11.0", "Version is null or empty");
        return a(new q(new i6("Startio", "4.11.0"), webView, (String) null, (List<w9>) null, (String) null, "", AdSessionContextType.HTML), false, false);
    }

    public static a5 b(o oVar) {
        if (oVar == null) {
            return null;
        }
        try {
            return a5.a(oVar);
        } catch (Throwable th) {
            i3.a(th);
            return null;
        }
    }

    public static o a(Context context, List<VerificationDetails> list, boolean z) {
        URL url;
        if (!a(context)) {
            return null;
        }
        String a = f6.a();
        ArrayList arrayList = new ArrayList(list.size());
        for (VerificationDetails next : list) {
            try {
                url = new URL(next.c());
            } catch (Throwable th) {
                i3.a(th);
                url = null;
            }
            if (url != null) {
                String a2 = next.a();
                String b = next.b();
                gc.a(a2, "VendorKey is null or empty");
                gc.a(b, "VerificationParameters is null or empty");
                arrayList.add(new w9(a2, url, b));
            }
        }
        gc.a("Startio", "Name is null or empty");
        gc.a("4.11.0", "Version is null or empty");
        i6 i6Var = new i6("Startio", "4.11.0");
        gc.a((Object) a, "OM SDK JS script content is null");
        return a(new q(i6Var, (WebView) null, a, arrayList, (String) null, "", AdSessionContextType.NATIVE), z, true);
    }

    public static o a(q qVar, boolean z, boolean z2) {
        Owner owner;
        CreativeType creativeType = z ? CreativeType.d : z2 ? CreativeType.NATIVE_DISPLAY : CreativeType.HTML_DISPLAY;
        ImpressionType impressionType = ImpressionType.VIEWABLE;
        Owner owner2 = Owner.NATIVE;
        if (z) {
            owner = owner2;
        } else {
            owner = Owner.NONE;
        }
        if (creativeType != CreativeType.DEFINED_BY_JAVASCRIPT) {
            p pVar = new p(creativeType, impressionType, owner2, owner, false);
            if (e6.a.a) {
                return new fb(pVar, qVar);
            }
            throw new IllegalStateException("Method called before OM SDK activation");
        }
        throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
    }

    public static l a(o oVar) {
        if (oVar == null) {
            return null;
        }
        try {
            return l.a(oVar);
        } catch (Throwable th) {
            i3.a(th);
            return null;
        }
    }
}
