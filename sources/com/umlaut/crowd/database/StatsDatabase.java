package com.umlaut.crowd.database;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.database.metrics.AppUsageMetrics;
import com.umlaut.crowd.database.metrics.AusFrequencyAgg;
import com.umlaut.crowd.database.metrics.CTSuccessAgg;
import com.umlaut.crowd.database.metrics.CTSuccessLocation;
import com.umlaut.crowd.database.metrics.ConnectivityTestMetrics;
import com.umlaut.crowd.database.metrics.MpaSignalStrengthAgg;
import com.umlaut.crowd.database.metrics.NetworkFeedbackMetrics;
import com.umlaut.crowd.database.metrics.NetworkInformationMetrics;
import com.umlaut.crowd.database.metrics.RatShareAgg;
import com.umlaut.crowd.database.metrics.SignalStrengthLocationShare;
import com.umlaut.crowd.database.metrics.SpeedTestMetrics;
import com.umlaut.crowd.database.metrics.TTRDataSpeedAgg;
import com.umlaut.crowd.database.metrics.TTRDataSpeedLocationAgg;
import com.umlaut.crowd.database.metrics.TTRDataTrafficAgg;
import com.umlaut.crowd.database.metrics.TTRLocation;
import com.umlaut.crowd.database.metrics.VcDropAgg;
import com.umlaut.crowd.database.metrics.VoiceCallMetrics;
import com.umlaut.crowd.internal.RST;
import com.umlaut.crowd.internal.RVR;
import com.umlaut.crowd.internal.f6;
import com.umlaut.crowd.internal.h6;
import com.umlaut.crowd.internal.k9;
import com.umlaut.crowd.internal.oc;
import com.umlaut.crowd.internal.p;
import com.umlaut.crowd.internal.r0;
import com.umlaut.crowd.internal.s0;
import com.umlaut.crowd.internal.ub;
import com.umlaut.crowd.utils.AppUsageUtils;
import com.umlaut.crowd.utils.DateUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

public class StatsDatabase extends SQLiteOpenHelper {
    private static final String A = "COLUMN_ST_UL";
    private static final String A0 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY";
    private static final String A1 = "COLUMN_AGG_RAT_INDEX";
    private static final String A2 = "COLUMN_AGG_VC_DROP_INDEX";
    private static final String B = "CREATE TABLE ST (COLUMN_ST_INDEX INTEGER PRIMARY KEY, COLUMN_ST_LT INTEGER, COLUMN_ST_DL INTEGER, COLUMN_ST_UL INTEGER)";
    private static final String B0 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_2G";
    private static final String B1 = "COLUMN_AGG_RAT_YEAR";
    private static final String B2 = "COLUMN_AGG_VC_DROP_YEAR";
    private static final String C = "VC";
    private static final String C0 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_3G";
    private static final String C1 = "COLUMN_AGG_RAT_MONTH";
    private static final String C2 = "COLUMN_AGG_VC_DROP_MONTH";
    private static final String D = "COLUMN_VC_INDEX";
    private static final String D0 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_4G";
    private static final String D1 = "COLUMN_AGG_RAT_DAY";
    private static final String D2 = "COLUMN_AGG_VC_DROP_DAY";
    private static final String E = "COLUMN_VC_CALL_DIRECTION";
    private static final String E0 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_5G";
    private static final String E1 = "COLUMN_AGG_RAT_DATE";
    private static final String E2 = "COLUMN_AGG_VC_DROP_DATE";
    private static final String F = "COLUMN_VC_CALL_SETUP_TIME";
    private static final String F0 = "CREATE TABLE AGG_CT (COLUMN_AGG_CT_INDEX INTEGER PRIMARY KEY, COLUMN_AGG_CT_YEAR INTEGER, COLUMN_AGG_CT_MONTH INTEGER, COLUMN_AGG_CT_DAY INTEGER, COLUMN_AGG_CT_DATE TEXT, COLUMN_AGG_CT_MOBILE_COUNT INTEGER, COLUMN_AGG_CT_MOBILE_SUCCESS INTEGER, COLUMN_AGG_CT_WIFI_COUNT INTEGER, COLUMN_AGG_CT_WIFI_SUCCESS INTEGER, COLUMN_AGG_CT_WIFI_MIN_LATENCY INTEGER, COLUMN_AGG_CT_MOBILE_MIN_LATENCY INTEGER, COLUMN_AGG_CT_MOBILE_MIN_LATENCY_2G INTEGER, COLUMN_AGG_CT_MOBILE_MIN_LATENCY_3G INTEGER, COLUMN_AGG_CT_MOBILE_MIN_LATENCY_4G INTEGER, COLUMN_AGG_CT_MOBILE_MIN_LATENCY_5G INTEGER);";
    private static final String F1 = "COLUMN_AGG_RAT_2G";
    private static final String F2 = "COLUMN_AGG_VC_DROP_CALLS_2G";
    private static final String G = "COLUMN_VC_CALL_DURATION";
    private static final String[] G0 = {r0, s0, t0, v0, w0, x0, y0, A0, z0, B0, C0, D0, E0};
    private static final String G1 = "COLUMN_AGG_RAT_3G";
    private static final String G2 = "COLUMN_AGG_VC_DROP_CALLS_3G";
    private static final String H = "COLUMN_VC_CALL_DROPPED";
    private static final String H0 = "LOC_CT";
    private static final String H1 = "COLUMN_AGG_RAT_4G";
    private static final String H2 = "COLUMN_AGG_VC_DROP_CALLS_4G";
    private static final String I = "CREATE TABLE VC (COLUMN_VC_INDEX INTEGER PRIMARY KEY, COLUMN_VC_CALL_DIRECTION TEXT, COLUMN_VC_CALL_SETUP_TIME INTEGER, COLUMN_VC_CALL_DURATION INTEGER, COLUMN_VC_CALL_DROPPED INTEGER)";
    private static final String I0 = "COLUMN_LOCATION_CT_INDEX";
    private static final String I1 = "COLUMN_AGG_RAT_5G";
    private static final String I2 = "COLUMN_AGG_VC_DROP_CALLS_5G";
    private static final String J = "AGG_TTR";
    private static final String J0 = "COLUMN_LOCATION_CT_YEAR";
    private static final String J1 = "COLUMN_AGG_RAT_WIFI";
    private static final String J2 = "COLUMN_AGG_VC_DROP_DROPS_2G";
    private static final String K = "COLUMN_AGG_TTR_INDEX";
    private static final String K0 = "COLUMN_LOCATION_CT_MONTH";
    private static final String K1 = "COLUMN_AGG_RAT_UNKNOWN";
    private static final String K2 = "COLUMN_AGG_VC_DROP_DROPS_3G";
    private static final String L = "COLUMN_AGG_TTR_YEAR";
    private static final String L0 = "COLUMN_LOCATION_CT_DAY";
    private static final String L1 = "TABLE_AGG_MPA_SIGNALSTRENGTH_SHARE";
    private static final String L2 = "COLUMN_AGG_VC_DROP_DROPS_4G";
    private static final String M = "COLUMN_AGG_TTR_MONTH";
    private static final String M0 = "COLUMN_LOCATION_CT_DATE";
    private static final String M1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_INDEX";
    private static final String M2 = "COLUMN_AGG_VC_DROP_DROPS_5G";
    private static final String N = "COLUMN_AGG_TTR_DAY";
    private static final String N0 = "COLUMN_LOCATION_CT_MIN_LATENCY";
    private static final String N1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_YEAR";
    private static final String N2 = "CREATE TABLE AGG_VC_DROP (COLUMN_AGG_VC_DROP_INDEX INTEGER PRIMARY KEY, COLUMN_AGG_VC_DROP_YEAR INTEGER, COLUMN_AGG_VC_DROP_MONTH INTEGER, COLUMN_AGG_VC_DROP_DAY INTEGER,COLUMN_AGG_VC_DROP_DATE TEXT,COLUMN_AGG_VC_DROP_CALLS_2G INTEGER, COLUMN_AGG_VC_DROP_CALLS_3G INTEGER, COLUMN_AGG_VC_DROP_CALLS_4G INTEGER, COLUMN_AGG_VC_DROP_CALLS_5G INTEGER, COLUMN_AGG_VC_DROP_DROPS_2G INTEGER, COLUMN_AGG_VC_DROP_DROPS_3G INTEGER, COLUMN_AGG_VC_DROP_DROPS_4G INTEGER, COLUMN_AGG_VC_DROP_DROPS_5G INTEGER);";
    private static final String O = "COLUMN_AGG_TTR_HOUR";
    private static final String O0 = "COLUMN_LOCATION_CT_COUNT";
    private static final String O1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MONTH";
    private static final String[] O2 = {B2, C2, D2, E2, F2, G2, H2, I2, J2, K2, L2, M2};
    private static final String P = "COLUMN_AGG_TTR_QUARTER";
    private static final String P0 = "COLUMN_LOCATION_CT_SUCCESS";
    private static final String P1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_DAY";
    private static final String P2 = "TABLE_AGG_AUS_FREQUENCY";
    private static final String Q = "COLUMN_AGG_TTR_DATE";
    private static final String Q0 = "COLUMN_LOCATION_CT_TECHNOLOGY";
    private static final String Q1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_DATE";
    private static final String Q2 = "COLUMN_AGG_AUS_FREQUENCY_INDEX";
    private static final String R = "COLUMN_AGG_TTR_MAX_2G";
    private static final String R0 = "COLUMN_LOCATION_CT_TECHNOLOGY_ID";
    private static final String R1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_WIFI_UNKNOWN";
    private static final String R2 = "COLUMN_AGG_AUS_FREQUENCY_YEAR";
    private static final String S = "COLUMN_AGG_TTR_MAX_3G";
    private static final String S0 = "COLUMN_LOCATION_CT_TECHNOLOGY_TYPE";
    private static final String S1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_WIFI_EXCELLENT";
    private static final String S2 = "COLUMN_AGG_AUS_FREQUENCY_MONTH";
    private static final String T = "COLUMN_AGG_TTR_MAX_4G";
    private static final String T0 = "COLUMN_LOCATION_CT_LAT";
    private static final String T1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_WIFI_GOOD";
    private static final String T2 = "COLUMN_AGG_AUS_FREQUENCY_DAY";
    private static final String U = "COLUMN_AGG_TTR_MAX_5G";
    private static final String U0 = "COLUMN_LOCATION_CT_LNG";
    private static final String U1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_WIFI_FAIR";
    private static final String U2 = "COLUMN_AGG_AUS_FREQUENCY_DATE";
    private static final String V = "COLUMN_AGG_TTR_MAX_WIFI";
    private static final String V0 = "COLUMN_LOCATION_CT_ACCURACY";
    private static final String V1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_WIFI_POOR";
    private static final String V2 = "COLUMN_AGG_AUS_FREQUENCY_PACKAGENAME";
    private static final String W = "COLUMN_AGG_TTR_TRAFFIC_RX_WIFI";
    private static final String W0 = "CREATE TABLE LOC_CT (COLUMN_LOCATION_CT_INDEX INTEGER PRIMARY KEY, COLUMN_LOCATION_CT_YEAR INTEGER, COLUMN_LOCATION_CT_MONTH INTEGER, COLUMN_LOCATION_CT_DAY INTEGER, COLUMN_LOCATION_CT_DATE TEXT, COLUMN_LOCATION_CT_LAT REAL,COLUMN_LOCATION_CT_LNG REAL,COLUMN_LOCATION_CT_ACCURACY INTEGER, COLUMN_LOCATION_CT_MIN_LATENCY INTEGER, COLUMN_LOCATION_CT_COUNT INTEGER, COLUMN_LOCATION_CT_SUCCESS INTEGER, COLUMN_LOCATION_CT_TECHNOLOGY_ID TEXT, COLUMN_LOCATION_CT_TECHNOLOGY_TYPE TEXT, COLUMN_LOCATION_CT_TECHNOLOGY TEXT);";
    private static final String W1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_WIFI_BAD";
    private static final String W2 = "COLUMN_AGG_AUS_FREQUENCY_SESSIONS";
    private static final String X = "COLUMN_AGG_TTR_TRAFFIC_TX_WIFI";
    private static final String[] X0 = {J0, K0, L0, M0, T0, U0, V0, N0, O0, P0, R0, Q0, S0};
    private static final String X1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MOBILE_UNKNOWN";
    private static final String X2 = "COLUMN_AGG_AUS_FREQUENCY_USAGE_TIME";
    private static final String Y = "COLUMN_AGG_TTR_TRAFFIC_RX_MOBILE";
    private static final String Y0 = "AGG_MPA_RAT";
    private static final String Y1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MOBILE_EXCELLENT";
    private static final String Y2 = "COLUMN_AGG_AUS_FREQUENCY_TRAFFIC_RX";
    private static final String Z = "COLUMN_AGG_TTR_TRAFFIC_TX_MOBILE";
    private static final String Z0 = "COLUMN_AGG_MPA_RAT_INDEX";
    private static final String Z1 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MOBILE_GOOD";
    private static final String Z2 = "COLUMN_AGG_AUS_FREQUENCY_TRAFFIC_TX";
    private static final String a0 = "COLUMN_AGG_TTR_LAT_2G";
    private static final String a1 = "COLUMN_AGG_MPA_RAT_YEAR";
    private static final String a2 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MOBILE_FAIR";
    private static final String a3 = "CREATE TABLE TABLE_AGG_AUS_FREQUENCY (COLUMN_AGG_AUS_FREQUENCY_INDEX INTEGER PRIMARY KEY, COLUMN_AGG_AUS_FREQUENCY_YEAR INTEGER, COLUMN_AGG_AUS_FREQUENCY_MONTH INTEGER, COLUMN_AGG_AUS_FREQUENCY_DAY INTEGER,COLUMN_AGG_AUS_FREQUENCY_DATE TEXT,COLUMN_AGG_AUS_FREQUENCY_PACKAGENAME TEXT, COLUMN_AGG_AUS_FREQUENCY_SESSIONS INTEGER, COLUMN_AGG_AUS_FREQUENCY_USAGE_TIME INTEGER, COLUMN_AGG_AUS_FREQUENCY_TRAFFIC_RX INTEGER, COLUMN_AGG_AUS_FREQUENCY_TRAFFIC_TX INTEGER);";
    private static final String b0 = "COLUMN_AGG_TTR_LONG_2G";
    private static final String b1 = "COLUMN_AGG_MPA_RAT_MONTH";
    private static final String b2 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MOBILE_POOR";
    private static final String[] b3 = {R2, S2, T2, U2, V2, W2, X2, Y2, Z2};
    private static final boolean c = false;
    private static final String c0 = "COLUMN_AGG_TTR_LAT_3G";
    private static final String c1 = "COLUMN_AGG_MPA_RAT_DAY";
    private static final String c2 = "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MOBILE_BAD";
    private static final String d = "StatsDatabase";
    private static final String d0 = "COLUMN_AGG_TTR_LONG_3G";
    private static final String d1 = "COLUMN_AGG_MPA_RAT_DATE";
    private static final String d2 = "CREATE TABLE TABLE_AGG_MPA_SIGNALSTRENGTH_SHARE (COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_INDEX INTEGER PRIMARY KEY, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_YEAR INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MONTH INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_DAY INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_DATE TEXT, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_WIFI_UNKNOWN INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_WIFI_EXCELLENT INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_WIFI_GOOD INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_WIFI_FAIR INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_WIFI_POOR INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_WIFI_BAD INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MOBILE_UNKNOWN INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MOBILE_EXCELLENT INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MOBILE_GOOD INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MOBILE_FAIR INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MOBILE_POOR INTEGER, COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MOBILE_BAD INTEGER)";
    private static final String e = "insight-stats.db";
    private static final String e0 = "COLUMN_AGG_TTR_LAT_4G";
    private static final String e1 = "COLUMN_AGG_MPA_RAT_2G";
    private static final String[] e2 = {N1, O1, P1, X1, Y1, Z1, a2, b2, c2, R1, S1, T1, U1, V1, W1};
    private static final int f = 16;
    private static final String f0 = "COLUMN_AGG_TTR_LONG_4G";
    private static final String f1 = "COLUMN_AGG_MPA_RAT_3G";
    private static final String f2 = "TABLE_LOCATION_MPA_SIGNALSTRENGTH_SHARE";
    private static final String g = "CT";
    private static final String g0 = "COLUMN_AGG_TTR_LAT_5G";
    private static final String g1 = "COLUMN_AGG_MPA_RAT_4G";
    private static final String g2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_INDEX";
    private static final String h = "COLUMN_CT_NUMBER_OF_TESTS_MOBILE";
    private static final String h0 = "COLUMN_AGG_TTR_LONG_5G";
    private static final String h1 = "COLUMN_AGG_MPA_RAT_5G";
    private static final String h2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_YEAR";
    private static final String i = "COLUMN_CT_TESTS_SUCCESS_MOBILE";
    private static final String i0 = "COLUMN_AGG_TTR_LAT_WIFI";
    private static final String i1 = "COLUMN_AGG_MPA_RAT_WIFI";
    private static final String i2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_MONTH";
    private static final String j = "COLUMN_CT_NUMBER_OF_TESTS_WIFI";
    private static final String j0 = "COLUMN_AGG_TTR_LONG_WIFI";
    private static final String j1 = "COLUMN_AGG_MPA_RAT_UNKNOWN";
    private static final String j2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_DAY";
    private static final String k = "COLUMN_CT_TESTS_SUCCESS_WIFI";
    private static final String k0 = "CREATE TABLE AGG_TTR (COLUMN_AGG_TTR_INDEX INTEGER PRIMARY KEY, COLUMN_AGG_TTR_YEAR INTEGER, COLUMN_AGG_TTR_MONTH INTEGER, COLUMN_AGG_TTR_DAY INTEGER,COLUMN_AGG_TTR_HOUR INTEGER, COLUMN_AGG_TTR_QUARTER INTEGER,COLUMN_AGG_TTR_DATE TEXT,COLUMN_AGG_TTR_MAX_2G INTEGER, COLUMN_AGG_TTR_MAX_3G INTEGER,COLUMN_AGG_TTR_MAX_4G INTEGER,COLUMN_AGG_TTR_MAX_5G INTEGER,COLUMN_AGG_TTR_MAX_WIFI INTEGER, COLUMN_AGG_TTR_TRAFFIC_RX_MOBILE INTEGER, COLUMN_AGG_TTR_TRAFFIC_TX_MOBILE INTEGER,COLUMN_AGG_TTR_TRAFFIC_RX_WIFI INTEGER,COLUMN_AGG_TTR_TRAFFIC_TX_WIFI INTEGER,COLUMN_AGG_TTR_LAT_2G REAL,COLUMN_AGG_TTR_LONG_2G REAL,COLUMN_AGG_TTR_LAT_3G REAL,COLUMN_AGG_TTR_LONG_3G REAL,COLUMN_AGG_TTR_LAT_4G REAL,COLUMN_AGG_TTR_LONG_4G REAL,COLUMN_AGG_TTR_LAT_5G REAL,COLUMN_AGG_TTR_LONG_5G REAL,COLUMN_AGG_TTR_LAT_WIFI REAL,COLUMN_AGG_TTR_LONG_WIFI REAL);";
    private static final String k1 = "CREATE TABLE AGG_MPA_RAT (COLUMN_AGG_MPA_RAT_INDEX INTEGER PRIMARY KEY, COLUMN_AGG_MPA_RAT_YEAR INTEGER, COLUMN_AGG_MPA_RAT_MONTH INTEGER, COLUMN_AGG_MPA_RAT_DAY INTEGER,COLUMN_AGG_MPA_RAT_DATE TEXT,COLUMN_AGG_MPA_RAT_2G INTEGER,COLUMN_AGG_MPA_RAT_3G INTEGER, COLUMN_AGG_MPA_RAT_4G INTEGER, COLUMN_AGG_MPA_RAT_5G INTEGER, COLUMN_AGG_MPA_RAT_WIFI INTEGER, COLUMN_AGG_MPA_RAT_UNKNOWN INTEGER);";
    private static final String k2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_DATE";
    private static final String l = "CREATE TABLE CT ( COLUMN_CT_NUMBER_OF_TESTS_MOBILE INTEGER, COLUMN_CT_TESTS_SUCCESS_MOBILE INTEGER, COLUMN_CT_NUMBER_OF_TESTS_WIFI INTEGER, COLUMN_CT_TESTS_SUCCESS_WIFI INTEGER)";
    private static final String[] l0 = {L, M, N, O, P, R, S, T, U, V, a0, b0, c0, d0, e0, f0, g0, h0, i0, j0};
    private static final String[] l1 = {a1, b1, c1, e1, f1, g1, h1, i1, j1};
    private static final String l2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_UNKNOWN";
    private static final String m = "INSERT INTO CT (COLUMN_CT_NUMBER_OF_TESTS_MOBILE,COLUMN_CT_TESTS_SUCCESS_MOBILE,COLUMN_CT_NUMBER_OF_TESTS_WIFI,COLUMN_CT_TESTS_SUCCESS_WIFI) VALUES (0,0,0,0)";
    private static final String[] m0 = {Q, L, M, N, O, P, R, S, T, U, V, a0, b0, c0, d0, e0, f0, g0, h0, i0, j0, a0, a0, b0, c0, d0, e0, f0, i0, j0};
    private static final String m1 = "AGG_MPV_RAT";
    private static final String m2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_EXCELLENT";
    private static final String n = "NIR";
    private static final String[] n0 = {L, M, N, O, P, "MAX(COLUMN_AGG_TTR_MAX_2G) AS COLUMN_AGG_TTR_MAX_2G", "MAX(COLUMN_AGG_TTR_MAX_3G) AS COLUMN_AGG_TTR_MAX_3G", "MAX(COLUMN_AGG_TTR_MAX_4G) AS COLUMN_AGG_TTR_MAX_4G", "MAX(COLUMN_AGG_TTR_MAX_5G) AS COLUMN_AGG_TTR_MAX_5G", "MAX(COLUMN_AGG_TTR_MAX_WIFI) AS COLUMN_AGG_TTR_MAX_WIFI"};
    private static final String n1 = "COLUMN_AGG_MPV_RAT_INDEX";
    private static final String n2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_GOOD";
    private static final String o = "COLUMN_NIR_NUMBER_OF_SAMPLES";
    private static final String[] o0 = {L, M, N, "SUM(COLUMN_AGG_TTR_TRAFFIC_RX_WIFI) AS COLUMN_AGG_TTR_TRAFFIC_RX_WIFI", "SUM(COLUMN_AGG_TTR_TRAFFIC_TX_WIFI) AS COLUMN_AGG_TTR_TRAFFIC_TX_WIFI", "SUM(COLUMN_AGG_TTR_TRAFFIC_RX_MOBILE) AS COLUMN_AGG_TTR_TRAFFIC_RX_MOBILE", "SUM(COLUMN_AGG_TTR_TRAFFIC_TX_MOBILE) AS COLUMN_AGG_TTR_TRAFFIC_TX_MOBILE"};
    private static final String o1 = "COLUMN_AGG_MPV_RAT_YEAR";
    private static final String o2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_FAIR";
    private static final String p = "COLUMN_NIR_NUMBER_OF_SAMPLES_BELOW_99DBM";
    private static final String p0 = "AGG_CT";
    private static final String p1 = "COLUMN_AGG_MPV_RAT_MONTH";
    private static final String p2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_POOR";
    private static final String q = "CREATE TABLE NIR (COLUMN_NIR_NUMBER_OF_SAMPLES INTEGER, COLUMN_NIR_NUMBER_OF_SAMPLES_BELOW_99DBM INTEGER)";
    private static final String q0 = "COLUMN_AGG_CT_INDEX";
    private static final String q1 = "COLUMN_AGG_MPV_RAT_DAY";
    private static final String q2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_BAD";
    private static final String r = "INSERT INTO NIR (COLUMN_NIR_NUMBER_OF_SAMPLES,COLUMN_NIR_NUMBER_OF_SAMPLES_BELOW_99DBM) VALUES (0,0)";
    private static final String r0 = "COLUMN_AGG_CT_YEAR";
    private static final String r1 = "COLUMN_AGG_MPV_RAT_DATE";
    private static final String r2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_LAT";
    private static final String s = "NF";
    private static final String s0 = "COLUMN_AGG_CT_MONTH";
    private static final String s1 = "COLUMN_AGG_MPV_RAT_2G";
    private static final String s2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_LNG";
    private static final String t = "COLUMN_NF_NUMBER_OF_FEEDBACKS";
    private static final String t0 = "COLUMN_AGG_CT_DAY";
    private static final String t1 = "COLUMN_AGG_MPV_RAT_3G";
    private static final String t2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_ACCURACY";
    private static final String u = "CREATE TABLE NF (COLUMN_NF_NUMBER_OF_FEEDBACKS INTEGER)";
    private static final String u0 = "COLUMN_AGG_CT_DATE";
    private static final String u1 = "COLUMN_AGG_MPV_RAT_4G";
    private static final String u2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_TECHNOLOGY";
    private static final String v = "INSERT INTO NF (COLUMN_NF_NUMBER_OF_FEEDBACKS) VALUES (0)";
    private static final String v0 = "COLUMN_AGG_CT_MOBILE_COUNT";
    private static final String v1 = "COLUMN_AGG_MPV_RAT_5G";
    private static final String v2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_TECHNOLOGY_ID";
    private static final String w = "ST";
    private static final String w0 = "COLUMN_AGG_CT_MOBILE_SUCCESS";
    private static final String w1 = "COLUMN_AGG_MPV_RAT_WIFI";
    private static final String w2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_TECHNOLOGY_TYPE";
    private static final String x = "COLUMN_ST_INDEX";
    private static final String x0 = "COLUMN_AGG_CT_WIFI_COUNT";
    private static final String x1 = "COLUMN_AGG_MPV_RAT_UNKNOWN";
    private static final String x2 = "CREATE TABLE TABLE_LOCATION_MPA_SIGNALSTRENGTH_SHARE (COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_INDEX INTEGER PRIMARY KEY, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_YEAR INTEGER, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_MONTH INTEGER, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_DAY INTEGER, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_DATE TEXT, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_UNKNOWN INTEGER, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_EXCELLENT INTEGER, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_GOOD INTEGER, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_FAIR INTEGER, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_POOR INTEGER, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_BAD INTEGER, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_LAT REAL, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_LNG REAL, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_ACCURACY INTEGER, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_TECHNOLOGY TEXT, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_TECHNOLOGY_TYPE TEXT, COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_TECHNOLOGY_ID TEXT);";
    private static final String y = "COLUMN_ST_LT";
    private static final String y0 = "COLUMN_AGG_CT_WIFI_SUCCESS";
    private static final String y1 = "CREATE TABLE AGG_MPV_RAT (COLUMN_AGG_MPV_RAT_INDEX INTEGER PRIMARY KEY, COLUMN_AGG_MPV_RAT_YEAR INTEGER, COLUMN_AGG_MPV_RAT_MONTH INTEGER, COLUMN_AGG_MPV_RAT_DAY INTEGER,COLUMN_AGG_MPV_RAT_DATE TEXT,COLUMN_AGG_MPV_RAT_2G INTEGER,COLUMN_AGG_MPV_RAT_3G INTEGER, COLUMN_AGG_MPV_RAT_4G INTEGER, COLUMN_AGG_MPV_RAT_5G INTEGER, COLUMN_AGG_MPV_RAT_WIFI INTEGER, COLUMN_AGG_MPV_RAT_UNKNOWN INTEGER);";
    private static final String[] y2 = {h2, i2, j2, k2, l2, m2, n2, o2, p2, q2, r2, s2, t2, u2, v2, w2};
    private static final String z = "COLUMN_ST_DL";
    private static final String z0 = "COLUMN_AGG_CT_WIFI_MIN_LATENCY";
    private static final String[] z1 = {o1, p1, q1, s1, t1, u1, v1, w1, x1};
    private static final String z2 = "AGG_VC_DROP";
    private long a = InsightCore.getInsightConfig().n1();
    private Context b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.umlaut.crowd.enums.NetworkGenerations[] r0 = com.umlaut.crowd.enums.NetworkGenerations.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen2     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen3     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen4     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen5SA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen5NSA     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.database.StatsDatabase.a.<clinit>():void");
        }
    }

    public StatsDatabase(Context context) {
        super(context, e, (SQLiteDatabase.CursorFactory) null, 16);
        this.b = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0095 A[Catch:{ Exception -> 0x024c }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ab A[Catch:{ Exception -> 0x024c }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0102 A[Catch:{ Exception -> 0x024c }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0168 A[Catch:{ Exception -> 0x024c }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01f4 A[Catch:{ Exception -> 0x024c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.umlaut.crowd.internal.RVR r25) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            java.lang.String r2 = ""
            java.lang.String r3 = "addVC: "
            monitor-enter(r24)
            if (r0 != 0) goto L_0x000d
            monitor-exit(r24)
            return
        L_0x000d:
            android.database.sqlite.SQLiteDatabase r12 = r24.getWritableDatabase()     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_VC_DROP_DATE) > CAST(? as INTEGER)"
            r13 = 1
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ Exception -> 0x024c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024c }
            r6.<init>(r2)     // Catch:{ Exception -> 0x024c }
            long r7 = r1.a     // Catch:{ Exception -> 0x024c }
            r6.append(r7)     // Catch:{ Exception -> 0x024c }
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x024c }
            r14 = 0
            r5[r14] = r2     // Catch:{ Exception -> 0x024c }
            java.lang.String r2 = "AGG_VC_DROP"
            r12.delete(r2, r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r2 = "COLUMN_AGG_VC_DROP_YEAR=? AND COLUMN_AGG_VC_DROP_MONTH=? AND COLUMN_AGG_VC_DROP_DAY=?"
            r4 = 3
            java.lang.String[] r15 = new java.lang.String[r4]     // Catch:{ Exception -> 0x024c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024c }
            r4.<init>()     // Catch:{ Exception -> 0x024c }
            com.umlaut.crowd.internal.ub r5 = r0.TimeInfoOnStart     // Catch:{ Exception -> 0x024c }
            int r5 = r5.year     // Catch:{ Exception -> 0x024c }
            r4.append(r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r5 = ""
            r4.append(r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x024c }
            r15[r14] = r4     // Catch:{ Exception -> 0x024c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024c }
            r4.<init>()     // Catch:{ Exception -> 0x024c }
            com.umlaut.crowd.internal.ub r5 = r0.TimeInfoOnStart     // Catch:{ Exception -> 0x024c }
            int r5 = r5.month     // Catch:{ Exception -> 0x024c }
            r4.append(r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r5 = ""
            r4.append(r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x024c }
            r15[r13] = r4     // Catch:{ Exception -> 0x024c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x024c }
            r4.<init>()     // Catch:{ Exception -> 0x024c }
            com.umlaut.crowd.internal.ub r5 = r0.TimeInfoOnStart     // Catch:{ Exception -> 0x024c }
            int r5 = r5.day     // Catch:{ Exception -> 0x024c }
            r4.append(r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r5 = ""
            r4.append(r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x024c }
            r5 = 2
            r15[r5] = r4     // Catch:{ Exception -> 0x024c }
            com.umlaut.crowd.internal.s0 r4 = r0.CallEndType     // Catch:{ Exception -> 0x024c }
            com.umlaut.crowd.internal.s0 r5 = com.umlaut.crowd.internal.s0.Dropped     // Catch:{ Exception -> 0x024c }
            if (r4 == r5) goto L_0x008c
            com.umlaut.crowd.internal.s0 r5 = com.umlaut.crowd.internal.s0.DroppedInWindow     // Catch:{ Exception -> 0x024c }
            if (r4 == r5) goto L_0x008c
            com.umlaut.crowd.internal.s0 r5 = com.umlaut.crowd.internal.s0.DroppedSamsung     // Catch:{ Exception -> 0x024c }
            if (r4 == r5) goto L_0x008c
            com.umlaut.crowd.internal.s0 r5 = com.umlaut.crowd.internal.s0.DroppedSamsungIms     // Catch:{ Exception -> 0x024c }
            if (r4 != r5) goto L_0x008a
            goto L_0x008c
        L_0x008a:
            r4 = 0
            goto L_0x008d
        L_0x008c:
            r4 = 1
        L_0x008d:
            double r5 = r0.VoiceRatShare5G     // Catch:{ Exception -> 0x024c }
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x00ab
            if (r4 == 0) goto L_0x009a
            r16 = 1
            goto L_0x009c
        L_0x009a:
            r16 = 0
        L_0x009c:
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 1
            r21 = 0
        L_0x00a6:
            r22 = 0
        L_0x00a8:
            r23 = 0
            goto L_0x00ee
        L_0x00ab:
            double r5 = r0.VoiceRatShare4G     // Catch:{ Exception -> 0x024c }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c3
            r16 = 0
            if (r4 == 0) goto L_0x00b8
            r17 = 1
            goto L_0x00ba
        L_0x00b8:
            r17 = 0
        L_0x00ba:
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 1
            goto L_0x00a6
        L_0x00c3:
            double r5 = r0.VoiceRatShare3G     // Catch:{ Exception -> 0x024c }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r16 = 0
            r17 = 0
            if (r9 <= 0) goto L_0x00dd
            if (r4 == 0) goto L_0x00d2
            r18 = 1
            goto L_0x00d4
        L_0x00d2:
            r18 = 0
        L_0x00d4:
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 1
            goto L_0x00a8
        L_0x00dd:
            r18 = 0
            if (r4 == 0) goto L_0x00e4
            r19 = 1
            goto L_0x00e6
        L_0x00e4:
            r19 = 0
        L_0x00e6:
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 1
        L_0x00ee:
            java.lang.String r5 = "AGG_VC_DROP"
            java.lang.String[] r6 = O2     // Catch:{ Exception -> 0x024c }
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r12
            r7 = r2
            r8 = r15
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x024c }
            boolean r5 = r4.moveToFirst()     // Catch:{ Exception -> 0x024c }
            if (r5 == 0) goto L_0x0163
            java.lang.String r5 = "COLUMN_AGG_VC_DROP_CALLS_2G"
            int r5 = r4.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x024c }
            int r5 = r4.getInt(r5)     // Catch:{ Exception -> 0x024c }
            int r23 = r23 + r5
            java.lang.String r5 = "COLUMN_AGG_VC_DROP_CALLS_3G"
            int r5 = r4.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x024c }
            int r5 = r4.getInt(r5)     // Catch:{ Exception -> 0x024c }
            int r22 = r22 + r5
            java.lang.String r5 = "COLUMN_AGG_VC_DROP_CALLS_4G"
            int r5 = r4.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x024c }
            int r5 = r4.getInt(r5)     // Catch:{ Exception -> 0x024c }
            int r21 = r21 + r5
            java.lang.String r5 = "COLUMN_AGG_VC_DROP_CALLS_5G"
            int r5 = r4.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x024c }
            int r5 = r4.getInt(r5)     // Catch:{ Exception -> 0x024c }
            int r20 = r20 + r5
            java.lang.String r5 = "COLUMN_AGG_VC_DROP_DROPS_2G"
            int r5 = r4.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x024c }
            int r5 = r4.getInt(r5)     // Catch:{ Exception -> 0x024c }
            int r19 = r19 + r5
            java.lang.String r5 = "COLUMN_AGG_VC_DROP_DROPS_3G"
            int r5 = r4.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x024c }
            int r5 = r4.getInt(r5)     // Catch:{ Exception -> 0x024c }
            int r18 = r18 + r5
            java.lang.String r5 = "COLUMN_AGG_VC_DROP_DROPS_4G"
            int r5 = r4.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x024c }
            int r5 = r4.getInt(r5)     // Catch:{ Exception -> 0x024c }
            int r17 = r17 + r5
            java.lang.String r5 = "COLUMN_AGG_VC_DROP_DROPS_5G"
            int r5 = r4.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x024c }
            int r5 = r4.getInt(r5)     // Catch:{ Exception -> 0x024c }
            int r16 = r16 + r5
            r13 = 0
        L_0x0163:
            r4.close()     // Catch:{ Exception -> 0x024c }
            if (r13 == 0) goto L_0x01f4
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x024c }
            r2.<init>()     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_CALLS_2G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r23)     // Catch:{ Exception -> 0x024c }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_CALLS_3G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r22)     // Catch:{ Exception -> 0x024c }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_CALLS_4G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r21)     // Catch:{ Exception -> 0x024c }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_CALLS_5G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r20)     // Catch:{ Exception -> 0x024c }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_DROPS_2G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r19)     // Catch:{ Exception -> 0x024c }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_DROPS_3G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r18)     // Catch:{ Exception -> 0x024c }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_DROPS_4G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x024c }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_DROPS_5G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r16)     // Catch:{ Exception -> 0x024c }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_YEAR"
            com.umlaut.crowd.internal.ub r5 = r0.TimeInfoOnStart     // Catch:{ Exception -> 0x024c }
            int r5 = r5.year     // Catch:{ Exception -> 0x024c }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x024c }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_MONTH"
            com.umlaut.crowd.internal.ub r5 = r0.TimeInfoOnStart     // Catch:{ Exception -> 0x024c }
            int r5 = r5.month     // Catch:{ Exception -> 0x024c }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x024c }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_DAY"
            com.umlaut.crowd.internal.ub r5 = r0.TimeInfoOnStart     // Catch:{ Exception -> 0x024c }
            int r5 = r5.day     // Catch:{ Exception -> 0x024c }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x024c }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_DATE"
            com.umlaut.crowd.internal.ub r0 = r0.TimeInfoOnStart     // Catch:{ Exception -> 0x024c }
            int r5 = r0.year     // Catch:{ Exception -> 0x024c }
            int r6 = r0.month     // Catch:{ Exception -> 0x024c }
            int r0 = r0.day     // Catch:{ Exception -> 0x024c }
            java.lang.String r0 = com.umlaut.crowd.utils.DateUtils.formatLumenDate(r5, r6, r0)     // Catch:{ Exception -> 0x024c }
            r2.put(r4, r0)     // Catch:{ Exception -> 0x024c }
            java.lang.String r0 = "AGG_VC_DROP"
            r4 = 0
            r12.insert(r0, r4, r2)     // Catch:{ Exception -> 0x024c }
            goto L_0x0246
        L_0x01f4:
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ Exception -> 0x024c }
            r0.<init>()     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_CALLS_2G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r23)     // Catch:{ Exception -> 0x024c }
            r0.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_CALLS_3G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r22)     // Catch:{ Exception -> 0x024c }
            r0.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_CALLS_4G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r21)     // Catch:{ Exception -> 0x024c }
            r0.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_CALLS_5G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r20)     // Catch:{ Exception -> 0x024c }
            r0.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_DROPS_2G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r19)     // Catch:{ Exception -> 0x024c }
            r0.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_DROPS_3G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r18)     // Catch:{ Exception -> 0x024c }
            r0.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_DROPS_4G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x024c }
            r0.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "COLUMN_AGG_VC_DROP_DROPS_5G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r16)     // Catch:{ Exception -> 0x024c }
            r0.put(r4, r5)     // Catch:{ Exception -> 0x024c }
            java.lang.String r4 = "AGG_VC_DROP"
            r12.update(r4, r0, r2, r15)     // Catch:{ Exception -> 0x024c }
        L_0x0246:
            r12.close()     // Catch:{ Exception -> 0x024c }
            goto L_0x0262
        L_0x024a:
            r0 = move-exception
            goto L_0x0264
        L_0x024c:
            r0 = move-exception
            java.lang.String r2 = d     // Catch:{ all -> 0x024a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x024a }
            r4.<init>(r3)     // Catch:{ all -> 0x024a }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x024a }
            r4.append(r0)     // Catch:{ all -> 0x024a }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x024a }
            android.util.Log.e(r2, r0)     // Catch:{ all -> 0x024a }
        L_0x0262:
            monitor-exit(r24)
            return
        L_0x0264:
            monitor-exit(r24)
            goto L_0x0267
        L_0x0266:
            throw r0
        L_0x0267:
            goto L_0x0266
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.database.StatsDatabase.a(com.umlaut.crowd.internal.RVR):void");
    }

    public synchronized void b(ub ubVar, int i3, int i4, int i5, int i6, int i7, int i8) {
        ub ubVar2 = ubVar;
        synchronized (this) {
            int i9 = i3 < 0 ? 0 : i3;
            int i10 = i4 < 0 ? 0 : i4;
            int i11 = i5 < 0 ? 0 : i5;
            int i12 = i6 < 0 ? 0 : i6;
            int i13 = i7 < 0 ? 0 : i7;
            int i14 = i8 < 0 ? 0 : i8;
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                SQLiteDatabase sQLiteDatabase = writableDatabase;
                sQLiteDatabase.delete(m1, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_MPV_RAT_DATE) > CAST(? as INTEGER)", new String[]{"" + this.a});
                String[] strArr = {ubVar2.year + "", ubVar2.month + "", ubVar2.day + ""};
                boolean z3 = true;
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase.query(m1, z1, "COLUMN_AGG_MPV_RAT_YEAR=? AND COLUMN_AGG_MPV_RAT_MONTH=? AND COLUMN_AGG_MPV_RAT_DAY=?", strArr, (String) null, (String) null, (String) null);
                if (query.moveToFirst()) {
                    i9 += query.getInt(query.getColumnIndexOrThrow(s1));
                    i10 += query.getInt(query.getColumnIndexOrThrow(t1));
                    i11 += query.getInt(query.getColumnIndexOrThrow(u1));
                    i12 += query.getInt(query.getColumnIndexOrThrow(v1));
                    i13 += query.getInt(query.getColumnIndexOrThrow(w1));
                    i14 += query.getInt(query.getColumnIndexOrThrow(x1));
                    z3 = false;
                }
                query.close();
                if (z3) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(s1, Integer.valueOf(i9));
                    contentValues.put(t1, Integer.valueOf(i10));
                    contentValues.put(u1, Integer.valueOf(i11));
                    contentValues.put(v1, Integer.valueOf(i12));
                    contentValues.put(w1, Integer.valueOf(i13));
                    contentValues.put(x1, Integer.valueOf(i14));
                    contentValues.put(o1, Integer.valueOf(ubVar2.year));
                    contentValues.put(p1, Integer.valueOf(ubVar2.month));
                    contentValues.put(q1, Integer.valueOf(ubVar2.day));
                    contentValues.put(r1, DateUtils.formatLumenDate(ubVar2.year, ubVar2.month, ubVar2.day));
                    sQLiteDatabase2.insert(m1, (String) null, contentValues);
                } else {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put(s1, Integer.valueOf(i9));
                    contentValues2.put(t1, Integer.valueOf(i10));
                    contentValues2.put(u1, Integer.valueOf(i11));
                    contentValues2.put(v1, Integer.valueOf(i12));
                    contentValues2.put(w1, Integer.valueOf(i13));
                    contentValues2.put(x1, Integer.valueOf(i14));
                    sQLiteDatabase2.update(m1, contentValues2, "COLUMN_AGG_MPV_RAT_YEAR=? AND COLUMN_AGG_MPV_RAT_MONTH=? AND COLUMN_AGG_MPV_RAT_DAY=?", strArr);
                }
                sQLiteDatabase2.close();
            } catch (Exception e3) {
                String str = d;
                Log.e(str, "addMpvRatShare: " + e3.getMessage());
            }
        }
        return;
    }

    public AusFrequencyAgg[] getAppUsageForLastDays(int i3, SortOrder sortOrder, boolean z3) {
        int i4;
        AusFrequencyAgg ausFrequencyAgg;
        int i5;
        Iterator<UsageStats> it;
        Calendar calendar;
        ArrayList arrayList;
        HashSet hashSet;
        ArrayList arrayList2;
        Iterator<UsageStats> it2;
        SortOrder sortOrder2 = sortOrder;
        ArrayList arrayList3 = new ArrayList();
        if (Build.VERSION.SDK_INT < 23 || !AppUsageUtils.isAppUsageStatsPermissionGranted(this.b)) {
            int i6 = i3;
            return getAusFrequencyAggForLastDays(i3, sortOrder);
        }
        try {
            UsageStatsManager usageStatsManager = (UsageStatsManager) this.b.getSystemService("usagestats");
            PackageManager packageManager = this.b.getPackageManager();
            NetworkStatsManager networkStatsManager = (NetworkStatsManager) this.b.getSystemService(NetworkStatsManager.class);
            String subscriberId = this.b.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 ? ((TelephonyManager) this.b.getSystemService("phone")).getSubscriberId() : null;
            long currentTimeMillis = System.currentTimeMillis();
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(currentTimeMillis);
            int i7 = 0;
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            i4 = i3;
            if (i4 < 1) {
                i4 = 1;
            }
            int i8 = 5;
            try {
                instance.add(5, -(i4 - 1));
                long timeInMillis = instance.getTimeInMillis();
                int i9 = i4 > 7 ? 4 : 0;
                HashSet hashSet2 = new HashSet();
                int i10 = 1;
                int i11 = i4;
                try {
                    Iterator<UsageStats> it3 = usageStatsManager.queryUsageStats(i9, timeInMillis, currentTimeMillis).iterator();
                    while (it3.hasNext()) {
                        UsageStats next = it3.next();
                        if (next.getTotalTimeInForeground() > 0 || !z3) {
                            instance.setTimeInMillis(next.getFirstTimeStamp());
                            int i12 = instance.get(i10);
                            int i13 = instance.get(2) + i10;
                            int i14 = instance.get(i8);
                            Iterator it4 = arrayList3.iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    ausFrequencyAgg = null;
                                    break;
                                }
                                ausFrequencyAgg = (AusFrequencyAgg) it4.next();
                                if (ausFrequencyAgg.day == i14 && ausFrequencyAgg.month == i13 && ausFrequencyAgg.year == i12) {
                                    break;
                                }
                            }
                            if (ausFrequencyAgg == null) {
                                ausFrequencyAgg = new AusFrequencyAgg();
                                ausFrequencyAgg.year = i12;
                                ausFrequencyAgg.month = i13;
                                ausFrequencyAgg.day = i14;
                                arrayList3.add(ausFrequencyAgg);
                            }
                            AppUsageMetrics appUsageMetrics = new AppUsageMetrics();
                            appUsageMetrics.packageName = next.getPackageName();
                            appUsageMetrics.usageTime = next.getTotalTimeInForeground();
                            try {
                                i5 = packageManager.getApplicationInfo(next.getPackageName(), i7).uid;
                            } catch (PackageManager.NameNotFoundException e3) {
                                Log.e(d, "getAppUsageForLastDays" + e3.toString());
                                i5 = -1;
                            }
                            if (i5 != -1) {
                                try {
                                    instance.setTimeInMillis(next.getFirstTimeStamp());
                                    instance.set(11, i7);
                                    instance.set(12, i7);
                                    instance.set(13, i7);
                                    instance.set(14, i7);
                                    NetworkStats.Bucket bucket = new NetworkStats.Bucket();
                                    hashSet = hashSet2;
                                    calendar = instance;
                                    try {
                                        NetworkStats queryDetailsForUid = networkStatsManager.queryDetailsForUid(1, (String) null, instance.getTimeInMillis(), next.getLastTimeStamp(), i5);
                                        if (queryDetailsForUid != null) {
                                            while (queryDetailsForUid.getNextBucket(bucket)) {
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("WIFI-");
                                                sb.append(appUsageMetrics.packageName);
                                                sb.append("-");
                                                arrayList2 = arrayList3;
                                                it2 = it3;
                                                try {
                                                    sb.append(bucket.getStartTimeStamp());
                                                    sb.append("-");
                                                    sb.append(bucket.getEndTimeStamp());
                                                    String sb2 = sb.toString();
                                                    if (!hashSet.contains(sb2)) {
                                                        hashSet.add(sb2);
                                                        appUsageMetrics.trafficRxBytesWifi += bucket.getRxBytes();
                                                        appUsageMetrics.trafficTxBytesWifi += bucket.getTxBytes();
                                                    }
                                                    it3 = it2;
                                                    arrayList3 = arrayList2;
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    Log.e(d, "getAppUsageForLastDays" + e.toString());
                                                    ausFrequencyAgg.appUsageList.add(appUsageMetrics);
                                                    it3 = it;
                                                    hashSet2 = hashSet;
                                                    arrayList3 = arrayList;
                                                    instance = calendar;
                                                    i8 = 5;
                                                    i7 = 0;
                                                    i10 = 1;
                                                }
                                            }
                                            arrayList = arrayList3;
                                            it = it3;
                                            queryDetailsForUid.close();
                                        } else {
                                            arrayList = arrayList3;
                                            it = it3;
                                        }
                                        if (subscriberId != null) {
                                            long firstTimeStamp = next.getFirstTimeStamp();
                                            long lastTimeStamp = next.getLastTimeStamp();
                                            String str = "-";
                                            NetworkStats queryDetailsForUid2 = networkStatsManager.queryDetailsForUid(0, subscriberId, firstTimeStamp, lastTimeStamp, i5);
                                            if (queryDetailsForUid2 != null) {
                                                while (queryDetailsForUid2.getNextBucket(bucket)) {
                                                    String str2 = "MOBILE-appUsageMetrics.packageName-" + bucket.getStartTimeStamp() + str + bucket.getEndTimeStamp();
                                                    if (!hashSet.contains(str2)) {
                                                        hashSet.add(str2);
                                                        appUsageMetrics.trafficRxBytesMobile += bucket.getRxBytes();
                                                        appUsageMetrics.trafficTxBytesMobile += bucket.getTxBytes();
                                                    }
                                                }
                                                queryDetailsForUid2.close();
                                            }
                                        }
                                        appUsageMetrics.trafficRxBytes = appUsageMetrics.trafficRxBytesMobile + appUsageMetrics.trafficRxBytesWifi;
                                        appUsageMetrics.trafficTxBytes = appUsageMetrics.trafficTxBytesMobile + appUsageMetrics.trafficTxBytesWifi;
                                    } catch (Exception e5) {
                                        e = e5;
                                        arrayList2 = arrayList3;
                                        it2 = it3;
                                        Log.e(d, "getAppUsageForLastDays" + e.toString());
                                        ausFrequencyAgg.appUsageList.add(appUsageMetrics);
                                        it3 = it;
                                        hashSet2 = hashSet;
                                        arrayList3 = arrayList;
                                        instance = calendar;
                                        i8 = 5;
                                        i7 = 0;
                                        i10 = 1;
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    hashSet = hashSet2;
                                    arrayList2 = arrayList3;
                                    it2 = it3;
                                    calendar = instance;
                                    Log.e(d, "getAppUsageForLastDays" + e.toString());
                                    ausFrequencyAgg.appUsageList.add(appUsageMetrics);
                                    it3 = it;
                                    hashSet2 = hashSet;
                                    arrayList3 = arrayList;
                                    instance = calendar;
                                    i8 = 5;
                                    i7 = 0;
                                    i10 = 1;
                                }
                            } else {
                                hashSet = hashSet2;
                                arrayList = arrayList3;
                                it = it3;
                                calendar = instance;
                            }
                            ausFrequencyAgg.appUsageList.add(appUsageMetrics);
                            it3 = it;
                            hashSet2 = hashSet;
                            arrayList3 = arrayList;
                            instance = calendar;
                            i8 = 5;
                            i7 = 0;
                            i10 = 1;
                        }
                    }
                    ArrayList arrayList4 = arrayList3;
                    if (sortOrder2 == SortOrder.DESC) {
                        Collections.reverse(arrayList4);
                    }
                    return (AusFrequencyAgg[]) arrayList4.toArray(new AusFrequencyAgg[arrayList4.size()]);
                } catch (Exception e7) {
                    e = e7;
                    i4 = i11;
                    Log.e(d, "getAppUsageForLastDays" + e.toString());
                    return getAusFrequencyAggForLastDays(i4, sortOrder2);
                }
            } catch (Exception e8) {
                e = e8;
                int i15 = i4;
                Log.e(d, "getAppUsageForLastDays" + e.toString());
                return getAusFrequencyAggForLastDays(i4, sortOrder2);
            }
        } catch (Exception e9) {
            e = e9;
            i4 = i3;
            Log.e(d, "getAppUsageForLastDays" + e.toString());
            return getAusFrequencyAggForLastDays(i4, sortOrder2);
        }
    }

    public synchronized AusFrequencyAgg[] getAusFrequencyAggForLastDays(int i3, SortOrder sortOrder) {
        AusFrequencyAgg[] ausFrequencyAggArr;
        SortOrder sortOrder2 = sortOrder;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                int i4 = 0;
                Cursor query = readableDatabase.query(P2, b3, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_AUS_FREQUENCY_DATE) <= CAST(? as INTEGER)", new String[]{i3 + ""}, (String) null, (String) null, "COLUMN_AGG_AUS_FREQUENCY_YEAR " + sortOrder2 + ",COLUMN_AGG_AUS_FREQUENCY_MONTH " + sortOrder2 + ",COLUMN_AGG_AUS_FREQUENCY_DAY " + sortOrder2);
                AusFrequencyAgg ausFrequencyAgg = new AusFrequencyAgg();
                while (query.moveToNext()) {
                    int i5 = query.getInt(query.getColumnIndexOrThrow(T2));
                    if (i5 != i4) {
                        if (i4 != 0) {
                            arrayList.add(ausFrequencyAgg);
                        }
                        ausFrequencyAgg = new AusFrequencyAgg();
                        ausFrequencyAgg.year = query.getInt(query.getColumnIndexOrThrow(R2));
                        ausFrequencyAgg.month = query.getInt(query.getColumnIndexOrThrow(S2));
                        ausFrequencyAgg.day = i5;
                    }
                    AppUsageMetrics appUsageMetrics = new AppUsageMetrics();
                    appUsageMetrics.packageName = query.getString(query.getColumnIndexOrThrow(V2));
                    appUsageMetrics.sessions = query.getInt(query.getColumnIndexOrThrow(W2));
                    appUsageMetrics.usageTime = query.getLong(query.getColumnIndexOrThrow(X2));
                    appUsageMetrics.trafficRxBytes = query.getLong(query.getColumnIndexOrThrow(Y2));
                    appUsageMetrics.trafficTxBytes = query.getLong(query.getColumnIndexOrThrow(Z2));
                    ausFrequencyAgg.appUsageList.add(appUsageMetrics);
                    i4 = i5;
                }
                if (i4 != 0) {
                    arrayList.add(ausFrequencyAgg);
                }
                query.close();
                readableDatabase.close();
                ausFrequencyAggArr = (AusFrequencyAgg[]) arrayList.toArray(new AusFrequencyAgg[arrayList.size()]);
            } catch (Exception e3) {
                Log.e(d, "getAusFrequencyAggForLastDays: " + e3.getMessage());
                return null;
            }
        }
        return ausFrequencyAggArr;
    }

    public synchronized CTSuccessAgg[] getCTSuccessAggForLastDays(int i3, SortOrder sortOrder) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String[] strArr = {i3 + ""};
            SQLiteDatabase sQLiteDatabase = readableDatabase;
            Cursor query = sQLiteDatabase.query(p0, G0, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_CT_DATE) <= CAST(? as INTEGER)", strArr, (String) null, (String) null, "COLUMN_AGG_CT_YEAR " + sortOrder + ",COLUMN_AGG_CT_MONTH " + sortOrder + ",COLUMN_AGG_CT_DAY " + sortOrder);
            while (query.moveToNext()) {
                CTSuccessAgg cTSuccessAgg = new CTSuccessAgg();
                cTSuccessAgg.year = query.getInt(query.getColumnIndexOrThrow(r0));
                cTSuccessAgg.month = query.getInt(query.getColumnIndexOrThrow(s0));
                cTSuccessAgg.day = query.getInt(query.getColumnIndexOrThrow(t0));
                cTSuccessAgg.mobileCount = query.getInt(query.getColumnIndexOrThrow(v0));
                cTSuccessAgg.mobileSuccess = query.getInt(query.getColumnIndexOrThrow(w0));
                cTSuccessAgg.mobileMinLatency = query.getInt(query.getColumnIndexOrThrow(A0));
                cTSuccessAgg.mobileMinLatency2G = query.getInt(query.getColumnIndexOrThrow(B0));
                cTSuccessAgg.mobileMinLatency3G = query.getInt(query.getColumnIndexOrThrow(C0));
                cTSuccessAgg.mobileMinLatency4G = query.getInt(query.getColumnIndexOrThrow(D0));
                cTSuccessAgg.mobileMinLatency5G = query.getInt(query.getColumnIndexOrThrow(E0));
                cTSuccessAgg.wifiCount = query.getInt(query.getColumnIndexOrThrow(x0));
                cTSuccessAgg.wifiSuccess = query.getInt(query.getColumnIndexOrThrow(y0));
                cTSuccessAgg.wifiMinLatency = query.getInt(query.getColumnIndexOrThrow(z0));
                arrayList.add(cTSuccessAgg);
            }
            query.close();
            readableDatabase.close();
        } catch (Exception e3) {
            String str = d;
            Log.e(str, "getCTSuccessAggForLastDays: " + e3.getMessage());
            return null;
        }
        return (CTSuccessAgg[]) arrayList.toArray(new CTSuccessAgg[arrayList.size()]);
    }

    public synchronized CTSuccessLocation[] getCTSuccessLocationForLastDays(int i3, SortOrder sortOrder) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String[] strArr = {i3 + ""};
            SQLiteDatabase sQLiteDatabase = readableDatabase;
            Cursor query = sQLiteDatabase.query(H0, X0, "JULIANDAY('now') - JULIANDAY(COLUMN_LOCATION_CT_DATE) <= CAST(? as INTEGER)", strArr, (String) null, (String) null, "COLUMN_LOCATION_CT_YEAR " + sortOrder + ",COLUMN_LOCATION_CT_MONTH " + sortOrder + ",COLUMN_LOCATION_CT_DAY " + sortOrder);
            while (query.moveToNext()) {
                CTSuccessLocation cTSuccessLocation = new CTSuccessLocation();
                cTSuccessLocation.year = query.getInt(query.getColumnIndexOrThrow(J0));
                cTSuccessLocation.month = query.getInt(query.getColumnIndexOrThrow(K0));
                cTSuccessLocation.day = query.getInt(query.getColumnIndexOrThrow(L0));
                cTSuccessLocation.latency = query.getInt(query.getColumnIndexOrThrow(N0));
                cTSuccessLocation.count = query.getInt(query.getColumnIndexOrThrow(O0));
                cTSuccessLocation.accuracy = query.getInt(query.getColumnIndexOrThrow(V0));
                cTSuccessLocation.successful = query.getInt(query.getColumnIndexOrThrow(P0));
                cTSuccessLocation.technology = query.getString(query.getColumnIndexOrThrow(Q0));
                cTSuccessLocation.technologyID = query.getString(query.getColumnIndexOrThrow(R0));
                cTSuccessLocation.technologyType = query.getString(query.getColumnIndexOrThrow(S0));
                cTSuccessLocation.locationLatitude = query.getDouble(query.getColumnIndexOrThrow(T0));
                cTSuccessLocation.locationLongitude = query.getDouble(query.getColumnIndexOrThrow(U0));
                arrayList.add(cTSuccessLocation);
            }
            query.close();
            readableDatabase.close();
        } catch (Exception e3) {
            String str = d;
            Log.e(str, "getCTSuccessAggForLastDays: " + e3.getMessage());
            return null;
        }
        return (CTSuccessLocation[]) arrayList.toArray(new CTSuccessLocation[arrayList.size()]);
    }

    @Deprecated
    public synchronized ConnectivityTestMetrics getConnectivityTestMetrics() {
        ConnectivityTestMetrics connectivityTestMetrics;
        connectivityTestMetrics = new ConnectivityTestMetrics();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT COLUMN_CT_NUMBER_OF_TESTS_MOBILE,COLUMN_CT_TESTS_SUCCESS_MOBILE,COLUMN_CT_NUMBER_OF_TESTS_WIFI,COLUMN_CT_TESTS_SUCCESS_WIFI FROM CT", (String[]) null);
        if (rawQuery.moveToFirst()) {
            connectivityTestMetrics.numberOfTestsMobile = rawQuery.getLong(0);
            connectivityTestMetrics.numberOfTestsSucessfulMobile = rawQuery.getLong(1);
            connectivityTestMetrics.numberOfTestsWiFi = rawQuery.getLong(2);
            connectivityTestMetrics.numberOfTestsSucessfulWiFi = rawQuery.getLong(3);
        }
        rawQuery.close();
        readableDatabase.close();
        long j3 = connectivityTestMetrics.numberOfTestsMobile;
        if (j3 > 0) {
            double d3 = (double) connectivityTestMetrics.numberOfTestsSucessfulMobile;
            double d4 = (double) j3;
            Double.isNaN(d3);
            Double.isNaN(d4);
            connectivityTestMetrics.successRateMobile = (d3 / d4) * 100.0d;
        }
        long j4 = connectivityTestMetrics.numberOfTestsWiFi;
        if (j4 > 0) {
            double d5 = (double) connectivityTestMetrics.numberOfTestsSucessfulWiFi;
            double d6 = (double) j4;
            Double.isNaN(d5);
            Double.isNaN(d6);
            connectivityTestMetrics.successRateWiFi = (d5 / d6) * 100.0d;
        }
        return connectivityTestMetrics;
    }

    public synchronized RatShareAgg[] getMpaRatShareAggForLastDays(int i3, SortOrder sortOrder) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String[] strArr = {i3 + ""};
            SQLiteDatabase sQLiteDatabase = readableDatabase;
            Cursor query = sQLiteDatabase.query(Y0, l1, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_MPA_RAT_DATE) <= CAST(? as INTEGER)", strArr, (String) null, (String) null, "COLUMN_AGG_MPA_RAT_YEAR " + sortOrder + ",COLUMN_AGG_MPA_RAT_MONTH " + sortOrder + ",COLUMN_AGG_MPA_RAT_DAY " + sortOrder);
            while (query.moveToNext()) {
                RatShareAgg ratShareAgg = new RatShareAgg();
                ratShareAgg.year = query.getInt(query.getColumnIndexOrThrow(a1));
                ratShareAgg.month = query.getInt(query.getColumnIndexOrThrow(b1));
                ratShareAgg.day = query.getInt(query.getColumnIndexOrThrow(c1));
                ratShareAgg.samples2g = (long) query.getInt(query.getColumnIndexOrThrow(e1));
                ratShareAgg.samples3g = (long) query.getInt(query.getColumnIndexOrThrow(f1));
                ratShareAgg.samples4g = (long) query.getInt(query.getColumnIndexOrThrow(g1));
                ratShareAgg.samples5g = (long) query.getInt(query.getColumnIndexOrThrow(h1));
                ratShareAgg.samplesWifi = (long) query.getInt(query.getColumnIndexOrThrow(i1));
                ratShareAgg.samplesUnknown = (long) query.getInt(query.getColumnIndexOrThrow(j1));
                arrayList.add(ratShareAgg);
            }
            query.close();
            readableDatabase.close();
        } catch (Exception e3) {
            String str = d;
            Log.e(str, "getCTSuccessAggForLastDays: " + e3.getMessage());
            return null;
        }
        return (RatShareAgg[]) arrayList.toArray(new RatShareAgg[arrayList.size()]);
    }

    public synchronized MpaSignalStrengthAgg[] getMpaSignalStrengthAggForLastDays(int i3, SortOrder sortOrder) {
        MpaSignalStrengthAgg[] mpaSignalStrengthAggArr;
        SortOrder sortOrder2 = sortOrder;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                Cursor query = readableDatabase.query(L1, e2, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_DATE) <= CAST(? as INTEGER)", new String[]{i3 + ""}, (String) null, (String) null, "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_YEAR " + sortOrder2 + ",COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MONTH " + sortOrder2 + ",COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_DAY " + sortOrder2);
                while (query.moveToNext()) {
                    MpaSignalStrengthAgg mpaSignalStrengthAgg = new MpaSignalStrengthAgg();
                    mpaSignalStrengthAgg.year = query.getInt(query.getColumnIndexOrThrow(N1));
                    mpaSignalStrengthAgg.month = query.getInt(query.getColumnIndexOrThrow(O1));
                    mpaSignalStrengthAgg.day = query.getInt(query.getColumnIndexOrThrow(P1));
                    long j3 = query.getLong(query.getColumnIndexOrThrow(R1));
                    long j4 = query.getLong(query.getColumnIndexOrThrow(S1));
                    long j5 = query.getLong(query.getColumnIndexOrThrow(T1));
                    long j6 = query.getLong(query.getColumnIndexOrThrow(U1));
                    long j7 = query.getLong(query.getColumnIndexOrThrow(V1));
                    long j8 = query.getLong(query.getColumnIndexOrThrow(W1));
                    mpaSignalStrengthAgg.signalStrengthShareMobile = new k9(query.getLong(query.getColumnIndexOrThrow(X1)), query.getLong(query.getColumnIndexOrThrow(Y1)), query.getLong(query.getColumnIndexOrThrow(Z1)), query.getLong(query.getColumnIndexOrThrow(a2)), query.getLong(query.getColumnIndexOrThrow(b2)), query.getLong(query.getColumnIndexOrThrow(c2)));
                    mpaSignalStrengthAgg.signalStrengthShareWifi = new k9(j3, j4, j5, j6, j7, j8);
                    arrayList.add(mpaSignalStrengthAgg);
                }
                query.close();
                readableDatabase.close();
                mpaSignalStrengthAggArr = (MpaSignalStrengthAgg[]) arrayList.toArray(new MpaSignalStrengthAgg[arrayList.size()]);
            } catch (Exception e3) {
                Log.e(d, "getMpaSignalStrengthAggForLastDays: " + e3.getMessage());
                return null;
            }
        }
        return mpaSignalStrengthAggArr;
    }

    public synchronized SignalStrengthLocationShare[] getMpaSignalStrengthLocationShare(int i3, SortOrder sortOrder) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String[] strArr = {i3 + ""};
            SQLiteDatabase sQLiteDatabase = readableDatabase;
            Cursor query = sQLiteDatabase.query(f2, y2, "JULIANDAY('now') - JULIANDAY(COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_DATE) <= CAST(? as INTEGER)", strArr, (String) null, (String) null, "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_YEAR " + sortOrder + ",COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_MONTH " + sortOrder + ",COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_DAY " + sortOrder);
            while (query.moveToNext()) {
                SignalStrengthLocationShare signalStrengthLocationShare = new SignalStrengthLocationShare();
                signalStrengthLocationShare.unknown = query.getInt(query.getColumnIndexOrThrow(l2));
                signalStrengthLocationShare.excellent = query.getInt(query.getColumnIndexOrThrow(m2));
                signalStrengthLocationShare.good = query.getInt(query.getColumnIndexOrThrow(n2));
                signalStrengthLocationShare.fair = query.getInt(query.getColumnIndexOrThrow(o2));
                signalStrengthLocationShare.poor = query.getInt(query.getColumnIndexOrThrow(p2));
                int i4 = query.getInt(query.getColumnIndexOrThrow(q2));
                signalStrengthLocationShare.bad = i4;
                signalStrengthLocationShare.total = (long) (signalStrengthLocationShare.excellent + signalStrengthLocationShare.good + signalStrengthLocationShare.fair + signalStrengthLocationShare.poor + i4);
                signalStrengthLocationShare.latitude = query.getDouble(query.getColumnIndexOrThrow(r2));
                signalStrengthLocationShare.longitude = query.getDouble(query.getColumnIndexOrThrow(s2));
                signalStrengthLocationShare.accuracy = query.getInt(query.getColumnIndexOrThrow(t2));
                signalStrengthLocationShare.technology = query.getString(query.getColumnIndexOrThrow(u2));
                signalStrengthLocationShare.technologyId = query.getString(query.getColumnIndexOrThrow(v2));
                signalStrengthLocationShare.technologyType = query.getString(query.getColumnIndexOrThrow(w2));
                arrayList.add(signalStrengthLocationShare);
            }
            query.close();
            readableDatabase.close();
        } catch (Exception e3) {
            String str = d;
            Log.e(str, "getMpaSignalStrengthLocationShare: " + e3.getMessage());
            return null;
        }
        return (SignalStrengthLocationShare[]) arrayList.toArray(new SignalStrengthLocationShare[arrayList.size()]);
    }

    public synchronized RatShareAgg[] getMpvRatShareAggForLastDays(int i3, SortOrder sortOrder) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String[] strArr = {i3 + ""};
            SQLiteDatabase sQLiteDatabase = readableDatabase;
            Cursor query = sQLiteDatabase.query(m1, z1, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_MPV_RAT_DATE) <= CAST(? as INTEGER)", strArr, (String) null, (String) null, "COLUMN_AGG_MPV_RAT_YEAR " + sortOrder + ",COLUMN_AGG_MPV_RAT_MONTH " + sortOrder + ",COLUMN_AGG_MPV_RAT_DAY " + sortOrder);
            while (query.moveToNext()) {
                RatShareAgg ratShareAgg = new RatShareAgg();
                ratShareAgg.year = query.getInt(query.getColumnIndexOrThrow(o1));
                ratShareAgg.month = query.getInt(query.getColumnIndexOrThrow(p1));
                ratShareAgg.day = query.getInt(query.getColumnIndexOrThrow(q1));
                ratShareAgg.samples2g = (long) query.getInt(query.getColumnIndexOrThrow(s1));
                ratShareAgg.samples3g = (long) query.getInt(query.getColumnIndexOrThrow(t1));
                ratShareAgg.samples4g = (long) query.getInt(query.getColumnIndexOrThrow(u1));
                ratShareAgg.samples5g = (long) query.getInt(query.getColumnIndexOrThrow(v1));
                ratShareAgg.samplesWifi = (long) query.getInt(query.getColumnIndexOrThrow(w1));
                ratShareAgg.samplesUnknown = (long) query.getInt(query.getColumnIndexOrThrow(x1));
                arrayList.add(ratShareAgg);
            }
            query.close();
            readableDatabase.close();
        } catch (Exception e3) {
            String str = d;
            Log.e(str, "getCTSuccessAggForLastDays: " + e3.getMessage());
            return null;
        }
        return (RatShareAgg[]) arrayList.toArray(new RatShareAgg[arrayList.size()]);
    }

    @Deprecated
    public synchronized NetworkFeedbackMetrics getNetworkFeedbackMetrics() {
        NetworkFeedbackMetrics networkFeedbackMetrics;
        networkFeedbackMetrics = new NetworkFeedbackMetrics();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT COLUMN_NF_NUMBER_OF_FEEDBACKS FROM NF", (String[]) null);
        if (rawQuery.moveToFirst()) {
            networkFeedbackMetrics.numberOfFeedbacksReported = rawQuery.getLong(0);
        }
        rawQuery.close();
        readableDatabase.close();
        return networkFeedbackMetrics;
    }

    @Deprecated
    public synchronized NetworkInformationMetrics getNetworkInformationMetrics() {
        NetworkInformationMetrics networkInformationMetrics;
        networkInformationMetrics = new NetworkInformationMetrics();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT COLUMN_NIR_NUMBER_OF_SAMPLES,COLUMN_NIR_NUMBER_OF_SAMPLES_BELOW_99DBM FROM NIR", (String[]) null);
        if (rawQuery.moveToFirst()) {
            networkInformationMetrics.numberOfSamples = rawQuery.getLong(0);
            networkInformationMetrics.numberOfSamplesBelow99dBm = rawQuery.getLong(1);
        }
        rawQuery.close();
        readableDatabase.close();
        long j3 = networkInformationMetrics.numberOfSamples;
        if (j3 > 0) {
            double d3 = (double) networkInformationMetrics.numberOfSamplesBelow99dBm;
            double d4 = (double) j3;
            Double.isNaN(d3);
            Double.isNaN(d4);
            networkInformationMetrics.percentageOfSamplesBelow99dBm = (d3 / d4) * 100.0d;
        }
        return networkInformationMetrics;
    }

    public synchronized RatShareAgg[] getRatShareAggForLastDays(int i3, SortOrder sortOrder) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor rawQuery = readableDatabase.rawQuery("SELECT COLUMN_AGG_RAT_YEAR, COLUMN_AGG_RAT_MONTH, COLUMN_AGG_RAT_DAY, SUM(COLUMN_AGG_RAT_2G) AS COLUMN_AGG_RAT_2G, SUM(COLUMN_AGG_RAT_3G) AS COLUMN_AGG_RAT_3G, SUM(COLUMN_AGG_RAT_4G) AS COLUMN_AGG_RAT_4G, SUM(COLUMN_AGG_RAT_5G) AS COLUMN_AGG_RAT_5G, SUM(COLUMN_AGG_RAT_WIFI) AS COLUMN_AGG_RAT_WIFI, SUM(COLUMN_AGG_RAT_UNKNOWN) AS COLUMN_AGG_RAT_UNKNOWN FROM (SELECT COLUMN_AGG_MPA_RAT_YEAR AS COLUMN_AGG_RAT_YEAR, COLUMN_AGG_MPA_RAT_MONTH AS COLUMN_AGG_RAT_MONTH, COLUMN_AGG_MPA_RAT_DAY AS COLUMN_AGG_RAT_DAY, COLUMN_AGG_MPA_RAT_2G AS COLUMN_AGG_RAT_2G, COLUMN_AGG_MPA_RAT_3G AS COLUMN_AGG_RAT_3G, COLUMN_AGG_MPA_RAT_4G AS COLUMN_AGG_RAT_4G, COLUMN_AGG_MPA_RAT_5G AS COLUMN_AGG_RAT_5G, COLUMN_AGG_MPA_RAT_WIFI AS COLUMN_AGG_RAT_WIFI, COLUMN_AGG_MPA_RAT_UNKNOWN AS COLUMN_AGG_RAT_UNKNOWN FROM AGG_MPA_RAT WHERE JULIANDAY('now') - JULIANDAY(COLUMN_AGG_MPA_RAT_DATE) <= CAST(? as INTEGER) UNION ALL SELECT COLUMN_AGG_MPV_RAT_YEAR AS COLUMN_AGG_RAT_YEAR, COLUMN_AGG_MPV_RAT_MONTH AS COLUMN_AGG_RAT_MONTH, COLUMN_AGG_MPV_RAT_DAY AS COLUMN_AGG_RAT_DAY, COLUMN_AGG_MPV_RAT_2G AS COLUMN_AGG_RAT_2G, COLUMN_AGG_MPV_RAT_3G AS COLUMN_AGG_RAT_3G, COLUMN_AGG_MPV_RAT_4G AS COLUMN_AGG_RAT_4G, COLUMN_AGG_MPV_RAT_5G AS COLUMN_AGG_RAT_5G, COLUMN_AGG_MPV_RAT_WIFI AS COLUMN_AGG_RAT_WIFI, COLUMN_AGG_MPV_RAT_UNKNOWN AS COLUMN_AGG_RAT_UNKNOWN FROM AGG_MPV_RAT WHERE JULIANDAY('now') - JULIANDAY(COLUMN_AGG_MPV_RAT_DATE) <= CAST(? as INTEGER)) GROUP BY COLUMN_AGG_RAT_YEAR,COLUMN_AGG_RAT_MONTH,COLUMN_AGG_RAT_DAY ORDER BY " + ("COLUMN_AGG_RAT_YEAR " + sortOrder + ",COLUMN_AGG_RAT_MONTH " + sortOrder + ",COLUMN_AGG_RAT_DAY " + sortOrder), new String[]{i3 + "", i3 + ""});
            while (rawQuery.moveToNext()) {
                RatShareAgg ratShareAgg = new RatShareAgg();
                ratShareAgg.year = rawQuery.getInt(rawQuery.getColumnIndexOrThrow(B1));
                ratShareAgg.month = rawQuery.getInt(rawQuery.getColumnIndexOrThrow(C1));
                ratShareAgg.day = rawQuery.getInt(rawQuery.getColumnIndexOrThrow(D1));
                ratShareAgg.samples2g = (long) rawQuery.getInt(rawQuery.getColumnIndexOrThrow(F1));
                ratShareAgg.samples3g = (long) rawQuery.getInt(rawQuery.getColumnIndexOrThrow(G1));
                ratShareAgg.samples4g = (long) rawQuery.getInt(rawQuery.getColumnIndexOrThrow(H1));
                ratShareAgg.samples5g = (long) rawQuery.getInt(rawQuery.getColumnIndexOrThrow(I1));
                ratShareAgg.samplesWifi = (long) rawQuery.getInt(rawQuery.getColumnIndexOrThrow(J1));
                ratShareAgg.samplesUnknown = (long) rawQuery.getInt(rawQuery.getColumnIndexOrThrow(K1));
                arrayList.add(ratShareAgg);
            }
            rawQuery.close();
            readableDatabase.close();
        } catch (Exception e3) {
            Log.e(d, "getCTSuccessAggForLastDays: " + e3.getMessage());
            return null;
        }
        return (RatShareAgg[]) arrayList.toArray(new RatShareAgg[arrayList.size()]);
    }

    @Deprecated
    public synchronized SpeedTestMetrics getSpeedTestMetrics() {
        SpeedTestMetrics speedTestMetrics;
        long j3;
        speedTestMetrics = new SpeedTestMetrics();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT COLUMN_ST_LT,COLUMN_ST_DL,COLUMN_ST_UL FROM ST", (String[]) null);
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        while (rawQuery.moveToNext()) {
            j5++;
            long j11 = rawQuery.getLong(0);
            if (j11 > 0) {
                j4++;
                j6 += j11;
            }
            long j12 = rawQuery.getLong(1);
            if (j12 > 0) {
                j8++;
                j7 += j12;
            }
            long j13 = rawQuery.getLong(2);
            if (j13 > 0) {
                j3 = j7;
                j10++;
                j9 += j13;
            } else {
                j3 = j7;
                long j14 = j9;
                long j15 = j10;
            }
            j7 = j3;
        }
        long j16 = j7;
        long j17 = j10;
        rawQuery.close();
        readableDatabase.close();
        speedTestMetrics.numberOfSpeedTestExecuted = j5;
        if (j4 > 0) {
            double d3 = (double) j6;
            double d4 = (double) j4;
            Double.isNaN(d3);
            Double.isNaN(d4);
            speedTestMetrics.latencyTestAverageValue = Math.round(d3 / d4);
        }
        if (j8 > 0) {
            double d5 = (double) j16;
            double d6 = (double) j8;
            Double.isNaN(d5);
            Double.isNaN(d6);
            speedTestMetrics.downloadTestAverageValue = Math.round(d5 / d6);
        }
        if (j17 > 0) {
            double d7 = (double) j9;
            double d8 = (double) j17;
            Double.isNaN(d7);
            Double.isNaN(d8);
            speedTestMetrics.uploadTestAverageValue = Math.round(d7 / d8);
        }
        return speedTestMetrics;
    }

    public synchronized TTRDataSpeedAgg[] getTTRDataSpeedAggForLastDays(int i3, SortOrder sortOrder, Granularity granularity) {
        Cursor cursor;
        TTRDataSpeedAgg[] tTRDataSpeedAggArr;
        SortOrder sortOrder2 = sortOrder;
        Granularity granularity2 = granularity;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                String[] strArr = {i3 + ""};
                String str = "COLUMN_AGG_TTR_YEAR " + sortOrder2 + ",COLUMN_AGG_TTR_MONTH " + sortOrder2 + ",COLUMN_AGG_TTR_DAY " + sortOrder2 + ",COLUMN_AGG_TTR_HOUR " + sortOrder2 + ",COLUMN_AGG_TTR_QUARTER " + sortOrder2;
                if (granularity2 == Granularity.DAYS) {
                    cursor = readableDatabase.query(J, n0, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_TTR_DATE) <= CAST(? as INTEGER)", strArr, "COLUMN_AGG_TTR_YEAR,COLUMN_AGG_TTR_MONTH,COLUMN_AGG_TTR_DAY", (String) null, str);
                } else if (granularity2 == Granularity.HOURS) {
                    cursor = readableDatabase.query(J, n0, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_TTR_DATE) <= CAST(? as INTEGER)", strArr, "COLUMN_AGG_TTR_YEAR,COLUMN_AGG_TTR_MONTH,COLUMN_AGG_TTR_DAY,COLUMN_AGG_TTR_HOUR", (String) null, str);
                } else {
                    cursor = readableDatabase.query(J, l0, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_TTR_DATE) <= CAST(? as INTEGER)", strArr, (String) null, (String) null, str);
                }
                while (cursor.moveToNext()) {
                    TTRDataSpeedAgg tTRDataSpeedAgg = new TTRDataSpeedAgg();
                    tTRDataSpeedAgg.year = cursor.getInt(cursor.getColumnIndexOrThrow(L));
                    tTRDataSpeedAgg.month = cursor.getInt(cursor.getColumnIndexOrThrow(M));
                    tTRDataSpeedAgg.day = cursor.getInt(cursor.getColumnIndexOrThrow(N));
                    tTRDataSpeedAgg.maxDataSpeed2G = cursor.getLong(cursor.getColumnIndexOrThrow(R));
                    tTRDataSpeedAgg.maxDataSpeed3G = cursor.getLong(cursor.getColumnIndexOrThrow(S));
                    tTRDataSpeedAgg.maxDataSpeed4G = cursor.getLong(cursor.getColumnIndexOrThrow(T));
                    tTRDataSpeedAgg.maxDataSpeed5G = cursor.getLong(cursor.getColumnIndexOrThrow(U));
                    tTRDataSpeedAgg.maxDataSpeedWifi = cursor.getLong(cursor.getColumnIndexOrThrow(V));
                    if (granularity2 == Granularity.HOURS) {
                        tTRDataSpeedAgg.hour = cursor.getInt(cursor.getColumnIndexOrThrow(O));
                    } else if (granularity2 == Granularity.QUARTERS) {
                        tTRDataSpeedAgg.hour = cursor.getInt(cursor.getColumnIndexOrThrow(O));
                        tTRDataSpeedAgg.quarter = cursor.getInt(cursor.getColumnIndexOrThrow(P));
                    }
                    arrayList.add(tTRDataSpeedAgg);
                }
                cursor.close();
                readableDatabase.close();
                tTRDataSpeedAggArr = (TTRDataSpeedAgg[]) arrayList.toArray(new TTRDataSpeedAgg[arrayList.size()]);
            } catch (Exception e3) {
                Log.e(d, "getTTRDataSpeedAggForLastDays: " + e3.getMessage());
                return null;
            }
        }
        return tTRDataSpeedAggArr;
    }

    public synchronized TTRDataSpeedLocationAgg[] getTTRDataSpeedLocationAggForLastDays(int i3, SortOrder sortOrder) {
        SortOrder sortOrder2 = sortOrder;
        synchronized (this) {
            TreeMap treeMap = new TreeMap();
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                Cursor query = readableDatabase.query(J, m0, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_TTR_DATE) <= CAST(? as INTEGER)", new String[]{i3 + ""}, (String) null, (String) null, "COLUMN_AGG_TTR_YEAR " + sortOrder2 + ",COLUMN_AGG_TTR_MONTH " + sortOrder2 + ",COLUMN_AGG_TTR_DAY " + sortOrder2 + ",COLUMN_AGG_TTR_HOUR " + sortOrder2 + ",COLUMN_AGG_TTR_QUARTER " + sortOrder2);
                while (query.moveToNext()) {
                    TTRDataSpeedLocationAgg tTRDataSpeedLocationAgg = new TTRDataSpeedLocationAgg();
                    tTRDataSpeedLocationAgg.year = query.getInt(query.getColumnIndexOrThrow(L));
                    tTRDataSpeedLocationAgg.month = query.getInt(query.getColumnIndexOrThrow(M));
                    tTRDataSpeedLocationAgg.day = query.getInt(query.getColumnIndexOrThrow(N));
                    tTRDataSpeedLocationAgg.maxDataSpeed2G = query.getLong(query.getColumnIndexOrThrow(R));
                    tTRDataSpeedLocationAgg.maxDataSpeed3G = query.getLong(query.getColumnIndexOrThrow(S));
                    tTRDataSpeedLocationAgg.maxDataSpeed4G = query.getLong(query.getColumnIndexOrThrow(T));
                    tTRDataSpeedLocationAgg.maxDataSpeed5G = query.getLong(query.getColumnIndexOrThrow(U));
                    tTRDataSpeedLocationAgg.maxDataSpeedWifi = query.getLong(query.getColumnIndexOrThrow(V));
                    tTRDataSpeedLocationAgg.RvMobile2gLat = query.getDouble(query.getColumnIndexOrThrow(a0));
                    tTRDataSpeedLocationAgg.RvMobile2gLong = query.getDouble(query.getColumnIndexOrThrow(b0));
                    tTRDataSpeedLocationAgg.RvMobile3gLat = query.getDouble(query.getColumnIndexOrThrow(c0));
                    tTRDataSpeedLocationAgg.RvMobile3gLong = query.getDouble(query.getColumnIndexOrThrow(d0));
                    tTRDataSpeedLocationAgg.RvMobile4gLat = query.getDouble(query.getColumnIndexOrThrow(e0));
                    tTRDataSpeedLocationAgg.RvMobile4gLong = query.getDouble(query.getColumnIndexOrThrow(f0));
                    tTRDataSpeedLocationAgg.RvMobile5gLat = query.getDouble(query.getColumnIndexOrThrow(g0));
                    tTRDataSpeedLocationAgg.RvMobile5gLong = query.getDouble(query.getColumnIndexOrThrow(h0));
                    tTRDataSpeedLocationAgg.RvWifiLat = query.getDouble(query.getColumnIndexOrThrow(i0));
                    tTRDataSpeedLocationAgg.RvWifiLong = query.getDouble(query.getColumnIndexOrThrow(j0));
                    String string = query.getString(query.getColumnIndexOrThrow(Q));
                    if (treeMap.containsKey(string)) {
                        TTRDataSpeedLocationAgg tTRDataSpeedLocationAgg2 = (TTRDataSpeedLocationAgg) treeMap.get(string);
                        long j3 = tTRDataSpeedLocationAgg.maxDataSpeed2G;
                        if (j3 > tTRDataSpeedLocationAgg2.maxDataSpeed2G) {
                            tTRDataSpeedLocationAgg2.maxDataSpeed2G = j3;
                            tTRDataSpeedLocationAgg2.RvMobile2gLat = tTRDataSpeedLocationAgg.RvMobile2gLat;
                            tTRDataSpeedLocationAgg2.RvMobile2gLong = tTRDataSpeedLocationAgg.RvMobile2gLong;
                        }
                        long j4 = tTRDataSpeedLocationAgg.maxDataSpeed3G;
                        if (j4 > tTRDataSpeedLocationAgg2.maxDataSpeed3G) {
                            tTRDataSpeedLocationAgg2.maxDataSpeed3G = j4;
                            tTRDataSpeedLocationAgg2.RvMobile3gLat = tTRDataSpeedLocationAgg.RvMobile3gLat;
                            tTRDataSpeedLocationAgg2.RvMobile3gLong = tTRDataSpeedLocationAgg.RvMobile3gLong;
                        }
                        long j5 = tTRDataSpeedLocationAgg.maxDataSpeed4G;
                        if (j5 > tTRDataSpeedLocationAgg2.maxDataSpeed4G) {
                            tTRDataSpeedLocationAgg2.maxDataSpeed4G = j5;
                            tTRDataSpeedLocationAgg2.RvMobile4gLat = tTRDataSpeedLocationAgg.RvMobile4gLat;
                            tTRDataSpeedLocationAgg2.RvMobile4gLong = tTRDataSpeedLocationAgg.RvMobile4gLong;
                        }
                        long j6 = tTRDataSpeedLocationAgg.maxDataSpeed5G;
                        if (j6 > tTRDataSpeedLocationAgg2.maxDataSpeed5G) {
                            tTRDataSpeedLocationAgg2.maxDataSpeed5G = j6;
                            tTRDataSpeedLocationAgg2.RvMobile5gLat = tTRDataSpeedLocationAgg.RvMobile5gLat;
                            tTRDataSpeedLocationAgg2.RvMobile5gLong = tTRDataSpeedLocationAgg.RvMobile5gLong;
                        }
                        long j7 = tTRDataSpeedLocationAgg.maxDataSpeedWifi;
                        if (j7 > tTRDataSpeedLocationAgg2.maxDataSpeedWifi) {
                            tTRDataSpeedLocationAgg2.maxDataSpeedWifi = j7;
                            tTRDataSpeedLocationAgg2.RvWifiLat = tTRDataSpeedLocationAgg.RvWifiLat;
                            tTRDataSpeedLocationAgg2.RvWifiLong = tTRDataSpeedLocationAgg.RvWifiLong;
                        }
                    } else {
                        treeMap.put(string, tTRDataSpeedLocationAgg);
                    }
                }
                query.close();
                readableDatabase.close();
                if (sortOrder2 == SortOrder.DESC) {
                    TTRDataSpeedLocationAgg[] tTRDataSpeedLocationAggArr = (TTRDataSpeedLocationAgg[]) treeMap.descendingMap().values().toArray(new TTRDataSpeedLocationAgg[treeMap.values().size()]);
                    return tTRDataSpeedLocationAggArr;
                }
                TTRDataSpeedLocationAgg[] tTRDataSpeedLocationAggArr2 = (TTRDataSpeedLocationAgg[]) treeMap.values().toArray(new TTRDataSpeedLocationAgg[treeMap.values().size()]);
                return tTRDataSpeedLocationAggArr2;
            } catch (Exception e3) {
                Log.e(d, "getTTRDataSpeedLocationAggForLastDays: " + e3.getMessage());
                return null;
            }
        }
    }

    public synchronized TTRDataTrafficAgg[] getTTRDataTrafficAggForLastDays(int i3, SortOrder sortOrder) {
        TTRDataTrafficAgg[] tTRDataTrafficAggArr;
        SortOrder sortOrder2 = sortOrder;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                Cursor query = readableDatabase.query(J, o0, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_TTR_DATE) <= CAST(? as INTEGER)", new String[]{i3 + ""}, "COLUMN_AGG_TTR_YEAR,COLUMN_AGG_TTR_MONTH,COLUMN_AGG_TTR_DAY", (String) null, "COLUMN_AGG_TTR_YEAR " + sortOrder2 + ",COLUMN_AGG_TTR_MONTH " + sortOrder2 + ",COLUMN_AGG_TTR_DAY " + sortOrder2 + ",COLUMN_AGG_TTR_HOUR " + sortOrder2 + ",COLUMN_AGG_TTR_QUARTER " + sortOrder2);
                while (query.moveToNext()) {
                    TTRDataTrafficAgg tTRDataTrafficAgg = new TTRDataTrafficAgg();
                    tTRDataTrafficAgg.year = query.getInt(query.getColumnIndexOrThrow(L));
                    tTRDataTrafficAgg.month = query.getInt(query.getColumnIndexOrThrow(M));
                    tTRDataTrafficAgg.day = query.getInt(query.getColumnIndexOrThrow(N));
                    tTRDataTrafficAgg.trafficRxMobile = query.getLong(query.getColumnIndexOrThrow(Y));
                    tTRDataTrafficAgg.trafficTxMobile = query.getLong(query.getColumnIndexOrThrow(Z));
                    tTRDataTrafficAgg.trafficRxWifi = query.getLong(query.getColumnIndexOrThrow(W));
                    tTRDataTrafficAgg.trafficTxWifi = query.getLong(query.getColumnIndexOrThrow(X));
                    arrayList.add(tTRDataTrafficAgg);
                }
                query.close();
                readableDatabase.close();
                tTRDataTrafficAggArr = (TTRDataTrafficAgg[]) arrayList.toArray(new TTRDataTrafficAgg[arrayList.size()]);
            } catch (Exception e3) {
                Log.e(d, "getTTRDataTrafficAggForLastDays: " + e3.getMessage());
                return null;
            }
        }
        return tTRDataTrafficAggArr;
    }

    public VcDropAgg[] getVcDropAggForLastDays(int i3, SortOrder sortOrder) {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String[] strArr = {i3 + ""};
            SQLiteDatabase sQLiteDatabase = readableDatabase;
            Cursor query = sQLiteDatabase.query(z2, O2, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_VC_DROP_DATE) <= CAST(? as INTEGER)", strArr, (String) null, (String) null, "COLUMN_AGG_VC_DROP_YEAR " + sortOrder + ",COLUMN_AGG_VC_DROP_MONTH " + sortOrder + ",COLUMN_AGG_VC_DROP_DAY " + sortOrder);
            while (query.moveToNext()) {
                VcDropAgg vcDropAgg = new VcDropAgg();
                vcDropAgg.year = query.getInt(query.getColumnIndexOrThrow(B2));
                vcDropAgg.month = query.getInt(query.getColumnIndexOrThrow(C2));
                vcDropAgg.day = query.getInt(query.getColumnIndexOrThrow(D2));
                vcDropAgg.voiceCalls2g = query.getInt(query.getColumnIndexOrThrow(F2));
                vcDropAgg.voiceCalls3g = query.getInt(query.getColumnIndexOrThrow(G2));
                vcDropAgg.voiceCalls4g = query.getInt(query.getColumnIndexOrThrow(H2));
                vcDropAgg.voiceCalls5g = query.getInt(query.getColumnIndexOrThrow(I2));
                vcDropAgg.drops2g = query.getInt(query.getColumnIndexOrThrow(J2));
                vcDropAgg.drops3g = query.getInt(query.getColumnIndexOrThrow(K2));
                vcDropAgg.drops4g = query.getInt(query.getColumnIndexOrThrow(L2));
                vcDropAgg.drops5g = query.getInt(query.getColumnIndexOrThrow(M2));
                arrayList.add(vcDropAgg);
            }
            query.close();
            readableDatabase.close();
            return (VcDropAgg[]) arrayList.toArray(new VcDropAgg[arrayList.size()]);
        } catch (Exception e3) {
            String str = d;
            Log.e(str, "getVcDropAggForLastDays: " + e3.getMessage());
            return null;
        }
    }

    @Deprecated
    public synchronized VoiceCallMetrics getVoiceCallMetrics() {
        VoiceCallMetrics voiceCallMetrics;
        voiceCallMetrics = new VoiceCallMetrics();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT COLUMN_VC_CALL_DIRECTION,COLUMN_VC_CALL_SETUP_TIME,COLUMN_VC_CALL_DURATION,COLUMN_VC_CALL_DROPPED FROM VC", (String[]) null);
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (rawQuery.moveToNext()) {
            String string = rawQuery.getString(0);
            long j6 = rawQuery.getLong(1);
            long j7 = rawQuery.getLong(2);
            boolean z3 = rawQuery.getInt(3) == 1;
            if (j7 != 0) {
                if (z3) {
                    j5++;
                }
                j3 += j7;
                if (string.equals(r0.MOC.toString())) {
                    voiceCallMetrics.numberOfCallsMOC++;
                    j4 += j6;
                } else {
                    voiceCallMetrics.numberOfCallsMTC++;
                }
            }
        }
        rawQuery.close();
        readableDatabase.close();
        long j8 = (long) (voiceCallMetrics.numberOfCallsMOC + voiceCallMetrics.numberOfCallsMTC);
        if (j8 > 0) {
            double d3 = (double) j3;
            double d4 = (double) j8;
            Double.isNaN(d3);
            Double.isNaN(d4);
            voiceCallMetrics.averageCallDuration = Math.round(d3 / d4);
        }
        int i3 = voiceCallMetrics.numberOfCallsMOC;
        if (i3 > 0) {
            double d5 = (double) j4;
            double d6 = (double) i3;
            Double.isNaN(d5);
            Double.isNaN(d6);
            voiceCallMetrics.averageCallSetupTime = (int) Math.round(d5 / d6);
        }
        if (j5 > 0) {
            double d7 = (double) j5;
            double d8 = (double) j8;
            Double.isNaN(d7);
            Double.isNaN(d8);
            voiceCallMetrics.percentageOfDrops = (d7 / d8) * 100.0d;
        }
        return voiceCallMetrics;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(l);
        sQLiteDatabase.execSQL(m);
        sQLiteDatabase.execSQL(q);
        sQLiteDatabase.execSQL(r);
        sQLiteDatabase.execSQL(u);
        sQLiteDatabase.execSQL(v);
        sQLiteDatabase.execSQL(B);
        sQLiteDatabase.execSQL(I);
        sQLiteDatabase.execSQL(k0);
        sQLiteDatabase.execSQL(F0);
        sQLiteDatabase.execSQL(k1);
        sQLiteDatabase.execSQL(y1);
        sQLiteDatabase.execSQL(N2);
        sQLiteDatabase.execSQL(d2);
        sQLiteDatabase.execSQL(a3);
        sQLiteDatabase.execSQL(W0);
        sQLiteDatabase.execSQL(x2);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        if (i3 < 4) {
            sQLiteDatabase.execSQL(k0);
            sQLiteDatabase.execSQL(F0);
            sQLiteDatabase.execSQL(k1);
            sQLiteDatabase.execSQL(N2);
        }
        if (i3 == 4) {
            sQLiteDatabase.execSQL("ALTER TABLE AGG_CT ADD COLUMN COLUMN_AGG_CT_WIFI_MIN_LATENCY INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_CT ADD COLUMN COLUMN_AGG_CT_MOBILE_MIN_LATENCY INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_CT ADD COLUMN COLUMN_AGG_CT_MOBILE_MIN_LATENCY_2G INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_CT ADD COLUMN COLUMN_AGG_CT_MOBILE_MIN_LATENCY_3G INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_CT ADD COLUMN COLUMN_AGG_CT_MOBILE_MIN_LATENCY_4G INTEGER DEFAULT 0");
        }
        if (i3 == 5) {
            sQLiteDatabase.execSQL("ALTER TABLE AGG_CT ADD COLUMN COLUMN_AGG_CT_MOBILE_MIN_LATENCY_2G INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_CT ADD COLUMN COLUMN_AGG_CT_MOBILE_MIN_LATENCY_3G INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_CT ADD COLUMN COLUMN_AGG_CT_MOBILE_MIN_LATENCY_4G INTEGER DEFAULT 0");
        }
        if (i3 < 7) {
            sQLiteDatabase.execSQL(d2);
        }
        if (i3 >= 4 && i3 < 8) {
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_HOUR INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_QUARTER INTEGER DEFAULT 0");
        }
        if (i3 < 9) {
            sQLiteDatabase.execSQL(y1);
        }
        if (i3 < 10) {
            sQLiteDatabase.execSQL(a3);
        }
        if (i3 >= 4 && i3 < 11) {
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_TRAFFIC_TX_MOBILE INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_TRAFFIC_RX_MOBILE INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_TRAFFIC_TX_WIFI INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_TRAFFIC_RX_WIFI INTEGER DEFAULT 0");
        }
        if (i3 >= 10 && i3 < 12) {
            sQLiteDatabase.execSQL("ALTER TABLE TABLE_AGG_AUS_FREQUENCY ADD COLUMN COLUMN_AGG_AUS_FREQUENCY_TRAFFIC_RX INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE TABLE_AGG_AUS_FREQUENCY ADD COLUMN COLUMN_AGG_AUS_FREQUENCY_TRAFFIC_TX INTEGER DEFAULT 0");
        }
        if (i3 >= 4 && i3 < 13) {
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_LAT_2G REAL DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_LONG_2G REAL DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_LAT_3G REAL DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_LONG_3G REAL DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_LAT_4G REAL DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_LONG_4G REAL DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_LAT_WIFI REAL DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_LONG_WIFI REAL DEFAULT 0");
        }
        if (i3 < 14) {
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_MAX_5G INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_LAT_5G REAL DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_TTR ADD COLUMN COLUMN_AGG_TTR_LONG_5G REAL DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_CT ADD COLUMN COLUMN_AGG_CT_MOBILE_MIN_LATENCY_5G INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_MPA_RAT ADD COLUMN COLUMN_AGG_MPA_RAT_5G INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_MPV_RAT ADD COLUMN COLUMN_AGG_MPV_RAT_5G INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_VC_DROP ADD COLUMN COLUMN_AGG_VC_DROP_CALLS_5G INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE AGG_VC_DROP ADD COLUMN COLUMN_AGG_VC_DROP_DROPS_5G INTEGER DEFAULT 0");
        }
        if (i3 > 14 && i4 <= 16) {
            try {
                Cursor query = sQLiteDatabase.query(H0, new String[]{Q0}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
                if (query.moveToFirst()) {
                    query.getString(query.getColumnIndexOrThrow(Q0));
                }
                query.close();
            } catch (Exception unused) {
                sQLiteDatabase.delete(H0, (String) null, (String[]) null);
                sQLiteDatabase.delete(f2, (String) null, (String[]) null);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS LOC_CT");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS TABLE_LOCATION_MPA_SIGNALSTRENGTH_SHARE");
                sQLiteDatabase.execSQL(W0);
                sQLiteDatabase.execSQL(x2);
            }
        }
    }

    public synchronized void wipeAllData() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete(J, (String) null, (String[]) null);
            writableDatabase.delete(p0, (String) null, (String[]) null);
            writableDatabase.delete(Y0, (String) null, (String[]) null);
            writableDatabase.delete(m1, (String) null, (String[]) null);
            writableDatabase.delete(L1, (String) null, (String[]) null);
            writableDatabase.delete(z2, (String) null, (String[]) null);
            writableDatabase.delete(P2, (String) null, (String[]) null);
            writableDatabase.delete(H0, (String) null, (String[]) null);
            writableDatabase.delete(f2, (String) null, (String[]) null);
            writableDatabase.close();
        } catch (Exception e3) {
            String str = d;
            Log.e(str, "wipeData: " + e3.getMessage());
        }
        return;
    }

    public synchronized void wipeAusFrequency() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete(P2, (String) null, (String[]) null);
            writableDatabase.close();
        } catch (Exception e3) {
            String str = d;
            Log.e(str, "wipeAusFrequency: " + e3.getMessage());
        }
        return;
    }

    public synchronized void b(RVR rvr) {
        int i3;
        if (rvr != null) {
            s0 s0Var = rvr.CallEndType;
            if (!(s0Var == s0.Dropped || s0Var == s0.DroppedInWindow || s0Var == s0.DroppedSamsung)) {
                if (s0Var != s0.DroppedSamsungIms) {
                    i3 = 0;
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    StringBuilder sb = new StringBuilder("INSERT INTO VC ( COLUMN_VC_CALL_DIRECTION,COLUMN_VC_CALL_SETUP_TIME,COLUMN_VC_CALL_DURATION,COLUMN_VC_CALL_DROPPED) VALUES (");
                    sb.append("'" + rvr.CallDirection + "'");
                    StringBuilder sb2 = new StringBuilder(",");
                    sb2.append(rvr.CallSetupTime);
                    sb.append(sb2.toString());
                    sb.append("," + rvr.CallDuration);
                    sb.append("," + i3);
                    sb.append(")");
                    writableDatabase.execSQL(sb.toString());
                    writableDatabase.close();
                }
            }
            i3 = 1;
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            StringBuilder sb3 = new StringBuilder("INSERT INTO VC ( COLUMN_VC_CALL_DIRECTION,COLUMN_VC_CALL_SETUP_TIME,COLUMN_VC_CALL_DURATION,COLUMN_VC_CALL_DROPPED) VALUES (");
            sb3.append("'" + rvr.CallDirection + "'");
            StringBuilder sb22 = new StringBuilder(",");
            sb22.append(rvr.CallSetupTime);
            sb3.append(sb22.toString());
            sb3.append("," + rvr.CallDuration);
            sb3.append("," + i3);
            sb3.append(")");
            writableDatabase2.execSQL(sb3.toString());
            writableDatabase2.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x009b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(com.umlaut.crowd.internal.g1 r10) {
        /*
            r9 = this;
            java.lang.String r0 = ", COLUMN_CT_TESTS_SUCCESS_MOBILE=COLUMN_CT_TESTS_SUCCESS_MOBILE+"
            java.lang.String r1 = ", COLUMN_CT_TESTS_SUCCESS_WIFI=COLUMN_CT_TESTS_SUCCESS_WIFI+"
            monitor-enter(r9)
            if (r10 != 0) goto L_0x0009
            monitor-exit(r9)
            return
        L_0x0009:
            com.umlaut.crowd.internal.DRI r2 = r10.RadioInfo     // Catch:{ all -> 0x009c }
            com.umlaut.crowd.enums.ConnectionTypes r3 = r2.ConnectionType     // Catch:{ all -> 0x009c }
            com.umlaut.crowd.enums.ConnectionTypes r4 = com.umlaut.crowd.enums.ConnectionTypes.WiFi     // Catch:{ all -> 0x009c }
            r5 = 1
            r6 = 0
            if (r3 == r4) goto L_0x0015
            r4 = 1
            goto L_0x0016
        L_0x0015:
            r4 = 0
        L_0x0016:
            com.umlaut.crowd.enums.ConnectionTypes r7 = com.umlaut.crowd.enums.ConnectionTypes.Mobile     // Catch:{ all -> 0x009c }
            if (r3 == r7) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r5 = 0
        L_0x001c:
            r3 = r4 & r5
            if (r3 == 0) goto L_0x0022
            monitor-exit(r9)
            return
        L_0x0022:
            boolean r3 = r10.LocalhostPingSuccess     // Catch:{ all -> 0x009c }
            if (r3 != 0) goto L_0x0028
            monitor-exit(r9)
            return
        L_0x0028:
            long r3 = r10.DurationOverall     // Catch:{ all -> 0x009c }
            long r5 = r10.DurationOverallNoSleep     // Catch:{ all -> 0x009c }
            long r3 = r3 - r5
            r5 = 3
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x009a
            r5 = -3
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 >= 0) goto L_0x003a
            goto L_0x009a
        L_0x003a:
            boolean r3 = r2.MissingPermission     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x0040
            monitor-exit(r9)
            return
        L_0x0040:
            com.umlaut.crowd.internal.g9 r2 = r2.ServiceState     // Catch:{ all -> 0x009c }
            com.umlaut.crowd.internal.g9 r3 = com.umlaut.crowd.internal.g9.PowerOff     // Catch:{ all -> 0x009c }
            if (r2 != r3) goto L_0x0048
            monitor-exit(r9)
            return
        L_0x0048:
            com.umlaut.crowd.internal.a2 r2 = r10.DeviceInfo     // Catch:{ all -> 0x009c }
            com.umlaut.crowd.enums.ThreeState r2 = r2.PowerSaveMode     // Catch:{ all -> 0x009c }
            com.umlaut.crowd.enums.ThreeState r3 = com.umlaut.crowd.enums.ThreeState.Enabled     // Catch:{ all -> 0x009c }
            if (r2 != r3) goto L_0x0052
            monitor-exit(r9)
            return
        L_0x0052:
            android.database.sqlite.SQLiteDatabase r2 = r9.getWritableDatabase()     // Catch:{ all -> 0x009c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x009c }
            java.lang.String r4 = "UPDATE CT SET "
            r3.<init>(r4)     // Catch:{ all -> 0x009c }
            com.umlaut.crowd.internal.DRI r4 = r10.RadioInfo     // Catch:{ all -> 0x009c }
            com.umlaut.crowd.enums.ConnectionTypes r4 = r4.ConnectionType     // Catch:{ all -> 0x009c }
            if (r4 != r7) goto L_0x0079
            java.lang.String r1 = "COLUMN_CT_NUMBER_OF_TESTS_MOBILE=COLUMN_CT_NUMBER_OF_TESTS_MOBILE+1"
            r3.append(r1)     // Catch:{ all -> 0x009c }
            boolean r10 = r10.Success     // Catch:{ all -> 0x009c }
            if (r10 == 0) goto L_0x006f
            java.lang.String r10 = "1"
            goto L_0x0071
        L_0x006f:
            java.lang.String r10 = "0"
        L_0x0071:
            java.lang.String r10 = r0.concat(r10)     // Catch:{ all -> 0x009c }
            r3.append(r10)     // Catch:{ all -> 0x009c }
            goto L_0x008e
        L_0x0079:
            java.lang.String r0 = "COLUMN_CT_NUMBER_OF_TESTS_WIFI=COLUMN_CT_NUMBER_OF_TESTS_WIFI+1"
            r3.append(r0)     // Catch:{ all -> 0x009c }
            boolean r10 = r10.Success     // Catch:{ all -> 0x009c }
            if (r10 == 0) goto L_0x0085
            java.lang.String r10 = "1"
            goto L_0x0087
        L_0x0085:
            java.lang.String r10 = "0"
        L_0x0087:
            java.lang.String r10 = r1.concat(r10)     // Catch:{ all -> 0x009c }
            r3.append(r10)     // Catch:{ all -> 0x009c }
        L_0x008e:
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x009c }
            r2.execSQL(r10)     // Catch:{ all -> 0x009c }
            r2.close()     // Catch:{ all -> 0x009c }
            monitor-exit(r9)
            return
        L_0x009a:
            monitor-exit(r9)
            return
        L_0x009c:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.database.StatsDatabase.b(com.umlaut.crowd.internal.g1):void");
    }

    public synchronized void a(ub ubVar, int i3, int i4, int i5, int i6, int i7, int i8) {
        ub ubVar2 = ubVar;
        synchronized (this) {
            int i9 = i3 < 0 ? 0 : i3;
            int i10 = i4 < 0 ? 0 : i4;
            int i11 = i5 < 0 ? 0 : i5;
            int i12 = i6 < 0 ? 0 : i6;
            int i13 = i7 < 0 ? 0 : i7;
            int i14 = i8 < 0 ? 0 : i8;
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                SQLiteDatabase sQLiteDatabase = writableDatabase;
                sQLiteDatabase.delete(Y0, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_MPA_RAT_DATE) > CAST(? as INTEGER)", new String[]{"" + this.a});
                String[] strArr = {ubVar2.year + "", ubVar2.month + "", ubVar2.day + ""};
                boolean z3 = true;
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase.query(Y0, l1, "COLUMN_AGG_MPA_RAT_YEAR=? AND COLUMN_AGG_MPA_RAT_MONTH=? AND COLUMN_AGG_MPA_RAT_DAY=?", strArr, (String) null, (String) null, (String) null);
                if (query.moveToFirst()) {
                    i9 += query.getInt(query.getColumnIndexOrThrow(e1));
                    i10 += query.getInt(query.getColumnIndexOrThrow(f1));
                    i11 += query.getInt(query.getColumnIndexOrThrow(g1));
                    i12 += query.getInt(query.getColumnIndexOrThrow(h1));
                    i13 += query.getInt(query.getColumnIndexOrThrow(i1));
                    i14 += query.getInt(query.getColumnIndexOrThrow(j1));
                    z3 = false;
                }
                query.close();
                if (z3) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e1, Integer.valueOf(i9));
                    contentValues.put(f1, Integer.valueOf(i10));
                    contentValues.put(g1, Integer.valueOf(i11));
                    contentValues.put(h1, Integer.valueOf(i12));
                    contentValues.put(i1, Integer.valueOf(i13));
                    contentValues.put(j1, Integer.valueOf(i14));
                    contentValues.put(a1, Integer.valueOf(ubVar2.year));
                    contentValues.put(b1, Integer.valueOf(ubVar2.month));
                    contentValues.put(c1, Integer.valueOf(ubVar2.day));
                    contentValues.put(d1, DateUtils.formatLumenDate(ubVar2.year, ubVar2.month, ubVar2.day));
                    sQLiteDatabase2.insert(Y0, (String) null, contentValues);
                } else {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put(e1, Integer.valueOf(i9));
                    contentValues2.put(f1, Integer.valueOf(i10));
                    contentValues2.put(g1, Integer.valueOf(i11));
                    contentValues2.put(h1, Integer.valueOf(i12));
                    contentValues2.put(i1, Integer.valueOf(i13));
                    contentValues2.put(j1, Integer.valueOf(i14));
                    sQLiteDatabase2.update(Y0, contentValues2, "COLUMN_AGG_MPA_RAT_YEAR=? AND COLUMN_AGG_MPA_RAT_MONTH=? AND COLUMN_AGG_MPA_RAT_DAY=?", strArr);
                }
                sQLiteDatabase2.close();
            } catch (Exception e3) {
                String str = d;
                Log.e(str, "addMpaRatShare: " + e3.getMessage());
            }
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x022e, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x014c A[Catch:{ Exception -> 0x0231 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0177 A[Catch:{ Exception -> 0x0231 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0208 A[Catch:{ Exception -> 0x0231 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x021d A[Catch:{ Exception -> 0x0231 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.umlaut.crowd.internal.ub r30, java.util.List<com.umlaut.crowd.database.metrics.SignalStrengthLocationShare> r31) {
        /*
            r29 = this;
            r1 = r29
            r0 = r30
            java.lang.String r2 = ""
            monitor-enter(r29)
            android.database.sqlite.SQLiteDatabase r11 = r29.getWritableDatabase()     // Catch:{ Exception -> 0x0231 }
            if (r31 == 0) goto L_0x022d
            int r3 = r31.size()     // Catch:{ Exception -> 0x0231 }
            if (r3 != 0) goto L_0x0015
            goto L_0x022d
        L_0x0015:
            java.lang.String r3 = "JULIANDAY('now') - JULIANDAY(COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_DATE) > CAST(? as INTEGER)"
            r12 = 1
            java.lang.String[] r4 = new java.lang.String[r12]     // Catch:{ Exception -> 0x0231 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0231 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0231 }
            long r6 = r1.a     // Catch:{ Exception -> 0x0231 }
            r5.append(r6)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x0231 }
            r13 = 0
            r4[r13] = r2     // Catch:{ Exception -> 0x0231 }
            java.lang.String r2 = "TABLE_LOCATION_MPA_SIGNALSTRENGTH_SHARE"
            r11.delete(r2, r3, r4)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_TECHNOLOGY=? AND COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_TECHNOLOGY_ID=?"
            java.util.Iterator r14 = r31.iterator()     // Catch:{ Exception -> 0x0231 }
        L_0x0036:
            boolean r3 = r14.hasNext()     // Catch:{ Exception -> 0x0231 }
            if (r3 == 0) goto L_0x0229
            java.lang.Object r3 = r14.next()     // Catch:{ Exception -> 0x0231 }
            r15 = r3
            com.umlaut.crowd.database.metrics.SignalStrengthLocationShare r15 = (com.umlaut.crowd.database.metrics.SignalStrengthLocationShare) r15     // Catch:{ Exception -> 0x0231 }
            if (r15 == 0) goto L_0x0036
            double r3 = r15.longitude     // Catch:{ Exception -> 0x0231 }
            r16 = 0
            int r5 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r5 != 0) goto L_0x0054
            double r3 = r15.latitude     // Catch:{ Exception -> 0x0231 }
            int r5 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r5 != 0) goto L_0x0054
            goto L_0x0036
        L_0x0054:
            r3 = 2
            java.lang.String[] r10 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0231 }
            java.lang.String r3 = r15.technology     // Catch:{ Exception -> 0x0231 }
            r10[r13] = r3     // Catch:{ Exception -> 0x0231 }
            java.lang.String r3 = r15.technologyId     // Catch:{ Exception -> 0x0231 }
            r10[r12] = r3     // Catch:{ Exception -> 0x0231 }
            int r9 = r15.unknown     // Catch:{ Exception -> 0x0231 }
            int r8 = r15.excellent     // Catch:{ Exception -> 0x0231 }
            int r7 = r15.good     // Catch:{ Exception -> 0x0231 }
            int r6 = r15.fair     // Catch:{ Exception -> 0x0231 }
            int r5 = r15.poor     // Catch:{ Exception -> 0x0231 }
            int r4 = r15.bad     // Catch:{ Exception -> 0x0231 }
            java.lang.String r18 = ""
            java.lang.String r19 = "TABLE_LOCATION_MPA_SIGNALSTRENGTH_SHARE"
            java.lang.String[] r20 = y2     // Catch:{ Exception -> 0x0231 }
            r21 = 0
            r22 = 0
            r23 = 0
            r3 = r11
            r24 = r4
            r4 = r19
            r19 = r5
            r5 = r20
            r20 = r6
            r6 = r2
            r25 = r7
            r7 = r10
            r26 = r8
            r8 = r21
            r21 = r9
            r9 = r22
            r12 = r10
            r10 = r23
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0231 }
            boolean r4 = r3.moveToFirst()     // Catch:{ Exception -> 0x0231 }
            if (r4 == 0) goto L_0x0114
            java.lang.String r4 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_UNKNOWN"
            int r4 = r3.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0231 }
            int r4 = r3.getInt(r4)     // Catch:{ Exception -> 0x0231 }
            int r9 = r21 + r4
            java.lang.String r4 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_EXCELLENT"
            int r4 = r3.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0231 }
            int r4 = r3.getInt(r4)     // Catch:{ Exception -> 0x0231 }
            int r8 = r26 + r4
            java.lang.String r4 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_GOOD"
            int r4 = r3.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0231 }
            int r4 = r3.getInt(r4)     // Catch:{ Exception -> 0x0231 }
            int r7 = r25 + r4
            java.lang.String r4 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_FAIR"
            int r4 = r3.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0231 }
            int r4 = r3.getInt(r4)     // Catch:{ Exception -> 0x0231 }
            int r6 = r20 + r4
            java.lang.String r4 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_POOR"
            int r4 = r3.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0231 }
            int r4 = r3.getInt(r4)     // Catch:{ Exception -> 0x0231 }
            int r5 = r19 + r4
            java.lang.String r4 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_BAD"
            int r4 = r3.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0231 }
            int r4 = r3.getInt(r4)     // Catch:{ Exception -> 0x0231 }
            int r4 = r24 + r4
            java.lang.String r10 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_ACCURACY"
            int r10 = r3.getColumnIndexOrThrow(r10)     // Catch:{ Exception -> 0x0231 }
            int r10 = r3.getInt(r10)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r13 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_LAT"
            int r13 = r3.getColumnIndexOrThrow(r13)     // Catch:{ Exception -> 0x0231 }
            double r16 = r3.getDouble(r13)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r13 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_LNG"
            int r13 = r3.getColumnIndexOrThrow(r13)     // Catch:{ Exception -> 0x0231 }
            double r18 = r3.getDouble(r13)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r13 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_TECHNOLOGY_TYPE"
            int r13 = r3.getColumnIndexOrThrow(r13)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r13 = r3.getString(r13)     // Catch:{ Exception -> 0x0231 }
            r20 = 0
            r27 = r16
            r16 = r18
            r18 = r27
            goto L_0x0129
        L_0x0114:
            r10 = 2147483647(0x7fffffff, float:NaN)
            r13 = r18
            r5 = r19
            r6 = r20
            r9 = r21
            r4 = r24
            r7 = r25
            r8 = r26
            r20 = 1
            r18 = r16
        L_0x0129:
            r3.close()     // Catch:{ Exception -> 0x0231 }
            if (r20 != 0) goto L_0x0139
            int r3 = r15.accuracy     // Catch:{ Exception -> 0x0231 }
            if (r3 >= r10) goto L_0x0133
            goto L_0x0139
        L_0x0133:
            r27 = r10
            r10 = r2
            r2 = r27
            goto L_0x014a
        L_0x0139:
            r10 = r2
            double r2 = r15.latitude     // Catch:{ Exception -> 0x0231 }
            r16 = r2
            double r2 = r15.longitude     // Catch:{ Exception -> 0x0231 }
            r18 = r2
            int r2 = r15.accuracy     // Catch:{ Exception -> 0x0231 }
            r27 = r16
            r16 = r18
            r18 = r27
        L_0x014a:
            if (r20 != 0) goto L_0x0177
            java.lang.String r3 = r15.technology     // Catch:{ Exception -> 0x0231 }
            com.umlaut.crowd.enums.NetworkTypes r21 = com.umlaut.crowd.enums.NetworkTypes.WiFi     // Catch:{ Exception -> 0x0231 }
            r31 = r14
            java.lang.String r14 = r21.name()     // Catch:{ Exception -> 0x0231 }
            boolean r3 = r3.equals(r14)     // Catch:{ Exception -> 0x0231 }
            if (r3 == 0) goto L_0x017b
            java.lang.String r3 = r15.technologyType     // Catch:{ Exception -> 0x0231 }
            boolean r3 = r3.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0231 }
            if (r3 != 0) goto L_0x017b
            java.lang.String r3 = r15.technologyType     // Catch:{ Exception -> 0x0231 }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x0231 }
            if (r3 != 0) goto L_0x017b
            java.lang.String r3 = r15.technologyType     // Catch:{ Exception -> 0x0231 }
            java.lang.String r14 = "<unknown ssid>"
            boolean r3 = r3.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0231 }
            if (r3 != 0) goto L_0x017b
            goto L_0x0179
        L_0x0177:
            r31 = r14
        L_0x0179:
            java.lang.String r13 = r15.technologyType     // Catch:{ Exception -> 0x0231 }
        L_0x017b:
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x0231 }
            r3.<init>()     // Catch:{ Exception -> 0x0231 }
            java.lang.String r14 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_UNKNOWN"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0231 }
            r3.put(r14, r9)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r9 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_EXCELLENT"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0231 }
            r3.put(r9, r8)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r8 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_GOOD"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0231 }
            r3.put(r8, r7)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r7 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_FAIR"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0231 }
            r3.put(r7, r6)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r6 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_POOR"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0231 }
            r3.put(r6, r5)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r5 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_BAD"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0231 }
            r3.put(r5, r4)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r4 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_ACCURACY"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0231 }
            r3.put(r4, r2)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_LAT"
            java.lang.Double r4 = java.lang.Double.valueOf(r18)     // Catch:{ Exception -> 0x0231 }
            r3.put(r2, r4)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_LNG"
            java.lang.Double r4 = java.lang.Double.valueOf(r16)     // Catch:{ Exception -> 0x0231 }
            r3.put(r2, r4)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_YEAR"
            int r4 = r0.year     // Catch:{ Exception -> 0x0231 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0231 }
            r3.put(r2, r4)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_MONTH"
            int r4 = r0.month     // Catch:{ Exception -> 0x0231 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0231 }
            r3.put(r2, r4)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_DAY"
            int r4 = r0.day     // Catch:{ Exception -> 0x0231 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0231 }
            r3.put(r2, r4)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_DATE"
            int r4 = r0.year     // Catch:{ Exception -> 0x0231 }
            int r5 = r0.month     // Catch:{ Exception -> 0x0231 }
            int r6 = r0.day     // Catch:{ Exception -> 0x0231 }
            java.lang.String r4 = com.umlaut.crowd.utils.DateUtils.formatLumenDate(r4, r5, r6)     // Catch:{ Exception -> 0x0231 }
            r3.put(r2, r4)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_TECHNOLOGY_TYPE"
            r3.put(r2, r13)     // Catch:{ Exception -> 0x0231 }
            if (r20 == 0) goto L_0x021d
            java.lang.String r2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_TECHNOLOGY"
            java.lang.String r4 = r15.technology     // Catch:{ Exception -> 0x0231 }
            r3.put(r2, r4)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r2 = "COLUMN_LOCATION_MPA_SIGNALSTRENGTH_SHARE_TECHNOLOGY_ID"
            java.lang.String r4 = r15.technologyId     // Catch:{ Exception -> 0x0231 }
            r3.put(r2, r4)     // Catch:{ Exception -> 0x0231 }
            java.lang.String r2 = "TABLE_LOCATION_MPA_SIGNALSTRENGTH_SHARE"
            r4 = 0
            r11.insert(r2, r4, r3)     // Catch:{ Exception -> 0x0231 }
            goto L_0x0222
        L_0x021d:
            java.lang.String r2 = "TABLE_LOCATION_MPA_SIGNALSTRENGTH_SHARE"
            r11.update(r2, r3, r10, r12)     // Catch:{ Exception -> 0x0231 }
        L_0x0222:
            r14 = r31
            r2 = r10
            r12 = 1
            r13 = 0
            goto L_0x0036
        L_0x0229:
            r11.close()     // Catch:{ Exception -> 0x0231 }
            goto L_0x024c
        L_0x022d:
            monitor-exit(r29)
            return
        L_0x022f:
            r0 = move-exception
            goto L_0x024e
        L_0x0231:
            r0 = move-exception
            java.lang.String r2 = d     // Catch:{ all -> 0x022f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x022f }
            r3.<init>()     // Catch:{ all -> 0x022f }
            java.lang.String r4 = "addMpaSignalStrengthShare: "
            r3.append(r4)     // Catch:{ all -> 0x022f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x022f }
            r3.append(r0)     // Catch:{ all -> 0x022f }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x022f }
            android.util.Log.e(r2, r0)     // Catch:{ all -> 0x022f }
        L_0x024c:
            monitor-exit(r29)
            return
        L_0x024e:
            monitor-exit(r29)
            goto L_0x0251
        L_0x0250:
            throw r0
        L_0x0251:
            goto L_0x0250
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.database.StatsDatabase.a(com.umlaut.crowd.internal.ub, java.util.List):void");
    }

    public synchronized void a(ub ubVar, k9 k9Var, k9 k9Var2) {
        ub ubVar2 = ubVar;
        synchronized (this) {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                boolean z3 = true;
                writableDatabase.delete(L1, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_DATE) > CAST(? as INTEGER)", new String[]{"" + this.a});
                String[] strArr = {ubVar2.year + "", ubVar2.month + "", ubVar2.day + ""};
                long samplesUnknown = k9Var2.getSamplesUnknown();
                long samplesExcellent = k9Var2.getSamplesExcellent();
                long samplesGood = k9Var2.getSamplesGood();
                long samplesFair = k9Var2.getSamplesFair();
                long samplesPoor = k9Var2.getSamplesPoor();
                long samplesBad = k9Var2.getSamplesBad();
                long samplesUnknown2 = k9Var.getSamplesUnknown();
                long samplesExcellent2 = k9Var.getSamplesExcellent();
                long samplesGood2 = k9Var.getSamplesGood();
                long samplesFair2 = k9Var.getSamplesFair();
                long samplesPoor2 = k9Var.getSamplesPoor();
                long samplesBad2 = k9Var.getSamplesBad();
                Cursor query = writableDatabase.query(L1, e2, "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_YEAR=? AND COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MONTH=? AND COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_DAY=?", strArr, (String) null, (String) null, (String) null);
                if (query.moveToFirst()) {
                    samplesUnknown += query.getLong(query.getColumnIndexOrThrow(R1));
                    samplesExcellent += query.getLong(query.getColumnIndexOrThrow(S1));
                    samplesGood += query.getLong(query.getColumnIndexOrThrow(T1));
                    samplesFair += query.getLong(query.getColumnIndexOrThrow(U1));
                    samplesPoor += query.getLong(query.getColumnIndexOrThrow(V1));
                    samplesBad += query.getLong(query.getColumnIndexOrThrow(W1));
                    samplesUnknown2 += query.getLong(query.getColumnIndexOrThrow(X1));
                    samplesExcellent2 += query.getLong(query.getColumnIndexOrThrow(Y1));
                    samplesGood2 += query.getLong(query.getColumnIndexOrThrow(Z1));
                    samplesFair2 += query.getLong(query.getColumnIndexOrThrow(a2));
                    samplesPoor2 += query.getLong(query.getColumnIndexOrThrow(b2));
                    samplesBad2 += query.getLong(query.getColumnIndexOrThrow(c2));
                    z3 = false;
                }
                query.close();
                if (z3) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(R1, Long.valueOf(samplesUnknown));
                    contentValues.put(S1, Long.valueOf(samplesExcellent));
                    contentValues.put(T1, Long.valueOf(samplesGood));
                    contentValues.put(U1, Long.valueOf(samplesFair));
                    contentValues.put(V1, Long.valueOf(samplesPoor));
                    contentValues.put(W1, Long.valueOf(samplesBad));
                    contentValues.put(X1, Long.valueOf(samplesUnknown2));
                    contentValues.put(Y1, Long.valueOf(samplesExcellent2));
                    contentValues.put(Z1, Long.valueOf(samplesGood2));
                    contentValues.put(a2, Long.valueOf(samplesFair2));
                    contentValues.put(b2, Long.valueOf(samplesPoor2));
                    contentValues.put(c2, Long.valueOf(samplesBad2));
                    contentValues.put(N1, Integer.valueOf(ubVar2.year));
                    contentValues.put(O1, Integer.valueOf(ubVar2.month));
                    contentValues.put(P1, Integer.valueOf(ubVar2.day));
                    contentValues.put(Q1, DateUtils.formatLumenDate(ubVar2.year, ubVar2.month, ubVar2.day));
                    writableDatabase.insert(L1, (String) null, contentValues);
                } else {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put(R1, Long.valueOf(samplesUnknown));
                    contentValues2.put(S1, Long.valueOf(samplesExcellent));
                    contentValues2.put(T1, Long.valueOf(samplesGood));
                    contentValues2.put(U1, Long.valueOf(samplesFair));
                    contentValues2.put(V1, Long.valueOf(samplesPoor));
                    contentValues2.put(W1, Long.valueOf(samplesBad));
                    contentValues2.put(X1, Long.valueOf(samplesUnknown2));
                    contentValues2.put(Y1, Long.valueOf(samplesExcellent2));
                    contentValues2.put(Z1, Long.valueOf(samplesGood2));
                    contentValues2.put(a2, Long.valueOf(samplesFair2));
                    contentValues2.put(b2, Long.valueOf(samplesPoor2));
                    contentValues2.put(c2, Long.valueOf(samplesBad2));
                    writableDatabase.update(L1, contentValues2, "COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_YEAR=? AND COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_MONTH=? AND COLUMN_AGG_MPA_SIGNALSTRENGTH_SHARE_DAY=?", strArr);
                }
                writableDatabase.close();
            } catch (Exception e3) {
                String str = d;
                Log.e(str, "addMpaSignalStrengthShare: " + e3.getMessage());
            }
        }
        return;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x058d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.umlaut.crowd.internal.g1 r34) {
        /*
            r33 = this;
            r1 = r33
            r2 = r34
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            java.lang.String r5 = "addCT: "
            monitor-enter(r33)
            if (r2 != 0) goto L_0x000f
            monitor-exit(r33)
            return
        L_0x000f:
            com.umlaut.crowd.internal.DRI r6 = r2.RadioInfo     // Catch:{ all -> 0x058e }
            com.umlaut.crowd.enums.ConnectionTypes r7 = r6.ConnectionType     // Catch:{ all -> 0x058e }
            com.umlaut.crowd.enums.ConnectionTypes r8 = com.umlaut.crowd.enums.ConnectionTypes.WiFi     // Catch:{ all -> 0x058e }
            r9 = 1
            if (r7 == r8) goto L_0x001a
            r11 = 1
            goto L_0x001b
        L_0x001a:
            r11 = 0
        L_0x001b:
            com.umlaut.crowd.enums.ConnectionTypes r12 = com.umlaut.crowd.enums.ConnectionTypes.Mobile     // Catch:{ all -> 0x058e }
            if (r7 == r12) goto L_0x0021
            r13 = 1
            goto L_0x0022
        L_0x0021:
            r13 = 0
        L_0x0022:
            r11 = r11 & r13
            if (r11 == 0) goto L_0x0027
            monitor-exit(r33)
            return
        L_0x0027:
            boolean r11 = r2.LocalhostPingSuccess     // Catch:{ all -> 0x058e }
            if (r11 != 0) goto L_0x002d
            monitor-exit(r33)
            return
        L_0x002d:
            long r13 = r2.DurationOverall     // Catch:{ all -> 0x058e }
            long r10 = r2.DurationOverallNoSleep     // Catch:{ all -> 0x058e }
            long r13 = r13 - r10
            r10 = 3
            int r16 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r16 > 0) goto L_0x058c
            r10 = -3
            int r16 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r16 >= 0) goto L_0x0040
            goto L_0x058c
        L_0x0040:
            boolean r10 = r6.MissingPermission     // Catch:{ all -> 0x058e }
            if (r10 == 0) goto L_0x0046
            monitor-exit(r33)
            return
        L_0x0046:
            com.umlaut.crowd.internal.a2 r10 = r2.DeviceInfo     // Catch:{ all -> 0x058e }
            com.umlaut.crowd.enums.ThreeState r11 = r10.PowerSaveMode     // Catch:{ all -> 0x058e }
            com.umlaut.crowd.enums.ThreeState r13 = com.umlaut.crowd.enums.ThreeState.Enabled     // Catch:{ all -> 0x058e }
            if (r11 != r13) goto L_0x0050
            monitor-exit(r33)
            return
        L_0x0050:
            if (r7 != r12) goto L_0x0076
            com.umlaut.crowd.internal.g9 r7 = r6.ServiceState     // Catch:{ all -> 0x058e }
            com.umlaut.crowd.internal.g9 r11 = com.umlaut.crowd.internal.g9.PowerOff     // Catch:{ all -> 0x058e }
            if (r7 != r11) goto L_0x005a
            monitor-exit(r33)
            return
        L_0x005a:
            com.umlaut.crowd.internal.y2 r7 = r6.FlightMode     // Catch:{ all -> 0x058e }
            com.umlaut.crowd.internal.y2 r11 = com.umlaut.crowd.internal.y2.Disabled     // Catch:{ all -> 0x058e }
            if (r7 == r11) goto L_0x0062
            monitor-exit(r33)
            return
        L_0x0062:
            com.umlaut.crowd.enums.ThreeState r7 = r6.MobileDataEnabled     // Catch:{ all -> 0x058e }
            if (r7 == r13) goto L_0x0068
            monitor-exit(r33)
            return
        L_0x0068:
            com.umlaut.crowd.internal.p9 r7 = r10.SimState     // Catch:{ all -> 0x058e }
            com.umlaut.crowd.internal.p9 r10 = com.umlaut.crowd.internal.p9.Ready     // Catch:{ all -> 0x058e }
            if (r7 == r10) goto L_0x0070
            monitor-exit(r33)
            return
        L_0x0070:
            boolean r6 = r6.IsRoaming     // Catch:{ all -> 0x058e }
            if (r6 == 0) goto L_0x0088
            monitor-exit(r33)
            return
        L_0x0076:
            com.umlaut.crowd.internal.DWI r6 = r2.WifiInfo     // Catch:{ all -> 0x058e }
            com.umlaut.crowd.internal.re r7 = r6.WifiState     // Catch:{ all -> 0x058e }
            com.umlaut.crowd.internal.re r10 = com.umlaut.crowd.internal.re.Enabled     // Catch:{ all -> 0x058e }
            if (r7 == r10) goto L_0x0080
            monitor-exit(r33)
            return
        L_0x0080:
            com.umlaut.crowd.internal.fe r6 = r6.WifiDetailedState     // Catch:{ all -> 0x058e }
            com.umlaut.crowd.internal.fe r7 = com.umlaut.crowd.internal.fe.CONNECTED     // Catch:{ all -> 0x058e }
            if (r6 == r7) goto L_0x0088
            monitor-exit(r33)
            return
        L_0x0088:
            android.database.sqlite.SQLiteDatabase r6 = r33.getWritableDatabase()     // Catch:{ Exception -> 0x056f }
            java.lang.String r7 = "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_CT_DATE) > CAST(? as INTEGER)"
            java.lang.String[] r10 = new java.lang.String[r9]     // Catch:{ Exception -> 0x056f }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
            r11.<init>(r4)     // Catch:{ Exception -> 0x056f }
            long r13 = r1.a     // Catch:{ Exception -> 0x056f }
            r11.append(r13)     // Catch:{ Exception -> 0x056f }
            java.lang.String r4 = r11.toString()     // Catch:{ Exception -> 0x056f }
            r11 = 0
            r10[r11] = r4     // Catch:{ Exception -> 0x056f }
            java.lang.String r4 = "AGG_CT"
            r6.delete(r4, r7, r10)     // Catch:{ Exception -> 0x056f }
            com.umlaut.crowd.internal.ub r4 = r2.TimeInfo     // Catch:{ Exception -> 0x056f }
            int r7 = r4.year     // Catch:{ Exception -> 0x056f }
            int r10 = r4.month     // Catch:{ Exception -> 0x056f }
            int r4 = r4.day     // Catch:{ Exception -> 0x056f }
            java.lang.String r11 = "COLUMN_AGG_CT_YEAR=? AND COLUMN_AGG_CT_MONTH=? AND COLUMN_AGG_CT_DAY=?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ Exception -> 0x056f }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
            r15.<init>()     // Catch:{ Exception -> 0x056f }
            r15.append(r7)     // Catch:{ Exception -> 0x056f }
            java.lang.String r13 = ""
            r15.append(r13)     // Catch:{ Exception -> 0x056f }
            java.lang.String r13 = r15.toString()     // Catch:{ Exception -> 0x056f }
            r15 = 0
            r14[r15] = r13     // Catch:{ Exception -> 0x056f }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
            r13.<init>()     // Catch:{ Exception -> 0x056f }
            r13.append(r10)     // Catch:{ Exception -> 0x056f }
            java.lang.String r15 = ""
            r13.append(r15)     // Catch:{ Exception -> 0x056f }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x056f }
            r14[r9] = r13     // Catch:{ Exception -> 0x056f }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
            r13.<init>()     // Catch:{ Exception -> 0x056f }
            r13.append(r4)     // Catch:{ Exception -> 0x056f }
            java.lang.String r15 = ""
            r13.append(r15)     // Catch:{ Exception -> 0x056f }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x056f }
            r15 = 2
            r14[r15] = r13     // Catch:{ Exception -> 0x056f }
            com.umlaut.crowd.internal.DRI r13 = r2.RadioInfo     // Catch:{ Exception -> 0x056f }
            com.umlaut.crowd.enums.ConnectionTypes r13 = r13.ConnectionType     // Catch:{ Exception -> 0x056f }
            if (r13 != r12) goto L_0x0104
            boolean r13 = r2.Success     // Catch:{ Exception -> 0x00fe }
            r26 = r13
            r13 = 0
            r25 = 0
            r27 = 1
            goto L_0x0111
        L_0x00fe:
            r0 = move-exception
            r2 = r0
            r25 = r5
            goto L_0x0573
        L_0x0104:
            boolean r13 = r2.Success     // Catch:{ Exception -> 0x056f }
            if (r13 == 0) goto L_0x010a
            r13 = 1
            goto L_0x010b
        L_0x010a:
            r13 = 0
        L_0x010b:
            r25 = 1
            r26 = 0
            r27 = 0
        L_0x0111:
            java.lang.String r17 = "AGG_CT"
            java.lang.String[] r18 = G0     // Catch:{ Exception -> 0x056f }
            r21 = 0
            r22 = 0
            r23 = 0
            r16 = r6
            r19 = r11
            r20 = r14
            android.database.Cursor r15 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x056f }
            boolean r16 = r15.moveToFirst()     // Catch:{ Exception -> 0x056f }
            r28 = 2147483647(0x7fffffff, float:NaN)
            if (r16 == 0) goto L_0x01bc
            java.lang.String r9 = "COLUMN_AGG_CT_MOBILE_COUNT"
            int r9 = r15.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x00fe }
            int r9 = r15.getInt(r9)     // Catch:{ Exception -> 0x00fe }
            int r27 = r27 + r9
            java.lang.String r9 = "COLUMN_AGG_CT_MOBILE_SUCCESS"
            int r9 = r15.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x00fe }
            int r9 = r15.getInt(r9)     // Catch:{ Exception -> 0x00fe }
            int r26 = r26 + r9
            java.lang.String r9 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY"
            int r9 = r15.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x00fe }
            int r9 = r15.getInt(r9)     // Catch:{ Exception -> 0x00fe }
            r16 = r9
            java.lang.String r9 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_2G"
            int r9 = r15.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x00fe }
            int r9 = r15.getInt(r9)     // Catch:{ Exception -> 0x00fe }
            r17 = r9
            java.lang.String r9 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_3G"
            int r9 = r15.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x00fe }
            int r9 = r15.getInt(r9)     // Catch:{ Exception -> 0x00fe }
            r18 = r9
            java.lang.String r9 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_4G"
            int r9 = r15.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x00fe }
            int r9 = r15.getInt(r9)     // Catch:{ Exception -> 0x00fe }
            r19 = r9
            java.lang.String r9 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_5G"
            int r9 = r15.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x00fe }
            int r9 = r15.getInt(r9)     // Catch:{ Exception -> 0x00fe }
            r20 = r9
            java.lang.String r9 = "COLUMN_AGG_CT_WIFI_COUNT"
            int r9 = r15.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x00fe }
            int r9 = r15.getInt(r9)     // Catch:{ Exception -> 0x00fe }
            int r25 = r25 + r9
            java.lang.String r9 = "COLUMN_AGG_CT_WIFI_SUCCESS"
            int r9 = r15.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x00fe }
            int r9 = r15.getInt(r9)     // Catch:{ Exception -> 0x00fe }
            int r13 = r13 + r9
            java.lang.String r9 = "COLUMN_AGG_CT_WIFI_MIN_LATENCY"
            int r9 = r15.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x00fe }
            int r9 = r15.getInt(r9)     // Catch:{ Exception -> 0x00fe }
            r21 = r25
            r25 = r5
            r5 = r17
            r17 = r3
            r3 = r19
            r19 = r13
            r13 = r16
            r16 = r8
            r8 = r18
            r18 = r11
            r11 = r20
            r20 = 0
            goto L_0x01dc
        L_0x01bc:
            r17 = r3
            r16 = r8
            r18 = r11
            r19 = r13
            r21 = r25
            r3 = 2147483647(0x7fffffff, float:NaN)
            r8 = 2147483647(0x7fffffff, float:NaN)
            r9 = 2147483647(0x7fffffff, float:NaN)
            r11 = 2147483647(0x7fffffff, float:NaN)
            r13 = 2147483647(0x7fffffff, float:NaN)
            r20 = 1
            r25 = r5
            r5 = 2147483647(0x7fffffff, float:NaN)
        L_0x01dc:
            r15.close()     // Catch:{ Exception -> 0x056d }
            r22 = r14
            long r14 = r2.DurationTcpConnect     // Catch:{ Exception -> 0x056d }
            r29 = 0
            int r23 = (r14 > r29 ? 1 : (r14 == r29 ? 0 : -1))
            if (r23 <= 0) goto L_0x0252
            r31 = r6
            com.umlaut.crowd.internal.DRI r6 = r2.RadioInfo     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.enums.ConnectionTypes r6 = r6.ConnectionType     // Catch:{ Exception -> 0x056d }
            if (r6 != r12) goto L_0x0246
            r6 = r12
            long r12 = (long) r13     // Catch:{ Exception -> 0x056d }
            long r12 = java.lang.Math.min(r14, r12)     // Catch:{ Exception -> 0x056d }
            int r13 = (int) r12     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.internal.DRI r12 = r2.RadioInfo     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.enums.NetworkTypes r14 = r12.NetworkType     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.internal.o6 r15 = r12.NrState     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.enums.NetworkTypes r12 = r12.DisplayNetworkType     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.enums.NetworkGenerations r12 = com.umlaut.crowd.internal.l7.a((com.umlaut.crowd.enums.NetworkTypes) r14, (com.umlaut.crowd.internal.o6) r15, (com.umlaut.crowd.enums.NetworkTypes) r12)     // Catch:{ Exception -> 0x056d }
            int[] r14 = com.umlaut.crowd.database.StatsDatabase.a.a     // Catch:{ Exception -> 0x056d }
            int r12 = r12.ordinal()     // Catch:{ Exception -> 0x056d }
            r12 = r14[r12]     // Catch:{ Exception -> 0x056d }
            r14 = 1
            if (r12 == r14) goto L_0x023b
            r14 = 2
            if (r12 == r14) goto L_0x0230
            r15 = 3
            if (r12 == r15) goto L_0x0225
            r15 = 4
            if (r12 == r15) goto L_0x021c
            r15 = 5
            if (r12 == r15) goto L_0x021c
            goto L_0x0257
        L_0x021c:
            long r14 = r2.DurationTcpConnect     // Catch:{ Exception -> 0x056d }
            long r11 = (long) r11     // Catch:{ Exception -> 0x056d }
            long r11 = java.lang.Math.min(r14, r11)     // Catch:{ Exception -> 0x056d }
            int r11 = (int) r11     // Catch:{ Exception -> 0x056d }
            goto L_0x0257
        L_0x0225:
            long r14 = r2.DurationTcpConnect     // Catch:{ Exception -> 0x056d }
            r23 = r11
            long r11 = (long) r3     // Catch:{ Exception -> 0x056d }
            long r11 = java.lang.Math.min(r14, r11)     // Catch:{ Exception -> 0x056d }
            int r3 = (int) r11     // Catch:{ Exception -> 0x056d }
            goto L_0x024f
        L_0x0230:
            r23 = r11
            long r11 = r2.DurationTcpConnect     // Catch:{ Exception -> 0x056d }
            long r14 = (long) r8     // Catch:{ Exception -> 0x056d }
            long r11 = java.lang.Math.min(r11, r14)     // Catch:{ Exception -> 0x056d }
            int r8 = (int) r11     // Catch:{ Exception -> 0x056d }
            goto L_0x024f
        L_0x023b:
            r23 = r11
            long r11 = r2.DurationTcpConnect     // Catch:{ Exception -> 0x056d }
            long r14 = (long) r5     // Catch:{ Exception -> 0x056d }
            long r11 = java.lang.Math.min(r11, r14)     // Catch:{ Exception -> 0x056d }
            int r5 = (int) r11     // Catch:{ Exception -> 0x056d }
            goto L_0x024f
        L_0x0246:
            r23 = r11
            r6 = r12
            long r11 = (long) r9     // Catch:{ Exception -> 0x056d }
            long r11 = java.lang.Math.min(r14, r11)     // Catch:{ Exception -> 0x056d }
            int r9 = (int) r11     // Catch:{ Exception -> 0x056d }
        L_0x024f:
            r11 = r23
            goto L_0x0257
        L_0x0252:
            r31 = r6
            r23 = r11
            r6 = r12
        L_0x0257:
            if (r20 == 0) goto L_0x02e7
            android.content.ContentValues r14 = new android.content.ContentValues     // Catch:{ Exception -> 0x056d }
            r14.<init>()     // Catch:{ Exception -> 0x056d }
            java.lang.String r15 = "COLUMN_AGG_CT_MOBILE_COUNT"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r27)     // Catch:{ Exception -> 0x056d }
            r14.put(r15, r12)     // Catch:{ Exception -> 0x056d }
            java.lang.String r12 = "COLUMN_AGG_CT_MOBILE_SUCCESS"
            java.lang.Integer r15 = java.lang.Integer.valueOf(r26)     // Catch:{ Exception -> 0x056d }
            r14.put(r12, r15)     // Catch:{ Exception -> 0x056d }
            java.lang.String r12 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x056d }
            r14.put(r12, r13)     // Catch:{ Exception -> 0x056d }
            java.lang.String r12 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_2G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x056d }
            r14.put(r12, r5)     // Catch:{ Exception -> 0x056d }
            java.lang.String r5 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_3G"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x056d }
            r14.put(r5, r8)     // Catch:{ Exception -> 0x056d }
            java.lang.String r5 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_4G"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x056d }
            r14.put(r5, r3)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_5G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x056d }
            r14.put(r3, r5)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_AGG_CT_WIFI_COUNT"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r21)     // Catch:{ Exception -> 0x056d }
            r14.put(r3, r5)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_AGG_CT_WIFI_SUCCESS"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r19)     // Catch:{ Exception -> 0x056d }
            r14.put(r3, r5)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_AGG_CT_WIFI_MIN_LATENCY"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x056d }
            r14.put(r3, r5)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_AGG_CT_YEAR"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x056d }
            r14.put(r3, r5)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_AGG_CT_MONTH"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x056d }
            r14.put(r3, r5)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_AGG_CT_DAY"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x056d }
            r14.put(r3, r5)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_AGG_CT_DATE"
            java.lang.String r5 = com.umlaut.crowd.utils.DateUtils.formatLumenDate(r7, r10, r4)     // Catch:{ Exception -> 0x056d }
            r14.put(r3, r5)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "AGG_CT"
            r12 = r31
            r5 = 0
            r12.insert(r3, r5, r14)     // Catch:{ Exception -> 0x056d }
            r31 = r4
            goto L_0x0353
        L_0x02e7:
            r12 = r31
            android.content.ContentValues r14 = new android.content.ContentValues     // Catch:{ Exception -> 0x056d }
            r14.<init>()     // Catch:{ Exception -> 0x056d }
            java.lang.String r15 = "COLUMN_AGG_CT_MOBILE_COUNT"
            r31 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r27)     // Catch:{ Exception -> 0x056d }
            r14.put(r15, r4)     // Catch:{ Exception -> 0x056d }
            java.lang.String r4 = "COLUMN_AGG_CT_MOBILE_SUCCESS"
            java.lang.Integer r15 = java.lang.Integer.valueOf(r26)     // Catch:{ Exception -> 0x056d }
            r14.put(r4, r15)     // Catch:{ Exception -> 0x056d }
            java.lang.String r4 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x056d }
            r14.put(r4, r13)     // Catch:{ Exception -> 0x056d }
            java.lang.String r4 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_2G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x056d }
            r14.put(r4, r5)     // Catch:{ Exception -> 0x056d }
            java.lang.String r4 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_3G"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x056d }
            r14.put(r4, r5)     // Catch:{ Exception -> 0x056d }
            java.lang.String r4 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_4G"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x056d }
            r14.put(r4, r3)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_AGG_CT_MOBILE_MIN_LATENCY_5G"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x056d }
            r14.put(r3, r4)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_AGG_CT_WIFI_COUNT"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r21)     // Catch:{ Exception -> 0x056d }
            r14.put(r3, r4)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_AGG_CT_WIFI_SUCCESS"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r19)     // Catch:{ Exception -> 0x056d }
            r14.put(r3, r4)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_AGG_CT_WIFI_MIN_LATENCY"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x056d }
            r14.put(r3, r4)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "AGG_CT"
            r4 = r18
            r5 = r22
            r12.update(r3, r14, r4, r5)     // Catch:{ Exception -> 0x056d }
        L_0x0353:
            com.umlaut.crowd.internal.q4 r3 = r2.LocationInfo     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.internal.s4 r4 = r3.LocationProvider     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.internal.s4 r5 = com.umlaut.crowd.internal.s4.Unknown     // Catch:{ Exception -> 0x056d }
            if (r4 != r5) goto L_0x035d
            monitor-exit(r33)
            return
        L_0x035d:
            double r4 = r3.LocationLatitude     // Catch:{ Exception -> 0x056d }
            r8 = 0
            int r11 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r11 != 0) goto L_0x036d
            double r3 = r3.LocationLongitude     // Catch:{ Exception -> 0x056d }
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 != 0) goto L_0x036d
            monitor-exit(r33)
            return
        L_0x036d:
            java.lang.String r3 = "JULIANDAY('now') - JULIANDAY(COLUMN_LOCATION_CT_DATE) > CAST(? as INTEGER)"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ Exception -> 0x056d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056d }
            r11 = r17
            r4.<init>(r11)     // Catch:{ Exception -> 0x056d }
            long r13 = r1.a     // Catch:{ Exception -> 0x056d }
            r4.append(r13)     // Catch:{ Exception -> 0x056d }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x056d }
            r11 = 0
            r5[r11] = r4     // Catch:{ Exception -> 0x056d }
            r4 = 2
            java.lang.String r11 = "LOC_CT"
            r12.delete(r11, r3, r5)     // Catch:{ Exception -> 0x056d }
            boolean r3 = r2.Success     // Catch:{ Exception -> 0x056d }
            java.lang.String r5 = ""
            com.umlaut.crowd.internal.DRI r11 = r2.RadioInfo     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.enums.ConnectionTypes r13 = r11.ConnectionType     // Catch:{ Exception -> 0x056d }
            r14 = r16
            if (r13 != r14) goto L_0x039c
            com.umlaut.crowd.internal.DWI r8 = r2.WifiInfo     // Catch:{ Exception -> 0x056d }
            java.lang.String r8 = r8.WifiSSID     // Catch:{ Exception -> 0x056d }
            goto L_0x039e
        L_0x039c:
            java.lang.String r8 = r11.OperatorName     // Catch:{ Exception -> 0x056d }
        L_0x039e:
            if (r13 != r14) goto L_0x03a7
            com.umlaut.crowd.enums.NetworkTypes r6 = com.umlaut.crowd.enums.NetworkTypes.WiFi     // Catch:{ Exception -> 0x056d }
            java.lang.String r6 = r6.name()     // Catch:{ Exception -> 0x056d }
            goto L_0x03c1
        L_0x03a7:
            if (r13 != r6) goto L_0x056b
            com.umlaut.crowd.enums.NetworkTypes r6 = r11.NetworkType     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.internal.o6 r9 = r11.NrState     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.enums.NetworkTypes r11 = r11.DisplayNetworkType     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.enums.NetworkGenerations r6 = com.umlaut.crowd.internal.l7.a((com.umlaut.crowd.enums.NetworkTypes) r6, (com.umlaut.crowd.internal.o6) r9, (com.umlaut.crowd.enums.NetworkTypes) r11)     // Catch:{ Exception -> 0x056d }
            java.lang.String r6 = r6.name()     // Catch:{ Exception -> 0x056d }
            java.lang.String r9 = "Gen5"
            boolean r9 = r6.startsWith(r9)     // Catch:{ Exception -> 0x056d }
            if (r9 == 0) goto L_0x03c1
            java.lang.String r6 = "Gen5"
        L_0x03c1:
            com.umlaut.crowd.internal.DRI r9 = r2.RadioInfo     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.enums.ConnectionTypes r11 = r9.ConnectionType     // Catch:{ Exception -> 0x056d }
            if (r11 != r14) goto L_0x03db
            com.umlaut.crowd.internal.DWI r9 = r2.WifiInfo     // Catch:{ Exception -> 0x056d }
            java.lang.String r9 = r9.DefaultGatewayMacAddress     // Catch:{ Exception -> 0x056d }
            boolean r9 = r9.isEmpty()     // Catch:{ Exception -> 0x056d }
            if (r9 != 0) goto L_0x03d6
            com.umlaut.crowd.internal.DWI r9 = r2.WifiInfo     // Catch:{ Exception -> 0x056d }
            java.lang.String r9 = r9.DefaultGatewayMacAddress     // Catch:{ Exception -> 0x056d }
            goto L_0x03fb
        L_0x03d6:
            com.umlaut.crowd.internal.DWI r9 = r2.WifiInfo     // Catch:{ Exception -> 0x056d }
            java.lang.String r9 = r9.WifiBSSID     // Catch:{ Exception -> 0x056d }
            goto L_0x03fb
        L_0x03db:
            long r13 = r9.NrCellId     // Catch:{ Exception -> 0x056d }
            r16 = -1
            int r11 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r11 == 0) goto L_0x03f9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056d }
            r9.<init>()     // Catch:{ Exception -> 0x056d }
            com.umlaut.crowd.internal.DRI r11 = r2.RadioInfo     // Catch:{ Exception -> 0x056d }
            long r13 = r11.NrCellId     // Catch:{ Exception -> 0x056d }
            r9.append(r13)     // Catch:{ Exception -> 0x056d }
            java.lang.String r11 = ""
            r9.append(r11)     // Catch:{ Exception -> 0x056d }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x056d }
            goto L_0x03fb
        L_0x03f9:
            java.lang.String r9 = r9.GsmCellId     // Catch:{ Exception -> 0x056d }
        L_0x03fb:
            java.lang.String r11 = "COLUMN_LOCATION_CT_TECHNOLOGY=? AND COLUMN_LOCATION_CT_TECHNOLOGY_ID=?"
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ Exception -> 0x056d }
            r13 = 0
            r4[r13] = r6     // Catch:{ Exception -> 0x056d }
            r14 = 1
            r4[r14] = r9     // Catch:{ Exception -> 0x056d }
            java.lang.String r17 = "LOC_CT"
            java.lang.String[] r18 = X0     // Catch:{ Exception -> 0x056d }
            r21 = 0
            r22 = 0
            r23 = 0
            r16 = r12
            r19 = r11
            r20 = r4
            android.database.Cursor r14 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x056d }
            boolean r15 = r14.moveToFirst()     // Catch:{ Exception -> 0x056d }
            if (r15 == 0) goto L_0x0476
            java.lang.String r5 = "COLUMN_LOCATION_CT_COUNT"
            int r5 = r14.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x056d }
            int r5 = r14.getInt(r5)     // Catch:{ Exception -> 0x056d }
            r15 = 1
            int r5 = r5 + r15
            java.lang.String r15 = "COLUMN_LOCATION_CT_SUCCESS"
            int r15 = r14.getColumnIndexOrThrow(r15)     // Catch:{ Exception -> 0x056d }
            int r15 = r14.getInt(r15)     // Catch:{ Exception -> 0x056d }
            int r3 = r3 + r15
            java.lang.String r15 = "COLUMN_LOCATION_CT_ACCURACY"
            int r15 = r14.getColumnIndexOrThrow(r15)     // Catch:{ Exception -> 0x056d }
            int r28 = r14.getInt(r15)     // Catch:{ Exception -> 0x056d }
            java.lang.String r15 = "COLUMN_LOCATION_CT_MIN_LATENCY"
            int r15 = r14.getColumnIndexOrThrow(r15)     // Catch:{ Exception -> 0x056d }
            int r15 = r14.getInt(r15)     // Catch:{ Exception -> 0x056d }
            java.lang.String r13 = "COLUMN_LOCATION_CT_LAT"
            int r13 = r14.getColumnIndexOrThrow(r13)     // Catch:{ Exception -> 0x056d }
            double r17 = r14.getDouble(r13)     // Catch:{ Exception -> 0x056d }
            java.lang.String r13 = "COLUMN_LOCATION_CT_LNG"
            int r13 = r14.getColumnIndexOrThrow(r13)     // Catch:{ Exception -> 0x056d }
            double r19 = r14.getDouble(r13)     // Catch:{ Exception -> 0x056d }
            java.lang.String r13 = "COLUMN_LOCATION_CT_TECHNOLOGY_TYPE"
            int r13 = r14.getColumnIndexOrThrow(r13)     // Catch:{ Exception -> 0x056d }
            java.lang.String r13 = r14.getString(r13)     // Catch:{ Exception -> 0x056d }
            r16 = r4
            r21 = r11
            r4 = r15
            r11 = r28
            r15 = 0
            r32 = r13
            r13 = r5
            r5 = r32
            goto L_0x0486
        L_0x0476:
            r15 = 1
            r16 = r4
            r21 = r11
            r4 = 2147483647(0x7fffffff, float:NaN)
            r11 = 2147483647(0x7fffffff, float:NaN)
            r13 = 1
            r17 = 0
            r19 = 0
        L_0x0486:
            r14.close()     // Catch:{ Exception -> 0x056d }
            r22 = r9
            r14 = r10
            long r9 = r2.DurationTcpConnect     // Catch:{ Exception -> 0x056d }
            int r23 = (r9 > r29 ? 1 : (r9 == r29 ? 0 : -1))
            if (r23 <= 0) goto L_0x049d
            r23 = r12
            r24 = r13
            long r12 = (long) r4     // Catch:{ Exception -> 0x056d }
            long r9 = java.lang.Math.min(r9, r12)     // Catch:{ Exception -> 0x056d }
            int r4 = (int) r9     // Catch:{ Exception -> 0x056d }
            goto L_0x04a1
        L_0x049d:
            r23 = r12
            r24 = r13
        L_0x04a1:
            if (r15 != 0) goto L_0x04ac
            com.umlaut.crowd.internal.q4 r9 = r2.LocationInfo     // Catch:{ Exception -> 0x056d }
            double r9 = r9.LocationAccuracyHorizontal     // Catch:{ Exception -> 0x056d }
            double r12 = (double) r11     // Catch:{ Exception -> 0x056d }
            int r26 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r26 >= 0) goto L_0x04ba
        L_0x04ac:
            com.umlaut.crowd.internal.q4 r2 = r2.LocationInfo     // Catch:{ Exception -> 0x056d }
            double r9 = r2.LocationLatitude     // Catch:{ Exception -> 0x056d }
            double r11 = r2.LocationLongitude     // Catch:{ Exception -> 0x056d }
            r17 = r9
            double r9 = r2.LocationAccuracyHorizontal     // Catch:{ Exception -> 0x056d }
            int r2 = (int) r9     // Catch:{ Exception -> 0x056d }
            r19 = r11
            r11 = r2
        L_0x04ba:
            if (r15 != 0) goto L_0x04de
            com.umlaut.crowd.enums.NetworkTypes r2 = com.umlaut.crowd.enums.NetworkTypes.WiFi     // Catch:{ Exception -> 0x056d }
            java.lang.String r2 = r2.name()     // Catch:{ Exception -> 0x056d }
            boolean r2 = r6.equals(r2)     // Catch:{ Exception -> 0x056d }
            if (r2 == 0) goto L_0x04dd
            boolean r2 = r8.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x056d }
            if (r2 != 0) goto L_0x04dd
            boolean r2 = r8.isEmpty()     // Catch:{ Exception -> 0x056d }
            if (r2 != 0) goto L_0x04dd
            java.lang.String r2 = "<unknown ssid>"
            boolean r2 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x056d }
            if (r2 != 0) goto L_0x04dd
            goto L_0x04de
        L_0x04dd:
            r8 = r5
        L_0x04de:
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x056d }
            r2.<init>()     // Catch:{ Exception -> 0x056d }
            java.lang.String r5 = "COLUMN_LOCATION_CT_MIN_LATENCY"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x056d }
            r2.put(r5, r4)     // Catch:{ Exception -> 0x056d }
            java.lang.String r4 = "COLUMN_LOCATION_CT_SUCCESS"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x056d }
            r2.put(r4, r3)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_LOCATION_CT_LAT"
            java.lang.Double r4 = java.lang.Double.valueOf(r17)     // Catch:{ Exception -> 0x056d }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_LOCATION_CT_LNG"
            java.lang.Double r4 = java.lang.Double.valueOf(r19)     // Catch:{ Exception -> 0x056d }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_LOCATION_CT_ACCURACY"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x056d }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_LOCATION_CT_COUNT"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r24)     // Catch:{ Exception -> 0x056d }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_LOCATION_CT_TECHNOLOGY_TYPE"
            r2.put(r3, r8)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_LOCATION_CT_YEAR"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x056d }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_LOCATION_CT_MONTH"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x056d }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_LOCATION_CT_DAY"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r31)     // Catch:{ Exception -> 0x056d }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_LOCATION_CT_DATE"
            r4 = r14
            r5 = r31
            java.lang.String r4 = com.umlaut.crowd.utils.DateUtils.formatLumenDate(r7, r4, r5)     // Catch:{ Exception -> 0x056d }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x056d }
            if (r15 == 0) goto L_0x055c
            java.lang.String r3 = "COLUMN_LOCATION_CT_TECHNOLOGY"
            r2.put(r3, r6)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "COLUMN_LOCATION_CT_TECHNOLOGY_ID"
            r9 = r22
            r2.put(r3, r9)     // Catch:{ Exception -> 0x056d }
            java.lang.String r3 = "LOC_CT"
            r4 = r23
            r5 = 0
            r4.insert(r3, r5, r2)     // Catch:{ Exception -> 0x056d }
            goto L_0x0567
        L_0x055c:
            r4 = r23
            java.lang.String r3 = "LOC_CT"
            r6 = r16
            r5 = r21
            r4.update(r3, r2, r5, r6)     // Catch:{ Exception -> 0x056d }
        L_0x0567:
            r4.close()     // Catch:{ Exception -> 0x056d }
            goto L_0x058a
        L_0x056b:
            monitor-exit(r33)
            return
        L_0x056d:
            r0 = move-exception
            goto L_0x0572
        L_0x056f:
            r0 = move-exception
            r25 = r5
        L_0x0572:
            r2 = r0
        L_0x0573:
            java.lang.String r3 = d     // Catch:{ all -> 0x058e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x058e }
            r5 = r25
            r4.<init>(r5)     // Catch:{ all -> 0x058e }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x058e }
            r4.append(r2)     // Catch:{ all -> 0x058e }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x058e }
            android.util.Log.e(r3, r2)     // Catch:{ all -> 0x058e }
        L_0x058a:
            monitor-exit(r33)
            return
        L_0x058c:
            monitor-exit(r33)
            return
        L_0x058e:
            r0 = move-exception
            r2 = r0
            monitor-exit(r33)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.database.StatsDatabase.a(com.umlaut.crowd.internal.g1):void");
    }

    /* JADX INFO: finally extract failed */
    public synchronized void a(oc ocVar, TTRLocation tTRLocation) {
        String str;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        long j3;
        long j4;
        long j5;
        oc ocVar2 = ocVar;
        TTRLocation tTRLocation2 = tTRLocation;
        synchronized (this) {
            if (ocVar2 != null) {
                try {
                    long j6 = ocVar2.RvMobile2gRx;
                    if (j6 != 0 || ocVar2.RvMobile3gRx != 0 || ocVar2.RvMobile4gRx != 0 || ocVar2.RvMobile5gRx != 0 || ocVar2.RvWifiRx != 0) {
                        long j7 = ocVar2.RvMobile3gRx;
                        long j8 = ocVar2.RvMobile4gRx;
                        long j9 = ocVar2.RvMobile5gRx;
                        long j10 = ocVar2.RvWifiRx;
                        double d9 = tTRLocation2.RvMobile2gLat;
                        double d10 = tTRLocation2.RvMobile2gLong;
                        double d11 = tTRLocation2.RvMobile3gLat;
                        double d12 = tTRLocation2.RvMobile3gLong;
                        double d13 = tTRLocation2.RvMobile4gLat;
                        double d14 = tTRLocation2.RvMobile4gLong;
                        double d15 = tTRLocation2.RvMobile5gLat;
                        double d16 = tTRLocation2.RvMobile5gLong;
                        double d17 = tTRLocation2.RvWifiLat;
                        double d18 = tTRLocation2.RvWifiLong;
                        long j11 = ocVar2.TrafficBytesRxMobile;
                        long j12 = j9;
                        long j13 = ocVar2.TrafficBytesTxMobile;
                        long j14 = j8;
                        long j15 = ocVar2.TrafficBytesRxWifi;
                        long j16 = j7;
                        long j17 = ocVar2.TrafficBytesTxWifi;
                        if (j6 > 220000) {
                            j6 = 220000;
                        }
                        try {
                            SQLiteDatabase writableDatabase = getWritableDatabase();
                            str = "addTTR: ";
                            long j18 = j6;
                            try {
                                StringBuilder sb = new StringBuilder("");
                                long j19 = j17;
                                sb.append(this.a);
                                String sb2 = sb.toString();
                                boolean z3 = false;
                                writableDatabase.delete(J, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_TTR_DATE) > CAST(? as INTEGER)", new String[]{sb2});
                                boolean z4 = true;
                                String[] strArr = {ocVar2.Year + "", ocVar2.Month + "", ocVar2.Day + "", ocVar2.Hour + "", ocVar2.Quarter + ""};
                                Cursor query = writableDatabase.query(J, l0, "COLUMN_AGG_TTR_YEAR=? AND COLUMN_AGG_TTR_MONTH=? AND COLUMN_AGG_TTR_DAY=? AND COLUMN_AGG_TTR_HOUR=? AND COLUMN_AGG_TTR_QUARTER=?", strArr, (String) null, (String) null, (String) null);
                                if (query.moveToFirst()) {
                                    long j20 = query.getLong(query.getColumnIndexOrThrow(R));
                                    j5 = query.getLong(query.getColumnIndexOrThrow(S));
                                    j4 = query.getLong(query.getColumnIndexOrThrow(T));
                                    j3 = query.getLong(query.getColumnIndexOrThrow(U));
                                    long j21 = query.getLong(query.getColumnIndexOrThrow(V));
                                    double d19 = query.getDouble(query.getColumnIndexOrThrow(a0));
                                    d8 = query.getDouble(query.getColumnIndexOrThrow(b0));
                                    d7 = query.getDouble(query.getColumnIndexOrThrow(c0));
                                    d6 = query.getDouble(query.getColumnIndexOrThrow(d0));
                                    d5 = query.getDouble(query.getColumnIndexOrThrow(e0));
                                    d4 = query.getDouble(query.getColumnIndexOrThrow(f0));
                                    double d20 = query.getDouble(query.getColumnIndexOrThrow(g0));
                                    double d21 = query.getDouble(query.getColumnIndexOrThrow(h0));
                                    double d22 = query.getDouble(query.getColumnIndexOrThrow(i0));
                                    d3 = query.getDouble(query.getColumnIndexOrThrow(j0));
                                    j11 += query.getLong(query.getColumnIndexOrThrow(Y));
                                    j13 += query.getLong(query.getColumnIndexOrThrow(Z));
                                    j15 += query.getLong(query.getColumnIndexOrThrow(W));
                                    j19 += query.getLong(query.getColumnIndexOrThrow(X));
                                    if (j20 > j18) {
                                        j18 = j20;
                                        d9 = d19;
                                    } else {
                                        d8 = d10;
                                    }
                                    if (j5 <= j16) {
                                        d7 = d11;
                                        d6 = d12;
                                        j5 = j16;
                                    }
                                    if (j4 <= j14) {
                                        d5 = d13;
                                        d4 = d14;
                                        j4 = j14;
                                    }
                                    if (j3 > j12) {
                                        d15 = d20;
                                        d16 = d21;
                                    } else {
                                        j3 = j12;
                                    }
                                    if (j21 > j10) {
                                        j10 = j21;
                                        d17 = d22;
                                    } else {
                                        d3 = d18;
                                    }
                                } else {
                                    d8 = d10;
                                    d7 = d11;
                                    d6 = d12;
                                    d5 = d13;
                                    d4 = d14;
                                    d3 = d18;
                                    j3 = j12;
                                    j4 = j14;
                                    j5 = j16;
                                    z3 = true;
                                    z4 = false;
                                }
                                query.close();
                                if (z3) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(R, Long.valueOf(j18));
                                    contentValues.put(S, Long.valueOf(j5));
                                    contentValues.put(T, Long.valueOf(j4));
                                    contentValues.put(U, Long.valueOf(j3));
                                    contentValues.put(V, Long.valueOf(j10));
                                    contentValues.put(a0, Double.valueOf(d9));
                                    contentValues.put(b0, Double.valueOf(d8));
                                    contentValues.put(c0, Double.valueOf(d7));
                                    contentValues.put(d0, Double.valueOf(d6));
                                    contentValues.put(e0, Double.valueOf(d5));
                                    contentValues.put(f0, Double.valueOf(d4));
                                    contentValues.put(g0, Double.valueOf(d15));
                                    contentValues.put(h0, Double.valueOf(d16));
                                    contentValues.put(i0, Double.valueOf(d17));
                                    contentValues.put(j0, Double.valueOf(d3));
                                    contentValues.put(Y, Long.valueOf(j11));
                                    contentValues.put(Z, Long.valueOf(j13));
                                    contentValues.put(W, Long.valueOf(j15));
                                    contentValues.put(X, Long.valueOf(j19));
                                    contentValues.put(L, Integer.valueOf(ocVar2.Year));
                                    contentValues.put(M, Integer.valueOf(ocVar2.Month));
                                    contentValues.put(N, Integer.valueOf(ocVar2.Day));
                                    contentValues.put(O, Integer.valueOf(ocVar2.Hour));
                                    contentValues.put(P, Integer.valueOf(ocVar2.Quarter));
                                    contentValues.put(Q, DateUtils.formatLumenDate(ocVar2.Year, ocVar2.Month, ocVar2.Day));
                                    writableDatabase.insert(J, (String) null, contentValues);
                                } else if (z4) {
                                    ContentValues contentValues2 = new ContentValues();
                                    contentValues2.put(R, Long.valueOf(j18));
                                    contentValues2.put(S, Long.valueOf(j5));
                                    contentValues2.put(T, Long.valueOf(j4));
                                    contentValues2.put(U, Long.valueOf(j3));
                                    contentValues2.put(V, Long.valueOf(j10));
                                    contentValues2.put(a0, Double.valueOf(d9));
                                    contentValues2.put(b0, Double.valueOf(d8));
                                    contentValues2.put(c0, Double.valueOf(d7));
                                    contentValues2.put(d0, Double.valueOf(d6));
                                    contentValues2.put(e0, Double.valueOf(d5));
                                    contentValues2.put(f0, Double.valueOf(d4));
                                    contentValues2.put(g0, Double.valueOf(d15));
                                    contentValues2.put(h0, Double.valueOf(d16));
                                    contentValues2.put(i0, Double.valueOf(d17));
                                    contentValues2.put(j0, Double.valueOf(d3));
                                    contentValues2.put(Y, Long.valueOf(j11));
                                    contentValues2.put(Z, Long.valueOf(j13));
                                    contentValues2.put(W, Long.valueOf(j15));
                                    contentValues2.put(X, Long.valueOf(j19));
                                    writableDatabase.update(J, contentValues2, "COLUMN_AGG_TTR_YEAR=? AND COLUMN_AGG_TTR_MONTH=? AND COLUMN_AGG_TTR_DAY=? AND COLUMN_AGG_TTR_HOUR=? AND COLUMN_AGG_TTR_QUARTER=?", strArr);
                                }
                                writableDatabase.close();
                            } catch (Exception e3) {
                                e = e3;
                                Exception exc = e;
                                Log.e(d, str + exc.getMessage());
                            }
                        } catch (Exception e4) {
                            e = e4;
                            str = "addTTR: ";
                            Exception exc2 = e;
                            Log.e(d, str + exc2.getMessage());
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public synchronized void a(p pVar) {
        String str;
        long j3;
        int i3;
        boolean z3;
        long j4;
        long j5;
        p pVar2 = pVar;
        synchronized (this) {
            if (pVar2 != null) {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.delete(P2, "JULIANDAY('now') - JULIANDAY(COLUMN_AGG_AUS_FREQUENCY_DATE) > CAST(? as INTEGER)", new String[]{"" + this.a});
                    String[] strArr = {pVar2.TimeInfoOnStart.year + "", pVar2.TimeInfoOnStart.month + "", pVar2.TimeInfoOnStart.day + "", pVar2.PackageName};
                    Cursor query = writableDatabase.query(P2, b3, "COLUMN_AGG_AUS_FREQUENCY_YEAR=? AND COLUMN_AGG_AUS_FREQUENCY_MONTH=? AND COLUMN_AGG_AUS_FREQUENCY_DAY=? AND COLUMN_AGG_AUS_FREQUENCY_PACKAGENAME=?", strArr, (String) null, (String) null, (String) null);
                    long j6 = 0;
                    if (query.moveToFirst()) {
                        int i4 = query.getInt(query.getColumnIndexOrThrow(W2));
                        j5 = query.getLong(query.getColumnIndexOrThrow(X2));
                        j4 = query.getLong(query.getColumnIndexOrThrow(Y2));
                        j3 = query.getLong(query.getColumnIndexOrThrow(Z2));
                        i3 = i4;
                        z3 = false;
                    } else {
                        j5 = 0;
                        j4 = 0;
                        j3 = 0;
                        z3 = true;
                        i3 = 0;
                    }
                    query.close();
                    long j7 = pVar2.SessionTotalRxBytes;
                    boolean z4 = z3;
                    long j8 = pVar2.SessionTotalTxBytes;
                    if (j7 < 0) {
                        j7 = 0;
                    }
                    if (j8 >= 0) {
                        j6 = j8;
                    }
                    if (z4) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(V2, pVar2.PackageName);
                        contentValues.put(W2, 1);
                        contentValues.put(X2, Long.valueOf(pVar2.AppUsageTime));
                        contentValues.put(R2, Integer.valueOf(pVar2.TimeInfoOnStart.year));
                        contentValues.put(S2, Integer.valueOf(pVar2.TimeInfoOnStart.month));
                        contentValues.put(T2, Integer.valueOf(pVar2.TimeInfoOnStart.day));
                        ub ubVar = pVar2.TimeInfoOnStart;
                        contentValues.put(U2, DateUtils.formatLumenDate(ubVar.year, ubVar.month, ubVar.day));
                        contentValues.put(Y2, Long.valueOf(j7));
                        contentValues.put(Z2, Long.valueOf(j6));
                        writableDatabase.insert(P2, (String) null, contentValues);
                        Object obj = "addAusFrequency: ";
                    } else {
                        ContentValues contentValues2 = new ContentValues();
                        str = "addAusFrequency: ";
                        try {
                            contentValues2.put(W2, Integer.valueOf(i3 + 1));
                            contentValues2.put(X2, Long.valueOf(j5 + pVar2.AppUsageTime));
                            contentValues2.put(Y2, Long.valueOf(j4 + j7));
                            contentValues2.put(Z2, Long.valueOf(j3 + j6));
                            writableDatabase.update(P2, contentValues2, "COLUMN_AGG_AUS_FREQUENCY_YEAR=? AND COLUMN_AGG_AUS_FREQUENCY_MONTH=? AND COLUMN_AGG_AUS_FREQUENCY_DAY=? AND COLUMN_AGG_AUS_FREQUENCY_PACKAGENAME=?", strArr);
                        } catch (Exception e3) {
                            e = e3;
                            Log.e(d, str + e.getMessage());
                        }
                    }
                    writableDatabase.close();
                } catch (Exception e4) {
                    e = e4;
                    str = "addAusFrequency: ";
                    Log.e(d, str + e.getMessage());
                }
            }
        }
    }

    public synchronized void a(RST rst) {
        if (rst != null) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            StringBuilder sb = new StringBuilder("INSERT INTO ST ( COLUMN_ST_LT,COLUMN_ST_DL,COLUMN_ST_UL) VALUES (");
            sb.append(rst.LatencyTest.RttMed);
            sb.append("," + rst.DownloadTest.MedValue);
            sb.append("," + rst.UploadTest.MedValue);
            sb.append(")");
            writableDatabase.execSQL(sb.toString());
            writableDatabase.close();
        }
    }

    public synchronized void a(f6 f6Var) {
        if (f6Var != null) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("UPDATE NF SET COLUMN_NF_NUMBER_OF_FEEDBACKS=COLUMN_NF_NUMBER_OF_FEEDBACKS+1");
            writableDatabase.close();
        }
    }

    public synchronized void a(h6 h6Var) {
        if (h6Var != null) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            StringBuilder sb = new StringBuilder("UPDATE NIR SET COLUMN_NIR_NUMBER_OF_SAMPLES=COLUMN_NIR_NUMBER_OF_SAMPLES+1");
            if (h6Var.RadioInfo.RXLevel < -99) {
                sb.append(", COLUMN_NIR_NUMBER_OF_SAMPLES_BELOW_99DBM=COLUMN_NIR_NUMBER_OF_SAMPLES_BELOW_99DBM+1");
            }
            writableDatabase.execSQL(sb.toString());
            writableDatabase.close();
        }
    }
}
