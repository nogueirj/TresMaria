package br.com.tresmaria.ws.factory;

import br.com.tresmaria.ws.entity.Preco;
import java.util.function.Function;

import br.com.tresmaria.ws.entity.Servico;
import br.com.tresmaria.ws.model.ServicoDto;
import br.com.tresmaria.ws.service.PrecoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ServicoFactory {

	@Autowired
	private PrecoService precoService;

	public Function<ServicoDto, Servico> factory = new Function<ServicoDto, Servico>() {
		@Override
		public Servico apply(ServicoDto dto) {
			Servico s = new Servico(null, dto.descricao);
			if(dto.idPreco != null){
                                List<Preco> preco = precoService.buscarRange(dto.IdsPrecos);
				s.setPrecoCollection(preco);
			}
			return s;
		}
	};
}