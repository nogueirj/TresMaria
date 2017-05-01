package br.com.tresmaria.ws.factory;

import br.com.tresmaria.ws.entity.Preco;
import br.com.tresmaria.ws.model.ServicoDto;
import br.com.tresmaria.ws.repository.ServicoRepository;
import br.com.tresmaria.ws.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.function.Function;

/**
 * Created by julionogueira on 06/04/17.
 */
public class PrecoFactory {

    @Autowired
    private ServicoService servicoService;
    
    @Autowired
    private ServicoRepository servicoRepository;

    public Function<ServicoDto, Preco> create = new Function<ServicoDto, Preco>() {
        @Override
        public Preco apply(ServicoDto dto) {
            Preco preco = new Preco();
            preco.setId(dto.idPreco.get());
            preco.setValor(dto.valor);
            preco.setDataHoraCadastro(new Date());
            preco.setDataHoraFimVigencia(null);
            ServicoDto servico = servicoService.buscar(dto.id);
            preco.setIdServico(servicoRepository.findOne(servico.id));
            return preco;
        }
    };
}
