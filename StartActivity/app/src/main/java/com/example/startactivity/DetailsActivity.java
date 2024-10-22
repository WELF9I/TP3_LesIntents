package com.example.startactivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        String nom = intent.getStringExtra("nom");
        String age = intent.getStringExtra("age");
        String siteWeb = intent.getStringExtra("siteWeb");
        String telephone = intent.getStringExtra("telephone");

        TextView tvNom = findViewById(R.id.tvNom);
        TextView tvAge = findViewById(R.id.tvAge);
        TextView tvSiteWeb = findViewById(R.id.tvSiteWeb);
        TextView tvTelephone = findViewById(R.id.tvTelephone);

        tvNom.setText("Nom: " + nom);
        tvAge.setText("Âge: " + age);
        tvSiteWeb.setText("Site Web: " + siteWeb);
        tvTelephone.setText("Téléphone: " + telephone);

        Button btnOk = findViewById(R.id.btnOk);
        Button btnRetour = findViewById(R.id.btnRetour);

        btnOk.setOnClickListener(v -> {
            Intent finalIntent = new Intent(this, FinalActivity.class);
            startActivity(finalIntent);
        });
        btnRetour.setOnClickListener(v -> finish());
    }
}