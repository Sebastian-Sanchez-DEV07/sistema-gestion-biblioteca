package biblioteca.enumeraciones;

public enum EstadoPrestamo {

    //! Estados posibles de un préstamo
        ACTIVO("Préstamo vigente"),
        DEVUELTO("Libro devuelto a tiempo"),
        RETRASADO("Fecha límite superada");

        //! Devuelve la descripcion del estado
        private final String descripcion;

        EstadoPrestamo(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }

}

