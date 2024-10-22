package com.example.startactivityforresult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvQuote;
    private ActivityResultLauncher<Intent> colorActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnChangeColor = findViewById(R.id.btnChangeColor);
        tvQuote = findViewById(R.id.tvQuote);
        colorActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String color = result.getData().getStringExtra("selected_color");
                        if (color != null) {
                            tvQuote.setBackgroundColor(Color.parseColor(color));
                        }
                    }
                }
        );

        btnChangeColor.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ColorActivity.class);
            colorActivityLauncher.launch(intent);
        });
    }
}