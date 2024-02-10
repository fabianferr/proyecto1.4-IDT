package com.teragence.library;

import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class n8 extends y7 {
    static final i8 t = new d8();
    public Hashtable j = new Hashtable();
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    protected Hashtable o = new Hashtable();
    protected Hashtable p = new Hashtable();
    protected boolean q = true;
    Hashtable r = new Hashtable();
    Vector s;

    public n8(int i) {
        super(i);
        a(this.g, "Array", k8.n);
        t.a(this);
    }

    private int a(String str, int i, int i2) {
        if (str == null) {
            return i2;
        }
        try {
            return str.length() - i < 3 ? i2 : Integer.parseInt(str.substring(i + 1, str.length() - 1));
        } catch (Exception unused) {
            return i2;
        }
    }

    private void a(z8 z8Var, f8 f8Var) {
        int a = f8Var.a();
        for (int i = 0; i < a; i++) {
            c8 c8Var = new c8();
            f8Var.a(i, c8Var);
            f8Var.b(i, c8Var);
            if (c8Var.d() != null) {
                z8Var.a(c8Var.c(), c8Var.b(), c8Var.d().toString());
            }
        }
    }

    private void d(z8 z8Var, h8 h8Var) {
        Object b;
        if ((h8Var instanceof g8) && (b = ((g8) h8Var).b()) != null) {
            if (b instanceof o8) {
                ((o8) b).a(z8Var);
            } else {
                z8Var.e(b.toString());
            }
        }
    }

    public Object a(x8 x8Var, Object obj, int i, String str, String str2, k8 k8Var) {
        Object obj2;
        Object obj3;
        String n2 = x8Var.n();
        String a = x8Var.a((String) null, ShareConstants.WEB_DIALOG_PARAM_HREF);
        if (a == null) {
            String a2 = x8Var.a(this.h, "nil");
            String a3 = x8Var.a((String) null, "id");
            if (a2 == null) {
                a2 = x8Var.a(this.h, AbstractJsonLexerKt.NULL);
            }
            if (a2 == null || !y7.a(a2)) {
                String a4 = x8Var.a(this.h, "type");
                if (a4 != null) {
                    int indexOf = a4.indexOf(58);
                    str2 = a4.substring(indexOf + 1);
                    str = x8Var.a(indexOf == -1 ? "" : a4.substring(0, indexOf));
                } else if (str2 == null && str == null) {
                    if (x8Var.a(this.g, "arrayType") != null) {
                        str = this.g;
                        str2 = "Array";
                    } else {
                        Object[] a5 = a(k8Var.f, (Object) null);
                        String str3 = (String) a5[0];
                        str2 = (String) a5[1];
                        str = str3;
                    }
                }
                if (a4 == null) {
                    this.k = true;
                }
                Object a6 = a(x8Var, str, str2, k8Var);
                if (a6 == null) {
                    a6 = a(x8Var, str, str2);
                }
                obj3 = a6;
            } else {
                x8Var.i();
                x8Var.a(3, (String) null, n2);
                obj3 = null;
            }
            if (a3 != null) {
                a(a3, obj2);
            }
        } else if (obj != null) {
            String b = b(a);
            obj2 = this.r.get(b);
            if (obj2 == null || (obj2 instanceof e8)) {
                e8 e8Var = new e8();
                e8Var.a = (e8) obj2;
                e8Var.b = obj;
                e8Var.c = i;
                this.r.put(b, e8Var);
                obj2 = null;
            }
            x8Var.i();
            x8Var.a(3, (String) null, n2);
        } else {
            throw new RuntimeException("href at root level?!?");
        }
        x8Var.a(3, (String) null, n2);
        return obj2;
    }

    /* access modifiers changed from: protected */
    public Object a(x8 x8Var, String str, String str2) {
        b8 b8Var;
        String str3;
        x8 x8Var2 = x8Var;
        String str4 = str;
        String str5 = str2;
        String n2 = x8Var.n();
        String k2 = x8Var.k();
        Vector vector = new Vector();
        for (int i = 0; i < x8Var.a(); i++) {
            c8 c8Var = new c8();
            c8Var.a(x8Var2.b(i));
            c8Var.b((Object) x8Var2.f(i));
            c8Var.b(x8Var2.g(i));
            c8Var.a((Object) x8Var2.e(i));
            vector.addElement(c8Var);
        }
        x8Var.h();
        if (x8Var.l() == 4) {
            str3 = x8Var.j();
            b8Var = new m8(str4, str5, str3);
            for (int i2 = 0; i2 < vector.size(); i2++) {
                b8Var.b((c8) vector.elementAt(i2));
            }
            x8Var.h();
        } else {
            b8Var = null;
            if (x8Var.l() == 3) {
                b8 l8Var = new l8(str4, str5);
                for (int i3 = 0; i3 < vector.size(); i3++) {
                    l8Var.b((c8) vector.elementAt(i3));
                }
                b8Var = l8Var;
                str3 = null;
            } else {
                str3 = null;
            }
        }
        if (x8Var.l() == 2) {
            if (str3 == null || str3.trim().length() == 0) {
                l8 l8Var2 = new l8(str4, str5);
                for (int i4 = 0; i4 < vector.size(); i4++) {
                    l8Var2.b((c8) vector.elementAt(i4));
                }
                while (x8Var.l() != 3) {
                    l8Var2.b(x8Var.k(), x8Var.n(), a(x8Var, l8Var2, l8Var2.m(), (String) null, (String) null, k8.o));
                    x8Var.i();
                }
                b8Var = l8Var2;
            } else {
                throw new RuntimeException("Malformed input: Mixed content");
            }
        }
        x8Var2.a(3, k2, n2);
        return b8Var;
    }

    public Object a(x8 x8Var, String str, String str2, k8 k8Var) {
        Object obj;
        Object obj2 = this.o.get(new m8(str, str2, (Object) null));
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof i8) {
            return ((i8) obj2).a(x8Var, str, str2, k8Var);
        }
        if (obj2 instanceof l8) {
            obj = ((l8) obj2).e();
        } else if (obj2 == l8.class) {
            obj = new l8(str, str2);
        } else {
            try {
                obj = ((Class) obj2).newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        if (obj instanceof f8) {
            f8 f8Var = (f8) obj;
            int a = x8Var.a();
            for (int i = 0; i < a; i++) {
                c8 c8Var = new c8();
                c8Var.a(x8Var.b(i));
                c8Var.b((Object) x8Var.f(i));
                c8Var.b(x8Var.g(i));
                c8Var.a((Object) x8Var.e(i));
                f8Var.a(c8Var);
            }
        }
        if (obj instanceof l8) {
            a(x8Var, (l8) obj);
        } else if (obj instanceof h8) {
            if (obj instanceof g8) {
                ((g8) obj).a(x8Var.j() != null ? x8Var.j() : "");
            }
            a(x8Var, (h8) obj);
        } else if (obj instanceof Vector) {
            a(x8Var, (Vector) obj, k8Var.h);
        } else {
            throw new RuntimeException("no deserializer for " + obj.getClass());
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.teragence.library.x8 r18, com.teragence.library.h8 r19) {
        /*
            r17 = this;
            r0 = r19
            java.lang.String r1 = ""
            int r2 = r18.i()     // Catch:{ y8 -> 0x000f }
            r3 = r17
            r4 = r2
            r2 = r0
            r0 = r18
            goto L_0x0036
        L_0x000f:
            boolean r2 = r0 instanceof com.teragence.library.g8
            if (r2 == 0) goto L_0x002d
            r2 = r0
            com.teragence.library.g8 r2 = (com.teragence.library.g8) r2
            java.lang.String r3 = r18.j()
            if (r3 == 0) goto L_0x0025
            java.lang.String r3 = r18.j()
            r4 = r17
            r5 = r3
            r3 = r0
            goto L_0x0029
        L_0x0025:
            r4 = r17
            r3 = r0
            r5 = r1
        L_0x0029:
            r0 = r18
            goto L_0x012f
        L_0x002d:
            r3 = r17
            r2 = r0
            r0 = r18
        L_0x0032:
            int r4 = r0.i()
        L_0x0036:
            r12 = 3
            if (r4 == r12) goto L_0x0136
            java.lang.String r4 = r0.n()
            boolean r5 = r3.k
            if (r5 == 0) goto L_0x0064
            boolean r5 = r2 instanceof com.teragence.library.l8
            if (r5 != 0) goto L_0x0046
            goto L_0x0064
        L_0x0046:
            r12 = r2
            com.teragence.library.l8 r12 = (com.teragence.library.l8) r12
            java.lang.String r13 = r0.n()
            int r8 = r2.m()
            java.lang.String r9 = r12.d()
            com.teragence.library.k8 r11 = com.teragence.library.k8.o
            r5 = r3
            r6 = r0
            r7 = r2
            r10 = r4
            java.lang.Object r4 = r5.a(r6, r7, r8, r9, r10, r11)
            r12.b(r13, r4)
            goto L_0x0110
        L_0x0064:
            com.teragence.library.k8 r13 = new com.teragence.library.k8
            r13.<init>()
            int r14 = r2.m()
            r5 = 0
            r11 = 0
        L_0x006f:
            if (r11 >= r14) goto L_0x00b0
            if (r5 != 0) goto L_0x00b0
            r13.a()
            java.util.Hashtable r6 = r3.j
            r2.a(r11, r6, r13)
            java.lang.String r6 = r13.b
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0087
            java.lang.String r6 = r13.c
            if (r6 == 0) goto L_0x009b
        L_0x0087:
            java.lang.String r6 = r13.b
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x00ac
            java.lang.String r6 = r0.k()
            java.lang.String r7 = r13.c
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00ac
        L_0x009b:
            r9 = 0
            r10 = 0
            r5 = r3
            r6 = r0
            r7 = r2
            r8 = r11
            r15 = r11
            r11 = r13
            java.lang.Object r5 = r5.a(r6, r7, r8, r9, r10, r11)
            r2.a(r15, r5)
            r5 = 1
            goto L_0x00ad
        L_0x00ac:
            r15 = r11
        L_0x00ad:
            int r11 = r15 + 1
            goto L_0x006f
        L_0x00b0:
            if (r5 != 0) goto L_0x00db
            boolean r5 = r3.n
            if (r5 == 0) goto L_0x00c7
        L_0x00b6:
            int r5 = r0.h()
            if (r5 != r12) goto L_0x00b6
            java.lang.String r5 = r0.n()
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x0110
            goto L_0x00b6
        L_0x00c7:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown Property: "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00db:
            boolean r4 = r2 instanceof com.teragence.library.f8
            if (r4 == 0) goto L_0x0110
            r4 = r2
            com.teragence.library.f8 r4 = (com.teragence.library.f8) r4
            int r5 = r0.a()
            r15 = 0
        L_0x00e7:
            if (r15 >= r5) goto L_0x0110
            com.teragence.library.c8 r6 = new com.teragence.library.c8
            r6.<init>()
            java.lang.String r7 = r0.b(r15)
            r6.a((java.lang.String) r7)
            java.lang.String r7 = r0.f(r15)
            r6.b((java.lang.Object) r7)
            java.lang.String r7 = r0.g(r15)
            r6.b((java.lang.String) r7)
            java.lang.String r7 = r0.e(r15)
            r6.a((java.lang.Object) r7)
            r4.a(r6)
            int r15 = r15 + 1
            goto L_0x00e7
        L_0x0110:
            int r4 = r0.i()     // Catch:{ y8 -> 0x0116 }
            goto L_0x0036
        L_0x0116:
            boolean r4 = r2 instanceof com.teragence.library.g8
            if (r4 == 0) goto L_0x0032
            r4 = r2
            com.teragence.library.g8 r4 = (com.teragence.library.g8) r4
            java.lang.String r5 = r0.j()
            if (r5 == 0) goto L_0x0128
            java.lang.String r5 = r0.j()
            goto L_0x0129
        L_0x0128:
            r5 = r1
        L_0x0129:
            r16 = r3
            r3 = r2
            r2 = r4
            r4 = r16
        L_0x012f:
            r2.a(r5)
            r2 = r3
            r3 = r4
            goto L_0x0032
        L_0x0136:
            r1 = 0
            r0.a(r12, r1, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.n8.a(com.teragence.library.x8, com.teragence.library.h8):void");
    }

    /* access modifiers changed from: protected */
    public void a(x8 x8Var, l8 l8Var) {
        for (int i = 0; i < x8Var.a(); i++) {
            l8Var.a(x8Var.b(i), (Object) x8Var.f(i));
        }
        a(x8Var, (h8) l8Var);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.teragence.library.x8 r18, java.util.Vector r19, com.teragence.library.k8 r20) {
        /*
            r17 = this;
            r7 = r17
            r8 = r18
            r9 = r19
            int r0 = r19.size()
            java.lang.String r1 = r7.g
            java.lang.String r2 = "arrayType"
            java.lang.String r1 = r8.a((java.lang.String) r1, (java.lang.String) r2)
            r10 = 0
            r11 = 0
            r2 = 1
            if (r1 == 0) goto L_0x0049
            r0 = 58
            int r0 = r1.indexOf(r0)
            java.lang.String r3 = "["
            int r3 = r1.indexOf(r3, r0)
            int r4 = r0 + 1
            java.lang.String r4 = r1.substring(r4, r3)
            r5 = -1
            if (r0 != r5) goto L_0x002f
            java.lang.String r0 = ""
            goto L_0x0033
        L_0x002f:
            java.lang.String r0 = r1.substring(r10, r0)
        L_0x0033:
            java.lang.String r0 = r8.a((java.lang.String) r0)
            int r1 = r7.a((java.lang.String) r1, (int) r3, (int) r5)
            if (r1 == r5) goto L_0x0045
            r9.setSize(r1)
            r12 = r0
            r0 = r1
            r14 = r4
            r13 = 0
            goto L_0x004c
        L_0x0045:
            r12 = r0
            r0 = r1
            r14 = r4
            goto L_0x004b
        L_0x0049:
            r12 = r11
            r14 = r12
        L_0x004b:
            r13 = 1
        L_0x004c:
            if (r20 != 0) goto L_0x0052
            com.teragence.library.k8 r1 = com.teragence.library.k8.o
            r15 = r1
            goto L_0x0054
        L_0x0052:
            r15 = r20
        L_0x0054:
            r18.i()
            java.lang.String r1 = r7.g
            java.lang.String r2 = "offset"
            java.lang.String r1 = r8.a((java.lang.String) r1, (java.lang.String) r2)
            int r1 = r7.a((java.lang.String) r1, (int) r10, (int) r10)
        L_0x0063:
            int r2 = r18.l()
            r3 = 3
            if (r2 == r3) goto L_0x009c
            java.lang.String r2 = r7.g
            java.lang.String r3 = "position"
            java.lang.String r2 = r8.a((java.lang.String) r2, (java.lang.String) r3)
            int r6 = r7.a((java.lang.String) r2, (int) r10, (int) r1)
            if (r13 == 0) goto L_0x007f
            if (r6 < r0) goto L_0x007f
            int r0 = r6 + 1
            r9.setSize(r0)
        L_0x007f:
            r16 = r0
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r6
            r4 = r12
            r5 = r14
            r10 = r6
            r6 = r15
            java.lang.Object r0 = r0.a(r1, r2, r3, r4, r5, r6)
            r9.setElementAt(r0, r10)
            int r1 = r10 + 1
            r18.i()
            r0 = r16
            r10 = 0
            goto L_0x0063
        L_0x009c:
            r8.a(r3, r11, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.n8.a(com.teragence.library.x8, java.util.Vector, com.teragence.library.k8):void");
    }

    public void a(z8 z8Var, h8 h8Var) {
        if (h8Var instanceof f8) {
            a(z8Var, (f8) h8Var);
        }
        a(z8Var, (ArrayList) h8Var);
    }

    /* access modifiers changed from: protected */
    public void a(z8 z8Var, Object obj, k8 k8Var) {
        StringBuilder sb;
        if (obj == null || obj == m8.f) {
            z8Var.a(this.h, this.e >= 120 ? "nil" : AbstractJsonLexerKt.NULL, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            return;
        }
        Object[] a = a((Object) null, obj);
        if (k8Var.g || a[2] != null) {
            int indexOf = this.s.indexOf(obj);
            if (indexOf == -1) {
                indexOf = this.s.size();
                this.s.addElement(obj);
            }
            if (a[2] == null) {
                sb = new StringBuilder("#o");
                sb.append(indexOf);
            } else {
                sb = new StringBuilder("#");
                sb.append(a[2]);
            }
            z8Var.a((String) null, ShareConstants.WEB_DIALOG_PARAM_HREF, sb.toString());
            return;
        }
        if (!this.k || obj.getClass() != k8Var.f) {
            String a2 = z8Var.a((String) a[0], true);
            String str = this.h;
            z8Var.a(str, "type", a2 + CertificateUtil.DELIMITER + a[1]);
        }
        a(z8Var, obj, k8Var, a[3]);
    }

    /* access modifiers changed from: protected */
    public void a(z8 z8Var, Object obj, k8 k8Var, Object obj2) {
        if (obj2 != null) {
            ((i8) obj2).a(z8Var, obj);
        } else if ((obj instanceof h8) || obj == m8.f || obj == m8.e) {
            boolean z = obj instanceof ArrayList;
            h8 h8Var = (h8) obj;
            if (z) {
                a(z8Var, h8Var);
            } else {
                c(z8Var, h8Var);
            }
        } else if (obj instanceof f8) {
            a(z8Var, (f8) obj);
        } else if (obj instanceof Vector) {
            a(z8Var, (Vector) obj, k8Var.h);
        } else {
            throw new RuntimeException("Cannot serialize: " + obj);
        }
    }

    /* access modifiers changed from: protected */
    public void a(z8 z8Var, ArrayList arrayList) {
        h8 h8Var = (h8) arrayList;
        int size = arrayList.size();
        k8 k8Var = new k8();
        for (int i = 0; i < size; i++) {
            Object a = h8Var.a(i);
            h8Var.a(i, this.j, k8Var);
            if (a instanceof l8) {
                l8 l8Var = (l8) a;
                Object[] a2 = a((Object) null, (Object) l8Var);
                String str = (String) a2[0];
                String str2 = (String) a2[1];
                String str3 = k8Var.b;
                String str4 = (str3 == null || str3.length() <= 0) ? (String) a2[1] : k8Var.b;
                String str5 = k8Var.c;
                String str6 = (str5 == null || str5.length() <= 0) ? (String) a2[0] : k8Var.c;
                z8Var.b(str6, str4);
                if (!this.k) {
                    String a3 = z8Var.a(str6, true);
                    String str7 = this.h;
                    z8Var.a(str7, "type", a3 + CertificateUtil.DELIMITER + str2);
                }
                c(z8Var, l8Var);
                z8Var.c(str6, str4);
            } else if ((k8Var.d & 1) == 0) {
                Object a4 = h8Var.a(i);
                if ((a != null || !this.l) && a4 != m8.e) {
                    z8Var.b(k8Var.c, k8Var.b);
                    a(z8Var, a4, k8Var);
                    z8Var.c(k8Var.c, k8Var.b);
                }
            }
        }
        d(z8Var, h8Var);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.teragence.library.z8 r12, java.util.Vector r13, com.teragence.library.k8 r14) {
        /*
            r11 = this;
            java.lang.String r0 = "item"
            r1 = 0
            if (r14 != 0) goto L_0x000a
            com.teragence.library.k8 r14 = com.teragence.library.k8.o
        L_0x0007:
            r2 = r0
            r0 = r1
            goto L_0x0014
        L_0x000a:
            boolean r2 = r14 instanceof com.teragence.library.k8
            if (r2 == 0) goto L_0x0007
            java.lang.String r2 = r14.b
            if (r2 == 0) goto L_0x0007
            java.lang.String r0 = r14.c
        L_0x0014:
            int r3 = r13.size()
            java.lang.Object r4 = r14.f
            java.lang.Object[] r1 = r11.a((java.lang.Object) r4, (java.lang.Object) r1)
            boolean r4 = r11.k
            java.lang.String r5 = "]"
            java.lang.String r6 = "["
            r7 = 1
            r8 = 0
            if (r4 != 0) goto L_0x0057
            java.lang.String r4 = r11.g
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r10 = r1[r8]
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r10 = r12.a((java.lang.String) r10, (boolean) r8)
            r9.append(r10)
            java.lang.String r10 = ":"
            r9.append(r10)
            r1 = r1[r7]
            r9.append(r1)
            r9.append(r6)
            r9.append(r3)
            r9.append(r5)
            java.lang.String r1 = r9.toString()
            java.lang.String r9 = "arrayType"
            r12.a(r4, r9, r1)
            goto L_0x005d
        L_0x0057:
            if (r0 != 0) goto L_0x005d
            r0 = r1[r8]
            java.lang.String r0 = (java.lang.String) r0
        L_0x005d:
            r1 = 0
            r4 = 0
        L_0x005f:
            if (r1 >= r3) goto L_0x0092
            java.lang.Object r9 = r13.elementAt(r1)
            if (r9 != 0) goto L_0x0069
            r4 = 1
            goto L_0x008f
        L_0x0069:
            r12.b(r0, r2)
            if (r4 == 0) goto L_0x0085
            java.lang.String r4 = r11.g
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r6)
            r9.append(r1)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "position"
            r12.a(r4, r10, r9)
            r4 = 0
        L_0x0085:
            java.lang.Object r9 = r13.elementAt(r1)
            r11.a((com.teragence.library.z8) r12, (java.lang.Object) r9, (com.teragence.library.k8) r14)
            r12.c(r0, r2)
        L_0x008f:
            int r1 = r1 + 1
            goto L_0x005f
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.n8.a(com.teragence.library.z8, java.util.Vector, com.teragence.library.k8):void");
    }

    /* access modifiers changed from: protected */
    public void a(String str, Object obj) {
        Object obj2 = this.r.get(str);
        if (obj2 instanceof e8) {
            e8 e8Var = (e8) obj2;
            do {
                Object obj3 = e8Var.b;
                if (obj3 instanceof h8) {
                    ((h8) obj3).a(e8Var.c, obj);
                } else {
                    ((Vector) obj3).setElementAt(obj, e8Var.c);
                }
                e8Var = e8Var.a;
            } while (e8Var != null);
        } else if (obj2 == null) {
            this.r.put(str, obj);
        } else {
            throw new RuntimeException("double ID");
        }
        this.r.put(str, obj);
    }

    public void a(String str, String str2, Class cls) {
        a(str, str2, cls, (i8) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Class} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Class} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Class} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r5, java.lang.String r6, java.lang.Class r7, com.teragence.library.i8 r8) {
        /*
            r4 = this;
            java.util.Hashtable r0 = r4.o
            com.teragence.library.m8 r1 = new com.teragence.library.m8
            r2 = 0
            r1.<init>(r5, r6, r2)
            if (r8 != 0) goto L_0x000c
            r3 = r7
            goto L_0x000d
        L_0x000c:
            r3 = r8
        L_0x000d:
            r0.put(r1, r3)
            java.util.Hashtable r0 = r4.p
            java.lang.String r7 = r7.getName()
            r1 = 4
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r3 = 0
            r1[r3] = r5
            r5 = 1
            r1[r5] = r6
            r5 = 2
            r1[r5] = r2
            r5 = 3
            r1[r5] = r8
            r0.put(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.n8.a(java.lang.String, java.lang.String, java.lang.Class, com.teragence.library.i8):void");
    }

    public Object[] a(Object obj, Object obj2) {
        Object[] objArr;
        if (obj == null) {
            obj = ((obj2 instanceof l8) || (obj2 instanceof m8)) ? obj2 : obj2.getClass();
        }
        if (obj instanceof l8) {
            l8 l8Var = (l8) obj;
            return new Object[]{l8Var.d(), l8Var.c(), null, null};
        } else if (obj instanceof m8) {
            m8 m8Var = (m8) obj;
            return new Object[]{m8Var.d(), m8Var.c(), null, t};
        } else if ((obj instanceof Class) && obj != k8.i && (objArr = (Object[]) this.p.get(((Class) obj).getName())) != null) {
            return objArr;
        } else {
            return new Object[]{this.i, "anyType", null, null};
        }
    }

    /* access modifiers changed from: protected */
    public String b(String str) {
        return str.substring(1);
    }

    public void b(x8 x8Var) {
        this.a = null;
        x8Var.i();
        if (x8Var.l() != 2 || !x8Var.k().equals(this.f) || !x8Var.n().equals("Fault")) {
            while (x8Var.l() == 2) {
                String a = x8Var.a(this.g, "root");
                Object a2 = a(x8Var, (Object) null, -1, x8Var.k(), x8Var.n(), k8.o);
                if ("1".equals(a) || this.a == null) {
                    this.a = a2;
                }
                x8Var.i();
            }
            return;
        }
        a8 a8Var = this.e < 120 ? new a8(this.e) : new z7(this.e);
        a8Var.a(x8Var);
        this.a = a8Var;
    }

    public void b(z8 z8Var) {
        if (this.b != null) {
            Vector vector = new Vector();
            this.s = vector;
            vector.addElement(this.b);
            Object[] a = a((Object) null, this.b);
            String str = "";
            z8Var.b(this.m ? str : (String) a[0], (String) a[1]);
            if (this.m) {
                z8Var.a((String) null, "xmlns", (String) a[0]);
            }
            if (this.q) {
                Object obj = a[2];
                z8Var.a((String) null, "id", obj == null ? "o0" : (String) obj);
                z8Var.a(this.g, "root", "1");
            }
            a(z8Var, this.b, (k8) null, a[3]);
            if (!this.m) {
                str = (String) a[0];
            }
            z8Var.c(str, (String) a[1]);
        }
    }

    public void b(z8 z8Var, h8 h8Var) {
        int m2 = h8Var.m();
        k8 k8Var = new k8();
        for (int i = 0; i < m2; i++) {
            Object a = h8Var.a(i);
            h8Var.a(i, this.j, k8Var);
            if (a instanceof l8) {
                l8 l8Var = (l8) a;
                Object[] a2 = a((Object) null, (Object) l8Var);
                String str = (String) a2[0];
                String str2 = (String) a2[1];
                String str3 = k8Var.b;
                String str4 = (str3 == null || str3.length() <= 0) ? (String) a2[1] : k8Var.b;
                String str5 = k8Var.c;
                String str6 = (str5 == null || str5.length() <= 0) ? (String) a2[0] : k8Var.c;
                z8Var.b(str6, str4);
                if (!this.k) {
                    String a3 = z8Var.a(str6, true);
                    String str7 = this.h;
                    z8Var.a(str7, "type", a3 + CertificateUtil.DELIMITER + str2);
                }
                c(z8Var, l8Var);
                z8Var.c(str6, str4);
            } else if ((k8Var.d & 1) == 0) {
                Object a4 = h8Var.a(i);
                if ((a != null || !this.l) && a4 != m8.e) {
                    z8Var.b(k8Var.c, k8Var.b);
                    a(z8Var, a4, k8Var);
                    z8Var.c(k8Var.c, k8Var.b);
                }
            }
        }
        d(z8Var, h8Var);
    }

    public void c(z8 z8Var, h8 h8Var) {
        if (h8Var instanceof f8) {
            a(z8Var, (f8) h8Var);
        }
        b(z8Var, h8Var);
    }
}
