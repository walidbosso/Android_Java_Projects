package com.example.tp3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Calculatrice extends AppCompatActivity {

    private EditText number1Input, number2Input;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculatrice);

        number1Input = findViewById(R.id.number1Input);
        number2Input = findViewById(R.id.number2Input);
        resultTextView = findViewById(R.id.resultTextView);

        Button addButton = findViewById(R.id.addButton);
        Button subtractButton = findViewById(R.id.subtractButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        Button divideButton = findViewById(R.id.divideButton);
        Button quitButton = findViewById(R.id.quitButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the activity
            }
        });
    }

    private void calculate(char operation) {
        if (!number1Input.getText().toString().isEmpty() && !number2Input.getText().toString().isEmpty()) {
            double number1 = Double.parseDouble(number1Input.getText().toString());
            double number2 = Double.parseDouble(number2Input.getText().toString());
            double result = 0;

            switch (operation) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        resultTextView.setText("Impossible de diviser par zéro");
                        return;
                    }
                    break;
            }

            resultTextView.setText(String.valueOf(result));
        }else{
            resultTextView.setText("Veuillez remplir tous les champs.");
        }
    }
}
