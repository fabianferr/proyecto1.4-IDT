package com.cellrebel.sdk.networking.beans.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GameMetric extends BaseMetric {
    public String cellInfoMetricsJSON;
    @SerializedName("gameMetrics")
    @Expose
    public List<GameInfoMetric> games;

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof GameMetric;
    }

    public GameMetric cellInfoMetricsJSON(String str) {
        this.cellInfoMetricsJSON = str;
        return this;
    }

    public String cellInfoMetricsJSON() {
        return this.cellInfoMetricsJSON;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GameMetric)) {
            return false;
        }
        GameMetric gameMetric = (GameMetric) obj;
        if (!gameMetric.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        List<GameInfoMetric> games2 = games();
        List<GameInfoMetric> games3 = gameMetric.games();
        if (games2 != null ? !games2.equals(games3) : games3 != null) {
            return false;
        }
        String cellInfoMetricsJSON2 = cellInfoMetricsJSON();
        String cellInfoMetricsJSON3 = gameMetric.cellInfoMetricsJSON();
        return cellInfoMetricsJSON2 != null ? cellInfoMetricsJSON2.equals(cellInfoMetricsJSON3) : cellInfoMetricsJSON3 == null;
    }

    public GameMetric games(List<GameInfoMetric> list) {
        this.games = list;
        return this;
    }

    public List<GameInfoMetric> games() {
        return this.games;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        List<GameInfoMetric> games2 = games();
        int i = 43;
        int hashCode2 = (hashCode * 59) + (games2 == null ? 43 : games2.hashCode());
        String cellInfoMetricsJSON2 = cellInfoMetricsJSON();
        int i2 = hashCode2 * 59;
        if (cellInfoMetricsJSON2 != null) {
            i = cellInfoMetricsJSON2.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "GameMetric(super=" + super.toString() + ", games=" + games() + ", cellInfoMetricsJSON=" + cellInfoMetricsJSON() + ")";
    }
}
