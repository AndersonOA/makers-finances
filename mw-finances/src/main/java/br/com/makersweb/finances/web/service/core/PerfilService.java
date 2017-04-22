/**
 * 
 */
package br.com.makersweb.finances.web.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.makersweb.finances.web.entity.Perfil;
import br.com.makersweb.finances.web.repository.IBaseRepository;
import br.com.makersweb.finances.web.repository.IPerfilRepository;
import br.com.makersweb.finances.web.service.exception.BusinessException;

/**
 *
 * @author anderson.aristides
 *
 */
@Service
@Transactional
public class PerfilService extends BaseService<Perfil> {

	@Autowired
	private IPerfilRepository perfilRepository;

	public PerfilService() {
		super(Perfil.class);
	}

	@Override
	protected IBaseRepository<Perfil> getRepository() {
		return perfilRepository;
	}

	@Override
	protected void verificaExistencia(Perfil entity) throws BusinessException {
		buscar(entity.getId());
	}

}
