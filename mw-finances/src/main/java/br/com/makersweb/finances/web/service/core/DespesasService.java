/**
 * 
 */
package br.com.makersweb.finances.web.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.makersweb.finances.web.entity.Despesas;
import br.com.makersweb.finances.web.repository.IBaseRepository;
import br.com.makersweb.finances.web.repository.IDespesasRepository;
import br.com.makersweb.finances.web.service.exception.BusinessException;

/**
 *
 * @author anderson.aristides
 *
 */
@Service
@Transactional
public class DespesasService extends BaseService<Despesas> {

	@Autowired
	private IDespesasRepository despesasRepository;

	public DespesasService() {
		super(Despesas.class);
	}

	@Override
	protected IBaseRepository<Despesas> getRepository() {
		return despesasRepository;
	}

	@Override
	protected void verificaExistencia(Despesas entity) throws BusinessException {
		buscar(entity.getId());
	}

}
