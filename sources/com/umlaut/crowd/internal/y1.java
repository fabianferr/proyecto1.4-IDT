package com.umlaut.crowd.internal;

import android.os.AsyncTask;

public class y1 {
    private static final String a = "y1";
    private static final boolean b = false;
    private static final String c = "https://iceportal.de/api1/rs/status";
    private static final String d = "https://portal.imice.de/api1/rs/status";
    private static final String e = "https://iceportal.de/api1/rs/tripInfo/trip";

    private class a extends AsyncTask<Void, Void, x1> {
        private p3 a;

        public a(p3 p3Var) {
            this.a = p3Var;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public x1 doInBackground(Void... voidArr) {
            return y1.a();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(x1 x1Var) {
            p3 p3Var = this.a;
            if (p3Var != null) {
                p3Var.a(x1Var);
            }
        }
    }

    private class b extends AsyncTask<Void, Void, q4> {
        private q3 a;

        public b(q3 q3Var) {
            this.a = q3Var;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public q4 doInBackground(Void... voidArr) {
            return y1.b();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(q4 q4Var) {
            q3 q3Var = this.a;
            if (q3Var != null) {
                q3Var.a(q4Var);
            }
        }
    }

    public static q4 b() {
        q4 a2 = a(c);
        return a2 == null ? a(d) : a2;
    }

    public void a(q3 q3Var) {
        new b(q3Var).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0073 A[Catch:{ g4 | IOException -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c6 A[Catch:{ g4 | IOException -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0124 A[SYNTHETIC, Splitter:B:70:0x0124] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0141 A[SYNTHETIC, Splitter:B:75:0x0141] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.umlaut.crowd.internal.x1 a() {
        /*
            java.lang.String r0 = "getDbIceTripInfo. Closing JSONStreamReader failed: "
            r1 = 0
            com.umlaut.crowd.net.WebApiClient$RequestMethod r2 = com.umlaut.crowd.net.WebApiClient.RequestMethod.GET     // Catch:{ IOException -> 0x015d }
            java.lang.String r3 = "https://iceportal.de/api1/rs/tripInfo/trip"
            com.umlaut.crowd.net.WebApiResponse r2 = com.umlaut.crowd.net.WebApiClient.sendJsonRequest(r2, r3)     // Catch:{ IOException -> 0x015d }
            int r3 = r2.responseCode
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x015c
            com.umlaut.crowd.internal.x1 r3 = new com.umlaut.crowd.internal.x1
            r3.<init>()
            com.umlaut.crowd.internal.k4 r4 = new com.umlaut.crowd.internal.k4     // Catch:{ g4 -> 0x0106, IOException -> 0x0104, all -> 0x0100 }
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch:{ g4 -> 0x0106, IOException -> 0x0104, all -> 0x0100 }
            java.lang.String r2 = r2.content     // Catch:{ g4 -> 0x0106, IOException -> 0x0104, all -> 0x0100 }
            java.lang.String r6 = "UTF-8"
            byte[] r2 = r2.getBytes(r6)     // Catch:{ g4 -> 0x0106, IOException -> 0x0104, all -> 0x0100 }
            r5.<init>(r2)     // Catch:{ g4 -> 0x0106, IOException -> 0x0104, all -> 0x0100 }
            r4.<init>(r5)     // Catch:{ g4 -> 0x0106, IOException -> 0x0104, all -> 0x0100 }
            r4.H()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            r2 = 1
            r5 = 1
        L_0x002d:
            boolean r6 = r4.p()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            if (r6 == 0) goto L_0x00df
            if (r5 == 0) goto L_0x00df
            java.lang.String r6 = r4.q()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            int r7 = r6.hashCode()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            r8 = 117290(0x1ca2a, float:1.64358E-40)
            r9 = 2
            r10 = 0
            if (r7 == r8) goto L_0x0065
            r8 = 904376674(0x35e7b162, float:1.7262466E-6)
            if (r7 == r8) goto L_0x005a
            r8 = 1714491344(0x66310fd0, float:2.0903764E23)
            if (r7 == r8) goto L_0x004f
            goto L_0x0070
        L_0x004f:
            java.lang.String r7 = "stopInfo"
            boolean r6 = r6.equals(r7)     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            if (r6 == 0) goto L_0x0070
            r6 = 2
            goto L_0x0071
        L_0x005a:
            java.lang.String r7 = "trainType"
            boolean r6 = r6.equals(r7)     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            if (r6 == 0) goto L_0x0070
            r6 = 0
            goto L_0x0071
        L_0x0065:
            java.lang.String r7 = "vzn"
            boolean r6 = r6.equals(r7)     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            if (r6 == 0) goto L_0x0070
            r6 = 1
            goto L_0x0071
        L_0x0070:
            r6 = -1
        L_0x0071:
            if (r6 == 0) goto L_0x00c6
            if (r6 == r2) goto L_0x00af
            if (r6 == r9) goto L_0x007b
            r4.E()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            goto L_0x002d
        L_0x007b:
            r4.H()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
        L_0x007e:
            boolean r6 = r4.p()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            if (r6 == 0) goto L_0x009b
            java.lang.String r6 = r4.q()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            java.lang.String r7 = "finalStationName"
            boolean r6 = r6.equals(r7)     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            if (r6 == 0) goto L_0x0097
            java.lang.String r6 = r4.z()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            r3.FinalStationName = r6     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            goto L_0x007e
        L_0x0097:
            r4.E()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            goto L_0x007e
        L_0x009b:
            r4.l()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            java.lang.String r6 = r3.TrainType     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            int r6 = r6.length()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            if (r6 <= 0) goto L_0x002d
            java.lang.String r6 = r3.Vzn     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            int r6 = r6.length()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            if (r6 <= 0) goto L_0x002d
            goto L_0x00dc
        L_0x00af:
            java.lang.String r6 = r4.z()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            r3.Vzn = r6     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            java.lang.String r6 = r3.FinalStationName     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            int r6 = r6.length()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            if (r6 <= 0) goto L_0x002d
            java.lang.String r6 = r3.TrainType     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            int r6 = r6.length()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            if (r6 <= 0) goto L_0x002d
            goto L_0x00dc
        L_0x00c6:
            java.lang.String r6 = r4.z()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            r3.TrainType = r6     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            java.lang.String r6 = r3.FinalStationName     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            int r6 = r6.length()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            if (r6 <= 0) goto L_0x002d
            java.lang.String r6 = r3.Vzn     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            int r6 = r6.length()     // Catch:{ g4 -> 0x00fe, IOException -> 0x00fc }
            if (r6 <= 0) goto L_0x002d
        L_0x00dc:
            r5 = 0
            goto L_0x002d
        L_0x00df:
            r4.close()     // Catch:{ IOException -> 0x00e3 }
            goto L_0x00f9
        L_0x00e3:
            r1 = move-exception
            java.lang.String r2 = a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            java.lang.String r0 = r1.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r2, r0)
        L_0x00f9:
            return r3
        L_0x00fa:
            r1 = move-exception
            goto L_0x013f
        L_0x00fc:
            r2 = move-exception
            goto L_0x0108
        L_0x00fe:
            r2 = move-exception
            goto L_0x0108
        L_0x0100:
            r2 = move-exception
            r4 = r1
            r1 = r2
            goto L_0x013f
        L_0x0104:
            r2 = move-exception
            goto L_0x0107
        L_0x0106:
            r2 = move-exception
        L_0x0107:
            r4 = r1
        L_0x0108:
            java.lang.String r3 = a     // Catch:{ all -> 0x00fa }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fa }
            r5.<init>()     // Catch:{ all -> 0x00fa }
            java.lang.String r6 = "getDbIceTripInfo. Encoding json failed: "
            r5.append(r6)     // Catch:{ all -> 0x00fa }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x00fa }
            r5.append(r2)     // Catch:{ all -> 0x00fa }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x00fa }
            android.util.Log.e(r3, r2)     // Catch:{ all -> 0x00fa }
            if (r4 == 0) goto L_0x015c
            r4.close()     // Catch:{ IOException -> 0x0128 }
            goto L_0x015c
        L_0x0128:
            r2 = move-exception
            java.lang.String r3 = a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            java.lang.String r0 = r2.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r3, r0)
            goto L_0x015c
        L_0x013f:
            if (r4 == 0) goto L_0x015b
            r4.close()     // Catch:{ IOException -> 0x0145 }
            goto L_0x015b
        L_0x0145:
            r2 = move-exception
            java.lang.String r3 = a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            java.lang.String r0 = r2.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.util.Log.e(r3, r0)
        L_0x015b:
            throw r1
        L_0x015c:
            return r1
        L_0x015d:
            r0 = move-exception
            java.lang.String r2 = a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "getDbIceTripInfo. Request failed: "
            r3.<init>(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.util.Log.e(r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.y1.a():com.umlaut.crowd.internal.x1");
    }

    public void a(p3 p3Var) {
        new a(p3Var).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0090 A[Catch:{ g4 | IOException -> 0x00fb, all -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6 A[Catch:{ g4 | IOException -> 0x00fb, all -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0121 A[SYNTHETIC, Splitter:B:53:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0141 A[SYNTHETIC, Splitter:B:61:0x0141] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.umlaut.crowd.internal.q4 a(java.lang.String r9) {
        /*
            java.lang.String r0 = "getDbRailNetLocationInfo. Closing JSONStreamReader failed: "
            r1 = 3
            r2 = 0
            com.umlaut.crowd.internal.vd[] r1 = new com.umlaut.crowd.internal.vd[r1]     // Catch:{ IOException -> 0x015d }
            com.umlaut.crowd.internal.vd r3 = new com.umlaut.crowd.internal.vd     // Catch:{ IOException -> 0x015d }
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = "https://github.com/derhuerst/wifi-on-ice-portal-client"
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x015d }
            r4 = 0
            r1[r4] = r3     // Catch:{ IOException -> 0x015d }
            com.umlaut.crowd.internal.vd r3 = new com.umlaut.crowd.internal.vd     // Catch:{ IOException -> 0x015d }
            java.lang.String r5 = "Content-Type"
            java.lang.String r6 = "application/json; charset=UTF-8"
            r3.<init>(r5, r6)     // Catch:{ IOException -> 0x015d }
            r5 = 1
            r1[r5] = r3     // Catch:{ IOException -> 0x015d }
            com.umlaut.crowd.internal.vd r3 = new com.umlaut.crowd.internal.vd     // Catch:{ IOException -> 0x015d }
            java.lang.String r6 = "Accept"
            java.lang.String r7 = "application/json"
            r3.<init>(r6, r7)     // Catch:{ IOException -> 0x015d }
            r6 = 2
            r1[r6] = r3     // Catch:{ IOException -> 0x015d }
            com.umlaut.crowd.net.WebApiClient$RequestMethod r3 = com.umlaut.crowd.net.WebApiClient.RequestMethod.GET     // Catch:{ IOException -> 0x015d }
            com.umlaut.crowd.net.WebApiResponse r9 = com.umlaut.crowd.net.WebApiClient.sendJsonRequest(r3, r9, r2, r1)     // Catch:{ IOException -> 0x015d }
            int r1 = r9.responseCode
            r3 = 200(0xc8, float:2.8E-43)
            if (r1 != r3) goto L_0x015c
            com.umlaut.crowd.internal.w1 r1 = new com.umlaut.crowd.internal.w1
            r1.<init>()
            com.umlaut.crowd.internal.k4 r3 = new com.umlaut.crowd.internal.k4     // Catch:{ g4 -> 0x0103, IOException -> 0x0101, all -> 0x00ff }
            java.io.ByteArrayInputStream r7 = new java.io.ByteArrayInputStream     // Catch:{ g4 -> 0x0103, IOException -> 0x0101, all -> 0x00ff }
            java.lang.String r9 = r9.content     // Catch:{ g4 -> 0x0103, IOException -> 0x0101, all -> 0x00ff }
            java.lang.String r8 = "UTF-8"
            byte[] r9 = r9.getBytes(r8)     // Catch:{ g4 -> 0x0103, IOException -> 0x0101, all -> 0x00ff }
            r7.<init>(r9)     // Catch:{ g4 -> 0x0103, IOException -> 0x0101, all -> 0x00ff }
            r3.<init>(r7)     // Catch:{ g4 -> 0x0103, IOException -> 0x0101, all -> 0x00ff }
            r3.H()     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
        L_0x0050:
            boolean r9 = r3.p()     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            if (r9 == 0) goto L_0x00b2
            java.lang.String r9 = r3.q()     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            int r7 = r9.hashCode()     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            r8 = -1439978388(0xffffffffaa2bac6c, float:-1.5247672E-13)
            if (r7 == r8) goto L_0x0083
            r8 = 109641799(0x6890047, float:5.153408E-35)
            if (r7 == r8) goto L_0x0078
            r8 = 137365935(0x83009af, float:5.2974456E-34)
            if (r7 == r8) goto L_0x006e
            goto L_0x008d
        L_0x006e:
            java.lang.String r7 = "longitude"
            boolean r9 = r9.equals(r7)     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            if (r9 == 0) goto L_0x008d
            r9 = 1
            goto L_0x008e
        L_0x0078:
            java.lang.String r7 = "speed"
            boolean r9 = r9.equals(r7)     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            if (r9 == 0) goto L_0x008d
            r9 = 0
            goto L_0x008e
        L_0x0083:
            java.lang.String r7 = "latitude"
            boolean r9 = r9.equals(r7)     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            if (r9 == 0) goto L_0x008d
            r9 = 2
            goto L_0x008e
        L_0x008d:
            r9 = -1
        L_0x008e:
            if (r9 == 0) goto L_0x00a6
            if (r9 == r5) goto L_0x009f
            if (r9 == r6) goto L_0x0098
            r3.E()     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            goto L_0x0050
        L_0x0098:
            double r7 = r3.u()     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            r1.d = r7     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            goto L_0x0050
        L_0x009f:
            double r7 = r3.u()     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            r1.e = r7     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            goto L_0x0050
        L_0x00a6:
            double r7 = r3.u()     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            long r7 = java.lang.Math.round(r7)     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            int r9 = (int) r7     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            r1.b = r9     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            goto L_0x0050
        L_0x00b2:
            com.umlaut.crowd.internal.q4 r9 = new com.umlaut.crowd.internal.q4     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            r9.<init>()     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            long r4 = com.umlaut.crowd.timeserver.TimeServer.getTimeInMillis()     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            r9.locationTimestampMillis = r4     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            java.lang.String r4 = com.umlaut.crowd.utils.DateUtils.formatTableau(r4)     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            r9.LocationTimestamp = r4     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            com.umlaut.crowd.internal.s4 r4 = com.umlaut.crowd.internal.s4.RailNet     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            r9.LocationProvider = r4     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            double r4 = r1.d     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            r9.LocationLatitude = r4     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            double r4 = r1.e     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            r9.LocationLongitude = r4     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            int r1 = r1.b     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            double r4 = (double) r1
            r6 = 4598675619503873138(0x3fd1c71c71c71c72, double:0.2777777777777778)
            java.lang.Double.isNaN(r4)
            double r4 = r4 * r6
            r9.LocationSpeed = r4     // Catch:{ g4 -> 0x00fd, IOException -> 0x00fb, all -> 0x00f9 }
            r3.close()     // Catch:{ IOException -> 0x00e2 }
            goto L_0x00f8
        L_0x00e2:
            r1 = move-exception
            java.lang.String r2 = a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = r1.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.util.Log.e(r2, r0)
        L_0x00f8:
            return r9
        L_0x00f9:
            r9 = move-exception
            goto L_0x013f
        L_0x00fb:
            r9 = move-exception
            goto L_0x0105
        L_0x00fd:
            r9 = move-exception
            goto L_0x0105
        L_0x00ff:
            r9 = move-exception
            goto L_0x013e
        L_0x0101:
            r9 = move-exception
            goto L_0x0104
        L_0x0103:
            r9 = move-exception
        L_0x0104:
            r3 = r2
        L_0x0105:
            java.lang.String r1 = a     // Catch:{ all -> 0x013c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x013c }
            r4.<init>()     // Catch:{ all -> 0x013c }
            java.lang.String r5 = "getDbRailNetLocationInfo. Encoding json failed: "
            r4.append(r5)     // Catch:{ all -> 0x013c }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x013c }
            r4.append(r9)     // Catch:{ all -> 0x013c }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x013c }
            android.util.Log.e(r1, r9)     // Catch:{ all -> 0x013c }
            if (r3 == 0) goto L_0x015c
            r3.close()     // Catch:{ IOException -> 0x0125 }
            goto L_0x015c
        L_0x0125:
            r9 = move-exception
            java.lang.String r1 = a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r9 = r9.getMessage()
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            android.util.Log.e(r1, r9)
            goto L_0x015c
        L_0x013c:
            r9 = move-exception
            r2 = r3
        L_0x013e:
            r3 = r2
        L_0x013f:
            if (r3 == 0) goto L_0x015b
            r3.close()     // Catch:{ IOException -> 0x0145 }
            goto L_0x015b
        L_0x0145:
            r1 = move-exception
            java.lang.String r2 = a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = r1.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.util.Log.e(r2, r0)
        L_0x015b:
            throw r9
        L_0x015c:
            return r2
        L_0x015d:
            r9 = move-exception
            java.lang.String r0 = a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "getDbRailNetLocationInfo. Request failed: "
            r1.<init>(r3)
            java.lang.String r9 = r9.getMessage()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            android.util.Log.e(r0, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.y1.a(java.lang.String):com.umlaut.crowd.internal.q4");
    }
}
