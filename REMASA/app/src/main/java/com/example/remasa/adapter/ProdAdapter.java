package com.example.remasa.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remasa.CrearArticuloFragment;
import com.example.remasa.R;
import com.example.remasa.VerProductoFragment;
import com.example.remasa.model.Producto;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class ProdAdapter extends FirestoreRecyclerAdapter<Producto, ProdAdapter.ViewHolder> {

    private FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
    Activity activity;
    FragmentManager fm;

    public ProdAdapter(@NonNull FirestoreRecyclerOptions<Producto> options, Activity activity, FragmentManager fm) {
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
        viewHolder.precio.setText(Double.toString((int) producto.getPrecio()));

        viewHolder.btn_editar.setVisibility(View.GONE);
        viewHolder.btn_eliminar.setVisibility(View.GONE);
        viewHolder.tvId.setVisibility(View.GONE);
        viewHolder.tvCantidad.setVisibility(View.GONE);
        viewHolder.id.setVisibility(View.GONE);
        viewHolder.cantidad.setVisibility(View.GONE);
        //viewHolder.linearDescripcion.setWidth(300);

        String img = producto.getImg();
        if (img != null && !img.isEmpty()) {
            Picasso.with(activity.getApplicationContext())
                    .load(img)
                    .resize(100, 100)
                    .into(viewHolder.ivImagen);
        }


        viewHolder.CvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerProductoFragment verProductoFragment = new VerProductoFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id_prdct", cod);
                verProductoFragment.setArguments(bundle);
                verProductoFragment.show(fm, "open fragment");
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
        TextView id, cantidad, nombre, descripcion, medida, tvId, tvCantidad, precio;
        ImageView btn_eliminar, btn_editar, ivImagen;
        CardView CvItem;
        LinearLayout linearDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            cantidad = itemView.findViewById(R.id.cantidad);
            nombre = itemView.findViewById(R.id.nombre);
            descripcion = itemView.findViewById(R.id.descripcion);
            medida = itemView.findViewById(R.id.medida);
            btn_eliminar = itemView.findViewById(R.id.btn_eliminar);
            btn_editar = itemView.findViewById(R.id.btn_editar);
            ivImagen = itemView.findViewById(R.id.ivImagen);
            CvItem = itemView.findViewById(R.id.CvItem);
            tvId = itemView.findViewById(R.id.tvId);
            tvCantidad = itemView.findViewById(R.id.tvCantidad);
            precio = itemView.findViewById(R.id.precio);
            linearDescripcion = itemView.findViewById(R.id.linearDescripcion);
        }
    }
}