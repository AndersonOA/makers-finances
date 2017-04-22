/**
 * 
 */
package br.com.makersweb.finances.web.service.core;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.makersweb.finances.web.entity.DefaultEntity;
import br.com.makersweb.finances.web.message.MakersMessage;
import br.com.makersweb.finances.web.repository.IBaseRepository;
import br.com.makersweb.finances.web.service.exception.BusinessException;

/**
 *
 * @author anderson.aristides
 *
 */
public abstract class BaseService<T extends DefaultEntity> {

	private Logger logger;

	@Autowired
	private MessageSource messageSource;

	private Class<T> currentClass;

	/**
	 * @param currentClass
	 */
	public BaseService(Class<T> currentClass) {
		super();
		this.currentClass = currentClass;
		this.logger = LogManager.getLogger(this.getClass());
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public T buscar(Long id) throws BusinessException {
		getLogger().info("Iniciou Metodo buscar " + currentClass.getSimpleName() + " no serviço...");

		Optional<Long> optionalId = Optional.of(id);

		if (!optionalId.isPresent()) {
			throw new BusinessException(
					new MakersMessage(messageSource).message("br.com.helpeo.text.campos.obrigatorio"));
		}

		T result = getRepository().findOne(id);

		Optional<T> optionalResult = Optional.of(result);

		if (!optionalResult.isPresent()) {
			throw new BusinessException(new MakersMessage(messageSource).message("br.com.helpeo.text.nao.encontrado",
					currentClass.getCanonicalName()));
		}

		return result;
	}

	public void deletar(Long id) throws BusinessException {
		getLogger().info("Iniciou Metodo deletar " + currentClass.getSimpleName() + " no serviço...");

		T object = buscar(id);

		Optional<T> optionalResult = Optional.of(object);

		if (!optionalResult.isPresent()) {
			throw new BusinessException(new MakersMessage(messageSource).message("br.com.helpeo.text.nao.encontrado",
					currentClass.getSimpleName()));
		}

		getRepository().delete(id);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<T> listar() throws BusinessException {
		getLogger().info("Iniciou Metodo listar " + currentClass.getSimpleName() + " no serviço...");

		List<T> results = getRepository().findAll();

		Optional<List<T>> optionalResults = Optional.of(results);

		if (!optionalResults.isPresent()) {
			throw new BusinessException(new MakersMessage(messageSource).message("br.com.helpeo.text.nao.encontrado",
					currentClass.getSimpleName()));
		}

		return results;
	}

	public T salvar(T object) throws BusinessException {
		getLogger().info("Iniciou Metodo salvar " + currentClass.getSimpleName() + " no serviço...");

		Optional<T> optionalObject = Optional.of(object);

		if (!optionalObject.isPresent()) {
			throw new BusinessException(new MakersMessage(messageSource).message("br.com.helpeo.text.nao.encontrado",
					currentClass.getSimpleName()));
		}

		T saved = getRepository().save(object);
		return saved;
	}

	public T alterar(T object) throws BusinessException {
		getLogger().info("Iniciou Metodo alterar " + currentClass.getSimpleName() + " no serviço...");

		verificaExistencia(object);

		T updated = getRepository().save(object);

		return updated;
	}

	protected abstract IBaseRepository<T> getRepository();

	protected abstract void verificaExistencia(T entity) throws BusinessException;

	/**
	 * @return the logger
	 */
	public Logger getLogger() {
		return logger;
	}

}
