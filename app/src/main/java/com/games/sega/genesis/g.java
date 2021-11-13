package com.games.sega.genesis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class g extends ArrayAdapter<f> {
    private int a = -1;

    public g(Context context, int i, f[] fVarArr) {
        super(context, i, fVarArr);
    }

    public void a(int i) {
        this.a = i;
        notifyDataSetChanged();
    }

    @SuppressLint("WrongConstant") // retirar depois
    public View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        if (view == null) {
            view = ((LayoutInflater) getContext().getSystemService("layout_inflater"))
                    .inflate(R.layout.custom_key_view, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.txtExample);
        if (this.a == i) {
            textView.setBackgroundColor(getContext().getResources().getColor(R.color.orange));
            view.setBackgroundColor(-65536);
            obj = " (Press any button to set new key) ";
        } else {
            textView.setBackgroundColor(getContext().getResources().getColor(R.color.black));
            view.setBackgroundColor(-16777216);
            obj = "";
        }
        // textView.setText(String.format("%1$s %2$s", new Object[]{((f) getItem(i)).toString(), obj}));
        textView.setText(String.format("%1$s %2$s", ((f) getItem(i)).toString(), obj ));
        return view;
    }
}
