package com.games.sega.genesis;

import java.util.Locale;

public class h implements Comparable<h> {
    private String a;
    private String b;
    private String c;

    public h(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    /* renamed from: a */
    public int compareTo(h hVar) {
        if (this.a != null) {
            return this.a.toLowerCase(Locale.getDefault()).compareTo(hVar.a()
                    .toLowerCase(Locale.getDefault()));
        }
        throw new IllegalArgumentException();
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
