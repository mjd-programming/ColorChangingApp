package edu.temple.colorchangingapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        String color = getIntent().getStringExtra("color_parser");
        String color_parser = getIntent().getStringExtra("color");
        findViewById(R.id.canvas_id).setBackgroundColor(Color.parseColor(color_parser));
        TextView canvasText = findViewById(R.id.canvas_text);
        canvasText.setText(color);
    }
}