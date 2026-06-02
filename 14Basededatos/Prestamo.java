public class Prestamo {

    private int idPrestamo;
    private int idUsuario;
    private int idLibro;
    private String fechaPrestamo;

    public Prestamo() {

        this.idPrestamo = 0;
        this.idUsuario = 0;
        this.idLibro = 0;
        this.fechaPrestamo = "";

    }

    public Prestamo(int idPrestamo,
            int idUsuario,
            int idLibro,
            String fechaPrestamo) {

        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.fechaPrestamo = fechaPrestamo;

    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String mostrarDetalle() {

        return String.format(
                "ID Prestamo: %d | ID Usuario: %d | ID Libro: %d | Fecha: %s",
                idPrestamo, idUsuario, idLibro, fechaPrestamo);

    }

    @Override
    public String toString() {
        return mostrarDetalle();
    }

}