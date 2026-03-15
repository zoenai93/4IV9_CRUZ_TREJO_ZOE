/*
Vamos a crear 14 programas dentro de un menu gigante para poner a pruba sus conocimientos de algoritmia
1.- Desarrollar un programa para calcular el bono de un descuento por edad
2.- Conventir numeros decimales a binarios
3.- Conventir temperaturas entre los 3 principales grados C -> F y K
4.- Realizar un programa para contar numero de positivos y negativos de una serie de numeros
5.- Desarrollar una tienda para para agregar productos y precios
6.- Desarrollar un programa para calcular el area y perimetro de 5 diferentes figuras
7.- Desarrollar una tabla
8.- Desarrollar un programa para calcular el factorial con recursividad
9.- Vamos a hacer dibujitos wiiiii
10.- Desarrollar un figura hueca
11.- Realizar algunos patrones
12.- Realizar un diamante
13.- Desarrollar una calculadora basica + - * /
 */

import java.util.Scanner;

class EstructuraDatos{

    public static void main(String[] args) {
        //aqui van las variables
        int opcion;
        Scanner entrada = new Scanner(System.in);
        char letrapararepetir;

        //aqui van los objetos

        //aqui va el menu

        do {

        System.out.println("Bienvenido a este programa para verificar que tanto saben programar a partir de algoritmos basicos");
        System.out.println("Por favor elija la opción deseada");
        System.out.println("1.-");
        System.out.println("2.-");
        System.out.println("3.-");
        System.out.println("4.-");
        System.out.println("5.-");
        System.out.println("6.-");
        System.out.println("7.-");
        System.out.println("8.-");
        System.out.println("9.-");
        System.out.println("10.-");
        System.out.println("11.-");
        System.out.println("12.-");
        System.out.println("13.- ");
        System.out.println("14.- Salir");

        //entrada de dato
        opcion = entrada.nextInt();
        //ahora tengo que evaluar la entrada
        switch (opcion) {
            case 1:
                System.out.println("Bienvenido al programa para calcular el descuento por edad");
                System.out.println("Ingrese su edad");

                //variables
                int edad;
                edad = entrada.nextInt();

                // evaluar la edad
                if (edad < 18){
                    System.out.println("No tiene descuento");
                }else if(edad >= 18 && edad < 60){
                    System.out.println("Tiene un descuento del 10%");
                }else{
                    System.out.println("Tiene un descuento del 20%");
                }
                break;
            case 2:
                //conventir un numero decimal a binario
                System.out.println("Ingrese un numero positivo entero que desee convertir a binario");
                int numbinario;
                String guardarbinario = "";
                numbinario = entrada.nextInt();

                if(numbinario > 0){
                    //realizamos el mod 2
                    while(numbinario > 0){
                        if(numbinario%2 == 0){
                            guardarbinario = "0" + guardarbinario;
                        }else{
                            guardarbinario = "1" + guardarbinario;
                        }
                        numbinario = (int)numbinario/2;
                    }
                }else if (numbinario == 0) {
                    guardarbinario = "0";
                }else{
                    guardarbinario = "no se puede convertir ese numero, solo acepta positivos";

                }
                System.out.println("El numero convertido a binario" + guardarbinario);

                break;
            case 3:
                System.out.println("Bienvenido al programa conversor de temperaturas");
                System.out.println("Ingrese la temperatura en grados celsius");

                //variables de celsius
                float celsius;
                celsius = entrada.nextFloat();

                // variables de fahrenheit y kelvin
                float fahrenheit;
                float kelvin;

                // formulas para convertir los grados
                fahrenheit = (celsius * 9/5) + 32;
                kelvin = celsius + 273.15f;

                System.out.println("Temperatura en Fahrenheit: " + fahrenheit);
                System.out.println("Temperatura en kelvin: " + kelvin);

                break; 

            case 4:
                System.out.println("Bienvenido al programa de numeros positivos y negativos");
                System.out.println("Cuántos números vas a ingresar?");

                //variables
                int cantidadnum;
                cantidadnum = entrada.nextInt();

                //contadores de positivos y negativos
                int positivos = 0;
                int negativos = 0;

                for(int i = 1; i <= cantidadnum; i++){
                    System.out.println("Ingrese un numero");
                    int num;
                    num = entrada.nextInt();

                    //ver si es positivo o negativo
                    if(num >= 0){
                        positivos++;
                    }else{
                        negativos++;
                    }
                }
                System.out.println("Numeros positivos: " + positivos);
                System.out.println("Numeros negativos: " + negativos);
                break;
            
            case 5:
                System.out.println("Bienvenido a esta hermosa tiendita linda y kawaiii");
                System.out.println("Por favor ingrese cuantos elementos va a comprar");
                
                int elementosproducto = 0;
                elementosproducto = entrada.nextInt();

                if ( elementosproducto > 0){

                    float compra = 0;

                    for (int i = 1; i<= elementosproducto; i++){
                        
                        System.out.println("Ingresa el nombre del producto");
                        String nombreproducto = "";
                        nombreproducto = entrada.next();

                        System.out.println("Ingrese el precio");
                        float precio = entrada.nextFloat();
                        
                        System.out.println("Ingrese la cantidad de producto");
                        int cantidad = entrada.nextInt();
                        
                        float resultado = precio * cantidad;

                        compra = compra + resultado;
                    
                    }
                    System.out.println("El total de la compra es:" + compra);

                }else{
                    System.out.println("ingrese solo cantidades positivas");
                }


                break;

            case 6:
                System.out.println("Bienvenido a calcular el area de las figuritas");
                System.out.println("1 cuadrado");
                System.out.println("2 rectangulo");
                System.out.println("3 triangulo");
                System.out.println("4 circulo");
                System.out.println("5 pentagono");

                //variables
                int figura;
                figura = entrada.nextInt();

                // mini menu para elegir la figura
                switch (figura) {
                    case 1:
                        //cuadrado
                        System.out.println("Ingrese el lado del cuadrado");
                        float lado;
                        lado = entrada.nextFloat();

                        float areacuadrado;
                        float perimetrocuadrado;

                        // formulas
                        areacuadrado = lado * lado;
                        perimetrocuadrado = lado * 4;

                        System.out.println("Area: " + areacuadrado);
                        System.out.println("Perimetro: " + perimetrocuadrado);
                        break;

                    case 2:
                        //rectangulo
                        System.out.println("Ingrese la base");
                        float base;
                        base = entrada.nextFloat();

                        System.out.println("Ingrese la altura");
                        float altura;
                        altura = entrada.nextFloat();

                        float arearect;
                        float perimetrorect;

                        //formulas
                        arearect = base * altura;
                        perimetrorect = 2 * (base + altura);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;    
                    default:
                        break;
                }
                break;

            case 7:
                break;
            
            case 8:
                break;
            
            case 9:
                break;

            case 10:
                break;
            
            case 11:
                break;
            
            case 12:
                break;
            
            case 13:
                break;

        
            default:
                break;
        }
        System.out.println("Deseas repetir el programa escribe s o S para si");
        letrapararepetir = entrada.next().charAt(0);

        }while (letrapararepetir == 's' || letrapararepetir == 'S'); {
            
        }
        
    }
}

