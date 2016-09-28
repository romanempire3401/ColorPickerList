package edu.temple.lab3test;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MacBookPro on 9/27/16.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<ColorPick> colorList;

    public CustomAdapter(Context context, ArrayList<ColorPick> colorList) {
        this.context = context;
        this.colorList = colorList;
    }

    @Override
    public int getCount(){
        return colorList.size();
    }

    @Override
    public Object getItem(int position) {
        return colorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout = (LinearLayout) convertView;

        if(linearLayout != null) {
            TextView colorName = (TextView) linearLayout.getChildAt(0);

            colorName.setText(colorList.get(position).getColorName());
        } else {
            linearLayout = new LinearLayout(this.context);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            TextView nameTextView = new TextView(this.context);

            nameTextView.setText(colorList.get(position).getColorName());
            nameTextView.setTextSize(50);
            nameTextView.setMaxWidth(800);
            nameTextView.setTextColor(Color.BLACK);
            nameTextView.setBackgroundColor(getColor(position));

            linearLayout.addView(nameTextView);
        }

        return linearLayout;
    }

    private int getColor(int position){
        String colorPicked = colorList.get(position).getColorName();
        int theColor;

        switch (colorPicked){
            case "RED":
                theColor = Color.RED;
                break;
            case "GREEN":
                theColor = Color.GREEN;
                break;
            case "BLUE":
                theColor = Color.BLUE;
                break;
            case "CYAN":
                theColor = Color.CYAN;
                break;
            case "DKGRAY":
                theColor = Color.DKGRAY;
                break;
            default:
                theColor = Color.WHITE;
                break;
        }
        return theColor;
    }
}
