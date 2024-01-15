package com.example.tp3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Convertisseur extends AppCompatActivity {

    private Spinner currencySpinner;
    private EditText amountInput , amountInput2 ;
    private TextView resultText;
    private Button convertButton , quitButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convertisseur);

        currencySpinner = findViewById(R.id.currencySpinner);
        amountInput = findViewById(R.id.amountInput);
        resultText = findViewById(R.id.amountInput2);

//        add data we have in values strings  <string-array name="currency_array">
//        <item>Dollar américain</item> etc to Spinner

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertButton();
            }
        });
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the activity
            }
        });
    }

    public void convertButton() {
            double amount = Double.parseDouble(amountInput.getText().toString());
        double convertedAmount = 0;

        String selectedCurrency = currencySpinner.getSelectedItem().toString();

        switch (selectedCurrency) {
            case "Dollar américain":
                convertedAmount = amount * 9.86;
                break;
            case "Dollar canadien":
                convertedAmount = amount * 7.03;
                break;
            case "Euro":
                convertedAmount = amount * 11.02;
                break;
        }

        String result = String.format("%.2f", convertedAmount) ;
        resultText.setText(result);
    }
}
