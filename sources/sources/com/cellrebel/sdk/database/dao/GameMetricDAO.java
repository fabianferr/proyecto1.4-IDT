package com.cellrebel.sdk.database.dao;

import com.cellrebel.sdk.networking.beans.request.GameInfoMetric;
import java.util.List;

public interface GameMetricDAO {
    List<GameInfoMetric> a(String str, Integer num, boolean z);

    void a(GameInfoMetric gameInfoMetric);

    void a(String str, String str2, boolean z);

    void a(List<GameInfoMetric> list);

    List<GameInfoMetric> b();

    List<GameInfoMetric> b(String str, String str2, boolean z);

    void b(GameInfoMetric gameInfoMetric);

    List<GameInfoMetric> getAll();
}
