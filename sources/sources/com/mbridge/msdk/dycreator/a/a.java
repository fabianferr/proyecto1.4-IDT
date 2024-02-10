package com.mbridge.msdk.dycreator.a;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: MBLayoutInflate */
public final class a {
    private static final Class[] f = {Context.class, AttributeSet.class};
    private static final HashMap<String, Constructor> g = new HashMap<>();
    private static String j = "com.mbridge.msdk.dycreator.baseview.MB";
    protected final Context a;
    private final boolean b = true;
    private C0131a c;
    private b d;
    private final Object[] e = new Object[2];
    private HashMap<String, Boolean> h;
    private long i;

    /* renamed from: com.mbridge.msdk.dycreator.a.a$a  reason: collision with other inner class name */
    /* compiled from: MBLayoutInflate */
    public interface C0131a {
        View a(String str, Context context, AttributeSet attributeSet);
    }

    /* compiled from: MBLayoutInflate */
    public interface b {
        boolean a(Class cls);
    }

    public a(Context context) {
        this.a = context;
    }

    private XmlPullParser a(String str) {
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new FileInputStream(str), "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return newPullParser;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: android.view.ViewGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bc, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r9 = new android.view.InflateException(r7.getPositionDescription() + ": " + r8.getMessage());
        r9.initCause(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e1, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e3, code lost:
        r8 = new android.view.InflateException(r7.getMessage());
        r8.initCause(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ef, code lost:
        throw r8;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b A[Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a1 A[SYNTHETIC, Splitter:B:34:0x00a1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View a(org.xmlpull.v1.XmlPullParser r7, android.view.ViewGroup r8, boolean r9) {
        /*
            r6 = this;
            java.lang.Object[] r0 = r6.e
            monitor-enter(r0)
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r7)     // Catch:{ all -> 0x00f0 }
            java.lang.Object[] r2 = r6.e     // Catch:{ all -> 0x00f0 }
            android.content.Context r3 = r6.a     // Catch:{ all -> 0x00f0 }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x00f0 }
        L_0x000e:
            int r2 = r7.next()     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            r3 = 2
            if (r2 == r3) goto L_0x0019
            r4 = 1
            if (r2 == r4) goto L_0x0019
            goto L_0x000e
        L_0x0019:
            if (r2 != r3) goto L_0x00a1
            java.lang.String r2 = r7.getName()     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.String r4 = "**************************"
            r3.println(r4)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.String r5 = "Creating root view: "
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.String r4 = r4.toString()     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            r3.println(r4)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.String r4 = "**************************"
            r3.println(r4)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.String r3 = "merge"
            boolean r3 = r3.equals(r2)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            if (r3 == 0) goto L_0x005b
            if (r8 == 0) goto L_0x0053
            if (r9 == 0) goto L_0x0053
            r6.a((org.xmlpull.v1.XmlPullParser) r7, (android.view.View) r8, (android.util.AttributeSet) r1)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            goto L_0x009f
        L_0x0053:
            android.view.InflateException r8 = new android.view.InflateException     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.String r9 = "<merge /> can be used only with a valid ViewGroup root and attachToRoot=true"
            r8.<init>(r9)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            throw r8     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
        L_0x005b:
            android.view.View r2 = r6.a((java.lang.String) r2, (android.util.AttributeSet) r1)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            if (r8 == 0) goto L_0x0081
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.String r5 = "Creating params from root: "
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            r4.append(r8)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.String r4 = r4.toString()     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            r3.println(r4)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            android.view.ViewGroup$LayoutParams r3 = r8.generateLayoutParams(r1)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            if (r9 != 0) goto L_0x0082
            r2.setLayoutParams(r3)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            goto L_0x0082
        L_0x0081:
            r3 = 0
        L_0x0082:
            java.io.PrintStream r4 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.String r5 = "-----> start inflating children"
            r4.println(r5)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            r6.a((org.xmlpull.v1.XmlPullParser) r7, (android.view.View) r2, (android.util.AttributeSet) r1)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.String r4 = "-----> done inflating children"
            r1.println(r4)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            if (r8 == 0) goto L_0x009a
            if (r9 == 0) goto L_0x009a
            r8.addView(r2, r3)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
        L_0x009a:
            if (r8 == 0) goto L_0x009e
            if (r9 != 0) goto L_0x009f
        L_0x009e:
            r8 = r2
        L_0x009f:
            monitor-exit(r0)     // Catch:{ all -> 0x00f0 }
            return r8
        L_0x00a1:
            android.view.InflateException r8 = new android.view.InflateException     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            r9.<init>()     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.String r1 = r7.getPositionDescription()     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            r9.append(r1)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.String r1 = ": No start tag found!"
            r9.append(r1)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            java.lang.String r9 = r9.toString()     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            r8.<init>(r9)     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
            throw r8     // Catch:{ XmlPullParserException -> 0x00e2, IOException -> 0x00bc }
        L_0x00bc:
            r8 = move-exception
            android.view.InflateException r9 = new android.view.InflateException     // Catch:{ all -> 0x00f0 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f0 }
            r1.<init>()     // Catch:{ all -> 0x00f0 }
            java.lang.String r7 = r7.getPositionDescription()     // Catch:{ all -> 0x00f0 }
            r1.append(r7)     // Catch:{ all -> 0x00f0 }
            java.lang.String r7 = ": "
            r1.append(r7)     // Catch:{ all -> 0x00f0 }
            java.lang.String r7 = r8.getMessage()     // Catch:{ all -> 0x00f0 }
            r1.append(r7)     // Catch:{ all -> 0x00f0 }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x00f0 }
            r9.<init>(r7)     // Catch:{ all -> 0x00f0 }
            r9.initCause(r8)     // Catch:{ all -> 0x00f0 }
            throw r9     // Catch:{ all -> 0x00f0 }
        L_0x00e2:
            r7 = move-exception
            android.view.InflateException r8 = new android.view.InflateException     // Catch:{ all -> 0x00f0 }
            java.lang.String r9 = r7.getMessage()     // Catch:{ all -> 0x00f0 }
            r8.<init>(r9)     // Catch:{ all -> 0x00f0 }
            r8.initCause(r7)     // Catch:{ all -> 0x00f0 }
            throw r8     // Catch:{ all -> 0x00f0 }
        L_0x00f0:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00f0 }
            goto L_0x00f4
        L_0x00f3:
            throw r7
        L_0x00f4:
            goto L_0x00f3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.a.a.a(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View");
    }

    private View a(String str, String str2, AttributeSet attributeSet) throws ClassNotFoundException, InflateException {
        String str3;
        String str4;
        String str5;
        HashMap<String, Constructor> hashMap = g;
        Constructor<?> constructor = hashMap.get(str);
        Class cls = null;
        if (constructor == null) {
            try {
                ClassLoader classLoader = this.a.getClassLoader();
                if (str2 != null) {
                    str5 = str2 + str;
                } else {
                    str5 = str;
                }
                Class<?> loadClass = classLoader.loadClass(str5);
                b bVar = this.d;
                if (!(bVar == null || loadClass == null || bVar.a(loadClass))) {
                    b(str, str2, attributeSet);
                }
                constructor = loadClass.getConstructor(f);
                hashMap.put(str, constructor);
            } catch (NoSuchMethodException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append(attributeSet.getPositionDescription());
                sb.append(": Error inflating class ");
                if (str2 != null) {
                    str = str2 + str;
                }
                sb.append(str);
                InflateException inflateException = new InflateException(sb.toString());
                inflateException.initCause(e2);
                throw inflateException;
            } catch (ClassNotFoundException e3) {
                throw e3;
            } catch (Exception e4) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(attributeSet.getPositionDescription());
                sb2.append(": Error inflating class ");
                if (cls == null) {
                    str4 = "<unknown>";
                } else {
                    str4 = cls.getName();
                }
                sb2.append(str4);
                InflateException inflateException2 = new InflateException(sb2.toString());
                inflateException2.initCause(e4);
                throw inflateException2;
            }
        } else if (this.d != null) {
            Boolean bool = this.h.get(str);
            if (bool == null) {
                ClassLoader classLoader2 = this.a.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                Class<?> loadClass2 = classLoader2.loadClass(str3);
                boolean z = loadClass2 != null && this.d.a(loadClass2);
                this.h.put(str, Boolean.valueOf(z));
                if (!z) {
                    b(str, str2, attributeSet);
                }
            } else if (bool.equals(Boolean.FALSE)) {
                b(str, str2, attributeSet);
            }
        }
        Object[] objArr = this.e;
        objArr[1] = attributeSet;
        return (View) constructor.newInstance(objArr);
    }

    private void b(String str, String str2, AttributeSet attributeSet) {
        StringBuilder sb = new StringBuilder();
        sb.append(attributeSet.getPositionDescription());
        sb.append(": Class not allowed to be inflated ");
        if (str2 != null) {
            str = str2 + str;
        }
        sb.append(str);
        throw new InflateException(sb.toString());
    }

    private View a(String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        PrintStream printStream = System.out;
        printStream.println("******** Creating view: " + str);
        try {
            C0131a aVar = this.c;
            View a2 = aVar == null ? null : aVar.a(str, this.a, attributeSet);
            if (a2 == null) {
                if (-1 == str.indexOf(46)) {
                    if (!str.equals("MBStarLevelLayoutView")) {
                        if (!str.equals("LuckPan")) {
                            a2 = a(str, j, attributeSet);
                        }
                    }
                    a2 = a(str, "", attributeSet);
                } else {
                    a2 = a(str, (String) null, attributeSet);
                }
            }
            PrintStream printStream2 = System.out;
            printStream2.println("Created view is: " + a2);
            return a2;
        } catch (InflateException e2) {
            throw e2;
        } catch (ClassNotFoundException e3) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e3);
            throw inflateException;
        } catch (Exception e4) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e4);
            throw inflateException2;
        }
    }

    private void a(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int next;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next2 = xmlPullParser.next();
            if ((next2 == 3 && xmlPullParser.getDepth() <= depth) || next2 == 1) {
                return;
            }
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                if ("requestFocus".equals(name)) {
                    view.requestFocus();
                    int depth2 = xmlPullParser.getDepth();
                    do {
                        next = xmlPullParser.next();
                        if (next == 3 && xmlPullParser.getDepth() <= depth2) {
                            break;
                        }
                    } while (next != 1);
                } else if ("include".equals(name)) {
                    if (xmlPullParser.getDepth() != 0) {
                        b(xmlPullParser, view, attributeSet);
                    } else {
                        throw new InflateException("<include /> cannot be the root element");
                    }
                } else if (!"merge".equals(name)) {
                    View a2 = a(name, attributeSet);
                    ViewGroup viewGroup = (ViewGroup) view;
                    ViewGroup.LayoutParams generateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                    a(xmlPullParser, a2, attributeSet);
                    viewGroup.addView(a2, generateLayoutParams);
                } else {
                    throw new InflateException("<merge /> must be the root element");
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
        if (r8 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r2.setLayoutParams(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r8 = r7.generateLayoutParams(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        if (r8 == null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        a((org.xmlpull.v1.XmlPullParser) r0, r2, r1);
        r7.addView(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b3, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b4, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b7, code lost:
        throw r6;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0072 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050 A[Catch:{ all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0098 A[Catch:{ all -> 0x00b3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(org.xmlpull.v1.XmlPullParser r6, android.view.View r7, android.util.AttributeSet r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r5 = this;
            boolean r0 = r7 instanceof android.view.ViewGroup
            if (r0 == 0) goto L_0x00b8
            r0 = 0
            r1 = 0
            java.lang.String r2 = "layout"
            int r0 = r8.getAttributeResourceValue(r1, r2, r0)
            if (r0 != 0) goto L_0x0035
            java.lang.String r6 = r8.getAttributeValue(r1, r2)
            if (r6 != 0) goto L_0x001c
            android.view.InflateException r6 = new android.view.InflateException
            java.lang.String r7 = "You must specifiy a layout in the include tag: <include layout=\"@layout/layoutID\" />"
            r6.<init>(r7)
            throw r6
        L_0x001c:
            android.view.InflateException r7 = new android.view.InflateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "You must specifiy a valid layout reference. The layout ID "
            r8.<init>(r0)
            r8.append(r6)
            java.lang.String r6 = " is not valid."
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.<init>(r6)
            throw r7
        L_0x0035:
            android.content.Context r1 = r5.a
            android.content.res.Resources r1 = r1.getResources()
            android.content.res.XmlResourceParser r0 = r1.getLayout(r0)
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r0)     // Catch:{ all -> 0x00b3 }
        L_0x0043:
            int r2 = r0.next()     // Catch:{ all -> 0x00b3 }
            r3 = 1
            r4 = 2
            if (r2 == r4) goto L_0x004e
            if (r2 == r3) goto L_0x004e
            goto L_0x0043
        L_0x004e:
            if (r2 != r4) goto L_0x0098
            java.lang.String r2 = r0.getName()     // Catch:{ all -> 0x00b3 }
            java.lang.String r4 = "merge"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x00b3 }
            if (r4 == 0) goto L_0x0060
            r5.a((org.xmlpull.v1.XmlPullParser) r0, (android.view.View) r7, (android.util.AttributeSet) r1)     // Catch:{ all -> 0x00b3 }
            goto L_0x007f
        L_0x0060:
            android.view.View r2 = r5.a((java.lang.String) r2, (android.util.AttributeSet) r1)     // Catch:{ all -> 0x00b3 }
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7     // Catch:{ all -> 0x00b3 }
            android.view.ViewGroup$LayoutParams r8 = r7.generateLayoutParams(r8)     // Catch:{ RuntimeException -> 0x0072 }
            if (r8 == 0) goto L_0x0079
        L_0x006c:
            r2.setLayoutParams(r8)     // Catch:{ all -> 0x00b3 }
            goto L_0x0079
        L_0x0070:
            r6 = move-exception
            goto L_0x0097
        L_0x0072:
            android.view.ViewGroup$LayoutParams r8 = r7.generateLayoutParams(r1)     // Catch:{ all -> 0x0070 }
            if (r8 == 0) goto L_0x0079
            goto L_0x006c
        L_0x0079:
            r5.a((org.xmlpull.v1.XmlPullParser) r0, (android.view.View) r2, (android.util.AttributeSet) r1)     // Catch:{ all -> 0x00b3 }
            r7.addView(r2)     // Catch:{ all -> 0x00b3 }
        L_0x007f:
            r0.close()
            int r7 = r6.getDepth()
        L_0x0086:
            int r8 = r6.next()
            r0 = 3
            if (r8 != r0) goto L_0x0093
            int r0 = r6.getDepth()
            if (r0 <= r7) goto L_0x0096
        L_0x0093:
            if (r8 == r3) goto L_0x0096
            goto L_0x0086
        L_0x0096:
            return
        L_0x0097:
            throw r6     // Catch:{ all -> 0x00b3 }
        L_0x0098:
            android.view.InflateException r6 = new android.view.InflateException     // Catch:{ all -> 0x00b3 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            r7.<init>()     // Catch:{ all -> 0x00b3 }
            java.lang.String r8 = r0.getPositionDescription()     // Catch:{ all -> 0x00b3 }
            r7.append(r8)     // Catch:{ all -> 0x00b3 }
            java.lang.String r8 = ": No start tag found!"
            r7.append(r8)     // Catch:{ all -> 0x00b3 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00b3 }
            r6.<init>(r7)     // Catch:{ all -> 0x00b3 }
            throw r6     // Catch:{ all -> 0x00b3 }
        L_0x00b3:
            r6 = move-exception
            r0.close()
            throw r6
        L_0x00b8:
            android.view.InflateException r6 = new android.view.InflateException
            java.lang.String r7 = "<include /> can only be used inside of a ViewGroup"
            r6.<init>(r7)
            goto L_0x00c1
        L_0x00c0:
            throw r6
        L_0x00c1:
            goto L_0x00c0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.a.a.b(org.xmlpull.v1.XmlPullParser, android.view.View, android.util.AttributeSet):void");
    }

    public final View a(String str, ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        this.i = System.currentTimeMillis();
        PrintStream printStream = System.out;
        printStream.println("INFLATING from resource: " + str);
        return a(a(str), viewGroup, z);
    }
}
