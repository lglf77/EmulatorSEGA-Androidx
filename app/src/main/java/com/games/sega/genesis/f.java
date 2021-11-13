package com.games.sega.genesis;

import android.content.Context;

class f {
    String a;
    int b;
    boolean c;
    Context d;

    f() {
    }

    public String toString() {
        return String.format(this.d.getResources().getString(R.string.settingConfigureKeyInputLine),
                this.a, this.b );
        // return String.format(this.d.getResources().getString(R.string.settingConfigureKeyInputLine), new Object[]{this.a, Integer.valueOf(this.b)});
    }
}
