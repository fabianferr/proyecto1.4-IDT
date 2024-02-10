package com.cellrebel.sdk.utils;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.CellIdentity;
import java.util.ArrayList;

public class WrappedRegInfo {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public String f;
    public Integer g;
    public int h;
    public String i;

    public WrappedRegInfo(Parcelable parcelable) {
        int i2;
        if (parcelable != null && (i2 = Build.VERSION.SDK_INT) >= 31) {
            String obj = parcelable.toString();
            Parcel obtain = Parcel.obtain();
            boolean z = false;
            try {
                parcelable.writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                String.valueOf(obtain.readInt());
                String.valueOf(obtain.readInt());
                String.valueOf(obtain.readInt());
                if (obj.contains("RegistrationState")) {
                    String.valueOf(obtain.readInt());
                }
                String.valueOf(obtain.readInt());
                int readInt = obtain.readInt();
                String.valueOf(readInt);
                this.e = readInt == 20 ? true : z;
                this.h = readInt;
                String.valueOf(obtain.readInt());
                String.valueOf(obtain.readBoolean());
                ArrayList arrayList = new ArrayList();
                if (i2 < 33) {
                    obtain.readList(arrayList, Integer.class.getClassLoader());
                } else {
                    obtain.readList(arrayList, Integer.class.getClassLoader(), Integer.class);
                }
                arrayList.toString();
                CellIdentity cellIdentity = (CellIdentity) (i2 < 33 ? obtain.readParcelable(CellIdentity.class.getClassLoader()) : obtain.readParcelable(CellIdentity.class.getClassLoader(), CellIdentity.class));
                if (cellIdentity != null) {
                    cellIdentity.toString();
                    this.i = cellIdentity.toString();
                }
                String readString = obtain.readString();
                if (readString != null && readString.equals("android.telephony.VoiceSpecificRegistrationInfo")) {
                    String.valueOf(obtain.readBoolean());
                    String.valueOf(obtain.readInt());
                    String.valueOf(obtain.readInt());
                    String.valueOf(obtain.readInt());
                }
                String readString2 = obtain.readString();
                if (readString2 != null && readString2.equals("android.telephony.DataSpecificRegistrationInfo")) {
                    String.valueOf(obtain.readInt());
                    boolean readBoolean = obtain.readBoolean();
                    this.a = readBoolean;
                    String.valueOf(readBoolean);
                    boolean readBoolean2 = obtain.readBoolean();
                    this.b = readBoolean2;
                    String.valueOf(readBoolean2);
                    boolean readBoolean3 = obtain.readBoolean();
                    this.c = readBoolean3;
                    String.valueOf(readBoolean3);
                    String readString3 = obtain.readString();
                    if (readString3 != null) {
                        if (readString3.equals("android.telephony.LteVopsSupportInfo")) {
                            String.valueOf(obtain.readInt());
                            this.g = Integer.valueOf(obtain.readInt());
                        } else if (readString3.equals("android.telephony.NrVopsSupportInfo")) {
                            String.valueOf(obtain.readInt());
                            this.g = Integer.valueOf(obtain.readInt());
                            String.valueOf(obtain.readInt());
                        }
                        String.valueOf(obtain.readInt());
                    }
                    if (i2 > 33) {
                        String.valueOf(obtain.readInt());
                        String.valueOf(obtain.readInt());
                    }
                }
                int readInt2 = obtain.readInt();
                String.valueOf(readInt2);
                this.f = a(readInt2);
                obtain.readString();
                this.d = obtain.readBoolean();
            } catch (Exception unused) {
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
            obtain.recycle();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:137:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WrappedRegInfo(java.lang.String r8) {
        /*
            r7 = this;
            r7.<init>()
            if (r8 != 0) goto L_0x0006
            return
        L_0x0006:
            java.lang.String r0 = "isDcNrRestricted = true"
            boolean r0 = r8.contains(r0)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001b
            java.lang.String r0 = "isDcNrRestricted=true"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r0 = 0
            goto L_0x001c
        L_0x001b:
            r0 = 1
        L_0x001c:
            r7.a = r0
            java.lang.String r0 = "isNrAvailable = true"
            boolean r0 = r8.contains(r0)
            if (r0 != 0) goto L_0x0031
            java.lang.String r0 = "isNrAvailable=true"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r0 = 0
            goto L_0x0032
        L_0x0031:
            r0 = 1
        L_0x0032:
            r7.b = r0
            java.lang.String r0 = "isEnDcAvailable = true"
            boolean r0 = r8.contains(r0)
            if (r0 != 0) goto L_0x0047
            java.lang.String r0 = "isEnDcAvailable=true"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r0 = 0
            goto L_0x0048
        L_0x0047:
            r0 = 1
        L_0x0048:
            r7.c = r0
            java.lang.String r0 = "accessNetworkTechnology = NR"
            boolean r3 = r8.contains(r0)
            java.lang.String r4 = "accessNetworkTechnology=NR"
            if (r3 != 0) goto L_0x005d
            boolean r3 = r8.contains(r4)
            if (r3 == 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r3 = 0
            goto L_0x005e
        L_0x005d:
            r3 = 1
        L_0x005e:
            r7.e = r3
            java.lang.String r3 = "accessNetworkTechnology = GPRS"
            boolean r3 = r8.contains(r3)
            r5 = 3
            r6 = 2
            if (r3 != 0) goto L_0x01f2
            java.lang.String r3 = "accessNetworkTechnology=GPRS"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x0074
            goto L_0x01f2
        L_0x0074:
            java.lang.String r3 = "accessNetworkTechnology = EDGE"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01f0
            java.lang.String r3 = "accessNetworkTechnology=EDGE"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x0086
            goto L_0x01f0
        L_0x0086:
            java.lang.String r3 = "accessNetworkTechnology = UMTS"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01ee
            java.lang.String r3 = "accessNetworkTechnology=UMTS"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x0098
            goto L_0x01ee
        L_0x0098:
            java.lang.String r3 = "accessNetworkTechnology = CDMA"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01ec
            java.lang.String r3 = "accessNetworkTechnology=CDMA"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x00aa
            goto L_0x01ec
        L_0x00aa:
            java.lang.String r3 = "accessNetworkTechnology = CDMA - EvDo rev. 0"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01ea
            java.lang.String r3 = "accessNetworkTechnology=CDMA - EvDo rev. 0"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x00bc
            goto L_0x01ea
        L_0x00bc:
            java.lang.String r3 = "accessNetworkTechnology = CDMA - EvDo rev. A"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01e8
            java.lang.String r3 = "accessNetworkTechnology=CDMA - EvDo rev. A"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x00ce
            goto L_0x01e8
        L_0x00ce:
            java.lang.String r3 = "accessNetworkTechnology = CDMA - 1xRTT"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01e6
            java.lang.String r3 = "accessNetworkTechnology=CDMA - 1xRTT"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x00e0
            goto L_0x01e6
        L_0x00e0:
            java.lang.String r3 = "accessNetworkTechnology = HSDPA"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01e3
            java.lang.String r3 = "accessNetworkTechnology=HSDPA"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x00f2
            goto L_0x01e3
        L_0x00f2:
            java.lang.String r3 = "accessNetworkTechnology = HSUPA"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01e0
            java.lang.String r3 = "accessNetworkTechnology=HSUPA"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x0104
            goto L_0x01e0
        L_0x0104:
            java.lang.String r3 = "accessNetworkTechnology = HSPA"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01dd
            java.lang.String r3 = "accessNetworkTechnology=HSPA"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x0116
            goto L_0x01dd
        L_0x0116:
            java.lang.String r3 = "accessNetworkTechnology = iDEN"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01da
            java.lang.String r3 = "accessNetworkTechnology=iDEN"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x0128
            goto L_0x01da
        L_0x0128:
            java.lang.String r3 = "accessNetworkTechnology = CDMA - EvDo rev. B"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01d7
            java.lang.String r3 = "accessNetworkTechnology=CDMA - EvDo rev. B"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x013a
            goto L_0x01d7
        L_0x013a:
            java.lang.String r3 = "accessNetworkTechnology = LTE"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01d4
            java.lang.String r3 = "accessNetworkTechnology=LTE"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x014c
            goto L_0x01d4
        L_0x014c:
            java.lang.String r3 = "accessNetworkTechnology = CDMA - eHRPD"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01d1
            java.lang.String r3 = "accessNetworkTechnology=CDMA - eHRPD"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x015e
            goto L_0x01d1
        L_0x015e:
            java.lang.String r3 = "accessNetworkTechnology = HSPA+"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01ce
            java.lang.String r3 = "accessNetworkTechnology=HSPA+"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x016f
            goto L_0x01ce
        L_0x016f:
            java.lang.String r3 = "accessNetworkTechnology = GSM"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01cb
            java.lang.String r3 = "accessNetworkTechnology=GSM"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x0180
            goto L_0x01cb
        L_0x0180:
            java.lang.String r3 = "accessNetworkTechnology = TD_SCDMA"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01c8
            java.lang.String r3 = "accessNetworkTechnology=TD_SCDMA"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x0191
            goto L_0x01c8
        L_0x0191:
            java.lang.String r3 = "accessNetworkTechnology = IWLAN"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01c5
            java.lang.String r3 = "accessNetworkTechnology=IWLAN"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x01a2
            goto L_0x01c5
        L_0x01a2:
            java.lang.String r3 = "accessNetworkTechnology = LTE_CA"
            boolean r3 = r8.contains(r3)
            if (r3 != 0) goto L_0x01c2
            java.lang.String r3 = "accessNetworkTechnology=LTE_CA"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L_0x01b3
            goto L_0x01c2
        L_0x01b3:
            boolean r0 = r8.contains(r0)
            if (r0 != 0) goto L_0x01bf
            boolean r0 = r8.contains(r4)
            if (r0 == 0) goto L_0x01f5
        L_0x01bf:
            r0 = 20
            goto L_0x01f3
        L_0x01c2:
            r0 = 19
            goto L_0x01f3
        L_0x01c5:
            r0 = 18
            goto L_0x01f3
        L_0x01c8:
            r0 = 17
            goto L_0x01f3
        L_0x01cb:
            r0 = 16
            goto L_0x01f3
        L_0x01ce:
            r0 = 15
            goto L_0x01f3
        L_0x01d1:
            r0 = 14
            goto L_0x01f3
        L_0x01d4:
            r0 = 13
            goto L_0x01f3
        L_0x01d7:
            r0 = 12
            goto L_0x01f3
        L_0x01da:
            r0 = 11
            goto L_0x01f3
        L_0x01dd:
            r0 = 10
            goto L_0x01f3
        L_0x01e0:
            r0 = 9
            goto L_0x01f3
        L_0x01e3:
            r0 = 8
            goto L_0x01f3
        L_0x01e6:
            r0 = 7
            goto L_0x01f3
        L_0x01e8:
            r0 = 6
            goto L_0x01f3
        L_0x01ea:
            r0 = 5
            goto L_0x01f3
        L_0x01ec:
            r0 = 4
            goto L_0x01f3
        L_0x01ee:
            r0 = 3
            goto L_0x01f3
        L_0x01f0:
            r0 = 2
            goto L_0x01f3
        L_0x01f2:
            r0 = 1
        L_0x01f3:
            r7.h = r0
        L_0x01f5:
            java.lang.String r0 = "IsUsingCarrierAggregation = true"
            boolean r0 = r8.contains(r0)
            if (r0 != 0) goto L_0x0205
            java.lang.String r0 = "IsUsingCarrierAggregation=true"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x0206
        L_0x0205:
            r1 = 1
        L_0x0206:
            r7.d = r1
            java.lang.String r0 = "nrState=CONNECTED"
            boolean r0 = r8.contains(r0)
            if (r0 != 0) goto L_0x0254
            java.lang.String r0 = "nrState = CONNECTED"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x0219
            goto L_0x0254
        L_0x0219:
            java.lang.String r0 = "nrState=NOT_RESTRICTED"
            boolean r0 = r8.contains(r0)
            if (r0 != 0) goto L_0x0251
            java.lang.String r0 = "nrState = NOT_RESTRICTED"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x022a
            goto L_0x0251
        L_0x022a:
            java.lang.String r0 = "nrState=RESTRICTED"
            boolean r0 = r8.contains(r0)
            if (r0 != 0) goto L_0x024e
            java.lang.String r0 = "nrState = RESTRICTED"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x023b
            goto L_0x024e
        L_0x023b:
            java.lang.String r0 = "nrState=NONE"
            boolean r0 = r8.contains(r0)
            if (r0 != 0) goto L_0x024b
            java.lang.String r0 = "nrState = NONE"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x0258
        L_0x024b:
            java.lang.String r0 = "NONE"
            goto L_0x0256
        L_0x024e:
            java.lang.String r0 = "RESTRICTED"
            goto L_0x0256
        L_0x0251:
            java.lang.String r0 = "NOT_RESTRICTED"
            goto L_0x0256
        L_0x0254:
            java.lang.String r0 = "CONNECTED"
        L_0x0256:
            r7.f = r0
        L_0x0258:
            java.lang.String r0 = "VopsSupport = 1"
            boolean r0 = r8.contains(r0)
            if (r0 != 0) goto L_0x0294
            java.lang.String r0 = "VopsSupport=1"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x0269
            goto L_0x0294
        L_0x0269:
            java.lang.String r0 = "VopsSupport = 2"
            boolean r0 = r8.contains(r0)
            if (r0 != 0) goto L_0x028f
            java.lang.String r0 = "VopsSupport=2"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x027a
            goto L_0x028f
        L_0x027a:
            java.lang.String r0 = "VopsSupport = 3"
            boolean r0 = r8.contains(r0)
            if (r0 != 0) goto L_0x028a
            java.lang.String r0 = "VopsSupport=3"
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x029a
        L_0x028a:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            goto L_0x0298
        L_0x028f:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            goto L_0x0298
        L_0x0294:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
        L_0x0298:
            r7.g = r0
        L_0x029a:
            java.lang.String r0 = "cellIdentity="
            boolean r0 = r8.contains(r0)
            if (r0 == 0) goto L_0x02b8
            java.lang.String r0 = "cellIdentity=CellIdentity(.*?)\\}"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r8 = r0.matcher(r8)
            boolean r0 = r8.find()
            if (r0 == 0) goto L_0x02b8
            java.lang.String r8 = r8.group(r2)
            r7.i = r8
        L_0x02b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.WrappedRegInfo.<init>(java.lang.String):void");
    }

    private String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "NONE" : "CONNECTED" : "NOT_RESTRICTED" : "RESTRICTED";
    }

    public int a() {
        return this.h;
    }

    /* access modifiers changed from: protected */
    public boolean a(Object obj) {
        return obj instanceof WrappedRegInfo;
    }

    public String b() {
        return this.i;
    }

    public String c() {
        return this.f;
    }

    public Integer d() {
        return this.g;
    }

    public boolean e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WrappedRegInfo)) {
            return false;
        }
        WrappedRegInfo wrappedRegInfo = (WrappedRegInfo) obj;
        if (!wrappedRegInfo.a((Object) this) || e() != wrappedRegInfo.e() || h() != wrappedRegInfo.h() || f() != wrappedRegInfo.f() || i() != wrappedRegInfo.i() || g() != wrappedRegInfo.g()) {
            return false;
        }
        String c2 = c();
        String c3 = wrappedRegInfo.c();
        if (c2 != null ? !c2.equals(c3) : c3 != null) {
            return false;
        }
        Integer d2 = d();
        Integer d3 = wrappedRegInfo.d();
        if (d2 != null ? !d2.equals(d3) : d3 != null) {
            return false;
        }
        if (a() != wrappedRegInfo.a()) {
            return false;
        }
        String b2 = b();
        String b3 = wrappedRegInfo.b();
        return b2 != null ? b2.equals(b3) : b3 == null;
    }

    public boolean f() {
        return this.c;
    }

    public boolean g() {
        return this.e;
    }

    public boolean h() {
        return this.b;
    }

    public int hashCode() {
        int i2 = 79;
        int i3 = ((((((((e() ? 79 : 97) + 59) * 59) + (h() ? 79 : 97)) * 59) + (f() ? 79 : 97)) * 59) + (i() ? 79 : 97)) * 59;
        if (!g()) {
            i2 = 97;
        }
        int i4 = i3 + i2;
        String c2 = c();
        int i5 = 43;
        int hashCode = (i4 * 59) + (c2 == null ? 43 : c2.hashCode());
        Integer d2 = d();
        int hashCode2 = (((hashCode * 59) + (d2 == null ? 43 : d2.hashCode())) * 59) + a();
        String b2 = b();
        int i6 = hashCode2 * 59;
        if (b2 != null) {
            i5 = b2.hashCode();
        }
        return i6 + i5;
    }

    public boolean i() {
        return this.d;
    }

    public String toString() {
        return "WrappedRegInfo(isDcNrRestricted=" + e() + ", isNrAvailable=" + h() + ", isEnDcAvailable=" + f() + ", isUsingCarrierAggregation=" + i() + ", isNetworkTypeNR=" + g() + ", nrState=" + c() + ", vopsSupport=" + d() + ", accessNetworkTechnology=" + a() + ", cellIdentity=" + b() + ")";
    }
}
