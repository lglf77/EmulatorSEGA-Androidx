package com.games.sega.genesis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdView;
// import com.google.android.gms.ads.c;

public class HelpActivity extends Activity {
    private AdView a;

    private void b() {
        setContentView(R.layout.help);
        c();
        this.a = (AdView) findViewById(R.id.adView);
        this.a.a(new c.a().a());
    }

    private void c() {
        ((Button) findViewById(R.id.buttonBack)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HelpActivity.this.a();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a() {
        setResult(-1, new Intent(this, MainActivity.class));
        finish();
    }

    public void onCreate(Bundle bundle) {
        Log.d("HelpActivity", "onCreate()");
        super.onCreate(bundle);
        b();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Log.d("HelpActivity", "onKeyDown(" + i + ")");
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        setResult(-1, new Intent());
        finish();
        return true;
    }

}
