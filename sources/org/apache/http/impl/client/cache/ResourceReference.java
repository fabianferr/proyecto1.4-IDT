package org.apache.http.impl.client.cache;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import org.apache.http.client.cache.HttpCacheEntry;
import org.apache.http.client.cache.Resource;

class ResourceReference extends PhantomReference<HttpCacheEntry> {
    private final Resource resource;

    public ResourceReference(HttpCacheEntry httpCacheEntry, ReferenceQueue<HttpCacheEntry> referenceQueue) {
        super(httpCacheEntry, referenceQueue);
        if (httpCacheEntry.getResource() != null) {
            this.resource = httpCacheEntry.getResource();
            return;
        }
        throw new IllegalArgumentException("Resource may not be null");
    }

    public Resource getResource() {
        return this.resource;
    }

    public int hashCode() {
        return this.resource.hashCode();
    }

    public boolean equals(Object obj) {
        return this.resource.equals(obj);
    }
}
