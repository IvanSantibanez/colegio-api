package cl.ipss.colegio_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ipss.colegio_api.models.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {

}
