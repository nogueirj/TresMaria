package br.com.tresmaria.ws.service;

import br.com.tresmaria.ws.contract.ICidadeService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.ws.entity.Cidade;
import br.com.tresmaria.ws.model.CidadeDto;
import br.com.tresmaria.ws.repository.CidadeRepository;

@Service
public class CidadeService implements ICidadeService{

	@Autowired
	private CidadeRepository cidadeRepository;
        
        @Autowired
        private Cidade
	
	public void salvar(CidadeDto cidade){
            Cidade c = 
		return cidadeRepository.saveAndFlush(cidade);
	}
	
	public List<Cidade> listar(){
		return cidadeRepository.findAll();
	}
	
	public void remover(Cidade cidade){
		cidadeRepository.delete(cidade);
	}
	
	public Cidade buscar(Cidade cidade){
		return cidadeRepository.findOne(cidade.getId());
	}
}
