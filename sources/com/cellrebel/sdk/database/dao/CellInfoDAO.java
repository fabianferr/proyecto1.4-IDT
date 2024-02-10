package com.cellrebel.sdk.database.dao;

import com.cellrebel.sdk.networking.beans.request.CellInfoMetric;
import java.util.List;

public interface CellInfoDAO {
    void a();

    void a(CellInfoMetric cellInfoMetric);

    void a(List<CellInfoMetric> list);

    List<CellInfoMetric> getAll();
}
