package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class activity_EntregaEnSucursal extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnCarrito, btnWA, btnCuenta;
    ImageView iVBanner, iVBack;
    Button btnRegresar, btnContinuar;
    TextView tVDatosDeQuienRecibe;
    RadioButton rBPagarEnSucursal, rBPagarConTransferencia;
    EditText eTNombre, eTTelefono, eTPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrega_en_sucursal);

        iVBack = findViewById(R.id.iVBack);
        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnCarrito = findViewById(R.id.btnCarrito);
        btnWA = findViewById(R.id.btnWA);
        iVBanner = findViewById(R.id.iVBanner);
        btnCuenta = findViewById(R.id.btnCuenta);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnContinuar = findViewById(R.id.btnContinuar);
        tVDatosDeQuienRecibe = findViewById(R.id.tVDatosDeQuienRecibe);
        rBPagarEnSucursal = findViewById(R.id.rBPagarEnSucursal);
        rBPagarConTransferencia = findViewById(R.id.rBPagarConTransferencia);
        eTNombre = findViewById(R.id.eTNombre);
        eTTelefono = findViewById(R.id.eTTelefono);
        eTPrecio = findViewById(R.id.eTPrecio);

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
                Intent siguiente = new Intent(getApplicationContext(), activity_TipoDeEntrega.class);
                startActivity(siguiente);
            }
        });
        //__________________________________________________________________________________________
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = eTNombre.getText().toString();
                String telefono = eTTelefono.getText().toString();

                if(rBPagarEnSucursal.isChecked()&&(!nombre.equals(""))&&(!telefono.equals(""))){
                Intent siguiente = new Intent(getApplicationContext(), activityConfPedido.class);
                startActivity(siguiente);
                } else if (rBPagarConTransferencia.isChecked()) {
                    Intent siguiente = new Intent(getApplicationContext(), activity_DatosDeTransferencia.class);
                    startActivity(siguiente);
                }else{
                    Toast.makeText(activity_EntregaEnSucursal.this,"Selecciona una opción de pago para continuar y llene todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}