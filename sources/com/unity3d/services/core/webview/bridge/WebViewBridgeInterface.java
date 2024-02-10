package com.unity3d.services.core.webview.bridge;

import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import com.facebook.share.internal.ShareConstants;
import com.unity3d.services.core.log.DeviceLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007J.\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J.\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u001f\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00010\u00010\u001c*\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;", "", "webViewBridge", "Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;", "webViewAppInvocationCallbackInvoker", "Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;", "(Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;)V", "handleCallback", "", "callbackId", "", "callbackStatus", "rawParameters", "handleInvocation", "data", "onHandleCallback", "view", "Landroid/webkit/WebView;", "message", "Landroidx/webkit/WebMessageCompat;", "sourceOrigin", "Landroid/net/Uri;", "isMainFrame", "", "replyProxy", "Landroidx/webkit/JavaScriptReplyProxy;", "onHandleInvocation", "toTypedArray", "", "kotlin.jvm.PlatformType", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)[Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WebViewBridgeInterface.kt */
public final class WebViewBridgeInterface {
    private final IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker;
    private final IWebViewBridge webViewBridge;

    public WebViewBridgeInterface() {
        this((IWebViewBridge) null, (IInvocationCallbackInvoker) null, 3, (DefaultConstructorMarker) null);
    }

    public WebViewBridgeInterface(IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker) {
        Intrinsics.checkNotNullParameter(iWebViewBridge, "webViewBridge");
        Intrinsics.checkNotNullParameter(iInvocationCallbackInvoker, "webViewAppInvocationCallbackInvoker");
        this.webViewBridge = iWebViewBridge;
        this.webViewAppInvocationCallbackInvoker = iInvocationCallbackInvoker;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebViewBridgeInterface(IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SharedInstances.INSTANCE.getWebViewBridge() : iWebViewBridge, (i & 2) != 0 ? SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker() : iInvocationCallbackInvoker);
    }

    private final Object[] toTypedArray(JSONArray jSONArray) {
        Iterable until = RangesKt.until(0, jSONArray.length());
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(jSONArray.get(((IntIterator) it).nextInt()));
        }
        return ((List) arrayList).toArray(new Object[0]);
    }

    @JavascriptInterface
    public final void handleInvocation(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        DeviceLog.debug("handleInvocation " + str);
        JSONArray jSONArray = new JSONArray(str);
        Invocation invocation = new Invocation(this.webViewAppInvocationCallbackInvoker, this.webViewBridge);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray2 = (JSONArray) obj;
            Object obj2 = jSONArray2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = jSONArray2.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            Object obj4 = jSONArray2.get(2);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type org.json.JSONArray");
            Object obj5 = jSONArray2.get(3);
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
            invocation.addInvocation((String) obj2, (String) obj3, toTypedArray((JSONArray) obj4), new WebViewCallback((String) obj5, invocation.getId()));
            invocation.nextInvocation();
        }
        invocation.sendInvocationCallback();
    }

    @JavascriptInterface
    public final void handleCallback(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "callbackId");
        Intrinsics.checkNotNullParameter(str2, "callbackStatus");
        Intrinsics.checkNotNullParameter(str3, "rawParameters");
        DeviceLog.debug("handleCallback " + str + ' ' + str2 + ' ' + str3);
        this.webViewBridge.handleCallback(str, str2, toTypedArray(new JSONArray(str3)));
    }

    public final void onHandleInvocation(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(webMessageCompat, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(uri, "sourceOrigin");
        Intrinsics.checkNotNullParameter(javaScriptReplyProxy, "replyProxy");
        String data = webMessageCompat.getData();
        if (z) {
            CharSequence charSequence = data;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                handleInvocation(data);
            }
        }
    }

    public final void onHandleCallback(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(webMessageCompat, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(uri, "sourceOrigin");
        Intrinsics.checkNotNullParameter(javaScriptReplyProxy, "replyProxy");
        String data = webMessageCompat.getData();
        if (z) {
            CharSequence charSequence = data;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                JSONObject jSONObject = new JSONObject(data);
                String string = jSONObject.getString("id");
                String string2 = jSONObject.getString("status");
                String string3 = jSONObject.getString("parameters");
                Intrinsics.checkNotNullExpressionValue(string, "callbackId");
                Intrinsics.checkNotNullExpressionValue(string2, "callbackStatus");
                Intrinsics.checkNotNullExpressionValue(string3, "rawParameters");
                handleCallback(string, string2, string3);
            }
        }
    }
}
