import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Usuario extends JFrame {

    JTextField txtNombre;
    JTextField txtEdad;
    JTextField txtCorreo;

    JButton btnGuardar;

    public Usuario() {

        setTitle("Usuarios");
        setSize(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(4,2,10,10));

        panel.add(new JLabel("Nombre"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Edad"));
        txtEdad = new JTextField();
        panel.add(txtEdad);

        panel.add(new JLabel("Correo"));
        txtCorreo = new JTextField();
        panel.add(txtCorreo);

        btnGuardar = new JButton("Guardar Usuario");
        panel.add(btnGuardar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarUsuario());

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
                    "Usuario guardado correctamente");

            txtNombre.setText("");
            txtEdad.setText("");
            txtCorreo.setText("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public static void main(String[] args) {

        new Usuario().setVisible(true);

    }

}