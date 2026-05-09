package biblioteca;

import biblioteca.modelo.*;
import biblioteca.servicios.Biblioteca;
import biblioteca.vista.Menu;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        //! Datos de prueba para demostrar el funcionamiento del sistema.
        biblioteca.agregarLibro(new Libro("978-001", "El Principito", "Saint-Exupéry", "Planeta", 1943, "Ficción", 3));
        biblioteca.agregarLibro(new Libro("978-002", "Clean Code", "Robert Martin", "Prentice Hall", 2008, "Tecnología", 2));
        biblioteca.agregarLibro(new Libro("978-003", "Cien años de soledad", "García Márquez", "Sudamericana", 1967, "Novela", 1));

        biblioteca.registrarUsuario(new Usuario("U001", "Ana", "García", "ana@email.com"));
        biblioteca.registrarUsuario(new Usuario("U002", "Carlos", "López", "carlos@email.com"));

        //! Arranca el menú.
        Menu menu = new Menu(biblioteca);
        menu.mostrarMenuPrincipal();
    }

}