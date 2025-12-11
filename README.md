# API REST para gestión de prácticas profesionales

API desarrollada en Java Spring Boot para la gestión de prácticas profesionales en un entorno educativo. Permite a profesores y estudiantes crear, consultar, actualizar y eliminar registros de prácticas profesionales, así como gestionar la información relacionada con estudiantes, profesores, empresas y jefes directos.

## Características principales

- Gestión de prácticas profesionales (CRUD)
- Roles diferenciados para profesor y estudiante
- Validaciones de datos y relaciones entre entidades
- Respuestas estructuradas en formato JSON

## Requisitos previos

- Java 17 o superior
- PostgreSQL
- Maven

## Instalación y ejecución

1. Clona este repositorio.
2. Configura la conexión a tu base de datos en `src/main/resources/application.properties`.
3. Ejecuta los scripts de poblado para crear los datos base.
4. Compila y ejecuta la aplicación con Maven:

```bash
mvn spring-boot:run
```

La API estará disponible en `http://localhost:8080/` por defecto.

## Documentación interactiva (Swagger UI)

Puedes explorar y probar los endpoints de la API desde la documentación generada automáticamente por Swagger/OpenAPI en:

`http://localhost:8080/swagger-ui/index.html`


## Poblado para base de datos

```sql

INSERT INTO carrera (nombre) VALUES
('Técnico en Programación'),
('Mecánica Automotriz'),
('Administración de Empresas'),
('Electricidad Industrial');

INSERT INTO empresa (rut, nombre, direccion, telefono, correo) VALUES
('76111222-3', 'Tech Solutions Ltda', 'Av. Providencia 1234, Santiago', '56223334444', 'contacto@techsolutions.cl'),
('77222333-K', 'Automotora del Sur', 'Gran Avenida 5678, San Miguel', '56225556666', 'taller@autosur.cl'),
('78333444-5', 'Constructora Andes', 'Alameda 987, Santiago', '56227778888', 'rrhh@andes.cl');

INSERT INTO profesor (rut, nombres, apellido_paterno, apellido_materno, correo, telefono) VALUES
('11111111-1', 'Juan', 'Pérez', 'Soto', 'juan.perez@colegio.cl', '56911111111'),
('12222222-2', 'María', 'González', 'López', 'maria.gonzalez@colegio.cl', '56922222222'),
('13333333-3', 'Carlos', 'Muñoz', 'Rojas', 'carlos.munoz@colegio.cl', '56933333333');

INSERT INTO jefe_directo (rut, nombres, apellido_paterno, apellido_materno, cargo, correo_supervisor, telefono_supervisor, empresa_rut) VALUES
('14444444-4', 'Roberto', 'Díaz', 'Vega', 'Gerente TI', 'rdiaz@techsolutions.cl', '56944444444', '76111222-3'),
('15555555-5', 'Ana', 'Torres', 'Silva', 'Jefe de Taller', 'atorres@autosur.cl', '56955555555', '77222333-K'),
('16666666-6', 'Luis', 'Castro', 'Mora', 'Supervisor de Obra', 'lcastro@andes.cl', '56966666666', '78333444-5');

INSERT INTO estudiante (rut, nombres, apellido_paterno, apellido_materno, correo, telefono, carrera_id) VALUES
('17777777-7', 'Pedro', 'Tapia', 'Vidal', 'pedro.tapia@alumno.cl', '56977777777', 1),
('18888888-8', 'Laura', 'Salas', 'Reyes', 'laura.salas@alumno.cl', '56988888888', 2),
('19999999-9', 'Diego', 'Fuentes', 'Cid', 'diego.fuentes@alumno.cl', '56999999999', 1),
('20000000-K', 'Sofia', 'Vargas', 'Pinto', 'sofia.vargas@alumno.cl', '56900000000', 3);

```

## Métodos de la API

| Método | Ruta                                | Descripción                                  |
| ------ | ----------------------------------- | -------------------------------------------- |
| POST   | /api/v1/profesor/practicas/crear    | Crear una nueva práctica (profesor)          |
| GET    | /api/v1/profesor/practicas/listar   | Obtener todas las prácticas (profesor)       |
| GET    | /api/v1/profesor/practicas/{id}     | Obtener una práctica por ID (profesor)       |
| PUT    | /api/v1/profesor/practicas/{id}     | Actualizar una práctica existente (profesor) |
| DELETE | /api/v1/profesor/practicas/{id}     | Eliminar una práctica por ID (profesor)      |
| POST   | /api/v1/estudiante/practicas/crear  | Crear una nueva práctica (estudiante)        |
| GET    | /api/v1/estudiante/practicas/listar | Obtener todas las prácticas (estudiante)     |
| GET    | /api/v1/estudiante/practicas/{id}   | Obtener una práctica por ID (estudiante)     |

## Ejemplos de body para crear una práctica

```json
{
  "fechaInicio": "2025-02-01",
  "fechaTermino": "2025-05-28",
  "tareasDescripcion": "Práctica profesional en desarrollo de software.",
  "estudiante": {
    "rut": "17777777-7"
  },
  "jefeDirecto": {
    "rut": "14444444-4"
  },
  "profesor": {
    "rut": "11111111-1"
  }
}

{
  "fechaInicio": "2025-03-10",
  "fechaTermino": "2025-06-15",
  "tareasDescripcion": "Práctica en área de administración de empresas.",
  "estudiante": {
    "rut": "18888888-8"
  },
  "jefeDirecto": {
    "rut": "15555555-5"
  },
  "profesor": {
    "rut": "12222222-2"
  }
}

{
  "fechaInicio": "2025-04-05",
  "fechaTermino": "2025-07-20",
  "tareasDescripcion": "Práctica en taller de mecánica automotriz.",
  "estudiante": {
    "rut": "19999999-9"
  },
  "jefeDirecto": {
    "rut": "16666666-6"
  },
  "profesor": {
    "rut": "13333333-3"
  }
}
```
