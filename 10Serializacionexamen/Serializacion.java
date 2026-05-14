
// Serializacion.java

import java.io.*;

public class Serializacion {


    public static void guardarEstudiantes(Estudiante[] estudiantes, int x) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("estudiantes.txt"));

            for (int i = 0; i < x; i++) {

                writer.write(
                        estudiantes[i].getNumBoleta()
                        + ","
                        + estudiantes[i].getNombre()
                        + ","
                        + estudiantes[i].getEdad()
                        + ","
                        + estudiantes[i].getGenero());

                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error al guardar estudiantes");
        }
    }

    public static Estudiante[] cargarEstudiantes() {

        Estudiante[] estudiantes = new Estudiante[10];

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("estudiantes.txt"));

            String linea;

            int i = 0;

            while ((linea = reader.readLine()) != null) {

                String[] datos = linea.split(",");

                estudiantes[i] = new Estudiante(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        Integer.parseInt(datos[2]),
                        datos[3].charAt(0));

                i++;
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Archivo estudiantes no encontrado");
        }

        return estudiantes;
    }

    //profes
    public static void guardarProfesores(Profesor[] profesores, int x) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("profesores.txt"));

            for (int i = 0; i < x; i++) {

                writer.write(
                        profesores[i].getNumEmpleado()
                        + ","
                        + profesores[i].getNombre()
                        + ","
                        + profesores[i].getEdad()
                        + ","
                        + profesores[i].getGenero());

                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error al guardar profesores");
        }
    }

    public static Profesor[] cargarProfesores() {

        Profesor[] profesores = new Profesor[10];

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("profesores.txt"));

            String linea;

            int i = 0;

            while ((linea = reader.readLine()) != null) {

                String[] datos = linea.split(",");

                profesores[i] = new Profesor(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        Integer.parseInt(datos[2]),
                        datos[3].charAt(0));

                i++;
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Archivo profesores no encontrado");
        }

        return profesores;
    }
}