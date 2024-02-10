package com.mbridge.msdk.dycreator.wrapper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.b.a;
import com.mbridge.msdk.dycreator.e.f;
import com.mbridge.msdk.dycreator.viewmodel.BaseViewModel;
import com.mbridge.msdk.dycreator.viewmodel.MBCommonViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBRewardViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DynamicViewCreator {
    private static volatile DynamicViewCreator a = null;
    private static int b = -201;

    private DynamicViewCreator() {
        b.a().a(com.mbridge.msdk.foundation.controller.b.d().g());
    }

    public static DynamicViewCreator getInstance() {
        if (a == null) {
            synchronized (DynamicViewCreator.class) {
                if (a == null) {
                    a = new DynamicViewCreator();
                }
            }
        }
        return a;
    }

    public void createDynamicView(DyOption dyOption, DynamicViewBackListener dynamicViewBackListener) {
        boolean z;
        BaseViewModel baseViewModel;
        boolean z2;
        if (dyOption == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_DYNAMIC_OPTION));
        } else if (dynamicViewBackListener != null) {
            Context g = com.mbridge.msdk.foundation.controller.b.d().g();
            if (g == null) {
                dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_CONTEXT));
                return;
            }
            if (dyOption != null) {
                z = false;
                if (dyOption.getCampaignEx() == null) {
                    dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_CAMPAIGN));
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (dyOption.getFile() != null || dyOption.getFileDirs() == null) {
                    z = z2;
                } else {
                    dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.BIND_DATA_FILE_OR_DIR));
                }
            } else {
                z = true;
            }
            if (z) {
                try {
                    a(dyOption, "create dynamic view", "start");
                    View a2 = a(g, dyOption);
                    if (a2 == null) {
                        dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.FILE_CREATE_VIEW_FILE));
                        a(dyOption, "create dynamic view", "fail");
                        return;
                    }
                    a(dyOption, "create dynamic view", "success");
                    int i = AnonymousClass1.a[dyOption.getDyAdType().ordinal()];
                    if (i == 1) {
                        baseViewModel = new MBSplashViewVModel(dyOption);
                    } else if (i != 2) {
                        baseViewModel = new MBCommonViewVModel();
                    } else {
                        baseViewModel = new MBRewardViewVModel(dyOption);
                    }
                    baseViewModel.setDynamicViewBackListener(dynamicViewBackListener);
                    com.mbridge.msdk.dycreator.binding.b.a().a(baseViewModel);
                    baseViewModel.setModelDataAndBind();
                    a(dyOption, "create dynamic view", "bind_data_done");
                    dynamicViewBackListener.viewCreatedSuccess(a2);
                } catch (Exception e) {
                    aa.d("DynamicViewCreator", e.getMessage());
                    dynamicViewBackListener.viewCreateFail(new a(b, e.getMessage()));
                }
            }
        }
    }

    /* renamed from: com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mbridge.msdk.dycreator.wrapper.DyAdType[] r0 = com.mbridge.msdk.dycreator.wrapper.DyAdType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.mbridge.msdk.dycreator.wrapper.DyAdType r1 = com.mbridge.msdk.dycreator.wrapper.DyAdType.SPLASH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.wrapper.DyAdType r1 = com.mbridge.msdk.dycreator.wrapper.DyAdType.REWARD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator.AnonymousClass1.<clinit>():void");
        }
    }

    public View createDynamicView(DyOption dyOption) {
        Context g;
        if (dyOption == null || (g = com.mbridge.msdk.foundation.controller.b.d().g()) == null) {
            return null;
        }
        return a(g, dyOption);
    }

    private View a(Context context, DyOption dyOption) {
        List<String> fileDirs;
        if (dyOption == null || (fileDirs = dyOption.getFileDirs()) == null) {
            return null;
        }
        int i = 0;
        ViewGroup viewGroup = null;
        int i2 = 0;
        while (i2 < fileDirs.size()) {
            try {
                if (!TextUtils.isEmpty(fileDirs.get(i2))) {
                    if (i2 == 0) {
                        viewGroup = (ViewGroup) f.a(context).a(fileDirs.get(i2));
                    } else {
                        String str = fileDirs.get(i2);
                        if (!(context == null || viewGroup == null || TextUtils.isEmpty(str))) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                String string = jSONObject.getString("folder_dir");
                                if (!TextUtils.isEmpty(string)) {
                                    JSONArray jSONArray = new JSONArray(jSONObject.optString("ext_template"));
                                    if (jSONArray.length() != 0) {
                                        int i3 = 0;
                                        while (i3 < jSONArray.length()) {
                                            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                                            if (jSONObject2 != null) {
                                                View a2 = f.a(context).a(string + File.separator + jSONObject2.optString("name"));
                                                if (!(viewGroup == null || a2 == null)) {
                                                    JSONObject jSONObject3 = jSONObject2.getJSONObject("layout");
                                                    if (jSONObject3 == null) {
                                                        viewGroup.addView(a2, 3);
                                                    } else if (!(context == null || viewGroup == null || a2 == null || jSONObject3 == null)) {
                                                        try {
                                                            String optString = jSONObject3.optString("parent_id");
                                                            ViewGroup viewGroup2 = !TextUtils.isEmpty(optString) ? (ViewGroup) f.a(context).a(viewGroup, optString) : viewGroup;
                                                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup2.getLayoutParams();
                                                            if (layoutParams != null) {
                                                                String optString2 = jSONObject3.optString("below", "");
                                                                if (!TextUtils.isEmpty(optString2)) {
                                                                    layoutParams.addRule(3, optString2.hashCode());
                                                                }
                                                                String optString3 = jSONObject3.optString("left_of", "");
                                                                if (!TextUtils.isEmpty(optString3)) {
                                                                    layoutParams.addRule(i, optString3.hashCode());
                                                                }
                                                                String optString4 = jSONObject3.optString("right_of", "");
                                                                if (!TextUtils.isEmpty(optString4)) {
                                                                    layoutParams.addRule(1, optString4.hashCode());
                                                                }
                                                                int optInt = jSONObject3.optInt(FirebaseAnalytics.Param.INDEX, -2);
                                                                int optInt2 = jSONObject3.optInt("visibility", -1);
                                                                if (optInt2 != -1) {
                                                                    a2.setVisibility(optInt2);
                                                                }
                                                                if (optInt != -2) {
                                                                    viewGroup2.addView(a2, optInt, layoutParams);
                                                                } else {
                                                                    viewGroup2.addView(a2, layoutParams);
                                                                }
                                                            }
                                                        } catch (Exception e) {
                                                            aa.d("DynamicViewCreator", e.getMessage());
                                                        }
                                                    }
                                                }
                                            }
                                            i3++;
                                            i = 0;
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                aa.d("DynamicViewCreator", e2.getMessage());
                            }
                        }
                    }
                }
                i2++;
                i = 0;
            } catch (Exception e3) {
                aa.d("DynamicViewCreator", e3.getMessage());
            }
        }
        return viewGroup;
    }

    private void a(DyOption dyOption, String str, String str2) {
        if (dyOption != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    Context g = com.mbridge.msdk.foundation.controller.b.d().g();
                    q.a(g, dyOption.getDyAdType() + "", dyOption.getTemplateType(), str, str2, dyOption.getCampaignEx());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
