import java.util.Scanner;
public class figuritas {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("MENU FIGURITAS");
            System.out.println("1. Circulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triangulo");
            System.out.println("4. Rombo");
            System.out.println("5. Hexagono");
            System.out.println("6. Salir");
            System.out.println("Selecciona una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el radio: ");
                    float radio = entrada.nextFloat();

                    Circulo circulo = new Circulo(radio);
                    mostrarResultados(circulo);
                    break;
                
                case 2:
                    System.out.println("Ingresa el lado: ");
                    float ladoCuadrado = entrada.nextFloat();

                    Cuadrado cuadrado = new Cuadrado(ladoCuadrado);
                    mostrarResultados(cuadrado);
                    break;
                
                case 3:
                    System.out.println("Ingresa la base: ");
                    float base = entrada.nextFloat();

                    System.out.println("Ingrese lado 2: ");
                    float lado2 = entrada.nextFloat();

                    System.out.println("Ingresa el lado 3: ");
                    float lado3 = entrada.nextFloat();

                    System.out.println("Ingrese la altura");
                    float alturaTriangulo = entrada.nextFloat();

                    Triangulo triangulo = new Triangulo(base, lado2, lado3, alturaTriangulo);
                    mostrarResultados(triangulo);
                    break;

                case 4:
                    System.out.println("Ingresa el lado: ");
                    float ladoRombo = entrada.nextFloat();

                    System.out.println("Ingresa la altura: ");
                    float alturaRombo = entrada.nextFloat();

                    Rombo rombo = new Rombo(ladoRombo, alturaRombo);
                    mostrarResultados(rombo);
                    break;

                case 5:
                    System.out.println("Ingresa el lado: ");
                    float ladoHexagono = entrada.nextFloat();

                    Hexagono hexagono = new Hexagono(ladoHexagono);
                    mostrarResultados(hexagono);
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

            
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 6); 
        
        entrada.close();
    }

    public static void mostrarResultados(Figura figura) {
        System.out.println("Area: " + figura.calcularArea());
        System.out.println("Perimetro: " + figura.calcularPerimetro());
    }
}

//clase base
abstract class Figura {
    public abstract float calcularArea();
    public abstract float calcularPerimetro();
}

//circulo
class Circulo extends Figura{
    private float radio;

    public Circulo(float radio){
        this.radio =radio;
    }
    public float calcularArea() {
        return (float) (Math.PI * radio * radio);
    }

    public float calcularPerimetro() {
        return (float) (2 * Math.PI * radio);
    }
}

//cuadrado
class Cuadrado extends Figura {
    private float lado;

    public Cuadrado(float lado) {
        this.lado = lado;
    }

    public float calcularArea() {
        return lado * lado;
    }

    public float calcularPerimetro() {
        return 4 * lado;
    }
}
//triangulo
class Triangulo extends Figura {
    private float base;
    private float lado2;
    private float lado3;
    private float altura;

    public Triangulo(float base, float lado2, float lado3, float altura) {
        this.base = base;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.altura = altura;
    }

    public float calcularArea() {
        return (base * altura) / 2;
    }

    public float calcularPerimetro() {
        return base + lado2 + lado3;
    }
}
//rombo
class Rombo extends Figura {
    private float lado;
    private float altura;

    public Rombo(float lado, float altura) {
        this.lado = lado;
        this.altura = altura;
    }

    public float calcularArea() {
        return lado * altura;
    }

    public float calcularPerimetro() {
        return 4 * lado;
    }
}
//hexagono
class Hexagono extends Figura {
    private float lado;

    public Hexagono(float lado) {
        this.lado = lado;
    }

    public float calcularArea() {
        return (float) ((3 * Math.sqrt(3) * lado * lado) / 2);
    }

    public float calcularPerimetro() {
        return 6 * lado;
    }
}