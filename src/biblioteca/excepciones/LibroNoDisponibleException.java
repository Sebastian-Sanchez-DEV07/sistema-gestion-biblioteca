package biblioteca.excepciones;

public class LibroNoDisponibleException extends BibliotecaException{

    //!  Mensaje de excepciones libro no disponible
        public LibroNoDisponibleException() {
            super("El libro no tiene ejemplares disponibles");
        }

}

