package com.example.tarea_checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CheckBox fresa;
    private CheckBox manzana;
    private CheckBox naranja;
    private TextView textoFrutas;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            fresa = findViewById(R.id.fresa);
            manzana = findViewById(R.id.manzana);
            naranja = findViewById(R.id.naranja);
            textoFrutas = findViewById(R.id.frutas);
            button = findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    frutasSeleccionadas();
                }
            });

            return insets;
        });
    }

    private void frutasSeleccionadas() {
        ArrayList<String> frutas = new ArrayList<>();

        if (fresa.isChecked()) {
            frutas.add("Fresa");
        }
        if (manzana.isChecked()) {
            frutas.add("Manzana");
        }
        if (naranja.isChecked()) {
            frutas.add("Naranja");
        }

        String frutasCadena = String.join(",", frutas);
        textoFrutas.setText(frutasCadena.isEmpty() ? "No hay fruta seleccionada" : frutasCadena);
    }

}