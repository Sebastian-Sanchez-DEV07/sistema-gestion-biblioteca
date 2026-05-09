package biblioteca.modelo;

import biblioteca.enumeraciones.EstadoPrestamo; //* enum de EstadoPrestamo
import java.time.LocalDate; //* Para manejar fechas

public class Prestamo {

    //! Atributos de la clase Prestamo
    private String id;
    private String idUsuario;
    private String isbnLibro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionEsperada;
    private EstadoPrestamo estado;
    private static final int DIAS_PRESTAMO = 7; //* plazo de devolución

    //! Constructores de la clase Prestamo
    public Prestamo(String id, String idUsuario, String isbnLibro) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.isbnLibro = isbnLibro;
        this.fechaPrestamo = LocalDate.now();                          //* hoy
        this.fechaDevolucionEsperada = fechaPrestamo.plusDays(DIAS_PRESTAMO); //* hoy + 7 días
        this.estado = EstadoPrestamo.ACTIVO;
    }

    //! Getters
    public String getId() { return id; }
    public String getIdUsuario() { return idUsuario; }
    public String getIsbnLibro() { return isbnLibro; }
    public EstadoPrestamo getEstado() { return estado; }

    //? Método de negocio — el préstamo decide su propio estado al devolver
    public void registrarDevolucion() {
        LocalDate hoy = LocalDate.now(); //* fecha actual
        if (hoy.isAfter(fechaDevolucionEsperada)) {
            this.estado = EstadoPrestamo.RETRASADO;  //* llegó tarde - Para esto fue necesario crear la clase enum
        } else {
            this.estado = EstadoPrestamo.DEVUELTO;   //* llegó a tiempo - Para esto fue necesario crear la clase enum
        }
    }

    //? Método de negocio — el préstamo sabe si está activo o no
    public boolean estaActivo() {
        return estado == EstadoPrestamo.ACTIVO;
    }

    //? Sobreescribe el método toString para mostrar información del préstamo
    @Override
    public String toString() {
        return "ID: " + id +
                " | Usuario: " + idUsuario +
                " | ISBN: " + isbnLibro +
                " | Prestado: " + fechaPrestamo +
                " | Devolver antes de: " + fechaDevolucionEsperada +
                " | Estado: " + estado.getDescripcion();
    }
}
