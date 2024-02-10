package com.m2catalyst.m2sdk.business.models;

import android.content.Context;
import android.content.res.Configuration;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.m2catalyst.m2sdk.a;
import com.m2catalyst.m2sdk.m4;
import com.m2catalyst.m2sdk.o4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010E\u001a\u00020\u000fH\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001c\u0010 \u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001e\u0010&\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b'\u0010\n\"\u0004\b(\u0010\fR\u001e\u0010)\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010\fR\u001e\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00103\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0011\"\u0004\b5\u0010\u0013R\u001e\u00106\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b7\u0010\n\"\u0004\b8\u0010\fR\u001e\u00109\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b:\u0010\n\"\u0004\b;\u0010\fR\u001c\u0010<\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0011\"\u0004\b>\u0010\u0013R\u001e\u0010?\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b@\u0010\n\"\u0004\bA\u0010\fR\u001e\u0010B\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\bC\u0010\n\"\u0004\bD\u0010\f¨\u0006F"}, d2 = {"Lcom/m2catalyst/m2sdk/business/models/NetworkInfoSnapshot;", "", "context", "Landroid/content/Context;", "sub", "", "(Landroid/content/Context;I)V", "()V", "dataNetworkType", "getDataNetworkType", "()Ljava/lang/Integer;", "setDataNetworkType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "networkCountryIso", "", "getNetworkCountryIso", "()Ljava/lang/String;", "setNetworkCountryIso", "(Ljava/lang/String;)V", "networkMcc", "getNetworkMcc", "setNetworkMcc", "networkMccStr", "getNetworkMccStr", "setNetworkMccStr", "networkMnc", "getNetworkMnc", "setNetworkMnc", "networkMncStr", "getNetworkMncStr", "setNetworkMncStr", "networkOperatorName", "getNetworkOperatorName", "setNetworkOperatorName", "phoneType", "getPhoneType", "setPhoneType", "resourcesMcc", "getResourcesMcc", "setResourcesMcc", "resourcesMnc", "getResourcesMnc", "setResourcesMnc", "roaming", "", "getRoaming", "()Ljava/lang/Boolean;", "setRoaming", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "simCountryIso", "getSimCountryIso", "setSimCountryIso", "simMcc", "getSimMcc", "setSimMcc", "simMnc", "getSimMnc", "setSimMnc", "simOperatorName", "getSimOperatorName", "setSimOperatorName", "subscriber", "getSubscriber", "setSubscriber", "voiceNetworkType", "getVoiceNetworkType", "setVoiceNetworkType", "toString", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NetworkInfoSnapshot.kt */
public final class NetworkInfoSnapshot {
    private Integer dataNetworkType;
    private String networkCountryIso;
    private Integer networkMcc;
    private String networkMccStr;
    private Integer networkMnc;
    private String networkMncStr;
    private String networkOperatorName;
    private String phoneType;
    private Integer resourcesMcc;
    private Integer resourcesMnc;
    private Boolean roaming;
    private String simCountryIso;
    private Integer simMcc;
    private Integer simMnc;
    private String simOperatorName;
    private Integer subscriber;
    private Integer voiceNetworkType;

    public NetworkInfoSnapshot() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NetworkInfoSnapshot(Context context, int i) {
        this();
        Intrinsics.checkNotNullParameter(context, "context");
        this.subscriber = Integer.valueOf(i);
        NetworkInfo b = m4.b(context);
        this.roaming = b != null ? Boolean.valueOf(b.isRoaming()) : null;
        TelephonyManager a = m4.a(context, i);
        if (a != null) {
            this.phoneType = m4.a(a.getPhoneType());
            this.networkOperatorName = (String) a.a(new NetworkInfoSnapshot$1$1(a));
            this.networkCountryIso = (String) a.a(new NetworkInfoSnapshot$1$2(a));
            if (o4.e(context)) {
                this.dataNetworkType = Integer.valueOf(a.getDataNetworkType());
                this.voiceNetworkType = Integer.valueOf(a.getVoiceNetworkType());
            }
            String str = (String) a.a(new NetworkInfoSnapshot$1$3(a));
            if (str != null) {
                this.networkMccStr = (String) a.a(new NetworkInfoSnapshot$1$4$1(str));
                this.networkMncStr = (String) a.a(new NetworkInfoSnapshot$1$4$2(str));
                this.networkMcc = (Integer) a.a(new NetworkInfoSnapshot$1$4$3(this));
                this.networkMnc = (Integer) a.a(new NetworkInfoSnapshot$1$4$4(this));
            }
            this.simOperatorName = (String) a.a(new NetworkInfoSnapshot$1$5(a));
            this.simCountryIso = (String) a.a(new NetworkInfoSnapshot$1$6(a));
            String str2 = (String) a.a(new NetworkInfoSnapshot$1$7(a));
            if (str2 != null) {
                this.simMcc = (Integer) a.a(new NetworkInfoSnapshot$1$8$1(str2));
                this.simMnc = (Integer) a.a(new NetworkInfoSnapshot$1$8$2(str2));
            }
            Configuration configuration = context.getResources().getConfiguration();
            this.resourcesMcc = Integer.valueOf(configuration.mcc);
            this.resourcesMnc = Integer.valueOf(configuration.mnc);
        }
    }

    public final Integer getDataNetworkType() {
        return this.dataNetworkType;
    }

    public final String getNetworkCountryIso() {
        return this.networkCountryIso;
    }

    public final Integer getNetworkMcc() {
        return this.networkMcc;
    }

    public final String getNetworkMccStr() {
        return this.networkMccStr;
    }

    public final Integer getNetworkMnc() {
        return this.networkMnc;
    }

    public final String getNetworkMncStr() {
        return this.networkMncStr;
    }

    public final String getNetworkOperatorName() {
        return this.networkOperatorName;
    }

    public final String getPhoneType() {
        return this.phoneType;
    }

    public final Integer getResourcesMcc() {
        return this.resourcesMcc;
    }

    public final Integer getResourcesMnc() {
        return this.resourcesMnc;
    }

    public final Boolean getRoaming() {
        return this.roaming;
    }

    public final String getSimCountryIso() {
        return this.simCountryIso;
    }

    public final Integer getSimMcc() {
        return this.simMcc;
    }

    public final Integer getSimMnc() {
        return this.simMnc;
    }

    public final String getSimOperatorName() {
        return this.simOperatorName;
    }

    public final Integer getSubscriber() {
        return this.subscriber;
    }

    public final Integer getVoiceNetworkType() {
        return this.voiceNetworkType;
    }

    public final void setDataNetworkType(Integer num) {
        this.dataNetworkType = num;
    }

    public final void setNetworkCountryIso(String str) {
        this.networkCountryIso = str;
    }

    public final void setNetworkMcc(Integer num) {
        this.networkMcc = num;
    }

    public final void setNetworkMccStr(String str) {
        this.networkMccStr = str;
    }

    public final void setNetworkMnc(Integer num) {
        this.networkMnc = num;
    }

    public final void setNetworkMncStr(String str) {
        this.networkMncStr = str;
    }

    public final void setNetworkOperatorName(String str) {
        this.networkOperatorName = str;
    }

    public final void setPhoneType(String str) {
        this.phoneType = str;
    }

    public final void setResourcesMcc(Integer num) {
        this.resourcesMcc = num;
    }

    public final void setResourcesMnc(Integer num) {
        this.resourcesMnc = num;
    }

    public final void setRoaming(Boolean bool) {
        this.roaming = bool;
    }

    public final void setSimCountryIso(String str) {
        this.simCountryIso = str;
    }

    public final void setSimMcc(Integer num) {
        this.simMcc = num;
    }

    public final void setSimMnc(Integer num) {
        this.simMnc = num;
    }

    public final void setSimOperatorName(String str) {
        this.simOperatorName = str;
    }

    public final void setSubscriber(Integer num) {
        this.subscriber = num;
    }

    public final void setVoiceNetworkType(Integer num) {
        this.voiceNetworkType = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NetworkInfoSnapshot: ");
        Integer num = this.subscriber;
        sb.append("subscriber=" + num);
        Boolean bool = this.roaming;
        sb.append(" roaming= " + bool);
        String str = this.phoneType;
        sb.append(" phoneType= " + str);
        Integer num2 = this.dataNetworkType;
        sb.append(" dataNetworkType= " + num2);
        Integer num3 = this.voiceNetworkType;
        sb.append(" voiceNetworkType= " + num3);
        String str2 = this.networkOperatorName;
        sb.append(" networkOperatorName= " + str2);
        String str3 = this.networkCountryIso;
        sb.append(" networkCountryIso= " + str3);
        Integer num4 = this.networkMcc;
        sb.append("networkMcc=" + num4);
        Integer num5 = this.networkMnc;
        sb.append(" networkMnc= " + num5);
        String str4 = this.networkMccStr;
        sb.append(" networkMccStr= " + str4);
        String str5 = this.networkMncStr;
        sb.append(" networkMncStr= " + str5);
        String str6 = this.simOperatorName;
        sb.append(" simOperatorName= " + str6);
        String str7 = this.simCountryIso;
        sb.append(" simCountryIso= " + str7);
        Integer num6 = this.simMcc;
        sb.append(" simMcc= " + num6);
        Integer num7 = this.simMnc;
        sb.append(" simMnc=" + num7);
        Integer num8 = this.resourcesMcc;
        sb.append(" resourcesMcc=" + num8);
        Integer num9 = this.resourcesMnc;
        sb.append(" resourcesMnc=" + num9);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
