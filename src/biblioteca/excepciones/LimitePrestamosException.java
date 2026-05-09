package biblioteca.excepciones;

public class LimitePrestamosException extends BibliotecaException {

    //! Mensaje de excepcion limite de prestamos alcanzado
    public LimitePrestamosException() {
        super("El usuario ha alcanzado el límite de préstamos permitidos");
    }

}
