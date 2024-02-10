package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;

final class SessionDescription {
    public static final String ATTR_CONTROL = "control";
    public static final String ATTR_FMTP = "fmtp";
    public static final String ATTR_LENGTH = "length";
    public static final String ATTR_RANGE = "range";
    public static final String ATTR_RTPMAP = "rtpmap";
    public static final String ATTR_TOOL = "tool";
    public static final String ATTR_TYPE = "type";
    public static final String SUPPORTED_SDP_VERSION = "0";
    public final ImmutableMap<String, String> attributes;
    public final int bitrate;
    public final String connection;
    public final String emailAddress;
    public final String key;
    public final ImmutableList<MediaDescription> mediaDescriptionList;
    public final String origin;
    public final String phoneNumber;
    public final String sessionInfo;
    public final String sessionName;
    public final String timing;
    public final Uri uri;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final HashMap<String, String> attributes = new HashMap<>();
        /* access modifiers changed from: private */
        public int bitrate = -1;
        /* access modifiers changed from: private */
        public String connection;
        /* access modifiers changed from: private */
        public String emailAddress;
        /* access modifiers changed from: private */
        public String key;
        /* access modifiers changed from: private */
        public final ImmutableList.Builder<MediaDescription> mediaDescriptionListBuilder = new ImmutableList.Builder<>();
        /* access modifiers changed from: private */
        public String origin;
        /* access modifiers changed from: private */
        public String phoneNumber;
        /* access modifiers changed from: private */
        public String sessionInfo;
        /* access modifiers changed from: private */
        public String sessionName;
        /* access modifiers changed from: private */
        public String timing;
        /* access modifiers changed from: private */
        public Uri uri;

        public Builder setSessionName(String str) {
            this.sessionName = str;
            return this;
        }

        public Builder setSessionInfo(String str) {
            this.sessionInfo = str;
            return this;
        }

        public Builder setUri(Uri uri2) {
            this.uri = uri2;
            return this;
        }

        public Builder setOrigin(String str) {
            this.origin = str;
            return this;
        }

        public Builder setConnection(String str) {
            this.connection = str;
            return this;
        }

        public Builder setBitrate(int i) {
            this.bitrate = i;
            return this;
        }

        public Builder setTiming(String str) {
            this.timing = str;
            return this;
        }

        public Builder setKey(String str) {
            this.key = str;
            return this;
        }

        public Builder setEmailAddress(String str) {
            this.emailAddress = str;
            return this;
        }

        public Builder setPhoneNumber(String str) {
            this.phoneNumber = str;
            return this;
        }

        public Builder addAttribute(String str, String str2) {
            this.attributes.put(str, str2);
            return this;
        }

        public Builder addMediaDescription(MediaDescription mediaDescription) {
            this.mediaDescriptionListBuilder.add((Object) mediaDescription);
            return this;
        }

        public SessionDescription build() {
            if (this.sessionName != null && this.origin != null && this.timing != null) {
                return new SessionDescription(this);
            }
            throw new IllegalStateException("One of more mandatory SDP fields are not set.");
        }
    }

    private SessionDescription(Builder builder) {
        this.attributes = ImmutableMap.copyOf(builder.attributes);
        this.mediaDescriptionList = builder.mediaDescriptionListBuilder.build();
        this.sessionName = (String) Util.castNonNull(builder.sessionName);
        this.origin = (String) Util.castNonNull(builder.origin);
        this.timing = (String) Util.castNonNull(builder.timing);
        this.uri = builder.uri;
        this.connection = builder.connection;
        this.bitrate = builder.bitrate;
        this.key = builder.key;
        this.emailAddress = builder.emailAddress;
        this.phoneNumber = builder.phoneNumber;
        this.sessionInfo = builder.sessionInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SessionDescription sessionDescription = (SessionDescription) obj;
        if (this.bitrate != sessionDescription.bitrate || !this.attributes.equals(sessionDescription.attributes) || !this.mediaDescriptionList.equals(sessionDescription.mediaDescriptionList) || !this.origin.equals(sessionDescription.origin) || !this.sessionName.equals(sessionDescription.sessionName) || !this.timing.equals(sessionDescription.timing) || !Util.areEqual(this.sessionInfo, sessionDescription.sessionInfo) || !Util.areEqual(this.uri, sessionDescription.uri) || !Util.areEqual(this.emailAddress, sessionDescription.emailAddress) || !Util.areEqual(this.phoneNumber, sessionDescription.phoneNumber) || !Util.areEqual(this.connection, sessionDescription.connection) || !Util.areEqual(this.key, sessionDescription.key)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((((((((217 + this.attributes.hashCode()) * 31) + this.mediaDescriptionList.hashCode()) * 31) + this.origin.hashCode()) * 31) + this.sessionName.hashCode()) * 31) + this.timing.hashCode()) * 31) + this.bitrate) * 31;
        String str = this.sessionInfo;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Uri uri2 = this.uri;
        int hashCode3 = (hashCode2 + (uri2 == null ? 0 : uri2.hashCode())) * 31;
        String str2 = this.emailAddress;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.phoneNumber;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.connection;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.key;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode6 + i;
    }
}
