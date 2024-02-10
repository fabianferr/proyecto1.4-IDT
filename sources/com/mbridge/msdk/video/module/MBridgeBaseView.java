package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.video.module.a.a;
import com.mbridge.msdk.video.module.a.a.f;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class MBridgeBaseView extends RelativeLayout {
    public static final String TAG = "MBridgeBaseView";
    protected Context a;
    protected CampaignEx b;
    protected LayoutInflater c;
    protected int d;
    protected a e;
    protected boolean f;
    protected float g;
    protected float h;
    protected boolean i;
    protected int j;
    protected boolean k;
    protected int l;
    protected int m;

    /* access modifiers changed from: protected */
    public void c() {
    }

    public abstract void init(Context context);

    public MBridgeBaseView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MBridgeBaseView(Context context, AttributeSet attributeSet, boolean z, int i2, boolean z2, int i3, int i4) {
        super(context, attributeSet);
        this.d = 1;
        this.e = new f();
        this.f = false;
        this.l = 1;
        this.m = 0;
        this.a = context;
        this.c = LayoutInflater.from(context);
        this.i = z;
        this.j = i2;
        this.k = z2;
        this.l = i3;
        this.m = i4;
        init(context);
    }

    public MBridgeBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 1;
        this.e = new f();
        this.f = false;
        this.l = 1;
        this.m = 0;
        this.a = context;
        this.c = LayoutInflater.from(context);
        init(context);
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.d = configuration.orientation;
        super.onConfigurationChanged(configuration);
        Log.d(TAG, "onConfigurationChanged:" + configuration.orientation);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.d = configuration.orientation;
        Log.d(TAG, "onSelfConfigurationChanged:" + configuration.orientation);
    }

    public void setNotifyListener(a aVar) {
        this.e = aVar;
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.b = campaignEx;
    }

    public int findID(String str) {
        return t.a(this.a.getApplicationContext(), str, "id");
    }

    public int findDyID(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.hashCode();
        }
        return -1;
    }

    public int filterFindViewId(boolean z, String str) {
        if (z) {
            return findDyID(str);
        }
        return findID(str);
    }

    public int findLayout(String str) {
        return t.a(this.a.getApplicationContext(), str, "layout");
    }

    public int findColor(String str) {
        return t.a(this.a.getApplicationContext(), str, "color");
    }

    public int findDrawable(String str) {
        return t.a(this.a.getApplicationContext(), str, "drawable");
    }

    public boolean isNotNULL(View... viewArr) {
        if (viewArr == null) {
            return false;
        }
        int length = viewArr.length;
        int i2 = 0;
        boolean z = false;
        while (i2 < length) {
            if (viewArr[i2] == null) {
                return false;
            }
            i2++;
            z = true;
        }
        return z;
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        layoutParams.height = -1;
        layoutParams.width = -1;
    }

    public void setWrapContent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            return;
        }
        layoutParams.height = -2;
        layoutParams.width = -2;
    }

    public void defaultShow() {
        aa.a(TAG, "defaultShow");
    }

    public boolean isLandscape() {
        return this.a.getResources().getConfiguration().orientation == 2;
    }

    public void setLayoutCenter(int i2, int i3) {
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.addRule(13);
            if (i2 != -999) {
                parentRelativeLayoutParams.width = i2;
            }
            if (i3 != -999) {
                parentRelativeLayoutParams.height = i3;
            }
            setLayoutParams(parentRelativeLayoutParams);
        } else if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.gravity = 17;
            if (i2 != -999) {
                parentLinearLayoutParams.width = i2;
            }
            if (i3 != -999) {
                parentLinearLayoutParams.height = i3;
            }
            setLayoutParams(parentLinearLayoutParams);
        }
    }

    public void setLayoutParam(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.topMargin = i3;
            parentRelativeLayoutParams.leftMargin = i2;
            if (i4 != -999) {
                parentRelativeLayoutParams.width = i4;
            }
            if (i5 != -999) {
                parentRelativeLayoutParams.height = i5;
            }
            setLayoutParams(parentRelativeLayoutParams);
        } else if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.topMargin = i3;
            parentLinearLayoutParams.leftMargin = i2;
            if (i4 != -999) {
                parentLinearLayoutParams.width = i4;
            }
            if (i5 != -999) {
                parentLinearLayoutParams.height = i5;
            }
            setLayoutParams(parentLinearLayoutParams);
        }
    }

    public RelativeLayout.LayoutParams getParentRelativeLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            return (RelativeLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public LinearLayout.LayoutParams getParentLinearLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public CampaignEx getCampaign() {
        return this.b;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.g = motionEvent.getRawX();
        this.h = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public final String d() {
        return a(0).toString();
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f, af.a(b.d().g(), this.g));
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.g, af.a(b.d().g(), this.h));
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.i, i2);
                try {
                    this.d = getContext().getResources().getConfiguration().orientation;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.j, this.d);
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.k, (double) af.e(getContext()));
                return jSONObject2;
            } catch (JSONException e3) {
                e = e3;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e4) {
            e = e4;
            e.printStackTrace();
            return jSONObject;
        }
    }
}
