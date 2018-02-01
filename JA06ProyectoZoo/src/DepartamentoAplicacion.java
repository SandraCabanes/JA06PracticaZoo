/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author mati
 */
public class DepartamentoAplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String correo = "";
        String contrasena = "";
        int op = 0;
        Departamento listaUsuarios = null;
        Usuario persona1 = null;
        String correoNuevo = "";
        String contrasenaNueva = "";

        do {

            mostrarMenu();
            System.out.println("Elige una opción");
            op = teclado.nextInt();

            teclado.nextLine();

            switch (op) {
                case 1:
                    listaUsuarios = new Departamento();
                    break;

                case 2:
                    while (!validarCorreo(correo)) {
                        System.out.print("Correo electrónico: ");
                        correo = teclado.nextLine();
                    }

                    while (!validarContra(contrasena)) {

                        System.out.print("Contraseña: ");
                        contrasena = teclado.nextLine();
                    }

                    persona1 = new Usuario(correo, contrasena, false);
                    listaUsuarios.añadirUsuario(persona1);

                    break;

                case 3:
                    System.out.print("Correo a buscar: ");
                    correo = teclado.nextLine();

                    if (listaUsuarios.buscar(correo)) {
                        persona1.imprimeUsuario();
                    } else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;

                case 4:
                    System.out.print("Correo del usuario que desea eliminar: ");
                    correo = teclado.nextLine();

                    if (listaUsuarios.buscar(correo)) {
                        listaUsuarios.eliminar(correo);
                    } else {
                        System.out.println("No se puede liminar. Usuario no encontrado");
                    }
                    break;

                case 5:
                    System.out.print("Correo del usuario que desea modificar: ");
                    correo = teclado.nextLine();

                    if (listaUsuarios.buscar(correo)) {

                        while (!validarCorreo(correoNuevo)) {
                            System.out.print("Introduce correo nuevo: ");
                            correoNuevo = teclado.nextLine();
                        }

                        while (!validarContra(contrasenaNueva)) {

                            System.out.print("Introduce nueva contrseña: ");
                            contrasenaNueva = teclado.nextLine();
                        }

                        listaUsuarios.modificar(correo, correoNuevo, contrasenaNueva);
                    } else {
                        System.out.println("No se puede liminar. Usuario no encontrado");
                    }
                    break;

                case 6:
                    System.out.print("Correo del usuario que desea encriptar la contraseña: ");
                    correo = teclado.nextLine();
                    persona1 = listaUsuarios.obtenerUsuario(correo);

                    if (persona1 != null) {
                        persona1.encriptar();
                    } else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;

                case 7:
                    System.out.print("Correo del usuario que desea desencriptar la contraseña: ");
                    correo = teclado.nextLine();
                    persona1 = listaUsuarios.obtenerUsuario(correo);

                    if (persona1 != null) {
                        persona1.desencriptar();
                    } else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;

                case 8:
                    listaUsuarios.mostrarDatos();
                    break;

                case 9:
                    listaUsuarios.mostrarEncriptados();
                    break;

                case 10:
                    listaUsuarios.mostrarNoEncriptados();
                    break;

                case 11:
                    persona1.imprimeUsuario();
                    break;

                case 0:
                    System.out.println("Salir");
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }

        } while (op != 0);
    }

    public static void mostrarMenu() {
        System.out.println("\n____________________________________________________\n");
        System.out.println("1. Crear departamento");
        System.out.println("2. Añadir usuarios al departamento");
        System.out.println("3. Buscar un usuario y mostrar sus datos");
        System.out.println("4. Borrar un usuario de un departamento");
        System.out.println("5. Modificar datos de un usuario concreto");
        System.out.println("6. Encriptar contraseña");
        System.out.println("7. Desencriptar contraseña");
        System.out.println("8. Visualizar los datos de todo el departamento");
        System.out.println("9. Visualizar los datos de usuarios con contraseñas encriptadas");
        System.out.println("10. Visualizar los datos de usuarios con contraseñas sin encriptar");
        System.out.println("11. Visualizar los datos de un usuario concreto");
        System.out.println("0. Salir");
        System.out.println("\n____________________________________________________\n");
    }

    public static boolean validarCorreo(String correo) {

        if (correo.equals("")) {
            return false;
        } else {

            String[] direccion = correo.split("@");
            String aux;

            if (direccion[0] != null) {
                aux = direccion[1];
                String[] dominio = aux.split("\\.");
                if (dominio[1].equals("com") && dominio[1].equals("es")) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean validarContra(String contrasena) {
        boolean min = false;
        boolean mayus = false;
        boolean num = false;
        boolean caracter = false;

        if (contrasena.length() > 6) {
            for (int i = 0; i < contrasena.length(); i++) {
                if ((contrasena.charAt(i) >= 'a' && contrasena.charAt(i) <= 'z') && min == false) {
                    min = true;
                    i = 0;
                }
                if (min) {
                    if ((contrasena.charAt(i) >= 'A' && contrasena.charAt(i) <= 'Z') && mayus == false) {
                        mayus = true;
                        i = 0;
                    }
                    if (mayus) {
                        if ((contrasena.charAt(i) >= '0' && contrasena.charAt(i) <= '9') && num == false) {
                            num = true;
                            i = 0;
                        }
                        if (num) {
                            if ((contrasena.charAt(i) >= 33 && contrasena.charAt(i) <= 47) || (contrasena.charAt(i) >= 58 && contrasena.charAt(i) <= 64) || (contrasena.charAt(i) >= 91 && contrasena.charAt(i) <= 96) && caracter == false) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
