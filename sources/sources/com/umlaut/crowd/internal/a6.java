package com.umlaut.crowd.internal;

import android.util.Log;
import com.umlaut.crowd.InsightCore;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;

public class a6 {
    private static final String e = "a6";
    private static final boolean f = false;
    private static final int g = 10000;
    private static final String h = "\r\n";
    private final String a;
    private HttpURLConnection b;
    private OutputStream c = this.b.getOutputStream();
    private PrintWriter d = new PrintWriter(new OutputStreamWriter(this.c, "UTF-8"), true);

    public a6(String str) throws IOException {
        String str2 = "bp3b" + System.currentTimeMillis();
        this.a = str2;
        HttpURLConnection a2 = j3.a(str, 10000, InsightCore.getInsightConfig().v0());
        this.b = a2;
        a2.setUseCaches(false);
        this.b.setDoOutput(true);
        this.b.setDoInput(true);
        this.b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str2);
        this.b.setRequestProperty("User-Agent", "c0nnectthed0ts");
    }

    public void a(String str, File file) throws IOException {
        String name = file.getName();
        PrintWriter printWriter = this.d;
        printWriter.append("--" + this.a);
        this.d.append(h);
        PrintWriter printWriter2 = this.d;
        printWriter2.append("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + name + "\"");
        this.d.append(h);
        this.d.append("Content-Type: application/octet-stream");
        this.d.append(h);
        this.d.append("Content-Transfer-Encoding: binary");
        this.d.append(h);
        this.d.append(h);
        this.d.flush();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                this.c.write(bArr, 0, read);
            } else {
                this.c.flush();
                fileInputStream.close();
                this.d.flush();
                return;
            }
        }
    }

    public boolean a() throws IOException {
        this.d.append(h);
        PrintWriter printWriter = this.d;
        printWriter.append("--" + this.a + "--");
        this.d.append(h);
        this.d.flush();
        this.d.close();
        int responseCode = this.b.getResponseCode();
        if (responseCode != 200) {
            this.b.disconnect();
            String str = e;
            Log.e(str, "Transfer failed. HTTP code: " + responseCode);
            return false;
        } else if (this.b.getHeaderField("MovedFileTo") != null) {
            return true;
        } else {
            return false;
        }
    }
}
