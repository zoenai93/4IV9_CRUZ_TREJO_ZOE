import java.util.Scanner;

public class ejercicios {
    //vamos a hacer una calculadora rapida
    //la calculadora debe de tener un menu
Scanner entrada = new Scanner(System.in);
    public void menu(){
        //las instrucciones
        System.out.println("Bienvenido a la calculadora");
        System.out.println("Elige la opcion deseada");
        System.out.println("1. sumar");
        System.out.println("2. restar");
        System.out.println("3. multiplicar");
        System.out.println("4. salir");
//
        int opcion = 0;

        opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                suma();
                break;
        
            default:
                break;
        }
    }
    public void suma(){
        double num1 = 0.00, num2=0.00, resultado;

        System.out.println("Ingresa el numero que deseas sumar");
        num1 = entrada.nextDouble();
        System.out.println("Ingresa el numero que deseas sumar");
        num2 = entrada.nextDouble();
        resultado = num1 + num2;
        System.out.println("La suma es: " + resultado);

    }
}
