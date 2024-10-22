package com.example.startactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.util.Patterns;

public class MainActivity extends AppCompatActivity {
    private EditText editNom, editAge, editSiteWeb, editTelephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNom = findViewById(R.id.editNom);
        editAge = findViewById(R.id.editAge);
        editSiteWeb = findViewById(R.id.editSiteWeb);
        editTelephone = findViewById(R.id.editTelephone);
        Button btnValider = findViewById(R.id.btnValider);

        btnValider.setOnClickListener(v -> validateAndProceed());
    }

    private void validateAndProceed() {
        boolean isValid = true;
        String nom = editNom.getText().toString().trim();
        if (nom.isEmpty()) {
            editNom.setBackgroundColor(Color.RED);
            isValid = false;
        } else {
            editNom.setBackgroundColor(Color.GREEN);
        }

        String age = editAge.getText().toString().trim();
        if (age.isEmpty() || !age.matches("\\d+")) {
            editAge.setBackgroundColor(Color.RED);
            isValid = false;
        } else {
            editAge.setBackgroundColor(Color.GREEN);
        }

        String siteWeb = editSiteWeb.getText().toString().trim();
        if (siteWeb.isEmpty() || !Patterns.WEB_URL.matcher(siteWeb).matches()) {
            editSiteWeb.setBackgroundColor(Color.RED);
            isValid = false;
        } else {
            editSiteWeb.setBackgroundColor(Color.GREEN);
        }
        String telephone = editTelephone.getText().toString().trim();
        if (telephone.isEmpty() || !Patterns.PHONE.matcher(telephone).matches()) {
            editTelephone.setBackgroundColor(Color.RED);
            isValid = false;
        } else {
            editTelephone.setBackgroundColor(Color.GREEN);
        }

        if (isValid) {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("nom", nom);
            intent.putExtra("age", age);
            intent.putExtra("siteWeb", siteWeb);
            intent.putExtra("telephone", telephone);
            startActivity(intent);
        }
    }
}