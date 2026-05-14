// DAOEstudiante.java

import javax.swing.JOptionPane;

public class DAOEstudiante {

    Estudiante[] obj = new Estudiante[10];

    int x = 0;

    public DAOEstudiante() {

        obj = Serializacion.cargarEstudiantes();

        for (Estudiante e : obj) {

            if (e != null) {

                x++;
            }
        }
    }

    public void menu() {

        String op = "si";

        while (op.equalsIgnoreCase("si")) {

            int opcion = Integer.parseInt(

                    JOptionPane.showInputDialog(

                            "CRUD ESTUDIANTES\n"
                            + "1. Registrar\n"
                            + "2. Mostrar\n"
                            + "3. Buscar\n"
                            + "4. Editar\n"
                            + "5. Eliminar"));

            switch (opcion) {

                case 1:

                    registrar();

                    break;

                case 2:

                    mostrar();

                    break;

                case 3:

                    buscar();

                    break;

                case 4:

                    editar();

                    break;

                case 5:

                    eliminar();

                    break;

                default:

                    JOptionPane.showMessageDialog(
                            null,
                            "Opcion invalida");
            }

            op = JOptionPane.showInputDialog(
                    "¿Deseas continuar? si/no");
        }
    }

    public void registrar() {

        if (x < obj.length) {

            int boleta = Integer.parseInt(

                    JOptionPane.showInputDialog(
                            "Boleta"));

            String nombre = JOptionPane.showInputDialog(
                    "Nombre");

            int edad = Integer.parseInt(

                    JOptionPane.showInputDialog(
                            "Edad"));

            char genero = JOptionPane.showInputDialog(
                    "Genero M/F").charAt(0);

            obj[x] = new Estudiante(
                    boleta,
                    nombre,
                    edad,
                    genero);

            x++;

            Serializacion.guardarEstudiantes(obj, x);

            JOptionPane.showMessageDialog(
                    null,
                    "Registrado");

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Arreglo lleno");
        }
    }

    public void mostrar() {

        if (x == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "No hay datos");

        } else {

            String datos = "";

            for (int i = 0; i < x; i++) {

                datos +=
                        "Boleta: "
                        + obj[i].getNumBoleta()
                        + "\nNombre: "
                        + obj[i].getNombre()
                        + "\nEdad: "
                        + obj[i].getEdad()
                        + "\nGenero: "
                        + obj[i].getGenero()
                        + "\n-----------------\n";
            }

            JOptionPane.showMessageDialog(
                    null,
                    datos);
        }
    }

    public void buscar() {

        int boleta = Integer.parseInt(

                JOptionPane.showInputDialog(
                        "Boleta a buscar"));

        for (int i = 0; i < x; i++) {

            if (obj[i].getNumBoleta() == boleta) {

                JOptionPane.showMessageDialog(
                        null,

                        "Nombre: "
                        + obj[i].getNombre()
                        + "\nEdad: "
                        + obj[i].getEdad()
                        + "\nGenero: "
                        + obj[i].getGenero());

                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "No encontrado");
    }

    public void editar() {

        int boleta = Integer.parseInt(

                JOptionPane.showInputDialog(
                        "Boleta a editar"));

        for (int i = 0; i < x; i++) {

            if (obj[i].getNumBoleta() == boleta) {

                obj[i].setNombre(

                        JOptionPane.showInputDialog(
                                "Nuevo nombre"));

                obj[i].setEdad(

                        Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        "Nueva edad")));

                obj[i].setGenero(

                        JOptionPane.showInputDialog(
                                "Nuevo genero")
                                .charAt(0));

                Serializacion.guardarEstudiantes(obj, x);

                JOptionPane.showMessageDialog(
                        null,
                        "Actualizado");

                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "No encontrado");
    }

    public void eliminar() {

        int boleta = Integer.parseInt(

                JOptionPane.showInputDialog(
                        "Boleta a eliminar"));

        for (int i = 0; i < x; i++) {

            if (obj[i].getNumBoleta() == boleta) {

                for (int j = i; j < x - 1; j++) {

                    obj[j] = obj[j + 1];
                }

                obj[x - 1] = null;

                x--;

                Serializacion.guardarEstudiantes(obj, x);

                JOptionPane.showMessageDialog(
                        null,
                        "Eliminado");

                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "No encontrado");
    }
}