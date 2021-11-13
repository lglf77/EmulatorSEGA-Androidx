package com.games.sega.genesis;

import android.app.Activity;
import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdView;

/*
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.d;
 */

public class AdPreference extends Preference {
    public AdPreference(Context context) {
        super(context);
    }

    public AdPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        AdView adView = new AdView((Activity) getContext());
        adView.setAdSize(d.a);
        adView.setAdUnitId("ca-app-pub-8207906625354307/7183554679");
        ((LinearLayout) onCreateView).addView(adView);
        adView.a(new c.a().a());
        return onCreateView;
    }

}
