package biblioteca.modelo;
import biblioteca.enumeraciones.EstadoPrestamo;
import biblioteca.excepciones.LibroNoDisponibleException;
import biblioteca.excepciones.LimitePrestamosException;

public class Libro {

    //! Atributos de la clase Libro
    private String isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int anio;
    private String genero;
    private int cantidadTotal;
    private int cantidadDisponible;

    //! Constructores de la clase libro
    public Libro(String isbn, String titulo, String autor, String editorial, int anio, String genero, int cantidadTotal) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
        this.genero = genero;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponible = cantidadTotal;
    }

    //! Getters y Setters
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getCantidadTotal() {
        return cantidadTotal;
    }
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    //! Verifica si el libro esta disponible
    public boolean estaDisponible() throws LibroNoDisponibleException {
        return cantidadDisponible > 0;
    }

    //! Resta el ejemplar del libro prestado a cantidad disponible
    public boolean prestarEjemplar() throws LibroNoDisponibleException {
        if(estaDisponible()) {
            cantidadDisponible--;
            return true;
        } else {
            throw new LibroNoDisponibleException();
        }
    }

    //! Suma el ejemplar del libro prestado a cantidad disponible
    public void devolverEjemplar() {
        if(cantidadDisponible < cantidadTotal) {
            cantidadDisponible++;
        }
    }

    //! Hace un toString del libro
    @Override
    public String toString() {
        return "ISBN: " + isbn + " | Titulo: " + titulo + " | Autor: " + autor + " | Disponibles: " + cantidadDisponible + "/" + cantidadTotal;
    }
}
