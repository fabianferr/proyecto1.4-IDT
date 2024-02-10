package com.cellrebel.sdk.networking.beans.request;

import com.cellrebel.sdk.database.DatabaseClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConnectionMetric extends BaseMetric {
    @SerializedName("callSetUpTimeTotal")
    @Expose
    public int callSetUpTimeTotal;
    @SerializedName("callsBlocksTotal")
    @Expose
    public int callsBlocksTotal;
    @SerializedName("callsDropsTotal")
    @Expose
    public int callsDropsTotal;
    @SerializedName("callsTotal")
    @Expose
    public int callsTotal;
    @SerializedName("connectionTimeActive2g")
    @Expose
    public int connectionTimeActive2g;
    @SerializedName("connectionTimeActive3g")
    @Expose
    public int connectionTimeActive3g;
    @SerializedName("connectionTimeActive4g")
    @Expose
    public int connectionTimeActive4g;
    @SerializedName("connectionTimeActive5g")
    @Expose
    public int connectionTimeActive5g;
    @SerializedName("connectionTimeActiveWifi")
    @Expose
    public int connectionTimeActiveWifi;
    @SerializedName("connectionTimePassive2g")
    @Expose
    public int connectionTimePassive2g;
    @SerializedName("connectionTimePassive3g")
    @Expose
    public int connectionTimePassive3g;
    @SerializedName("connectionTimePassive4g")
    @Expose
    public int connectionTimePassive4g;
    @SerializedName("connectionTimePassive5g")
    @Expose
    public int connectionTimePassive5g;
    @SerializedName("connectionTimePassiveWifi")
    @Expose
    public int connectionTimePassiveWifi;
    @SerializedName("noConnectionTimeActive")
    @Expose
    public int noConnectionTimeActive;
    @SerializedName("noConnectionTimePassive")
    @Expose
    public int noConnectionTimePassive;
    @SerializedName("pageFailsToLoadTotal")
    @Expose
    public int pageFailsToLoadTotal;
    @SerializedName("totalTimeActive")
    @Expose
    public int totalTimeActive;
    @SerializedName("totalTimePassive")
    @Expose
    public int totalTimePassive;
    @SerializedName("videoFailsToStartTotal")
    @Expose
    public int videoFailsToStartTotal;

    public int callSetUpTimeTotal() {
        return this.callSetUpTimeTotal;
    }

    public ConnectionMetric callSetUpTimeTotal(int i) {
        this.callSetUpTimeTotal = i;
        return this;
    }

    public int callsBlocksTotal() {
        return this.callsBlocksTotal;
    }

    public ConnectionMetric callsBlocksTotal(int i) {
        this.callsBlocksTotal = i;
        return this;
    }

    public int callsDropsTotal() {
        return this.callsDropsTotal;
    }

    public ConnectionMetric callsDropsTotal(int i) {
        this.callsDropsTotal = i;
        return this;
    }

    public int callsTotal() {
        return this.callsTotal;
    }

    public ConnectionMetric callsTotal(int i) {
        this.callsTotal = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof ConnectionMetric;
    }

    public int connectionTimeActive2g() {
        return this.connectionTimeActive2g;
    }

    public ConnectionMetric connectionTimeActive2g(int i) {
        this.connectionTimeActive2g = i;
        return this;
    }

    public int connectionTimeActive3g() {
        return this.connectionTimeActive3g;
    }

    public ConnectionMetric connectionTimeActive3g(int i) {
        this.connectionTimeActive3g = i;
        return this;
    }

    public int connectionTimeActive4g() {
        return this.connectionTimeActive4g;
    }

    public ConnectionMetric connectionTimeActive4g(int i) {
        this.connectionTimeActive4g = i;
        return this;
    }

    public int connectionTimeActive5g() {
        return this.connectionTimeActive5g;
    }

    public ConnectionMetric connectionTimeActive5g(int i) {
        this.connectionTimeActive5g = i;
        return this;
    }

    public int connectionTimeActiveWifi() {
        return this.connectionTimeActiveWifi;
    }

    public ConnectionMetric connectionTimeActiveWifi(int i) {
        this.connectionTimeActiveWifi = i;
        return this;
    }

    public int connectionTimePassive2g() {
        return this.connectionTimePassive2g;
    }

    public ConnectionMetric connectionTimePassive2g(int i) {
        this.connectionTimePassive2g = i;
        return this;
    }

    public int connectionTimePassive3g() {
        return this.connectionTimePassive3g;
    }

    public ConnectionMetric connectionTimePassive3g(int i) {
        this.connectionTimePassive3g = i;
        return this;
    }

    public int connectionTimePassive4g() {
        return this.connectionTimePassive4g;
    }

    public ConnectionMetric connectionTimePassive4g(int i) {
        this.connectionTimePassive4g = i;
        return this;
    }

    public int connectionTimePassive5g() {
        return this.connectionTimePassive5g;
    }

    public ConnectionMetric connectionTimePassive5g(int i) {
        this.connectionTimePassive5g = i;
        return this;
    }

    public int connectionTimePassiveWifi() {
        return this.connectionTimePassiveWifi;
    }

    public ConnectionMetric connectionTimePassiveWifi(int i) {
        this.connectionTimePassiveWifi = i;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionMetric)) {
            return false;
        }
        ConnectionMetric connectionMetric = (ConnectionMetric) obj;
        return connectionMetric.canEqual(this) && super.equals(obj) && videoFailsToStartTotal() == connectionMetric.videoFailsToStartTotal() && pageFailsToLoadTotal() == connectionMetric.pageFailsToLoadTotal() && callsTotal() == connectionMetric.callsTotal() && callsBlocksTotal() == connectionMetric.callsBlocksTotal() && callsDropsTotal() == connectionMetric.callsDropsTotal() && callSetUpTimeTotal() == connectionMetric.callSetUpTimeTotal() && connectionTimePassive2g() == connectionMetric.connectionTimePassive2g() && connectionTimePassive3g() == connectionMetric.connectionTimePassive3g() && connectionTimePassive4g() == connectionMetric.connectionTimePassive4g() && connectionTimePassive5g() == connectionMetric.connectionTimePassive5g() && connectionTimePassiveWifi() == connectionMetric.connectionTimePassiveWifi() && noConnectionTimePassive() == connectionMetric.noConnectionTimePassive() && totalTimePassive() == connectionMetric.totalTimePassive() && connectionTimeActive2g() == connectionMetric.connectionTimeActive2g() && connectionTimeActive3g() == connectionMetric.connectionTimeActive3g() && connectionTimeActive4g() == connectionMetric.connectionTimeActive4g() && connectionTimeActive5g() == connectionMetric.connectionTimeActive5g() && connectionTimeActiveWifi() == connectionMetric.connectionTimeActiveWifi() && noConnectionTimeActive() == connectionMetric.noConnectionTimeActive() && totalTimeActive() == connectionMetric.totalTimeActive();
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((super.hashCode() * 59) + videoFailsToStartTotal()) * 59) + pageFailsToLoadTotal()) * 59) + callsTotal()) * 59) + callsBlocksTotal()) * 59) + callsDropsTotal()) * 59) + callSetUpTimeTotal()) * 59) + connectionTimePassive2g()) * 59) + connectionTimePassive3g()) * 59) + connectionTimePassive4g()) * 59) + connectionTimePassive5g()) * 59) + connectionTimePassiveWifi()) * 59) + noConnectionTimePassive()) * 59) + totalTimePassive()) * 59) + connectionTimeActive2g()) * 59) + connectionTimeActive3g()) * 59) + connectionTimeActive4g()) * 59) + connectionTimeActive5g()) * 59) + connectionTimeActiveWifi()) * 59) + noConnectionTimeActive()) * 59) + totalTimeActive();
    }

    public int noConnectionTimeActive() {
        return this.noConnectionTimeActive;
    }

    public ConnectionMetric noConnectionTimeActive(int i) {
        this.noConnectionTimeActive = i;
        return this;
    }

    public int noConnectionTimePassive() {
        return this.noConnectionTimePassive;
    }

    public ConnectionMetric noConnectionTimePassive(int i) {
        this.noConnectionTimePassive = i;
        return this;
    }

    public int pageFailsToLoadTotal() {
        return this.pageFailsToLoadTotal;
    }

    public ConnectionMetric pageFailsToLoadTotal(int i) {
        this.pageFailsToLoadTotal = i;
        return this;
    }

    public void save() {
        try {
            if (DatabaseClient.a() != null) {
                DatabaseClient.a().b().a(this);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public String toString() {
        return "ConnectionMetric(super=" + super.toString() + ", videoFailsToStartTotal=" + videoFailsToStartTotal() + ", pageFailsToLoadTotal=" + pageFailsToLoadTotal() + ", callsTotal=" + callsTotal() + ", callsBlocksTotal=" + callsBlocksTotal() + ", callsDropsTotal=" + callsDropsTotal() + ", callSetUpTimeTotal=" + callSetUpTimeTotal() + ", connectionTimePassive2g=" + connectionTimePassive2g() + ", connectionTimePassive3g=" + connectionTimePassive3g() + ", connectionTimePassive4g=" + connectionTimePassive4g() + ", connectionTimePassive5g=" + connectionTimePassive5g() + ", connectionTimePassiveWifi=" + connectionTimePassiveWifi() + ", noConnectionTimePassive=" + noConnectionTimePassive() + ", totalTimePassive=" + totalTimePassive() + ", connectionTimeActive2g=" + connectionTimeActive2g() + ", connectionTimeActive3g=" + connectionTimeActive3g() + ", connectionTimeActive4g=" + connectionTimeActive4g() + ", connectionTimeActive5g=" + connectionTimeActive5g() + ", connectionTimeActiveWifi=" + connectionTimeActiveWifi() + ", noConnectionTimeActive=" + noConnectionTimeActive() + ", totalTimeActive=" + totalTimeActive() + ")";
    }

    public int totalTimeActive() {
        return this.totalTimeActive;
    }

    public ConnectionMetric totalTimeActive(int i) {
        this.totalTimeActive = i;
        return this;
    }

    public int totalTimePassive() {
        return this.totalTimePassive;
    }

    public ConnectionMetric totalTimePassive(int i) {
        this.totalTimePassive = i;
        return this;
    }

    public int videoFailsToStartTotal() {
        return this.videoFailsToStartTotal;
    }

    public ConnectionMetric videoFailsToStartTotal(int i) {
        this.videoFailsToStartTotal = i;
        return this;
    }
}
