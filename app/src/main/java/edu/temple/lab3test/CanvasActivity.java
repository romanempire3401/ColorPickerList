package edu.temple.lab3test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class CanvasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent intent = getIntent();
        String message;

        if((message = intent.getStringExtra(PalletteActivity.MESSAGE)) == null) {
            message = "WHITE";
        } else {
            switch (message){
                case "RED":
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                    break;
                case "GREEN":
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                    break;
                case "BLUE":
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                    break;
                case "CYAN":
                    getWindow().getDecorView().setBackgroundColor(Color.CYAN);
                    break;
                case "DKGRAY":
                    getWindow().getDecorView().setBackgroundColor(Color.DKGRAY);
                    break;
                case "WHITE":
                    getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                    break;
                default:
                    getWindow().getDecorView().setBackgroundColor(Color.WHITE);
            }
        }
    }
}
