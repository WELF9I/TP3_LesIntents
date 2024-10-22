package com.example.lesintentsimplicites;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private static final int CALL_PERMISSION_REQUEST = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        Button btnCall = findViewById(R.id.btnCall);
        Button btnDial = findViewById(R.id.btnDial);
        Button btnWeb = findViewById(R.id.btnWeb);
        Button btnAppManager = findViewById(R.id.btnAppManager);
        Button btnWifi = findViewById(R.id.btnWifi);

        btnCall.setOnClickListener(view -> {
            String number = editText.getText().toString();
            if (!number.isEmpty()) {
                makePhoneCall(number);
            } else {
                Toast.makeText(this, "Veuillez entrer un numéro", Toast.LENGTH_SHORT).show();
            }
        });
        btnDial.setOnClickListener(view -> {
            String number = editText.getText().toString();
            if (!number.isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            } else {
                Toast.makeText(this, "Veuillez entrer un numéro", Toast.LENGTH_SHORT).show();
            }
        });
        btnWeb.setOnClickListener(view -> {
            String url = editText.getText().toString();
            if (!url.isEmpty()) {
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url;
                }
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            } else {
                Toast.makeText(this, "Veuillez entrer une URL", Toast.LENGTH_SHORT).show();
            }
        });
        btnAppManager.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
            startActivity(intent);
        });
        btnWifi.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
            startActivity(intent);
        });
    }

    private void makePhoneCall(String number) {
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION_REQUEST);
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CALL_PERMISSION_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                String number = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            } else {
                Toast.makeText(this, "Permission refusée", Toast.LENGTH_SHORT).show();
            }
        }
    }
}