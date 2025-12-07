# API REST para gestión de prácticas profesionales


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

| Método | Ruta | Descripción |
|--------|------|-------------|
| POST   | /api/v1/practicas/crear | Crear una nueva práctica |
| GET    | /api/v1/practicas/listar | Obtener todas las prácticas |
| GET    | /api/v1/practicas/{id} | Obtener una práctica por ID |
| PUT    | /api/v1/practicas/{id} | Actualizar una práctica existente |
| DELETE | /api/v1/practicas/{id} | Eliminar una práctica por ID |

## Body ejemplo para crear una práctica

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

```




