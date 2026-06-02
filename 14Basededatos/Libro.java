public class Libro {

    private int idLibro;
    private String titulo;
    private String autor;
    private String genero;
    private int anio;

    public Libro() {

        this.idLibro = 0;
        this.titulo = "";
        this.autor = "";
        this.genero = "";
        this.anio = 0;

    }

    public Libro(int idLibro, String titulo,
            String autor, String genero, int anio) {

        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;

    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String mostrarDetalle() {

        return String.format(
                "ID: %d | Titulo: %s | Autor: %s | Genero: %s | Año: %d",
                idLibro, titulo, autor, genero, anio);

    }

    @Override
    public String toString() {
        return mostrarDetalle();
    }

}