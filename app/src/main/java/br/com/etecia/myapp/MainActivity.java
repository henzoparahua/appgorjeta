package br.com.etecia.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextView txtTotal, txtValor;
    Button btnConfirmar;
    TextInputEditText iptValor;
    Spinner spinner;
    Double value, gorj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtValor = findViewById(R.id.txtValor);
        txtTotal = findViewById(R.id.txtTotal);
        btnConfirmar = findViewById(R.id.btnCalcular);
        iptValor = findViewById(R.id.valor);
        spinner = findViewById(R.id.spinner);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state = spinner.getSelectedItem().toString();
                if (!TextUtils.isEmpty(iptValor.getText())){
                    value = Double.parseDouble(iptValor.getText().toString());
                    switch (state){
                        case "Excelente – 10%":
                            gorj = value*0.1;
                            value = gorj + value;
                            txtValor.setText(String.format("%.2f", gorj));
                            txtTotal.setText(value.toString());
                            break;
                        case "Ótimo – 8%":
                            gorj = value*0.08;
                            value = gorj + value;
                            txtValor.setText(gorj.toString());
                            txtTotal.setText(value.toString());
                            break;
                        case "Bom – 5%":
                            gorj = value*0.05;
                            value = gorj + value;
                            txtValor.setText(gorj.toString());
                            txtTotal.setText(value.toString());
                            break;
                        case "Ruim – 2%":
                            gorj = value*0.02;
                            value = gorj + value;
                            txtValor.setText(String.format("%.2f", gorj));
                            txtTotal.setText(value.toString());
                            break;
                        default:
                            break;
                    }
                } else {
                    txtTotal.setText("0");
                    txtValor.setText("0");
                }
                }
        });
    }
}