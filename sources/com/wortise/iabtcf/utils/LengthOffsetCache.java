package com.wortise.iabtcf.utils;

import java.util.EnumMap;

class LengthOffsetCache {
    private final BitReader bbv;
    private final EnumMap<FieldDefs, Integer> lengthCache = new EnumMap<>(FieldDefs.class);
    private final EnumMap<FieldDefs, Integer> offsetCache = new EnumMap<>(FieldDefs.class);

    public LengthOffsetCache(BitReader bitReader) {
        this.bbv = bitReader;
    }

    public Integer getLength(FieldDefs fieldDefs, Function<BitReader, Integer> function) {
        return memoize(fieldDefs, this.lengthCache, function);
    }

    public Integer getOffset(FieldDefs fieldDefs, Function<BitReader, Integer> function) {
        return memoize(fieldDefs, this.offsetCache, function);
    }

    private Integer memoize(FieldDefs fieldDefs, EnumMap<FieldDefs, Integer> enumMap, Function<BitReader, Integer> function) {
        if (!fieldDefs.isDynamic()) {
            return function.apply(this.bbv);
        }
        Integer num = enumMap.get(fieldDefs);
        if (num != null) {
            return num;
        }
        Integer apply = function.apply(this.bbv);
        enumMap.put(fieldDefs, apply);
        return apply;
    }
}
