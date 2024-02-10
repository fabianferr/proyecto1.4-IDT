package com.bytedance.sdk.openadsdk.core;

import androidx.appcompat.app.AppCompatDelegate;
import com.bytedance.sdk.component.utils.s;
import io.antmedia.rtmp_client.RtmpClient;

/* compiled from: ErrorCode */
public class g {
    public static String a(int i) {
        if (i == -16) {
            return s.a(o.a(), "tt_error_ad_able_false_msg");
        }
        if (i == -15) {
            return s.a(o.a(), "tt_lack_android_manifest_configuration");
        }
        if (i == 117) {
            return "dynamic1 render time_out";
        }
        if (i == 118) {
            return "dynamic1 render error";
        }
        if (i == 127) {
            return "dynamic2 render time_out";
        }
        if (i == 128) {
            return "dynamic2 render error";
        }
        if (i == 201) {
            return s.a(o.a(), "tt_load_creative_icon_response_error");
        }
        if (i == 202) {
            return s.a(o.a(), "tt_load_creative_icon_error");
        }
        if (i == 10002) {
            return "load time out";
        }
        if (i == 10003) {
            return "resource error";
        }
        switch (i) {
            case AppCompatDelegate.MODE_NIGHT_UNSPECIFIED:
                return s.a(o.a(), "tt_init_setting_config_not_complete");
            case 113:
                return "dynamic1 parse error";
            case 123:
                return "dynamic2 parse error";
            case AD_SERVER_ERROR_VALUE:
                return s.a(o.a(), "tt_no_ad");
            case 40026:
                return s.a(o.a(), "tt_error_device_ip");
            case 40028:
                return s.a(o.a(), "tt_error_update_version");
            case 40034:
                return s.a(o.a(), "tt_error_bidding_type");
            case 40042:
                return s.a(o.a(), "tt_error_interstitial_version");
            case 40052:
                return s.a(o.a(), "tt_error_empty_content");
            case 50001:
                return s.a(o.a(), "tt_sys_error");
            case 60007:
                return s.a(o.a(), "tt_error_verify_reward");
            default:
                switch (i) {
                    case RtmpClient.RtmpIOException.HANDSHAKE_FAIL /*-12*/:
                        return s.a(o.a(), "tt_splash_not_have_cache_error");
                    case RtmpClient.RtmpIOException.HANDSHAKE_CONNECT_FAIL /*-11*/:
                        return s.a(o.a(), "tt_splash_cache_expired_error");
                    case RtmpClient.RtmpIOException.NO_SSL_TLS_SUPP /*-10*/:
                        return s.a(o.a(), "tt_splash_cache_parse_error");
                    case RtmpClient.RtmpIOException.SOCKET_CREATE_FAIL /*-9*/:
                        return s.a(o.a(), "tt_request_body_error");
                    case -8:
                        return s.a(o.a(), "tt_frequent_call_erroe");
                    case -7:
                        return s.a(o.a(), "tt_splash_ad_load_image_error");
                    case -6:
                        return s.a(o.a(), "tt_insert_ad_load_image_error");
                    case -5:
                        return s.a(o.a(), "tt_banner_ad_load_image_error");
                    case -4:
                        return s.a(o.a(), "tt_ad_data_error");
                    case -3:
                        return s.a(o.a(), "tt_no_ad_parse");
                    case -2:
                        return s.a(o.a(), "tt_net_error");
                    case -1:
                        return s.a(o.a(), "tt_parse_fail");
                    default:
                        switch (i) {
                            case 101:
                                return s.a(o.a(), "tt_render_render_parse_error");
                            case 102:
                                return s.a(o.a(), "tt_render_main_template_invalid");
                            case 103:
                                return s.a(o.a(), "tt_render_diff_template_invalid");
                            case 104:
                                return s.a(o.a(), "tt_render_fail_meta_invalid");
                            case 105:
                                return s.a(o.a(), "tt_render_fail_template_parse_error");
                            case 106:
                                return s.a(o.a(), "tt_render_fail_unknown");
                            case 107:
                                return s.a(o.a(), "tt_render_fail_timeout");
                            case 108:
                                return s.a(o.a(), "tt_reder_ad_load_timeout");
                            case 109:
                                return s.a(o.a(), "tt_template_load_fail");
                            default:
                                switch (i) {
                                    case 40000:
                                        return s.a(o.a(), "tt_content_type");
                                    case 40001:
                                        return s.a(o.a(), "tt_request_pb_error");
                                    case 40002:
                                        return s.a(o.a(), "tt_app_empty");
                                    case 40003:
                                        return s.a(o.a(), "tt_wap_empty");
                                    case 40004:
                                        return s.a(o.a(), "tt_adslot_empty");
                                    case 40005:
                                        return s.a(o.a(), "tt_adslot_size_empty");
                                    case 40006:
                                        return s.a(o.a(), "tt_adslot_id_error");
                                    case 40007:
                                        return s.a(o.a(), "tt_error_code_adcount_error");
                                    case 40008:
                                        return s.a(o.a(), "tt_error_image_size");
                                    case 40009:
                                        return s.a(o.a(), "tt_error_media_id");
                                    case 40010:
                                        return s.a(o.a(), "tt_error_media_type");
                                    case 40011:
                                        return s.a(o.a(), "tt_error_ad_type");
                                    case 40012:
                                    case 40017:
                                        return s.a(o.a(), "tt_error_access_method_pass");
                                    case 40013:
                                        return s.a(o.a(), "tt_error_splash_ad_type");
                                    case 40014:
                                        return s.a(o.a(), "tt_error_redirect");
                                    case 40015:
                                        return s.a(o.a(), "tt_error_request_invalid");
                                    case 40016:
                                        return s.a(o.a(), "tt_error_slot_id_app_id_differ");
                                    case 40018:
                                        return s.a(o.a(), "tt_error_package_name");
                                    case 40019:
                                        return s.a(o.a(), "tt_error_adtype_differ");
                                    case 40020:
                                        return s.a(o.a(), "tt_error_new_register_limit");
                                    case 40021:
                                        return s.a(o.a(), "tt_error_apk_sign_check_error");
                                    case 40022:
                                        return s.a(o.a(), "tt_error_origin_ad_error");
                                    case 40023:
                                        return s.a(o.a(), "tt_error_union_os_error");
                                    case 40024:
                                        return s.a(o.a(), "tt_error_union_sdk_too_old");
                                    default:
                                        switch (i) {
                                            case 60001:
                                                return s.a(o.a(), "tt_ror_code_show_event_error");
                                            case 60002:
                                                return s.a(o.a(), "tt_error_code_click_event_error");
                                            default:
                                                try {
                                                    return s.a(o.a(), "tt_error_unknow");
                                                } catch (Throwable unused) {
                                                    return "";
                                                }
                                        }
                                }
                        }
                }
        }
        return "";
    }
}
