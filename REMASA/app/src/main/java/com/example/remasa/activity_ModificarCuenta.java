package com.example.remasa;

import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class activity_ModificarCuenta extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnCarrito, btnWA, btnCuenta;
    ImageView iVBanner;
    TextView tVNombre, tVCorreo, tVDireccion, tVCiudad, tVEstado, tVCP, tVContraseña, tVTelefono;
    EditText eTNombre, eTCorreo, eTDireccion, eTCiudad, eTEstado, eTCodigoPostal, eTContraseña, eTTelefono;
    Button btnGuardar;
    ScrollView scrollView;
    private FirebaseFirestore mfirestore;
    String id_prdct = "H6695xHDKhWl2XTFyWiB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_cuenta);

        mfirestore = FirebaseFirestore.getInstance();

        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnCarrito = findViewById(R.id.btnCarrito);
        btnWA = findViewById(R.id.btnWA);
        iVBanner = findViewById(R.id.iVBanner);
        btnCuenta = findViewById(R.id.btnCuenta);
        tVNombre = findViewById(R.id.tVFecha);
        eTNombre = findViewById(R.id.eTNombre);
        tVCorreo = findViewById(R.id.tVCorreo);
        eTCorreo = findViewById(R.id.eTCorreo);
        tVDireccion = findViewById(R.id.tVDireccion);
        eTDireccion = findViewById(R.id.eTDireccion);
        tVCiudad = findViewById(R.id.tVCiudad);
        eTCiudad = findViewById(R.id.eTCiudad);
        tVEstado = findViewById(R.id.tVEstado);
        eTEstado = findViewById(R.id.eTEstado);
        tVCP = findViewById(R.id.tVCP);
        eTCodigoPostal = findViewById(R.id.eTCodigoPostal);
        tVContraseña = findViewById(R.id.tVContraseña);
        eTContraseña = findViewById(R.id.eTContraseña);
        tVTelefono = findViewById(R.id.tVTelefono);
        eTTelefono = findViewById(R.id.eTTelefono);
        btnGuardar = findViewById(R.id.btnGuardar);
        scrollView = findViewById(R.id.scrollView);

        getUsuario(id_prdct);
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
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombreUs = eTNombre.getText().toString().trim();
                String dirUs = eTDireccion.getText().toString().trim();
                String ciudadUs = eTCiudad.getText().toString().trim();
                String estadoUs = eTEstado.getText().toString().trim();
                int codpUs = Integer.parseInt(eTCodigoPostal.getText().toString().trim());
                String contraUs = eTContraseña.getText().toString().trim();
                String telUs = eTTelefono.getText().toString().trim();
                String correoUs = eTCorreo.getText().toString().trim();


                if (contraUs.isEmpty() || correoUs.isEmpty() || nombreUs.isEmpty()
                        || dirUs.isEmpty() || ciudadUs.isEmpty() || estadoUs.isEmpty()
                        || Objects.equals(codpUs, "") || telUs.isEmpty()) {
                    Toast.makeText(activity_ModificarCuenta.this, "Llena todos los campos", Toast.LENGTH_LONG).show();
                } else {
                    updateUsuario(contraUs, correoUs, nombreUs, dirUs, ciudadUs, estadoUs, codpUs, telUs);
                }
            }

        });
    }
    private void getUsuario(String id_prdct){
        mfirestore.collection("Usuario").document(id_prdct).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                String nombreUs = documentSnapshot.getString("nombre");
                String dirUs = documentSnapshot.getString("direccion");
                String ciudadUs = documentSnapshot.getString("ciudad");
                String estadoUs = documentSnapshot.getString("estado");
                int codpUs = parseInt(documentSnapshot.get("codigopostal").toString());
                String contraUs = documentSnapshot.getString("contraseña");
                String telUs = documentSnapshot.getString("telefono");
                String apellidosUs = documentSnapshot.getString("apellidos");
                String correoUs = documentSnapshot.getString("correo");
                String TipoUs = documentSnapshot.getString("tipousuario");

                eTNombre.setText(nombreUs);
                eTDireccion.setText(dirUs);
                eTCiudad.setText(ciudadUs);
                eTEstado.setText(estadoUs);
                eTCodigoPostal.setText(Integer.toString(codpUs));
                eTContraseña.setText(contraUs);
                eTTelefono.setText(telUs);
                eTCorreo.setText(correoUs);


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error al obtener los datos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateUsuario(String contraUs, String correoUs, String nombreUs, String dirUs, String ciudadUs,
                               String estadoUs, int codpUs, String telUs) {
        Map<String, Object> map = new HashMap<>();

        map.put("nombre", nombreUs);
        map.put("direccion", dirUs);
        map.put("cuidad", ciudadUs);
        map.put("estado", estadoUs);
        map.put("codigopostal", codpUs);
        map.put("telefono", telUs);
        map.put("correo", correoUs);
        map.put("contraseña", contraUs);




        mfirestore.collection("Usuario").document(id_prdct).update(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getApplicationContext(), "Actualizado exitosamente", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error al actualizar", Toast.LENGTH_SHORT).show();
            }
        });
        /*eTNombre.setText("");
        eTCorreo.setText("");
        eTContraseña.setText("");*/
    }
}