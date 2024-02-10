package com.umlaut.crowd.internal;

import com.facebook.internal.security.OidcSecurityUtil;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.timeserver.TimeServer;
import com.umlaut.crowd.utils.JsonUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.security.Signature;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class w0 {
    private static final String a = "w0";
    private static final boolean b = false;
    private static final String c = "cdnconfig.txt";
    private static final String d = "cdnconfig.txt.sig";
    private static final int e = 10000;

    public static void a() {
        InputStream inputStream;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = j3.a(InsightCore.getInsightConfig().M().replace("[PROJECTID]", InsightCore.getInsightConfig().f1()), 10000, InsightCore.getInsightConfig().v0());
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setRequestProperty("If-Modified-Since", i1.b(InsightCore.getInsightSettings().h()));
            httpURLConnection.setRequestProperty("Connection", "close");
            if (httpURLConnection.getResponseCode() == 304) {
                InsightCore.getInsightSettings().d(TimeServer.getTimeInMillis());
            } else if (httpURLConnection.getResponseCode() == 200) {
                long lastModified = httpURLConnection.getLastModified();
                inputStream = httpURLConnection.getInputStream();
                boolean a2 = a(inputStream);
                inputStream.close();
                if (a2) {
                    InsightCore.getInsightSettings().d(TimeServer.getTimeInMillis());
                    InsightCore.getInsightSettings().a(lastModified);
                } else {
                    throw new IOException("Verification of downloaded cdn config failed");
                }
            }
        } catch (IOException unused) {
            if (httpURLConnection == null) {
                return;
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        httpURLConnection.disconnect();
    }

    private static boolean a(InputStream inputStream) throws IOException {
        CCI cci;
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        byte[] bArr = new byte[512];
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                } else if (!nextEntry.isDirectory()) {
                    if (nextEntry.getName().equalsIgnoreCase(c)) {
                        for (int read = zipInputStream.read(bArr); read != -1; read = zipInputStream.read(bArr)) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        zipInputStream.closeEntry();
                    } else if (nextEntry.getName().equalsIgnoreCase(d)) {
                        for (int read2 = zipInputStream.read(bArr); read2 != -1; read2 = zipInputStream.read(bArr)) {
                            byteArrayOutputStream2.write(bArr, 0, read2);
                        }
                        byteArrayOutputStream2.flush();
                        zipInputStream.closeEntry();
                    }
                }
            } finally {
                zipInputStream.close();
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
        boolean a2 = a(byteArrayOutputStream, byteArrayOutputStream2);
        if (a2 && (cci = (CCI) JsonUtils.fromJson(new String(byteArrayOutputStream.toByteArray(), "UTF-8"), CCI.class)) != null) {
            IS insightSettings = InsightCore.getInsightSettings();
            insightSettings.a((Set<String>) null);
            insightSettings.b((Set<String>) new HashSet(Arrays.asList(cci.ct.cdn)));
            insightSettings.d(cci.ct.criteria);
            insightSettings.c((Set<String>) new HashSet(Arrays.asList(cci.ltr.cdn)));
            insightSettings.e(cci.ltr.criteria);
        }
        return a2;
    }

    private static boolean a(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2) {
        try {
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            Signature instance = Signature.getInstance(OidcSecurityUtil.SIGNATURE_ALGORITHM_SHA256);
            instance.initVerify(InsightCore.getPublicKey());
            instance.update(byteArray2);
            return instance.verify(byteArray);
        } catch (Exception unused) {
            return false;
        }
    }
}
