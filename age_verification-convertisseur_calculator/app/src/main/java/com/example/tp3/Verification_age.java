package com.example.tp3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Verification_age extends AppCompatActivity {
    private EditText editTextName, editTextDob;
    private Button buttonVerifier, buttonQuitter;
    private TextView textViewResult;
    private SimpleDateFormat sdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verification_age);

//        name
        editTextName = findViewById(R.id.nameEditText);
//        date of birth editext
        editTextDob = findViewById(R.id.dobEditText);
        buttonVerifier = findViewById(R.id.verifyButton);
        buttonQuitter = findViewById(R.id.quitButton);
//        result
        textViewResult = findViewById(R.id.textViewResult);

        sdf = new SimpleDateFormat("yyyy-MM-dd");

//        button event verifier calls function verifier
        buttonVerifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAge();
            }
        });

//        button auitter handler
        buttonQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Ferme l'activité, terminant l'application
            }
        });
    }

    private void verifyAge() {
//        extract data from both input
        String name = editTextName.getText().toString();
        String dob = editTextDob.getText().toString();

        try {
            if (!name.isEmpty() && !dob.isEmpty()) {
//                        sdf = new SimpleDateFormat("yyyy-MM-dd"); deja defini
                Date parsedDate = sdf.parse(dob);
                Date dateNow = new Date();
//                now - date of birth = age
                long diffInMillies = Math.abs(dateNow.getTime() - parsedDate.getTime());
                long diff = diffInMillies / (1000 * 60 * 60 * 24 * 365);

                if (diff >= 18) {
                    textViewResult.setText("Vous avez plus de 18 ans.");
                } else {
                    textViewResult.setText("Vous avez moins de 18 ans.");
                }
            } else {
                textViewResult.setText("Veuillez remplir tous les champs.");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
