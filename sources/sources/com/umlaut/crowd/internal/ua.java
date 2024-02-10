package com.umlaut.crowd.internal;

import androidx.core.app.NotificationCompat;

public class ua implements h4 {
    public sa msg;
    public ja testType;

    public static ua a(sa saVar) {
        ua uaVar = new ua();
        uaVar.testType = saVar.a();
        uaVar.msg = saVar;
        return uaVar;
    }

    public void a(o4 o4Var) throws g4 {
        o4Var.b("type");
        o4Var.a((Object) this.testType);
        o4Var.b(NotificationCompat.CATEGORY_MESSAGE);
        o4Var.a((Object) this.msg);
    }

    public void a(k4 k4Var) throws g4 {
        String q = k4Var.q();
        if (q.equals("type")) {
            this.testType = (ja) k4Var.b((Class<?>) ja.class);
            String q2 = k4Var.q();
            if (q2.equals(NotificationCompat.CATEGORY_MESSAGE)) {
                this.msg = (sa) k4Var.b(this.testType.a());
                return;
            }
            throw new g4("Eror on reading: Unknown/unexpected field \"" + q2 + "\"");
        }
        throw new g4("Eror on reading: Unknown/unexpected field \"" + q + "\"");
    }
}
