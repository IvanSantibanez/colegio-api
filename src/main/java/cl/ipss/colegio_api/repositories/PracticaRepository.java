package cl.ipss.colegio_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ipss.colegio_api.models.Practica;

public interface PracticaRepository extends JpaRepository<Practica, Long> {
    List<Practica> findByActiveTrue();
}
