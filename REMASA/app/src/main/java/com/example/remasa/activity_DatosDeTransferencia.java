package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_DatosDeTransferencia extends AppCompatActivity {

    ImageView iVTituloDatos, iVTransferenciaInfo, iVFavorDeEnviar, iVBanner, iVBack;
    TextView tVTotal, tVMxn;
    EditText eTPrecio, eTCorreos, eTCorreos2;
    Button btnRegresar, btnContinuar;
    ImageButton btnHome, btnCatalogo, btnCarrito, btnWA, btnCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_de_transferencia);

        iVBack = findViewById(R.id.iVBack);
        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnCarrito = findViewById(R.id.btnCarrito);
        btnWA = findViewById(R.id.btnWA);
        iVBanner = findViewById(R.id.iVBanner);
        btnCuenta = findViewById(R.id.btnCuenta);
        eTCorreos = findViewById(R.id.eTCorreos);
        eTCorreos2 = findViewById(R.id.eTCorreos2);
        eTPrecio = findViewById(R.id.eTPrecio);
        tVMxn = findViewById(R.id.tVMxn);
        tVTotal = findViewById(R.id.tVTotal);
        iVTituloDatos = findViewById(R.id.iVTituloDatos);
        iVTransferenciaInfo = findViewById(R.id.iVTransferenciaInfo);
        iVFavorDeEnviar = findViewById(R.id.iVFavorDeEnviar);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnContinuar = findViewById(R.id.btnContinuar);

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
        //__________________________________________________________________________________________
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(), activity_EntregaPaqueteria.class);
                startActivity(siguiente);
            }
        });
        //__________________________________________________________________________________________
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(), activityConfPedido.class);
                startActivity(siguiente);
            }
        });
    }
}