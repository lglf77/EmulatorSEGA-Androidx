package com.games.sega.genesis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class d extends ArrayAdapter<h> implements SectionIndexer {
    HashMap<String, Integer> a;
    String[] b;
    private Context c;
    private int d;
    private List<h> e;

    public d(Context context, int i, List<h> list) {
        super(context, i, list);
        this.c = context;
        this.d = i;
        this.e = list;
        a();
    }

    private void a() {
        this.a = new HashMap<>();
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            String upperCase = this.e.get(i).a().substring(0, 1).toUpperCase(Locale.getDefault());
            if (!this.a.containsKey(upperCase)) {
                this.a.put(upperCase, Integer.valueOf(i));
            }
        }
        ArrayList arrayList = new ArrayList(this.a.keySet());
        Collections.sort(arrayList);
        this.b = new String[arrayList.size()];
        arrayList.toArray(this.b);
    }

    /* renamed from: a */
    public h getItem(int i) {
        return this.e.get(i);
    }

    public int getPositionForSection(int i) {
        if (i >= this.b.length) {
            return 0;
        }
        return this.a.get(this.b[i]).intValue();
    }

    public int getSectionForPosition(int i) {
        return 1;
    }

    public Object[] getSections() {
        return this.b;
    }

    @SuppressLint("WrongConstant") // Retirar depois
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.c.getSystemService("layout_inflater")).inflate(this.d, (ViewGroup) null);
        }
        h hVar = this.e.get(i);
        if (hVar != null) {
            TextView textView = (TextView) view.findViewById(R.id.TextView01);
            TextView textView2 = (TextView) view.findViewById(R.id.TextView02);
            if (textView != null) {
                textView.setText(hVar.a());
            }
            if (textView2 != null) {
                textView2.setText(hVar.b());
            }
        }
        return view;
    }
}
