import java.sql.*;
import java.util.ArrayList;

public class LibroDAO {

    public void insertarLibro(Libro libro) throws Exception {

        Connection con = ConexionBD.getConexion();

        String sql =
        "INSERT INTO libros(titulo,autor,genero,anio) VALUES(?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, libro.getTitulo());
        ps.setString(2, libro.getAutor());
        ps.setString(3, libro.getGenero());
        ps.setInt(4, libro.getAnio());

        ps.executeUpdate();
    }

    public ArrayList<Libro> obtenerLibros() throws Exception {

        ArrayList<Libro> lista = new ArrayList<>();

        Connection con = ConexionBD.getConexion();

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM libros");

        while(rs.next()) {

            lista.add(
                new Libro(
                    rs.getInt("id_libro"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("genero"),
                    rs.getInt("anio")
                )
            );
        }

        return lista;
    }

    public void eliminarLibro(int id) throws Exception {

        Connection con = ConexionBD.getConexion();

        PreparedStatement ps =
        con.prepareStatement(
        "DELETE FROM libros WHERE id_libro=?");

        ps.setInt(1,id);

        ps.executeUpdate();
    }

    public void actualizarLibro(Libro libro) throws Exception {

        Connection con = ConexionBD.getConexion();

        PreparedStatement ps =
        con.prepareStatement(
        "UPDATE libros SET titulo=?,autor=?,genero=?,anio=? WHERE id_libro=?");

        ps.setString(1, libro.getTitulo());
        ps.setString(2, libro.getAutor());
        ps.setString(3, libro.getGenero());
        ps.setInt(4, libro.getAnio());
        ps.setInt(5, libro.getId());

        ps.executeUpdate();
    }
}