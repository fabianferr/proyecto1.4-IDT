package com.umlaut.crowd.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.facebook.internal.security.OidcSecurityUtil;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.timeserver.TimeServer;
import com.umlaut.crowd.utils.JsonUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.security.Signature;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class t {
    private static final String a = "t";
    private static final boolean b = false;
    private static final int c = 10000;
    private static final String d = "prefbt";
    private static final String e = "INS_PFK_BACKGROUNDTESTS";
    private static final String f = "INS_PFK_BACKGROUNDTESTS_CONFIG_LAST_MODIFIED";
    private static final String g = "INS_PFK_BACKGROUNDTESTS_CONFIG_LAST_CHECK";
    private static final String h = "INS_PFK_BACKGROUNDTESTS_INITIAL_CONFIG";
    private static final String i = "testconfig.json";
    private static final String j = "testconfig.json.sig";

    public static void a(Context context, BGTS bgts) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(d, 0);
        String a2 = a((Object) bgts);
        if (sharedPreferences != null && a2 != null) {
            sharedPreferences.edit().putString(e, a2).commit();
        }
    }

    private static void b(Context context, long j2) {
        context.getSharedPreferences(d, 0).edit().putLong(f, j2).commit();
    }

    public static String c(Context context) {
        return context.getSharedPreferences(d, 0).getString(h, "");
    }

    public static BGTS d(Context context) {
        String string = context.getSharedPreferences(d, 0).getString(e, "");
        BGTS a2 = !string.isEmpty() ? a(string) : null;
        if (a2 != null) {
            return a2;
        }
        b(context, 0);
        return a();
    }

    public static long b(Context context) {
        return context.getSharedPreferences(d, 0).getLong(f, 0);
    }

    private static void b(Context context, String str) {
        context.getSharedPreferences(d, 0).edit().putString(h, str).commit();
    }

    private static String a(Object obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 11);
        } catch (Exception e2) {
            String str = a;
            Log.e(str, "toBase64String: " + e2.toString(), e2);
            return "";
        }
    }

    private static BGTS a(String str) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str, 11)));
            BGTS bgts = (BGTS) objectInputStream.readObject();
            objectInputStream.close();
            return bgts;
        } catch (Exception e2) {
            String str2 = a;
            Log.e(str2, "loadFromBase64: " + e2.toString(), e2);
            return null;
        }
    }

    public static void a(Context context, String str) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = j3.a(str, 10000, InsightCore.getInsightConfig().v0());
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setRequestProperty("If-Modified-Since", i1.b(b(context)));
            httpURLConnection.setRequestProperty("Connection", "close");
            if (httpURLConnection.getResponseCode() == 304) {
                a(context, TimeServer.getTimeInMillis());
            } else if (httpURLConnection.getResponseCode() == 200) {
                long lastModified = httpURLConnection.getLastModified();
                inputStream = httpURLConnection.getInputStream();
                boolean a2 = a(context, inputStream);
                inputStream.close();
                if (a2) {
                    a(context, TimeServer.getTimeInMillis());
                    b(context, lastModified);
                } else {
                    throw new IOException("Verification of downloaded test config failed");
                }
            }
        } catch (Exception e2) {
            try {
                Log.e(a, e2.getMessage(), e2);
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    private static boolean a(Context context, InputStream inputStream) throws IOException {
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
                    if (nextEntry.getName().equalsIgnoreCase(i)) {
                        for (int read = zipInputStream.read(bArr); read != -1; read = zipInputStream.read(bArr)) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        zipInputStream.closeEntry();
                    } else if (nextEntry.getName().equalsIgnoreCase(j)) {
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
        if (a2) {
            String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            BGTS bgts = (BGTS) JsonUtils.fromJson(str, BGTS.class, true);
            if (bgts != null && bgts.Version == 3) {
                bgts.Hash = str.hashCode();
                a(context, bgts);
                if (c(context).isEmpty()) {
                    b(context, bgts.Id + "");
                }
            }
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

    private static BGTS a() {
        BGTS bgts = new BGTS();
        bgts.Id = 0;
        bgts.Hash = 0;
        return bgts;
    }

    public static long a(Context context) {
        return context.getSharedPreferences(d, 0).getLong(g, 0);
    }

    private static void a(Context context, long j2) {
        context.getSharedPreferences(d, 0).edit().putLong(g, j2).commit();
    }
}
