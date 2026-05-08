package biblioteca.excepciones;

public class EntidadNoEncontradaException extends BibliotecaException{

    public EntidadNoEncontradaException() {
        super("La entidad solicitada no fue encontrada");
    }

}
