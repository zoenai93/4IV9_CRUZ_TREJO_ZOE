import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaBiblioteca extends JFrame {

    JTextField txtId, txtTitulo, txtAutor, txtGenero, txtAnio;

    JButton btnAgregar, btnMostrar, btnBuscar, btnActualizar, btnEliminar;

    JTable tabla;
    DefaultTableModel modelo;

    LibroDAO dao = new LibroDAO();

    public VentanaBiblioteca() {

        setTitle("CRUD Biblioteca");
        setSize(900,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        txtId = new JTextField(5);
        txtTitulo = new JTextField(10);
        txtAutor = new JTextField(10);
        txtGenero = new JTextField(10);
        txtAnio = new JTextField(5);

        btnAgregar = new JButton("Agregar");
        btnMostrar = new JButton("Mostrar");
        btnBuscar = new JButton("Buscar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        add(new JLabel("ID"));
        add(txtId);

        add(new JLabel("Titulo"));
        add(txtTitulo);

        add(new JLabel("Autor"));
        add(txtAutor);

        add(new JLabel("Genero"));
        add(txtGenero);

        add(new JLabel("Año"));
        add(txtAnio);

        add(btnAgregar);
        add(btnMostrar);
        add(btnBuscar);
        add(btnActualizar);
        add(btnEliminar);

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Titulo");
        modelo.addColumn("Autor");
        modelo.addColumn("Genero");
        modelo.addColumn("Año");

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(850,350));

        add(scroll);

        btnAgregar.addActionListener(e -> agregar());
        btnMostrar.addActionListener(e -> mostrar());
        btnBuscar.addActionListener(e -> buscar());
        btnActualizar.addActionListener(e -> actualizar());
        btnEliminar.addActionListener(e -> eliminar());

        mostrar();
    }

    private void agregar() {

        try {

            Libro libro = new Libro();

            libro.setTitulo(txtTitulo.getText());
            libro.setAutor(txtAutor.getText());
            libro.setGenero(txtGenero.getText());
            libro.setAnio(Integer.parseInt(txtAnio.getText()));

            dao.insertarLibro(libro);

            JOptionPane.showMessageDialog(null,
                    "Libro agregado correctamente");

            limpiar();

            mostrar();

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

        }
    }

    private void mostrar() {

        try {

            modelo.setRowCount(0);

            for(Libro l : dao.obtenerLibros()) {

                modelo.addRow(new Object[]{
                    l.getId(),
                    l.getTitulo(),
                    l.getAutor(),
                    l.getGenero(),
                    l.getAnio()
                });
            }

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

        }
    }

    private void buscar() {

        try {

            if(txtId.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Ingresa un ID");

                return;
            }

            int idBuscado =
                    Integer.parseInt(txtId.getText());

            for(Libro l : dao.obtenerLibros()) {

                if(l.getId() == idBuscado) {

                    txtTitulo.setText(l.getTitulo());
                    txtAutor.setText(l.getAutor());
                    txtGenero.setText(l.getGenero());
                    txtAnio.setText(
                            String.valueOf(l.getAnio()));

                    return;
                }
            }

            JOptionPane.showMessageDialog(null,
                    "Libro no encontrado");

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

        }
    }

    private void actualizar() {

        try {

            if(txtId.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Ingresa un ID");

                return;
            }

            Libro libro = new Libro();

            libro.setId(
                    Integer.parseInt(txtId.getText()));

            libro.setTitulo(txtTitulo.getText());
            libro.setAutor(txtAutor.getText());
            libro.setGenero(txtGenero.getText());
            libro.setAnio(
                    Integer.parseInt(txtAnio.getText()));

            dao.actualizarLibro(libro);

            JOptionPane.showMessageDialog(null,
                    "Libro actualizado");

            limpiar();

            mostrar();

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

        }
    }

    private void eliminar() {

        try {

            if(txtId.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Ingresa un ID");

                return;
            }

            dao.eliminarLibro(
                    Integer.parseInt(txtId.getText()));

            JOptionPane.showMessageDialog(null,
                    "Libro eliminado");

            limpiar();

            mostrar();

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

        }
    }

    private void limpiar() {

        txtId.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtGenero.setText("");
        txtAnio.setText("");
    }

    public static void main(String[] args) {

        new VentanaBiblioteca().setVisible(true);

    }
}