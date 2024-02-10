package com.unity3d.services.ads.adunit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import java.util.ArrayList;
import java.util.Map;

public class AdUnitActivity extends Activity implements IAdUnitActivity {
    public static final String EXTRA_ACTIVITY_ID = "activityId";
    public static final String EXTRA_DISPLAY_CUTOUT_MODE = "displayCutoutMode";
    public static final String EXTRA_KEEP_SCREEN_ON = "keepScreenOn";
    public static final String EXTRA_KEY_EVENT_LIST = "keyEvents";
    public static final String EXTRA_ORIENTATION = "orientation";
    public static final String EXTRA_SYSTEM_UI_VISIBILITY = "systemUiVisibility";
    public static final String EXTRA_VIEWS = "views";
    protected AdUnitActivityController _controller;

    public Activity getActivity() {
        return this;
    }

    public Context getContext() {
        return this;
    }

    /* access modifiers changed from: protected */
    public AdUnitActivityController createController() {
        return new AdUnitActivityController(this, SharedInstances.INSTANCE.getWebViewEventSender(), new AdUnitViewHandlerFactory());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AdUnitActivityController createController = createController();
        this._controller = createController;
        createController.onCreate(bundle);
    }

    public AdUnitRelativeLayout getLayout() {
        return this._controller.getLayout();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this._controller.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this._controller.onStop();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this._controller.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this._controller.onPause();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this._controller.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this._controller.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this._controller.onKeyDown(i, keyEvent);
    }

    public void onWindowFocusChanged(boolean z) {
        this._controller.onWindowFocusChanged(z);
        super.onWindowFocusChanged(z);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this._controller.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void setViewFrame(String str, int i, int i2, int i3, int i4) {
        this._controller.setViewFrame(str, i, i2, i3, i4);
    }

    public Map<String, Integer> getViewFrame(String str) {
        return this._controller.getViewFrame(str);
    }

    public void setViews(String[] strArr) {
        this._controller.setViews(strArr);
    }

    public String[] getViews() {
        return this._controller.getViews();
    }

    public void setOrientation(int i) {
        this._controller.setOrientation(i);
    }

    public boolean setKeepScreenOn(boolean z) {
        return this._controller.setKeepScreenOn(z);
    }

    public boolean setSystemUiVisibility(int i) {
        return this._controller.setSystemUiVisibility(i);
    }

    public void setKeyEventList(ArrayList<Integer> arrayList) {
        this._controller.setKeyEventList(arrayList);
    }

    public IAdUnitViewHandler getViewHandler(String str) {
        return this._controller.getViewHandler(str);
    }

    public void setLayoutInDisplayCutoutMode(int i) {
        this._controller.setLayoutInDisplayCutoutMode(i);
    }
}
