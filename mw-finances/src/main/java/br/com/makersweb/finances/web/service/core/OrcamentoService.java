/**
 * 
 */
package br.com.makersweb.finances.web.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.makersweb.finances.web.entity.Orcamento;
import br.com.makersweb.finances.web.repository.IBaseRepository;
import br.com.makersweb.finances.web.repository.IOrcamentoRepository;
import br.com.makersweb.finances.web.service.exception.BusinessException;

/**
 *
 * @author anderson.aristides
 *
 */
@Service
@Transactional
public class OrcamentoService extends BaseService<Orcamento> {

	@Autowired
	private IOrcamentoRepository orcamentoRepository;

	public OrcamentoService() {
		super(Orcamento.class);
	}

	@Override
	protected IBaseRepository<Orcamento> getRepository() {
		return orcamentoRepository;
	}

	@Override
	protected void verificaExistencia(Orcamento entity) throws BusinessException {
		buscar(entity.getId());
	}

}
