package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText peso, altura;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.editpeso);
        altura = findViewById(R.id.editaltura);
        resultado = findViewById(R.id.textresultado);

    }

    public void Calcularimc (View view) {
        String EditTextpeso = peso.getText().toString();
        String EditTextaltura = altura.getText().toString();
        boolean CamposValidos = validarCampos(EditTextpeso,EditTextaltura);
        if (CamposValidos) {
            Double valorpeso = Double.parseDouble(EditTextpeso);
            Double valoraltura = Double.parseDouble(EditTextaltura);
            double resul = (valorpeso) / (valoraltura * valoraltura);
            if (resul <= 18.5) {
                resultado.setText("Abaixo do peso ");
            } else {
            }
            if (resul >= 18.5 && resul <= 24.9) {
                resultado.setText("Peso Normal");
            }
            if (resul >= 25 && resul <= 29.9) {
                resultado.setText("Sobrepeso");
            }
            if (resul >= 30 && resul <= 34.9) {
                resultado.setText("Obesidade Grau I");
            }
            if (resul >= 35 && resul <= 39.9) {
                resultado.setText("Obesidade Grau II");
            }
            if (resul >= 40) {
                resultado.setText("Obesidade Grau III / Mórbida");
            }
        }
    }

    public boolean validarCampos(String ppeso, String paltura) {
        boolean camposValidos = true;
        if (ppeso == null || ppeso.equals("")) {
            camposValidos = false;
        } else if (paltura == null || paltura.equals("")) {
            camposValidos = false;
        }
        return camposValidos;
    }
}
