package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.c.j;
import com.bytedance.sdk.component.adexpress.widget.AnimationText;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.google.android.gms.cast.MediaTrack;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class DynamicTextView extends DynamicBaseWidgetImp {
    public DynamicTextView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        if (this.l.H()) {
            this.o = new AnimationText(context, this.l.g(), this.l.e(), 1, this.l.h());
            ((AnimationText) this.o).setMaxLines(1);
        } else {
            this.o = new TextView(context);
            ((TextView) this.o).setIncludeFontPadding(false);
        }
        this.o.setTag(Integer.valueOf(getClickArea()));
        addView(this.o, getWidgetLayoutParams());
    }

    public boolean i() {
        int i;
        double d;
        super.i();
        if (TextUtils.isEmpty(getText())) {
            this.o.setVisibility(4);
            return true;
        } else if (this.l.H()) {
            k();
            return true;
        } else {
            ((TextView) this.o).setText(this.l.f());
            ((TextView) this.o).setTextDirection(5);
            this.o.setTextAlignment(this.l.h());
            ((TextView) this.o).setTextColor(this.l.g());
            ((TextView) this.o).setTextSize(this.l.e());
            if (!this.l.v()) {
                ((TextView) this.o).setMaxLines(1);
                ((TextView) this.o).setGravity(17);
                ((TextView) this.o).setEllipsize(TextUtils.TruncateAt.END);
            } else {
                int w = this.l.w();
                if (w > 0) {
                    ((TextView) this.o).setLines(w);
                    ((TextView) this.o).setEllipsize(TextUtils.TruncateAt.END);
                }
            }
            if (!(this.m == null || this.m.j() == null)) {
                if (!d.b() || !a() || (!TextUtils.equals(this.m.j().b(), "text_star") && !TextUtils.equals(this.m.j().b(), "score-count") && !TextUtils.equals(this.m.j().b(), "score-count-type-1") && !TextUtils.equals(this.m.j().b(), "score-count-type-2"))) {
                    if (TextUtils.equals(this.m.j().b(), "score-count") || TextUtils.equals(this.m.j().b(), "score-count-type-2")) {
                        try {
                            i = Integer.parseInt(getText());
                        } catch (NumberFormatException unused) {
                            i = -1;
                        }
                        if (i < 0) {
                            try {
                                if (d.b()) {
                                    setVisibility(8);
                                    return true;
                                }
                                this.o.setVisibility(0);
                            } catch (Exception unused2) {
                            }
                        }
                        if (TextUtils.equals(this.m.j().b(), "score-count-type-2")) {
                            ((TextView) this.o).setText(String.format(new DecimalFormat("(###,###,###)").format((long) i), new Object[]{Integer.valueOf(i)}));
                            ((TextView) this.o).setGravity(17);
                            return true;
                        }
                        a((TextView) this.o, i, getContext(), "tt_comment_num");
                    } else if (TextUtils.equals(this.m.j().b(), "text_star")) {
                        try {
                            d = Double.parseDouble(getText());
                        } catch (Exception e) {
                            l.e("DynamicStarView applyNativeStyle", e.toString());
                            d = -1.0d;
                        }
                        if (d < 0.0d || d > 5.0d) {
                            if (d.b()) {
                                setVisibility(8);
                                return true;
                            }
                            this.o.setVisibility(0);
                        }
                        ((TextView) this.o).setIncludeFontPadding(false);
                        ((TextView) this.o).setText(String.format("%.1f", new Object[]{Double.valueOf(d)}));
                    } else if (TextUtils.equals("privacy-detail", this.m.j().b())) {
                        ((TextView) this.o).setText("Permission list | Privacy policy");
                    } else if (TextUtils.equals(this.m.j().b(), "development-name")) {
                        ((TextView) this.o).setText(s.a(d.a(), "tt_text_privacy_development") + getText());
                    } else if (TextUtils.equals(this.m.j().b(), "app-version")) {
                        ((TextView) this.o).setText(s.a(d.a(), "tt_text_privacy_app_version") + getText());
                    } else {
                        ((TextView) this.o).setText(getText());
                    }
                    this.o.setTextAlignment(this.l.h());
                    ((TextView) this.o).setGravity(this.l.i());
                    if (d.b()) {
                        j();
                    }
                } else {
                    setVisibility(8);
                    return true;
                }
            }
            return true;
        }
    }

    private boolean a() {
        return (this.n == null || this.n.getRenderRequest() == null || this.n.getRenderRequest().j() == 4) ? false : true;
    }

    private void j() {
        int a;
        if (TextUtils.equals(this.m.j().b(), "source") || TextUtils.equals(this.m.j().b(), "title") || TextUtils.equals(this.m.j().b(), "text_star")) {
            int[] b = j.b(this.l.f(), this.l.e(), true);
            int a2 = (int) e.a(getContext(), (float) this.l.b());
            int a3 = (int) e.a(getContext(), (float) this.l.c());
            int a4 = (int) e.a(getContext(), (float) this.l.d());
            int a5 = (int) e.a(getContext(), (float) this.l.a());
            int min = Math.min(a2, a5);
            if (!TextUtils.equals(this.m.j().b(), "source") || (a = ((this.h - ((int) e.a(getContext(), this.l.e()))) - a2) - a5) <= 1 || a > min * 2) {
                int i = (((b[1] + a2) + a5) - this.h) - 2;
                if (i > 1) {
                    if (i <= min * 2) {
                        int i2 = i / 2;
                        this.o.setPadding(a3, a2 - i2, a4, a5 - (i - i2));
                    } else if (i > a2 + a5) {
                        final int i3 = (i - a2) - a5;
                        this.o.setPadding(a3, 0, a4, 0);
                        if (i3 <= ((int) e.a(getContext(), 1.0f)) + 1) {
                            ((TextView) this.o).setTextSize(this.l.e() - 1.0f);
                        } else if (i3 <= (((int) e.a(getContext(), 1.0f)) + 1) * 2) {
                            ((TextView) this.o).setTextSize(this.l.e() - 2.0f);
                        } else {
                            post(new Runnable() {
                                public void run() {
                                    try {
                                        ViewGroup.LayoutParams layoutParams = DynamicTextView.this.o.getLayoutParams();
                                        layoutParams.height = DynamicTextView.this.h + i3;
                                        DynamicTextView.this.o.setLayoutParams(layoutParams);
                                        DynamicTextView.this.o.setTranslationY((float) (-i3));
                                        ViewGroup viewGroup = (ViewGroup) DynamicTextView.this.o.getParent();
                                        ViewGroup viewGroup2 = viewGroup;
                                        viewGroup.setClipChildren(false);
                                        ViewGroup viewGroup3 = (ViewGroup) DynamicTextView.this.o.getParent().getParent();
                                        ViewGroup viewGroup4 = viewGroup3;
                                        viewGroup3.setClipChildren(false);
                                    } catch (Throwable unused) {
                                    }
                                }
                            });
                        }
                    } else if (a2 > a5) {
                        this.o.setPadding(a3, a2 - (i - min), a4, a5 - min);
                    } else {
                        this.o.setPadding(a3, a2 - min, a4, a5 - (i - min));
                    }
                } else {
                    return;
                }
            } else {
                int i4 = a / 2;
                this.o.setPadding(a3, a2 - i4, a4, a5 - (a - i4));
                return;
            }
        }
        if (TextUtils.equals(this.m.j().b(), "fillButton")) {
            this.o.setTextAlignment(2);
            ((TextView) this.o).setGravity(17);
        }
    }

    public String getText() {
        String f = this.l.f();
        if (TextUtils.isEmpty(f)) {
            if (!d.b() && TextUtils.equals(this.m.j().b(), "text_star")) {
                f = CampaignEx.CLICKMODE_ON;
            }
            if (!d.b() && TextUtils.equals(this.m.j().b(), "score-count")) {
                f = "6870";
            }
        }
        return (TextUtils.equals(this.m.j().b(), "title") || TextUtils.equals(this.m.j().b(), MediaTrack.ROLE_SUBTITLE)) ? f.replace("\n", "") : f;
    }

    public void a(TextView textView, int i, Context context, String str) {
        String format = String.format(s.a(context, str), new Object[]{Integer.valueOf(i)});
        textView.setText("(" + format + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }

    private void k() {
        if (this.o instanceof AnimationText) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                arrayList.add(text);
            }
            ((AnimationText) this.o).setMaxLines(1);
            ((AnimationText) this.o).setTextColor(this.l.g());
            ((AnimationText) this.o).setTextSize(this.l.e());
            ((AnimationText) this.o).setAnimationText(arrayList);
            ((AnimationText) this.o).setAnimationType(this.l.J());
            ((AnimationText) this.o).setAnimationDuration(this.l.I() * 1000);
            ((AnimationText) this.o).a();
        }
    }
}
