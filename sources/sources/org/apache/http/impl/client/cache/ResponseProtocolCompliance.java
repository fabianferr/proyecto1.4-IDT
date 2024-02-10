package org.apache.http.impl.client.cache;

import java.util.ArrayList;
import java.util.Date;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

class ResponseProtocolCompliance {
    ResponseProtocolCompliance() {
    }

    public void ensureProtocolCompliance(HttpRequest httpRequest, HttpResponse httpResponse) throws ClientProtocolException {
        if (backendResponseMustNotHaveBody(httpRequest, httpResponse)) {
            httpResponse.setEntity((HttpEntity) null);
        }
        authenticationRequiredDidNotHaveAProxyAuthenticationHeader(httpRequest, httpResponse);
        notAllowedResponseDidNotHaveAnAllowHeader(httpRequest, httpResponse);
        unauthorizedResponseDidNotHaveAWWWAuthenticateHeader(httpRequest, httpResponse);
        requestDidNotExpect100ContinueButResponseIsOne(httpRequest, httpResponse);
        transferEncodingIsNotReturnedTo1_0Client(httpRequest, httpResponse);
        ensurePartialContentIsNotSentToAClientThatDidNotRequestIt(httpRequest, httpResponse);
        ensure200ForOPTIONSRequestWithNoBodyHasContentLengthZero(httpRequest, httpResponse);
        ensure206ContainsDateHeader(httpResponse);
        ensure304DoesNotContainExtraEntityHeaders(httpResponse);
        identityIsNotUsedInContentEncoding(httpResponse);
        warningsWithNonMatchingWarnDatesAreRemoved(httpResponse);
    }

    private void warningsWithNonMatchingWarnDatesAreRemoved(HttpResponse httpResponse) {
        Date date;
        Header[] headers;
        try {
            date = DateUtils.parseDate(httpResponse.getFirstHeader("Date").getValue());
        } catch (DateParseException unused) {
            date = null;
        }
        if (date != null && (headers = httpResponse.getHeaders("Warning")) != null && headers.length != 0) {
            ArrayList<Header> arrayList = new ArrayList<>();
            boolean z = false;
            for (Header warningValues : headers) {
                for (WarningValue warningValue : WarningValue.getWarningValues(warningValues)) {
                    Date warnDate = warningValue.getWarnDate();
                    if (warnDate == null || warnDate.equals(date)) {
                        arrayList.add(new BasicHeader("Warning", warningValue.toString()));
                    } else {
                        z = true;
                    }
                }
            }
            if (z) {
                httpResponse.removeHeaders("Warning");
                for (Header addHeader : arrayList) {
                    httpResponse.addHeader(addHeader);
                }
            }
        }
    }

    private void identityIsNotUsedInContentEncoding(HttpResponse httpResponse) {
        HttpResponse httpResponse2 = httpResponse;
        Header[] headers = httpResponse2.getHeaders("Content-Encoding");
        if (headers != null && headers.length != 0) {
            ArrayList<Header> arrayList = new ArrayList<>();
            boolean z = false;
            for (Header elements : headers) {
                StringBuilder sb = new StringBuilder();
                boolean z2 = true;
                for (HeaderElement headerElement : elements.getElements()) {
                    if (HTTP.IDENTITY_CODING.equalsIgnoreCase(headerElement.getName())) {
                        z = true;
                    } else {
                        if (!z2) {
                            sb.append(",");
                        }
                        sb.append(headerElement.toString());
                        z2 = false;
                    }
                }
                String sb2 = sb.toString();
                if (!"".equals(sb2)) {
                    arrayList.add(new BasicHeader("Content-Encoding", sb2));
                }
            }
            if (z) {
                httpResponse2.removeHeaders("Content-Encoding");
                for (Header addHeader : arrayList) {
                    httpResponse2.addHeader(addHeader);
                }
            }
        }
    }

    private void authenticationRequiredDidNotHaveAProxyAuthenticationHeader(HttpRequest httpRequest, HttpResponse httpResponse) throws ClientProtocolException {
        if (httpResponse.getStatusLine().getStatusCode() == 407 && httpResponse.getFirstHeader("Proxy-Authenticate") == null) {
            throw new ClientProtocolException("407 Response did not contain a Proxy-Authentication header");
        }
    }

    private void notAllowedResponseDidNotHaveAnAllowHeader(HttpRequest httpRequest, HttpResponse httpResponse) throws ClientProtocolException {
        if (httpResponse.getStatusLine().getStatusCode() == 405 && httpResponse.getFirstHeader("Allow") == null) {
            throw new ClientProtocolException("405 Response did not contain an Allow header.");
        }
    }

    private void unauthorizedResponseDidNotHaveAWWWAuthenticateHeader(HttpRequest httpRequest, HttpResponse httpResponse) throws ClientProtocolException {
        if (httpResponse.getStatusLine().getStatusCode() == 401 && httpResponse.getFirstHeader("WWW-Authenticate") == null) {
            throw new ClientProtocolException("401 Response did not contain required WWW-Authenticate challenge header");
        }
    }

    private void ensure206ContainsDateHeader(HttpResponse httpResponse) {
        if (httpResponse.getFirstHeader("Date") == null) {
            httpResponse.addHeader("Date", DateUtils.formatDate(new Date()));
        }
    }

    private void ensurePartialContentIsNotSentToAClientThatDidNotRequestIt(HttpRequest httpRequest, HttpResponse httpResponse) throws ClientProtocolException {
        if (httpRequest.getFirstHeader("Range") == null && httpResponse.getFirstHeader("Content-Range") != null) {
            throw new ClientProtocolException("Content-Range was returned for a request that did not ask for a Content-Range.");
        }
    }

    private void ensure200ForOPTIONSRequestWithNoBodyHasContentLengthZero(HttpRequest httpRequest, HttpResponse httpResponse) {
        if (httpRequest.getRequestLine().getMethod().equalsIgnoreCase("OPTIONS") && httpResponse.getStatusLine().getStatusCode() == 200 && httpResponse.getFirstHeader("Content-Length") == null) {
            httpResponse.addHeader("Content-Length", "0");
        }
    }

    private void ensure304DoesNotContainExtraEntityHeaders(HttpResponse httpResponse) {
        String[] strArr = {"Allow", "Content-Encoding", "Content-Language", "Content-Length", "Content-MD5", "Content-Range", "Content-Type", "Last-Modified"};
        if (httpResponse.getStatusLine().getStatusCode() == 304) {
            for (int i = 0; i < 8; i++) {
                httpResponse.removeHeaders(strArr[i]);
            }
        }
    }

    private boolean backendResponseMustNotHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        return "HEAD".equals(httpRequest.getRequestLine().getMethod()) || httpResponse.getStatusLine().getStatusCode() == 204 || httpResponse.getStatusLine().getStatusCode() == 205 || httpResponse.getStatusLine().getStatusCode() == 304;
    }

    private void requestDidNotExpect100ContinueButResponseIsOne(HttpRequest httpRequest, HttpResponse httpResponse) throws ClientProtocolException {
        if (httpResponse.getStatusLine().getStatusCode() == 100 && requestWasWrapped(httpRequest)) {
            RequestWrapper requestWrapper = (RequestWrapper) httpRequest;
            if (getOriginalRequestProtocol(requestWrapper).compareToVersion(HttpVersion.HTTP_1_1) < 0 && originalRequestDidNotExpectContinue(requestWrapper)) {
                throw new ClientProtocolException("The incoming request did not contain a 100-continue header, but the response was a Status 100, continue.");
            }
        }
    }

    private void transferEncodingIsNotReturnedTo1_0Client(HttpRequest httpRequest, HttpResponse httpResponse) {
        if (requestWasWrapped(httpRequest) && getOriginalRequestProtocol((RequestWrapper) httpRequest).compareToVersion(HttpVersion.HTTP_1_1) < 0) {
            removeResponseTransferEncoding(httpResponse);
        }
    }

    private void removeResponseTransferEncoding(HttpResponse httpResponse) {
        httpResponse.removeHeaders("TE");
        httpResponse.removeHeaders("Transfer-Encoding");
    }

    private boolean originalRequestDidNotExpectContinue(RequestWrapper requestWrapper) {
        try {
            return !((HttpEntityEnclosingRequest) requestWrapper.getOriginal()).expectContinue();
        } catch (ClassCastException unused) {
            return false;
        }
    }

    private ProtocolVersion getOriginalRequestProtocol(RequestWrapper requestWrapper) {
        return requestWrapper.getOriginal().getProtocolVersion();
    }

    private boolean requestWasWrapped(HttpRequest httpRequest) {
        return httpRequest instanceof RequestWrapper;
    }
}
