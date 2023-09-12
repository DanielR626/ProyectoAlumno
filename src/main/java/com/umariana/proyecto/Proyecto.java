/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 * Daniel Revelo
 */
package com.umariana.proyecto;

import Mundo.Alumno;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Proyecto {

    private static Scanner lector = new Scanner(System.in);
    private static ArrayList<Alumno> misAlumnos = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        cargarDatosArchivo();

        boolean activo = true;
        do {
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

            int option = lector.nextInt();
            switch (option) {
                case 1:
                    insertarAlumno();
                    break;

                case 2:
                    eliminarAlumno();
                    break;

                case 3:
                    modificarAlumno();
                    break;

                case 4:
                    consultarAlumno();
                    break;

                case 5:
                    generarReporte();
                    break;

                case 6:
                    guardarDatosArchivo();
                    break;

                case 7:
                    cargarDatosArchivo();
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

        lector.close();
    }

    private static void insertarAlumno() {
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

        Alumno nuevoAlumno = new Alumno(cedula, nombre, apellido, semestre, correoElectronico, celular);
        misAlumnos.add(nuevoAlumno);
        System.out.println("Alumno inserto correctamente :D ");
    }

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

    private static void modificarAlumno() {
        System.out.println("Introduce la cédula del alumno a modificar");
        int cedulaModificar = lector.nextInt();
        lector.nextLine();
        boolean modificado = false;
        for (Alumno alumno : misAlumnos) {
            if (alumno.getCedula() == cedulaModificar) {
                modificado = true;

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

    private static void consultarAlumno() {
        System.out.println("Listado de alumnos ingresados:");

        if (misAlumnos.isEmpty()) {
            System.out.println("No hay alumnos ingresados. :(");
            return;
        }

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

    private static void guardarDatosArchivo() {
        try {
            File archivo = new File("./data/reporteAlumno.txt");
            PrintWriter pluma = new PrintWriter(archivo);

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

    private static void cargarDatosArchivo() {
        try {
            File archivo = new File("./data/reporteAlumno.txt");
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                int cedula = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String apellido = partes[2];
                int semestre = Integer.parseInt(partes[3]);
                String correoElectronico = partes[4];
                int celular = Integer.parseInt(partes[5]);

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
