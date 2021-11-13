package com.games.sega.genesis;

public class Emulator {
    static {
        System.loadLibrary("gnupng");
        System.loadLibrary("zip");
        System.loadLibrary("genesis");
    }

    public static native void destroy();
    public static native void draw();
    public static native int init(String str);
    public static native int initAudioBuffer(int i);
    public static native int initGraphics();
    public static native boolean isRomLoaded();
    public static native int loadRom(String str);
    public static native void loadState(int i);
    public static native int mixAudioBuffer(short[] sArr);
    public static native void onKeyDown(int i);
    public static native void onKeyUp(int i);
    public static native void onTouchDown(int i, float f, float f2, float f3);
    public static native void onTouchMove(int i, float f, float f2, float f3);
    public static native void onTouchUp(int i, float f, float f2, float f3);
    public static native void resetGame();
    public static native void saveState(int i);
    public static native void setAnalog(float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, boolean z);
    public static native void setAspectRatio(float f);
    public static native void setAudioEnabled(boolean z);
    public static native void setAudioSampleRate(int i);
    public static native void setButton(int i, float f, float f2, float f3, float f4, int i2, boolean z);
    public static native void setFrameSkip(int i);
    public static native void setGameGenie(boolean z);
    public static native int setPaths(String str, String str2, String str3, String str4, String str5);
    public static native void setSensitivity(float f, float f2);
    public static native void setSmoothFiltering(boolean z);
    public static native void setViewport(int i, int i2);
    public static native void step();
    public static native void unzipFile(String str, String str2, String str3);

}
