package com.mbridge.msdk.video.dynview.h;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.dycreator.wrapper.DyAdType;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.video.dynview.e.e;
import com.mbridge.msdk.video.dynview.e.g;
import com.mbridge.msdk.video.dynview.j.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: MBridgeUI */
public final class a {
    /* access modifiers changed from: private */
    public static boolean a = false;

    public a() {
    }

    public a(Context context, List<CampaignEx> list, g gVar, Map<String, Object> map) {
        a(new c().a(context, list), gVar, map);
    }

    public a(com.mbridge.msdk.video.dynview.c cVar, g gVar, Map<String, Object> map) {
        a(cVar, gVar, map);
    }

    private void a(com.mbridge.msdk.video.dynview.c cVar, final g gVar, Map<String, Object> map) {
        View view;
        if (gVar != null) {
            if (cVar == null) {
                gVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            } else if (cVar.a() == null) {
                gVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_CONTEXT);
            } else if (TextUtils.isEmpty(cVar.b())) {
                gVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_LAYOUTNAME);
            } else {
                try {
                    if (cVar.l() != null) {
                        CampaignEx campaignEx = (cVar.g() == null || cVar.g().size() <= 0) ? null : cVar.g().get(0);
                        try {
                            Context g = b.d().g();
                            q.a(g, DyAdType.REWARD + "", cVar.i(), "create dynamic view", "start", campaignEx);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        view = DynamicViewCreator.getInstance().createDynamicView(new DyOption.Builder().campaignEx(campaignEx).fileDirs(cVar.l()).dyAdType(DyAdType.REWARD).orientation(cVar.e()).templateType(cVar.i()).build());
                        if (view != null) {
                            a = true;
                            try {
                                Context g2 = b.d().g();
                                q.a(g2, DyAdType.REWARD + "", cVar.i(), "create dynamic view", "view create done", campaignEx);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            a = false;
                            view = LayoutInflater.from(cVar.a()).inflate(t.a(cVar.a(), cVar.b(), "layout"), (ViewGroup) null);
                        }
                    } else {
                        a = false;
                        view = LayoutInflater.from(cVar.a()).inflate(t.a(cVar.a(), cVar.b(), "layout"), (ViewGroup) null);
                    }
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    map.put("is_dy_success", Boolean.valueOf(a));
                    com.mbridge.msdk.video.dynview.b.b.a().a(view, cVar, map);
                    com.mbridge.msdk.video.dynview.b.a.a().a(view, cVar, map, new e() {
                        public final void a(View view, List<View> list) {
                            com.mbridge.msdk.video.dynview.a aVar = new com.mbridge.msdk.video.dynview.a();
                            aVar.a(view);
                            aVar.a(list);
                            aVar.a(a.a);
                            gVar.a(aVar);
                        }

                        public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                            gVar.a(aVar);
                        }
                    });
                } catch (Exception e3) {
                    aa.d("MBridgeUI", e3.getMessage());
                    if (gVar != null) {
                        gVar.a(com.mbridge.msdk.video.dynview.c.a.VIEW_CREATE_ERROR);
                    }
                }
            }
        }
    }
}
