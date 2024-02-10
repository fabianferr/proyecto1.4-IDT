package androidx.media3.exoplayer.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.XmlPullParserUtil;
import androidx.media3.exoplayer.dash.manifest.SegmentBase;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import com.applovin.sdk.AppLovinMediationProvider;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.cast.MediaTrack;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {
    private static final Pattern CEA_608_ACCESSIBILITY_PATTERN = Pattern.compile("CC([1-4])=.*");
    private static final Pattern CEA_708_ACCESSIBILITY_PATTERN = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    private static final Pattern FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final int[] MPEG_CHANNEL_CONFIGURATION_MAPPING = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};
    private static final String TAG = "MpdParser";
    private final XmlPullParserFactory xmlParserFactory;

    private static long getFinalAvailabilityTimeOffset(long j, long j2) {
        if (j2 != -9223372036854775807L) {
            j = j2;
        }
        if (j == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j;
    }

    public DashManifestParser() {
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public DashManifest parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            newPullParser.setInput(inputStream, (String) null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return parseMediaPresentationDescription(newPullParser, uri);
            }
            throw ParserException.createForMalformedManifest("inputStream does not contain a valid media presentation description", (Throwable) null);
        } catch (XmlPullParserException e) {
            throw ParserException.createForMalformedManifest((String) null, e);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01e6 A[LOOP:0: B:23:0x00a7->B:79:0x01e6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01a2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.exoplayer.dash.manifest.DashManifest parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser r47, android.net.Uri r48) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r46 = this;
            r14 = r46
            r12 = r47
            r0 = 0
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r2 = "profiles"
            java.lang.String[] r1 = r14.parseProfiles(r12, r2, r1)
            boolean r13 = r14.isDvbProfileDeclared(r1)
            java.lang.String r1 = "availabilityStartTime"
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r15 = parseDateTime(r12, r1, r9)
            java.lang.String r1 = "mediaPresentationDuration"
            long r17 = parseDuration(r12, r1, r9)
            java.lang.String r1 = "minBufferTime"
            long r19 = parseDuration(r12, r1, r9)
            java.lang.String r1 = "type"
            r11 = 0
            java.lang.String r1 = r12.getAttributeValue(r11, r1)
            java.lang.String r2 = "dynamic"
            boolean r21 = r2.equals(r1)
            if (r21 == 0) goto L_0x0041
            java.lang.String r1 = "minimumUpdatePeriod"
            long r1 = parseDuration(r12, r1, r9)
            r22 = r1
            goto L_0x0043
        L_0x0041:
            r22 = r9
        L_0x0043:
            if (r21 == 0) goto L_0x004f
            java.lang.String r1 = "timeShiftBufferDepth"
            long r1 = parseDuration(r12, r1, r9)
            r24 = r1
            goto L_0x0051
        L_0x004f:
            r24 = r9
        L_0x0051:
            if (r21 == 0) goto L_0x005d
            java.lang.String r1 = "suggestedPresentationDelay"
            long r1 = parseDuration(r12, r1, r9)
            r26 = r1
            goto L_0x005f
        L_0x005d:
            r26 = r9
        L_0x005f:
            java.lang.String r1 = "publishTime"
            long r28 = parseDateTime(r12, r1, r9)
            if (r21 == 0) goto L_0x006a
            r3 = 0
            goto L_0x006b
        L_0x006a:
            r3 = r9
        L_0x006b:
            androidx.media3.exoplayer.dash.manifest.BaseUrl r5 = new androidx.media3.exoplayer.dash.manifest.BaseUrl
            java.lang.String r6 = r48.toString()
            java.lang.String r7 = r48.toString()
            r8 = 1
            if (r13 == 0) goto L_0x007a
            r1 = 1
            goto L_0x007e
        L_0x007a:
            r30 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x007e:
            r5.<init>(r6, r7, r1, r8)
            androidx.media3.exoplayer.dash.manifest.BaseUrl[] r1 = new androidx.media3.exoplayer.dash.manifest.BaseUrl[r8]
            r1[r0] = r5
            java.util.ArrayList r7 = com.google.common.collect.Lists.newArrayList((E[]) r1)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            if (r21 == 0) goto L_0x0097
            r1 = r9
            goto L_0x0099
        L_0x0097:
            r1 = 0
        L_0x0099:
            r32 = r1
            r34 = r11
            r35 = r34
            r36 = r35
            r37 = r36
            r30 = 0
            r31 = 0
        L_0x00a7:
            r47.next()
            java.lang.String r0 = "BaseURL"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r12, r0)
            if (r0 == 0) goto L_0x00c2
            if (r30 != 0) goto L_0x00ba
            long r3 = r14.parseAvailabilityTimeOffsetUs(r12, r3)
            r30 = 1
        L_0x00ba:
            java.util.List r0 = r14.parseBaseUrl(r12, r7, r13)
            r6.addAll(r0)
            goto L_0x00d0
        L_0x00c2:
            java.lang.String r0 = "ProgramInformation"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r12, r0)
            if (r0 == 0) goto L_0x00dc
            androidx.media3.exoplayer.dash.manifest.ProgramInformation r0 = r46.parseProgramInformation(r47)
            r34 = r0
        L_0x00d0:
            r41 = r6
            r43 = r7
            r44 = r9
            r14 = r11
            r42 = 1
            r11 = r5
            goto L_0x019a
        L_0x00dc:
            java.lang.String r0 = "UTCTiming"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r12, r0)
            if (r0 == 0) goto L_0x00eb
            androidx.media3.exoplayer.dash.manifest.UtcTimingElement r0 = r46.parseUtcTiming(r47)
            r35 = r0
            goto L_0x00d0
        L_0x00eb:
            java.lang.String r0 = "Location"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r12, r0)
            if (r0 == 0) goto L_0x0102
            java.lang.String r0 = r48.toString()
            java.lang.String r1 = r47.nextText()
            android.net.Uri r0 = androidx.media3.common.util.UriUtil.resolveToUri(r0, r1)
            r36 = r0
            goto L_0x00d0
        L_0x0102:
            java.lang.String r0 = "ServiceDescription"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r12, r0)
            if (r0 == 0) goto L_0x0111
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r0 = r46.parseServiceDescription(r47)
            r37 = r0
            goto L_0x00d0
        L_0x0111:
            java.lang.String r0 = "Period"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r12, r0)
            if (r0 == 0) goto L_0x0189
            if (r31 != 0) goto L_0x0189
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L_0x0123
            r2 = r6
            goto L_0x0124
        L_0x0123:
            r2 = r7
        L_0x0124:
            r0 = r46
            r1 = r47
            r38 = r3
            r3 = r32
            r40 = r5
            r41 = r6
            r5 = r38
            r43 = r7
            r42 = 1
            r7 = r15
            r44 = r9
            r9 = r24
            r14 = r11
            r11 = r13
            android.util.Pair r0 = r0.parsePeriod(r1, r2, r3, r5, r7, r9, r11)
            java.lang.Object r1 = r0.first
            androidx.media3.exoplayer.dash.manifest.Period r1 = (androidx.media3.exoplayer.dash.manifest.Period) r1
            long r2 = r1.startMs
            int r4 = (r2 > r44 ? 1 : (r2 == r44 ? 0 : -1))
            if (r4 != 0) goto L_0x0168
            if (r21 == 0) goto L_0x0151
            r11 = r40
            r8 = 1
            goto L_0x0186
        L_0x0151:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to determine start of period "
            r0.<init>(r1)
            int r1 = r40.size()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.createForMalformedManifest(r0, r14)
            throw r0
        L_0x0168:
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            int r0 = (r2 > r44 ? 1 : (r2 == r44 ? 0 : -1))
            if (r0 != 0) goto L_0x0179
            r11 = r40
            r9 = r44
            goto L_0x017f
        L_0x0179:
            long r4 = r1.startMs
            long r9 = r4 + r2
            r11 = r40
        L_0x017f:
            r11.add(r1)
            r32 = r9
            r8 = r31
        L_0x0186:
            r31 = r8
            goto L_0x0198
        L_0x0189:
            r38 = r3
            r41 = r6
            r43 = r7
            r44 = r9
            r14 = r11
            r42 = 1
            r11 = r5
            maybeSkipTag(r47)
        L_0x0198:
            r3 = r38
        L_0x019a:
            java.lang.String r0 = "MPD"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isEndTag(r12, r0)
            if (r0 == 0) goto L_0x01e6
            int r0 = (r17 > r44 ? 1 : (r17 == r44 ? 0 : -1))
            if (r0 != 0) goto L_0x01b7
            int r0 = (r32 > r44 ? 1 : (r32 == r44 ? 0 : -1))
            if (r0 == 0) goto L_0x01ad
            r3 = r32
            goto L_0x01b9
        L_0x01ad:
            if (r21 == 0) goto L_0x01b0
            goto L_0x01b7
        L_0x01b0:
            java.lang.String r0 = "Unable to determine duration of static manifest."
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.createForMalformedManifest(r0, r14)
            throw r0
        L_0x01b7:
            r3 = r17
        L_0x01b9:
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x01df
            r0 = r46
            r1 = r15
            r5 = r19
            r7 = r21
            r8 = r22
            r38 = r11
            r10 = r24
            r12 = r26
            r14 = r28
            r16 = r34
            r17 = r35
            r18 = r37
            r19 = r36
            r20 = r38
            androidx.media3.exoplayer.dash.manifest.DashManifest r0 = r0.buildMediaPresentationDescription(r1, r3, r5, r7, r8, r10, r12, r14, r16, r17, r18, r19, r20)
            return r0
        L_0x01df:
            java.lang.String r0 = "No periods found."
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.createForMalformedManifest(r0, r14)
            throw r0
        L_0x01e6:
            r5 = r11
            r11 = r14
            r6 = r41
            r7 = r43
            r9 = r44
            r8 = 1
            r14 = r46
            goto L_0x00a7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser, android.net.Uri):androidx.media3.exoplayer.dash.manifest.DashManifest");
    }

    /* access modifiers changed from: protected */
    public DashManifest buildMediaPresentationDescription(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, ProgramInformation programInformation, UtcTimingElement utcTimingElement, ServiceDescriptionElement serviceDescriptionElement, Uri uri, List<Period> list) {
        return new DashManifest(j, j2, j3, z, j4, j5, j6, j7, programInformation, utcTimingElement, serviceDescriptionElement, uri, list);
    }

    /* access modifiers changed from: protected */
    public UtcTimingElement parseUtcTiming(XmlPullParser xmlPullParser) {
        return buildUtcTimingElement(xmlPullParser.getAttributeValue((String) null, "schemeIdUri"), xmlPullParser.getAttributeValue((String) null, "value"));
    }

    /* access modifiers changed from: protected */
    public UtcTimingElement buildUtcTimingElement(String str, String str2) {
        return new UtcTimingElement(str, str2);
    }

    /* access modifiers changed from: protected */
    public ServiceDescriptionElement parseServiceDescription(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        float f = -3.4028235E38f;
        float f2 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Latency")) {
                j = parseLong(xmlPullParser2, TypedValues.AttributesType.S_TARGET, -9223372036854775807L);
                j2 = parseLong(xmlPullParser2, "min", -9223372036854775807L);
                j3 = parseLong(xmlPullParser2, AppLovinMediationProvider.MAX, -9223372036854775807L);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "PlaybackRate")) {
                f = parseFloat(xmlPullParser2, "min", -3.4028235E38f);
                f2 = parseFloat(xmlPullParser2, AppLovinMediationProvider.MAX, -3.4028235E38f);
            }
            long j4 = j;
            long j5 = j2;
            long j6 = j3;
            float f3 = f;
            float f4 = f2;
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "ServiceDescription")) {
                return new ServiceDescriptionElement(j4, j5, j6, f3, f4);
            }
            j = j4;
            j2 = j5;
            j3 = j6;
            f = f3;
            f2 = f4;
        }
    }

    /* access modifiers changed from: protected */
    public Pair<Period, Long> parsePeriod(XmlPullParser xmlPullParser, List<BaseUrl> list, long j, long j2, long j3, long j4, boolean z) throws XmlPullParserException, IOException {
        long j5;
        ArrayList arrayList;
        Object obj;
        ArrayList arrayList2;
        ArrayList arrayList3;
        long j6;
        long j7;
        SegmentBase parseSegmentTemplate;
        DashManifestParser dashManifestParser = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue((String) null, "id");
        long parseDuration = parseDuration(xmlPullParser2, "start", j);
        long j8 = -9223372036854775807L;
        long j9 = j3 != -9223372036854775807L ? j3 + parseDuration : -9223372036854775807L;
        long parseDuration2 = parseDuration(xmlPullParser2, "duration", -9223372036854775807L);
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        long j10 = j2;
        long j11 = -9223372036854775807L;
        SegmentBase segmentBase = null;
        Descriptor descriptor = null;
        boolean z2 = false;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "BaseURL")) {
                if (!z2) {
                    j10 = dashManifestParser.parseAvailabilityTimeOffsetUs(xmlPullParser2, j10);
                    z2 = true;
                }
                arrayList6.addAll(dashManifestParser.parseBaseUrl(xmlPullParser2, list, z));
                arrayList = arrayList5;
                arrayList2 = arrayList6;
                j5 = j8;
                obj = obj2;
                arrayList3 = arrayList4;
            } else {
                List<BaseUrl> list2 = list;
                boolean z3 = z;
                if (XmlPullParserUtil.isStartTag(xmlPullParser2, "AdaptationSet")) {
                    j6 = j10;
                    arrayList2 = arrayList6;
                    arrayList3 = arrayList4;
                    arrayList3.add(parseAdaptationSet(xmlPullParser, !arrayList6.isEmpty() ? arrayList6 : list2, segmentBase, parseDuration2, j10, j11, j9, j4, z));
                    xmlPullParser2 = xmlPullParser;
                    arrayList = arrayList5;
                } else {
                    j6 = j10;
                    ArrayList arrayList7 = arrayList5;
                    arrayList2 = arrayList6;
                    arrayList3 = arrayList4;
                    xmlPullParser2 = xmlPullParser;
                    if (XmlPullParserUtil.isStartTag(xmlPullParser2, "EventStream")) {
                        ArrayList arrayList8 = arrayList7;
                        arrayList8.add(parseEventStream(xmlPullParser));
                        arrayList = arrayList8;
                    } else {
                        ArrayList arrayList9 = arrayList7;
                        if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentBase")) {
                            arrayList = arrayList9;
                            segmentBase = parseSegmentBase(xmlPullParser2, (SegmentBase.SingleSegmentBase) null);
                            obj = null;
                            j10 = j6;
                            j5 = -9223372036854775807L;
                        } else {
                            arrayList = arrayList9;
                            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentList")) {
                                long parseAvailabilityTimeOffsetUs = parseAvailabilityTimeOffsetUs(xmlPullParser2, -9223372036854775807L);
                                obj = null;
                                parseSegmentTemplate = parseSegmentList(xmlPullParser, (SegmentBase.SegmentList) null, j9, parseDuration2, j6, parseAvailabilityTimeOffsetUs, j4);
                                j11 = parseAvailabilityTimeOffsetUs;
                                j10 = j6;
                                j5 = -9223372036854775807L;
                            } else {
                                obj = null;
                                if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTemplate")) {
                                    long parseAvailabilityTimeOffsetUs2 = parseAvailabilityTimeOffsetUs(xmlPullParser2, -9223372036854775807L);
                                    j5 = -9223372036854775807L;
                                    parseSegmentTemplate = parseSegmentTemplate(xmlPullParser, (SegmentBase.SegmentTemplate) null, ImmutableList.of(), j9, parseDuration2, j6, parseAvailabilityTimeOffsetUs2, j4);
                                    j11 = parseAvailabilityTimeOffsetUs2;
                                    j10 = j6;
                                } else {
                                    j7 = -9223372036854775807L;
                                    if (XmlPullParserUtil.isStartTag(xmlPullParser2, "AssetIdentifier")) {
                                        descriptor = parseDescriptor(xmlPullParser2, "AssetIdentifier");
                                    } else {
                                        maybeSkipTag(xmlPullParser);
                                    }
                                    j10 = j6;
                                }
                            }
                            segmentBase = parseSegmentTemplate;
                        }
                    }
                }
                obj = null;
                j7 = -9223372036854775807L;
                j10 = j6;
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "Period")) {
                return Pair.create(buildPeriod(attributeValue, parseDuration, arrayList3, arrayList, descriptor), Long.valueOf(parseDuration2));
            }
            arrayList4 = arrayList3;
            arrayList6 = arrayList2;
            obj2 = obj;
            arrayList5 = arrayList;
            j8 = j5;
            dashManifestParser = this;
        }
    }

    /* access modifiers changed from: protected */
    public Period buildPeriod(String str, long j, List<AdaptationSet> list, List<EventStream> list2, Descriptor descriptor) {
        return new Period(str, j, list, list2, descriptor);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v3, resolved type: androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentTemplate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v5, resolved type: androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v6, resolved type: androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v4, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0314 A[LOOP:0: B:1:0x007f->B:69:0x0314, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02d5 A[EDGE_INSN: B:70:0x02d5->B:63:0x02d5 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.exoplayer.dash.manifest.AdaptationSet parseAdaptationSet(org.xmlpull.v1.XmlPullParser r56, java.util.List<androidx.media3.exoplayer.dash.manifest.BaseUrl> r57, androidx.media3.exoplayer.dash.manifest.SegmentBase r58, long r59, long r61, long r63, long r65, long r67, boolean r69) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r55 = this;
            r15 = r55
            r14 = r56
            java.lang.String r0 = "id"
            r1 = -1
            long r27 = parseLong(r14, r0, r1)
            int r0 = r55.parseContentType(r56)
            java.lang.String r1 = "mimeType"
            r13 = 0
            java.lang.String r29 = r14.getAttributeValue(r13, r1)
            java.lang.String r1 = "codecs"
            java.lang.String r30 = r14.getAttributeValue(r13, r1)
            java.lang.String r1 = "width"
            r2 = -1
            int r31 = parseInt(r14, r1, r2)
            java.lang.String r1 = "height"
            int r32 = parseInt(r14, r1, r2)
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r33 = parseFrameRate(r14, r1)
            java.lang.String r1 = "audioSamplingRate"
            int r34 = parseInt(r14, r1, r2)
            java.lang.String r12 = "lang"
            java.lang.String r1 = r14.getAttributeValue(r13, r12)
            java.lang.String r3 = "label"
            java.lang.String r3 = r14.getAttributeValue(r13, r3)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r35 = 0
            r36 = r58
            r37 = r0
            r38 = r1
            r40 = r3
            r42 = r13
            r39 = -1
            r41 = 0
            r2 = r61
            r0 = r63
        L_0x007f:
            r56.next()
            java.lang.String r13 = "BaseURL"
            boolean r13 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r13)
            if (r13 == 0) goto L_0x00be
            if (r41 != 0) goto L_0x0092
            long r2 = r15.parseAvailabilityTimeOffsetUs(r14, r2)
            r41 = 1
        L_0x0092:
            r13 = r57
            r61 = r0
            r17 = r10
            r10 = r69
            java.util.List r0 = r15.parseBaseUrl(r14, r13, r10)
            r4.addAll(r0)
        L_0x00a1:
            r0 = r61
            r43 = r4
            r15 = r5
            r45 = r6
            r46 = r7
            r47 = r8
            r48 = r9
            r50 = r11
            r51 = r12
            r52 = r37
            r54 = r38
            r53 = 0
            r37 = r2
            r3 = r17
            goto L_0x02cd
        L_0x00be:
            r13 = r57
            r61 = r0
            r17 = r10
            r10 = r69
            java.lang.String r0 = "ContentProtection"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x00e8
            android.util.Pair r0 = r55.parseContentProtection(r56)
            java.lang.Object r1 = r0.first
            if (r1 == 0) goto L_0x00dc
            java.lang.Object r1 = r0.first
            r42 = r1
            java.lang.String r42 = (java.lang.String) r42
        L_0x00dc:
            java.lang.Object r1 = r0.second
            if (r1 == 0) goto L_0x00a1
            java.lang.Object r0 = r0.second
            androidx.media3.common.DrmInitData$SchemeData r0 = (androidx.media3.common.DrmInitData.SchemeData) r0
            r11.add(r0)
            goto L_0x00a1
        L_0x00e8:
            java.lang.String r0 = "ContentComponent"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x0122
            r1 = 0
            java.lang.String r0 = r14.getAttributeValue(r1, r12)
            r15 = r38
            java.lang.String r0 = checkLanguageConsistency(r15, r0)
            int r15 = r55.parseContentType(r56)
            r13 = r37
            int r13 = checkContentTypeConsistency(r13, r15)
            r54 = r0
            r53 = r1
            r37 = r2
            r43 = r4
            r15 = r5
            r45 = r6
            r46 = r7
            r47 = r8
            r48 = r9
            r50 = r11
            r51 = r12
            r52 = r13
            r3 = r17
        L_0x011e:
            r0 = r61
            goto L_0x02cd
        L_0x0122:
            r13 = r37
            r15 = r38
            r1 = 0
            java.lang.String r0 = "Role"
            boolean r16 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r16 == 0) goto L_0x0137
            androidx.media3.exoplayer.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r8.add(r0)
            goto L_0x0145
        L_0x0137:
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x0162
            int r0 = r55.parseAudioChannelConfiguration(r56)
            r39 = r0
        L_0x0145:
            r53 = r1
            r37 = r2
            r43 = r4
            r45 = r6
            r46 = r7
            r47 = r8
            r48 = r9
            r50 = r11
            r51 = r12
            r52 = r13
            r54 = r15
            r3 = r17
            r0 = r61
            r15 = r5
            goto L_0x02cd
        L_0x0162:
            java.lang.String r0 = "Accessibility"
            boolean r16 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r16 == 0) goto L_0x0172
            androidx.media3.exoplayer.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r9.add(r0)
            goto L_0x0145
        L_0x0172:
            java.lang.String r0 = "EssentialProperty"
            boolean r16 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r16 == 0) goto L_0x0182
            androidx.media3.exoplayer.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r7.add(r0)
            goto L_0x0145
        L_0x0182:
            java.lang.String r0 = "SupplementalProperty"
            boolean r16 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r16 == 0) goto L_0x0192
            androidx.media3.exoplayer.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r6.add(r0)
            goto L_0x0145
        L_0x0192:
            java.lang.String r0 = "Representation"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x020b
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L_0x01a3
            r16 = r4
            goto L_0x01a5
        L_0x01a3:
            r16 = r57
        L_0x01a5:
            r0 = r55
            r18 = r1
            r1 = r56
            r37 = r2
            r2 = r16
            r3 = r29
            r43 = r4
            r4 = r30
            r44 = r5
            r5 = r31
            r45 = r6
            r6 = r32
            r46 = r7
            r7 = r33
            r47 = r8
            r8 = r39
            r48 = r9
            r9 = r34
            r49 = r17
            r10 = r15
            r50 = r11
            r11 = r47
            r51 = r12
            r12 = r48
            r52 = r13
            r53 = r18
            r13 = r46
            r14 = r45
            r54 = r15
            r15 = r36
            r16 = r65
            r18 = r59
            r20 = r37
            r22 = r61
            r24 = r67
            r26 = r69
            androidx.media3.exoplayer.dash.manifest.DashManifestParser$RepresentationInfo r0 = r0.parseRepresentation(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r20, r22, r24, r26)
            androidx.media3.common.Format r1 = r0.format
            java.lang.String r1 = r1.sampleMimeType
            int r1 = androidx.media3.common.MimeTypes.getTrackType(r1)
            r14 = r52
            int r1 = checkContentTypeConsistency(r14, r1)
            r15 = r44
            r15.add(r0)
            r14 = r56
            r52 = r1
            r3 = r49
            goto L_0x011e
        L_0x020b:
            r53 = r1
            r37 = r2
            r43 = r4
            r45 = r6
            r46 = r7
            r47 = r8
            r48 = r9
            r50 = r11
            r51 = r12
            r14 = r13
            r54 = r15
            r49 = r17
            r15 = r5
            java.lang.String r0 = "SegmentBase"
            r13 = r56
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r13, r0)
            if (r0 == 0) goto L_0x0242
            r0 = r36
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase r0 = (androidx.media3.exoplayer.dash.manifest.SegmentBase.SingleSegmentBase) r0
            r11 = r55
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase r0 = r11.parseSegmentBase(r13, r0)
            r36 = r0
            r52 = r14
            r3 = r49
            r0 = r61
            r14 = r13
            goto L_0x02cd
        L_0x0242:
            r11 = r55
            java.lang.String r0 = "SegmentList"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r13, r0)
            if (r0 == 0) goto L_0x0273
            r0 = r61
            long r16 = r11.parseAvailabilityTimeOffsetUs(r13, r0)
            r2 = r36
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentList r2 = (androidx.media3.exoplayer.dash.manifest.SegmentBase.SegmentList) r2
            r0 = r55
            r1 = r56
            r3 = r65
            r5 = r59
            r7 = r37
            r9 = r16
            r52 = r14
            r14 = r11
            r11 = r67
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentList r0 = r0.parseSegmentList(r1, r2, r3, r5, r7, r9, r11)
            r36 = r0
            r14 = r13
        L_0x026e:
            r0 = r16
            r3 = r49
            goto L_0x02cd
        L_0x0273:
            r0 = r61
            r52 = r14
            r14 = r11
            java.lang.String r2 = "SegmentTemplate"
            boolean r2 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r13, r2)
            if (r2 == 0) goto L_0x02a0
            long r16 = r14.parseAvailabilityTimeOffsetUs(r13, r0)
            r2 = r36
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentTemplate r2 = (androidx.media3.exoplayer.dash.manifest.SegmentBase.SegmentTemplate) r2
            r0 = r55
            r1 = r56
            r3 = r45
            r4 = r65
            r6 = r59
            r8 = r37
            r10 = r16
            r14 = r13
            r12 = r67
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentTemplate r0 = r0.parseSegmentTemplate(r1, r2, r3, r4, r6, r8, r10, r12)
            r36 = r0
            goto L_0x026e
        L_0x02a0:
            r14 = r13
            java.lang.String r2 = "InbandEventStream"
            boolean r3 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r2)
            if (r3 == 0) goto L_0x02b3
            androidx.media3.exoplayer.dash.manifest.Descriptor r2 = parseDescriptor(r14, r2)
            r3 = r49
            r3.add(r2)
            goto L_0x02cd
        L_0x02b3:
            r3 = r49
            java.lang.String r2 = "Label"
            boolean r2 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r2)
            if (r2 == 0) goto L_0x02c4
            java.lang.String r2 = r55.parseLabel(r56)
            r40 = r2
            goto L_0x02cd
        L_0x02c4:
            boolean r2 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r56)
            if (r2 == 0) goto L_0x02cd
            r55.parseAdaptationSetChild(r56)
        L_0x02cd:
            java.lang.String r2 = "AdaptationSet"
            boolean r2 = androidx.media3.common.util.XmlPullParserUtil.isEndTag(r14, r2)
            if (r2 == 0) goto L_0x0314
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            r1 = 0
        L_0x02df:
            int r2 = r15.size()
            if (r1 >= r2) goto L_0x0301
            java.lang.Object r2 = r15.get(r1)
            androidx.media3.exoplayer.dash.manifest.DashManifestParser$RepresentationInfo r2 = (androidx.media3.exoplayer.dash.manifest.DashManifestParser.RepresentationInfo) r2
            r56 = r55
            r57 = r2
            r58 = r40
            r59 = r42
            r60 = r50
            r61 = r3
            androidx.media3.exoplayer.dash.manifest.Representation r2 = r56.buildRepresentation(r57, r58, r59, r60, r61)
            r0.add(r2)
            int r1 = r1 + 1
            goto L_0x02df
        L_0x0301:
            r56 = r55
            r57 = r27
            r59 = r52
            r60 = r0
            r61 = r48
            r62 = r46
            r63 = r45
            androidx.media3.exoplayer.dash.manifest.AdaptationSet r0 = r56.buildAdaptationSet(r57, r59, r60, r61, r62, r63)
            return r0
        L_0x0314:
            r10 = r3
            r5 = r15
            r2 = r37
            r4 = r43
            r6 = r45
            r7 = r46
            r8 = r47
            r9 = r48
            r11 = r50
            r12 = r51
            r37 = r52
            r13 = r53
            r38 = r54
            r15 = r55
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.parseAdaptationSet(org.xmlpull.v1.XmlPullParser, java.util.List, androidx.media3.exoplayer.dash.manifest.SegmentBase, long, long, long, long, long, boolean):androidx.media3.exoplayer.dash.manifest.AdaptationSet");
    }

    /* access modifiers changed from: protected */
    public AdaptationSet buildAdaptationSet(long j, int i, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        return new AdaptationSet(j, i, list, list2, list3, list4);
    }

    /* access modifiers changed from: protected */
    public int parseContentType(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        if ("image".equals(attributeValue)) {
            return 4;
        }
        return -1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.util.UUID} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0091, code lost:
        r0 = null;
        r3 = null;
        r5 = null;
        r4 = r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<java.lang.String, androidx.media3.common.DrmInitData.SchemeData> parseContentProtection(org.xmlpull.v1.XmlPullParser r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r8 = this;
            java.lang.String r0 = "schemeIdUri"
            r1 = 0
            java.lang.String r0 = r9.getAttributeValue(r1, r0)
            r2 = 0
            if (r0 == 0) goto L_0x0098
            java.lang.String r0 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r0)
            r0.hashCode()
            int r3 = r0.hashCode()
            r4 = -1
            switch(r3) {
                case -1980789791: goto L_0x003e;
                case 489446379: goto L_0x0032;
                case 755418770: goto L_0x0026;
                case 1812765994: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x0049
        L_0x001a:
            java.lang.String r3 = "urn:mpeg:dash:mp4protection:2011"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0024
            goto L_0x0049
        L_0x0024:
            r4 = 3
            goto L_0x0049
        L_0x0026:
            java.lang.String r3 = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0030
            goto L_0x0049
        L_0x0030:
            r4 = 2
            goto L_0x0049
        L_0x0032:
            java.lang.String r3 = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x003c
            goto L_0x0049
        L_0x003c:
            r4 = 1
            goto L_0x0049
        L_0x003e:
            java.lang.String r3 = "urn:uuid:e2719d58-a985-b3c9-781a-b030af78d30e"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r4 = 0
        L_0x0049:
            switch(r4) {
                case 0: goto L_0x0095;
                case 1: goto L_0x008f;
                case 2: goto L_0x008c;
                case 3: goto L_0x004d;
                default: goto L_0x004c;
            }
        L_0x004c:
            goto L_0x0098
        L_0x004d:
            java.lang.String r0 = "value"
            java.lang.String r0 = r9.getAttributeValue(r1, r0)
            java.lang.String r3 = "default_KID"
            java.lang.String r3 = androidx.media3.common.util.XmlPullParserUtil.getAttributeValueIgnorePrefix(r9, r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x008a
            java.lang.String r4 = "00000000-0000-0000-0000-000000000000"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x008a
            java.lang.String r4 = "\\s+"
            java.lang.String[] r3 = r3.split(r4)
            int r4 = r3.length
            java.util.UUID[] r4 = new java.util.UUID[r4]
            r5 = 0
        L_0x0072:
            int r6 = r3.length
            if (r5 >= r6) goto L_0x0080
            r6 = r3[r5]
            java.util.UUID r6 = java.util.UUID.fromString(r6)
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x0072
        L_0x0080:
            java.util.UUID r3 = androidx.media3.common.C.COMMON_PSSH_UUID
            byte[] r3 = androidx.media3.extractor.mp4.PsshAtomUtil.buildPsshAtom(r3, r4, r1)
            java.util.UUID r4 = androidx.media3.common.C.COMMON_PSSH_UUID
            r5 = r1
            goto L_0x009c
        L_0x008a:
            r3 = r1
            goto L_0x009a
        L_0x008c:
            java.util.UUID r4 = androidx.media3.common.C.WIDEVINE_UUID
            goto L_0x0091
        L_0x008f:
            java.util.UUID r4 = androidx.media3.common.C.PLAYREADY_UUID
        L_0x0091:
            r0 = r1
            r3 = r0
            r5 = r3
            goto L_0x009c
        L_0x0095:
            java.util.UUID r4 = androidx.media3.common.C.CLEARKEY_UUID
            goto L_0x0091
        L_0x0098:
            r0 = r1
            r3 = r0
        L_0x009a:
            r4 = r3
            r5 = r4
        L_0x009c:
            r9.next()
            java.lang.String r6 = "clearkey:Laurl"
            boolean r6 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r9, r6)
            r7 = 4
            if (r6 == 0) goto L_0x00b3
            int r6 = r9.next()
            if (r6 != r7) goto L_0x00b3
            java.lang.String r5 = r9.getText()
            goto L_0x0113
        L_0x00b3:
            java.lang.String r6 = "ms:laurl"
            boolean r6 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r9, r6)
            if (r6 == 0) goto L_0x00c2
            java.lang.String r5 = "licenseUrl"
            java.lang.String r5 = r9.getAttributeValue(r1, r5)
            goto L_0x0113
        L_0x00c2:
            if (r3 != 0) goto L_0x00e9
            java.lang.String r6 = "pssh"
            boolean r6 = androidx.media3.common.util.XmlPullParserUtil.isStartTagIgnorePrefix(r9, r6)
            if (r6 == 0) goto L_0x00e9
            int r6 = r9.next()
            if (r6 != r7) goto L_0x00e9
            java.lang.String r3 = r9.getText()
            byte[] r3 = android.util.Base64.decode(r3, r2)
            java.util.UUID r4 = androidx.media3.extractor.mp4.PsshAtomUtil.parseUuid(r3)
            if (r4 != 0) goto L_0x0113
            java.lang.String r3 = "MpdParser"
            java.lang.String r6 = "Skipping malformed cenc:pssh data"
            androidx.media3.common.util.Log.w(r3, r6)
            r3 = r1
            goto L_0x0113
        L_0x00e9:
            if (r3 != 0) goto L_0x0110
            java.util.UUID r6 = androidx.media3.common.C.PLAYREADY_UUID
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0110
            java.lang.String r6 = "mspr:pro"
            boolean r6 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r9, r6)
            if (r6 == 0) goto L_0x0110
            int r6 = r9.next()
            if (r6 != r7) goto L_0x0110
            java.util.UUID r3 = androidx.media3.common.C.PLAYREADY_UUID
            java.lang.String r6 = r9.getText()
            byte[] r6 = android.util.Base64.decode(r6, r2)
            byte[] r3 = androidx.media3.extractor.mp4.PsshAtomUtil.buildPsshAtom(r3, r6)
            goto L_0x0113
        L_0x0110:
            maybeSkipTag(r9)
        L_0x0113:
            java.lang.String r6 = "ContentProtection"
            boolean r6 = androidx.media3.common.util.XmlPullParserUtil.isEndTag(r9, r6)
            if (r6 == 0) goto L_0x009c
            if (r4 == 0) goto L_0x0125
            androidx.media3.common.DrmInitData$SchemeData r1 = new androidx.media3.common.DrmInitData$SchemeData
            java.lang.String r9 = "video/mp4"
            r1.<init>(r4, r5, r9, r3)
        L_0x0125:
            android.util.Pair r9 = android.util.Pair.create(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.parseContentProtection(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    /* access modifiers changed from: protected */
    public void parseAdaptationSetChild(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        maybeSkipTag(xmlPullParser);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v0, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v4, resolved type: androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v3, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v4, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v5, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v6, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v7, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v8, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v9, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v10, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r31v1 */
    /* JADX WARNING: type inference failed for: r31v2 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01f3 A[LOOP:0: B:1:0x006b->B:53:0x01f3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x019d A[EDGE_INSN: B:54:0x019d->B:45:0x019d ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.exoplayer.dash.manifest.DashManifestParser.RepresentationInfo parseRepresentation(org.xmlpull.v1.XmlPullParser r36, java.util.List<androidx.media3.exoplayer.dash.manifest.BaseUrl> r37, java.lang.String r38, java.lang.String r39, int r40, int r41, float r42, int r43, int r44, java.lang.String r45, java.util.List<androidx.media3.exoplayer.dash.manifest.Descriptor> r46, java.util.List<androidx.media3.exoplayer.dash.manifest.Descriptor> r47, java.util.List<androidx.media3.exoplayer.dash.manifest.Descriptor> r48, java.util.List<androidx.media3.exoplayer.dash.manifest.Descriptor> r49, androidx.media3.exoplayer.dash.manifest.SegmentBase r50, long r51, long r53, long r55, long r57, long r59, boolean r61) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r35 = this;
            r15 = r35
            r14 = r36
            java.lang.String r0 = "id"
            r1 = 0
            java.lang.String r16 = r14.getAttributeValue(r1, r0)
            java.lang.String r0 = "bandwidth"
            r2 = -1
            int r17 = parseInt(r14, r0, r2)
            java.lang.String r0 = "mimeType"
            r2 = r38
            java.lang.String r18 = parseString(r14, r0, r2)
            java.lang.String r0 = "codecs"
            r2 = r39
            java.lang.String r19 = parseString(r14, r0, r2)
            java.lang.String r0 = "width"
            r2 = r40
            int r20 = parseInt(r14, r0, r2)
            java.lang.String r0 = "height"
            r2 = r41
            int r21 = parseInt(r14, r0, r2)
            r0 = r42
            float r22 = parseFrameRate(r14, r0)
            java.lang.String r0 = "audioSamplingRate"
            r2 = r44
            int r23 = parseInt(r14, r0, r2)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r0 = r48
            r12.<init>(r0)
            java.util.ArrayList r9 = new java.util.ArrayList
            r10 = r49
            r9.<init>(r10)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r0 = 0
            r24 = r43
            r0 = r50
            r5 = r55
            r26 = r1
            r25 = 0
            r1 = r57
        L_0x006b:
            r36.next()
            java.lang.String r3 = "BaseURL"
            boolean r3 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r3 == 0) goto L_0x0091
            if (r25 != 0) goto L_0x007e
            long r5 = r15.parseAvailabilityTimeOffsetUs(r14, r5)
            r25 = 1
        L_0x007e:
            r8 = r37
            r3 = r61
            java.util.List r4 = r15.parseBaseUrl(r14, r8, r3)
            r7.addAll(r4)
        L_0x0089:
            r31 = r7
            r15 = r13
            r7 = r24
            r24 = r0
            goto L_0x00a7
        L_0x0091:
            r8 = r37
            r3 = r61
            java.lang.String r4 = "AudioChannelConfiguration"
            boolean r4 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r4)
            if (r4 == 0) goto L_0x00ab
            int r4 = r35.parseAudioChannelConfiguration(r36)
            r24 = r0
            r31 = r7
            r15 = r13
            r7 = r4
        L_0x00a7:
            r13 = r11
            r11 = r9
            goto L_0x0195
        L_0x00ab:
            java.lang.String r4 = "SegmentBase"
            boolean r4 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r4)
            if (r4 == 0) goto L_0x00ba
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase r0 = (androidx.media3.exoplayer.dash.manifest.SegmentBase.SingleSegmentBase) r0
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase r0 = r15.parseSegmentBase(r14, r0)
            goto L_0x0089
        L_0x00ba:
            java.lang.String r4 = "SegmentList"
            boolean r4 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r4)
            if (r4 == 0) goto L_0x00f6
            long r27 = r15.parseAvailabilityTimeOffsetUs(r14, r1)
            r2 = r0
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentList r2 = (androidx.media3.exoplayer.dash.manifest.SegmentBase.SegmentList) r2
            r0 = r35
            r1 = r36
            r3 = r51
            r29 = r5
            r5 = r53
            r31 = r7
            r7 = r29
            r32 = r9
            r9 = r27
            r33 = r11
            r34 = r12
            r11 = r59
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentList r0 = r0.parseSegmentList(r1, r2, r3, r5, r7, r9, r11)
            r15 = r13
        L_0x00e6:
            r7 = r24
            r1 = r27
        L_0x00ea:
            r5 = r29
            r11 = r32
            r13 = r33
            r12 = r34
        L_0x00f2:
            r24 = r0
            goto L_0x0195
        L_0x00f6:
            r29 = r5
            r31 = r7
            r32 = r9
            r33 = r11
            r34 = r12
            java.lang.String r3 = "SegmentTemplate"
            boolean r3 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r3 == 0) goto L_0x0125
            long r27 = r15.parseAvailabilityTimeOffsetUs(r14, r1)
            r2 = r0
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentTemplate r2 = (androidx.media3.exoplayer.dash.manifest.SegmentBase.SegmentTemplate) r2
            r0 = r35
            r1 = r36
            r3 = r49
            r4 = r51
            r6 = r53
            r8 = r29
            r10 = r27
            r15 = r13
            r12 = r59
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentTemplate r0 = r0.parseSegmentTemplate(r1, r2, r3, r4, r6, r8, r10, r12)
            goto L_0x00e6
        L_0x0125:
            r15 = r13
            java.lang.String r3 = "ContentProtection"
            boolean r3 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r3 == 0) goto L_0x014a
            android.util.Pair r3 = r35.parseContentProtection(r36)
            java.lang.Object r4 = r3.first
            if (r4 == 0) goto L_0x013c
            java.lang.Object r4 = r3.first
            r26 = r4
            java.lang.String r26 = (java.lang.String) r26
        L_0x013c:
            java.lang.Object r4 = r3.second
            if (r4 == 0) goto L_0x0147
            java.lang.Object r3 = r3.second
            androidx.media3.common.DrmInitData$SchemeData r3 = (androidx.media3.common.DrmInitData.SchemeData) r3
            r15.add(r3)
        L_0x0147:
            r7 = r24
            goto L_0x00ea
        L_0x014a:
            java.lang.String r3 = "InbandEventStream"
            boolean r4 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r4 == 0) goto L_0x0160
            androidx.media3.exoplayer.dash.manifest.Descriptor r3 = parseDescriptor(r14, r3)
            r13 = r33
            r13.add(r3)
            r11 = r32
            r12 = r34
            goto L_0x018f
        L_0x0160:
            r13 = r33
            java.lang.String r3 = "EssentialProperty"
            boolean r4 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r4 == 0) goto L_0x0176
            androidx.media3.exoplayer.dash.manifest.Descriptor r3 = parseDescriptor(r14, r3)
            r12 = r34
            r12.add(r3)
            r11 = r32
            goto L_0x018f
        L_0x0176:
            r12 = r34
            java.lang.String r3 = "SupplementalProperty"
            boolean r4 = androidx.media3.common.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r4 == 0) goto L_0x018a
            androidx.media3.exoplayer.dash.manifest.Descriptor r3 = parseDescriptor(r14, r3)
            r11 = r32
            r11.add(r3)
            goto L_0x018f
        L_0x018a:
            r11 = r32
            maybeSkipTag(r36)
        L_0x018f:
            r7 = r24
            r5 = r29
            goto L_0x00f2
        L_0x0195:
            java.lang.String r0 = "Representation"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isEndTag(r14, r0)
            if (r0 == 0) goto L_0x01f3
            r0 = r35
            r1 = r16
            r2 = r18
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r7
            r7 = r23
            r8 = r17
            r9 = r45
            r10 = r46
            r27 = r11
            r11 = r47
            r28 = r12
            r12 = r19
            r29 = r13
            r13 = r28
            r14 = r27
            androidx.media3.common.Format r0 = r0.buildFormat(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            if (r24 == 0) goto L_0x01c7
            goto L_0x01ce
        L_0x01c7:
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase r1 = new androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase
            r1.<init>()
            r24 = r1
        L_0x01ce:
            androidx.media3.exoplayer.dash.manifest.DashManifestParser$RepresentationInfo r1 = new androidx.media3.exoplayer.dash.manifest.DashManifestParser$RepresentationInfo
            boolean r2 = r31.isEmpty()
            if (r2 != 0) goto L_0x01d7
            goto L_0x01d9
        L_0x01d7:
            r31 = r37
        L_0x01d9:
            r2 = -1
            r36 = r1
            r37 = r0
            r38 = r31
            r39 = r24
            r40 = r26
            r41 = r15
            r42 = r29
            r43 = r28
            r44 = r27
            r45 = r2
            r36.<init>(r37, r38, r39, r40, r41, r42, r43, r44, r45)
            return r1
        L_0x01f3:
            r10 = r49
            r9 = r11
            r11 = r13
            r13 = r15
            r0 = r24
            r15 = r35
            r24 = r7
            r7 = r31
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.parseRepresentation(org.xmlpull.v1.XmlPullParser, java.util.List, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, androidx.media3.exoplayer.dash.manifest.SegmentBase, long, long, long, long, long, boolean):androidx.media3.exoplayer.dash.manifest.DashManifestParser$RepresentationInfo");
    }

    /* access modifiers changed from: protected */
    public Format buildFormat(String str, String str2, int i, int i2, float f, int i3, int i4, int i5, String str3, List<Descriptor> list, List<Descriptor> list2, String str4, List<Descriptor> list3, List<Descriptor> list4) {
        String str5 = str2;
        int i6 = i;
        int i7 = i2;
        List<Descriptor> list5 = list;
        List<Descriptor> list6 = list3;
        String str6 = str4;
        String sampleMimeType = getSampleMimeType(str2, str6);
        if ("audio/eac3".equals(sampleMimeType)) {
            sampleMimeType = parseEac3SupplementalProperties(list4);
            if ("audio/eac3-joc".equals(sampleMimeType)) {
                str6 = "ec+3";
            }
        }
        int parseSelectionFlagsFromRoleDescriptors = parseSelectionFlagsFromRoleDescriptors(list5);
        int parseRoleFlagsFromRoleDescriptors = parseRoleFlagsFromRoleDescriptors(list5) | parseRoleFlagsFromAccessibilityDescriptors(list2) | parseRoleFlagsFromProperties(list6) | parseRoleFlagsFromProperties(list4);
        Pair<Integer, Integer> parseTileCountFromProperties = parseTileCountFromProperties(list6);
        String str7 = str;
        Format.Builder language = new Format.Builder().setId(str).setContainerMimeType(str2).setSampleMimeType(sampleMimeType).setCodecs(str6).setPeakBitrate(i5).setSelectionFlags(parseSelectionFlagsFromRoleDescriptors).setRoleFlags(parseRoleFlagsFromRoleDescriptors).setLanguage(str3);
        int i8 = -1;
        Format.Builder tileCountVertical = language.setTileCountHorizontal(parseTileCountFromProperties != null ? ((Integer) parseTileCountFromProperties.first).intValue() : -1).setTileCountVertical(parseTileCountFromProperties != null ? ((Integer) parseTileCountFromProperties.second).intValue() : -1);
        if (MimeTypes.isVideo(sampleMimeType)) {
            tileCountVertical.setWidth(i).setHeight(i7).setFrameRate(f);
        } else if (MimeTypes.isAudio(sampleMimeType)) {
            tileCountVertical.setChannelCount(i3).setSampleRate(i4);
        } else if (MimeTypes.isText(sampleMimeType)) {
            if ("application/cea-608".equals(sampleMimeType)) {
                i8 = parseCea608AccessibilityChannel(list2);
            } else if ("application/cea-708".equals(sampleMimeType)) {
                i8 = parseCea708AccessibilityChannel(list2);
            }
            tileCountVertical.setAccessibilityChannel(i8);
        } else if (MimeTypes.isImage(sampleMimeType)) {
            tileCountVertical.setWidth(i).setHeight(i7);
        }
        return tileCountVertical.build();
    }

    /* access modifiers changed from: protected */
    public Representation buildRepresentation(RepresentationInfo representationInfo, String str, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
        Format.Builder buildUpon = representationInfo.format.buildUpon();
        if (str != null) {
            buildUpon.setLabel(str);
        }
        String str3 = representationInfo.drmSchemeType;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = representationInfo.drmSchemeDatas;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            fillInClearKeyInformation(arrayList3);
            filterRedundantIncompleteSchemeDatas(arrayList3);
            buildUpon.setDrmInitData(new DrmInitData(str2, (List<DrmInitData.SchemeData>) arrayList3));
        }
        ArrayList<Descriptor> arrayList4 = representationInfo.inbandEventStreams;
        arrayList4.addAll(arrayList2);
        return Representation.newInstance(representationInfo.revisionId, buildUpon.build(), representationInfo.baseUrls, representationInfo.segmentBase, arrayList4, representationInfo.essentialProperties, representationInfo.supplementalProperties, (String) null);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xmlPullParser, SegmentBase.SingleSegmentBase singleSegmentBase) throws XmlPullParserException, IOException {
        long j;
        long j2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SingleSegmentBase singleSegmentBase2 = singleSegmentBase;
        long parseLong = parseLong(xmlPullParser2, "timescale", singleSegmentBase2 != null ? singleSegmentBase2.timescale : 1);
        long j3 = 0;
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", singleSegmentBase2 != null ? singleSegmentBase2.presentationTimeOffset : 0);
        long j4 = singleSegmentBase2 != null ? singleSegmentBase2.indexStart : 0;
        if (singleSegmentBase2 != null) {
            j3 = singleSegmentBase2.indexLength;
        }
        RangedUri rangedUri = null;
        String attributeValue = xmlPullParser2.getAttributeValue((String) null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j2 = Long.parseLong(split[0]);
            j = (Long.parseLong(split[1]) - j2) + 1;
        } else {
            j = j3;
            j2 = j4;
        }
        if (singleSegmentBase2 != null) {
            rangedUri = singleSegmentBase2.initialization;
        }
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentBase"));
        return buildSingleSegmentBase(rangedUri, parseLong, parseLong2, j2, j);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4) {
        return new SegmentBase.SingleSegmentBase(rangedUri, j, j2, j3, j4);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentList parseSegmentList(XmlPullParser xmlPullParser, SegmentBase.SegmentList segmentList, long j, long j2, long j3, long j4, long j5) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentList segmentList2 = segmentList;
        long j6 = 1;
        long parseLong = parseLong(xmlPullParser2, "timescale", segmentList2 != null ? segmentList2.timescale : 1);
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", segmentList2 != null ? segmentList2.presentationTimeOffset : 0);
        long parseLong3 = parseLong(xmlPullParser2, "duration", segmentList2 != null ? segmentList2.duration : -9223372036854775807L);
        if (segmentList2 != null) {
            j6 = segmentList2.startNumber;
        }
        long parseLong4 = parseLong(xmlPullParser2, "startNumber", j6);
        long finalAvailabilityTimeOffset = getFinalAvailabilityTimeOffset(j3, j4);
        List<SegmentBase.SegmentTimelineElement> list = null;
        List list2 = null;
        RangedUri rangedUri = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTimeline")) {
                list = parseSegmentTimeline(xmlPullParser, parseLong, j2);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(parseSegmentUrl(xmlPullParser));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentList"));
        if (segmentList2 != null) {
            if (rangedUri == null) {
                rangedUri = segmentList2.initialization;
            }
            if (list == null) {
                list = segmentList2.segmentTimeline;
            }
            if (list2 == null) {
                list2 = segmentList2.mediaSegments;
            }
        }
        return buildSegmentList(rangedUri, parseLong, parseLong2, parseLong4, parseLong3, list, finalAvailabilityTimeOffset, list2, j5, j);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentList buildSegmentList(RangedUri rangedUri, long j, long j2, long j3, long j4, List<SegmentBase.SegmentTimelineElement> list, long j5, List<RangedUri> list2, long j6, long j7) {
        return new SegmentBase.SegmentList(rangedUri, j, j2, j3, j4, list, j5, list2, Util.msToUs(j6), Util.msToUs(j7));
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xmlPullParser, SegmentBase.SegmentTemplate segmentTemplate, List<Descriptor> list, long j, long j2, long j3, long j4, long j5) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentTemplate segmentTemplate2 = segmentTemplate;
        long j6 = 1;
        long parseLong = parseLong(xmlPullParser2, "timescale", segmentTemplate2 != null ? segmentTemplate2.timescale : 1);
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", segmentTemplate2 != null ? segmentTemplate2.presentationTimeOffset : 0);
        long parseLong3 = parseLong(xmlPullParser2, "duration", segmentTemplate2 != null ? segmentTemplate2.duration : -9223372036854775807L);
        if (segmentTemplate2 != null) {
            j6 = segmentTemplate2.startNumber;
        }
        long parseLong4 = parseLong(xmlPullParser2, "startNumber", j6);
        long parseLastSegmentNumberSupplementalProperty = parseLastSegmentNumberSupplementalProperty(list);
        long finalAvailabilityTimeOffset = getFinalAvailabilityTimeOffset(j3, j4);
        List<SegmentBase.SegmentTimelineElement> list2 = null;
        UrlTemplate parseUrlTemplate = parseUrlTemplate(xmlPullParser2, ShareConstants.WEB_DIALOG_PARAM_MEDIA, segmentTemplate2 != null ? segmentTemplate2.mediaTemplate : null);
        UrlTemplate parseUrlTemplate2 = parseUrlTemplate(xmlPullParser2, "initialization", segmentTemplate2 != null ? segmentTemplate2.initializationTemplate : null);
        RangedUri rangedUri = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTimeline")) {
                list2 = parseSegmentTimeline(xmlPullParser, parseLong, j2);
            } else {
                maybeSkipTag(xmlPullParser);
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentTemplate")) {
                break;
            }
        }
        if (segmentTemplate2 != null) {
            if (rangedUri == null) {
                rangedUri = segmentTemplate2.initialization;
            }
            if (list2 == null) {
                list2 = segmentTemplate2.segmentTimeline;
            }
        }
        return buildSegmentTemplate(rangedUri, parseLong, parseLong2, parseLong4, parseLastSegmentNumberSupplementalProperty, parseLong3, list2, finalAvailabilityTimeOffset, parseUrlTemplate2, parseUrlTemplate, j5, j);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri rangedUri, long j, long j2, long j3, long j4, long j5, List<SegmentBase.SegmentTimelineElement> list, long j6, UrlTemplate urlTemplate, UrlTemplate urlTemplate2, long j7, long j8) {
        return new SegmentBase.SegmentTemplate(rangedUri, j, j2, j3, j4, j5, list, j6, urlTemplate, urlTemplate2, Util.msToUs(j7), Util.msToUs(j8));
    }

    /* access modifiers changed from: protected */
    public EventStream parseEventStream(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        long j;
        ByteArrayOutputStream byteArrayOutputStream;
        ArrayList arrayList;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String parseString = parseString(xmlPullParser2, "schemeIdUri", "");
        String parseString2 = parseString(xmlPullParser2, "value", "");
        long parseLong = parseLong(xmlPullParser2, "timescale", 1);
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", 0);
        ArrayList arrayList2 = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(512);
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Event")) {
                byteArrayOutputStream = byteArrayOutputStream2;
                long j2 = parseLong2;
                j = parseLong2;
                arrayList = arrayList2;
                arrayList.add(parseEvent(xmlPullParser, parseString, parseString2, parseLong, j2, byteArrayOutputStream));
            } else {
                byteArrayOutputStream = byteArrayOutputStream2;
                j = parseLong2;
                arrayList = arrayList2;
                maybeSkipTag(xmlPullParser);
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "EventStream")) {
                break;
            }
            arrayList2 = arrayList;
            byteArrayOutputStream2 = byteArrayOutputStream;
            parseLong2 = j;
        }
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            Pair pair = (Pair) arrayList.get(i);
            jArr[i] = ((Long) pair.first).longValue();
            eventMessageArr[i] = (EventMessage) pair.second;
        }
        return buildEventStream(parseString, parseString2, parseLong, jArr, eventMessageArr);
    }

    /* access modifiers changed from: protected */
    public EventStream buildEventStream(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        return new EventStream(str, str2, j, jArr, eventMessageArr);
    }

    /* access modifiers changed from: protected */
    public Pair<Long, EventMessage> parseEvent(XmlPullParser xmlPullParser, String str, String str2, long j, long j2, ByteArrayOutputStream byteArrayOutputStream) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long parseLong = parseLong(xmlPullParser2, "id", 0);
        long parseLong2 = parseLong(xmlPullParser2, "duration", -9223372036854775807L);
        long parseLong3 = parseLong(xmlPullParser2, "presentationTime", 0);
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(parseLong2, 1000, j);
        long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(parseLong3 - j2, 1000000, j);
        String parseString = parseString(xmlPullParser2, "messageData", (String) null);
        byte[] parseEventObject = parseEventObject(xmlPullParser2, byteArrayOutputStream);
        Long valueOf = Long.valueOf(scaleLargeTimestamp2);
        if (parseString != null) {
            parseEventObject = Util.getUtf8Bytes(parseString);
        }
        return Pair.create(valueOf, buildEvent(str, str2, parseLong, scaleLargeTimestamp, parseEventObject));
    }

    /* access modifiers changed from: protected */
    public byte[] parseEventObject(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, Charsets.UTF_8.name());
        xmlPullParser.nextToken();
        while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument((String) null, false);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: protected */
    public EventMessage buildEvent(String str, String str2, long j, long j2, byte[] bArr) {
        return new EventMessage(str, str2, j2, j, bArr);
    }

    /* access modifiers changed from: protected */
    public List<SegmentBase.SegmentTimelineElement> parseSegmentTimeline(XmlPullParser xmlPullParser, long j, long j2) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        long j4 = -9223372036854775807L;
        boolean z = false;
        int i = 0;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, ExifInterface.LATITUDE_SOUTH)) {
                long parseLong = parseLong(xmlPullParser2, "t", -9223372036854775807L);
                if (z) {
                    j3 = addSegmentTimelineElementsToList(arrayList, j3, j4, i, parseLong);
                }
                if (parseLong == -9223372036854775807L) {
                    parseLong = j3;
                }
                j4 = parseLong(xmlPullParser2, "d", -9223372036854775807L);
                i = parseInt(xmlPullParser2, CampaignEx.JSON_KEY_AD_R, 0);
                j3 = parseLong;
                z = true;
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentTimeline"));
        if (z) {
            addSegmentTimelineElementsToList(arrayList, j3, j4, i, Util.scaleLargeTimestamp(j2, j, 1000));
        }
        return arrayList;
    }

    private long addSegmentTimelineElementsToList(List<SegmentBase.SegmentTimelineElement> list, long j, long j2, int i, long j3) {
        int ceilDivide = i >= 0 ? i + 1 : (int) Util.ceilDivide(j3 - j, j2);
        for (int i2 = 0; i2 < ceilDivide; i2++) {
            list.add(buildSegmentTimelineElement(j, j2));
            j += j2;
        }
        return j;
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long j, long j2) {
        return new SegmentBase.SegmentTimelineElement(j, j2);
    }

    /* access modifiers changed from: protected */
    public UrlTemplate parseUrlTemplate(XmlPullParser xmlPullParser, String str, UrlTemplate urlTemplate) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue != null ? UrlTemplate.compile(attributeValue) : urlTemplate;
    }

    /* access modifiers changed from: protected */
    public RangedUri parseInitialization(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "sourceURL", "range");
    }

    /* access modifiers changed from: protected */
    public RangedUri parseSegmentUrl(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, ShareConstants.WEB_DIALOG_PARAM_MEDIA, "mediaRange");
    }

    /* access modifiers changed from: protected */
    public RangedUri parseRangedUrl(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j2 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j = (Long.parseLong(split[1]) - j2) + 1;
                return buildRangedUri(attributeValue, j2, j);
            }
        } else {
            j2 = 0;
        }
        j = -1;
        return buildRangedUri(attributeValue, j2, j);
    }

    /* access modifiers changed from: protected */
    public RangedUri buildRangedUri(String str, long j, long j2) {
        return new RangedUri(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public ProgramInformation parseProgramInformation(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str = null;
        String parseString = parseString(xmlPullParser, "moreInformationURL", (String) null);
        String parseString2 = parseString(xmlPullParser, "lang", (String) null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, ExifInterface.TAG_COPYRIGHT)) {
                str3 = xmlPullParser.nextText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
            String str4 = str3;
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "ProgramInformation")) {
                return new ProgramInformation(str, str2, str4, parseString, parseString2);
            }
            str3 = str4;
        }
    }

    /* access modifiers changed from: protected */
    public String parseLabel(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return parseText(xmlPullParser, "Label");
    }

    /* access modifiers changed from: protected */
    public List<BaseUrl> parseBaseUrl(XmlPullParser xmlPullParser, List<BaseUrl> list, boolean z) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "dvb:priority");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : z ? 1 : Integer.MIN_VALUE;
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "dvb:weight");
        int parseInt2 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue((String) null, "serviceLocation");
        String parseText = parseText(xmlPullParser, "BaseURL");
        if (UriUtil.isAbsolute(parseText)) {
            if (attributeValue3 == null) {
                attributeValue3 = parseText;
            }
            return Lists.newArrayList((E[]) new BaseUrl[]{new BaseUrl(parseText, attributeValue3, parseInt, parseInt2)});
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            BaseUrl baseUrl = list.get(i);
            String resolve = UriUtil.resolve(baseUrl.url, parseText);
            String str = attributeValue3 == null ? resolve : attributeValue3;
            if (z) {
                parseInt = baseUrl.priority;
                parseInt2 = baseUrl.weight;
                str = baseUrl.serviceLocation;
            }
            arrayList.add(new BaseUrl(resolve, str, parseInt, parseInt2));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public long parseAvailabilityTimeOffsetUs(XmlPullParser xmlPullParser, long j) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseAudioChannelConfiguration(org.xmlpull.v1.XmlPullParser r4) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "schemeIdUri"
            r1 = 0
            java.lang.String r0 = parseString(r4, r0, r1)
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = -1
            switch(r1) {
                case -2128649360: goto L_0x005c;
                case -1352850286: goto L_0x0050;
                case -1138141449: goto L_0x0044;
                case -986633423: goto L_0x0038;
                case -79006963: goto L_0x002c;
                case 312179081: goto L_0x0020;
                case 2036691300: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            r0 = -1
            goto L_0x0067
        L_0x0014:
            java.lang.String r1 = "urn:dolby:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001e
            goto L_0x0012
        L_0x001e:
            r0 = 6
            goto L_0x0067
        L_0x0020:
            java.lang.String r1 = "tag:dts.com,2018:uhd:audio_channel_configuration"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002a
            goto L_0x0012
        L_0x002a:
            r0 = 5
            goto L_0x0067
        L_0x002c:
            java.lang.String r1 = "tag:dts.com,2014:dash:audio_channel_configuration:2012"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0036
            goto L_0x0012
        L_0x0036:
            r0 = 4
            goto L_0x0067
        L_0x0038:
            java.lang.String r1 = "urn:mpeg:mpegB:cicp:ChannelConfiguration"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0042
            goto L_0x0012
        L_0x0042:
            r0 = 3
            goto L_0x0067
        L_0x0044:
            java.lang.String r1 = "tag:dolby.com,2014:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004e
            goto L_0x0012
        L_0x004e:
            r0 = 2
            goto L_0x0067
        L_0x0050:
            java.lang.String r1 = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x005a
            goto L_0x0012
        L_0x005a:
            r0 = 1
            goto L_0x0067
        L_0x005c:
            java.lang.String r1 = "urn:dts:dash:audio_channel_configuration:2012"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0066
            goto L_0x0012
        L_0x0066:
            r0 = 0
        L_0x0067:
            switch(r0) {
                case 0: goto L_0x0082;
                case 1: goto L_0x007a;
                case 2: goto L_0x0075;
                case 3: goto L_0x0070;
                case 4: goto L_0x0082;
                case 5: goto L_0x006b;
                case 6: goto L_0x0075;
                default: goto L_0x006a;
            }
        L_0x006a:
            goto L_0x0086
        L_0x006b:
            int r2 = parseDtsxChannelConfiguration(r4)
            goto L_0x0086
        L_0x0070:
            int r2 = parseMpegChannelConfiguration(r4)
            goto L_0x0086
        L_0x0075:
            int r2 = parseDolbyChannelConfiguration(r4)
            goto L_0x0086
        L_0x007a:
            java.lang.String r0 = "value"
            int r2 = parseInt(r4, r0, r2)
            goto L_0x0086
        L_0x0082:
            int r2 = parseDtsChannelConfiguration(r4)
        L_0x0086:
            r4.next()
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.isEndTag(r4, r0)
            if (r0 == 0) goto L_0x0086
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.parseAudioChannelConfiguration(org.xmlpull.v1.XmlPullParser):int");
    }

    /* access modifiers changed from: protected */
    public int parseSelectionFlagsFromRoleDescriptors(List<Descriptor> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", descriptor.schemeIdUri)) {
                i |= parseSelectionFlagsFromDashRoleScheme(descriptor.value);
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int parseSelectionFlagsFromDashRoleScheme(String str) {
        if (str == null) {
            return 0;
        }
        str.hashCode();
        return (str.equals(MediaTrack.ROLE_FORCED_SUBTITLE) || str.equals("forced-subtitle")) ? 2 : 0;
    }

    /* access modifiers changed from: protected */
    public int parseRoleFlagsFromRoleDescriptors(List<Descriptor> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", descriptor.schemeIdUri)) {
                i |= parseRoleFlagsFromDashRoleScheme(descriptor.value);
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int parseRoleFlagsFromAccessibilityDescriptors(List<Descriptor> list) {
        int parseTvaAudioPurposeCsValue;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", descriptor.schemeIdUri)) {
                parseTvaAudioPurposeCsValue = parseRoleFlagsFromDashRoleScheme(descriptor.value);
            } else if (Ascii.equalsIgnoreCase("urn:tva:metadata:cs:AudioPurposeCS:2007", descriptor.schemeIdUri)) {
                parseTvaAudioPurposeCsValue = parseTvaAudioPurposeCsValue(descriptor.value);
            }
            i |= parseTvaAudioPurposeCsValue;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int parseRoleFlagsFromProperties(List<Descriptor> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (Ascii.equalsIgnoreCase("http://dashif.org/guidelines/trickmode", list.get(i2).schemeIdUri)) {
                i |= 16384;
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int parseRoleFlagsFromDashRoleScheme(String str) {
        if (str == null) {
            return 0;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals(MediaTrack.ROLE_SUBTITLE)) {
                    c = 0;
                    break;
                }
                break;
            case -1724546052:
                if (str.equals("description")) {
                    c = 1;
                    break;
                }
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    c = 2;
                    break;
                }
                break;
            case -1574842690:
                if (str.equals(MediaTrack.ROLE_FORCED_SUBTITLE)) {
                    c = 3;
                    break;
                }
                break;
            case -1408024454:
                if (str.equals(MediaTrack.ROLE_ALTERNATE)) {
                    c = 4;
                    break;
                }
                break;
            case -1396432756:
                if (str.equals("forced-subtitle")) {
                    c = 5;
                    break;
                }
                break;
            case 99825:
                if (str.equals(MediaTrack.ROLE_DUB)) {
                    c = 6;
                    break;
                }
                break;
            case 3343801:
                if (str.equals(MediaTrack.ROLE_MAIN)) {
                    c = 7;
                    break;
                }
                break;
            case 3530173:
                if (str.equals(MediaTrack.ROLE_SIGN)) {
                    c = 8;
                    break;
                }
                break;
            case 552573414:
                if (str.equals("caption")) {
                    c = 9;
                    break;
                }
                break;
            case 899152809:
                if (str.equals(MediaTrack.ROLE_COMMENTARY)) {
                    c = 10;
                    break;
                }
                break;
            case 1629013393:
                if (str.equals(MediaTrack.ROLE_EMERGENCY)) {
                    c = 11;
                    break;
                }
                break;
            case 1855372047:
                if (str.equals(MediaTrack.ROLE_SUPPLEMENTARY)) {
                    c = 12;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 3:
            case 5:
                return 128;
            case 1:
                return 512;
            case 2:
                return 2048;
            case 4:
                return 2;
            case 6:
                return 16;
            case 7:
                return 1;
            case 8:
                return 256;
            case 9:
                return 64;
            case 10:
                return 8;
            case 11:
                return 32;
            case 12:
                return 4;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: protected */
    public int parseTvaAudioPurposeCsValue(String str) {
        if (str == null) {
            return 0;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                    c = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 512;
            case 1:
                return 2048;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: protected */
    public String[] parseProfiles(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return strArr;
        }
        return attributeValue.split(",");
    }

    /* access modifiers changed from: protected */
    public Pair<Integer, Integer> parseTileCountFromProperties(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ((Ascii.equalsIgnoreCase("http://dashif.org/thumbnail_tile", descriptor.schemeIdUri) || Ascii.equalsIgnoreCase("http://dashif.org/guidelines/thumbnail_tile", descriptor.schemeIdUri)) && descriptor.value != null) {
                String[] split = Util.split(descriptor.value, "x");
                if (split.length != 2) {
                    continue;
                } else {
                    try {
                        return Pair.create(Integer.valueOf(Integer.parseInt(split[0])), Integer.valueOf(Integer.parseInt(split[1])));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        return null;
    }

    public static void maybeSkipTag(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
            int i = 1;
            while (i != 0) {
                xmlPullParser.next();
                if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
                    i++;
                } else if (XmlPullParserUtil.isEndTag(xmlPullParser)) {
                    i--;
                }
            }
        }
    }

    private static void filterRedundantIncompleteSchemeDatas(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                int i = 0;
                while (true) {
                    if (i >= arrayList.size()) {
                        break;
                    } else if (arrayList.get(i).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    private static void fillInClearKeyInformation(ArrayList<DrmInitData.SchemeData> arrayList) {
        String str;
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                str = null;
                break;
            }
            DrmInitData.SchemeData schemeData = arrayList.get(i);
            if (C.CLEARKEY_UUID.equals(schemeData.uuid) && schemeData.licenseServerUrl != null) {
                str = schemeData.licenseServerUrl;
                arrayList.remove(i);
                break;
            }
            i++;
        }
        if (str != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                DrmInitData.SchemeData schemeData2 = arrayList.get(i2);
                if (C.COMMON_PSSH_UUID.equals(schemeData2.uuid) && schemeData2.licenseServerUrl == null) {
                    arrayList.set(i2, new DrmInitData.SchemeData(C.CLEARKEY_UUID, str, schemeData2.mimeType, schemeData2.data));
                }
            }
        }
    }

    private static String getSampleMimeType(String str, String str2) {
        if (MimeTypes.isAudio(str)) {
            return MimeTypes.getAudioMediaMimeType(str2);
        }
        if (MimeTypes.isVideo(str)) {
            return MimeTypes.getVideoMediaMimeType(str2);
        }
        if (MimeTypes.isText(str) || MimeTypes.isImage(str)) {
            return str;
        }
        if (!"application/mp4".equals(str)) {
            return null;
        }
        String mediaMimeType = MimeTypes.getMediaMimeType(str2);
        return "text/vtt".equals(mediaMimeType) ? "application/x-mp4-vtt" : mediaMimeType;
    }

    private static String checkLanguageConsistency(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        Assertions.checkState(str.equals(str2));
        return str;
    }

    private static int checkContentTypeConsistency(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        Assertions.checkState(i == i2);
        return i;
    }

    protected static Descriptor parseDescriptor(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", "");
        String parseString2 = parseString(xmlPullParser, "value", (String) null);
        String parseString3 = parseString(xmlPullParser, "id", (String) null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return new Descriptor(parseString, parseString2, parseString3);
    }

    protected static int parseCea608AccessibilityChannel(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri) && descriptor.value != null) {
                Matcher matcher = CEA_608_ACCESSIBILITY_PATTERN.matcher(descriptor.value);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w(TAG, "Unable to parse CEA-608 channel number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static int parseCea708AccessibilityChannel(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri) && descriptor.value != null) {
                Matcher matcher = CEA_708_ACCESSIBILITY_PATTERN.matcher(descriptor.value);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w(TAG, "Unable to parse CEA-708 service block number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static String parseEac3SupplementalProperties(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            String str = descriptor.schemeIdUri;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(descriptor.value)) {
                return "audio/eac3-joc";
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(descriptor.value)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    protected static float parseFrameRate(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "frameRate");
        if (attributeValue == null) {
            return f;
        }
        Matcher matcher = FRAME_RATE_PATTERN.matcher(attributeValue);
        if (!matcher.matches()) {
            return f;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        String group = matcher.group(2);
        return !TextUtils.isEmpty(group) ? ((float) parseInt) / ((float) Integer.parseInt(group)) : (float) parseInt;
    }

    protected static long parseDuration(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j;
        }
        return Util.parseXsDuration(attributeValue);
    }

    protected static long parseDateTime(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j;
        }
        return Util.parseXsDateTime(attributeValue);
    }

    protected static String parseText(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return str2;
    }

    protected static int parseInt(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    protected static long parseLong(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    protected static float parseFloat(XmlPullParser xmlPullParser, String str, float f) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? f : Float.parseFloat(attributeValue);
    }

    protected static String parseString(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    protected static int parseMpegChannelConfiguration(XmlPullParser xmlPullParser) {
        int parseInt = parseInt(xmlPullParser, "value", -1);
        if (parseInt < 0) {
            return -1;
        }
        int[] iArr = MPEG_CHANNEL_CONFIGURATION_MAPPING;
        if (parseInt < iArr.length) {
            return iArr[parseInt];
        }
        return -1;
    }

    protected static int parseDtsChannelConfiguration(XmlPullParser xmlPullParser) {
        int parseInt = parseInt(xmlPullParser, "value", -1);
        if (parseInt <= 0 || parseInt >= 33) {
            return -1;
        }
        return parseInt;
    }

    protected static int parseDtsxChannelConfiguration(XmlPullParser xmlPullParser) {
        int bitCount;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "value");
        if (attributeValue == null || (bitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return bitCount;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static int parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser r4) {
        /*
            r0 = 0
            java.lang.String r1 = "value"
            java.lang.String r4 = r4.getAttributeValue(r0, r1)
            r0 = -1
            if (r4 != 0) goto L_0x000c
            return r0
        L_0x000c:
            java.lang.String r4 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r4)
            r4.hashCode()
            int r1 = r4.hashCode()
            r2 = 2
            r3 = 1
            switch(r1) {
                case 1596796: goto L_0x003f;
                case 2937391: goto L_0x0034;
                case 3094035: goto L_0x0029;
                case 3133436: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            r4 = -1
            goto L_0x0049
        L_0x001e:
            java.lang.String r1 = "fa01"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0027
            goto L_0x001c
        L_0x0027:
            r4 = 3
            goto L_0x0049
        L_0x0029:
            java.lang.String r1 = "f801"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0032
            goto L_0x001c
        L_0x0032:
            r4 = 2
            goto L_0x0049
        L_0x0034:
            java.lang.String r1 = "a000"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x003d
            goto L_0x001c
        L_0x003d:
            r4 = 1
            goto L_0x0049
        L_0x003f:
            java.lang.String r1 = "4000"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0048
            goto L_0x001c
        L_0x0048:
            r4 = 0
        L_0x0049:
            switch(r4) {
                case 0: goto L_0x0053;
                case 1: goto L_0x0052;
                case 2: goto L_0x0050;
                case 3: goto L_0x004d;
                default: goto L_0x004c;
            }
        L_0x004c:
            return r0
        L_0x004d:
            r4 = 8
            return r4
        L_0x0050:
            r4 = 6
            return r4
        L_0x0052:
            return r2
        L_0x0053:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser):int");
    }

    protected static long parseLastSegmentNumberSupplementalProperty(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if (Ascii.equalsIgnoreCase("http://dashif.org/guidelines/last-segment-number", descriptor.schemeIdUri)) {
                return Long.parseLong(descriptor.value);
            }
        }
        return -1;
    }

    private boolean isDvbProfileDeclared(String[] strArr) {
        for (String startsWith : strArr) {
            if (startsWith.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

    protected static final class RepresentationInfo {
        public final ImmutableList<BaseUrl> baseUrls;
        public final ArrayList<DrmInitData.SchemeData> drmSchemeDatas;
        public final String drmSchemeType;
        public final List<Descriptor> essentialProperties;
        public final Format format;
        public final ArrayList<Descriptor> inbandEventStreams;
        public final long revisionId;
        public final SegmentBase segmentBase;
        public final List<Descriptor> supplementalProperties;

        public RepresentationInfo(Format format2, List<BaseUrl> list, SegmentBase segmentBase2, String str, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2, List<Descriptor> list2, List<Descriptor> list3, long j) {
            this.format = format2;
            this.baseUrls = ImmutableList.copyOf(list);
            this.segmentBase = segmentBase2;
            this.drmSchemeType = str;
            this.drmSchemeDatas = arrayList;
            this.inbandEventStreams = arrayList2;
            this.essentialProperties = list2;
            this.supplementalProperties = list3;
            this.revisionId = j;
        }
    }
}
