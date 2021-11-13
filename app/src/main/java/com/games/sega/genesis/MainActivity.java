package com.games.sega.genesis;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.ads.AdView;

/*
import android.support.v4.a.a;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.h;
 */

import java.io.File;

public class MainActivity extends Activity {
    private boolean a = false;
    private AdView b;
    private int c;

    private boolean e() {
        boolean z;
        boolean z2;
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            z = true;
            z2 = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            z = false;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        if (z2 && z) {
            return true;
        }
        new AlertDialog.Builder(this).setTitle(getString(R.string.app_name) + getString(R.string.messageExternalStorageTitle)).setMessage(getString(R.string.messageExternalStorageSummary)).setPositiveButton(getString(R.string.buttonRetry), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.f();
            }
        }).setNeutralButton(getString(R.string.buttonExit), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        }).show();
        return false;
    }

    /* access modifiers changed from: private */
    public void f() {
        if (e() && !this.a) {
            String file = Environment.getExternalStorageDirectory().toString();
            File file2 = new File(file + "/Genesis");
            if (!file2.exists()) {
                file2.mkdir();
            }
            File file3 = new File(file + "/Genesis/roms");
            if (!file3.exists()) {
                file3.mkdir();
            }
            File file4 = new File(file + "/Genesis/states");
            if (!file4.exists()) {
                file4.mkdir();
            }
            File file5 = new File(file + "/Genesis/sram");
            if (!file5.exists()) {
                file5.mkdir();
            }
            File file6 = new File(file + "/Genesis/temp");
            if (!file6.exists()) {
                file6.mkdir();
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            if (defaultSharedPreferences.getBoolean("genplus_1_7", true)) {
                SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                edit.putBoolean("genplus_1_7", false);
                edit.putBoolean("useDefaultInput", true);
                edit.apply();
            }
            try {
                Emulator.init(getPackageManager().getApplicationInfo(getString(R.string.package_name), 0).sourceDir);
                Emulator.setPaths(file + "/Genesis", file + "/Genesis/roms", file + "/Genesis/states", file + "/Genesis/sram", file + "/Genesis/cheats");
                Log.d("MainActivity", "Done init()");
                setContentView(R.layout.main);
                g();
                super.setTitle(getString(R.string.app_name));
                this.a = true;
                this.b = (AdView) findViewById(R.id.adView);
                this.b.a(new c.a().a());
                Log.d("MainActivity", "Done onCreate()");
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Unable to locate assets, aborting...");
            }
        }
    }

    private void g() {
        ((Button) findViewById(R.id.buttonLoadRom)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.b();
            }
        });
        ((Button) findViewById(R.id.buttonResume)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Emulator.isRomLoaded()) {
                    MainActivity.this.a();
                } else {
                    Toast.makeText(MainActivity.this.getApplicationContext(),
                            MainActivity.this.getString(R.string.menuResumeNoRomLoaded), 0).show();
                }
            }
        });
        ((Button) findViewById(R.id.buttonSettings)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.c();
            }
        });
        ((Button) findViewById(R.id.buttonHelp)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.d();
            }
        });
        ((Button) findViewById(R.id.buttonExit)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a() {
        startActivity(new Intent(this, EmuActivity.class));
    }

    /* access modifiers changed from: protected */
    public void b() {
        Context applicationContext = getApplicationContext();
        Intent intent = new Intent(this, FileChooser.class);
        intent.putExtra("StartDir", i.a(applicationContext));
        intent.putExtra("Extensions", "smd|gen|bin|md|sms|zip");
        intent.putExtra("TempDir", i.e(applicationContext));
        startActivityForResult(intent, 1);
    }

    /* access modifiers changed from: protected */
    public void c() {
        startActivityForResult(new Intent(this, SettingsActivity.class), 2);
    }

    /* access modifiers changed from: protected */
    public void d() {
        startActivityForResult(new Intent(this, HelpActivity.class), 0);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Log.d("MainActivity", "onActivityResult(" + i + ", " + i2 + ")");
        if (i2 == 0) {
            finish();
        } else if (i != 2 && i == 1) {
            String stringExtra = intent.getStringExtra("Filename");
            if (stringExtra != null) {
                i.c(this, getApplicationContext());
                if (Emulator.loadRom(stringExtra) == 0) {
                    i.g(getApplicationContext());
                    a();
                }
            } else {
                Toast.makeText(getApplicationContext(), getString(R.string.fileChooseNoRomSelected), 0).show();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        Log.d("MainActivity", "onCreate()");
        super.onCreate(bundle);
        System.gc();
        h.a(this, "ca-app-pub-8207906625354307~3070081870");
        if (a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            android.support.v4.app.a.a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, this.c);
            return;
        }
        f();
    }

    public void onDestroy() {
        String[] list;
        Log.d("MainActivity", "onDestroy()");
        super.onDestroy();
        a.c();
        Emulator.destroy();
        i.f(getApplicationContext());
        File file = new File(Environment.getExternalStorageDirectory().toString() + "/Genesis/temp" + "/");
        if (file.exists() && (list = file.list()) != null) {
            for (String file2 : list) {
                File file3 = new File(file.getAbsoluteFile(), file2);
                if (file3.exists()) {
                    file3.delete();
                }
            }
        }
        this.a = false;
        System.gc();
    }

    public void onPause() {
        Log.d("MainActivity", "onPause()");
        super.onPause();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != this.c) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            finish();
        } else {
            f();
        }
    }

    public void onStop() {
        Log.d("MainActivity", "onStop()");
        super.onStop();
    }

}