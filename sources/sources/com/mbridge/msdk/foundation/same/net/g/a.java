package com.mbridge.msdk.foundation.same.net.g;

/* compiled from: CommonHttpConfig */
public final class a {
    public static String a(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        if (aVar == null) {
            return "Network error,Load failed";
        }
        try {
            int i = aVar.a;
            int i2 = aVar.b != null ? aVar.b.a : 0;
            if (i == -2) {
                return "Network is canceled";
            }
            switch (i) {
                case 1:
                    return "Network error,Load failed";
                case 2:
                    return "Network error,I/O exception";
                case 3:
                    return "Network error,timeout exception";
                case 4:
                    return "Network unknown error";
                case 5:
                    return "Network error，https is not work,please check your phone time";
                case 6:
                    if (i2 == 0) {
                        return "Network error,please check ";
                    }
                    return "Network error,please check state code " + i2;
                case 7:
                    if (i2 == 0) {
                        return "The server returns an exception ";
                    }
                    return "The server returns an exception state code " + i2;
                case 8:
                    return "Cast exception, return data can not be casted correctly";
                case 9:
                    return "Network error,UnknownHostException";
                case 10:
                    return "Network error,socket timeout exception";
                case 11:
                    return "Network error，sslp exception";
                case 12:
                    return "Network error,ConnectException";
                case 13:
                    if (aVar.b == null) {
                        return "Unknown socket exception";
                    }
                    byte[] bArr = aVar.b.b;
                    return bArr != null ? new String(bArr) : "Socket exception message is NULL";
                case 14:
                    return "Network error,I/O exception response null";
                case 15:
                    return "Network error,I/O exception contents null";
                default:
                    return "Network error,unknown";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Network error,Load failed";
        }
    }
}
