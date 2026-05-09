# 📚 Sistema de Gestión de Biblioteca

Proyecto final de la materia **Programación Orientada a Objetos** en Java.  
Sistema de consola para gestionar libros, usuarios y préstamos de una biblioteca.

**Alumno:** Sebastián Sánchez Hernández  
**Matrícula:** AL07222282  
**Profesor:** Juan Diego Moreno Muñoz

---

## ▶️ ¿Cómo ejecutarlo?

1. Clona o descarga el repositorio como ZIP
2. Abre la carpeta como **proyecto Java** en tu `IDE (Eclipse, IntelliJ, NetBeans)`
3. Ejecuta `Main.java`

El programa inicia con datos de prueba precargados — no necesitas agregar nada para probarlo.

---

## 🗂️ Estructura del proyecto

```
src/
└── biblioteca/
     ├── enumeraciones/
     │    └── EstadoPrestamo.java
     ├── excepciones/
     │    ├── BibliotecaException.java
     │    ├── EntidadNoEncontradaException.java
     │    ├── LibroNoDisponibleException.java
     │    └── LimitePrestamosException.java
     ├── modelo/
     │    ├── Libro.java
     │    ├── Prestamo.java
     │    └── Usuario.java
     ├── servicios/
     │    └── Biblioteca.java
     ├── vista/
     │    └── Menu.java
     └── Main.java
```

---

## 🪪 Convenciones de IDs

Para usar el sistema correctamente sigue estos formatos:

### Usuarios
| Formato | Ejemplos |
|---|---|
| `U` + 3 dígitos | `U001`, `U002`, `U003` |

### Libros — ISBN
| Formato | Ejemplos |
|---|---|
| `978-` + 3 dígitos | `978-001`, `978-002`, `978-003` |

> Los datos de prueba ya usan estos formatos. Puedes seguir la secuencia al agregar nuevos.

### Préstamos
| Formato | Generado automáticamente |
|---|---|
| `P` + 3 dígitos | `P001`, `P002`, `P003` |

> El sistema genera el ID del préstamo solo — no necesitas escribirlo al crear uno, solo al registrar una devolución.

---

## 🔄 Flujo básico para probar el sistema

```
1. Menú principal → opción 1 → ver todos los libros
   (ya hay 3 libros precargados)

2. Menú principal → opción 2 → ver todos los usuarios
   (ya hay 2 usuarios precargados)

3. Menú principal → opción 3 → realizar préstamo
   ISBN: 978-001
   ID usuario: U001
   → El sistema genera P001 automáticamente

4. Menú principal → opción 4 → reporte general
   → Ver estadísticas del sistema

5. Menú principal → opción 3 → registrar devolución
   ID préstamo: P001
   → El sistema actualiza estado y disponibilidad
```

---

## 🧱 Conceptos de POO aplicados

| Concepto | Dónde se aplica |
|---|---|
| **Encapsulamiento** | Todos los atributos son `private` con getters controlados |
| **Herencia** | Las excepciones heredan de `BibliotecaException` |
| **Polimorfismo** | `catch (BibliotecaException e)` atrapa cualquier excepción del sistema |
| **Abstracción** | `Biblioteca.java` oculta la complejidad interna al menú |
| **Enumeraciones** | `EstadoPrestamo` con atributos — ACTIVO, DEVUELTO, RETRASADO |
| **Excepciones personalizadas** | 4 excepciones del dominio con mensajes específicos |
| **Colecciones** | `HashMap` para libros, usuarios y préstamos |
| **LocalDate** | Fechas de préstamo y devolución con `java.time` |

---

## ⚙️ Reglas del sistema

- Un usuario puede tener máximo **2 préstamos activos** simultáneos
- El plazo de devolución es de **7 días**
- Si se devuelve después del plazo → estado `RETRASADO`
- Si se devuelve antes → estado `DEVUELTO`
- No se puede prestar un libro sin ejemplares disponibles

---

## 🚀 Próximas mejoras (versión futura)

- [ ] Persistencia de datos con serialización
- [ ] Búsqueda de libros por título y autor
- [ ] Clase abstracta `RecursoBibliografico` para libros y revistas
- [ ] Interfaz `IBuscable` en el catálogo
- [ ] Reportes de préstamos retrasados
- [ ] Interfaz de escritorio con `Swing`
