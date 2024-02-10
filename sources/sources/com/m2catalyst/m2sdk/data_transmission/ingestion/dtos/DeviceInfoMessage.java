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

public final class DeviceInfoMessage extends Message<DeviceInfoMessage, Builder> {
    public static final ProtoAdapter<DeviceInfoMessage> ADAPTER = new ProtoAdapter_DeviceInfoMessage();
    public static final String DEFAULT_ANDROID_ID = "";
    public static final Integer DEFAULT_ANDROID_VERSION = 0;
    public static final String DEFAULT_BOOTLOADER_ID = "";
    public static final String DEFAULT_CARRIER_NAME = "";
    public static final String DEFAULT_CPU_CORE_LABELS = "";
    public static final String DEFAULT_CPU_INFO = "";
    public static final Integer DEFAULT_CPU_MAX_SPEED = 0;
    public static final String DEFAULT_DEVICE_ARCHITECTURE = "";
    public static final String DEFAULT_DEVICE_HASH = "";
    public static final String DEFAULT_DEVICE_NAME = "";
    public static final String DEFAULT_DEVICE_TYPE = "";
    public static final String DEFAULT_GOOGLE_ADVERTISING_ID = "";
    public static final String DEFAULT_LANGUAGE = "";
    public static final String DEFAULT_M2_ID = "";
    public static final String DEFAULT_MAC_ADDRESS = "";
    public static final Integer DEFAULT_MCC = 0;
    public static final Integer DEFAULT_MNC = 0;
    public static final Integer DEFAULT_N_MCC = 0;
    public static final Integer DEFAULT_N_MNC = 0;
    public static final String DEFAULT_OS_ARCHITECTURE = "";
    public static final String DEFAULT_OS_BUILD_ID = "";
    public static final String DEFAULT_OS_BUILD_VERSION = "";
    public static final String DEFAULT_PHONE_ID = "";
    public static final Integer DEFAULT_R_MCC = 0;
    public static final Integer DEFAULT_R_MNC = 0;
    public static final Integer DEFAULT_S_MCC = 0;
    public static final Integer DEFAULT_S_MNC = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 17)
    public final String android_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer android_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 29)
    public final String bootloader_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 21)
    public final String carrier_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 40)
    public final String cpu_core_labels;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 38)
    public final String cpu_info;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 39)
    public final Integer cpu_max_speed;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 42)
    public final String device_architecture;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String device_hash;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 20)
    public final String device_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String device_type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 41)
    public final String google_advertising_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 28)
    public final String language;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String m2_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 18)
    public final String mac_address;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 26)
    public final Integer mcc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 27)
    public final Integer mnc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 32)
    public final Integer n_mcc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 33)
    public final Integer n_mnc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 43)
    public final String os_architecture;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 31)
    public final String os_build_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 30)
    public final String os_build_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 19)
    public final String phone_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 36)
    public final Integer r_mcc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 37)
    public final Integer r_mnc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 34)
    public final Integer s_mcc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 35)
    public final Integer s_mnc;

    public static final class Builder extends Message.Builder<DeviceInfoMessage, Builder> {
        public String android_id;
        public Integer android_version;
        public String bootloader_id;
        public String carrier_name;
        public String cpu_core_labels;
        public String cpu_info;
        public Integer cpu_max_speed;
        public String device_architecture;
        public String device_hash;
        public String device_name;
        public String device_type;
        public String google_advertising_id;
        public String language;
        public String m2_id;
        public String mac_address;
        public Integer mcc;
        public Integer mnc;
        public Integer n_mcc;
        public Integer n_mnc;
        public String os_architecture;
        public String os_build_id;
        public String os_build_version;
        public String phone_id;
        public Integer r_mcc;
        public Integer r_mnc;
        public Integer s_mcc;
        public Integer s_mnc;

        public Builder android_id(String str) {
            this.android_id = str;
            return this;
        }

        public Builder android_version(Integer num) {
            this.android_version = num;
            return this;
        }

        public Builder bootloader_id(String str) {
            this.bootloader_id = str;
            return this;
        }

        public Builder carrier_name(String str) {
            this.carrier_name = str;
            return this;
        }

        public Builder cpu_core_labels(String str) {
            this.cpu_core_labels = str;
            return this;
        }

        public Builder cpu_info(String str) {
            this.cpu_info = str;
            return this;
        }

        public Builder cpu_max_speed(Integer num) {
            this.cpu_max_speed = num;
            return this;
        }

        public Builder device_architecture(String str) {
            this.device_architecture = str;
            return this;
        }

        public Builder device_hash(String str) {
            this.device_hash = str;
            return this;
        }

        public Builder device_name(String str) {
            this.device_name = str;
            return this;
        }

        public Builder device_type(String str) {
            this.device_type = str;
            return this;
        }

        public Builder google_advertising_id(String str) {
            this.google_advertising_id = str;
            return this;
        }

        public Builder language(String str) {
            this.language = str;
            return this;
        }

        public Builder m2_id(String str) {
            this.m2_id = str;
            return this;
        }

        public Builder mac_address(String str) {
            this.mac_address = str;
            return this;
        }

        public Builder mcc(Integer num) {
            this.mcc = num;
            return this;
        }

        public Builder mnc(Integer num) {
            this.mnc = num;
            return this;
        }

        public Builder n_mcc(Integer num) {
            this.n_mcc = num;
            return this;
        }

        public Builder n_mnc(Integer num) {
            this.n_mnc = num;
            return this;
        }

        public Builder os_architecture(String str) {
            this.os_architecture = str;
            return this;
        }

        public Builder os_build_id(String str) {
            this.os_build_id = str;
            return this;
        }

        public Builder os_build_version(String str) {
            this.os_build_version = str;
            return this;
        }

        public Builder phone_id(String str) {
            this.phone_id = str;
            return this;
        }

        public Builder r_mcc(Integer num) {
            this.r_mcc = num;
            return this;
        }

        public Builder r_mnc(Integer num) {
            this.r_mnc = num;
            return this;
        }

        public Builder s_mcc(Integer num) {
            this.s_mcc = num;
            return this;
        }

        public Builder s_mnc(Integer num) {
            this.s_mnc = num;
            return this;
        }

        public DeviceInfoMessage build() {
            return new DeviceInfoMessage(this.m2_id, this.device_type, this.android_version, this.device_hash, this.android_id, this.mac_address, this.phone_id, this.device_name, this.carrier_name, this.mcc, this.mnc, this.language, this.bootloader_id, this.os_build_version, this.os_build_id, this.n_mcc, this.n_mnc, this.s_mcc, this.s_mnc, this.r_mcc, this.r_mnc, this.cpu_info, this.cpu_max_speed, this.cpu_core_labels, this.google_advertising_id, this.device_architecture, this.os_architecture, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_DeviceInfoMessage extends ProtoAdapter<DeviceInfoMessage> {
        public ProtoAdapter_DeviceInfoMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) DeviceInfoMessage.class);
        }

        public DeviceInfoMessage decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.m2_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.device_type(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.android_version(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 4) {
                    switch (nextTag) {
                        case 17:
                            builder.android_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 18:
                            builder.mac_address(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 19:
                            builder.phone_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 20:
                            builder.device_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 21:
                            builder.carrier_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            switch (nextTag) {
                                case 26:
                                    builder.mcc(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 27:
                                    builder.mnc(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 28:
                                    builder.language(ProtoAdapter.STRING.decode(protoReader));
                                    break;
                                case 29:
                                    builder.bootloader_id(ProtoAdapter.STRING.decode(protoReader));
                                    break;
                                case 30:
                                    builder.os_build_version(ProtoAdapter.STRING.decode(protoReader));
                                    break;
                                case 31:
                                    builder.os_build_id(ProtoAdapter.STRING.decode(protoReader));
                                    break;
                                case 32:
                                    builder.n_mcc(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 33:
                                    builder.n_mnc(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 34:
                                    builder.s_mcc(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 35:
                                    builder.s_mnc(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 36:
                                    builder.r_mcc(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 37:
                                    builder.r_mnc(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 38:
                                    builder.cpu_info(ProtoAdapter.STRING.decode(protoReader));
                                    break;
                                case 39:
                                    builder.cpu_max_speed(ProtoAdapter.INT32.decode(protoReader));
                                    break;
                                case 40:
                                    builder.cpu_core_labels(ProtoAdapter.STRING.decode(protoReader));
                                    break;
                                case 41:
                                    builder.google_advertising_id(ProtoAdapter.STRING.decode(protoReader));
                                    break;
                                case 42:
                                    builder.device_architecture(ProtoAdapter.STRING.decode(protoReader));
                                    break;
                                case 43:
                                    builder.os_architecture(ProtoAdapter.STRING.decode(protoReader));
                                    break;
                                default:
                                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                                    break;
                            }
                    }
                } else {
                    builder.device_hash(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, DeviceInfoMessage deviceInfoMessage) {
            String str = deviceInfoMessage.m2_id;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, str);
            }
            String str2 = deviceInfoMessage.device_type;
            if (str2 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, str2);
            }
            Integer num = deviceInfoMessage.android_version;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, num);
            }
            String str3 = deviceInfoMessage.device_hash;
            if (str3 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, str3);
            }
            String str4 = deviceInfoMessage.android_id;
            if (str4 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 17, str4);
            }
            String str5 = deviceInfoMessage.mac_address;
            if (str5 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 18, str5);
            }
            String str6 = deviceInfoMessage.phone_id;
            if (str6 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 19, str6);
            }
            String str7 = deviceInfoMessage.device_name;
            if (str7 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 20, str7);
            }
            String str8 = deviceInfoMessage.carrier_name;
            if (str8 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 21, str8);
            }
            Integer num2 = deviceInfoMessage.mcc;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 26, num2);
            }
            Integer num3 = deviceInfoMessage.mnc;
            if (num3 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 27, num3);
            }
            String str9 = deviceInfoMessage.language;
            if (str9 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 28, str9);
            }
            String str10 = deviceInfoMessage.bootloader_id;
            if (str10 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 29, str10);
            }
            String str11 = deviceInfoMessage.os_build_version;
            if (str11 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 30, str11);
            }
            String str12 = deviceInfoMessage.os_build_id;
            if (str12 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 31, str12);
            }
            Integer num4 = deviceInfoMessage.n_mcc;
            if (num4 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 32, num4);
            }
            Integer num5 = deviceInfoMessage.n_mnc;
            if (num5 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 33, num5);
            }
            Integer num6 = deviceInfoMessage.s_mcc;
            if (num6 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 34, num6);
            }
            Integer num7 = deviceInfoMessage.s_mnc;
            if (num7 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 35, num7);
            }
            Integer num8 = deviceInfoMessage.r_mcc;
            if (num8 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 36, num8);
            }
            Integer num9 = deviceInfoMessage.r_mnc;
            if (num9 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 37, num9);
            }
            String str13 = deviceInfoMessage.cpu_info;
            if (str13 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 38, str13);
            }
            Integer num10 = deviceInfoMessage.cpu_max_speed;
            if (num10 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 39, num10);
            }
            String str14 = deviceInfoMessage.cpu_core_labels;
            if (str14 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 40, str14);
            }
            String str15 = deviceInfoMessage.google_advertising_id;
            if (str15 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 41, str15);
            }
            String str16 = deviceInfoMessage.device_architecture;
            if (str16 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 42, str16);
            }
            String str17 = deviceInfoMessage.os_architecture;
            if (str17 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 43, str17);
            }
            protoWriter.writeBytes(deviceInfoMessage.unknownFields());
        }

        public int encodedSize(DeviceInfoMessage deviceInfoMessage) {
            String str = deviceInfoMessage.m2_id;
            int i = 0;
            int encodedSizeWithTag = str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0;
            String str2 = deviceInfoMessage.device_type;
            int encodedSizeWithTag2 = encodedSizeWithTag + (str2 != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, str2) : 0);
            Integer num = deviceInfoMessage.android_version;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, num) : 0);
            String str3 = deviceInfoMessage.device_hash;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (str3 != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, str3) : 0);
            String str4 = deviceInfoMessage.android_id;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (str4 != null ? ProtoAdapter.STRING.encodedSizeWithTag(17, str4) : 0);
            String str5 = deviceInfoMessage.mac_address;
            int encodedSizeWithTag6 = encodedSizeWithTag5 + (str5 != null ? ProtoAdapter.STRING.encodedSizeWithTag(18, str5) : 0);
            String str6 = deviceInfoMessage.phone_id;
            int encodedSizeWithTag7 = encodedSizeWithTag6 + (str6 != null ? ProtoAdapter.STRING.encodedSizeWithTag(19, str6) : 0);
            String str7 = deviceInfoMessage.device_name;
            int encodedSizeWithTag8 = encodedSizeWithTag7 + (str7 != null ? ProtoAdapter.STRING.encodedSizeWithTag(20, str7) : 0);
            String str8 = deviceInfoMessage.carrier_name;
            int encodedSizeWithTag9 = encodedSizeWithTag8 + (str8 != null ? ProtoAdapter.STRING.encodedSizeWithTag(21, str8) : 0);
            Integer num2 = deviceInfoMessage.mcc;
            int encodedSizeWithTag10 = encodedSizeWithTag9 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(26, num2) : 0);
            Integer num3 = deviceInfoMessage.mnc;
            int encodedSizeWithTag11 = encodedSizeWithTag10 + (num3 != null ? ProtoAdapter.INT32.encodedSizeWithTag(27, num3) : 0);
            String str9 = deviceInfoMessage.language;
            int encodedSizeWithTag12 = encodedSizeWithTag11 + (str9 != null ? ProtoAdapter.STRING.encodedSizeWithTag(28, str9) : 0);
            String str10 = deviceInfoMessage.bootloader_id;
            int encodedSizeWithTag13 = encodedSizeWithTag12 + (str10 != null ? ProtoAdapter.STRING.encodedSizeWithTag(29, str10) : 0);
            String str11 = deviceInfoMessage.os_build_version;
            int encodedSizeWithTag14 = encodedSizeWithTag13 + (str11 != null ? ProtoAdapter.STRING.encodedSizeWithTag(30, str11) : 0);
            String str12 = deviceInfoMessage.os_build_id;
            int encodedSizeWithTag15 = encodedSizeWithTag14 + (str12 != null ? ProtoAdapter.STRING.encodedSizeWithTag(31, str12) : 0);
            Integer num4 = deviceInfoMessage.n_mcc;
            int encodedSizeWithTag16 = encodedSizeWithTag15 + (num4 != null ? ProtoAdapter.INT32.encodedSizeWithTag(32, num4) : 0);
            Integer num5 = deviceInfoMessage.n_mnc;
            int encodedSizeWithTag17 = encodedSizeWithTag16 + (num5 != null ? ProtoAdapter.INT32.encodedSizeWithTag(33, num5) : 0);
            Integer num6 = deviceInfoMessage.s_mcc;
            int encodedSizeWithTag18 = encodedSizeWithTag17 + (num6 != null ? ProtoAdapter.INT32.encodedSizeWithTag(34, num6) : 0);
            Integer num7 = deviceInfoMessage.s_mnc;
            int encodedSizeWithTag19 = encodedSizeWithTag18 + (num7 != null ? ProtoAdapter.INT32.encodedSizeWithTag(35, num7) : 0);
            Integer num8 = deviceInfoMessage.r_mcc;
            int encodedSizeWithTag20 = encodedSizeWithTag19 + (num8 != null ? ProtoAdapter.INT32.encodedSizeWithTag(36, num8) : 0);
            Integer num9 = deviceInfoMessage.r_mnc;
            int encodedSizeWithTag21 = encodedSizeWithTag20 + (num9 != null ? ProtoAdapter.INT32.encodedSizeWithTag(37, num9) : 0);
            String str13 = deviceInfoMessage.cpu_info;
            int encodedSizeWithTag22 = encodedSizeWithTag21 + (str13 != null ? ProtoAdapter.STRING.encodedSizeWithTag(38, str13) : 0);
            Integer num10 = deviceInfoMessage.cpu_max_speed;
            int encodedSizeWithTag23 = encodedSizeWithTag22 + (num10 != null ? ProtoAdapter.INT32.encodedSizeWithTag(39, num10) : 0);
            String str14 = deviceInfoMessage.cpu_core_labels;
            int encodedSizeWithTag24 = encodedSizeWithTag23 + (str14 != null ? ProtoAdapter.STRING.encodedSizeWithTag(40, str14) : 0);
            String str15 = deviceInfoMessage.google_advertising_id;
            int encodedSizeWithTag25 = encodedSizeWithTag24 + (str15 != null ? ProtoAdapter.STRING.encodedSizeWithTag(41, str15) : 0);
            String str16 = deviceInfoMessage.device_architecture;
            int encodedSizeWithTag26 = encodedSizeWithTag25 + (str16 != null ? ProtoAdapter.STRING.encodedSizeWithTag(42, str16) : 0);
            String str17 = deviceInfoMessage.os_architecture;
            if (str17 != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(43, str17);
            }
            return deviceInfoMessage.unknownFields().size() + encodedSizeWithTag26 + i;
        }

        public DeviceInfoMessage redact(DeviceInfoMessage deviceInfoMessage) {
            Builder newBuilder = deviceInfoMessage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public DeviceInfoMessage(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, Integer num2, Integer num3, String str9, String str10, String str11, String str12, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, String str13, Integer num10, String str14, String str15, String str16, String str17) {
        this(str, str2, num, str3, str4, str5, str6, str7, str8, num2, num3, str9, str10, str11, str12, num4, num5, num6, num7, num8, num9, str13, num10, str14, str15, str16, str17, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceInfoMessage)) {
            return false;
        }
        DeviceInfoMessage deviceInfoMessage = (DeviceInfoMessage) obj;
        if (!unknownFields().equals(deviceInfoMessage.unknownFields()) || !Internal.equals(this.m2_id, deviceInfoMessage.m2_id) || !Internal.equals(this.device_type, deviceInfoMessage.device_type) || !Internal.equals(this.android_version, deviceInfoMessage.android_version) || !Internal.equals(this.device_hash, deviceInfoMessage.device_hash) || !Internal.equals(this.android_id, deviceInfoMessage.android_id) || !Internal.equals(this.mac_address, deviceInfoMessage.mac_address) || !Internal.equals(this.phone_id, deviceInfoMessage.phone_id) || !Internal.equals(this.device_name, deviceInfoMessage.device_name) || !Internal.equals(this.carrier_name, deviceInfoMessage.carrier_name) || !Internal.equals(this.mcc, deviceInfoMessage.mcc) || !Internal.equals(this.mnc, deviceInfoMessage.mnc) || !Internal.equals(this.language, deviceInfoMessage.language) || !Internal.equals(this.bootloader_id, deviceInfoMessage.bootloader_id) || !Internal.equals(this.os_build_version, deviceInfoMessage.os_build_version) || !Internal.equals(this.os_build_id, deviceInfoMessage.os_build_id) || !Internal.equals(this.n_mcc, deviceInfoMessage.n_mcc) || !Internal.equals(this.n_mnc, deviceInfoMessage.n_mnc) || !Internal.equals(this.s_mcc, deviceInfoMessage.s_mcc) || !Internal.equals(this.s_mnc, deviceInfoMessage.s_mnc) || !Internal.equals(this.r_mcc, deviceInfoMessage.r_mcc) || !Internal.equals(this.r_mnc, deviceInfoMessage.r_mnc) || !Internal.equals(this.cpu_info, deviceInfoMessage.cpu_info) || !Internal.equals(this.cpu_max_speed, deviceInfoMessage.cpu_max_speed) || !Internal.equals(this.cpu_core_labels, deviceInfoMessage.cpu_core_labels) || !Internal.equals(this.google_advertising_id, deviceInfoMessage.google_advertising_id) || !Internal.equals(this.device_architecture, deviceInfoMessage.device_architecture) || !Internal.equals(this.os_architecture, deviceInfoMessage.os_architecture)) {
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
        String str = this.m2_id;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.device_type;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.android_version;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.device_hash;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.android_id;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.mac_address;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.phone_id;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.device_name;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.carrier_name;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Integer num2 = this.mcc;
        int hashCode11 = (hashCode10 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mnc;
        int hashCode12 = (hashCode11 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str9 = this.language;
        int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.bootloader_id;
        int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.os_build_version;
        int hashCode15 = (hashCode14 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.os_build_id;
        int hashCode16 = (hashCode15 + (str12 != null ? str12.hashCode() : 0)) * 37;
        Integer num4 = this.n_mcc;
        int hashCode17 = (hashCode16 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.n_mnc;
        int hashCode18 = (hashCode17 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.s_mcc;
        int hashCode19 = (hashCode18 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.s_mnc;
        int hashCode20 = (hashCode19 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.r_mcc;
        int hashCode21 = (hashCode20 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.r_mnc;
        int hashCode22 = (hashCode21 + (num9 != null ? num9.hashCode() : 0)) * 37;
        String str13 = this.cpu_info;
        int hashCode23 = (hashCode22 + (str13 != null ? str13.hashCode() : 0)) * 37;
        Integer num10 = this.cpu_max_speed;
        int hashCode24 = (hashCode23 + (num10 != null ? num10.hashCode() : 0)) * 37;
        String str14 = this.cpu_core_labels;
        int hashCode25 = (hashCode24 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.google_advertising_id;
        int hashCode26 = (hashCode25 + (str15 != null ? str15.hashCode() : 0)) * 37;
        String str16 = this.device_architecture;
        int hashCode27 = (hashCode26 + (str16 != null ? str16.hashCode() : 0)) * 37;
        String str17 = this.os_architecture;
        if (str17 != null) {
            i2 = str17.hashCode();
        }
        int i3 = hashCode27 + i2;
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.m2_id != null) {
            sb.append(", m2_id=");
            sb.append(this.m2_id);
        }
        if (this.device_type != null) {
            sb.append(", device_type=");
            sb.append(this.device_type);
        }
        if (this.android_version != null) {
            sb.append(", android_version=");
            sb.append(this.android_version);
        }
        if (this.device_hash != null) {
            sb.append(", device_hash=");
            sb.append(this.device_hash);
        }
        if (this.android_id != null) {
            sb.append(", android_id=");
            sb.append(this.android_id);
        }
        if (this.mac_address != null) {
            sb.append(", mac_address=");
            sb.append(this.mac_address);
        }
        if (this.phone_id != null) {
            sb.append(", phone_id=");
            sb.append(this.phone_id);
        }
        if (this.device_name != null) {
            sb.append(", device_name=");
            sb.append(this.device_name);
        }
        if (this.carrier_name != null) {
            sb.append(", carrier_name=");
            sb.append(this.carrier_name);
        }
        if (this.mcc != null) {
            sb.append(", mcc=");
            sb.append(this.mcc);
        }
        if (this.mnc != null) {
            sb.append(", mnc=");
            sb.append(this.mnc);
        }
        if (this.language != null) {
            sb.append(", language=");
            sb.append(this.language);
        }
        if (this.bootloader_id != null) {
            sb.append(", bootloader_id=");
            sb.append(this.bootloader_id);
        }
        if (this.os_build_version != null) {
            sb.append(", os_build_version=");
            sb.append(this.os_build_version);
        }
        if (this.os_build_id != null) {
            sb.append(", os_build_id=");
            sb.append(this.os_build_id);
        }
        if (this.n_mcc != null) {
            sb.append(", n_mcc=");
            sb.append(this.n_mcc);
        }
        if (this.n_mnc != null) {
            sb.append(", n_mnc=");
            sb.append(this.n_mnc);
        }
        if (this.s_mcc != null) {
            sb.append(", s_mcc=");
            sb.append(this.s_mcc);
        }
        if (this.s_mnc != null) {
            sb.append(", s_mnc=");
            sb.append(this.s_mnc);
        }
        if (this.r_mcc != null) {
            sb.append(", r_mcc=");
            sb.append(this.r_mcc);
        }
        if (this.r_mnc != null) {
            sb.append(", r_mnc=");
            sb.append(this.r_mnc);
        }
        if (this.cpu_info != null) {
            sb.append(", cpu_info=");
            sb.append(this.cpu_info);
        }
        if (this.cpu_max_speed != null) {
            sb.append(", cpu_max_speed=");
            sb.append(this.cpu_max_speed);
        }
        if (this.cpu_core_labels != null) {
            sb.append(", cpu_core_labels=");
            sb.append(this.cpu_core_labels);
        }
        if (this.google_advertising_id != null) {
            sb.append(", google_advertising_id=");
            sb.append(this.google_advertising_id);
        }
        if (this.device_architecture != null) {
            sb.append(", device_architecture=");
            sb.append(this.device_architecture);
        }
        if (this.os_architecture != null) {
            sb.append(", os_architecture=");
            sb.append(this.os_architecture);
        }
        return c.a(sb, 0, 2, "DeviceInfoMessage{", AbstractJsonLexerKt.END_OBJ);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceInfoMessage(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, Integer num2, Integer num3, String str9, String str10, String str11, String str12, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, String str13, Integer num10, String str14, String str15, String str16, String str17, ByteString byteString) {
        super(ADAPTER, byteString);
        this.m2_id = str;
        this.device_type = str2;
        this.android_version = num;
        this.device_hash = str3;
        this.android_id = str4;
        this.mac_address = str5;
        this.phone_id = str6;
        this.device_name = str7;
        this.carrier_name = str8;
        this.mcc = num2;
        this.mnc = num3;
        this.language = str9;
        this.bootloader_id = str10;
        this.os_build_version = str11;
        this.os_build_id = str12;
        this.n_mcc = num4;
        this.n_mnc = num5;
        this.s_mcc = num6;
        this.s_mnc = num7;
        this.r_mcc = num8;
        this.r_mnc = num9;
        this.cpu_info = str13;
        this.cpu_max_speed = num10;
        this.cpu_core_labels = str14;
        this.google_advertising_id = str15;
        this.device_architecture = str16;
        this.os_architecture = str17;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.m2_id = this.m2_id;
        builder.device_type = this.device_type;
        builder.android_version = this.android_version;
        builder.device_hash = this.device_hash;
        builder.android_id = this.android_id;
        builder.mac_address = this.mac_address;
        builder.phone_id = this.phone_id;
        builder.device_name = this.device_name;
        builder.carrier_name = this.carrier_name;
        builder.mcc = this.mcc;
        builder.mnc = this.mnc;
        builder.language = this.language;
        builder.bootloader_id = this.bootloader_id;
        builder.os_build_version = this.os_build_version;
        builder.os_build_id = this.os_build_id;
        builder.n_mcc = this.n_mcc;
        builder.n_mnc = this.n_mnc;
        builder.s_mcc = this.s_mcc;
        builder.s_mnc = this.s_mnc;
        builder.r_mcc = this.r_mcc;
        builder.r_mnc = this.r_mnc;
        builder.cpu_info = this.cpu_info;
        builder.cpu_max_speed = this.cpu_max_speed;
        builder.cpu_core_labels = this.cpu_core_labels;
        builder.google_advertising_id = this.google_advertising_id;
        builder.device_architecture = this.device_architecture;
        builder.os_architecture = this.os_architecture;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
