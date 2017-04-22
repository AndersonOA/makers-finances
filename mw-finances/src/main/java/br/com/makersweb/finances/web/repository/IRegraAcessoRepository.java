/**
 * 
 */
package br.com.makersweb.finances.web.repository;

import java.util.List;

import br.com.makersweb.finances.web.entity.RegraAcesso;

/**
 *
 * @author anderson.aristides
 *
 */
public interface IRegraAcessoRepository extends IBaseRepository<RegraAcesso> {

	List<RegraAcesso> findByNomeStartingWith(String nome);
	
}
