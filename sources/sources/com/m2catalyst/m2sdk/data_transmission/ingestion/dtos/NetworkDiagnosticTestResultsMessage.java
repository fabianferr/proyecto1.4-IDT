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

public final class NetworkDiagnosticTestResultsMessage extends Message<NetworkDiagnosticTestResultsMessage, Builder> {
    public static final ProtoAdapter<NetworkDiagnosticTestResultsMessage> ADAPTER = new ProtoAdapter_NetworkDiagnosticTestResultsMessage();
    public static final Integer DEFAULT_CELLIDCHANGED = 0;
    public static final Integer DEFAULT_CONNECTIONTYPE = 0;
    public static final Long DEFAULT_ENDTIME = 0L;
    public static final Long DEFAULT_STARTTIME = 0L;
    public static final Integer DEFAULT_TESTTRIGGER = 0;
    public static final Integer DEFAULT_TESTTYPE = 0;
    public static final Integer DEFAULT_TIMEOFFSET = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 24)
    public final Integer cellIdChanged;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 23)
    public final Integer connectionType;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.BandwidthTestResultsMessage#ADAPTER", tag = 26)
    public final BandwidthTestResultsMessage downloadTestResults;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 21)
    public final Long endTime;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LatencyTestResultsMessage#ADAPTER", tag = 25)
    public final LatencyTestResultsMessage latencyResults;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.MobileNetworkSignalInfoMessage#ADAPTER", tag = 28)
    public final MobileNetworkSignalInfoMessage mnsi;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 20)
    public final Long startTime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 29)
    public final Integer testTrigger;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 30)
    public final Integer testType;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 22)
    public final Integer timeOffset;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.BandwidthTestResultsMessage#ADAPTER", tag = 27)
    public final BandwidthTestResultsMessage uploadTestResults;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.WifiNetworkInfoMessage#ADAPTER", tag = 31)
    public final WifiNetworkInfoMessage wifiNetworkInfo;

    public static final class Builder extends Message.Builder<NetworkDiagnosticTestResultsMessage, Builder> {
        public Integer cellIdChanged;
        public Integer connectionType;
        public BandwidthTestResultsMessage downloadTestResults;
        public Long endTime;
        public LatencyTestResultsMessage latencyResults;
        public MobileNetworkSignalInfoMessage mnsi;
        public Long startTime;
        public Integer testTrigger;
        public Integer testType;
        public Integer timeOffset;
        public BandwidthTestResultsMessage uploadTestResults;
        public WifiNetworkInfoMessage wifiNetworkInfo;

        public Builder cellIdChanged(Integer num) {
            this.cellIdChanged = num;
            return this;
        }

        public Builder connectionType(Integer num) {
            this.connectionType = num;
            return this;
        }

        public Builder downloadTestResults(BandwidthTestResultsMessage bandwidthTestResultsMessage) {
            this.downloadTestResults = bandwidthTestResultsMessage;
            return this;
        }

        public Builder endTime(Long l) {
            this.endTime = l;
            return this;
        }

        public Builder latencyResults(LatencyTestResultsMessage latencyTestResultsMessage) {
            this.latencyResults = latencyTestResultsMessage;
            return this;
        }

        public Builder mnsi(MobileNetworkSignalInfoMessage mobileNetworkSignalInfoMessage) {
            this.mnsi = mobileNetworkSignalInfoMessage;
            return this;
        }

        public Builder startTime(Long l) {
            this.startTime = l;
            return this;
        }

        public Builder testTrigger(Integer num) {
            this.testTrigger = num;
            return this;
        }

        public Builder testType(Integer num) {
            this.testType = num;
            return this;
        }

        public Builder timeOffset(Integer num) {
            this.timeOffset = num;
            return this;
        }

        public Builder uploadTestResults(BandwidthTestResultsMessage bandwidthTestResultsMessage) {
            this.uploadTestResults = bandwidthTestResultsMessage;
            return this;
        }

        public Builder wifiNetworkInfo(WifiNetworkInfoMessage wifiNetworkInfoMessage) {
            this.wifiNetworkInfo = wifiNetworkInfoMessage;
            return this;
        }

        public NetworkDiagnosticTestResultsMessage build() {
            return new NetworkDiagnosticTestResultsMessage(this.startTime, this.endTime, this.timeOffset, this.connectionType, this.cellIdChanged, this.latencyResults, this.downloadTestResults, this.uploadTestResults, this.mnsi, this.testTrigger, this.testType, this.wifiNetworkInfo, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_NetworkDiagnosticTestResultsMessage extends ProtoAdapter<NetworkDiagnosticTestResultsMessage> {
        public ProtoAdapter_NetworkDiagnosticTestResultsMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) NetworkDiagnosticTestResultsMessage.class);
        }

        public NetworkDiagnosticTestResultsMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 20:
                            builder.startTime(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 21:
                            builder.endTime(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 22:
                            builder.timeOffset(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 23:
                            builder.connectionType(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 24:
                            builder.cellIdChanged(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 25:
                            builder.latencyResults(LatencyTestResultsMessage.ADAPTER.decode(protoReader));
                            break;
                        case 26:
                            builder.downloadTestResults(BandwidthTestResultsMessage.ADAPTER.decode(protoReader));
                            break;
                        case 27:
                            builder.uploadTestResults(BandwidthTestResultsMessage.ADAPTER.decode(protoReader));
                            break;
                        case 28:
                            builder.mnsi(MobileNetworkSignalInfoMessage.ADAPTER.decode(protoReader));
                            break;
                        case 29:
                            builder.testTrigger(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 30:
                            builder.testType(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 31:
                            builder.wifiNetworkInfo(WifiNetworkInfoMessage.ADAPTER.decode(protoReader));
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

        public void encode(ProtoWriter protoWriter, NetworkDiagnosticTestResultsMessage networkDiagnosticTestResultsMessage) {
            Long l = networkDiagnosticTestResultsMessage.startTime;
            if (l != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 20, l);
            }
            Long l2 = networkDiagnosticTestResultsMessage.endTime;
            if (l2 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 21, l2);
            }
            Integer num = networkDiagnosticTestResultsMessage.timeOffset;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 22, num);
            }
            Integer num2 = networkDiagnosticTestResultsMessage.connectionType;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 23, num2);
            }
            Integer num3 = networkDiagnosticTestResultsMessage.cellIdChanged;
            if (num3 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 24, num3);
            }
            LatencyTestResultsMessage latencyTestResultsMessage = networkDiagnosticTestResultsMessage.latencyResults;
            if (latencyTestResultsMessage != null) {
                LatencyTestResultsMessage.ADAPTER.encodeWithTag(protoWriter, 25, latencyTestResultsMessage);
            }
            BandwidthTestResultsMessage bandwidthTestResultsMessage = networkDiagnosticTestResultsMessage.downloadTestResults;
            if (bandwidthTestResultsMessage != null) {
                BandwidthTestResultsMessage.ADAPTER.encodeWithTag(protoWriter, 26, bandwidthTestResultsMessage);
            }
            BandwidthTestResultsMessage bandwidthTestResultsMessage2 = networkDiagnosticTestResultsMessage.uploadTestResults;
            if (bandwidthTestResultsMessage2 != null) {
                BandwidthTestResultsMessage.ADAPTER.encodeWithTag(protoWriter, 27, bandwidthTestResultsMessage2);
            }
            MobileNetworkSignalInfoMessage mobileNetworkSignalInfoMessage = networkDiagnosticTestResultsMessage.mnsi;
            if (mobileNetworkSignalInfoMessage != null) {
                MobileNetworkSignalInfoMessage.ADAPTER.encodeWithTag(protoWriter, 28, mobileNetworkSignalInfoMessage);
            }
            Integer num4 = networkDiagnosticTestResultsMessage.testTrigger;
            if (num4 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 29, num4);
            }
            Integer num5 = networkDiagnosticTestResultsMessage.testType;
            if (num5 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 30, num5);
            }
            WifiNetworkInfoMessage wifiNetworkInfoMessage = networkDiagnosticTestResultsMessage.wifiNetworkInfo;
            if (wifiNetworkInfoMessage != null) {
                WifiNetworkInfoMessage.ADAPTER.encodeWithTag(protoWriter, 31, wifiNetworkInfoMessage);
            }
            protoWriter.writeBytes(networkDiagnosticTestResultsMessage.unknownFields());
        }

        public int encodedSize(NetworkDiagnosticTestResultsMessage networkDiagnosticTestResultsMessage) {
            Long l = networkDiagnosticTestResultsMessage.startTime;
            int i = 0;
            int encodedSizeWithTag = l != null ? ProtoAdapter.INT64.encodedSizeWithTag(20, l) : 0;
            Long l2 = networkDiagnosticTestResultsMessage.endTime;
            int encodedSizeWithTag2 = encodedSizeWithTag + (l2 != null ? ProtoAdapter.INT64.encodedSizeWithTag(21, l2) : 0);
            Integer num = networkDiagnosticTestResultsMessage.timeOffset;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(22, num) : 0);
            Integer num2 = networkDiagnosticTestResultsMessage.connectionType;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(23, num2) : 0);
            Integer num3 = networkDiagnosticTestResultsMessage.cellIdChanged;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (num3 != null ? ProtoAdapter.INT32.encodedSizeWithTag(24, num3) : 0);
            LatencyTestResultsMessage latencyTestResultsMessage = networkDiagnosticTestResultsMessage.latencyResults;
            int encodedSizeWithTag6 = encodedSizeWithTag5 + (latencyTestResultsMessage != null ? LatencyTestResultsMessage.ADAPTER.encodedSizeWithTag(25, latencyTestResultsMessage) : 0);
            BandwidthTestResultsMessage bandwidthTestResultsMessage = networkDiagnosticTestResultsMessage.downloadTestResults;
            int encodedSizeWithTag7 = encodedSizeWithTag6 + (bandwidthTestResultsMessage != null ? BandwidthTestResultsMessage.ADAPTER.encodedSizeWithTag(26, bandwidthTestResultsMessage) : 0);
            BandwidthTestResultsMessage bandwidthTestResultsMessage2 = networkDiagnosticTestResultsMessage.uploadTestResults;
            int encodedSizeWithTag8 = encodedSizeWithTag7 + (bandwidthTestResultsMessage2 != null ? BandwidthTestResultsMessage.ADAPTER.encodedSizeWithTag(27, bandwidthTestResultsMessage2) : 0);
            MobileNetworkSignalInfoMessage mobileNetworkSignalInfoMessage = networkDiagnosticTestResultsMessage.mnsi;
            int encodedSizeWithTag9 = encodedSizeWithTag8 + (mobileNetworkSignalInfoMessage != null ? MobileNetworkSignalInfoMessage.ADAPTER.encodedSizeWithTag(28, mobileNetworkSignalInfoMessage) : 0);
            Integer num4 = networkDiagnosticTestResultsMessage.testTrigger;
            int encodedSizeWithTag10 = encodedSizeWithTag9 + (num4 != null ? ProtoAdapter.INT32.encodedSizeWithTag(29, num4) : 0);
            Integer num5 = networkDiagnosticTestResultsMessage.testType;
            int encodedSizeWithTag11 = encodedSizeWithTag10 + (num5 != null ? ProtoAdapter.INT32.encodedSizeWithTag(30, num5) : 0);
            WifiNetworkInfoMessage wifiNetworkInfoMessage = networkDiagnosticTestResultsMessage.wifiNetworkInfo;
            if (wifiNetworkInfoMessage != null) {
                i = WifiNetworkInfoMessage.ADAPTER.encodedSizeWithTag(31, wifiNetworkInfoMessage);
            }
            return networkDiagnosticTestResultsMessage.unknownFields().size() + encodedSizeWithTag11 + i;
        }

        public NetworkDiagnosticTestResultsMessage redact(NetworkDiagnosticTestResultsMessage networkDiagnosticTestResultsMessage) {
            Builder newBuilder = networkDiagnosticTestResultsMessage.newBuilder();
            LatencyTestResultsMessage latencyTestResultsMessage = newBuilder.latencyResults;
            if (latencyTestResultsMessage != null) {
                newBuilder.latencyResults = LatencyTestResultsMessage.ADAPTER.redact(latencyTestResultsMessage);
            }
            BandwidthTestResultsMessage bandwidthTestResultsMessage = newBuilder.downloadTestResults;
            if (bandwidthTestResultsMessage != null) {
                newBuilder.downloadTestResults = BandwidthTestResultsMessage.ADAPTER.redact(bandwidthTestResultsMessage);
            }
            BandwidthTestResultsMessage bandwidthTestResultsMessage2 = newBuilder.uploadTestResults;
            if (bandwidthTestResultsMessage2 != null) {
                newBuilder.uploadTestResults = BandwidthTestResultsMessage.ADAPTER.redact(bandwidthTestResultsMessage2);
            }
            MobileNetworkSignalInfoMessage mobileNetworkSignalInfoMessage = newBuilder.mnsi;
            if (mobileNetworkSignalInfoMessage != null) {
                newBuilder.mnsi = MobileNetworkSignalInfoMessage.ADAPTER.redact(mobileNetworkSignalInfoMessage);
            }
            WifiNetworkInfoMessage wifiNetworkInfoMessage = newBuilder.wifiNetworkInfo;
            if (wifiNetworkInfoMessage != null) {
                newBuilder.wifiNetworkInfo = WifiNetworkInfoMessage.ADAPTER.redact(wifiNetworkInfoMessage);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public NetworkDiagnosticTestResultsMessage(Long l, Long l2, Integer num, Integer num2, Integer num3, LatencyTestResultsMessage latencyTestResultsMessage, BandwidthTestResultsMessage bandwidthTestResultsMessage, BandwidthTestResultsMessage bandwidthTestResultsMessage2, MobileNetworkSignalInfoMessage mobileNetworkSignalInfoMessage, Integer num4, Integer num5, WifiNetworkInfoMessage wifiNetworkInfoMessage) {
        this(l, l2, num, num2, num3, latencyTestResultsMessage, bandwidthTestResultsMessage, bandwidthTestResultsMessage2, mobileNetworkSignalInfoMessage, num4, num5, wifiNetworkInfoMessage, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkDiagnosticTestResultsMessage)) {
            return false;
        }
        NetworkDiagnosticTestResultsMessage networkDiagnosticTestResultsMessage = (NetworkDiagnosticTestResultsMessage) obj;
        if (!unknownFields().equals(networkDiagnosticTestResultsMessage.unknownFields()) || !Internal.equals(this.startTime, networkDiagnosticTestResultsMessage.startTime) || !Internal.equals(this.endTime, networkDiagnosticTestResultsMessage.endTime) || !Internal.equals(this.timeOffset, networkDiagnosticTestResultsMessage.timeOffset) || !Internal.equals(this.connectionType, networkDiagnosticTestResultsMessage.connectionType) || !Internal.equals(this.cellIdChanged, networkDiagnosticTestResultsMessage.cellIdChanged) || !Internal.equals(this.latencyResults, networkDiagnosticTestResultsMessage.latencyResults) || !Internal.equals(this.downloadTestResults, networkDiagnosticTestResultsMessage.downloadTestResults) || !Internal.equals(this.uploadTestResults, networkDiagnosticTestResultsMessage.uploadTestResults) || !Internal.equals(this.mnsi, networkDiagnosticTestResultsMessage.mnsi) || !Internal.equals(this.testTrigger, networkDiagnosticTestResultsMessage.testTrigger) || !Internal.equals(this.testType, networkDiagnosticTestResultsMessage.testType) || !Internal.equals(this.wifiNetworkInfo, networkDiagnosticTestResultsMessage.wifiNetworkInfo)) {
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
        Long l = this.startTime;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.endTime;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.timeOffset;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.connectionType;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.cellIdChanged;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        LatencyTestResultsMessage latencyTestResultsMessage = this.latencyResults;
        int hashCode7 = (hashCode6 + (latencyTestResultsMessage != null ? latencyTestResultsMessage.hashCode() : 0)) * 37;
        BandwidthTestResultsMessage bandwidthTestResultsMessage = this.downloadTestResults;
        int hashCode8 = (hashCode7 + (bandwidthTestResultsMessage != null ? bandwidthTestResultsMessage.hashCode() : 0)) * 37;
        BandwidthTestResultsMessage bandwidthTestResultsMessage2 = this.uploadTestResults;
        int hashCode9 = (hashCode8 + (bandwidthTestResultsMessage2 != null ? bandwidthTestResultsMessage2.hashCode() : 0)) * 37;
        MobileNetworkSignalInfoMessage mobileNetworkSignalInfoMessage = this.mnsi;
        int hashCode10 = (hashCode9 + (mobileNetworkSignalInfoMessage != null ? mobileNetworkSignalInfoMessage.hashCode() : 0)) * 37;
        Integer num4 = this.testTrigger;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.testType;
        int hashCode12 = (hashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37;
        WifiNetworkInfoMessage wifiNetworkInfoMessage = this.wifiNetworkInfo;
        if (wifiNetworkInfoMessage != null) {
            i2 = wifiNetworkInfoMessage.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.startTime != null) {
            sb.append(", startTime=");
            sb.append(this.startTime);
        }
        if (this.endTime != null) {
            sb.append(", endTime=");
            sb.append(this.endTime);
        }
        if (this.timeOffset != null) {
            sb.append(", timeOffset=");
            sb.append(this.timeOffset);
        }
        if (this.connectionType != null) {
            sb.append(", connectionType=");
            sb.append(this.connectionType);
        }
        if (this.cellIdChanged != null) {
            sb.append(", cellIdChanged=");
            sb.append(this.cellIdChanged);
        }
        if (this.latencyResults != null) {
            sb.append(", latencyResults=");
            sb.append(this.latencyResults);
        }
        if (this.downloadTestResults != null) {
            sb.append(", downloadTestResults=");
            sb.append(this.downloadTestResults);
        }
        if (this.uploadTestResults != null) {
            sb.append(", uploadTestResults=");
            sb.append(this.uploadTestResults);
        }
        if (this.mnsi != null) {
            sb.append(", mnsi=");
            sb.append(this.mnsi);
        }
        if (this.testTrigger != null) {
            sb.append(", testTrigger=");
            sb.append(this.testTrigger);
        }
        if (this.testType != null) {
            sb.append(", testType=");
            sb.append(this.testType);
        }
        if (this.wifiNetworkInfo != null) {
            sb.append(", wifiNetworkInfo=");
            sb.append(this.wifiNetworkInfo);
        }
        return c.a(sb, 0, 2, "NetworkDiagnosticTestResultsMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public NetworkDiagnosticTestResultsMessage(Long l, Long l2, Integer num, Integer num2, Integer num3, LatencyTestResultsMessage latencyTestResultsMessage, BandwidthTestResultsMessage bandwidthTestResultsMessage, BandwidthTestResultsMessage bandwidthTestResultsMessage2, MobileNetworkSignalInfoMessage mobileNetworkSignalInfoMessage, Integer num4, Integer num5, WifiNetworkInfoMessage wifiNetworkInfoMessage, ByteString byteString) {
        super(ADAPTER, byteString);
        this.startTime = l;
        this.endTime = l2;
        this.timeOffset = num;
        this.connectionType = num2;
        this.cellIdChanged = num3;
        this.latencyResults = latencyTestResultsMessage;
        this.downloadTestResults = bandwidthTestResultsMessage;
        this.uploadTestResults = bandwidthTestResultsMessage2;
        this.mnsi = mobileNetworkSignalInfoMessage;
        this.testTrigger = num4;
        this.testType = num5;
        this.wifiNetworkInfo = wifiNetworkInfoMessage;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.startTime = this.startTime;
        builder.endTime = this.endTime;
        builder.timeOffset = this.timeOffset;
        builder.connectionType = this.connectionType;
        builder.cellIdChanged = this.cellIdChanged;
        builder.latencyResults = this.latencyResults;
        builder.downloadTestResults = this.downloadTestResults;
        builder.uploadTestResults = this.uploadTestResults;
        builder.mnsi = this.mnsi;
        builder.testTrigger = this.testTrigger;
        builder.testType = this.testType;
        builder.wifiNetworkInfo = this.wifiNetworkInfo;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
