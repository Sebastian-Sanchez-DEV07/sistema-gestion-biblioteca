package biblioteca.servicios;

//! Como en todas las capas, importamos lo necesario para conectar con las demás partes del sistema
import biblioteca.excepciones.*; //* Importamos todas las excepciones
import biblioteca.modelo.*; //* Importamos todos los modelos
import java.util.*;

//? Vista  principal — conecta libros, usuarios y préstamos
public class Biblioteca {
    private Map<String, Libro> libros;       // ISBN → Libro
    private Map<String, Usuario> usuarios;   // ID → Usuario
    private Map<String, Prestamo> prestamos; // ID → Prestamo
    private int contadorPrestamos;

    public Biblioteca() {
        this.libros = new HashMap<>();
        this.usuarios = new HashMap<>();
        this.prestamos = new HashMap<>();
        this.contadorPrestamos = 1;
    }

    //? Agrega un libro a la biblioteca
    public void agregarLibro(Libro libro) {
        libros.put(libro.getIsbn(), libro);
    }

    //? Busca un libro por ISBN - ISBN es el código unico del libro
    public Libro buscarLibroPorIsbn(String isbn) throws EntidadNoEncontradaException {
        Libro libro = libros.get(isbn);
        if (libro == null) throw new EntidadNoEncontradaException();
        return libro;
    }

    //? Obtiene todos los libros de la biblioteca
    public Collection<Libro> obtenerTodosLosLibros() {
        return libros.values();
    }

    //? Registra un nuevo usuario
    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    //? Verifica si un usuario existe por su ID o no
    public Usuario buscarUsuario(String id) throws EntidadNoEncontradaException {
        Usuario usuario = usuarios.get(id);
        if (usuario == null) throw new EntidadNoEncontradaException();
        return usuario;
    }

    //? Obtiene todos los usuarios registrados
    public Collection<Usuario> obtenerTodosLosUsuarios() {
        return usuarios.values();
    }

    //? Realiza el prestamo de un libro a un usuario, verificando disponibilidad y límites.
    public Prestamo realizarPrestamo(String isbn, String idUsuario)
            throws LibroNoDisponibleException, LimitePrestamosException, EntidadNoEncontradaException {
        Libro libro = buscarLibroPorIsbn(isbn);
        Usuario usuario = buscarUsuario(idUsuario);

        libro.prestarEjemplar();  //* lanza LibroNoDisponibleException si no hay.
        String idPrestamo = "P" + String.format("%03d", contadorPrestamos++); //* Formato para mostrar el id - Ej. P001, P002...
        Prestamo prestamo = new Prestamo(idPrestamo, idUsuario, isbn);
        usuario.agregarPrestamo(idPrestamo); //* lanza LimitePrestamosException si excede.
        prestamos.put(idPrestamo, prestamo);
        return prestamo;
    }

    //? Registra y actualiza el estado de las devoluciones.
    public void registrarDevolucion(String idPrestamo) throws EntidadNoEncontradaException {
        Prestamo prestamo = prestamos.get(idPrestamo);
        if (prestamo == null) throw new EntidadNoEncontradaException();

        Libro libro = buscarLibroPorIsbn(prestamo.getIsbnLibro());
        Usuario usuario = buscarUsuario(prestamo.getIdUsuario());

        prestamo.registrarDevolucion();  //* actualiza estado del préstamo.
        libro.devolverEjemplar();        //* sube disponibilidad del libro.
        usuario.removerPrestamo(idPrestamo); //* quita de la lista del usuario.
    }

    //? Obtiene todos los préstamos registrados en la biblioteca.
    public Collection<Prestamo> obtenerTodosLosPrestamos() {
        return prestamos.values();
    }
}
