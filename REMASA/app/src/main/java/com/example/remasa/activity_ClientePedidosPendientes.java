package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

public class activity_ClientePedidosPendientes extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnCarrito, btnWA, btnCuenta;
    ImageView iVBanner;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_pedidos_pendientes);

        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnCarrito = findViewById(R.id.btnCarrito);
        btnWA = findViewById(R.id.btnWA);
        iVBanner = findViewById(R.id.iVBanner);
        btnCuenta = findViewById(R.id.btnCuenta);
        listView = findViewById(R.id.listView);

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

                Intent siguiente = new Intent(getApplicationContext(), activyCarrito.class);
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
        //__________________________________________________________________________________________
        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(), activity_CuentaUsuario.class);
                startActivity(siguiente);
            }
        });
    }
}