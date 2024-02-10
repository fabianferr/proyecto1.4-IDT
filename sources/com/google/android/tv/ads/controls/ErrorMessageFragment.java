package com.google.android.tv.ads.controls;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.google.android.tv.ads.R;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
public final class ErrorMessageFragment extends Fragment {
    public static final /* synthetic */ int zza = 0;
    private ConstraintLayout zzb;
    private ConstraintLayout zzc;

    public ErrorMessageFragment() {
        super(R.layout.fragment_error_message);
    }

    public float getBackgroundAlpha() {
        return this.zzb.getAlpha();
    }

    public float getDrawerTranslationX() {
        return this.zzc.getTranslationX() / ((float) this.zzc.getWidth());
    }

    public void setBackgroundAlpha(float f) {
        this.zzb.setAlpha(f);
        this.zzb.invalidate();
    }

    public void setDrawerTranslationX(float f) {
        ConstraintLayout constraintLayout = this.zzc;
        constraintLayout.setTranslationX(((float) constraintLayout.getWidth()) * f);
        this.zzc.invalidate();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        viewGroup.getClass();
        View inflate = layoutInflater.inflate(R.layout.fragment_error_message, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.error_message_base_layout);
        constraintLayout.getClass();
        this.zzb = constraintLayout;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate.findViewById(R.id.error_message_layout);
        constraintLayout2.getClass();
        this.zzc = constraintLayout2;
        this.zzb.setAlpha(0.0f);
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(requireContext(), R.animator.animator_drawer_in);
        animatorSet.setTarget(this);
        animatorSet.start();
        AnimatorSet animatorSet2 = (AnimatorSet) AnimatorInflater.loadAnimator(requireContext(), R.animator.animator_drawer_out);
        animatorSet2.setTarget(this);
        animatorSet2.addListener(new zzb(this));
        Button button = (Button) inflate.findViewById(R.id.error_message_back_button);
        button.getClass();
        button.setOnClickListener(new zza(animatorSet2));
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new zzc(this, true, animatorSet2));
        return inflate;
    }
}
