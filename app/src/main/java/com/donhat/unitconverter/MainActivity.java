package com.donhat.unitconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText weightsInKilosEditText;
    private TextView weightsInPoundsTextView;

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

        // Get view instances
        weightsInKilosEditText = findViewById(R.id.weights_in_kilos_edit_text);
        weightsInPoundsTextView = findViewById(R.id.weights_in_pounds_text_view);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(v1 -> {
            String inputText = weightsInKilosEditText.getText().toString().trim();

            try {
                double kilos = Double.parseDouble(inputText);

                double pounds = makeConversion(kilos);

                weightsInPoundsTextView.setText("" + pounds);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Cannot parse this value!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private double makeConversion(double kilos) {
        return kilos * 2.20462;
    }
}