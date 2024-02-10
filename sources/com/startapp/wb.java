package com.startapp;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import com.startapp.ib;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Sta */
public class wb implements ib {
    public final ib a;

    public wb(ib ibVar) {
        this.a = ibVar;
    }

    public JSONObject a(View view) {
        return rb.a(0, 0, 0, 0);
    }

    public void a(View view, JSONObject jSONObject, ib.a aVar, boolean z, boolean z2) {
        boolean z3;
        View rootView;
        ArrayList arrayList = new ArrayList();
        db dbVar = db.c;
        if (dbVar != null) {
            Collection<T> unmodifiableCollection = Collections.unmodifiableCollection(dbVar.b);
            IdentityHashMap identityHashMap = new IdentityHashMap((unmodifiableCollection.size() * 2) + 3);
            for (T b : unmodifiableCollection) {
                View b2 = b.b();
                if (b2 != null) {
                    if (b2.isAttachedToWindow() && b2.isShown()) {
                        View view2 = b2;
                        while (true) {
                            if (view2 == null) {
                                z3 = true;
                                break;
                            } else if (view2.getAlpha() == 0.0f) {
                                break;
                            } else {
                                ViewParent parent = view2.getParent();
                                view2 = parent instanceof View ? (View) parent : null;
                            }
                        }
                    }
                    z3 = false;
                    if (z3 && (rootView = b2.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                        identityHashMap.put(rootView, rootView);
                        float z4 = Build.VERSION.SDK_INT >= 21 ? rootView.getZ() : 0.0f;
                        int size = arrayList.size();
                        while (size > 0) {
                            if ((Build.VERSION.SDK_INT >= 21 ? ((View) arrayList.get(size - 1)).getZ() : 0.0f) <= z4) {
                                break;
                            }
                            size--;
                        }
                        arrayList.add(size, rootView);
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((w8) aVar).a((View) it.next(), this.a, jSONObject, z2);
        }
    }
}
