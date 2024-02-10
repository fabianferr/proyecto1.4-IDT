package org.apache.http.impl.client.cache;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.Locale;

class BasicIdGenerator {
    private long count;
    private final String hostname;
    private final SecureRandom rnd;

    public BasicIdGenerator() {
        String str;
        try {
            str = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException unused) {
            str = "localhost";
        }
        this.hostname = str;
        try {
            SecureRandom instance = SecureRandom.getInstance("SHA1PRNG");
            this.rnd = instance;
            instance.setSeed(System.currentTimeMillis());
        } catch (NoSuchAlgorithmException e) {
            throw new Error(e);
        }
    }

    public synchronized void generate(StringBuilder sb) {
        this.count++;
        int nextInt = this.rnd.nextInt();
        sb.append(System.currentTimeMillis());
        sb.append('.');
        new Formatter(sb, Locale.US).format("%1$016x-%2$08x", new Object[]{Long.valueOf(this.count), Integer.valueOf(nextInt)});
        sb.append('.');
        sb.append(this.hostname);
    }

    public String generate() {
        StringBuilder sb = new StringBuilder();
        generate(sb);
        return sb.toString();
    }
}
