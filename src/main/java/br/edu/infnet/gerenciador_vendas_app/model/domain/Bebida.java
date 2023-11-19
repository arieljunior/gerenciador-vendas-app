package br.edu.infnet.gerenciador_vendas_app.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Bebida")
public class Bebida extends Produto {

	private String marca;
	private String tipo;

	@Override
	public String toString() {
		return String.format("%s - marca (%s) - tipo (%s)", 
				super.toString(), marca, tipo);
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}