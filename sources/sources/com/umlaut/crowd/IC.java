package com.umlaut.crowd;

import androidx.work.PeriodicWorkRequest;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.internal.b0;
import com.umlaut.crowd.internal.d;
import com.umlaut.crowd.internal.mc;
import com.umlaut.crowd.internal.r1;
import com.umlaut.crowd.internal.z4;

public class IC {
    private boolean ANDROID_ID_CHECK_ENABLED;
    private d APNINFO_PCSCFADDRESS_RECORDTYPE;
    private boolean APPUSAGE_BROWSER_SESSION_TRACKING_ENABLED;
    private boolean APPUSAGE_MANAGER_INSTALLED_APP_SNAPSHOT_ENABLED;
    private boolean APPUSAGE_MEASURE_ALL_MPA;
    private boolean APPUSAGE_REQUIRE_PERMISSION;
    private boolean APPUSAGE_SERVICE_ENABLED;
    private mc APPUSAGE_TRAFFIC_DETECTION_MODE;
    private boolean AUTO_UPLOAD_ENABLED = true;
    private String BACKGROUND_TEST_CONFIG_URL;
    private boolean BACKGROUND_TEST_IN_POWER_SAVE;
    private boolean BACKGROUND_TEST_JOB_CHARGING;
    private int BACKGROUND_TEST_JOB_CONNECTION;
    private int BACKGROUND_TEST_JOB_DELAY;
    private long BACKGROUND_TEST_JOB_INTERVAL;
    private int BACKGROUND_TEST_JOB_WAKELOCK_TIMEOUT;
    private CLC.ProviderMode BACKGROUND_TEST_LOCATIONPROVIDER;
    private int BACKGROUND_TEST_MIN_BATTERY_LEVEL;
    private boolean BACKGROUND_TEST_SERVICE_ENABLED;
    private int BACKGROUND_TEST_TIMEOUT;
    private long BACKGROUND_TEST_UPDATE_INTERVAL;
    private boolean BANDWDITH_TEST_MANAGER_GET_IMEI_IMSI;
    private boolean BATTERYINFO_TAKE_CPU_TEMP;
    private String CAMPAIGN_ID = "Campaign001";
    private boolean CLEAR_AUS_LOCATION_INFO;
    private boolean CLEAR_CT_LOCATION_INFO;
    private boolean CLEAR_LTR_LOCATION_INFO;
    private boolean CLEAR_MSG_LOCATION_INFO;
    private boolean CLEAR_NF_LOCATION_INFO;
    private boolean CLEAR_NTR_LOCATION_INFO;
    private boolean CLEAR_RSS_LOCATION_INFO;
    private boolean CLEAR_VC_LOCATION_INFO;
    private boolean CLEAR_WPT_LOCATION_INFO;
    private boolean CLEAR_YT_LOCATION_INFO;
    private boolean CONNECTIVITY_KEEPALIVE_ENABLED = false;
    private long CONNECTIVITY_KEEPALIVE_INTERVAL = 86400000;
    private boolean CONNECTIVITY_TEST_ALLOW_IN_IDLE = false;
    private long CONNECTIVITY_TEST_CDNCONFIG_UPDATE_INTERVAL = 86400000;
    private String CONNECTIVITY_TEST_CDNCONFIG_URL = "https://configs.sdk.crowd-umlaut.com/configs/[PROJECTID]/cdnconfig.zip";
    private r1 CONNECTIVITY_TEST_CRITERIA;
    private boolean CONNECTIVITY_TEST_ENABLED = false;
    private boolean CONNECTIVITY_TEST_ENABLED_IN_ROAMING = true;
    private boolean CONNECTIVITY_TEST_ENABLE_TRACEROUTE = true;
    private String CONNECTIVITY_TEST_FILENAME = "";
    private String CONNECTIVITY_TEST_HOSTNAME = "";
    private String[] CONNECTIVITY_TEST_HOSTNAME_ARRAY;
    private boolean CONNECTIVITY_TEST_IGNORE_SUCCESS_TO_UPLOAD;
    private long CONNECTIVITY_TEST_INTERVAL = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
    private String CONNECTIVITY_TEST_IP = "";
    private CLC.ProviderMode CONNECTIVITY_TEST_LOCATIONPROVIDER;
    private boolean CONNECTIVITY_TEST_LOGGING;
    private double CONNECTIVITY_TEST_MINIMUM_ACCURACY;
    private int CONNECTIVITY_TEST_MINIMUM_ACCURACY_LOCATION_AGE;
    private int CONNECTIVITY_TEST_MINIMUM_ACCURACY_TIMEOUT;
    private float CONNECTIVITY_TEST_MIN_BATTERY_LEVEL = 15.0f;
    private long CONNECTIVITY_TEST_TRUSTSTORE_UPDATE_INTERVAL = 86400000;
    private String CONNECTIVITY_TEST_TRUSTSTORE_URL = "https://configs.sdk.crowd-umlaut.com/configs/[PROJECTID]/truststore.zip";
    private long CORE_EXPIRATION_TIMESTAMP;
    private long COVERAGE_MAPPER_SERVICE_CELL_ID_CHANGE_MEASUREMENT_DUARTION;
    private boolean COVERAGE_MAPPER_SERVICE_ENABLED;
    private long COVERAGE_MAPPER_SERVICE_FOREGROUND_MEASUREMENT_DUARTION;
    private boolean COVERAGE_MAPPER_SERVICE_INTERNET_CONNECTIVITY_MONITORING;
    private long COVERAGE_MAPPER_SERVICE_NRSTATE_CHANGE_MEASUREMENT_DUARTION;
    private boolean COVERAGE_MAPPER_SERVICE_NRSTATE_CHANGE_MEASUREMENT_REQUIRES_LOCATION;
    private long COVERAGE_MAPPER_SERVICE_OUT_OF_SERVICE_MEASUREMENT_DUARTION;
    private long COVERAGE_MAPPER_SERVICE_SAMSUNG_NETWORK_MEASUREMENT_DUARTION;
    private boolean COVERAGE_MAPPER_SERVICE_START_STOP_TRIGGER;
    private CLC.ProviderMode COVERAGE_MAPPER_SERVICE_TRIGGER_PROVIDER_MODE;
    private boolean CT_COLLECT_APNINFO;
    private boolean CT_COLLECT_CELLINFO;
    private boolean CT_COLLECT_CONNECTEDDEVICES;
    private long DATABASE_ENTRIES_MAX_AGE_DAYS;
    private int DNS_CUSTOM_CACHE_DURATION;
    private boolean DNS_CUSTOM_LOOKUP;
    private boolean FOREGROUND_TEST_CT_ENABLED;
    private long FOREGROUND_TEST_CT_MIN_INTERVAL;
    private long FOREGROUND_TEST_CT_SCHEDULE_INTERVAL;
    private boolean FOREGROUND_TEST_NIR_ENABLED;
    private long GEOIP_CLEAR_CACHE_INTERVAL;
    private boolean GEOIP_MOBILE_ENABLED;
    private long GEOIP_UPDATE_INTERVAL;
    private String GEOIP_URL;
    private long GUID_MAX_AGE;
    private int INSIGHTCORE_SERVICE_INTERVAL = 60000;
    private String[] IPV4_DNS_CUSTOM_SERVER;
    private String[] IPV6_DNS_CUSTOM_SERVER;
    private z4 LATENCY_TEST_CRITERIA;
    private String[] LATENCY_TEST_HOSTNAME_ARRAY;
    private boolean LATENCY_TEST_LOGGING;
    private boolean LTR_COLLECT_CELLINFO;
    private CLC.ProviderMode LTR_LOCATIONPROVIDER;
    private d MESSAGINGMANAGER_PHONENUMBER_RECORD_TYPE;
    private boolean MESSAGING_SERVICE_ENABLED;
    private boolean NIR_COLLECT_CELLINFO;
    private int NIR_COLLECT_CELLINFO_THRESHOLD;
    private String NTP_SERVER;
    private boolean NTP_SYNC_ENABLED;
    private long NTP_SYNC_INTERVAL;
    private String P3ST_CDN_DOWNLOAD_URL;
    private String P3ST_CDN_UPLOAD_URL;
    private String P3ST_CONTROL_SERVER;
    private int P3ST_CUSTOM_TCP_PORT;
    private String P3ST_ICMP_SERVER;
    private int P3ST_NUMBER_OF_PINGS;
    private int P3ST_NUMBER_OF_SOCKETS;
    private boolean P3ST_USE_CDN_DOWNLOAD;
    private boolean P3ST_USE_CDN_UPLOAD;
    private boolean P3ST_USE_ICMP_PING;
    private String PRIVACY_PAGE_URL;
    private String PROJECT_ID = "0";
    private boolean QOE_MANAGER_ENABLED;
    private String RAILNET_LOCATION_PROVIDER_SSID;
    private boolean SEND_REGISTRATION_TIMESTAMP_ENABLED;
    private d SIMINFO_ICCID_RECORDTYPE;
    private d SIMINFO_IMSI_RECORDTYPE;
    private boolean START_SERVICES_IN_FOREGROUND;
    private boolean STATSMANAGER_ENABLED;
    private long STATSMANAGER_ENTRIES_MAX_AGE_DAYS;
    private boolean STATSMANAGER_LEGACY_ENABLED;
    private int[] STATSMANAGER_SIGNAL_STRENGTH_MAPPING_2G;
    private int[] STATSMANAGER_SIGNAL_STRENGTH_MAPPING_3G;
    private int[] STATSMANAGER_SIGNAL_STRENGTH_MAPPING_4G;
    private int[] STATSMANAGER_SIGNAL_STRENGTH_MAPPING_5G;
    private boolean STATSMANAGER_USE_NTR_FOR_RATSHARE_AND_SIGNALSTRENGTH;
    private boolean TRAFFIC_ANALYZER_ENABLED;
    private boolean TRAFFIC_ANALYZER_MPT_ENABLED;
    private boolean TRC_COLLECT_CELLINFO;
    private int TRC_EACH_HOP_PINGS;
    private int TRC_HOP_TIMEOUT;
    private int TRC_MAX_HOPS;
    private b0 UPLOAD_BATTERY_STATUS_CONSTRAINT = b0.Always;
    private String UPLOAD_DUS_URL = "https://dus.sdk.crowd-umlaut.com/isupload/upload_check_lumen.php";
    private boolean UPLOAD_ENABLED_IN_ROAMING = true;
    private boolean UPLOAD_ENABLED_IN_ROAMING_WIFI = true;
    private boolean UPLOAD_INFORMATION_ENABLED = false;
    private boolean UPLOAD_LOGGING;
    private String[] UPLOAD_TICKET_FALLBACK_URL_ARRAY = {"https://ul.api.c0nnectthed0ts.com/ul/v3/", "https://awsul3.api.c0nnectthed0ts.com/ul/v3/"};
    private String UPLOAD_TICKET_URL = "https://ul.sdk.crowd-umlaut.com/ul/v3/";
    private long UPLOAD_TIMESPAN_BETWEEN_EXPORTS = 14400000;
    private long UPLOAD_TIMESPAN_BETWEEN_UPLOADS = 57600000;
    private long UPLOAD_TIMESPAN_BETWEEN_UPLOADS_WIFI = 14400000;
    private boolean USE_WORK_MANAGER;
    private boolean VC_COLLECT_APNINFO;
    private boolean VC_COLLECT_CELLINFO;
    private CLC.ProviderMode VOICEMANAGER_LOCATIONPROVIDER;
    private CLC.ProviderMode VOICEMANAGER_LOCATIONPROVIDER_DROPPEDWINDOW;
    private d VOICEMANAGER_PHONENUMBER_RECORD_TYPE;
    private boolean VOICEMANAGER_SAVE_DROPPEDWINDOW_MPVS;
    private boolean VOICEMANAGER_USE_READ_CALL_LOG_PERMISSION;
    private boolean VOICE_SERVICE_ENABLED;
    private String VOWIFI_TEST_EPDG_LATENCY_IP;
    private String VOWIFI_TEST_EPDG_SERVER_URL;
    private boolean VOWIFI_TEST_MANAGER_ENABLED;
    private String VOWIFI_TEST_PORT_TEST_SERVER_URL;
    private int WIFICONNECTEDDEVICES_IPV6_ANONYMIZATIONCOUNT;
    private d WIFICONNECTEDDEVICES_IP_RECORDTYPE;
    private int WIFICONNECTEDDEVICES_MAC_ANONYMIZATIONCOUNT;
    private d WIFICONNECTEDDEVICES_MAC_RECORDTYPE;
    private d WIFIINFO_BSSID_RECORDTYPE;
    private boolean WIFIINFO_COLLECT_ETHERNET_MAC;
    private d WIFIINFO_DEFAULT_GATEWAY_MAC_RECORDTYPE;
    private d WIFIINFO_SSID_RECORDTYPE;
    private d WIFISCAN_BSSID_RECORDTYPE;
    private String WIFISCAN_SALT;
    private d WIFISCAN_SSID_RECORDTYPE;
    private long WIFI_CONNECTED_DEVICES_INTERVAL;
    private long WIFI_ROUTER_DATA_INTERVAL;
    private boolean WIFI_SCAN_ENABLED;
    private long WIFI_SCAN_MINIMUM_INTERVAL;
    private String YT_USER_AGENT;

    public IC() {
        CLC.ProviderMode providerMode = CLC.ProviderMode.Passive;
        this.CONNECTIVITY_TEST_LOCATIONPROVIDER = providerMode;
        this.CONNECTIVITY_TEST_MINIMUM_ACCURACY_TIMEOUT = 2000;
        this.CONNECTIVITY_TEST_MINIMUM_ACCURACY = 1.0d;
        this.CONNECTIVITY_TEST_MINIMUM_ACCURACY_LOCATION_AGE = 1;
        this.CONNECTIVITY_TEST_IGNORE_SUCCESS_TO_UPLOAD = false;
        this.APPUSAGE_SERVICE_ENABLED = false;
        this.APPUSAGE_MANAGER_INSTALLED_APP_SNAPSHOT_ENABLED = false;
        this.APPUSAGE_BROWSER_SESSION_TRACKING_ENABLED = false;
        this.APPUSAGE_TRAFFIC_DETECTION_MODE = mc.Auto;
        this.APPUSAGE_REQUIRE_PERMISSION = true;
        this.COVERAGE_MAPPER_SERVICE_ENABLED = false;
        this.COVERAGE_MAPPER_SERVICE_TRIGGER_PROVIDER_MODE = CLC.ProviderMode.GpsAndNetwork;
        this.COVERAGE_MAPPER_SERVICE_OUT_OF_SERVICE_MEASUREMENT_DUARTION = 10000;
        this.COVERAGE_MAPPER_SERVICE_CELL_ID_CHANGE_MEASUREMENT_DUARTION = 1;
        this.COVERAGE_MAPPER_SERVICE_FOREGROUND_MEASUREMENT_DUARTION = 10000;
        this.COVERAGE_MAPPER_SERVICE_SAMSUNG_NETWORK_MEASUREMENT_DUARTION = 10000;
        this.COVERAGE_MAPPER_SERVICE_NRSTATE_CHANGE_MEASUREMENT_DUARTION = 5000;
        this.COVERAGE_MAPPER_SERVICE_NRSTATE_CHANGE_MEASUREMENT_REQUIRES_LOCATION = true;
        this.COVERAGE_MAPPER_SERVICE_INTERNET_CONNECTIVITY_MONITORING = false;
        this.COVERAGE_MAPPER_SERVICE_START_STOP_TRIGGER = false;
        d dVar = d.Anonymized;
        this.VOICEMANAGER_PHONENUMBER_RECORD_TYPE = dVar;
        this.VOICEMANAGER_LOCATIONPROVIDER = providerMode;
        this.VOICEMANAGER_LOCATIONPROVIDER_DROPPEDWINDOW = providerMode;
        this.VOICEMANAGER_SAVE_DROPPEDWINDOW_MPVS = false;
        this.VOICEMANAGER_USE_READ_CALL_LOG_PERMISSION = true;
        this.LTR_LOCATIONPROVIDER = providerMode;
        this.LTR_COLLECT_CELLINFO = false;
        this.MESSAGINGMANAGER_PHONENUMBER_RECORD_TYPE = dVar;
        this.VOICE_SERVICE_ENABLED = false;
        this.MESSAGING_SERVICE_ENABLED = false;
        this.VOWIFI_TEST_MANAGER_ENABLED = false;
        this.GUID_MAX_AGE = 15552000000L;
        this.STATSMANAGER_ENABLED = false;
        this.STATSMANAGER_LEGACY_ENABLED = false;
        this.STATSMANAGER_USE_NTR_FOR_RATSHARE_AND_SIGNALSTRENGTH = true;
        this.STATSMANAGER_SIGNAL_STRENGTH_MAPPING_2G = new int[]{-57, -79, -89, -99};
        this.STATSMANAGER_SIGNAL_STRENGTH_MAPPING_3G = new int[]{-65, -85, -95, -101};
        this.STATSMANAGER_SIGNAL_STRENGTH_MAPPING_4G = new int[]{-79, -92, -112, -124};
        this.STATSMANAGER_SIGNAL_STRENGTH_MAPPING_5G = new int[]{-95, -105, -115, -120};
        this.STATSMANAGER_ENTRIES_MAX_AGE_DAYS = 30;
        this.DATABASE_ENTRIES_MAX_AGE_DAYS = 30;
        this.TRAFFIC_ANALYZER_ENABLED = false;
        this.TRAFFIC_ANALYZER_MPT_ENABLED = false;
        this.QOE_MANAGER_ENABLED = false;
        this.SEND_REGISTRATION_TIMESTAMP_ENABLED = false;
        this.GEOIP_URL = "https://webapi.sdk.crowd-umlaut.com/geoip/";
        this.GEOIP_MOBILE_ENABLED = true;
        this.GEOIP_UPDATE_INTERVAL = 86400000;
        this.GEOIP_CLEAR_CACHE_INTERVAL = 604800000;
        this.P3ST_CONTROL_SERVER = "st.sdk.crowd-umlaut.com";
        this.P3ST_CUSTOM_TCP_PORT = 20000;
        this.P3ST_NUMBER_OF_SOCKETS = 3;
        this.P3ST_NUMBER_OF_PINGS = 4;
        this.P3ST_USE_ICMP_PING = false;
        this.P3ST_USE_CDN_DOWNLOAD = false;
        this.P3ST_USE_CDN_UPLOAD = false;
        this.P3ST_ICMP_SERVER = "8.8.8.8";
        this.P3ST_CDN_DOWNLOAD_URL = "https://cloudfront.sdk.crowd-umlaut.com/5g.bin";
        this.P3ST_CDN_UPLOAD_URL = "https://upload-sdk-crowd-umlaut.s3-accelerate.amazonaws.com";
        this.START_SERVICES_IN_FOREGROUND = false;
        this.BANDWDITH_TEST_MANAGER_GET_IMEI_IMSI = false;
        this.APPUSAGE_MEASURE_ALL_MPA = false;
        this.CORE_EXPIRATION_TIMESTAMP = -1;
        d dVar2 = d.Full;
        this.WIFIINFO_SSID_RECORDTYPE = dVar2;
        this.WIFIINFO_BSSID_RECORDTYPE = dVar2;
        this.WIFIINFO_DEFAULT_GATEWAY_MAC_RECORDTYPE = dVar2;
        this.WIFIINFO_COLLECT_ETHERNET_MAC = false;
        d dVar3 = d.Hashed;
        this.WIFISCAN_SSID_RECORDTYPE = dVar3;
        this.WIFISCAN_BSSID_RECORDTYPE = dVar3;
        this.WIFISCAN_SALT = "Tualmu";
        this.SIMINFO_ICCID_RECORDTYPE = dVar;
        this.SIMINFO_IMSI_RECORDTYPE = dVar;
        this.APNINFO_PCSCFADDRESS_RECORDTYPE = dVar;
        this.NTP_SYNC_ENABLED = true;
        this.NTP_SERVER = "pool.ntp.org";
        this.NTP_SYNC_INTERVAL = 28800000;
        this.VOWIFI_TEST_PORT_TEST_SERVER_URL = "";
        this.VOWIFI_TEST_EPDG_SERVER_URL = "";
        this.VOWIFI_TEST_EPDG_LATENCY_IP = "";
        this.NIR_COLLECT_CELLINFO = true;
        this.NIR_COLLECT_CELLINFO_THRESHOLD = 2;
        this.VC_COLLECT_CELLINFO = false;
        this.VC_COLLECT_APNINFO = true;
        this.CT_COLLECT_CELLINFO = true;
        this.CT_COLLECT_APNINFO = true;
        this.CLEAR_AUS_LOCATION_INFO = false;
        this.CLEAR_CT_LOCATION_INFO = false;
        this.CLEAR_LTR_LOCATION_INFO = false;
        this.CLEAR_MSG_LOCATION_INFO = false;
        this.CLEAR_NF_LOCATION_INFO = false;
        this.CLEAR_NTR_LOCATION_INFO = false;
        this.CLEAR_RSS_LOCATION_INFO = false;
        this.CLEAR_WPT_LOCATION_INFO = false;
        this.CLEAR_VC_LOCATION_INFO = false;
        this.CLEAR_YT_LOCATION_INFO = false;
        this.YT_USER_AGENT = "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";
        this.CONNECTIVITY_TEST_HOSTNAME_ARRAY = new String[0];
        this.CONNECTIVITY_TEST_CRITERIA = r1.Random;
        this.LATENCY_TEST_HOSTNAME_ARRAY = new String[0];
        this.LATENCY_TEST_CRITERIA = z4.CTItem;
        this.WIFI_SCAN_MINIMUM_INTERVAL = 600000;
        this.WIFI_SCAN_ENABLED = false;
        this.BACKGROUND_TEST_SERVICE_ENABLED = false;
        this.FOREGROUND_TEST_NIR_ENABLED = true;
        this.FOREGROUND_TEST_CT_ENABLED = true;
        this.FOREGROUND_TEST_CT_MIN_INTERVAL = 180000;
        this.FOREGROUND_TEST_CT_SCHEDULE_INTERVAL = 300000;
        this.PRIVACY_PAGE_URL = "";
        this.USE_WORK_MANAGER = true;
        this.WIFI_ROUTER_DATA_INTERVAL = 60000;
        this.WIFI_CONNECTED_DEVICES_INTERVAL = CCS.a;
        this.WIFICONNECTEDDEVICES_MAC_RECORDTYPE = dVar;
        this.WIFICONNECTEDDEVICES_MAC_ANONYMIZATIONCOUNT = 6;
        this.WIFICONNECTEDDEVICES_IP_RECORDTYPE = dVar;
        this.WIFICONNECTEDDEVICES_IPV6_ANONYMIZATIONCOUNT = 10;
        this.CT_COLLECT_CONNECTEDDEVICES = true;
        this.BACKGROUND_TEST_UPDATE_INTERVAL = 86400000;
        this.BACKGROUND_TEST_CONFIG_URL = "";
        this.BACKGROUND_TEST_JOB_INTERVAL = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
        this.BACKGROUND_TEST_JOB_CHARGING = false;
        this.BACKGROUND_TEST_JOB_CONNECTION = 1;
        this.BACKGROUND_TEST_TIMEOUT = 10000;
        this.BACKGROUND_TEST_JOB_WAKELOCK_TIMEOUT = 50000;
        this.BACKGROUND_TEST_JOB_DELAY = 10000;
        this.BACKGROUND_TEST_MIN_BATTERY_LEVEL = 15;
        this.BACKGROUND_TEST_LOCATIONPROVIDER = providerMode;
        this.BACKGROUND_TEST_IN_POWER_SAVE = false;
        this.TRC_MAX_HOPS = 30;
        this.TRC_EACH_HOP_PINGS = 3;
        this.TRC_HOP_TIMEOUT = 5000;
        this.TRC_COLLECT_CELLINFO = false;
        this.RAILNET_LOCATION_PROVIDER_SSID = "WIFIonICE";
        this.CONNECTIVITY_TEST_LOGGING = false;
        this.LATENCY_TEST_LOGGING = false;
        this.UPLOAD_LOGGING = false;
        this.ANDROID_ID_CHECK_ENABLED = false;
        this.DNS_CUSTOM_LOOKUP = false;
        this.DNS_CUSTOM_CACHE_DURATION = 300000;
        this.IPV4_DNS_CUSTOM_SERVER = new String[]{"8.8.8.8", "1.1.1.1"};
        this.IPV6_DNS_CUSTOM_SERVER = new String[]{"2001:4860:4860:0:0:0:0:8888", "2606:4700:4700:0:0:0:0:1111"};
        this.BATTERYINFO_TAKE_CPU_TEMP = false;
    }

    public boolean A() {
        return this.CLEAR_LTR_LOCATION_INFO;
    }

    public long A0() {
        return this.GEOIP_CLEAR_CACHE_INTERVAL;
    }

    public b0 A1() {
        return this.UPLOAD_BATTERY_STATUS_CONSTRAINT;
    }

    public boolean B() {
        return this.CLEAR_MSG_LOCATION_INFO;
    }

    public boolean B0() {
        return this.GEOIP_MOBILE_ENABLED;
    }

    public String B1() {
        return this.UPLOAD_DUS_URL;
    }

    public boolean C() {
        return this.CLEAR_NF_LOCATION_INFO;
    }

    public long C0() {
        return this.GEOIP_UPDATE_INTERVAL;
    }

    public boolean C1() {
        return this.UPLOAD_ENABLED_IN_ROAMING;
    }

    public boolean D() {
        return this.CLEAR_NTR_LOCATION_INFO;
    }

    public String D0() {
        return this.GEOIP_URL;
    }

    public boolean D1() {
        return this.UPLOAD_ENABLED_IN_ROAMING_WIFI;
    }

    public boolean E() {
        return this.CLEAR_RSS_LOCATION_INFO;
    }

    public long E0() {
        return this.GUID_MAX_AGE;
    }

    public boolean E1() {
        return this.UPLOAD_INFORMATION_ENABLED;
    }

    public boolean F() {
        return this.CLEAR_VC_LOCATION_INFO;
    }

    public int F0() {
        return this.INSIGHTCORE_SERVICE_INTERVAL;
    }

    public boolean F1() {
        return this.UPLOAD_LOGGING;
    }

    public boolean G() {
        return this.CLEAR_WPT_LOCATION_INFO;
    }

    public String[] G0() {
        return this.IPV4_DNS_CUSTOM_SERVER;
    }

    public String[] G1() {
        return this.UPLOAD_TICKET_FALLBACK_URL_ARRAY;
    }

    public boolean H() {
        return this.CLEAR_YT_LOCATION_INFO;
    }

    public String[] H0() {
        return this.IPV6_DNS_CUSTOM_SERVER;
    }

    public String H1() {
        return this.UPLOAD_TICKET_URL;
    }

    public boolean I() {
        return this.CONNECTIVITY_KEEPALIVE_ENABLED;
    }

    public z4 I0() {
        return this.LATENCY_TEST_CRITERIA;
    }

    public long I1() {
        return this.UPLOAD_TIMESPAN_BETWEEN_EXPORTS;
    }

    public long J() {
        return this.CONNECTIVITY_KEEPALIVE_INTERVAL;
    }

    public String[] J0() {
        return this.LATENCY_TEST_HOSTNAME_ARRAY;
    }

    public long J1() {
        return this.UPLOAD_TIMESPAN_BETWEEN_UPLOADS;
    }

    public boolean K() {
        return this.CONNECTIVITY_TEST_ALLOW_IN_IDLE;
    }

    public boolean K0() {
        return this.LATENCY_TEST_LOGGING;
    }

    public long K1() {
        return this.UPLOAD_TIMESPAN_BETWEEN_UPLOADS_WIFI;
    }

    public long L() {
        return this.CONNECTIVITY_TEST_CDNCONFIG_UPDATE_INTERVAL;
    }

    public boolean L0() {
        return this.LTR_COLLECT_CELLINFO;
    }

    public boolean L1() {
        return this.USE_WORK_MANAGER;
    }

    public String M() {
        return this.CONNECTIVITY_TEST_CDNCONFIG_URL;
    }

    public CLC.ProviderMode M0() {
        return this.LTR_LOCATIONPROVIDER;
    }

    public boolean M1() {
        return this.VC_COLLECT_APNINFO;
    }

    public r1 N() {
        return this.CONNECTIVITY_TEST_CRITERIA;
    }

    public d N0() {
        return this.MESSAGINGMANAGER_PHONENUMBER_RECORD_TYPE;
    }

    public boolean N1() {
        return this.VC_COLLECT_CELLINFO;
    }

    public boolean O() {
        return this.CONNECTIVITY_TEST_ENABLED;
    }

    public boolean O0() {
        return this.MESSAGING_SERVICE_ENABLED;
    }

    public CLC.ProviderMode O1() {
        return this.VOICEMANAGER_LOCATIONPROVIDER;
    }

    public boolean P() {
        return this.CONNECTIVITY_TEST_ENABLED_IN_ROAMING;
    }

    public boolean P0() {
        return this.NIR_COLLECT_CELLINFO;
    }

    public CLC.ProviderMode P1() {
        return this.VOICEMANAGER_LOCATIONPROVIDER_DROPPEDWINDOW;
    }

    public boolean Q() {
        return this.CONNECTIVITY_TEST_ENABLE_TRACEROUTE;
    }

    public int Q0() {
        return this.NIR_COLLECT_CELLINFO_THRESHOLD;
    }

    public d Q1() {
        return this.VOICEMANAGER_PHONENUMBER_RECORD_TYPE;
    }

    public String R() {
        return this.CONNECTIVITY_TEST_FILENAME;
    }

    public String R0() {
        return this.NTP_SERVER;
    }

    public boolean R1() {
        return this.VOICEMANAGER_SAVE_DROPPEDWINDOW_MPVS;
    }

    public String S() {
        return this.CONNECTIVITY_TEST_HOSTNAME;
    }

    public boolean S0() {
        return this.NTP_SYNC_ENABLED;
    }

    public boolean S1() {
        return this.VOICEMANAGER_USE_READ_CALL_LOG_PERMISSION;
    }

    public String[] T() {
        return this.CONNECTIVITY_TEST_HOSTNAME_ARRAY;
    }

    public long T0() {
        return this.NTP_SYNC_INTERVAL;
    }

    public boolean T1() {
        return this.VOICE_SERVICE_ENABLED;
    }

    public boolean U() {
        return this.CONNECTIVITY_TEST_IGNORE_SUCCESS_TO_UPLOAD;
    }

    public String U0() {
        return this.P3ST_CDN_DOWNLOAD_URL;
    }

    public String U1() {
        return this.VOWIFI_TEST_EPDG_LATENCY_IP;
    }

    public long V() {
        return this.CONNECTIVITY_TEST_INTERVAL;
    }

    public String V0() {
        return this.P3ST_CDN_UPLOAD_URL;
    }

    public String V1() {
        return this.VOWIFI_TEST_EPDG_SERVER_URL;
    }

    public String W() {
        return this.CONNECTIVITY_TEST_IP;
    }

    public String W0() {
        return this.P3ST_CONTROL_SERVER;
    }

    public boolean W1() {
        return this.VOWIFI_TEST_MANAGER_ENABLED;
    }

    public CLC.ProviderMode X() {
        return this.CONNECTIVITY_TEST_LOCATIONPROVIDER;
    }

    public int X0() {
        return this.P3ST_CUSTOM_TCP_PORT;
    }

    public String X1() {
        return this.VOWIFI_TEST_PORT_TEST_SERVER_URL;
    }

    public boolean Y() {
        return this.CONNECTIVITY_TEST_LOGGING;
    }

    public String Y0() {
        return this.P3ST_ICMP_SERVER;
    }

    public int Y1() {
        return this.WIFICONNECTEDDEVICES_IPV6_ANONYMIZATIONCOUNT;
    }

    public double Z() {
        return this.CONNECTIVITY_TEST_MINIMUM_ACCURACY;
    }

    public int Z0() {
        return this.P3ST_NUMBER_OF_PINGS;
    }

    public d Z1() {
        return this.WIFICONNECTEDDEVICES_IP_RECORDTYPE;
    }

    public boolean a() {
        return this.ANDROID_ID_CHECK_ENABLED;
    }

    public int a0() {
        return this.CONNECTIVITY_TEST_MINIMUM_ACCURACY_LOCATION_AGE;
    }

    public int a1() {
        return this.P3ST_NUMBER_OF_SOCKETS;
    }

    public int a2() {
        return this.WIFICONNECTEDDEVICES_MAC_ANONYMIZATIONCOUNT;
    }

    public d b() {
        return this.APNINFO_PCSCFADDRESS_RECORDTYPE;
    }

    public int b0() {
        return this.CONNECTIVITY_TEST_MINIMUM_ACCURACY_TIMEOUT;
    }

    public boolean b1() {
        return this.P3ST_USE_CDN_DOWNLOAD;
    }

    public d b2() {
        return this.WIFICONNECTEDDEVICES_MAC_RECORDTYPE;
    }

    public boolean c() {
        return this.APPUSAGE_BROWSER_SESSION_TRACKING_ENABLED;
    }

    public float c0() {
        return this.CONNECTIVITY_TEST_MIN_BATTERY_LEVEL;
    }

    public boolean c1() {
        return this.P3ST_USE_CDN_UPLOAD;
    }

    public d c2() {
        return this.WIFIINFO_BSSID_RECORDTYPE;
    }

    public boolean d() {
        return this.APPUSAGE_MANAGER_INSTALLED_APP_SNAPSHOT_ENABLED;
    }

    public long d0() {
        return this.CONNECTIVITY_TEST_TRUSTSTORE_UPDATE_INTERVAL;
    }

    public boolean d1() {
        return this.P3ST_USE_ICMP_PING;
    }

    public boolean d2() {
        return this.WIFIINFO_COLLECT_ETHERNET_MAC;
    }

    public boolean e() {
        return this.APPUSAGE_MEASURE_ALL_MPA;
    }

    public String e0() {
        return this.CONNECTIVITY_TEST_TRUSTSTORE_URL;
    }

    public String e1() {
        return this.PRIVACY_PAGE_URL;
    }

    public d e2() {
        return this.WIFIINFO_DEFAULT_GATEWAY_MAC_RECORDTYPE;
    }

    public boolean f() {
        return this.APPUSAGE_REQUIRE_PERMISSION;
    }

    public long f0() {
        return this.CORE_EXPIRATION_TIMESTAMP;
    }

    public String f1() {
        return this.PROJECT_ID;
    }

    public d f2() {
        return this.WIFIINFO_SSID_RECORDTYPE;
    }

    public boolean g() {
        return this.APPUSAGE_SERVICE_ENABLED;
    }

    public long g0() {
        return this.COVERAGE_MAPPER_SERVICE_CELL_ID_CHANGE_MEASUREMENT_DUARTION;
    }

    public boolean g1() {
        return this.QOE_MANAGER_ENABLED;
    }

    public d g2() {
        return this.WIFISCAN_BSSID_RECORDTYPE;
    }

    public mc h() {
        return this.APPUSAGE_TRAFFIC_DETECTION_MODE;
    }

    public boolean h0() {
        return this.COVERAGE_MAPPER_SERVICE_ENABLED;
    }

    public String h1() {
        return this.RAILNET_LOCATION_PROVIDER_SSID;
    }

    public String h2() {
        return this.WIFISCAN_SALT;
    }

    public boolean i() {
        return this.AUTO_UPLOAD_ENABLED;
    }

    public long i0() {
        return this.COVERAGE_MAPPER_SERVICE_FOREGROUND_MEASUREMENT_DUARTION;
    }

    public boolean i1() {
        return this.SEND_REGISTRATION_TIMESTAMP_ENABLED;
    }

    public d i2() {
        return this.WIFISCAN_SSID_RECORDTYPE;
    }

    public String j() {
        return this.BACKGROUND_TEST_CONFIG_URL;
    }

    public boolean j0() {
        return this.COVERAGE_MAPPER_SERVICE_INTERNET_CONNECTIVITY_MONITORING;
    }

    public d j1() {
        return this.SIMINFO_ICCID_RECORDTYPE;
    }

    public long j2() {
        return this.WIFI_CONNECTED_DEVICES_INTERVAL;
    }

    public boolean k() {
        return this.BACKGROUND_TEST_IN_POWER_SAVE;
    }

    public long k0() {
        return this.COVERAGE_MAPPER_SERVICE_NRSTATE_CHANGE_MEASUREMENT_DUARTION;
    }

    public d k1() {
        return this.SIMINFO_IMSI_RECORDTYPE;
    }

    public long k2() {
        return this.WIFI_ROUTER_DATA_INTERVAL;
    }

    public boolean l() {
        return this.BACKGROUND_TEST_JOB_CHARGING;
    }

    public boolean l0() {
        return this.COVERAGE_MAPPER_SERVICE_NRSTATE_CHANGE_MEASUREMENT_REQUIRES_LOCATION;
    }

    public boolean l1() {
        return this.START_SERVICES_IN_FOREGROUND;
    }

    public boolean l2() {
        return this.WIFI_SCAN_ENABLED;
    }

    public int m() {
        return this.BACKGROUND_TEST_JOB_CONNECTION;
    }

    public long m0() {
        return this.COVERAGE_MAPPER_SERVICE_OUT_OF_SERVICE_MEASUREMENT_DUARTION;
    }

    public boolean m1() {
        return this.STATSMANAGER_ENABLED;
    }

    public long m2() {
        return this.WIFI_SCAN_MINIMUM_INTERVAL;
    }

    public int n() {
        return this.BACKGROUND_TEST_JOB_DELAY;
    }

    public long n0() {
        return this.COVERAGE_MAPPER_SERVICE_SAMSUNG_NETWORK_MEASUREMENT_DUARTION;
    }

    public long n1() {
        return this.STATSMANAGER_ENTRIES_MAX_AGE_DAYS;
    }

    public String n2() {
        return this.YT_USER_AGENT;
    }

    public long o() {
        return this.BACKGROUND_TEST_JOB_INTERVAL;
    }

    public boolean o0() {
        return this.COVERAGE_MAPPER_SERVICE_START_STOP_TRIGGER;
    }

    public boolean o1() {
        return this.STATSMANAGER_LEGACY_ENABLED;
    }

    public int p() {
        return this.BACKGROUND_TEST_JOB_WAKELOCK_TIMEOUT;
    }

    public CLC.ProviderMode p0() {
        return this.COVERAGE_MAPPER_SERVICE_TRIGGER_PROVIDER_MODE;
    }

    public int[] p1() {
        return this.STATSMANAGER_SIGNAL_STRENGTH_MAPPING_2G;
    }

    public CLC.ProviderMode q() {
        return this.BACKGROUND_TEST_LOCATIONPROVIDER;
    }

    public boolean q0() {
        return this.CT_COLLECT_APNINFO;
    }

    public int[] q1() {
        return this.STATSMANAGER_SIGNAL_STRENGTH_MAPPING_3G;
    }

    public int r() {
        return this.BACKGROUND_TEST_MIN_BATTERY_LEVEL;
    }

    public boolean r0() {
        return this.CT_COLLECT_CELLINFO;
    }

    public int[] r1() {
        return this.STATSMANAGER_SIGNAL_STRENGTH_MAPPING_4G;
    }

    public boolean s() {
        return this.BACKGROUND_TEST_SERVICE_ENABLED;
    }

    public boolean s0() {
        return this.CT_COLLECT_CONNECTEDDEVICES;
    }

    public int[] s1() {
        return this.STATSMANAGER_SIGNAL_STRENGTH_MAPPING_5G;
    }

    public int t() {
        return this.BACKGROUND_TEST_TIMEOUT;
    }

    public long t0() {
        return this.DATABASE_ENTRIES_MAX_AGE_DAYS;
    }

    public boolean t1() {
        return this.STATSMANAGER_USE_NTR_FOR_RATSHARE_AND_SIGNALSTRENGTH;
    }

    public long u() {
        return this.BACKGROUND_TEST_UPDATE_INTERVAL;
    }

    public int u0() {
        return this.DNS_CUSTOM_CACHE_DURATION;
    }

    public boolean u1() {
        return this.TRAFFIC_ANALYZER_ENABLED;
    }

    public boolean v() {
        return this.BANDWDITH_TEST_MANAGER_GET_IMEI_IMSI;
    }

    public boolean v0() {
        return this.DNS_CUSTOM_LOOKUP;
    }

    public boolean v1() {
        return this.TRAFFIC_ANALYZER_MPT_ENABLED;
    }

    public boolean w() {
        return this.BATTERYINFO_TAKE_CPU_TEMP;
    }

    public boolean w0() {
        return this.FOREGROUND_TEST_CT_ENABLED;
    }

    public boolean w1() {
        return this.TRC_COLLECT_CELLINFO;
    }

    public String x() {
        return this.CAMPAIGN_ID;
    }

    public long x0() {
        return this.FOREGROUND_TEST_CT_MIN_INTERVAL;
    }

    public int x1() {
        return this.TRC_EACH_HOP_PINGS;
    }

    public boolean y() {
        return this.CLEAR_AUS_LOCATION_INFO;
    }

    public long y0() {
        return this.FOREGROUND_TEST_CT_SCHEDULE_INTERVAL;
    }

    public int y1() {
        return this.TRC_HOP_TIMEOUT;
    }

    public boolean z() {
        return this.CLEAR_CT_LOCATION_INFO;
    }

    public boolean z0() {
        return this.FOREGROUND_TEST_NIR_ENABLED;
    }

    public int z1() {
        return this.TRC_MAX_HOPS;
    }
}
