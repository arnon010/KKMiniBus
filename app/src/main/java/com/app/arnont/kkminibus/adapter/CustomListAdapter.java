package com.app.arnont.kkminibus.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.arnont.kkminibus.R;


/**
 * Created by arnont on 2/22/18.
 */

public class CustomListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the animal images
    private final Integer[] imageIDarray;

    //to store the list of countries
    private final String[] nameArray;

    //to store the list of countries
    private final String[] infoArray;

    public CustomListAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam, Integer[] imageIDArrayParam){

        super(context, R.layout.listview_layout , nameArrayParam);

        this.context=context;
        this.imageIDarray = imageIDArrayParam;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;

    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_layout, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView firstLine = rowView.findViewById(R.id.firstLine);
        TextView secondLine = rowView.findViewById(R.id.secondLine);
        ImageView icon = rowView.findViewById(R.id.icon);

        //this code sets the values of the objects to values from the arrays
        firstLine.setText(nameArray[position]);
        secondLine.setText(infoArray[position]);
        icon.setImageResource(imageIDarray[position]);

        return rowView;

    };


}
