package com.daddyhok.loginpanel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etKey = findViewById(R.id.etKey);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String enteredKey = etKey.getText().toString().trim().toUpperCase();

            String[] validKeys = {
                "DADDYHOK-VIP-2026",
                "ADMIN-ACCESS-001",
                "LIFETIME-KEY-999"
            };

            boolean isValid = false;
            for (String key : validKeys) {
                if (enteredKey.equals(key)) {
                    isValid = true;
                    break;
                }
            }

            if (isValid) {
                Toast.makeText(this, "Access Granted!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid License Key!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
