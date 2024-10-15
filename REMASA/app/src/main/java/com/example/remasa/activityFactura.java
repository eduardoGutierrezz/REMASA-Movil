package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class activityFactura extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnCarrito, btnWA, btnCuenta;
    ImageView iVBanner, iVFormulario;
    TextView tVNombre, tVRFC, tVRegimenFiscal, tVDireccion, tVCiudad, tVEstado, tVCP, tVCorreo;
    EditText eTNombre, eTRFC, eTDireccion, eTCiudad, eTEstado, eTCP, eTCorreo;
    Button btnSolicitarFactura;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnCarrito = findViewById(R.id.btnCarrito);
        btnWA = findViewById(R.id.btnWA);
        iVBanner = findViewById(R.id.iVBanner);
        btnCuenta = findViewById(R.id.btnCuenta);
        iVFormulario = findViewById(R.id.iVFormulario);
        tVNombre = findViewById(R.id.tVFecha);
        eTNombre = findViewById(R.id.eTNombre);
        tVRFC = findViewById(R.id.tVRFC);
        eTRFC = findViewById(R.id.eTRFC);
        tVRegimenFiscal = findViewById(R.id.tVRegimenFiscal);
        tVDireccion = findViewById(R.id.tVDireccion);
        eTDireccion = findViewById(R.id.eTDireccion);
        tVCiudad = findViewById(R.id.tVCiudad);
        eTCiudad = findViewById(R.id.eTCiudad);
        tVEstado = findViewById(R.id.tVEstado);
        eTEstado = findViewById(R.id.eTEstado);
        tVCP = findViewById(R.id.tVCP);
        eTCP = findViewById(R.id.eTCP);
        tVCorreo = findViewById(R.id.tVCorreo);
        eTCorreo = findViewById(R.id.eTCorreo);
        btnSolicitarFactura = findViewById(R.id.btnSolicitarFactura);
        spinner = findViewById(R.id.spinner);

        String [] opciones = {"Régimen simplificado de confianza", "Sueldos y salarios e ingresos asimilados a salarios", "Régimen de actividades empresariales y profesionales",
        "Régimen de incorporación fiscal", "Enajenación de bienes", "Régimen de actividades empresariales con ingresos a través de plataformas tecnológicas", "Régimen de arrendamiento",
        "Intereses", "obtención de premios", "Dividendos", "Demás ingresos"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_personalizacion, opciones);
        spinner.setAdapter(adapter);

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
        btnSolicitarFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = eTNombre.getText().toString();
                String rfc = eTRFC.getText().toString();
                String direccion = eTDireccion.getText().toString();
                String ciudad = eTCiudad.getText().toString();
                String estado = eTEstado.getText().toString();
                String cp = eTCP.getText().toString();
                String correo = eTCorreo.getText().toString();

                if((!nombre.equals(""))&&(!rfc.equals(""))&&(!direccion.equals(""))&&(!ciudad.equals(""))
                &&(!estado.equals(""))&&(!cp.equals(""))&&(!correo.equals(""))){
                    Toast.makeText(activityFactura.this, "Datos guardados correctamente, generando factura", Toast.LENGTH_LONG).show();;
                } else{
                    Toast.makeText(activityFactura.this,"Llena todos los campos", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}

/*<ImageView
        android:id="@+id/iVBack"
        android:layout_width="418dp"
        android:layout_height="738dp"
        android:layout_marginTop="-1dp"
        android:src="@drawable/fondofacturacion"
        app:layout_constraintTop_toTopOf="parent"
        tools:layout_editor_absoluteX="-3dp"
        tools:ignore="MissingConstraints" />*/