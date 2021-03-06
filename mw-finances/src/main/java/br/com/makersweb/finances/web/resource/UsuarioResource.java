/**
 * 
 */
package br.com.makersweb.finances.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.finances.web.entity.Usuario;
import br.com.makersweb.finances.web.service.core.BaseService;
import br.com.makersweb.finances.web.service.core.UsuarioService;

/**
 *
 * @author anderson.aristides
 *
 */
@RestController
@RequestMapping("${finances.api}/usuarios")
public class UsuarioResource extends BaseResource<Usuario> {

	@Autowired
	private UsuarioService usuarioService;

	public UsuarioResource() {
		super(Usuario.class);
	}

	@Override
	protected BaseService<Usuario> getService() {
		return usuarioService;
	}

}
