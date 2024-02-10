package com.ironsource.sdk.controller;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/ironsource/sdk/controller/JSMethod;", "", "asString", "", "Base", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface q {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ironsource/sdk/controller/JSMethod$Base;", "Lcom/ironsource/sdk/controller/JSMethod;", "funToCall", "", "parameters", "onSuccessCallback", "onFailCallback", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "asString", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements q {
        private final String a;
        private final String b;
        private final String c;
        private final String d;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(String str) {
            this(str, (String) null, (String) null, (String) null, 14);
            Intrinsics.checkNotNullParameter(str, "funToCall");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            this(str, str2, (String) null, (String) null, 12);
            Intrinsics.checkNotNullParameter(str, "funToCall");
        }

        public a(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "funToCall");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        private /* synthetic */ a(String str, String str2, String str3, String str4, int i) {
            this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0079, code lost:
            if ((r1.length() > 0) == true) goto L_0x007d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x007f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String a() {
            /*
                r5 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "SSA_CORE.SDKController.runFunction('"
                r0.<init>(r1)
                java.lang.String r1 = r5.a
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = r5.b
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L_0x0025
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0020
                r1 = 1
                goto L_0x0021
            L_0x0020:
                r1 = 0
            L_0x0021:
                if (r1 != r2) goto L_0x0025
                r1 = 1
                goto L_0x0026
            L_0x0025:
                r1 = 0
            L_0x0026:
                if (r1 == 0) goto L_0x003e
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                java.lang.String r0 = "?parameters="
                r1.append(r0)
                java.lang.String r0 = r5.b
                r1.append(r0)
                java.lang.String r0 = r1.toString()
            L_0x003e:
                java.lang.String r1 = r5.c
                if (r1 == 0) goto L_0x0051
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x004c
                r1 = 1
                goto L_0x004d
            L_0x004c:
                r1 = 0
            L_0x004d:
                if (r1 != r2) goto L_0x0051
                r1 = 1
                goto L_0x0052
            L_0x0051:
                r1 = 0
            L_0x0052:
                java.lang.String r4 = "','"
                if (r1 == 0) goto L_0x006a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                r1.append(r4)
                java.lang.String r0 = r5.c
                r1.append(r0)
                java.lang.String r0 = r1.toString()
            L_0x006a:
                java.lang.String r1 = r5.d
                if (r1 == 0) goto L_0x007c
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0078
                r1 = 1
                goto L_0x0079
            L_0x0078:
                r1 = 0
            L_0x0079:
                if (r1 != r2) goto L_0x007c
                goto L_0x007d
            L_0x007c:
                r2 = 0
            L_0x007d:
                if (r2 == 0) goto L_0x0093
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                r1.append(r4)
                java.lang.String r0 = r5.d
                r1.append(r0)
                java.lang.String r0 = r1.toString()
            L_0x0093:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                java.lang.String r0 = "');"
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.q.a.a():java.lang.String");
        }
    }
}
