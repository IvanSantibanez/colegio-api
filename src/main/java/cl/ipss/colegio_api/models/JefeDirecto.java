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
public class JefeDirecto {

  @Id
  @NotBlank(message = "El RUT del jefe directo no puede estar vacío")
  private String rut;

  @NotBlank(message = "Los nombres del jefe directo no pueden estar vacíos")
  private String nombres;

  @NotBlank(message = "El apellido paterno del jefe directo no puede estar vacío")
  private String apellidoPaterno;

  private String apellidoMaterno;

  @NotBlank(message = "El cargo del jefe directo no puede estar vacío")
  private String cargo;

  @NotBlank(message = "El correo del jefe directo no puede estar vacío")
  @Column(unique = true)
  private String correoSupervisor;

  @NotBlank(message = "El teléfono del jefe directo no puede estar vacío")
  private String telefonoSupervisor;

  @ManyToOne
  @JoinColumn(name = "empresa_rut")
  private Empresa empresa;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "jefeDirecto", cascade = { CascadeType.ALL })
  @JsonIgnore
  private List<Practica> practicas;

}
