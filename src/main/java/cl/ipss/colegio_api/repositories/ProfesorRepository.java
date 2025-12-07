package cl.ipss.colegio_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ipss.colegio_api.models.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {

}
