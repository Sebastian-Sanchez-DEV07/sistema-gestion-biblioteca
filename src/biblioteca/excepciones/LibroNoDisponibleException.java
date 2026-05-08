package biblioteca.excepciones;

public class LibroNoDisponibleException extends BibliotecaException{

        public LibroNoDisponibleException() {
            super("El libro no tiene ejemplares disponibles");
        }

}

