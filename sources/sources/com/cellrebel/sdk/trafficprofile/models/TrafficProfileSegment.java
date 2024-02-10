package com.cellrebel.sdk.trafficprofile.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class TrafficProfileSegment {
    @SerializedName("id")
    @Expose
    public int a;
    @SerializedName("packetSize")
    @Expose
    public int b;
    @SerializedName("interval")
    @Expose
    public int c;
    @SerializedName("quantity")
    @Expose
    public int d;

    public TrafficProfileSegment(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public String toString() {
        return "[" + this.b + "," + this.c + "," + this.d + AbstractJsonLexerKt.END_LIST;
    }
}
