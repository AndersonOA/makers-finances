/**
 * 
 */
package br.com.makersweb.finances.web.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.makersweb.finances.web.entity.Categoria;
import br.com.makersweb.finances.web.repository.IBaseRepository;
import br.com.makersweb.finances.web.repository.ICategoriaRepository;
import br.com.makersweb.finances.web.service.exception.BusinessException;

/**
 *
 * @author anderson.aristides
 *
 */
@Service
@Transactional
public class CategoriaService extends BaseService<Categoria> {

	@Autowired
	private ICategoriaRepository categoriaRepository;

	public CategoriaService() {
		super(Categoria.class);
	}

	@Override
	protected IBaseRepository<Categoria> getRepository() {
		return categoriaRepository;
	}

	@Override
	protected void verificaExistencia(Categoria entity) throws BusinessException {
		buscar(entity.getId());
	}

}
