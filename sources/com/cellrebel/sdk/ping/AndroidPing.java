package com.cellrebel.sdk.ping;

import android.net.Network;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructPollfd;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class AndroidPing implements Runnable {
    private static final String g = "AndroidPing";
    protected static final short h;
    private final InetAddress a;
    private int b = 4000;
    private int c = 1000;
    private EchoPacketBuilder d;
    private Network e;
    public long f = 0;

    public interface PingListener {
    }

    static {
        int i = OsConstants.POLLIN;
        if (i == 0) {
            i = 1;
        }
        h = (short) i;
    }

    public AndroidPing(InetAddress inetAddress) {
        this.a = inetAddress;
        a(new EchoPacketBuilder(inetAddress instanceof Inet6Address ? Byte.MIN_VALUE : 8, "abcdefghijklmnopqrstuvwabcdefghi".getBytes()));
    }

    /* access modifiers changed from: protected */
    public int a(FileDescriptor fileDescriptor, ByteBuffer byteBuffer) {
        return Os.sendto(fileDescriptor, byteBuffer, 0, this.a, 7);
    }

    /* access modifiers changed from: protected */
    public int a(StructPollfd[] structPollfdArr) {
        return Os.poll(structPollfdArr, this.b);
    }

    /* access modifiers changed from: protected */
    public long a(long j, long j2) {
        return j2 - j;
    }

    /* access modifiers changed from: protected */
    public FileDescriptor a(int i, int i2) {
        return Os.socket(i, OsConstants.SOCK_DGRAM, i2);
    }

    public void a(int i) {
        if (i >= 0) {
            this.b = i;
            return;
        }
        throw new IllegalArgumentException("Timeout must not be negative: " + i);
    }

    public void a(EchoPacketBuilder echoPacketBuilder) {
        this.d = echoPacketBuilder;
    }

    /* access modifiers changed from: protected */
    public void a(FileDescriptor fileDescriptor) {
        Os.close(fileDescriptor);
    }

    /* access modifiers changed from: protected */
    public void b(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 26) {
            Os.setsockoptInt(fileDescriptor, OsConstants.IPPROTO_IP, OsConstants.IP_TOS, 16);
            return;
        }
        Class<Os> cls = Os.class;
        try {
            Class cls2 = Integer.TYPE;
            cls.getMethod("setsockoptInt", new Class[]{FileDescriptor.class, cls2, cls2, cls2}).invoke((Object) null, new Object[]{fileDescriptor, Integer.valueOf(OsConstants.IPPROTO_IP), Integer.valueOf(OsConstants.IP_TOS), 16});
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            Log.e(g, "Could not setsockOptInt()", e2);
        }
    }

    public void run() {
        int i;
        int i2;
        Network network;
        if (this.a instanceof Inet6Address) {
            i2 = OsConstants.AF_INET6;
            i = OsConstants.IPPROTO_ICMPV6;
        } else {
            i2 = OsConstants.AF_INET;
            i = OsConstants.IPPROTO_ICMP;
        }
        try {
            FileDescriptor a2 = a(i2, i);
            if (a2.valid()) {
                try {
                    if (Build.VERSION.SDK_INT >= 23 && (network = this.e) != null) {
                        network.bindSocket(a2);
                    }
                    b(a2);
                    StructPollfd structPollfd = new StructPollfd();
                    structPollfd.fd = a2;
                    short s = h;
                    structPollfd.events = s;
                    StructPollfd[] structPollfdArr = {structPollfd};
                    ByteBuffer a3 = this.d.a();
                    byte[] bArr = new byte[a3.limit()];
                    long currentTimeMillis = System.currentTimeMillis();
                    if (a(a2, a3) >= 0) {
                        int a4 = a(structPollfdArr);
                        long a5 = a(currentTimeMillis, System.currentTimeMillis());
                        if (a4 >= 0 && structPollfd.revents == s) {
                            structPollfd.revents = 0;
                            this.f = a5;
                        }
                    }
                } catch (ErrnoException e2) {
                    e2.toString();
                } catch (Throwable th) {
                    a(a2);
                    throw th;
                }
                a(a2);
            }
        } catch (ErrnoException | IOException e3) {
            e3.toString();
        }
    }
}
