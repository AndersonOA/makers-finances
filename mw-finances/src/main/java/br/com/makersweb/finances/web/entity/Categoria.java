/**
 * 
 */
package br.com.makersweb.finances.web.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.makersweb.finances.web.enums.TipoCategoriaEnum;

/**
*
* @author anderson.aristides
*
*/
@Entity
@Table(name = "tb_categorias")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Categoria extends DefaultEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6663103440621155244L;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoCategoriaEnum tipo;
	
	@Column(nullable = false, length = 200)
	private String categoria;
	
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorias")
	private Set<Despesas> despesas;
	
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorias")
	private Set<Entradas> entradas;

}
