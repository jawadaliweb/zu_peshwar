package com.lmkt.zupeshawar.Utilities;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.app.ActivityCompat;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.UUID;

public class HandyUtils {
    public static void hideKeyboardFrom(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static String getIMEI(Context context) {
        String str;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (ActivityCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0) {
            return "";
        }
        try {
            str = telephonyManager.getDeviceId();
        } catch (Exception unused) {
            str = "Exception";
        }
        Log.d("TAG", str);
        return str;
    }

    private static String getUniqueID(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager.getDeviceId() != null) {
                return telephonyManager.getDeviceId();
            }
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
    }

    public static String getUUID(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String str = "" + telephonyManager.getDeviceId();
        return new UUID((long) ("" + Settings.Secure.getString(context.getContentResolver(), "android_id")).hashCode(), ((long) ("" + telephonyManager.getSimSerialNumber()).hashCode()) | (((long) str.hashCode()) << 32)).toString();
    }

    public static String getMacAddress(Context context) {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = t.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return getUniqueID(context);
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString() + "-" + getUniqueID(context);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "02:00:00:00:00:00-" + getUniqueID(context);
    }
}
