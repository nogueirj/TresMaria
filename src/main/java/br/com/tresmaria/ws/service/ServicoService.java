package br.com.tresmaria.ws.service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.tresmaria.ws.factory.ServicoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.tresmaria.ws.contract.IServicoService;
import br.com.tresmaria.ws.entity.Servico;
import br.com.tresmaria.ws.model.ServicoDto;
import br.com.tresmaria.ws.projections.ServicoProjection;
import br.com.tresmaria.ws.repository.ServicoRepository;

@Service
public class ServicoService implements IServicoService {

	@Autowired
	private JpaRepository<Servico, Long> servicoRepository;
	@Autowired
	private ServicoFactory servicoFactory;
	@Autowired
	private ServicoProjection projetor;

	@Override
	public ServicoDto salvar(ServicoDto servico) {
		Servico s = Stream.of(servico).map(servicoFactory.factory).findAny().get();
		return Stream.of(servicoRepository.saveAndFlush(s)).map(projetor.project).findAny().get();
	}

	@Override
	public Collection<ServicoDto> listar() {
		Collection<ServicoDto> servicos = servicoRepository.findAll().stream().map(projetor.project)
				.collect(Collectors.<ServicoDto>toList());
		return servicos;
	}

	@Override
	public void remover(ServicoDto servico) {
		servicoRepository.delete(servico.id);
	}

	@Override
	public ServicoDto buscar(long idservico) {
		return Stream.of(servicoRepository.findOne(idservico)).map(projetor.project).findFirst().get();
	}

	@Override
	public ServicoDto alterar(ServicoDto servicoDto) {
		Servico servico = servicoRepository.findOne(servicoDto.id);
		servico.setDescricao(servicoDto.descricao);
		servicoRepository.saveAndFlush(servico);
		return Stream.of(servico).map(projetor.project).findFirst().get();
	}
	
	@Override
	public boolean existe(ServicoDto servicoDto){
		 return servicoRepository.exists(servicoDto.id);
	}

}
