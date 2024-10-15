package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.remasa.adapter.ProdAdapter;
import com.example.remasa.model.Producto;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class activity_SurtidorPedidosEnProceso extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnPedidosFinalizados, btnPedidosEnProceso, btnNuevosPedidos, btnCuenta;
    ImageView iVBanner;
    Button finalizarPed;
    TextView tVPedido, tVFecha, tVTelefono;
    //-----
    ProdAdapter mAdapter;
    RecyclerView mRecycler;
    FirebaseFirestore mFirestore;
    Query query;
    //----

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surtidor_pedidos_en_proceso);

        //Consulta a bd
        mFirestore = FirebaseFirestore.getInstance();
        mRecycler = findViewById(R.id.RvProdct);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        query = mFirestore.collection("Producto");

        FirestoreRecyclerOptions<Producto> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Producto>().setQuery(query, Producto.class).build();

        mAdapter = new ProdAdapter(firestoreRecyclerOptions, this, getSupportFragmentManager());
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

        mRecycler.setItemAnimator(null);
        //Consulta bd

        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnPedidosFinalizados = findViewById(R.id.btnPedidosFinalizados);
        btnPedidosEnProceso = findViewById(R.id.btnPedidosEnProceso);
        btnNuevosPedidos = findViewById(R.id.btnNuevosPedidos);
        btnCuenta = findViewById(R.id.btnCuenta);
        iVBanner = findViewById(R.id.iVBanner);
        finalizarPed = findViewById(R.id.finalizarPed);

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

        finalizarPed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecycler.setVisibility(View.GONE);
            }
        });
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