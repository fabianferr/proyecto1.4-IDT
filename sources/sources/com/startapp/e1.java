package com.startapp;

import android.bluetooth.BluetoothDevice;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Sta */
public class e1 {
    public Set<BluetoothDevice> a;
    public Set<BluetoothDevice> b;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Set<BluetoothDevice> set = this.a;
            if (set != null && set.size() > 0) {
                jSONObject.put("paired", a(this.a));
            }
            Set<BluetoothDevice> set2 = this.b;
            if (set2 != null && set2.size() > 0) {
                jSONObject.put("available", a(this.b));
            }
        } catch (Exception unused) {
        }
        if (jSONObject.length() > 0) {
            return jSONObject;
        }
        return null;
    }

    public final JSONArray a(Set<BluetoothDevice> set) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (BluetoothDevice next : set) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bluetoothClass", next.getBluetoothClass().getDeviceClass());
                jSONObject.put("name", next.getName());
                jSONObject.put("mac", next.getAddress());
                jSONObject.put("bondState", next.getBondState());
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (Exception unused) {
            return null;
        }
    }
}
