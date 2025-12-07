package cl.ipss.colegio_api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

  @Id
  @NotBlank(message = "El RUT del estudiante no puede estar vacío")
  private String rut;

  @NotBlank(message = "Los nombres del estudiante no pueden estar vacíos")
  private String nombres;

  @NotBlank(message = "El apellido paterno del estudiante no puede estar vacío")
  private String apellidoPaterno;

  private String apellidoMaterno;

  @NotBlank(message = "El correo del estudiante no puede estar vacío")
  @Column(unique = true)
  private String correo;

  private String telefono;

  @ManyToOne
  @JoinColumn(name = "carrera_id")
  private Carrera carrera;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante", cascade = { CascadeType.ALL })
  @JsonIgnore
  private List<Practica> practicas;

}
