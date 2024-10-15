package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class activity_FacturacionInfo extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnCarrito, btnWA, btnCuenta;
    ImageView iVBanner, iVParaFacturarSuPedido;
    Button btnContinuar;
    EditText eTCorreos, eTCorreos2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturacion_info);

        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnCarrito = findViewById(R.id.btnCarrito);
        btnWA = findViewById(R.id.btnWA);
        iVBanner = findViewById(R.id.iVBanner);
        btnCuenta = findViewById(R.id.btnCuenta);
        iVParaFacturarSuPedido = findViewById(R.id.iVParaFacturarSuPedido);
        btnContinuar = findViewById(R.id.btnContinuar);
        eTCorreos = findViewById(R.id.eTCorreos);
        eTCorreos2 = findViewById(R.id.eTCorreos2);

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

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(), activityPresentacion.class);
                startActivity(siguiente);
            }
        });
    }
}