package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.y;
import java.util.List;

/* compiled from: ViewUtils */
public class ae {

    /* compiled from: ViewUtils */
    public interface b {
        void a();

        void a(View view, boolean z);

        void a(boolean z);

        void b();
    }

    public static void a(final ViewGroup viewGroup, boolean z, int i, b bVar, List<ViewGroup> list) {
        viewGroup.setTag(520093765, bVar);
        viewGroup.setTag(520093766, Integer.valueOf(i));
        if (viewGroup.getTag(520093764) != true) {
            final a aVar = new a(viewGroup);
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    list.get(i2).setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
                        public void onChildViewAdded(View view, View view2) {
                            aVar.a = view2;
                        }

                        public void onChildViewRemoved(View view, View view2) {
                            aVar.a = null;
                        }
                    });
                }
            }
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
            if (z) {
                viewGroup.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                    public void onScrollChanged() {
                        try {
                            ViewGroup viewGroup = viewGroup;
                            ae.b(viewGroup, (b) viewGroup.getTag(520093765), (Integer) viewGroup.getTag(520093766));
                        } catch (Exception e) {
                            ApmHelper.reportCustomError("onScrollChanged exception " + viewGroup.getTag(520093765), "ViewUtils", e);
                        }
                    }
                });
            }
            viewGroup.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
                public void onWindowFocusChanged(boolean z) {
                    try {
                        b bVar = (b) viewGroup.getTag(520093765);
                        if (bVar != null) {
                            bVar.a(z);
                            ViewGroup viewGroup = viewGroup;
                            ae.b(viewGroup, bVar, (Integer) viewGroup.getTag(520093766));
                        }
                    } catch (Exception e) {
                        ApmHelper.reportCustomError("onWindowFocusChanged exception " + viewGroup.getTag(520093765), "ViewUtils", e);
                    }
                }
            });
            viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    b bVar = (b) viewGroup.getTag(520093765);
                    if (bVar != null) {
                        bVar.a();
                    }
                }

                public void onViewDetachedFromWindow(View view) {
                    b bVar = (b) viewGroup.getTag(520093765);
                    if (bVar != null) {
                        bVar.b();
                    }
                }
            });
            viewGroup.setTag(520093764, true);
        }
    }

    /* compiled from: ViewUtils */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        View a = null;
        final /* synthetic */ ViewGroup b;

        a(ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        public void onGlobalLayout() {
            try {
                b bVar = (b) this.b.getTag(520093765);
                if (this.a != null) {
                    Rect rect = new Rect();
                    this.a.getGlobalVisibleRect(rect);
                    Rect rect2 = new Rect();
                    this.b.getGlobalVisibleRect(rect2);
                    if (rect.contains(rect2)) {
                        if (bVar != null) {
                            bVar.a(this.b, false);
                        }
                        this.b.setTag(520093763, false);
                        return;
                    }
                    if (bVar != null) {
                        bVar.a(this.b, true);
                    }
                    this.b.setTag(520093763, true);
                    return;
                }
                ViewGroup viewGroup = this.b;
                ae.b(viewGroup, bVar, (Integer) viewGroup.getTag(520093766));
            } catch (Exception e) {
                ApmHelper.reportCustomError("onGlobalLayout exception " + this.b.getTag(520093765), "ViewUtils", e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(View view, b bVar, Integer num) {
        if (bVar != null) {
            if (num == null) {
                num = 0;
            }
            Boolean bool = (Boolean) view.getTag(520093763);
            boolean a2 = a(view, num.intValue());
            if (bool == null) {
                if (a2) {
                    bVar.a(view, true);
                    view.setTag(520093763, true);
                }
            } else if (bool.booleanValue() != a2) {
                bVar.a(view, a2);
                view.setTag(520093763, Boolean.valueOf(a2));
            }
        }
    }

    private static boolean a(View view, int i) {
        return y.a(view, 20, i);
    }
}
