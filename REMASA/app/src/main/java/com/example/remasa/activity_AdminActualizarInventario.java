package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.remasa.adapter.ProductoAdapter;
import com.example.remasa.model.Producto;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class activity_AdminActualizarInventario extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnAdminInventario, btnActualizarInventario, btnAdminCuenta, btnCuenta;
    ImageView iVBanner, btn_agregar, ivmodif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_actualizar_inventario);

        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnAdminInventario = findViewById(R.id.btnAdminInventario);
        btnActualizarInventario = findViewById(R.id.btnActualizarInventario);
        btnAdminCuenta = findViewById(R.id.btnAdminCuenta);
        btnCuenta = findViewById(R.id.btnCuenta);
        iVBanner = findViewById(R.id.iVBanner);
        btn_agregar = findViewById(R.id.btn_agregar);
        ivmodif = findViewById(R.id.ivmodif);

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
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CrearArticuloFragment fm = new CrearArticuloFragment();
                fm.show(getSupportFragmentManager(),"Navegar a fragment");
            }
        });
        //------------------------------------------------------------------------------------------
        ivmodif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(), activity_AdminModificarProducto.class);
                startActivity(siguiente);
            }
        });

    }
}