package com.example.remasa.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remasa.CrearArticuloFragment;
import com.example.remasa.R;
import com.example.remasa.model.Producto;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class ProductoAdapter extends FirestoreRecyclerAdapter<Producto, ProductoAdapter.ViewHolder> {

    private FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
    Activity activity;
    FragmentManager fm;

    public ProductoAdapter(@NonNull FirestoreRecyclerOptions<Producto> options, Activity activity, FragmentManager fm) {
        super(options);
        this.activity = activity;
        this.fm = fm;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull Producto producto) {
        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(viewHolder.getBindingAdapterPosition());
        final String cod = documentSnapshot.getId();

        viewHolder.id.setText(producto.getId());
        viewHolder.cantidad.setText(Integer.toString((int)producto.getCantidad()));
        viewHolder.nombre.setText(producto.getNombre());
        viewHolder.descripcion.setText(producto.getDescripcion());
        viewHolder.medida.setText(producto.getMedida());
        viewHolder.precio.setText(Integer.toString((int)producto.getPrecio()));

        String img = producto.getImg();
        if (img != null && !img.isEmpty()) {
            Picasso.with(activity.getApplicationContext())
                    .load(img)
                    .resize(130, 130)
                    .into(viewHolder.ivImagen);
        }

        viewHolder.btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrearArticuloFragment crearArticuloFragment = new CrearArticuloFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id_prdct", cod);
                crearArticuloFragment.setArguments(bundle);
                crearArticuloFragment.show(fm, "open fragment");
            }
        });

        viewHolder.btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteProducto(cod);
            }
        });
    }

    private void deleteProducto(String cod) {
        mFirestore.collection("Producto").document(cod).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(activity, "Eliminado correctamente", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(activity, "Error al eliminar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_producto, parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, cantidad, nombre, descripcion, medida,precio;
        ImageView btn_eliminar, btn_editar, ivImagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            cantidad = itemView.findViewById(R.id.cantidad);
            nombre = itemView.findViewById(R.id.nombre);
            descripcion = itemView.findViewById(R.id.descripcion);
            medida = itemView.findViewById(R.id.medida);
            btn_eliminar = itemView.findViewById(R.id.btn_eliminar);
            btn_editar = itemView.findViewById(R.id.btn_editar);
            precio = itemView.findViewById(R.id.precio);
            ivImagen = itemView.findViewById(R.id.ivImagen);
        }
    }
}