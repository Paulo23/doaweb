package br.unifor.pin.doaweb.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author equipe.doaweb
 *
 */
@Entity 
@DiscriminatorValue("1")
public class Instituicoes extends Usuarios {
	
	@Column(name="cnpj_instituicao", nullable = false, length = 14, unique = true)
	private String cnpj;
	
	@Column(name="razao_social", nullable = false)
	private String razaoSocial;
	
	@OneToMany(mappedBy = "instituicao", fetch=FetchType.EAGER)
	private List<Campanhas> campanhas;
	
	/*
	 * Dados Bancarios
	 */
	
	@Column(name = "nomeBanco_dadosBancarios", nullable = false)
	private String nomeBanco;

	@Column(name = "operacao_dadosBancarios", nullable = true, length = 10)
	private String operacao;

	@Column(name = "agencia_dadosBancarios", nullable = false, length = 50)
	private String agencia;

	@Column(name = "conta_dadosBancarios", nullable = false, length = 50)
	private String conta;

	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public List<Campanhas> getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(List<Campanhas> campanhas) {
		this.campanhas = campanhas;
	}

	/*
	 * GETS/SETS DADOS BANCARIOS
	 */
	
	
	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	
	
}
