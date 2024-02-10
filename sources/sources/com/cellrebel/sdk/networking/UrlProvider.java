package com.cellrebel.sdk.networking;

public class UrlProvider {
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0048, code lost:
        r0 = r6.reportingUrl;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(com.cellrebel.sdk.networking.beans.response.Settings r6) {
        /*
            if (r6 == 0) goto L_0x0046
            java.lang.String r0 = r6.secondaryReportingUrls
            if (r0 == 0) goto L_0x0046
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0046
            java.lang.String r0 = r6.secondaryReportingUrls
            java.lang.String r1 = ";"
            java.lang.String[] r0 = r0.split(r1)
            com.cellrebel.sdk.utils.TrackingHelper r1 = com.cellrebel.sdk.utils.TrackingHelper.a()
            android.content.Context r2 = com.cellrebel.sdk.workers.TrackingManager.getContext()
            java.lang.String r1 = r1.l(r2)
            if (r1 == 0) goto L_0x0046
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0046
            int r2 = r0.length
            r3 = 0
        L_0x002a:
            if (r3 >= r2) goto L_0x0046
            r4 = r0[r3]
            boolean r5 = r4.contains(r1)
            if (r5 == 0) goto L_0x0043
            java.lang.String r5 = ","
            java.lang.String[] r4 = r4.split(r5)
            int r5 = r4.length
            if (r5 <= 0) goto L_0x0043
            int r6 = r4.length
            int r6 = r6 + -1
            r6 = r4[r6]
            return r6
        L_0x0043:
            int r3 = r3 + 1
            goto L_0x002a
        L_0x0046:
            if (r6 == 0) goto L_0x0056
            java.lang.String r0 = r6.reportingUrl
            if (r0 == 0) goto L_0x0056
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0053
            goto L_0x0056
        L_0x0053:
            java.lang.String r6 = r6.reportingUrl
            return r6
        L_0x0056:
            java.lang.String r6 = "https://metricreceiver.cellrebel.com/"
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.networking.UrlProvider.a(com.cellrebel.sdk.networking.beans.response.Settings):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r1.settingsUrl;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(com.cellrebel.sdk.networking.beans.response.Settings r1) {
        /*
            if (r1 == 0) goto L_0x0010
            java.lang.String r0 = r1.settingsUrl
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x000d
            goto L_0x0010
        L_0x000d:
            java.lang.String r1 = r1.settingsUrl
            return r1
        L_0x0010:
            java.lang.String r1 = "https://metricreceiver.cellrebel.com/"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.networking.UrlProvider.b(com.cellrebel.sdk.networking.beans.response.Settings):java.lang.String");
    }
}
