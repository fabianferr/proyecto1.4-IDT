package org.apache.http.impl.client.cache;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.cache.InputLimit;
import org.apache.http.client.cache.Resource;
import org.apache.http.client.cache.ResourceFactory;
import org.apache.http.message.BasicHttpResponse;

class SizeLimitedResponseReader {
    private boolean consumed;
    private InputStream instream;
    private InputLimit limit;
    private final long maxResponseSizeBytes;
    private final HttpRequest request;
    private Resource resource;
    private final ResourceFactory resourceFactory;
    private final HttpResponse response;

    public SizeLimitedResponseReader(ResourceFactory resourceFactory2, long j, HttpRequest httpRequest, HttpResponse httpResponse) {
        this.resourceFactory = resourceFactory2;
        this.maxResponseSizeBytes = j;
        this.request = httpRequest;
        this.response = httpResponse;
    }

    /* access modifiers changed from: protected */
    public void readResponse() throws IOException {
        if (!this.consumed) {
            doConsume();
        }
    }

    private void ensureNotConsumed() {
        if (this.consumed) {
            throw new IllegalStateException("Response has already been consumed");
        }
    }

    private void ensureConsumed() {
        if (!this.consumed) {
            throw new IllegalStateException("Response has not been consumed");
        }
    }

    private void doConsume() throws IOException {
        ensureNotConsumed();
        this.consumed = true;
        this.limit = new InputLimit(this.maxResponseSizeBytes);
        HttpEntity entity = this.response.getEntity();
        if (entity != null) {
            String uri = this.request.getRequestLine().getUri();
            InputStream content = entity.getContent();
            this.instream = content;
            this.resource = this.resourceFactory.generate(uri, content, this.limit);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isLimitReached() {
        ensureConsumed();
        return this.limit.isReached();
    }

    /* access modifiers changed from: package-private */
    public Resource getResource() {
        ensureConsumed();
        return this.resource;
    }

    /* access modifiers changed from: package-private */
    public HttpResponse getReconstructedResponse() throws IOException {
        ensureConsumed();
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(this.response.getStatusLine());
        basicHttpResponse.setHeaders(this.response.getAllHeaders());
        CombinedEntity combinedEntity = new CombinedEntity(this.resource, this.instream);
        HttpEntity entity = this.response.getEntity();
        if (entity != null) {
            combinedEntity.setContentType(entity.getContentType());
            combinedEntity.setContentEncoding(entity.getContentEncoding());
            combinedEntity.setChunked(entity.isChunked());
        }
        basicHttpResponse.setEntity(combinedEntity);
        return basicHttpResponse;
    }
}
