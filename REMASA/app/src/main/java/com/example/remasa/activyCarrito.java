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

import com.example.remasa.adapter.AdapterFragmentCarrito;
import com.example.remasa.model.Detalleventa;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class activyCarrito extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnCarrito, btnWA, btnCuenta;
    ImageView iVBanner;
    EditText eTPerecioTotal;
    TextView tVTotal, tVMxn;
    Button btnRegresar, btnContinuar;
    RecyclerView RvProdct;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activy_carrito);

        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnCarrito = findViewById(R.id.btnCarrito);
        btnWA = findViewById(R.id.btnWA);
        iVBanner = findViewById(R.id.iVBanner);
        btnCuenta = findViewById(R.id.btnCuenta);
        eTPerecioTotal = findViewById(R.id.eTPerecioTotal);
        tVTotal = findViewById(R.id.tVTotal);
        tVMxn = findViewById(R.id.tVMxn);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnContinuar = findViewById(R.id.btnContinuar);
        RvProdct = findViewById(R.id.RvProdct);




        //------------------------------------------------------------------------------------------
        // Supongamos que tienes una referencia a la colección "productos"
        CollectionReference productosRef = FirebaseFirestore.getInstance().collection("Detalleventa");

// Definir el precio a filtrar (por ejemplo, 100)
        int idFiltrar = 9;

// Crear una consulta para filtrar documentos con el mismo precio
        Query consulta = productosRef.whereEqualTo("idventa", idFiltrar);

// Ejecutar la consulta y obtener los resultados
        /*consulta.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    // Obtener información de cada documento
                    int idventa = documentSnapshot.getLong("precio").intValue();

                    // Acceder a los datos del documento
                    int cantidadProducto = documentSnapshot.getLong("cantidad").intValue();
                    String descripcionProducto = documentSnapshot.getString("contraseña");
                    String idProducto = documentSnapshot.getString("idproducto");
                    int precioTotal = documentSnapshot.getLong("preciototal").intValue();
                    int precioUnitario = documentSnapshot.getLong("preciounitario").intValue();

                    // Aquí puedes realizar las acciones que necesites con la información obtenida
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Manejar el error si la consulta falla
            }
        });*/
        //------------------------------------------------------------------------------------------

// Definir la consulta los productos dentro detalle venta filtrando por idVenta
        Query query = FirebaseFirestore.getInstance().collection("Detalleventa").whereEqualTo("idventa", 9);

// Configurar las opciones para el adaptador
        FirestoreRecyclerOptions<Detalleventa> options = new FirestoreRecyclerOptions.Builder<Detalleventa>()
                .setQuery(query, Detalleventa.class)
                .build();
        if (options.getSnapshots().isEmpty()) {
            // No hay datos para mostrar
            Toast.makeText(this, "No se encontro", Toast.LENGTH_SHORT).show();
        } else {
        // Crear el adaptador
                AdapterFragmentCarrito adapter = new AdapterFragmentCarrito(options);
                Detalleventa venta =new Detalleventa();
                venta.setCantidad(7);
        // Configurar el RecyclerView
                RecyclerView recyclerView = findViewById(R.id.RvProdct);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adapter);
        }
        /*consulta.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot querySnapshot) {
                        List<Venta> listaProductos = new ArrayList<>();
                        FirestoreRecyclerOptions<Producto> firestoreRecyclerOptions =
                                new FirestoreRecyclerOptions.Builder<Producto>().setQuery(query, Producto.class).build();

                        for (DocumentSnapshot documentSnapshot : querySnapshot) {
                            int idventa = documentSnapshot.getLong("precio").intValue();

                            // Acceder a los datos del documento
                            int cantidadProducto = documentSnapshot.getLong("cantidad").intValue();
                            String descripcionProducto = documentSnapshot.getString("descripcion");
                            String idProducto = documentSnapshot.getString("idproducto");
                            int precioTotal = documentSnapshot.getLong("preciototal").intValue();
                            int precioUnitario = documentSnapshot.getLong("preciounitario").intValue();

                            // Crear un objeto Producto y agregarlo a la lista
                            Venta detalle = new Venta(cantidadProducto, descripcionProducto, idProducto, precioTotal, precioUnitario);
                            listaProductos.add(detalle);
                        }

                        // Crear el adaptador y establecerlo en el RecyclerView
                        AdapterFragmentCarrito adapter = new AdapterFragmentCarrito(options,listaProductos);
                        RvProdct.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Manejar el error si la consulta falla
                    }
                });
*/
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
                Intent siguiente = new Intent(getApplicationContext(), activityCatalogo.class);
                startActivity(siguiente);
            }
        });
        //__________________________________________________________________________________________
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(), activity_TipoDeEntrega.class);
                startActivity(siguiente);
            }
        });

    }
}