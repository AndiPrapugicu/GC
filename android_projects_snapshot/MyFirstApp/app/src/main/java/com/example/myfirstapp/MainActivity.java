package com.example.myfirstapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        Button buttonChangeColor = findViewById(R.id.buttonChangeColor);

        int[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.BLACK};
        int[] index = {0};

        buttonChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setTextColor(colors[index[0]]);
                Toast.makeText(MainActivity.this, "Culoarea s-a schimbat!", Toast.LENGTH_SHORT).show();
                index[0] = (index[0] + 1) % colors.length;
            }
        });
    }
}
