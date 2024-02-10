package com.cellrebel.sdk.networking.beans.response;

import com.cellrebel.sdk.trafficprofile.models.TrafficProfileConfig;
import com.cellrebel.sdk.trafficprofile.models.TrafficProfileSegment;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class TrafficProfiles {
    @SerializedName("downlinkProfile")
    @Expose
    private Profile downlinkProfile;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("uplinkProfile")
    @Expose
    private Profile uplinkProfile;
    @SerializedName("weight")
    @Expose
    private int weight;

    public class Flow {
        @SerializedName("id")
        @Expose
        public int id;
        @SerializedName("segments")
        @Expose
        public List<Segment> segments;

        public Flow() {
        }

        public List<TrafficProfileSegment> map() {
            ArrayList arrayList = new ArrayList();
            for (Segment next : this.segments) {
                arrayList.add(new TrafficProfileSegment(next.id, next.packetSize, next.interval, next.quantity));
            }
            return arrayList;
        }
    }

    public class Profile {
        @SerializedName("flows")
        @Expose
        public List<Flow> flows;
        @SerializedName("id")
        @Expose
        public int id;
        @SerializedName("type")
        @Expose
        public String type;

        public Profile() {
        }

        public List<TrafficProfileConfig> map() {
            ArrayList arrayList = new ArrayList();
            for (Flow next : this.flows) {
                arrayList.add(new TrafficProfileConfig(next.id, next.map()));
            }
            return arrayList;
        }
    }

    public class Segment {
        @SerializedName("id")
        @Expose
        public int id;
        @SerializedName("interval")
        @Expose
        public int interval;
        @SerializedName("packetSize")
        @Expose
        public int packetSize;
        @SerializedName("quantity")
        @Expose
        public int quantity;

        public Segment() {
        }
    }

    public Profile getDownlinkProfile() {
        return this.downlinkProfile;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Profile getUplinkProfile() {
        return this.uplinkProfile;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setDownlinkProfile(Profile profile) {
        this.downlinkProfile = profile;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUplinkProfile(Profile profile) {
        this.uplinkProfile = profile;
    }

    public void setWeight(int i) {
        this.weight = i;
    }
}
