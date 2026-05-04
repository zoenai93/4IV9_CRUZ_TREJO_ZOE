public class Gato extends Animal {

    private int numVidas;

    public Gato(){}

    public Gato(String nombre, String raza, String tipoAlimento, int edad, int numVidas){
        super(nombre, raza, tipoAlimento, edad);
        this.numVidas = numVidas;
    }

    public int getNumVidas(){ return numVidas; }
    public void setNumVidas(int numVidas){ this.numVidas = numVidas; }

    public void mostrarGato(){
        System.out.println(
            "Nombre: " + getNombre() + "\n" +
            "Raza: " + getRaza() + "\n" +
            "Alimento: " + getTipoAlimento() + "\n" +
            "Edad: " + getEdad() + "\n" +
            "Vidas: " + numVidas
        );
    }
}