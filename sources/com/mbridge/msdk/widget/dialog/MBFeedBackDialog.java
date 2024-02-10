package com.mbridge.msdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.t;

public class MBFeedBackDialog extends Dialog {
    /* access modifiers changed from: private */
    public a a;
    private TextView b;
    private LinearLayout c;
    private Button d;
    private Button e;
    private Button f;
    private int g;
    private int h;

    public void setConfirmText(String str) {
    }

    public MBFeedBackDialog(Context context, a aVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(t.a(context, "mbridge_cm_feedbackview", "layout"), (ViewGroup) null);
        setDialogWidthAndHeight(0.5f, 0.8f);
        this.a = aVar;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.b = (TextView) inflate.findViewById(t.a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e2) {
                aa.a("MBAlertDialog", e2.getMessage());
            }
            try {
                this.c = (LinearLayout) inflate.findViewById(t.a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.d = (Button) inflate.findViewById(t.a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.e = (Button) inflate.findViewById(t.a(context, "mbridge_video_common_alertview_cancel_button", "id"));
                this.f = (Button) inflate.findViewById(t.a(context, "mbridge_video_common_alertview_private_action_button", "id"));
            } catch (Exception e3) {
                aa.a("MBAlertDialog", e3.getMessage());
            }
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Button button = this.e;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBFeedBackDialog.this.a != null) {
                        MBFeedBackDialog.this.a.b();
                    }
                    MBFeedBackDialog.this.dismiss();
                }
            });
        }
        Button button2 = this.d;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBFeedBackDialog.this.a != null) {
                        MBFeedBackDialog.this.a.c();
                    }
                    MBFeedBackDialog.this.dismiss();
                }
            });
        }
        Button button3 = this.f;
        if (button3 != null) {
            button3.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBFeedBackDialog.this.dismiss();
                    if (MBFeedBackDialog.this.a != null) {
                        MBFeedBackDialog.this.a.a();
                    }
                }
            });
        }
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (MBFeedBackDialog.this.a != null) {
                    MBFeedBackDialog.this.a.c();
                }
            }
        });
    }

    public void setCancelButtonClickable(boolean z) {
        Button button = this.e;
        if (button != null) {
            button.setClickable(z);
            if (z) {
                this.e.setBackgroundResource(getContext().getResources().getIdentifier("mbridge_cm_feedback_choice_btn_bg_pressed", "drawable", b.d().b()));
                this.e.setAlpha(1.0f);
                return;
            }
            this.e.setBackgroundResource(getContext().getResources().getIdentifier("mbridge_cm_feedback_choice_btn_bg_pressed", "drawable", b.d().b()));
            this.e.setAlpha(0.4f);
        }
    }

    public void clear() {
        if (this.a != null) {
            this.a = null;
        }
    }

    public a getListener() {
        return this.a;
    }

    public void setListener(a aVar) {
        this.a = aVar;
    }

    public void setTitle(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setContent(ViewGroup viewGroup) {
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = af.b(b.d().g(), 16.0f);
            layoutParams.rightMargin = af.b(b.d().g(), 16.0f);
            layoutParams.topMargin = af.b(b.d().g(), 3.0f);
            layoutParams.bottomMargin = af.b(b.d().g(), 3.0f);
            this.c.addView(viewGroup, layoutParams);
        }
    }

    public void setPrivacyText(String str) {
        Button button = this.f;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setCancelText(String str) {
        Button button = this.e;
        if (button != null) {
            button.setText(str);
        }
    }

    public void show() {
        super.show();
        try {
            getWindow().setFlags(8, 8);
            super.show();
            hideNavigationBar(getWindow());
            getWindow().clearFlags(8);
        } catch (Exception e2) {
            aa.d("MBAlertDialog", e2.getMessage());
            super.show();
        }
    }

    public void hideNavigationBar(Window window) {
        if (window != null) {
            window.setFlags(1024, 1024);
            window.addFlags(67108864);
            window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            window.setGravity(17);
        }
    }

    public void setDialogWidthAndHeight(float f2, float f3) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (isScreenOrientationPortrait(getContext())) {
            this.h = displayMetrics.widthPixels;
            this.g = displayMetrics.heightPixels;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = (int) (((float) this.g) * f3);
            attributes.gravity = 80;
            getWindow().setAttributes(attributes);
            return;
        }
        this.h = displayMetrics.heightPixels;
        this.g = displayMetrics.widthPixels;
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.width = (int) (((float) this.g) * f2);
        attributes2.height = -1;
        attributes2.gravity = 17;
        getWindow().setAttributes(attributes2);
    }

    public static boolean isScreenOrientationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }
}
