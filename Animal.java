public class Animal {

    private String nombre, raza, tipoAlimento;
    private int edad;

    public Animal(){}

    public Animal(String nombre, String raza, String tipoAlimento, int edad){
        this.nombre = nombre;
        this.raza = raza;
        this.tipoAlimento = tipoAlimento;
        this.edad = edad;
    }

    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }

    public String getRaza(){ return raza; }
    public void setRaza(String raza){ this.raza = raza; }

    public String getTipoAlimento(){ return tipoAlimento; }
    public void setTipoAlimento(String tipoAlimento){ this.tipoAlimento = tipoAlimento; }

    public int getEdad(){ return edad; }
    public void setEdad(int edad){ this.edad = edad; }
}
