package org.apache.http.conn.routing;

import java.net.InetAddress;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.util.LangUtils;

public final class HttpRoute implements RouteInfo, Cloneable {
    private static final HttpHost[] EMPTY_HTTP_HOST_ARRAY = new HttpHost[0];
    private final RouteInfo.LayerType layered;
    private final InetAddress localAddress;
    private final HttpHost[] proxyChain;
    private final boolean secure;
    private final HttpHost targetHost;
    private final RouteInfo.TunnelType tunnelled;

    private HttpRoute(InetAddress inetAddress, HttpHost httpHost, HttpHost[] httpHostArr, boolean z, RouteInfo.TunnelType tunnelType, RouteInfo.LayerType layerType) {
        if (httpHost == null) {
            throw new IllegalArgumentException("Target host may not be null.");
        } else if (httpHostArr == null) {
            throw new IllegalArgumentException("Proxies may not be null.");
        } else if (tunnelType == RouteInfo.TunnelType.TUNNELLED && httpHostArr.length == 0) {
            throw new IllegalArgumentException("Proxy required if tunnelled.");
        } else {
            tunnelType = tunnelType == null ? RouteInfo.TunnelType.PLAIN : tunnelType;
            layerType = layerType == null ? RouteInfo.LayerType.PLAIN : layerType;
            this.targetHost = httpHost;
            this.localAddress = inetAddress;
            this.proxyChain = httpHostArr;
            this.secure = z;
            this.tunnelled = tunnelType;
            this.layered = layerType;
        }
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, HttpHost[] httpHostArr, boolean z, RouteInfo.TunnelType tunnelType, RouteInfo.LayerType layerType) {
        this(inetAddress, httpHost, toChain(httpHostArr), z, tunnelType, layerType);
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, HttpHost httpHost2, boolean z, RouteInfo.TunnelType tunnelType, RouteInfo.LayerType layerType) {
        this(inetAddress, httpHost, toChain(httpHost2), z, tunnelType, layerType);
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, boolean z) {
        this(inetAddress, httpHost, EMPTY_HTTP_HOST_ARRAY, z, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
    }

    public HttpRoute(HttpHost httpHost) {
        this((InetAddress) null, httpHost, EMPTY_HTTP_HOST_ARRAY, false, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRoute(org.apache.http.HttpHost r8, java.net.InetAddress r9, org.apache.http.HttpHost r10, boolean r11) {
        /*
            r7 = this;
            org.apache.http.HttpHost[] r3 = toChain((org.apache.http.HttpHost) r10)
            if (r11 == 0) goto L_0x0009
            org.apache.http.conn.routing.RouteInfo$TunnelType r0 = org.apache.http.conn.routing.RouteInfo.TunnelType.TUNNELLED
            goto L_0x000b
        L_0x0009:
            org.apache.http.conn.routing.RouteInfo$TunnelType r0 = org.apache.http.conn.routing.RouteInfo.TunnelType.PLAIN
        L_0x000b:
            r5 = r0
            if (r11 == 0) goto L_0x0011
            org.apache.http.conn.routing.RouteInfo$LayerType r0 = org.apache.http.conn.routing.RouteInfo.LayerType.LAYERED
            goto L_0x0013
        L_0x0011:
            org.apache.http.conn.routing.RouteInfo$LayerType r0 = org.apache.http.conn.routing.RouteInfo.LayerType.PLAIN
        L_0x0013:
            r6 = r0
            r0 = r7
            r1 = r9
            r2 = r8
            r4 = r11
            r0.<init>((java.net.InetAddress) r1, (org.apache.http.HttpHost) r2, (org.apache.http.HttpHost[]) r3, (boolean) r4, (org.apache.http.conn.routing.RouteInfo.TunnelType) r5, (org.apache.http.conn.routing.RouteInfo.LayerType) r6)
            if (r10 == 0) goto L_0x001e
            return
        L_0x001e:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Proxy host may not be null."
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.conn.routing.HttpRoute.<init>(org.apache.http.HttpHost, java.net.InetAddress, org.apache.http.HttpHost, boolean):void");
    }

    private static HttpHost[] toChain(HttpHost httpHost) {
        if (httpHost == null) {
            return EMPTY_HTTP_HOST_ARRAY;
        }
        return new HttpHost[]{httpHost};
    }

    private static HttpHost[] toChain(HttpHost[] httpHostArr) {
        if (httpHostArr == null || httpHostArr.length < 1) {
            return EMPTY_HTTP_HOST_ARRAY;
        }
        int length = httpHostArr.length;
        int i = 0;
        while (i < length) {
            if (httpHostArr[i] != null) {
                i++;
            } else {
                throw new IllegalArgumentException("Proxy chain may not contain null elements.");
            }
        }
        HttpHost[] httpHostArr2 = new HttpHost[httpHostArr.length];
        System.arraycopy(httpHostArr, 0, httpHostArr2, 0, httpHostArr.length);
        return httpHostArr2;
    }

    public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    public final InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public final int getHopCount() {
        return this.proxyChain.length + 1;
    }

    public final HttpHost getHopTarget(int i) {
        if (i >= 0) {
            int hopCount = getHopCount();
            if (i >= hopCount) {
                throw new IllegalArgumentException("Hop index " + i + " exceeds route length " + hopCount);
            } else if (i < hopCount - 1) {
                return this.proxyChain[i];
            } else {
                return this.targetHost;
            }
        } else {
            throw new IllegalArgumentException("Hop index must not be negative: " + i);
        }
    }

    public final HttpHost getProxyHost() {
        HttpHost[] httpHostArr = this.proxyChain;
        if (httpHostArr.length == 0) {
            return null;
        }
        return httpHostArr[0];
    }

    public final RouteInfo.TunnelType getTunnelType() {
        return this.tunnelled;
    }

    public final boolean isTunnelled() {
        return this.tunnelled == RouteInfo.TunnelType.TUNNELLED;
    }

    public final RouteInfo.LayerType getLayerType() {
        return this.layered;
    }

    public final boolean isLayered() {
        return this.layered == RouteInfo.LayerType.LAYERED;
    }

    public final boolean isSecure() {
        return this.secure;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRoute)) {
            return false;
        }
        HttpRoute httpRoute = (HttpRoute) obj;
        if (this.secure != httpRoute.secure || this.tunnelled != httpRoute.tunnelled || this.layered != httpRoute.layered || !LangUtils.equals((Object) this.targetHost, (Object) httpRoute.targetHost) || !LangUtils.equals((Object) this.localAddress, (Object) httpRoute.localAddress) || !LangUtils.equals((Object[]) this.proxyChain, (Object[]) httpRoute.proxyChain)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = LangUtils.hashCode(LangUtils.hashCode(17, (Object) this.targetHost), (Object) this.localAddress);
        int i = 0;
        while (true) {
            HttpHost[] httpHostArr = this.proxyChain;
            if (i >= httpHostArr.length) {
                return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(hashCode, this.secure), (Object) this.tunnelled), (Object) this.layered);
            }
            hashCode = LangUtils.hashCode(hashCode, (Object) httpHostArr[i]);
            i++;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((getHopCount() * 30) + 50);
        sb.append("HttpRoute[");
        InetAddress inetAddress = this.localAddress;
        if (inetAddress != null) {
            sb.append(inetAddress);
            sb.append("->");
        }
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        if (this.tunnelled == RouteInfo.TunnelType.TUNNELLED) {
            sb.append('t');
        }
        if (this.layered == RouteInfo.LayerType.LAYERED) {
            sb.append('l');
        }
        if (this.secure) {
            sb.append('s');
        }
        sb.append("}->");
        for (HttpHost append : this.proxyChain) {
            sb.append(append);
            sb.append("->");
        }
        sb.append(this.targetHost);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
