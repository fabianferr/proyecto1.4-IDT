package com.teragence.library;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class i0 implements Externalizable, v5 {
    private v5 b;

    public i0() {
    }

    public i0(v5 v5Var) {
        this.b = v5Var;
    }

    public Date a() {
        return this.b.a();
    }

    public String b() {
        return this.b.b();
    }

    public UUID c() {
        return this.b.c();
    }

    public w5 d() {
        return this.b.d();
    }

    public long e() {
        return this.b.e();
    }

    public String f() {
        return this.b.f();
    }

    public void readExternal(ObjectInput objectInput) {
        this.b = new m7(objectInput.readLong(), objectInput.readUTF(), new n7(objectInput.readUTF(), objectInput.readUTF(), objectInput.readUTF(), objectInput.readUTF()), objectInput.readUTF(), new Date(objectInput.readLong()), new UUID(objectInput.readLong(), objectInput.readLong()));
    }

    public String toString() {
        return "ExternalizableLogError{origin=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeLong(this.b.e());
        UUID c = this.b.c();
        objectOutput.writeLong(c.getLeastSignificantBits());
        objectOutput.writeLong(c.getMostSignificantBits());
        objectOutput.writeUTF(this.b.b());
        w5 d = this.b.d();
        objectOutput.writeUTF(d.d());
        objectOutput.writeUTF(d.c());
        objectOutput.writeUTF(d.a());
        objectOutput.writeUTF(d.b());
        objectOutput.writeUTF(this.b.f());
        objectOutput.writeLong(this.b.a().getTime());
    }
}
