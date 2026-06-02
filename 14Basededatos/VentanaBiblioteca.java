import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class VentanaBiblioteca extends JFrame {

    JTextField txtTitulo;
    JTextField txtAutor;
    JTextField txtGenero;
    JTextField txtAnio;

    JButton btnGuardar;

    public VentanaBiblioteca() {

        setTitle("Biblioteca");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5,2,10,10));

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

        btnGuardar = new JButton("Guardar Libro");
        panel.add(btnGuardar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarLibro());

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
                    "Libro guardado correctamente");

            txtTitulo.setText("");
            txtAutor.setText("");
            txtGenero.setText("");
            txtAnio.setText("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        }

    }

    public static void main(String[] args) {

        new VentanaBiblioteca().setVisible(true);

    }

}