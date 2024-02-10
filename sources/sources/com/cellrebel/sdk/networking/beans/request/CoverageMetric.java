package com.cellrebel.sdk.networking.beans.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CoverageMetric extends BaseMetric {
    @SerializedName("cellInfoMetrics")
    @Expose
    public List<CellInfoMetric> cellInfoMetrics;
    public String cellInfoMetricsJSON;

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof CoverageMetric;
    }

    public CoverageMetric cellInfoMetrics(List<CellInfoMetric> list) {
        this.cellInfoMetrics = list;
        return this;
    }

    public List<CellInfoMetric> cellInfoMetrics() {
        return this.cellInfoMetrics;
    }

    public CoverageMetric cellInfoMetricsJSON(String str) {
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
        if (!(obj instanceof CoverageMetric)) {
            return false;
        }
        CoverageMetric coverageMetric = (CoverageMetric) obj;
        if (!coverageMetric.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        List<CellInfoMetric> cellInfoMetrics2 = cellInfoMetrics();
        List<CellInfoMetric> cellInfoMetrics3 = coverageMetric.cellInfoMetrics();
        if (cellInfoMetrics2 != null ? !cellInfoMetrics2.equals(cellInfoMetrics3) : cellInfoMetrics3 != null) {
            return false;
        }
        String cellInfoMetricsJSON2 = cellInfoMetricsJSON();
        String cellInfoMetricsJSON3 = coverageMetric.cellInfoMetricsJSON();
        return cellInfoMetricsJSON2 != null ? cellInfoMetricsJSON2.equals(cellInfoMetricsJSON3) : cellInfoMetricsJSON3 == null;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        List<CellInfoMetric> cellInfoMetrics2 = cellInfoMetrics();
        int i = 43;
        int hashCode2 = (hashCode * 59) + (cellInfoMetrics2 == null ? 43 : cellInfoMetrics2.hashCode());
        String cellInfoMetricsJSON2 = cellInfoMetricsJSON();
        int i2 = hashCode2 * 59;
        if (cellInfoMetricsJSON2 != null) {
            i = cellInfoMetricsJSON2.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "CoverageMetric(super=" + super.toString() + ", cellInfoMetrics=" + cellInfoMetrics() + ", cellInfoMetricsJSON=" + cellInfoMetricsJSON() + ")";
    }
}
