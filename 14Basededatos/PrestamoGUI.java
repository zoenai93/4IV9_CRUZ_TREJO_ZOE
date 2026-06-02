import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PrestamoGUI extends JFrame {

    JTextField txtIdUsuario;
    JTextField txtIdLibro;
    JTextField txtFecha;

    JButton btnGuardar;

    public PrestamoGUI() {

        setTitle("Prestamos");
        setSize(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(4,2,10,10));

        panel.add(new JLabel("ID Usuario"));
        txtIdUsuario = new JTextField();
        panel.add(txtIdUsuario);

        panel.add(new JLabel("ID Libro"));
        txtIdLibro = new JTextField();
        panel.add(txtIdLibro);

        panel.add(new JLabel("Fecha"));
        txtFecha = new JTextField();
        panel.add(txtFecha);

        btnGuardar = new JButton("Guardar Prestamo");
        panel.add(btnGuardar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarPrestamo());

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

            txtIdUsuario.setText("");
            txtIdLibro.setText("");
            txtFecha.setText("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public static void main(String[] args) {

        new PrestamoGUI().setVisible(true);

    }

}