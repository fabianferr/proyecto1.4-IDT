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

public final class ApiResponseMessage extends Message<ApiResponseMessage, Builder> {
    public static final ProtoAdapter<ApiResponseMessage> ADAPTER = new ProtoAdapter_ApiResponseMessage();
    public static final String DEFAULT_DETAILS = "";
    public static final Boolean DEFAULT_ENABLE_ERROR_REPORTING;
    public static final Integer DEFAULT_REPORT_STATUS = 0;
    public static final Long DEFAULT_RESYNC_DATE = 0L;
    public static final Boolean DEFAULT_SUCCESS;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String details;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.DeviceBatteryLogsResponseMessage#ADAPTER", tag = 28)
    public final DeviceBatteryLogsResponseMessage device_battery_logs_response;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 24)
    public final Boolean enable_error_reporting;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationInfoResponseMessage#ADAPTER", tag = 29)
    public final LocationInfoResponseMessage location_info_response;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoResponseMessage#ADAPTER", tag = 30)
    public final NetworkInfoResponseMessage network_info_response;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 25)
    public final Integer report_status;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 23)
    public final Long resync_date;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean success;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.SyncDeviceResponseMessage#ADAPTER", tag = 20)
    public final SyncDeviceResponseMessage sync_device_response;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.VerifyApiKeyResponseMessage#ADAPTER", tag = 22)
    public final VerifyApiKeyResponseMessage verify_api_key_response;

    public static final class Builder extends Message.Builder<ApiResponseMessage, Builder> {
        public String details;
        public DeviceBatteryLogsResponseMessage device_battery_logs_response;
        public Boolean enable_error_reporting;
        public LocationInfoResponseMessage location_info_response;
        public NetworkInfoResponseMessage network_info_response;
        public Integer report_status;
        public Long resync_date;
        public Boolean success;
        public SyncDeviceResponseMessage sync_device_response;
        public VerifyApiKeyResponseMessage verify_api_key_response;

        public Builder details(String str) {
            this.details = str;
            return this;
        }

        public Builder device_battery_logs_response(DeviceBatteryLogsResponseMessage deviceBatteryLogsResponseMessage) {
            this.device_battery_logs_response = deviceBatteryLogsResponseMessage;
            return this;
        }

        public Builder enable_error_reporting(Boolean bool) {
            this.enable_error_reporting = bool;
            return this;
        }

        public Builder location_info_response(LocationInfoResponseMessage locationInfoResponseMessage) {
            this.location_info_response = locationInfoResponseMessage;
            return this;
        }

        public Builder network_info_response(NetworkInfoResponseMessage networkInfoResponseMessage) {
            this.network_info_response = networkInfoResponseMessage;
            return this;
        }

        public Builder report_status(Integer num) {
            this.report_status = num;
            return this;
        }

        public Builder resync_date(Long l) {
            this.resync_date = l;
            return this;
        }

        public Builder success(Boolean bool) {
            this.success = bool;
            return this;
        }

        public Builder sync_device_response(SyncDeviceResponseMessage syncDeviceResponseMessage) {
            this.sync_device_response = syncDeviceResponseMessage;
            return this;
        }

        public Builder verify_api_key_response(VerifyApiKeyResponseMessage verifyApiKeyResponseMessage) {
            this.verify_api_key_response = verifyApiKeyResponseMessage;
            return this;
        }

        public ApiResponseMessage build() {
            return new ApiResponseMessage(this.success, this.details, this.sync_device_response, this.verify_api_key_response, this.resync_date, this.enable_error_reporting, this.report_status, this.device_battery_logs_response, this.location_info_response, this.network_info_response, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_ApiResponseMessage extends ProtoAdapter<ApiResponseMessage> {
        public ProtoAdapter_ApiResponseMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) ApiResponseMessage.class);
        }

        public ApiResponseMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.success(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.details(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 20) {
                    switch (nextTag) {
                        case 22:
                            builder.verify_api_key_response(VerifyApiKeyResponseMessage.ADAPTER.decode(protoReader));
                            break;
                        case 23:
                            builder.resync_date(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 24:
                            builder.enable_error_reporting(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 25:
                            builder.report_status(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        default:
                            switch (nextTag) {
                                case 28:
                                    builder.device_battery_logs_response(DeviceBatteryLogsResponseMessage.ADAPTER.decode(protoReader));
                                    break;
                                case 29:
                                    builder.location_info_response(LocationInfoResponseMessage.ADAPTER.decode(protoReader));
                                    break;
                                case 30:
                                    builder.network_info_response(NetworkInfoResponseMessage.ADAPTER.decode(protoReader));
                                    break;
                                default:
                                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                                    break;
                            }
                    }
                } else {
                    builder.sync_device_response(SyncDeviceResponseMessage.ADAPTER.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, ApiResponseMessage apiResponseMessage) {
            Boolean bool = apiResponseMessage.success;
            if (bool != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, bool);
            }
            String str = apiResponseMessage.details;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, str);
            }
            SyncDeviceResponseMessage syncDeviceResponseMessage = apiResponseMessage.sync_device_response;
            if (syncDeviceResponseMessage != null) {
                SyncDeviceResponseMessage.ADAPTER.encodeWithTag(protoWriter, 20, syncDeviceResponseMessage);
            }
            VerifyApiKeyResponseMessage verifyApiKeyResponseMessage = apiResponseMessage.verify_api_key_response;
            if (verifyApiKeyResponseMessage != null) {
                VerifyApiKeyResponseMessage.ADAPTER.encodeWithTag(protoWriter, 22, verifyApiKeyResponseMessage);
            }
            Long l = apiResponseMessage.resync_date;
            if (l != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 23, l);
            }
            Boolean bool2 = apiResponseMessage.enable_error_reporting;
            if (bool2 != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 24, bool2);
            }
            Integer num = apiResponseMessage.report_status;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 25, num);
            }
            DeviceBatteryLogsResponseMessage deviceBatteryLogsResponseMessage = apiResponseMessage.device_battery_logs_response;
            if (deviceBatteryLogsResponseMessage != null) {
                DeviceBatteryLogsResponseMessage.ADAPTER.encodeWithTag(protoWriter, 28, deviceBatteryLogsResponseMessage);
            }
            LocationInfoResponseMessage locationInfoResponseMessage = apiResponseMessage.location_info_response;
            if (locationInfoResponseMessage != null) {
                LocationInfoResponseMessage.ADAPTER.encodeWithTag(protoWriter, 29, locationInfoResponseMessage);
            }
            NetworkInfoResponseMessage networkInfoResponseMessage = apiResponseMessage.network_info_response;
            if (networkInfoResponseMessage != null) {
                NetworkInfoResponseMessage.ADAPTER.encodeWithTag(protoWriter, 30, networkInfoResponseMessage);
            }
            protoWriter.writeBytes(apiResponseMessage.unknownFields());
        }

        public int encodedSize(ApiResponseMessage apiResponseMessage) {
            Boolean bool = apiResponseMessage.success;
            int i = 0;
            int encodedSizeWithTag = bool != null ? ProtoAdapter.BOOL.encodedSizeWithTag(1, bool) : 0;
            String str = apiResponseMessage.details;
            int encodedSizeWithTag2 = encodedSizeWithTag + (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, str) : 0);
            SyncDeviceResponseMessage syncDeviceResponseMessage = apiResponseMessage.sync_device_response;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (syncDeviceResponseMessage != null ? SyncDeviceResponseMessage.ADAPTER.encodedSizeWithTag(20, syncDeviceResponseMessage) : 0);
            VerifyApiKeyResponseMessage verifyApiKeyResponseMessage = apiResponseMessage.verify_api_key_response;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (verifyApiKeyResponseMessage != null ? VerifyApiKeyResponseMessage.ADAPTER.encodedSizeWithTag(22, verifyApiKeyResponseMessage) : 0);
            Long l = apiResponseMessage.resync_date;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (l != null ? ProtoAdapter.INT64.encodedSizeWithTag(23, l) : 0);
            Boolean bool2 = apiResponseMessage.enable_error_reporting;
            int encodedSizeWithTag6 = encodedSizeWithTag5 + (bool2 != null ? ProtoAdapter.BOOL.encodedSizeWithTag(24, bool2) : 0);
            Integer num = apiResponseMessage.report_status;
            int encodedSizeWithTag7 = encodedSizeWithTag6 + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(25, num) : 0);
            DeviceBatteryLogsResponseMessage deviceBatteryLogsResponseMessage = apiResponseMessage.device_battery_logs_response;
            int encodedSizeWithTag8 = encodedSizeWithTag7 + (deviceBatteryLogsResponseMessage != null ? DeviceBatteryLogsResponseMessage.ADAPTER.encodedSizeWithTag(28, deviceBatteryLogsResponseMessage) : 0);
            LocationInfoResponseMessage locationInfoResponseMessage = apiResponseMessage.location_info_response;
            int encodedSizeWithTag9 = encodedSizeWithTag8 + (locationInfoResponseMessage != null ? LocationInfoResponseMessage.ADAPTER.encodedSizeWithTag(29, locationInfoResponseMessage) : 0);
            NetworkInfoResponseMessage networkInfoResponseMessage = apiResponseMessage.network_info_response;
            if (networkInfoResponseMessage != null) {
                i = NetworkInfoResponseMessage.ADAPTER.encodedSizeWithTag(30, networkInfoResponseMessage);
            }
            return apiResponseMessage.unknownFields().size() + encodedSizeWithTag9 + i;
        }

        public ApiResponseMessage redact(ApiResponseMessage apiResponseMessage) {
            Builder newBuilder = apiResponseMessage.newBuilder();
            SyncDeviceResponseMessage syncDeviceResponseMessage = newBuilder.sync_device_response;
            if (syncDeviceResponseMessage != null) {
                newBuilder.sync_device_response = SyncDeviceResponseMessage.ADAPTER.redact(syncDeviceResponseMessage);
            }
            VerifyApiKeyResponseMessage verifyApiKeyResponseMessage = newBuilder.verify_api_key_response;
            if (verifyApiKeyResponseMessage != null) {
                newBuilder.verify_api_key_response = VerifyApiKeyResponseMessage.ADAPTER.redact(verifyApiKeyResponseMessage);
            }
            DeviceBatteryLogsResponseMessage deviceBatteryLogsResponseMessage = newBuilder.device_battery_logs_response;
            if (deviceBatteryLogsResponseMessage != null) {
                newBuilder.device_battery_logs_response = DeviceBatteryLogsResponseMessage.ADAPTER.redact(deviceBatteryLogsResponseMessage);
            }
            LocationInfoResponseMessage locationInfoResponseMessage = newBuilder.location_info_response;
            if (locationInfoResponseMessage != null) {
                newBuilder.location_info_response = LocationInfoResponseMessage.ADAPTER.redact(locationInfoResponseMessage);
            }
            NetworkInfoResponseMessage networkInfoResponseMessage = newBuilder.network_info_response;
            if (networkInfoResponseMessage != null) {
                newBuilder.network_info_response = NetworkInfoResponseMessage.ADAPTER.redact(networkInfoResponseMessage);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        DEFAULT_SUCCESS = bool;
        DEFAULT_ENABLE_ERROR_REPORTING = bool;
    }

    public ApiResponseMessage(Boolean bool, String str, SyncDeviceResponseMessage syncDeviceResponseMessage, VerifyApiKeyResponseMessage verifyApiKeyResponseMessage, Long l, Boolean bool2, Integer num, DeviceBatteryLogsResponseMessage deviceBatteryLogsResponseMessage, LocationInfoResponseMessage locationInfoResponseMessage, NetworkInfoResponseMessage networkInfoResponseMessage) {
        this(bool, str, syncDeviceResponseMessage, verifyApiKeyResponseMessage, l, bool2, num, deviceBatteryLogsResponseMessage, locationInfoResponseMessage, networkInfoResponseMessage, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiResponseMessage)) {
            return false;
        }
        ApiResponseMessage apiResponseMessage = (ApiResponseMessage) obj;
        if (!unknownFields().equals(apiResponseMessage.unknownFields()) || !Internal.equals(this.success, apiResponseMessage.success) || !Internal.equals(this.details, apiResponseMessage.details) || !Internal.equals(this.sync_device_response, apiResponseMessage.sync_device_response) || !Internal.equals(this.verify_api_key_response, apiResponseMessage.verify_api_key_response) || !Internal.equals(this.resync_date, apiResponseMessage.resync_date) || !Internal.equals(this.enable_error_reporting, apiResponseMessage.enable_error_reporting) || !Internal.equals(this.report_status, apiResponseMessage.report_status) || !Internal.equals(this.device_battery_logs_response, apiResponseMessage.device_battery_logs_response) || !Internal.equals(this.location_info_response, apiResponseMessage.location_info_response) || !Internal.equals(this.network_info_response, apiResponseMessage.network_info_response)) {
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
        Boolean bool = this.success;
        int i2 = 0;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.details;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        SyncDeviceResponseMessage syncDeviceResponseMessage = this.sync_device_response;
        int hashCode4 = (hashCode3 + (syncDeviceResponseMessage != null ? syncDeviceResponseMessage.hashCode() : 0)) * 37;
        VerifyApiKeyResponseMessage verifyApiKeyResponseMessage = this.verify_api_key_response;
        int hashCode5 = (hashCode4 + (verifyApiKeyResponseMessage != null ? verifyApiKeyResponseMessage.hashCode() : 0)) * 37;
        Long l = this.resync_date;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool2 = this.enable_error_reporting;
        int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num = this.report_status;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        DeviceBatteryLogsResponseMessage deviceBatteryLogsResponseMessage = this.device_battery_logs_response;
        int hashCode9 = (hashCode8 + (deviceBatteryLogsResponseMessage != null ? deviceBatteryLogsResponseMessage.hashCode() : 0)) * 37;
        LocationInfoResponseMessage locationInfoResponseMessage = this.location_info_response;
        int hashCode10 = (hashCode9 + (locationInfoResponseMessage != null ? locationInfoResponseMessage.hashCode() : 0)) * 37;
        NetworkInfoResponseMessage networkInfoResponseMessage = this.network_info_response;
        if (networkInfoResponseMessage != null) {
            i2 = networkInfoResponseMessage.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.success != null) {
            sb.append(", success=");
            sb.append(this.success);
        }
        if (this.details != null) {
            sb.append(", details=");
            sb.append(this.details);
        }
        if (this.sync_device_response != null) {
            sb.append(", sync_device_response=");
            sb.append(this.sync_device_response);
        }
        if (this.verify_api_key_response != null) {
            sb.append(", verify_api_key_response=");
            sb.append(this.verify_api_key_response);
        }
        if (this.resync_date != null) {
            sb.append(", resync_date=");
            sb.append(this.resync_date);
        }
        if (this.enable_error_reporting != null) {
            sb.append(", enable_error_reporting=");
            sb.append(this.enable_error_reporting);
        }
        if (this.report_status != null) {
            sb.append(", report_status=");
            sb.append(this.report_status);
        }
        if (this.device_battery_logs_response != null) {
            sb.append(", device_battery_logs_response=");
            sb.append(this.device_battery_logs_response);
        }
        if (this.location_info_response != null) {
            sb.append(", location_info_response=");
            sb.append(this.location_info_response);
        }
        if (this.network_info_response != null) {
            sb.append(", network_info_response=");
            sb.append(this.network_info_response);
        }
        return c.a(sb, 0, 2, "ApiResponseMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    public ApiResponseMessage(Boolean bool, String str, SyncDeviceResponseMessage syncDeviceResponseMessage, VerifyApiKeyResponseMessage verifyApiKeyResponseMessage, Long l, Boolean bool2, Integer num, DeviceBatteryLogsResponseMessage deviceBatteryLogsResponseMessage, LocationInfoResponseMessage locationInfoResponseMessage, NetworkInfoResponseMessage networkInfoResponseMessage, ByteString byteString) {
        super(ADAPTER, byteString);
        this.success = bool;
        this.details = str;
        this.sync_device_response = syncDeviceResponseMessage;
        this.verify_api_key_response = verifyApiKeyResponseMessage;
        this.resync_date = l;
        this.enable_error_reporting = bool2;
        this.report_status = num;
        this.device_battery_logs_response = deviceBatteryLogsResponseMessage;
        this.location_info_response = locationInfoResponseMessage;
        this.network_info_response = networkInfoResponseMessage;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.success = this.success;
        builder.details = this.details;
        builder.sync_device_response = this.sync_device_response;
        builder.verify_api_key_response = this.verify_api_key_response;
        builder.resync_date = this.resync_date;
        builder.enable_error_reporting = this.enable_error_reporting;
        builder.report_status = this.report_status;
        builder.device_battery_logs_response = this.device_battery_logs_response;
        builder.location_info_response = this.location_info_response;
        builder.network_info_response = this.network_info_response;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
