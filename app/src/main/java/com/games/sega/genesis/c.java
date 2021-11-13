package com.games.sega.genesis;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

class c extends GLSurfaceView {
    public static int a = 0;
    public static int b = 0;
    public static int c = 0;
    protected static boolean d;
    /* access modifiers changed from: private */
    public static String f = "EmulatorView";
    public boolean e = true;
    /* access modifiers changed from: private */
    public Activity g;

    private static class a implements EGLConfigChooser {
        private static int g = 4;
        private static int[] h = {12324, 4, 12323, 4, 12322, 4, 12352, g, 12344};
        protected int a;
        protected int b;
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        private int[] i = new int[1];

        public a(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.e = i6;
            this.f = i7;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.i) ? this.i[0] : i3;
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a2 >= this.e && a3 >= this.f) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a4 == this.a && a5 == this.b && a6 == this.c && a7 == this.d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, h, (EGLConfig[]) null, 0, iArr);
            int i2 = iArr[0];
            if (i2 <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i2];
            egl10.eglChooseConfig(eGLDisplay, h, eGLConfigArr, i2, iArr);
            return a(egl10, eGLDisplay, eGLConfigArr);
        }
    }

    private static class b implements EGLContextFactory {
        private static int a = 12440;

        private b() {
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            // Log.w(c.f, "creating OpenGL ES 2.0 context"); // LOG
            c.b("Before eglCreateContext", egl10);
            EGLContext eglCreateContext = egl10.eglCreateContext(
                    eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{a, 2, 12344});
            c.b("After eglCreateContext", egl10);
            return eglCreateContext;
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* renamed from: com.tizmoplay.androgens.c$c  reason: collision with other inner class name */
    private class C0018c implements Renderer {
        short[] a;

        private C0018c() {
            this.a = new short[2048];
        }

        public void onDrawFrame(GL10 gl10) {
            if (!c.d) {
                Emulator.draw();
                return;
            }
            Emulator.step();
            Emulator.draw();
            int mixAudioBuffer = Emulator.mixAudioBuffer(this.a);
            if (mixAudioBuffer > 0) {
                a.a(this.a, mixAudioBuffer); // OLHAR
            }
        }

        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            // Log.d(c.f, "onSurfaceChanged(" + i + ", " + i2 + ")");
            Emulator.setViewport(i, i2);
        }

        @SuppressLint("ResourceType")
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            // Log.d(c.f, "onSurfaceCreated()"); // LOG
            Emulator.initGraphics();
            i.d(c.this.g, c.this.getContext());
            Rect rect = new Rect();
            Window window = c.this.g.getWindow();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            int i = rect.top;
            c = i + (window.findViewById(16908290).getTop() - i);
            // c.c = i + (window.findViewById(16908290).getTop() - i); // OLHAR
        }
    }

    public c(Activity activity, Context context) {
        super(context);
        this.g = activity;
        a(false, 0, 0);
        setDebugFlags(0);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    private void a(boolean z, int i, int i2) {
        if (z) {
            getHolder().setFormat(-3);
        }
        setEGLContextFactory(new b());
        setEGLConfigChooser(z ? new a(8, 8, 8, 8, i, i2) : new a(5, 6, 5, 0, i, i2));
        setRenderer(new C0018c());
        setKeepScreenOn(true);
        setClickable(false);
    }

    /* access modifiers changed from: private */
    public static void b(String str, EGL10 egl10) {
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError != 12288) {
                // Log.e(f, String.format("%s: EGL error: 0x%x", new Object[]{str, Integer.valueOf(eglGetError)}));
                Log.e(f, String.format("%s: EGL error: 0x%x", str, eglGetError ));
            } else {
                return;
            }
        }
    }

    public void a() {
        if (this.e) {
            this.g.getActionBar().hide();
            this.e = false;
            return;
        }
        this.g.getActionBar().show();
        this.e = true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 5 || actionMasked == 0) {
            int actionIndex = motionEvent.getActionIndex();
            Emulator.onTouchDown(motionEvent.getPointerId(actionIndex),
                    motionEvent.getX(actionIndex),
                    motionEvent.getY(actionIndex) - ((float) c),
                    motionEvent.getSize(actionIndex));
        } else if (actionMasked == 6 || actionMasked == 1 || actionMasked == 3) {
            int actionIndex2 = motionEvent.getActionIndex();
            Emulator.onTouchUp(motionEvent.getPointerId(actionIndex2),
                    motionEvent.getX(actionIndex2), motionEvent.getY(actionIndex2) - ((float) c),
                    motionEvent.getSize(actionIndex2));
        } else if (actionMasked == 2) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                Emulator.onTouchMove(motionEvent.getPointerId(i), (float) ((int) motionEvent.getX(i)),
                        (float) (((int) motionEvent.getY(i)) - c), motionEvent.getSize(i));
            }
        }
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if ((i == 4 || i == 82) && keyEvent.getRepeatCount() == 0) {
            a();
            return true;
        } else if (i == 24 || i == 25) {
            return super.onKeyDown(i, keyEvent);
        } else {
            Emulator.onKeyDown(keyEvent.getKeyCode());
            return true;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 24 || i == 25) {
            return super.onKeyUp(i, keyEvent);
        }
        Emulator.onKeyUp(keyEvent.getKeyCode());
        return true;
    }

    public void onWindowFocusChanged(boolean z) {
        d = z;
    }

}
