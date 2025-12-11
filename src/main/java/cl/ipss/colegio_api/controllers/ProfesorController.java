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

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Prácticas Profesor", description = "Operaciones CRUD de prácticas para profesores")
@RestController
@RequestMapping("api/v1/profesor/practicas")
@Validated
public class ProfesorController {

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
  public ResponseEntity<Object> getPractica(
      @PathVariable @Min(value = 1, message = "El ID debe ser mayor a 0") Long id) {

    PracticaResponse response = new PracticaResponse();

    response.setStatus(200);
    response.setMessage("Práctica obtenida exitosamente");
    response.setData(practicaService.buscarPorId(id));

    return ResponseEntity.ok().body(response);
  }

  @PutMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Object> putPracticas(@PathVariable Long id, @RequestBody Practica practica) {

    Practica practicaExistente = practicaService.buscarPorId(id);

    // Validar si la práctica existe y está activa
    if (practicaExistente == null || !practicaExistente.isActive()) {
        PracticaResponse response = new PracticaResponse();
        response.setStatus(400);
        response.setMessage("La práctica no existe");
        response.setData(null);
        return ResponseEntity.badRequest().body(response);
    }

    // Actualizar los campos necesarios
    practica.setId(id);
    practica.setActive(true);
    practica.setCreated_at(practicaExistente.getCreated_at());
    practica.setUpdated_at(new Date());

    PracticaResponse response = new PracticaResponse();
    response.setStatus(200);
    response.setMessage("Práctica actualizada exitosamente");
    response.setData(practicaService.crear(practica));

    return ResponseEntity.ok().body(response);
  }

  @DeleteMapping(value = "/{id}", produces = "application/json")
  public ResponseEntity<Object> deletePracticas(@PathVariable Long id) {

    practicaService.eliminar(id);

    PracticaResponse response = new PracticaResponse();
    response.setStatus(202);
    response.setMessage("Práctica eliminada exitosamente");
    response.setData(null);

    return ResponseEntity.accepted().body(response);
  }

}
