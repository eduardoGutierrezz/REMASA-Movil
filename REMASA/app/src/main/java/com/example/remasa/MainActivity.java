package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //-----Declarar elementos del activity main xml-------------------------------------------------

    public Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlazar los elementos de xml y main activity java-----------------------------------------

        btnIniciar = findViewById(R.id.btnIniciar);

        //-----Metodo OnClick para el btnIniciar----------------------------------------------------

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), MainActivity2activityLoggeo.class);
                startActivity(siguiente);
            }
        });
    }
}