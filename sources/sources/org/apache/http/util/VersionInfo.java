package org.apache.http.util;

import java.util.ArrayList;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class VersionInfo {
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";
    private final String infoClassloader;
    private final String infoModule;
    private final String infoPackage;
    private final String infoRelease;
    private final String infoTimestamp;

    protected VersionInfo(String str, String str2, String str3, String str4, String str5) {
        if (str != null) {
            this.infoPackage = str;
            this.infoModule = str2 == null ? UNAVAILABLE : str2;
            this.infoRelease = str3 == null ? UNAVAILABLE : str3;
            this.infoTimestamp = str4 == null ? UNAVAILABLE : str4;
            this.infoClassloader = str5 == null ? UNAVAILABLE : str5;
            return;
        }
        throw new IllegalArgumentException("Package identifier must not be null.");
    }

    public final String getPackage() {
        return this.infoPackage;
    }

    public final String getModule() {
        return this.infoModule;
    }

    public final String getRelease() {
        return this.infoRelease;
    }

    public final String getTimestamp() {
        return this.infoTimestamp;
    }

    public final String getClassloader() {
        return this.infoClassloader;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.infoPackage.length() + 20 + this.infoModule.length() + this.infoRelease.length() + this.infoTimestamp.length() + this.infoClassloader.length());
        stringBuffer.append("VersionInfo(").append(this.infoPackage).append(AbstractJsonLexerKt.COLON).append(this.infoModule);
        if (!UNAVAILABLE.equals(this.infoRelease)) {
            stringBuffer.append(AbstractJsonLexerKt.COLON).append(this.infoRelease);
        }
        if (!UNAVAILABLE.equals(this.infoTimestamp)) {
            stringBuffer.append(AbstractJsonLexerKt.COLON).append(this.infoTimestamp);
        }
        stringBuffer.append(')');
        if (!UNAVAILABLE.equals(this.infoClassloader)) {
            stringBuffer.append('@').append(this.infoClassloader);
        }
        return stringBuffer.toString();
    }

    public static final VersionInfo[] loadVersionInfo(String[] strArr, ClassLoader classLoader) {
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String loadVersionInfo : strArr) {
                VersionInfo loadVersionInfo2 = loadVersionInfo(loadVersionInfo, classLoader);
                if (loadVersionInfo2 != null) {
                    arrayList.add(loadVersionInfo2);
                }
            }
            return (VersionInfo[]) arrayList.toArray(new VersionInfo[arrayList.size()]);
        }
        throw new IllegalArgumentException("Package identifier list must not be null.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.apache.http.util.VersionInfo loadVersionInfo(java.lang.String r5, java.lang.ClassLoader r6) {
        /*
            java.lang.String r0 = "/version.properties"
            if (r5 == 0) goto L_0x004c
            if (r6 != 0) goto L_0x000e
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r6 = r6.getContextClassLoader()
        L_0x000e:
            r1 = 0
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x0043 }
            r2.<init>()     // Catch:{ IOException -> 0x0043 }
            r3 = 46
            r4 = 47
            java.lang.String r3 = r5.replace(r3, r4)     // Catch:{ IOException -> 0x0043 }
            java.lang.StringBuffer r2 = r2.append(r3)     // Catch:{ IOException -> 0x0043 }
            java.lang.StringBuffer r0 = r2.append(r0)     // Catch:{ IOException -> 0x0043 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0043 }
            java.io.InputStream r0 = r6.getResourceAsStream(r0)     // Catch:{ IOException -> 0x0043 }
            if (r0 == 0) goto L_0x0041
            java.util.Properties r2 = new java.util.Properties     // Catch:{ all -> 0x003c }
            r2.<init>()     // Catch:{ all -> 0x003c }
            r2.load(r0)     // Catch:{ all -> 0x003c }
            r0.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x0045
        L_0x003a:
            goto L_0x0045
        L_0x003c:
            r2 = move-exception
            r0.close()     // Catch:{ IOException -> 0x0043 }
            throw r2     // Catch:{ IOException -> 0x0043 }
        L_0x0041:
            r2 = r1
            goto L_0x0045
        L_0x0043:
            goto L_0x0041
        L_0x0045:
            if (r2 == 0) goto L_0x004b
            org.apache.http.util.VersionInfo r1 = fromMap(r5, r2, r6)
        L_0x004b:
            return r1
        L_0x004c:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Package identifier must not be null."
            r5.<init>(r6)
            goto L_0x0055
        L_0x0054:
            throw r5
        L_0x0055:
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.util.VersionInfo.loadVersionInfo(java.lang.String, java.lang.ClassLoader):org.apache.http.util.VersionInfo");
    }

    protected static final VersionInfo fromMap(String str, Map map, ClassLoader classLoader) {
        String str2;
        String str3;
        String str4;
        if (str != null) {
            String str5 = null;
            if (map != null) {
                String str6 = (String) map.get(PROPERTY_MODULE);
                if (str6 != null && str6.length() < 1) {
                    str6 = null;
                }
                String str7 = (String) map.get(PROPERTY_RELEASE);
                if (str7 != null && (str7.length() < 1 || str7.equals("${pom.version}"))) {
                    str7 = null;
                }
                String str8 = (String) map.get(PROPERTY_TIMESTAMP);
                str2 = (str8 == null || (str8.length() >= 1 && !str8.equals("${mvn.timestamp}"))) ? str8 : null;
                str4 = str6;
                str3 = str7;
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
            }
            if (classLoader != null) {
                str5 = classLoader.toString();
            }
            return new VersionInfo(str, str4, str3, str2, str5);
        }
        throw new IllegalArgumentException("Package identifier must not be null.");
    }
}
