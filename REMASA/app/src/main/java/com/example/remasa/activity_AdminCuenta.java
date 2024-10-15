package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_AdminCuenta extends AppCompatActivity {

    TextView tVusuario;
    ImageButton btnHome, btnCatalogo, btnAdminInventario, btnActualizarInventario, btnAdminCuenta, btnCuenta;
    ImageView iVBanner, iVCerrarSesionn, iVModificarCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_cuenta);

        tVusuario = findViewById(R.id.tVusuario);
        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnAdminInventario = findViewById(R.id.btnAdminInventario);
        btnActualizarInventario = findViewById(R.id.btnActualizarInventario);
        btnAdminCuenta = findViewById(R.id.btnAdminCuenta);
        btnCuenta = findViewById(R.id.btnCuenta);
        iVBanner = findViewById(R.id.iVBanner);
        iVModificarCuenta = findViewById(R.id.iVModificarCuenta);
        iVCerrarSesionn = findViewById(R.id.iVCerrarSesionn);

        tVusuario.setText(Usuario.nombre);

        //---------Metodos OnClick para los botones-------------------------------------------------

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_AdminMenu.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_AdminCatalogo.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnAdminInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_AdminInventario.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnActualizarInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_AdminActualizarInventario.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnAdminCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_AdminCuenta.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_AdminCuenta.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        iVCerrarSesionn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), MainActivity2activityLoggeo.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        iVModificarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_AdminModificarCuenta.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
    }
}