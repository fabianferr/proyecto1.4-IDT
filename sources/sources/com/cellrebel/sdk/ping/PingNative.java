package com.cellrebel.sdk.ping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class PingNative {
    private PingNative() {
    }

    public static PingResult a(PingResult pingResult, String str) {
        String str2 = "unknown host";
        if (!str.contains(str2)) {
            if (str.contains("0% packet loss")) {
                int indexOf = str.indexOf("/mdev = ");
                int indexOf2 = str.indexOf(" ms\n", indexOf);
                pingResult.e = str;
                if (indexOf == -1 || indexOf2 == -1) {
                    str2 = "Error: " + str;
                } else {
                    String substring = str.substring(indexOf + 8, indexOf2);
                    String[] split = substring.split("/");
                    pingResult.b = true;
                    pingResult.f = substring;
                    pingResult.d = Float.parseFloat(split[1]);
                    return pingResult;
                }
            } else {
                str2 = "100% packet loss";
                if (!str.contains(str2)) {
                    str2 = str.contains("% packet loss") ? "partial packet loss" : "unknown error in getPingStats";
                }
            }
        }
        pingResult.c = str2;
        return pingResult;
    }

    public static PingResult a(InetAddress inetAddress, PingOptions pingOptions) {
        PingResult pingResult = new PingResult(inetAddress);
        if (inetAddress == null) {
            pingResult.b = false;
            return pingResult;
        }
        StringBuilder sb = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();
        int max = Math.max(pingOptions.b() / 1000, 1);
        int max2 = Math.max(pingOptions.a(), 1);
        String hostAddress = inetAddress.getHostAddress();
        String str = "ping";
        if (hostAddress == null) {
            hostAddress = inetAddress.getHostName();
        } else if (IPTools.d(hostAddress)) {
            str = "ping6";
        } else {
            IPTools.c(hostAddress);
        }
        Process exec = runtime.exec(str + " -c 1 -W " + max + " -t " + max2 + " " + hostAddress);
        exec.waitFor();
        int exitValue = exec.exitValue();
        if (exitValue != 0) {
            pingResult.c = exitValue != 1 ? "error, exit = 2" : "failed, exit = 1";
            exec.destroy();
            return pingResult;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return a(pingResult, sb.toString());
            }
            sb.append(readLine);
            sb.append("\n");
        }
    }
}
