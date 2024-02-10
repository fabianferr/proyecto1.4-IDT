package com.applovin.impl.sdk.utils;

import android.util.Xml;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class s {
    /* access modifiers changed from: private */
    public final u a;
    /* access modifiers changed from: private */
    public Stack<a> b;
    /* access modifiers changed from: private */
    public StringBuilder c;
    /* access modifiers changed from: private */
    public long d;
    /* access modifiers changed from: private */
    public a e;

    private static class a extends r {
        a(String str, Map<String, String> map, r rVar) {
            super(str, map, rVar);
        }

        /* access modifiers changed from: package-private */
        public void a(r rVar) {
            if (rVar != null) {
                this.c.add(rVar);
                return;
            }
            throw new IllegalArgumentException("None specified.");
        }

        /* access modifiers changed from: package-private */
        public void d(String str) {
            this.b = str;
        }
    }

    s(m mVar) {
        if (mVar != null) {
            this.a = mVar.A();
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    public static r a(String str, m mVar) throws SAXException {
        return new s(mVar).a(str);
    }

    /* access modifiers changed from: private */
    public Map<String, String> a(Attributes attributes) {
        if (attributes == null) {
            return Collections.emptyMap();
        }
        int length = attributes.getLength();
        Map<String, String> map = CollectionUtils.map(length);
        for (int i = 0; i < length; i++) {
            map.put(attributes.getQName(i), attributes.getValue(i));
        }
        return map;
    }

    public r a(String str) throws SAXException {
        if (str != null) {
            this.c = new StringBuilder();
            this.b = new Stack<>();
            this.e = null;
            Xml.parse(str, new ContentHandler() {
                public void characters(char[] cArr, int i, int i2) {
                    String trim = new String(Arrays.copyOfRange(cArr, i, i2)).trim();
                    if (StringUtils.isValidString(trim)) {
                        s.this.c.append(trim);
                    }
                }

                public void endDocument() {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - s.this.d;
                    if (u.a()) {
                        u a2 = s.this.a;
                        a2.b("XmlParser", "Finished parsing in " + seconds + " seconds");
                    }
                }

                public void endElement(String str, String str2, String str3) {
                    s sVar = s.this;
                    a unused = sVar.e = (a) sVar.b.pop();
                    s.this.e.d(s.this.c.toString().trim());
                    s.this.c.setLength(0);
                }

                public void endPrefixMapping(String str) {
                }

                public void ignorableWhitespace(char[] cArr, int i, int i2) {
                }

                public void processingInstruction(String str, String str2) {
                }

                public void setDocumentLocator(Locator locator) {
                }

                public void skippedEntity(String str) {
                }

                public void startDocument() {
                    if (u.a()) {
                        s.this.a.b("XmlParser", "Begin parsing...");
                    }
                    long unused = s.this.d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                }

                public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
                    try {
                        a aVar = !s.this.b.isEmpty() ? (a) s.this.b.peek() : null;
                        a aVar2 = new a(str2, s.this.a(attributes), aVar);
                        if (aVar != null) {
                            aVar.a(aVar2);
                        }
                        s.this.b.push(aVar2);
                    } catch (Exception e) {
                        if (u.a()) {
                            u a2 = s.this.a;
                            a2.b("XmlParser", "Unable to process element <" + str2 + ">", e);
                        }
                        throw new SAXException("Failed to start element", e);
                    }
                }

                public void startPrefixMapping(String str, String str2) {
                }
            });
            a aVar = this.e;
            if (aVar != null) {
                return aVar;
            }
            throw new SAXException("Unable to parse XML into node");
        }
        throw new IllegalArgumentException("Unable to parse. No XML specified.");
    }
}
