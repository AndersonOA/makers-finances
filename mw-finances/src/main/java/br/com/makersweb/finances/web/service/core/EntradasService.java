/**
 * 
 */
package br.com.makersweb.finances.web.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.makersweb.finances.web.entity.Entradas;
import br.com.makersweb.finances.web.repository.IBaseRepository;
import br.com.makersweb.finances.web.repository.IEntradasRepository;
import br.com.makersweb.finances.web.service.exception.BusinessException;

/**
 *
 * @author anderson.aristides
 *
 */
@Service
@Transactional
public class EntradasService extends BaseService<Entradas> {

	@Autowired
	private IEntradasRepository entradaRepository;

	public EntradasService() {
		super(Entradas.class);
	}

	@Override
	protected IBaseRepository<Entradas> getRepository() {
		return entradaRepository;
	}

	@Override
	protected void verificaExistencia(Entradas entity) throws BusinessException {
		buscar(entity.getId());
	}

}
