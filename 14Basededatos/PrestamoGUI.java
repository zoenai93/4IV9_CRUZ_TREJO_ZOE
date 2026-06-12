import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class PrestamoGUI extends JFrame {

    JTextField txtIdPrestamo, txtIdUsuario, txtIdLibro, txtFecha;

    JButton btnGuardar, btnBuscar, btnActualizar, btnEliminar;

    public PrestamoGUI() {

        setTitle("CRUD Prestamos");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(6,2,10,10));

        panel.add(new JLabel("ID Prestamo"));
        txtIdPrestamo = new JTextField();
        panel.add(txtIdPrestamo);

        panel.add(new JLabel("ID Usuario"));
        txtIdUsuario = new JTextField();
        panel.add(txtIdUsuario);

        panel.add(new JLabel("ID Libro"));
        txtIdLibro = new JTextField();
        panel.add(txtIdLibro);

        panel.add(new JLabel("Fecha"));
        txtFecha = new JTextField();
        panel.add(txtFecha);

        btnGuardar = new JButton("Guardar");
        btnBuscar = new JButton("Buscar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        panel.add(btnGuardar);
        panel.add(btnBuscar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarPrestamo());
        btnBuscar.addActionListener(e -> buscarPrestamo());
        btnActualizar.addActionListener(e -> actualizarPrestamo());
        btnEliminar.addActionListener(e -> eliminarPrestamo());

    }

    public void guardarPrestamo() {

        try {

            Connection con = ConexionBD.getConexion();

            String sql =
            "INSERT INTO prestamos(id_usuario,id_libro,fecha_prestamo) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtIdUsuario.getText()));
            ps.setInt(2, Integer.parseInt(txtIdLibro.getText()));
            ps.setString(3, txtFecha.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Prestamo guardado");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public void buscarPrestamo() {

        try {

            Connection con = ConexionBD.getConexion();

            String sql =
            "SELECT * FROM prestamos WHERE id_prestamo=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtIdPrestamo.getText()));

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                txtIdUsuario.setText(rs.getString("id_usuario"));
                txtIdLibro.setText(rs.getString("id_libro"));
                txtFecha.setText(rs.getString("fecha_prestamo"));

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public void actualizarPrestamo() {

        try {

            Connection con = ConexionBD.getConexion();

            String sql =
            "UPDATE prestamos SET id_usuario=?,id_libro=?,fecha_prestamo=? WHERE id_prestamo=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtIdUsuario.getText()));
            ps.setInt(2, Integer.parseInt(txtIdLibro.getText()));
            ps.setString(3, txtFecha.getText());
            ps.setInt(4, Integer.parseInt(txtIdPrestamo.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Prestamo actualizado");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public void eliminarPrestamo() {

        try {

            Connection con = ConexionBD.getConexion();

            String sql =
            "DELETE FROM prestamos WHERE id_prestamo=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtIdPrestamo.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Prestamo eliminado");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public static void main(String[] args) {

        new PrestamoGUI().setVisible(true);

    }

}