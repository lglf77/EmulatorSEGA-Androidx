package com.games.sega.genesis;

import android.media.AudioTrack;
import android.util.Log;

public class a {
    private static String a = "AudioPlayer";
    private static AudioTrack b;
    private static int c;
    private static float d = AudioTrack.getMaxVolume();
    private static int e;
    private static int f;
    private static int g;

    public static int a(short[] sArr, int i) {
        if (b == null) {
            return 0;
        }
        return b.write(sArr, 0, i);
    }

    public static void a() {
        if (b != null && b.getPlayState() != 2) {
            b.pause();
        }
    }

    public static boolean a(int i, int i2, int i3) {
        int i4 = 3;
        Log.d(a, "create(" + i + ", " + i2 + ", " + i3 + ")");
        b = null;
        e = i;
        f = i2;
        g = i3;
        if (f == 16) {
            i4 = 2;
        }
        int i5 = g == 2 ? 12 : 4;
        int minBufferSize = AudioTrack.getMinBufferSize(e, i5, i4);
        c = minBufferSize;
        try {
            // b = new AudioTrack(3, e, i5, i4, minBufferSize * 1, 1);
            b = new AudioTrack(3, e, i5, i4, minBufferSize, 1);
            if (b.getState() == 0) {
                b = null;
            }
            b.setStereoVolume(d, d);
            return true;
        } catch (IllegalArgumentException e2) {
            b = null;
            return false;
        }
    }

    public static void b() {
        if (b != null && b.getPlayState() != 3) {
            b.play();
        }
    }

    public static void c() {
        Log.d(a, "AudioPlayer.destroy()");
        if (b != null) {
            b.pause();
            b.release();
            b = null;
        }
    }

    public static int d() {
        return c;
    }
}
