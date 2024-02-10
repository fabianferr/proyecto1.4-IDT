package com.startapp.sdk.adsbase;

import com.mbridge.msdk.c.f;
import com.startapp.p0;
import java.io.Serializable;

/* compiled from: Sta */
public class SDKAdPreferences implements Serializable {
    private static final long serialVersionUID = 2055046185195723724L;
    private String age = null;
    private Gender gender = null;

    /* compiled from: Sta */
    public enum Gender {
        MALE("m"),
        FEMALE(f.a);
        
        private String gender;

        private Gender(String str) {
            this.gender = str;
        }

        public static Gender parseString(String str) {
            for (Gender gender2 : values()) {
                if (gender2.getGender().equals(str)) {
                    return gender2;
                }
            }
            return null;
        }

        public String getGender() {
            return this.gender;
        }

        public String toString() {
            return getGender();
        }
    }

    public String getAge() {
        return this.age;
    }

    public Gender getGender() {
        return this.gender;
    }

    public SDKAdPreferences setAge(int i) {
        this.age = Integer.toString(i);
        return this;
    }

    public SDKAdPreferences setGender(Gender gender2) {
        this.gender = gender2;
        return this;
    }

    public String toString() {
        StringBuilder a = p0.a("SDKAdPreferences [gender=");
        a.append(this.gender);
        a.append(", age=");
        a.append(this.age);
        a.append("]");
        return a.toString();
    }

    public SDKAdPreferences setAge(String str) {
        this.age = str;
        return this;
    }
}
