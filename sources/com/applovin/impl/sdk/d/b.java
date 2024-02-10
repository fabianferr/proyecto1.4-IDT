package com.applovin.impl.sdk.d;

import android.net.Uri;
import androidx.media3.common.C;
import com.applovin.impl.a.m;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.http.protocol.HTTP;

public class b<T> implements Comparable {
    public static final b<Boolean> U = a("is_disabled", false);
    public static final b<String> V = a("device_id", "");
    public static final b<Boolean> W = a("rss", true);
    public static final b<String> X = a("device_token", "");
    public static final b<Long> Y = a("publisher_id", 0L);
    public static final b<Boolean> Z = a("is_verbose_logging", false);
    private static final List<?> a = Arrays.asList(new Class[]{Boolean.class, Float.class, Integer.class, Long.class, String.class});
    public static final b<Boolean> aA = a("alert_consent_for_dialog_closed_with_back_button", false);
    public static final b<Boolean> aB = a("alert_consent_after_init", false);
    public static final b<Long> aC = a("alert_consent_after_init_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));
    public static final b<Long> aD = a("alert_consent_after_dialog_rejection_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(30)));
    public static final b<Long> aE = a("alert_consent_after_dialog_close_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));
    public static final b<Long> aF = a("alert_consent_after_dialog_close_with_back_button_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));
    public static final b<Long> aG = a("alert_consent_after_cancel_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(10)));
    public static final b<Long> aH = a("alert_consent_reschedule_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));
    public static final b<String> aI = a("text_alert_consent_title", "Make this App Better and Stay Free!");
    public static final b<String> aJ = a("text_alert_consent_body", "If you don't give us consent to use your data, you will be making our ability to support this app harder, which may negatively affect the user experience.");
    public static final b<String> aK = a("text_alert_consent_yes_option", "I Agree");
    public static final b<String> aL = a("text_alert_consent_no_option", "Cancel");
    public static final b<Long> aM = a("ttc_max_click_duration_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));
    public static final b<Integer> aN = a("ttc_max_click_distance_dp", 10);
    public static final b<Integer> aO = a("ttc_acrsv2a", Integer.valueOf(AppLovinTouchToClickListener.ClickRecognitionState.ACTION_DOWN.ordinal()));
    public static final b<Integer> aP = a("ttc_edge_buffer_dp", 0);
    public static final b<String> aQ = a("whitelisted_postback_endpoints", "https://prod-a.applovin.com,https://rt.applovin.com/4.0/pix, https://rt.applvn.com/4.0/pix,https://ms.applovin.com/,https://ms.applvn.com/");
    public static final b<String> aR = a("fetch_settings_endpoint", "https://ms.applovin.com/");
    public static final b<String> aS = a("fetch_settings_backup_endpoint", "https://ms.applvn.com/");
    public static final b<String> aT = a("adserver_endpoint", "https://a.applovin.com/");
    public static final b<String> aU = a("adserver_backup_endpoint", "https://a.applvn.com/");
    public static final b<String> aV = a("api_endpoint", "https://d.applovin.com/");
    public static final b<String> aW = a("api_backup_endpoint", "https://d.applvn.com/");
    public static final b<String> aX = a("event_tracking_endpoint_v2", "https://rt.applovin.com/");
    public static final b<String> aY = a("event_tracking_backup_endpoint_v2", "https://rt.applvn.com/");
    public static final b<String> aZ = a("fetch_variables_endpoint", "https://ms.applovin.com/");
    public static final b<String> aa = a("sc", "");
    public static final b<String> ab = a("sc2", "");
    public static final b<String> ac = a("sc3", "");
    public static final b<String> ad = a("server_installed_at", "");
    public static final b<Boolean> ae = a("track_network_response_codes", false);
    public static final b<Boolean> af = a("submit_network_response_codes", false);
    public static final b<Boolean> ag = a("clear_network_response_codes_on_request", true);
    public static final b<Boolean> ah = a("clear_completion_callback_on_failure", false);
    public static final b<Long> ai = a("sicd_ms", 0L);
    public static final b<Integer> aj = a("logcat_max_line_size", 1000);
    public static final b<Integer> ak = a("stps", 16);
    public static final b<Boolean> al = a("ustp", false);
    public static final b<Boolean> am = a("exception_handler_enabled", true);
    public static final b<Integer> an = a("network_thread_count", 4);
    public static final b<Boolean> ao = a("uam", false);
    public static final b<Boolean> ap = a("ah_cvc", true);
    public static final b<Boolean> aq = a("ah_cdde", true);
    public static final b<Boolean> ar = a("ah_crut", true);
    public static final b<Boolean> as = a("init_omsdk", true);
    public static final b<String> at = a("omsdk_partner_name", "applovin");
    public static final b<Boolean> au = a("publisher_can_show_consent_dialog", true);
    public static final b<String> av = a("consent_dialog_url", "https://assets.applovin.com/gdpr/flow_v1/gdpr-flow-1.html");
    public static final b<Boolean> aw = a("consent_dialog_immersive_mode_on", false);
    public static final b<Long> ax = a("consent_dialog_show_from_alert_delay_ms", 450L);
    public static final b<Boolean> ay = a("alert_consent_for_dialog_rejected", false);
    public static final b<Boolean> az = a("alert_consent_for_dialog_closed", false);
    private static final Map<String, b<?>> b = CollectionUtils.map(512);
    public static final b<String> bA = a("text_incent_warning_continue_option", "Keep Watching");
    public static final b<Boolean> bB = a("incent_nonvideo_warning_enabled", false);
    public static final b<String> bC = a("text_incent_nonvideo_warning_title", "Attention!");
    public static final b<String> bD = a("text_incent_nonvideo_warning_body", "You won’t get your reward if the game hasn’t finished.");
    public static final b<String> bE = a("text_incent_nonvideo_warning_close_option", HTTP.CONN_CLOSE);
    public static final b<String> bF = a("text_incent_nonvideo_warning_continue_option", "Keep Playing");
    public static final b<Integer> bG = a("close_button_touch_area", 0);
    public static final b<Integer> bH = a("close_button_outside_touch_area", 0);
    public static final b<Boolean> bI = a("creative_debugger_enabled", false);
    public static final b<Long> bJ = a("viewability_adview_imp_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));
    public static final b<Integer> bK = a("viewability_adview_banner_min_width", 320);
    public static final b<Integer> bL = a("viewability_adview_banner_min_height", Integer.valueOf(AppLovinAdSize.BANNER.getHeight()));
    public static final b<Integer> bM = a("viewability_adview_mrec_min_width", Integer.valueOf(MaxAdFormat.MREC.getSize().getWidth()));
    public static final b<Integer> bN = a("viewability_adview_mrec_min_height", Integer.valueOf(MaxAdFormat.MREC.getSize().getHeight()));
    public static final b<Integer> bO = a("viewability_adview_leader_min_width", 728);
    public static final b<Integer> bP = a("viewability_adview_leader_min_height", Integer.valueOf(AppLovinAdSize.LEADER.getHeight()));
    public static final b<Integer> bQ = a("viewability_adview_native_min_width", 0);
    public static final b<Integer> bR = a("viewability_adview_native_min_height", 0);
    public static final b<Float> bS = a("viewability_adview_min_alpha", Float.valueOf(10.0f));
    public static final b<Long> bT = a("viewability_timer_min_visible_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));
    public static final b<Long> bU = a("viewability_timer_interval_ms", 100L);
    public static final b<Integer> bV = a("expandable_close_button_size", 27);
    public static final b<Integer> bW = a("expandable_h_close_button_margin", 10);
    public static final b<Integer> bX = a("expandable_t_close_button_margin", 10);
    public static final b<Boolean> bY = a("expandable_lhs_close_button", false);
    public static final b<Integer> bZ = a("expandable_close_button_touch_area", 0);
    public static final b<String> ba = a("fetch_variables_backup_endpoint", "https://ms.applvn.com/");
    public static final b<String> bb = a("anr_postback_endpoint", "https://ms.applovin.com/1.0/sdk/error");
    public static final b<String> bc = a("token_type_prefixes_r", "4!");
    public static final b<String> bd = a("token_type_prefixes_arj", "json_v3!");
    public static final b<String> be = a("top_level_events", "landing,paused,resumed,ref,rdf,checkout,iap");
    public static final b<String> bf = a("valid_super_property_types", String.class.getName() + "," + Integer.class.getName() + "," + Long.class.getName() + "," + Double.class.getName() + "," + Float.class.getName() + "," + Date.class.getName() + "," + Uri.class.getName() + "," + List.class.getName() + "," + Map.class.getName());
    public static final b<Boolean> bg = a("persist_super_properties", true);
    public static final b<Integer> bh = a("super_property_string_max_length", 1024);
    public static final b<Integer> bi = a("super_property_url_max_length", 1024);
    public static final b<Long> bj = a("cached_advertising_info_ttl_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(10)));
    public static final b<Boolean> bk = a("use_per_format_cache_queues", true);
    public static final b<Boolean> bl = a("cache_cleanup_enabled", false);
    public static final b<Long> bm = a("cache_file_ttl_seconds", Long.valueOf(TimeUnit.DAYS.toSeconds(1)));
    public static final b<Integer> bn = a("cache_max_size_mb", -1);
    public static final b<String> bo = a("precache_delimiters", ")]',");
    public static final b<Boolean> bp = a("ad_resource_caching_enabled", true);
    public static final b<Boolean> bq = a("fail_ad_load_on_failed_video_cache", true);
    public static final b<String> br = a("resource_cache_prefix", "https://vid.applovin.com/,https://stage-vid.applovin.com/,https://pdn.applovin.com/,https://stage-pdn.applovin.com/,https://img.applovin.com/,https://stage-img.applovin.com/,https://d.applovin.com/,https://assets.applovin.com/,https://stage-assets.applovin.com/,https://cdnjs.cloudflare.com/,http://vid.applovin.com/,http://stage-vid.applovin.com/,http://pdn.applovin.com/,http://stage-pdn.applovin.com/,http://img.applovin.com/,http://stage-img.applovin.com/,http://d.applovin.com/,http://assets.applovin.com/,http://stage-assets.applovin.com/,http://cdnjs.cloudflare.com/,http://u.appl.vn/,https://u.appl.vn/,https://res.applovin.com/,https://res1.applovin.com/,https://res2.applovin.com/,https://res3.applovin.com/,http://res.applovin.com/,http://res1.applovin.com/,http://res2.applovin.com/,http://res3.applovin.com/");
    public static final b<String> bs = a("preserved_cached_assets", "sound_off.png,sound_on.png,closeOptOut.png,1381250003_28x28.png,zepto-1.1.3.min.js,jquery-2.1.1.min.js,jquery-1.9.1.min.js,jquery.knob.js");
    public static final b<Boolean> bt = a("use_old_file_manager", false);
    public static final b<Integer> bu = a("vr_retry_count_v1", 1);
    public static final b<Integer> bv = a("cr_retry_count_v1", 1);
    public static final b<Boolean> bw = a("incent_warning_enabled", false);
    public static final b<String> bx = a("text_incent_warning_title", "Attention!");
    public static final b<String> by = a("text_incent_warning_body", "You won’t get your reward if the video hasn’t finished.");
    public static final b<String> bz = a("text_incent_warning_close_option", HTTP.CONN_CLOSE);
    public static final b<Integer> cA = a("progress_bar_scale", 10000);
    public static final b<Integer> cB = a("progress_bar_vertical_padding", -8);
    public static final b<Integer> cC = a("vs_buffer_indicator_size", 50);
    public static final b<Long> cD = a("set_poststitial_muted_initial_delay_ms", 500L);
    public static final b<Integer> cE = a("minepsv", -1);
    public static final b<Integer> cF = a("maxepsv", -1);
    public static final b<Boolean> cG = a("fasuic", true);
    public static final b<Boolean> cH = a("ssfwif", false);
    public static final b<Integer> cI = a("submit_postback_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));
    public static final b<Integer> cJ = a("submit_postback_retries", 4);
    public static final b<Integer> cK = a("max_postback_attempts", 3);
    public static final b<Boolean> cL = a("fppopq", false);
    public static final b<Integer> cM = a("max_persisted_postbacks", 100);
    public static final b<Boolean> cN = a("retry_on_all_errors", false);
    public static final b<Integer> cO = a("get_retry_delay_v1", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));
    public static final b<Integer> cP = a("http_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));
    public static final b<Integer> cQ = a("http_socket_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(20)));
    public static final b<Boolean> cR = a("force_ssl", false);
    public static final b<Integer> cS = a("fetch_ad_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));
    public static final b<Integer> cT = a("fetch_ad_retry_count_v1", 1);
    public static final b<Boolean> cU = a("faer", false);
    public static final b<Boolean> cV = a("faroae", false);
    public static final b<Integer> cW = a("submit_data_retry_count_v1", 1);
    public static final b<Integer> cX = a("response_buffer_size", 16000);
    public static final b<Integer> cY = a("fetch_basic_settings_connection_timeout_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));
    public static final b<Integer> cZ = a("fetch_basic_settings_retry_count", 3);
    public static final b<Boolean> ca = a("iaad", false);
    public static final b<String> cb = a("js_tag_schemes", "applovin,mopub");
    public static final b<String> cc = a("js_tag_load_success_hosts", "load,load_succeeded");
    public static final b<String> cd = a("js_tag_load_failure_hosts", "failLoad,load_failed");
    public static final b<Integer> ce = a("auxiliary_operations_threads", 3);
    public static final b<Integer> cf = a("caching_operations_threads", 8);
    public static final b<Long> cg = a("fullscreen_ad_pending_display_state_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(10)));
    public static final b<Long> ch = a("fullscreen_ad_showing_state_timeout_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(2)));
    public static final b<Boolean> ci = a("lhs_close_button_video", false);
    public static final b<Integer> cj = a("close_button_right_margin_video", 4);
    public static final b<Integer> ck = a("close_button_size_video", 30);
    public static final b<Integer> cl = a("close_button_top_margin_video", 8);
    public static final b<Long> cm = a("inter_display_delay", 200L);
    public static final b<Long> cn = a("maximum_close_button_delay_seconds", 999L);
    public static final b<Boolean> co = a("respect_close_button", true);
    public static final b<Boolean> cp = a("lhs_skip_button", true);
    public static final b<Boolean> cq = a("track_app_killed", false);
    public static final b<Boolean> cr = a("mute_controls_enabled", false);
    public static final b<Boolean> cs = a("allow_user_muting", true);
    public static final b<Boolean> ct = a("mute_videos", false);
    public static final b<Boolean> cu = a("show_mute_by_default", false);
    public static final b<Boolean> cv = a("mute_with_user_settings", true);
    public static final b<Integer> cw = a("mute_button_size", 32);
    public static final b<Integer> cx = a("mute_button_margin", 10);
    public static final b<Integer> cy = a("mute_button_gravity", 85);
    public static final b<Long> cz = a("progress_bar_step", 25L);
    public static final b<Boolean> dA = a("qq11", true);
    public static final b<Boolean> dB = a("pui", true);
    public static final b<String> dC = a("plugin_version", "");
    public static final b<Boolean> dD = a("hgn", false);
    public static final b<Boolean> dE = a("cso", false);
    public static final b<Boolean> dF = a("cfs", false);
    public static final b<Boolean> dG = a("cmi", false);
    public static final b<Boolean> dH = a("crat", false);
    public static final b<Boolean> dI = a("cvs", false);
    public static final b<Boolean> dJ = a("caf", false);
    public static final b<Boolean> dK = a("cf", false);
    public static final b<Boolean> dL = a("cmtl", true);
    public static final b<Boolean> dM = a("cnr", false);
    public static final b<Boolean> dN = a("adr", false);
    public static final b<Float> dO = a("volume_normalization_factor", Float.valueOf(6.6666665f));
    public static final b<Boolean> dP = a("system_user_agent_collection_enabled", false);
    public static final b<Boolean> dQ = a(AppLovinSdkExtraParameterKey.USER_AGENT_COLLECTION_ENABLED, false);
    public static final b<Boolean> dR = a("collect_device_angle", false);
    public static final b<Boolean> dS = a("collect_device_movement", false);
    public static final b<Float> dT = a("movement_degradation", Float.valueOf(0.75f));
    public static final b<Integer> dU = a("device_sensor_period_ms", 250);
    public static final b<Boolean> dV = a("dte", true);
    public static final b<Boolean> dW = a("idcw", false);
    public static final b<Long> dX = a("anr_debug_thread_refresh_time_ms", -1L);
    public static final b<Integer> dY = a("fetch_basic_settings_delay_ms", 1500);
    public static final b<Boolean> dZ = a("cclia", true);
    public static final b<Boolean> da = a("fetch_basic_settings_on_reconnect", false);
    public static final b<Boolean> db = a("skip_fetch_basic_settings_if_not_connected", false);
    public static final b<Integer> dc = a("fetch_basic_settings_retry_delay_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(2)));
    public static final b<Integer> dd = a("fetch_variables_connection_timeout_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(5)));
    public static final b<Boolean> de = a("idflrwbe", false);
    public static final b<Boolean> df = a("falawpr", false);
    public static final b<Boolean> dg = a("sort_query_parameters", false);
    public static final b<Boolean> dh = a("encode_amp_query_value", false);
    public static final b<Long> di = a("communicator_request_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(10)));
    public static final b<Integer> dj = a("communicator_request_retry_count", 3);
    public static final b<Long> dk = a("communicator_request_retry_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(2)));
    public static final b<Integer> dl = a("ad_session_minutes", 60);
    public static final b<Boolean> dm = a("session_tracking_cooldown_on_event_fire", true);
    public static final b<Long> dn = a("session_tracking_resumed_cooldown_minutes", 90L);

    /* renamed from: do  reason: not valid java name */
    public static final b<Long> f0do = a("session_tracking_paused_cooldown_minutes", 90L);
    public static final b<Boolean> dp = a("qq", false);
    public static final b<Boolean> dq = a("qq1", true);
    public static final b<Boolean> dr = a("qq2", true);
    public static final b<Boolean> ds = a("qq3", true);
    public static final b<Boolean> dt = a("qq4", true);
    public static final b<Boolean> du = a("qq5", true);
    public static final b<Boolean> dv = a("qq6", true);
    public static final b<Boolean> dw = a("qq7", true);
    public static final b<Boolean> dx = a("qq8", true);
    public static final b<Boolean> dy = a("qq9", false);
    public static final b<Boolean> dz = a("qq10", true);
    public static final b<Boolean> eA = a("fetch_ad_gzip", false);
    public static final b<Boolean> eB = a("event_tracking_gzip", false);
    public static final b<Boolean> eC = a("submit_ad_stats_gzip", false);
    public static final b<Boolean> eD = a("reward_postback_gzip", false);
    public static final b<Boolean> eE = a("force_rerender", false);
    public static final b<Boolean> eF = a("daostr", false);
    public static final b<Boolean> eG = a("tctlaa", false);
    public static final b<Boolean> eH = a("rwvdv", false);
    public static final b<Boolean> eI = a("handle_render_process_gone", true);
    public static final b<Boolean> eJ = a("fdadaomr", true);
    public static final b<Boolean> eK = a("teorpc", false);
    public static final b<Boolean> eL = a("rmpibt", false);
    public static final b<Boolean> eM = a("spbcioa", false);
    public static final b<Boolean> eN = a("set_webview_render_process_client", false);
    public static final b<Boolean> eO = a("disable_webview_hardware_acceleration", false);
    public static final b<Boolean> eP = a("dsaovcf", false);
    public static final b<Boolean> eQ = a("daoar", false);
    public static final b<Boolean> eR = a("use_uri_encode", false);
    public static final b<Boolean> eS = a("anr_detection_enabled", false);
    public static final b<Long> eT = a("anr_trigger_millis", 4000L);
    public static final b<Long> eU = a("anr_touch_millis", Long.valueOf(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS));
    public static final b<Long> eV = a("anr_check_millis", Long.valueOf(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS));
    public static final b<Boolean> eW = a("frpcfn", false);
    public static final b<Boolean> eX = a("use_in_memory_signal_providers", false);
    public static final b<Boolean> eY = a("uobid", true);
    public static final b<String> eZ = a("config_consent_dialog_state", "unknown");
    public static final b<Long> ea = a("lccdm", 10L);
    public static final b<Integer> eb = a("lmfd", 3);
    public static final b<Boolean> ec = a("is_track_ad_info", true);
    public static final b<Boolean> ed = a("submit_ad_stats_enabled", false);
    public static final b<Integer> ee = a("submit_ad_stats_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));
    public static final b<Integer> ef = a("submit_ad_stats_retry_count", 1);
    public static final b<Integer> eg = a("submit_ad_stats_max_count", 500);
    public static final b<Boolean> eh = a("asdm", false);
    public static final b<String> ei = a("vast_image_html", "<html><head><style>html,body{height:100%;width:100%}body{background-image:url({SOURCE});background-repeat:no-repeat;background-size:contain;background-position:center;}a{position:absolute;top:0;bottom:0;left:0;right:0}</style></head><body><a href=\"applovin://com.applovin.sdk/adservice/track_click_now\"></a></body></html>");
    public static final b<String> ej = a("vast_link_html", "<html><head><style>html,body,iframe{height:100%;width:100%;}body{margin:0}iframe{border:0;overflow:hidden;position:absolute}</style></head><body><iframe src={SOURCE} frameborder=0></iframe></body></html>");
    public static final b<Integer> ek = a("vast_max_response_length", 640000);
    public static final b<Integer> el = a("vast_max_wrapper_depth", 5);
    public static final b<String> em = a("vast_unsupported_video_extensions", "ogv,flv");
    public static final b<String> en = a("vast_unsupported_video_types", "video/ogg,video/x-flv");
    public static final b<Boolean> eo = a("vast_validate_with_extension_if_no_video_type", true);
    public static final b<Integer> ep = a("vast_video_selection_policy", Integer.valueOf(m.a.MEDIUM.ordinal()));
    public static final b<Integer> eq = a("vast_wrapper_resolution_retry_count_v1", 1);
    public static final b<Integer> er = a("vast_wrapper_resolution_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));
    public static final b<Boolean> es = a("ree", true);
    public static final b<Boolean> et = a("btee", true);
    public static final b<Long> eu = a("server_timestamp_ms", 0L);
    public static final b<Long> ev = a("device_timestamp_ms", 0L);
    public static final b<Integer> ew = a("gzip_min_length", 0);
    public static final b<Boolean> ex = a("gzip_encoding_default", false);
    public static final b<Boolean> ey = a("fetch_settings_gzip", false);
    public static final b<Boolean> ez = a("device_init_gzip", false);
    public static final b<String> fa = a("country_code", "");
    public static final b<Boolean> fb = a("communicator_enabled", true);
    private final String c;
    private final T d;

    public b(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (t != null) {
            this.c = str;
            this.d = t;
        } else {
            throw new IllegalArgumentException("No default value specified");
        }
    }

    protected static <T> b<T> a(String str, T t) {
        if (t == null) {
            throw new IllegalArgumentException("No default value specified");
        } else if (a.contains(t.getClass())) {
            b<T> bVar = new b<>(str, t);
            Map<String, b<?>> map = b;
            if (!map.containsKey(str)) {
                map.put(str, bVar);
                return bVar;
            }
            throw new IllegalArgumentException("Setting has already been used: " + str);
        } else {
            throw new IllegalArgumentException("Unsupported value type: " + t.getClass());
        }
    }

    public static Collection<b<?>> c() {
        return Collections.synchronizedCollection(b.values());
    }

    public T a(Object obj) {
        return this.d.getClass().cast(obj);
    }

    public String a() {
        return this.c;
    }

    public T b() {
        return this.d;
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof b)) {
            return 0;
        }
        return this.c.compareTo(((b) obj).a());
    }
}
