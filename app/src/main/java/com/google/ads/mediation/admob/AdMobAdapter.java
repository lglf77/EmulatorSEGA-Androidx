package com.google.ads.mediation.admob;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;

import com.google.ads.mediation.AbstractAdViewAdapter;

@Keep
public final class AdMobAdapter extends AbstractAdViewAdapter {
    /* access modifiers changed from: protected */
    public final Bundle zza(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        return bundle;
    }
}
