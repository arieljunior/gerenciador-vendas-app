package br.edu.infnet.model.domain;

public class Vestimenta extends Produto {
	private String tamanho;
	private String marca;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s", super.toString(), tamanho, marca);
	}
	
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

}
