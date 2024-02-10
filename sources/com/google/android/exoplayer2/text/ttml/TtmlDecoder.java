package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import com.facebook.appevents.UserDataStore;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class TtmlDecoder extends SimpleSubtitleDecoder {
    private static final String ATTR_BEGIN = "begin";
    private static final String ATTR_DURATION = "dur";
    private static final String ATTR_END = "end";
    private static final String ATTR_IMAGE = "backgroundImage";
    private static final String ATTR_REGION = "region";
    private static final String ATTR_STYLE = "style";
    private static final Pattern CELL_RESOLUTION = Pattern.compile("^(\\d+) (\\d+)$");
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final CellResolution DEFAULT_CELL_RESOLUTION = new CellResolution(32, 15);
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);
    private static final int DEFAULT_FRAME_RATE = 30;
    private static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern PIXEL_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    static final Pattern SIGNED_PERCENTAGE = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    private static final String TAG = "TtmlDecoder";
    private static final String TTP = "http://www.w3.org/ns/ttml#parameter";
    private final XmlPullParserFactory xmlParserFactory;

    public TtmlDecoder() {
        super(TAG);
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.xmlParserFactory = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* access modifiers changed from: protected */
    public Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        FrameAndTickRate frameAndTickRate;
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new TtmlRegion(""));
            TtsExtent ttsExtent = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), (String) null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRate2 = DEFAULT_FRAME_AND_TICK_RATE;
            CellResolution cellResolution = DEFAULT_CELL_RESOLUTION;
            TtmlSubtitle ttmlSubtitle = null;
            int i2 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            frameAndTickRate2 = parseFrameAndTickRates(newPullParser);
                            cellResolution = parseCellResolution(newPullParser, DEFAULT_CELL_RESOLUTION);
                            ttsExtent = parseTtsExtent(newPullParser);
                        }
                        TtsExtent ttsExtent2 = ttsExtent;
                        FrameAndTickRate frameAndTickRate3 = frameAndTickRate2;
                        CellResolution cellResolution2 = cellResolution;
                        if (!isSupportedTag(name)) {
                            String valueOf = String.valueOf(newPullParser.getName());
                            Log.i(TAG, valueOf.length() != 0 ? "Ignoring unsupported tag: ".concat(valueOf) : new String("Ignoring unsupported tag: "));
                            i2++;
                            frameAndTickRate2 = frameAndTickRate3;
                        } else {
                            if ("head".equals(name)) {
                                frameAndTickRate = frameAndTickRate3;
                                parseHeader(newPullParser, hashMap, cellResolution2, ttsExtent2, hashMap2, hashMap3);
                            } else {
                                frameAndTickRate = frameAndTickRate3;
                                try {
                                    TtmlNode parseNode = parseNode(newPullParser, ttmlNode, hashMap2, frameAndTickRate);
                                    arrayDeque.push(parseNode);
                                    if (ttmlNode != null) {
                                        ttmlNode.addChild(parseNode);
                                    }
                                } catch (SubtitleDecoderException e) {
                                    Log.w(TAG, "Suppressing parser error", e);
                                    i2++;
                                }
                            }
                            frameAndTickRate2 = frameAndTickRate;
                        }
                        ttsExtent = ttsExtent2;
                        cellResolution = cellResolution2;
                    } else if (eventType == 4) {
                        ((TtmlNode) Assertions.checkNotNull(ttmlNode)).addChild(TtmlNode.buildTextNode(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            ttmlSubtitle = new TtmlSubtitle((TtmlNode) Assertions.checkNotNull((TtmlNode) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            if (ttmlSubtitle != null) {
                return ttmlSubtitle;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (XmlPullParserException e2) {
            throw new SubtitleDecoderException("Unable to decode source", e2);
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        }
    }

    private static FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        float f;
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue(TTP, "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] split = Util.split(attributeValue2, " ");
            if (split.length == 2) {
                f = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
            } else {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
        } else {
            f = 1.0f;
        }
        FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
        int i = frameAndTickRate.subFrameRate;
        String attributeValue3 = xmlPullParser.getAttributeValue(TTP, "subFrameRate");
        if (attributeValue3 != null) {
            i = Integer.parseInt(attributeValue3);
        }
        int i2 = frameAndTickRate.tickRate;
        String attributeValue4 = xmlPullParser.getAttributeValue(TTP, "tickRate");
        if (attributeValue4 != null) {
            i2 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(((float) parseInt) * f, i, i2);
    }

    private static CellResolution parseCellResolution(XmlPullParser xmlPullParser, CellResolution cellResolution) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "cellResolution");
        if (attributeValue == null) {
            return cellResolution;
        }
        Matcher matcher = CELL_RESOLUTION.matcher(attributeValue);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(attributeValue);
            Log.w(TAG, valueOf.length() != 0 ? "Ignoring malformed cell resolution: ".concat(valueOf) : new String("Ignoring malformed cell resolution: "));
            return cellResolution;
        }
        try {
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2)));
            if (parseInt != 0 && parseInt2 != 0) {
                return new CellResolution(parseInt, parseInt2);
            }
            StringBuilder sb = new StringBuilder(47);
            sb.append("Invalid cell resolution ");
            sb.append(parseInt);
            sb.append(" ");
            sb.append(parseInt2);
            throw new SubtitleDecoderException(sb.toString());
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(attributeValue);
            Log.w(TAG, valueOf2.length() != 0 ? "Ignoring malformed cell resolution: ".concat(valueOf2) : new String("Ignoring malformed cell resolution: "));
            return cellResolution;
        }
    }

    private static TtsExtent parseTtsExtent(XmlPullParser xmlPullParser) {
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "extent");
        if (attributeValue == null) {
            return null;
        }
        Matcher matcher = PIXEL_COORDINATES.matcher(attributeValue);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(attributeValue);
            Log.w(TAG, valueOf.length() != 0 ? "Ignoring non-pixel tts extent: ".concat(valueOf) : new String("Ignoring non-pixel tts extent: "));
            return null;
        }
        try {
            return new TtsExtent(Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2))));
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(attributeValue);
            Log.w(TAG, valueOf2.length() != 0 ? "Ignoring malformed tts extent: ".concat(valueOf2) : new String("Ignoring malformed tts extent: "));
            return null;
        }
    }

    private static Map<String, TtmlStyle> parseHeader(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, CellResolution cellResolution, TtsExtent ttsExtent, Map<String, TtmlRegion> map2, Map<String, String> map3) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, new TtmlStyle());
                if (attributeValue != null) {
                    for (String str : parseStyleIds(attributeValue)) {
                        parseStyleAttributes.chain(map.get(str));
                    }
                }
                String id = parseStyleAttributes.getId();
                if (id != null) {
                    map.put(id, parseStyleAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "region")) {
                TtmlRegion parseRegionAttributes = parseRegionAttributes(xmlPullParser, cellResolution, ttsExtent);
                if (parseRegionAttributes != null) {
                    map2.put(parseRegionAttributes.id, parseRegionAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "metadata")) {
                parseMetadata(xmlPullParser, map3);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "head"));
        return map;
    }

    private static void parseMetadata(XmlPullParser xmlPullParser, Map<String, String> map) throws IOException, XmlPullParserException {
        String attributeValue;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "image") && (attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id")) != null) {
                map.put(attributeValue, xmlPullParser.nextText());
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "metadata"));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01bf, code lost:
        if (r0.equals("tb") == false) goto L_0x01a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.text.ttml.TtmlRegion parseRegionAttributes(org.xmlpull.v1.XmlPullParser r17, com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution r18, com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent r19) {
        /*
            r0 = r17
            r1 = r19
            java.lang.String r2 = "id"
            java.lang.String r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r0, r2)
            r2 = 0
            if (r4 != 0) goto L_0x000e
            return r2
        L_0x000e:
            java.lang.String r3 = "origin"
            java.lang.String r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r0, r3)
            java.lang.String r5 = "TtmlDecoder"
            if (r3 == 0) goto L_0x0246
            java.util.regex.Pattern r6 = PERCENTAGE_COORDINATES
            java.util.regex.Matcher r7 = r6.matcher(r3)
            java.util.regex.Pattern r8 = PIXEL_COORDINATES
            java.util.regex.Matcher r9 = r8.matcher(r3)
            boolean r10 = r7.matches()
            java.lang.String r11 = "Ignoring region with malformed origin: "
            java.lang.String r12 = "Ignoring region with missing tts:extent: "
            r13 = 1120403456(0x42c80000, float:100.0)
            r14 = 2
            r15 = 1
            if (r10 == 0) goto L_0x006f
            java.lang.String r9 = r7.group(r15)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r9)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ NumberFormatException -> 0x0056 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0056 }
            float r9 = r9 / r13
            java.lang.String r7 = r7.group(r14)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r7)     // Catch:{ NumberFormatException -> 0x0056 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x0056 }
            float r7 = java.lang.Float.parseFloat(r7)     // Catch:{ NumberFormatException -> 0x0056 }
            float r7 = r7 / r13
            r16 = r9
            r9 = r7
            r7 = r16
            goto L_0x00b5
        L_0x0056:
            java.lang.String r0 = java.lang.String.valueOf(r3)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x0066
            java.lang.String r0 = r11.concat(r0)
            goto L_0x006b
        L_0x0066:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r11)
        L_0x006b:
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x006f:
            boolean r7 = r9.matches()
            if (r7 == 0) goto L_0x022c
            if (r1 != 0) goto L_0x008f
            java.lang.String r0 = java.lang.String.valueOf(r3)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x0086
            java.lang.String r0 = r12.concat(r0)
            goto L_0x008b
        L_0x0086:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r12)
        L_0x008b:
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x008f:
            java.lang.String r7 = r9.group(r15)     // Catch:{ NumberFormatException -> 0x0213 }
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r7)     // Catch:{ NumberFormatException -> 0x0213 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x0213 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x0213 }
            java.lang.String r9 = r9.group(r14)     // Catch:{ NumberFormatException -> 0x0213 }
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r9)     // Catch:{ NumberFormatException -> 0x0213 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ NumberFormatException -> 0x0213 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x0213 }
            float r7 = (float) r7     // Catch:{ NumberFormatException -> 0x0213 }
            int r10 = r1.width     // Catch:{ NumberFormatException -> 0x0213 }
            float r10 = (float) r10     // Catch:{ NumberFormatException -> 0x0213 }
            float r7 = r7 / r10
            float r9 = (float) r9     // Catch:{ NumberFormatException -> 0x0213 }
            int r10 = r1.height     // Catch:{ NumberFormatException -> 0x0213 }
            float r10 = (float) r10
            float r9 = r9 / r10
        L_0x00b5:
            java.lang.String r10 = "extent"
            java.lang.String r10 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r0, r10)
            if (r10 == 0) goto L_0x020d
            java.util.regex.Matcher r6 = r6.matcher(r10)
            java.util.regex.Matcher r8 = r8.matcher(r10)
            boolean r10 = r6.matches()
            java.lang.String r11 = "Ignoring region with malformed extent: "
            if (r10 == 0) goto L_0x0106
            java.lang.String r1 = r6.group(r15)     // Catch:{ NumberFormatException -> 0x00ed }
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r1)     // Catch:{ NumberFormatException -> 0x00ed }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x00ed }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x00ed }
            float r1 = r1 / r13
            java.lang.String r6 = r6.group(r14)     // Catch:{ NumberFormatException -> 0x00ed }
            java.lang.Object r6 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r6)     // Catch:{ NumberFormatException -> 0x00ed }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ NumberFormatException -> 0x00ed }
            float r2 = java.lang.Float.parseFloat(r6)     // Catch:{ NumberFormatException -> 0x00ed }
            float r2 = r2 / r13
            r10 = r2
            goto L_0x014e
        L_0x00ed:
            java.lang.String r0 = java.lang.String.valueOf(r3)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x00fd
            java.lang.String r0 = r11.concat(r0)
            goto L_0x0102
        L_0x00fd:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r11)
        L_0x0102:
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x0106:
            boolean r6 = r8.matches()
            if (r6 == 0) goto L_0x01f3
            if (r1 != 0) goto L_0x0126
            java.lang.String r0 = java.lang.String.valueOf(r3)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x011d
            java.lang.String r0 = r12.concat(r0)
            goto L_0x0122
        L_0x011d:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r12)
        L_0x0122:
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x0126:
            java.lang.String r6 = r8.group(r15)     // Catch:{ NumberFormatException -> 0x01da }
            java.lang.Object r6 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r6)     // Catch:{ NumberFormatException -> 0x01da }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ NumberFormatException -> 0x01da }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x01da }
            java.lang.String r8 = r8.group(r14)     // Catch:{ NumberFormatException -> 0x01da }
            java.lang.Object r8 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r8)     // Catch:{ NumberFormatException -> 0x01da }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NumberFormatException -> 0x01da }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x01da }
            float r6 = (float) r6     // Catch:{ NumberFormatException -> 0x01da }
            int r10 = r1.width     // Catch:{ NumberFormatException -> 0x01da }
            float r10 = (float) r10     // Catch:{ NumberFormatException -> 0x01da }
            float r6 = r6 / r10
            float r8 = (float) r8     // Catch:{ NumberFormatException -> 0x01da }
            int r1 = r1.height     // Catch:{ NumberFormatException -> 0x01da }
            float r1 = (float) r1
            float r8 = r8 / r1
            r1 = r6
            r10 = r8
        L_0x014e:
            java.lang.String r2 = "displayAlign"
            java.lang.String r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r0, r2)
            r3 = 0
            if (r2 == 0) goto L_0x017f
            java.lang.String r2 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r2)
            r2.hashCode()
            java.lang.String r5 = "center"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0175
            java.lang.String r5 = "after"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x016f
            goto L_0x017f
        L_0x016f:
            float r9 = r9 + r10
            r2 = r18
            r6 = r9
            r8 = 2
            goto L_0x0183
        L_0x0175:
            r2 = 1073741824(0x40000000, float:2.0)
            float r2 = r10 / r2
            float r9 = r9 + r2
            r2 = r18
            r6 = r9
            r8 = 1
            goto L_0x0183
        L_0x017f:
            r2 = r18
            r6 = r9
            r8 = 0
        L_0x0183:
            int r2 = r2.rows
            float r2 = (float) r2
            r5 = 1065353216(0x3f800000, float:1.0)
            float r12 = r5 / r2
            java.lang.String r2 = "writingMode"
            java.lang.String r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(r0, r2)
            if (r0 == 0) goto L_0x01ca
            java.lang.String r0 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r0)
            r0.hashCode()
            int r2 = r0.hashCode()
            r5 = -1
            switch(r2) {
                case 3694: goto L_0x01b9;
                case 3553396: goto L_0x01ae;
                case 3553576: goto L_0x01a3;
                default: goto L_0x01a1;
            }
        L_0x01a1:
            r3 = -1
            goto L_0x01c2
        L_0x01a3:
            java.lang.String r2 = "tbrl"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01ac
            goto L_0x01a1
        L_0x01ac:
            r3 = 2
            goto L_0x01c2
        L_0x01ae:
            java.lang.String r2 = "tblr"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01b7
            goto L_0x01a1
        L_0x01b7:
            r3 = 1
            goto L_0x01c2
        L_0x01b9:
            java.lang.String r2 = "tb"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01c2
            goto L_0x01a1
        L_0x01c2:
            switch(r3) {
                case 0: goto L_0x01c8;
                case 1: goto L_0x01c8;
                case 2: goto L_0x01c6;
                default: goto L_0x01c5;
            }
        L_0x01c5:
            goto L_0x01ca
        L_0x01c6:
            r13 = 1
            goto L_0x01ce
        L_0x01c8:
            r13 = 2
            goto L_0x01ce
        L_0x01ca:
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x01ce:
            com.google.android.exoplayer2.text.ttml.TtmlRegion r0 = new com.google.android.exoplayer2.text.ttml.TtmlRegion
            r2 = 0
            r11 = 1
            r3 = r0
            r5 = r7
            r7 = r2
            r9 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        L_0x01da:
            java.lang.String r0 = java.lang.String.valueOf(r3)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x01ea
            java.lang.String r0 = r11.concat(r0)
            goto L_0x01ef
        L_0x01ea:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r11)
        L_0x01ef:
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x01f3:
            java.lang.String r0 = java.lang.String.valueOf(r3)
            int r1 = r0.length()
            java.lang.String r3 = "Ignoring region with unsupported extent: "
            if (r1 == 0) goto L_0x0204
            java.lang.String r0 = r3.concat(r0)
            goto L_0x0209
        L_0x0204:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
        L_0x0209:
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x020d:
            java.lang.String r0 = "Ignoring region without an extent"
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x0213:
            java.lang.String r0 = java.lang.String.valueOf(r3)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x0223
            java.lang.String r0 = r11.concat(r0)
            goto L_0x0228
        L_0x0223:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r11)
        L_0x0228:
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x022c:
            java.lang.String r0 = java.lang.String.valueOf(r3)
            int r1 = r0.length()
            java.lang.String r3 = "Ignoring region with unsupported origin: "
            if (r1 == 0) goto L_0x023d
            java.lang.String r0 = r3.concat(r0)
            goto L_0x0242
        L_0x023d:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
        L_0x0242:
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        L_0x0246:
            java.lang.String r0 = "Ignoring region without an origin"
            com.google.android.exoplayer2.util.Log.w(r5, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseRegionAttributes(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlDecoder$CellResolution, com.google.android.exoplayer2.text.ttml.TtmlDecoder$TtsExtent):com.google.android.exoplayer2.text.ttml.TtmlRegion");
    }

    private static String[] parseStyleIds(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : Util.split(trim, "\\s+");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01f2, code lost:
        if (r3.equals("text") == false) goto L_0x01ea;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.text.ttml.TtmlStyle parseStyleAttributes(org.xmlpull.v1.XmlPullParser r12, com.google.android.exoplayer2.text.ttml.TtmlStyle r13) {
        /*
            int r0 = r12.getAttributeCount()
            r1 = 0
            r2 = 0
        L_0x0006:
            if (r2 >= r0) goto L_0x0308
            java.lang.String r3 = r12.getAttributeValue(r2)
            java.lang.String r4 = r12.getAttributeName(r2)
            r4.hashCode()
            int r5 = r4.hashCode()
            r6 = 5
            r7 = 4
            r8 = -1
            r9 = 3
            r10 = 2
            r11 = 1
            switch(r5) {
                case -1550943582: goto L_0x00cf;
                case -1224696685: goto L_0x00c3;
                case -1065511464: goto L_0x00b7;
                case -879295043: goto L_0x00ab;
                case -734428249: goto L_0x009f;
                case 3355: goto L_0x0094;
                case 3511770: goto L_0x0089;
                case 94842723: goto L_0x007e;
                case 109403361: goto L_0x0071;
                case 110138194: goto L_0x0064;
                case 365601008: goto L_0x0057;
                case 921125321: goto L_0x004a;
                case 1115953443: goto L_0x003d;
                case 1287124693: goto L_0x0030;
                case 1754920356: goto L_0x0023;
                default: goto L_0x0020;
            }
        L_0x0020:
            r4 = -1
            goto L_0x00da
        L_0x0023:
            java.lang.String r5 = "multiRowAlign"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x002c
            goto L_0x0020
        L_0x002c:
            r4 = 14
            goto L_0x00da
        L_0x0030:
            java.lang.String r5 = "backgroundColor"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0039
            goto L_0x0020
        L_0x0039:
            r4 = 13
            goto L_0x00da
        L_0x003d:
            java.lang.String r5 = "rubyPosition"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0046
            goto L_0x0020
        L_0x0046:
            r4 = 12
            goto L_0x00da
        L_0x004a:
            java.lang.String r5 = "textEmphasis"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0053
            goto L_0x0020
        L_0x0053:
            r4 = 11
            goto L_0x00da
        L_0x0057:
            java.lang.String r5 = "fontSize"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0060
            goto L_0x0020
        L_0x0060:
            r4 = 10
            goto L_0x00da
        L_0x0064:
            java.lang.String r5 = "textCombine"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x006d
            goto L_0x0020
        L_0x006d:
            r4 = 9
            goto L_0x00da
        L_0x0071:
            java.lang.String r5 = "shear"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x007a
            goto L_0x0020
        L_0x007a:
            r4 = 8
            goto L_0x00da
        L_0x007e:
            java.lang.String r5 = "color"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0087
            goto L_0x0020
        L_0x0087:
            r4 = 7
            goto L_0x00da
        L_0x0089:
            java.lang.String r5 = "ruby"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0092
            goto L_0x0020
        L_0x0092:
            r4 = 6
            goto L_0x00da
        L_0x0094:
            java.lang.String r5 = "id"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x009d
            goto L_0x0020
        L_0x009d:
            r4 = 5
            goto L_0x00da
        L_0x009f:
            java.lang.String r5 = "fontWeight"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00a9
            goto L_0x0020
        L_0x00a9:
            r4 = 4
            goto L_0x00da
        L_0x00ab:
            java.lang.String r5 = "textDecoration"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00b5
            goto L_0x0020
        L_0x00b5:
            r4 = 3
            goto L_0x00da
        L_0x00b7:
            java.lang.String r5 = "textAlign"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00c1
            goto L_0x0020
        L_0x00c1:
            r4 = 2
            goto L_0x00da
        L_0x00c3:
            java.lang.String r5 = "fontFamily"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00cd
            goto L_0x0020
        L_0x00cd:
            r4 = 1
            goto L_0x00da
        L_0x00cf:
            java.lang.String r5 = "fontStyle"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00d9
            goto L_0x0020
        L_0x00d9:
            r4 = 0
        L_0x00da:
            java.lang.String r5 = "TtmlDecoder"
            switch(r4) {
                case 0: goto L_0x02f6;
                case 1: goto L_0x02ed;
                case 2: goto L_0x02e0;
                case 3: goto L_0x027e;
                case 4: goto L_0x026e;
                case 5: goto L_0x0258;
                case 6: goto L_0x01dc;
                case 7: goto L_0x01b3;
                case 8: goto L_0x01a5;
                case 9: goto L_0x0178;
                case 10: goto L_0x0153;
                case 11: goto L_0x0145;
                case 12: goto L_0x0118;
                case 13: goto L_0x00ef;
                case 14: goto L_0x00e1;
                default: goto L_0x00df;
            }
        L_0x00df:
            goto L_0x0304
        L_0x00e1:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            android.text.Layout$Alignment r3 = parseAlignment(r3)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setMultiRowAlign(r3)
            goto L_0x0304
        L_0x00ef:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            int r4 = com.google.android.exoplayer2.util.ColorParser.parseTtmlColor(r3)     // Catch:{ IllegalArgumentException -> 0x00fc }
            r13.setBackgroundColor(r4)     // Catch:{ IllegalArgumentException -> 0x00fc }
            goto L_0x0304
        L_0x00fc:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            java.lang.String r6 = "Failed parsing background value: "
            if (r4 == 0) goto L_0x010e
            java.lang.String r3 = r6.concat(r3)
            goto L_0x0113
        L_0x010e:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r6)
        L_0x0113:
            com.google.android.exoplayer2.util.Log.w(r5, r3)
            goto L_0x0304
        L_0x0118:
            java.lang.String r3 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r3)
            r3.hashCode()
            java.lang.String r4 = "before"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x013b
            java.lang.String r4 = "after"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0131
            goto L_0x0304
        L_0x0131:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setRubyPosition(r10)
            goto L_0x0304
        L_0x013b:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setRubyPosition(r11)
            goto L_0x0304
        L_0x0145:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TextEmphasis r3 = com.google.android.exoplayer2.text.ttml.TextEmphasis.parse(r3)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setTextEmphasis(r3)
            goto L_0x0304
        L_0x0153:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)     // Catch:{ SubtitleDecoderException -> 0x015c }
            parseFontSize(r3, r13)     // Catch:{ SubtitleDecoderException -> 0x015c }
            goto L_0x0304
        L_0x015c:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            java.lang.String r6 = "Failed parsing fontSize value: "
            if (r4 == 0) goto L_0x016e
            java.lang.String r3 = r6.concat(r3)
            goto L_0x0173
        L_0x016e:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r6)
        L_0x0173:
            com.google.android.exoplayer2.util.Log.w(r5, r3)
            goto L_0x0304
        L_0x0178:
            java.lang.String r3 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r3)
            r3.hashCode()
            java.lang.String r4 = "all"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x019b
            java.lang.String r4 = "none"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0191
            goto L_0x0304
        L_0x0191:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setTextCombine(r1)
            goto L_0x0304
        L_0x019b:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setTextCombine(r11)
            goto L_0x0304
        L_0x01a5:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            float r3 = parseShear(r3)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setShearPercentage(r3)
            goto L_0x0304
        L_0x01b3:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            int r4 = com.google.android.exoplayer2.util.ColorParser.parseTtmlColor(r3)     // Catch:{ IllegalArgumentException -> 0x01c0 }
            r13.setFontColor(r4)     // Catch:{ IllegalArgumentException -> 0x01c0 }
            goto L_0x0304
        L_0x01c0:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            java.lang.String r6 = "Failed parsing color value: "
            if (r4 == 0) goto L_0x01d2
            java.lang.String r3 = r6.concat(r3)
            goto L_0x01d7
        L_0x01d2:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r6)
        L_0x01d7:
            com.google.android.exoplayer2.util.Log.w(r5, r3)
            goto L_0x0304
        L_0x01dc:
            java.lang.String r3 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r3)
            r3.hashCode()
            int r4 = r3.hashCode()
            switch(r4) {
                case -618561360: goto L_0x0221;
                case -410956671: goto L_0x0216;
                case -250518009: goto L_0x020b;
                case -136074796: goto L_0x0200;
                case 3016401: goto L_0x01f5;
                case 3556653: goto L_0x01ec;
                default: goto L_0x01ea;
            }
        L_0x01ea:
            r6 = -1
            goto L_0x022b
        L_0x01ec:
            java.lang.String r4 = "text"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x022b
            goto L_0x01ea
        L_0x01f5:
            java.lang.String r4 = "base"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01fe
            goto L_0x01ea
        L_0x01fe:
            r6 = 4
            goto L_0x022b
        L_0x0200:
            java.lang.String r4 = "textContainer"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0209
            goto L_0x01ea
        L_0x0209:
            r6 = 3
            goto L_0x022b
        L_0x020b:
            java.lang.String r4 = "delimiter"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0214
            goto L_0x01ea
        L_0x0214:
            r6 = 2
            goto L_0x022b
        L_0x0216:
            java.lang.String r4 = "container"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x021f
            goto L_0x01ea
        L_0x021f:
            r6 = 1
            goto L_0x022b
        L_0x0221:
            java.lang.String r4 = "baseContainer"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x022a
            goto L_0x01ea
        L_0x022a:
            r6 = 0
        L_0x022b:
            switch(r6) {
                case 0: goto L_0x024e;
                case 1: goto L_0x0244;
                case 2: goto L_0x023a;
                case 3: goto L_0x0230;
                case 4: goto L_0x024e;
                case 5: goto L_0x0230;
                default: goto L_0x022e;
            }
        L_0x022e:
            goto L_0x0304
        L_0x0230:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setRubyType(r9)
            goto L_0x0304
        L_0x023a:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setRubyType(r7)
            goto L_0x0304
        L_0x0244:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setRubyType(r11)
            goto L_0x0304
        L_0x024e:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setRubyType(r10)
            goto L_0x0304
        L_0x0258:
            java.lang.String r4 = "style"
            java.lang.String r5 = r12.getName()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0304
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setId(r3)
            goto L_0x0304
        L_0x026e:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            java.lang.String r4 = "bold"
            boolean r3 = r4.equalsIgnoreCase(r3)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setBold(r3)
            goto L_0x0304
        L_0x027e:
            java.lang.String r3 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r3)
            r3.hashCode()
            int r4 = r3.hashCode()
            switch(r4) {
                case -1461280213: goto L_0x02ae;
                case -1026963764: goto L_0x02a3;
                case 913457136: goto L_0x0298;
                case 1679736913: goto L_0x028d;
                default: goto L_0x028c;
            }
        L_0x028c:
            goto L_0x02b8
        L_0x028d:
            java.lang.String r4 = "linethrough"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0296
            goto L_0x02b8
        L_0x0296:
            r8 = 3
            goto L_0x02b8
        L_0x0298:
            java.lang.String r4 = "nolinethrough"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02a1
            goto L_0x02b8
        L_0x02a1:
            r8 = 2
            goto L_0x02b8
        L_0x02a3:
            java.lang.String r4 = "underline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02ac
            goto L_0x02b8
        L_0x02ac:
            r8 = 1
            goto L_0x02b8
        L_0x02ae:
            java.lang.String r4 = "nounderline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x02b7
            goto L_0x02b8
        L_0x02b7:
            r8 = 0
        L_0x02b8:
            switch(r8) {
                case 0: goto L_0x02d7;
                case 1: goto L_0x02ce;
                case 2: goto L_0x02c5;
                case 3: goto L_0x02bc;
                default: goto L_0x02bb;
            }
        L_0x02bb:
            goto L_0x0304
        L_0x02bc:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setLinethrough(r11)
            goto L_0x0304
        L_0x02c5:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setLinethrough(r1)
            goto L_0x0304
        L_0x02ce:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setUnderline(r11)
            goto L_0x0304
        L_0x02d7:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setUnderline(r1)
            goto L_0x0304
        L_0x02e0:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            android.text.Layout$Alignment r3 = parseAlignment(r3)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setTextAlign(r3)
            goto L_0x0304
        L_0x02ed:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setFontFamily(r3)
            goto L_0x0304
        L_0x02f6:
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = createIfNull(r13)
            java.lang.String r4 = "italic"
            boolean r3 = r4.equalsIgnoreCase(r3)
            com.google.android.exoplayer2.text.ttml.TtmlStyle r13 = r13.setItalic(r3)
        L_0x0304:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x0308:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseStyleAttributes(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlStyle):com.google.android.exoplayer2.text.ttml.TtmlStyle");
    }

    private static TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    private static Layout.Alignment parseAlignment(String str) {
        String lowerCase = Ascii.toLowerCase(str);
        lowerCase.hashCode();
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case -1364013995:
                if (lowerCase.equals("center")) {
                    c = 0;
                    break;
                }
                break;
            case 100571:
                if (lowerCase.equals("end")) {
                    c = 1;
                    break;
                }
                break;
            case 3317767:
                if (lowerCase.equals("left")) {
                    c = 2;
                    break;
                }
                break;
            case 108511772:
                if (lowerCase.equals("right")) {
                    c = 3;
                    break;
                }
                break;
            case 109757538:
                if (lowerCase.equals("start")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Layout.Alignment.ALIGN_CENTER;
            case 1:
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 2:
            case 4:
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.text.ttml.TtmlNode parseNode(org.xmlpull.v1.XmlPullParser r20, com.google.android.exoplayer2.text.ttml.TtmlNode r21, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> r22, com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate r23) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
            r0 = r20
            r9 = r21
            r1 = r23
            int r2 = r20.getAttributeCount()
            r3 = 0
            com.google.android.exoplayer2.text.ttml.TtmlStyle r5 = parseStyleAttributes(r0, r3)
            java.lang.String r4 = ""
            r10 = r3
            r12 = r10
            r11 = r4
            r3 = 0
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0024:
            if (r3 >= r2) goto L_0x00b4
            java.lang.String r4 = r0.getAttributeName(r3)
            java.lang.String r8 = r0.getAttributeValue(r3)
            r4.hashCode()
            int r19 = r4.hashCode()
            r6 = 1
            switch(r19) {
                case -934795532: goto L_0x0072;
                case 99841: goto L_0x0067;
                case 100571: goto L_0x005c;
                case 93616297: goto L_0x0051;
                case 109780401: goto L_0x0046;
                case 1292595405: goto L_0x003b;
                default: goto L_0x0039;
            }
        L_0x0039:
            r7 = -1
            goto L_0x007c
        L_0x003b:
            java.lang.String r7 = "backgroundImage"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0044
            goto L_0x0039
        L_0x0044:
            r7 = 5
            goto L_0x007c
        L_0x0046:
            java.lang.String r7 = "style"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x004f
            goto L_0x0039
        L_0x004f:
            r7 = 4
            goto L_0x007c
        L_0x0051:
            java.lang.String r7 = "begin"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x005a
            goto L_0x0039
        L_0x005a:
            r7 = 3
            goto L_0x007c
        L_0x005c:
            java.lang.String r7 = "end"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0065
            goto L_0x0039
        L_0x0065:
            r7 = 2
            goto L_0x007c
        L_0x0067:
            java.lang.String r7 = "dur"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x0070
            goto L_0x0039
        L_0x0070:
            r7 = 1
            goto L_0x007c
        L_0x0072:
            java.lang.String r7 = "region"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x007b
            goto L_0x0039
        L_0x007b:
            r7 = 0
        L_0x007c:
            switch(r7) {
                case 0: goto L_0x00a7;
                case 1: goto L_0x00a2;
                case 2: goto L_0x009d;
                case 3: goto L_0x0096;
                case 4: goto L_0x008d;
                case 5: goto L_0x0080;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x009a
        L_0x0080:
            java.lang.String r4 = "#"
            boolean r4 = r8.startsWith(r4)
            if (r4 == 0) goto L_0x009a
            java.lang.String r12 = r8.substring(r6)
            goto L_0x009a
        L_0x008d:
            java.lang.String[] r4 = parseStyleIds(r8)
            int r6 = r4.length
            if (r6 <= 0) goto L_0x009a
            r10 = r4
            goto L_0x009a
        L_0x0096:
            long r13 = parseTimeExpression(r8, r1)
        L_0x009a:
            r4 = r22
            goto L_0x00b0
        L_0x009d:
            long r15 = parseTimeExpression(r8, r1)
            goto L_0x009a
        L_0x00a2:
            long r17 = parseTimeExpression(r8, r1)
            goto L_0x009a
        L_0x00a7:
            r4 = r22
            boolean r6 = r4.containsKey(r8)
            if (r6 == 0) goto L_0x00b0
            r11 = r8
        L_0x00b0:
            int r3 = r3 + 1
            goto L_0x0024
        L_0x00b4:
            if (r9 == 0) goto L_0x00d0
            long r1 = r9.startTimeUs
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00d5
            int r1 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00c8
            long r1 = r9.startTimeUs
            long r13 = r13 + r1
        L_0x00c8:
            int r1 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00d5
            long r1 = r9.startTimeUs
            long r15 = r15 + r1
            goto L_0x00d5
        L_0x00d0:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x00d5:
            r1 = r13
            int r6 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x00ee
            int r6 = (r17 > r3 ? 1 : (r17 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00e3
            long r17 = r1 + r17
            r3 = r17
            goto L_0x00ef
        L_0x00e3:
            if (r9 == 0) goto L_0x00ee
            long r6 = r9.endTimeUs
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 == 0) goto L_0x00ee
            long r3 = r9.endTimeUs
            goto L_0x00ef
        L_0x00ee:
            r3 = r15
        L_0x00ef:
            java.lang.String r0 = r20.getName()
            r6 = r10
            r7 = r11
            r8 = r12
            r9 = r21
            com.google.android.exoplayer2.text.ttml.TtmlNode r0 = com.google.android.exoplayer2.text.ttml.TtmlNode.buildNode(r0, r1, r3, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseNode(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode, java.util.Map, com.google.android.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate):com.google.android.exoplayer2.text.ttml.TtmlNode");
    }

    private static boolean isSupportedTag(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    private static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String[] split = Util.split(str, "\\s+");
        if (split.length == 1) {
            matcher = FONT_SIZE.matcher(str);
        } else if (split.length == 2) {
            matcher = FONT_SIZE.matcher(split[1]);
            Log.w(TAG, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            int length = split.length;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Invalid number of entries for fontSize: ");
            sb.append(length);
            sb.append(".");
            throw new SubtitleDecoderException(sb.toString());
        }
        if (matcher.matches()) {
            String str2 = (String) Assertions.checkNotNull(matcher.group(3));
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case 37:
                    if (str2.equals("%")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (str2.equals(UserDataStore.EMAIL)) {
                        c = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (str2.equals("px")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    ttmlStyle.setFontSizeUnit(3);
                    break;
                case 1:
                    ttmlStyle.setFontSizeUnit(2);
                    break;
                case 2:
                    ttmlStyle.setFontSizeUnit(1);
                    break;
                default:
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 30);
                    sb2.append("Invalid unit for fontSize: '");
                    sb2.append(str2);
                    sb2.append("'.");
                    throw new SubtitleDecoderException(sb2.toString());
            }
            ttmlStyle.setFontSize(Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1))));
            return;
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 36);
        sb3.append("Invalid expression for fontSize: '");
        sb3.append(str);
        sb3.append("'.");
        throw new SubtitleDecoderException(sb3.toString());
    }

    private static float parseShear(String str) {
        Matcher matcher = SIGNED_PERCENTAGE.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            Log.w(TAG, valueOf.length() != 0 ? "Invalid value for shear: ".concat(valueOf) : new String("Invalid value for shear: "));
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1)))));
        } catch (NumberFormatException e) {
            String valueOf2 = String.valueOf(str);
            Log.w(TAG, valueOf2.length() != 0 ? "Failed to parse shear: ".concat(valueOf2) : new String("Failed to parse shear: "), e);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d1, code lost:
        if (r13.equals("ms") == false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0108, code lost:
        r8 = r8 / r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0119, code lost:
        r8 = r8 * r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long parseTimeExpression(java.lang.String r13, com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate r14) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
            java.util.regex.Pattern r0 = CLOCK_TIME
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L_0x009a
            java.lang.String r13 = r0.group(r7)
            java.lang.Object r13 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r7 = java.lang.Long.parseLong(r13)
            r9 = 3600(0xe10, double:1.7786E-320)
            long r7 = r7 * r9
            double r7 = (double) r7
            java.lang.String r13 = r0.group(r6)
            java.lang.Object r13 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r9 = java.lang.Long.parseLong(r13)
            r11 = 60
            long r9 = r9 * r11
            double r9 = (double) r9
            java.lang.Double.isNaN(r7)
            java.lang.Double.isNaN(r9)
            double r7 = r7 + r9
            java.lang.String r13 = r0.group(r5)
            java.lang.Object r13 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r5 = java.lang.Long.parseLong(r13)
            double r5 = (double) r5
            java.lang.Double.isNaN(r5)
            double r7 = r7 + r5
            java.lang.String r13 = r0.group(r4)
            r4 = 0
            if (r13 == 0) goto L_0x0062
            double r9 = java.lang.Double.parseDouble(r13)
            goto L_0x0063
        L_0x0062:
            r9 = r4
        L_0x0063:
            double r7 = r7 + r9
            r13 = 5
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x0075
            long r9 = java.lang.Long.parseLong(r13)
            float r13 = (float) r9
            float r1 = r14.effectiveFrameRate
            float r13 = r13 / r1
            double r9 = (double) r13
            goto L_0x0076
        L_0x0075:
            r9 = r4
        L_0x0076:
            double r7 = r7 + r9
            r13 = 6
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x0095
            long r0 = java.lang.Long.parseLong(r13)
            double r0 = (double) r0
            int r13 = r14.subFrameRate
            double r4 = (double) r13
            java.lang.Double.isNaN(r0)
            java.lang.Double.isNaN(r4)
            double r0 = r0 / r4
            float r13 = r14.effectiveFrameRate
            double r13 = (double) r13
            java.lang.Double.isNaN(r13)
            double r4 = r0 / r13
        L_0x0095:
            double r7 = r7 + r4
            double r7 = r7 * r2
            long r13 = (long) r7
            return r13
        L_0x009a:
            java.util.regex.Pattern r0 = OFFSET_TIME
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            if (r1 == 0) goto L_0x0127
            java.lang.String r13 = r0.group(r7)
            java.lang.Object r13 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            double r8 = java.lang.Double.parseDouble(r13)
            java.lang.String r13 = r0.group(r6)
            java.lang.Object r13 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r13)
            java.lang.String r13 = (java.lang.String) r13
            r13.hashCode()
            int r0 = r13.hashCode()
            r1 = -1
            switch(r0) {
                case 102: goto L_0x00f5;
                case 104: goto L_0x00ea;
                case 109: goto L_0x00df;
                case 116: goto L_0x00d4;
                case 3494: goto L_0x00cb;
                default: goto L_0x00c9;
            }
        L_0x00c9:
            r4 = -1
            goto L_0x00ff
        L_0x00cb:
            java.lang.String r0 = "ms"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00ff
            goto L_0x00c9
        L_0x00d4:
            java.lang.String r0 = "t"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00dd
            goto L_0x00c9
        L_0x00dd:
            r4 = 3
            goto L_0x00ff
        L_0x00df:
            java.lang.String r0 = "m"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00e8
            goto L_0x00c9
        L_0x00e8:
            r4 = 2
            goto L_0x00ff
        L_0x00ea:
            java.lang.String r0 = "h"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00f3
            goto L_0x00c9
        L_0x00f3:
            r4 = 1
            goto L_0x00ff
        L_0x00f5:
            java.lang.String r0 = "f"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00fe
            goto L_0x00c9
        L_0x00fe:
            r4 = 0
        L_0x00ff:
            switch(r4) {
                case 0: goto L_0x011c;
                case 1: goto L_0x0114;
                case 2: goto L_0x0111;
                case 3: goto L_0x010a;
                case 4: goto L_0x0103;
                default: goto L_0x0102;
            }
        L_0x0102:
            goto L_0x0123
        L_0x0103:
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
        L_0x0108:
            double r8 = r8 / r13
            goto L_0x0123
        L_0x010a:
            int r13 = r14.tickRate
            double r13 = (double) r13
            java.lang.Double.isNaN(r13)
            goto L_0x0108
        L_0x0111:
            r13 = 4633641066610819072(0x404e000000000000, double:60.0)
            goto L_0x0119
        L_0x0114:
            r13 = 4660134898793709568(0x40ac200000000000, double:3600.0)
        L_0x0119:
            double r8 = r8 * r13
            goto L_0x0123
        L_0x011c:
            float r13 = r14.effectiveFrameRate
            double r13 = (double) r13
            java.lang.Double.isNaN(r13)
            goto L_0x0108
        L_0x0123:
            double r8 = r8 * r2
            long r13 = (long) r8
            return r13
        L_0x0127:
            com.google.android.exoplayer2.text.SubtitleDecoderException r14 = new com.google.android.exoplayer2.text.SubtitleDecoderException
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r0 = r13.length()
            java.lang.String r1 = "Malformed time expression: "
            if (r0 == 0) goto L_0x013a
            java.lang.String r13 = r1.concat(r13)
            goto L_0x013f
        L_0x013a:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r1)
        L_0x013f:
            r14.<init>((java.lang.String) r13)
            goto L_0x0144
        L_0x0143:
            throw r14
        L_0x0144:
            goto L_0x0143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseTimeExpression(java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate):long");
    }

    private static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        FrameAndTickRate(float f, int i, int i2) {
            this.effectiveFrameRate = f;
            this.subFrameRate = i;
            this.tickRate = i2;
        }
    }

    private static final class CellResolution {
        final int columns;
        final int rows;

        CellResolution(int i, int i2) {
            this.columns = i;
            this.rows = i2;
        }
    }

    private static final class TtsExtent {
        final int height;
        final int width;

        TtsExtent(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }
}
