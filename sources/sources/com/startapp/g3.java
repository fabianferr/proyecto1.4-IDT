package com.startapp;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import com.startapp.sdk.ads.list3d.List3DActivity;
import com.startapp.sdk.ads.list3d.List3DView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Sta */
public class g3 {
    public HashMap<String, k7> a = new HashMap<>();
    public Hashtable<String, Bitmap> b = new Hashtable<>();
    public Set<String> c = new HashSet();
    public c6 d;
    public int e = 0;
    public ConcurrentLinkedQueue<b> f = new ConcurrentLinkedQueue<>();

    /* compiled from: Sta */
    public class a extends AsyncTask<Void, Void, Bitmap> {
        public int a;
        public String b;
        public String c;

        public a(int i, String str, String str2) {
            this.a = i;
            this.b = str;
            this.c = str2;
        }

        public Object doInBackground(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            return c1.b(this.c);
        }

        public void onPostExecute(Object obj) {
            List<s4> list;
            Bitmap bitmap = (Bitmap) obj;
            g3 g3Var = g3.this;
            boolean z = true;
            g3Var.e--;
            if (bitmap != null) {
                g3Var.b.put(this.b, bitmap);
                c6 c6Var = g3.this.d;
                if (c6Var != null) {
                    int i = this.a;
                    List3DActivity list3DActivity = (List3DActivity) c6Var;
                    List3DView list3DView = list3DActivity.a;
                    View childAt = list3DView.getChildAt(i - list3DView.i);
                    if (childAt != null) {
                        t4 t4Var = (t4) childAt.getTag();
                        u4 a2 = v4.b.a(list3DActivity.f);
                        if (!(a2 == null || (list = a2.b) == null || i >= list.size())) {
                            s4 s4Var = a2.b.get(i);
                            t4Var.b.setImageBitmap(a2.a.a(i, s4Var.a, s4Var.i));
                            t4Var.b.requestLayout();
                            if (s4Var.n == null) {
                                z = false;
                            }
                            t4Var.a(z);
                        }
                    }
                }
                g3 g3Var2 = g3.this;
                if (!g3Var2.f.isEmpty()) {
                    b poll = g3Var2.f.poll();
                    new a(poll.a, poll.b, poll.c).execute(new Void[0]);
                }
            }
        }
    }

    /* compiled from: Sta */
    public class b {
        public int a;
        public String b;
        public String c;

        public b(g3 g3Var, int i, String str, String str2) {
            this.a = i;
            this.b = str;
            this.c = str2;
        }
    }

    public final String a(String[] strArr, String str) {
        if (strArr == null) {
            return null;
        }
        return TextUtils.join("^", strArr) + str;
    }

    public Bitmap a(int i, String str, String str2) {
        Bitmap bitmap = this.b.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        if (this.c.contains(str)) {
            return null;
        }
        this.c.add(str);
        int i2 = this.e;
        if (i2 >= 15) {
            this.f.add(new b(this, i, str, str2));
            return null;
        }
        this.e = i2 + 1;
        new a(i, str, str2).execute(new Void[0]);
        return null;
    }
}
