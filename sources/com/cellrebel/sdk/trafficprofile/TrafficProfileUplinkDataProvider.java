package com.cellrebel.sdk.trafficprofile;

import com.cellrebel.sdk.trafficprofile.udp.UdpMessageType;
import com.cellrebel.sdk.trafficprofile.udp.messages.UdpPackageMessage;
import com.cellrebel.sdk.trafficprofile.utils.DownloadManager;
import com.cellrebel.sdk.trafficprofile.utils.FileManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class TrafficProfileUplinkDataProvider {
    private final String a;
    private final String b;
    private final DownloadManager c;
    private final FileManager d;

    public TrafficProfileUplinkDataProvider(String str, String str2, DownloadManager downloadManager, FileManager fileManager) {
        this.a = "https://" + str + "/downloadUplinkLog/";
        this.b = str2;
        this.c = downloadManager;
        this.d = fileManager;
    }

    public List<UdpPackageMessage> a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            String str2 = this.d.a() + File.separator + "uplink_data.json";
            this.c.a(this.a + str, this.b, str2);
            while (true) {
                String b2 = this.d.b(str2);
                if (b2 == null) {
                    break;
                }
                JSONObject jSONObject = new JSONObject(b2);
                UdpPackageMessage udpPackageMessage = new UdpPackageMessage();
                udpPackageMessage.a = UdpMessageType.UPLINK;
                udpPackageMessage.b = jSONObject.getLong("clientTimestamp");
                udpPackageMessage.d = jSONObject.getLong("serverTimestamp");
                udpPackageMessage.c = jSONObject.getInt("packetId");
                udpPackageMessage.e = jSONObject.getInt("profileId");
                udpPackageMessage.f = jSONObject.getInt("flowId");
                udpPackageMessage.g = jSONObject.getInt("segmentId");
                udpPackageMessage.h = jSONObject.optString("measurementSequenceId");
                arrayList.add(udpPackageMessage);
            }
            this.d.a(str2);
        } catch (IOException | JSONException unused) {
        }
        return arrayList;
    }
}
