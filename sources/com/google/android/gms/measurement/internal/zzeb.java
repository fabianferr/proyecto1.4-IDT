package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzhp;
import com.umlaut.crowd.CCS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public final class zzeb {
    public static final zzea zzA = zza("measurement.upload.retry_time", 1800000L, 1800000L, zzbi.zza);
    public static final zzea zzB = zza("measurement.upload.retry_count", 6, 6, zzbk.zza);
    public static final zzea zzC = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbl.zza);
    public static final zzea zzD = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbm.zza);
    public static final zzea zzE = zza("measurement.audience.filter_result_max_count", 200, 200, zzbo.zza);
    public static final zzea zzF = zza("measurement.upload.max_public_user_properties", 25, 25, (zzdx) null);
    public static final zzea zzG = zza("measurement.upload.max_event_name_cardinality", 500, 500, (zzdx) null);
    public static final zzea zzH = zza("measurement.upload.max_public_event_params", 25, 25, (zzdx) null);
    public static final zzea zzI = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzbp.zza);
    public static final zzea zzJ = zza("measurement.test.boolean_flag", false, false, zzbq.zza);
    public static final zzea zzK = zza("measurement.test.string_flag", "---", "---", zzbr.zza);
    public static final zzea zzL = zza("measurement.test.long_flag", -1L, -1L, zzbs.zza);
    public static final zzea zzM = zza("measurement.test.int_flag", -2, -2, zzbt.zza);
    public static final zzea zzN;
    public static final zzea zzO = zza("measurement.experiment.max_ids", 50, 50, zzbw.zza);
    public static final zzea zzP = zza("measurement.max_bundles_per_iteration", 100, 100, zzbx.zza);
    public static final zzea zzQ = zza("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, zzby.zza);
    public static final zzea zzR = zza("measurement.redaction.app_instance_id.ttl", 7200000L, 7200000L, zzca.zza);
    public static final zzea zzS = zza("measurement.collection.log_event_and_bundle_v2", true, true, zzcb.zza);
    public static final zzea zzT = zza("measurement.quality.checksum", false, false, (zzdx) null);
    public static final zzea zzU = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, zzcc.zza);
    public static final zzea zzV = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, zzcd.zza);
    public static final zzea zzW = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, zzce.zza);
    public static final zzea zzX = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, zzcg.zza);
    public static final zzea zzY = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, zzch.zza);
    public static final zzea zzZ = zza("measurement.lifecycle.app_in_background_parameter", false, false, zzci.zza);
    public static final zzea zza = zza("measurement.ad_id_cache_time", 10000L, 10000L, zzbj.zza);
    public static final zzea zzaA = zza("measurement.audience.dynamic_filters.oob_fix", true, true, zzdp.zza);
    public static final zzea zzaB = zza("measurement.service.clear_global_params_on_uninstall", true, true, zzdq.zza);
    /* access modifiers changed from: private */
    public static final List zzaC = Collections.synchronizedList(new ArrayList());
    private static final Set zzaD = Collections.synchronizedSet(new HashSet());
    public static final zzea zzaa = zza("measurement.integration.disable_firebase_instance_id", false, false, zzcj.zza);
    public static final zzea zzab = zza("measurement.collection.service.update_with_analytics_fix", false, false, zzck.zza);
    public static final zzea zzac = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, zzcm.zza);
    public static final zzea zzad = zza("measurement.client.sessions.check_on_reset_and_enable2", true, true, zzcn.zza);
    public static final zzea zzae = zza("measurement.collection.synthetic_data_mitigation", false, false, zzco.zza);
    public static final zzea zzaf = zza("measurement.service.storage_consent_support_version", 203600, 203600, zzcp.zza);
    public static final zzea zzag = zza("measurement.client.click_identifier_control.dev", false, false, zzcr.zza);
    public static final zzea zzah = zza("measurement.service.click_identifier_control", false, false, zzcs.zza);
    public static final zzea zzai = zza("measurement.service.store_null_safelist", true, true, zzct.zza);
    public static final zzea zzaj = zza("measurement.service.store_safelist", true, true, zzcu.zza);
    public static final zzea zzak = zza("measurement.redaction.no_aiid_in_config_request", true, true, zzcv.zza);
    public static final zzea zzal = zza("measurement.redaction.config_redacted_fields", true, true, zzcw.zza);
    public static final zzea zzam = zza("measurement.redaction.upload_redacted_fields", true, true, zzcy.zza);
    public static final zzea zzan = zza("measurement.redaction.upload_subdomain_override", true, true, zzcz.zza);
    public static final zzea zzao = zza("measurement.redaction.device_info", true, true, zzda.zza);
    public static final zzea zzap = zza("measurement.redaction.user_id", true, true, zzdc.zza);
    public static final zzea zzaq = zza("measurement.redaction.google_signals", true, true, zzdd.zza);
    public static final zzea zzar = zza("measurement.collection.enable_session_stitching_token.service", false, false, zzde.zza);
    public static final zzea zzas = zza("measurement.collection.enable_session_stitching_token.client.dev", false, false, zzdf.zza);
    public static final zzea zzat = zza("measurement.redaction.app_instance_id", true, true, zzdg.zza);
    public static final zzea zzau = zza("measurement.redaction.populate_ephemeral_app_instance_id", true, true, zzdh.zza);
    public static final zzea zzav = zza("measurement.redaction.enhanced_uid", true, true, zzdi.zza);
    public static final zzea zzaw = zza("measurement.redaction.e_tag", true, true, zzdk.zza);
    public static final zzea zzax = zza("measurement.redaction.client_ephemeral_aiid_generation", true, true, zzdl.zza);
    public static final zzea zzay = zza("measurement.redaction.retain_major_os_version", true, true, zzdn.zza);
    public static final zzea zzaz = zza("measurement.redaction.scion_payload_generator", true, true, zzdo.zza);
    public static final zzea zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzbb.zza);
    public static final zzea zzc;
    public static final zzea zzd = zza("measurement.config.url_scheme", ProxyConfig.MATCH_HTTPS, ProxyConfig.MATCH_HTTPS, zzbz.zza);
    public static final zzea zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzcl.zza);
    public static final zzea zzf = zza("measurement.upload.max_bundles", 100, 100, zzcx.zza);
    public static final zzea zzg = zza("measurement.upload.max_batch_size", 65536, 65536, zzdj.zza);
    public static final zzea zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, zzdr.zza);
    public static final zzea zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, zzds.zza);
    public static final zzea zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, zzdt.zza);
    public static final zzea zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, zzbu.zza);
    public static final zzea zzl = zza("measurement.upload.max_public_events_per_day", 50000, 50000, zzcf.zza);
    public static final zzea zzm = zza("measurement.upload.max_conversions_per_day", 10000, 10000, zzcq.zza);
    public static final zzea zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzdb.zza);
    public static final zzea zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, zzdm.zza);
    public static final zzea zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzdu.zza);
    public static final zzea zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzdv.zza);
    public static final zzea zzr;
    public static final zzea zzs;
    public static final zzea zzt = zza("measurement.upload.realtime_upload_interval", 10000L, 10000L, zzba.zza);
    public static final zzea zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbc.zza);
    public static final zzea zzv = zza("measurement.upload.minimum_delay", 500L, 500L, zzbd.zza);
    public static final zzea zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbe.zza);
    public static final zzea zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbf.zza);
    public static final zzea zzy = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbg.zza);
    public static final zzea zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbh.zza);

    static {
        Long valueOf = Long.valueOf(CCS.a);
        zzc = zza("measurement.config.cache_time", 86400000L, valueOf, zzbn.zza);
        zzr = zza("measurement.upload.window_interval", valueOf, valueOf, zzdw.zza);
        zzs = zza("measurement.upload.interval", valueOf, valueOf, zzaz.zza);
        Double valueOf2 = Double.valueOf(-3.0d);
        zzN = zza("measurement.test.double_flag", valueOf2, valueOf2, zzbv.zza);
    }

    static zzea zza(String str, Object obj, Object obj2, zzdx zzdx) {
        zzea zzea = new zzea(str, obj, obj2, zzdx, (zzdz) null);
        zzaC.add(zzea);
        return zzea;
    }

    public static Map zzc(Context context) {
        zzhe zza2 = zzhe.zza(context.getContentResolver(), zzhp.zza("com.google.android.gms.measurement"), zzay.zza);
        return zza2 == null ? Collections.emptyMap() : zza2.zzc();
    }
}
