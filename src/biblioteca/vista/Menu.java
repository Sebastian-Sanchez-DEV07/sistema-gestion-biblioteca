package biblioteca.vista;

//* Importamos las excepciones y los modelos necesarios para interactuar con la biblioteca
import biblioteca.excepciones.*;
import biblioteca.modelo.*;
import biblioteca.servicios.Biblioteca;
import java.util.Scanner;

/* * Esta es la vida principal y la que interactúa con el usuario.
* Decidí hacerlo en una clase separada para facilitar la prueba.
* También es una manera más eficiente y limpia.
* El uso de do, while, case, entre otros; Los implemente para mejorar la legibilidad.
 * */

public class Menu {
    private Biblioteca biblioteca;
    private Scanner scanner; //* Inicializamos el scanner

    //! Constructor de la clase Menu
    public Menu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.scanner = new Scanner(System.in);
    }

    //? Muestra el menu principal y maneja la navegación entre las diferentes opciones
    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE BIBLIOTECA =====");
            System.out.println("1. Gestión de Libros");
            System.out.println("2. Gestión de Usuarios");
            System.out.println("3. Gestión de Préstamos");
            System.out.println("4. Reporte General");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            //? Como se puede observar el switch(opcion) es muy eficiente y limpio para manejar las diferentes opciones del menú, evitando anidamientos y mejorando la legibilidad.
            switch (opcion) {
                case 1 -> menuLibros();
                case 2 -> menuUsuarios();
                case 3 -> menuPrestamos();
                case 4 -> reporteGeneral();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    //? Menu de opciones para gestionar libros con su respectivo switch case.
    private void menuLibros() {
        System.out.println("\n--- LIBROS ---");
        System.out.println("1. Agregar libro");
        System.out.println("2. Ver todos los libros");
        System.out.println("3. Buscar por ISBN");
        System.out.print("Opción: ");
        int op = scanner.nextInt(); scanner.nextLine();
        switch (op) {
            case 1 -> agregarLibro();
            case 2 -> verLibros();
            case 3 -> buscarLibro();
        }
    }

    //? Inicializa los campos del libro y lo agrega a la biblioteca.
    private void agregarLibro() {
        System.out.println("\n-- Agregar Libro --");
        System.out.print("ISBN: ");        String isbn = scanner.nextLine();
        System.out.print("Título: ");      String titulo = scanner.nextLine();
        System.out.print("Autor: ");       String autor = scanner.nextLine();
        System.out.print("Editorial: ");   String editorial = scanner.nextLine();
        System.out.print("Año: ");         int anio = scanner.nextInt(); scanner.nextLine();
        System.out.print("Género: ");      String genero = scanner.nextLine();
        System.out.print("Ejemplares: ");  int cantidad = scanner.nextInt(); scanner.nextLine();

        biblioteca.agregarLibro(new Libro(isbn, titulo, autor, editorial, anio, genero, cantidad));
        System.out.println("✅ Libro agregado."); //* Menaje de confirmación para el usuario después de agregar un libro exitosamente.
    }

    //? Muestra todos los libros registrados en la biblioteca.
    private void verLibros() {
        System.out.println("\n-- Todos los Libros --");
        if (biblioteca.obtenerTodosLosLibros().isEmpty()) {
            System.out.println("No hay libros registrados."); return; //* return funciona para mostrar lo que no hay libros registrados y salir del método sin ejecutar el forEach.
        }
        biblioteca.obtenerTodosLosLibros().forEach(System.out::println);
    }

    //? Busca un libro por su ISBN y muestra los detalles del libro.
    private void buscarLibro() {
        System.out.print("ISBN: "); String isbn = scanner.nextLine();
        try {
            System.out.println(biblioteca.buscarLibroPorIsbn(isbn));
        } catch (EntidadNoEncontradaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //? Menu de opciones para gestionar usuarios con su respectivo switch case.
    private void menuUsuarios() {
        System.out.println("\n--- USUARIOS ---");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Ver todos los usuarios");
        System.out.print("Opción: ");
        int op = scanner.nextInt(); scanner.nextLine();
        switch (op) {
            case 1 -> registrarUsuario();
            case 2 -> verUsuarios();
        }
    }

    //? Registra un nuevo usuario en la biblioteca.
    private void registrarUsuario() {
        System.out.println("\n-- Registrar Usuario --");
        System.out.print("ID: ");       String id = scanner.nextLine();
        System.out.print("Nombre: ");   String nombre = scanner.nextLine();
        System.out.print("Apellido: "); String apellido = scanner.nextLine();
        System.out.print("Email: ");    String email = scanner.nextLine();

        biblioteca.registrarUsuario(new Usuario(id, nombre, apellido, email));
        System.out.println("✅ Usuario registrado.");
    }

    //? Muestra todos los usuarios registrados en la biblioteca.
    private void verUsuarios() {
        System.out.println("\n-- Todos los Usuarios --");
        if (biblioteca.obtenerTodosLosUsuarios().isEmpty()) {
            System.out.println("No hay usuarios registrados."); return;
        }
        biblioteca.obtenerTodosLosUsuarios().forEach(System.out::println);
    }

    //? Menu para manejar los préstamos con su respectivo switch case.
    private void menuPrestamos() {
        System.out.println("\n--- PRÉSTAMOS ---");
        System.out.println("1. Realizar préstamo");
        System.out.println("2. Registrar devolución");
        System.out.println("3. Ver todos los préstamos");
        System.out.print("Opción: ");
        int op = scanner.nextInt(); scanner.nextLine();
        switch (op) {
            case 1 -> realizarPrestamo();
            case 2 -> registrarDevolucion();
            case 3 -> verPrestamos();
        }
    }

    //? Para realizar el prestamo de un libro, se necesita el ISBN del libro y el ID del usuario.
    private void realizarPrestamo() {
        System.out.println("\n-- Realizar Préstamo --");
        System.out.print("ISBN del libro: ");  String isbn = scanner.nextLine();
        System.out.print("ID del usuario: ");  String idUsuario = scanner.nextLine();
        try {
            Prestamo prestamo = biblioteca.realizarPrestamo(isbn, idUsuario);
            System.out.println("✅ Préstamo realizado: " + prestamo);
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage()); //* Para esto era las excepciones creadas.
        }
    }

    //? Menu para registrar las devoluciones de la biblioteca.
    private void registrarDevolucion() {
        System.out.println("\n-- Registrar Devolución --");
        System.out.print("ID del préstamo (ej: P001): "); String id = scanner.nextLine();
        try {
            biblioteca.registrarDevolucion(id);
            System.out.println("✅ Devolución registrada.");
        } catch (EntidadNoEncontradaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //? Ver prestamos registrados en la biblioteca.
    private void verPrestamos() {
        System.out.println("\n-- Todos los Préstamos --");
        if (biblioteca.obtenerTodosLosPrestamos().isEmpty()) {
            System.out.println("No hay préstamos registrados."); return;
        }
        biblioteca.obtenerTodosLosPrestamos().forEach(System.out::println);
    }

    //? Muestra un reporte general de la biblioteca.
    private void reporteGeneral() {
        long activos = biblioteca.obtenerTodosLosPrestamos()
                .stream().filter(Prestamo::estaActivo).count();
        System.out.println("\n===== REPORTE GENERAL =====");
        System.out.println("Libros registrados:  " + biblioteca.obtenerTodosLosLibros().size());
        System.out.println("Usuarios registrados: " + biblioteca.obtenerTodosLosUsuarios().size());
        System.out.println("Préstamos totales:    " + biblioteca.obtenerTodosLosPrestamos().size());
        System.out.println("Préstamos activos:    " + activos);
    }
}