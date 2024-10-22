package com.example.startactivityforresult;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Integer score = 0;
    private Integer niveau = 1;
    private TextView tvScore;
    private TextView tvNiveau;

    private ActivityResultLauncher<Intent> levelActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClick = findViewById(R.id.btnClick);
        Button btnRejouer = findViewById(R.id.btnRejouer);
        tvScore = findViewById(R.id.tvScore);
        tvNiveau = findViewById(R.id.tvNiveau);
        levelActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                }
        );

        btnClick.setOnClickListener(view -> {
            score++;
            tvScore.setText("Score: " + score);
            if (score % 5 == 0) {
                niveau++;
                tvNiveau.setText("Niveau: " + niveau);
                Toast.makeText(this, "Passage au niveau suivant!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, LevelActivity.class);
                intent.putExtra("niveau", niveau);
                levelActivityLauncher.launch(intent);
            }
        });
        btnRejouer.setOnClickListener(view -> {
            score = 0;
            niveau = 1;
            tvScore.setText("Score: " + score);
            tvNiveau.setText("Niveau: " + niveau);
        });
    }
}