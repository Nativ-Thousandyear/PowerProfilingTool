package com.example.powerprofilingtool;

import android.os.Build;

import java.util.HashMap;
import java.util.Map;

public class PowerProfile {
    private final Map<String, Double> powerValues;

    public PowerProfile() {
        powerValues = new HashMap<>();
        powerValues.put(Build.DEVICE, 500.0); // Example power value for the device
        // Add more power values for different components if needed
    }

    public double getBatteryCapacity() {
        String device = Build.DEVICE;
        if (powerValues.containsKey(device)) {
            Double powerValue = powerValues.get(device);
            if (powerValue != null) {
                return powerValue;
            }
        }
        return 0.0; // Default value if power value for the device is not found or null
    }
}
