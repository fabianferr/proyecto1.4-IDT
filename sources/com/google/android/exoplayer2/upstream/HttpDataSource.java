package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HttpDataSource extends DataSource {
    public static final Predicate<String> REJECT_PAYWALL_TYPES = new HttpDataSource$$ExternalSyntheticLambda0();

    public interface Factory extends DataSource.Factory {

        @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
        /* renamed from: com.google.android.exoplayer2.upstream.HttpDataSource$Factory$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        HttpDataSource createDataSource();

        @Deprecated
        RequestProperties getDefaultRequestProperties();

        Factory setDefaultRequestProperties(Map<String, String> map);
    }

    void clearAllRequestProperties();

    void clearRequestProperty(String str);

    void close() throws HttpDataSourceException;

    int getResponseCode();

    Map<String, List<String>> getResponseHeaders();

    long open(DataSpec dataSpec) throws HttpDataSourceException;

    int read(byte[] bArr, int i, int i2) throws HttpDataSourceException;

    void setRequestProperty(String str, String str2);

    public static final class RequestProperties {
        private final Map<String, String> requestProperties = new HashMap();
        private Map<String, String> requestPropertiesSnapshot;

        public synchronized void set(String str, String str2) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.put(str, str2);
        }

        public synchronized void set(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.putAll(map);
        }

        public synchronized void clearAndSet(Map<String, String> map) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
            this.requestProperties.putAll(map);
        }

        public synchronized void remove(String str) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.remove(str);
        }

        public synchronized void clear() {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.clear();
        }

        public synchronized Map<String, String> getSnapshot() {
            if (this.requestPropertiesSnapshot == null) {
                this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
            }
            return this.requestPropertiesSnapshot;
        }
    }

    public static abstract class BaseFactory implements Factory {
        private final RequestProperties defaultRequestProperties = new RequestProperties();

        /* access modifiers changed from: protected */
        public abstract HttpDataSource createDataSourceInternal(RequestProperties requestProperties);

        public final HttpDataSource createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }

        @Deprecated
        public final RequestProperties getDefaultRequestProperties() {
            return this.defaultRequestProperties;
        }

        public final Factory setDefaultRequestProperties(Map<String, String> map) {
            this.defaultRequestProperties.clearAndSet(map);
            return this;
        }
    }

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.android.exoplayer2.upstream.HttpDataSource$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            Predicate<String> predicate = HttpDataSource.REJECT_PAYWALL_TYPES;
        }

        public static /* synthetic */ boolean lambda$static$0(String str) {
            if (str == null) {
                return false;
            }
            String lowerCase = Ascii.toLowerCase(str);
            if (TextUtils.isEmpty(lowerCase)) {
                return false;
            }
            if ((!lowerCase.contains("text") || lowerCase.contains("text/vtt")) && !lowerCase.contains("html") && !lowerCase.contains("xml")) {
                return true;
            }
            return false;
        }
    }

    public static class HttpDataSourceException extends DataSourceException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final DataSpec dataSpec;
        public final int type;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        private static int assignErrorCode(int i, int i2) {
            if (i == 2000 && i2 == 1) {
                return 2001;
            }
            return i;
        }

        public static HttpDataSourceException createForIOException(IOException iOException, DataSpec dataSpec2, int i) {
            int i2;
            String message = iOException.getMessage();
            if (iOException instanceof SocketTimeoutException) {
                i2 = 2002;
            } else if (iOException instanceof InterruptedIOException) {
                i2 = 1004;
            } else {
                i2 = (message == null || !Ascii.toLowerCase(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
            }
            if (i2 == 2007) {
                return new CleartextNotPermittedException(iOException, dataSpec2);
            }
            return new HttpDataSourceException(iOException, dataSpec2, i2, i);
        }

        @Deprecated
        public HttpDataSourceException(DataSpec dataSpec2, int i) {
            this(dataSpec2, 2000, i);
        }

        public HttpDataSourceException(DataSpec dataSpec2, int i, int i2) {
            super(assignErrorCode(i, i2));
            this.dataSpec = dataSpec2;
            this.type = i2;
        }

        @Deprecated
        public HttpDataSourceException(String str, DataSpec dataSpec2, int i) {
            this(str, dataSpec2, 2000, i);
        }

        public HttpDataSourceException(String str, DataSpec dataSpec2, int i, int i2) {
            super(str, assignErrorCode(i, i2));
            this.dataSpec = dataSpec2;
            this.type = i2;
        }

        @Deprecated
        public HttpDataSourceException(IOException iOException, DataSpec dataSpec2, int i) {
            this(iOException, dataSpec2, 2000, i);
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec2, int i, int i2) {
            super((Throwable) iOException, assignErrorCode(i, i2));
            this.dataSpec = dataSpec2;
            this.type = i2;
        }

        @Deprecated
        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec2, int i) {
            this(str, iOException, dataSpec2, 2000, i);
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec2, int i, int i2) {
            super(str, iOException, assignErrorCode(i, i2));
            this.dataSpec = dataSpec2;
            this.type = i2;
        }
    }

    public static final class CleartextNotPermittedException extends HttpDataSourceException {
        public CleartextNotPermittedException(IOException iOException, DataSpec dataSpec) {
            super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, dataSpec, 2007, 1);
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InvalidContentTypeException(java.lang.String r4, com.google.android.exoplayer2.upstream.DataSpec r5) {
            /*
                r3 = this;
                java.lang.String r0 = java.lang.String.valueOf(r4)
                int r1 = r0.length()
                java.lang.String r2 = "Invalid content type: "
                if (r1 == 0) goto L_0x0011
                java.lang.String r0 = r2.concat(r0)
                goto L_0x0016
            L_0x0011:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r2)
            L_0x0016:
                r1 = 2003(0x7d3, float:2.807E-42)
                r2 = 1
                r3.<init>((java.lang.String) r0, (com.google.android.exoplayer2.upstream.DataSpec) r5, (int) r1, (int) r2)
                r3.contentType = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.HttpDataSource.InvalidContentTypeException.<init>(java.lang.String, com.google.android.exoplayer2.upstream.DataSpec):void");
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;
        public final String responseMessage;

        @Deprecated
        public InvalidResponseCodeException(int i, Map<String, List<String>> map, DataSpec dataSpec) {
            this(i, (String) null, (IOException) null, map, dataSpec, Util.EMPTY_BYTE_ARRAY);
        }

        @Deprecated
        public InvalidResponseCodeException(int i, String str, Map<String, List<String>> map, DataSpec dataSpec) {
            this(i, str, (IOException) null, map, dataSpec, Util.EMPTY_BYTE_ARRAY);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InvalidResponseCodeException(int r9, java.lang.String r10, java.io.IOException r11, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r12, com.google.android.exoplayer2.upstream.DataSpec r13, byte[] r14) {
            /*
                r8 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 26
                r0.<init>(r1)
                java.lang.String r1 = "Response code: "
                r0.append(r1)
                r0.append(r9)
                java.lang.String r3 = r0.toString()
                r6 = 2004(0x7d4, float:2.808E-42)
                r7 = 1
                r2 = r8
                r4 = r11
                r5 = r13
                r2.<init>(r3, r4, r5, r6, r7)
                r8.responseCode = r9
                r8.responseMessage = r10
                r8.headerFields = r12
                r8.responseBody = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException.<init>(int, java.lang.String, java.io.IOException, java.util.Map, com.google.android.exoplayer2.upstream.DataSpec, byte[]):void");
        }
    }
}
