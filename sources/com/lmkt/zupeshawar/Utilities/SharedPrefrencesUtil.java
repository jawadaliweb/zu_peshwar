package com.lmkt.zupeshawar.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.lmkt.zupeshawar.model.User;

public class SharedPrefrencesUtil {
    public static String PREFRENCESNAME = "ZuPeshawar";

    public static void saveFloat(String str, float f, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFRENCESNAME, 0).edit();
        edit.putFloat(str, f);
        edit.commit();
    }

    public static void setInt(String str, int i, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFRENCESNAME, 0).edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public static int getInt(String str, Context context) {
        return context.getSharedPreferences(PREFRENCESNAME, 0).getInt(str, 0);
    }

    public static void setNFCCheck(String str, boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFRENCESNAME, 0).edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    public static boolean getNFCCheck(String str, Context context) {
        return context.getSharedPreferences(PREFRENCESNAME, 0).getBoolean(str, false);
    }

    public static float getFloat(String str, Context context) {
        return context.getSharedPreferences(PREFRENCESNAME, 0).getFloat(str, 0.0f);
    }

    public static void saveString(String str, String str2, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFRENCESNAME, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static String getString(String str, Context context) {
        return context.getSharedPreferences(PREFRENCESNAME, 0).getString(str, "");
    }

    public static void saveBoolean(String str, boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFRENCESNAME, 0).edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    public static boolean getBoolean(String str, Context context) {
        return context.getSharedPreferences(PREFRENCESNAME, 0).getBoolean(str, false);
    }

    public static void saveBooleanFile(String str, boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFRENCESNAME, 0).edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    public static void saveSyncBoolean(String str, boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFRENCESNAME, 0).edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    public static boolean getSyncBoolean(String str, Context context) {
        return context.getSharedPreferences(PREFRENCESNAME, 0).getBoolean(str, true);
    }

    public static void clearPrefrences(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFRENCESNAME, 0).edit();
        edit.clear().commit();
        edit.commit();
    }

    public static void saveUserObject_Prefrences(User user, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFRENCESNAME, 0).edit();
        edit.putString("ZU_User", new Gson().toJson((Object) user));
        edit.commit();
    }

    public static User getUserObject_Prefrences(Context context) {
        return (User) new Gson().fromJson(context.getSharedPreferences(PREFRENCESNAME, 0).getString("ZU_User", ""), User.class);
    }

    public static void updateUserBalance(Context context, String str) {
        User userObject_Prefrences = getUserObject_Prefrences(context);
        userObject_Prefrences.setAccountBalance(str);
        saveUserObject_Prefrences(userObject_Prefrences, context);
    }
}
