package com.applovin.impl.mediation.debugger.ui.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class d extends BaseAdapter implements View.OnClickListener {
    private List<c> a = new ArrayList();
    private Map<Integer, Integer> b = CollectionUtils.map();
    /* access modifiers changed from: protected */
    public Context c;
    private a d;
    private LayoutInflater e;

    public interface a {
        void a(a aVar, c cVar);
    }

    protected d(Context context) {
        this.c = context;
    }

    private LayoutInflater a() {
        LayoutInflater layoutInflater = this.e;
        if (layoutInflater != null) {
            return layoutInflater;
        }
        LayoutInflater layoutInflater2 = (LayoutInflater) this.c.getSystemService("layout_inflater");
        this.e = layoutInflater2;
        return layoutInflater2;
    }

    private a e(int i) {
        for (int i2 = 0; i2 < b(); i2++) {
            Integer num = this.b.get(Integer.valueOf(i2));
            if (num != null) {
                if (i <= num.intValue() + a(i2)) {
                    return new a(i2, i - (num.intValue() + 1));
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract int a(int i);

    public void a(a aVar) {
        this.d = aVar;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract int b();

    /* access modifiers changed from: protected */
    public abstract c b(int i);

    /* access modifiers changed from: protected */
    public abstract List<c> c(int i);

    /* renamed from: d */
    public c getItem(int i) {
        return this.a.get(i);
    }

    public int getCount() {
        return this.a.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return getItem(i).i();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c d2 = getItem(i);
        if (view == null) {
            view = a().inflate(d2.j(), viewGroup, false);
            bVar = new b();
            bVar.a = (TextView) view.findViewById(16908308);
            bVar.b = (TextView) view.findViewById(16908309);
            bVar.c = (ImageView) view.findViewById(R.id.imageView);
            bVar.d = (ImageView) view.findViewById(R.id.detailImageView);
            view.setTag(bVar);
            view.setOnClickListener(this);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.a(i);
        bVar.a(d2);
        view.setEnabled(d2.b());
        return view;
    }

    public int getViewTypeCount() {
        return c.h();
    }

    public boolean isEnabled(int i) {
        return getItem(i).b();
    }

    public void m() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                d.this.notifyDataSetChanged();
            }
        });
    }

    /* access modifiers changed from: protected */
    public c n() {
        return null;
    }

    public void notifyDataSetChanged() {
        int i;
        super.notifyDataSetChanged();
        this.a = new ArrayList();
        int b2 = b();
        this.b = CollectionUtils.map(b2);
        c n = n();
        if (n != null) {
            this.a.add(n);
            i = 1;
        } else {
            i = 0;
        }
        for (int i2 = 0; i2 < b2; i2++) {
            int a2 = a(i2);
            if (a2 != 0) {
                this.a.add(b(i2));
                this.a.addAll(c(i2));
                this.b.put(Integer.valueOf(i2), Integer.valueOf(i));
                i += a2 + 1;
            }
        }
        this.a.add(new e(""));
    }

    public void onClick(View view) {
        b bVar = (b) view.getTag();
        c b2 = bVar.b();
        a e2 = e(bVar.a());
        a aVar = this.d;
        if (aVar != null && e2 != null) {
            aVar.a(e2, b2);
        }
    }
}
