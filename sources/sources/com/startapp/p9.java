package com.startapp;

import android.text.TextUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* compiled from: Sta */
public class p9 {
    public final Node a;
    public final boolean b = true;

    public p9(Node node) {
        this.a = node;
    }

    public final List<p9> a(String str, String str2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) cb.a(this.a, str, str2, list)).iterator();
        while (it.hasNext()) {
            arrayList.add(new p9((Node) it.next()));
        }
        return arrayList;
    }

    public final p9 b(String str, String str2, List<String> list) {
        ArrayList arrayList = (ArrayList) cb.a(this.a, str, str2, (List<String>) null);
        Node node = arrayList.isEmpty() ? null : (Node) arrayList.get(0);
        if (node != null) {
            return new p9(node);
        }
        return null;
    }

    public final List<String> c(String str) {
        List<p9> a2 = a(str, (String) null, (List<String>) null);
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) a2).iterator();
        while (it.hasNext()) {
            String d = ((p9) it.next()).d();
            if (!TextUtils.isEmpty(d)) {
                arrayList.add(d);
            }
        }
        return arrayList;
    }

    public final String d() {
        Node node = this.a;
        if (node.getFirstChild() == null || node.getFirstChild().getNodeValue() == null) {
            return null;
        }
        return node.getFirstChild().getNodeValue().trim();
    }

    public List<String> e(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) d(str)).iterator();
        while (it.hasNext()) {
            String d = ((p9) it.next()).d();
            if (!TextUtils.isEmpty(d)) {
                arrayList.add(d);
            }
        }
        return arrayList;
    }

    public final String f(String str) {
        p9 b2 = b(str, (String) null, (List<String>) null);
        if (b2 == null) {
            return null;
        }
        return b2.d();
    }

    public p9(String str) throws ParserConfigurationException, SAXException, IOException {
        String replaceFirst = str.replaceFirst("<\\?.*\\?>", "");
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setCoalescing(true);
        newInstance.setExpandEntityReferences(false);
        this.a = newInstance.newDocumentBuilder().parse(new InputSource(new StringReader(replaceFirst))).getFirstChild();
    }

    public final List<p9> d(String str) {
        return a("Tracking", "TrackingEvents", "event", Collections.singletonList(str));
    }

    public final Integer b(String str) {
        try {
            String a2 = a(str);
            if (a2 != null) {
                return Integer.valueOf(Integer.parseInt(a2));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public final List<p9> a(String str, String str2, String str3, List<String> list) {
        ArrayList arrayList = new ArrayList();
        p9 b2 = b(str2, (String) null, (List<String>) null);
        if (b2 == null) {
            return arrayList;
        }
        return b2.a(str, str3, list);
    }

    public final List<String> b(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) a(str, str2, (String) null, (List<String>) null)).iterator();
        while (it.hasNext()) {
            String d = ((p9) it.next()).d();
            if (!TextUtils.isEmpty(d)) {
                arrayList.add(d);
            }
        }
        return arrayList;
    }

    public List<p9> c() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) a("Creative", "Creatives", (String) null, (List<String>) null)).iterator();
        while (it.hasNext()) {
            p9 b2 = ((p9) it.next()).b("Linear", (String) null, (List<String>) null);
            if (b2 != null) {
                arrayList.add(b2);
            }
        }
        return arrayList;
    }

    public final String a(String str) {
        Node namedItem = this.a.getAttributes().getNamedItem(str);
        if (namedItem != null) {
            return namedItem.getNodeValue();
        }
        return null;
    }

    public List<String> b() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) d("creativeView")).iterator();
        while (it.hasNext()) {
            String d = ((p9) it.next()).d();
            if (!TextUtils.isEmpty(d)) {
                arrayList.add(d);
            }
        }
        return arrayList;
    }

    public final String a(String str, String str2) {
        p9 b2;
        p9 b3 = b(str2, (String) null, (List<String>) null);
        if (b3 == null || (b2 = b3.b(str, (String) null, (List<String>) null)) == null) {
            return null;
        }
        return b2.d();
    }

    public List<p9> a() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) a("Creative", "Creatives", (String) null, (List<String>) null)).iterator();
        while (it.hasNext()) {
            arrayList.addAll(((p9) it.next()).a("Companion", "CompanionAds", (String) null, (List<String>) null));
        }
        return arrayList;
    }
}
