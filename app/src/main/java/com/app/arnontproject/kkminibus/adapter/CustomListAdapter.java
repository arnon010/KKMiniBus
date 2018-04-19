package com.app.arnontproject.kkminibus.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.arnontproject.kkminibus.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by arnont on 2/22/18.
 */

public class CustomListAdapter extends ArrayAdapter<MiniBus> {


    // private List<DrinksList> items = null; // no use
    private ArrayList<MiniBus> arraylist;
    public CustomListAdapter(Context context, int layoutId, List<MiniBus> items) {
            super(context, layoutId, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View arrayView = convertView;
            if(arrayView == null){
            LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
            arrayView = vi.inflate(R.layout.listview_layout, parent, false);
            }

            MiniBus currentPosition = getItem(position);
            if(currentPosition != null){
            ImageView image = arrayView.findViewById(R.id.icon);
            image.setImageResource(currentPosition.getImageID());

            TextView name = arrayView.findViewById(R.id.firstLine);
            name.setText(currentPosition.getName());

            TextView info = arrayView.findViewById(R.id.secondLine);
            info.setText(currentPosition.getInfo());
            }
            return arrayView;
    }
}


