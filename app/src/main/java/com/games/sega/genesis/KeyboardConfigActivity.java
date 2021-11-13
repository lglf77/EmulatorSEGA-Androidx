package com.games.sega.genesis;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListView;

public class KeyboardConfigActivity extends ListActivity {
    /* access modifiers changed from: private */
    public int a = -1;
    private int b = -1;
    private ListView c = null;
    /* access modifiers changed from: private */
    public g d;

    public void a() {
        int ordinal = b.BUTTON_INDEX_COUNT.ordinal();
        f[] fVarArr = new f[ordinal];
        for (b bVar : b.values()) {
            if (bVar.ordinal() != ordinal) {
                int e = e.e(getApplicationContext(), bVar.ordinal());
                fVarArr[bVar.ordinal()] = new f();
                fVarArr[bVar.ordinal()].a = bVar.name();
                fVarArr[bVar.ordinal()].b = e;
                fVarArr[bVar.ordinal()].c = false;
                fVarArr[bVar.ordinal()].d = getApplicationContext();
            }
        }
        this.d = new g(this, R.layout.custom_key_view, fVarArr);
        setListAdapter(this.d);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Log.d("KeyboardConfigActivity", "dispatchKeyEvent(" + keyEvent + ")");
        if (keyEvent.getKeyCode() == 24 || keyEvent.getKeyCode() == 25 || keyEvent.getKeyCode() == 82) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.a < 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        Log.d("KeyboardConfigActivity", "NewButton: " + keyEvent.getKeyCode());
        this.b = keyEvent.getKeyCode();
        e.a(getApplicationContext(), this.b, this.a);
        a();
        this.a = -1;
        this.b = -1;
        this.d.a(-1);
        return true;
    }

    @SuppressLint("WrongConstant") // Retirar depois
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (defaultSharedPreferences.getBoolean("useDefaultInput", true)) {
            b.d(this, getApplicationContext());
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.putBoolean("useDefaultInput", false);
            edit.apply();
        }
        a();
        this.c = getListView();
        this.c.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Log.d("KeyboardConfigActivity", "onItemClick(" + adapterView + ", "
                        + view + ", " + i + ", " + j + ")");
                int unused = KeyboardConfigActivity.this.a = i;
                KeyboardConfigActivity.this.d.a(adapterView.getPositionForView(view));
            }
        });
        ((InputMethodManager) getSystemService("input_method")).showInputMethodPicker();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.keyboard_config_menu, menu);
        return true;
    }

    public void onDestroy() {
        Log.d("KeyboardConfigActivity", "onDestroy()");
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        menuItem.getItemId();
        return super.onOptionsItemSelected(menuItem);
    }

}
