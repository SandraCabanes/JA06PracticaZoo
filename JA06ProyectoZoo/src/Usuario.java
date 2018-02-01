/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author mati
 */
public class Usuario {
    private String correo;
    private String contrasena;
    private boolean encriptada;

    public Usuario() {
    }

    public Usuario(String correo, String contraseña, boolean encriptada) {
        this.correo = correo;
        this.contrasena = contraseña;
        this.encriptada = encriptada;
    }
    
    public void encriptar(){
        String pass=this.getContraseña();
        String passEncriptada="";
        
        for (int i = 0; i < pass.length(); i++) {
            char letra=pass.charAt(i);
            letra+=3;
            passEncriptada+=letra;
        }
        this.setContraseña(passEncriptada);
        this.setEncriptada(false);
    }
    
    public void desencriptar(){
        String pass=this.getContraseña();
        String passEncriptada="";
        
        for (int i = 0; i < pass.length(); i++) {
            char letra=pass.charAt(i);
            letra-=3;
            passEncriptada+=letra;
        }
        this.setContraseña(passEncriptada);
        this.setEncriptada(false);
    }
    
    public void imprimeUsuario(){
        System.out.println("\n ////////////////////////////////// \n");
        System.out.println("CORREO: "+this.getNombre());
        System.out.println("CONTRASEÑA: "+this.getContraseña()+"\n");
    }
    
    public void imprimirCorreo(){
        System.out.println("Correo: "+this.getNombre());
}
    
    public String getNombre() {
        return correo;
    }

    public void setNombre(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public boolean isEncriptada() {
        return encriptada;
    }

    public void setEncriptada(boolean encriptada) {
        this.encriptada = encriptada;
    }
    
    @override
    public String toString(){
        return this.getcontrasena().toString();
    }
    
}
