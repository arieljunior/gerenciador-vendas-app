package br.edu.infnet.gerenciador_vendas_app.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Vestimenta")
public class Vestimenta extends Produto {

	private String tamanho;
	@Size(min = 2, max = 100, message = "A cor deve ter entre {min} e {max} caracteres.")
	private String cor;

	@Override
	public String toString() {
		return String.format("%s - tamanho (%s) - cor (%s)", 
				super.toString(), tamanho, cor);
	}
	
	public String  getTamanho() {
		return tamanho;
	}
	public void setTamanho(String  tamanho) {
		this.tamanho = tamanho;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String caracteristica) {
		this.cor = caracteristica;
	}
}