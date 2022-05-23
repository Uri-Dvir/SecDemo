package com.example.secdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEncrypt = findViewById(R.id.buttonEncrypt);
        btnEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText plain = findViewById(R.id.plain);
                String plainText = plain.getText().toString();
                EditText encrypted = findViewById(R.id.encrypted);
                encrypted.setText(SecurityHelper.Encrypt(plainText));
            }
        });

        Button btnDecrypt = findViewById(R.id.buttonDecrypt);
        btnDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText encrypted = findViewById(R.id.encrypted);
                String encryptedText = encrypted.getText().toString();
                EditText plain = findViewById(R.id.plain);
                plain.setText(SecurityHelper.Decrypt(encryptedText));
            }
        });
    }
}