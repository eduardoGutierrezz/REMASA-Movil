
package com.example.remasa;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.remasa.model.Producto;
import com.example.remasa.model.Venta;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class VerProductoFragment extends DialogFragment {

    String id_prdct;
    String idProd;
    String nombreProd;
    String descripcionProd;
    String medidaProd ;
    int precioProd;
    Producto producto=new Producto();
    Venta venta=new Venta();
    Button btnAgregar;
    CardView cardView;
    TextView idProducto, cantidadProducto, nombreProducto, descripcionProducto, medidaProducto, precioProducto;
    private FirebaseFirestore mfirestore;
    private FirebaseAuth mAuth;
    ImageView img_Prod;

    StorageReference storageReference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Editar bd
        if (getArguments()!=null){
            id_prdct = getArguments().getString("id_prdct");
        }
        //Editar bd

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_ver_producto, container, false);

        mfirestore = FirebaseFirestore.getInstance();
        img_Prod = v.findViewById(R.id.img_Prod);
        btnAgregar = v.findViewById(R.id.btnAgregar);
        cardView = v.findViewById(R.id.cardView);
        nombreProducto = v.findViewById(R.id.nombreProducto);
        descripcionProducto = v.findViewById(R.id.descripcionProducto);
        medidaProducto = v.findViewById(R.id.medidaProducto);
        precioProducto = v.findViewById(R.id.precioProducto);

        storageReference = FirebaseStorage.getInstance().getReference();


        getProducto(id_prdct);

<<<<<<< HEAD
        if(!Usuario.tipoUsuario.equals("Cliente")){
            btnAgregar.setVisibility(View.GONE);
        }
=======
        /*if(!Usuario.tipoUsuario.equals("Cliente")){
            btnAgregar.setVisibility(View.GONE);
        }*/
>>>>>>> ad70d40881c1ec55fd4670aac7c5ba724507bd1e

        return v;
    }

    private void getProducto(String id_prdct){
        mfirestore.collection("Producto").document(id_prdct).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                nombreProd = documentSnapshot.getString("nombre");
                descripcionProd = documentSnapshot.getString("descripcion");
                medidaProd = documentSnapshot.getString("medida");
                precioProd = documentSnapshot.getLong("precio").intValue();
                idProd = documentSnapshot.getString("id");

                nombreProducto.setText(nombreProd);
                descripcionProducto.setText(descripcionProd);
                medidaProducto.setText(medidaProd);
                precioProducto.setText(String.valueOf(precioProd));

                String imgProd = documentSnapshot.getString("img");
                try {
                    if(!imgProd.equals("")){
                        //Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Cargando foto", Toast.LENGTH_SHORT);
                        //toast.setGravity(Gravity.TOP,0,200);
                        //toast.show();
                        Picasso.with(getActivity().getApplicationContext())
                                .load(imgProd)
                                .resize(150, 150)
                                .into(img_Prod);
                    }
                }catch (Exception e){
                    Log.v("Error", "e: " + e);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity().getApplicationContext(), "Error al obtener los datos", Toast.LENGTH_SHORT).show();
            }
        });
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //venta.obtenerSiguienteId();
                venta.setIdVentaSiguiente(9);

                //consultar datos del producto que se agrego
                //producto.consultarProducto(idProd);
                //Toast.makeText(getActivity().getApplicationContext(), "total "+ venta.getPrecioUnitario()+venta.getPrecioTotal(), Toast.LENGTH_SHORT).show();
                //tomar datos del producto que se agrego
                int idVenta=8;
                venta.setCantidad(1);
                venta.setIdventa(idVenta);
                venta.setDescripcion(descripcionProd);
                venta.setPreciototal(precioProd);
                venta.setPreciounitario(precioProd);
                venta.setIdproducto(idProd);
                venta.registroDetalleVenta();


            }
        });
    }
}