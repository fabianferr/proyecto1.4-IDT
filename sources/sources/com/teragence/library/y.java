package com.teragence.library;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class y implements e6, Externalizable {
    private e6 b;

    public y() {
    }

    public y(e6 e6Var) {
        this.b = e6Var;
    }

    public w5 a() {
        return this.b.a();
    }

    public String b() {
        return this.b.b();
    }

    public boolean c() {
        return this.b.c();
    }

    public boolean d() {
        return this.b.d();
    }

    public long e() {
        return this.b.e();
    }

    public n5 f() {
        return this.b.f();
    }

    public boolean g() {
        return this.b.g();
    }

    public Date h() {
        return this.b.h();
    }

    public void readExternal(ObjectInput objectInput) {
        this.b = new u7(objectInput.readLong(), new Date(objectInput.readLong()), objectInput.readUTF(), new n7(objectInput.readUTF(), objectInput.readUTF(), objectInput.readUTF(), objectInput.readUTF()), n5.valueOf(objectInput.readUTF()), objectInput.readBoolean(), objectInput.readBoolean(), objectInput.readBoolean());
    }

    public String toString() {
        return "ExternalizableReportMeasurementRequest{origin=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeLong(this.b.e());
        objectOutput.writeLong(this.b.h().getTime());
        objectOutput.writeUTF(this.b.b());
        w5 a = this.b.a();
        objectOutput.writeUTF(a.d());
        objectOutput.writeUTF(a.c());
        objectOutput.writeUTF(a.a());
        objectOutput.writeUTF(a.b());
        objectOutput.writeUTF(this.b.f().name());
        objectOutput.writeBoolean(this.b.g());
        objectOutput.writeBoolean(this.b.d());
        objectOutput.writeBoolean(this.b.c());
    }
}
