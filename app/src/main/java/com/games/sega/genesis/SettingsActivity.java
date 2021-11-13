package com.games.sega.genesis;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;
import java.io.File;

public class SettingsActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    /* access modifiers changed from: private */
    public String a = "prefRomDir";
    private String b = "prefStatesDir";
    /* access modifiers changed from: private */
    public String c = "prefSramDir";
    /* access modifiers changed from: private */
    public String d = "prefTempDir";

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Log.d("SettingsActivity", "onActivityResult()");
        if (i == 3) {
            Log.d("SettingsActivity", "onActivityResult(INPUT_CONFIG)");
        } else if (i == 6) {
            Log.d("SettingsActivity", "onActivityResult(DIR_SELECT)");
            String stringExtra = intent.getStringExtra("DirSelected");
            if (stringExtra != null) {
                Log.d("SettingsActivity", "NewDir: " + stringExtra + " @ Key: " + this.a);
            }
            if (this.a != null) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                findPreference(this.a).setSummary(stringExtra);
                SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                edit.putString(this.a, stringExtra);
                edit.apply();
            }
        } else if (i == 7) {
            Log.d("SettingsActivity", "onActivityResult(DIR_SELECT)");
            String stringExtra2 = intent.getStringExtra("DirSelected");
            if (stringExtra2 != null) {
                Log.d("SettingsActivity", "NewDir: " + stringExtra2 + " @ Key: " + this.b);
            }
            if (this.b != null) {
                SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                findPreference(this.b).setSummary(stringExtra2);
                SharedPreferences.Editor edit2 = defaultSharedPreferences2.edit();
                edit2.putString(this.b, stringExtra2);
                edit2.apply();
            }
        } else if (i == 8) {
            Log.d("SettingsActivity", "onActivityResult(DIR_SELECT)");
            String stringExtra3 = intent.getStringExtra("DirSelected");
            if (stringExtra3 != null) {
                Log.d("SettingsActivity", "NewDir: " + stringExtra3 + " @ Key: " + this.c);
            }
            if (this.c != null) {
                SharedPreferences defaultSharedPreferences3 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                findPreference(this.c).setSummary(stringExtra3);
                SharedPreferences.Editor edit3 = defaultSharedPreferences3.edit();
                edit3.putString(this.c, stringExtra3);
                edit3.apply();
            }
        } else if (i == 9) {
            Log.d("SettingsActivity", "onActivityResult(DIR_SELECT)");
            String stringExtra4 = intent.getStringExtra("DirSelected");
            if (stringExtra4 != null) {
                Log.d("SettingsActivity", "NewDir: " + stringExtra4 + " @ Key: " + this.d);
            }
            if (this.b != null) {
                SharedPreferences defaultSharedPreferences4
                        = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                findPreference(this.d).setSummary(stringExtra4);
                SharedPreferences.Editor edit4 = defaultSharedPreferences4.edit();
                edit4.putString(this.d, stringExtra4);
                edit4.apply();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Log.d("SettingsActivity", "onCreate()");
        super.onCreate(bundle);
        System.gc();
        addPreferencesFromResource(R.layout.settings);
        findPreference("bntInputPref").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                try {
                    SettingsActivity.this.startActivityForResult(new Intent(
                            SettingsActivity.this, InputConfigActivity.class),
                            3);
                    return true;
                } catch (Exception e) {
                    Log.e("SettingsActivity", "EXCEPTION: " + e.toString());
                    return true;
                }
            }
        });
        final Preference findPreference = findPreference("prefButtonNumber");
        findPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object obj) {
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(
                        SettingsActivity.this.getApplicationContext()).edit();
                edit.putString("prefButtonNumber", (String) obj);
                edit.apply();
                /*
                Integer valueOf = Integer.valueOf(Integer.parseInt((String) obj));
                if (valueOf.intValue() == 3) {
                    findPreference.setSummary(R.string.settingSetButtonNumber3ButtonPad);
                    b.b(SettingsActivity.this, SettingsActivity.this.getApplicationContext());
                }
                if (valueOf.intValue() != 6) {
                    return true;
                }
                 */

                int valueOf = Integer.parseInt ( (String) obj );
                if ((int) valueOf == 3) {
                    findPreference.setSummary(R.string.settingSetButtonNumber3ButtonPad);
                    b.b(SettingsActivity.this, SettingsActivity.this.getApplicationContext());
                }
                if ((int) valueOf != 6) {
                    return true;
                }

                findPreference.setSummary(R.string.settingSetButtonNumber6ButtonPad);
                b.c(SettingsActivity.this, SettingsActivity.this.getApplicationContext());
                return true;
            }
        });
        findPreference("bntDefaultEmpty").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(
                        SettingsActivity.this.getApplicationContext()).edit();
                edit.putBoolean("useDefaultInput", true);
                edit.apply();
                b.d(SettingsActivity.this, SettingsActivity.this.getApplicationContext());
                return true;
            }
        });
        findPreference("bntCustomKeys").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                try {
                    SettingsActivity.this.startActivityForResult(
                            new Intent(SettingsActivity.this,
                                    KeyboardConfigActivity.class), 5);
                    return true;
                } catch (Exception e) {
                    Log.e("SettingsActivity", "EXCEPTION: " + e.toString());
                    return true;
                }
            }
        });
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("useGameGenie");
        if (checkBoxPreference != null) {
            checkBoxPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @SuppressLint("WrongConstant") // WrongConstant
                public boolean onPreferenceClick(Preference preference) {
                    if (((CheckBoxPreference) preference).isChecked()) {
                        String str = Environment.getExternalStorageDirectory() + "/Genesis" + "/gg.rom";
                        if (!new File(str).exists()) {
                            new AlertDialog.Builder(SettingsActivity.this).setTitle(
                                    SettingsActivity.this.getString(
                                            R.string.settingGameGenieNotFoundTitle))
                                    .setMessage(SettingsActivity.this.getString(
                                            R.string.settingGameGenieNotFoundSummary)
                                            + ": " + str).setPositiveButton(
                                                    SettingsActivity.this.getString(R.string.buttonOk),
                                    (DialogInterface.OnClickListener) null).show();
                            ((CheckBoxPreference) preference).setChecked(false);
                        }
                        if (PreferenceManager.getDefaultSharedPreferences(
                                SettingsActivity.this.getApplicationContext()).getBoolean(
                                        "enableAutosave", false)) {
                            Toast.makeText(SettingsActivity.this.getApplicationContext(),
                                    SettingsActivity.this.getString(R.string.settingGameGenieCantAutoload),
                                    1).show();
                        }
                    }
                    return false;
                }
            });
        }
        ((CheckBoxPreference) findPreference("enableAutosave"))
                .setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @SuppressLint("WrongConstant") // Retirar depois
            public boolean onPreferenceClick(Preference preference) {
                if (((CheckBoxPreference) preference).isChecked()
                        && PreferenceManager.getDefaultSharedPreferences(
                                SettingsActivity.this.getApplicationContext()).getBoolean(
                                        "useGameGenie", false)) {
                    Toast.makeText(SettingsActivity.this.getApplicationContext(),
                            SettingsActivity.this.getString(R.string.settingGameGenieCantAutoload),
                            1).show();
                }
                return false;
            }
        });
        Preference findPreference2 = findPreference("prefRomDir");
        findPreference2.setSummary(i.a(getApplicationContext()));
        findPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(SettingsActivity.this, FileChooser.class);
                intent.putExtra("SelectDir", "true");
                intent.putExtra("StartDir", i.a(SettingsActivity.this.getApplicationContext()));
                intent.putExtra("Extensions", "");
                SettingsActivity.this.startActivityForResult(intent, 6);
                String unused = SettingsActivity.this.a = "prefRomDir";
                return true;
            }
        });
        Preference findPreference3 = findPreference("prefStatesDir");
        findPreference3.setSummary(i.b(getApplicationContext()));
        findPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(SettingsActivity.this, FileChooser.class);
                intent.putExtra("SelectDir", "true");
                intent.putExtra("StartDir", i.b(SettingsActivity.this.getApplicationContext()));
                intent.putExtra("Extensions", "");
                SettingsActivity.this.startActivityForResult(intent, 7);
                String unused = SettingsActivity.this.a = "prefStatesDir";
                return true;
            }
        });
        Preference findPreference4 = findPreference("prefSramDir");
        findPreference4.setSummary(i.c(getApplicationContext()));
        findPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(SettingsActivity.this, FileChooser.class);
                intent.putExtra("SelectDir", "true");
                intent.putExtra("StartDir", i.c(SettingsActivity.this.getApplicationContext()));
                intent.putExtra("Extensions", "");
                SettingsActivity.this.startActivityForResult(intent, 8);
                String unused = SettingsActivity.this.c = "prefSramDir";
                return true;
            }
        });
        Preference findPreference5 = findPreference("prefTempDir");
        findPreference5.setSummary(i.e(getApplicationContext()));
        findPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(SettingsActivity.this, FileChooser.class);
                intent.putExtra("SelectDir", "true");
                intent.putExtra("StartDir", i.e(SettingsActivity.this.getApplicationContext()));
                intent.putExtra("Extensions", "");
                SettingsActivity.this.startActivityForResult(intent, 9);
                String unused = SettingsActivity.this.d = "prefTempDir";
                return true;
            }
        });
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Log.d("SettingsActivity", "onKeyDown(" + i + ")");
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        setResult(-1, new Intent());
        finish();
        return true;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Preference findPreference = findPreference(str);
        if (findPreference instanceof ListPreference) {
            findPreference.setSummary(((ListPreference) findPreference).getEntry());
        }
    }

    public void onStart() {
        super.onStart();
        for (String findPreference : PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext()).getAll().keySet()) {
            Preference findPreference2 = findPreference(findPreference);
            if (findPreference2 instanceof ListPreference) {
                findPreference2.setSummary(((ListPreference) findPreference2).getEntry());
            }
        }
    }

}