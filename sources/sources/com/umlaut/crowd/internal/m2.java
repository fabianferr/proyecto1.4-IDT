package com.umlaut.crowd.internal;

import com.umlaut.crowd.internal.na;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.security.InvalidParameterException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class m2 implements AutoCloseable {
    private na a;
    private Socket b;
    private String c;
    private SocketChannel d;
    private p2 e = null;
    private u2 f = null;
    private String g = "";
    private int h = 0;
    private o2 i;
    private boolean j = false;
    private r9 k = null;

    public m2(na naVar) throws IOException {
        this.a = naVar;
        if (naVar.e() != null) {
            this.c = naVar.e().ips[0];
        } else {
            ka kaVar = naVar.customServer;
            if (kaVar != null) {
                this.c = kaVar.server;
            } else {
                throw new InvalidParameterException("No server defined");
            }
        }
        this.i = new o2(naVar);
    }

    public void a(q2 q2Var) {
        this.i.a(q2Var);
    }

    public void close() throws IOException {
        this.i.a();
        r9 r9Var = this.k;
        if (r9Var != null) {
            synchronized (r9Var) {
                this.k.close();
            }
        }
        if (this.b != null) {
            SocketChannel socketChannel = this.d;
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                this.d = null;
            }
            p2 p2Var = this.e;
            if (p2Var != null) {
                try {
                    p2Var.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                this.e = null;
            }
            u2 u2Var = this.f;
            if (u2Var != null) {
                try {
                    u2Var.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                this.f = null;
            }
            Socket socket = this.b;
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                this.b = null;
            }
        }
    }

    public void g() throws IOException {
        if (this.a.controlEncryption.equals(na.a.IMPLICIT)) {
            try {
                this.b = y8.a(this.c, 990);
                this.j = true;
            } catch (KeyManagementException | NoSuchAlgorithmException e2) {
                throw new IOException("Cannot initilize SSL", e2);
            }
        } else {
            this.b = new Socket(this.c, 21);
        }
        this.b.setKeepAlive(true);
        this.f = new u2(this.b.getOutputStream());
        p2 p2Var = new p2(this.b.getInputStream());
        this.e = p2Var;
        n2 a2 = n2.a(p2Var);
        if (a2 == null || !a2.a().equals("220")) {
            throw new IOException("unexpected FTP answer after initial connect: " + a2);
        }
        if (this.a.controlEncryption.equals(na.a.EXPLICIT)) {
            n2 a3 = a(new n2("AUTH", SSLSocketFactory.TLS));
            if (!a3.a().equals("234")) {
                n2 a4 = a(new n2("AUTH", SSLSocketFactory.SSL));
                if (!a4.a().equals("234")) {
                    throw new IOException("unexpected FTP answer after AUTH commands: " + a3 + ", " + a4);
                }
            }
            try {
                this.b = y8.a(this.b, this.b.getInetAddress().getHostName(), this.b.getPort(), true);
                this.f = new u2(this.b.getOutputStream());
                this.e = new p2(this.b.getInputStream());
                this.j = true;
            } catch (KeyManagementException | NoSuchAlgorithmException e3) {
                throw new IOException("Cannot initilize SSL", e3);
            }
        }
        n2 a5 = a(new n2("USER", this.a.username));
        if (a5.a().equals("331")) {
            n2 a6 = a(new n2("PASS", this.a.password));
            if (a6.a().equals("230")) {
                n2 a7 = a(new n2("TYPE", "I"));
                if (a7.a().equals("200")) {
                    if (this.a.dataEncryption.equals(na.b.PRIVATE) && this.j) {
                        n2 a8 = a(new n2("PBSZ", "0"));
                        if (a8.a().equals("200")) {
                            n2 a9 = a(new n2("PROT", "P"));
                            if (!a9.a().equals("200")) {
                                throw new IOException("unexpected FTP answer after PROT P command: " + a9);
                            }
                        } else {
                            throw new IOException("unexpected FTP answer after PBSZ 0 command: " + a8);
                        }
                    }
                    n2 a10 = a(new n2("EPSV", ""));
                    if (!a10.a().equals("229")) {
                        n2 a11 = a(new n2("PASV", ""));
                        if (a11.a().equals("227")) {
                            String a12 = a(a11.b());
                            if (a12 != null) {
                                String[] split = a12.split(",");
                                if (split.length == 6) {
                                    this.g = split[0] + "." + split[1] + "." + split[2] + "." + split[3];
                                    this.h = (Integer.parseInt(split[4]) * 256) + Integer.parseInt(split[5]);
                                    return;
                                }
                                throw new IOException("unexpected FTP answer after PASV command: " + a11);
                            }
                            throw new IOException("unexpected FTP answer after PASV command: " + a11);
                        }
                        throw new IOException("unexpected FTP answer after PASV command: " + a11);
                    }
                    String a13 = a(a10.b());
                    if (a13 != null) {
                        String[] split2 = a13.split("\\|");
                        if (split2.length == 4) {
                            this.g = this.c;
                            this.h = Integer.parseInt(split2[3]);
                            return;
                        }
                        throw new IOException("unexpected FTP answer after EPSV command: " + a10);
                    }
                    throw new IOException("unexpected FTP answer after TYPE EPSV command: " + a10);
                }
                throw new IOException("unexpected FTP answer after TYPE I command: " + a7);
            }
            throw new IOException("unexpected FTP answer after PASS command: " + a6);
        }
        throw new IOException("unexpected FTP answer after USER command: " + a5);
    }

    public void h() throws IOException {
        n2 a2 = a(new n2("NOOP", ""));
        if (!a2.a().equals("200")) {
            throw new IOException("unexpected FTP answer after NOOP command: " + a2);
        }
    }

    public void i() throws IOException {
        na naVar = this.a;
        String str = naVar.uuid;
        ka kaVar = naVar.customServer;
        if (kaVar != null) {
            str = kaVar.file;
            if (this.i.c()) {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                str = ((str + "_" + simpleDateFormat.format(date)) + "_" + this.a.uuid) + "_" + ((int) (Math.random() * 2.147483646E9d));
            }
        }
        try {
            s9 s9Var = new s9(SocketChannel.open());
            this.k = s9Var;
            s9Var.c().configureBlocking(true);
            if (this.k.c().connect(new InetSocketAddress(this.g, this.h))) {
                if (!this.a.controlEncryption.equals(na.a.NONE) && this.a.dataEncryption.equals(na.b.PRIVATE)) {
                    this.k.c().configureBlocking(false);
                    x8 x8Var = new x8((s9) this.k);
                    this.k = x8Var;
                    x8 x8Var2 = x8Var;
                    x8Var.a(y8.a());
                }
                this.k.c().configureBlocking(false);
                if (this.i.c()) {
                    n2 a2 = a(new n2("STOR", str));
                    if (!a2.a().equals("150")) {
                        throw new IOException("unexpected FTP answer after STOR command: " + a2);
                    }
                } else {
                    n2 a3 = a(new n2("RETR", str));
                    if (!a3.a().equals("150")) {
                        throw new IOException("unexpected FTP answer after RETR command: " + a3);
                    }
                }
                while (!this.k.d()) {
                }
                this.i.a(this.k);
                r9 r9Var = this.k;
                if (r9Var != null) {
                    synchronized (r9Var) {
                        r9 r9Var2 = this.k;
                        if (r9Var2 != null) {
                            try {
                                r9Var2.e();
                                this.k.f();
                                this.k.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            this.k = null;
                        }
                    }
                }
                if (this.i.c()) {
                    n2 a4 = n2.a(this.e);
                    if (!a4.a().startsWith("2")) {
                        throw new IOException("unexpected FTP answer after aborting transmission : " + a4);
                    }
                } else {
                    n2 a5 = n2.a(this.e);
                    if (!a5.a().startsWith("4")) {
                        throw new IOException("unexpected FTP answer after aborting transmission : " + a5);
                    }
                }
                if (this.a.customServer != null) {
                    this.d = null;
                    if (this.i.c()) {
                        n2 a6 = a(new n2("DELE", str));
                        if (!a6.a().equals("250")) {
                            throw new IOException("unexpected FTP answer after DELE command: " + a6);
                        }
                    }
                }
                n2.a(this.f, new n2("QUIT", ""));
                do {
                    try {
                    } catch (Exception unused) {
                        return;
                    }
                } while (!n2.a(this.e).a().equals("221"));
                return;
            }
            throw new IOException("Cannot connect to passive Port");
        } catch (KeyManagementException | NoSuchAlgorithmException e3) {
            throw new IOException("Cannot initialize SSL", e3);
        } catch (Throwable th) {
            r9 r9Var3 = this.k;
            if (r9Var3 != null) {
                synchronized (r9Var3) {
                    r9 r9Var4 = this.k;
                    if (r9Var4 != null) {
                        try {
                            r9Var4.e();
                            this.k.f();
                            this.k.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        this.k = null;
                    }
                }
            }
            throw th;
        }
    }

    private synchronized n2 a(n2 n2Var) throws IOException {
        n2.a(this.f, n2Var);
        return n2.a(this.e);
    }

    private String a(String str) {
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(41, indexOf);
        if (indexOf2 > 0) {
            return str.substring(indexOf, indexOf2);
        }
        return null;
    }
}
