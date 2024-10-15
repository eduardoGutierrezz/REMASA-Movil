package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class activity_SurtidorPedidosEnProceso extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnPedidosFinalizados, btnPedidosEnProceso, btnNuevosPedidos, btnCuenta;
    ImageView iVBanner;
    TextView tVPedido, tVFecha, tVTelefono;
    ListView lVPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surtidor_pedidos_en_proceso);

        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnPedidosFinalizados = findViewById(R.id.btnPedidosFinalizados);
        btnPedidosEnProceso = findViewById(R.id.btnPedidosEnProceso);
        btnNuevosPedidos = findViewById(R.id.btnNuevosPedidos);
        btnCuenta = findViewById(R.id.btnCuenta);
        iVBanner = findViewById(R.id.iVBanner);
        tVPedido = findViewById(R.id.tVPedido);
        tVFecha = findViewById(R.id.tVFecha);
        tVTelefono = findViewById(R.id.tVTelefono);
        lVPedidos = findViewById(R.id.lVPedidos);

        //---------Metodos OnClick para los botones-------------------------------------------------

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_SurtidorMenu.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_SurtidorCatalogo.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnPedidosFinalizados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_SurtidorPedidosFinalizados.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnPedidosEnProceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_SurtidorPedidosEnProceso.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnNuevosPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_SurtidorNuevosPedidos.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_SurtidorCuenta.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
    }
}