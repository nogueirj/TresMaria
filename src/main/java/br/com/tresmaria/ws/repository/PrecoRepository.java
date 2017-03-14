package br.com.tresmaria.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tresmaria.entity.Preco;

@Repository
public interface PrecoRepository extends JpaRepository<Preco, Long> {

}
