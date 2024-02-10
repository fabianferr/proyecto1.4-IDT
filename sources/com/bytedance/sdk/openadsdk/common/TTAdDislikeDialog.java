package com.bytedance.sdk.openadsdk.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.dislike.d;
import com.bytedance.sdk.openadsdk.dislike.e;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import java.util.ArrayList;

public class TTAdDislikeDialog extends PAGFrameLayout {
    private View a;
    private TTDislikeListView b;
    private TTDislikeListView c;
    private RelativeLayout d;
    private View e;
    private c.b f;
    private c.b g;
    /* access modifiers changed from: private */
    public q h;
    /* access modifiers changed from: private */
    public a i;
    private Context j;
    private boolean k;
    private e l;

    public interface a {
        void a(int i, FilterWord filterWord);

        void a(View view);

        void b(View view);

        void c(View view);
    }

    public TTAdDislikeDialog(Context context, q qVar) {
        this(context.getApplicationContext());
        this.j = context;
        this.h = qVar;
        d();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TTAdDislikeDialog(Context context) {
        this(context, (AttributeSet) null);
        AttributeSet attributeSet = null;
    }

    public TTAdDislikeDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTAdDislikeDialog(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = false;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTAdDislikeDialog.this.b();
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.a = new d().a(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = ad.b(getContext(), 20.0f);
        layoutParams.rightMargin = ad.b(getContext(), 20.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setClickable(true);
        e();
        d();
    }

    private void d() {
        if (this.h != null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            c.b bVar = new c.b(from, this.h.ae());
            this.f = bVar;
            this.b.setAdapter(bVar);
            c.b bVar2 = new c.b(from, new ArrayList());
            this.g = bVar2;
            bVar2.a(false);
            this.c.setAdapter(this.g);
            this.b.setMaterialMeta(this.h.ac());
            this.c.setMaterialMeta(this.h.ac());
        }
    }

    private void e() {
        this.d = (RelativeLayout) this.a.findViewById(i.bk);
        this.e = this.a.findViewById(i.bn);
        PAGTextView pAGTextView = (PAGTextView) this.a.findViewById(i.by);
        TextView textView = (TextView) this.a.findViewById(i.bl);
        textView.setText(s.a(getContext(), "tt_dislike_header_tv_back"));
        ((TextView) this.a.findViewById(i.bm)).setText(s.a(getContext(), "tt_dislike_header_tv_title"));
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTAdDislikeDialog.this.f();
                if (TTAdDislikeDialog.this.i != null) {
                    TTAdDislikeDialog.this.i.c(view);
                }
            }
        });
        if (pAGTextView != null) {
            pAGTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTAdDislikeDialog.this.c();
                }
            });
        }
        TTDislikeListView tTDislikeListView = (TTDislikeListView) this.a.findViewById(i.bo);
        this.b = tTDislikeListView;
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
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this     // Catch:{ all -> 0x0027 }
                    r2.a((com.bytedance.sdk.openadsdk.FilterWord) r1)     // Catch:{ all -> 0x0027 }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this     // Catch:{ all -> 0x0027 }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog$a r2 = r2.i     // Catch:{ all -> 0x0027 }
                    if (r2 == 0) goto L_0x0026
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this     // Catch:{ all -> 0x0027 }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog$a r2 = r2.i     // Catch:{ all -> 0x0027 }
                    r2.a(r3, r1)     // Catch:{ all -> 0x0027 }
                L_0x0026:
                    return
                L_0x0027:
                L_0x0028:
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r1 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog$a r1 = r1.i
                    if (r1 == 0) goto L_0x0049
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r1 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this     // Catch:{ all -> 0x0049 }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog$a r1 = r1.i     // Catch:{ all -> 0x0049 }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this     // Catch:{ all -> 0x0049 }
                    com.bytedance.sdk.openadsdk.core.model.q r2 = r2.h     // Catch:{ all -> 0x0049 }
                    java.util.List r2 = r2.ae()     // Catch:{ all -> 0x0049 }
                    java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0049 }
                    com.bytedance.sdk.openadsdk.FilterWord r2 = (com.bytedance.sdk.openadsdk.FilterWord) r2     // Catch:{ all -> 0x0049 }
                    r1.a(r3, r2)     // Catch:{ all -> 0x0049 }
                L_0x0049:
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r1 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this
                    r1.b()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.AnonymousClass4.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
        TTDislikeListView tTDislikeListView2 = (TTDislikeListView) this.a.findViewById(i.bp);
        this.c = tTDislikeListView2;
        tTDislikeListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                /*
                    r0 = this;
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog$a r2 = r2.i
                    if (r2 == 0) goto L_0x001b
                    android.widget.Adapter r1 = r1.getAdapter()     // Catch:{ all -> 0x001b }
                    java.lang.Object r1 = r1.getItem(r3)     // Catch:{ all -> 0x001b }
                    com.bytedance.sdk.openadsdk.FilterWord r1 = (com.bytedance.sdk.openadsdk.FilterWord) r1     // Catch:{ all -> 0x001b }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r2 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this     // Catch:{ all -> 0x001b }
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog$a r2 = r2.i     // Catch:{ all -> 0x001b }
                    r2.a(r3, r1)     // Catch:{ all -> 0x001b }
                L_0x001b:
                    com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog r1 = com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.this
                    r1.b()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.AnonymousClass5.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
    }

    public void a() {
        l.b("TTAD.DisLD", "showDislike: ");
        if (this.a.getParent() == null) {
            addView(this.a);
        }
        f();
        setVisibility(0);
        this.k = true;
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void b() {
        setVisibility(8);
        this.k = false;
        a aVar = this.i;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void setCallback(a aVar) {
        this.i = aVar;
    }

    /* access modifiers changed from: private */
    public void f() {
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        View view = this.e;
        if (view != null) {
            view.setVisibility(8);
        }
        TTDislikeListView tTDislikeListView = this.b;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
        c.b bVar = this.g;
        if (bVar != null) {
            bVar.a();
        }
        TTDislikeListView tTDislikeListView2 = this.c;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void a(FilterWord filterWord) {
        if (filterWord != null) {
            c.b bVar = this.g;
            if (bVar != null) {
                bVar.a(filterWord.getOptions());
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            View view = this.e;
            if (view != null) {
                view.setVisibility(0);
            }
            TTDislikeListView tTDislikeListView = this.b;
            if (tTDislikeListView != null) {
                tTDislikeListView.setVisibility(8);
            }
            TTDislikeListView tTDislikeListView2 = this.c;
            if (tTDislikeListView2 != null) {
                tTDislikeListView2.setVisibility(0);
            }
        }
    }

    public void c() {
        Context context = this.j;
        if (context instanceof Activity) {
            boolean z = !((Activity) context).isFinishing();
            e eVar = new e(this.j);
            this.l = eVar;
            eVar.a(g());
            this.l.a(this.h.ac(), this.h.ao().toString());
            if (z && !this.l.isShowing()) {
                this.l.show();
            }
        }
    }

    private e.a g() {
        return new e.a() {
            public void b() {
            }

            public void a() {
                TTAdDislikeDialog.this.setVisibility(8);
            }

            public void c() {
                TTAdDislikeDialog.this.setVisibility(0);
            }

            public void d() {
                TTAdDislikeDialog.this.setVisibility(0);
            }

            public void a(int i, FilterWord filterWord) {
                if (TTAdDislikeDialog.this.i != null) {
                    TTAdDislikeDialog.this.i.a(i, filterWord);
                    TTAdDislikeDialog.this.i.b(TTAdDislikeDialog.this);
                }
            }
        };
    }
}
