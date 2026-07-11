package com.example.demo_m14.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demo_m14.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout txtUsernameLayout;
    TextInputLayout txtPasswordLayout;
    TextView txtUsername;
    TextView txtPassword;

    Button btnLogin;

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            var defaultPadding = getResources().getDimensionPixelSize(R.dimen.default_padding);
            var keyboardPadding = insets.getInsets(WindowInsetsCompat.Type.ime()); //Input Method Editor
            v.setPadding(systemBars.left + defaultPadding,
                    systemBars.top,
                    systemBars.right + defaultPadding,
                    systemBars.bottom + keyboardPadding.bottom);
            return insets;
        });

        btnLogin = findViewById(R.id.btnLogin);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            finish();
        });

        setupTextEditText();

        Intent recieveIntent = getIntent();
        txtUsername.setText(recieveIntent.getStringExtra("username"));
    }

    private void validation() {
//        if (txtUsername.getText().toString().isEmpty() ||
//                txtPassword.getText().toString().isEmpty()) {
//            btnLogin.setEnabled(false);
//        } else {
//            btnLogin.setEnabled(true);
//        }
    }

    private  void setupTextEditText() {
        txtUsernameLayout = findViewById(R.id.txtusernameLayout);
        txtPasswordLayout = findViewById(R.id.txtPasswordLayout);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);

        var textChangeListener = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d("Text Change", s.toString());
                validation();
            }
        };

        txtUsername.addTextChangedListener(textChangeListener);
        txtPassword.addTextChangedListener(textChangeListener);
    }
}