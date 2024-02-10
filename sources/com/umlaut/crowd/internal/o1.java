package com.umlaut.crowd.internal;

public class o1 {
    private static final String[] a = {"/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/virtual/thermal/thermal_zone2/temp", "/sys/devices/virtual/thermal/thermal_zone3/temp", "/sys/devices/virtual/thermal/thermal_zone4/temp", "/sys/class/thermal/thermal_zone0/temp", "/sys/class/thermal/thermal_zone1/temp", "/sys/class/thermal/thermal_zone2/temp", "/sys/class/thermal/thermal_zone3/temp", "/sys/class/thermal/thermal_zone4/temp", "/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/ext_temperature", "/sys/devices/platform/tegra-tsensor/tsensor_temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/s5p-tmu/temperature", "/sys/devices/platform/s5p-tmu/curr_temp", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/class/hwmon/hwmon0/temp1_input", "/sys/class/hwmon/hwmonX/temp1_input", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/htc/cpu_temp"};

    public static double a() {
        String[] strArr = a;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String[] a2 = i9.a(strArr[i]);
            if (a2.length > 0) {
                try {
                    double parseDouble = Double.parseDouble(a2[0]);
                    return parseDouble >= 1000.0d ? parseDouble / 1000.0d : parseDouble;
                } catch (NumberFormatException unused) {
                }
            } else {
                i++;
            }
        }
        return 0.0d;
    }
}
