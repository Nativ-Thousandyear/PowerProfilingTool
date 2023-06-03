package com.example.powerprofilingtool;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView batteryPercentageTextView;
    private PowerProfile powerProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryPercentageTextView = findViewById(R.id.battery_percentage_textview);
        powerProfile = new PowerProfile();

        updateBatteryPercentage();
    }

    private void updateBatteryPercentage() {
        double batteryCapacity = powerProfile.getBatteryCapacity();
        int batteryPercentage = (int) ((getBatteryLevel() / batteryCapacity) * 100);

        String batteryPercentageText = getString(R.string.battery_percentage, batteryPercentage);
        batteryPercentageTextView.setText(batteryPercentageText);
    }

    private double getBatteryLevel() {
        BatteryManager batteryManager = (BatteryManager) getSystemService(Context.BATTERY_SERVICE);
        return batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
    }
}

