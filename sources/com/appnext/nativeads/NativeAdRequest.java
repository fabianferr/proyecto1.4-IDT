package com.appnext.nativeads;

import com.appnext.base.a;
import com.appnext.core.c;

public class NativeAdRequest extends c {
    private String categories = "";
    private CreativeType creativeType = CreativeType.ALL;
    private CachingPolicy fi = CachingPolicy.ALL;
    private VideoLength fj = VideoLength.DEFAULT;
    private VideoQuality fk = VideoQuality.DEFAULT;
    private String mSpecificCategories = "";
    private int maxVideoLength = 0;
    private int minVideoLength = 0;
    private String postback = "";

    public enum CreativeType {
        STATIC_ONLY,
        VIDEO_ONLY,
        ALL
    }

    public NativeAdRequest() {
    }

    NativeAdRequest(NativeAdRequest nativeAdRequest) {
        this.categories = nativeAdRequest.categories;
        this.mSpecificCategories = nativeAdRequest.mSpecificCategories;
        this.postback = nativeAdRequest.postback;
        this.fi = nativeAdRequest.fi;
        this.creativeType = nativeAdRequest.creativeType;
        this.fj = nativeAdRequest.fj;
        this.fk = nativeAdRequest.fk;
    }

    public String getCategories() {
        return this.categories;
    }

    public NativeAdRequest setCategories(String str) {
        this.categories = str;
        return this;
    }

    public String getSpecificCategories() {
        return this.mSpecificCategories;
    }

    public NativeAdRequest setSpecificCategories(String str) {
        this.mSpecificCategories = str;
        return this;
    }

    public String getPostback() {
        return this.postback;
    }

    public NativeAdRequest setPostback(String str) {
        this.postback = str;
        return this;
    }

    public CachingPolicy getCachingPolicy() {
        return this.fi;
    }

    public NativeAdRequest setCachingPolicy(CachingPolicy cachingPolicy) {
        this.fi = cachingPolicy;
        return this;
    }

    public CreativeType getCreativeType() {
        return this.creativeType;
    }

    public NativeAdRequest setCreativeType(CreativeType creativeType2) {
        this.creativeType = creativeType2;
        return this;
    }

    public VideoLength getVideoLength() {
        return this.fj;
    }

    public NativeAdRequest setVideoLength(VideoLength videoLength) {
        this.fj = videoLength;
        return this;
    }

    public VideoQuality getVideoQuality() {
        return this.fk;
    }

    public NativeAdRequest setVideoQuality(VideoQuality videoQuality) {
        this.fk = videoQuality;
        return this;
    }

    public NativeAdRequest setMaxVideoLength(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Max Length must be higher than 0");
        } else if (i <= 0 || getMinVideoLength() <= 0 || i >= getMinVideoLength()) {
            this.maxVideoLength = i;
            return this;
        } else {
            throw new IllegalArgumentException("Max Length cannot be lower than min length");
        }
    }

    public int getMaxVideoLength() {
        return this.maxVideoLength;
    }

    public NativeAdRequest setMinVideoLength(int i) {
        if (i < 0 || (i > 0 && getMaxVideoLength() > 0 && i > getMaxVideoLength())) {
            this.minVideoLength = 0;
        } else {
            this.minVideoLength = i;
        }
        return this;
    }

    public int getMinVideoLength() {
        return this.minVideoLength;
    }

    public enum CachingPolicy {
        NOTHING(0),
        STATIC_ONLY(1),
        VIDEO_ONLY(2),
        ALL(3);
        
        private int value;

        private CachingPolicy(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public static CachingPolicy fromInt(int i) {
            for (CachingPolicy cachingPolicy : values()) {
                if (cachingPolicy.getValue() == i) {
                    return cachingPolicy;
                }
            }
            return null;
        }
    }

    public enum VideoQuality {
        DEFAULT(0),
        HIGH(1),
        LOW(2);
        
        private int value;

        private VideoQuality(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public static VideoQuality fromInt(int i) {
            for (VideoQuality videoQuality : values()) {
                if (videoQuality.getValue() == i) {
                    return videoQuality;
                }
            }
            return null;
        }
    }

    public enum VideoLength {
        DEFAULT(0),
        LONG(1),
        SHORT(2);
        
        private int value;

        private VideoLength(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public static VideoLength fromInt(int i) {
            try {
                for (VideoLength videoLength : values()) {
                    if (videoLength.getValue() == i) {
                        return videoLength;
                    }
                }
                return null;
            } catch (Throwable th) {
                a.a("NativeAdRequest$VideoLength", th);
                return null;
            }
        }
    }
}
