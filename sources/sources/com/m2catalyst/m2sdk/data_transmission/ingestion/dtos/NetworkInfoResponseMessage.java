package com.m2catalyst.m2sdk.data_transmission.ingestion.dtos;

import com.m2catalyst.m2sdk.c;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.ByteString;

public final class NetworkInfoResponseMessage extends Message<NetworkInfoResponseMessage, Builder> {
    public static final ProtoAdapter<NetworkInfoResponseMessage> ADAPTER = new ProtoAdapter_NetworkInfoResponseMessage();
    public static final Integer DEFAULT_MOBILE_NETWORK_SIGNAL_INFO_LOGS_ACCEPTED = 0;
    public static final Integer DEFAULT_NETWORK_DIAGNOSTIC_TEST_RESULTS_ACCEPTED = 0;
    public static final Integer DEFAULT_NO_NETWORK_SIGNAL_INFO_LOGS_ACCEPTED = 0;
    public static final Integer DEFAULT_WIFI_NETWORK_INFO_LOGS_ACCEPTED = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer mobile_network_signal_info_logs_accepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer network_diagnostic_test_results_accepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer no_network_signal_info_logs_accepted;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer wifi_network_info_logs_accepted;

    public static final class Builder extends Message.Builder<NetworkInfoResponseMessage, Builder> {
        public Integer mobile_network_signal_info_logs_accepted;
        public Integer network_diagnostic_test_results_accepted;
        public Integer no_network_signal_info_logs_accepted;
        public Integer wifi_network_info_logs_accepted;

        public Builder mobile_network_signal_info_logs_accepted(Integer num) {
            this.mobile_network_signal_info_logs_accepted = num;
            return this;
        }

        public Builder network_diagnostic_test_results_accepted(Integer num) {
            this.network_diagnostic_test_results_accepted = num;
            return this;
        }

        public Builder no_network_signal_info_logs_accepted(Integer num) {
            this.no_network_signal_info_logs_accepted = num;
            return this;
        }

        public Builder wifi_network_info_logs_accepted(Integer num) {
            this.wifi_network_info_logs_accepted = num;
            return this;
        }

        public NetworkInfoResponseMessage build() {
            return new NetworkInfoResponseMessage(this.wifi_network_info_logs_accepted, this.mobile_network_signal_info_logs_accepted, this.no_network_signal_info_logs_accepted, this.network_diagnostic_test_results_accepted, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_NetworkInfoResponseMessage extends ProtoAdapter<NetworkInfoResponseMessage> {
        public ProtoAdapter_NetworkInfoResponseMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) NetworkInfoResponseMessage.class);
        }

        public NetworkInfoResponseMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.wifi_network_info_logs_accepted(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.mobile_network_signal_info_logs_accepted(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.no_network_signal_info_logs_accepted(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.network_diagnostic_test_results_accepted(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, NetworkInfoResponseMessage networkInfoResponseMessage) {
            Integer num = networkInfoResponseMessage.wifi_network_info_logs_accepted;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, num);
            }
            Integer num2 = networkInfoResponseMessage.mobile_network_signal_info_logs_accepted;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, num2);
            }
            Integer num3 = networkInfoResponseMessage.no_network_signal_info_logs_accepted;
            if (num3 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, num3);
            }
            Integer num4 = networkInfoResponseMessage.network_diagnostic_test_results_accepted;
            if (num4 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, num4);
            }
            protoWriter.writeBytes(networkInfoResponseMessage.unknownFields());
        }

        public int encodedSize(NetworkInfoResponseMessage networkInfoResponseMessage) {
            Integer num = networkInfoResponseMessage.wifi_network_info_logs_accepted;
            int i = 0;
            int encodedSizeWithTag = num != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, num) : 0;
            Integer num2 = networkInfoResponseMessage.mobile_network_signal_info_logs_accepted;
            int encodedSizeWithTag2 = encodedSizeWithTag + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(2, num2) : 0);
            Integer num3 = networkInfoResponseMessage.no_network_signal_info_logs_accepted;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (num3 != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, num3) : 0);
            Integer num4 = networkInfoResponseMessage.network_diagnostic_test_results_accepted;
            if (num4 != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(4, num4);
            }
            return networkInfoResponseMessage.unknownFields().size() + encodedSizeWithTag3 + i;
        }

        public NetworkInfoResponseMessage redact(NetworkInfoResponseMessage networkInfoResponseMessage) {
            Builder newBuilder = networkInfoResponseMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public NetworkInfoResponseMessage(Integer num, Integer num2, Integer num3, Integer num4) {
        this(num, num2, num3, num4, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkInfoResponseMessage)) {
            return false;
        }
        NetworkInfoResponseMessage networkInfoResponseMessage = (NetworkInfoResponseMessage) obj;
        if (!unknownFields().equals(networkInfoResponseMessage.unknownFields()) || !Internal.equals(this.wifi_network_info_logs_accepted, networkInfoResponseMessage.wifi_network_info_logs_accepted) || !Internal.equals(this.mobile_network_signal_info_logs_accepted, networkInfoResponseMessage.mobile_network_signal_info_logs_accepted) || !Internal.equals(this.no_network_signal_info_logs_accepted, networkInfoResponseMessage.no_network_signal_info_logs_accepted) || !Internal.equals(this.network_diagnostic_test_results_accepted, networkInfoResponseMessage.network_diagnostic_test_results_accepted)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.wifi_network_info_logs_accepted;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.mobile_network_signal_info_logs_accepted;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.no_network_signal_info_logs_accepted;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.network_diagnostic_test_results_accepted;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.wifi_network_info_logs_accepted != null) {
            sb.append(", wifi_network_info_logs_accepted=");
            sb.append(this.wifi_network_info_logs_accepted);
        }
        if (this.mobile_network_signal_info_logs_accepted != null) {
            sb.append(", mobile_network_signal_info_logs_accepted=");
            sb.append(this.mobile_network_signal_info_logs_accepted);
        }
        if (this.no_network_signal_info_logs_accepted != null) {
            sb.append(", no_network_signal_info_logs_accepted=");
            sb.append(this.no_network_signal_info_logs_accepted);
        }
        if (this.network_diagnostic_test_results_accepted != null) {
            sb.append(", network_diagnostic_test_results_accepted=");
            sb.append(this.network_diagnostic_test_results_accepted);
        }
        return c.a(sb, 0, 2, "NetworkInfoResponseMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public NetworkInfoResponseMessage(Integer num, Integer num2, Integer num3, Integer num4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.wifi_network_info_logs_accepted = num;
        this.mobile_network_signal_info_logs_accepted = num2;
        this.no_network_signal_info_logs_accepted = num3;
        this.network_diagnostic_test_results_accepted = num4;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.wifi_network_info_logs_accepted = this.wifi_network_info_logs_accepted;
        builder.mobile_network_signal_info_logs_accepted = this.mobile_network_signal_info_logs_accepted;
        builder.no_network_signal_info_logs_accepted = this.no_network_signal_info_logs_accepted;
        builder.network_diagnostic_test_results_accepted = this.network_diagnostic_test_results_accepted;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
