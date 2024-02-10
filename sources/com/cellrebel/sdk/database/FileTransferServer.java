package com.cellrebel.sdk.database;

public class FileTransferServer {
    public long a;
    public String b;

    public long a() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public boolean a(Object obj) {
        return obj instanceof FileTransferServer;
    }

    public String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileTransferServer)) {
            return false;
        }
        FileTransferServer fileTransferServer = (FileTransferServer) obj;
        if (!fileTransferServer.a(this) || a() != fileTransferServer.a()) {
            return false;
        }
        String b2 = b();
        String b3 = fileTransferServer.b();
        return b2 != null ? b2.equals(b3) : b3 == null;
    }

    public int hashCode() {
        long a2 = a();
        String b2 = b();
        return ((((int) (a2 ^ (a2 >>> 32))) + 59) * 59) + (b2 == null ? 43 : b2.hashCode());
    }

    public String toString() {
        return "FileTransferServer(id=" + a() + ", url=" + b() + ")";
    }
}
