import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber1, editTextNumber2;
    private Button buttonCalculer, buttonInitialiser, buttonQuitter;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        buttonCalculer = findViewById(R.id.buttonCalculer);
        buttonInitialiser = findViewById(R.id.buttonInitialiser);
        buttonQuitter = findViewById(R.id.buttonQuitter);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSum();
            }
        });

        buttonInitialiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeFields();
            }
        });

        buttonQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Ferme l'activité, terminant l'application
            }
        });
    }

    private void calculateSum() {
        String input1 = editTextNumber1.getText().toString();
        String input2 = editTextNumber2.getText().toString();

        if (!input1.isEmpty() && !input2.isEmpty()) {
            double number1 = Double.parseDouble(input1);
            double number2 = Double.parseDouble(input2);

            double sum = number1 + number2;

            textViewResult.setText("La somme est : " + sum);
        } else {
            textViewResult.setText("Veuillez entrer deux nombres.");
        }
    }

    private void initializeFields() {
        editTextNumber1.setText("");
        editTextNumber2.setText("");
        textViewResult.setText("");
    }
}
