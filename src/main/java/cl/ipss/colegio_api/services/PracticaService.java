package cl.ipss.colegio_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ipss.colegio_api.models.Estudiante;
import cl.ipss.colegio_api.models.JefeDirecto;
import cl.ipss.colegio_api.models.Practica;
import cl.ipss.colegio_api.models.Profesor;
import cl.ipss.colegio_api.repositories.EstudianteRepository;
import cl.ipss.colegio_api.repositories.JefeDirectoRepository;
import cl.ipss.colegio_api.repositories.PracticaRepository;
import cl.ipss.colegio_api.repositories.ProfesorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class PracticaService {

  @Autowired
  private PracticaRepository practicaRepository;

  @Autowired
  private EstudianteRepository estudianteRepository;

  @Autowired
  private ProfesorRepository profesorRepository;

  @Autowired
  private JefeDirectoRepository jefeDirectoRepository;

  public Practica crear(Practica practica) {

    if (practica.getEstudiante() != null) {
      String rutEstudiante = practica.getEstudiante().getRut();
      Estudiante estudiante = estudianteRepository.findById(rutEstudiante)
          .orElseThrow(() -> new EntityNotFoundException("El Estudiante con RUT" + rutEstudiante + " no existe"));
      practica.setEstudiante(estudiante);
    }

    if (practica.getProfesor() != null) {
      String rutProfesor = practica.getProfesor().getRut();
      Profesor profesor = profesorRepository.findById(rutProfesor)
          .orElseThrow(() -> new EntityNotFoundException("El Profesor con RUT" + rutProfesor + " no existe"));
      practica.setProfesor(profesor);
    }

    if (practica.getJefeDirecto() != null) {
      String rutJefeDirecto = practica.getJefeDirecto().getRut();
      JefeDirecto jefeDirecto = jefeDirectoRepository.findById(rutJefeDirecto)
          .orElseThrow(() -> new EntityNotFoundException("El Jefe Directo con RUT " + rutJefeDirecto + " no existe"));
      practica.setJefeDirecto(jefeDirecto);
    }

    return practicaRepository.save(practica);
  }

  public List<Practica> listarTodos() {
    return practicaRepository.findAll();
  }

  public Practica buscarPorId(Long id) {
    return practicaRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("La práctica con ID " + id + " no existe"));
  }

  public void eliminar(Long id) {
    practicaRepository.deleteById(id);
  }

}
