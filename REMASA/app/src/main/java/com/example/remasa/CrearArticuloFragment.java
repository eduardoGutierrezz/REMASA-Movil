package com.example.remasa;

import static java.lang.Integer.parseInt;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class CrearArticuloFragment extends DialogFragment {
    String id_prdct;
    Button btnAgregar,btn_imagen;
    CardView cardView;
    EditText idProducto, cantidadProducto, nombreProducto, descripcionProducto, medidaProducto,precioProducto;
    private FirebaseFirestore mfirestore;
    private FirebaseAuth mAuth;

    ImageView img_Prod;

    private static final int COD_SEL_STORAGE = 200;
    private static final int COD_SEL_IMAGE = 300;

    StorageReference storageReference;
    String storage_path = "Producto/*";
    private Uri image_url;
    String photo = "photo";
    String idd;
    ProgressDialog progressDialog;



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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crear_articulo, container, false);

        mfirestore = FirebaseFirestore.getInstance();
        btn_imagen = v.findViewById(R.id.btn_imagen);
        img_Prod = v.findViewById(R.id.img_Prod);
        btnAgregar = v.findViewById(R.id.btnAgregar);
        cardView = v.findViewById(R.id.cardView);
        idProducto = v.findViewById(R.id.idProducto);
        cantidadProducto = v.findViewById(R.id.cantidadProducto);
        nombreProducto = v.findViewById(R.id.nombreProducto);
        descripcionProducto = v.findViewById(R.id.descripcionProducto);
        medidaProducto = v.findViewById(R.id.medidaProducto);
        precioProducto = v.findViewById(R.id.precioProducto);

        storageReference = FirebaseStorage.getInstance().getReference();

        btn_imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadFoto();
            }
        });




        //Editar bd
        if (id_prdct==null || id_prdct==""){
            //Agregar a bd
            btnAgregar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String idprod = idProducto.getText().toString().trim();
                    int cantidadprod = parseInt(cantidadProducto.getText().toString().trim());
                    String nombreprod = nombreProducto.getText().toString().trim();
                    String descripcionprod = descripcionProducto.getText().toString().trim();
                    String medidaprod = medidaProducto.getText().toString().trim();
                    Double precioprod = Double.valueOf(precioProducto.getText().toString().trim());

                    if(idprod.isEmpty() || (Objects.equals(cantidadprod, "")) || nombreprod.isEmpty()
                            || descripcionprod.isEmpty() || medidaprod.isEmpty() || precioprod.equals("")){
                        Toast.makeText(getContext(), "Ingresar los datos", Toast.LENGTH_SHORT).show();
                    }else{
                        postProducto(idprod, cantidadprod, nombreprod, descripcionprod, medidaprod, precioprod);
                    }
                }
            });
            //Agregar a bd
        }else {
            getProducto(id_prdct);
            btnAgregar.setText("Guardar");
            btn_imagen.setVisibility(View.VISIBLE);
            cardView.setVisibility(View.VISIBLE);
            btnAgregar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String idprod = idProducto.getText().toString().trim();
                    int cantidadprod = parseInt(cantidadProducto.getText().toString().trim());
                    String nombreprod = nombreProducto.getText().toString().trim();
                    String descripcionprod = descripcionProducto.getText().toString().trim();
                    String medidaprod = medidaProducto.getText().toString().trim();
                    Double precioprod = Double.valueOf(precioProducto.getText().toString().trim());

                    if(idprod.isEmpty() || (Objects.equals(cantidadprod, "")) || nombreprod.isEmpty()
                            || descripcionprod.isEmpty() || medidaprod.isEmpty()){
                        Toast.makeText(getContext(), "Ingresar los datos", Toast.LENGTH_SHORT).show();
                    }else{
                        updateProducto(idprod, cantidadprod, nombreprod, descripcionprod, medidaprod, precioprod);
                    }
                }
            });
        }
        //Editar bd




        return v;
    }

    private void updateProducto(String idprod, int cantidadprod, String nombreprod, String descripcionprod, String medidaprod, Double precioprod) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", idprod);
        map.put("cantidad", cantidadprod);
        map.put("nombre", nombreprod);
        map.put("descripcion", descripcionprod);
        map.put("medida", medidaprod);
        map.put("precio", precioprod);


        mfirestore.collection("Producto").document(id_prdct).update(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getContext(), "Actualizado exitosamente", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Error al actualizar", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void postProducto(String idprod, int cantidadprod, String nombreprod, String descripcionprod, String medidaprod, double precioprod) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", idprod);
        map.put("cantidad", cantidadprod);
        map.put("nombre", nombreprod);
        map.put("descripcion", descripcionprod);
        map.put("medida", medidaprod);
        map.put("precio", precioprod);


        mfirestore.collection("Producto").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getContext(), "Creado exitosamente", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Error al ingresar", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void uploadFoto() {
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType("image/*");
        startActivityForResult(i, COD_SEL_IMAGE);

        /*Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        i.setType("image/*");
        startActivityForResult(i, COD_SEL_IMAGE);

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),
        COD_SEL_IMAGE);*/
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == Activity.RESULT_OK){
            if (requestCode == COD_SEL_IMAGE){
                image_url = data.getData();
                subirFoto(image_url);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void subirFoto(Uri image_url) {
        //progressDialog.setMessage("Actualizando foto");
        //progressDialog.show();
        String rute_storage_photo = storage_path + "" + photo + "" /*+ mAuth.getUid() +""*/+ id_prdct;
        StorageReference reference = storageReference.child(rute_storage_photo);
        reference.putFile(image_url).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isSuccessful());
                if (uriTask.isSuccessful()){
                    uriTask.addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            String download_uri = uri.toString();
                            HashMap<String, Object> map = new HashMap<>();
                            map.put("img", download_uri);
                            mfirestore.collection("Producto").document(id_prdct).update(map);
                            Toast.makeText(getContext(), "Foto actualizada", Toast.LENGTH_SHORT).show();
                            //progressDialog.dismiss();
                        }
                    });
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Error al cargar foto", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getProducto(String id_prdct){
        mfirestore.collection("Producto").document(id_prdct).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //DecimalFormat format = new DecimalFormat("0.00");
                String idProd = documentSnapshot.getString("id");
                int cantidadProd = parseInt(documentSnapshot.get("cantidad").toString());
                String nombreProd = documentSnapshot.getString("nombre");
                String descripcionProd = documentSnapshot.getString("descripcion");
                String medidaProd = documentSnapshot.getString("medida");
                String imgProd = documentSnapshot.getString("img");
                double precioProd = Double.parseDouble((documentSnapshot.get("precio").toString()));

                idProducto.setText(idProd);
                cantidadProducto.setText(Integer.toString(cantidadProd));
                nombreProducto.setText(nombreProd);
                descripcionProducto.setText(descripcionProd);
                medidaProducto.setText(medidaProd);
                precioProducto.setText(Double.toString(precioProd));

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
    }

    public boolean onSupportNavigateUp() {
        progressDialog.onBackPressed();
        return false;
    }

}