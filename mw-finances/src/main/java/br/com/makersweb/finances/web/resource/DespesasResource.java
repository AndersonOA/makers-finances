/**
 * 
 */
package br.com.makersweb.finances.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.finances.web.entity.Despesas;
import br.com.makersweb.finances.web.service.core.BaseService;
import br.com.makersweb.finances.web.service.core.DespesasService;

/**
 *
 * @author anderson.aristides
 *
 */
@RestController
@RequestMapping("${finances.api}/despesas")
public class DespesasResource extends BaseResource<Despesas> {

	@Autowired
	private DespesasService despesaService;

	public DespesasResource() {
		super(Despesas.class);
	}

	@Override
	protected BaseService<Despesas> getService() {
		return despesaService;
	}

}
