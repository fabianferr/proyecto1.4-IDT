package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;

public class SingleClientConnManager implements ClientConnectionManager {
    public static final String MISUSE_MESSAGE = "Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
    protected final boolean alwaysShutDown;
    protected final ClientConnectionOperator connOperator;
    protected long connectionExpiresTime;
    protected volatile boolean isShutDown;
    protected long lastReleaseTime;
    private final Log log;
    protected ConnAdapter managedConn;
    protected final SchemeRegistry schemeRegistry;
    protected PoolEntry uniquePoolEntry;

    @Deprecated
    public SingleClientConnManager(HttpParams httpParams, SchemeRegistry schemeRegistry2) {
        this(schemeRegistry2);
    }

    public SingleClientConnManager(SchemeRegistry schemeRegistry2) {
        this.log = LogFactory.getLog(getClass());
        if (schemeRegistry2 != null) {
            this.schemeRegistry = schemeRegistry2;
            this.connOperator = createConnectionOperator(schemeRegistry2);
            this.uniquePoolEntry = new PoolEntry();
            this.managedConn = null;
            this.lastReleaseTime = -1;
            this.alwaysShutDown = false;
            this.isShutDown = false;
            return;
        }
        throw new IllegalArgumentException("Scheme registry must not be null.");
    }

    public SingleClientConnManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    /* access modifiers changed from: protected */
    public ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry2) {
        return new DefaultClientConnectionOperator(schemeRegistry2);
    }

    /* access modifiers changed from: protected */
    public final void assertStillUp() throws IllegalStateException {
        if (this.isShutDown) {
            throw new IllegalStateException("Manager is shut down.");
        }
    }

    public final ClientConnectionRequest requestConnection(final HttpRoute httpRoute, final Object obj) {
        return new ClientConnectionRequest() {
            public void abortRequest() {
            }

            public ManagedClientConnection getConnection(long j, TimeUnit timeUnit) {
                return SingleClientConnManager.this.getConnection(httpRoute, obj);
            }
        };
    }

    public synchronized ManagedClientConnection getConnection(HttpRoute httpRoute, Object obj) {
        boolean z;
        ConnAdapter connAdapter;
        if (httpRoute != null) {
            try {
                assertStillUp();
                if (this.log.isDebugEnabled()) {
                    Log log2 = this.log;
                    log2.debug("Get connection for route " + httpRoute);
                }
                if (this.managedConn == null) {
                    closeExpiredConnections();
                    boolean z2 = true;
                    boolean z3 = false;
                    if (this.uniquePoolEntry.connection.isOpen()) {
                        RouteTracker routeTracker = this.uniquePoolEntry.tracker;
                        z3 = routeTracker == null || !routeTracker.toRoute().equals(httpRoute);
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z3) {
                        this.uniquePoolEntry.shutdown();
                    } else {
                        z2 = z;
                    }
                    if (z2) {
                        this.uniquePoolEntry = new PoolEntry();
                    }
                    connAdapter = new ConnAdapter(this.uniquePoolEntry, httpRoute);
                    this.managedConn = connAdapter;
                } else {
                    throw new IllegalStateException(MISUSE_MESSAGE);
                }
            } catch (IOException e) {
                this.log.debug("Problem shutting down connection.", e);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Route may not be null.");
        }
        return connAdapter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ab, code lost:
        return;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:43:0x0094=Splitter:B:43:0x0094, B:31:0x0066=Splitter:B:31:0x0066} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void releaseConnection(org.apache.http.conn.ManagedClientConnection r9, long r10, java.util.concurrent.TimeUnit r12) {
        /*
            r8 = this;
            java.lang.String r0 = "Releasing connection "
            monitor-enter(r8)
            r8.assertStillUp()     // Catch:{ all -> 0x00d0 }
            boolean r1 = r9 instanceof org.apache.http.impl.conn.SingleClientConnManager.ConnAdapter     // Catch:{ all -> 0x00d0 }
            if (r1 == 0) goto L_0x00c8
            org.apache.commons.logging.Log r1 = r8.log     // Catch:{ all -> 0x00d0 }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ all -> 0x00d0 }
            if (r1 == 0) goto L_0x0023
            org.apache.commons.logging.Log r1 = r8.log     // Catch:{ all -> 0x00d0 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r2.<init>(r0)     // Catch:{ all -> 0x00d0 }
            r2.append(r9)     // Catch:{ all -> 0x00d0 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00d0 }
            r1.debug(r0)     // Catch:{ all -> 0x00d0 }
        L_0x0023:
            org.apache.http.impl.conn.SingleClientConnManager$ConnAdapter r9 = (org.apache.http.impl.conn.SingleClientConnManager.ConnAdapter) r9     // Catch:{ all -> 0x00d0 }
            org.apache.http.impl.conn.AbstractPoolEntry r0 = r9.poolEntry     // Catch:{ all -> 0x00d0 }
            if (r0 != 0) goto L_0x002b
            monitor-exit(r8)
            return
        L_0x002b:
            org.apache.http.conn.ClientConnectionManager r0 = r9.getManager()     // Catch:{ all -> 0x00d0 }
            if (r0 == 0) goto L_0x003c
            if (r0 != r8) goto L_0x0034
            goto L_0x003c
        L_0x0034:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00d0 }
            java.lang.String r10 = "Connection not obtained from this manager."
            r9.<init>(r10)     // Catch:{ all -> 0x00d0 }
            throw r9     // Catch:{ all -> 0x00d0 }
        L_0x003c:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r2 = 0
            r4 = 0
            boolean r5 = r9.isOpen()     // Catch:{ IOException -> 0x0084 }
            if (r5 == 0) goto L_0x0066
            boolean r5 = r8.alwaysShutDown     // Catch:{ IOException -> 0x0084 }
            if (r5 != 0) goto L_0x0054
            boolean r5 = r9.isMarkedReusable()     // Catch:{ IOException -> 0x0084 }
            if (r5 != 0) goto L_0x0066
        L_0x0054:
            org.apache.commons.logging.Log r5 = r8.log     // Catch:{ IOException -> 0x0084 }
            boolean r5 = r5.isDebugEnabled()     // Catch:{ IOException -> 0x0084 }
            if (r5 == 0) goto L_0x0063
            org.apache.commons.logging.Log r5 = r8.log     // Catch:{ IOException -> 0x0084 }
            java.lang.String r6 = "Released connection open but not reusable."
            r5.debug(r6)     // Catch:{ IOException -> 0x0084 }
        L_0x0063:
            r9.shutdown()     // Catch:{ IOException -> 0x0084 }
        L_0x0066:
            r9.detach()     // Catch:{ all -> 0x00d0 }
            r8.managedConn = r4     // Catch:{ all -> 0x00d0 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d0 }
            r8.lastReleaseTime = r4     // Catch:{ all -> 0x00d0 }
            int r9 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r9 <= 0) goto L_0x007f
            long r9 = r12.toMillis(r10)     // Catch:{ all -> 0x00d0 }
            long r11 = r8.lastReleaseTime     // Catch:{ all -> 0x00d0 }
        L_0x007b:
            long r9 = r9 + r11
            r8.connectionExpiresTime = r9     // Catch:{ all -> 0x00d0 }
            goto L_0x00aa
        L_0x007f:
            r8.connectionExpiresTime = r0     // Catch:{ all -> 0x00d0 }
            goto L_0x00aa
        L_0x0082:
            r5 = move-exception
            goto L_0x00ac
        L_0x0084:
            r5 = move-exception
            org.apache.commons.logging.Log r6 = r8.log     // Catch:{ all -> 0x0082 }
            boolean r6 = r6.isDebugEnabled()     // Catch:{ all -> 0x0082 }
            if (r6 == 0) goto L_0x0094
            org.apache.commons.logging.Log r6 = r8.log     // Catch:{ all -> 0x0082 }
            java.lang.String r7 = "Exception shutting down released connection."
            r6.debug(r7, r5)     // Catch:{ all -> 0x0082 }
        L_0x0094:
            r9.detach()     // Catch:{ all -> 0x00d0 }
            r8.managedConn = r4     // Catch:{ all -> 0x00d0 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d0 }
            r8.lastReleaseTime = r4     // Catch:{ all -> 0x00d0 }
            int r9 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r9 <= 0) goto L_0x007f
            long r9 = r12.toMillis(r10)     // Catch:{ all -> 0x00d0 }
            long r11 = r8.lastReleaseTime     // Catch:{ all -> 0x00d0 }
            goto L_0x007b
        L_0x00aa:
            monitor-exit(r8)
            return
        L_0x00ac:
            r9.detach()     // Catch:{ all -> 0x00d0 }
            r8.managedConn = r4     // Catch:{ all -> 0x00d0 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d0 }
            r8.lastReleaseTime = r6     // Catch:{ all -> 0x00d0 }
            int r9 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c5
            long r9 = r12.toMillis(r10)     // Catch:{ all -> 0x00d0 }
            long r11 = r8.lastReleaseTime     // Catch:{ all -> 0x00d0 }
            long r9 = r9 + r11
            r8.connectionExpiresTime = r9     // Catch:{ all -> 0x00d0 }
            goto L_0x00c7
        L_0x00c5:
            r8.connectionExpiresTime = r0     // Catch:{ all -> 0x00d0 }
        L_0x00c7:
            throw r5     // Catch:{ all -> 0x00d0 }
        L_0x00c8:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00d0 }
            java.lang.String r10 = "Connection class mismatch, connection not obtained from this manager."
            r9.<init>(r10)     // Catch:{ all -> 0x00d0 }
            throw r9     // Catch:{ all -> 0x00d0 }
        L_0x00d0:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x00d4
        L_0x00d3:
            throw r9
        L_0x00d4:
            goto L_0x00d3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.SingleClientConnManager.releaseConnection(org.apache.http.conn.ManagedClientConnection, long, java.util.concurrent.TimeUnit):void");
    }

    public synchronized void closeExpiredConnections() {
        if (System.currentTimeMillis() >= this.connectionExpiresTime) {
            closeIdleConnections(0, TimeUnit.MILLISECONDS);
        }
    }

    public synchronized void closeIdleConnections(long j, TimeUnit timeUnit) {
        assertStillUp();
        if (timeUnit == null) {
            throw new IllegalArgumentException("Time unit must not be null.");
        } else if (this.managedConn == null && this.uniquePoolEntry.connection.isOpen()) {
            if (this.lastReleaseTime <= System.currentTimeMillis() - timeUnit.toMillis(j)) {
                try {
                    this.uniquePoolEntry.close();
                } catch (IOException e) {
                    this.log.debug("Problem closing idle connection.", e);
                }
            }
        }
        return;
    }

    public synchronized void shutdown() {
        this.isShutDown = true;
        ConnAdapter connAdapter = this.managedConn;
        if (connAdapter != null) {
            connAdapter.detach();
        }
        try {
            PoolEntry poolEntry = this.uniquePoolEntry;
            if (poolEntry != null) {
                poolEntry.shutdown();
            }
        } catch (IOException e) {
            try {
                this.log.debug("Problem while shutting down manager.", e);
            } catch (Throwable th) {
                this.uniquePoolEntry = null;
                throw th;
            }
        }
        this.uniquePoolEntry = null;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public synchronized void revokeConnection() {
        ConnAdapter connAdapter = this.managedConn;
        if (connAdapter != null) {
            connAdapter.detach();
            try {
                this.uniquePoolEntry.shutdown();
            } catch (IOException e) {
                this.log.debug("Problem while shutting down connection.", e);
            }
        } else {
            return;
        }
        return;
    }

    protected class PoolEntry extends AbstractPoolEntry {
        protected PoolEntry() {
            super(SingleClientConnManager.this.connOperator, (HttpRoute) null);
        }

        /* access modifiers changed from: protected */
        public void close() throws IOException {
            shutdownEntry();
            if (this.connection.isOpen()) {
                this.connection.close();
            }
        }

        /* access modifiers changed from: protected */
        public void shutdown() throws IOException {
            shutdownEntry();
            if (this.connection.isOpen()) {
                this.connection.shutdown();
            }
        }
    }

    protected class ConnAdapter extends AbstractPooledConnAdapter {
        protected ConnAdapter(PoolEntry poolEntry, HttpRoute httpRoute) {
            super(SingleClientConnManager.this, poolEntry);
            markReusable();
            poolEntry.route = httpRoute;
        }
    }
}
