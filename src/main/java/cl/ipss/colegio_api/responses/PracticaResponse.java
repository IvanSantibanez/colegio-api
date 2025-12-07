package cl.ipss.colegio_api.responses;

import cl.ipss.colegio_api.models.Practica;
import lombok.Data;

@Data
public class PracticaResponse {

  private int status;
  private String message;
  private Practica data;

}
