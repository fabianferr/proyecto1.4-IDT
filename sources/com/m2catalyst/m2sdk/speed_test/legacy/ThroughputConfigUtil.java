package com.m2catalyst.m2sdk.speed_test.legacy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.business.repositories.MNSIRepository;
import com.m2catalyst.m2sdk.business.repositories.NDTRepository;
import com.m2catalyst.m2sdk.g2;
import com.m2catalyst.m2sdk.j3;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents;
import com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger;
import com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults;
import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import com.m2catalyst.m2sdk.ndt.models.LatencyTestResults;
import com.m2catalyst.m2sdk.q3;
import com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.koin.core.qualifier.Qualifier;
import org.koin.java.KoinJavaComponent;

@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 õ\u00012\u00020\u0001:\u0002õ\u0001B4\u0012\u0006\u0010x\u001a\u00020w\u0012\u0006\u0010{\u001a\u00020z\u0012\u0006\u0010~\u001a\u00020}\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0007\u0010\u0001\u001a\u000207¢\u0006\u0006\bó\u0001\u0010ô\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001d\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u001aH\u0002J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0013\u0010\u001f\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J(\u0010'\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\u0006H\u0002J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0002H\u0002J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0002H\u0002J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0002H\u0002J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0002H\u0002J\b\u0010.\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020\u0006H\u0002J\b\u00100\u001a\u00020\u0006H\u0002J\u0010\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u000201H\u0002J\u0012\u00106\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u000104H\u0002J\u0012\u00109\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u000107H\u0002J\u0012\u0010:\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u000104H\u0002J\u0012\u0010=\u001a\u00020<2\b\u0010;\u001a\u0004\u0018\u000104H\u0002J\b\u0010>\u001a\u00020<H\u0002J'\u0010B\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010\u00142\b\u0010A\u001a\u0004\u0018\u00010@H@ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u0006\u0010D\u001a\u00020\u0006JC\u0010G\u001a\u00020\u00062\u0006\u0010A\u001a\u00020@2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010E\u001a\u0004\u0018\u0001012\b\u00105\u001a\u0004\u0018\u0001042\b\u0010F\u001a\u0004\u0018\u00010\u0014H@ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u0006\u0010I\u001a\u00020\u0006J\u0010\u0010J\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0006\u0010K\u001a\u00020\u0004J\u001d\u0010L\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H@ø\u0001\u0000¢\u0006\u0004\bL\u0010\u0017J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u001aJ\u001d\u0010N\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H@ø\u0001\u0000¢\u0006\u0004\bN\u0010\u0017J\u0006\u0010O\u001a\u00020\u0004J#\u0010P\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ\u0006\u0010R\u001a\u00020\u0004J\u0006\u0010S\u001a\u00020\u0004J\u0010\u0010U\u001a\u00020\u00062\b\u0010T\u001a\u0004\u0018\u00010\u0014J\b\u0010V\u001a\u00020\u0006H\u0016J#\u0010X\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\t2\u0006\u00102\u001a\u000201H@ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ\u0010\u0010\\\u001a\u00020\u00062\u0006\u0010[\u001a\u00020ZH\u0016J\u0012\u0010^\u001a\u00020\u00062\b\u0010[\u001a\u0004\u0018\u00010]H\u0016J\u0010\u0010`\u001a\u00020\u00062\u0006\u0010[\u001a\u00020_H\u0016J\u0010\u0010a\u001a\u00020\u00062\u0006\u0010[\u001a\u00020_H\u0016J\b\u0010b\u001a\u00020\u0006H\u0016J\b\u0010c\u001a\u00020\u0006H\u0016J\b\u0010d\u001a\u00020\u0006H\u0016J \u0010h\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\f2\u0006\u0010f\u001a\u00020\u00022\u0006\u0010g\u001a\u00020\u0004H\u0016J(\u0010m\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u00022\u0006\u0010j\u001a\u00020\t2\u0006\u0010k\u001a\u00020\t2\u0006\u0010l\u001a\u00020\"H\u0016J(\u0010q\u001a\u00020\u00062\u0006\u0010n\u001a\u00020\"2\u0006\u0010o\u001a\u00020\"2\u0006\u0010p\u001a\u00020\"2\u0006\u0010l\u001a\u00020\"H\u0016J(\u0010v\u001a\u00020\u00062\u0006\u0010r\u001a\u00020\"2\u0006\u0010s\u001a\u00020\u00022\u0006\u0010t\u001a\u00020\u00022\u0006\u0010u\u001a\u00020\"H\u0016R\u0014\u0010x\u001a\u00020w8\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010{\u001a\u00020z8\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0014\u0010~\u001a\u00020}8\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010R\u0018\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0001\u001a\u0002078\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\f0\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b \u0001\u0010\u0001\"\u0006\b¡\u0001\u0010\u0001R\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001b\u0010¤\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u0019\u0010¦\u0001\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u0019\u0010¨\u0001\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010§\u0001R\u0019\u0010©\u0001\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b©\u0001\u0010§\u0001R\u0019\u0010ª\u0001\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bª\u0001\u0010§\u0001R+\u0010«\u0001\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b­\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R\u0019\u0010?\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b?\u0010±\u0001R\u001c\u0010³\u0001\u001a\u0005\u0018\u00010²\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u001c\u0010¶\u0001\u001a\u0005\u0018\u00010µ\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R*\u0010¹\u0001\u001a\u00030¸\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b¹\u0001\u0010º\u0001\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R\u001c\u0010À\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001c\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u001c\u0010Å\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Á\u0001R\u001c\u0010Æ\u0001\u001a\u0005\u0018\u00010Â\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ä\u0001R\u0019\u0010Ç\u0001\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010§\u0001R\u001b\u0010È\u0001\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u001b\u0010Ê\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u001b\u0010Ì\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Ë\u0001R\u001c\u0010Î\u0001\u001a\u0005\u0018\u00010Í\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R)\u0010A\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\bA\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R\u0019\u0010Õ\u0001\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010\u0001R\u0019\u0010Ö\u0001\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010\u0001R\u0019\u0010×\u0001\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R\u0019\u0010Ù\u0001\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010Ø\u0001R*\u0010Û\u0001\u001a\u00020\t2\u0007\u0010Ú\u0001\u001a\u00020\t8\u0006@BX\u000e¢\u0006\u0010\n\u0006\bÛ\u0001\u0010Ü\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001R\"\u0010ß\u0001\u001a\u000b\u0012\u0004\u0012\u00020\"\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bß\u0001\u0010\u0001R\u0019\u0010à\u0001\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bà\u0001\u0010Ø\u0001R\u0019\u0010á\u0001\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bá\u0001\u0010Ø\u0001R0\u0010ã\u0001\u001a\u0005\u0018\u00010â\u00012\n\u0010Ú\u0001\u001a\u0005\u0018\u00010â\u00018\u0006@BX\u000e¢\u0006\u0010\n\u0006\bã\u0001\u0010ä\u0001\u001a\u0006\bå\u0001\u0010æ\u0001R\u001c\u0010è\u0001\u001a\u0005\u0018\u00010ç\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001R\u001a\u0010E\u001a\u0005\u0018\u00010ç\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bE\u0010é\u0001R\u0019\u0010F\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bF\u0010±\u0001R\u0017\u0010ë\u0001\u001a\u00020\t8BX\u0004¢\u0006\b\u001a\u0006\bê\u0001\u0010Þ\u0001R\u0014\u0010î\u0001\u001a\u00020Z8F¢\u0006\b\u001a\u0006\bì\u0001\u0010í\u0001R\u0016\u0010ð\u0001\u001a\u0004\u0018\u00010@8F¢\u0006\b\u001a\u0006\bï\u0001\u0010Ò\u0001R\u0014\u0010ñ\u0001\u001a\u00020\u00048F¢\u0006\b\u001a\u0006\bñ\u0001\u0010ò\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006ö\u0001"}, d2 = {"Lcom/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigUtil;", "Lcom/m2catalyst/m2sdk/speed_test/legacy/ThroughputTestSystemListener;", "", "seconds", "", "wait", "", "prepareToRunTest", "runTest", "", "dataUsed", "updateDataUsage", "", "tag", "getConfig", "checkIfNewDay", "checkIfNewMonth", "Lcom/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigurationVO;", "obj", "populateConfigVO", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "mnsi", "updateConfig", "(Lcom/m2catalyst/m2sdk/business/models/MNSI;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDefaults", "updateConfigSharedPrefs", "Lorg/json/JSONObject;", "parseIPJSON", "indicator", "parseConfigJSON", "checkTimeConstraint", "cellIdIsUnique", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isTimeBetweenTargetHours", "", "latStart", "lngStart", "latEnd", "lngEnd", "calculateDistance", "resetVariables", "testType", "sendTestBeginEvent", "sendTestStageBeginEvent", "sendTestStageEndEvent", "sendTestEndEvent", "startLatency", "startDownload", "startUpload", "Landroid/location/Location;", "loc", "setUserGeneratedLocation", "Landroid/net/Network;", "network", "activeDataNetworkUpdated", "Landroid/content/Context;", "context", "registerConnectivityChangeReceiver", "listenForActiveDataNetworkChanges", "desiredNetwork", "Landroid/net/ConnectivityManager$NetworkCallback;", "createNetworkCallback", "createDefaultMonitoringNetworkCallback", "signalInfo", "Lcom/m2catalyst/m2sdk/speed_test/legacy/NetworkDiagnosticTestConfig;", "networkDiagnosticTestConfig", "updateInstance", "(Lcom/m2catalyst/m2sdk/business/models/MNSI;Lcom/m2catalyst/m2sdk/speed_test/legacy/NetworkDiagnosticTestConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHandlers", "location", "lastSavedMNSI", "initiateTest", "(Lcom/m2catalyst/m2sdk/speed_test/legacy/NetworkDiagnosticTestConfig;Lcom/m2catalyst/m2sdk/business/models/MNSI;Landroid/location/Location;Landroid/net/Network;Lcom/m2catalyst/m2sdk/business/models/MNSI;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeHandlerThread", "update", "dataLimitReached", "iPAddresses", "testObj", "checkIfAnyTestShouldRun", "isTooSoon", "shouldRunTest", "(Ljava/lang/String;Lcom/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigurationVO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "testHasRunToday", "testHasRunInLastHour", "info", "updateMNSIObject", "finishTesting", "ndtID", "updateUserGeneratedLocation", "(JLandroid/location/Location;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/m2catalyst/m2sdk/ndt/models/DiagnosticsResults;", "results", "throughputTestComplete", "Lcom/m2catalyst/m2sdk/ndt/models/LatencyTestResults;", "latencyTestComplete", "Lcom/m2catalyst/m2sdk/ndt/models/BandwidthTestResults;", "downloadTestComplete", "uploadTestComplete", "webSocketClientOpened", "setTestFailedCalledFalse", "setTestFailedCalledTrue", "reason", "errorCode", "isError", "testFailed", "bytes", "timeDiff", "totalDataUsed", "avgSpeed", "downloadTestUpdate", "packetsReceived", "packetsExpected", "currentSpeed", "uploadTestUpdate", "latency", "totalCount", "currentCount", "jitter", "latencyUpdate", "Lcom/m2catalyst/m2sdk/business/repositories/NDTRepository;", "ndtRepository", "Lcom/m2catalyst/m2sdk/business/repositories/NDTRepository;", "Lcom/m2catalyst/m2sdk/business/repositories/MNSIRepository;", "mnsiRepository", "Lcom/m2catalyst/m2sdk/business/repositories/MNSIRepository;", "Lcom/m2catalyst/m2sdk/speed_test/SpeedTestNDTApiClient;", "ndtApiClient", "Lcom/m2catalyst/m2sdk/speed_test/SpeedTestNDTApiClient;", "Lcom/m2catalyst/m2sdk/g2;", "locationCollectorManager", "Lcom/m2catalyst/m2sdk/g2;", "mContext", "Landroid/content/Context;", "dataLimit", "Ljava/lang/Long;", "Lcom/m2catalyst/m2sdk/q3;", "networkCollectionManager$delegate", "Lkotlin/Lazy;", "getNetworkCollectionManager", "()Lcom/m2catalyst/m2sdk/q3;", "networkCollectionManager", "Ljava/util/ArrayList;", "ipAddresses", "Ljava/util/ArrayList;", "startTime", "I", "getStartTime", "()I", "setStartTime", "(I)V", "endTime", "getEndTime", "setEndTime", "daysOfWeek", "checkIfRoaming", "technologyArray", "mnc", "getMnc", "setMnc", "mcc", "getMcc", "setMcc", "operator", "Ljava/lang/String;", "frequency", "Ljava/lang/Double;", "runDefault", "Z", "runLatency", "runDownload", "runUpload", "configVO", "Lcom/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigurationVO;", "getConfigVO", "()Lcom/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigurationVO;", "setConfigVO", "(Lcom/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigurationVO;)V", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "Landroid/content/SharedPreferences;", "prefs", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences$Editor;", "editor", "Landroid/content/SharedPreferences$Editor;", "Lcom/m2catalyst/m2sdk/speed_test/legacy/NetworkDiagnosticTools;", "ndt", "Lcom/m2catalyst/m2sdk/speed_test/legacy/NetworkDiagnosticTools;", "getNdt", "()Lcom/m2catalyst/m2sdk/speed_test/legacy/NetworkDiagnosticTools;", "setNdt", "(Lcom/m2catalyst/m2sdk/speed_test/legacy/NetworkDiagnosticTools;)V", "Landroid/os/HandlerThread;", "tcuMainThread", "Landroid/os/HandlerThread;", "Landroid/os/Handler;", "tcuMainHandler", "Landroid/os/Handler;", "networkCallbackThread", "networkCallbackHandler", "testFailedCalled", "testNetwork", "Landroid/net/Network;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "defaultMonitoringNetworkCallback", "Landroid/content/BroadcastReceiver;", "connectivityChangeReceiver", "Landroid/content/BroadcastReceiver;", "Lcom/m2catalyst/m2sdk/speed_test/legacy/NetworkDiagnosticTestConfig;", "getNetworkDiagnosticTestConfig", "()Lcom/m2catalyst/m2sdk/speed_test/legacy/NetworkDiagnosticTestConfig;", "setNetworkDiagnosticTestConfig", "(Lcom/m2catalyst/m2sdk/speed_test/legacy/NetworkDiagnosticTestConfig;)V", "currentStage", "numberOfStages", "runningSpeedTotal", "D", "runningCount", "<set-?>", "testNumber", "J", "getTestNumber", "()J", "latencyArray", "runningJitter", "totalLatencyDelta", "Lcom/m2catalyst/m2sdk/speed_test/legacy/TestBaseEvent;", "lastEvent", "Lcom/m2catalyst/m2sdk/speed_test/legacy/TestBaseEvent;", "getLastEvent", "()Lcom/m2catalyst/m2sdk/speed_test/legacy/TestBaseEvent;", "Lcom/m2catalyst/m2sdk/business/models/M2Location;", "userGeneratedLocation", "Lcom/m2catalyst/m2sdk/business/models/M2Location;", "getDataConsumption", "dataConsumption", "getCurrentTestObject", "()Lcom/m2catalyst/m2sdk/ndt/models/DiagnosticsResults;", "currentTestObject", "getCurrentTestConfig", "currentTestConfig", "isMobile", "()Z", "<init>", "(Lcom/m2catalyst/m2sdk/business/repositories/NDTRepository;Lcom/m2catalyst/m2sdk/business/repositories/MNSIRepository;Lcom/m2catalyst/m2sdk/speed_test/SpeedTestNDTApiClient;Lcom/m2catalyst/m2sdk/g2;Landroid/content/Context;)V", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: ThroughputConfigUtil.kt */
public final class ThroughputConfigUtil implements ThroughputTestSystemListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DAY_TO_MILLISECONDS = 86400000;
    public static final long DEFAULT_DATA_LIMIT = 52428800;
    public static final int DEFAULT_TOTAL_DATA_SIZE = 2048000;
    public static final String DOWNLOAD_TAG = "_download";
    private static final long FIRST_RUN_WAITING_PERIOD = 300000;
    private static final long HOUR_TO_MILLISECONDS = 3600000;
    public static final String INDICATOR_DEFAULT = "default";
    private static final String INDICATOR_DOWNLOAD = "download";
    private static final String INDICATOR_LATENCY = "latency";
    private static final String INDICATOR_UPLOAD = "upload";
    public static final String LATENCY_TAG = "_latency";
    public static final String NDT_WAIT_FIRST_RUN = "ndt_wait_first_time";
    public static final String SHARED_PREFS_FIRST_CHECK = "shared_prefs_first_check";
    public static final String SHARED_PREFS_KEY_CURRENT_MONTH = "current_month";
    public static final String SHARED_PREFS_KEY_DATA_LIMIT = "data_limit";
    public static final String SHARED_PREFS_KEY_DATA_USED = "data_used";
    public static final String SHARED_PREFS_KEY_DAY_OF_WEEK_CONSTRAINT = "days_of_week_constraint";
    public static final String SHARED_PREFS_KEY_END_TIME_CONSTRAINT = "end_time_constraint";
    public static final String SHARED_PREFS_KEY_FREQUENCY = "frequency";
    public static final String SHARED_PREFS_KEY_LAST_CONFIG_UPDATE = "last_update";
    public static final String SHARED_PREFS_KEY_LAST_TEST_RUN_DATE = "last_test_run_date";
    public static final String SHARED_PREFS_KEY_MCC = "mcc";
    public static final String SHARED_PREFS_KEY_MNC = "mnc";
    public static final String SHARED_PREFS_KEY_OPERATOR = "operator";
    public static final String SHARED_PREFS_KEY_ROAMING_CONSTRAINT = "roaming_constraint";
    private static final String SHARED_PREFS_KEY_RUN_DEFAULT = "run_default";
    private static final String SHARED_PREFS_KEY_RUN_DOWNLOAD = "run_download";
    private static final String SHARED_PREFS_KEY_RUN_LATENCY = "run_latency";
    private static final String SHARED_PREFS_KEY_RUN_UPLOAD = "run_upload";
    public static final String SHARED_PREFS_KEY_START_TIME_CONSTRAINT = "start_time_constraint";
    public static final String SHARED_PREFS_KEY_TECHNOLOGY = "technology";
    public static final String SHARED_PREFS_NAME = "throughput_config";
    public static final String TAG = "TCU";
    public static final String UPLOAD_TAG = "_upload";
    private int checkIfRoaming;
    private ThroughputConfigurationVO configVO;
    private BroadcastReceiver connectivityChangeReceiver;
    private int currentStage;
    private Long dataLimit;
    private ArrayList<Integer> daysOfWeek;
    /* access modifiers changed from: private */
    public ConnectivityManager.NetworkCallback defaultMonitoringNetworkCallback;
    private SharedPreferences.Editor editor;
    private int endTime;
    private Double frequency;
    private final ArrayList<String> ipAddresses = new ArrayList<>();
    private TestBaseEvent lastEvent;
    private MNSI lastSavedMNSI;
    private ArrayList<Double> latencyArray;
    /* access modifiers changed from: private */
    public M2Location location;
    /* access modifiers changed from: private */
    public final g2 locationCollectorManager;
    /* access modifiers changed from: private */
    public final Context mContext;
    private int mcc;
    private int mnc;
    /* access modifiers changed from: private */
    public final MNSIRepository mnsiRepository;
    private NetworkDiagnosticTools ndt;
    private final SpeedTestNDTApiClient ndtApiClient;
    /* access modifiers changed from: private */
    public final NDTRepository ndtRepository;
    /* access modifiers changed from: private */
    public ConnectivityManager.NetworkCallback networkCallback;
    private Handler networkCallbackHandler;
    private HandlerThread networkCallbackThread;
    private final Lazy networkCollectionManager$delegate = KoinJavaComponent.inject$default(q3.class, (Qualifier) null, (Function0) null, 6, (Object) null);
    private NetworkDiagnosticTestConfig networkDiagnosticTestConfig;
    private int numberOfStages;
    private String operator;
    private SharedPreferences prefs;
    private boolean runDefault;
    private boolean runDownload;
    private boolean runLatency;
    private boolean runUpload;
    private double runningCount;
    private double runningJitter;
    private double runningSpeedTotal;
    /* access modifiers changed from: private */
    public MNSI signalInfo;
    private int startTime;
    /* access modifiers changed from: private */
    public Handler tcuMainHandler;
    private HandlerThread tcuMainThread;
    private ArrayList<Integer> technologyArray;
    /* access modifiers changed from: private */
    public boolean testFailedCalled;
    private Network testNetwork;
    private long testNumber;
    private double totalLatencyDelta;
    /* access modifiers changed from: private */
    public M2Location userGeneratedLocation;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigUtil$Companion;", "", "()V", "DAY_TO_MILLISECONDS", "", "DEFAULT_DATA_LIMIT", "DEFAULT_TOTAL_DATA_SIZE", "", "DOWNLOAD_TAG", "", "FIRST_RUN_WAITING_PERIOD", "HOUR_TO_MILLISECONDS", "INDICATOR_DEFAULT", "INDICATOR_DOWNLOAD", "INDICATOR_LATENCY", "INDICATOR_UPLOAD", "LATENCY_TAG", "NDT_WAIT_FIRST_RUN", "SHARED_PREFS_FIRST_CHECK", "SHARED_PREFS_KEY_CURRENT_MONTH", "SHARED_PREFS_KEY_DATA_LIMIT", "SHARED_PREFS_KEY_DATA_USED", "SHARED_PREFS_KEY_DAY_OF_WEEK_CONSTRAINT", "SHARED_PREFS_KEY_END_TIME_CONSTRAINT", "SHARED_PREFS_KEY_FREQUENCY", "SHARED_PREFS_KEY_LAST_CONFIG_UPDATE", "SHARED_PREFS_KEY_LAST_TEST_RUN_DATE", "SHARED_PREFS_KEY_MCC", "SHARED_PREFS_KEY_MNC", "SHARED_PREFS_KEY_OPERATOR", "SHARED_PREFS_KEY_ROAMING_CONSTRAINT", "SHARED_PREFS_KEY_RUN_DEFAULT", "SHARED_PREFS_KEY_RUN_DOWNLOAD", "SHARED_PREFS_KEY_RUN_LATENCY", "SHARED_PREFS_KEY_RUN_UPLOAD", "SHARED_PREFS_KEY_START_TIME_CONSTRAINT", "SHARED_PREFS_KEY_TECHNOLOGY", "SHARED_PREFS_NAME", "TAG", "UPLOAD_TAG", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ThroughputConfigUtil.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ThroughputConfigUtil(NDTRepository nDTRepository, MNSIRepository mNSIRepository, SpeedTestNDTApiClient speedTestNDTApiClient, g2 g2Var, Context context) {
        Intrinsics.checkNotNullParameter(nDTRepository, "ndtRepository");
        Intrinsics.checkNotNullParameter(mNSIRepository, "mnsiRepository");
        Intrinsics.checkNotNullParameter(speedTestNDTApiClient, "ndtApiClient");
        Intrinsics.checkNotNullParameter(g2Var, "locationCollectorManager");
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.ndtRepository = nDTRepository;
        this.mnsiRepository = mNSIRepository;
        this.ndtApiClient = speedTestNDTApiClient;
        this.locationCollectorManager = g2Var;
        this.mContext = context;
        NetworkDiagnosticTools instance = NetworkDiagnosticTools.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        this.ndt = instance;
        Intrinsics.checkNotNull(instance);
        instance.registerListener(this);
        Intrinsics.checkNotNull(context);
        this.prefs = context.getSharedPreferences(SHARED_PREFS_NAME, 0);
        setHandlers();
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        HandlerThread handlerThread = this.networkCallbackThread;
        Intrinsics.checkNotNull(handlerThread);
        int threadId = handlerThread.getThreadId();
        logger.d(TAG, "Handler Thread 2 - " + threadId, new String[0]);
    }

    /* access modifiers changed from: private */
    public final void activeDataNetworkUpdated(Network network) {
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        M2SDKLogger logger = companion.getLogger("NDT");
        NetworkDiagnosticTestConfig currentTestConfig = getCurrentTestConfig();
        Intrinsics.checkNotNull(currentTestConfig);
        int i = currentTestConfig.testType;
        int i2 = this.currentStage;
        logger.d(TAG, "Default data network has changed. " + i + ", " + i2, new String[0]);
        NetworkDiagnosticTestConfig currentTestConfig2 = getCurrentTestConfig();
        Intrinsics.checkNotNull(currentTestConfig2);
        if (!(currentTestConfig2.testType == 0 && this.currentStage == 1)) {
            NetworkDiagnosticTestConfig currentTestConfig3 = getCurrentTestConfig();
            Intrinsics.checkNotNull(currentTestConfig3);
            if (!(currentTestConfig3.testType == 1 && this.currentStage == 1)) {
                return;
            }
        }
        Network network2 = this.testNetwork;
        if (network2 == null || !Intrinsics.areEqual((Object) network2, (Object) network)) {
            testFailed("Default data network does not match test network", 7, true);
            M2SDKLogger logger2 = companion.getLogger("NDT");
            Network network3 = this.testNetwork;
            logger2.d(TAG, "Default data network does not match test network - testNetwork:" + network3 + ",network: " + network, new String[0]);
        }
    }

    /* access modifiers changed from: private */
    public final double calculateDistance(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d3 - d);
        double radians2 = Math.toRadians(d4 - d2);
        double d5 = (double) 2;
        Double.isNaN(d5);
        double pow = Math.pow(Math.sin(radians / d5), 2.0d);
        Double.isNaN(d5);
        double asin = Math.asin(Math.sqrt((Math.cos(Math.toRadians(d3)) * Math.cos(Math.toRadians(d)) * Math.pow(Math.sin(radians2 / d5), 2.0d)) + pow));
        Double.isNaN(d5);
        double d6 = (double) 6371;
        Double.isNaN(d6);
        return d6 * asin * d5;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object cellIdIsUnique(kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$cellIdIsUnique$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$cellIdIsUnique$1 r0 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$cellIdIsUnique$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$cellIdIsUnique$1 r0 = new com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$cellIdIsUnique$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r4) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0057
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.m2catalyst.m2sdk.business.models.MNSI r6 = r5.signalInfo
            if (r6 == 0) goto L_0x003f
            java.lang.String r6 = r6.getUniqueCellIdentifier()
            if (r6 != 0) goto L_0x0041
        L_0x003f:
            java.lang.String r6 = ""
        L_0x0041:
            int r2 = r6.length()
            if (r2 <= 0) goto L_0x0049
            r2 = 1
            goto L_0x004a
        L_0x0049:
            r2 = 0
        L_0x004a:
            if (r2 == 0) goto L_0x0061
            com.m2catalyst.m2sdk.business.repositories.NDTRepository r2 = r5.ndtRepository
            r0.label = r4
            java.lang.Object r6 = r2.isCellIdUniqueForNetworkTest(r6, r0)
            if (r6 != r1) goto L_0x0057
            return r1
        L_0x0057:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            r0 = 3
            if (r6 > r0) goto L_0x0061
            r3 = 1
        L_0x0061:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil.cellIdIsUnique(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean checkIfNewDay() {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences);
        return currentTimeMillis - sharedPreferences.getLong(SHARED_PREFS_KEY_LAST_TEST_RUN_DATE, 0) > DAY_TO_MILLISECONDS;
    }

    private final void checkIfNewMonth() {
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, 0);
        this.prefs = sharedPreferences;
        Intrinsics.checkNotNull(sharedPreferences);
        this.editor = sharedPreferences.edit();
        SharedPreferences sharedPreferences2 = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences2);
        int i = sharedPreferences2.getInt(SHARED_PREFS_KEY_CURRENT_MONTH, -1);
        int i2 = Calendar.getInstance().get(2);
        if (i == -1 || i != i2) {
            SharedPreferences.Editor editor2 = this.editor;
            Intrinsics.checkNotNull(editor2);
            editor2.putLong(SHARED_PREFS_KEY_DATA_USED, 0);
            SharedPreferences.Editor editor3 = this.editor;
            Intrinsics.checkNotNull(editor3);
            editor3.putInt(SHARED_PREFS_KEY_CURRENT_MONTH, i2);
            SharedPreferences.Editor editor4 = this.editor;
            Intrinsics.checkNotNull(editor4);
            editor4.commit();
        }
    }

    private final boolean checkTimeConstraint(String str, ThroughputConfigurationVO throughputConfigurationVO) {
        if (!Intrinsics.areEqual(throughputConfigurationVO.frequency, 0.0d)) {
            if (StringsKt.equals(str, "default", true)) {
                long currentTimeMillis = System.currentTimeMillis();
                SharedPreferences sharedPreferences = this.prefs;
                Intrinsics.checkNotNull(sharedPreferences);
                double d = (double) DAY_TO_MILLISECONDS;
                Double d2 = throughputConfigurationVO.frequency;
                Intrinsics.checkNotNullExpressionValue(d2, "obj.frequency");
                double doubleValue = d2.doubleValue();
                Double.isNaN(d);
                if (((double) (currentTimeMillis - sharedPreferences.getLong(SHARED_PREFS_KEY_LAST_TEST_RUN_DATE, 0))) > d / doubleValue) {
                    return true;
                }
            } else if (StringsKt.equals(str, INDICATOR_LATENCY, true)) {
                long currentTimeMillis2 = System.currentTimeMillis();
                SharedPreferences sharedPreferences2 = this.prefs;
                Intrinsics.checkNotNull(sharedPreferences2);
                double d3 = (double) DAY_TO_MILLISECONDS;
                Double d4 = throughputConfigurationVO.frequency;
                Intrinsics.checkNotNullExpressionValue(d4, "obj.frequency");
                double doubleValue2 = d4.doubleValue();
                Double.isNaN(d3);
                if (((double) (currentTimeMillis2 - sharedPreferences2.getLong("last_test_run_date_latency", 0))) > d3 / doubleValue2) {
                    return true;
                }
            } else if (StringsKt.equals(str, "download", true)) {
                long currentTimeMillis3 = System.currentTimeMillis();
                SharedPreferences sharedPreferences3 = this.prefs;
                Intrinsics.checkNotNull(sharedPreferences3);
                double d5 = (double) DAY_TO_MILLISECONDS;
                Double d6 = throughputConfigurationVO.frequency;
                Intrinsics.checkNotNullExpressionValue(d6, "obj.frequency");
                double doubleValue3 = d6.doubleValue();
                Double.isNaN(d5);
                if (((double) (currentTimeMillis3 - sharedPreferences3.getLong("last_test_run_date_download", 0))) > d5 / doubleValue3) {
                    return true;
                }
            } else if (StringsKt.equals(str, INDICATOR_UPLOAD, true)) {
                long currentTimeMillis4 = System.currentTimeMillis();
                SharedPreferences sharedPreferences4 = this.prefs;
                Intrinsics.checkNotNull(sharedPreferences4);
                double d7 = (double) DAY_TO_MILLISECONDS;
                Double d8 = throughputConfigurationVO.frequency;
                Intrinsics.checkNotNullExpressionValue(d8, "obj.frequency");
                double doubleValue4 = d8.doubleValue();
                Double.isNaN(d7);
                if (((double) (currentTimeMillis4 - sharedPreferences4.getLong("last_test_run_date_upload", 0))) > d7 / doubleValue4) {
                    return true;
                }
            }
        }
        return false;
    }

    private final ConnectivityManager.NetworkCallback createDefaultMonitoringNetworkCallback() {
        return new ThroughputConfigUtil$createDefaultMonitoringNetworkCallback$1(this);
    }

    private final ConnectivityManager.NetworkCallback createNetworkCallback(Network network) {
        return new ThroughputConfigUtil$createNetworkCallback$1(network, this);
    }

    private final void getConfig(String str) {
        String str2 = str;
        int i = 0;
        M2SDKLogger.Companion.getLogger("NDT").d(TAG, "Get configuration Get config " + str2, new String[0]);
        SharedPreferences sharedPreferences = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences);
        this.dataLimit = Long.valueOf(sharedPreferences.getLong(SHARED_PREFS_KEY_DATA_LIMIT, DEFAULT_DATA_LIMIT));
        SharedPreferences sharedPreferences2 = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences2);
        this.startTime = sharedPreferences2.getInt(SHARED_PREFS_KEY_START_TIME_CONSTRAINT + str2, -1);
        SharedPreferences sharedPreferences3 = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences3);
        this.endTime = sharedPreferences3.getInt(SHARED_PREFS_KEY_END_TIME_CONSTRAINT + str2, -1);
        SharedPreferences sharedPreferences4 = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences4);
        this.checkIfRoaming = sharedPreferences4.getInt(SHARED_PREFS_KEY_ROAMING_CONSTRAINT + str2, 0);
        ArrayList<Integer> arrayList = this.technologyArray;
        if (arrayList == null) {
            this.technologyArray = new ArrayList<>();
        } else {
            Intrinsics.checkNotNull(arrayList);
            arrayList.clear();
        }
        SharedPreferences sharedPreferences5 = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences5);
        String string = sharedPreferences5.getString(SHARED_PREFS_KEY_TECHNOLOGY + str2, (String) null);
        if (string != null) {
            if (!(string.length() == 0)) {
                Object[] array = StringsKt.split$default((CharSequence) string, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                for (String parseInt : (String[]) array) {
                    ArrayList<Integer> arrayList2 = this.technologyArray;
                    Intrinsics.checkNotNull(arrayList2);
                    arrayList2.add(Integer.valueOf(Integer.parseInt(parseInt)));
                }
            }
        }
        SharedPreferences sharedPreferences6 = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences6);
        this.mnc = sharedPreferences6.getInt(SHARED_PREFS_KEY_MNC + str2, -1);
        SharedPreferences sharedPreferences7 = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences7);
        this.mcc = sharedPreferences7.getInt(SHARED_PREFS_KEY_MCC + str2, -1);
        SharedPreferences sharedPreferences8 = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences8);
        this.operator = sharedPreferences8.getString(SHARED_PREFS_KEY_OPERATOR + str2, (String) null);
        ArrayList<Integer> arrayList3 = this.daysOfWeek;
        if (arrayList3 == null) {
            this.daysOfWeek = new ArrayList<>();
        } else {
            Intrinsics.checkNotNull(arrayList3);
            arrayList3.clear();
        }
        SharedPreferences sharedPreferences9 = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences9);
        String string2 = sharedPreferences9.getString(SHARED_PREFS_KEY_DAY_OF_WEEK_CONSTRAINT + str2, (String) null);
        if (string2 != null) {
            if (!(string2.length() == 0)) {
                Object[] array2 = StringsKt.split$default((CharSequence) string2, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array2;
                int length = strArr.length;
                while (i < length) {
                    String str3 = strArr[i];
                    try {
                        ArrayList<Integer> arrayList4 = this.daysOfWeek;
                        Intrinsics.checkNotNull(arrayList4);
                        arrayList4.add(Integer.valueOf(Integer.parseInt(str3)));
                    } catch (Exception unused) {
                    }
                    i++;
                }
                SharedPreferences sharedPreferences10 = this.prefs;
                Intrinsics.checkNotNull(sharedPreferences10);
                this.frequency = Double.valueOf((double) sharedPreferences10.getFloat(SHARED_PREFS_KEY_FREQUENCY + str2, 0.0f));
            }
        }
        while (i < 7) {
            try {
                ArrayList<Integer> arrayList5 = this.daysOfWeek;
                Intrinsics.checkNotNull(arrayList5);
                arrayList5.add(1);
            } catch (Exception unused2) {
            }
            i++;
        }
        SharedPreferences sharedPreferences102 = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences102);
        this.frequency = Double.valueOf((double) sharedPreferences102.getFloat(SHARED_PREFS_KEY_FREQUENCY + str2, 0.0f));
    }

    private final long getDataConsumption() {
        SharedPreferences sharedPreferences = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences);
        return sharedPreferences.getLong(SHARED_PREFS_KEY_DATA_USED, 0);
    }

    /* access modifiers changed from: private */
    public final q3 getNetworkCollectionManager() {
        return (q3) this.networkCollectionManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0219  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void initiateTest$lambda$1(boolean r19, com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r20, com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r21, com.m2catalyst.m2sdk.business.models.MNSI r22, boolean r23, long r24) {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            java.lang.String r3 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "$networkDiagnosticTestConfig"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            r3 = 0
            if (r19 != 0) goto L_0x001a
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r0 = r0.ndt
            r0.setTestRunning(r3)
            return
        L_0x001a:
            int r4 = r21.getTrigger()
            java.lang.String r5 = "TCU"
            java.lang.String r6 = "NDT"
            r7 = 1
            if (r4 == r7) goto L_0x002c
            int r4 = r21.getTrigger()
            r8 = 2
            if (r4 != r8) goto L_0x020d
        L_0x002c:
            int r4 = r1.testType
            if (r4 == r7) goto L_0x020d
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r4 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r4 = r4.getLogger(r6)
            java.lang.String[] r8 = new java.lang.String[r3]
            java.lang.String r9 = "Run Initial Test..."
            r4.d(r5, r9, r8)
            r0.signalInfo = r2
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r4 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.getInstance()
            android.content.Context r8 = r0.mContext     // Catch:{ Exception -> 0x0049 }
            r4.initializeNewTest(r8, r2, r1)     // Catch:{ Exception -> 0x0049 }
            goto L_0x004a
        L_0x0049:
        L_0x004a:
            if (r23 != 0) goto L_0x0054
            java.lang.String r1 = "Unable to get IP Addresses"
            r2 = 4
            r0.testFailed(r1, r2, r7)
            goto L_0x020b
        L_0x0054:
            com.m2catalyst.m2sdk.business.models.MNSI r2 = r0.signalInfo
            if (r2 != 0) goto L_0x0065
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r2 = r2.getLogger(r6)
            java.lang.String[] r8 = new java.lang.String[r3]
            java.lang.String r9 = "Creating speed test with no ndt"
            r2.d(r5, r9, r8)
        L_0x0065:
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputTestStatus r2 = new com.m2catalyst.m2sdk.speed_test.legacy.ThroughputTestStatus
            r2.<init>()
            r4.registerListener(r2)
            r8 = 40960(0xa000, float:5.7397E-41)
            r9 = 3
            r10 = 10240(0x2800, float:1.4349E-41)
            boolean r8 = r4.setUpWebSocketClient(r10, r8, r9)
            if (r8 == 0) goto L_0x020b
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r8 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r8 = r8.getLogger(r6)
            java.lang.String[] r9 = new java.lang.String[r3]
            java.lang.String r10 = "Run Initial Test... waiting for connection"
            r8.d(r5, r10, r9)
            r8 = 0
        L_0x0087:
            boolean r9 = r2.connected
            r10 = 60
            if (r9 != 0) goto L_0x0099
            boolean r9 = r2.testFailed
            if (r9 != 0) goto L_0x0099
            if (r8 >= r10) goto L_0x0099
            int r8 = r8 + 1
            r0.wait(r7)
            goto L_0x0087
        L_0x0099:
            boolean r9 = r2.testFailed
            if (r9 == 0) goto L_0x00bb
            org.greenrobot.eventbus.EventBus r0 = org.greenrobot.eventbus.EventBus.getDefault()
            com.m2catalyst.m2sdk.speed_test.legacy.TestErrorEvent r14 = new com.m2catalyst.m2sdk.speed_test.legacy.TestErrorEvent
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.String r10 = r2.testFailureReason
            int r13 = r21.getTrigger()
            r8 = -1
            r9 = 6
            r11 = -1
            r12 = -1
            r3 = r14
            r4 = r24
            r3.<init>(r4, r6, r8, r9, r10, r11, r12, r13)
            r0.postSticky(r14)
            return
        L_0x00bb:
            if (r8 < r10) goto L_0x00db
            org.greenrobot.eventbus.EventBus r0 = org.greenrobot.eventbus.EventBus.getDefault()
            com.m2catalyst.m2sdk.speed_test.legacy.TestErrorEvent r12 = new com.m2catalyst.m2sdk.speed_test.legacy.TestErrorEvent
            long r4 = java.lang.System.currentTimeMillis()
            int r11 = r21.getTrigger()
            r6 = -1
            r7 = 6
            java.lang.String r8 = "Timeout"
            r9 = -1
            r10 = -1
            r1 = r12
            r2 = r24
            r1.<init>(r2, r4, r6, r7, r8, r9, r10, r11)
            r0.postSticky(r12)
            return
        L_0x00db:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r8 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r8 = r8.getLogger(r6)
            java.lang.String[] r9 = new java.lang.String[r3]
            java.lang.String r11 = "Run Initial Test... run download test"
            r8.d(r5, r11, r9)
            r4.runDownloadTest()
            r8 = 0
        L_0x00ec:
            boolean r9 = r2.downloadTestCompleted
            if (r9 != 0) goto L_0x00fc
            boolean r9 = r2.testFailed
            if (r9 != 0) goto L_0x00fc
            if (r8 >= r10) goto L_0x00fc
            int r8 = r8 + 1
            r0.wait(r7)
            goto L_0x00ec
        L_0x00fc:
            r4.disconnect()
            boolean r4 = r2.testFailed
            if (r4 == 0) goto L_0x0126
            org.greenrobot.eventbus.EventBus r4 = org.greenrobot.eventbus.EventBus.getDefault()
            com.m2catalyst.m2sdk.speed_test.legacy.TestErrorEvent r15 = new com.m2catalyst.m2sdk.speed_test.legacy.TestErrorEvent
            long r11 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = r2.testFailureReason
            int r18 = r21.getTrigger()
            r13 = -1
            r14 = 6
            r16 = -1
            r17 = -1
            r8 = r15
            r9 = r24
            r1 = r15
            r15 = r2
            r8.<init>(r9, r11, r13, r14, r15, r16, r17, r18)
            r4.postSticky(r1)
            goto L_0x020b
        L_0x0126:
            if (r8 < r10) goto L_0x0149
            org.greenrobot.eventbus.EventBus r2 = org.greenrobot.eventbus.EventBus.getDefault()
            com.m2catalyst.m2sdk.speed_test.legacy.TestErrorEvent r4 = new com.m2catalyst.m2sdk.speed_test.legacy.TestErrorEvent
            long r11 = java.lang.System.currentTimeMillis()
            int r18 = r21.getTrigger()
            r13 = -1
            r14 = 6
            java.lang.String r15 = "Timeout"
            r16 = -1
            r17 = -1
            r8 = r4
            r9 = r24
            r8.<init>(r9, r11, r13, r14, r15, r16, r17, r18)
            r2.postSticky(r4)
            goto L_0x020b
        L_0x0149:
            com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults r4 = r2.downloadTestResults
            java.lang.Float r4 = r4.getAvg()
            com.m2catalyst.m2sdk.s1.a((java.lang.Float) r4)
            r4 = 1024(0x400, float:1.435E-42)
            float r4 = (float) r4
            r8 = 8
            float r8 = (float) r8
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r9 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r9 = r9.getLogger(r6)
            com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults r10 = r2.downloadTestResults
            java.lang.Float r10 = r10.getAvg()
            float r10 = com.m2catalyst.m2sdk.s1.a((java.lang.Float) r10)
            float r10 = r10 / r4
            float r10 = r10 / r4
            float r10 = r10 * r8
            java.lang.String r4 = java.lang.Float.toString(r10)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "Run Initial Test...  complete"
            r8.<init>(r10)
            r8.append(r4)
            java.lang.String r4 = " Mbs"
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            java.lang.String[] r8 = new java.lang.String[r3]
            r9.d(r5, r4, r8)
            org.greenrobot.eventbus.EventBus r4 = org.greenrobot.eventbus.EventBus.getDefault()
            com.m2catalyst.m2sdk.speed_test.legacy.TestSnifferEvent r8 = new com.m2catalyst.m2sdk.speed_test.legacy.TestSnifferEvent
            com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults r9 = r2.downloadTestResults
            java.lang.Float r9 = r9.getAvg()
            r10 = 0
            r11 = r24
            r8.<init>(r11, r9, r10)
            r4.postSticky(r8)
            com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults r4 = r2.downloadTestResults
            java.lang.Float r4 = r4.getAvg()
            float r4 = com.m2catalyst.m2sdk.s1.a((java.lang.Float) r4)
            double r8 = (double) r4
            r10 = 4668431373732256154(0x40c999999999999a, double:13107.2)
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 >= 0) goto L_0x01bb
            r4 = 122880(0x1e000, float:1.72192E-40)
            r1.maxDataSize = r4
            r4 = 30720(0x7800, float:4.3048E-41)
            r1.packetDataSize = r4
            goto L_0x01f0
        L_0x01bb:
            com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults r4 = r2.downloadTestResults
            java.lang.Float r4 = r4.getAvg()
            float r4 = com.m2catalyst.m2sdk.s1.a((java.lang.Float) r4)
            double r8 = (double) r4
            r10 = 4683743612465315840(0x4100000000000000, double:131072.0)
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 >= 0) goto L_0x01d7
            r4 = 1228800(0x12c000, float:1.721916E-39)
            r1.maxDataSize = r4
            r4 = 102400(0x19000, float:1.43493E-40)
            r1.packetDataSize = r4
            goto L_0x01f0
        L_0x01d7:
            com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults r4 = r2.downloadTestResults
            java.lang.Float r4 = r4.getAvg()
            float r4 = com.m2catalyst.m2sdk.s1.a((java.lang.Float) r4)
            double r8 = (double) r4
            r10 = 4698380311254269952(0x4134000000000000, double:1310720.0)
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 >= 0) goto L_0x01f0
            r4 = 10485760(0xa00000, float:1.469368E-38)
            r1.maxDataSize = r4
            r4 = 131072(0x20000, float:1.83671E-40)
            r1.packetDataSize = r4
        L_0x01f0:
            boolean r4 = r20.isMobile()
            if (r4 == 0) goto L_0x01fe
            java.lang.String r4 = "1.061"
            r1.setLibreDlOverheadFactor(r4)
            r1.setLibreUlOverheadFactor(r4)
        L_0x01fe:
            com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults r2 = r2.downloadTestResults
            java.lang.Float r2 = r2.getAvg()
            r21.getLibreUlOverheadFactor()
            java.util.Objects.toString(r2)
            goto L_0x020d
        L_0x020b:
            r1 = 0
            goto L_0x020e
        L_0x020d:
            r1 = 1
        L_0x020e:
            if (r1 == 0) goto L_0x0219
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r1 = r0.ndt
            r1.registerListener(r0)
            r20.prepareToRunTest()
            goto L_0x022b
        L_0x0219:
            r1 = 100
            java.lang.String r2 = "Error setting up test to run."
            r0.testFailed(r2, r1, r7)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r0.getLogger(r6)
            java.lang.String[] r1 = new java.lang.String[r3]
            r0.d(r5, r2, r1)
        L_0x022b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil.initiateTest$lambda$1(boolean, com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil, com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig, com.m2catalyst.m2sdk.business.models.MNSI, boolean, long):void");
    }

    private final boolean isTimeBetweenTargetHours(ThroughputConfigurationVO throughputConfigurationVO) {
        int i = Calendar.getInstance().get(11);
        int i2 = throughputConfigurationVO.startTime;
        int i3 = throughputConfigurationVO.endTime;
        if (i2 == i3 || i2 == -1 || i3 == -1) {
            return true;
        }
        return i >= i2 && i <= i3;
    }

    private final void listenForActiveDataNetworkChanges(Network network) {
        int i;
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
        if (networkCapabilities == null) {
            setTestFailedCalledFalse();
            testFailed("Network Unavailable", 9, true);
            M2SDKLogger.Companion.getLogger("NDT").d(TAG, "Network Unavailable - networkCapabilities:null", new String[0]);
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 25) {
            registerConnectivityChangeReceiver(this.mContext);
        } else {
            ConnectivityManager.NetworkCallback createDefaultMonitoringNetworkCallback = createDefaultMonitoringNetworkCallback();
            this.defaultMonitoringNetworkCallback = createDefaultMonitoringNetworkCallback;
            Intrinsics.checkNotNull(createDefaultMonitoringNetworkCallback);
            Handler handler = this.networkCallbackHandler;
            Intrinsics.checkNotNull(handler);
            connectivityManager.registerDefaultNetworkCallback(createDefaultMonitoringNetworkCallback, handler);
        }
        if (networkCapabilities.hasTransport(0)) {
            i = 0;
        } else {
            i = networkCapabilities.hasTransport(1) ? 1 : -1;
        }
        if (i == -1) {
            setTestFailedCalledFalse();
            testFailed("Network Unavailable", 9, true);
            M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
            logger.d(TAG, "Network Unavailable - desiredTransportType:" + i, new String[0]);
            return;
        }
        try {
            NetworkRequest build = new NetworkRequest.Builder().addTransportType(i).build();
            this.networkCallback = createNetworkCallback(network);
            M2SDKLogger logger2 = M2SDKLogger.Companion.getLogger("NDT");
            ConnectivityManager.NetworkCallback networkCallback2 = this.networkCallback;
            logger2.d("NDT", "register callback - " + networkCallback2, new String[0]);
            if (i2 >= 26) {
                ConnectivityManager.NetworkCallback networkCallback3 = this.networkCallback;
                Intrinsics.checkNotNull(networkCallback3);
                Handler handler2 = this.networkCallbackHandler;
                Intrinsics.checkNotNull(handler2);
                connectivityManager.registerNetworkCallback(build, networkCallback3, handler2);
                return;
            }
            ConnectivityManager.NetworkCallback networkCallback4 = this.networkCallback;
            Intrinsics.checkNotNull(networkCallback4);
            connectivityManager.registerNetworkCallback(build, networkCallback4);
        } catch (IllegalArgumentException unused) {
            setTestFailedCalledFalse();
            testFailed("Invalid Network Type", 7, true);
            M2SDKLogger.Companion.getLogger("NDT").d(TAG, "Invalid Network Type:7", new String[0]);
        }
    }

    private final void parseConfigJSON(JSONObject jSONObject, String str) {
        try {
            if (StringsKt.equals(str, "default", true)) {
                this.dataLimit = Long.valueOf(jSONObject.optLong("maxDataLimit", DEFAULT_DATA_LIMIT));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(SHARED_PREFS_KEY_TECHNOLOGY);
            if (optJSONArray != null) {
                this.technologyArray = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    ArrayList<Integer> arrayList = this.technologyArray;
                    Intrinsics.checkNotNull(arrayList);
                    arrayList.add(Integer.valueOf(optJSONArray.getInt(i)));
                }
            }
            this.mnc = jSONObject.optInt(SHARED_PREFS_KEY_MNC, -1);
            this.mcc = jSONObject.optInt(SHARED_PREFS_KEY_MCC, -1);
            this.operator = jSONObject.optString(SHARED_PREFS_KEY_OPERATOR, (String) null);
            this.checkIfRoaming = jSONObject.optInt("roaming", 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("time");
            if (optJSONObject != null) {
                this.startTime = optJSONObject.optInt("startHour", -1);
                this.endTime = optJSONObject.optInt("endHour", -1);
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("days");
                if (optJSONArray2 != null) {
                    this.daysOfWeek = new ArrayList<>();
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        ArrayList<Integer> arrayList2 = this.daysOfWeek;
                        Intrinsics.checkNotNull(arrayList2);
                        arrayList2.add(Integer.valueOf(optJSONArray2.getInt(i2)));
                    }
                }
            } else {
                this.startTime = -1;
                this.endTime = -1;
                this.daysOfWeek = null;
            }
            this.frequency = Double.valueOf(jSONObject.optDouble(SHARED_PREFS_KEY_FREQUENCY, 0.0d));
        } catch (JSONException e) {
            e.printStackTrace();
            M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
            String localizedMessage = e.getLocalizedMessage();
            logger.e(TAG, "JSON ERROR" + localizedMessage, new String[0]);
        }
    }

    private final void parseIPJSON(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("servers");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    this.ipAddresses.add(optJSONArray.getString(i));
                }
            }
        } catch (JSONException e) {
            M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
            String localizedMessage = e.getLocalizedMessage();
            logger.e(TAG, "IP JSON exception" + localizedMessage, new String[0]);
        }
    }

    private final void populateConfigVO(ThroughputConfigurationVO throughputConfigurationVO) {
        Long l = this.dataLimit;
        Intrinsics.checkNotNull(l);
        throughputConfigurationVO.dataLimit = l.longValue();
        throughputConfigurationVO.startTime = this.startTime;
        throughputConfigurationVO.endTime = this.endTime;
        throughputConfigurationVO.checkIfRoaming = this.checkIfRoaming;
        throughputConfigurationVO.technologyArray = this.technologyArray;
        throughputConfigurationVO.mnc = this.mnc;
        throughputConfigurationVO.mcc = this.mcc;
        throughputConfigurationVO.operator = this.operator;
        throughputConfigurationVO.daysOfWeek = this.daysOfWeek;
        throughputConfigurationVO.frequency = this.frequency;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r5.getTrigger() == 2) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void prepareToRunTest() {
        /*
            r7 = this;
            android.content.Context r0 = r7.mContext
            if (r0 == 0) goto L_0x0009
            android.net.Network r0 = com.m2catalyst.m2sdk.m4.a((android.content.Context) r0)
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.lang.String r1 = "TCU"
            java.lang.String r2 = "NDT"
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0066
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r5 = r7.networkDiagnosticTestConfig
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r5 = r5.getTrigger()
            if (r5 == r4) goto L_0x0029
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r5 = r7.networkDiagnosticTestConfig
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r5 = r5.getTrigger()
            r6 = 2
            if (r5 != r6) goto L_0x0060
        L_0x0029:
            android.net.Network r5 = r7.testNetwork
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x0060
            java.lang.String r5 = "Invalid data network type."
            r6 = 7
            r7.testFailed(r5, r6, r4)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r4 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r2 = r4.getLogger(r2)
            android.net.Network r4 = r7.testNetwork
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Invalid data network type. - activeDataNetwork("
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r0 = ") != testNetwork("
            r5.append(r0)
            r5.append(r4)
            java.lang.String r0 = ")"
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            java.lang.String[] r3 = new java.lang.String[r3]
            r2.d(r1, r0, r3)
            return
        L_0x0060:
            android.net.Network r0 = r7.testNetwork
            r7.listenForActiveDataNetworkChanges(r0)
            goto L_0x007f
        L_0x0066:
            java.lang.String r0 = "Unable to get IP Addresses"
            r5 = 4
            r7.testFailed(r0, r5, r4)
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r0 = r7.ndt
            r0.setTestRunning(r3)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r0.getLogger(r2)
            java.lang.String[] r2 = new java.lang.String[r3]
            java.lang.String r3 = "test failed. - Unable to get IP Addresses"
            r0.d(r1, r3, r2)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil.prepareToRunTest():void");
    }

    private final void registerConnectivityChangeReceiver(Context context) {
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        BroadcastReceiver broadcastReceiver = this.connectivityChangeReceiver;
        logger.d(TAG, "registerConnectivityChangeReceiver - " + broadcastReceiver, new String[0]);
        if (this.connectivityChangeReceiver == null) {
            try {
                this.connectivityChangeReceiver = new ThroughputConfigUtil$registerConnectivityChangeReceiver$1(this);
                Intrinsics.checkNotNull(context);
                context.getApplicationContext().registerReceiver(this.connectivityChangeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Exception e) {
                M2SDKLogger logger2 = M2SDKLogger.Companion.getLogger("NDT");
                String message = e.getMessage();
                logger2.d(TAG, "Error registering connectivity change receiver - " + message, new String[0]);
                this.connectivityChangeReceiver = null;
            }
        }
    }

    private final void resetVariables() {
        this.testFailedCalled = false;
        this.currentStage = 0;
        this.numberOfStages = 0;
        this.runningCount = 0.0d;
        this.runningSpeedTotal = 0.0d;
        this.userGeneratedLocation = null;
        this.networkDiagnosticTestConfig = null;
        this.lastEvent = null;
    }

    /* access modifiers changed from: private */
    public final void runTest() {
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        M2SDKLogger logger = companion.getLogger("NDT");
        Network network = this.ndt.getNetwork();
        logger.d(TAG, "---------  RUN TEST ----------- " + network, new String[0]);
        if (this.signalInfo != null) {
            M2SDKLogger logger2 = companion.getLogger("NDT");
            MNSI mnsi = this.signalInfo;
            logger2.d(TAG, "New Test MNSI: " + mnsi, new String[0]);
        }
        try {
            this.ndt.initializeNewTest(this.mContext, this.signalInfo, this.networkDiagnosticTestConfig);
            NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
            Intrinsics.checkNotNull(networkDiagnosticTestConfig2);
            this.numberOfStages = networkDiagnosticTestConfig2.testType == 0 ? 3 : 1;
            NetworkDiagnosticTestConfig networkDiagnosticTestConfig3 = this.networkDiagnosticTestConfig;
            Intrinsics.checkNotNull(networkDiagnosticTestConfig3);
            sendTestBeginEvent(networkDiagnosticTestConfig3.testType);
            if (this.runDefault) {
                MonitorStatsLogger.increment$default(MonitorStatsLogger.INSTANCE, LoggingEvents.NDT_START_TEST_FULL, 1, false, 4, (Object) null);
                startLatency();
            } else if (this.runLatency) {
                startLatency();
            } else if (this.runDownload || this.runUpload) {
                NetworkDiagnosticTestConfig networkDiagnosticTestConfig4 = this.networkDiagnosticTestConfig;
                Intrinsics.checkNotNull(networkDiagnosticTestConfig4);
                if (networkDiagnosticTestConfig4.getTrigger() != 1) {
                    NetworkDiagnosticTestConfig networkDiagnosticTestConfig5 = this.networkDiagnosticTestConfig;
                    Intrinsics.checkNotNull(networkDiagnosticTestConfig5);
                    if (networkDiagnosticTestConfig5.getTrigger() != 2) {
                        NetworkDiagnosticTools networkDiagnosticTools = this.ndt;
                        NetworkDiagnosticTestConfig networkDiagnosticTestConfig6 = this.networkDiagnosticTestConfig;
                        Intrinsics.checkNotNull(networkDiagnosticTestConfig6);
                        int i = networkDiagnosticTestConfig6.packetDataSize;
                        NetworkDiagnosticTestConfig networkDiagnosticTestConfig7 = this.networkDiagnosticTestConfig;
                        Intrinsics.checkNotNull(networkDiagnosticTestConfig7);
                        networkDiagnosticTools.setUpWebSocketClient(i, networkDiagnosticTestConfig7.maxDataSize, 3);
                        return;
                    }
                }
                NetworkDiagnosticTools.getInstance().setUpWebSocketClient(1048576, 209715200, 4);
            } else {
                this.ndt.setTestRunning(false);
            }
        } catch (Exception e) {
            M2SDKLogger logger3 = M2SDKLogger.Companion.getLogger("NDT");
            logger3.e(TAG, "Error initializing new test: " + e, new String[0]);
            this.ndt.setTestRunning(false);
        }
    }

    private final void sendTestBeginEvent(int i) {
        int i2 = (int) this.testNumber;
        long currentTimeMillis = System.currentTimeMillis();
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
        Intrinsics.checkNotNull(networkDiagnosticTestConfig2);
        int trigger = networkDiagnosticTestConfig2.getTrigger();
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig3 = this.networkDiagnosticTestConfig;
        Intrinsics.checkNotNull(networkDiagnosticTestConfig3);
        TestBeginEvent testBeginEvent = new TestBeginEvent(i2, currentTimeMillis, i, trigger, (long) networkDiagnosticTestConfig3.maxDataSize, this.numberOfStages, this.currentStage);
        this.lastEvent = testBeginEvent;
        EventBus.getDefault().postSticky(testBeginEvent);
    }

    /* access modifiers changed from: private */
    public final void sendTestEndEvent(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = this.numberOfStages;
        int i3 = this.currentStage;
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
        Intrinsics.checkNotNull(networkDiagnosticTestConfig2);
        TestEndEvent testEndEvent = new TestEndEvent((long) ((int) this.testNumber), currentTimeMillis, i, i2, i3, networkDiagnosticTestConfig2.getTrigger());
        this.lastEvent = testEndEvent;
        EventBus.getDefault().postSticky(testEndEvent);
    }

    private final void sendTestStageBeginEvent(int i) {
        int i2 = (int) this.testNumber;
        long currentTimeMillis = System.currentTimeMillis();
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
        Intrinsics.checkNotNull(networkDiagnosticTestConfig2);
        int trigger = networkDiagnosticTestConfig2.getTrigger();
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig3 = this.networkDiagnosticTestConfig;
        Intrinsics.checkNotNull(networkDiagnosticTestConfig3);
        TestStageBeginEvent testStageBeginEvent = new TestStageBeginEvent(i2, currentTimeMillis, i, trigger, (long) networkDiagnosticTestConfig3.maxDataSize, this.numberOfStages, this.currentStage);
        this.lastEvent = testStageBeginEvent;
        EventBus.getDefault().postSticky(testStageBeginEvent);
    }

    private final void sendTestStageEndEvent(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = this.numberOfStages;
        int i3 = this.currentStage;
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
        Intrinsics.checkNotNull(networkDiagnosticTestConfig2);
        TestStageEndEvent testStageEndEvent = new TestStageEndEvent((long) ((int) this.testNumber), currentTimeMillis, i, i2, i3, networkDiagnosticTestConfig2.getTrigger());
        this.lastEvent = testStageEndEvent;
        EventBus.getDefault().postSticky(testStageEndEvent);
    }

    private final void setUserGeneratedLocation(Location location2) {
        this.userGeneratedLocation = new M2Location(location2);
    }

    private final void startDownload() {
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
        logger.d(TAG, "start-download-testType:" + (networkDiagnosticTestConfig2 != null ? Integer.valueOf(networkDiagnosticTestConfig2.testType) : null), new String[0]);
        this.runningSpeedTotal = 0.0d;
        this.runningCount = 0.0d;
        this.currentStage++;
        sendTestStageBeginEvent(2);
        this.ndt.runDownloadTest();
    }

    private final void startLatency() {
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
        Integer valueOf = networkDiagnosticTestConfig2 != null ? Integer.valueOf(networkDiagnosticTestConfig2.testType) : null;
        logger.d(TAG, "start-latency-testType:" + valueOf, new String[0]);
        this.currentStage = this.currentStage + 1;
        this.latencyArray = new ArrayList<>();
        this.runningCount = 0.0d;
        this.runningSpeedTotal = 0.0d;
        this.runningJitter = 0.0d;
        this.totalLatencyDelta = 0.0d;
        sendTestStageBeginEvent(1);
        this.ndt.runLatencyTest();
    }

    private final void startUpload() {
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
        logger.d(TAG, "start-upload-testType:" + (networkDiagnosticTestConfig2 != null ? Integer.valueOf(networkDiagnosticTestConfig2.testType) : null), new String[0]);
        this.runningSpeedTotal = 0.0d;
        this.runningCount = 0.0d;
        this.currentStage++;
        sendTestStageBeginEvent(3);
        this.ndt.runUploadTest();
    }

    private final void updateConfigSharedPrefs(String str) {
        if (this.technologyArray != null) {
            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> arrayList = this.technologyArray;
            Intrinsics.checkNotNull(arrayList);
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "tech");
                sb.append(next.intValue());
                sb.append(",");
            }
            SharedPreferences.Editor editor2 = this.editor;
            Intrinsics.checkNotNull(editor2);
            editor2.putString(SHARED_PREFS_KEY_TECHNOLOGY + str, sb.toString());
        }
        SharedPreferences.Editor editor3 = this.editor;
        Intrinsics.checkNotNull(editor3);
        editor3.putInt(SHARED_PREFS_KEY_MNC + str, this.mnc);
        SharedPreferences.Editor editor4 = this.editor;
        Intrinsics.checkNotNull(editor4);
        editor4.putInt(SHARED_PREFS_KEY_MCC + str, this.mcc);
        SharedPreferences.Editor editor5 = this.editor;
        Intrinsics.checkNotNull(editor5);
        editor5.putString(SHARED_PREFS_KEY_OPERATOR + str, this.operator);
        SharedPreferences.Editor editor6 = this.editor;
        Intrinsics.checkNotNull(editor6);
        editor6.putInt(SHARED_PREFS_KEY_ROAMING_CONSTRAINT + str, this.checkIfRoaming);
        SharedPreferences.Editor editor7 = this.editor;
        Intrinsics.checkNotNull(editor7);
        editor7.putInt(SHARED_PREFS_KEY_START_TIME_CONSTRAINT + str, this.startTime);
        SharedPreferences.Editor editor8 = this.editor;
        Intrinsics.checkNotNull(editor8);
        editor8.putInt(SHARED_PREFS_KEY_END_TIME_CONSTRAINT + str, this.endTime);
        StringBuilder sb2 = new StringBuilder();
        ArrayList<Integer> arrayList2 = this.daysOfWeek;
        if (arrayList2 != null) {
            Intrinsics.checkNotNull(arrayList2);
            Iterator<Integer> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Integer next2 = it2.next();
                Intrinsics.checkNotNullExpressionValue(next2, "day");
                sb2.append(next2.intValue());
                sb2.append(",");
            }
            SharedPreferences.Editor editor9 = this.editor;
            Intrinsics.checkNotNull(editor9);
            editor9.putString(SHARED_PREFS_KEY_DAY_OF_WEEK_CONSTRAINT + str, sb2.toString());
        }
        SharedPreferences.Editor editor10 = this.editor;
        Intrinsics.checkNotNull(editor10);
        Double d = this.frequency;
        Intrinsics.checkNotNull(d);
        editor10.putFloat(SHARED_PREFS_KEY_FREQUENCY + str, (float) d.doubleValue());
        SharedPreferences.Editor editor11 = this.editor;
        Intrinsics.checkNotNull(editor11);
        editor11.commit();
    }

    private final void updateDataUsage(long j) {
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
        Intrinsics.checkNotNull(networkDiagnosticTestConfig2);
        if (networkDiagnosticTestConfig2.getTrigger() == 0) {
            SharedPreferences sharedPreferences = this.prefs;
            Intrinsics.checkNotNull(sharedPreferences);
            long j2 = sharedPreferences.getLong(SHARED_PREFS_KEY_DATA_USED, 0) + j;
            SharedPreferences.Editor editor2 = this.editor;
            Intrinsics.checkNotNull(editor2);
            editor2.putLong(SHARED_PREFS_KEY_DATA_USED, j2);
            SharedPreferences.Editor editor3 = this.editor;
            Intrinsics.checkNotNull(editor3);
            editor3.putLong(SHARED_PREFS_KEY_LAST_TEST_RUN_DATE, System.currentTimeMillis());
            SharedPreferences.Editor editor4 = this.editor;
            Intrinsics.checkNotNull(editor4);
            editor4.apply();
            M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
            logger.d(TAG, "Data usage updated - Total: " + j2, new String[0]);
        }
    }

    private final void updateDefaults() {
        SharedPreferences.Editor editor2 = this.editor;
        Intrinsics.checkNotNull(editor2);
        Long l = this.dataLimit;
        Intrinsics.checkNotNull(l);
        editor2.putLong(SHARED_PREFS_KEY_DATA_LIMIT, l.longValue());
        SharedPreferences.Editor editor3 = this.editor;
        Intrinsics.checkNotNull(editor3);
        editor3.putLong(SHARED_PREFS_KEY_LAST_CONFIG_UPDATE, System.currentTimeMillis());
        SharedPreferences.Editor editor4 = this.editor;
        Intrinsics.checkNotNull(editor4);
        editor4.commit();
    }

    private final boolean wait(int i) {
        int i2 = 0;
        while (i2 < i) {
            i2++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02af, code lost:
        if (r4 != 0) goto L_0x031d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0283  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkIfAnyTestShouldRun(com.m2catalyst.m2sdk.business.models.MNSI r21, kotlin.coroutines.Continuation<? super java.lang.Boolean> r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            boolean r2 = r1 instanceof com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$checkIfAnyTestShouldRun$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$checkIfAnyTestShouldRun$1 r2 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$checkIfAnyTestShouldRun$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$checkIfAnyTestShouldRun$1 r2 = new com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$checkIfAnyTestShouldRun$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            java.lang.String r5 = "TCU"
            java.lang.String r6 = "NDT"
            r7 = 5
            r8 = 4
            r9 = 3
            r10 = 2
            r11 = 0
            r12 = 1
            if (r4 == 0) goto L_0x0076
            if (r4 == r12) goto L_0x006e
            if (r4 == r10) goto L_0x0063
            if (r4 == r9) goto L_0x0058
            if (r4 == r8) goto L_0x004d
            if (r4 != r7) goto L_0x0045
            int r3 = r2.I$0
            java.lang.Object r2 = r2.L$0
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r2 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x025e
        L_0x0045:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004d:
            int r4 = r2.I$0
            java.lang.Object r8 = r2.L$0
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r8 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil) r8
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x020b
        L_0x0058:
            int r4 = r2.I$0
            java.lang.Object r13 = r2.L$0
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r13 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil) r13
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x01b3
        L_0x0063:
            int r4 = r2.I$0
            java.lang.Object r13 = r2.L$0
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r13 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil) r13
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0156
        L_0x006e:
            java.lang.Object r4 = r2.L$0
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r4 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00d6
        L_0x0076:
            kotlin.ResultKt.throwOnFailure(r1)
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r1 = r0.networkDiagnosticTestConfig
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getTrigger()
            if (r1 == r12) goto L_0x02b2
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r1 = r0.networkDiagnosticTestConfig
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getTrigger()
            if (r1 != r10) goto L_0x0091
            goto L_0x02b2
        L_0x0091:
            boolean r1 = r20.isMobile()
            if (r1 != 0) goto L_0x00a9
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r1 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = r1.getLogger(r6)
            java.lang.String[] r2 = new java.lang.String[r11]
            java.lang.String r3 = "Don't run test, not on mobile"
            r1.d(r5, r3, r2)
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            return r1
        L_0x00a9:
            android.content.SharedPreferences r1 = r0.prefs
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r4 = "last_update"
            r13 = 0
            long r13 = r1.getLong(r4, r13)
            long r15 = java.lang.System.currentTimeMillis()
            long r15 = r15 - r13
            r13 = 86400000(0x5265c00, double:4.2687272E-316)
            int r1 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r1 < 0) goto L_0x00e5
            r20.checkIfNewMonth()
            r20.checkIfNewDay()
            r2.L$0 = r0
            r2.label = r12
            r1 = r21
            java.lang.Object r1 = r0.updateConfig(r1, r2)
            if (r1 != r3) goto L_0x00d5
            return r3
        L_0x00d5:
            r4 = r0
        L_0x00d6:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x00e3
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            return r1
        L_0x00e3:
            r13 = r4
            goto L_0x00e6
        L_0x00e5:
            r13 = r0
        L_0x00e6:
            android.content.SharedPreferences r1 = r13.prefs
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r4 = "run_default"
            boolean r1 = r1.getBoolean(r4, r12)
            r13.runDefault = r1
            android.content.SharedPreferences r1 = r13.prefs
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r4 = "run_latency"
            boolean r1 = r1.getBoolean(r4, r12)
            r13.runLatency = r1
            android.content.SharedPreferences r1 = r13.prefs
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r4 = "run_download"
            boolean r1 = r1.getBoolean(r4, r12)
            r13.runDownload = r1
            android.content.SharedPreferences r1 = r13.prefs
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r4 = "run_upload"
            boolean r1 = r1.getBoolean(r4, r12)
            r13.runUpload = r1
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r1 = new com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO
            r1.<init>()
            r13.configVO = r1
            boolean r1 = r13.runDefault
            if (r1 == 0) goto L_0x0163
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r14 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r15 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.NDT_CHECK_FULL_TEST
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r14, r15, r16, r17, r18, r19)
            java.lang.String r1 = ""
            r13.getConfig(r1)
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r1 = r13.configVO
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r13.populateConfigVO(r1)
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r1 = r13.configVO
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r2.L$0 = r13
            r2.I$0 = r11
            r2.label = r10
            java.lang.String r4 = "default"
            java.lang.Object r1 = r13.shouldRunTest(r4, r1, r2)
            if (r1 != r3) goto L_0x0155
            return r3
        L_0x0155:
            r4 = 0
        L_0x0156:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0160
            r4 = 1
            goto L_0x0164
        L_0x0160:
            r13.runDefault = r11
            goto L_0x0164
        L_0x0163:
            r4 = 0
        L_0x0164:
            boolean r1 = r13.runDefault
            if (r1 == 0) goto L_0x0177
            r13.runLatency = r12
            r13.runDownload = r12
            r13.runUpload = r12
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r1 = r13.networkDiagnosticTestConfig
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r1.testType = r11
            goto L_0x0273
        L_0x0177:
            boolean r1 = r13.runLatency
            if (r1 == 0) goto L_0x01ce
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r14 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r15 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.NDT_CHECK_LATENCY_TEST
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r14, r15, r16, r17, r18, r19)
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r1 = r13.configVO
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r1.clear()
            java.lang.String r1 = "_latency"
            r13.getConfig(r1)
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r1 = r13.configVO
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r13.populateConfigVO(r1)
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r1 = r13.configVO
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r2.L$0 = r13
            r2.I$0 = r4
            r2.label = r9
            java.lang.String r14 = "latency"
            java.lang.Object r1 = r13.shouldRunTest(r14, r1, r2)
            if (r1 != r3) goto L_0x01b3
            return r3
        L_0x01b3:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x01bd
            r4 = 1
            goto L_0x01bf
        L_0x01bd:
            r13.runLatency = r11
        L_0x01bf:
            boolean r1 = r13.runDownload
            if (r1 != 0) goto L_0x01ce
            boolean r1 = r13.runUpload
            if (r1 != 0) goto L_0x01ce
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r1 = r13.networkDiagnosticTestConfig
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r1.testType = r12
        L_0x01ce:
            boolean r1 = r13.runDownload
            if (r1 == 0) goto L_0x021f
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r14 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r15 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.NDT_CHECK_DOWNLOAD_TEST
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r14, r15, r16, r17, r18, r19)
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r1 = r13.configVO
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r1.clear()
            java.lang.String r1 = "_download"
            r13.getConfig(r1)
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r1 = r13.configVO
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r13.populateConfigVO(r1)
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r1 = r13.configVO
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r2.L$0 = r13
            r2.I$0 = r4
            r2.label = r8
            java.lang.String r8 = "download"
            java.lang.Object r1 = r13.shouldRunTest(r8, r1, r2)
            if (r1 != r3) goto L_0x020a
            return r3
        L_0x020a:
            r8 = r13
        L_0x020b:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0215
            r4 = 1
            goto L_0x0217
        L_0x0215:
            r8.runDownload = r11
        L_0x0217:
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r1 = r8.networkDiagnosticTestConfig
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r1.testType = r10
            r13 = r8
        L_0x021f:
            boolean r1 = r13.runUpload
            if (r1 == 0) goto L_0x0273
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r14 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r15 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.NDT_CHECK_UPLOAD_TEST
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r14, r15, r16, r17, r18, r19)
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r1 = r13.configVO
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r1.clear()
            java.lang.String r1 = "_upload"
            r13.getConfig(r1)
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r1 = r13.configVO
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r13.populateConfigVO(r1)
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r1 = r13.configVO
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r2.L$0 = r13
            r2.I$0 = r4
            r2.label = r7
            java.lang.String r7 = "upload"
            java.lang.Object r1 = r13.shouldRunTest(r7, r1, r2)
            if (r1 != r3) goto L_0x025c
            return r3
        L_0x025c:
            r3 = r4
            r2 = r13
        L_0x025e:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0268
            r4 = 1
            goto L_0x026b
        L_0x0268:
            r2.runUpload = r11
            r4 = r3
        L_0x026b:
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r1 = r2.networkDiagnosticTestConfig
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r1.testType = r9
            r13 = r2
        L_0x0273:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r1 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = r1.getLogger(r6)
            boolean r2 = r13.runLatency
            boolean r3 = r13.runDownload
            boolean r6 = r13.runUpload
            if (r4 == 0) goto L_0x0283
            r7 = 1
            goto L_0x0284
        L_0x0283:
            r7 = 0
        L_0x0284:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "runLatency: "
            r8.<init>(r9)
            r8.append(r2)
            java.lang.String r2 = ", runDownload: "
            r8.append(r2)
            r8.append(r3)
            java.lang.String r2 = ", runUpload: "
            r8.append(r2)
            r8.append(r6)
            java.lang.String r2 = " ==> runAnytest: "
            r8.append(r2)
            r8.append(r7)
            java.lang.String r2 = r8.toString()
            java.lang.String[] r3 = new java.lang.String[r11]
            r1.d(r5, r2, r3)
            if (r4 == 0) goto L_0x031e
            goto L_0x031d
        L_0x02b2:
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r1 = r0.networkDiagnosticTestConfig
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.testType
            if (r1 != 0) goto L_0x02cd
            r0.runLatency = r12
            r0.runDownload = r12
            r0.runUpload = r12
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r2 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r3 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.NDT_CHECK_FULL_TEST
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r2, r3, r4, r5, r6, r7)
            goto L_0x031d
        L_0x02cd:
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r1 = r0.networkDiagnosticTestConfig
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.testType
            if (r1 != r12) goto L_0x02e8
            r0.runLatency = r12
            r0.runDownload = r11
            r0.runUpload = r11
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r2 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r3 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.NDT_CHECK_LATENCY_TEST
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r2, r3, r4, r5, r6, r7)
            goto L_0x031d
        L_0x02e8:
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r1 = r0.networkDiagnosticTestConfig
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.testType
            if (r1 != r10) goto L_0x0303
            r0.runLatency = r11
            r0.runDownload = r12
            r0.runUpload = r11
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r2 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r3 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.NDT_CHECK_DOWNLOAD_TEST
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r2, r3, r4, r5, r6, r7)
            goto L_0x031d
        L_0x0303:
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r1 = r0.networkDiagnosticTestConfig
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.testType
            if (r1 != r9) goto L_0x031d
            r0.runLatency = r11
            r0.runDownload = r11
            r0.runUpload = r12
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r2 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r3 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.NDT_CHECK_UPLOAD_TEST
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r2, r3, r4, r5, r6, r7)
        L_0x031d:
            r11 = 1
        L_0x031e:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil.checkIfAnyTestShouldRun(com.m2catalyst.m2sdk.business.models.MNSI, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean dataLimitReached() {
        if (this.dataLimit == null) {
            this.dataLimit = Long.valueOf(DEFAULT_DATA_LIMIT);
        }
        long dataConsumption = getDataConsumption();
        Long l = this.dataLimit;
        Intrinsics.checkNotNull(l);
        return dataConsumption >= l.longValue();
    }

    public void downloadTestComplete(BandwidthTestResults bandwidthTestResults) {
        Intrinsics.checkNotNullParameter(bandwidthTestResults, "results");
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        boolean z = this.testFailedCalled;
        logger.d(TAG, "downloadTestComplete failed case:" + z, new String[0]);
        MonitorStatsLogger.increment$default(MonitorStatsLogger.INSTANCE, LoggingEvents.NDT_TEST_COMPLETED_DOWNLOAD, (Object) null, false, 6, (Object) null);
        SharedPreferences.Editor editor2 = this.editor;
        Intrinsics.checkNotNull(editor2);
        editor2.putLong("last_test_run_date_download", System.currentTimeMillis());
        SharedPreferences.Editor editor3 = this.editor;
        Intrinsics.checkNotNull(editor3);
        editor3.commit();
        sendTestStageEndEvent(2);
        if (!this.runUpload) {
            finishTesting();
            return;
        }
        try {
            if (this.ndt.isWebSocketConnected()) {
                startUpload();
            } else {
                finishTesting();
            }
        } catch (WebsocketNotConnectedException unused) {
            if (this.ndt.reconnectWebSocket()) {
                startUpload();
            }
        }
    }

    public void finishTesting() {
        j3.a(new ThroughputConfigUtil$finishTesting$1(this, (Continuation<? super ThroughputConfigUtil$finishTesting$1>) null));
    }

    public final ThroughputConfigurationVO getConfigVO() {
        return this.configVO;
    }

    public final NetworkDiagnosticTestConfig getCurrentTestConfig() {
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
        if (networkDiagnosticTestConfig2 == null) {
            return null;
        }
        try {
            Intrinsics.checkNotNull(networkDiagnosticTestConfig2);
            Object clone = networkDiagnosticTestConfig2.clone();
            Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig");
            return (NetworkDiagnosticTestConfig) clone;
        } catch (CloneNotSupportedException e) {
            M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
            String message = e.getMessage();
            logger.e(TAG, "Error occurred. - error:" + message, new String[0]);
            return null;
        }
    }

    public final DiagnosticsResults getCurrentTestObject() {
        DiagnosticsResults currentTestResults = this.ndt.getCurrentTestResults();
        Intrinsics.checkNotNullExpressionValue(currentTestResults, "ndt.currentTestResults");
        return currentTestResults;
    }

    public final int getEndTime() {
        return this.endTime;
    }

    public final TestBaseEvent getLastEvent() {
        return this.lastEvent;
    }

    public final int getMcc() {
        return this.mcc;
    }

    public final int getMnc() {
        return this.mnc;
    }

    public final NetworkDiagnosticTools getNdt() {
        return this.ndt;
    }

    public final NetworkDiagnosticTestConfig getNetworkDiagnosticTestConfig() {
        return this.networkDiagnosticTestConfig;
    }

    public final int getStartTime() {
        return this.startTime;
    }

    public final long getTestNumber() {
        return this.testNumber;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0083, code lost:
        if ((!r11.isEmpty()) == false) goto L_0x0091;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object iPAddresses(com.m2catalyst.m2sdk.business.models.MNSI r10, kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$iPAddresses$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$iPAddresses$1 r0 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$iPAddresses$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$iPAddresses$1 r0 = new com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$iPAddresses$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "TCU"
            java.lang.String r4 = "NDT"
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x003a
            if (r2 != r5) goto L_0x0032
            java.lang.Object r10 = r0.L$0
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r10 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x005a
        L_0x0032:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r11)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r11 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r2 = r11.getLogger(r4)
            java.lang.String[] r7 = new java.lang.String[r6]
            java.lang.String r8 = "getIPAddress() called"
            r2.d(r3, r8, r7)
            if (r10 == 0) goto L_0x0086
            com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient r11 = r9.ndtApiClient
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r11 = r11.getServers(r10, r0)
            if (r11 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r10 = r9
        L_0x005a:
            java.util.List r11 = (java.util.List) r11
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r10 = r10.ndt
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r11)
            r10.ipAddresses = r0
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r10 = r10.getLogger(r4)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "getIPAddress():"
            r0.<init>(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.String[] r1 = new java.lang.String[r6]
            r10.d(r3, r0, r1)
            boolean r10 = r11.isEmpty()
            r10 = r10 ^ r5
            if (r10 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0086:
            com.m2catalyst.m2sdk.logger.M2SDKLogger r10 = r11.getLogger(r4)
            java.lang.String[] r11 = new java.lang.String[r6]
            java.lang.String r0 = "failed - no mnsi to get ip addresses"
            r10.d(r3, r0, r11)
        L_0x0091:
            r5 = 0
        L_0x0092:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil.iPAddresses(com.m2catalyst.m2sdk.business.models.MNSI, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0128 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0149 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initiateTest(com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r20, com.m2catalyst.m2sdk.business.models.MNSI r21, android.location.Location r22, android.net.Network r23, com.m2catalyst.m2sdk.business.models.MNSI r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r25
            boolean r6 = r5 instanceof com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$initiateTest$1
            if (r6 == 0) goto L_0x001f
            r6 = r5
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$initiateTest$1 r6 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$initiateTest$1) r6
            int r7 = r6.label
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = r7 & r8
            if (r9 == 0) goto L_0x001f
            int r7 = r7 - r8
            r6.label = r7
            goto L_0x0024
        L_0x001f:
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$initiateTest$1 r6 = new com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$initiateTest$1
            r6.<init>(r0, r5)
        L_0x0024:
            java.lang.Object r5 = r6.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r8 = r6.label
            r9 = 3
            r10 = 2
            r11 = 1
            if (r8 == 0) goto L_0x0088
            if (r8 == r11) goto L_0x0072
            if (r8 == r10) goto L_0x0059
            if (r8 != r9) goto L_0x0051
            boolean r1 = r6.Z$0
            long r2 = r6.J$0
            java.lang.Object r4 = r6.L$2
            com.m2catalyst.m2sdk.business.models.MNSI r4 = (com.m2catalyst.m2sdk.business.models.MNSI) r4
            java.lang.Object r7 = r6.L$1
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r7 = (com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig) r7
            java.lang.Object r6 = r6.L$0
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r6 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil) r6
            kotlin.ResultKt.throwOnFailure(r5)
            r10 = r1
            r15 = r2
            r13 = r4
            r11 = r6
            r12 = r7
            goto L_0x0150
        L_0x0051:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0059:
            long r1 = r6.J$0
            java.lang.Object r3 = r6.L$2
            com.m2catalyst.m2sdk.business.models.MNSI r3 = (com.m2catalyst.m2sdk.business.models.MNSI) r3
            java.lang.Object r4 = r6.L$1
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r4 = (com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig) r4
            java.lang.Object r8 = r6.L$0
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r8 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil) r8
            kotlin.ResultKt.throwOnFailure(r5)
            r17 = r4
            r4 = r3
            r2 = r1
            r1 = r17
            goto L_0x0130
        L_0x0072:
            java.lang.Object r1 = r6.L$2
            com.m2catalyst.m2sdk.business.models.MNSI r1 = (com.m2catalyst.m2sdk.business.models.MNSI) r1
            java.lang.Object r2 = r6.L$1
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r2 = (com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig) r2
            java.lang.Object r3 = r6.L$0
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r3 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil) r3
            kotlin.ResultKt.throwOnFailure(r5)
            r17 = r2
            r2 = r1
            r1 = r17
            goto L_0x0112
        L_0x0088:
            kotlin.ResultKt.throwOnFailure(r5)
            r5 = r24
            r0.lastSavedMNSI = r5
            if (r3 == 0) goto L_0x0098
            com.m2catalyst.m2sdk.business.models.M2Location r5 = new com.m2catalyst.m2sdk.business.models.M2Location
            r5.<init>((android.location.Location) r3)
            r0.location = r5
        L_0x0098:
            com.m2catalyst.m2sdk.business.models.M2Location r3 = r0.location
            if (r3 != 0) goto L_0x009f
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x009f:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r3 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r5 = "NDT"
            com.m2catalyst.m2sdk.logger.M2SDKLogger r8 = r3.getLogger(r5)
            int r12 = r20.getTrigger()
            int r13 = r1.testType
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r14 = r0.ndt
            boolean r14 = r14.isTestRunning()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r9 = "Initiate test via "
            r15.<init>(r9)
            r15.append(r12)
            r15.append(r13)
            java.lang.String r9 = ", "
            r15.append(r9)
            r15.append(r14)
            java.lang.String r9 = r15.toString()
            r12 = 0
            java.lang.String[] r13 = new java.lang.String[r12]
            java.lang.String r14 = "TCU"
            r8.d(r14, r9, r13)
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r8 = r0.ndt
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            boolean r8 = r8.isTestRunning()
            if (r8 == 0) goto L_0x00ed
            com.m2catalyst.m2sdk.logger.M2SDKLogger r1 = r3.getLogger(r5)
            java.lang.String[] r2 = new java.lang.String[r12]
            java.lang.String r3 = "Test is already running"
            r1.d(r14, r3, r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00ed:
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r3 = r0.ndt
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r3.setTestRunning(r11)
            r19.resetVariables()
            r0.testNetwork = r4
            com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r3 = r0.ndt
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r3.setNetwork(r4)
            r6.L$0 = r0
            r6.L$1 = r1
            r6.L$2 = r2
            r6.label = r11
            java.lang.Object r5 = r0.updateInstance(r2, r1, r6)
            if (r5 != r7) goto L_0x0111
            return r7
        L_0x0111:
            r3 = r0
        L_0x0112:
            java.lang.Number r5 = (java.lang.Number) r5
            long r4 = r5.longValue()
            r6.L$0 = r3
            r6.L$1 = r1
            r6.L$2 = r2
            r6.J$0 = r4
            r6.label = r10
            java.lang.Object r8 = r3.checkIfAnyTestShouldRun(r2, r6)
            if (r8 != r7) goto L_0x0129
            return r7
        L_0x0129:
            r17 = r4
            r4 = r2
            r5 = r8
            r8 = r3
            r2 = r17
        L_0x0130:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r6.L$0 = r8
            r6.L$1 = r1
            r6.L$2 = r4
            r6.J$0 = r2
            r6.Z$0 = r5
            r9 = 3
            r6.label = r9
            java.lang.Object r6 = r8.iPAddresses(r4, r6)
            if (r6 != r7) goto L_0x014a
            return r7
        L_0x014a:
            r12 = r1
            r15 = r2
            r13 = r4
            r10 = r5
            r5 = r6
            r11 = r8
        L_0x0150:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r14 = r5.booleanValue()
            android.os.Handler r1 = r11.tcuMainHandler
            if (r1 != 0) goto L_0x015d
            r11.setHandlers()
        L_0x015d:
            android.os.Handler r1 = r11.tcuMainHandler
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$$ExternalSyntheticLambda0 r2 = new com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$$ExternalSyntheticLambda0
            r9 = r2
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r1.post(r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil.initiateTest(com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig, com.m2catalyst.m2sdk.business.models.MNSI, android.location.Location, android.net.Network, com.m2catalyst.m2sdk.business.models.MNSI, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean isMobile() {
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo networkInfo = ((ConnectivityManager) systemService).getNetworkInfo(0);
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        Intrinsics.checkNotNull(networkInfo);
        String typeName = networkInfo.getTypeName();
        int type = networkInfo.getType();
        boolean isConnected = networkInfo.isConnected();
        logger.d(TAG, "isMobile - " + networkInfo + ", " + typeName + ", " + type + ", " + isConnected, new String[0]);
        return networkInfo.isConnected();
    }

    public final boolean isTooSoon() {
        SharedPreferences sharedPreferences = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences);
        if (!sharedPreferences.getBoolean(NDT_WAIT_FIRST_RUN, false)) {
            return false;
        }
        SharedPreferences sharedPreferences2 = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences2);
        long j = sharedPreferences2.getLong(SHARED_PREFS_FIRST_CHECK, 0);
        if (j == 0) {
            SharedPreferences.Editor editor2 = this.editor;
            Intrinsics.checkNotNull(editor2);
            editor2.putLong(SHARED_PREFS_FIRST_CHECK, System.currentTimeMillis());
            SharedPreferences.Editor editor3 = this.editor;
            Intrinsics.checkNotNull(editor3);
            editor3.commit();
            return true;
        } else if (System.currentTimeMillis() - j < 300000) {
            return true;
        } else {
            return false;
        }
    }

    public void latencyTestComplete(LatencyTestResults latencyTestResults) {
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        boolean z = this.testFailedCalled;
        logger.d(TAG, "latencyTestComplete failed case:" + z, new String[0]);
        if (!this.testFailedCalled) {
            MonitorStatsLogger.increment$default(MonitorStatsLogger.INSTANCE, LoggingEvents.NDT_TEST_COMPLETED_LATENCY, (Object) null, false, 6, (Object) null);
            SharedPreferences.Editor editor2 = this.editor;
            Intrinsics.checkNotNull(editor2);
            editor2.putLong("last_test_run_date_latency", System.currentTimeMillis());
            SharedPreferences.Editor editor3 = this.editor;
            Intrinsics.checkNotNull(editor3);
            editor3.commit();
            sendTestStageEndEvent(1);
            if (this.runDownload || this.runUpload) {
                NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
                Intrinsics.checkNotNull(networkDiagnosticTestConfig2);
                Integer num = networkDiagnosticTestConfig2.bandwidthAlgorithm;
                if (num != null && num.intValue() == 4) {
                    NetworkDiagnosticTools networkDiagnosticTools = this.ndt;
                    NetworkDiagnosticTestConfig networkDiagnosticTestConfig3 = this.networkDiagnosticTestConfig;
                    Intrinsics.checkNotNull(networkDiagnosticTestConfig3);
                    Integer num2 = networkDiagnosticTestConfig3.bandwidthAlgorithm;
                    Intrinsics.checkNotNullExpressionValue(num2, "networkDiagnosticTestConfig!!.bandwidthAlgorithm");
                    networkDiagnosticTools.setUpWebSocketClient(1048576, 209715200, num2.intValue());
                    return;
                }
                NetworkDiagnosticTestConfig networkDiagnosticTestConfig4 = this.networkDiagnosticTestConfig;
                Intrinsics.checkNotNull(networkDiagnosticTestConfig4);
                Integer num3 = networkDiagnosticTestConfig4.bandwidthAlgorithm;
                if (num3 != null && num3.intValue() == 3) {
                    NetworkDiagnosticTools networkDiagnosticTools2 = this.ndt;
                    NetworkDiagnosticTestConfig networkDiagnosticTestConfig5 = this.networkDiagnosticTestConfig;
                    Intrinsics.checkNotNull(networkDiagnosticTestConfig5);
                    int i = networkDiagnosticTestConfig5.packetDataSize;
                    NetworkDiagnosticTestConfig networkDiagnosticTestConfig6 = this.networkDiagnosticTestConfig;
                    Intrinsics.checkNotNull(networkDiagnosticTestConfig6);
                    int i2 = networkDiagnosticTestConfig6.maxDataSize;
                    NetworkDiagnosticTestConfig networkDiagnosticTestConfig7 = this.networkDiagnosticTestConfig;
                    Intrinsics.checkNotNull(networkDiagnosticTestConfig7);
                    Integer num4 = networkDiagnosticTestConfig7.bandwidthAlgorithm;
                    Intrinsics.checkNotNullExpressionValue(num4, "networkDiagnosticTestConfig!!.bandwidthAlgorithm");
                    networkDiagnosticTools2.setUpWebSocketClient(i, i2, num4.intValue());
                    return;
                }
                return;
            }
            finishTesting();
        }
    }

    public void latencyUpdate(double d, int i, int i2, double d2) {
        if (!this.testFailedCalled) {
            this.runningCount += 1.0d;
            this.runningSpeedTotal += d;
            ArrayList<Double> arrayList = this.latencyArray;
            Intrinsics.checkNotNull(arrayList);
            arrayList.add(Double.valueOf(d));
            ArrayList<Double> arrayList2 = this.latencyArray;
            Intrinsics.checkNotNull(arrayList2);
            if (arrayList2.size() > 1) {
                double d3 = this.totalLatencyDelta;
                ArrayList<Double> arrayList3 = this.latencyArray;
                Intrinsics.checkNotNull(arrayList3);
                ArrayList<Double> arrayList4 = this.latencyArray;
                Intrinsics.checkNotNull(arrayList4);
                double doubleValue = arrayList3.get(arrayList4.size() - 1).doubleValue();
                ArrayList<Double> arrayList5 = this.latencyArray;
                Intrinsics.checkNotNull(arrayList5);
                ArrayList<Double> arrayList6 = this.latencyArray;
                Intrinsics.checkNotNull(arrayList6);
                Double d4 = arrayList5.get(arrayList6.size() - 2);
                Intrinsics.checkNotNullExpressionValue(d4, "latencyArray!![latencyArray!!.size - 2]");
                this.totalLatencyDelta = Math.abs(doubleValue - d4.doubleValue()) + d3;
                NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
                Intrinsics.checkNotNull(networkDiagnosticTestConfig2);
                Integer num = networkDiagnosticTestConfig2.LatencyAlgorithm;
                if (num != null && num.intValue() == 3) {
                    double d5 = this.totalLatencyDelta;
                    ArrayList<Double> arrayList7 = this.latencyArray;
                    Intrinsics.checkNotNull(arrayList7);
                    double size = (double) (arrayList7.size() - 1);
                    Double.isNaN(size);
                    this.runningJitter = d5 / size;
                } else {
                    NetworkDiagnosticTestConfig networkDiagnosticTestConfig3 = this.networkDiagnosticTestConfig;
                    Intrinsics.checkNotNull(networkDiagnosticTestConfig3);
                    Integer num2 = networkDiagnosticTestConfig3.LatencyAlgorithm;
                    if (num2 != null && num2.intValue() == 4) {
                        this.runningJitter = d2;
                    }
                }
            }
            int i3 = (int) this.testNumber;
            long currentTimeMillis = System.currentTimeMillis();
            double d6 = this.runningSpeedTotal / this.runningCount;
            double d7 = this.runningJitter;
            int i4 = this.numberOfStages;
            int i5 = this.currentStage;
            NetworkDiagnosticTestConfig networkDiagnosticTestConfig4 = this.networkDiagnosticTestConfig;
            Intrinsics.checkNotNull(networkDiagnosticTestConfig4);
            LatencyUpdateEvent latencyUpdateEvent = new LatencyUpdateEvent(i3, currentTimeMillis, 1, d, i, i2, d6, d7, i4, i5, networkDiagnosticTestConfig4.getTrigger());
            this.lastEvent = latencyUpdateEvent;
            EventBus.getDefault().postSticky(latencyUpdateEvent);
        }
    }

    public final void removeHandlerThread() {
        Handler handler = this.tcuMainHandler;
        if (handler != null) {
            Intrinsics.checkNotNull(handler);
            handler.removeCallbacksAndMessages((Object) null);
        }
        Handler handler2 = this.networkCallbackHandler;
        if (handler2 != null) {
            Intrinsics.checkNotNull(handler2);
            handler2.removeCallbacksAndMessages((Object) null);
        }
        try {
            HandlerThread handlerThread = this.tcuMainThread;
            if (handlerThread != null) {
                Intrinsics.checkNotNull(handlerThread);
                handlerThread.quit();
                HandlerThread handlerThread2 = this.tcuMainThread;
                Intrinsics.checkNotNull(handlerThread2);
                handlerThread2.join(5000);
            }
            HandlerThread handlerThread3 = this.networkCallbackThread;
            if (handlerThread3 != null) {
                Intrinsics.checkNotNull(handlerThread3);
                handlerThread3.quit();
                HandlerThread handlerThread4 = this.networkCallbackThread;
                Intrinsics.checkNotNull(handlerThread4);
                handlerThread4.join(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.tcuMainThread = null;
        this.tcuMainHandler = null;
        this.networkCallbackThread = null;
        this.networkCallbackHandler = null;
    }

    public final void setConfigVO(ThroughputConfigurationVO throughputConfigurationVO) {
        this.configVO = throughputConfigurationVO;
    }

    public final void setEndTime(int i) {
        this.endTime = i;
    }

    public final void setHandlers() {
        HandlerThread handlerThread = new HandlerThread("ThroughputConfig", 10);
        this.tcuMainThread = handlerThread;
        Intrinsics.checkNotNull(handlerThread);
        handlerThread.start();
        HandlerThread handlerThread2 = this.tcuMainThread;
        Intrinsics.checkNotNull(handlerThread2);
        this.tcuMainHandler = new Handler(handlerThread2.getLooper());
        HandlerThread handlerThread3 = new HandlerThread("NCB", 10);
        this.networkCallbackThread = handlerThread3;
        Intrinsics.checkNotNull(handlerThread3);
        handlerThread3.start();
        HandlerThread handlerThread4 = this.networkCallbackThread;
        Intrinsics.checkNotNull(handlerThread4);
        this.networkCallbackHandler = new Handler(handlerThread4.getLooper());
    }

    public final void setMcc(int i) {
        this.mcc = i;
    }

    public final void setMnc(int i) {
        this.mnc = i;
    }

    public final void setNdt(NetworkDiagnosticTools networkDiagnosticTools) {
        Intrinsics.checkNotNullParameter(networkDiagnosticTools, "<set-?>");
        this.ndt = networkDiagnosticTools;
    }

    public final void setNetworkDiagnosticTestConfig(NetworkDiagnosticTestConfig networkDiagnosticTestConfig2) {
        this.networkDiagnosticTestConfig = networkDiagnosticTestConfig2;
    }

    public final void setStartTime(int i) {
        this.startTime = i;
    }

    public void setTestFailedCalledFalse() {
        this.testFailedCalled = false;
    }

    public void setTestFailedCalledTrue() {
        this.testFailedCalled = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object shouldRunTest(java.lang.String r9, com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r10, kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$shouldRunTest$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$shouldRunTest$1 r0 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$shouldRunTest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$shouldRunTest$1 r0 = new com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$shouldRunTest$1
            r0.<init>(r8, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "TCU"
            java.lang.String r5 = "NDT"
            r6 = 0
            if (r2 == 0) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            java.lang.Object r9 = r0.L$2
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO r9 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO) r9
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r0 = r0.L$0
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r0 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil) r0
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00ae
        L_0x003d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r11)
            boolean r11 = r8.dataLimitReached()
            if (r11 == 0) goto L_0x006f
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r10 = r10.getLogger(r5)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = " Don't run test: Data limit has been reached"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String[] r11 = new java.lang.String[r6]
            r10.d(r4, r9, r11)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r9
        L_0x006f:
            boolean r11 = r8.checkTimeConstraint(r9, r10)
            if (r11 != 0) goto L_0x0096
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r10 = r10.getLogger(r5)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = " Don't run test: Frequency constraint not met"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String[] r11 = new java.lang.String[r6]
            r10.d(r4, r9, r11)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r9
        L_0x0096:
            java.lang.String r11 = "latency"
            boolean r11 = kotlin.text.StringsKt.equals(r9, r11, r3)
            if (r11 != 0) goto L_0x00d7
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r3
            java.lang.Object r11 = r8.cellIdIsUnique(r0)
            if (r11 != r1) goto L_0x00ad
            return r1
        L_0x00ad:
            r0 = r8
        L_0x00ae:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x00d8
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r10 = r10.getLogger(r5)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = " Don't run test: Cell ID is not unique"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String[] r11 = new java.lang.String[r6]
            r10.d(r4, r9, r11)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r9
        L_0x00d7:
            r0 = r8
        L_0x00d8:
            int r11 = r10.checkIfRoaming
            if (r11 != 0) goto L_0x0112
            com.m2catalyst.m2sdk.business.models.MNSI r11 = r0.signalInfo
            if (r11 == 0) goto L_0x0112
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            java.lang.Boolean r11 = r11.getRoaming()
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r1)
            if (r11 == 0) goto L_0x0112
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r10 = r10.getLogger(r5)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = " Don't run test: Device is roaming"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String[] r11 = new java.lang.String[r6]
            r10.d(r4, r9, r11)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r9
        L_0x0112:
            boolean r11 = r0.isTimeBetweenTargetHours(r10)
            if (r11 != 0) goto L_0x0139
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r10 = r10.getLogger(r5)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = " Don't run test: Time is not between target hours"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String[] r11 = new java.lang.String[r6]
            r10.d(r4, r9, r11)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r9
        L_0x0139:
            java.util.ArrayList<java.lang.Integer> r11 = r10.technologyArray
            if (r11 == 0) goto L_0x018d
            int r11 = r11.size()
            if (r11 == 0) goto L_0x018d
            java.util.ArrayList<java.lang.Integer> r11 = r10.technologyArray
            java.util.Iterator r11 = r11.iterator()
        L_0x0149:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x0169
            java.lang.Object r1 = r11.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            com.m2catalyst.m2sdk.business.models.MNSI r2 = r0.signalInfo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.getNetworkType()
            if (r1 != 0) goto L_0x0161
            goto L_0x0149
        L_0x0161:
            int r1 = r1.intValue()
            if (r1 != r2) goto L_0x0149
            r11 = 1
            goto L_0x016a
        L_0x0169:
            r11 = 0
        L_0x016a:
            if (r11 != 0) goto L_0x018d
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r10 = r10.getLogger(r5)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = " Don't run test: Technology is not in list"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String[] r11 = new java.lang.String[r6]
            r10.d(r4, r9, r11)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r9
        L_0x018d:
            java.util.ArrayList<java.lang.Integer> r11 = r10.daysOfWeek
            if (r11 == 0) goto L_0x01d3
            int r11 = r11.size()
            if (r11 == 0) goto L_0x01d3
            java.util.Calendar r11 = java.util.Calendar.getInstance()
            r1 = 7
            int r11 = r11.get(r1)
            java.util.ArrayList<java.lang.Integer> r1 = r10.daysOfWeek
            int r11 = r11 - r3
            java.lang.Object r11 = r1.get(r11)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 != 0) goto L_0x01ac
            goto L_0x01d3
        L_0x01ac:
            int r11 = r11.intValue()
            if (r11 != 0) goto L_0x01d3
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r10 = r10.getLogger(r5)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = " Don't run test: Not on day test should run"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String[] r11 = new java.lang.String[r6]
            r10.d(r4, r9, r11)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r9
        L_0x01d3:
            int r11 = r10.mnc
            if (r11 <= 0) goto L_0x020a
            com.m2catalyst.m2sdk.business.models.MNSI r1 = r0.signalInfo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.Integer r1 = r1.getNetworkMnc()
            if (r1 != 0) goto L_0x01e3
            goto L_0x01e9
        L_0x01e3:
            int r1 = r1.intValue()
            if (r11 == r1) goto L_0x020a
        L_0x01e9:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r10 = r10.getLogger(r5)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = " Don't run test: Incorrect MNC"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String[] r11 = new java.lang.String[r6]
            r10.d(r4, r9, r11)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r9
        L_0x020a:
            int r10 = r10.mcc
            if (r10 <= 0) goto L_0x0241
            com.m2catalyst.m2sdk.business.models.MNSI r11 = r0.signalInfo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            java.lang.Integer r11 = r11.getNetworkMcc()
            if (r11 != 0) goto L_0x021a
            goto L_0x0220
        L_0x021a:
            int r11 = r11.intValue()
            if (r10 == r11) goto L_0x0241
        L_0x0220:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r10 = r10.getLogger(r5)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = " Don't run test: Incorrect MCC"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String[] r11 = new java.lang.String[r6]
            r10.d(r4, r9, r11)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r9
        L_0x0241:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r10 = r10.getLogger(r5)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = " Run test True"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String[] r11 = new java.lang.String[r6]
            r10.d(r4, r9, r11)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil.shouldRunTest(java.lang.String, com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigurationVO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public synchronized void testFailed(String str, int i, boolean z) {
        String str2 = str;
        synchronized (this) {
            Intrinsics.checkNotNullParameter(str, IronSourceConstants.EVENTS_ERROR_REASON);
            M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
            logger.d(TAG, "Test failed: " + str + ", Code: " + i, new String[0]);
            if (!this.testFailedCalled) {
                this.testFailedCalled = true;
                this.ndt.setTestRunning(false);
                if (z) {
                    long currentTimeMillis = System.currentTimeMillis();
                    NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
                    Intrinsics.checkNotNull(networkDiagnosticTestConfig2);
                    int i2 = networkDiagnosticTestConfig2.testType;
                    int i3 = this.numberOfStages;
                    int i4 = this.currentStage;
                    NetworkDiagnosticTestConfig networkDiagnosticTestConfig3 = this.networkDiagnosticTestConfig;
                    Intrinsics.checkNotNull(networkDiagnosticTestConfig3);
                    TestErrorEvent testErrorEvent = new TestErrorEvent((long) ((int) this.testNumber), currentTimeMillis, i2, i, str, i3, i4, networkDiagnosticTestConfig3.getTrigger());
                    this.lastEvent = testErrorEvent;
                    EventBus.getDefault().postSticky(testErrorEvent);
                }
                finishTesting();
            }
        }
    }

    public final boolean testHasRunInLastHour() {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = this.prefs;
        Intrinsics.checkNotNull(sharedPreferences);
        return currentTimeMillis - sharedPreferences.getLong(SHARED_PREFS_KEY_LAST_TEST_RUN_DATE, 0) < 3600000;
    }

    public final boolean testHasRunToday() {
        return !checkIfNewDay();
    }

    public void throughputTestComplete(DiagnosticsResults diagnosticsResults) {
        Intrinsics.checkNotNullParameter(diagnosticsResults, "results");
    }

    public final void update(MNSI mnsi) {
        updateMNSIObject(mnsi);
    }

    public final void updateConfig(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "testObj");
        try {
            parseConfigJSON(jSONObject, "default");
            SharedPreferences.Editor editor2 = this.editor;
            Intrinsics.checkNotNull(editor2);
            Long l = this.dataLimit;
            Intrinsics.checkNotNull(l);
            editor2.putLong(SHARED_PREFS_KEY_DATA_LIMIT, l.longValue());
            if (this.technologyArray != null) {
                StringBuilder sb = new StringBuilder();
                ArrayList<Integer> arrayList = this.technologyArray;
                Intrinsics.checkNotNull(arrayList);
                Iterator<Integer> it = arrayList.iterator();
                while (it.hasNext()) {
                    Integer next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "tech");
                    sb.append(next.intValue());
                    sb.append(",");
                }
                SharedPreferences.Editor editor3 = this.editor;
                Intrinsics.checkNotNull(editor3);
                editor3.putString(SHARED_PREFS_KEY_TECHNOLOGY, sb.toString());
            }
            SharedPreferences.Editor editor4 = this.editor;
            Intrinsics.checkNotNull(editor4);
            editor4.putInt(SHARED_PREFS_KEY_MNC, this.mnc);
            SharedPreferences.Editor editor5 = this.editor;
            Intrinsics.checkNotNull(editor5);
            editor5.putInt(SHARED_PREFS_KEY_MCC, this.mcc);
            SharedPreferences.Editor editor6 = this.editor;
            Intrinsics.checkNotNull(editor6);
            editor6.putString(SHARED_PREFS_KEY_OPERATOR, this.operator);
            SharedPreferences.Editor editor7 = this.editor;
            Intrinsics.checkNotNull(editor7);
            editor7.putInt(SHARED_PREFS_KEY_ROAMING_CONSTRAINT, this.checkIfRoaming);
            SharedPreferences.Editor editor8 = this.editor;
            Intrinsics.checkNotNull(editor8);
            editor8.putInt(SHARED_PREFS_KEY_START_TIME_CONSTRAINT, this.startTime);
            SharedPreferences.Editor editor9 = this.editor;
            Intrinsics.checkNotNull(editor9);
            editor9.putInt(SHARED_PREFS_KEY_END_TIME_CONSTRAINT, this.endTime);
            StringBuilder sb2 = new StringBuilder();
            ArrayList<Integer> arrayList2 = this.daysOfWeek;
            if (arrayList2 != null) {
                Intrinsics.checkNotNull(arrayList2);
                Iterator<Integer> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    Integer next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "day");
                    sb2.append(next2.intValue());
                    sb2.append(",");
                }
                SharedPreferences.Editor editor10 = this.editor;
                Intrinsics.checkNotNull(editor10);
                editor10.putString(SHARED_PREFS_KEY_DAY_OF_WEEK_CONSTRAINT, sb2.toString());
            }
            SharedPreferences.Editor editor11 = this.editor;
            Intrinsics.checkNotNull(editor11);
            editor11.putLong(SHARED_PREFS_KEY_LAST_CONFIG_UPDATE, System.currentTimeMillis());
            SharedPreferences.Editor editor12 = this.editor;
            Intrinsics.checkNotNull(editor12);
            editor12.commit();
        } catch (Exception e) {
            M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
            String message = e.getMessage();
            logger.e(TAG, "JSON config Exception" + message, new String[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateInstance(com.m2catalyst.m2sdk.business.models.MNSI r6, com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig r7, kotlin.coroutines.Continuation<? super java.lang.Long> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$updateInstance$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$updateInstance$1 r0 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$updateInstance$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$updateInstance$1 r0 = new com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$updateInstance$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r6 = r0.L$1
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r6 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil) r6
            java.lang.Object r7 = r0.L$0
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r7 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0069
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r8)
            android.content.Context r8 = r5.mContext
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            java.lang.String r2 = "throughput_config"
            r4 = 0
            android.content.SharedPreferences r8 = r8.getSharedPreferences(r2, r4)
            r5.prefs = r8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            android.content.SharedPreferences$Editor r8 = r8.edit()
            r5.editor = r8
            r5.signalInfo = r6
            r5.networkDiagnosticTestConfig = r7
            com.m2catalyst.m2sdk.business.repositories.NDTRepository r6 = r5.ndtRepository
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = r6.getNDTCount(r0)
            if (r8 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r6 = r5
            r7 = r6
        L_0x0069:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            long r0 = (long) r8
            r6.testNumber = r0
            long r6 = r7.testNumber
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil.updateInstance(com.m2catalyst.m2sdk.business.models.MNSI, com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void updateMNSIObject(MNSI mnsi) {
        this.signalInfo = mnsi;
    }

    public void uploadTestComplete(BandwidthTestResults bandwidthTestResults) {
        Intrinsics.checkNotNullParameter(bandwidthTestResults, "results");
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        boolean z = this.testFailedCalled;
        logger.d(TAG, "uploadTestComplete failed case:" + z, new String[0]);
        MonitorStatsLogger monitorStatsLogger = MonitorStatsLogger.INSTANCE;
        MonitorStatsLogger.increment$default(monitorStatsLogger, LoggingEvents.NDT_TEST_COMPLETED_UPLOAD, (Object) null, false, 6, (Object) null);
        sendTestStageEndEvent(3);
        if (this.runDefault) {
            MonitorStatsLogger.increment$default(monitorStatsLogger, LoggingEvents.NDT_TEST_COMPLETED_FULL, (Object) null, false, 6, (Object) null);
            SharedPreferences.Editor editor2 = this.editor;
            Intrinsics.checkNotNull(editor2);
            editor2.putLong(SHARED_PREFS_KEY_LAST_TEST_RUN_DATE, System.currentTimeMillis());
        }
        SharedPreferences.Editor editor3 = this.editor;
        Intrinsics.checkNotNull(editor3);
        editor3.putLong("last_test_run_date_upload", System.currentTimeMillis());
        SharedPreferences.Editor editor4 = this.editor;
        Intrinsics.checkNotNull(editor4);
        editor4.commit();
        finishTesting();
    }

    public void uploadTestUpdate(double d, double d2, double d3, double d4) {
        double d5 = d;
        double d6 = (double) 1024;
        Double.isNaN(d6);
        Double.isNaN(d6);
        int i = (int) this.testNumber;
        long currentTimeMillis = System.currentTimeMillis();
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
        Intrinsics.checkNotNull(networkDiagnosticTestConfig2);
        long j = ((long) networkDiagnosticTestConfig2.packetDataSize) * ((long) d5);
        double d7 = (double) 100;
        Double.isNaN(d7);
        double d8 = (d5 / d2) * d7;
        int i2 = this.numberOfStages;
        int i3 = this.currentStage;
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig3 = this.networkDiagnosticTestConfig;
        Intrinsics.checkNotNull(networkDiagnosticTestConfig3);
        ThroughputUpdateEvent throughputUpdateEvent = new ThroughputUpdateEvent(i, currentTimeMillis, 3, j, d4, d4 * d6 * d6, d8, i2, i3, networkDiagnosticTestConfig3.getTrigger());
        this.lastEvent = throughputUpdateEvent;
        EventBus.getDefault().postSticky(throughputUpdateEvent);
    }

    public void webSocketClientOpened() {
        try {
            M2SDKLogger.Companion.getLogger("NDT").d(TAG, "webSocket opened", new String[0]);
            if (this.runDownload) {
                updateDataUsage(2048000);
                startDownload();
            } else if (this.runUpload) {
                updateDataUsage(2048000);
                startUpload();
            } else {
                this.ndt.disconnect();
                this.ndt.setTestRunning(false);
            }
        } catch (WebsocketNotConnectedException e) {
            M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
            logger.e(TAG, "webSocket opened exception: " + e, new String[0]);
            if (!this.ndt.reconnectWebSocket()) {
                return;
            }
            if (this.runDownload) {
                startDownload();
            } else if (this.runUpload) {
                startUpload();
            }
        }
    }

    public final Object updateUserGeneratedLocation(long j, Location location2, Continuation<? super Unit> continuation) {
        setUserGeneratedLocation(location2);
        if (this.ndt.isTestRunning()) {
            this.userGeneratedLocation = new M2Location(location2);
            return Unit.INSTANCE;
        }
        M2Location m2Location = new M2Location(location2);
        this.locationCollectorManager.a(this.mContext, m2Location);
        Object updateLocationDataFromNetworkDiagnostics = this.mnsiRepository.updateLocationDataFromNetworkDiagnostics((int) j, m2Location.toEntity$m2sdk_release(), continuation);
        return updateLocationDataFromNetworkDiagnostics == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateLocationDataFromNetworkDiagnostics : Unit.INSTANCE;
    }

    public void downloadTestUpdate(int i, long j, long j2, double d) {
        int i2 = (int) this.testNumber;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = j2;
        double d2 = (double) j3;
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig2 = this.networkDiagnosticTestConfig;
        Intrinsics.checkNotNull(networkDiagnosticTestConfig2);
        double d3 = (double) networkDiagnosticTestConfig2.maxDataSize;
        Double.isNaN(d2);
        Double.isNaN(d3);
        int i3 = this.numberOfStages;
        int i4 = this.currentStage;
        NetworkDiagnosticTestConfig networkDiagnosticTestConfig3 = this.networkDiagnosticTestConfig;
        Intrinsics.checkNotNull(networkDiagnosticTestConfig3);
        int i5 = i4;
        ThroughputUpdateEvent throughputUpdateEvent = r1;
        ThroughputUpdateEvent throughputUpdateEvent2 = new ThroughputUpdateEvent(i2, currentTimeMillis, 2, j3, d, d, (d2 / d3) * 100.0d, i3, i5, networkDiagnosticTestConfig3.getTrigger());
        ThroughputUpdateEvent throughputUpdateEvent3 = throughputUpdateEvent;
        this.lastEvent = throughputUpdateEvent3;
        EventBus.getDefault().postSticky(throughputUpdateEvent3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0096, code lost:
        if (r15.doubleValue() <= 0.0d) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x013a, code lost:
        if (r14 != false) goto L_0x013e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073 A[Catch:{ JSONException -> 0x011b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateConfig(com.m2catalyst.m2sdk.business.models.MNSI r14, kotlin.coroutines.Continuation<? super java.lang.Boolean> r15) {
        /*
            r13 = this;
            java.lang.String r0 = "upload"
            java.lang.String r1 = "download"
            java.lang.String r2 = "latency"
            boolean r3 = r15 instanceof com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$updateConfig$1
            if (r3 == 0) goto L_0x001a
            r3 = r15
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$updateConfig$1 r3 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$updateConfig$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x001a
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001f
        L_0x001a:
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$updateConfig$1 r3 = new com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil$updateConfig$1
            r3.<init>(r13, r15)
        L_0x001f:
            java.lang.Object r15 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            java.lang.String r6 = "TCU"
            java.lang.String r7 = "NDT"
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x0045
            if (r5 != r8) goto L_0x003d
            java.lang.Object r14 = r3.L$1
            kotlin.jvm.internal.Ref$ObjectRef r14 = (kotlin.jvm.internal.Ref.ObjectRef) r14
            java.lang.Object r3 = r3.L$0
            com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil r3 = (com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil) r3
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ JSONException -> 0x011b }
            goto L_0x006f
        L_0x003d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r15)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r15 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r15 = r15.getLogger(r7)
            java.lang.String[] r5 = new java.lang.String[r9]
            java.lang.String r10 = "Update config"
            r15.d(r6, r10, r5)
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            if (r14 == 0) goto L_0x013d
            com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient r5 = r13.ndtApiClient     // Catch:{ JSONException -> 0x011b }
            r3.L$0 = r13     // Catch:{ JSONException -> 0x011b }
            r3.L$1 = r15     // Catch:{ JSONException -> 0x011b }
            r3.label = r8     // Catch:{ JSONException -> 0x011b }
            java.lang.Object r14 = r5.getNDTConfig(r14, r3)     // Catch:{ JSONException -> 0x011b }
            if (r14 != r4) goto L_0x006b
            return r4
        L_0x006b:
            r3 = r13
            r12 = r15
            r15 = r14
            r14 = r12
        L_0x006f:
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ JSONException -> 0x011b }
            if (r15 == 0) goto L_0x0139
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x011b }
            r4.<init>(r15)     // Catch:{ JSONException -> 0x011b }
            r14.element = r4     // Catch:{ JSONException -> 0x011b }
            java.lang.String r15 = "default"
            r3.parseConfigJSON(r4, r15)     // Catch:{ JSONException -> 0x011b }
            r3.updateDefaults()     // Catch:{ JSONException -> 0x011b }
            java.lang.String r15 = ""
            r3.updateConfigSharedPrefs(r15)     // Catch:{ JSONException -> 0x011b }
            java.lang.Double r15 = r3.frequency     // Catch:{ JSONException -> 0x011b }
            if (r15 == 0) goto L_0x0098
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)     // Catch:{ JSONException -> 0x011b }
            double r4 = r15.doubleValue()     // Catch:{ JSONException -> 0x011b }
            r10 = 0
            int r15 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r15 > 0) goto L_0x00aa
        L_0x0098:
            android.content.SharedPreferences$Editor r15 = r3.editor     // Catch:{ JSONException -> 0x011b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)     // Catch:{ JSONException -> 0x011b }
            java.lang.String r4 = "run_default"
            r15.putBoolean(r4, r9)     // Catch:{ JSONException -> 0x011b }
            android.content.SharedPreferences$Editor r15 = r3.editor     // Catch:{ JSONException -> 0x011b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)     // Catch:{ JSONException -> 0x011b }
            r15.commit()     // Catch:{ JSONException -> 0x011b }
        L_0x00aa:
            T r15 = r14.element     // Catch:{ JSONException -> 0x011b }
            org.json.JSONObject r15 = (org.json.JSONObject) r15     // Catch:{ JSONException -> 0x011b }
            org.json.JSONObject r15 = r15.optJSONObject(r2)     // Catch:{ JSONException -> 0x011b }
            if (r15 == 0) goto L_0x00bd
            r3.parseConfigJSON(r15, r2)     // Catch:{ JSONException -> 0x011b }
            java.lang.String r15 = "_latency"
            r3.updateConfigSharedPrefs(r15)     // Catch:{ JSONException -> 0x011b }
            goto L_0x00cf
        L_0x00bd:
            android.content.SharedPreferences$Editor r15 = r3.editor     // Catch:{ JSONException -> 0x011b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)     // Catch:{ JSONException -> 0x011b }
            java.lang.String r2 = "run_latency"
            r15.putBoolean(r2, r9)     // Catch:{ JSONException -> 0x011b }
            android.content.SharedPreferences$Editor r15 = r3.editor     // Catch:{ JSONException -> 0x011b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)     // Catch:{ JSONException -> 0x011b }
            r15.commit()     // Catch:{ JSONException -> 0x011b }
        L_0x00cf:
            T r15 = r14.element     // Catch:{ JSONException -> 0x011b }
            org.json.JSONObject r15 = (org.json.JSONObject) r15     // Catch:{ JSONException -> 0x011b }
            org.json.JSONObject r15 = r15.optJSONObject(r1)     // Catch:{ JSONException -> 0x011b }
            if (r15 == 0) goto L_0x00e2
            r3.parseConfigJSON(r15, r1)     // Catch:{ JSONException -> 0x011b }
            java.lang.String r15 = "_download"
            r3.updateConfigSharedPrefs(r15)     // Catch:{ JSONException -> 0x011b }
            goto L_0x00f4
        L_0x00e2:
            android.content.SharedPreferences$Editor r15 = r3.editor     // Catch:{ JSONException -> 0x011b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)     // Catch:{ JSONException -> 0x011b }
            java.lang.String r1 = "run_download"
            r15.putBoolean(r1, r9)     // Catch:{ JSONException -> 0x011b }
            android.content.SharedPreferences$Editor r15 = r3.editor     // Catch:{ JSONException -> 0x011b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)     // Catch:{ JSONException -> 0x011b }
            r15.commit()     // Catch:{ JSONException -> 0x011b }
        L_0x00f4:
            T r14 = r14.element     // Catch:{ JSONException -> 0x011b }
            org.json.JSONObject r14 = (org.json.JSONObject) r14     // Catch:{ JSONException -> 0x011b }
            org.json.JSONObject r14 = r14.optJSONObject(r0)     // Catch:{ JSONException -> 0x011b }
            if (r14 == 0) goto L_0x0107
            r3.parseConfigJSON(r14, r0)     // Catch:{ JSONException -> 0x011b }
            java.lang.String r14 = "_upload"
            r3.updateConfigSharedPrefs(r14)     // Catch:{ JSONException -> 0x011b }
            goto L_0x0119
        L_0x0107:
            android.content.SharedPreferences$Editor r14 = r3.editor     // Catch:{ JSONException -> 0x011b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)     // Catch:{ JSONException -> 0x011b }
            java.lang.String r15 = "run_upload"
            r14.putBoolean(r15, r9)     // Catch:{ JSONException -> 0x011b }
            android.content.SharedPreferences$Editor r14 = r3.editor     // Catch:{ JSONException -> 0x011b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)     // Catch:{ JSONException -> 0x011b }
            r14.commit()     // Catch:{ JSONException -> 0x011b }
        L_0x0119:
            r14 = 1
            goto L_0x013a
        L_0x011b:
            r14 = move-exception
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r15 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.M2SDKLogger r15 = r15.getLogger(r7)
            java.lang.String r14 = r14.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "JSON config Exception"
            r0.<init>(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            java.lang.String[] r0 = new java.lang.String[r9]
            r15.e(r6, r14, r0)
        L_0x0139:
            r14 = 0
        L_0x013a:
            if (r14 == 0) goto L_0x013d
            goto L_0x013e
        L_0x013d:
            r8 = 0
        L_0x013e:
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil.updateConfig(com.m2catalyst.m2sdk.business.models.MNSI, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
