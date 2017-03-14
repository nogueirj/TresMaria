package br.com.tresmaria.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tresmaria.ws.entity.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
