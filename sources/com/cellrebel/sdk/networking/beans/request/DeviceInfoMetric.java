package com.cellrebel.sdk.networking.beans.request;

import com.cellrebel.sdk.database.DatabaseClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceInfoMetric extends BaseMetric {
    @SerializedName("batteryChargeType")
    @Expose
    public Integer batteryChargeType;
    @SerializedName("batteryHealth")
    @Expose
    public Integer batteryHealth;
    @SerializedName("batteryLevel")
    @Expose
    public Float batteryLevel;
    @SerializedName("batteryState")
    @Expose
    public Integer batteryState;
    @SerializedName("batteryTemperature")
    @Expose
    public Float batteryTemperature;
    @SerializedName("cpuUsage")
    @Expose
    public int cpuUsage;
    @SerializedName("deviceYear")
    @Expose
    public Integer deviceYear;
    @SerializedName("elapsedRealtimeNanos")
    @Expose
    public Long elapsedRealtimeNanos;
    @SerializedName("freeRam")
    @Expose
    public Integer freeRam;
    @SerializedName("freeStorage")
    @Expose
    public Integer freeStorage;
    @SerializedName("is4gCapable")
    @Expose
    public Boolean is4gCapable;
    @SerializedName("is5gCapable")
    @Expose
    public Boolean is5gCapable;
    @SerializedName("language")
    @Expose
    public String language;
    @SerializedName("locale")
    @Expose
    public String locale;
    @SerializedName("lteFrequencySupport")
    @Expose
    public String lteFrequencySupport;
    @SerializedName("maximumStorage")
    @Expose
    public Integer maximumStorage;
    @SerializedName("nrFrequencySupport")
    @Expose
    public String nrFrequencySupport;
    @SerializedName("ram")
    @Expose
    public Integer ram;
    @SerializedName("screenHeight")
    @Expose
    public Integer screenHeight;
    @SerializedName("screenWidth")
    @Expose
    public Integer screenWidth;
    @SerializedName("ueCategory")
    @Expose
    public String ueCategory;
    @SerializedName("userAgent")
    @Expose
    public String userAgent;
    @SerializedName("volteSupport")
    @Expose
    public Boolean volteSupport;

    public DeviceInfoMetric batteryChargeType(Integer num) {
        this.batteryChargeType = num;
        return this;
    }

    public Integer batteryChargeType() {
        return this.batteryChargeType;
    }

    public DeviceInfoMetric batteryHealth(Integer num) {
        this.batteryHealth = num;
        return this;
    }

    public Integer batteryHealth() {
        return this.batteryHealth;
    }

    public DeviceInfoMetric batteryLevel(Float f) {
        this.batteryLevel = f;
        return this;
    }

    public Float batteryLevel() {
        return this.batteryLevel;
    }

    public DeviceInfoMetric batteryState(Integer num) {
        this.batteryState = num;
        return this;
    }

    public Integer batteryState() {
        return this.batteryState;
    }

    public DeviceInfoMetric batteryTemperature(Float f) {
        this.batteryTemperature = f;
        return this;
    }

    public Float batteryTemperature() {
        return this.batteryTemperature;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof DeviceInfoMetric;
    }

    public int cpuUsage() {
        return this.cpuUsage;
    }

    public DeviceInfoMetric cpuUsage(int i) {
        this.cpuUsage = i;
        return this;
    }

    public DeviceInfoMetric deviceYear(Integer num) {
        this.deviceYear = num;
        return this;
    }

    public Integer deviceYear() {
        return this.deviceYear;
    }

    public DeviceInfoMetric elapsedRealtimeNanos(Long l) {
        this.elapsedRealtimeNanos = l;
        return this;
    }

    public Long elapsedRealtimeNanos() {
        return this.elapsedRealtimeNanos;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceInfoMetric)) {
            return false;
        }
        DeviceInfoMetric deviceInfoMetric = (DeviceInfoMetric) obj;
        if (!deviceInfoMetric.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String lteFrequencySupport2 = lteFrequencySupport();
        String lteFrequencySupport3 = deviceInfoMetric.lteFrequencySupport();
        if (lteFrequencySupport2 != null ? !lteFrequencySupport2.equals(lteFrequencySupport3) : lteFrequencySupport3 != null) {
            return false;
        }
        String nrFrequencySupport2 = nrFrequencySupport();
        String nrFrequencySupport3 = deviceInfoMetric.nrFrequencySupport();
        if (nrFrequencySupport2 != null ? !nrFrequencySupport2.equals(nrFrequencySupport3) : nrFrequencySupport3 != null) {
            return false;
        }
        String ueCategory2 = ueCategory();
        String ueCategory3 = deviceInfoMetric.ueCategory();
        if (ueCategory2 != null ? !ueCategory2.equals(ueCategory3) : ueCategory3 != null) {
            return false;
        }
        Boolean is4gCapable2 = is4gCapable();
        Boolean is4gCapable3 = deviceInfoMetric.is4gCapable();
        if (is4gCapable2 != null ? !is4gCapable2.equals(is4gCapable3) : is4gCapable3 != null) {
            return false;
        }
        Boolean is5gCapable2 = is5gCapable();
        Boolean is5gCapable3 = deviceInfoMetric.is5gCapable();
        if (is5gCapable2 != null ? !is5gCapable2.equals(is5gCapable3) : is5gCapable3 != null) {
            return false;
        }
        Boolean volteSupport2 = volteSupport();
        Boolean volteSupport3 = deviceInfoMetric.volteSupport();
        if (volteSupport2 != null ? !volteSupport2.equals(volteSupport3) : volteSupport3 != null) {
            return false;
        }
        Integer deviceYear2 = deviceYear();
        Integer deviceYear3 = deviceInfoMetric.deviceYear();
        if (deviceYear2 != null ? !deviceYear2.equals(deviceYear3) : deviceYear3 != null) {
            return false;
        }
        Integer maximumStorage2 = maximumStorage();
        Integer maximumStorage3 = deviceInfoMetric.maximumStorage();
        if (maximumStorage2 != null ? !maximumStorage2.equals(maximumStorage3) : maximumStorage3 != null) {
            return false;
        }
        Integer freeStorage2 = freeStorage();
        Integer freeStorage3 = deviceInfoMetric.freeStorage();
        if (freeStorage2 != null ? !freeStorage2.equals(freeStorage3) : freeStorage3 != null) {
            return false;
        }
        Integer ram2 = ram();
        Integer ram3 = deviceInfoMetric.ram();
        if (ram2 != null ? !ram2.equals(ram3) : ram3 != null) {
            return false;
        }
        Integer freeRam2 = freeRam();
        Integer freeRam3 = deviceInfoMetric.freeRam();
        if (freeRam2 != null ? !freeRam2.equals(freeRam3) : freeRam3 != null) {
            return false;
        }
        if (cpuUsage() != deviceInfoMetric.cpuUsage()) {
            return false;
        }
        Float batteryLevel2 = batteryLevel();
        Float batteryLevel3 = deviceInfoMetric.batteryLevel();
        if (batteryLevel2 != null ? !batteryLevel2.equals(batteryLevel3) : batteryLevel3 != null) {
            return false;
        }
        Integer batteryState2 = batteryState();
        Integer batteryState3 = deviceInfoMetric.batteryState();
        if (batteryState2 != null ? !batteryState2.equals(batteryState3) : batteryState3 != null) {
            return false;
        }
        Integer batteryChargeType2 = batteryChargeType();
        Integer batteryChargeType3 = deviceInfoMetric.batteryChargeType();
        if (batteryChargeType2 != null ? !batteryChargeType2.equals(batteryChargeType3) : batteryChargeType3 != null) {
            return false;
        }
        Integer batteryHealth2 = batteryHealth();
        Integer batteryHealth3 = deviceInfoMetric.batteryHealth();
        if (batteryHealth2 != null ? !batteryHealth2.equals(batteryHealth3) : batteryHealth3 != null) {
            return false;
        }
        Float batteryTemperature2 = batteryTemperature();
        Float batteryTemperature3 = deviceInfoMetric.batteryTemperature();
        if (batteryTemperature2 != null ? !batteryTemperature2.equals(batteryTemperature3) : batteryTemperature3 != null) {
            return false;
        }
        String language2 = language();
        String language3 = deviceInfoMetric.language();
        if (language2 != null ? !language2.equals(language3) : language3 != null) {
            return false;
        }
        String locale2 = locale();
        String locale3 = deviceInfoMetric.locale();
        if (locale2 != null ? !locale2.equals(locale3) : locale3 != null) {
            return false;
        }
        String userAgent2 = userAgent();
        String userAgent3 = deviceInfoMetric.userAgent();
        if (userAgent2 != null ? !userAgent2.equals(userAgent3) : userAgent3 != null) {
            return false;
        }
        Integer screenWidth2 = screenWidth();
        Integer screenWidth3 = deviceInfoMetric.screenWidth();
        if (screenWidth2 != null ? !screenWidth2.equals(screenWidth3) : screenWidth3 != null) {
            return false;
        }
        Integer screenHeight2 = screenHeight();
        Integer screenHeight3 = deviceInfoMetric.screenHeight();
        if (screenHeight2 != null ? !screenHeight2.equals(screenHeight3) : screenHeight3 != null) {
            return false;
        }
        Long elapsedRealtimeNanos2 = elapsedRealtimeNanos();
        Long elapsedRealtimeNanos3 = deviceInfoMetric.elapsedRealtimeNanos();
        return elapsedRealtimeNanos2 != null ? elapsedRealtimeNanos2.equals(elapsedRealtimeNanos3) : elapsedRealtimeNanos3 == null;
    }

    public DeviceInfoMetric freeRam(Integer num) {
        this.freeRam = num;
        return this;
    }

    public Integer freeRam() {
        return this.freeRam;
    }

    public DeviceInfoMetric freeStorage(Integer num) {
        this.freeStorage = num;
        return this;
    }

    public Integer freeStorage() {
        return this.freeStorage;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String lteFrequencySupport2 = lteFrequencySupport();
        int i = 43;
        int hashCode2 = (hashCode * 59) + (lteFrequencySupport2 == null ? 43 : lteFrequencySupport2.hashCode());
        String nrFrequencySupport2 = nrFrequencySupport();
        int hashCode3 = (hashCode2 * 59) + (nrFrequencySupport2 == null ? 43 : nrFrequencySupport2.hashCode());
        String ueCategory2 = ueCategory();
        int hashCode4 = (hashCode3 * 59) + (ueCategory2 == null ? 43 : ueCategory2.hashCode());
        Boolean is4gCapable2 = is4gCapable();
        int hashCode5 = (hashCode4 * 59) + (is4gCapable2 == null ? 43 : is4gCapable2.hashCode());
        Boolean is5gCapable2 = is5gCapable();
        int hashCode6 = (hashCode5 * 59) + (is5gCapable2 == null ? 43 : is5gCapable2.hashCode());
        Boolean volteSupport2 = volteSupport();
        int hashCode7 = (hashCode6 * 59) + (volteSupport2 == null ? 43 : volteSupport2.hashCode());
        Integer deviceYear2 = deviceYear();
        int hashCode8 = (hashCode7 * 59) + (deviceYear2 == null ? 43 : deviceYear2.hashCode());
        Integer maximumStorage2 = maximumStorage();
        int hashCode9 = (hashCode8 * 59) + (maximumStorage2 == null ? 43 : maximumStorage2.hashCode());
        Integer freeStorage2 = freeStorage();
        int hashCode10 = (hashCode9 * 59) + (freeStorage2 == null ? 43 : freeStorage2.hashCode());
        Integer ram2 = ram();
        int hashCode11 = (hashCode10 * 59) + (ram2 == null ? 43 : ram2.hashCode());
        Integer freeRam2 = freeRam();
        int hashCode12 = (((hashCode11 * 59) + (freeRam2 == null ? 43 : freeRam2.hashCode())) * 59) + cpuUsage();
        Float batteryLevel2 = batteryLevel();
        int hashCode13 = (hashCode12 * 59) + (batteryLevel2 == null ? 43 : batteryLevel2.hashCode());
        Integer batteryState2 = batteryState();
        int hashCode14 = (hashCode13 * 59) + (batteryState2 == null ? 43 : batteryState2.hashCode());
        Integer batteryChargeType2 = batteryChargeType();
        int hashCode15 = (hashCode14 * 59) + (batteryChargeType2 == null ? 43 : batteryChargeType2.hashCode());
        Integer batteryHealth2 = batteryHealth();
        int hashCode16 = (hashCode15 * 59) + (batteryHealth2 == null ? 43 : batteryHealth2.hashCode());
        Float batteryTemperature2 = batteryTemperature();
        int hashCode17 = (hashCode16 * 59) + (batteryTemperature2 == null ? 43 : batteryTemperature2.hashCode());
        String language2 = language();
        int hashCode18 = (hashCode17 * 59) + (language2 == null ? 43 : language2.hashCode());
        String locale2 = locale();
        int hashCode19 = (hashCode18 * 59) + (locale2 == null ? 43 : locale2.hashCode());
        String userAgent2 = userAgent();
        int hashCode20 = (hashCode19 * 59) + (userAgent2 == null ? 43 : userAgent2.hashCode());
        Integer screenWidth2 = screenWidth();
        int hashCode21 = (hashCode20 * 59) + (screenWidth2 == null ? 43 : screenWidth2.hashCode());
        Integer screenHeight2 = screenHeight();
        int hashCode22 = (hashCode21 * 59) + (screenHeight2 == null ? 43 : screenHeight2.hashCode());
        Long elapsedRealtimeNanos2 = elapsedRealtimeNanos();
        int i2 = hashCode22 * 59;
        if (elapsedRealtimeNanos2 != null) {
            i = elapsedRealtimeNanos2.hashCode();
        }
        return i2 + i;
    }

    public DeviceInfoMetric is4gCapable(Boolean bool) {
        this.is4gCapable = bool;
        return this;
    }

    public Boolean is4gCapable() {
        return this.is4gCapable;
    }

    public DeviceInfoMetric is5gCapable(Boolean bool) {
        this.is5gCapable = bool;
        return this;
    }

    public Boolean is5gCapable() {
        return this.is5gCapable;
    }

    public DeviceInfoMetric language(String str) {
        this.language = str;
        return this;
    }

    public String language() {
        return this.language;
    }

    public DeviceInfoMetric locale(String str) {
        this.locale = str;
        return this;
    }

    public String locale() {
        return this.locale;
    }

    public DeviceInfoMetric lteFrequencySupport(String str) {
        this.lteFrequencySupport = str;
        return this;
    }

    public String lteFrequencySupport() {
        return this.lteFrequencySupport;
    }

    public DeviceInfoMetric maximumStorage(Integer num) {
        this.maximumStorage = num;
        return this;
    }

    public Integer maximumStorage() {
        return this.maximumStorage;
    }

    public DeviceInfoMetric nrFrequencySupport(String str) {
        this.nrFrequencySupport = str;
        return this;
    }

    public String nrFrequencySupport() {
        return this.nrFrequencySupport;
    }

    public DeviceInfoMetric ram(Integer num) {
        this.ram = num;
        return this;
    }

    public Integer ram() {
        return this.ram;
    }

    public void save() {
        try {
            if (DatabaseClient.a() != null) {
                DatabaseClient.a().g().a(this);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public DeviceInfoMetric screenHeight(Integer num) {
        this.screenHeight = num;
        return this;
    }

    public Integer screenHeight() {
        return this.screenHeight;
    }

    public DeviceInfoMetric screenWidth(Integer num) {
        this.screenWidth = num;
        return this;
    }

    public Integer screenWidth() {
        return this.screenWidth;
    }

    public String toString() {
        return "DeviceInfoMetric(super=" + super.toString() + ", lteFrequencySupport=" + lteFrequencySupport() + ", nrFrequencySupport=" + nrFrequencySupport() + ", ueCategory=" + ueCategory() + ", is4gCapable=" + is4gCapable() + ", is5gCapable=" + is5gCapable() + ", volteSupport=" + volteSupport() + ", deviceYear=" + deviceYear() + ", maximumStorage=" + maximumStorage() + ", freeStorage=" + freeStorage() + ", ram=" + ram() + ", freeRam=" + freeRam() + ", cpuUsage=" + cpuUsage() + ", batteryLevel=" + batteryLevel() + ", batteryState=" + batteryState() + ", batteryChargeType=" + batteryChargeType() + ", batteryHealth=" + batteryHealth() + ", batteryTemperature=" + batteryTemperature() + ", language=" + language() + ", locale=" + locale() + ", userAgent=" + userAgent() + ", screenWidth=" + screenWidth() + ", screenHeight=" + screenHeight() + ", elapsedRealtimeNanos=" + elapsedRealtimeNanos() + ")";
    }

    public DeviceInfoMetric ueCategory(String str) {
        this.ueCategory = str;
        return this;
    }

    public String ueCategory() {
        return this.ueCategory;
    }

    public DeviceInfoMetric userAgent(String str) {
        this.userAgent = str;
        return this;
    }

    public String userAgent() {
        return this.userAgent;
    }

    public DeviceInfoMetric volteSupport(Boolean bool) {
        this.volteSupport = bool;
        return this;
    }

    public Boolean volteSupport() {
        return this.volteSupport;
    }
}
