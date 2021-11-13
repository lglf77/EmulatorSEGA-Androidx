package com.games.sega.genesis;

import android.app.Application;

public class App extends Application {
    private Long a;

    public Long a() {
        return this.a;
    }

    public void a(Long l) {
        this.a = l;
    }

    public Long b() {
        // return Long.valueOf(System.currentTimeMillis() / 1000);
        return System.currentTimeMillis() / 1000;
    }
}
