package biblioteca.enumeraciones;

public enum EstadoPrestamo {

        ACTIVO("Préstamo vigente"),
        DEVUELTO("Libro devuelto a tiempo"),
        RETRASADO("Fecha límite superada");

        private final String descripcion;

        EstadoPrestamo(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }

}

