// HerenciaPersona.java

import javax.swing.JOptionPane;

public class HerenciaPersona {

    public static void main(String[] args) {

        DAOEstudiante estudiantes =
                new DAOEstudiante();

        DAOProfesor profesores =
                new DAOProfesor();

        String op = "si";

        while (op.equalsIgnoreCase("si")) {

            int opcion = Integer.parseInt(

                    JOptionPane.showInputDialog(

                            "MENU PRINCIPAL\n"
                            + "1. CRUD Estudiantes\n"
                            + "2. CRUD Profesores"));

            switch (opcion) {

                case 1:

                    estudiantes.menu();

                    break;

                case 2:

                    profesores.menu();

                    break;

                default:

                    JOptionPane.showMessageDialog(
                            null,
                            "Opcion invalida");
            }

            op = JOptionPane.showInputDialog(
                    "¿Deseas regresar al menu principal? si/no");
        }
    }
}
