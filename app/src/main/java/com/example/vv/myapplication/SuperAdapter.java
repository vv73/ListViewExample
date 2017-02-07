package com.example.vv.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vv on 07.02.2017.
 */
public class SuperAdapter extends ArrayAdapter<String> {
   SuperAdapter(Context context, String[] array)
   {
       super(context, R.layout.myitem, array);
   }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView =
                    LayoutInflater.from(getContext())
                            .inflate(R.layout.myitem, null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.mytext);
        textView.setText(getItem(position));
        textView.setBackgroundColor(Color.rgb(position, position, position));
        final int pos = position;
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), getItem(pos), Toast.LENGTH_SHORT).show();
            }
        });
    return convertView;
    }
}
