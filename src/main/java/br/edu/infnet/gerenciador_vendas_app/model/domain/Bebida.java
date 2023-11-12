package br.edu.infnet.gerenciador_vendas_app.model.domain;

import javax.validation.constraints.Size;

public class Bebida extends Produto {
	@Size(min = 2, max = 100, message = "O tipo da bebida deve ter entre {min} e {max} caracteres.")
	private String tipoBebida;
	private String sabor;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s", super.toString(), tipoBebida, sabor);
	}
	
	public String getTipoBebida() {
		return tipoBebida;
	}
	public void setTipoBebida(String tipoBebida) {
		this.tipoBebida = tipoBebida;
	}
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

}
