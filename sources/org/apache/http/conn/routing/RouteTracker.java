package org.apache.http.conn.routing;

import java.net.InetAddress;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.util.LangUtils;

public final class RouteTracker implements RouteInfo, Cloneable {
    private boolean connected;
    private RouteInfo.LayerType layered;
    private final InetAddress localAddress;
    private HttpHost[] proxyChain;
    private boolean secure;
    private final HttpHost targetHost;
    private RouteInfo.TunnelType tunnelled;

    public RouteTracker(HttpHost httpHost, InetAddress inetAddress) {
        if (httpHost != null) {
            this.targetHost = httpHost;
            this.localAddress = inetAddress;
            this.tunnelled = RouteInfo.TunnelType.PLAIN;
            this.layered = RouteInfo.LayerType.PLAIN;
            return;
        }
        throw new IllegalArgumentException("Target host may not be null.");
    }

    public RouteTracker(HttpRoute httpRoute) {
        this(httpRoute.getTargetHost(), httpRoute.getLocalAddress());
    }

    public final void connectTarget(boolean z) {
        if (!this.connected) {
            this.connected = true;
            this.secure = z;
            return;
        }
        throw new IllegalStateException("Already connected.");
    }

    public final void connectProxy(HttpHost httpHost, boolean z) {
        if (httpHost == null) {
            throw new IllegalArgumentException("Proxy host may not be null.");
        } else if (!this.connected) {
            this.connected = true;
            this.proxyChain = new HttpHost[]{httpHost};
            this.secure = z;
        } else {
            throw new IllegalStateException("Already connected.");
        }
    }

    public final void tunnelTarget(boolean z) {
        if (!this.connected) {
            throw new IllegalStateException("No tunnel unless connected.");
        } else if (this.proxyChain != null) {
            this.tunnelled = RouteInfo.TunnelType.TUNNELLED;
            this.secure = z;
        } else {
            throw new IllegalStateException("No tunnel without proxy.");
        }
    }

    public final void tunnelProxy(HttpHost httpHost, boolean z) {
        if (httpHost == null) {
            throw new IllegalArgumentException("Proxy host may not be null.");
        } else if (this.connected) {
            HttpHost[] httpHostArr = this.proxyChain;
            if (httpHostArr != null) {
                int length = httpHostArr.length + 1;
                HttpHost[] httpHostArr2 = new HttpHost[length];
                System.arraycopy(httpHostArr, 0, httpHostArr2, 0, httpHostArr.length);
                httpHostArr2[length - 1] = httpHost;
                this.proxyChain = httpHostArr2;
                this.secure = z;
                return;
            }
            throw new IllegalStateException("No proxy tunnel without proxy.");
        } else {
            throw new IllegalStateException("No tunnel unless connected.");
        }
    }

    public final void layerProtocol(boolean z) {
        if (this.connected) {
            this.layered = RouteInfo.LayerType.LAYERED;
            this.secure = z;
            return;
        }
        throw new IllegalStateException("No layered protocol unless connected.");
    }

    public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    public final InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public final int getHopCount() {
        if (!this.connected) {
            return 0;
        }
        HttpHost[] httpHostArr = this.proxyChain;
        if (httpHostArr == null) {
            return 1;
        }
        return 1 + httpHostArr.length;
    }

    public final HttpHost getHopTarget(int i) {
        if (i >= 0) {
            int hopCount = getHopCount();
            if (i >= hopCount) {
                throw new IllegalArgumentException("Hop index " + i + " exceeds tracked route length " + hopCount + ".");
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
        if (httpHostArr == null) {
            return null;
        }
        return httpHostArr[0];
    }

    public final boolean isConnected() {
        return this.connected;
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

    public final HttpRoute toRoute() {
        if (!this.connected) {
            return null;
        }
        return new HttpRoute(this.targetHost, this.localAddress, this.proxyChain, this.secure, this.tunnelled, this.layered);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteTracker)) {
            return false;
        }
        RouteTracker routeTracker = (RouteTracker) obj;
        if (this.connected == routeTracker.connected && this.secure == routeTracker.secure && this.tunnelled == routeTracker.tunnelled && this.layered == routeTracker.layered && LangUtils.equals((Object) this.targetHost, (Object) routeTracker.targetHost) && LangUtils.equals((Object) this.localAddress, (Object) routeTracker.localAddress) && LangUtils.equals((Object[]) this.proxyChain, (Object[]) routeTracker.proxyChain)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = LangUtils.hashCode(LangUtils.hashCode(17, (Object) this.targetHost), (Object) this.localAddress);
        if (this.proxyChain != null) {
            int i = 0;
            while (true) {
                HttpHost[] httpHostArr = this.proxyChain;
                if (i >= httpHostArr.length) {
                    break;
                }
                hashCode = LangUtils.hashCode(hashCode, (Object) httpHostArr[i]);
                i++;
            }
        }
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(hashCode, this.connected), this.secure), (Object) this.tunnelled), (Object) this.layered);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((getHopCount() * 30) + 50);
        sb.append("RouteTracker[");
        InetAddress inetAddress = this.localAddress;
        if (inetAddress != null) {
            sb.append(inetAddress);
            sb.append("->");
        }
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        if (this.connected) {
            sb.append('c');
        }
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
        if (this.proxyChain != null) {
            int i = 0;
            while (true) {
                HttpHost[] httpHostArr = this.proxyChain;
                if (i >= httpHostArr.length) {
                    break;
                }
                sb.append(httpHostArr[i]);
                sb.append("->");
                i++;
            }
        }
        sb.append(this.targetHost);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
