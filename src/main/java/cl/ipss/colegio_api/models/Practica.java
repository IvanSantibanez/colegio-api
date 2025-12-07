package cl.ipss.colegio_api.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Practica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "La fecha de inicio no puede ser nula")
  private LocalDate fechaInicio;

  @NotNull(message = "La fecha de término no puede ser nula")
  private LocalDate fechaTermino;

  @NotBlank(message = "La descripción de las tareas no puede estar vacía")
  private String tareasDescripcion;

  @ManyToOne
  @JoinColumn(name = "estudiante_rut")
  @NotNull(message = "El estudiante no puede ser nulo")
  private Estudiante estudiante;

  @ManyToOne
  @JoinColumn(name = "profesor_rut")
  @NotNull(message = "El profesor no puede ser nulo")
  private Profesor profesor;

  @ManyToOne
  @JoinColumn(name = "jefe_directo_rut")
  @NotNull(message = "El jefe directo no puede ser nulo")
  private JefeDirecto jefeDirecto;

}
