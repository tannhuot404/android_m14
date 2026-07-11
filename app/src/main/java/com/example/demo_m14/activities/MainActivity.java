package com.example.demo_m14.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demo_m14.R;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvHello;
    Button btn1;
    TextInputLayout txtUsernameLayout;
    TextInputEditText txtUsername;
    CheckBox checkboxOption1;
    CheckBox checkboxOption2;
    RadioGroup rdGroupGender;
    MaterialSwitch switchNotification;
    SeekBar volumSlider;
    ProgressBar loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvHello = findViewById(R.id.tvHello);
        tvHello.setText(R.string.hello_android);

        handleButton();
    }

    private void handleButton() {
        btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        ImageButton imgButton = findViewById(R.id.img_btn);
        Button btnGoToLogin = findViewById(R.id.btnGoToLogin);

        /*
        // Anoynimous Inner Class
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button 1 Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Lamda Expression
        btn2.setOnClickListener(view -> {
            ConstraintLayout rootView = findViewById(R.id.main);
            Snackbar.make(rootView, "Button 2 Click", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", v -> { })
                    .show();
        });
         */

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        imgButton.setOnClickListener(this);
        btnGoToLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn1) {
            Toast.makeText(MainActivity.this, "Button 1 Clicked", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btn2) {
            ConstraintLayout rootView = findViewById(R.id.main);
            Snackbar.make(rootView, "Button 2 Click", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", view -> {
                        btn1.setEnabled(true);
                    })
                    .show();
        } else if (v.getId() == R.id.btn3) {

        } else if (v.getId() == R.id.img_btn) {

        } else if (v.getId() == R.id.btnGoToLogin) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.putExtra("username", "username@email.com");
            startActivity(intent);
        }
    }
}