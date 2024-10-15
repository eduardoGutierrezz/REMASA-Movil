package com.example.remasa.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remasa.R;
import com.example.remasa.model.Detalleventa;
import com.example.remasa.model.Producto;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterFragmentCarrito extends FirestoreRecyclerAdapter<Detalleventa, AdapterFragmentCarrito.ViewHolder> {



    private FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
    Activity activity;
    FragmentManager fm;
    public AdapterFragmentCarrito(@NonNull FirestoreRecyclerOptions<Detalleventa> options) {
        super(options);
    }

    public AdapterFragmentCarrito(@NonNull FirestoreRecyclerOptions<Detalleventa> options, Activity activity, FragmentManager fm) {
        super(options);
        this.activity = activity;
        this.fm = fm;
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterFragmentCarrito.ViewHolder viewHolder, int position, @NonNull Detalleventa venta) {
        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(viewHolder.getBindingAdapterPosition());
        final String cod = documentSnapshot.getId();

        viewHolder.idprod.setText(venta.getIdproducto());
        viewHolder.cantidad.setText(Integer.toString((int)venta.getCantidad()));
        viewHolder.descripcion.setText(venta.getDescripcion());
        viewHolder.idventa.setText(venta.getIdventa());
        viewHolder.precioTotal.setText(Double.toString((int) venta.getPreciototal()));
        viewHolder.precioUnitario.setText(Double.toString((int) venta.getPreciounitario()));

        viewHolder.btn_editar.setVisibility(View.GONE);
        viewHolder.btn_eliminar.setVisibility(View.GONE);
        //viewHolder.linearDescripcion.setWidth(300);

        /*String img = producto.getImg();
        if (img != null && !img.isEmpty()) {
            Picasso.with(activity.getApplicationContext())
                    .load(img)
                    .resize(100, 100)
                    .into(viewHolder.ivImagen);
        }*/

    }

    @NonNull
    @Override
    public AdapterFragmentCarrito.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment__carrito, parent, false);
        return new ViewHolder(v);
    }

    //_________________________________________________________
    public class ViewHolder extends RecyclerView.ViewHolder {

        ///////------------
        TextView idprod, idventa, cantidad, descripcion, precioUnitario, precioTotal;
        ImageView btn_editar, btn_eliminar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idprod = itemView.findViewById(R.id.idprod);
            idventa = itemView.findViewById(R.id.idventa);
            cantidad = itemView.findViewById(R.id.cantidad);
            descripcion = itemView.findViewById(R.id.descripcion);
            precioUnitario = itemView.findViewById(R.id.precioUnitario);
            precioTotal = itemView.findViewById(R.id.precioTotal);
        }
    }
}
