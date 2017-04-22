/**
 * 
 */
package br.com.makersweb.finances.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author anderson.aristides
 *
 */
@Entity
@Table(name = "tb_orcamentos")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Orcamento extends DefaultEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4113966719558115357L;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "data_orcamento", nullable = false)
	private LocalDate dataOrcamento;

	@Column(nullable = false)
	private String descricao;

	@Column(name = "orcamento_inicial", precision = 10, scale = 2)
	private BigDecimal orcamentoInicial;

	@Column(name = "orcamento_final", precision = 10, scale = 2)
	private BigDecimal orcamentoFinal;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuarios;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orcamentos")
	private Set<Despesas> despesas;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orcamentos")
	private Set<Entradas> entradas;

	/**
	 * @return the dataOrcamento
	 */
	public LocalDate getDataOrcamento() {
		return dataOrcamento;
	}

	/**
	 * @param dataOrcamento
	 *            the dataOrcamento to set
	 */
	public void setDataOrcamento(LocalDate dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the orcamentoInicial
	 */
	public BigDecimal getOrcamentoInicial() {
		return orcamentoInicial;
	}

	/**
	 * @param orcamentoInicial
	 *            the orcamentoInicial to set
	 */
	public void setOrcamentoInicial(BigDecimal orcamentoInicial) {
		this.orcamentoInicial = orcamentoInicial;
	}

	/**
	 * @return the orcamentoFinal
	 */
	public BigDecimal getOrcamentoFinal() {
		return orcamentoFinal;
	}

	/**
	 * @param orcamentoFinal
	 *            the orcamentoFinal to set
	 */
	public void setOrcamentoFinal(BigDecimal orcamentoFinal) {
		this.orcamentoFinal = orcamentoFinal;
	}

	/**
	 * @return the usuarios
	 */
	public Usuario getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios
	 *            the usuarios to set
	 */
	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the despesas
	 */
	public Set<Despesas> getDespesas() {
		return despesas;
	}

	/**
	 * @param despesas
	 *            the despesas to set
	 */
	public void setDespesas(Set<Despesas> despesas) {
		this.despesas = despesas;
	}

	/**
	 * @return the entradas
	 */
	public Set<Entradas> getEntradas() {
		return entradas;
	}

	/**
	 * @param entradas
	 *            the entradas to set
	 */
	public void setEntradas(Set<Entradas> entradas) {
		this.entradas = entradas;
	}

}
