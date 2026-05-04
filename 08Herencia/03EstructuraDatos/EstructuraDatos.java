/*
Vamos a crear 14 programas dentro de un menu gigante para poner a pruba sus conocimientos de algoritmia
1.- Desarrollar un programa para calcular el bono de un descuento por edad
2.- Conventir numeros decimales a binarios
3.- Conventir temperaturas entre los 3 principales grados C -> F y K
4.- Realizar un programa para contar numero de positivos y negativos de una serie de numeros
5.- Desarrollar una tienda para para agregar productos y precios
6.- Desarrollar un programa para calcular el area y perimetro de 5 diferentes figuras
7.- Desarrollar una tabla
8.- Desarrollar un programa para calcular el factorial 
9.- Vamos a hacer dibujitos wiiiii triangulo equilatero o rombo
10.- Desarrollar un figura hueca
11.- 
12.- Realizar un diamante
13.- Desarrollar una calculadora basica + - * / para n numeros
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

                        System.out.println("Area: " + arearect);
                        System.out.println("Perimetro: " + perimetrorect);

                        break;
                    case 3:
                        // triangulo
                        System.out.println("Ingrese base");
                        float basetri;
                        basetri = entrada.nextFloat();

                        System.out.println("Ingrese altura");
                        float alturatri;
                        alturatri = entrada.nextFloat();

                        float areatri;

                        //formula
                        areatri = (basetri * alturatri)/2;

                        System.out.println("Area: " + areatri);
                        break;

                    case 4:
                        //circulo
                        System.out.println("Ingrese el radio");
                        float radio;
                        radio = entrada.nextFloat();

                        float areacir;
                        float perimetrocir;

                        //formulas

                        areacir = 3.1416f * radio * radio;
                        perimetrocir = 2 * 3.1416f * radio;

                        System.out.println("Area: " + areacir);
                        System.out.println("Perimetro: " + perimetrocir);
                        break;
                    case 5:
                        System.out.println("Ingrese el lado del pentagono");
                        float ladopenta;
                        ladopenta = entrada.nextFloat();

                        System.out.println("Ingrese el apotema");
                        float apotema;
                        apotema = entrada.nextFloat();

                        float areapenta;
                        float perimetropenta;

                        //formulas
                        perimetropenta = ladopenta * 5;
                        areapenta = (perimetropenta + apotema) / 2;

                        System.out.println("Area: " + areapenta);
                        System.out.println("Perimetro: " + perimetropenta);
                        break;    
                    default:
                        
                        break;
                }
                break;

            case 7:
                //quiero una tabla de multiplicar
                //deberan de darte formato y titulos a cada columna
                for(int n = 1; n <= 10; n++){
                    System.out.println(n + " | " + (n * 10 + " | " + (n * 100) + " | " + (n * 1000)));
                }
                break;
            
            case 8:
                //factoriales
                //variables
                System.out.println("Bienvenido, ingrese un número");
                int numfact = entrada.nextInt();
                int factorial = 1;

                for (int i = 1; i <= numfact; i++){
                    factorial = factorial * i;
                }
                System.out.println("El factorial es: " + factorial);
                break;
            
            case 9:
                //vamos a realizar un cuadrado magico
                System.out.println("Vamos a realizar el dibujo de un cuadrado magico");
                System.out.println("Ingrese el tamaño del cuadrado");

                int n1 = entrada.nextInt();

                if (n1 >= 1 && n1 <= 20){
                    //se imprime
                    for(int i = 1; i <= n1; i++){
                        //recorro las columnas
                        for(int j = 1; j <= n1; j++){
                            System.out.print("*");
                        }
                        System.out.println();
                    } 
                }else{
                    System.out.println("Por favor solo ingrese valores entre el 1 y el 20");
                }

                break;

            case 10:
                //figura hueca
                System.out.println("dibujito sin relleno");
                System.out.println("Ingrese el tamaño");

                //variables
                int n2 = entrada.nextInt();

                if (n2 >= 1 && n2 <= 20){
                    for(int i = 1; i <= n2; i++){
                        for(int j = 1; j <= n2; j++){
                            if(i == 1 || i == n2 || j == 1 || j == n2){
                                System.out.print("*");
                            }else{
                                System.out.print(" ");
                            }
                        }
                        System.out.println();

                    }
                }
                break;
            
            case 11:
                //no hay
                System.out.println("oli profe :)");
                break;
            
            case 12:
                //realizar un diamante
                System.out.println("ingrese el tamaño");
                int n3 = entrada.nextInt();

                for(int i = 1; i <= n3; i++){
                    for(int j = 1; j <= n3 - i; j++){
                        System.out.print(" ");
                    }
                    for(int j = 1; j <= (2*i - 1); j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }

                for(int i = n3 - 1; i >= 1; i--){
                    for(int j = 1; j <= n3 - i; j++){
                        System.out.print(" ");
                    }
                    for(int j = 1; j <= (2*i - 1); j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            
            case 13:
                //la calculadora
                System.out.println("Calculadora básica");

                System.out.println("Ingrese el primer número");
                float resultado = entrada.nextFloat();

                char continuar;

                do{
                    System.out.println("Ingrese operación (+ - * /)");
                    char op = entrada.next().charAt(0);

                    System.out.println("Ingrese numero");
                    float num = entrada.nextFloat();

                    if (op == '+') {
                        resultado = resultado + num;
                    }else if (op == '-') {
                        resultado = resultado - num;
                    }else if (op == '*') {
                        resultado = resultado * num;
                    }else if (op == '/') {
                        resultado = resultado / num;
                    }else{
                        System.out.println("operación no valida");
                    }
                    System.out.println("Resultado actual: " + resultado);

                    System.out.println("Deseas continuar? (s/n)");
                    continuar = entrada.next().charAt(0);
                
                }while (continuar == 's' || continuar == 'S'); 
                    
                System.out.println("Resultado final: " + resultado);
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

