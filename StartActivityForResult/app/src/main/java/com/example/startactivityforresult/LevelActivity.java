package com.example.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LevelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        TextView tvNiveauActuel = findViewById(R.id.tvNiveauActuel);
        Button btnPrecedent = findViewById(R.id.btnPrecedent);
        int niveau = getIntent().getIntExtra("niveau", 1);
        tvNiveauActuel.setText("Niveau actuel : " + niveau);
        btnPrecedent.setOnClickListener(view -> finish());
    }
}