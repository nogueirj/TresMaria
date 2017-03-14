package br.com.tresmaria.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tresmaria.ws.entity.TelefoneContato;

@Repository
public interface TelefoneContatoRepository extends JpaRepository<TelefoneContato, Long>{

}
