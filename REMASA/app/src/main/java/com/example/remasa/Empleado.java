package com.example.remasa;

public class Empleado extends Usuario{

    //----------Atributos---------------------------------------------------------------------------

    protected String area;

    //------Creación de constructor-----------------------------------------------------------------

    public Empleado(String correo, String nombre,String apellido, String contraseña, String tipoUsuario, String area) {
        super(correo, nombre,apellido, contraseña, tipoUsuario);
        this.area = area;
    }

    //------Metodos---------------------------------------------------------------------------------

    public void consultarPedidos (){

    }

}
