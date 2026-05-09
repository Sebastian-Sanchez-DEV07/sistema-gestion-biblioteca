package biblioteca.excepciones;

public class BibliotecaException extends Exception {

    //! Mensaje de excepcion personalizada
    public BibliotecaException(String mensaje) {
        super(mensaje);
    }

}
