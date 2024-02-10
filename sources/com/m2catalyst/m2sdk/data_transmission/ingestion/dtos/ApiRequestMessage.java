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

public final class ApiRequestMessage extends Message<ApiRequestMessage, Builder> {
    public static final ProtoAdapter<ApiRequestMessage> ADAPTER = new ProtoAdapter_ApiRequestMessage();
    public static final Integer DEFAULT_ANDROID_VERSION = 0;
    public static final String DEFAULT_API_KEY = "";
    public static final Integer DEFAULT_COMPANY_ID = -1;
    public static final Integer DEFAULT_DEVICE_ID = -1;
    public static final String DEFAULT_HOST_PACKAGE_NAME = "";
    public static final String DEFAULT_IOS_VERSION = "";
    public static final Long DEFAULT_MESSAGE_CREATE_TIME = 0L;
    public static final String DEFAULT_PERMISSIONS = "";
    public static final Integer DEFAULT_PERMISSION_LOCATION = -1;
    public static final Integer DEFAULT_PERMISSION_PACKAGE_USAGE_STATS = -1;
    public static final Integer DEFAULT_PERMISSION_READ_PHONE_STATE = -1;
    public static final Boolean DEFAULT_PERSISTENT_MODE = Boolean.FALSE;
    public static final String DEFAULT_VERSION = "";
    public static final Integer DEFAULT_VERSION_CODE = -1;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 21)
    public final Integer android_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String api_key;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer company_id;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.DeviceBatteryLogMessage#ADAPTER", label = WireField.Label.REPEATED, tag = 8)
    public final List<DeviceBatteryLogMessage> device_battery_log;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer device_id;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.DeviceInfoMessage#ADAPTER", tag = 20)
    public final DeviceInfoMessage device_info;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.AppErrorReportMessage#ADAPTER", label = WireField.Label.REPEATED, tag = 9)
    public final List<AppErrorReportMessage> error_reports;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 25)
    public final String host_package_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 33)
    public final String ios_version;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.LocationInfoMessage#ADAPTER", tag = 29)
    public final LocationInfoMessage location_info;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 28)
    public final Long message_create_time;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.MonitoringStatsMessage#ADAPTER", tag = 27)
    public final MonitoringStatsMessage monitoring_stats;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.MonitoringStatsV10Message#ADAPTER", tag = 35)
    public final MonitoringStatsV10Message monitoring_stats_v10;
    @WireField(adapter = "com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.NetworkInfoMessage#ADAPTER", tag = 22)
    public final NetworkInfoMessage network_info;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 30)
    public final Integer permission_location;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 32)
    public final Integer permission_package_usage_stats;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 31)
    public final Integer permission_read_phone_state;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 34)
    public final String permissions;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean persistent_mode;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 26)
    public final Integer version_code;

    public static final class Builder extends Message.Builder<ApiRequestMessage, Builder> {
        public Integer android_version;
        public String api_key;
        public Integer company_id;
        public List<DeviceBatteryLogMessage> device_battery_log = Internal.newMutableList();
        public Integer device_id;
        public DeviceInfoMessage device_info;
        public List<AppErrorReportMessage> error_reports = Internal.newMutableList();
        public String host_package_name;
        public String ios_version;
        public LocationInfoMessage location_info;
        public Long message_create_time;
        public MonitoringStatsMessage monitoring_stats;
        public MonitoringStatsV10Message monitoring_stats_v10;
        public NetworkInfoMessage network_info;
        public Integer permission_location;
        public Integer permission_package_usage_stats;
        public Integer permission_read_phone_state;
        public String permissions;
        public Boolean persistent_mode;
        public String version;
        public Integer version_code;

        public Builder android_version(Integer num) {
            this.android_version = num;
            return this;
        }

        public Builder api_key(String str) {
            this.api_key = str;
            return this;
        }

        public Builder company_id(Integer num) {
            this.company_id = num;
            return this;
        }

        public Builder device_battery_log(List<DeviceBatteryLogMessage> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.device_battery_log = list;
            return this;
        }

        public Builder device_id(Integer num) {
            this.device_id = num;
            return this;
        }

        public Builder device_info(DeviceInfoMessage deviceInfoMessage) {
            this.device_info = deviceInfoMessage;
            return this;
        }

        public Builder error_reports(List<AppErrorReportMessage> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.error_reports = list;
            return this;
        }

        public Builder host_package_name(String str) {
            this.host_package_name = str;
            return this;
        }

        public Builder ios_version(String str) {
            this.ios_version = str;
            return this;
        }

        public Builder location_info(LocationInfoMessage locationInfoMessage) {
            this.location_info = locationInfoMessage;
            return this;
        }

        public Builder message_create_time(Long l) {
            this.message_create_time = l;
            return this;
        }

        public Builder monitoring_stats(MonitoringStatsMessage monitoringStatsMessage) {
            this.monitoring_stats = monitoringStatsMessage;
            return this;
        }

        public Builder monitoring_stats_v10(MonitoringStatsV10Message monitoringStatsV10Message) {
            this.monitoring_stats_v10 = monitoringStatsV10Message;
            return this;
        }

        public Builder network_info(NetworkInfoMessage networkInfoMessage) {
            this.network_info = networkInfoMessage;
            return this;
        }

        public Builder permission_location(Integer num) {
            this.permission_location = num;
            return this;
        }

        public Builder permission_package_usage_stats(Integer num) {
            this.permission_package_usage_stats = num;
            return this;
        }

        public Builder permission_read_phone_state(Integer num) {
            this.permission_read_phone_state = num;
            return this;
        }

        public Builder permissions(String str) {
            this.permissions = str;
            return this;
        }

        public Builder persistent_mode(Boolean bool) {
            this.persistent_mode = bool;
            return this;
        }

        public Builder version(String str) {
            this.version = str;
            return this;
        }

        public Builder version_code(Integer num) {
            this.version_code = num;
            return this;
        }

        public ApiRequestMessage build() {
            return new ApiRequestMessage(this.version, this.api_key, this.company_id, this.device_id, this.persistent_mode, this.device_battery_log, this.error_reports, this.device_info, this.android_version, this.network_info, this.host_package_name, this.version_code, this.monitoring_stats, this.message_create_time, this.location_info, this.permission_location, this.permission_read_phone_state, this.permission_package_usage_stats, this.ios_version, this.permissions, this.monitoring_stats_v10, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_ApiRequestMessage extends ProtoAdapter<ApiRequestMessage> {
        public ProtoAdapter_ApiRequestMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) ApiRequestMessage.class);
        }

        public ApiRequestMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 8) {
                    builder.device_battery_log.add(DeviceBatteryLogMessage.ADAPTER.decode(protoReader));
                } else if (nextTag == 9) {
                    builder.error_reports.add(AppErrorReportMessage.ADAPTER.decode(protoReader));
                } else if (nextTag == 1) {
                    builder.version(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.api_key(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.company_id(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.device_id(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 5) {
                    switch (nextTag) {
                        case 20:
                            builder.device_info(DeviceInfoMessage.ADAPTER.decode(protoReader));
                            break;
                        case 21:
                            builder.android_version(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 22:
                            builder.network_info(NetworkInfoMessage.ADAPTER.decode(protoReader));
                            break;
                        default:
                            switch (nextTag) {
                                case 25:
                                    builder.host_package_name(ProtoAdapter.STRING.decode(protoReader));
                                    break;
                                case 26:
                                    builder.version_code(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 27:
                                    builder.monitoring_stats(MonitoringStatsMessage.ADAPTER.decode(protoReader));
                                    break;
                                case 28:
                                    builder.message_create_time(ProtoAdapter.INT64.decode(protoReader));
                                    break;
                                case 29:
                                    builder.location_info(LocationInfoMessage.ADAPTER.decode(protoReader));
                                    break;
                                case 30:
                                    builder.permission_location(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 31:
                                    builder.permission_read_phone_state(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 32:
                                    builder.permission_package_usage_stats(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 33:
                                    builder.ios_version(ProtoAdapter.STRING.decode(protoReader));
                                    break;
                                case 34:
                                    builder.permissions(ProtoAdapter.STRING.decode(protoReader));
                                    break;
                                case 35:
                                    builder.monitoring_stats_v10(MonitoringStatsV10Message.ADAPTER.decode(protoReader));
                                    break;
                                default:
                                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                                    break;
                            }
                    }
                } else {
                    builder.persistent_mode(ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, ApiRequestMessage apiRequestMessage) {
            String str = apiRequestMessage.version;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, str);
            }
            String str2 = apiRequestMessage.api_key;
            if (str2 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, str2);
            }
            Integer num = apiRequestMessage.company_id;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, num);
            }
            Integer num2 = apiRequestMessage.device_id;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, num2);
            }
            Boolean bool = apiRequestMessage.persistent_mode;
            if (bool != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 5, bool);
            }
            DeviceBatteryLogMessage.ADAPTER.asRepeated().encodeWithTag(protoWriter, 8, apiRequestMessage.device_battery_log);
            AppErrorReportMessage.ADAPTER.asRepeated().encodeWithTag(protoWriter, 9, apiRequestMessage.error_reports);
            DeviceInfoMessage deviceInfoMessage = apiRequestMessage.device_info;
            if (deviceInfoMessage != null) {
                DeviceInfoMessage.ADAPTER.encodeWithTag(protoWriter, 20, deviceInfoMessage);
            }
            Integer num3 = apiRequestMessage.android_version;
            if (num3 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 21, num3);
            }
            NetworkInfoMessage networkInfoMessage = apiRequestMessage.network_info;
            if (networkInfoMessage != null) {
                NetworkInfoMessage.ADAPTER.encodeWithTag(protoWriter, 22, networkInfoMessage);
            }
            String str3 = apiRequestMessage.host_package_name;
            if (str3 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 25, str3);
            }
            Integer num4 = apiRequestMessage.version_code;
            if (num4 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 26, num4);
            }
            MonitoringStatsMessage monitoringStatsMessage = apiRequestMessage.monitoring_stats;
            if (monitoringStatsMessage != null) {
                MonitoringStatsMessage.ADAPTER.encodeWithTag(protoWriter, 27, monitoringStatsMessage);
            }
            Long l = apiRequestMessage.message_create_time;
            if (l != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 28, l);
            }
            LocationInfoMessage locationInfoMessage = apiRequestMessage.location_info;
            if (locationInfoMessage != null) {
                LocationInfoMessage.ADAPTER.encodeWithTag(protoWriter, 29, locationInfoMessage);
            }
            Integer num5 = apiRequestMessage.permission_location;
            if (num5 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 30, num5);
            }
            Integer num6 = apiRequestMessage.permission_read_phone_state;
            if (num6 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 31, num6);
            }
            Integer num7 = apiRequestMessage.permission_package_usage_stats;
            if (num7 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 32, num7);
            }
            String str4 = apiRequestMessage.ios_version;
            if (str4 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 33, str4);
            }
            String str5 = apiRequestMessage.permissions;
            if (str5 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 34, str5);
            }
            MonitoringStatsV10Message monitoringStatsV10Message = apiRequestMessage.monitoring_stats_v10;
            if (monitoringStatsV10Message != null) {
                MonitoringStatsV10Message.ADAPTER.encodeWithTag(protoWriter, 35, monitoringStatsV10Message);
            }
            protoWriter.writeBytes(apiRequestMessage.unknownFields());
        }

        public int encodedSize(ApiRequestMessage apiRequestMessage) {
            String str = apiRequestMessage.version;
            int i = 0;
            int encodedSizeWithTag = str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0;
            String str2 = apiRequestMessage.api_key;
            int encodedSizeWithTag2 = encodedSizeWithTag + (str2 != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, str2) : 0);
            Integer num = apiRequestMessage.company_id;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, num) : 0);
            Integer num2 = apiRequestMessage.device_id;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, num2) : 0);
            Boolean bool = apiRequestMessage.persistent_mode;
            int encodedSizeWithTag5 = AppErrorReportMessage.ADAPTER.asRepeated().encodedSizeWithTag(9, apiRequestMessage.error_reports) + DeviceBatteryLogMessage.ADAPTER.asRepeated().encodedSizeWithTag(8, apiRequestMessage.device_battery_log) + encodedSizeWithTag4 + (bool != null ? ProtoAdapter.BOOL.encodedSizeWithTag(5, bool) : 0);
            DeviceInfoMessage deviceInfoMessage = apiRequestMessage.device_info;
            int encodedSizeWithTag6 = encodedSizeWithTag5 + (deviceInfoMessage != null ? DeviceInfoMessage.ADAPTER.encodedSizeWithTag(20, deviceInfoMessage) : 0);
            Integer num3 = apiRequestMessage.android_version;
            int encodedSizeWithTag7 = encodedSizeWithTag6 + (num3 != null ? ProtoAdapter.INT32.encodedSizeWithTag(21, num3) : 0);
            NetworkInfoMessage networkInfoMessage = apiRequestMessage.network_info;
            int encodedSizeWithTag8 = encodedSizeWithTag7 + (networkInfoMessage != null ? NetworkInfoMessage.ADAPTER.encodedSizeWithTag(22, networkInfoMessage) : 0);
            String str3 = apiRequestMessage.host_package_name;
            int encodedSizeWithTag9 = encodedSizeWithTag8 + (str3 != null ? ProtoAdapter.STRING.encodedSizeWithTag(25, str3) : 0);
            Integer num4 = apiRequestMessage.version_code;
            int encodedSizeWithTag10 = encodedSizeWithTag9 + (num4 != null ? ProtoAdapter.INT32.encodedSizeWithTag(26, num4) : 0);
            MonitoringStatsMessage monitoringStatsMessage = apiRequestMessage.monitoring_stats;
            int encodedSizeWithTag11 = encodedSizeWithTag10 + (monitoringStatsMessage != null ? MonitoringStatsMessage.ADAPTER.encodedSizeWithTag(27, monitoringStatsMessage) : 0);
            Long l = apiRequestMessage.message_create_time;
            int encodedSizeWithTag12 = encodedSizeWithTag11 + (l != null ? ProtoAdapter.INT64.encodedSizeWithTag(28, l) : 0);
            LocationInfoMessage locationInfoMessage = apiRequestMessage.location_info;
            int encodedSizeWithTag13 = encodedSizeWithTag12 + (locationInfoMessage != null ? LocationInfoMessage.ADAPTER.encodedSizeWithTag(29, locationInfoMessage) : 0);
            Integer num5 = apiRequestMessage.permission_location;
            int encodedSizeWithTag14 = encodedSizeWithTag13 + (num5 != null ? ProtoAdapter.INT32.encodedSizeWithTag(30, num5) : 0);
            Integer num6 = apiRequestMessage.permission_read_phone_state;
            int encodedSizeWithTag15 = encodedSizeWithTag14 + (num6 != null ? ProtoAdapter.INT32.encodedSizeWithTag(31, num6) : 0);
            Integer num7 = apiRequestMessage.permission_package_usage_stats;
            int encodedSizeWithTag16 = encodedSizeWithTag15 + (num7 != null ? ProtoAdapter.INT32.encodedSizeWithTag(32, num7) : 0);
            String str4 = apiRequestMessage.ios_version;
            int encodedSizeWithTag17 = encodedSizeWithTag16 + (str4 != null ? ProtoAdapter.STRING.encodedSizeWithTag(33, str4) : 0);
            String str5 = apiRequestMessage.permissions;
            int encodedSizeWithTag18 = encodedSizeWithTag17 + (str5 != null ? ProtoAdapter.STRING.encodedSizeWithTag(34, str5) : 0);
            MonitoringStatsV10Message monitoringStatsV10Message = apiRequestMessage.monitoring_stats_v10;
            if (monitoringStatsV10Message != null) {
                i = MonitoringStatsV10Message.ADAPTER.encodedSizeWithTag(35, monitoringStatsV10Message);
            }
            return apiRequestMessage.unknownFields().size() + encodedSizeWithTag18 + i;
        }

        public ApiRequestMessage redact(ApiRequestMessage apiRequestMessage) {
            Builder newBuilder = apiRequestMessage.newBuilder();
            Internal.redactElements(newBuilder.device_battery_log, DeviceBatteryLogMessage.ADAPTER);
            Internal.redactElements(newBuilder.error_reports, AppErrorReportMessage.ADAPTER);
            DeviceInfoMessage deviceInfoMessage = newBuilder.device_info;
            if (deviceInfoMessage != null) {
                newBuilder.device_info = DeviceInfoMessage.ADAPTER.redact(deviceInfoMessage);
            }
            NetworkInfoMessage networkInfoMessage = newBuilder.network_info;
            if (networkInfoMessage != null) {
                newBuilder.network_info = NetworkInfoMessage.ADAPTER.redact(networkInfoMessage);
            }
            MonitoringStatsMessage monitoringStatsMessage = newBuilder.monitoring_stats;
            if (monitoringStatsMessage != null) {
                newBuilder.monitoring_stats = MonitoringStatsMessage.ADAPTER.redact(monitoringStatsMessage);
            }
            LocationInfoMessage locationInfoMessage = newBuilder.location_info;
            if (locationInfoMessage != null) {
                newBuilder.location_info = LocationInfoMessage.ADAPTER.redact(locationInfoMessage);
            }
            MonitoringStatsV10Message monitoringStatsV10Message = newBuilder.monitoring_stats_v10;
            if (monitoringStatsV10Message != null) {
                newBuilder.monitoring_stats_v10 = MonitoringStatsV10Message.ADAPTER.redact(monitoringStatsV10Message);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ApiRequestMessage(String str, String str2, Integer num, Integer num2, Boolean bool, List<DeviceBatteryLogMessage> list, List<AppErrorReportMessage> list2, DeviceInfoMessage deviceInfoMessage, Integer num3, NetworkInfoMessage networkInfoMessage, String str3, Integer num4, MonitoringStatsMessage monitoringStatsMessage, Long l, LocationInfoMessage locationInfoMessage, Integer num5, Integer num6, Integer num7, String str4, String str5, MonitoringStatsV10Message monitoringStatsV10Message) {
        this(str, str2, num, num2, bool, list, list2, deviceInfoMessage, num3, networkInfoMessage, str3, num4, monitoringStatsMessage, l, locationInfoMessage, num5, num6, num7, str4, str5, monitoringStatsV10Message, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiRequestMessage)) {
            return false;
        }
        ApiRequestMessage apiRequestMessage = (ApiRequestMessage) obj;
        if (!unknownFields().equals(apiRequestMessage.unknownFields()) || !Internal.equals(this.version, apiRequestMessage.version) || !Internal.equals(this.api_key, apiRequestMessage.api_key) || !Internal.equals(this.company_id, apiRequestMessage.company_id) || !Internal.equals(this.device_id, apiRequestMessage.device_id) || !Internal.equals(this.persistent_mode, apiRequestMessage.persistent_mode) || !this.device_battery_log.equals(apiRequestMessage.device_battery_log) || !this.error_reports.equals(apiRequestMessage.error_reports) || !Internal.equals(this.device_info, apiRequestMessage.device_info) || !Internal.equals(this.android_version, apiRequestMessage.android_version) || !Internal.equals(this.network_info, apiRequestMessage.network_info) || !Internal.equals(this.host_package_name, apiRequestMessage.host_package_name) || !Internal.equals(this.version_code, apiRequestMessage.version_code) || !Internal.equals(this.monitoring_stats, apiRequestMessage.monitoring_stats) || !Internal.equals(this.message_create_time, apiRequestMessage.message_create_time) || !Internal.equals(this.location_info, apiRequestMessage.location_info) || !Internal.equals(this.permission_location, apiRequestMessage.permission_location) || !Internal.equals(this.permission_read_phone_state, apiRequestMessage.permission_read_phone_state) || !Internal.equals(this.permission_package_usage_stats, apiRequestMessage.permission_package_usage_stats) || !Internal.equals(this.ios_version, apiRequestMessage.ios_version) || !Internal.equals(this.permissions, apiRequestMessage.permissions) || !Internal.equals(this.monitoring_stats_v10, apiRequestMessage.monitoring_stats_v10)) {
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
        String str = this.version;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.api_key;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.company_id;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.device_id;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.persistent_mode;
        int hashCode6 = (this.error_reports.hashCode() + ((this.device_battery_log.hashCode() + ((hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37)) * 37)) * 37;
        DeviceInfoMessage deviceInfoMessage = this.device_info;
        int hashCode7 = (hashCode6 + (deviceInfoMessage != null ? deviceInfoMessage.hashCode() : 0)) * 37;
        Integer num3 = this.android_version;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        NetworkInfoMessage networkInfoMessage = this.network_info;
        int hashCode9 = (hashCode8 + (networkInfoMessage != null ? networkInfoMessage.hashCode() : 0)) * 37;
        String str3 = this.host_package_name;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num4 = this.version_code;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
        MonitoringStatsMessage monitoringStatsMessage = this.monitoring_stats;
        int hashCode12 = (hashCode11 + (monitoringStatsMessage != null ? monitoringStatsMessage.hashCode() : 0)) * 37;
        Long l = this.message_create_time;
        int hashCode13 = (hashCode12 + (l != null ? l.hashCode() : 0)) * 37;
        LocationInfoMessage locationInfoMessage = this.location_info;
        int hashCode14 = (hashCode13 + (locationInfoMessage != null ? locationInfoMessage.hashCode() : 0)) * 37;
        Integer num5 = this.permission_location;
        int hashCode15 = (hashCode14 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.permission_read_phone_state;
        int hashCode16 = (hashCode15 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.permission_package_usage_stats;
        int hashCode17 = (hashCode16 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str4 = this.ios_version;
        int hashCode18 = (hashCode17 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.permissions;
        int hashCode19 = (hashCode18 + (str5 != null ? str5.hashCode() : 0)) * 37;
        MonitoringStatsV10Message monitoringStatsV10Message = this.monitoring_stats_v10;
        if (monitoringStatsV10Message != null) {
            i2 = monitoringStatsV10Message.hashCode();
        }
        int i3 = hashCode19 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.version != null) {
            sb.append(", version=");
            sb.append(this.version);
        }
        if (this.api_key != null) {
            sb.append(", api_key=");
            sb.append(this.api_key);
        }
        if (this.company_id != null) {
            sb.append(", company_id=");
            sb.append(this.company_id);
        }
        if (this.device_id != null) {
            sb.append(", device_id=");
            sb.append(this.device_id);
        }
        if (this.persistent_mode != null) {
            sb.append(", persistent_mode=");
            sb.append(this.persistent_mode);
        }
        if (!this.device_battery_log.isEmpty()) {
            sb.append(", device_battery_log=");
            sb.append(this.device_battery_log);
        }
        if (!this.error_reports.isEmpty()) {
            sb.append(", error_reports=");
            sb.append(this.error_reports);
        }
        if (this.device_info != null) {
            sb.append(", device_info=");
            sb.append(this.device_info);
        }
        if (this.android_version != null) {
            sb.append(", android_version=");
            sb.append(this.android_version);
        }
        if (this.network_info != null) {
            sb.append(", network_info=");
            sb.append(this.network_info);
        }
        if (this.host_package_name != null) {
            sb.append(", host_package_name=");
            sb.append(this.host_package_name);
        }
        if (this.version_code != null) {
            sb.append(", version_code=");
            sb.append(this.version_code);
        }
        if (this.monitoring_stats != null) {
            sb.append(", monitoring_stats=");
            sb.append(this.monitoring_stats);
        }
        if (this.message_create_time != null) {
            sb.append(", message_create_time=");
            sb.append(this.message_create_time);
        }
        if (this.location_info != null) {
            sb.append(", location_info=");
            sb.append(this.location_info);
        }
        if (this.permission_location != null) {
            sb.append(", permission_location=");
            sb.append(this.permission_location);
        }
        if (this.permission_read_phone_state != null) {
            sb.append(", permission_read_phone_state=");
            sb.append(this.permission_read_phone_state);
        }
        if (this.permission_package_usage_stats != null) {
            sb.append(", permission_package_usage_stats=");
            sb.append(this.permission_package_usage_stats);
        }
        if (this.ios_version != null) {
            sb.append(", ios_version=");
            sb.append(this.ios_version);
        }
        if (this.permissions != null) {
            sb.append(", permissions=");
            sb.append(this.permissions);
        }
        if (this.monitoring_stats_v10 != null) {
            sb.append(", monitoring_stats_v10=");
            sb.append(this.monitoring_stats_v10);
        }
        return c.a(sb, 0, 2, "ApiRequestMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApiRequestMessage(String str, String str2, Integer num, Integer num2, Boolean bool, List<DeviceBatteryLogMessage> list, List<AppErrorReportMessage> list2, DeviceInfoMessage deviceInfoMessage, Integer num3, NetworkInfoMessage networkInfoMessage, String str3, Integer num4, MonitoringStatsMessage monitoringStatsMessage, Long l, LocationInfoMessage locationInfoMessage, Integer num5, Integer num6, Integer num7, String str4, String str5, MonitoringStatsV10Message monitoringStatsV10Message, ByteString byteString) {
        super(ADAPTER, byteString);
        this.version = str;
        this.api_key = str2;
        this.company_id = num;
        this.device_id = num2;
        this.persistent_mode = bool;
        List<DeviceBatteryLogMessage> list3 = list;
        this.device_battery_log = Internal.immutableCopyOf("device_battery_log", list);
        List<AppErrorReportMessage> list4 = list2;
        this.error_reports = Internal.immutableCopyOf("error_reports", list2);
        this.device_info = deviceInfoMessage;
        this.android_version = num3;
        this.network_info = networkInfoMessage;
        this.host_package_name = str3;
        this.version_code = num4;
        this.monitoring_stats = monitoringStatsMessage;
        this.message_create_time = l;
        this.location_info = locationInfoMessage;
        this.permission_location = num5;
        this.permission_read_phone_state = num6;
        this.permission_package_usage_stats = num7;
        this.ios_version = str4;
        this.permissions = str5;
        this.monitoring_stats_v10 = monitoringStatsV10Message;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.version = this.version;
        builder.api_key = this.api_key;
        builder.company_id = this.company_id;
        builder.device_id = this.device_id;
        builder.persistent_mode = this.persistent_mode;
        builder.device_battery_log = Internal.copyOf("device_battery_log", this.device_battery_log);
        builder.error_reports = Internal.copyOf("error_reports", this.error_reports);
        builder.device_info = this.device_info;
        builder.android_version = this.android_version;
        builder.network_info = this.network_info;
        builder.host_package_name = this.host_package_name;
        builder.version_code = this.version_code;
        builder.monitoring_stats = this.monitoring_stats;
        builder.message_create_time = this.message_create_time;
        builder.location_info = this.location_info;
        builder.permission_location = this.permission_location;
        builder.permission_read_phone_state = this.permission_read_phone_state;
        builder.permission_package_usage_stats = this.permission_package_usage_stats;
        builder.ios_version = this.ios_version;
        builder.permissions = this.permissions;
        builder.monitoring_stats_v10 = this.monitoring_stats_v10;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
