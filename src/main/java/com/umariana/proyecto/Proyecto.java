/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 * Daniel Revelo
 */
package com.umariana.proyecto;

import Mundo.Alumno; // Importación de la clase Alumno desde el paquete Mundo
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Proyecto {

    private static Scanner lector = new Scanner(System.in); // Un objeto Scanner para entrada de usuario
    private static ArrayList<Alumno> misAlumnos = new ArrayList<>(); // Una lista de objetos Alumno para almacenar datos de alumnos

    public static void main(String[] args) throws FileNotFoundException {
        cargarDatosArchivo(); // Cargar datos de archivo al inicio del programa

        boolean activo = true;
        do {
            // Menú de opciones
            System.out.println("Menu de opciones!");
            System.out.println("1. Insertar alumno");
            System.out.println("2. Eliminar alumno");
            System.out.println("3. Modificar alumno");
            System.out.println("4. Consultar alumno");
            System.out.println("5. Generar Reporte");
            System.out.println("6. Guardar datos en archivo");
            System.out.println("7. Cargar reporte desde archivo");
            System.out.println("8. Terminar Programa");
            System.out.println("-----------------------------------");

            int option = lector.nextInt(); // Leer la opción seleccionada por el usuario
            switch (option) {
                case 1:
                    insertarAlumno(); // Llamar a la función para insertar un nuevo alumno
                    break;

                case 2:
                    eliminarAlumno(); // Llamar a la función para eliminar un alumno
                    break;

                case 3:
                    modificarAlumno(); // Llamar a la función para modificar los datos de un alumno
                    break;

                case 4:
                    consultarAlumno(); // Llamar a la función para consultar la lista de alumnos
                    break;

                case 5:
                    generarReporte(); // Llamar a la función para generar un reporte de alumnos
                    break;

                case 6:
                    guardarDatosArchivo(); // Llamar a la función para guardar los datos en un archivo
                    break;

                case 7:
                    cargarDatosArchivo(); // Llamar a la función para cargar los datos desde un archivo
                    break;

                case 8:
                    activo = false;
                    System.out.println("¡Programa terminado!");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (activo);

        lector.close(); // Cerrar el objeto Scanner al final del programa
    }

    private static void insertarAlumno() {
        // Captura de datos para un nuevo alumno
        System.out.println("Introduzca la cedula del alumno");
        int cedula = lector.nextInt();
        lector.nextLine();
        System.out.println("Introduzca el nombre del alumno");
        String nombre = lector.nextLine();
        System.out.println("Introduzca el apellido del alumno");
        String apellido = lector.nextLine();
        System.out.println("Introduzcae el semestre del alumno");
        int semestre = lector.nextInt();
        lector.nextLine();
        System.out.println("Introduzca el correo electrónico del alumno");
        String correoElectronico = lector.nextLine();
        System.out.println("Introduzca el celular del alumno");
        int celular = lector.nextInt();

        // Crear un objeto Alumno y agregarlo a la lista
        Alumno nuevoAlumno = new Alumno(cedula, nombre, apellido, semestre, correoElectronico, celular);
        misAlumnos.add(nuevoAlumno);
        System.out.println("Alumno inserto correctamente :D ");
    }

    // Función para eliminar un alumno por su cédula
    private static void eliminarAlumno() {
        System.out.println("Introduzca la cédula del alumno a eliminar :D");
        int cedulaEliminar = lector.nextInt();
        boolean encontrado = false;
        for (Alumno alumno : misAlumnos) {
            if (alumno.getCedula() == cedulaEliminar) {
                misAlumnos.remove(alumno);
                System.out.println("Alumno eliminado exitosamente :D");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Alumno no encontrado :D");
        }
    }

    // Función para modificar los datos de un alumno por su cédula
    private static void modificarAlumno() {
        System.out.println("Introduce la cédula del alumno a modificar");
        int cedulaModificar = lector.nextInt();
        lector.nextLine();
        boolean modificado = false;
        for (Alumno alumno : misAlumnos) {
            if (alumno.getCedula() == cedulaModificar) {
                modificado = true;

                // Captura de nuevos datos para el alumno
                System.out.println("Introduce el nuevo número de cédula");
                int nuevaCedula = lector.nextInt();
                lector.nextLine();
                System.out.println("Introduce el nuevo nombre");
                String nuevoNombre = lector.nextLine();
                System.out.println("Introduce el nuevo apellido");
                String nuevoApellido = lector.nextLine();
                System.out.println("Introduce el nuevo semestre");
                int nuevoSemestre = lector.nextInt();
                lector.nextLine();
                System.out.println("Introduce el nuevo correo electrónico");
                String nuevoCorreo = lector.nextLine();
                System.out.println("Introduce el nuevo celular");
                int nuevoCelular = lector.nextInt();

                // Actualización de los datos del alumno
                alumno.setCedula(nuevaCedula);
                alumno.setNombre(nuevoNombre);
                alumno.setApellido(nuevoApellido);
                alumno.setSemestre(nuevoSemestre);
                alumno.setCorreoElectronico(nuevoCorreo);
                alumno.setCelular(nuevoCelular);

                System.out.println("Datos del alumno modificados exitosamente");
                break;
            }
        }

        if (!modificado) {
            System.out.println("Datos del alumno no encontrado :D ");
        }
    }

    // Función para consultar y mostrar la lista de alumnos
    private static void consultarAlumno() {
        System.out.println("Listado de alumnos ingresados:");

        if (misAlumnos.isEmpty()) {
            System.out.println("No hay alumnos ingresados. :(");
            return;
        }

        // Mostrar los datos de cada alumno
        for (Alumno alumno : misAlumnos) {
            System.out.println("Cédula: " + alumno.getCedula());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Semestre: " + alumno.getSemestre());
            System.out.println("Correo Electrónico: " + alumno.getCorreoElectronico());
            System.out.println("Celular: " + alumno.getCelular());
            System.out.println("-----------------------------");
        }
    }

    // Función para generar un reporte de todos los alumnos
    private static void generarReporte() {
        System.out.println("Reporte de todos los alumnos ingresados");
        System.out.println("------------------------------------------------------------");

        if (misAlumnos.isEmpty()) {
            System.out.println("No hay alumnos ingresados.");
        } else {
            System.out.println("Cedula,Nombre,Apellido,Semestre,Correo Electrónico,Celular");
            for (Alumno alumno : misAlumnos) {
                System.out.println(alumno.getCedula() + "," + alumno.getNombre() + "," + alumno.getApellido() + ","
                        + alumno.getSemestre() + "," + alumno.getCorreoElectronico() + "," + alumno.getCelular());
            }
        }

        System.out.println("Reporte generado exitosamente");
    }

    // Función para guardar los datos de los alumnos en un archivo
    private static void guardarDatosArchivo() {
        try {
            File archivo = new File("./data/reporteAlumno.txt");
            PrintWriter pluma = new PrintWriter(archivo);

            // Escribir los datos de los alumnos en el archivo
            for (Alumno alumno : misAlumnos) {
                pluma.println(alumno.getCedula() + "," + alumno.getNombre() + "," + alumno.getApellido() + ","
                        + alumno.getSemestre() + "," + alumno.getCorreoElectronico() + "," + alumno.getCelular());
            }

            pluma.close();
            System.out.println("Datos guardados exitosamente en el archivo");
        } catch (FileNotFoundException e) {
            System.out.println("Error al guardar los datos en el archivo");
        }
    }

    // Función para cargar los datos de los alumnos desde un archivo
    private static void cargarDatosArchivo() {
        try {
            File archivo = new File("./data/reporteAlumno.txt");
            Scanner scanner = new Scanner(archivo);

            // Leer y procesar cada línea del archivo
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                int cedula = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String apellido = partes[2];
                int semestre = Integer.parseInt(partes[3]);
                String correoElectronico = partes[4];
                int celular = Integer.parseInt(partes[5]);

                // Crear un objeto Alumno y agregarlo a la lista
                Alumno alumno = new Alumno(cedula, nombre, apellido, semestre, correoElectronico, celular);
                misAlumnos.add(alumno);
            }

            scanner.close();
            System.out.println("Datos cargados exitosamente desde el archivo");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de datos. Se iniciará con lista vacía.");
        }
    }
}
