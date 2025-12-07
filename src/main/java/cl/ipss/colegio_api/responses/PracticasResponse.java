package cl.ipss.colegio_api.responses;

import java.util.List;

import cl.ipss.colegio_api.models.Practica;
import lombok.Data;

@Data
public class PracticasResponse {

  private int status;
  private String message;
  private List<Practica> data;

}
