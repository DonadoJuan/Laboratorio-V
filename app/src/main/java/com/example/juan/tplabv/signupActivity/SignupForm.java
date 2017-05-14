package com.example.juan.tplabv.signupActivity;


public class SignupForm {

    private String nombre;
    private String apellido;
    private String dni;
    private String password;
    private String email;
    private String usuario;

    public SignupForm(){};

    public SignupForm(String nombre, String apellido, String dni, String password, String email, String usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.password = password;
        this.email = email;
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return email;
    }

    public void setMail(String mail) {
        this.email = mail;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
