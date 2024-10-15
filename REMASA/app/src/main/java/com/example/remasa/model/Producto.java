package com.example.remasa.model;

import com.example.remasa.adapter.ProdAdapter;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class Producto {
    int cantidad;
    String descripcion;
    String id;
    String medida;
    String nombre;
    int precio;

    String img;
    //-----
    ProdAdapter mAdapter;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Query query;
    //----

    public Producto() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto(int cantidad, String descripcion, String id, String medida, String nombre, int precio, String img) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.id = id;
        this.medida = medida;
        this.nombre = nombre;
        this.precio = precio;
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    //-------------Metodos--------------------------------------------------------------------------

    public void consultarProducto(String idProducto){
        String campoBuscado = "id";

        db.collection("Producto")
                .whereEqualTo(campoBuscado, idProducto)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            // Acceder a los datos del documento
                            this.cantidad = document.getLong("cantidad").intValue();
                            this.descripcion = document.getString("descripcion");
                            this.id = document.getString("id");
                            this.medida = document.getString("medida");
                            this.nombre = document.getString("nombre");
                            this.precio = document.getLong("precio").intValue();

                        }
                    } else {
                        // Manejar errores
                    }
                }).addOnFailureListener(e -> {
                    // Manejar errores aquí
                    System.out.println("Error al conectarse"+e.getMessage());
                });
    }
}
