package com.umlaut.crowd.internal;

import androidx.core.app.NotificationCompat;

public class d7 implements h4 {
    public c7 msg;
    public a7 progressType;

    public static d7 a(c7 c7Var) {
        d7 d7Var = new d7();
        d7Var.progressType = c7Var.a();
        d7Var.msg = c7Var;
        return d7Var;
    }

    public void a(o4 o4Var) throws g4 {
        o4Var.b("type");
        o4Var.a((Object) this.progressType);
        o4Var.b(NotificationCompat.CATEGORY_MESSAGE);
        o4Var.a((Object) this.msg);
    }

    public void a(k4 k4Var) throws g4 {
        String q = k4Var.q();
        if (q.equals("type")) {
            this.progressType = (a7) k4Var.b((Class<?>) a7.class);
            String q2 = k4Var.q();
            if (q2.equals(NotificationCompat.CATEGORY_MESSAGE)) {
                this.msg = (c7) k4Var.b(this.progressType.a());
                return;
            }
            throw new g4("Eror on reading: Unknown/unexpected field \"" + q2 + "\"");
        }
        throw new g4("Eror on reading: Unknown/unexpected field \"" + q + "\"");
    }
}
