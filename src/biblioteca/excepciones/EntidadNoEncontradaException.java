package biblioteca.excepciones;

public class EntidadNoEncontradaException extends BibliotecaException{

    //! Mensaje excepcion entidad no encontrada
    public EntidadNoEncontradaException() {
        super("Usuario no encontrado");
    }

}
