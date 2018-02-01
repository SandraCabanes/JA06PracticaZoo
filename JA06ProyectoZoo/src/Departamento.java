/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author mati
 */
public class Departamento {

    ArrayList<Usuario> listaUsuarios;

    public Departamento() {
        listaUsuarios = new ArrayList<Usuario>();
    }

    public void añadirUsuario(Usuario persona) {
        this.listaUsuarios.add(persona);
    }

    public boolean buscar(String correo) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (this.listaUsuarios.get(i).getNombre().equals(correo)) {
                return true;
            }
        }
        return false;
    }

    public Usuario obtenerUsuario(String correo) {
        Usuario u = null;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (this.listaUsuarios.get(i).getNombre().equals(correo)) {
                u = this.listaUsuarios.get(i);
            }
        }
        return u;
    }

    public void eliminar(String correo) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (this.listaUsuarios.get(i).getNombre().equals(correo)) {
                listaUsuarios.remove(i);
            }
        }
    }

    public void modificar(String correo, String correoNuevo, String contrasenaNueva) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (this.listaUsuarios.get(i).getNombre().equals(correo)) {
                this.listaUsuarios.get(i).setNombre(correoNuevo);
                this.listaUsuarios.get(i).setContraseña(contrasenaNueva);
            }
        }
    }

    public void mostrarDatos() {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println("\n ////////////////////////////////// \n");
            System.out.println("CORREO: " + this.listaUsuarios.get(i).getNombre());
            System.out.println("CONTRASEÑA: " + this.listaUsuarios.get(i).getContraseña() + "\n");

        }
    }

    public void mostrarEncriptados() {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (this.listaUsuarios.get(i).isEncriptada() == true) {
                System.out.println("\n ////////////////////////////////// \n");
                System.out.println("CORREO: " + this.listaUsuarios.get(i).getNombre());
                System.out.println("CONTRASEÑA: " + this.listaUsuarios.get(i).getContraseña() + "\n");
            }
        }
    }
    
    public void mostrarNoEncriptados() {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (this.listaUsuarios.get(i).isEncriptada() == false) {
                System.out.println("\n ////////////////////////////////// \n");
                System.out.println("CORREO: " + this.listaUsuarios.get(i).getNombre());
                System.out.println("CONTRASEÑA: " + this.listaUsuarios.get(i).getContraseña() + "\n");
            }
        }
    }
}
