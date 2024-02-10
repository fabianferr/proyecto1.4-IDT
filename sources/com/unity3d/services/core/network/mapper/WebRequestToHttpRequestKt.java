package com.unity3d.services.core.network.mapper;

import com.unity3d.services.core.network.model.BodyType;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.RequestType;
import com.unity3d.services.core.request.WebRequest;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toHttpRequest", "Lcom/unity3d/services/core/network/model/HttpRequest;", "Lcom/unity3d/services/core/request/WebRequest;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: WebRequestToHttpRequest.kt */
public final class WebRequestToHttpRequestKt {
    public static final HttpRequest toHttpRequest(WebRequest webRequest) {
        Intrinsics.checkNotNullParameter(webRequest, "<this>");
        String url = webRequest.getUrl().toString();
        String requestType = webRequest.getRequestType();
        Intrinsics.checkNotNullExpressionValue(requestType, "requestType");
        RequestType valueOf = RequestType.valueOf(requestType);
        Map<String, List<String>> headers = webRequest.getHeaders();
        byte[] body = webRequest.getBody();
        Intrinsics.checkNotNullExpressionValue(url, "toString()");
        Intrinsics.checkNotNullExpressionValue(headers, "headers");
        return new HttpRequest(url, (String) null, valueOf, body, headers, (Map) null, (BodyType) null, (String) null, (Integer) null, 0, 0, 0, 0, 8162, (DefaultConstructorMarker) null);
    }
}
