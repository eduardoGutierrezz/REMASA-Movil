package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class activityPresentacion extends AppCompatActivity {

    //-----Declarar elementos del activity_presentacion xml-----------------------------------------

     ImageButton btnHome, btnCatalogo, btnCarrito, btnWA, btnCuenta;
     Button btnVerCatalogo;
     ImageView imageView3, imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actuvity_presentacion);

        //Enlazar los elementos de xml y main activity java-----------------------------------------
        btnVerCatalogo = findViewById(R.id.btnVerCatalogo);
        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnCarrito = findViewById(R.id.btnCarrito);
        btnWA = findViewById(R.id.btnWA);
        btnCuenta = findViewById(R.id.btnCuenta);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);

        //---------Metodos OnClick para los botones-------------------------------------------------

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activityPresentacion.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------

        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activityCatalogo.class);
                startActivity(siguiente);

            }
        });
        //__________________________________________________________________________________________

        btnCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

<<<<<<< HEAD
                Intent siguiente = new Intent(getApplicationContext(), activyCarrito.class);
=======
                Intent siguiente = new Intent(getApplicationContext(), ActivityEnDesarrolloAnuncio.class);
>>>>>>> ad70d40881c1ec55fd4670aac7c5ba724507bd1e
                startActivity(siguiente);
            }
        });
        //__________________________________________________________________________________________

        btnWA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(), activityContactanos.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Intent siguiente = new Intent(getApplicationContext(), activity_CuentaUsuario.class);
=======
                Intent siguiente = new Intent(getApplicationContext(), ActivityEnDesarrolloAnuncio.class);
>>>>>>> ad70d40881c1ec55fd4670aac7c5ba724507bd1e
                startActivity(siguiente);
            }
        });

        btnVerCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activityCatalogo.class);
                startActivity(siguiente);

            }
        });

    }
}