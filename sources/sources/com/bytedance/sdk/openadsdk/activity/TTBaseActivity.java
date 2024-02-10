package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Build;
import com.bytedance.sdk.component.utils.l;
import java.lang.reflect.Field;

public class TTBaseActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onResume() {
        if (Build.VERSION.SDK_INT > 28 || Build.VERSION.SDK_INT < 24) {
            super.onResume();
            return;
        }
        try {
            super.onResume();
        } catch (IllegalArgumentException e) {
            l.c("TTBaseActivity", "super.onResume() run fail", e);
            try {
                Field declaredField = Activity.class.getDeclaredField("mCalled");
                declaredField.setAccessible(true);
                declaredField.set(this, true);
            } catch (Exception e2) {
                l.c("TTBaseActivity", "onResume set mCalled fail", e2);
            }
        }
    }
}
