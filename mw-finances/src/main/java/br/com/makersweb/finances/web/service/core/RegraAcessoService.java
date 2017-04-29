/**
 * 
 */
package br.com.makersweb.finances.web.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.makersweb.finances.web.entity.RegraAcesso;
import br.com.makersweb.finances.web.repository.IBaseRepository;
import br.com.makersweb.finances.web.repository.IRegraAcessoRepository;
import br.com.makersweb.finances.web.service.exception.BusinessException;

/**
 *
 * @author anderson.aristides
 *
 */
@Service
@Transactional
public class RegraAcessoService extends BaseService<RegraAcesso> {

	@Autowired
	private IRegraAcessoRepository regraRepository;

	public RegraAcessoService() {
		super(RegraAcesso.class);
	}

	@Override
	protected IBaseRepository<RegraAcesso> getRepository() {
		return regraRepository;
	}

	@Override
	protected void verificaExistencia(RegraAcesso entity) throws BusinessException {
		buscar(entity.getId());
	}

}
