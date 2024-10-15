package com.example.remasa;

import androidx.recyclerview.widget.RecyclerView;

import com.example.remasa.adapter.ProdAdapter;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class  Usuario {
//----------Atributos de la clase padre-------------------------------------------------------------

    protected String correo, contraseña, apellido;
    public static String nombre, tipoUsuario;

    //-----
    ProdAdapter mAdapter;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Query query;
    //----

    //------Constructor-----------------------------------------------------------------------------
    public Usuario() {

    }
    public Usuario(String correo, String nombre,String apellido, String contraseña, String tipoUsuario) {
        this.correo = correo;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipoUsuario=tipoUsuario;
        this.apellido=apellido;
    }
    //-----Getters and setters----------------------------------------------------------------------


    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    //-----Metodos----------------------------------------------------------------------------------

    public void consultarUsuario(String correoIntrucido){

        String campoBuscado = "correo";

        db.collection("Usuario")
                .whereEqualTo(campoBuscado, correoIntrucido)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            // Acceder a los datos del documento
                             this.apellido = document.getString("apellidos");
                             this.contraseña = document.getString("contraseña");
                             this.correo = document.getString("correo");
                             this.nombre = document.getString("nombre");
                             this.tipoUsuario = document.getString("tipousuario");

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
