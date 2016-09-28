package edu.temple.lab3test;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PalletteActivity extends Activity {
    public static String MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallette);

        ArrayList<ColorPick> colorArray = new ArrayList<>();
        colorArray.add(new ColorPick("RED"));
        colorArray.add(new ColorPick("GREEN"));
        colorArray.add(new ColorPick("BLUE"));
        colorArray.add(new ColorPick("CYAN"));
        colorArray.add(new ColorPick("DKGRAY"));
        colorArray.add(new ColorPick("WHITE"));

        CustomAdapter customAdapter = new CustomAdapter(this, colorArray);

        ListView listView = (ListView) findViewById(R.id.colorList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sendMessage(parent, position);
            }
        });
    }

    public void sendMessage(AdapterView parent, int position){
        Intent intent = new Intent(this, CanvasActivity.class);
        String message = ((ColorPick)parent.getItemAtPosition(position)).getColorName();
        intent.putExtra(MESSAGE, message);
        startActivity(intent);
    }
}
