package br.com.tresmaria.ws.factory;

import java.util.Arrays;
import java.util.function.Function;

import br.com.tresmaria.ws.entity.Servico;
import br.com.tresmaria.ws.model.ServicoDto;
import br.com.tresmaria.ws.service.PrecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ServicoFactory {

	@Autowired
	private PrecoService precoService;

	public Function<ServicoDto, Servico> factory = new Function<ServicoDto, Servico>() {
		@Override
		public Servico apply(ServicoDto t) {
			Servico s = new Servico(null, t.descricao);
			if(t.idPreco != null){
				PrecoDto preco = precoService.buscar(t.idPreco.get());
				s.setPrecoCollection(Arrays.asList(preco));
			}
			return s;
		}
	};
}