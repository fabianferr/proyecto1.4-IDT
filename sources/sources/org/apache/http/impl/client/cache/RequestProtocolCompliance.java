package org.apache.http.impl.client.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.cache.HeaderConstants;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.protocol.HTTP;

class RequestProtocolCompliance {
    private static final List<String> disallowedWithNoCache = Arrays.asList(new String[]{HeaderConstants.CACHE_CONTROL_MIN_FRESH, HeaderConstants.CACHE_CONTROL_MAX_STALE, "max-age"});

    RequestProtocolCompliance() {
    }

    public List<RequestProtocolError> requestIsFatallyNonCompliant(HttpRequest httpRequest) {
        ArrayList arrayList = new ArrayList();
        RequestProtocolError requestHasWeakETagAndRange = requestHasWeakETagAndRange(httpRequest);
        if (requestHasWeakETagAndRange != null) {
            arrayList.add(requestHasWeakETagAndRange);
        }
        RequestProtocolError requestHasWeekETagForPUTOrDELETEIfMatch = requestHasWeekETagForPUTOrDELETEIfMatch(httpRequest);
        if (requestHasWeekETagForPUTOrDELETEIfMatch != null) {
            arrayList.add(requestHasWeekETagForPUTOrDELETEIfMatch);
        }
        RequestProtocolError requestContainsNoCacheDirectiveWithFieldName = requestContainsNoCacheDirectiveWithFieldName(httpRequest);
        if (requestContainsNoCacheDirectiveWithFieldName != null) {
            arrayList.add(requestContainsNoCacheDirectiveWithFieldName);
        }
        return arrayList;
    }

    public HttpRequest makeRequestCompliant(HttpRequest httpRequest) throws ClientProtocolException {
        if (requestMustNotHaveEntity(httpRequest)) {
            ((HttpEntityEnclosingRequest) httpRequest).setEntity((HttpEntity) null);
        }
        verifyRequestWithExpectContinueFlagHas100continueHeader(httpRequest);
        verifyOPTIONSRequestWithBodyHasContentType(httpRequest);
        decrementOPTIONSMaxForwardsIfGreaterThen0(httpRequest);
        stripOtherFreshnessDirectivesWithNoCache(httpRequest);
        if (requestVersionIsTooLow(httpRequest)) {
            return upgradeRequestTo(httpRequest, HttpVersion.HTTP_1_1);
        }
        return requestMinorVersionIsTooHighMajorVersionsMatch(httpRequest) ? downgradeRequestTo(httpRequest, HttpVersion.HTTP_1_1) : httpRequest;
    }

    private void stripOtherFreshnessDirectivesWithNoCache(HttpRequest httpRequest) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (Header elements : httpRequest.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : elements.getElements()) {
                if (!disallowedWithNoCache.contains(headerElement.getName())) {
                    arrayList.add(headerElement);
                }
                if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equals(headerElement.getName())) {
                    z = true;
                }
            }
        }
        if (z) {
            httpRequest.removeHeaders("Cache-Control");
            httpRequest.setHeader("Cache-Control", buildHeaderFromElements(arrayList));
        }
    }

    private String buildHeaderFromElements(List<HeaderElement> list) {
        StringBuilder sb = new StringBuilder("");
        boolean z = true;
        for (HeaderElement next : list) {
            if (!z) {
                sb.append(",");
            } else {
                z = false;
            }
            sb.append(next.toString());
        }
        return sb.toString();
    }

    private boolean requestMustNotHaveEntity(HttpRequest httpRequest) {
        return "TRACE".equals(httpRequest.getRequestLine().getMethod()) && (httpRequest instanceof HttpEntityEnclosingRequest);
    }

    private void decrementOPTIONSMaxForwardsIfGreaterThen0(HttpRequest httpRequest) {
        Header firstHeader;
        if ("OPTIONS".equals(httpRequest.getRequestLine().getMethod()) && (firstHeader = httpRequest.getFirstHeader("Max-Forwards")) != null) {
            httpRequest.removeHeaders("Max-Forwards");
            httpRequest.setHeader("Max-Forwards", Integer.toString(Integer.parseInt(firstHeader.getValue()) - 1));
        }
    }

    private void verifyOPTIONSRequestWithBodyHasContentType(HttpRequest httpRequest) {
        if ("OPTIONS".equals(httpRequest.getRequestLine().getMethod()) && (httpRequest instanceof HttpEntityEnclosingRequest)) {
            addContentTypeHeaderIfMissing((HttpEntityEnclosingRequest) httpRequest);
        }
    }

    private void addContentTypeHeaderIfMissing(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        if (httpEntityEnclosingRequest.getEntity().getContentType() == null) {
            ((AbstractHttpEntity) httpEntityEnclosingRequest.getEntity()).setContentType("application/octet-stream");
        }
    }

    private void verifyRequestWithExpectContinueFlagHas100continueHeader(HttpRequest httpRequest) {
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
            if (!httpEntityEnclosingRequest.expectContinue() || httpEntityEnclosingRequest.getEntity() == null) {
                remove100ContinueHeaderIfExists(httpRequest);
            } else {
                add100ContinueHeaderIfMissing(httpRequest);
            }
        } else {
            remove100ContinueHeaderIfExists(httpRequest);
        }
    }

    private void remove100ContinueHeaderIfExists(HttpRequest httpRequest) {
        Header[] headers = httpRequest.getHeaders("Expect");
        ArrayList<HeaderElement> arrayList = new ArrayList<>();
        boolean z = false;
        for (Header header : headers) {
            for (HeaderElement headerElement : header.getElements()) {
                if (!HTTP.EXPECT_CONTINUE.equalsIgnoreCase(headerElement.getName())) {
                    arrayList.add(headerElement);
                } else {
                    z = true;
                }
            }
            if (z) {
                httpRequest.removeHeader(header);
                for (HeaderElement name : arrayList) {
                    httpRequest.addHeader(new BasicHeader("Expect", name.getName()));
                }
                return;
            }
            arrayList = new ArrayList<>();
        }
    }

    private void add100ContinueHeaderIfMissing(HttpRequest httpRequest) {
        boolean z = false;
        for (Header elements : httpRequest.getHeaders("Expect")) {
            for (HeaderElement name : elements.getElements()) {
                if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(name.getName())) {
                    z = true;
                }
            }
        }
        if (!z) {
            httpRequest.addHeader("Expect", HTTP.EXPECT_CONTINUE);
        }
    }

    private HttpRequest upgradeRequestTo(HttpRequest httpRequest, ProtocolVersion protocolVersion) throws ClientProtocolException {
        try {
            RequestWrapper requestWrapper = new RequestWrapper(httpRequest);
            requestWrapper.setProtocolVersion(protocolVersion);
            return requestWrapper;
        } catch (ProtocolException e) {
            throw new ClientProtocolException((Throwable) e);
        }
    }

    private HttpRequest downgradeRequestTo(HttpRequest httpRequest, ProtocolVersion protocolVersion) throws ClientProtocolException {
        try {
            RequestWrapper requestWrapper = new RequestWrapper(httpRequest);
            requestWrapper.setProtocolVersion(protocolVersion);
            return requestWrapper;
        } catch (ProtocolException e) {
            throw new ClientProtocolException((Throwable) e);
        }
    }

    /* access modifiers changed from: protected */
    public boolean requestMinorVersionIsTooHighMajorVersionsMatch(HttpRequest httpRequest) {
        ProtocolVersion protocolVersion = httpRequest.getProtocolVersion();
        if (protocolVersion.getMajor() == HttpVersion.HTTP_1_1.getMajor() && protocolVersion.getMinor() > HttpVersion.HTTP_1_1.getMinor()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean requestVersionIsTooLow(HttpRequest httpRequest) {
        return httpRequest.getProtocolVersion().compareToVersion(HttpVersion.HTTP_1_1) < 0;
    }

    /* renamed from: org.apache.http.impl.client.cache.RequestProtocolCompliance$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$http$impl$client$cache$RequestProtocolError;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.apache.http.impl.client.cache.RequestProtocolError[] r0 = org.apache.http.impl.client.cache.RequestProtocolError.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$http$impl$client$cache$RequestProtocolError = r0
                org.apache.http.impl.client.cache.RequestProtocolError r1 = org.apache.http.impl.client.cache.RequestProtocolError.BODY_BUT_NO_LENGTH_ERROR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$apache$http$impl$client$cache$RequestProtocolError     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.http.impl.client.cache.RequestProtocolError r1 = org.apache.http.impl.client.cache.RequestProtocolError.WEAK_ETAG_AND_RANGE_ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$apache$http$impl$client$cache$RequestProtocolError     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.http.impl.client.cache.RequestProtocolError r1 = org.apache.http.impl.client.cache.RequestProtocolError.WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$apache$http$impl$client$cache$RequestProtocolError     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.apache.http.impl.client.cache.RequestProtocolError r1 = org.apache.http.impl.client.cache.RequestProtocolError.NO_CACHE_DIRECTIVE_WITH_FIELD_NAME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.client.cache.RequestProtocolCompliance.AnonymousClass1.<clinit>():void");
        }
    }

    public HttpResponse getErrorForRequest(RequestProtocolError requestProtocolError) {
        int i = AnonymousClass1.$SwitchMap$org$apache$http$impl$client$cache$RequestProtocolError[requestProtocolError.ordinal()];
        if (i == 1) {
            return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 411, ""));
        }
        if (i == 2) {
            return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 400, "Weak eTag not compatible with byte range"));
        }
        if (i == 3) {
            return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 400, "Weak eTag not compatible with PUT or DELETE requests"));
        }
        if (i == 4) {
            return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 400, "No-Cache directive MUST NOT include a field name"));
        }
        throw new IllegalStateException("The request was compliant, therefore no error can be generated for it.");
    }

    private RequestProtocolError requestHasWeakETagAndRange(HttpRequest httpRequest) {
        Header firstHeader;
        if ("GET".equals(httpRequest.getRequestLine().getMethod()) && httpRequest.getFirstHeader("Range") != null && (firstHeader = httpRequest.getFirstHeader("If-Range")) != null && firstHeader.getValue().startsWith("W/")) {
            return RequestProtocolError.WEAK_ETAG_AND_RANGE_ERROR;
        }
        return null;
    }

    private RequestProtocolError requestHasWeekETagForPUTOrDELETEIfMatch(HttpRequest httpRequest) {
        String method = httpRequest.getRequestLine().getMethod();
        if (!"PUT".equals(method) && !"DELETE".equals(method)) {
            return null;
        }
        Header firstHeader = httpRequest.getFirstHeader("If-Match");
        if (firstHeader == null) {
            Header firstHeader2 = httpRequest.getFirstHeader("If-None-Match");
            if (firstHeader2 != null && firstHeader2.getValue().startsWith("W/")) {
                return RequestProtocolError.WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR;
            }
        } else if (firstHeader.getValue().startsWith("W/")) {
            return RequestProtocolError.WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR;
        }
        return null;
    }

    private RequestProtocolError requestContainsNoCacheDirectiveWithFieldName(HttpRequest httpRequest) {
        for (Header elements : httpRequest.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : elements.getElements()) {
                if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equalsIgnoreCase(headerElement.getName()) && headerElement.getValue() != null) {
                    return RequestProtocolError.NO_CACHE_DIRECTIVE_WITH_FIELD_NAME;
                }
            }
        }
        return null;
    }
}
