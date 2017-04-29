/**
 * 
 */
package br.com.makersweb.finances.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.finances.web.entity.Categoria;
import br.com.makersweb.finances.web.service.core.BaseService;
import br.com.makersweb.finances.web.service.core.CategoriaService;

/**
 *
 * @author anderson.aristides
 *
 */
@RestController
@RequestMapping("${finances.api}/categorias")
public class CategoriaResource extends BaseResource<Categoria> {

	@Autowired
	private CategoriaService categoriaService;

	public CategoriaResource() {
		super(Categoria.class);
	}

	@Override
	protected BaseService<Categoria> getService() {
		return categoriaService;
	}

}
