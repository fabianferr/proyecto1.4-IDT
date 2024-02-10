package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.MBGradientAndShadowTextView;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import java.util.ArrayList;
import java.util.Random;

public class MBAcquireRewardPopView extends RelativeLayout {
    private final String a = "MBAcquireRewardPopView";
    /* access modifiers changed from: private */
    public AcquireRewardPopViewParameters b;
    /* access modifiers changed from: private */
    public AnimationSet c;
    /* access modifiers changed from: private */
    public float d = 0.0f;
    /* access modifiers changed from: private */
    public float e = 0.0f;
    /* access modifiers changed from: private */
    public float f = 0.0f;
    /* access modifiers changed from: private */
    public float g = 0.0f;
    /* access modifiers changed from: private */
    public int h;
    /* access modifiers changed from: private */
    public boolean i;
    /* access modifiers changed from: private */
    public boolean j;
    private TextView k;
    private final View.OnClickListener l = new View.OnClickListener() {
        public void onClick(View view) {
            MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
            mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.m);
            String str = (String) view.getTag();
            if (!TextUtils.isEmpty(str)) {
                boolean contains = MBAcquireRewardPopView.this.b.rightAnswerList.contains(str);
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                View e = contains ? MBAcquireRewardPopView.e(mBAcquireRewardPopView2) : MBAcquireRewardPopView.f(mBAcquireRewardPopView2);
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, e);
                }
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    if (contains) {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView3.postDelayed(mBAcquireRewardPopView3.n, 2000);
            }
        }
    };
    /* access modifiers changed from: private */
    public Runnable m = new Runnable() {
        public void run() {
            if (MBAcquireRewardPopView.this.h <= 0) {
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                }
                boolean unused = MBAcquireRewardPopView.this.i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
                return;
            }
            MBAcquireRewardPopView.i(MBAcquireRewardPopView.this);
            MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
            mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.m, 1000);
        }
    };
    /* access modifiers changed from: private */
    public Runnable n = new Runnable() {
        public void run() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    boolean unused = MBAcquireRewardPopView.this.i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            });
            MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
        }
    };
    /* access modifiers changed from: private */
    public View.OnTouchListener o = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                float unused = MBAcquireRewardPopView.this.d = motionEvent.getX();
                float unused2 = MBAcquireRewardPopView.this.e = motionEvent.getY();
            } else if (action != 1) {
                if (action == 2) {
                    float unused3 = MBAcquireRewardPopView.this.f = motionEvent.getX();
                    float unused4 = MBAcquireRewardPopView.this.g = motionEvent.getY();
                }
            } else if (MBAcquireRewardPopView.this.f <= MBAcquireRewardPopView.this.d) {
                MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
            } else if (Math.abs(MBAcquireRewardPopView.this.f - MBAcquireRewardPopView.this.d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.g - MBAcquireRewardPopView.this.e) >= 100.0f) {
                MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
            } else if (MBAcquireRewardPopView.this.j) {
                return false;
            } else {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.m);
                boolean unused5 = MBAcquireRewardPopView.this.j = true;
                View e = MBAcquireRewardPopView.e(MBAcquireRewardPopView.this);
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, e);
                }
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.b.reduceTime);
                }
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.n, 2000);
            }
            return false;
        }
    };
    private final View.OnClickListener p = new View.OnClickListener() {
        public void onClick(View view) {
            if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
            }
        }
    };
    private final View.OnClickListener q = new View.OnClickListener() {
        public void onClick(View view) {
            if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
            }
            boolean unused = MBAcquireRewardPopView.this.i = false;
            MBAcquireRewardPopView.this.setVisibility(8);
            MBAcquireRewardPopView.this.removeAllViews();
        }
    };

    static /* synthetic */ int i(MBAcquireRewardPopView mBAcquireRewardPopView) {
        int i2 = mBAcquireRewardPopView.h;
        mBAcquireRewardPopView.h = i2 - 1;
        return i2;
    }

    public MBAcquireRewardPopView(Context context) {
        super(context);
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void init(AcquireRewardPopViewParameters acquireRewardPopViewParameters) {
        LinearLayout linearLayout;
        if (acquireRewardPopViewParameters == null) {
            aa.d("MBAcquireRewardPopView", "Must generate parameters.");
            return;
        }
        this.b = acquireRewardPopViewParameters;
        if (acquireRewardPopViewParameters.viewType == 1) {
            ArrayList arrayList = new ArrayList();
            AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.b;
            if (acquireRewardPopViewParameters2 != null) {
                if (acquireRewardPopViewParameters2.rightAnswerList != null) {
                    arrayList.addAll(this.b.rightAnswerList);
                }
                if (this.b.wrongAnswerList != null) {
                    int nextInt = new Random().nextInt(this.b.wrongAnswerList.size());
                    if (nextInt > this.b.wrongAnswerList.size() - 1) {
                        nextInt = 0;
                    }
                    arrayList.add(this.b.wrongAnswerList.get(nextInt));
                }
            }
            linearLayout = a((ArrayList<String>) arrayList);
            if (this.b.canClickMaskArea) {
                setOnClickListener(this.p);
            }
        } else {
            linearLayout = null;
        }
        if (this.b.viewType == 2) {
            int b2 = af.b(getContext(), 290.0f);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b2, -2);
            layoutParams.addRule(13);
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setOrientation(1);
            MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
            gradientAndShadowParameters.gradientStartColor = this.b.successTitleGradientStartColor;
            gradientAndShadowParameters.gradientEndColor = this.b.successTitleGradientEndColor;
            gradientAndShadowParameters.shadowColor = this.b.successTitleShadowColor;
            gradientAndShadowParameters.textSize = 30;
            MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(getContext(), gradientAndShadowParameters);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, 0, af.b(getContext(), 12.0f));
            layoutParams2.gravity = 1;
            mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
            mBGradientAndShadowTextView.setText(String.format(" %s ", new Object[]{this.b.slideTitle}));
            mBGradientAndShadowTextView.setGravity(17);
            linearLayout2.addView(mBGradientAndShadowTextView);
            GradientDrawable a2 = a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
            this.k = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 1;
            layoutParams3.setMargins(0, 0, 0, af.b(getContext(), 25.0f));
            this.k.setLayoutParams(layoutParams3);
            this.k.setTextSize(12.0f);
            this.k.setGravity(17);
            this.k.setTextColor(this.b.successTipTextColor);
            this.k.setText(String.format(this.b.slideTip, new Object[]{Integer.valueOf(this.b.reduceTime)}));
            int b3 = af.b(getContext(), 6.0f);
            int b4 = af.b(getContext(), 32.0f);
            this.k.setPadding(b4, b3, b4, b3);
            this.k.setBackground(a2);
            linearLayout2.addView(this.k);
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = 1;
            imageView.setLayoutParams(layoutParams4);
            imageView.setBackgroundResource(getResources().getIdentifier("mbridge_slide_rightarrow", "drawable", b.d().b()));
            linearLayout2.addView(imageView);
            ImageView imageView2 = new ImageView(getContext());
            imageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            imageView2.setBackgroundResource(getResources().getIdentifier("mbridge_slide_hand", "drawable", b.d().b()));
            linearLayout2.addView(imageView2);
            imageView2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, view);
                }

                public void onViewDetachedFromWindow(View view) {
                    if (MBAcquireRewardPopView.this.c != null) {
                        MBAcquireRewardPopView.this.c.cancel();
                    }
                }
            });
            linearLayout2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewDetachedFromWindow(View view) {
                }

                public void onViewAttachedToWindow(View view) {
                    MBAcquireRewardPopView.this.setLongClickable(true);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.setOnTouchListener(mBAcquireRewardPopView.o);
                }
            });
            linearLayout = linearLayout2;
        }
        if (linearLayout != null) {
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            setBackgroundColor(this.b.containerBackgroundColor);
            addView(linearLayout);
            if (this.b.autoDismissTime > 0) {
                this.h = this.b.autoDismissTime;
                post(this.m);
                this.i = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.m);
    }

    private View a(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = arrayList;
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(af.b(getContext(), 290.0f), -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        int i2 = this.b.viewBackLayerTopColor;
        int i3 = this.b.viewBackLayerBottomColor;
        int i4 = this.b.viewForegroundTopColor;
        int i5 = this.b.viewForegroundBottomColor;
        GradientDrawable a2 = a(new int[]{i2, i3}, GradientDrawable.Orientation.TOP_BOTTOM);
        a2.setCornerRadius((float) af.b(getContext(), 12.0f));
        GradientDrawable a3 = a(new int[]{i4, i5}, GradientDrawable.Orientation.TOP_BOTTOM);
        a3.setCornerRadius((float) af.b(getContext(), 12.0f));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{a2, a3});
        layerDrawable.setLayerInset(1, 5, 5, 5, 5);
        linearLayout.setBackground(layerDrawable);
        ImageView imageView = new ImageView(getContext());
        int b2 = af.b(getContext(), 20.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b2, b2);
        layoutParams2.gravity = GravityCompat.END;
        layoutParams2.setMargins(0, 13, 13, 0);
        imageView.setLayoutParams(layoutParams2);
        imageView.setImageResource(getResources().getIdentifier("mbridge_reward_popview_close", "drawable", b.d().b()));
        imageView.setOnClickListener(this.q);
        linearLayout.addView(imageView);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        int b3 = af.b(getContext(), 18.0f);
        layoutParams3.setMargins(b3, 5, b3, af.b(getContext(), 12.0f));
        textView.setLayoutParams(layoutParams3);
        textView.setText(this.b.title);
        textView.setTextColor(this.b.titleTextColor);
        textView.setTextSize(18.0f);
        textView.setGravity(17);
        linearLayout.addView(textView);
        if (arrayList2 != null && arrayList.size() > 1) {
            int b4 = af.b(getContext(), 8.0f);
            int b5 = af.b(getContext(), 24.0f);
            int b6 = af.b(getContext(), 30.0f);
            int b7 = af.b(getContext(), 12.0f);
            int b8 = af.b(getContext(), 40.0f);
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                boolean contains = this.b.rightAnswerList.contains(arrayList2.get(i6));
                TextView textView2 = new TextView(getContext());
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.gravity = 1;
                layoutParams4.setMargins(b6, b7, b6, 0);
                textView2.setPadding(b5, b4, b5, b4);
                textView2.setLayoutParams(layoutParams4);
                textView2.setText(arrayList2.get(i6));
                textView2.setSingleLine(true);
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setTag(arrayList2.get(i6));
                textView2.setTextSize(17.0f);
                textView2.setGravity(17);
                AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.b;
                textView2.setTextColor(contains ? acquireRewardPopViewParameters.buttonTextLightColor : acquireRewardPopViewParameters.buttonTextDarkColor);
                AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.b;
                int i7 = contains ? acquireRewardPopViewParameters2.buttonBackgroundLightColor : acquireRewardPopViewParameters2.buttonBackgroundDarkColor;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(i7);
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius((float) b8);
                textView2.setBackground(gradientDrawable);
                textView2.setOnClickListener(this.l);
                linearLayout.addView(textView2);
            }
        }
        this.k = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        int b9 = af.b(getContext(), 16.0f);
        int b10 = af.b(getContext(), 18.0f);
        layoutParams5.setMargins(b10, b9, b10, b9);
        layoutParams5.gravity = 1;
        this.k.setLayoutParams(layoutParams5);
        this.k.setText(String.format(this.b.tips, new Object[]{Integer.valueOf(this.b.reduceTime)}));
        this.k.setTextColor(this.b.tipTextColor);
        this.k.setGravity(17);
        this.k.setTextSize(12.0f);
        linearLayout.addView(this.k);
        return linearLayout;
    }

    private GradientDrawable a(int[] iArr, GradientDrawable.Orientation orientation) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(iArr);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(orientation);
        gradientDrawable.setShape(0);
        return gradientDrawable;
    }

    public void onTimeLessThanReduce(int i2) {
        this.b.reduceTime = i2;
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(String.format(this.b.tips, new Object[]{Integer.valueOf(this.b.reduceTime)}));
        }
    }

    public void onResume() {
        if (this.i && this.h > 0) {
            post(this.m);
        }
    }

    public void onPause() {
        if (this.i && this.h > 0) {
            removeCallbacks(this.m);
        }
    }

    public void onStop() {
        if (this.i && this.h > 0) {
            removeCallbacks(this.m);
        }
    }

    static /* synthetic */ void a(MBAcquireRewardPopView mBAcquireRewardPopView, final View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.8f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(1000);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000);
        AnimationSet animationSet = new AnimationSet(true);
        mBAcquireRewardPopView.c = animationSet;
        animationSet.addAnimation(translateAnimation);
        mBAcquireRewardPopView.c.addAnimation(alphaAnimation);
        final AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(1000);
        alphaAnimation2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view.startAnimation(MBAcquireRewardPopView.this.c);
            }
        });
        mBAcquireRewardPopView.c.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view.startAnimation(alphaAnimation2);
            }
        });
        view.startAnimation(mBAcquireRewardPopView.c);
    }

    static /* synthetic */ View e(MBAcquireRewardPopView mBAcquireRewardPopView) {
        String str;
        LinearLayout linearLayout = new LinearLayout(mBAcquireRewardPopView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        gradientAndShadowParameters.gradientStartColor = mBAcquireRewardPopView.b.successTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = mBAcquireRewardPopView.b.successTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = mBAcquireRewardPopView.b.successTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(mBAcquireRewardPopView.getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, af.b(mBAcquireRewardPopView.getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        if (mBAcquireRewardPopView.b.viewType == 1) {
            str = mBAcquireRewardPopView.b.successTitle;
        } else {
            str = mBAcquireRewardPopView.b.viewType == 2 ? mBAcquireRewardPopView.b.slideSuccessTitle : "";
        }
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setText(String.format(" %s ", new Object[]{str}));
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable a2 = mBAcquireRewardPopView.a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(mBAcquireRewardPopView.getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(mBAcquireRewardPopView.b.successTipTextColor);
        textView.setText(String.format(mBAcquireRewardPopView.b.successTip, new Object[]{Integer.valueOf(mBAcquireRewardPopView.b.reduceTime)}));
        int b2 = af.b(mBAcquireRewardPopView.getContext(), 6.0f);
        int b3 = af.b(mBAcquireRewardPopView.getContext(), 32.0f);
        textView.setPadding(b3, b2, b3, b2);
        textView.setBackground(a2);
        linearLayout.addView(textView);
        return linearLayout;
    }

    static /* synthetic */ View f(MBAcquireRewardPopView mBAcquireRewardPopView) {
        LinearLayout linearLayout = new LinearLayout(mBAcquireRewardPopView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        gradientAndShadowParameters.gradientStartColor = mBAcquireRewardPopView.b.failTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = mBAcquireRewardPopView.b.failTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = mBAcquireRewardPopView.b.failTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(mBAcquireRewardPopView.getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, af.b(mBAcquireRewardPopView.getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        mBGradientAndShadowTextView.setText(String.format(" %s ", new Object[]{mBAcquireRewardPopView.b.failTitle}));
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable a2 = mBAcquireRewardPopView.a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(mBAcquireRewardPopView.getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(mBAcquireRewardPopView.b.failTipTextColor);
        textView.setText(String.format(mBAcquireRewardPopView.b.failTip, new Object[]{""}));
        int b2 = af.b(mBAcquireRewardPopView.getContext(), 6.0f);
        int b3 = af.b(mBAcquireRewardPopView.getContext(), 32.0f);
        textView.setPadding(b3, b2, b3, b2);
        textView.setBackground(a2);
        linearLayout.addView(textView);
        return linearLayout;
    }

    static /* synthetic */ void a(MBAcquireRewardPopView mBAcquireRewardPopView, View view, View view2) {
        mBAcquireRewardPopView.removeView(view);
        mBAcquireRewardPopView.addView(view2);
    }
}
