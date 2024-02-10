package com.google.android.gms.ads.internal.util;

import android.util.Range;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzch {
    private static final Map zza = new HashMap();
    private static List zzb;
    private static final Object zzc = new Object();

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static java.util.List zza(java.lang.String r14) {
        /*
            java.lang.Object r0 = zzc
            monitor-enter(r0)
            java.util.Map r1 = zza     // Catch:{ all -> 0x0151 }
            boolean r2 = r1.containsKey(r14)     // Catch:{ all -> 0x0151 }
            if (r2 == 0) goto L_0x0013
            java.lang.Object r14 = r1.get(r14)     // Catch:{ all -> 0x0151 }
            java.util.List r14 = (java.util.List) r14     // Catch:{ all -> 0x0151 }
            monitor-exit(r0)     // Catch:{ all -> 0x0151 }
            return r14
        L_0x0013:
            monitor-enter(r0)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.util.List r1 = zzb     // Catch:{ all -> 0x012a }
            r2 = 21
            r3 = 0
            if (r1 == 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x012a }
            goto L_0x004c
        L_0x001d:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x012a }
            if (r1 < r2) goto L_0x0031
            android.media.MediaCodecList r1 = new android.media.MediaCodecList     // Catch:{ all -> 0x012a }
            r1.<init>(r3)     // Catch:{ all -> 0x012a }
            android.media.MediaCodecInfo[] r1 = r1.getCodecInfos()     // Catch:{ all -> 0x012a }
            java.util.List r1 = java.util.Arrays.asList(r1)     // Catch:{ all -> 0x012a }
            zzb = r1     // Catch:{ all -> 0x012a }
            goto L_0x004b
        L_0x0031:
            int r1 = android.media.MediaCodecList.getCodecCount()     // Catch:{ all -> 0x012a }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x012a }
            r4.<init>(r1)     // Catch:{ all -> 0x012a }
            zzb = r4     // Catch:{ all -> 0x012a }
            r4 = 0
        L_0x003d:
            if (r4 >= r1) goto L_0x004b
            android.media.MediaCodecInfo r5 = android.media.MediaCodecList.getCodecInfoAt(r4)     // Catch:{ all -> 0x012a }
            java.util.List r6 = zzb     // Catch:{ all -> 0x012a }
            r6.add(r5)     // Catch:{ all -> 0x012a }
            int r4 = r4 + 1
            goto L_0x003d
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x012a }
        L_0x004c:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r1.<init>()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.util.List r4 = zzb     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
        L_0x0057:
            boolean r5 = r4.hasNext()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            if (r5 == 0) goto L_0x0123
            java.lang.Object r5 = r4.next()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            android.media.MediaCodecInfo r5 = (android.media.MediaCodecInfo) r5     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            boolean r6 = r5.isEncoder()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            if (r6 != 0) goto L_0x0057
            java.lang.String[] r6 = r5.getSupportedTypes()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            boolean r6 = r6.contains(r14)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            if (r6 == 0) goto L_0x0057
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r6.<init>()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.String r7 = "codecName"
            java.lang.String r8 = r5.getName()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r6.put(r7, r8)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            android.media.MediaCodecInfo$CodecCapabilities r5 = r5.getCapabilitiesForType(r14)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r7.<init>()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            android.media.MediaCodecInfo$CodecProfileLevel[] r8 = r5.profileLevels     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            int r9 = r8.length     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r10 = 0
        L_0x0092:
            if (r10 >= r9) goto L_0x00b0
            r11 = r8[r10]     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r12 = 2
            java.lang.Integer[] r12 = new java.lang.Integer[r12]     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            int r13 = r11.profile     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r12[r3] = r13     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            int r11 = r11.level     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r13 = 1
            r12[r13] = r11     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r7.add(r12)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            int r10 = r10 + 1
            goto L_0x0092
        L_0x00b0:
            java.lang.String r8 = "profileLevels"
            r6.put(r8, r7)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            if (r7 < r2) goto L_0x010b
            android.media.MediaCodecInfo$VideoCapabilities r7 = r5.getVideoCapabilities()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.String r8 = "bitRatesBps"
            android.util.Range r9 = r7.getBitrateRange()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.Integer[] r9 = zzb(r9)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r6.put(r8, r9)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.String r8 = "widthAlignment"
            int r9 = r7.getWidthAlignment()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r6.put(r8, r9)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.String r8 = "heightAlignment"
            int r9 = r7.getHeightAlignment()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r6.put(r8, r9)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.String r8 = "frameRates"
            android.util.Range r9 = r7.getSupportedFrameRates()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.Integer[] r9 = zzb(r9)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r6.put(r8, r9)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.String r8 = "widths"
            android.util.Range r9 = r7.getSupportedWidths()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.Integer[] r9 = zzb(r9)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r6.put(r8, r9)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.String r8 = "heights"
            android.util.Range r7 = r7.getSupportedHeights()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.Integer[] r7 = zzb(r7)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r6.put(r8, r7)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
        L_0x010b:
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r8 = 23
            if (r7 < r8) goto L_0x011e
            java.lang.String r7 = "instancesLimit"
            int r5 = r5.getMaxSupportedInstances()     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r6.put(r7, r5)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
        L_0x011e:
            r1.add(r6)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            goto L_0x0057
        L_0x0123:
            java.util.Map r2 = zza     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            r2.put(r14, r1)     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
            monitor-exit(r0)     // Catch:{ all -> 0x0151 }
            return r1
        L_0x012a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x012a }
            throw r1     // Catch:{ RuntimeException -> 0x012f, LinkageError -> 0x012d }
        L_0x012d:
            r1 = move-exception
            goto L_0x0130
        L_0x012f:
            r1 = move-exception
        L_0x0130:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0151 }
            r2.<init>()     // Catch:{ all -> 0x0151 }
            java.lang.String r3 = "error"
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x0151 }
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ all -> 0x0151 }
            r2.put(r3, r1)     // Catch:{ all -> 0x0151 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0151 }
            r1.<init>()     // Catch:{ all -> 0x0151 }
            r1.add(r2)     // Catch:{ all -> 0x0151 }
            java.util.Map r2 = zza     // Catch:{ all -> 0x0151 }
            r2.put(r14, r1)     // Catch:{ all -> 0x0151 }
            monitor-exit(r0)     // Catch:{ all -> 0x0151 }
            return r1
        L_0x0151:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0151 }
            goto L_0x0155
        L_0x0154:
            throw r14
        L_0x0155:
            goto L_0x0154
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzch.zza(java.lang.String):java.util.List");
    }

    private static Integer[] zzb(Range range) {
        return new Integer[]{(Integer) range.getLower(), (Integer) range.getUpper()};
    }
}
