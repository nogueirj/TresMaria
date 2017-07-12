package br.com.tresmaria.ws.service;

import br.com.tresmaria.ws.contract.ICidadeService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresmaria.ws.entity.Cidade;
import br.com.tresmaria.ws.factory.CidadeFactory;
import br.com.tresmaria.ws.model.CidadeDto;
import br.com.tresmaria.ws.projections.CidadeProjection;
import br.com.tresmaria.ws.repository.CidadeRepository;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CidadeService implements ICidadeService{

	@Autowired
	private CidadeRepository cidadeRepository;
	
        @Autowired
        private CidadeFactory factory;
        
        @Autowired
        private CidadeProjection projector;
        
        @Override
	public void salvar(CidadeDto cidade){
            Cidade c = Stream.of(cidade).map(factory.factory).findAny().get();
            cidadeRepository.saveAndFlush(c);
	}
	
        @Override
	public List<CidadeDto> listar(){
            return cidadeRepository.findAll().stream().map(projector.projection).collect(Collectors.<CidadeDto> toList());
	}
	
        @Override
	public void excluir(Long idCidade){
		cidadeRepository.delete(idCidade);
	}
	
	public Cidade buscar(Cidade cidade){
		return cidadeRepository.findOne(cidade.getId());
	}
        
        @Override
        public void alterar(CidadeDto dto){
            
        }
}
