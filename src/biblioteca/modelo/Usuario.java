package biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;
import biblioteca.excepciones.LimitePrestamosException;

public class Usuario {

    //! Atributos de la clase Usuario
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private List<String> prestamosActivos;           //*  IDs de préstamos activos
    private static final int LIMITE_PRESTAMOS = 2;  //* constante — nunca cambia

    //! Constructores de la clase Usuario
    public Usuario(String id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.prestamosActivos = new ArrayList<>();   //* empieza vacío
    }

    //! Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public List<String> getPrestamosActivos() { return prestamosActivos; }

    //? Método de negocio — el usuario decide si puede pedir más libros
    public boolean puedeRealizarPrestamo() {
        return prestamosActivos.size() < LIMITE_PRESTAMOS;
    }

    //? Verifica si puede devolver un libro
    public void agregarPrestamo(String idPrestamo) throws LimitePrestamosException {
        if (!puedeRealizarPrestamo()) throw new LimitePrestamosException();
        prestamosActivos.add(idPrestamo); //? Añade el id del prestamo al listado
    }

    //? Elimina un prestamo del listado de activos
    public void removerPrestamo(String idPrestamo) {
        prestamosActivos.remove(idPrestamo);
    }

    @Override //? Sobreescribimos el método toString para mostrar información del usuario
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " " + apellido +
                " | Email: " + email +
                " | Préstamos activos: " + prestamosActivos.size() + "/" + LIMITE_PRESTAMOS;
    }
}
