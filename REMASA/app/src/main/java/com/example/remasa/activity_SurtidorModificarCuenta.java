package com.example.remasa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.remasa.adapter.ProdAdapter;
import com.example.remasa.model.Producto;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.HashMap;
import java.util.Map;

public class activity_SurtidorModificarCuenta extends AppCompatActivity {

    ImageView iVBanner;
    TextView tVusuario, tVNombre, tVCorreo, tVContraseña;
    ImageButton btnHome, btnCatalogo, btnPedidosFinalizados, btnPedidosEnProceso, btnNuevosPedidos, btnCuenta;
    EditText eTNombre, eTCorreo, eTContraseña;
    Button btnGuardar;
    private FirebaseFirestore mfirestore;
    String id_prdct = "KxhJ38LfoGlGiMwsl3ZA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surtidor_modificar_cuenta);

        mfirestore = FirebaseFirestore.getInstance();

        tVusuario = findViewById(R.id.tVusuario);
        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnNuevosPedidos = findViewById(R.id.btnNuevosPedidos);
        btnPedidosEnProceso = findViewById(R.id.btnPedidosEnProceso);
        btnPedidosFinalizados = findViewById(R.id.btnPedidosFinalizados);
        btnCuenta = findViewById(R.id.btnCuenta);
        iVBanner = findViewById(R.id.iVBanner);
        tVNombre = findViewById(R.id.tVNombre);
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
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String contraUs = eTContraseña.getText().toString().trim();
                String correoUs = eTCorreo.getText().toString().trim();
                String nombreUs = eTNombre.getText().toString().trim();


                if(contraUs.isEmpty() || correoUs.isEmpty() || nombreUs.isEmpty()){
                    Toast.makeText(activity_SurtidorModificarCuenta.this, "Llena todos los campos", Toast.LENGTH_LONG).show();
                }else{
                    updateUsuario(contraUs, correoUs, nombreUs);
                }
            }
        });
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