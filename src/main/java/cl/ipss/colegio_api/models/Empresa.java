package cl.ipss.colegio_api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
public class Empresa {

  @Id
  private String rut;
  @NotBlank(message = "El nombre de la empresa no puede estar vacío")
  private String nombre;
  @NotBlank(message = "La dirección de la empresa no puede estar vacío")
  private String direccion;
  @NotBlank(message = "El teléfono de la empresa no puede estar vacío")
  private String telefono;
  @NotBlank(message = "El correo de la empresa no puede estar vacío")
  private String correo;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa", cascade = { CascadeType.ALL })
  @JsonIgnore
  private List<JefeDirecto> jefesDirectos;

}
