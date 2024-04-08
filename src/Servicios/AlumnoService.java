
package Servicios;

import Entidades.Alumno;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlumnoService {
    
    Scanner scanner = new Scanner(System.in);
      private List<Alumno> listaAlumnos;

    public AlumnoService() {
        listaAlumnos = new ArrayList<>();
    }

    public void crearAlumnos() {
        
        String respuesta="";
       
        do {
            System.out.println("Ingrese el nombre del alumno:");
            String nombre = scanner.nextLine();

            List<Integer> notas = new ArrayList<>();
            for (int i = 1; i <= 3; i++) {
                System.out.println("Ingrese la nota " + i + ":");
                int nota = scanner.nextInt();
                notas.add(nota);
            }
            scanner.nextLine(); // Limpiar el buffer de entrada

            Alumno alumno = new Alumno(nombre, notas);
            listaAlumnos.add(alumno);
  
            System.out.println("¿Desea crear otro alumno? (s/n)");
            respuesta = scanner.nextLine();
        } while (respuesta.equalsIgnoreCase("s"));
    }

    // Otros métodos del servicio...

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }
    
    public double notaFinal(String nombreAlumno){
        for (Alumno alumno : listaAlumnos) {
            if (alumno.getNombre().equals(nombreAlumno)) {
                List<Integer> notas = alumno.getNotas();
                int suma = 0;
                for (int nota : notas) {
                    suma += nota;
                }
                double promedio = (double) suma / 3;
                return promedio;
            }
        }
         return -1;
    }
    
}


