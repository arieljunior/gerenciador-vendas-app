package br.edu.infnet.model.domain;

public class Bebida extends Produto {
	private String tipoBebida;
	
	@Override
	public String toString() {
		return String.format("%s - %s", super.toString(), tipoBebida);
	}
	
	public String getTipoBebida() {
		return tipoBebida;
	}
	public void setTipoBebida(String tipoBebida) {
		this.tipoBebida = tipoBebida;
	}

}
