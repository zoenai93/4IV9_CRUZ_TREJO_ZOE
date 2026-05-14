/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author HP
 */
import java.util.ArrayList;
import java.util.Scanner;
public class VistaPersona {
    Scanner entrada = new Scanner();
    int opcion;
    ControladorPersona crud = new ControladorPersona();
    
    public void Principal(){
        System.out.println("Bienvenido a "+ "gestionar personas");
        System.out.println("Elija una opcion");
        System.out.println("1.-Mostrar lista de personas");
        System.out.println("2.- Registrar nueva persona");
        System.out.println("3.- Editar datos de persona");
        System.out.println("4.- Borrar persona");
        System.out.println("5.- Salir");
        
        opcion = Integer.parseInt(entrada.nextLine());
        
        switch (opcion) {
            case 1: 
                ArrayList<Persona> listdePersonas = crud.mostrarPersonas();
                for (Persona objeto : listadePersonas){
                    System.out.println("El id: "+ objeto.getId()+ "El nombre: "+ objeto.getNombre()+ "La edad :"+ objeto.getEdad());
                }
            break;
            case 2:
                System.out.println("Ingresa si id");
                int idpersona = Integer.parseInt(entrada.nextLine());
                System.out.println("Ingresa el nombre");
                String nompersona = entrada.nextLine();
                System.out.printlin("Ingresa la edad");
                int edadpersona = Integer.parseInt(entrada.nextLine());
                //envio al objeto de persona
                Persona personaNueva = new Persona(idpersona)
        }
    }
}
