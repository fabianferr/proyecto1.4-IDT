package com.cellrebel.sdk.ping;

import android.content.Context;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.regex.Pattern;

public class IPTools {
    private static final Pattern a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    private IPTools() {
    }

    public static String a(Context context) {
        return "";
    }

    public static String a(String str) {
        try {
            return InetAddress.getByName(new URL(str).getHost()).getHostAddress();
        } catch (MalformedURLException | UnknownHostException unused) {
            return "";
        }
    }

    public static ArrayList<InetAddress> a() {
        ArrayList<InetAddress> arrayList = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        arrayList.add(nextElement);
                    }
                }
            }
        } catch (SocketException unused) {
        }
        return arrayList;
    }

    public static String b(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException unused) {
            return "";
        }
    }

    public static boolean c(String str) {
        return str != null && a.matcher(str).matches();
    }

    public static boolean d(String str) {
        return str != null && (f(str) || e(str));
    }

    public static boolean e(String str) {
        return str != null && c.matcher(str).matches();
    }

    public static boolean f(String str) {
        return str != null && b.matcher(str).matches();
    }
}
