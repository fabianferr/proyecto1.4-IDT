package com.umlaut.crowd.internal;

public class y5 implements Cloneable {
    public int ActiveSimCount = -1;
    public int ActiveSimCountMax = -1;
    public int DefaultDataSimId = -1;
    public int DefaultSimId = -1;
    public int DefaultSmsSimId = -1;
    public int DefaultVoiceSimId = -1;
    public z5 MultiSimVariant = z5.Unknown;
    public o9[] SimInfos = new o9[0];

    public Object clone() throws CloneNotSupportedException {
        y5 y5Var = (y5) super.clone();
        y5Var.SimInfos = new o9[this.SimInfos.length];
        int i = 0;
        while (true) {
            o9[] o9VarArr = this.SimInfos;
            if (i >= o9VarArr.length) {
                return y5Var;
            }
            y5Var.SimInfos[i] = (o9) o9VarArr[i].clone();
            i++;
        }
    }

    public o9 getDefaultDataSimInfo() {
        for (o9 o9Var : this.SimInfos) {
            if (o9Var.SubscriptionId == this.DefaultDataSimId) {
                return o9Var;
            }
        }
        return new o9();
    }

    public o9 getDefaultSmsSimInfo() {
        for (o9 o9Var : this.SimInfos) {
            if (o9Var.SubscriptionId == this.DefaultSmsSimId) {
                return o9Var;
            }
        }
        return new o9();
    }

    public o9 getDefaultVoiceSimInfo() {
        for (o9 o9Var : this.SimInfos) {
            if (o9Var.SubscriptionId == this.DefaultVoiceSimId) {
                return o9Var;
            }
        }
        return new o9();
    }

    public o9 getSimInfoSubId(int i) {
        for (o9 o9Var : this.SimInfos) {
            if (o9Var.SubscriptionId == i) {
                return o9Var;
            }
        }
        return new o9();
    }
}
