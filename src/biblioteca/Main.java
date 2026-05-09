package biblioteca;
import biblioteca.modelo.Libro;
import biblioteca.excepciones.LibroNoDisponibleException;

public class Main {
    public static void main(String[] args) throws LibroNoDisponibleException {
        Libro libro = new Libro("978-123", "El Principito", "Saint-Exupéry", "Planeta", 1943, "Ficción", 2);

        try {
            libro.prestarEjemplar();
            System.out.println("Después de prestar: " + libro);

            libro.prestarEjemplar();
            System.out.println("Después de prestar otro: " + libro);

            libro.prestarEjemplar(); // ← aquí salta
        } catch (LibroNoDisponibleException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
    }
}