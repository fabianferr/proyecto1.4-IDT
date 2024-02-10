package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.ShadowImageView;
import com.bytedance.sdk.openadsdk.core.widget.ShadowTextView;
import com.bytedance.sdk.openadsdk.utils.ad;

public class TopLayoutDislike2 extends PAGLinearLayout implements a<TopLayoutDislike2> {
    private View a;
    /* access modifiers changed from: private */
    public ImageView b;
    /* access modifiers changed from: private */
    public ShadowImageView c;
    private TextView d;
    private int e;
    private int f;
    private boolean g;
    /* access modifiers changed from: private */
    public boolean h;
    /* access modifiers changed from: private */
    public b i;
    private boolean j;
    private boolean k;
    private CharSequence l;
    private boolean m;

    public TopLayoutDislike2(Context context) {
        this(context, (AttributeSet) null);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = "";
        setOrientation(0);
    }

    public void setShouldShowSkipTime(boolean z) {
        this.j = z;
    }

    public TopLayoutDislike2 a(boolean z, q qVar) {
        a(qVar);
        this.a.setVisibility(0);
        ((ImageView) this.a).setImageResource(s.d(o.a(), "tt_reward_full_feedback"));
        this.b.setImageResource(s.d(o.a(), "tt_skip_btn"));
        if (this.b.getDrawable() != null) {
            this.b.getDrawable().setAutoMirrored(true);
        }
        this.b.setVisibility(8);
        this.e = qVar.K() == null ? 0 : ((int) qVar.K().f()) * qVar.K().w();
        if (com.bytedance.sdk.openadsdk.core.model.o.c(qVar) && qVar.i() != null) {
            this.e = (int) qVar.i().b();
        }
        if (this.e <= 0) {
            this.e = 10;
        }
        if (qVar.aS() != 8 || qVar.D() == null) {
            this.f = o.d().j(qVar.D().getCodeId());
        } else {
            this.f = o.d().q(qVar.D().getCodeId());
        }
        int i2 = this.f;
        this.j = i2 == -1 || i2 >= this.e;
        if (qVar.at()) {
            this.a.setVisibility(8);
            this.g = true;
        }
        this.d.setVisibility(0);
        this.d.setText("");
        this.d.setEnabled(false);
        this.d.setClickable(false);
        g();
        return this;
    }

    private void a(q qVar) {
        f();
    }

    private void f() {
        this.c = new ShadowImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ad.b(getContext(), 28.0f), ad.b(getContext(), 28.0f));
        layoutParams.leftMargin = ad.b(getContext(), 16.0f);
        layoutParams.topMargin = ad.b(getContext(), 20.0f);
        this.c.setLayoutParams(layoutParams);
        this.c.setScaleType(ImageView.ScaleType.CENTER);
        ShadowImageView shadowImageView = new ShadowImageView(getContext());
        this.a = shadowImageView;
        shadowImageView.setId(520093713);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ad.b(getContext(), 28.0f), ad.b(getContext(), 28.0f));
        layoutParams2.topMargin = ad.b(getContext(), 20.0f);
        layoutParams2.leftMargin = ad.b(getContext(), 16.0f);
        this.a.setLayoutParams(layoutParams2);
        ((ImageView) this.a).setScaleType(ImageView.ScaleType.CENTER);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 0);
        layoutParams3.weight = 1.0f;
        view.setLayoutParams(layoutParams3);
        ShadowTextView shadowTextView = new ShadowTextView(getContext());
        this.d = shadowTextView;
        shadowTextView.setId(520093714);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, ad.b(getContext(), 28.0f));
        layoutParams4.topMargin = ad.b(getContext(), 20.0f);
        int b2 = ad.b(getContext(), 16.0f);
        layoutParams2.rightMargin = b2;
        layoutParams4.rightMargin = b2;
        this.d.setLayoutParams(layoutParams4);
        this.d.setGravity(17);
        this.d.setTextColor(Color.parseColor("#ffffff"));
        this.d.setTextSize(14.0f);
        this.d.setVisibility(8);
        this.b = new ShadowImageView(getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(ad.b(getContext(), 28.0f), ad.b(getContext(), 28.0f));
        layoutParams5.topMargin = ad.b(getContext(), 20.0f);
        layoutParams5.rightMargin = ad.b(getContext(), 16.0f);
        this.b.setLayoutParams(layoutParams5);
        this.b.setPadding(ad.b(getContext(), 4.0f), ad.b(getContext(), 4.0f), ad.b(getContext(), 4.0f), ad.b(getContext(), 4.0f));
        this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.c);
        addView(this.a);
        addView(view);
        addView(this.d);
        addView(this.b);
    }

    private void g() {
        View view = this.a;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TopLayoutDislike2.this.i != null) {
                        TopLayoutDislike2.this.i.c(view);
                    }
                }
            });
        }
        ShadowImageView shadowImageView = this.c;
        if (shadowImageView != null) {
            shadowImageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    int i;
                    TopLayoutDislike2 topLayoutDislike2 = TopLayoutDislike2.this;
                    boolean unused = topLayoutDislike2.h = !topLayoutDislike2.h;
                    if (TopLayoutDislike2.this.b != null) {
                        if (TopLayoutDislike2.this.h) {
                            i = s.d(TopLayoutDislike2.this.getContext(), "tt_reward_full_mute");
                        } else {
                            i = s.d(TopLayoutDislike2.this.getContext(), "tt_reward_full_unmute");
                        }
                    } else if (TopLayoutDislike2.this.h) {
                        i = s.d(TopLayoutDislike2.this.getContext(), "tt_mute_wrapper");
                    } else {
                        i = s.d(TopLayoutDislike2.this.getContext(), "tt_unmute_wrapper");
                    }
                    TopLayoutDislike2.this.c.setImageResource(i);
                    if (TopLayoutDislike2.this.c.getDrawable() != null) {
                        TopLayoutDislike2.this.c.getDrawable().setAutoMirrored(true);
                    }
                    if (TopLayoutDislike2.this.i != null) {
                        TopLayoutDislike2.this.i.b(view);
                    }
                }
            });
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TopLayoutDislike2.this.i != null) {
                        TopLayoutDislike2.this.i.a(view);
                    }
                }
            });
            return;
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TopLayoutDislike2.this.i != null) {
                        TopLayoutDislike2.this.i.a(view);
                    }
                }
            });
        }
    }

    public void setShowSkip(boolean z) {
        TextView textView = this.d;
        if (textView != null) {
            if (!z) {
                textView.setText("");
            }
            if (this.b.getVisibility() != 4) {
                this.k = !z;
                int i2 = 0;
                this.b.setVisibility((!z || !this.m) ? 8 : 0);
                TextView textView2 = this.d;
                if (!z) {
                    i2 = 8;
                }
                textView2.setVisibility(i2);
            }
        }
    }

    public void setSkipEnable(boolean z) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setEnabled(z);
            this.b.setClickable(z);
            return;
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setEnabled(z);
            this.d.setClickable(z);
        }
    }

    public void setShowSound(boolean z) {
        ShadowImageView shadowImageView = this.c;
        if (shadowImageView != null) {
            shadowImageView.setVisibility(z ? 0 : 8);
        }
    }

    public void setSoundMute(boolean z) {
        int i2;
        this.h = z;
        if (this.b != null) {
            if (z) {
                i2 = s.d(getContext(), "tt_reward_full_mute");
            } else {
                i2 = s.d(getContext(), "tt_reward_full_unmute");
            }
        } else if (z) {
            i2 = s.d(getContext(), "tt_mute_wrapper");
        } else {
            i2 = s.d(getContext(), "tt_unmute_wrapper");
        }
        this.c.setImageResource(i2);
        if (this.c.getDrawable() != null) {
            this.c.getDrawable().setAutoMirrored(true);
        }
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        int i2;
        if (!TextUtils.isEmpty(charSequence)) {
            this.l = charSequence;
        }
        if (this.b != null) {
            this.m = true;
            if (this.j) {
                TextView textView = this.d;
                textView.setText(this.l + CmcdHeadersFactory.STREAMING_FORMAT_SS);
                a(false);
                return;
            }
            String str = (String) this.l;
            try {
                int i3 = this.f;
                if (i3 == 0) {
                    i2 = Integer.parseInt(str);
                } else {
                    i2 = i3 - (this.e - Integer.parseInt(str));
                }
                if (i2 <= 0) {
                    TextView textView2 = this.d;
                    textView2.setText(this.l + CmcdHeadersFactory.STREAMING_FORMAT_SS);
                    a(false);
                } else if (this.f == 0) {
                    a(false);
                } else {
                    this.d.setText(String.format(s.a(d.a(), "tt_reward_full_skip"), new Object[]{Integer.valueOf(i2)}));
                    a(true);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void a(boolean z) {
        if (this.k) {
            return;
        }
        if (this.j) {
            this.b.setVisibility(8);
            this.d.setVisibility(0);
        } else if (z) {
            this.d.setVisibility(0);
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            this.d.setVisibility(8);
        }
    }

    public void setSkipText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.d.setText(charSequence);
            ImageView imageView = this.b;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    public void setShowDislike(boolean z) {
        View view = this.a;
        if (view != null && !this.g) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setListener(b bVar) {
        this.i = bVar;
    }

    public void a() {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.performClick();
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.performClick();
        }
    }

    public void b() {
        ShadowImageView shadowImageView = this.c;
        if (shadowImageView != null) {
            shadowImageView.performClick();
        }
    }

    public void d() {
        this.d.setVisibility(0);
    }

    public void e() {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this.d.setVisibility(8);
    }

    public void c() {
        this.d.setWidth(20);
        this.d.setVisibility(4);
        this.b.setVisibility(4);
        this.k = true;
    }
}
