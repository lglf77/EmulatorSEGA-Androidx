package com.games.sega.genesis;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

public class i {
    public static int a(Activity activity, Context context) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return Math.min(rect.right, rect.bottom) - rect.top;
    }

    public static String a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(
                "prefRomDir", Environment.getExternalStorageDirectory() + "/Genesis/roms");
    }

    public static int b(Activity activity, Context context) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return Math.max(rect.right, rect.bottom) - rect.top;
    }

    public static String b(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(
                "prefStatesDir", Environment.getExternalStorageDirectory() + "/Genesis/states");
    }

    public static String c(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(
                "prefSramDir", Environment.getExternalStorageDirectory() + "/Genesis/sram");
    }

    protected static void c(Activity activity, Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        boolean z = defaultSharedPreferences.getBoolean(
                "audio", true);
        float f = ((float) defaultSharedPreferences.getInt(
                "xAxisSensitivity", 30)) / 100.0f;
        float f2 = ((float) defaultSharedPreferences.getInt(
                "yAxisSensitivity", 35)) / 100.0f;
        int parseInt = Integer.parseInt(defaultSharedPreferences.getString(
                "soundSampleRate", "44100"));
        int parseInt2 = Integer.parseInt(defaultSharedPreferences.getString(
                "frameSkip", "0"));
        boolean z2 = defaultSharedPreferences.getBoolean("useGameGenie", false);
        float parseInt3 = ((float) Integer.parseInt(defaultSharedPreferences.getString(
                "audioStretchPercent", String.valueOf(2)))) / 100.0f;
        Emulator.setFrameSkip(parseInt2);
        Emulator.setGameGenie(z2);
        Emulator.setAudioEnabled(z);
        if (z) {
            Emulator.setAudioSampleRate(parseInt);
            a.a((int) ((1.0d - ((double) parseInt3)) * ((double) parseInt)), 16, 2);
            a.b();
            Emulator.initAudioBuffer(a.d());
        } else {
            Emulator.setAudioSampleRate(0);
            a.c();
        }
        Emulator.setSensitivity(f, f2);
        String a = a(context);
        String b = b(context);
        String c = c(context);
        String d = d(context);
        String e = e(context);
        Emulator.setPaths(Environment.getExternalStorageDirectory() + "/Genesis", a, b, c, d);
        Log.d("PreferenceFacade", "Directories: \n\tRoms: " + a + "\n\tStates: " + b + "\n\tSRAM: "
                + c + "\n\tCheats: " + d + "\n\tTemp: " + e);
    }

    public static String d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("prefCheatsDir",
                Environment.getExternalStorageDirectory() + "/Genesis/cheats");
    }

    @SuppressLint("WrongConstant") // Retirar depois
    public static void d(Activity activity, Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean z = defaultSharedPreferences.getBoolean("aspectRatio", true);
        if (z) {
            Emulator.setAspectRatio(1.3333334f);
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            Emulator.setAspectRatio((float) (i / i2));
            Emulator.setAspectRatio((float) (i / i2));
        }

        Emulator.setSmoothFiltering(Boolean.parseBoolean(defaultSharedPreferences.getString(
                "graphicsFilter", "true")));
        Log.d("PreferenceFacade", "keepAspect: " + z + "\n");
    }

    public static String e(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("prefTempDir",
                Environment.getExternalStorageDirectory() + "/Genesis/temp");
    }

    public static void e(Activity activity, Context context) {
        boolean z = true;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean z2 = defaultSharedPreferences.getBoolean("prefShowTouchInput", true);
        if (defaultSharedPreferences.contains("useDefaultInput")) {
            z = defaultSharedPreferences.getBoolean("useDefaultInput", true);
        }
        if (z) {
            Log.d("PreferenceFacade", "Setting default input!");
            b.d(activity, context);
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.putBoolean("useDefaultInput", false);
            edit.apply();
        }
        Emulator.setAnalog(e.h(context, 0), e.i(context, 0), e.j(context, 0),
                e.k(context, 0), e.l(context, 0), e.m(context, 0), e.n(context, 0),
                e.o(context, 0), z2);
        int a = e.a(context);
        for (int i = 0; i < a; i++) {
            Emulator.setButton(e.f(context, i), e.a(context, i), e.b(context, i),
                    e.c(context, i), e.d(context, i), e.e(context, i), z2);
        }
    }

    public static void f(Context context) {
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("enableAutosave",
                false)) {
            Emulator.saveState(10);
        }
    }

    public static void g(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean z = defaultSharedPreferences.getBoolean("enableAutosave", false);
        boolean z2 = defaultSharedPreferences.getBoolean("useGameGenie", false);
        if (z && !z2) {
            Emulator.loadState(10);
        }
    }

    public static Integer h(Context context) {
        // return Integer.valueOf(Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString("prefButtonNumber", "6")));
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString(
                "prefButtonNumber", "6"));
    }
}
