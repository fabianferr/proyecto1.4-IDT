package com.teragence.library;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class k8 implements Serializable {
    public static final Class i = new Object().getClass();
    public static final Class j = "".getClass();
    public static final Class k = new Integer(0).getClass();
    public static final Class l = new Long(0).getClass();
    public static final Class m = new Boolean(true).getClass();
    public static final Class n = new Vector().getClass();
    public static final k8 o = new k8();
    public String b;
    public String c;
    public int d;
    protected Object e;
    public Object f = i;
    public boolean g;
    public k8 h;

    public void a() {
        this.f = i;
        this.d = 0;
        this.b = null;
        this.c = null;
    }

    public void a(Object obj) {
        this.f = obj;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public void b(Object obj) {
        this.e = obj;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public Object clone() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.flush();
            objectOutputStream.close();
            return new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (NotSerializableException e3) {
            e3.printStackTrace();
            return null;
        } catch (IOException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public Object d() {
        return this.e;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append(" : ");
        Object obj = this.e;
        if (obj != null) {
            stringBuffer.append(obj);
        } else {
            stringBuffer.append("(not set)");
        }
        return stringBuffer.toString();
    }
}
