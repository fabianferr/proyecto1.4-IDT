package com.mbridge.msdk.video.dynview.ordercamp.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.dycreator.baseview.MBFrameLayout;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.video.dynview.h.b;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.List;
import java.util.Locale;

/* compiled from: OrderCampAdapter */
public final class a extends BaseAdapter {
    private boolean a = false;
    private C0157a b;
    private List<CampaignEx> c;

    public final long getItemId(int i) {
        return (long) i;
    }

    public a(List<CampaignEx> list) {
        this.c = list;
    }

    public final int getCount() {
        List<CampaignEx> list = this.c;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.c.size();
    }

    public final Object getItem(int i) {
        List<CampaignEx> list = this.c;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        int i2 = i;
        if (view == null) {
            try {
                view2 = a(i);
            } catch (Exception e) {
                e = e;
                view2 = view;
                aa.d("OrderCampAdapter", e.getMessage());
                return view2;
            }
        } else {
            this.b = (C0157a) view.getTag();
            view2 = view;
        }
        try {
            this.b.a = (RelativeLayout) view2.findViewById(d("mbridge_lv_item_rl"));
            this.b.e = (TextView) view2.findViewById(d("mbridge_lv_title_tv"));
            this.b.g = (TextView) view2.findViewById(d("mbridge_lv_tv_install"));
            this.b.o = (MBHeatLevelLayoutView) view2.findViewById(d("mbridge_lv_sv_heat_level"));
            this.b.f = (TextView) view2.findViewById(d("mbridge_lv_desc_tv"));
            this.b.j = (ImageView) view2.findViewById(d("mbridge_iv_flag"));
            this.b.h = (TextView) view2.findViewById(d("mbridge_order_viewed_tv"));
            double d = 5.0d;
            if (this.a) {
                List<CampaignEx> list = this.c;
                if (list != null) {
                    if (this.b != null) {
                        if (list.size() != 0) {
                            if (this.b.l != null && (this.b.l instanceof MBCusRoundImageView)) {
                                this.b.l.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
                                a(this.b.l, this.c.get(i2).getImageUrl(), false);
                            }
                            if (this.b.k != null) {
                                a(this.b.k, this.c.get(i2).getImageUrl(), false);
                            }
                            if (this.b.m != null && (this.b.m instanceof MBCusRoundImageView)) {
                                this.b.m.setBorder(50, 20, -1);
                                a(this.b.m, this.c.get(i2).getIconUrl(), true);
                            }
                            double rating = this.c.get(i2).getRating();
                            if (rating > 0.0d) {
                                d = rating;
                            }
                            if (this.b.n != null) {
                                this.b.n.setRating((int) d);
                                this.b.n.setOrientation(0);
                            }
                            if (this.b.o != null) {
                                this.b.o.setHeatCount(this.c.get(i2).getNumberRating());
                            }
                        }
                    }
                }
            } else {
                List<CampaignEx> list2 = this.c;
                if (list2 != null) {
                    if (this.b != null) {
                        if (list2.size() != 0) {
                            if (this.b.c != null) {
                                a(this.b.c, this.c.get(i2).getImageUrl(), false);
                            }
                            if (this.b.k != null) {
                                a(this.b.k, this.c.get(i2).getImageUrl(), false);
                            }
                            if (this.b.d != null) {
                                this.b.d.setBorderRadius(25);
                                a(this.b.d, this.c.get(i2).getIconUrl(), true);
                            }
                            double rating2 = this.c.get(i2).getRating();
                            if (rating2 > 0.0d) {
                                d = rating2;
                            }
                            if (this.b.i != null) {
                                this.b.i.setRatingAndUser(d, this.c.get(i2).getNumberRating());
                                this.b.i.setOrientation(0);
                            }
                            if (this.b.b != null) {
                                this.b.b.setWidthRatio(1.0f);
                                this.b.b.setHeightRatio(1.0f);
                                this.b.b.setAutoscroll(false);
                            }
                            if (this.b.c != null) {
                                this.b.c.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
                            }
                        }
                    }
                }
            }
            C0157a aVar = this.b;
            if (aVar != null) {
                if (aVar.e != null) {
                    this.b.e.setText(this.c.get(i2).getAppName());
                }
                if (this.b.f != null) {
                    this.b.f.setText(this.c.get(i2).getAppDesc());
                }
                if (this.b.g != null) {
                    String adCall = this.c.get(i2).getAdCall();
                    if (this.b.g instanceof MBridgeTextView) {
                        ((MBridgeTextView) this.b.g).setObjectAnimator(new b().c(this.b.g));
                    }
                    this.b.g.setText(adCall);
                }
                if (this.b.j != null) {
                    try {
                        String language = Locale.getDefault().getLanguage();
                        Context g = com.mbridge.msdk.foundation.controller.b.d().g();
                        if (g != null) {
                            if (!TextUtils.isEmpty(language)) {
                                if (language.equals("zh")) {
                                    this.b.j.setImageDrawable(g.getResources().getDrawable(g.getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", com.mbridge.msdk.foundation.controller.b.d().b())));
                                }
                            }
                            this.b.j.setImageDrawable(g.getResources().getDrawable(g.getResources().getIdentifier("mbridge_reward_flag_en", "drawable", com.mbridge.msdk.foundation.controller.b.d().b())));
                        }
                    } catch (Exception e2) {
                        aa.d("OrderCampAdapter", e2.getMessage());
                    }
                    af.a(2, this.b.j, this.c.get(i2), com.mbridge.msdk.foundation.controller.b.d().g(), false, (com.mbridge.msdk.foundation.c.a) null);
                }
                if (this.b.h != null) {
                    try {
                        this.b.h.setText(com.mbridge.msdk.foundation.controller.b.d().g().getResources().getString(com.mbridge.msdk.foundation.controller.b.d().g().getResources().getIdentifier("mbridge_reward_viewed_text_str", TypedValues.Custom.S_STRING, com.mbridge.msdk.foundation.controller.b.d().b())));
                        this.b.h.setVisibility(0);
                    } catch (Exception e3) {
                        aa.d("OrderCampAdapter", e3.getMessage());
                    }
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
        return view2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f A[Catch:{ Exception -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044 A[Catch:{ Exception -> 0x0169 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View a(int r8) {
        /*
            r7 = this;
            java.lang.String r0 = "template_"
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r7.c     // Catch:{ Exception -> 0x0169 }
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0037
            java.lang.Object r1 = r1.get(r8)     // Catch:{ Exception -> 0x0169 }
            if (r1 == 0) goto L_0x0037
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0169 }
            r1.<init>()     // Catch:{ Exception -> 0x0169 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r7.c     // Catch:{ Exception -> 0x0169 }
            java.lang.Object r3 = r3.get(r8)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ Exception -> 0x0169 }
            int r3 = r3.getMof_tplid()     // Catch:{ Exception -> 0x0169 }
            r1.append(r3)     // Catch:{ Exception -> 0x0169 }
            r1.append(r2)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0169 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r7.c     // Catch:{ Exception -> 0x0169 }
            java.lang.Object r2 = r2.get(r8)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ Exception -> 0x0169 }
            java.lang.String r2 = r2.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0169 }
            goto L_0x0039
        L_0x0037:
            java.lang.String r1 = "501"
        L_0x0039:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0169 }
            if (r3 == 0) goto L_0x0044
            android.view.View r8 = r7.a()     // Catch:{ Exception -> 0x0169 }
            return r8
        L_0x0044:
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0169 }
            android.content.Context r3 = r3.g()     // Catch:{ Exception -> 0x0169 }
            int r3 = com.mbridge.msdk.foundation.tools.w.h(r3)     // Catch:{ Exception -> 0x0169 }
            r4 = 0
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.k.a(r4, r1, r2)     // Catch:{ Exception -> 0x0169 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0169 }
            if (r4 == 0) goto L_0x0060
            android.view.View r8 = r7.a()     // Catch:{ Exception -> 0x0169 }
            return r8
        L_0x0060:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0169 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0169 }
            r5.<init>()     // Catch:{ Exception -> 0x0169 }
            r5.append(r2)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r6 = java.io.File.separator     // Catch:{ Exception -> 0x0169 }
            r5.append(r6)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r6 = "template_config.json"
            r5.append(r6)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0169 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0169 }
            boolean r5 = r4.isFile()     // Catch:{ Exception -> 0x0169 }
            if (r5 == 0) goto L_0x0164
            boolean r4 = r4.exists()     // Catch:{ Exception -> 0x0169 }
            if (r4 != 0) goto L_0x008a
            goto L_0x0164
        L_0x008a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0169 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0169 }
            r4.append(r1)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r0 = "_"
            r4.append(r0)     // Catch:{ Exception -> 0x0169 }
            r4.append(r3)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r0 = "_item"
            r4.append(r0)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0169 }
            java.util.List r0 = com.mbridge.msdk.foundation.tools.y.b(r2, r0)     // Catch:{ Exception -> 0x0169 }
            if (r0 != 0) goto L_0x00ae
            android.view.View r8 = r7.a()     // Catch:{ Exception -> 0x0169 }
            return r8
        L_0x00ae:
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0169 }
            android.content.Context r1 = r1.g()     // Catch:{ Exception -> 0x0169 }
            int r1 = com.mbridge.msdk.foundation.tools.w.h(r1)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0169 }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.c.f r3 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x0169 }
            r3.b(r2)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.dycreator.wrapper.DyOption$Builder r2 = new com.mbridge.msdk.dycreator.wrapper.DyOption$Builder     // Catch:{ Exception -> 0x0169 }
            r2.<init>()     // Catch:{ Exception -> 0x0169 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r7.c     // Catch:{ Exception -> 0x0169 }
            java.lang.Object r3 = r3.get(r8)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.dycreator.wrapper.DyOption$IViewOptionBuilder r2 = r2.campaignEx(r3)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.dycreator.wrapper.DyOption$IViewOptionBuilder r0 = r2.fileDirs(r0)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.dycreator.wrapper.DyAdType r2 = com.mbridge.msdk.dycreator.wrapper.DyAdType.REWARD     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.dycreator.wrapper.DyOption$IViewOptionBuilder r0 = r0.dyAdType(r2)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.dycreator.wrapper.DyOption$IViewOptionBuilder r0 = r0.orientation(r1)     // Catch:{ Exception -> 0x0169 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r7.c     // Catch:{ Exception -> 0x0169 }
            java.lang.Object r8 = r1.get(r8)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = (com.mbridge.msdk.foundation.entity.CampaignEx) r8     // Catch:{ Exception -> 0x0169 }
            java.lang.String r8 = com.mbridge.msdk.foundation.tools.af.c((com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.dycreator.wrapper.DyOption$IViewOptionBuilder r8 = r0.adChoiceLink(r8)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.dycreator.wrapper.DyOption r8 = r8.build()     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator r0 = com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator.getInstance()     // Catch:{ Exception -> 0x0169 }
            android.view.View r8 = r0.createDynamicView(r8)     // Catch:{ Exception -> 0x0169 }
            if (r8 == 0) goto L_0x0174
            r0 = 1
            r7.a = r0     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.video.dynview.ordercamp.a.a$a r0 = new com.mbridge.msdk.video.dynview.ordercamp.a.a$a     // Catch:{ Exception -> 0x0169 }
            r0.<init>()     // Catch:{ Exception -> 0x0169 }
            r7.b = r0     // Catch:{ Exception -> 0x0169 }
            java.lang.String r1 = "mbridge_lv_iv"
            int r1 = r7.c(r1)     // Catch:{ Exception -> 0x0169 }
            android.view.View r1 = r8.findViewById(r1)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView r1 = (com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView) r1     // Catch:{ Exception -> 0x0169 }
            r0.l = r1     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.video.dynview.ordercamp.a.a$a r0 = r7.b     // Catch:{ Exception -> 0x0169 }
            java.lang.String r1 = "mbridge_lv_iv_burl"
            int r1 = r7.c(r1)     // Catch:{ Exception -> 0x0169 }
            android.view.View r1 = r8.findViewById(r1)     // Catch:{ Exception -> 0x0169 }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x0169 }
            r0.k = r1     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.video.dynview.ordercamp.a.a$a r0 = r7.b     // Catch:{ Exception -> 0x0169 }
            java.lang.String r1 = "mbridge_lv_icon_iv"
            int r1 = r7.c(r1)     // Catch:{ Exception -> 0x0169 }
            android.view.View r1 = r8.findViewById(r1)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView r1 = (com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView) r1     // Catch:{ Exception -> 0x0169 }
            r0.m = r1     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.video.dynview.ordercamp.a.a$a r0 = r7.b     // Catch:{ Exception -> 0x0169 }
            java.lang.String r1 = "mbridge_lv_sv_starlevel"
            int r1 = r7.c(r1)     // Catch:{ Exception -> 0x0169 }
            android.view.View r1 = r8.findViewById(r1)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView r1 = (com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView) r1     // Catch:{ Exception -> 0x0169 }
            r0.n = r1     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.video.dynview.ordercamp.a.a$a r0 = r7.b     // Catch:{ Exception -> 0x0169 }
            java.lang.String r1 = "mbridge_lv_ration"
            int r1 = r7.c(r1)     // Catch:{ Exception -> 0x0169 }
            android.view.View r1 = r8.findViewById(r1)     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.dycreator.baseview.MBFrameLayout r1 = (com.mbridge.msdk.dycreator.baseview.MBFrameLayout) r1     // Catch:{ Exception -> 0x0169 }
            r0.p = r1     // Catch:{ Exception -> 0x0169 }
            com.mbridge.msdk.video.dynview.ordercamp.a.a$a r0 = r7.b     // Catch:{ Exception -> 0x0169 }
            r8.setTag(r0)     // Catch:{ Exception -> 0x0169 }
            goto L_0x0174
        L_0x0164:
            android.view.View r8 = r7.a()     // Catch:{ Exception -> 0x0169 }
            return r8
        L_0x0169:
            r8 = move-exception
            java.lang.String r0 = "OrderCampAdapter"
            java.lang.String r8 = r8.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r0, r8)
            r8 = 0
        L_0x0174:
            boolean r0 = r7.a
            if (r0 == 0) goto L_0x0179
            goto L_0x017d
        L_0x0179:
            android.view.View r8 = r7.a()
        L_0x017d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.ordercamp.a.a.a(int):android.view.View");
    }

    private View a() {
        View inflate = LayoutInflater.from(com.mbridge.msdk.foundation.controller.b.d().g()).inflate(a("mbridge_order_layout_item"), (ViewGroup) null);
        C0157a aVar = new C0157a();
        this.b = aVar;
        aVar.c = (MBridgeImageView) inflate.findViewById(b("mbridge_lv_iv"));
        this.b.k = (ImageView) inflate.findViewById(b("mbridge_lv_iv_burl"));
        this.b.d = (RoundImageView) inflate.findViewById(b("mbridge_lv_icon_iv"));
        this.b.i = (MBridgeLevelLayoutView) inflate.findViewById(b("mbridge_lv_sv_starlevel"));
        this.b.b = (MBRotationView) inflate.findViewById(b("mbridge_lv_ration"));
        inflate.setTag(this.b);
        return inflate;
    }

    private void a(final ImageView imageView, String str, final boolean z) {
        if (imageView != null) {
            if (!TextUtils.isEmpty(str)) {
                com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, (c) new c() {
                    public final void onSuccessLoad(Bitmap bitmap, String str) {
                        try {
                            if (!bitmap.isRecycled()) {
                                imageView.setImageBitmap(bitmap);
                            }
                        } catch (Throwable th) {
                            aa.d("OrderCampAdapter", th.getMessage());
                        }
                    }

                    public final void onFailedLoad(String str, String str2) {
                        if (z) {
                            imageView.setVisibility(8);
                        }
                    }
                });
            } else if (z) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: com.mbridge.msdk.video.dynview.ordercamp.a.a$a  reason: collision with other inner class name */
    /* compiled from: OrderCampAdapter */
    static class C0157a {
        RelativeLayout a;
        MBRotationView b;
        MBridgeImageView c;
        RoundImageView d;
        TextView e;
        TextView f;
        TextView g;
        TextView h;
        MBridgeLevelLayoutView i;
        ImageView j;
        ImageView k;
        MBCusRoundImageView l;
        MBCusRoundImageView m;
        MBStarLevelLayoutView n;
        MBHeatLevelLayoutView o;
        MBFrameLayout p;

        C0157a() {
        }
    }

    private int a(String str) {
        return t.a(com.mbridge.msdk.foundation.controller.b.d().g().getApplicationContext(), str, "layout");
    }

    private int b(String str) {
        return t.a(com.mbridge.msdk.foundation.controller.b.d().g().getApplicationContext(), str, "id");
    }

    private int c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.hashCode();
        }
        return -1;
    }

    private int d(String str) {
        if (this.a) {
            return c(str);
        }
        return b(str);
    }
}
