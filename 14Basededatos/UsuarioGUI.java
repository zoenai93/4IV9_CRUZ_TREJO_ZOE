import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UsuarioGUI extends JFrame {

    JTextField txtId, txtNombre, txtEdad, txtCorreo;

    JButton btnGuardar, btnBuscar, btnActualizar, btnEliminar;

    public UsuarioGUI() {

        setTitle("CRUD Usuarios");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(6,2,10,10));

        panel.add(new JLabel("ID Usuario"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Nombre"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Edad"));
        txtEdad = new JTextField();
        panel.add(txtEdad);

        panel.add(new JLabel("Correo"));
        txtCorreo = new JTextField();
        panel.add(txtCorreo);

        btnGuardar = new JButton("Guardar");
        btnBuscar = new JButton("Buscar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        panel.add(btnGuardar);
        panel.add(btnBuscar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarUsuario());
        btnBuscar.addActionListener(e -> buscarUsuario());
        btnActualizar.addActionListener(e -> actualizarUsuario());
        btnEliminar.addActionListener(e -> eliminarUsuario());

    }

    public void guardarUsuario() {

        try {

            Connection con = ConexionBD.getConexion();

            String sql =
            "INSERT INTO usuarios(nombre,edad,correo) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, txtNombre.getText());
            ps.setInt(2, Integer.parseInt(txtEdad.getText()));
            ps.setString(3, txtCorreo.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Usuario guardado");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public void buscarUsuario() {

        try {

            Connection con = ConexionBD.getConexion();

            String sql =
            "SELECT * FROM usuarios WHERE id_usuario=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtId.getText()));

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                txtNombre.setText(rs.getString("nombre"));
                txtEdad.setText(rs.getString("edad"));
                txtCorreo.setText(rs.getString("correo"));

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public void actualizarUsuario() {

        try {

            Connection con = ConexionBD.getConexion();

            String sql =
            "UPDATE usuarios SET nombre=?,edad=?,correo=? WHERE id_usuario=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, txtNombre.getText());
            ps.setInt(2, Integer.parseInt(txtEdad.getText()));
            ps.setString(3, txtCorreo.getText());
            ps.setInt(4, Integer.parseInt(txtId.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Usuario actualizado");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public void eliminarUsuario() {

        try {

            Connection con = ConexionBD.getConexion();

            String sql =
            "DELETE FROM usuarios WHERE id_usuario=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtId.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Usuario eliminado");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public static void main(String[] args) {

        new UsuarioGUI().setVisible(true);

    }

}