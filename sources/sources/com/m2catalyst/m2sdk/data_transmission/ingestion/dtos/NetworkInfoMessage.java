package com.m2catalyst.m2sdk.data_transmission.ingestion.dtos;

import com.m2catalyst.m2sdk.c;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.ByteString;

public final class NetworkInfoMessage extends Message<NetworkInfoMessage, Builder> {
    public static final ProtoAdapter<NetworkInfoMessage> ADAPTER = new ProtoAdapter_NetworkInfoMessage();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.MobileNetworkSignalInfoMessage#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<MobileNetworkSignalInfoMessage> mobileNetworkSignalInfoLogs;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.MobileNetworkInfoMessage#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<MobileNetworkInfoMessage> mobile_network_info;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.MobileNetworkInfoMessage#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<MobileNetworkInfoMessage> mobile_network_signal_info;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkDiagnosticTestResultsMessage#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<NetworkDiagnosticTestResultsMessage> networkDiagnosticTestResults;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NoNetworkSignalInfoMessage#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<NoNetworkSignalInfoMessage> noNetworkSignalInfoLogs;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.WifiNetworkInfoMessage#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<WifiNetworkInfoMessage> wifi_network_info;

    public static final class Builder extends Message.Builder<NetworkInfoMessage, Builder> {
        public List<MobileNetworkSignalInfoMessage> mobileNetworkSignalInfoLogs = Internal.newMutableList();
        public List<MobileNetworkInfoMessage> mobile_network_info = Internal.newMutableList();
        public List<MobileNetworkInfoMessage> mobile_network_signal_info = Internal.newMutableList();
        public List<NetworkDiagnosticTestResultsMessage> networkDiagnosticTestResults = Internal.newMutableList();
        public List<NoNetworkSignalInfoMessage> noNetworkSignalInfoLogs = Internal.newMutableList();
        public List<WifiNetworkInfoMessage> wifi_network_info = Internal.newMutableList();

        public Builder mobileNetworkSignalInfoLogs(List<MobileNetworkSignalInfoMessage> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.mobileNetworkSignalInfoLogs = list;
            return this;
        }

        public Builder mobile_network_info(List<MobileNetworkInfoMessage> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.mobile_network_info = list;
            return this;
        }

        public Builder mobile_network_signal_info(List<MobileNetworkInfoMessage> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.mobile_network_signal_info = list;
            return this;
        }

        public Builder networkDiagnosticTestResults(List<NetworkDiagnosticTestResultsMessage> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.networkDiagnosticTestResults = list;
            return this;
        }

        public Builder noNetworkSignalInfoLogs(List<NoNetworkSignalInfoMessage> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.noNetworkSignalInfoLogs = list;
            return this;
        }

        public Builder wifi_network_info(List<WifiNetworkInfoMessage> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.wifi_network_info = list;
            return this;
        }

        public NetworkInfoMessage build() {
            return new NetworkInfoMessage(this.mobile_network_info, this.mobile_network_signal_info, this.wifi_network_info, this.mobileNetworkSignalInfoLogs, this.noNetworkSignalInfoLogs, this.networkDiagnosticTestResults, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_NetworkInfoMessage extends ProtoAdapter<NetworkInfoMessage> {
        public ProtoAdapter_NetworkInfoMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) NetworkInfoMessage.class);
        }

        public NetworkInfoMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.mobile_network_info.add(MobileNetworkInfoMessage.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            builder.mobile_network_signal_info.add(MobileNetworkInfoMessage.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            builder.wifi_network_info.add(WifiNetworkInfoMessage.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            builder.mobileNetworkSignalInfoLogs.add(MobileNetworkSignalInfoMessage.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            builder.noNetworkSignalInfoLogs.add(NoNetworkSignalInfoMessage.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            builder.networkDiagnosticTestResults.add(NetworkDiagnosticTestResultsMessage.ADAPTER.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public void encode(ProtoWriter protoWriter, NetworkInfoMessage networkInfoMessage) {
            ProtoAdapter<MobileNetworkInfoMessage> protoAdapter = MobileNetworkInfoMessage.ADAPTER;
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 1, networkInfoMessage.mobile_network_info);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 2, networkInfoMessage.mobile_network_signal_info);
            WifiNetworkInfoMessage.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, networkInfoMessage.wifi_network_info);
            MobileNetworkSignalInfoMessage.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, networkInfoMessage.mobileNetworkSignalInfoLogs);
            NoNetworkSignalInfoMessage.ADAPTER.asRepeated().encodeWithTag(protoWriter, 5, networkInfoMessage.noNetworkSignalInfoLogs);
            NetworkDiagnosticTestResultsMessage.ADAPTER.asRepeated().encodeWithTag(protoWriter, 6, networkInfoMessage.networkDiagnosticTestResults);
            protoWriter.writeBytes(networkInfoMessage.unknownFields());
        }

        public int encodedSize(NetworkInfoMessage networkInfoMessage) {
            ProtoAdapter<MobileNetworkInfoMessage> protoAdapter = MobileNetworkInfoMessage.ADAPTER;
            int encodedSizeWithTag = NoNetworkSignalInfoMessage.ADAPTER.asRepeated().encodedSizeWithTag(5, networkInfoMessage.noNetworkSignalInfoLogs) + MobileNetworkSignalInfoMessage.ADAPTER.asRepeated().encodedSizeWithTag(4, networkInfoMessage.mobileNetworkSignalInfoLogs) + WifiNetworkInfoMessage.ADAPTER.asRepeated().encodedSizeWithTag(3, networkInfoMessage.wifi_network_info) + protoAdapter.asRepeated().encodedSizeWithTag(2, networkInfoMessage.mobile_network_signal_info) + protoAdapter.asRepeated().encodedSizeWithTag(1, networkInfoMessage.mobile_network_info);
            return networkInfoMessage.unknownFields().size() + NetworkDiagnosticTestResultsMessage.ADAPTER.asRepeated().encodedSizeWithTag(6, networkInfoMessage.networkDiagnosticTestResults) + encodedSizeWithTag;
        }

        public NetworkInfoMessage redact(NetworkInfoMessage networkInfoMessage) {
            Builder newBuilder = networkInfoMessage.newBuilder();
            List<MobileNetworkInfoMessage> list = newBuilder.mobile_network_info;
            ProtoAdapter<MobileNetworkInfoMessage> protoAdapter = MobileNetworkInfoMessage.ADAPTER;
            Internal.redactElements(list, protoAdapter);
            Internal.redactElements(newBuilder.mobile_network_signal_info, protoAdapter);
            Internal.redactElements(newBuilder.wifi_network_info, WifiNetworkInfoMessage.ADAPTER);
            Internal.redactElements(newBuilder.mobileNetworkSignalInfoLogs, MobileNetworkSignalInfoMessage.ADAPTER);
            Internal.redactElements(newBuilder.noNetworkSignalInfoLogs, NoNetworkSignalInfoMessage.ADAPTER);
            Internal.redactElements(newBuilder.networkDiagnosticTestResults, NetworkDiagnosticTestResultsMessage.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public NetworkInfoMessage(List<MobileNetworkInfoMessage> list, List<MobileNetworkInfoMessage> list2, List<WifiNetworkInfoMessage> list3, List<MobileNetworkSignalInfoMessage> list4, List<NoNetworkSignalInfoMessage> list5, List<NetworkDiagnosticTestResultsMessage> list6) {
        this(list, list2, list3, list4, list5, list6, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkInfoMessage)) {
            return false;
        }
        NetworkInfoMessage networkInfoMessage = (NetworkInfoMessage) obj;
        if (!unknownFields().equals(networkInfoMessage.unknownFields()) || !this.mobile_network_info.equals(networkInfoMessage.mobile_network_info) || !this.mobile_network_signal_info.equals(networkInfoMessage.mobile_network_signal_info) || !this.wifi_network_info.equals(networkInfoMessage.wifi_network_info) || !this.mobileNetworkSignalInfoLogs.equals(networkInfoMessage.mobileNetworkSignalInfoLogs) || !this.noNetworkSignalInfoLogs.equals(networkInfoMessage.noNetworkSignalInfoLogs) || !this.networkDiagnosticTestResults.equals(networkInfoMessage.networkDiagnosticTestResults)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = this.mobile_network_info.hashCode();
        int hashCode2 = this.mobile_network_signal_info.hashCode();
        int hashCode3 = this.wifi_network_info.hashCode();
        int hashCode4 = this.mobileNetworkSignalInfoLogs.hashCode();
        int hashCode5 = this.noNetworkSignalInfoLogs.hashCode();
        int hashCode6 = this.networkDiagnosticTestResults.hashCode() + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (unknownFields().hashCode() * 37)) * 37)) * 37)) * 37)) * 37)) * 37);
        this.hashCode = hashCode6;
        return hashCode6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.mobile_network_info.isEmpty()) {
            sb.append(", mobile_network_info=");
            sb.append(this.mobile_network_info);
        }
        if (!this.mobile_network_signal_info.isEmpty()) {
            sb.append(", mobile_network_signal_info=");
            sb.append(this.mobile_network_signal_info);
        }
        if (!this.wifi_network_info.isEmpty()) {
            sb.append(", wifi_network_info=");
            sb.append(this.wifi_network_info);
        }
        if (!this.mobileNetworkSignalInfoLogs.isEmpty()) {
            sb.append(", mobileNetworkSignalInfoLogs=");
            sb.append(this.mobileNetworkSignalInfoLogs);
        }
        if (!this.noNetworkSignalInfoLogs.isEmpty()) {
            sb.append(", noNetworkSignalInfoLogs=");
            sb.append(this.noNetworkSignalInfoLogs);
        }
        if (!this.networkDiagnosticTestResults.isEmpty()) {
            sb.append(", networkDiagnosticTestResults=");
            sb.append(this.networkDiagnosticTestResults);
        }
        return c.a(sb, 0, 2, "NetworkInfoMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public NetworkInfoMessage(List<MobileNetworkInfoMessage> list, List<MobileNetworkInfoMessage> list2, List<WifiNetworkInfoMessage> list3, List<MobileNetworkSignalInfoMessage> list4, List<NoNetworkSignalInfoMessage> list5, List<NetworkDiagnosticTestResultsMessage> list6, ByteString byteString) {
        super(ADAPTER, byteString);
        this.mobile_network_info = Internal.immutableCopyOf("mobile_network_info", list);
        this.mobile_network_signal_info = Internal.immutableCopyOf("mobile_network_signal_info", list2);
        this.wifi_network_info = Internal.immutableCopyOf("wifi_network_info", list3);
        this.mobileNetworkSignalInfoLogs = Internal.immutableCopyOf("mobileNetworkSignalInfoLogs", list4);
        this.noNetworkSignalInfoLogs = Internal.immutableCopyOf("noNetworkSignalInfoLogs", list5);
        this.networkDiagnosticTestResults = Internal.immutableCopyOf("networkDiagnosticTestResults", list6);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.mobile_network_info = Internal.copyOf("mobile_network_info", this.mobile_network_info);
        builder.mobile_network_signal_info = Internal.copyOf("mobile_network_signal_info", this.mobile_network_signal_info);
        builder.wifi_network_info = Internal.copyOf("wifi_network_info", this.wifi_network_info);
        builder.mobileNetworkSignalInfoLogs = Internal.copyOf("mobileNetworkSignalInfoLogs", this.mobileNetworkSignalInfoLogs);
        builder.noNetworkSignalInfoLogs = Internal.copyOf("noNetworkSignalInfoLogs", this.noNetworkSignalInfoLogs);
        builder.networkDiagnosticTestResults = Internal.copyOf("networkDiagnosticTestResults", this.networkDiagnosticTestResults);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
