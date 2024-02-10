package com.mbridge.msdk.foundation.tools;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/* compiled from: ViewCoveredUtils */
public final class an {
    private static boolean a = false;

    public static boolean a(View view, int i) {
        if (view == null) {
            return true;
        }
        if (view.getVisibility() != 0) {
            aa.d("ViewUtils", "Banner Judge : Banner's not visible.");
            return true;
        }
        float f = 0.5f;
        if (view.getAlpha() < 0.5f) {
            aa.d("ViewUtils", "Banner Judge : Banner's alpha must set up 50%.");
            return true;
        } else if (view.getParent() == null || !(view.getParent() instanceof ViewGroup) || ((ViewGroup) view.getParent()).getVisibility() == 0) {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            if (i == 1) {
                f = 0.0f;
            }
            boolean z = ((float) ((rect.bottom - rect.top) * (rect.right - rect.left))) > ((float) (view.getMeasuredHeight() * view.getMeasuredWidth())) * f;
            boolean z2 = globalVisibleRect && z;
            aa.d("ViewUtils", "View Judge : partVisible is " + globalVisibleRect + " halfPercentVisible is " + z);
            StringBuilder sb = new StringBuilder("View Judge : totalViewVisible is ");
            sb.append(z2);
            aa.d("ViewUtils", sb.toString());
            if (!z2) {
                return true;
            }
            ViewGroup viewGroup = view;
            while (viewGroup.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                for (int a2 = a(viewGroup, viewGroup2) + 1; a2 < viewGroup2.getChildCount(); a2++) {
                    View childAt = viewGroup2.getChildAt(a2);
                    if (childAt.getVisibility() == 0 && a(view, childAt, i)) {
                        if (childAt instanceof ViewGroup) {
                            ViewGroup viewGroup3 = (ViewGroup) childAt;
                            if (viewGroup3.getChildCount() > 0) {
                                aa.d("ViewUtils", "View Judge : Covered by ViewGroup.");
                                boolean a3 = a(view, viewGroup3, i);
                                a = false;
                                if (a3) {
                                    return true;
                                }
                            }
                        }
                        if (a(childAt)) {
                            aa.d("ViewUtils", "View Judge : View Covered and Cover View is not transparent.");
                            return true;
                        }
                    }
                }
                viewGroup = viewGroup2;
            }
            aa.d("ViewUtils", "View Judge : Well done, View is not covered.");
            return false;
        } else {
            aa.d("ViewUtils", "View Judge : View's container is not visible.");
            return true;
        }
    }

    private static boolean a(View view) {
        if ((view == null || !(view.getTag() instanceof String) || !"mb_wm".equals(view.getTag())) && view.getBackground() != null && view.getBackground().getAlpha() > 127 && view.getAlpha() > 0.5f) {
            return true;
        }
        return false;
    }

    private static boolean a(View view, View view2, int i) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view2.getGlobalVisibleRect(rect2);
        if (!Rect.intersects(rect, rect2)) {
            return false;
        }
        int min = Math.min(rect.right, rect2.right) - Math.max(rect.left, rect2.left);
        int min2 = Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top);
        if ((i == 1 || min * min2 * 2 < view.getMeasuredHeight() * view.getMeasuredWidth()) && (i != 1 || min * min2 < view.getMeasuredHeight() * view.getMeasuredWidth())) {
            return false;
        }
        return true;
    }

    private static int a(View view, ViewGroup viewGroup) {
        int i = 0;
        while (i < viewGroup.getChildCount() && viewGroup.getChildAt(i) != view) {
            i++;
        }
        return i;
    }

    private static boolean a(View view, ViewGroup viewGroup, int i) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            aa.d("ViewUtils", "View Judge : Start Loop");
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0 && a(view, childAt, i)) {
                if ((childAt instanceof WebView) && childAt.getVisibility() == 0) {
                    aa.d("ViewUtils", "View Judge : View Covered by WebView.");
                    a = true;
                }
                if (a(childAt)) {
                    aa.d("ViewUtils", "View Judge : View Covered and Cover ViewGroup is not transparent.");
                    a = true;
                }
                if (a) {
                    break;
                } else if (childAt instanceof ViewGroup) {
                    a(view, (ViewGroup) childAt, i);
                }
            }
        }
        return a;
    }
}
