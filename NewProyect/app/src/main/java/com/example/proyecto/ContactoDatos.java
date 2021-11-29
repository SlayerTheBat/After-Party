package com.example.proyecto;

public class ContactoDatos {
    private String CorreoD;
    private String Telefono;
    private String Comentario;

    public String getCorreo(){
        return CorreoD;
    }
    public void setCorreo(String CorreoD){
        this.CorreoD= CorreoD;

    }
    public String getTelefono(){
        return Telefono;
    }
    public void setTelefono(String Telefono){
        this.Telefono= Telefono;

    }
    public String getComentario(){
        return Comentario;
    }
    public void setComentario(String Comentario){
        this.Comentario= Comentario;

    }
}
