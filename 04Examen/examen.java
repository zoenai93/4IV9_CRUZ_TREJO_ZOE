package Examen1;

import java.util.Scanner;
public class examen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //datos del cliente
        String nombre = ""; 
        String apPat = "";
        String apMat = "";
        String fecha = "";
        String direccion = "";

        int opcion;
        double totalGeneral = 0;

        //menu del programa
        do {
            System.out.println("MENU");
            System.out.println("1.- Capturar datos del cliente");
            System.out.println("2.- Mostrar tipos de piso");
            System.out.println("3.- Calcular costo");
            System.out.println("4.- Salir");
            System.out.println("opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("DATOS DEL CLIENTE");
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();

                    System.out.println("Apellido paterno: ");
                    apPat = sc.nextLine();

                    System.out.println("Apellido materno: ");
                    apMat = sc.nextLine();

                    System.out.println("Fecha de nacimiento: ");
                    fecha = sc.nextLine();

                    System.out.println("Dirección: ");
                    direccion = sc.nextLine();
                    
                    break;
                case 2:
                    System.out.println("TIPOS DE PISO");
                    System.out.println("1. Porcenalanato - $22.35 m2");
                    System.out.println("2. Marmoleado - $34.27 m2");
                    System.out.println("3. Acrilico - $22.94 m2");
                    break;
                
                case 3:
                    int cuartos;

                    do{
                        System.out.println("Numero de cuartos (2-4)");
                        cuartos = sc.nextInt();
                    }while (cuartos <= 1 || cuartos >= 5);
                    totalGeneral = 0;
                    
                    for (int i = 1; i <= cuartos; i++){
                        double largo, ancho, area, precio = 0, costo;

                        System.out.println("Cuarto " + i);

                        System.out.println("Largo: ");
                        largo = sc.nextDouble();

                        System.out.println("Ancho: ");
                        ancho = sc.nextDouble();

                        area = largo * ancho;

                        int tipo;
                        System.out.println("Tipo de piso: ");
                        System.out.println("1. Porcelanato");
                        System.out.println("2. Marmoleado");
                        System.out.println("3. Acrilico");
                        tipo = sc.nextInt();

                        switch (tipo) {
                            case 1:
                                precio = 22.35;
                
                                break;
                            case 2:
                                precio = 34.27;
                                break;
                            case 3:
                                precio = 22.94;
                                break;
                        
                            default:
                                System.out.println("Opcion invalida");
                                break;
                        }
                        costo = area * precio;
                        double iva = costo * 0.16;

                        System.out.println("Area: " + area);
                        System.out.println("Costo sin IVA: $" + costo);
                        System.out.println("IVA: $" + iva);
                        System.out.println("total cuarto: $" + (costo + iva));

                        totalGeneral += (costo + iva);

                    }
                    System.out.println("RESUMEN");
                    System.out.println("Cliente: " + nombre + " " + apPat + " " + apMat);
                    System.out.println("Dirección: " + direccion);
                    System.out.println("Total general: $" + totalGeneral);

                    System.out.println("Desea comprar? (0=si / 1=no): ");
                    int compra = sc.nextInt();

                    if (compra == 1){
                        double descuento = totalGeneral * 0.0795;
                        double totalFinal = totalGeneral - descuento;

                        System.out.println("Descuento: $" + descuento);
                        System.out.println("Total a pagar: $" + totalFinal);
                    }
                    {
                        
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
            
                default:
                    System.out.println("opcion invalida");
                    break;
            }
        }while (opcion != 4); 

        sc.close();
    }
}
