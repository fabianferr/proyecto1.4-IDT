package com.mbridge.msdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.t;
import java.util.Locale;
import org.apache.http.protocol.HTTP;

public class MBAlertDialog extends Dialog {
    private a a;
    private TextView b;
    private TextView c;
    private Button d;
    private Button e;

    public MBAlertDialog(Context context, final a aVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(t.a(context, "mbridge_cm_alertview", "layout"), (ViewGroup) null);
        this.a = aVar;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.b = (TextView) inflate.findViewById(t.a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e2) {
                aa.a("MBAlertDialog", e2.getMessage());
            }
            try {
                this.c = (TextView) inflate.findViewById(t.a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.d = (Button) inflate.findViewById(t.a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.e = (Button) inflate.findViewById(t.a(context, "mbridge_video_common_alertview_cancel_button", "id"));
            } catch (Exception e3) {
                aa.a("MBAlertDialog", e3.getMessage());
            }
        }
        Button button = this.e;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.b();
                    }
                    MBAlertDialog.this.cancel();
                    MBAlertDialog.this.clear();
                }
            });
        }
        Button button2 = this.d;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.c();
                    }
                    MBAlertDialog.this.cancel();
                    MBAlertDialog.this.clear();
                }
            });
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void clear() {
        if (this.a != null) {
            this.a = null;
        }
    }

    public void setTitle(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setContent(String str) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setConfirmText(String str) {
        Button button = this.d;
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

    private void a(String str, String str2, String str3, String str4) {
        setTitle(str);
        setContent(str2);
        setConfirmText(str3);
        setCancelText(str4);
    }

    public void makeRVAlertView(String str) {
        String str2 = str;
        try {
            Context context = getContext();
            String obj = ai.b(context, "MBridge_ConfirmTitle" + str2, "").toString();
            Context context2 = getContext();
            String obj2 = ai.b(context2, "MBridge_ConfirmContent" + str2, "").toString();
            Context context3 = getContext();
            String obj3 = ai.b(context3, "MBridge_CancelText" + str2, "").toString();
            Context context4 = getContext();
            String obj4 = ai.b(context4, "MBridge_ConfirmText" + str2, "").toString();
            e b2 = f.a().b(b.d().h());
            if (TextUtils.isEmpty(obj)) {
                if (TextUtils.isEmpty(obj2) && TextUtils.isEmpty(obj3) && TextUtils.isEmpty(obj4)) {
                    if (b2 != null) {
                        a(b2.ad(), b2.ae(), b2.af(), b2.ag());
                        return;
                    }
                    String language = Locale.getDefault().getLanguage();
                    if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                        setTitle("Confirm to close? ");
                        setContent("You will not be rewarded after closing the window");
                        setConfirmText("Close it");
                        setCancelText("Continue");
                        return;
                    }
                    setTitle("确认关闭？");
                    setContent("关闭后您将不会获得任何奖励噢~ ");
                    setConfirmText("确认关闭");
                    setCancelText("继续观看");
                    return;
                }
            }
            String language2 = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(obj)) {
                if (b2 != null) {
                    obj = b2.ad();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setTitle("Confirm to close? ");
                } else {
                    setTitle("确认关闭？");
                }
            }
            if (TextUtils.isEmpty(obj2)) {
                if (b2 != null) {
                    obj2 = b2.ae();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setContent("You will not be rewarded after closing the window");
                } else {
                    setContent("关闭后您将不会获得任何奖励噢~ ");
                }
            }
            if (TextUtils.isEmpty(obj4)) {
                if (b2 != null) {
                    obj4 = b2.af();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setConfirmText("Close it");
                } else {
                    setConfirmText("确认关闭");
                }
            }
            if (TextUtils.isEmpty(obj3)) {
                if (b2 != null) {
                    obj3 = b2.ag();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setCancelText("Continue");
                } else {
                    setCancelText("继续观看");
                }
            }
            a(obj, obj2, obj4, obj3);
        } catch (Exception e2) {
            aa.a("MBAlertDialog", e2.getMessage());
        }
    }

    public void makePlayableAlertView() {
        e b2 = f.a().b(b.d().h());
        if (b2 != null) {
            a(b2.ad(), b2.ae(), b2.af(), b2.ah());
            return;
        }
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            setTitle("Confirm to close? ");
            setContent("You will not be rewarded after closing the window");
            setConfirmText("Close it");
            setCancelText("Continue");
            return;
        }
        setTitle("确认关闭？");
        setContent("关闭后您将不会获得任何奖励噢~ ");
        setConfirmText("确认关闭");
        setCancelText("继续试玩");
    }

    public void makeIVAlertView(int i, String str) {
        try {
            Context context = getContext();
            String obj = ai.b(context, "MBridge_ConfirmTitle" + str, "").toString();
            Context context2 = getContext();
            String obj2 = ai.b(context2, "MBridge_ConfirmContent" + str, "").toString();
            Context context3 = getContext();
            String obj3 = ai.b(context3, "MBridge_CancelText" + str, "").toString();
            Context context4 = getContext();
            String obj4 = ai.b(context4, "MBridge_ConfirmText" + str, "").toString();
            if (!TextUtils.isEmpty(obj) || !TextUtils.isEmpty(obj2) || !TextUtils.isEmpty(obj3) || !TextUtils.isEmpty(obj4)) {
                a(obj, obj2, obj3, obj4);
                return;
            }
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                setTitle(i == a.o ? "Confirm" : "Tips");
                setContent(i == a.o ? "If you choose to continue, you will receive a reward after the end. Confirm closed?" : "If you choose to continue, you will receive a reward after the end. Whether to continue?");
                setConfirmText(i == a.o ? HTTP.CONN_CLOSE : "Cancel");
                setCancelText("Continue");
                return;
            }
            setTitle(i == a.o ? "确认关闭？" : "提示");
            setContent(i == a.o ? "如果你选择继续，结束后将会获得奖励。确认关闭吗？" : "如果你选择继续，结束后将会获得奖励。是否继续？");
            setConfirmText(i == a.o ? "确认关闭" : "取消");
            setCancelText("继续");
        } catch (Exception e2) {
            aa.a("MBAlertDialog", e2.getMessage());
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
}
