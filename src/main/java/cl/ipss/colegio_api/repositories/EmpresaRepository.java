package cl.ipss.colegio_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ipss.colegio_api.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {

}
