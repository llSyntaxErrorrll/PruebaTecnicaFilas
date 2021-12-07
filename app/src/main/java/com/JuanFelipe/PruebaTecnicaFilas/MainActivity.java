package com.JuanFelipe.PruebaTecnicaFilas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    //declaracion de variables
    private int numberRows;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void drawRows(){
        //imrpimir las filas
        StringBuilder resultado = new StringBuilder();
        for(int i=1; i<=numberRows; i++){

            //repetir hasta finalizar
            StringBuilder row = new StringBuilder();
            for (int x=1; x<=i; x++){
                row.append(" * ");
            }

            //agregar fila mas salto de linea
            row.append("\n");
            resultado.append(row);
        }

        //imrprimir resultado
        txtResult.setText(resultado.toString());
    }

    private void getNumberRows(){
        //obtener info
        TextInputLayout tilNumero = findViewById(R.id.til_numero);
        String textoANumero = tilNumero.getEditText().getText().toString();

        if(!textoANumero.isEmpty() && !textoANumero.equals("0")){
            //imrpimir datos
            numberRows = Integer.parseInt(textoANumero);
            drawRows();
        }else{
            Toast.makeText(this, getString(R.string.ingrese), Toast.LENGTH_SHORT).show();
        }

    }

    private void init(){
        //inicializa eventos
        numberRows = 0;
        txtResult = findViewById(R.id.txt_result);
        setOnClickListener();
    }

    private void setOnClickListener(){
        //boton aceptar
        Button btnAceptar = findViewById(R.id.btn_aceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumberRows();
            }
        });
    }
}