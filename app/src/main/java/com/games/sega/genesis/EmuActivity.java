package com.games.sega.genesis;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/*
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
 */

public class EmuActivity extends Activity {

    private c a;
    private int b = 0;

    /* access modifiers changed from: protected */
    public void a() {
        Context applicationContext = getApplicationContext();
        Intent intent = new Intent(this, FileChooser.class);
        intent.putExtra("StartDir", i.a(applicationContext));
        intent.putExtra("Extensions", "smd|gen|bin|md|sms|zip");
        intent.putExtra("TempDir", i.e(applicationContext));
        startActivityForResult(intent, 1);
    }

    /* access modifiers changed from: protected */
    public void b() {
        startActivityForResult(new Intent(this, SettingsActivity.class), 2);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        Log.d("EmulatorActivity", "onActivityResult(" + i + ", " + i2 + ")");
        if (i == 2) {
            this.a.queueEvent(new Runnable() {
                public void run() {
                    i.c(EmuActivity.this, EmuActivity.this.getApplicationContext());
                    i.e(EmuActivity.this, EmuActivity.this.getApplicationContext());
                }
            });
        } else if (i == 1 && (stringExtra = intent.getStringExtra("Filename")) != null) {
            if (Emulator.loadRom(stringExtra) != 0) {
                finish();
            }
            i.g(getApplicationContext());
        }
    }

    public void onCreate(Bundle bundle) {
        Log.d("EmulatorActivity", "onCreate()");
        super.onCreate(bundle);
        i.e(this, getApplicationContext());
        this.a = new c(this, getApplication());
        setContentView(this.a);
        getWindow().setFlags(1024, 1024);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.emulator, menu);
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint("NonConstantResourceId")
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        ActionBar actionBar = getActionBar();
        switch (menuItem.getItemId()) {
            case R.id.menuExit /*2131165232*/:
                finish();
                return true;
            case R.id.menuHide /*2131165233*/:
                actionBar.hide();
                this.a.e = false;
                return true;
            case R.id.menuLoadROM /*2131165234*/:
                a();
                return true;
            case R.id.menuLoadState /*2131165235*/:
                Emulator.loadState(this.b);
                actionBar.hide();
                this.a.e = false;
                return true;
            case R.id.menuResetGame /*2131165236*/:
                Emulator.resetGame();
                actionBar.hide();
                this.a.e = false;
                return true;
            case R.id.menuSaveState /*2131165237*/:
                Emulator.saveState(this.b);
                actionBar.hide();
                this.a.e = false;
                return true;
            case R.id.menuSelectState /*2131165238*/:
                return true;
            case R.id.menuSettings /*2131165239*/:
                b();
                return true;
            case R.id.menuState0 /*2131165240*/:
                this.b = 0;
                return true;
            case R.id.menuState1 /*2131165241*/:
                this.b = 1;
                return true;
            case R.id.menuState2 /*2131165243*/:
                this.b = 2;
                return true;
            case R.id.menuState3 /*2131165244*/:
                this.b = 3;
                return true;
            case R.id.menuState4 /*2131165245*/:
                this.b = 4;
                return true;
            case R.id.menuState5 /*2131165246*/:
                this.b = 5;
                return true;
            case R.id.menuState6 /*2131165247*/:
                this.b = 6;
                return true;
            case R.id.menuState7 /*2131165248*/:
                this.b = 7;
                return true;
            case R.id.menuState8 /*2131165249*/:
                this.b = 8;
                return true;
            case R.id.menuState9 /*2131165250*/:
                this.b = 9;
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onPause() {
        Log.d("EmulatorActivity", "onPause()");
        super.onPause();
        a.a();
        this.a.onPause();
        i.f(getApplicationContext());
    }

    public void onResume() {
        super.onResume();
        Log.d("EmulatorActivity", "onResume()");
        if (PreferenceManager.getDefaultSharedPreferences(getApplicationContext())
                .getBoolean("audio", true)) {
            a.b();
        }
        this.a.onResume();
        System.gc();
    }

    public void onStop() {
        Log.d("EmulatorActivity", "onStop()");
        super.onStop();
    }

}