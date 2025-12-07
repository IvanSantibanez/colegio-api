package cl.ipss.colegio_api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

  @Id
  @NotBlank(message = "El RUT del profesor no puede estar vacío")
  private String rut;

  @NotBlank(message = "Los nombres del profesor no pueden estar vacíos")
  private String nombres;

  @NotBlank(message = "El apellido paterno del profesor no puede estar vacío")
  private String apellidoPaterno;

  private String apellidoMaterno;

  @NotBlank(message = "El correo del profesor no puede estar vacío")
  @Column(unique = true)
  private String correo;

  @NotBlank(message = "El teléfono del profesor no puede estar vacío")
  private String telefono;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor", cascade = { CascadeType.ALL })
  @JsonIgnore
  private List<Practica> practicas;

}
