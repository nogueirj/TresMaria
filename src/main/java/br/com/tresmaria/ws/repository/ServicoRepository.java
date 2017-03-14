package br.com.tresmaria.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tresmaria.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
