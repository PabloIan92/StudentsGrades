/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentsGrades;

import Entidades.Alumno;
import Servicios.AlumnoService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lemmon
 */
public class StudentsGrades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlumnoService alumno = new AlumnoService();
        Alumno objeto = new Alumno();

        alumno.crearAlumnos();

        List<Alumno> listaAlumnos = alumno.getListaAlumnos();
        
        for (Alumno aux : listaAlumnos) {
            System.out.println("Nombre: " + aux.getNombre());
            System.out.println("Notas: " + aux.getNotas());
         //   System.out.println("Promedio final: " + aux.notaFinal(aux.getNombre()));
        }
        
          Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del alumno:");
        String nombreAlumno = scanner.nextLine();

        double promedioFinal = alumno.notaFinal(nombreAlumno);
        if (promedioFinal >= 0) {
            System.out.println("El promedio final del alumno " + nombreAlumno + " es: " + promedioFinal);
        } else {
            System.out.println("El alumno no se encuentra en la lista");
        }
    }

}
