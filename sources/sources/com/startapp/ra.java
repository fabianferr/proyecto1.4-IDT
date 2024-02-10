package com.startapp;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.startapp.sdk.ads.banner.BannerOptions;
import com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Sta */
public class ra {
    public static NotDisplayedReason a(View view, BannerOptions bannerOptions, AtomicReference<JSONObject> atomicReference) {
        NotDisplayedReason notDisplayedReason;
        ViewGroup viewGroup = view;
        AtomicReference<JSONObject> atomicReference2 = atomicReference;
        if (viewGroup == null) {
            return NotDisplayedReason.INTERNAL_ERROR;
        }
        if (bannerOptions.u()) {
            if (view.getParent() == null) {
                notDisplayedReason = NotDisplayedReason.VIEW_NOT_ATTACHED;
            } else if (view.getRootView() == null) {
                notDisplayedReason = NotDisplayedReason.VIEW_NOT_ATTACHED;
            } else if (view.getRootView().getParent() == null) {
                notDisplayedReason = NotDisplayedReason.VIEW_NOT_ATTACHED;
            } else if (!view.isShown()) {
                notDisplayedReason = NotDisplayedReason.VIEW_NOT_VISIBLE;
            } else if (view.getWidth() < 1 || view.getHeight() < 1) {
                notDisplayedReason = NotDisplayedReason.VIEW_INVALID_SIZE;
            } else {
                notDisplayedReason = null;
            }
            if (notDisplayedReason != null) {
                return notDisplayedReason;
            }
        }
        if (bannerOptions.s() && !view.hasWindowFocus()) {
            return NotDisplayedReason.WINDOW_NOT_FOCUSED;
        }
        if (!bannerOptions.r()) {
            return null;
        }
        int height = ((view.getHeight() * view.getWidth()) * Math.min(Math.max(1, bannerOptions.h()), 100)) / 100;
        Rect rect = new Rect();
        if (!viewGroup.getGlobalVisibleRect(rect)) {
            return NotDisplayedReason.AD_CLIPPED;
        }
        if (rect.isEmpty()) {
            return NotDisplayedReason.AD_CLIPPED;
        }
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        atomicReference2.set(a(viewGroup, rect, true));
        NotDisplayedReason notDisplayedReason2 = NotDisplayedReason.AD_CLIPPED;
        while (true) {
            int i = 0;
            if (!(viewGroup.getParent() instanceof ViewGroup)) {
                RegionIterator regionIterator = new RegionIterator(region);
                while (regionIterator.next(rect2)) {
                    i += rect2.height() * rect2.width();
                    if (i >= height) {
                        return null;
                    }
                }
                return notDisplayedReason2;
            } else if (bannerOptions.t() && viewGroup.getVisibility() != 0) {
                return NotDisplayedReason.VIEW_NOT_VISIBLE;
            } else {
                if (bannerOptions.q() && viewGroup.getAlpha() < 1.0f) {
                    return NotDisplayedReason.VIEW_TRANSPARENT;
                }
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                JSONObject a = a((View) viewGroup2, ((viewGroup2.getParent() instanceof ViewGroup) || !viewGroup2.getGlobalVisibleRect(rect2)) ? null : rect2, false);
                a(a, atomicReference.get());
                atomicReference2.set(a);
                int indexOfChild = viewGroup2.indexOfChild(viewGroup);
                int childCount = viewGroup2.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup2.getChildAt(i2);
                    if (childAt != viewGroup) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            int compare = Float.compare(childAt.getZ(), viewGroup.getZ());
                            if (compare >= 0) {
                                if (compare == 0 && i2 <= indexOfChild) {
                                }
                            }
                        } else if (i2 <= indexOfChild) {
                        }
                        if (childAt != null && childAt.getVisibility() == 0 && childAt.getGlobalVisibleRect(rect2) && Rect.intersects(rect, rect2)) {
                            region.op(rect2, Region.Op.DIFFERENCE);
                            a(a, a(childAt, rect2, false));
                            notDisplayedReason2 = NotDisplayedReason.AD_WAS_COVERED;
                        }
                    }
                }
                viewGroup = viewGroup2;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = "0x" + java.lang.Integer.toHexString(r4.getId());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(android.view.View r4, android.graphics.Rect r5, boolean r6) {
        /*
            java.lang.String r0 = "0x"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "class"
            java.lang.String r3 = a(r4)     // Catch:{ JSONException -> 0x0082 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0082 }
            int r2 = r4.getId()     // Catch:{ JSONException -> 0x0082 }
            r3 = -1
            if (r2 != r3) goto L_0x0019
            r0 = 0
            goto L_0x003e
        L_0x0019:
            android.content.Context r2 = r4.getContext()     // Catch:{ NotFoundException -> 0x002a }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ NotFoundException -> 0x002a }
            int r3 = r4.getId()     // Catch:{ NotFoundException -> 0x002a }
            java.lang.String r0 = r2.getResourceName(r3)     // Catch:{ NotFoundException -> 0x002a }
            goto L_0x003e
        L_0x002a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0082 }
            r2.<init>(r0)     // Catch:{ JSONException -> 0x0082 }
            int r0 = r4.getId()     // Catch:{ JSONException -> 0x0082 }
            java.lang.String r0 = java.lang.Integer.toHexString(r0)     // Catch:{ JSONException -> 0x0082 }
            r2.append(r0)     // Catch:{ JSONException -> 0x0082 }
            java.lang.String r0 = r2.toString()     // Catch:{ JSONException -> 0x0082 }
        L_0x003e:
            if (r0 == 0) goto L_0x0045
            java.lang.String r2 = "id"
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x0082 }
        L_0x0045:
            if (r6 == 0) goto L_0x004e
            java.lang.String r6 = "target"
            r0 = 1
            r1.put(r6, r0)     // Catch:{ JSONException -> 0x0082 }
        L_0x004e:
            float r6 = r4.getAlpha()     // Catch:{ JSONException -> 0x0082 }
            r0 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 >= 0) goto L_0x0062
            java.lang.String r6 = "alpha"
            float r4 = r4.getAlpha()     // Catch:{ JSONException -> 0x0082 }
            double r2 = (double) r4     // Catch:{ JSONException -> 0x0082 }
            r1.put(r6, r2)     // Catch:{ JSONException -> 0x0082 }
        L_0x0062:
            if (r5 == 0) goto L_0x0081
            java.lang.String r4 = "left"
            int r6 = r5.left     // Catch:{ JSONException -> 0x0082 }
            r1.put(r4, r6)     // Catch:{ JSONException -> 0x0082 }
            java.lang.String r4 = "top"
            int r6 = r5.top     // Catch:{ JSONException -> 0x0082 }
            r1.put(r4, r6)     // Catch:{ JSONException -> 0x0082 }
            java.lang.String r4 = "right"
            int r6 = r5.right     // Catch:{ JSONException -> 0x0082 }
            r1.put(r4, r6)     // Catch:{ JSONException -> 0x0082 }
            java.lang.String r4 = "bottom"
            int r5 = r5.bottom     // Catch:{ JSONException -> 0x0082 }
            r1.put(r4, r5)     // Catch:{ JSONException -> 0x0082 }
        L_0x0081:
            return r1
        L_0x0082:
            r4 = move-exception
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.ra.a(android.view.View, android.graphics.Rect, boolean):org.json.JSONObject");
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
            try {
                jSONObject.put("children", optJSONArray);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        optJSONArray.put(jSONObject2);
    }

    public static String a(View view) {
        String name = view.getClass().getName();
        if (name.startsWith("android.") || name.startsWith("androidx.") || name.startsWith("com.android.")) {
            return view.getClass().getSimpleName();
        }
        String packageName = view.getContext().getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(".");
        return name.startsWith(sb.toString()) ? name.substring(packageName.length()) : name;
    }
}
