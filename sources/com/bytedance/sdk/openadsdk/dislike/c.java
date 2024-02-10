package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.settings.o;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TTDislikeDialogDefault */
public class c extends TTDislikeDialogAbstract {
    private TTDislikeListView a;
    private TTDislikeListView b;
    private RelativeLayout c;
    private View d;
    private b e;
    private b f;
    /* access modifiers changed from: private */
    public a g;
    private String h;
    private String i;
    /* access modifiers changed from: private */
    public List<FilterWord> j;

    /* compiled from: TTDislikeDialogDefault */
    public interface a {
        void a();

        void a(int i, FilterWord filterWord);

        void b();

        void c();

        void d();
    }

    public c(Context context, String str, List<FilterWord> list) {
        super(context, s.f(context, "tt_dislikeDialog"));
        this.i = str;
        this.j = list;
    }

    public void a(String str, List<FilterWord> list) {
        b bVar = this.e;
        if (bVar != null && this.j != null && str != null) {
            this.i = str;
            this.j = list;
            bVar.a(list);
            setMaterialMeta(str, list);
        }
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            a();
            a(getContext());
            b();
            setMaterialMeta(this.i, this.j);
        } catch (Throwable unused) {
            dismiss();
        }
    }

    public void a(String str) {
        this.h = str;
    }

    public View getLayoutView() {
        return new d().a(getContext());
    }

    public int[] getTTDislikeListViewIds() {
        return new int[]{i.bo, i.bp};
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(ad.c(getContext()) - 120, -2);
    }

    public void show() {
        try {
            super.show();
            c();
        } catch (WindowManager.BadTokenException unused) {
            l.b("dislike bad token");
        }
    }

    private void a() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = 50;
            window.setAttributes(attributes);
        }
    }

    private void b() {
        setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                if (c.this.g != null) {
                    c.this.g.b();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.g != null) {
                    c.this.g.c();
                }
            }
        });
        b bVar = new b(getLayoutInflater(), this.j);
        this.e = bVar;
        this.a.setAdapter(bVar);
        b bVar2 = new b(getLayoutInflater(), new ArrayList());
        this.f = bVar2;
        bVar2.a(false);
        this.b.setAdapter(this.f);
    }

    private void a(Context context) {
        this.c = (RelativeLayout) findViewById(i.bk);
        this.d = findViewById(i.bn);
        TextView textView = (TextView) findViewById(i.bl);
        PAGTextView pAGTextView = (PAGTextView) findViewById(i.by);
        textView.setText(s.a(getContext(), "tt_dislike_header_tv_back"));
        ((TextView) findViewById(i.bm)).setText(s.a(getContext(), "tt_dislike_header_tv_title"));
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c.this.c();
                if (c.this.g != null) {
                    c.this.g.d();
                }
            }
        });
        if (pAGTextView != null) {
            pAGTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.g.a();
                }
            });
        }
        TTDislikeListView tTDislikeListView = (TTDislikeListView) findViewById(i.bo);
        this.a = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                /*
                    r0 = this;
                    android.widget.Adapter r1 = r1.getAdapter()     // Catch:{ all -> 0x0027 }
                    java.lang.Object r1 = r1.getItem(r3)     // Catch:{ all -> 0x0027 }
                    com.bytedance.sdk.openadsdk.FilterWord r1 = (com.bytedance.sdk.openadsdk.FilterWord) r1     // Catch:{ all -> 0x0027 }
                    boolean r2 = r1.hasSecondOptions()     // Catch:{ all -> 0x0027 }
                    if (r2 == 0) goto L_0x0028
                    com.bytedance.sdk.openadsdk.dislike.c r2 = com.bytedance.sdk.openadsdk.dislike.c.this     // Catch:{ all -> 0x0027 }
                    r2.a((com.bytedance.sdk.openadsdk.FilterWord) r1)     // Catch:{ all -> 0x0027 }
                    com.bytedance.sdk.openadsdk.dislike.c r2 = com.bytedance.sdk.openadsdk.dislike.c.this     // Catch:{ all -> 0x0027 }
                    com.bytedance.sdk.openadsdk.dislike.c$a r2 = r2.g     // Catch:{ all -> 0x0027 }
                    if (r2 == 0) goto L_0x0026
                    com.bytedance.sdk.openadsdk.dislike.c r2 = com.bytedance.sdk.openadsdk.dislike.c.this     // Catch:{ all -> 0x0027 }
                    com.bytedance.sdk.openadsdk.dislike.c$a r2 = r2.g     // Catch:{ all -> 0x0027 }
                    r2.a(r3, r1)     // Catch:{ all -> 0x0027 }
                L_0x0026:
                    return
                L_0x0027:
                L_0x0028:
                    com.bytedance.sdk.openadsdk.dislike.c r1 = com.bytedance.sdk.openadsdk.dislike.c.this
                    com.bytedance.sdk.openadsdk.dislike.c$a r1 = r1.g
                    if (r1 == 0) goto L_0x0045
                    com.bytedance.sdk.openadsdk.dislike.c r1 = com.bytedance.sdk.openadsdk.dislike.c.this     // Catch:{ all -> 0x0045 }
                    com.bytedance.sdk.openadsdk.dislike.c$a r1 = r1.g     // Catch:{ all -> 0x0045 }
                    com.bytedance.sdk.openadsdk.dislike.c r2 = com.bytedance.sdk.openadsdk.dislike.c.this     // Catch:{ all -> 0x0045 }
                    java.util.List r2 = r2.j     // Catch:{ all -> 0x0045 }
                    java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0045 }
                    com.bytedance.sdk.openadsdk.FilterWord r2 = (com.bytedance.sdk.openadsdk.FilterWord) r2     // Catch:{ all -> 0x0045 }
                    r1.a(r3, r2)     // Catch:{ all -> 0x0045 }
                L_0x0045:
                    com.bytedance.sdk.openadsdk.dislike.c r1 = com.bytedance.sdk.openadsdk.dislike.c.this
                    r1.dismiss()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.dislike.c.AnonymousClass5.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
        this.a.setClosedListenerKey(this.h);
        TTDislikeListView tTDislikeListView2 = (TTDislikeListView) findViewById(i.bp);
        this.b = tTDislikeListView2;
        tTDislikeListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                /*
                    r0 = this;
                    com.bytedance.sdk.openadsdk.dislike.c r2 = com.bytedance.sdk.openadsdk.dislike.c.this
                    com.bytedance.sdk.openadsdk.dislike.c$a r2 = r2.g
                    if (r2 == 0) goto L_0x001b
                    android.widget.Adapter r1 = r1.getAdapter()     // Catch:{ all -> 0x001b }
                    java.lang.Object r1 = r1.getItem(r3)     // Catch:{ all -> 0x001b }
                    com.bytedance.sdk.openadsdk.FilterWord r1 = (com.bytedance.sdk.openadsdk.FilterWord) r1     // Catch:{ all -> 0x001b }
                    com.bytedance.sdk.openadsdk.dislike.c r2 = com.bytedance.sdk.openadsdk.dislike.c.this     // Catch:{ all -> 0x001b }
                    com.bytedance.sdk.openadsdk.dislike.c$a r2 = r2.g     // Catch:{ all -> 0x001b }
                    r2.a(r3, r1)     // Catch:{ all -> 0x001b }
                L_0x001b:
                    com.bytedance.sdk.openadsdk.dislike.c r1 = com.bytedance.sdk.openadsdk.dislike.c.this
                    r1.dismiss()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.dislike.c.AnonymousClass6.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
        this.b.setClosedListenerKey(this.h);
    }

    /* access modifiers changed from: private */
    public void c() {
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        View view = this.d;
        if (view != null) {
            view.setVisibility(8);
        }
        TTDislikeListView tTDislikeListView = this.a;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
        b bVar = this.f;
        if (bVar != null) {
            bVar.a();
        }
        TTDislikeListView tTDislikeListView2 = this.b;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void a(FilterWord filterWord) {
        if (filterWord != null) {
            b bVar = this.f;
            if (bVar != null) {
                bVar.a(filterWord.getOptions());
            }
            RelativeLayout relativeLayout = this.c;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            View view = this.d;
            if (view != null) {
                view.setVisibility(0);
            }
            TTDislikeListView tTDislikeListView = this.a;
            if (tTDislikeListView != null) {
                tTDislikeListView.setVisibility(8);
            }
            TTDislikeListView tTDislikeListView2 = this.b;
            if (tTDislikeListView2 != null) {
                tTDislikeListView2.setVisibility(0);
            }
        }
    }

    /* compiled from: TTDislikeDialogDefault */
    public static class b extends BaseAdapter {
        private boolean a = true;
        private final List<FilterWord> b;
        private final LayoutInflater c;

        public long getItemId(int i) {
            return (long) i;
        }

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.b = list;
            this.c = layoutInflater;
        }

        public void a(boolean z) {
            this.a = z;
        }

        public int getCount() {
            List<FilterWord> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public Object getItem(int i) {
            return this.b.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            a aVar;
            if (view == null) {
                aVar = new a();
                view2 = a(this.c.getContext());
                aVar.a = (TextView) view2.findViewById(i.bq);
                aVar.b = (ImageView) view2.findViewById(i.br);
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.b.get(i);
            aVar.a.setText(filterWord.getName());
            if (o.ai().T()) {
                aVar.a.setBackgroundResource(s.d(this.c.getContext(), "tt_dislike_middle_seletor"));
            } else if (i != this.b.size() - 1) {
                aVar.a.setBackgroundResource(s.d(this.c.getContext(), "tt_dislike_middle_seletor"));
            } else {
                aVar.a.setBackgroundResource(s.d(this.c.getContext(), "tt_dislike_bottom_seletor"));
            }
            if (this.a && i == 0) {
                aVar.a.setBackgroundResource(s.d(this.c.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.b.setVisibility(0);
            } else {
                aVar.b.setVisibility(8);
            }
            return view2;
        }

        private View a(Context context) {
            PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(context);
            pAGFrameLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            PAGTextView pAGTextView = new PAGTextView(context);
            pAGTextView.setId(i.bq);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ad.b(context, 44.0f));
            layoutParams.gravity = 17;
            pAGTextView.setLayoutParams(layoutParams);
            pAGTextView.setGravity(17);
            pAGTextView.setTextColor(Color.parseColor("#FF4A4A4A"));
            pAGTextView.setTextSize(16.0f);
            PAGImageView pAGImageView = new PAGImageView(context);
            pAGImageView.setId(i.br);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ad.b(context, 44.0f), ad.b(context, 44.0f));
            layoutParams2.gravity = 8388629;
            pAGImageView.setLayoutParams(layoutParams2);
            pAGImageView.setRotation(180.0f);
            pAGImageView.setScaleType(ImageView.ScaleType.CENTER);
            pAGImageView.setImageResource(s.d(context, "tt_lefterbackicon_titlebar_press_wrapper"));
            pAGFrameLayout.addView(pAGTextView);
            pAGFrameLayout.addView(pAGImageView);
            return pAGFrameLayout;
        }

        public void a(List<FilterWord> list) {
            if (list != null && !list.isEmpty()) {
                this.b.clear();
                this.b.addAll(list);
                notifyDataSetChanged();
            }
        }

        public void a() {
            this.b.clear();
            notifyDataSetChanged();
        }

        /* compiled from: TTDislikeDialogDefault */
        private static class a {
            TextView a;
            ImageView b;

            private a() {
            }
        }
    }
}
