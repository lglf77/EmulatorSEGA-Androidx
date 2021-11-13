package com.games.sega.genesis;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class e {
    public static float a(Context context, int i) {
        return b(context, "input_button", "x", i);
    }

    public static int a(Context context) {
        return b.BUTTON_INDEX_COUNT.ordinal();
    }

    private static int a(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str, 0);
    }

    private static int a(Context context, String str, String str2, int i) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(a(str, i) + str2, 0);
    }

    private static String a(String str, int i) {
        return str + "_" + i + "_";
    }

    public static void a(Context context, float f, float f2, float f3, float f4, int i) {
        a(context, f, f2, f3, f4, e(context, i), g(context, i), i);
    }

    public static void a(Context context,
                         float f, float f2, float f3, float f4,
                         int i, int i2, int i3, int i4,
                         String str,
                         int i5) {
        Log.d("InputPreferences", "setAnalog(" + f + ", " + f2 + ", "
                + f3 + ", " + f4 + ", " + i + ", " + i2 + ", " + i3 + ", " + i4 + ", "
                + str + ", " + i5);
        int c = c(context);
        String a = a("input_analog", i5);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        if (!defaultSharedPreferences.contains(a)) {
            edit.putInt("input_numAnalogs", c + 1);
        }
        edit.putBoolean(a, true);
        edit.putFloat(a + "x", f);
        edit.putFloat(a + "y", f2);
        edit.putFloat(a + "w", f3);
        edit.putFloat(a + "h", f4);
        edit.putInt(a + "codeLeft", i);
        edit.putInt(a + "codeUp", i2);
        edit.putInt(a + "codeRight", i3);
        edit.putInt(a + "codeDown", i4);
        edit.putInt(a + "map", i5);
        edit.putString(a + "texture", str);
        edit.apply();
    }

    public static void a(Context context,
                         float f, float f2, float f3, float f4,
                         int i,
                         String str,
                         int i2) {
        Log.d("InputPreferences", "setButton(" + f + ", " + f2 + ", " + f3 + ", "
                + f4 + ", " + i + ", " + str + ", " + i2);
        int a = a(context);
        String a2 = a("input_button", i2);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        if (!defaultSharedPreferences.contains(a2)) {
            edit.putInt("input_numButtons", a + 1);
        }
        edit.putBoolean(a2, true);
        edit.putFloat(a2 + "x", f);
        edit.putFloat(a2 + "y", f2);
        edit.putFloat(a2 + "w", f3);
        edit.putFloat(a2 + "h", f4);
        edit.putInt(a2 + "code", i);
        edit.putInt(a2 + "map", i2);
        edit.putString(a2 + "texture", str);
        edit.apply();
    }

    public static void a(Context context, int i, int i2) {
        a(context, a(context, i2), b(context, i2), c(context, i2), d(context, i2), i, g(context, i2), i2);
    }

    public static float b(Context context, int i) {
        return b(context, "input_button", "y", i);
    }

    private static float b(Context context, String str, String str2, int i) {
        return PreferenceManager.getDefaultSharedPreferences(context).getFloat(a(str, i) + str2, 0.0f);
    }

    public static void b(Context context) {
        int a = a(context);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        for (int i = 0; i < a; i++) {
            String a2 = a("input_button", i);
            edit.remove(a2);
            edit.remove(a2 + "x");
            edit.remove(a2 + "y");
            edit.remove(a2 + "w");
            edit.remove(a2 + "h");
            edit.remove(a2 + "code");
            edit.remove(a2 + "map");
            edit.remove(a2 + "texture");
        }
        edit.putInt("input_numButtons", 0);
        edit.apply();
    }

    public static void b(Context context, float f, float f2, float f3, float f4, int i) {
        a(context, f, f2, f3, f4, l(context, i), m(context, i), n(context, i), o(context, i), p(context, i), i);
    }

    public static float c(Context context, int i) {
        return b(context, "input_button", "w", i);
    }

    public static int c(Context context) {
        return a(context, "input_numAnalogs");
    }

    private static String c(Context context, String str, String str2, int i) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(a(str, i) + str2, (String) null);
    }

    public static float d(Context context, int i) {
        return b(context, "input_button", "h", i);
    }

    public static int e(Context context, int i) {
        return a(context, "input_button", "code", i);
    }

    public static int f(Context context, int i) {
        return a(context, "input_button", "map", i);
    }

    public static String g(Context context, int i) {
        return c(context, "input_button", "texture", i);
    }

    public static float h(Context context, int i) {
        return b(context, "input_analog", "x", i);
    }

    public static float i(Context context, int i) {
        return b(context, "input_analog", "y", i);
    }

    public static float j(Context context, int i) {
        return b(context, "input_analog", "w", i);
    }

    public static float k(Context context, int i) {
        return b(context, "input_analog", "h", i);
    }

    public static int l(Context context, int i) {
        return a(context, "input_analog", "codeLeft", i);
    }

    public static int m(Context context, int i) {
        return a(context, "input_analog", "codeUp", i);
    }

    public static int n(Context context, int i) {
        return a(context, "input_analog", "codeRight", i);
    }

    public static int o(Context context, int i) {
        return a(context, "input_analog", "codeDown", i);
    }

    public static String p(Context context, int i) {
        return c(context, "input_analog", "texture", i);
    }

}
