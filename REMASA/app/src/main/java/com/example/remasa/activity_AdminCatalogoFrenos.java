package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

public class activity_AdminCatalogoFrenos extends AppCompatActivity {

    ListView lVCatalogo;
    ImageButton btnHome, btnCatalogo, btnAdminInventario, btnActualizarInventario, btnAdminCuenta, btnCuenta;
    ImageView iVBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_catalogo_frenos);

        lVCatalogo = findViewById(R.id.lVCatalogo);
        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnAdminInventario = findViewById(R.id.btnAdminInventario);
        btnActualizarInventario = findViewById(R.id.btnActualizarInventario);
        btnAdminCuenta = findViewById(R.id.btnAdminCuenta);
        btnCuenta = findViewById(R.id.btnCuenta);
        iVBanner = findViewById(R.id.iVBanner);

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

                Intent siguiente = new Intent(getApplicationContext(), activity_AdminMenu.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_AdminMenu.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
    }
}