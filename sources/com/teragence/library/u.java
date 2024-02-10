package com.teragence.library;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class u implements o5, Externalizable {
    private o5 b;

    public u() {
    }

    public u(o5 o5Var) {
        this.b = o5Var;
    }

    public Date a() {
        return this.b.a();
    }

    public x5 d() {
        return this.b.d();
    }

    public u5 e() {
        return this.b.e();
    }

    public void readExternal(ObjectInput objectInput) {
        this.b = new h7(new l7(objectInput.readDouble(), objectInput.readDouble(), objectInput.readDouble(), objectInput.readFloat(), objectInput.readFloat()), new o7(new n7(objectInput.readUTF(), objectInput.readUTF(), objectInput.readUTF(), objectInput.readUTF()), objectInput.readUTF(), objectInput.readUTF(), objectInput.readUTF(), objectInput.readBoolean(), objectInput.readDouble(), objectInput.readDouble(), objectInput.readInt()), new Date(objectInput.readLong()));
    }

    public String toString() {
        return "ExternalizableDeadzone{origin=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeLong(this.b.a().getTime());
        objectOutput.writeDouble(this.b.e().b());
        objectOutput.writeDouble(this.b.e().d());
        objectOutput.writeDouble(this.b.e().e());
        objectOutput.writeFloat(this.b.e().c());
        objectOutput.writeFloat(this.b.e().a());
        x5 d = this.b.d();
        w5 d2 = d.d();
        objectOutput.writeUTF(d2.d());
        objectOutput.writeUTF(d2.c());
        objectOutput.writeUTF(d2.a());
        objectOutput.writeUTF(d2.b());
        objectOutput.writeUTF(d.h());
        objectOutput.writeUTF(d.a());
        objectOutput.writeUTF(d.g());
        objectOutput.writeBoolean(d.b());
        objectOutput.writeDouble(d.e());
        objectOutput.writeDouble(d.f());
        objectOutput.writeInt(d.c());
    }
}
