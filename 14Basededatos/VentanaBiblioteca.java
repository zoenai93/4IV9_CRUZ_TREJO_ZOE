import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class VentanaBiblioteca extends JFrame {

    JTextField txtId, txtTitulo, txtAutor, txtGenero, txtAnio;

    JButton btnGuardar, btnBuscar, btnActualizar, btnEliminar;

    public VentanaBiblioteca() {

        setTitle("CRUD Libros");
        setSize(500,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7,2,10,10));

        panel.add(new JLabel("ID Libro"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Titulo"));
        txtTitulo = new JTextField();
        panel.add(txtTitulo);

        panel.add(new JLabel("Autor"));
        txtAutor = new JTextField();
        panel.add(txtAutor);

        panel.add(new JLabel("Genero"));
        txtGenero = new JTextField();
        panel.add(txtGenero);

        panel.add(new JLabel("Año"));
        txtAnio = new JTextField();
        panel.add(txtAnio);

        btnGuardar = new JButton("Guardar");
        btnBuscar = new JButton("Buscar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        panel.add(btnGuardar);
        panel.add(btnBuscar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarLibro());
        btnBuscar.addActionListener(e -> buscarLibro());
        btnActualizar.addActionListener(e -> actualizarLibro());
        btnEliminar.addActionListener(e -> eliminarLibro());

    }

    public void guardarLibro() {

        try {

            Connection con = ConexionBD.getConexion();

            String sql =
            "INSERT INTO libros(titulo,autor,genero,anio) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, txtTitulo.getText());
            ps.setString(2, txtAutor.getText());
            ps.setString(3, txtGenero.getText());
            ps.setInt(4, Integer.parseInt(txtAnio.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Libro guardado");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public void buscarLibro() {

        try {

            Connection con = ConexionBD.getConexion();

            String sql =
            "SELECT * FROM libros WHERE id_libro=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtId.getText()));

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                txtTitulo.setText(rs.getString("titulo"));
                txtAutor.setText(rs.getString("autor"));
                txtGenero.setText(rs.getString("genero"));
                txtAnio.setText(rs.getString("anio"));

            } else {

                JOptionPane.showMessageDialog(null,
                        "Libro no encontrado");

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public void actualizarLibro() {

        try {

            Connection con = ConexionBD.getConexion();

            String sql =
            "UPDATE libros SET titulo=?,autor=?,genero=?,anio=? WHERE id_libro=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, txtTitulo.getText());
            ps.setString(2, txtAutor.getText());
            ps.setString(3, txtGenero.getText());
            ps.setInt(4, Integer.parseInt(txtAnio.getText()));
            ps.setInt(5, Integer.parseInt(txtId.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Libro actualizado");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public void eliminarLibro() {

        try {

            Connection con = ConexionBD.getConexion();

            String sql =
            "DELETE FROM libros WHERE id_libro=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtId.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Libro eliminado");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public static void main(String[] args) {

        new VentanaBiblioteca().setVisible(true);

    }

}