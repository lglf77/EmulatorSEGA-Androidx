package com.games.sega.genesis;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public enum b {
    BUTTON_INDEX_A,
    BUTTON_INDEX_B,
    BUTTON_INDEX_C,
    BUTTON_INDEX_X,
    BUTTON_INDEX_Y,
    BUTTON_INDEX_Z,
    BUTTON_INDEX_START,
    BUTTON_INDEX_LEFT,
    BUTTON_INDEX_UP,
    BUTTON_INDEX_RIGHT,
    BUTTON_INDEX_DOWN,
    BUTTON_INDEX_COUNT;
    
    public static float A;
    public static float B;
    public static float C;
    public static float D;
    public static float E;
    public static float F;
    public static float G;
    public static float H;
    public static float I;
    public static float J;
    public static float K;
    public static float L;
    public static String M;
    public static String N;
    public static String O;
    public static String P;
    public static String Q;
    public static String R;
    public static String S;
    public static String T;
    public static int U;
    public static int V;
    public static int W;
    public static int X;
    public static int Y;
    public static int Z;
    public static int aa;
    public static int ab;
    public static int ac;
    public static int ad;
    public static int ae;
    private static String af;
    public static float m;
    public static float n;
    public static float o;
    public static float p;
    public static float q;
    public static float r;
    public static float s;
    public static float t;
    public static float u;
    public static float v;
    public static float w;
    public static float x;
    public static float y;
    public static float z;

    static {
        af = "EmulatorButtons";
        m = 0.0f;
        n = 0.0f;
        o = 0.0f;
        p = 0.0f;
        q = 0.0f;
        r = 0.0f;
        s = 0.0f;
        t = 0.0f;
        u = 0.0f;
        v = 0.0f;
        w = 0.0f;
        x = 0.0f;
        y = 0.0f;
        z = 0.0f;
        A = 0.0f;
        B = 0.0f;
        C = 0.0f;
        D = 0.0f;
        E = 0.0f;
        F = 0.0f;
        G = 0.0f;
        H = 0.0f;
        I = 0.0f;
        J = 0.0f;
        K = 0.0f;
        L = 0.0f;
        M = "Textures/ButtonA.png";
        N = "Textures/ButtonB.png";
        O = "Textures/ButtonC.png";
        P = "Textures/ButtonX.png";
        Q = "Textures/ButtonY.png";
        R = "Textures/ButtonZ.png";
        S = "Textures/StartButton.png";
        T = "Textures/DirectionalPad.png";
        U = 23;
        V = 99;
        W = 4;
        X = 100;
        Y = 102;
        Z = 103;
        aa = 108;
        ab = 21;
        ac = 19;
        ad = 22;
        ae = 20;
    }

    public static void a(Activity activity, Context context) {
        m = (float) i.b(activity, context);
        n = (float) i.a(activity, context);
        Log.d(af, "resetInput(" + m + ", " + n + ")");
        o = m > n ? m : n;
        // o = Math.max ( m, n );
        p = o * 0.25f;
        if ((activity.getResources().getConfiguration().screenLayout & 15) == 3) {
            p = o * 0.15f;
        } else if ((activity.getResources().getConfiguration().screenLayout & 15) == 4) {
            p = o * 0.1f;
        }
        q = p;
        r = 0.0f + (o * 0.01f);
        s = (n - q) - (o * 0.01f);
        t = o * 0.085f;
        u = o * 0.085f;
        v = o * 0.01f;
        if ((activity.getResources().getConfiguration().screenLayout & 15) == 3) {
            t = o * 0.05f;
            u = o * 0.05f;
            v = o * 0.02f;
        } else if ((activity.getResources().getConfiguration().screenLayout & 15) == 4) {
            t = o * 0.045f;
            u = o * 0.045f;
            v = o * 0.015f;
        }
        w = (m - (t * 3.0f)) - (v * 3.0f);
        x = (n - u) - (u / 4.0f);
        y = w + t + v;
        z = x - (u / 3.0f);
        A = y + t + v;
        B = z - (u / 3.0f);
        C = w;
        D = (x - u) - v;
        E = y;
        F = (z - u) - v;
        G = A;
        H = (B - u) - v;
        I = o * 0.075f;
        J = o * 0.03f;
        K = (m / 2.0f) - (I / 2.0f);
        L = (n - J) - (o * 0.01f);
        M = "Textures/ButtonA.png";
        N = "Textures/ButtonB.png";
        O = "Textures/ButtonC.png";
        P = "Textures/ButtonX.png";
        Q = "Textures/ButtonY.png";
        R = "Textures/ButtonZ.png";
        S = "Textures/StartButton.png";
        T = "Textures/DirectionalPad.png";
        U = 23;
        V = 99;
        W = 4;
        X = 100;
        Y = 102;
        Z = 103;
        aa = 108;
        ab = 21;
        ac = 19;
        ad = 22;
        ae = 20;
    }

    public static void b(Activity activity, Context context) {
        a(activity, context);
        C = 0.0f;
        D = 0.0f;
        E = 0.0f;
        F = 0.0f;
        G = 0.0f;
        H = 0.0f;
        e.a(context, C, D, 0.0f, 0.0f, X, P, BUTTON_INDEX_X.ordinal());
        e.a(context, E, F, 0.0f, 0.0f, Y, Q, BUTTON_INDEX_Y.ordinal());
        e.a(context, G, H, 0.0f, 0.0f, Z, R, BUTTON_INDEX_Z.ordinal());
    }

    public static void c(Activity activity, Context context) {
        a(activity, context);
        C = w;
        D = (x - u) - v;
        E = y;
        F = (z - u) - v;
        G = A;
        H = (B - u) - v;
        e.a(context, C, D, t, u, X, P, BUTTON_INDEX_X.ordinal());
        e.a(context, E, F, t, u, Y, Q, BUTTON_INDEX_Y.ordinal());
        e.a(context, G, H, t, u, Z, R, BUTTON_INDEX_Z.ordinal());
    }

    public static void d(Activity activity, Context context) {
        a(activity, context);
        e.b(context);
        e.a(context, A, B, t, u, W, O, BUTTON_INDEX_C.ordinal());
        e.a(context, y, z, t, u, V, N, BUTTON_INDEX_B.ordinal());
        e.a(context, w, x, t, u, U, M, BUTTON_INDEX_A.ordinal());
        if (i.h(context).intValue() == 3) {
            e.a(context, 0.0f, 0.0f, 0.0f, 0.0f, X, P, BUTTON_INDEX_X.ordinal());
            e.a(context, 0.0f, 0.0f, 0.0f, 0.0f, Y, Q, BUTTON_INDEX_Y.ordinal());
            e.a(context, 0.0f, 0.0f, 0.0f, 0.0f, Z, R, BUTTON_INDEX_Z.ordinal());
        } else {
            C = w;
            D = (x - u) - v;
            E = y;
            F = (z - u) - v;
            G = A;
            H = (B - u) - v;
            e.a(context, C, D, t, u, X, P, BUTTON_INDEX_X.ordinal());
            e.a(context, E, F, t, u, Y, Q, BUTTON_INDEX_Y.ordinal());
            e.a(context, G, H, t, u, Z, R, BUTTON_INDEX_Z.ordinal());
        }
        e.a(context, K, L, I, J, aa, S, BUTTON_INDEX_START.ordinal());
        e.a(context, 0.0f, 0.0f, 0.0f, 0.0f, ab, (String) null, BUTTON_INDEX_LEFT.ordinal());
        e.a(context, 0.0f, 0.0f, 0.0f, 0.0f, ac, (String) null, BUTTON_INDEX_UP.ordinal());
        e.a(context, 0.0f, 0.0f, 0.0f, 0.0f, ad, (String) null, BUTTON_INDEX_RIGHT.ordinal());
        e.a(context, 0.0f, 0.0f, 0.0f, 0.0f, ae, (String) null, BUTTON_INDEX_DOWN.ordinal());
        e.a(context, r, s, p, q, ab, ac, ad, ae, T, 0);
    }

}
