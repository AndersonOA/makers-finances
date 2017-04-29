/**
 * 
 */
package br.com.makersweb.finances.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.finances.web.entity.Entradas;
import br.com.makersweb.finances.web.service.core.BaseService;
import br.com.makersweb.finances.web.service.core.EntradasService;

/**
 *
 * @author anderson.aristides
 *
 */
@RestController
@RequestMapping("${finances.api}/entradas")
public class EntradasResource extends BaseResource<Entradas> {

	@Autowired
	private EntradasService entradaService;

	public EntradasResource() {
		super(Entradas.class);
	}

	@Override
	protected BaseService<Entradas> getService() {
		return entradaService;
	}

}
