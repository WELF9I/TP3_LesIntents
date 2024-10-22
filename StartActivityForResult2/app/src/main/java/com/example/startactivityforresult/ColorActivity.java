package com.example.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        Button btnRed = findViewById(R.id.btnRed);
        Button btnYellow = findViewById(R.id.btnYellow);
        Button btnBlue = findViewById(R.id.btnBlue);
        Button btnGreen = findViewById(R.id.btnGreen);

        btnRed.setOnClickListener(view -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("selected_color", "#FF0000");
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        btnYellow.setOnClickListener(view -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("selected_color", "#FFEB3B");
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        btnBlue.setOnClickListener(view -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("selected_color", "#0000FF");
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        btnGreen.setOnClickListener(view -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("selected_color", "#4CAF50");
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}