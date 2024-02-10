package com.unity3d.services.core.webview;

import android.os.Build;
import android.os.ConditionVariable;
import android.os.Looper;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.unity3d.services.ads.api.AdUnit;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.configuration.InitializeThread;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.CallbackStatus;
import com.unity3d.services.core.webview.bridge.IWebViewBridge;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import com.unity3d.services.core.webview.bridge.Invocation;
import com.unity3d.services.core.webview.bridge.NativeCallback;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.unity3d.services.core.webview.bridge.WebViewBridge;
import com.vungle.ads.internal.model.AdPayload;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;

public class WebViewApp implements IWebViewBridgeInvoker {
    private static final int INVOKE_JS_CHARS_LENGTH = 22;
    /* access modifiers changed from: private */
    public static ConditionVariable _conditionVariable;
    private static WebViewApp _currentApp;
    private static final AtomicReference<Boolean> _initialized = new AtomicReference<>(false);
    private static final AtomicReference<Integer> _webAppFailureCode = new AtomicReference<>();
    private static final AtomicReference<String> _webAppFailureMessage = new AtomicReference<>();
    private Configuration _configuration;
    private final HashMap<String, NativeCallback> _nativeCallbacks;
    private boolean _webAppLoaded;
    private WebView _webView;
    protected final IWebViewBridge _webViewBridge;

    private WebViewApp(Configuration configuration, boolean z, boolean z2) {
        this(configuration, z, z2, SharedInstances.INSTANCE.getWebViewBridge());
    }

    private WebViewApp(Configuration configuration, boolean z, boolean z2, IWebViewBridge iWebViewBridge) {
        WebView webView;
        this._webAppLoaded = false;
        this._nativeCallbacks = new HashMap<>();
        setConfiguration(configuration);
        WebViewBridge.setClassTable(getConfiguration().getWebAppApiClassList());
        IExperiments experiments = configuration.getExperiments();
        this._webViewBridge = iWebViewBridge;
        if (z) {
            webView = new WebViewWithCache(ClientProperties.getApplicationContext(), z2, experiments);
        } else {
            webView = new WebView(ClientProperties.getApplicationContext(), z2, SharedInstances.INSTANCE.getWebViewBridge(), SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker(), experiments);
        }
        this._webView = webView;
        webView.setWebViewClient(new WebAppClient());
    }

    public WebViewApp() {
        this._webAppLoaded = false;
        this._nativeCallbacks = new HashMap<>();
        WebViewBridge.setClassTable(new Class[0]);
        this._webViewBridge = SharedInstances.INSTANCE.getWebViewBridge();
        _conditionVariable = new ConditionVariable();
    }

    public void setWebAppLoaded(boolean z) {
        this._webAppLoaded = z;
    }

    public boolean isWebAppLoaded() {
        return this._webAppLoaded;
    }

    public void setWebAppFailureMessage(String str) {
        _webAppFailureMessage.set(str);
    }

    public void setWebAppFailureCode(int i) {
        _webAppFailureCode.set(Integer.valueOf(i));
    }

    public String getWebAppFailureMessage() {
        return _webAppFailureMessage.get();
    }

    public int getWebAppFailureCode() {
        return _webAppFailureCode.get().intValue();
    }

    public void setWebAppInitialized(boolean z) {
        _initialized.set(Boolean.valueOf(z));
        _conditionVariable.open();
    }

    public void resetWebViewAppInitialization() {
        this._webAppLoaded = false;
        _webAppFailureCode.set(-1);
        _webAppFailureMessage.set("");
        _initialized.set(false);
    }

    public boolean isWebAppInitialized() {
        return _initialized.get().booleanValue();
    }

    public WebView getWebView() {
        return this._webView;
    }

    public void setWebView(WebView webView) {
        this._webView = webView;
    }

    public Configuration getConfiguration() {
        return this._configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this._configuration = configuration;
    }

    private void invokeJavascriptMethod(String str, String str2, JSONArray jSONArray) {
        String buildInvokeJavascript = buildInvokeJavascript(str, str2, jSONArray);
        DeviceLog.debug("Invoking javascript: %s", buildInvokeJavascript);
        getWebView().evaluateJavascript(buildInvokeJavascript, (ValueCallback<String>) null);
    }

    private String buildInvokeJavascript(String str, String str2, JSONArray jSONArray) {
        String jSONArray2 = jSONArray.toString();
        StringBuilder sb = new StringBuilder(str.length() + 22 + str2.length() + jSONArray2.length());
        sb.append("javascript:window.");
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        sb.append("(");
        sb.append(jSONArray2);
        sb.append(");");
        return sb.toString();
    }

    public boolean sendEvent(Enum enumR, Enum enumR2, Object... objArr) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("sendEvent ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(enumR.name());
        jSONArray.put(enumR2.name());
        for (Object put : objArr) {
            jSONArray.put(put);
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleEvent", jSONArray);
            return true;
        } catch (Exception e) {
            DeviceLog.exception("Error while sending event to WebView", e);
            return false;
        }
    }

    public boolean invokeMethod(String str, String str2, Method method, Object... objArr) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("invokeMethod ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(str);
        jSONArray.put(str2);
        if (method != null) {
            NativeCallback nativeCallback = new NativeCallback(method);
            addCallback(nativeCallback);
            jSONArray.put(nativeCallback.getId());
        } else {
            jSONArray.put((Object) null);
        }
        if (objArr != null) {
            for (Object put : objArr) {
                jSONArray.put(put);
            }
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleInvocation", jSONArray);
            return true;
        } catch (Exception e) {
            DeviceLog.exception("Error invoking javascript method", e);
            return false;
        }
    }

    public boolean invokeCallback(Invocation invocation) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("invokeBatchCallback ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        ArrayList<ArrayList<Object>> responses = invocation.getResponses();
        if (responses != null && !responses.isEmpty()) {
            Iterator<ArrayList<Object>> it = responses.iterator();
            while (it.hasNext()) {
                ArrayList next = it.next();
                Enum enumR = (Enum) next.get(1);
                Object[] objArr = (Object[]) next.get(2);
                Object[] copyOfRange = Arrays.copyOfRange(objArr, 1, objArr.length);
                ArrayList arrayList = new ArrayList();
                arrayList.add((String) objArr[0]);
                arrayList.add(((CallbackStatus) next.get(0)).toString());
                JSONArray jSONArray2 = new JSONArray();
                if (enumR != null) {
                    jSONArray2.put(enumR.name());
                }
                for (Object put : copyOfRange) {
                    jSONArray2.put(put);
                }
                arrayList.add(jSONArray2);
                JSONArray jSONArray3 = new JSONArray();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONArray.put(jSONArray3);
            }
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleCallback", jSONArray);
        } catch (Exception e) {
            DeviceLog.exception("Error while invoking batch response for WebView", e);
        }
        return true;
    }

    public void addCallback(NativeCallback nativeCallback) {
        synchronized (this._nativeCallbacks) {
            this._nativeCallbacks.put(nativeCallback.getId(), nativeCallback);
        }
    }

    public void removeCallback(NativeCallback nativeCallback) {
        synchronized (this._nativeCallbacks) {
            this._nativeCallbacks.remove(nativeCallback.getId());
        }
    }

    public NativeCallback getCallback(String str) {
        NativeCallback nativeCallback;
        synchronized (this._nativeCallbacks) {
            nativeCallback = this._nativeCallbacks.get(str);
        }
        return nativeCallback;
    }

    public static WebViewApp getCurrentApp() {
        return _currentApp;
    }

    public static void setCurrentApp(WebViewApp webViewApp) {
        _currentApp = webViewApp;
    }

    public static ErrorState create(Configuration configuration) throws IllegalThreadStateException {
        return create(configuration, false);
    }

    public static ErrorState create(final Configuration configuration, boolean z) throws IllegalThreadStateException {
        DeviceLog.entered();
        if (z) {
            return createWithRemoteUrl(configuration);
        }
        if (!Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        Configuration configuration = Configuration.this;
                        WebViewApp webViewApp = new WebViewApp(configuration, configuration.getExperiments().isWebAssetAdCaching(), Configuration.this.getExperiments().isWebGestureNotRequired());
                        webViewApp.getWebView().loadDataWithBaseURL(new WebViewUrlBuilder(AdPayload.FILE_SCHEME + SdkProperties.getLocalWebViewFile(), Configuration.this).getUrlWithQueryString(), Configuration.this.getWebViewData(), "text/html", "UTF-8", (String) null);
                        WebViewApp.setCurrentApp(webViewApp);
                    } catch (Exception e) {
                        DeviceLog.error("Unity Ads SDK unable to create WebViewApp " + e.getMessage());
                        WebViewApp._conditionVariable.open();
                    }
                }
            });
            ConditionVariable conditionVariable = new ConditionVariable();
            _conditionVariable = conditionVariable;
            boolean block = conditionVariable.block(configuration.getWebViewAppCreateTimeout());
            boolean z2 = true;
            boolean z3 = getCurrentApp() != null;
            boolean z4 = z3 && getCurrentApp().isWebAppInitialized();
            if (!block || !z3 || !z4) {
                z2 = false;
            }
            if (z2) {
                return null;
            }
            if (!block) {
                return ErrorState.CreateWebviewTimeout;
            }
            if (getCurrentApp() == null) {
                return ErrorState.CreateWebview;
            }
            return getCurrentApp().getErrorStateFromWebAppCode();
        }
        throw new IllegalThreadStateException("Cannot call create() from main thread!");
    }

    private static ErrorState createWithRemoteUrl(final Configuration configuration) {
        if (!Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        Configuration configuration = Configuration.this;
                        WebViewApp webViewApp = new WebViewApp(configuration, true, configuration.getExperiments().isWebGestureNotRequired());
                        webViewApp.getWebView().loadUrl(new WebViewUrlBuilder(Configuration.this.getWebViewUrl(), Configuration.this).getUrlWithQueryString());
                        WebViewApp.setCurrentApp(webViewApp);
                    } catch (Exception unused) {
                        DeviceLog.error("Unity Ads SDK unable to create WebViewApp");
                        WebViewApp._conditionVariable.open();
                    }
                }
            });
            ConditionVariable conditionVariable = new ConditionVariable();
            _conditionVariable = conditionVariable;
            boolean block = conditionVariable.block(configuration.getWebViewAppCreateTimeout());
            boolean z = true;
            boolean z2 = getCurrentApp() != null;
            boolean z3 = z2 && getCurrentApp().isWebAppInitialized();
            if (!block || !z2 || !z3) {
                z = false;
            }
            if (z) {
                return null;
            }
            if (!block) {
                return ErrorState.CreateWebviewTimeout;
            }
            if (getCurrentApp() == null) {
                return ErrorState.CreateWebview;
            }
            return getCurrentApp().getErrorStateFromWebAppCode();
        }
        throw new IllegalThreadStateException("Cannot call create() from main thread!");
    }

    public ErrorState getErrorStateFromWebAppCode() {
        int webAppFailureCode = getWebAppFailureCode();
        if (webAppFailureCode == 1) {
            return ErrorState.CreateWebviewGameIdDisabled;
        }
        if (webAppFailureCode == 2) {
            return ErrorState.CreateWebviewConfigError;
        }
        if (webAppFailureCode == 3) {
            return ErrorState.CreateWebviewInvalidArgument;
        }
        return ErrorState.CreateWebview;
    }

    private static class WebAppClient extends WebViewClient {
        private WebAppClient() {
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    if (AdUnit.getAdUnitActivity() != null) {
                        AdUnit.getAdUnitActivity().finish();
                    }
                    if (!(WebViewApp.getCurrentApp() == null || WebViewApp.getCurrentApp().getWebView() == null)) {
                        ViewUtilities.removeViewFromParent(WebViewApp.getCurrentApp().getWebView());
                    }
                    InitializeThread.reset();
                }
            });
            DeviceLog.error("UnityAds SDK WebView render process gone with following reason : " + renderProcessGoneDetail.toString());
            ((SDKMetricsSender) Utilities.getService(SDKMetricsSender.class)).sendEvent("native_webview_render_process_gone", (String) null, new HashMap<String, String>(renderProcessGoneDetail) {
                final /* synthetic */ RenderProcessGoneDetail val$detail;

                {
                    this.val$detail = r4;
                    if (Build.VERSION.SDK_INT >= 26) {
                        put("dc", "" + r4.didCrash());
                        put("pae", "" + r4.rendererPriorityAtExit());
                    }
                }
            });
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            DeviceLog.debug("Unity Ads SDK finished loading URL inside WebView: " + str);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            DeviceLog.debug("Unity Ads SDK attempts to load URL inside WebView: " + str);
            return false;
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (Build.VERSION.SDK_INT >= 23 && webResourceRequest != null && webResourceError != null) {
                DeviceLog.error("Unity Ads SDK encountered an error (code: " + webResourceError.getErrorCode() + ")  in WebView while loading a resource " + webResourceRequest.getUrl());
            } else if (Build.VERSION.SDK_INT < 21 || webResourceRequest == null) {
                DeviceLog.error("Unity Ads SDK encountered an error in WebView while loading a resource");
            } else {
                DeviceLog.error("Unity Ads SDK encountered an error in WebView while loading a resource " + webResourceRequest.getUrl());
            }
        }
    }
}
