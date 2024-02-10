package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzafm {
    static final String[] zza = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final /* synthetic */ int zzb = 0;

    /* JADX WARNING: Unknown top exception splitter block from list: {B:137:0x018d=Splitter:B:137:0x018d, B:225:0x029d=Splitter:B:225:0x029d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzbp zza(com.google.android.gms.internal.ads.zzef r12) {
        /*
            java.lang.String r0 = "Unrecognized cover art flags: "
            java.lang.String r1 = "Skipped unknown metadata entry: "
            int r2 = r12.zzc()
            int r3 = r12.zze()
            int r2 = r2 + r3
            int r3 = r12.zze()
            int r4 = r3 >> 24
            r4 = r4 & 255(0xff, float:3.57E-43)
            r5 = 169(0xa9, float:2.37E-43)
            java.lang.String r6 = "TCON"
            r7 = 16777215(0xffffff, float:2.3509886E-38)
            r8 = 1684108385(0x64617461, float:1.6635614E22)
            java.lang.String r9 = "MetadataUtil"
            r10 = 0
            if (r4 == r5) goto L_0x01e6
            r5 = 253(0xfd, float:3.55E-43)
            if (r4 != r5) goto L_0x002a
            goto L_0x01e6
        L_0x002a:
            r4 = 1735291493(0x676e7265, float:1.1260334E24)
            r5 = -1
            if (r3 != r4) goto L_0x0053
            int r0 = zzb(r12)     // Catch:{ all -> 0x021b }
            if (r0 <= 0) goto L_0x0040
            r1 = 192(0xc0, float:2.69E-43)
            if (r0 > r1) goto L_0x0040
            java.lang.String[] r1 = zza     // Catch:{ all -> 0x021b }
            int r0 = r0 + r5
            r0 = r1[r0]     // Catch:{ all -> 0x021b }
            goto L_0x0041
        L_0x0040:
            r0 = r10
        L_0x0041:
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzadl r1 = new com.google.android.gms.internal.ads.zzadl     // Catch:{ all -> 0x021b }
            r1.<init>(r6, r10, r0)     // Catch:{ all -> 0x021b }
            r10 = r1
            goto L_0x004f
        L_0x004a:
            java.lang.String r0 = "Failed to parse standard genre code"
            com.google.android.gms.internal.ads.zzdw.zze(r9, r0)     // Catch:{ all -> 0x021b }
        L_0x004f:
            r12.zzF(r2)
            return r10
        L_0x0053:
            r4 = 1684632427(0x6469736b, float:1.7225632E22)
            if (r3 != r4) goto L_0x0062
            java.lang.String r0 = "TPOS"
            com.google.android.gms.internal.ads.zzadl r0 = zzd(r4, r0, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0062:
            r4 = 1953655662(0x74726b6e, float:7.6825853E31)
            if (r3 != r4) goto L_0x0071
            java.lang.String r0 = "TRCK"
            com.google.android.gms.internal.ads.zzadl r0 = zzd(r4, r0, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0071:
            r4 = 1953329263(0x746d706f, float:7.5247484E31)
            r6 = 1
            r11 = 0
            if (r3 != r4) goto L_0x0082
            java.lang.String r0 = "TBPM"
            com.google.android.gms.internal.ads.zzadd r0 = zzc(r4, r0, r12, r6, r11)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0082:
            r4 = 1668311404(0x6370696c, float:4.434815E21)
            if (r3 != r4) goto L_0x0091
            java.lang.String r0 = "TCMP"
            com.google.android.gms.internal.ads.zzadd r0 = zzc(r4, r0, r12, r6, r6)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0091:
            r4 = 1668249202(0x636f7672, float:4.4173067E21)
            if (r3 != r4) goto L_0x00e5
            int r1 = r12.zze()     // Catch:{ all -> 0x021b }
            int r3 = r12.zze()     // Catch:{ all -> 0x021b }
            if (r3 != r8) goto L_0x00dc
            int r3 = r12.zze()     // Catch:{ all -> 0x021b }
            r3 = r3 & r7
            r4 = 13
            if (r3 != r4) goto L_0x00ac
            java.lang.String r4 = "image/jpeg"
            goto L_0x00b7
        L_0x00ac:
            r4 = 14
            if (r3 != r4) goto L_0x00b6
            java.lang.String r3 = "image/png"
            r4 = r3
            r3 = 14
            goto L_0x00b7
        L_0x00b6:
            r4 = r10
        L_0x00b7:
            if (r4 != 0) goto L_0x00c9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x021b }
            r1.<init>(r0)     // Catch:{ all -> 0x021b }
            r1.append(r3)     // Catch:{ all -> 0x021b }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x021b }
            com.google.android.gms.internal.ads.zzdw.zze(r9, r0)     // Catch:{ all -> 0x021b }
            goto L_0x00e1
        L_0x00c9:
            r0 = 4
            r12.zzG(r0)     // Catch:{ all -> 0x021b }
            int r1 = r1 + -16
            byte[] r0 = new byte[r1]     // Catch:{ all -> 0x021b }
            r12.zzB(r0, r11, r1)     // Catch:{ all -> 0x021b }
            com.google.android.gms.internal.ads.zzaco r1 = new com.google.android.gms.internal.ads.zzaco     // Catch:{ all -> 0x021b }
            r3 = 3
            r1.<init>(r4, r10, r3, r0)     // Catch:{ all -> 0x021b }
            r10 = r1
            goto L_0x00e1
        L_0x00dc:
            java.lang.String r0 = "Failed to parse cover art attribute"
            com.google.android.gms.internal.ads.zzdw.zze(r9, r0)     // Catch:{ all -> 0x021b }
        L_0x00e1:
            r12.zzF(r2)
            return r10
        L_0x00e5:
            r0 = 1631670868(0x61415254, float:2.2288462E20)
            if (r3 != r0) goto L_0x00f4
            java.lang.String r1 = "TPE2"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r0, r1, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x00f4:
            r0 = 1936682605(0x736f6e6d, float:1.8969706E31)
            if (r3 != r0) goto L_0x0103
            java.lang.String r1 = "TSOT"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r0, r1, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0103:
            r0 = 1936679276(0x736f616c, float:1.8965681E31)
            if (r3 != r0) goto L_0x0112
            java.lang.String r1 = "TSO2"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r0, r1, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0112:
            r0 = 1936679282(0x736f6172, float:1.8965689E31)
            if (r3 != r0) goto L_0x0121
            java.lang.String r1 = "TSOA"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r0, r1, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0121:
            r0 = 1936679265(0x736f6161, float:1.8965668E31)
            if (r3 != r0) goto L_0x0130
            java.lang.String r1 = "TSOP"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r0, r1, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0130:
            r0 = 1936679791(0x736f636f, float:1.8966304E31)
            if (r3 != r0) goto L_0x013f
            java.lang.String r1 = "TSOC"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r0, r1, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x013f:
            r0 = 1920233063(0x72746e67, float:4.84146E30)
            if (r3 != r0) goto L_0x014e
            java.lang.String r1 = "ITUNESADVISORY"
            com.google.android.gms.internal.ads.zzadd r0 = zzc(r0, r1, r12, r11, r11)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x014e:
            r0 = 1885823344(0x70676170, float:2.8643533E29)
            if (r3 != r0) goto L_0x0160
            java.lang.String r0 = "ITUNESGAPLESS"
            r1 = 1885823344(0x70676170, float:2.8643533E29)
            com.google.android.gms.internal.ads.zzadd r0 = zzc(r1, r0, r12, r11, r6)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0160:
            r0 = 1936683886(0x736f736e, float:1.8971255E31)
            if (r3 != r0) goto L_0x0172
            java.lang.String r0 = "TVSHOWSORT"
            r1 = 1936683886(0x736f736e, float:1.8971255E31)
            com.google.android.gms.internal.ads.zzadl r0 = zze(r1, r0, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0172:
            r0 = 1953919848(0x74767368, float:7.810338E31)
            if (r3 != r0) goto L_0x0184
            java.lang.String r0 = "TVSHOW"
            r1 = 1953919848(0x74767368, float:7.810338E31)
            com.google.android.gms.internal.ads.zzadl r0 = zze(r1, r0, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0184:
            r0 = 757935405(0x2d2d2d2d, float:9.8439425E-12)
            if (r3 != r0) goto L_0x029d
            r0 = r10
            r1 = r0
            r3 = -1
            r4 = -1
        L_0x018d:
            int r6 = r12.zzc()     // Catch:{ all -> 0x021b }
            if (r6 >= r2) goto L_0x01c8
            int r6 = r12.zzc()     // Catch:{ all -> 0x021b }
            int r7 = r12.zze()     // Catch:{ all -> 0x021b }
            int r9 = r12.zze()     // Catch:{ all -> 0x021b }
            r11 = 4
            r12.zzG(r11)     // Catch:{ all -> 0x021b }
            r11 = 1835360622(0x6d65616e, float:4.4368658E27)
            if (r9 != r11) goto L_0x01af
            int r7 = r7 + -12
            java.lang.String r0 = r12.zzw(r7)     // Catch:{ all -> 0x021b }
            goto L_0x018d
        L_0x01af:
            r11 = 1851878757(0x6e616d65, float:1.7441594E28)
            if (r9 != r11) goto L_0x01bb
            int r7 = r7 + -12
            java.lang.String r1 = r12.zzw(r7)     // Catch:{ all -> 0x021b }
            goto L_0x018d
        L_0x01bb:
            if (r9 != r8) goto L_0x01be
            r4 = r7
        L_0x01be:
            if (r9 == r8) goto L_0x01c1
            goto L_0x01c2
        L_0x01c1:
            r3 = r6
        L_0x01c2:
            int r7 = r7 + -12
            r12.zzG(r7)     // Catch:{ all -> 0x021b }
            goto L_0x018d
        L_0x01c8:
            if (r0 == 0) goto L_0x01e2
            if (r1 == 0) goto L_0x01e2
            if (r3 != r5) goto L_0x01cf
            goto L_0x01e2
        L_0x01cf:
            r12.zzF(r3)     // Catch:{ all -> 0x021b }
            r3 = 16
            r12.zzG(r3)     // Catch:{ all -> 0x021b }
            int r4 = r4 + -16
            java.lang.String r3 = r12.zzw(r4)     // Catch:{ all -> 0x021b }
            com.google.android.gms.internal.ads.zzadf r10 = new com.google.android.gms.internal.ads.zzadf     // Catch:{ all -> 0x021b }
            r10.<init>(r0, r1, r3)     // Catch:{ all -> 0x021b }
        L_0x01e2:
            r12.zzF(r2)
            return r10
        L_0x01e6:
            r0 = r3 & r7
            r4 = 6516084(0x636d74, float:9.130979E-39)
            if (r0 != r4) goto L_0x021e
            int r0 = r12.zze()     // Catch:{ all -> 0x021b }
            int r1 = r12.zze()     // Catch:{ all -> 0x021b }
            if (r1 != r8) goto L_0x020a
            r1 = 8
            r12.zzG(r1)     // Catch:{ all -> 0x021b }
            int r0 = r0 + -16
            java.lang.String r0 = r12.zzw(r0)     // Catch:{ all -> 0x021b }
            com.google.android.gms.internal.ads.zzacw r10 = new com.google.android.gms.internal.ads.zzacw     // Catch:{ all -> 0x021b }
            java.lang.String r1 = "und"
            r10.<init>(r1, r0, r0)     // Catch:{ all -> 0x021b }
            goto L_0x0217
        L_0x020a:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzaex.zzf(r3)     // Catch:{ all -> 0x021b }
            java.lang.String r1 = "Failed to parse comment attribute: "
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x021b }
            com.google.android.gms.internal.ads.zzdw.zze(r9, r0)     // Catch:{ all -> 0x021b }
        L_0x0217:
            r12.zzF(r2)
            return r10
        L_0x021b:
            r0 = move-exception
            goto L_0x02c8
        L_0x021e:
            r4 = 7233901(0x6e616d, float:1.0136854E-38)
            if (r0 == r4) goto L_0x02be
            r4 = 7631467(0x74726b, float:1.0693963E-38)
            if (r0 != r4) goto L_0x022a
            goto L_0x02be
        L_0x022a:
            r4 = 6516589(0x636f6d, float:9.131686E-39)
            if (r0 == r4) goto L_0x02b4
            r4 = 7828084(0x777274, float:1.0969482E-38)
            if (r0 != r4) goto L_0x0236
            goto L_0x02b4
        L_0x0236:
            r4 = 6578553(0x646179, float:9.218516E-39)
            if (r0 != r4) goto L_0x0245
            java.lang.String r0 = "TDRC"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r3, r0, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0245:
            r4 = 4280916(0x415254, float:5.998841E-39)
            if (r0 != r4) goto L_0x0254
            java.lang.String r0 = "TPE1"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r3, r0, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0254:
            r4 = 7630703(0x746f6f, float:1.0692892E-38)
            if (r0 != r4) goto L_0x0263
            java.lang.String r0 = "TSSE"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r3, r0, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0263:
            r4 = 6384738(0x616c62, float:8.946924E-39)
            if (r0 != r4) goto L_0x0272
            java.lang.String r0 = "TALB"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r3, r0, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0272:
            r4 = 7108978(0x6c7972, float:9.9618E-39)
            if (r0 != r4) goto L_0x0281
            java.lang.String r0 = "USLT"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r3, r0, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x0281:
            r4 = 6776174(0x67656e, float:9.495442E-39)
            if (r0 != r4) goto L_0x028e
            com.google.android.gms.internal.ads.zzadl r0 = zze(r3, r6, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x028e:
            r4 = 6779504(0x677270, float:9.500109E-39)
            if (r0 != r4) goto L_0x029d
            java.lang.String r0 = "TIT1"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r3, r0, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x029d:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzaex.zzf(r3)     // Catch:{ all -> 0x021b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x021b }
            r3.<init>(r1)     // Catch:{ all -> 0x021b }
            r3.append(r0)     // Catch:{ all -> 0x021b }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x021b }
            com.google.android.gms.internal.ads.zzdw.zza(r9, r0)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r10
        L_0x02b4:
            java.lang.String r0 = "TCOM"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r3, r0, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x02be:
            java.lang.String r0 = "TIT2"
            com.google.android.gms.internal.ads.zzadl r0 = zze(r3, r0, r12)     // Catch:{ all -> 0x021b }
            r12.zzF(r2)
            return r0
        L_0x02c8:
            r12.zzF(r2)
            goto L_0x02cd
        L_0x02cc:
            throw r0
        L_0x02cd:
            goto L_0x02cc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafm.zza(com.google.android.gms.internal.ads.zzef):com.google.android.gms.internal.ads.zzbp");
    }

    private static int zzb(zzef zzef) {
        zzef.zzG(4);
        if (zzef.zze() == 1684108385) {
            zzef.zzG(8);
            return zzef.zzk();
        }
        zzdw.zze("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static zzadd zzc(int i, String str, zzef zzef, boolean z, boolean z2) {
        int zzb2 = zzb(zzef);
        if (z2) {
            zzb2 = Math.min(1, zzb2);
        }
        if (zzb2 < 0) {
            zzdw.zze("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzaex.zzf(i)));
            return null;
        } else if (z) {
            return new zzadl(str, (String) null, Integer.toString(zzb2));
        } else {
            return new zzacw("und", str, Integer.toString(zzb2));
        }
    }

    private static zzadl zzd(int i, String str, zzef zzef) {
        int zze = zzef.zze();
        if (zzef.zze() == 1684108385 && zze >= 22) {
            zzef.zzG(10);
            int zzo = zzef.zzo();
            if (zzo > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(zzo);
                String sb2 = sb.toString();
                int zzo2 = zzef.zzo();
                if (zzo2 > 0) {
                    sb2 = sb2 + "/" + zzo2;
                }
                return new zzadl(str, (String) null, sb2);
            }
        }
        zzdw.zze("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzaex.zzf(i)));
        return null;
    }

    private static zzadl zze(int i, String str, zzef zzef) {
        int zze = zzef.zze();
        if (zzef.zze() == 1684108385) {
            zzef.zzG(8);
            return new zzadl(str, (String) null, zzef.zzw(zze - 16));
        }
        zzdw.zze("MetadataUtil", "Failed to parse text attribute: ".concat(zzaex.zzf(i)));
        return null;
    }
}
