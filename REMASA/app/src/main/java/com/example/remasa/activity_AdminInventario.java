package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.remasa.adapter.AdapterInventario;
import com.example.remasa.model.Producto;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class activity_AdminInventario extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnAdminInventario, btnActualizarInventario, btnAdminCuenta, btnCuenta;
    ImageView iVBanner;

    //-----
    AdapterInventario mAdapter;
    RecyclerView mRecycler;
    FirebaseFirestore mFirestore;
    Query query;
    //----

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_inventario);

        //Consulta a bd
        mFirestore = FirebaseFirestore.getInstance();
        mRecycler = findViewById(R.id.RvProdct);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        query = mFirestore.collection("Producto");

        FirestoreRecyclerOptions<Producto> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Producto>().setQuery(query, Producto.class).build();

        mAdapter = new AdapterInventario(firestoreRecyclerOptions, this, getSupportFragmentManager());
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

        mRecycler.setItemAnimator(null);
        //Consulta bd

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

        //------------------------------------------------------------------------------------------
    }
    //Consulta bd
    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }
    //Consulta bd
}