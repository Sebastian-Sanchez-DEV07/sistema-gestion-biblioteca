package biblioteca.excepciones;

public class LimitePrestamosException extends BibliotecaException {

    public LimitePrestamosException() {
        super("El usuario ha alcanzado el límite de préstamos permitidos");
    }

}
