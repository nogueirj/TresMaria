package br.com.tresmaria.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tresmaria.entity.Sexo;

@Repository
public interface SexoRepository extends JpaRepository<Sexo, Long>{

}
