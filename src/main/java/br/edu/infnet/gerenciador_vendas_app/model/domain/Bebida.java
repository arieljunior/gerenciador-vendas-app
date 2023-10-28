package br.edu.infnet.gerenciador_vendas_app.model.domain;

public class Bebida extends Produto {
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
