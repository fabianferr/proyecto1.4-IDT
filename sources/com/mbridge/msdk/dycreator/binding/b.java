package com.mbridge.msdk.dycreator.binding;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.dycreator.baseview.MBApkInfoView;
import com.mbridge.msdk.dycreator.baseview.MBFeedBack;
import com.mbridge.msdk.dycreator.baseview.MBLogoTextView;
import com.mbridge.msdk.dycreator.baseview.MBSplashClickView;
import com.mbridge.msdk.dycreator.baseview.MBSplashImageBgView;
import com.mbridge.msdk.dycreator.baseview.MBSplashPortView;
import com.mbridge.msdk.dycreator.baseview.MBSplashShakeView;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.d.a;
import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.e;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.g;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.g.i;
import com.mbridge.msdk.dycreator.listener.DyCountDownListenerWrapper;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.viewmodel.BaseViewModel;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.z;

/* compiled from: MBDataBinding */
public final class b {
    private static volatile b a;
    private d b = ((d) a.a().a(a.C0132a.VIEW_OBSERVER));
    private c c = ((c) a.a().a(a.C0132a.CLICK_OBSERVER));
    private f d = ((f) a.a().a(a.C0132a.EFFECT_OBSERVER));
    private h e = ((h) a.a().a(a.C0132a.REPORT_OBSERVER));
    private BaseViewModel f;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.shake.b g;

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public final void a(final View view) {
        AnonymousClass1 r0 = new g() {
            public final void a(Object obj) {
                try {
                    View view = view;
                    if (view instanceof InterBase) {
                        b.a(b.this, (InterBase) view, obj);
                    }
                } catch (Exception e) {
                    aa.d("MBDataBinding", e.getMessage());
                }
            }
        };
        int id = view.getId();
        h hVar = this.e;
        if (hVar != null) {
            hVar.a(r0, id);
        }
    }

    public final void b(final View view) {
        AnonymousClass2 r0 = new e() {
            public final void a(Object obj) {
                try {
                    View view = view;
                    if (view instanceof InterBase) {
                        b.b(b.this, (InterBase) view, obj);
                    }
                } catch (Exception e) {
                    aa.d("MBDataBinding", e.getMessage());
                }
            }
        };
        int id = view.getId();
        f fVar = this.d;
        if (fVar != null) {
            fVar.a(r0, id);
        }
    }

    public final void c(final View view) {
        AnonymousClass3 r0 = new i() {
            public final void a(Object obj) {
                try {
                    View view = view;
                    if (view instanceof InterBase) {
                        b.c(b.this, (InterBase) view, obj);
                    }
                } catch (Exception e) {
                    aa.d("MBDataBinding", e.getMessage());
                }
            }
        };
        int id = view.getId();
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(r0, id);
        }
    }

    public final void d(final View view) {
        if (view != null) {
            try {
                if (view instanceof InterBase) {
                    String actionDes = ((InterBase) view).getActionDes();
                    if (TextUtils.isEmpty(actionDes)) {
                        return;
                    }
                    if (actionDes.startsWith(CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                        AnonymousClass4 r0 = new com.mbridge.msdk.dycreator.g.b() {
                            public final void a(Object obj) {
                                if (obj != null) {
                                    try {
                                        if (com.mbridge.msdk.dycreator.e.d.a(view, (com.mbridge.msdk.dycreator.f.a.a) obj)) {
                                            b.a(b.this, view, obj);
                                        }
                                    } catch (Exception e) {
                                        aa.d("MBDataBinding", e.getMessage());
                                    }
                                }
                            }
                        };
                        int id = view.getId();
                        c cVar = this.c;
                        if (cVar != null) {
                            cVar.a(r0, id);
                        }
                    } else if (!actionDes.equals("move")) {
                        if (!actionDes.equals("long_click")) {
                            actionDes.equals("wobble");
                        }
                    }
                }
            } catch (Exception e2) {
                aa.d("MBDataBinding", e2.getMessage());
            }
        }
    }

    public final synchronized void b() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a();
        }
        d dVar = this.b;
        if (dVar != null) {
            dVar.a();
        }
        f fVar = this.d;
        if (fVar != null) {
            fVar.a();
        }
        if (this.f != null) {
            this.f = null;
        }
        if (this.g != null) {
            this.g = null;
        }
        if (a != null) {
            a = null;
        }
    }

    public final void a(BaseViewModel baseViewModel) {
        this.f = baseViewModel;
        if (baseViewModel != null) {
            baseViewModel.setClickSubject(this.c);
            this.f.setConcreteSubject(this.b);
            this.f.setEffectSubject(this.d);
            this.f.setReportSubject(this.e);
        }
    }

    private com.mbridge.msdk.shake.b a(View view, MBSplashData mBSplashData) {
        if (mBSplashData != null) {
            try {
                DyOption dyOption = mBSplashData.getDyOption();
                if (dyOption != null && dyOption.isShakeVisible() && this.g == null) {
                    final View view2 = view;
                    final MBSplashData mBSplashData2 = mBSplashData;
                    this.g = new com.mbridge.msdk.shake.b(dyOption.getShakeStrenght(), dyOption.getShakeTime() * 1000) {
                        public final void a() {
                            View view = view2;
                            if (view != null) {
                                try {
                                    if (view.getGlobalVisibleRect(new Rect())) {
                                        SplashResData splashResData = new SplashResData();
                                        mBSplashData2.setClickType(4);
                                        splashResData.setBaseViewData(mBSplashData2);
                                        splashResData.seteAction(EAction.DOWNLOAD);
                                        EventBus.getDefault().post(splashResData);
                                        com.mbridge.msdk.shake.a.a().b(b.this.g);
                                    }
                                } catch (Exception e) {
                                    aa.d("MBDataBinding", e.getMessage());
                                }
                            }
                        }
                    };
                }
            } catch (Exception e2) {
                aa.d("MBDataBinding", e2.getMessage());
            }
        }
        return this.g;
    }

    static /* synthetic */ void a(b bVar, InterBase interBase, Object obj) {
        if (interBase != null && obj != null) {
            String reportDes = interBase.getReportDes();
            if (!TextUtils.isEmpty(reportDes)) {
                try {
                    if ((obj instanceof com.mbridge.msdk.dycreator.f.a.a) && ((com.mbridge.msdk.dycreator.f.a.a) obj).getBindData() != null) {
                        interBase.setDynamicReport(reportDes, ((com.mbridge.msdk.dycreator.f.a.a) obj).getBindData());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static /* synthetic */ void b(b bVar, InterBase interBase, Object obj) {
        final boolean z;
        int i;
        if (interBase != null && obj != null) {
            String effectDes = interBase.getEffectDes();
            if (!TextUtils.isEmpty(effectDes)) {
                try {
                    if (interBase instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) interBase;
                        com.mbridge.msdk.dycreator.f.a.a aVar = (com.mbridge.msdk.dycreator.f.a.a) obj;
                        if (effectDes != null && (effectDes instanceof String)) {
                            if (effectDes.equals("wobble") && (viewGroup instanceof MBSplashShakeView)) {
                                if (aVar.getEffectData().isShakeVisible()) {
                                    if (bVar.g != null) {
                                        com.mbridge.msdk.shake.a.a().b(bVar.g);
                                    }
                                    com.mbridge.msdk.shake.a.a().a(bVar.a(viewGroup, (MBSplashData) aVar));
                                } else if (bVar.g != null) {
                                    com.mbridge.msdk.shake.a.a().b(bVar.g);
                                }
                            }
                            if (effectDes.equals("visible") && (viewGroup instanceof MBApkInfoView)) {
                                if (!aVar.getEffectData().isApkInfoVisible()) {
                                    viewGroup.setVisibility(8);
                                } else if (!(aVar instanceof MBSplashData) || TextUtils.isEmpty(((MBSplashData) aVar).getAppInfo())) {
                                    viewGroup.setVisibility(4);
                                } else {
                                    viewGroup.setVisibility(0);
                                }
                            }
                            effectDes.equals("anim");
                        }
                    } else if (interBase instanceof View) {
                        View view = (View) interBase;
                        if (effectDes != null && (effectDes instanceof String)) {
                            com.mbridge.msdk.dycreator.f.a.a aVar2 = (com.mbridge.msdk.dycreator.f.a.a) obj;
                            if (effectDes.equals("countdown") && view != null && (view instanceof TextView) && aVar2 != null) {
                                final String str = (String) ((TextView) view).getText();
                                final String g2 = w.g(view.getContext());
                                DyOption effectData = aVar2.getEffectData();
                                if (effectData != null) {
                                    boolean isCanSkip = effectData.isCanSkip();
                                    i = effectData.getCountDownTime();
                                    z = isCanSkip;
                                } else {
                                    i = 5;
                                    z = false;
                                }
                                ((TextView) view).setText(com.mbridge.msdk.dycreator.e.d.a(z, i, str, g2));
                                final View view2 = view;
                                ((com.mbridge.msdk.dycreator.f.a.a) obj).getEffectData().setDyCountDownListenerWrapper(new DyCountDownListenerWrapper() {
                                    public final void getCountDownValue(int i) {
                                        if (i == 0) {
                                            SplashResData splashResData = new SplashResData();
                                            splashResData.seteAction(EAction.CLOSE);
                                            EventBus.getDefault().post(splashResData);
                                            return;
                                        }
                                        ((TextView) view2).setText(com.mbridge.msdk.dycreator.e.d.a(z, i, str, g2));
                                    }
                                });
                            }
                            effectDes.equals("anim");
                            if (effectDes.equals("visible")) {
                                if (view instanceof MBFeedBack) {
                                    if (com.mbridge.msdk.foundation.c.b.a().b()) {
                                        view.setVisibility(0);
                                    } else {
                                        view.setVisibility(8);
                                    }
                                }
                                if ((view instanceof MBLogoTextView) && aVar2 != null && aVar2.getEffectData() != null && !aVar2.getEffectData().isLogoVisible()) {
                                    ((MBLogoTextView) view).setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static /* synthetic */ void c(b bVar, InterBase interBase, Object obj) {
        if (interBase != null && obj != null) {
            String bindDataDes = interBase.getBindDataDes();
            if (!TextUtils.isEmpty(bindDataDes)) {
                try {
                    Object a2 = com.mbridge.msdk.dycreator.e.d.a(obj, bindDataDes);
                    if (a2 != null) {
                        if (interBase instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) interBase;
                            com.mbridge.msdk.dycreator.f.a.a aVar = (com.mbridge.msdk.dycreator.f.a.a) obj;
                            if (viewGroup != null) {
                                if (viewGroup instanceof MBSplashClickView) {
                                    if (!(aVar == null || aVar.getEffectData() == null || !aVar.getEffectData().isClickButtonVisible())) {
                                        if (!aVar.getEffectData().isShakeVisible()) {
                                            if (a2 != null && !TextUtils.isEmpty(a2.toString())) {
                                                viewGroup.setVisibility(0);
                                                ((MBSplashClickView) viewGroup).initView(a2.toString());
                                            }
                                        }
                                    }
                                    viewGroup.setVisibility(8);
                                }
                                if (!(viewGroup instanceof MBSplashShakeView)) {
                                    return;
                                }
                                if (aVar == null || aVar.getEffectData() == null || !aVar.getEffectData().isShakeVisible()) {
                                    viewGroup.setVisibility(8);
                                } else if (a2 != null && !TextUtils.isEmpty(a2.toString())) {
                                    viewGroup.setVisibility(0);
                                    ((MBSplashShakeView) viewGroup).initView(a2.toString());
                                }
                            }
                        } else if (interBase instanceof View) {
                            final View view = (View) interBase;
                            final com.mbridge.msdk.dycreator.f.a.a aVar2 = (com.mbridge.msdk.dycreator.f.a.a) obj;
                            if (view != null && a2 != null) {
                                try {
                                    if (view instanceof TextView) {
                                        try {
                                            ((TextView) view).setText(String.valueOf(a2).replace("\\n", "\n"));
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    } else if ((view instanceof ImageView) && a2 != null) {
                                        if (a2 instanceof Integer) {
                                            ((ImageView) view).setImageResource(((Integer) a2).intValue());
                                        }
                                        if (a2 instanceof String) {
                                            com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(a2.toString(), (com.mbridge.msdk.foundation.same.c.c) new com.mbridge.msdk.foundation.same.c.c() {
                                                public final void onSuccessLoad(Bitmap bitmap, String str) {
                                                    int i;
                                                    if (bitmap != null) {
                                                        try {
                                                            if (!bitmap.isRecycled()) {
                                                                boolean z = bitmap.getWidth() > bitmap.getHeight();
                                                                if (aVar2.getEffectData().getOrientation() == 1) {
                                                                    i = view.getResources().getConfiguration().orientation;
                                                                } else {
                                                                    i = aVar2.getEffectData().getOrientation();
                                                                }
                                                                if (i == 1) {
                                                                    if (z) {
                                                                        View view = view;
                                                                        if (view instanceof MBSplashPortView) {
                                                                            if (view.getParent() != null) {
                                                                                ((ViewGroup) view.getParent()).setVisibility(8);
                                                                                return;
                                                                            }
                                                                            return;
                                                                        } else if (view instanceof MBSplashImageBgView) {
                                                                            view.setVisibility(0);
                                                                            Bitmap a2 = z.a(bitmap);
                                                                            ((MBSplashImageBgView) view).setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                                            ((MBSplashImageBgView) view).setImageBitmap(a2);
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        View view2 = view;
                                                                        if (view2 instanceof MBSplashPortView) {
                                                                            view2.setVisibility(0);
                                                                            ((MBSplashPortView) view).setScaleType(ImageView.ScaleType.FIT_CENTER);
                                                                            ((MBSplashPortView) view).setImageBitmap(bitmap);
                                                                            return;
                                                                        } else if (view2 instanceof MBSplashImageBgView) {
                                                                            view2.setVisibility(8);
                                                                            return;
                                                                        } else if (view2 instanceof InterBase) {
                                                                            String effectDes = ((InterBase) view2).getEffectDes();
                                                                            ViewGroup viewGroup = (ViewGroup) view.getParent();
                                                                            if (viewGroup != null) {
                                                                                com.mbridge.msdk.dycreator.e.d.a(effectDes, viewGroup, true);
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (z) {
                                                                    View view3 = view;
                                                                    if (view3 instanceof MBSplashPortView) {
                                                                        view3.setVisibility(0);
                                                                        ((MBSplashPortView) view).setScaleType(ImageView.ScaleType.FIT_XY);
                                                                        ((ImageView) view).setImageBitmap(bitmap);
                                                                        return;
                                                                    } else if (view3 instanceof MBSplashImageBgView) {
                                                                        view3.setVisibility(8);
                                                                        ((MBSplashImageBgView) view).setImageBitmap(z.a(bitmap));
                                                                        return;
                                                                    } else if (view3 instanceof InterBase) {
                                                                        String effectDes2 = ((InterBase) view3).getEffectDes();
                                                                        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                                                                        if (viewGroup2 != null) {
                                                                            com.mbridge.msdk.dycreator.e.d.a(effectDes2, viewGroup2, true);
                                                                        }
                                                                    }
                                                                } else {
                                                                    View view4 = view;
                                                                    if (view4 instanceof MBSplashPortView) {
                                                                        view4.setVisibility(0);
                                                                        ((MBSplashPortView) view).setImageBitmap(bitmap);
                                                                        return;
                                                                    } else if (view4 instanceof MBSplashImageBgView) {
                                                                        view4.setVisibility(0);
                                                                        Bitmap a3 = z.a(bitmap);
                                                                        ((MBSplashImageBgView) view).setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                                        ((MBSplashImageBgView) view).setImageBitmap(a3);
                                                                        return;
                                                                    } else if (view4 instanceof InterBase) {
                                                                        String effectDes3 = ((InterBase) view4).getEffectDes();
                                                                        ViewGroup viewGroup3 = (ViewGroup) view.getParent();
                                                                        if (viewGroup3 != null) {
                                                                            com.mbridge.msdk.dycreator.e.d.a(effectDes3, viewGroup3, true);
                                                                        }
                                                                    }
                                                                }
                                                                ((ImageView) view).setImageBitmap(bitmap);
                                                                return;
                                                            }
                                                        } catch (Exception e) {
                                                            aa.d("MBDataBinding", e.getMessage());
                                                            return;
                                                        }
                                                    }
                                                    ((ImageView) view).setBackgroundColor(-7829368);
                                                }

                                                public final void onFailedLoad(String str, String str2) {
                                                    View view = view;
                                                    if (view != null) {
                                                        ((ImageView) view).setBackgroundColor(-7829368);
                                                    }
                                                }
                                            });
                                        }
                                    }
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar, View view, Object obj) {
        if (view != null && obj != null && (obj instanceof com.mbridge.msdk.dycreator.f.a.a)) {
            view.setOnClickListener(new a((com.mbridge.msdk.dycreator.f.a.a) obj));
        }
    }
}
