package org.apache.http.impl.conn.tsccm;

import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.params.HttpParams;

public class ThreadSafeClientConnManager implements ClientConnectionManager {
    protected final ClientConnectionOperator connOperator;
    protected final ConnPerRouteBean connPerRoute;
    @Deprecated
    protected final AbstractConnPool connectionPool;
    /* access modifiers changed from: private */
    public final Log log;
    protected final ConnPoolByRoute pool;
    protected final SchemeRegistry schemeRegistry;

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry2) {
        this(schemeRegistry2, -1, TimeUnit.MILLISECONDS);
    }

    public ThreadSafeClientConnManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    public ThreadSafeClientConnManager(SchemeRegistry schemeRegistry2, long j, TimeUnit timeUnit) {
        if (schemeRegistry2 != null) {
            this.log = LogFactory.getLog(getClass());
            this.schemeRegistry = schemeRegistry2;
            this.connPerRoute = new ConnPerRouteBean();
            this.connOperator = createConnectionOperator(schemeRegistry2);
            ConnPoolByRoute createConnectionPool = createConnectionPool(j, timeUnit);
            this.pool = createConnectionPool;
            this.connectionPool = createConnectionPool;
            return;
        }
        throw new IllegalArgumentException("Scheme registry may not be null");
    }

    @Deprecated
    public ThreadSafeClientConnManager(HttpParams httpParams, SchemeRegistry schemeRegistry2) {
        if (schemeRegistry2 != null) {
            this.log = LogFactory.getLog(getClass());
            this.schemeRegistry = schemeRegistry2;
            this.connPerRoute = new ConnPerRouteBean();
            this.connOperator = createConnectionOperator(schemeRegistry2);
            ConnPoolByRoute connPoolByRoute = (ConnPoolByRoute) createConnectionPool(httpParams);
            this.pool = connPoolByRoute;
            this.connectionPool = connPoolByRoute;
            return;
        }
        throw new IllegalArgumentException("Scheme registry may not be null");
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public AbstractConnPool createConnectionPool(HttpParams httpParams) {
        return new ConnPoolByRoute(this.connOperator, httpParams);
    }

    /* access modifiers changed from: protected */
    public ConnPoolByRoute createConnectionPool(long j, TimeUnit timeUnit) {
        return new ConnPoolByRoute(this.connOperator, this.connPerRoute, 20, j, timeUnit);
    }

    /* access modifiers changed from: protected */
    public ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry2) {
        return new DefaultClientConnectionOperator(schemeRegistry2);
    }

    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    public ClientConnectionRequest requestConnection(final HttpRoute httpRoute, Object obj) {
        final PoolEntryRequest requestPoolEntry = this.pool.requestPoolEntry(httpRoute, obj);
        return new ClientConnectionRequest() {
            public void abortRequest() {
                requestPoolEntry.abortRequest();
            }

            public ManagedClientConnection getConnection(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
                if (httpRoute != null) {
                    if (ThreadSafeClientConnManager.this.log.isDebugEnabled()) {
                        Log access$000 = ThreadSafeClientConnManager.this.log;
                        access$000.debug("Get connection: " + httpRoute + ", timeout = " + j);
                    }
                    return new BasicPooledConnAdapter(ThreadSafeClientConnManager.this, requestPoolEntry.getPoolEntry(j, timeUnit));
                }
                throw new IllegalArgumentException("Route may not be null.");
            }
        };
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x0070=Splitter:B:34:0x0070, B:20:0x0036=Splitter:B:20:0x0036} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void releaseConnection(org.apache.http.conn.ManagedClientConnection r8, long r9, java.util.concurrent.TimeUnit r11) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof org.apache.http.impl.conn.tsccm.BasicPooledConnAdapter
            if (r0 == 0) goto L_0x00c0
            org.apache.http.impl.conn.tsccm.BasicPooledConnAdapter r8 = (org.apache.http.impl.conn.tsccm.BasicPooledConnAdapter) r8
            org.apache.http.impl.conn.AbstractPoolEntry r0 = r8.getPoolEntry()
            if (r0 == 0) goto L_0x001b
            org.apache.http.conn.ClientConnectionManager r0 = r8.getManager()
            if (r0 != r7) goto L_0x0013
            goto L_0x001b
        L_0x0013:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Connection not obtained from this manager."
            r8.<init>(r9)
            throw r8
        L_0x001b:
            monitor-enter(r8)
            org.apache.http.impl.conn.AbstractPoolEntry r0 = r8.getPoolEntry()     // Catch:{ all -> 0x00bd }
            r2 = r0
            org.apache.http.impl.conn.tsccm.BasicPoolEntry r2 = (org.apache.http.impl.conn.tsccm.BasicPoolEntry) r2     // Catch:{ all -> 0x00bd }
            if (r2 != 0) goto L_0x0027
            monitor-exit(r8)     // Catch:{ all -> 0x00bd }
            return
        L_0x0027:
            boolean r0 = r8.isOpen()     // Catch:{ IOException -> 0x0060 }
            if (r0 == 0) goto L_0x0036
            boolean r0 = r8.isMarkedReusable()     // Catch:{ IOException -> 0x0060 }
            if (r0 != 0) goto L_0x0036
            r8.shutdown()     // Catch:{ IOException -> 0x0060 }
        L_0x0036:
            boolean r3 = r8.isMarkedReusable()     // Catch:{ all -> 0x00bd }
            org.apache.commons.logging.Log r0 = r7.log     // Catch:{ all -> 0x00bd }
            boolean r0 = r0.isDebugEnabled()     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x0053
            if (r3 == 0) goto L_0x004c
            org.apache.commons.logging.Log r0 = r7.log     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = "Released connection is reusable."
            r0.debug(r1)     // Catch:{ all -> 0x00bd }
            goto L_0x0053
        L_0x004c:
            org.apache.commons.logging.Log r0 = r7.log     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = "Released connection is not reusable."
            r0.debug(r1)     // Catch:{ all -> 0x00bd }
        L_0x0053:
            r8.detach()     // Catch:{ all -> 0x00bd }
            org.apache.http.impl.conn.tsccm.ConnPoolByRoute r1 = r7.pool     // Catch:{ all -> 0x00bd }
        L_0x0058:
            r4 = r9
            r6 = r11
            r1.freeEntry(r2, r3, r4, r6)     // Catch:{ all -> 0x00bd }
            goto L_0x0093
        L_0x005e:
            r0 = move-exception
            goto L_0x0095
        L_0x0060:
            r0 = move-exception
            org.apache.commons.logging.Log r1 = r7.log     // Catch:{ all -> 0x005e }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0070
            org.apache.commons.logging.Log r1 = r7.log     // Catch:{ all -> 0x005e }
            java.lang.String r3 = "Exception shutting down released connection."
            r1.debug(r3, r0)     // Catch:{ all -> 0x005e }
        L_0x0070:
            boolean r3 = r8.isMarkedReusable()     // Catch:{ all -> 0x00bd }
            org.apache.commons.logging.Log r0 = r7.log     // Catch:{ all -> 0x00bd }
            boolean r0 = r0.isDebugEnabled()     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x008d
            if (r3 == 0) goto L_0x0086
            org.apache.commons.logging.Log r0 = r7.log     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = "Released connection is reusable."
            r0.debug(r1)     // Catch:{ all -> 0x00bd }
            goto L_0x008d
        L_0x0086:
            org.apache.commons.logging.Log r0 = r7.log     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = "Released connection is not reusable."
            r0.debug(r1)     // Catch:{ all -> 0x00bd }
        L_0x008d:
            r8.detach()     // Catch:{ all -> 0x00bd }
            org.apache.http.impl.conn.tsccm.ConnPoolByRoute r1 = r7.pool     // Catch:{ all -> 0x00bd }
            goto L_0x0058
        L_0x0093:
            monitor-exit(r8)     // Catch:{ all -> 0x00bd }
            return
        L_0x0095:
            boolean r3 = r8.isMarkedReusable()     // Catch:{ all -> 0x00bd }
            org.apache.commons.logging.Log r1 = r7.log     // Catch:{ all -> 0x00bd }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x00b2
            if (r3 == 0) goto L_0x00ab
            org.apache.commons.logging.Log r1 = r7.log     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = "Released connection is reusable."
            r1.debug(r4)     // Catch:{ all -> 0x00bd }
            goto L_0x00b2
        L_0x00ab:
            org.apache.commons.logging.Log r1 = r7.log     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = "Released connection is not reusable."
            r1.debug(r4)     // Catch:{ all -> 0x00bd }
        L_0x00b2:
            r8.detach()     // Catch:{ all -> 0x00bd }
            org.apache.http.impl.conn.tsccm.ConnPoolByRoute r1 = r7.pool     // Catch:{ all -> 0x00bd }
            r4 = r9
            r6 = r11
            r1.freeEntry(r2, r3, r4, r6)     // Catch:{ all -> 0x00bd }
            throw r0     // Catch:{ all -> 0x00bd }
        L_0x00bd:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00bd }
            throw r9
        L_0x00c0:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Connection class mismatch, connection not obtained from this manager."
            r8.<init>(r9)
            goto L_0x00c9
        L_0x00c8:
            throw r8
        L_0x00c9:
            goto L_0x00c8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager.releaseConnection(org.apache.http.conn.ManagedClientConnection, long, java.util.concurrent.TimeUnit):void");
    }

    public void shutdown() {
        this.log.debug("Shutting down");
        this.pool.shutdown();
    }

    public int getConnectionsInPool(HttpRoute httpRoute) {
        return this.pool.getConnectionsInPool(httpRoute);
    }

    public int getConnectionsInPool() {
        return this.pool.getConnectionsInPool();
    }

    public void closeIdleConnections(long j, TimeUnit timeUnit) {
        if (this.log.isDebugEnabled()) {
            Log log2 = this.log;
            log2.debug("Closing connections idle longer than " + j + " " + timeUnit);
        }
        this.pool.closeIdleConnections(j, timeUnit);
    }

    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpiredConnections();
    }

    public int getMaxTotal() {
        return this.pool.getMaxTotalConnections();
    }

    public void setMaxTotal(int i) {
        this.pool.setMaxTotalConnections(i);
    }

    public int getDefaultMaxPerRoute() {
        return this.connPerRoute.getDefaultMaxPerRoute();
    }

    public void setDefaultMaxPerRoute(int i) {
        this.connPerRoute.setDefaultMaxPerRoute(i);
    }

    public int getMaxForRoute(HttpRoute httpRoute) {
        return this.connPerRoute.getMaxForRoute(httpRoute);
    }

    public void setMaxForRoute(HttpRoute httpRoute, int i) {
        this.connPerRoute.setMaxForRoute(httpRoute, i);
    }
}
