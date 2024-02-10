package com.google.android.tv.ads.controls;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.gms.internal.atv_ads_framework.zzar;
import com.google.android.tv.ads.R;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
public final class WhyThisAdFragment extends Fragment {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public ImageView zzb;
    private ConstraintLayout zzc;
    private ConstraintLayout zzd;

    public WhyThisAdFragment() {
        super(R.layout.fragment_why_this_ad);
    }

    public float getBackgroundAlpha() {
        return this.zzc.getAlpha();
    }

    public float getDrawerTranslationX() {
        return this.zzd.getTranslationX() / ((float) this.zzd.getWidth());
    }

    public void setBackgroundAlpha(float f) {
        this.zzc.setAlpha(f);
        this.zzc.invalidate();
    }

    public void setDrawerTranslationX(float f) {
        ConstraintLayout constraintLayout = this.zzd;
        constraintLayout.setTranslationX(((float) constraintLayout.getWidth()) * f);
        this.zzd.invalidate();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        viewGroup.getClass();
        View inflate = layoutInflater.inflate(R.layout.fragment_why_this_ad, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.why_this_ad_base_layout);
        constraintLayout.getClass();
        this.zzc = constraintLayout;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate.findViewById(R.id.why_this_ad_layout);
        constraintLayout2.getClass();
        this.zzd = constraintLayout2;
        this.zzc.setAlpha(0.0f);
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(requireContext(), R.animator.animator_drawer_in);
        animatorSet.setTarget(this);
        animatorSet.start();
        AnimatorSet animatorSet2 = (AnimatorSet) AnimatorInflater.loadAnimator(requireContext(), R.animator.animator_drawer_out);
        animatorSet2.setTarget(this);
        animatorSet2.addListener(new zzf(this));
        Button button = (Button) inflate.findViewById(R.id.why_this_ad_back_button);
        button.getClass();
        button.setOnClickListener(new zzd(animatorSet2));
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new zzg(this, true, animatorSet2));
        ImageView imageView = (ImageView) inflate.findViewById(R.id.wta_image_view);
        imageView.getClass();
        this.zzb = imageView;
        String string = requireArguments().getString("wta_uri");
        string.getClass();
        String string2 = requireArguments().getString("wta_alt_text");
        if (!TextUtils.isEmpty(string2)) {
            this.zzb.setContentDescription(string2);
        }
        ((RequestBuilder) Glide.with((Fragment) this).load(zzar.zza(string, "zTvAdsFrameworkz")).fitCenter()).into(new zze(this, this.zzb));
        return inflate;
    }
}
