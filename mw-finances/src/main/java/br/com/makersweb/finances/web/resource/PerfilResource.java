/**
 * 
 */
package br.com.makersweb.finances.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.finances.web.entity.Perfil;
import br.com.makersweb.finances.web.service.core.BaseService;
import br.com.makersweb.finances.web.service.core.PerfilService;

/**
 *
 * @author anderson.aristides
 *
 */
@RestController
@RequestMapping("${finances.api}/perfils")
public class PerfilResource extends BaseResource<Perfil> {

	@Autowired
	private PerfilService perfilService;

	public PerfilResource() {
		super(Perfil.class);
	}

	@Override
	protected BaseService<Perfil> getService() {
		return perfilService;
	}

}
