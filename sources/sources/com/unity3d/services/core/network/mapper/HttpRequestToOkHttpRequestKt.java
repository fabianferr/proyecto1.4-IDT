package com.unity3d.services.core.network.mapper;

import com.unity3d.services.core.network.model.HttpRequest;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0006¨\u0006\t"}, d2 = {"generateOkHttpBody", "Lokhttp3/RequestBody;", "body", "", "generateOkHttpHeaders", "Lokhttp3/Headers;", "Lcom/unity3d/services/core/network/model/HttpRequest;", "toOkHttpRequest", "Lokhttp3/Request;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpRequestToOkHttpRequest.kt */
public final class HttpRequestToOkHttpRequestKt {
    private static final RequestBody generateOkHttpBody(Object obj) {
        if (obj instanceof byte[]) {
            RequestBody create = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), (byte[]) obj);
            Intrinsics.checkNotNullExpressionValue(create, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return create;
        } else if (obj instanceof String) {
            RequestBody create2 = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), (String) obj);
            Intrinsics.checkNotNullExpressionValue(create2, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return create2;
        } else {
            RequestBody create3 = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), "");
            Intrinsics.checkNotNullExpressionValue(create3, "create(MediaType.parse(\"…lain;charset=utf-8\"), \"\")");
            return create3;
        }
    }

    private static final Headers generateOkHttpHeaders(HttpRequest httpRequest) {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry next : httpRequest.getHeaders().entrySet()) {
            builder.add((String) next.getKey(), CollectionsKt.joinToString$default((List) next.getValue(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        Headers build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n    .also { he…ng(\",\")) } }\n    .build()");
        return build;
    }

    public static final Request toOkHttpRequest(HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequest, "<this>");
        Request.Builder builder = new Request.Builder();
        Request.Builder url = builder.url(StringsKt.removeSuffix(StringsKt.trim(httpRequest.getBaseURL(), '/') + '/' + StringsKt.trim(httpRequest.getPath(), '/'), (CharSequence) "/"));
        String requestType = httpRequest.getMethod().toString();
        Object body = httpRequest.getBody();
        Request build = url.method(requestType, body != null ? generateOkHttpBody(body) : null).headers(generateOkHttpHeaders(httpRequest)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()");
        return build;
    }
}
