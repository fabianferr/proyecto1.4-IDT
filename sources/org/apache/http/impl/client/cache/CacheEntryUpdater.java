package org.apache.http.impl.client.cache;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.cache.HttpCacheEntry;
import org.apache.http.client.cache.ResourceFactory;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

class CacheEntryUpdater {
    private final ResourceFactory resourceFactory;

    CacheEntryUpdater() {
        this(new HeapResourceFactory());
    }

    CacheEntryUpdater(ResourceFactory resourceFactory2) {
        this.resourceFactory = resourceFactory2;
    }

    public HttpCacheEntry updateCacheEntry(String str, HttpCacheEntry httpCacheEntry, Date date, Date date2, HttpResponse httpResponse) throws IOException {
        if (httpResponse.getStatusLine().getStatusCode() == 304) {
            return new HttpCacheEntry(date, date2, httpCacheEntry.getStatusLine(), mergeHeaders(httpCacheEntry, httpResponse), this.resourceFactory.copy(str, httpCacheEntry.getResource()));
        }
        throw new IllegalArgumentException("Response must have 304 status code");
    }

    /* access modifiers changed from: protected */
    public Header[] mergeHeaders(HttpCacheEntry httpCacheEntry, HttpResponse httpResponse) {
        if (entryAndResponseHaveDateHeader(httpCacheEntry, httpResponse) && entryDateHeaderNewerThenResponse(httpCacheEntry, httpResponse)) {
            return httpCacheEntry.getAllHeaders();
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(httpCacheEntry.getAllHeaders()));
        removeCacheHeadersThatMatchResponse(arrayList, httpResponse);
        removeCacheEntry1xxWarnings(arrayList, httpCacheEntry);
        arrayList.addAll(Arrays.asList(httpResponse.getAllHeaders()));
        return (Header[]) arrayList.toArray(new Header[arrayList.size()]);
    }

    private void removeCacheHeadersThatMatchResponse(List<Header> list, HttpResponse httpResponse) {
        for (Header header : httpResponse.getAllHeaders()) {
            ListIterator<Header> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.next().getName().equals(header.getName())) {
                    listIterator.remove();
                }
            }
        }
    }

    private void removeCacheEntry1xxWarnings(List<Header> list, HttpCacheEntry httpCacheEntry) {
        ListIterator<Header> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if ("Warning".equals(listIterator.next().getName())) {
                for (Header value : httpCacheEntry.getHeaders("Warning")) {
                    if (value.getValue().startsWith("1")) {
                        listIterator.remove();
                    }
                }
            }
        }
    }

    private boolean entryDateHeaderNewerThenResponse(HttpCacheEntry httpCacheEntry, HttpResponse httpResponse) {
        try {
            if (!DateUtils.parseDate(httpCacheEntry.getFirstHeader("Date").getValue()).after(DateUtils.parseDate(httpResponse.getFirstHeader("Date").getValue()))) {
                return false;
            }
            return true;
        } catch (DateParseException unused) {
            return false;
        }
    }

    private boolean entryAndResponseHaveDateHeader(HttpCacheEntry httpCacheEntry, HttpResponse httpResponse) {
        return (httpCacheEntry.getFirstHeader("Date") == null || httpResponse.getFirstHeader("Date") == null) ? false : true;
    }
}
