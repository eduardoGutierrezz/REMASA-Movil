package com.example.remasa;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class activity_AdminModificarCuenta extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnAdminInventario, btnActualizarInventario, btnAdminCuenta, btnCuenta;
    ImageView iVBanner;
    TextView tVusuario, tVFecha, tVContraseña, tVCorreo;
    EditText eTNombre, eTCorreo, eTContraseña;
    Button btnGuardar;
    private FirebaseFirestore mfirestore;
    String id_prdct = "zFUdZHUHgr6YsAsvrGwS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_modificar_cuenta);

        mfirestore = FirebaseFirestore.getInstance();

        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnAdminInventario = findViewById(R.id.btnAdminInventario);
        btnActualizarInventario = findViewById(R.id.btnActualizarInventario);
        btnAdminCuenta = findViewById(R.id.btnAdminCuenta);
        btnCuenta = findViewById(R.id.btnCuenta);
        iVBanner = findViewById(R.id.iVBanner);
        tVusuario = findViewById(R.id.tVusuario);
        tVFecha = findViewById(R.id.tVFecha);
        eTNombre = findViewById(R.id.eTNombre);
        tVCorreo = findViewById(R.id.tVCorreo);
        eTCorreo = findViewById(R.id.eTCorreo);
        tVContraseña = findViewById(R.id.tVContraseña);
        eTContraseña = findViewById(R.id.eTContraseña);
        btnGuardar = findViewById(R.id.btnGuardar);

        tVusuario.setText(Usuario.nombre);

        getUsuario(id_prdct);
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
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String contraUs = eTContraseña.getText().toString().trim();
                String correoUs = eTCorreo.getText().toString().trim();
                String nombreUs = eTNombre.getText().toString().trim();


                if(contraUs.isEmpty() || correoUs.isEmpty() || nombreUs.isEmpty()){
                    Toast.makeText(activity_AdminModificarCuenta.this, "Llena todos los campos", Toast.LENGTH_LONG).show();
                }else{
                    updateUsuario(contraUs, correoUs, nombreUs);
                }

            }
        });
        //------------------------------------------------------------------------------------------
    }

    private void getUsuario(String id_prdct){
        mfirestore.collection("Usuario").document(id_prdct).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                String apellidosUs = documentSnapshot.getString("apellidos");
                String contraUs = documentSnapshot.getString("contraseña");
                String correoUs = documentSnapshot.getString("correo");
                String nombreUs = documentSnapshot.getString("nombre");
                String TipoUs = documentSnapshot.getString("tipousuario");

                eTNombre.setText(nombreUs);
                eTCorreo.setText(correoUs);
                eTContraseña.setText(contraUs);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error al obtener los datos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateUsuario(String contraUs, String correoUs, String nombreUs) {
        Map<String, Object> map = new HashMap<>();
        map.put("contraseña", contraUs);
        map.put("correo", correoUs);
        map.put("nombre", nombreUs);


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
        eTNombre.setText("");
        eTCorreo.setText("");
        eTContraseña.setText("");
    }
}