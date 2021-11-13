package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;

import androidx.annotation.Keep;

/*
import com.google.android.gms.ads.b;
import com.google.android.gms.ads.b.f;
import com.google.android.gms.ads.b.g;
import com.google.android.gms.ads.b.h;
import com.google.android.gms.ads.b.i;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.g;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.b;
import com.google.android.gms.ads.mediation.h;
import com.google.android.gms.ads.mediation.k;
import com.google.android.gms.ads.mediation.l;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.internal.aot;
import com.google.android.gms.internal.app;
import com.google.android.gms.internal.ara;
import com.google.android.gms.internal.bfk;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.jn;
import com.google.android.gms.internal.zzapc;
 */
import java.util.Date;
import java.util.Set;

@bfk
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, k, l, MediationRewardedVideoAdAdapter, zzapc {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzgt;
    private g zzgu;
    private com.google.android.gms.ads.b zzgv;
    private Context zzgw;
    /* access modifiers changed from: private */
    public g zzgx;
    /* access modifiers changed from: private */
    public com.google.android.gms.ads.reward.mediation.a zzgy;
    private com.google.android.gms.ads.reward.c zzgz = new g(this);

    static class a extends com.google.android.gms.ads.mediation.g {
        private final com.google.android.gms.ads.b.g e;

        public a(com.google.android.gms.ads.b.g gVar) {
            this.e = gVar;
            a(gVar.b().toString());
            a(gVar.c());
            b(gVar.d().toString());
            a(gVar.e());
            c(gVar.f().toString());
            if (gVar.g() != null) {
                a(gVar.g().doubleValue());
            }
            if (gVar.h() != null) {
                d(gVar.h().toString());
            }
            if (gVar.i() != null) {
                e(gVar.i().toString());
            }
            a(true);
            b(true);
            a(gVar.j());
        }

        public final void a(View view) {
            if (view instanceof com.google.android.gms.ads.b.e) {
                ((com.google.android.gms.ads.b.e) view).setNativeAd(this.e);
            }
            f fVar = f.a.get(view);
            if (fVar != null) {
                fVar.a(this.e);
            }
        }
    }

    static class b extends h {
        private final com.google.android.gms.ads.b.h e;

        public b(com.google.android.gms.ads.b.h hVar) {
            this.e = hVar;
            a(hVar.b().toString());
            a(hVar.c());
            b(hVar.d().toString());
            if (hVar.e() != null) {
                a(hVar.e());
            }
            c(hVar.f().toString());
            d(hVar.g().toString());
            a(true);
            b(true);
            a(hVar.h());
        }

        public final void a(View view) {
            if (view instanceof com.google.android.gms.ads.b.e) {
                ((com.google.android.gms.ads.b.e) view).setNativeAd(this.e);
            }
            f fVar = f.a.get(view);
            if (fVar != null) {
                fVar.a(this.e);
            }
        }
    }

    static final class c extends com.google.android.gms.ads.a implements com.google.android.gms.ads.a.a, aot {
        private AbstractAdViewAdapter a;
        private com.google.android.gms.ads.mediation.c b;

        public c(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.c cVar) {
            this.a = abstractAdViewAdapter;
            this.b = cVar;
        }

        public final void a() {
            this.b.a(this.a);
        }

        public final void a(int i) {
            this.b.a(this.a, i);
        }

        public final void a(String str, String str2) {
            this.b.a(this.a, str, str2);
        }

        public final void b() {
            this.b.b(this.a);
        }

        public final void c() {
            this.b.c(this.a);
        }

        public final void d() {
            this.b.d(this.a);
        }

        public final void e() {
            this.b.e(this.a);
        }
    }

    static final class d extends com.google.android.gms.ads.a implements aot {
        private AbstractAdViewAdapter a;
        private com.google.android.gms.ads.mediation.d b;

        public d(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.d dVar) {
            this.a = abstractAdViewAdapter;
            this.b = dVar;
        }

        public final void a() {
            this.b.a(this.a);
        }

        public final void a(int i) {
            this.b.a(this.a, i);
        }

        public final void b() {
            this.b.b(this.a);
        }

        public final void c() {
            this.b.c(this.a);
        }

        public final void d() {
            this.b.d(this.a);
        }

        public final void e() {
            this.b.e(this.a);
        }
    }

    static final class e extends com.google.android.gms.ads.a implements g.a, h.a, i.a, i.b {
        private AbstractAdViewAdapter a;
        private com.google.android.gms.ads.mediation.e b;

        public e(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.e eVar) {
            this.a = abstractAdViewAdapter;
            this.b = eVar;
        }

        public final void a() {
        }

        public final void a(int i) {
            this.b.a((MediationNativeAdapter) this.a, i);
        }

        public final void a(com.google.android.gms.ads.b.g gVar) {
            this.b.a((MediationNativeAdapter) this.a, (com.google.android.gms.ads.mediation.f) new a(gVar));
        }

        public final void a(com.google.android.gms.ads.b.h hVar) {
            this.b.a((MediationNativeAdapter) this.a, (com.google.android.gms.ads.mediation.f) new b(hVar));
        }

        public final void a(i iVar) {
            this.b.a((MediationNativeAdapter) this.a, iVar);
        }

        public final void a(i iVar, String str) {
            this.b.a(this.a, iVar, str);
        }

        public final void b() {
            this.b.a(this.a);
        }

        public final void c() {
            this.b.b(this.a);
        }

        public final void d() {
            this.b.c(this.a);
        }

        public final void e() {
            this.b.d(this.a);
        }

        public final void f() {
            this.b.e(this.a);
        }
    }

    private final com.google.android.gms.ads.c zza(Context context, com.google.android.gms.ads.mediation.a aVar, Bundle bundle, Bundle bundle2) {
        c.a aVar2 = new c.a();
        Date a2 = aVar.a();
        if (a2 != null) {
            aVar2.a(a2);
        }
        int b2 = aVar.b();
        if (b2 != 0) {
            aVar2.a(b2);
        }
        Set<String> c2 = aVar.c();
        if (c2 != null) {
            for (String a3 : c2) {
                aVar2.a(a3);
            }
        }
        Location d2 = aVar.d();
        if (d2 != null) {
            aVar2.a(d2);
        }
        if (aVar.f()) {
            app.a();
            aVar2.b(jc.a(context));
        }
        if (aVar.e() != -1) {
            aVar2.a(aVar.e() == 1);
        }
        aVar2.b(aVar.g());
        aVar2.a(AdMobAdapter.class, zza(bundle, bundle2));
        return aVar2.a();
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzgt;
    }

    public Bundle getInterstitialAdapterInfo() {
        return new b.a().a(1).a();
    }

    public ara getVideoController() {
        com.google.android.gms.ads.i videoController;
        if (this.zzgt == null || (videoController = this.zzgt.getVideoController()) == null) {
            return null;
        }
        return videoController.a();
    }

    public void initialize(Context context, com.google.android.gms.ads.mediation.a aVar, String str, com.google.android.gms.ads.reward.mediation.a aVar2, Bundle bundle, Bundle bundle2) {
        this.zzgw = context.getApplicationContext();
        this.zzgy = aVar2;
        this.zzgy.a(this);
    }

    public boolean isInitialized() {
        return this.zzgy != null;
    }

    public void loadAd(com.google.android.gms.ads.mediation.a aVar, Bundle bundle, Bundle bundle2) {
        if (this.zzgw == null || this.zzgy == null) {
            jn.c("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzgx = new com.google.android.gms.ads.g(this.zzgw);
        this.zzgx.a(true);
        this.zzgx.a(getAdUnitId(bundle));
        this.zzgx.a(this.zzgz);
        this.zzgx.a(zza(this.zzgw, aVar, bundle2, bundle));
    }

    public void onDestroy() {
        if (this.zzgt != null) {
            this.zzgt.c();
            this.zzgt = null;
        }
        if (this.zzgu != null) {
            this.zzgu = null;
        }
        if (this.zzgv != null) {
            this.zzgv = null;
        }
        if (this.zzgx != null) {
            this.zzgx = null;
        }
    }

    public void onImmersiveModeUpdated(boolean z) {
        if (this.zzgu != null) {
            this.zzgu.b(z);
        }
        if (this.zzgx != null) {
            this.zzgx.b(z);
        }
    }

    public void onPause() {
        if (this.zzgt != null) {
            this.zzgt.b();
        }
    }

    public void onResume() {
        if (this.zzgt != null) {
            this.zzgt.a();
        }
    }

    public void requestBannerAd(Context context, com.google.android.gms.ads.mediation.c cVar, Bundle bundle, com.google.android.gms.ads.d dVar, com.google.android.gms.ads.mediation.a aVar, Bundle bundle2) {
        this.zzgt = new AdView(context);
        this.zzgt.setAdSize(new com.google.android.gms.ads.d(dVar.b(), dVar.a()));
        this.zzgt.setAdUnitId(getAdUnitId(bundle));
        this.zzgt.setAdListener(new c(this, cVar));
        this.zzgt.a(zza(context, aVar, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, com.google.android.gms.ads.mediation.d dVar, Bundle bundle, com.google.android.gms.ads.mediation.a aVar, Bundle bundle2) {
        this.zzgu = new com.google.android.gms.ads.g(context);
        this.zzgu.a(getAdUnitId(bundle));
        this.zzgu.a((com.google.android.gms.ads.a) new d(this, dVar));
        this.zzgu.a(zza(context, aVar, bundle2, bundle));
    }

    public void requestNativeAd(Context context, com.google.android.gms.ads.mediation.e eVar, Bundle bundle, com.google.android.gms.ads.mediation.i iVar, Bundle bundle2) {
        e eVar2 = new e(this, eVar);
        b.a a2 = new b.a(context, bundle.getString(AD_UNIT_ID_PARAMETER)).a((com.google.android.gms.ads.a) eVar2);
        com.google.android.gms.ads.b.d h = iVar.h();
        if (h != null) {
            a2.a(h);
        }
        if (iVar.i()) {
            a2.a((g.a) eVar2);
        }
        if (iVar.j()) {
            a2.a((h.a) eVar2);
        }
        if (iVar.k()) {
            for (String next : iVar.l().keySet()) {
                a2.a(next, eVar2, iVar.l().get(next).booleanValue() ? eVar2 : null);
            }
        }
        this.zzgv = a2.a();
        this.zzgv.a(zza(context, iVar, bundle2, bundle));
    }

    public void showInterstitial() {
        this.zzgu.b();
    }

    public void showVideo() {
        this.zzgx.b();
    }

    /* access modifiers changed from: protected */
    public abstract Bundle zza(Bundle bundle, Bundle bundle2);
}
