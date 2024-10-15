package com.example.remasa.model;

import com.example.remasa.adapter.ProdAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;

public class Venta {
    //------Atributos-detalleVenta------------------------------------------------------------------
    String descripcion, idproducto;
    int preciounitario, preciototal;
    static public int idventa;
    int cantidad;
    int  idVentaSiguiente;
    //-----
    ProdAdapter mAdapter;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Query query;
    //----


    public int getIdVentaSiguiente() {
        return idVentaSiguiente;
    }

    public void setIdVentaSiguiente(int idVentaSiguiente) {
        this.idVentaSiguiente = idVentaSiguiente;
    }

    FirebaseDatabase mibase;
    DatabaseReference miRef;
    private FirebaseFirestore mfirestore = FirebaseFirestore.getInstance();

    //------Constructor-----------------------------------------------------------------------------
    public Venta() {
    }

    /*public Venta(int cantidadProducto, String descripcionProducto,String idProducto, int precioTotal,int  precioUnitario){

    }*/

    //-------Getters and setters--------------------------------------------------------------------

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public int getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(int preciounitario) {
        this.preciounitario = preciounitario;
    }

    public int getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(int preciototal) {
        this.preciototal = preciototal;
    }

    public static int getIdventa() {
        return idventa;
    }

    public static void setIdventa(int idventa) {
        Venta.idventa = idventa;
    }


    //------------Metodos---------------------------------------------------------------------------
    public void registroDetalleVenta() {
        Map<String, Object> map = new HashMap<>();
        map.put("cantidad", cantidad);
        map.put("descripcion", descripcion);
        map.put("idproducto", idproducto);
        map.put("idventa", 15);
        map.put("preciototal", preciototal);
        map.put("preciounitario", preciounitario);

        mfirestore.collection("Detalleventa").add(map).addOnSuccessListener(documentReference -> {
                    // Inserción exitosa, puedes realizar acciones adicionales aquí
                })
                .addOnFailureListener(e -> {
                    System.out.println("Error al conectarse" + e.getMessage());
                });
    }

  /*  public void obtenerSiguienteId() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference VentaCollection = db.collection("venta");
        VentaCollection.orderBy("idventa", Query.Direction.DESCENDING).limit(1)
                .get()
                .addOnSuccessListener(querySnapshot -> {
                    if (!querySnapshot.isEmpty()) {
                        QueryDocumentSnapshot document = (QueryDocumentSnapshot) querySnapshot.getDocuments().get(0);
                        this.idVentaSiguiente = document.getLong("idventa").intValue() + 1;
                    } else {
                        // No se encontró ningún documento, asumiendo que 1 es el valor inicial
                        this.idVentaSiguiente = 1;
                    }
                })
                .addOnFailureListener(e -> {
                    System.out.println("Error al obtener el siguiente ID: " + e.getMessage());
                });
    }
*/
  /*  public void consultaDetalleVenta() {
        String campoBuscado = "idventa";

        db.collection("Detalleventa")
                .whereEqualTo(campoBuscado, idVenta)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {

                            // Acceder a los datos del documento
                            this.cantidadProducto = document.getLong("cantidad").intValue();
                            this.descripcionProducto = document.getString("contraseña");
                            this.idProducto = document.getString("idproducto");
                            this.idVenta = document.getLong("idventa").intValue();
                            this.precioTotal = document.getLong("preciototal").intValue();
                            this.precioUnitario = document.getLong("preciounitario").intValue();
                        }
                    } else {
                        // Manejar errores
                    }
                }).addOnFailureListener(e -> {
                    // Manejar errores aquí
                    System.out.println("Error al conectarse" + e.getMessage());
                });
    }*/
}