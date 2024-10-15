package com.example.remasa;

public class Cliente extends Usuario{

    protected String telefono, direccion;
    //------Constructor-----------------------------------------------------------------------------


    public Cliente(String correo, String nombre,String apellido, String contraseña, String tipoUsuario, String telefono, String direccion) {
        super(correo, nombre,apellido, contraseña, tipoUsuario);
        this.telefono = telefono;
        this.direccion = direccion;
    }

    //------Metodos---------------------------------------------------------------------------------

    public void comprar(){

    }
    public void consultarCompras(){

    }
    public void crearCuenta(){

    }
    public void modificarCuenta(){

    }
}
