/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herenciapersona;

/**
 *
 * @author HP
 */
import javax.swing.JOptionPane;
public class DAOEstudiante {
    //vamos a crear un programa para dar de alta 10 estudiantes
    //es un objeto por parte de estudiante
    Estudiante obj[] = new Estudiante[10];
    int x = 0;
    //metodo del menu para el programa
    void menu(){
        String var = "si";
        String mensaje = "";
        
        while(var.equalsIgnoreCase("si")){
            int po = Interger.parseInt(JOptionPane.showInputDialog("Ingresa la opción deseada: \n" + "1. Dar de alta al nuevo exstudiante. \n" + "2. Mostrar los datos de los estudiante. \n"))
        
            switch (op) {
                case 1:
                    //metodo para registrar 
                    pedirEstudiante();
                    
                    break;
                case 2:
                    //mostrar estudiante
                    mostrarEstudiante();
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    
            }
            mensaje = JOptionPane.showInputDialog("¿Deseas repetir el programa?"); 
        }
        public void pedirEstudiante(){
            int numboleta = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la boleta del estudiante"));
            String nom = JOptionPane.showInputDialog("Ingresa el nombre del estudiante");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Inngresa la edad del estudiante: "));
            char gen = JOptionPane.showInputDialog("Ingresa el nombre del estudiante").charAt(0);
            obj[x] = new Estudiante(numboleta, nom, edad, gen);
            x++;
        }
        public void mostrarEstudiante(){
            //necesitamos recorrer el arreglo del tamanño que sea 
            
            for(int i = 0; i < x; i++ ){
                //Visualizar los datos
                JOptionPane.showMessageDialog(null, "La boleta del estudiante es: " + obj[i].getNumBoleta() + "\n" + "El nombre del estudiante es: " + obj[i].getNombre()+ "\n" + "La edad del estudiante es: " + obj[i].getEdad()+ "\n"+ "El nombre del estudiante es: "+ obj[i].getNombre()+ "\n");
            }
         }
    }
}
