/*vamos a crear una instancia de un objeto para la entrada de datos*/

//libreria scanner
import java.util.Scanner;

class EntradaTexto{
    //metodo principal
    public static void main(String[] args){
        //instanceamos el objeto
        Scanner entrada = new
        Scanner(System.in);


        // las variables locales
        String nombre;
        int edad;
        // entrada 
        System.out.println("Escribe tu nombre");
            nombre = System.console().readLine();
            System.out.println("hola" + nombre + "bienvenido a programar muy feo");

            System.out.println("escribe tu edad");
            edad = entrada.nextInt();
    }
}