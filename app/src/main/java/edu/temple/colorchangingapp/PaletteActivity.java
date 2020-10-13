package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class PaletteActivity extends AppCompatActivity {

    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = PaletteActivity.this.getResources();
        final String[] color = res.getStringArray(R.array.colors_parser);
        final String[] color_parser = res.getStringArray(R.array.colors);

        grid = findViewById(R.id.grid_view);
        grid.setAdapter(new ColorAdapter(this, color, color_parser));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent colorIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                colorIntent.putExtra("color", color[i]);
                colorIntent.putExtra("color_parser", color_parser[i]);
                startActivity(colorIntent);
            }
        });
    }
}

class ColorAdapter extends BaseAdapter {

    private Context context;
    private String[] colors;
    private String[] colors_parser;

    public ColorAdapter(Context context, String[] colors, String[] colors_parser) {
        super();
        this.context = context;
        this.colors = colors;
        this.colors_parser = colors_parser;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int i) {
        return colors[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String current_color = colors[i];
        String current_color_parser = colors_parser[i];
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View v = inflater.inflate(R.layout.activity_canvas, viewGroup, false);
        TextView color_name = v.findViewById(R.id.color_text);
        color_name.setText(current_color_parser);
        v.setBackgroundColor(Color.parseColor(current_color));
        return v;
    }
}
