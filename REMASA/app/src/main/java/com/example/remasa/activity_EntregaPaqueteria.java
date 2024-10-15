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
import android.widget.Toast;

public class activity_EntregaPaqueteria extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnCarrito, btnWA, btnCuenta;
    ImageView iVBanner, iVBack;
    Button btnRegresar, btnContinuar;
    TextView tVDatosDeQuienRecibe, tVNombre, tVDireccion, tVCiudad, tVEstado, tVCP, tVTelefono;
    EditText eTNombre, eTDireccion, eTCiudad, eTEstado, eTCP, eTTelefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrega_paqueteria);

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
        tVNombre = findViewById(R.id.tVFecha);
        tVDireccion = findViewById(R.id.tVDireccion);
        tVCiudad = findViewById(R.id.tVCiudad);
        tVEstado = findViewById(R.id.tVEstado);
        tVCP = findViewById(R.id.tVCP);
        tVTelefono = findViewById(R.id.tVTelefono);
        eTNombre = findViewById(R.id.eTNombre);
        eTDireccion = findViewById(R.id.eTDireccion);
        eTCiudad = findViewById(R.id.eTCiudad);
        eTEstado = findViewById(R.id.eTEstado);
        eTCP = findViewById(R.id.eTCP);
        eTTelefono = findViewById(R.id.eTTelefono);

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
                String nombre =eTNombre.getText().toString();
                String direccion =eTDireccion.getText().toString();
                String ciudad =eTCiudad.getText().toString();
                String estado =eTEstado.getText().toString();
                String cp =eTCP.getText().toString();
                String telefono =eTTelefono.getText().toString();

                if(!nombre.equals("") &&(!direccion.equals(""))&&(!ciudad.equals(""))&&
                        (!estado.equals(""))&&(!cp.equals(""))&&(!telefono.equals(""))){
                    Intent siguiente = new Intent(getApplicationContext(), activity_DatosDeTransferencia.class);
                    startActivity(siguiente);
                }else{
                    Toast.makeText(activity_EntregaPaqueteria.this,"Llena todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}