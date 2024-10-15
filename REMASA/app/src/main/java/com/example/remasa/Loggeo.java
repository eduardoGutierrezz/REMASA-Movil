package com.example.remasa;

public class Loggeo {
    //-----Variables--------------------------------------------------------------------------------
    private String cuenta, contrasenia, nombre;

    //-----Constructores----------------------------------------------------------------------------


    public Loggeo() {
    }

    public Loggeo(String cuenta, String contrasenia, String nombre) {
        this.cuenta = cuenta;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
    }

    //-----Getters and setters----------------------------------------------------------------------

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //----------Metodos-----------------------------------------------------------------------------


}
