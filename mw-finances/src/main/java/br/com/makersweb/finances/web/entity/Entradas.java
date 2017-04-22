/**
 * 
 */
package br.com.makersweb.finances.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "tb_entradas")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Entradas extends DefaultEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2370082251417087327L;

	@Column(name = "data_entrada", nullable = false)
	private LocalDate dataEntrada;

	@Column(name = "valor_planejado", precision = 10, scale = 2)
	private BigDecimal valorPlanejado;

	@Column(name = "valor_atual", precision = 10, scale = 2, nullable = false)
	private BigDecimal valorAtual;

	@Column(name = "valor_diferenca", precision = 10, scale = 2)
	private BigDecimal valorDiferenca;

	@Column(nullable = false, length = 255)
	private String descricao;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id")
	private Categoria categorias;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orcamento_id")
	private Orcamento orcamentos;

	/**
	 * @return the dataEntrada
	 */
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	/**
	 * @param dataEntrada
	 *            the dataEntrada to set
	 */
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	/**
	 * @return the valorPlanejado
	 */
	public BigDecimal getValorPlanejado() {
		return valorPlanejado;
	}

	/**
	 * @param valorPlanejado
	 *            the valorPlanejado to set
	 */
	public void setValorPlanejado(BigDecimal valorPlanejado) {
		this.valorPlanejado = valorPlanejado;
	}

	/**
	 * @return the valorAtual
	 */
	public BigDecimal getValorAtual() {
		return valorAtual;
	}

	/**
	 * @param valorAtual
	 *            the valorAtual to set
	 */
	public void setValorAtual(BigDecimal valorAtual) {
		this.valorAtual = valorAtual;
	}

	/**
	 * @return the valorDiferenca
	 */
	public BigDecimal getValorDiferenca() {
		return valorDiferenca;
	}

	/**
	 * @param valorDiferenca
	 *            the valorDiferenca to set
	 */
	public void setValorDiferenca(BigDecimal valorDiferenca) {
		this.valorDiferenca = valorDiferenca;
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
	 * @return the categorias
	 */
	public Categoria getCategorias() {
		return categorias;
	}

	/**
	 * @param categorias
	 *            the categorias to set
	 */
	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}

	/**
	 * @return the orcamentos
	 */
	public Orcamento getOrcamentos() {
		return orcamentos;
	}

	/**
	 * @param orcamentos
	 *            the orcamentos to set
	 */
	public void setOrcamentos(Orcamento orcamentos) {
		this.orcamentos = orcamentos;
	}

}
