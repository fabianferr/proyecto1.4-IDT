package com.cellrebel.sdk.networking.beans.request;

import com.cellrebel.sdk.database.DatabaseClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VoiceCallMetric extends BaseMetric {
    @SerializedName("callEndTime")
    @Expose
    public int callEndTime;
    @SerializedName("callStartTime")
    @Expose
    public int callStartTime;

    public int callEndTime() {
        return this.callEndTime;
    }

    public VoiceCallMetric callEndTime(int i) {
        this.callEndTime = i;
        return this;
    }

    public int callStartTime() {
        return this.callStartTime;
    }

    public VoiceCallMetric callStartTime(int i) {
        this.callStartTime = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof VoiceCallMetric;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoiceCallMetric)) {
            return false;
        }
        VoiceCallMetric voiceCallMetric = (VoiceCallMetric) obj;
        return voiceCallMetric.canEqual(this) && super.equals(obj) && callStartTime() == voiceCallMetric.callStartTime() && callEndTime() == voiceCallMetric.callEndTime();
    }

    public int hashCode() {
        return (((super.hashCode() * 59) + callStartTime()) * 59) + callEndTime();
    }

    public void save() {
        try {
            if (DatabaseClient.a() != null) {
                DatabaseClient.a().w().a(this);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public String toString() {
        return "VoiceCallMetric(super=" + super.toString() + ", callStartTime=" + callStartTime() + ", callEndTime=" + callEndTime() + ")";
    }
}
