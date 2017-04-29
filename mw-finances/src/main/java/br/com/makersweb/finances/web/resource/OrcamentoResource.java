/**
 * 
 */
package br.com.makersweb.finances.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.finances.web.entity.Orcamento;
import br.com.makersweb.finances.web.service.core.BaseService;
import br.com.makersweb.finances.web.service.core.OrcamentoService;

/**
 *
 * @author anderson.aristides
 *
 */
@RestController
@RequestMapping("${finances.api}/orcamentos")
public class OrcamentoResource extends BaseResource<Orcamento> {

	@Autowired
	private OrcamentoService orcamentoService;

	public OrcamentoResource() {
		super(Orcamento.class);
	}

	@Override
	protected BaseService<Orcamento> getService() {
		return orcamentoService;
	}

}
