package model.entities;

public class Carro {
	private String modelo;
	private Double valor;
	private Integer ano;
	private Double ipva;

	
	void calcIpva() {
		if (ano < 2010) {
			ipva = valor * 2 / 100;
		} else if (ano < 2019) {
			ipva = valor * 4 / 100;
		} else {
			ipva = valor * 7 / 100;
		}
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Double getIpva() {
		return ipva;
	}

	public void setIpva(Double ipva) {
		this.ipva = ipva;
	}

	

}
