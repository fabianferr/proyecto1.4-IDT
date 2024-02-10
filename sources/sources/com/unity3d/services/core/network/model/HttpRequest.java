package com.unity3d.services.core.network.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 ?2\u00020\u0001:\u0001?B©\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\t\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010¢\u0006\u0002\u0010\u0015J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0010HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001b\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\tHÆ\u0003J\u0015\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010&J²\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\t2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0010HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0014\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0011\u0010\u0012\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001d¨\u0006@"}, d2 = {"Lcom/unity3d/services/core/network/model/HttpRequest;", "", "baseURL", "", "path", "method", "Lcom/unity3d/services/core/network/model/RequestType;", "body", "headers", "", "", "parameters", "bodyType", "Lcom/unity3d/services/core/network/model/BodyType;", "scheme", "port", "", "connectTimeout", "readTimeout", "writeTimeout", "callTimeout", "(Ljava/lang/String;Ljava/lang/String;Lcom/unity3d/services/core/network/model/RequestType;Ljava/lang/Object;Ljava/util/Map;Ljava/util/Map;Lcom/unity3d/services/core/network/model/BodyType;Ljava/lang/String;Ljava/lang/Integer;IIII)V", "getBaseURL", "()Ljava/lang/String;", "getBody", "()Ljava/lang/Object;", "getBodyType", "()Lcom/unity3d/services/core/network/model/BodyType;", "getCallTimeout", "()I", "getConnectTimeout", "getHeaders", "()Ljava/util/Map;", "getMethod", "()Lcom/unity3d/services/core/network/model/RequestType;", "getParameters", "getPath", "getPort", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReadTimeout", "getScheme", "getWriteTimeout", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/unity3d/services/core/network/model/RequestType;Ljava/lang/Object;Ljava/util/Map;Ljava/util/Map;Lcom/unity3d/services/core/network/model/BodyType;Ljava/lang/String;Ljava/lang/Integer;IIII)Lcom/unity3d/services/core/network/model/HttpRequest;", "equals", "", "other", "hashCode", "toString", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpRequest.kt */
public final class HttpRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_SCHEME = "https";
    private static final int DEFAULT_TIMEOUT = 30000;
    private final String baseURL;
    private final Object body;
    private final BodyType bodyType;
    private final int callTimeout;
    private final int connectTimeout;
    private final Map<String, List<String>> headers;
    private final RequestType method;
    private final Map<String, String> parameters;
    private final String path;
    private final Integer port;
    private final int readTimeout;
    private final String scheme;
    private final int writeTimeout;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8190(0x1ffe, float:1.1477E-41)
            r16 = 0
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8188(0x1ffc, float:1.1474E-41)
            r16 = 0
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8184(0x1ff8, float:1.1468E-41)
            r16 = 0
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8176(0x1ff0, float:1.1457E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8160(0x1fe0, float:1.1435E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8128(0x1fc0, float:1.139E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23, com.unity3d.services.core.network.model.BodyType r24) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "bodyType"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 8064(0x1f80, float:1.13E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23, com.unity3d.services.core.network.model.BodyType r24, java.lang.String r25) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "bodyType"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "scheme"
            r9 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 7936(0x1f00, float:1.1121E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23, com.unity3d.services.core.network.model.BodyType r24, java.lang.String r25, java.lang.Integer r26) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "bodyType"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "scheme"
            r9 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 7680(0x1e00, float:1.0762E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r10 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType, java.lang.String, java.lang.Integer):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23, com.unity3d.services.core.network.model.BodyType r24, java.lang.String r25, java.lang.Integer r26, int r27) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "bodyType"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "scheme"
            r9 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 7168(0x1c00, float:1.0045E-41)
            r16 = 0
            r1 = r17
            r5 = r21
            r10 = r26
            r11 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType, java.lang.String, java.lang.Integer, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23, com.unity3d.services.core.network.model.BodyType r24, java.lang.String r25, java.lang.Integer r26, int r27, int r28) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "bodyType"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "scheme"
            r9 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r13 = 0
            r14 = 0
            r15 = 6144(0x1800, float:8.61E-42)
            r16 = 0
            r1 = r17
            r5 = r21
            r10 = r26
            r11 = r27
            r12 = r28
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType, java.lang.String, java.lang.Integer, int, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequest(java.lang.String r18, java.lang.String r19, com.unity3d.services.core.network.model.RequestType r20, java.lang.Object r21, java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r22, java.util.Map<java.lang.String, java.lang.String> r23, com.unity3d.services.core.network.model.BodyType r24, java.lang.String r25, java.lang.Integer r26, int r27, int r28, int r29) {
        /*
            r17 = this;
            java.lang.String r0 = "baseURL"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "path"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "method"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "headers"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parameters"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "bodyType"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "scheme"
            r9 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r14 = 0
            r15 = 4096(0x1000, float:5.74E-42)
            r16 = 0
            r1 = r17
            r5 = r21
            r10 = r26
            r11 = r27
            r12 = r28
            r13 = r29
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType, java.lang.String, java.lang.Integer, int, int, int):void");
    }

    public static /* synthetic */ HttpRequest copy$default(HttpRequest httpRequest, String str, String str2, RequestType requestType, Object obj, Map map, Map map2, BodyType bodyType2, String str3, Integer num, int i, int i2, int i3, int i4, int i5, Object obj2) {
        HttpRequest httpRequest2 = httpRequest;
        int i6 = i5;
        return httpRequest.copy((i6 & 1) != 0 ? httpRequest2.baseURL : str, (i6 & 2) != 0 ? httpRequest2.path : str2, (i6 & 4) != 0 ? httpRequest2.method : requestType, (i6 & 8) != 0 ? httpRequest2.body : obj, (i6 & 16) != 0 ? httpRequest2.headers : map, (i6 & 32) != 0 ? httpRequest2.parameters : map2, (i6 & 64) != 0 ? httpRequest2.bodyType : bodyType2, (i6 & 128) != 0 ? httpRequest2.scheme : str3, (i6 & 256) != 0 ? httpRequest2.port : num, (i6 & 512) != 0 ? httpRequest2.connectTimeout : i, (i6 & 1024) != 0 ? httpRequest2.readTimeout : i2, (i6 & 2048) != 0 ? httpRequest2.writeTimeout : i3, (i6 & 4096) != 0 ? httpRequest2.callTimeout : i4);
    }

    public final String component1() {
        return this.baseURL;
    }

    public final int component10() {
        return this.connectTimeout;
    }

    public final int component11() {
        return this.readTimeout;
    }

    public final int component12() {
        return this.writeTimeout;
    }

    public final int component13() {
        return this.callTimeout;
    }

    public final String component2() {
        return this.path;
    }

    public final RequestType component3() {
        return this.method;
    }

    public final Object component4() {
        return this.body;
    }

    public final Map<String, List<String>> component5() {
        return this.headers;
    }

    public final Map<String, String> component6() {
        return this.parameters;
    }

    public final BodyType component7() {
        return this.bodyType;
    }

    public final String component8() {
        return this.scheme;
    }

    public final Integer component9() {
        return this.port;
    }

    public final HttpRequest copy(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2, String str3, Integer num, int i, int i2, int i3, int i4) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "baseURL");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str5, "path");
        RequestType requestType2 = requestType;
        Intrinsics.checkNotNullParameter(requestType2, FirebaseAnalytics.Param.METHOD);
        Map<String, ? extends List<String>> map3 = map;
        Intrinsics.checkNotNullParameter(map3, "headers");
        Map<String, String> map4 = map2;
        Intrinsics.checkNotNullParameter(map4, "parameters");
        BodyType bodyType3 = bodyType2;
        Intrinsics.checkNotNullParameter(bodyType3, "bodyType");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "scheme");
        return new HttpRequest(str4, str5, requestType2, obj, map3, map4, bodyType3, str6, num, i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRequest)) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        return Intrinsics.areEqual((Object) this.baseURL, (Object) httpRequest.baseURL) && Intrinsics.areEqual((Object) this.path, (Object) httpRequest.path) && this.method == httpRequest.method && Intrinsics.areEqual(this.body, httpRequest.body) && Intrinsics.areEqual((Object) this.headers, (Object) httpRequest.headers) && Intrinsics.areEqual((Object) this.parameters, (Object) httpRequest.parameters) && this.bodyType == httpRequest.bodyType && Intrinsics.areEqual((Object) this.scheme, (Object) httpRequest.scheme) && Intrinsics.areEqual((Object) this.port, (Object) httpRequest.port) && this.connectTimeout == httpRequest.connectTimeout && this.readTimeout == httpRequest.readTimeout && this.writeTimeout == httpRequest.writeTimeout && this.callTimeout == httpRequest.callTimeout;
    }

    public int hashCode() {
        int hashCode = ((((this.baseURL.hashCode() * 31) + this.path.hashCode()) * 31) + this.method.hashCode()) * 31;
        Object obj = this.body;
        int i = 0;
        int hashCode2 = (((((((((hashCode + (obj == null ? 0 : obj.hashCode())) * 31) + this.headers.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.bodyType.hashCode()) * 31) + this.scheme.hashCode()) * 31;
        Integer num = this.port;
        if (num != null) {
            i = num.hashCode();
        }
        return ((((((((hashCode2 + i) * 31) + this.connectTimeout) * 31) + this.readTimeout) * 31) + this.writeTimeout) * 31) + this.callTimeout;
    }

    public String toString() {
        return "HttpRequest(baseURL=" + this.baseURL + ", path=" + this.path + ", method=" + this.method + ", body=" + this.body + ", headers=" + this.headers + ", parameters=" + this.parameters + ", bodyType=" + this.bodyType + ", scheme=" + this.scheme + ", port=" + this.port + ", connectTimeout=" + this.connectTimeout + ", readTimeout=" + this.readTimeout + ", writeTimeout=" + this.writeTimeout + ", callTimeout=" + this.callTimeout + ')';
    }

    public HttpRequest(String str, String str2, RequestType requestType, Object obj, Map<String, ? extends List<String>> map, Map<String, String> map2, BodyType bodyType2, String str3, Integer num, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "baseURL");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestType, FirebaseAnalytics.Param.METHOD);
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "parameters");
        Intrinsics.checkNotNullParameter(bodyType2, "bodyType");
        Intrinsics.checkNotNullParameter(str3, "scheme");
        this.baseURL = str;
        this.path = str2;
        this.method = requestType;
        this.body = obj;
        this.headers = map;
        this.parameters = map2;
        this.bodyType = bodyType2;
        this.scheme = str3;
        this.port = num;
        this.connectTimeout = i;
        this.readTimeout = i2;
        this.writeTimeout = i3;
        this.callTimeout = i4;
    }

    public final String getBaseURL() {
        return this.baseURL;
    }

    public final String getPath() {
        return this.path;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HttpRequest(java.lang.String r14, java.lang.String r15, com.unity3d.services.core.network.model.RequestType r16, java.lang.Object r17, java.util.Map r18, java.util.Map r19, com.unity3d.services.core.network.model.BodyType r20, java.lang.String r21, java.lang.Integer r22, int r23, int r24, int r25, int r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r13 = this;
            r0 = r27
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = ""
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0011
            com.unity3d.services.core.network.model.RequestType r2 = com.unity3d.services.core.network.model.RequestType.GET
            goto L_0x0013
        L_0x0011:
            r2 = r16
        L_0x0013:
            r3 = r0 & 8
            r4 = 0
            if (r3 == 0) goto L_0x001a
            r3 = r4
            goto L_0x001c
        L_0x001a:
            r3 = r17
        L_0x001c:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0025
            java.util.Map r5 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x0027
        L_0x0025:
            r5 = r18
        L_0x0027:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0030
            java.util.Map r6 = kotlin.collections.MapsKt.emptyMap()
            goto L_0x0032
        L_0x0030:
            r6 = r19
        L_0x0032:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0039
            com.unity3d.services.core.network.model.BodyType r7 = com.unity3d.services.core.network.model.BodyType.UNKNOWN
            goto L_0x003b
        L_0x0039:
            r7 = r20
        L_0x003b:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0042
            java.lang.String r8 = "https"
            goto L_0x0044
        L_0x0042:
            r8 = r21
        L_0x0044:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r4 = r22
        L_0x004b:
            r9 = r0 & 512(0x200, float:7.175E-43)
            r10 = 30000(0x7530, float:4.2039E-41)
            if (r9 == 0) goto L_0x0054
            r9 = 30000(0x7530, float:4.2039E-41)
            goto L_0x0056
        L_0x0054:
            r9 = r23
        L_0x0056:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x005d
            r11 = 30000(0x7530, float:4.2039E-41)
            goto L_0x005f
        L_0x005d:
            r11 = r24
        L_0x005f:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0066
            r12 = 30000(0x7530, float:4.2039E-41)
            goto L_0x0068
        L_0x0066:
            r12 = r25
        L_0x0068:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r10 = r26
        L_0x006f:
            r15 = r13
            r16 = r14
            r17 = r1
            r18 = r2
            r19 = r3
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r4
            r25 = r9
            r26 = r11
            r27 = r12
            r28 = r10
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.model.HttpRequest.<init>(java.lang.String, java.lang.String, com.unity3d.services.core.network.model.RequestType, java.lang.Object, java.util.Map, java.util.Map, com.unity3d.services.core.network.model.BodyType, java.lang.String, java.lang.Integer, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final RequestType getMethod() {
        return this.method;
    }

    public final Object getBody() {
        return this.body;
    }

    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    public final BodyType getBodyType() {
        return this.bodyType;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final Integer getPort() {
        return this.port;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    public final int getCallTimeout() {
        return this.callTimeout;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/unity3d/services/core/network/model/HttpRequest$Companion;", "", "()V", "DEFAULT_SCHEME", "", "DEFAULT_TIMEOUT", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HttpRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
