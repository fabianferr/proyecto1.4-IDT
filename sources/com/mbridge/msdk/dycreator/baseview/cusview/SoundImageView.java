package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.t;

public class SoundImageView extends ImageView {
    private boolean a = true;

    public SoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SoundImageView(Context context) {
        super(context);
    }

    public boolean getStatus() {
        return this.a;
    }

    public void setSoundStatus(boolean z) {
        this.a = z;
        if (z) {
            setImageResource(t.a(getContext(), "mbridge_reward_sound_open", "drawable"));
        } else {
            setImageResource(t.a(getContext(), "mbridge_reward_sound_close", "drawable"));
        }
    }
}
