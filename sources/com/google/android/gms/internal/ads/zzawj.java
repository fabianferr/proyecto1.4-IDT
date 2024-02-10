package com.google.android.gms.internal.ads;

import android.util.Log;
import com.ironsource.mediationsdk.IronSourceSegment;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzawj {
    private static final int zzA = zzbar.zzg("sosn");
    private static final int zzB = zzbar.zzg("tvsh");
    private static final int zzC = zzbar.zzg("----");
    private static final String[] zzD = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};
    private static final int zza = zzbar.zzg("nam");
    private static final int zzb = zzbar.zzg("trk");
    private static final int zzc = zzbar.zzg("cmt");
    private static final int zzd = zzbar.zzg("day");
    private static final int zze = zzbar.zzg("ART");
    private static final int zzf = zzbar.zzg("too");
    private static final int zzg = zzbar.zzg("alb");
    private static final int zzh = zzbar.zzg("com");
    private static final int zzi = zzbar.zzg("wrt");
    private static final int zzj = zzbar.zzg("lyr");
    private static final int zzk = zzbar.zzg(IronSourceSegment.GENDER);
    private static final int zzl = zzbar.zzg("covr");
    private static final int zzm = zzbar.zzg("gnre");
    private static final int zzn = zzbar.zzg("grp");
    private static final int zzo = zzbar.zzg("disk");
    private static final int zzp = zzbar.zzg("trkn");
    private static final int zzq = zzbar.zzg("tmpo");
    private static final int zzr = zzbar.zzg("cpil");
    private static final int zzs = zzbar.zzg("aART");
    private static final int zzt = zzbar.zzg("sonm");
    private static final int zzu = zzbar.zzg("soal");
    private static final int zzv = zzbar.zzg("soar");
    private static final int zzw = zzbar.zzg("soaa");
    private static final int zzx = zzbar.zzg("soco");
    private static final int zzy = zzbar.zzg("rtng");
    private static final int zzz = zzbar.zzg("pgap");

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039 A[Catch:{ all -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040 A[Catch:{ all -> 0x01d3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzaxg zza(com.google.android.gms.internal.ads.zzbak r13) {
        /*
            java.lang.String r0 = "Skipped unknown metadata entry: "
            java.lang.String r1 = "Unrecognized cover art flags: "
            int r2 = r13.zzc()
            int r3 = r13.zze()
            int r2 = r2 + r3
            int r3 = r13.zze()
            int r4 = r3 >> 24
            r4 = r4 & 255(0xff, float:3.57E-43)
            r5 = 169(0xa9, float:2.37E-43)
            java.lang.String r6 = "und"
            java.lang.String r7 = "TCON"
            java.lang.String r8 = "MetadataUtil"
            r9 = 0
            if (r4 == r5) goto L_0x01d6
            int r4 = zzm     // Catch:{ all -> 0x01d3 }
            r5 = -1
            if (r3 != r4) goto L_0x0049
            int r0 = zzb(r13)     // Catch:{ all -> 0x01d3 }
            if (r0 <= 0) goto L_0x0036
            java.lang.String[] r1 = zzD     // Catch:{ all -> 0x01d3 }
            int r3 = r1.length     // Catch:{ all -> 0x01d3 }
            r3 = 148(0x94, float:2.07E-43)
            if (r0 > r3) goto L_0x0036
            int r0 = r0 + r5
            r0 = r1[r0]     // Catch:{ all -> 0x01d3 }
            goto L_0x0037
        L_0x0036:
            r0 = r9
        L_0x0037:
            if (r0 == 0) goto L_0x0040
            com.google.android.gms.internal.ads.zzaxp r1 = new com.google.android.gms.internal.ads.zzaxp     // Catch:{ all -> 0x01d3 }
            r1.<init>(r7, r9, r0)     // Catch:{ all -> 0x01d3 }
            r9 = r1
            goto L_0x0045
        L_0x0040:
            java.lang.String r0 = "Failed to parse standard genre code"
            android.util.Log.w(r8, r0)     // Catch:{ all -> 0x01d3 }
        L_0x0045:
            r13.zzv(r2)
            return r9
        L_0x0049:
            int r4 = zzo     // Catch:{ all -> 0x01d3 }
            if (r3 != r4) goto L_0x0057
            java.lang.String r0 = "TPOS"
            com.google.android.gms.internal.ads.zzaxp r0 = zzd(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x0057:
            int r4 = zzp     // Catch:{ all -> 0x01d3 }
            if (r3 != r4) goto L_0x0065
            java.lang.String r0 = "TRCK"
            com.google.android.gms.internal.ads.zzaxp r0 = zzd(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x0065:
            int r4 = zzq     // Catch:{ all -> 0x01d3 }
            r7 = 1
            r10 = 0
            if (r3 != r4) goto L_0x0075
            java.lang.String r0 = "TBPM"
            com.google.android.gms.internal.ads.zzaxn r0 = zzc(r3, r0, r13, r7, r10)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x0075:
            int r4 = zzr     // Catch:{ all -> 0x01d3 }
            if (r3 != r4) goto L_0x0083
            java.lang.String r0 = "TCMP"
            com.google.android.gms.internal.ads.zzaxn r0 = zzc(r3, r0, r13, r7, r7)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x0083:
            int r4 = zzl     // Catch:{ all -> 0x01d3 }
            r11 = 4
            if (r3 != r4) goto L_0x00db
            int r0 = r13.zze()     // Catch:{ all -> 0x01d3 }
            int r3 = r13.zze()     // Catch:{ all -> 0x01d3 }
            int r4 = com.google.android.gms.internal.ads.zzavw.zzaH     // Catch:{ all -> 0x01d3 }
            if (r3 != r4) goto L_0x00d2
            int r3 = r13.zze()     // Catch:{ all -> 0x01d3 }
            int r3 = com.google.android.gms.internal.ads.zzavw.zze(r3)     // Catch:{ all -> 0x01d3 }
            r4 = 13
            if (r3 != r4) goto L_0x00a3
            java.lang.String r4 = "image/jpeg"
            goto L_0x00ae
        L_0x00a3:
            r4 = 14
            if (r3 != r4) goto L_0x00ad
            java.lang.String r3 = "image/png"
            r4 = r3
            r3 = 14
            goto L_0x00ae
        L_0x00ad:
            r4 = r9
        L_0x00ae:
            if (r4 != 0) goto L_0x00c0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d3 }
            r0.<init>(r1)     // Catch:{ all -> 0x01d3 }
            r0.append(r3)     // Catch:{ all -> 0x01d3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01d3 }
            android.util.Log.w(r8, r0)     // Catch:{ all -> 0x01d3 }
            goto L_0x00d7
        L_0x00c0:
            r13.zzw(r11)     // Catch:{ all -> 0x01d3 }
            int r0 = r0 + -16
            byte[] r1 = new byte[r0]     // Catch:{ all -> 0x01d3 }
            r13.zzq(r1, r10, r0)     // Catch:{ all -> 0x01d3 }
            com.google.android.gms.internal.ads.zzaxj r0 = new com.google.android.gms.internal.ads.zzaxj     // Catch:{ all -> 0x01d3 }
            r3 = 3
            r0.<init>(r4, r9, r3, r1)     // Catch:{ all -> 0x01d3 }
            r9 = r0
            goto L_0x00d7
        L_0x00d2:
            java.lang.String r0 = "Failed to parse cover art attribute"
            android.util.Log.w(r8, r0)     // Catch:{ all -> 0x01d3 }
        L_0x00d7:
            r13.zzv(r2)
            return r9
        L_0x00db:
            int r1 = zzs     // Catch:{ all -> 0x01d3 }
            if (r3 != r1) goto L_0x00e9
            java.lang.String r0 = "TPE2"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x00e9:
            int r1 = zzt     // Catch:{ all -> 0x01d3 }
            if (r3 != r1) goto L_0x00f7
            java.lang.String r0 = "TSOT"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x00f7:
            int r1 = zzu     // Catch:{ all -> 0x01d3 }
            if (r3 != r1) goto L_0x0105
            java.lang.String r0 = "TSO2"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x0105:
            int r1 = zzv     // Catch:{ all -> 0x01d3 }
            if (r3 != r1) goto L_0x0113
            java.lang.String r0 = "TSOA"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x0113:
            int r1 = zzw     // Catch:{ all -> 0x01d3 }
            if (r3 != r1) goto L_0x0121
            java.lang.String r0 = "TSOP"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x0121:
            int r1 = zzx     // Catch:{ all -> 0x01d3 }
            if (r3 != r1) goto L_0x012f
            java.lang.String r0 = "TSOC"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x012f:
            int r1 = zzy     // Catch:{ all -> 0x01d3 }
            if (r3 != r1) goto L_0x013d
            java.lang.String r0 = "ITUNESADVISORY"
            com.google.android.gms.internal.ads.zzaxn r0 = zzc(r3, r0, r13, r10, r10)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x013d:
            int r1 = zzz     // Catch:{ all -> 0x01d3 }
            if (r3 != r1) goto L_0x014b
            java.lang.String r0 = "ITUNESGAPLESS"
            com.google.android.gms.internal.ads.zzaxn r0 = zzc(r3, r0, r13, r10, r7)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x014b:
            int r1 = zzA     // Catch:{ all -> 0x01d3 }
            if (r3 != r1) goto L_0x0159
            java.lang.String r0 = "TVSHOWSORT"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x0159:
            int r1 = zzB     // Catch:{ all -> 0x01d3 }
            if (r3 != r1) goto L_0x0167
            java.lang.String r0 = "TVSHOW"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x0167:
            int r1 = zzC     // Catch:{ all -> 0x01d3 }
            if (r3 != r1) goto L_0x0280
            r0 = r9
            r1 = r0
            r3 = -1
            r4 = -1
        L_0x016f:
            int r7 = r13.zzc()     // Catch:{ all -> 0x01d3 }
            if (r7 >= r2) goto L_0x01a9
            int r7 = r13.zzc()     // Catch:{ all -> 0x01d3 }
            int r8 = r13.zze()     // Catch:{ all -> 0x01d3 }
            int r10 = r13.zze()     // Catch:{ all -> 0x01d3 }
            r13.zzw(r11)     // Catch:{ all -> 0x01d3 }
            int r12 = com.google.android.gms.internal.ads.zzavw.zzaF     // Catch:{ all -> 0x01d3 }
            if (r10 != r12) goto L_0x018f
            int r8 = r8 + -12
            java.lang.String r0 = r13.zzo(r8)     // Catch:{ all -> 0x01d3 }
            goto L_0x016f
        L_0x018f:
            int r12 = com.google.android.gms.internal.ads.zzavw.zzaG     // Catch:{ all -> 0x01d3 }
            if (r10 != r12) goto L_0x019a
            int r8 = r8 + -12
            java.lang.String r1 = r13.zzo(r8)     // Catch:{ all -> 0x01d3 }
            goto L_0x016f
        L_0x019a:
            int r12 = com.google.android.gms.internal.ads.zzavw.zzaH     // Catch:{ all -> 0x01d3 }
            if (r10 != r12) goto L_0x019f
            r4 = r8
        L_0x019f:
            if (r10 == r12) goto L_0x01a2
            goto L_0x01a3
        L_0x01a2:
            r3 = r7
        L_0x01a3:
            int r8 = r8 + -12
            r13.zzw(r8)     // Catch:{ all -> 0x01d3 }
            goto L_0x016f
        L_0x01a9:
            java.lang.String r7 = "com.apple.iTunes"
            boolean r0 = r7.equals(r0)     // Catch:{ all -> 0x01d3 }
            if (r0 == 0) goto L_0x01cf
            java.lang.String r0 = "iTunSMPB"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x01d3 }
            if (r0 == 0) goto L_0x01cf
            if (r3 != r5) goto L_0x01bc
            goto L_0x01cf
        L_0x01bc:
            r13.zzv(r3)     // Catch:{ all -> 0x01d3 }
            r0 = 16
            r13.zzw(r0)     // Catch:{ all -> 0x01d3 }
            int r4 = r4 + -16
            java.lang.String r0 = r13.zzo(r4)     // Catch:{ all -> 0x01d3 }
            com.google.android.gms.internal.ads.zzaxl r9 = new com.google.android.gms.internal.ads.zzaxl     // Catch:{ all -> 0x01d3 }
            r9.<init>(r6, r1, r0)     // Catch:{ all -> 0x01d3 }
        L_0x01cf:
            r13.zzv(r2)
            return r9
        L_0x01d3:
            r0 = move-exception
            goto L_0x02ab
        L_0x01d6:
            r1 = 16777215(0xffffff, float:2.3509886E-38)
            r1 = r1 & r3
            int r4 = zzc     // Catch:{ all -> 0x01d3 }
            if (r1 != r4) goto L_0x020c
            int r0 = r13.zze()     // Catch:{ all -> 0x01d3 }
            int r1 = r13.zze()     // Catch:{ all -> 0x01d3 }
            int r4 = com.google.android.gms.internal.ads.zzavw.zzaH     // Catch:{ all -> 0x01d3 }
            if (r1 != r4) goto L_0x01fb
            r1 = 8
            r13.zzw(r1)     // Catch:{ all -> 0x01d3 }
            int r0 = r0 + -16
            java.lang.String r0 = r13.zzo(r0)     // Catch:{ all -> 0x01d3 }
            com.google.android.gms.internal.ads.zzaxl r9 = new com.google.android.gms.internal.ads.zzaxl     // Catch:{ all -> 0x01d3 }
            r9.<init>(r6, r0, r0)     // Catch:{ all -> 0x01d3 }
            goto L_0x0208
        L_0x01fb:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzavw.zzg(r3)     // Catch:{ all -> 0x01d3 }
            java.lang.String r1 = "Failed to parse comment attribute: "
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x01d3 }
            android.util.Log.w(r8, r0)     // Catch:{ all -> 0x01d3 }
        L_0x0208:
            r13.zzv(r2)
            return r9
        L_0x020c:
            int r4 = zza     // Catch:{ all -> 0x01d3 }
            if (r1 == r4) goto L_0x02a1
            int r4 = zzb     // Catch:{ all -> 0x01d3 }
            if (r1 != r4) goto L_0x0216
            goto L_0x02a1
        L_0x0216:
            int r4 = zzh     // Catch:{ all -> 0x01d3 }
            if (r1 == r4) goto L_0x0297
            int r4 = zzi     // Catch:{ all -> 0x01d3 }
            if (r1 != r4) goto L_0x0220
            goto L_0x0297
        L_0x0220:
            int r4 = zzd     // Catch:{ all -> 0x01d3 }
            if (r1 != r4) goto L_0x022e
            java.lang.String r0 = "TDRC"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x022e:
            int r4 = zze     // Catch:{ all -> 0x01d3 }
            if (r1 != r4) goto L_0x023c
            java.lang.String r0 = "TPE1"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x023c:
            int r4 = zzf     // Catch:{ all -> 0x01d3 }
            if (r1 != r4) goto L_0x024a
            java.lang.String r0 = "TSSE"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x024a:
            int r4 = zzg     // Catch:{ all -> 0x01d3 }
            if (r1 != r4) goto L_0x0258
            java.lang.String r0 = "TALB"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x0258:
            int r4 = zzj     // Catch:{ all -> 0x01d3 }
            if (r1 != r4) goto L_0x0266
            java.lang.String r0 = "USLT"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x0266:
            int r4 = zzk     // Catch:{ all -> 0x01d3 }
            if (r1 != r4) goto L_0x0272
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r7, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x0272:
            int r4 = zzn     // Catch:{ all -> 0x01d3 }
            if (r1 != r4) goto L_0x0280
            java.lang.String r0 = "TIT1"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x0280:
            java.lang.String r1 = com.google.android.gms.internal.ads.zzavw.zzg(r3)     // Catch:{ all -> 0x01d3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d3 }
            r3.<init>(r0)     // Catch:{ all -> 0x01d3 }
            r3.append(r1)     // Catch:{ all -> 0x01d3 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x01d3 }
            android.util.Log.d(r8, r0)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r9
        L_0x0297:
            java.lang.String r0 = "TCOM"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x02a1:
            java.lang.String r0 = "TIT2"
            com.google.android.gms.internal.ads.zzaxp r0 = zze(r3, r0, r13)     // Catch:{ all -> 0x01d3 }
            r13.zzv(r2)
            return r0
        L_0x02ab:
            r13.zzv(r2)
            goto L_0x02b0
        L_0x02af:
            throw r0
        L_0x02b0:
            goto L_0x02af
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawj.zza(com.google.android.gms.internal.ads.zzbak):com.google.android.gms.internal.ads.zzaxg");
    }

    private static int zzb(zzbak zzbak) {
        zzbak.zzw(4);
        if (zzbak.zze() == zzavw.zzaH) {
            zzbak.zzw(8);
            return zzbak.zzg();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static zzaxn zzc(int i, String str, zzbak zzbak, boolean z, boolean z2) {
        int zzb2 = zzb(zzbak);
        if (z2) {
            zzb2 = Math.min(1, zzb2);
        }
        if (zzb2 < 0) {
            Log.w("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzavw.zzg(i)));
            return null;
        } else if (z) {
            return new zzaxp(str, (String) null, Integer.toString(zzb2));
        } else {
            return new zzaxl("und", str, Integer.toString(zzb2));
        }
    }

    private static zzaxp zzd(int i, String str, zzbak zzbak) {
        int zze2 = zzbak.zze();
        if (zzbak.zze() == zzavw.zzaH && zze2 >= 22) {
            zzbak.zzw(10);
            int zzj2 = zzbak.zzj();
            if (zzj2 > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(zzj2);
                String sb2 = sb.toString();
                int zzj3 = zzbak.zzj();
                if (zzj3 > 0) {
                    sb2 = sb2 + "/" + zzj3;
                }
                return new zzaxp(str, (String) null, sb2);
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzavw.zzg(i)));
        return null;
    }

    private static zzaxp zze(int i, String str, zzbak zzbak) {
        int zze2 = zzbak.zze();
        if (zzbak.zze() == zzavw.zzaH) {
            zzbak.zzw(8);
            return new zzaxp(str, (String) null, zzbak.zzo(zze2 - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: ".concat(zzavw.zzg(i)));
        return null;
    }
}
