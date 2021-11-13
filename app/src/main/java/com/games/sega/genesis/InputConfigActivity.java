package com.games.sega.genesis;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;

public class InputConfigActivity extends Activity implements GestureDetector.OnGestureListener {
    /* access modifiers changed from: private */
    public RectF a;
    /* access modifiers changed from: private */
    public RectF[] b;
    /* access modifiers changed from: private */
    public RectF[] c;
    /* access modifiers changed from: private */
    public Bitmap[] d;
    /* access modifiers changed from: private */
    public Bitmap[] e;
    /* access modifiers changed from: private */
    public Paint f;
    /* access modifiers changed from: private */
    public Paint g;
    private RectF h;
    /* access modifiers changed from: private */
    public RectF i;
    private boolean j = false;
    private GestureDetector k;
    private float l;
    private float m;
    /* access modifiers changed from: private */
    public int n = 0;
    /* access modifiers changed from: private */
    public int o = 0;

    class a extends SurfaceView implements SurfaceHolder.Callback {
        private b b;

        public a(Context context) {
            super(context);
            getHolder().addCallback(this);
            this.b = new b(getHolder(), this);
        }

        public void onDraw(Canvas canvas) {
            canvas.drawColor(-16777216);
            canvas.drawRect(InputConfigActivity.this.a, InputConfigActivity.this.f);
            for (int i = 0; i < InputConfigActivity.this.n; i++) {
                if (InputConfigActivity.this.d[i] != null) {
                    canvas.drawBitmap(InputConfigActivity.this.d[i], (Rect) null, InputConfigActivity.this.b[i], (Paint) null);
                }
                if (InputConfigActivity.this.i == InputConfigActivity.this.b[i]) {
                    canvas.drawRect(InputConfigActivity.this.b[i], InputConfigActivity.this.g);
                }
            }
            for (int i2 = 0; i2 < InputConfigActivity.this.o; i2++) {
                if (!(InputConfigActivity.this.e[i2] == null || InputConfigActivity.this.c[i2] == null)) {
                    canvas.drawBitmap(InputConfigActivity.this.e[i2], (Rect) null, InputConfigActivity.this.c[i2], (Paint) null);
                }
                if (InputConfigActivity.this.i == InputConfigActivity.this.c[i2]) {
                    canvas.drawRect(InputConfigActivity.this.c[i2], InputConfigActivity.this.g);
                }
            }
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.b.a(true);
            this.b.start();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            boolean z = true;
            this.b.a(false);
            while (z) {
                try {
                    this.b.join();
                    z = false;
                } catch (InterruptedException e) {
                }
            }
        }
    }

    class b extends Thread {
        private SurfaceHolder b;
        private a c;
        private boolean d = false;

        public b(SurfaceHolder surfaceHolder, a aVar) {
            this.b = surfaceHolder;
            this.c = aVar;
        }

        public void a(boolean z) {
            this.d = z;
        }

        @SuppressLint({"WrongCall"})
        public void run() {
            Canvas canvas;
            while (this.d) {
                try {
                    canvas = this.b.lockCanvas((Rect) null);
                    try {
                        synchronized (this.b) {
                            if (canvas != null) {
                                this.c.onDraw(canvas);
                            }
                        }
                        if (canvas != null) {
                            this.b.unlockCanvasAndPost(canvas);
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    canvas = null;
                }
            }
            return;
            if (canvas != null) {
                this.b.unlockCanvasAndPost(canvas);
            }
            throw th;
        }
    }

    private void a() {
        Context applicationContext = getApplicationContext();
        if (this.b != null) {
            for (int i2 = 0; i2 < this.n; i2++) {
                if (this.b[i2] != null) {
                    e.a(applicationContext,
                            this.b[i2].left, this.b[i2].top,
                            this.b[i2].right - this.b[i2].left,
                            this.b[i2].bottom - this.b[i2].top, i2);
                }
            }
        }
        if (this.c != null) {
            for (int i3 = 0; i3 < this.o; i3++) {
                if (this.c[i3] != null) {
                    e.b(applicationContext,
                            this.c[i3].left,
                            this.c[i3].top, this.c[i3].right - this.c[i3].left,
                            this.c[i3].bottom - this.c[i3].top, i3);
                }
            }
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        edit.putBoolean("useDefaultInput", false);
        edit.apply();
    }

    @SuppressLint("WrongConstant") // Retirar depois
    public RectF a(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i2 = 0; i2 < this.n; i2++) {
            if (this.b[i2] != null) {
                RectF rectF = this.b[i2];
                if (x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom) {
                    Toast.makeText(this, getString(R.string.settingConfigureTouchLeaveResizeMode),
                            1).show();
                    return rectF;
                }
            }
        }
        for (int i3 = 0; i3 < this.o; i3++) {
            if (this.c[i3] != null) {
                RectF rectF2 = this.c[i3];
                if (x >= rectF2.left && x <= rectF2.right && y >= rectF2.top && y <= rectF2.bottom) {
                    Toast.makeText(this, getString(R.string.settingConfigureTouchLeaveResizeMode),
                            1).show();
                    return rectF2;
                }
            }
        }
        return null;
    }

    public void b(MotionEvent motionEvent) {
        if (this.i != null) {
            if (this.j) {
                float f2 = this.i.right - this.i.left;
                float f3 = f2 / (this.i.bottom - this.i.top);
                float f4 = f2 / 2.0f;
                float x = (motionEvent.getX() - this.i.left) / f4;
                float y = (motionEvent.getY() - this.i.top) / f4;
                if (((double) x) > 0.75d) {
                    float x2 = (motionEvent.getX() - this.i.right) * f3;
                    if (((double) (motionEvent.getX() - this.i.left)) > ((double) this.l) * 0.05d) {
                        this.i.right = motionEvent.getX();
                        if (((double) y) > 0.5d) {
                            RectF rectF = this.i;
                            rectF.bottom = x2 + rectF.bottom;
                        } else if (((double) y) < 0.5d) {
                            this.i.top -= x2;
                        }
                    }
                }
                if (((double) x) < 0.25d) {
                    float x3 = f3 * (this.i.left - motionEvent.getX());
                    if (((double) (this.i.right - motionEvent.getX())) > ((double) this.l) * 0.05d) {
                        this.i.left = motionEvent.getX();
                        if (((double) y) > 0.5d) {
                            RectF rectF2 = this.i;
                            rectF2.bottom = x3 + rectF2.bottom;
                        } else if (((double) y) < 0.5d) {
                            this.i.top -= x3;
                        }
                    }
                }
            }
        } else if (this.h != null) {
            float f5 = this.h.right - this.h.left;
            float f6 = this.h.bottom - this.h.top;
            float x4 = motionEvent.getX() - (f5 / 2.0f);
            float y2 = motionEvent.getY() - (f6 / 2.0f);
            this.h.left = x4;
            this.h.top = y2;
            this.h.right = f5 + x4;
            this.h.bottom = f6 + y2;
        }
    }

    public RectF c(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i2 = 0; i2 < this.n; i2++) {
            RectF rectF = this.b[i2];
            if (x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom) {
                return rectF;
            }
        }
        for (int i3 = 0; i3 < this.o; i3++) {
            RectF rectF2 = this.c[i3];
            if (x >= rectF2.left && x <= rectF2.right && y >= rectF2.top && y <= rectF2.bottom) {
                return rectF2;
            }
        }
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context applicationContext = getApplicationContext();
        this.n = e.a(applicationContext);
        this.o = e.c(applicationContext);
        Log.d("InputConfigActivity", "onCreate() Parsing NumButtons: " + this.n + ", NumAnalogs: " + this.o);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        this.b = new RectF[this.n];
        this.d = new Bitmap[this.n];
        this.c = new RectF[this.o];
        this.e = new Bitmap[this.o];
        this.l = (float) i.b(this, applicationContext);
        this.m = (float) i.a(this, applicationContext);
        float f2 = 1.3333334f;
        if (!defaultSharedPreferences.getBoolean("aspectRatio", true)) {
            f2 = this.l / this.m;
        }
        float f3 = this.m;
        float f4 = f2 * f3;
        float f5 = (this.l / 2.0f) - (f4 / 2.0f);
        this.a = new RectF(f5, 0.0f, f4 + f5, f3 + 0.0f);
        AssetManager assets = getAssets();
        for (int i2 = 0; i2 < this.o; i2++) {
            float h2 = e.h(applicationContext, i2);
            float i3 = e.i(applicationContext, i2);
            float j2 = e.j(applicationContext, i2);
            float k2 = e.k(applicationContext, i2);
            String p = e.p(applicationContext, i2);
            if (p != null) {
                try {
                    InputStream open = assets.open(p);
                    this.e[i2] = BitmapFactory.decodeStream(open);
                    open.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            this.c[i2] = new RectF(h2, i3, j2 + h2, k2 + i3);
        }
        for (int i4 = 0; i4 < this.n; i4++) {
            float a2 = e.a(applicationContext, i4);
            float b2 = e.b(applicationContext, i4);
            float c2 = e.c(applicationContext, i4);
            float d2 = e.d(applicationContext, i4);
            int f6 = e.f(applicationContext, i4);
            String g2 = e.g(applicationContext, i4);
            if (g2 != null) {
                try {
                    InputStream open2 = assets.open(g2);
                    this.d[f6] = BitmapFactory.decodeStream(open2);
                    open2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            this.b[f6] = new RectF(a2, b2, c2 + a2, d2 + b2);
        }
        this.g = new Paint();
        this.g.setColor(-16711936);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(3.0f);
        this.f = new Paint();
        this.f.setColor(-12303292);
        this.f.setStyle(Paint.Style.FILL);
        setContentView(new a(this));
        this.k = new GestureDetector(applicationContext, this);
        new AlertDialog.Builder(this).setTitle(getString(R.string.app_name)
                + " " + getString(R.string.settingConfigureTouchAlertTitle)).setMessage("- "
                + getString(R.string.settingConfigureTouchAlert0) + "\n- "
                + getString(R.string.settingConfigureTouchAlert1) + "\n- "
                + getString(R.string.settingConfigureTouchAlert2) + "\n- "
                + getString(R.string.settingConfigureTouchLeaveResizeMode) +
                "\n- " + getString(R.string.settingConfigureTouchAlert3))
                .setNeutralButton(getString(R.string.buttonOk),
                        (DialogInterface.OnClickListener) null).show();
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Log.d("InputConfigActivity", "onKeyDown(" + i2 + ")");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.i != null) {
            this.i = null;
            return true;
        }
        setResult(-1, new Intent());
        a();
        finish();
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        Log.d("InputConfigActivity", "LongPress(" + motionEvent + ")");
        this.i = a(motionEvent);
        this.j = false;
    }

    public void onPause() {
        super.onPause();
        a();
        finish();
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public void onStop() {
        super.onStop();
        a();
        finish();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 5 || actionMasked == 0) {
            RectF c2 = c(motionEvent);
            if (c2 == null || c2 != this.i) {
                this.h = c2;
                this.i = null;
            }
        } else if (actionMasked == 6 || actionMasked == 1 || actionMasked == 3) {
            this.h = null;
            if (this.i != null) {
                this.j = true;
            }
        } else if (actionMasked == 2) {
            b(motionEvent);
        }
        return this.k.onTouchEvent(motionEvent);
    }

}