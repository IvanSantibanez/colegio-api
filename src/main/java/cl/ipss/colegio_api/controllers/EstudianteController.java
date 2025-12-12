package cl.ipss.colegio_api.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import cl.ipss.colegio_api.models.Practica;
import cl.ipss.colegio_api.responses.PracticaResponse;
import cl.ipss.colegio_api.responses.PracticasResponse;
import cl.ipss.colegio_api.services.PracticaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Prácticas Estudiante", description = "Operaciones CRUD de prácticas para estudiantes")
@RestController
@RequestMapping("api/v1/estudiante/practicas")
@Validated
public class EstudianteController {

  @Autowired
  private PracticaService practicaService;

  @PostMapping(value = "crear", produces = "application/json")
  public ResponseEntity<Object> postPractica(@Valid @RequestBody Practica practica) {
    PracticaResponse response = new PracticaResponse();
    practica.setActive(true);
    practica.setCreated_at(new Date());

    response.setStatus(200);
    response.setMessage("Práctica creada exitosamente");
    response.setData(practicaService.crear(practica));

    return ResponseEntity.ok().body(response);
  }

  @GetMapping(value = "listar", produces = "application/json")
  public ResponseEntity<Object> getPracticas() {
    PracticasResponse response = new PracticasResponse();
    response.setStatus(200);
    response.setMessage("Listado de prácticas obtenido exitosamente");
    response.setData(practicaService.listarTodos());
    return ResponseEntity.ok().body(response);
  }

  @GetMapping(value = "{id}", produces = "application/json")
  public ResponseEntity<Object> getPracticaPorId(
      @PathVariable @Min(value = 1, message = "El ID debe ser mayor a 0") Long id) {
    PracticaResponse response = new PracticaResponse();
    response.setStatus(200);
    response.setMessage("Práctica obtenida exitosamente");
    response.setData(practicaService.buscarPorId(id));
    return ResponseEntity.ok().body(response);
  }
}